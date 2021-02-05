package br.com.aluno.usingsomeapis.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.aluno.usingsomeapis.R
import br.com.aluno.usingsomeapis.presenter.GlobalPresenter
import br.com.aluno.usingsomeapis.view.adapter.CardAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main_menu.*

class MainMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setupUI()
        this.setupCardsRV()
    }

    private fun setupUI(){
        this.activity?.toolbar?.visibility = View.GONE
    }

    private fun setupCardsRV() {
        val mLayoutManager = GridLayoutManager(context, 2)
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL

        this.rvCards.layoutManager = mLayoutManager
        val cardsOpAdapter = this.context?.let {
            CardAdapter(it, GlobalPresenter.sharedInstance.mCardList.value)
        }

        cardsOpAdapter?.clickInfoCard = {
            GlobalPresenter.sharedInstance.mCardSelected.value = it
            this.makeNavigation()
        }

        this.rvCards.adapter = cardsOpAdapter
    }

    private fun makeNavigation() {

        when (GlobalPresenter.sharedInstance.mCardSelected.value.cID) {

            1 -> {
                this.findNavController().navigate(MainMenuFragmentDirections.actionMainMenuToAnime())
            }

            2 -> {

            }
        }
    }
}