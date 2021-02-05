package br.com.aluno.usingsomeapis.resource.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import br.com.aluno.usingsomeapis.R
import java.lang.Exception

class Loading(contextIn: Context, private val isBlockView: Boolean = true) : Dialog(contextIn) {

    init {
        this.setCancelable(false)
        this.canUserTouchComponents()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading_layout)

        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    private fun canUserTouchComponents() {
        if (!isBlockView) {
            this.setCanceledOnTouchOutside(true)
        }
    }

    fun start() {
        this.show()
    }

    fun remove() {
        this.dismiss()
    }
}