package br.com.aluno.usingsomeapis.dao

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class APIClient {

    init {

        val iLogging = HttpLoggingInterceptor()
        iLogging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val originalR = chain.request()
            val request = originalR.newBuilder()
            request.addHeader("Content-Type", "application/json")
            val requestF = request.build()
            chain.proceed(requestF)
        }
    }
}