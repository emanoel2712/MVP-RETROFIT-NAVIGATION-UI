package br.com.aluno.usingsomeapis.resource.utils

import android.content.Context

abstract class MainContext {

    companion object {
        lateinit var context: Context
    }
}