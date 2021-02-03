package br.com.aluno.usingsomeapis.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.aluno.usingsomeapis.R
import br.com.aluno.usingsomeapis.model.Card
import kotlinx.android.synthetic.main.adapter_card.view.*

class CardAdapter(private val contextIn: Context, private val cardListIn: List<Card>) :
    RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        this.cardListIn[position].let {

            when (it.cID) {

                1 -> {
                    holder.nameCard.text = "GIFS Animados"
                    holder.ivCard.setImageResource(R.drawable.bg_main_menu)
                }

                2 -> {
                    holder.nameCard.text = "Gatos"
                    holder.ivCard.setImageResource(R.drawable.bg_main_menu)
                }

                3 -> {

                }

                4 -> {

                }
            }
        }
    }

    override fun getItemCount(): Int {
        return this.cardListIn.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(contextIn).inflate(R.layout.adapter_card, parent, false)
        )
    }

    class ViewHolder(itemViewIn: View) : RecyclerView.ViewHolder(itemViewIn) {
        var ivCard: ImageView = itemViewIn.ivCard
        var nameCard: TextView = itemViewIn.nameCard

    }
}