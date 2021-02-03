package br.com.aluno.usingsomeapis.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.aluno.usingsomeapis.R
import br.com.aluno.usingsomeapis.presenter.GlobalPresenter
import br.com.aluno.usingsomeapis.view.adapter.CardAdapter
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
        this.setupCardsRV()
    }

    private fun setupCardsRV() {
        println("LISTA CARDS " + GlobalPresenter.sharedInstance.listCards)
        GlobalPresenter.sharedInstance.generateCards()
        println("LISTA CARDS " + GlobalPresenter.sharedInstance.listCards)

        val mLayoutManager = GridLayoutManager(context, 2)
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL

        this.rvCards.layoutManager = mLayoutManager
        val cardsOpAdapter = this.context?.let {
            CardAdapter(it, GlobalPresenter.sharedInstance.listCards)
        }

        this.rvCards.adapter = cardsOpAdapter
    }
}