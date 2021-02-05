package br.com.aluno.usingsomeapis.view.activitiy

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.aluno.usingsomeapis.resource.utils.Loading
import kotlinx.android.synthetic.main.toolbar_layout.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*

open class BaseActivity : AppCompatActivity() {

    private var mLoading: Loading? = null

    override fun onDestroy() {
        super.onDestroy()
    }

    fun setupNavBar(titleIn: Int, withBackBtn: Boolean, bgColorIn: Int, tvColorIn: Int) {

        window.statusBarColor = bgColorIn
        this.toolbar.visibility = View.VISIBLE

        this.toolbar.mTitle.setText(titleIn)
        this.toolbar.setBackgroundColor(bgColorIn)
        this.toolbar.mTitle.setTextColor(tvColorIn)

        this.toolbar.navBackBtn.visibility = View.GONE
        if (withBackBtn) {
            this.toolbar.navBackBtn.visibility = View.VISIBLE
        }
    }

    fun showLoading() {
        this.mLoading = Loading(this)
        this.mLoading.let {
            it?.start()
        }
    }

    fun hideLoading() {
        this.mLoading.let {
            it?.remove()
        }
        this.mLoading = null
    }
}