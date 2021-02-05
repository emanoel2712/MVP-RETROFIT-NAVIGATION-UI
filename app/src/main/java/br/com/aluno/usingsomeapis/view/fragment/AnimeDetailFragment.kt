package br.com.aluno.usingsomeapis.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.aluno.usingsomeapis.R
import br.com.aluno.usingsomeapis.presenter.AnimePresenter
import br.com.aluno.usingsomeapis.view.activitiy.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_anime.*

class AnimeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_anime, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setupUI()
    }

    private fun setupUI() {
        (this.activity as BaseActivity).setupNavBar(
            AnimePresenter.sharedInstance.mAnimeSelected.value.anTitle ?: "",
            true,
            R.color.colorMainDark,
            R.color.white
        )
        this.settingInfoAnimeInUI()
        this.clickBtnEpisodes()
    }

    private fun settingInfoAnimeInUI() {
        Picasso.get().load(AnimePresenter.sharedInstance.mAnimeSelected.value.anIMG_URL)
            .into(ivAnimeDetailIMG)

        this.tvScoreInfo.text =
            AnimePresenter.sharedInstance.mAnimeSelected.value.anScore.toString()
        this.tvRankedInfo.text =
            AnimePresenter.sharedInstance.mAnimeSelected.value.anRated.toString()
        this.tvQtdEpisodesInfo.text =
            AnimePresenter.sharedInstance.mAnimeSelected.value.anQtdEpisodes.toString()
        this.tvSynopseInfo.text = AnimePresenter.sharedInstance.mAnimeSelected.value.anSynopse
    }

    private fun clickBtnEpisodes() {
        this.btnSeeEpisodes.setOnClickListener {
            this.findNavController().navigate(AnimeDetailFragmentDirections.actionAnimeDetailToAnimeEpisodes())
        }
    }
}