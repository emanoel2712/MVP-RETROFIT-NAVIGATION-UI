package br.com.aluno.usingsomeapis.dao

import br.com.aluno.usingsomeapis.model.response.AnimeEpisodesResponse
import br.com.aluno.usingsomeapis.model.response.AnimeResponse
import br.com.aluno.usingsomeapis.resource.utils.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIEndPoint {

    @GET("https://api.jikan.moe/v3/search/anime")
    fun getAnimes(@Query("q") nameSearched: String?): Call<AnimeResponse>

    @GET("https://api.jikan.moe/v3/anime/{id}/{request}")
    fun getInfoAnime(@Path("id") animeID: Int?, @Path("request") request: String?): Call<AnimeEpisodesResponse>
}