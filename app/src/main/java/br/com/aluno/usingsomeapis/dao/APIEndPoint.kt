package br.com.aluno.usingsomeapis.dao

import br.com.aluno.usingsomeapis.model.response.AnimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query
import java.util.*


interface APIEndPoint {

    @GET("https://api.jikan.moe/v3/search/anime")
    fun getAnimes(@Query("q") nameSearched: String?): Call<AnimeResponse>
}