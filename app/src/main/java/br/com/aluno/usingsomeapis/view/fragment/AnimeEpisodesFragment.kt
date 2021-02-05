package br.com.aluno.usingsomeapis.view.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.aluno.usingsomeapis.R
import br.com.aluno.usingsomeapis.presenter.AnimePresenter
import br.com.aluno.usingsomeapis.resource.extensions.localized
import br.com.aluno.usingsomeapis.view.activitiy.BaseActivity
import br.com.aluno.usingsomeapis.view.adapter.AnimeEpisodeAdapter
import kotlinx.android.synthetic.main.fragment_anime_episodes.*

class AnimeEpisodesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime_episodes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setupUI()
    }

    private fun setupUI() {
        (this.activity as BaseActivity).setupNavBar(
            R.string.episodes.localized(),
            true,
            R.color.colorMainDark,
            R.color.white
        )

        this.tvSeeEpisodes.text =
            "Todos episódios de " + AnimePresenter.sharedInstance.mAnimeSelected.value.anTitle

        this.setupListeners()
        this.setupEpisodesRV()
    }

    private fun setupListeners() {

        AnimePresenter.sharedInstance.mEpisodesList.bind {
            this.setupEpisodesRV()
        }

        AnimePresenter.sharedInstance.getEpisodesAnime()
    }

    private fun setupEpisodesRV() {

        val mLayoutManager = LinearLayoutManager(context)
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL

        var mAnimeEpisodeAdapter = context?.let {
            AnimeEpisodeAdapter(
                it,
                AnimePresenter.sharedInstance.mEpisodesList.value
            )
        }

        mAnimeEpisodeAdapter?.mInfoAnimeEpisodeIn = {
            AnimePresenter.sharedInstance.mEpisodeSelected.value = it
            if (it.epVideoURL != null || it.epVideoURL != "") {
//                var url = AnimePresenter.sharedInstance.mEpisodeSelected.value.epVideoURL
//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("param + string"))
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                this.startActivity(intent)

//                this.startActivity(Intent(requireContext(), VideoActivity::class.java))
            } else {
                Toast.makeText(context, R.string.url_is_empty, Toast.LENGTH_LONG).show()
            }
        }

        this.rvEpisodes.layoutManager = mLayoutManager
        this.rvEpisodes.adapter = mAnimeEpisodeAdapter
    }
}