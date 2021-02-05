package br.com.aluno.usingsomeapis.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.aluno.usingsomeapis.R
import br.com.aluno.usingsomeapis.model.Anime
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_animes.view.*

class AnimeAdapter(private val contextIn: Context, private val animeListIn: List<Anime>) :
    RecyclerView.Adapter<AnimeAdapter.ViewHolder>() {

    var mAnimeInfo: (animeIn: Anime) -> Unit = { }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        this.animeListIn[position].let {animeIn ->

            Picasso.get().load(animeIn.anIMG_URL).into(holder.ivAnimeIMG)
            holder.tvAnimeName.text = animeIn.anTitle

            holder.itemView.setOnClickListener {
                this.mAnimeInfo(animeIn)
            }
        }
    }

    override fun getItemCount(): Int {
        return this.animeListIn.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(contextIn).inflate(R.layout.adapter_animes, parent, false)
        )
    }

    class ViewHolder(itemViewIn: View) : RecyclerView.ViewHolder(itemViewIn) {
        val ivAnimeIMG: AppCompatImageView = itemViewIn.ivAnimeIMG
        val tvAnimeName: TextView = itemViewIn.tvAnimeName
    }
}