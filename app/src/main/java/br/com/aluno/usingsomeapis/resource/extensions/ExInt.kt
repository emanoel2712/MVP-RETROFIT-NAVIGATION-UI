package br.com.aluno.usingsomeapis.resource.extensions

import br.com.aluno.usingsomeapis.resource.utils.MainContext

fun Int.localized(): String {
    return MainContext.context.getString(this)
}