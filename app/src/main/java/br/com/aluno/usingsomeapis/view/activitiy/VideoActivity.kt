package br.com.aluno.usingsomeapis.view.activitiy

import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.aluno.usingsomeapis.R
import br.com.aluno.usingsomeapis.presenter.AnimePresenter
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.MimeTypes
import kotlinx.android.synthetic.main.activity_video.*
import kotlinx.android.synthetic.main.custom_controller.*


class VideoActivity : AppCompatActivity() {

    var flag: Boolean = false
    lateinit var simpleExoPlayer: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        //Make activity full screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        println("VIDEO URL EPISODE SLECTED" + AnimePresenter.sharedInstance.mEpisodeSelected.value.epVideoURL)

//        val videoURL = Uri.parse(AnimePresenter.sharedInstance.mEpisodeSelected.value.epVideoURL)

        val videoURL = Uri.parse("https://www.crunchyroll.com/affiliate_iframeplayer?aff=af-12299-plwa&media_id=535236&video_format=106&video_quality=60&auto_play=0")

        val loadControl: LoadControl = DefaultLoadControl()
        val bandWithMeter: BandwidthMeter = DefaultBandwidthMeter()
//        val trackSelector: TrackSelector =
//            DefaultTrackSelector(AdaptiveTrackSelection.Factory(bandWithMeter))
        val trackSelector: TrackSelector =
            DefaultTrackSelector(AdaptiveTrackSelection.Factory())

        //Initialize simple exo player
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector, loadControl)

        val factory = DefaultHttpDataSourceFactory("exoplayer_video")

        val extractorsFactory = DefaultExtractorsFactory()

        val mediaItem: MediaItem =
            MediaItem.Builder().setUri(videoURL).setMimeType(MimeTypes.BASE_TYPE_VIDEO).build()

        val mediaSource = ExtractorMediaSource(videoURL, factory, extractorsFactory, null, null)

        playerView.player = simpleExoPlayer

        playerView.keepScreenOn = true
        simpleExoPlayer.setMediaItem(mediaItem)
        simpleExoPlayer.prepare(mediaSource)
        simpleExoPlayer.playWhenReady = true

        simpleExoPlayer.addListener(object : Player.EventListener {
//            override fun onTimelineChanged(timeline: Timeline?, manifest: Any?, reason: Int) {
//            }
//
//            override fun onTracksChanged(
//                trackGroups: TrackGroupArray?,
//                trackSelections: TrackSelectionArray?
//            ) {
//            }

            override fun onLoadingChanged(isLoading: Boolean) {
            }

            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {

                if (playbackState == Player.STATE_BUFFERING) {
                    progress_bar.visibility = View.VISIBLE
                } else if (playbackState == Player.STATE_READY) {
                    progress_bar.visibility = View.GONE
                }
            }

            override fun onRepeatModeChanged(repeatMode: Int) {
            }

            override fun onShuffleModeEnabledChanged(shuffleModeEnabled: Boolean) {
            }

//            override fun onPlayerError(error: ExoPlaybackException?) {
//            }
//
//            override fun onPositionDiscontinuity(reason: Int) {
//            }
//
//            override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters?) {
//            }

            override fun onSeekProcessed() {
            }
        })

        bt_fullscreen.setOnClickListener {

            if (flag) {
                //Set enter the full screen image

                bt_fullscreen.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_fullscreen
                    )
                )
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                flag = false

            } else {
                bt_fullscreen.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_fullscreen_exit
                    )
                )

                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

                flag = true
            }
        }
    }

    override fun onPause() {
        super.onPause()
//        simpleExoPlayer.playWhenReady = false
//        simpleExoPlayer.playbackState
    }
}