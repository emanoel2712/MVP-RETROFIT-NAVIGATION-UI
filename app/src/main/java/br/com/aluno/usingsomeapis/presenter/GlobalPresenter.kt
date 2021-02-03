package br.com.aluno.usingsomeapis.presenter

import androidx.navigation.fragment.NavHostFragment
import br.com.aluno.usingsomeapis.R
import br.com.aluno.usingsomeapis.model.Card

class GlobalPresenter {

    companion object {
        var sharedInstance: GlobalPresenter = GlobalPresenter()
    }

    val navHostFragment = NavHostFragment.create(R.navigation.nav_graph)
    var listCards: List<Card> = listOf()

    fun generateCards() {
        this.listCards = listOf(Card(1, "GIF"), Card(2, "Cats"), Card(3, "Dogs"))
    }
}