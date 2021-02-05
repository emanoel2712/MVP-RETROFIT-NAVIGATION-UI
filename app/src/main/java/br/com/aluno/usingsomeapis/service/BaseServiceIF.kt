package br.com.aluno.usingsomeapis.service

import retrofit2.Response

interface BaseServiceIF {

    fun <T : Any> onResultSuccess(responseIn: Response<T>, wsTagInt: Int)
    fun onResultFail(msgIn: String, responseIn: Any? = null)
}
