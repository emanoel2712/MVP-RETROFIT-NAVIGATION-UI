package br.com.aluno.usingsomeapis.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.aluno.usingsomeapis.R
import br.com.aluno.usingsomeapis.model.Episode
import br.com.aluno.usingsomeapis.presenter.AnimePresenter
import br.com.aluno.usingsomeapis.resource.extensions.localized
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_anime_episode.view.*

class AnimeEpisodeAdapter(
    private val contextIn: Context,
    private val animeEpisodesListIn: List<Episode>
) : RecyclerView.Adapter<AnimeEpisodeAdapter.ViewHolder>() {

    var mInfoAnimeEpisodeIn: (mAnimeEpisodeIn: Episode) -> Unit = {}

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        this.animeEpisodesListIn[position].let { episodeIn ->

            Picasso.get().load(AnimePresenter.sharedInstance.mAnimeSelected.value.anIMG_URL)
                .into(holder.ivAnEpisodeIMG)

            holder.numAnEpisode.text =
                R.string.episode.localized() + " " + episodeIn.epID.toString()
            holder.nameAnEpisode.text = episodeIn.epTitle

            holder.itemView.setOnClickListener {
                mInfoAnimeEpisodeIn(episodeIn)
            }
        }
    }

    override fun getItemCount(): Int {
        return this.animeEpisodesListIn.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(contextIn).inflate(R.layout.adapter_anime_episode, parent, false)
        )
    }

    class ViewHolder(itemViewIn: View) : RecyclerView.ViewHolder(itemViewIn) {
        var ivAnEpisodeIMG: AppCompatImageView = itemViewIn.ivAnimeEpisodeIMG
        var numAnEpisode: TextView = itemViewIn.tvAnimeEpNum
        var nameAnEpisode: TextView = itemViewIn.tvAnimeEpName
    }
}