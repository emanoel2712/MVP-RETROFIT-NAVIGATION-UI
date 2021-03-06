package br.com.aluno.usingsomeapis.view.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.aluno.usingsomeapis.R
import br.com.aluno.usingsomeapis.presenter.AnimePresenter
import br.com.aluno.usingsomeapis.resource.extensions.hideLoading
import br.com.aluno.usingsomeapis.resource.extensions.localized
import br.com.aluno.usingsomeapis.resource.extensions.showLoading
import br.com.aluno.usingsomeapis.view.activitiy.BaseActivity
import br.com.aluno.usingsomeapis.view.adapter.AnimeAdapter
import kotlinx.android.synthetic.main.fragment_anime.*

class AnimeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setupUI()
    }

    private fun setupUI() {
        (requireActivity() as BaseActivity).setupNavBar(
            R.string.animes.localized(),
            true,
            R.color.colorMainDark,
            R.color.white
        )
        this.setupListeners()
        this.setupAnimesRV()
        this.clickBtnSearch()
        this.editClickInNext()
    }

    private fun setupListeners() {
        AnimePresenter.sharedInstance.mAnimeList.bind {
            this.hideLoading()
            this.setupAnimesRV()
        }

        this.showLoading()
        AnimePresenter.sharedInstance.getAnimes(AnimePresenter.sharedInstance.getAnimeDefault())
    }

    private fun setupAnimesRV() {
        val mLayoutManager = GridLayoutManager(context, 2)
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL

        val mAnimeAdapter = context?.let {
            AnimeAdapter(it, AnimePresenter.sharedInstance.mAnimeList.value)
        }

        mAnimeAdapter?.mAnimeInfo = {
            AnimePresenter.sharedInstance.mAnimeSelected.value = it
            this.findNavController().navigate(AnimeFragmentDirections.actionAnimeToAnimeDetail())
        }

        this.rvAnimes.layoutManager = mLayoutManager
        this.rvAnimes.adapter = mAnimeAdapter
    }

    private fun clickBtnSearch() {
        this.btnSearch.setOnClickListener {
            this.searchTF.editText?.let {
                if (it.text.isNotEmpty()) {
                    this.showLoading()
                    AnimePresenter.sharedInstance.getAnimes(it.text.toString())

                } else {
                    it.error = "O campo não pode ser vazio"
                }
            }
        }
    }

    private fun editClickInNext() {

        this.searchTF.editText?.setOnEditorActionListener { _, i, _ ->
            if (i == EditorInfo.IME_ACTION_NEXT) {
                this.btnSearch.requestFocusFromTouch()
            }
            false
        }
    }
}