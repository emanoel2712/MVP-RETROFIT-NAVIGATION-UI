package br.com.aluno.usingsomeapis.presenter

import androidx.navigation.fragment.NavHostFragment
import br.com.aluno.usingsomeapis.R
import br.com.aluno.usingsomeapis.model.Card
import br.com.aluno.usingsomeapis.resource.utils.DynamicType

class GlobalPresenter {

    companion object {
        var sharedInstance: GlobalPresenter = GlobalPresenter()
    }

    val navHostFragment = NavHostFragment.create(R.navigation.nav_graph)
    var mCardList: DynamicType<List<Card>> =
        DynamicType(listOf(Card(1, "ANIME")))
    var mCardSelected: DynamicType<Card> = DynamicType(Card())

}