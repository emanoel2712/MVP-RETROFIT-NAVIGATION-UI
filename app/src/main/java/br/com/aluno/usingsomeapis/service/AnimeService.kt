package br.com.aluno.usingsomeapis.service

import br.com.aluno.usingsomeapis.dao.APIClient
import br.com.aluno.usingsomeapis.model.response.AnimeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimeService(private val baseServiceIF: BaseServiceIF) {

    var mainAPIClient: APIClient = APIClient()

    fun getAnimes(nameSearched: String, wsTagInt: Int) {

//        GlobalPresenter.sharedInstance.baseURL = Constant.MAIN_URL_GET_ANIME + nameSearched + "/"
        val mCall: Call<AnimeResponse> = mainAPIClient.clientAPI.getAnimes(nameSearched)
        mCall.enqueue(object : Callback<AnimeResponse> {

            override fun onResponse(call: Call<AnimeResponse>, response: Response<AnimeResponse>) {
                if (!response.isSuccessful) {

                }

                response.body()?.let {
                    baseServiceIF.onResultSuccess(Response.success(it), wsTagInt)
                }
            }

            override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
            }
        })
    }
}