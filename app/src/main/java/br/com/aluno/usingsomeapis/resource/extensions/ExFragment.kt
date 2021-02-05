package br.com.aluno.usingsomeapis.resource.extensions

import androidx.fragment.app.Fragment
import br.com.aluno.usingsomeapis.view.activitiy.BaseActivity

fun Fragment.showLoading() {
    val baseA: BaseActivity? = this.activity as? BaseActivity
    baseA?.showLoading()
}

fun Fragment.hideLoading() {
    val baseA: BaseActivity? = this.activity as? BaseActivity
    baseA?.hideLoading()
}