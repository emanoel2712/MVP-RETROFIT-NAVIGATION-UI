package br.com.aluno.usingsomeapis.dao

import br.com.aluno.usingsomeapis.model.response.AnimeResponse
import br.com.aluno.usingsomeapis.utils.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIEndPoint {

    @GET(Constant.MAIN_URL_GET_ANIME + "{nameSearched}")
    fun getAnimes(@Path("nameSearched") nameSearched: String): Call<AnimeResponse>
}