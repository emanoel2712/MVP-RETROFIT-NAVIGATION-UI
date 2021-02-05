package br.com.aluno.usingsomeapis.presenter

import br.com.aluno.usingsomeapis.model.Anime
import br.com.aluno.usingsomeapis.model.response.AnimeResponse
import br.com.aluno.usingsomeapis.service.AnimeService
import br.com.aluno.usingsomeapis.service.BaseServiceIF
import br.com.aluno.usingsomeapis.resource.utils.Constant
import br.com.aluno.usingsomeapis.resource.utils.DynamicType
import retrofit2.Response

class AnimePresenter : BaseServiceIF {

    companion object {
        var sharedInstance = AnimePresenter()
    }

    private var mainAnimeService = AnimeService(this)
    var mAnimeList: DynamicType<List<Anime>> = DynamicType(listOf())
    var mAnimeSelected: DynamicType<Anime> = DynamicType(Anime())

    // PUBLIC Methods

    fun getAnimeDefault(): String {
        this.mAnimeList.value = listOf()

        val mListAnimeDefault: List<String> = listOf(
            "Naruto",
            "Dragon ball",
            "One Piece",
            "Death note",
            "Yu Yu Hakusho",
            "One-Punch Man"
        )

        return mListAnimeDefault.random()
    }

    // API Methods

    fun getAnimes(nameSearched: String) {
        this.mainAnimeService.getAnimes(nameSearched, Constant.GET_ANIMES_API_TAG)
    }

    override fun <T : Any> onResultSuccess(responseIn: Response<T>, wsTagInt: Int) {

        when (wsTagInt) {

            Constant.GET_ANIMES_API_TAG -> {
                var animeResponse: AnimeResponse? = responseIn.body() as AnimeResponse?
                animeResponse?.anListIn?.let {
                    this.mAnimeList.value = it
                }
            }
        }
    }

    override fun onResultFail(msgIn: String, responseIn: Any?) {
        TODO("Not yet implemented")
    }
}