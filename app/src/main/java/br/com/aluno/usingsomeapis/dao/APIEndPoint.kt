package br.com.aluno.usingsomeapis.dao

import br.com.aluno.usingsomeapis.model.response.AnimeResponse
import br.com.aluno.usingsomeapis.resource.utils.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIEndPoint {

    //"https://api.jikan.moe/v3/search/anime"
    @GET(Constant.MAIN_URL_GET_ANIMES_LIST)
    fun getAnimes(@Query("q") nameSearched: String?): Call<AnimeResponse>

    //https://api.jikan.moe/v3/anime/
    @GET(Constant.MAIN_URL_GET_EPISODES_OF_ANIME)
    fun getEpisodesOfAnime(@Query("id") animeID: Double?, @Query("request") request: String?)
}