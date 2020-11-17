package com.digitalhouse.listafilmes.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.listafilmes.R
import com.digitalhouse.listafilmes.models.Filme

class FilmeAdapter (val listaFilmes: List<Filme>, val context: Context): RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FilmeAdapter.FilmeViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_filme, parent, false)
        return FilmeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FilmeAdapter.FilmeViewHolder, position: Int) {
        val currentItem = listaFilmes[position]
        holder.tvNome.setText(currentItem.nome)
        holder.tvAno.setText(currentItem.lancamento)
        holder.tvSinopse.setText(currentItem.sinopse)
    }

    override fun getItemCount(): Int {
        return listaFilmes.size
    }


    class FilmeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNome: TextView = itemView.findViewById(R.id.tvNome)
        val tvAno: TextView = itemView.findViewById(R.id.tvAno)
        val tvSinopse: TextView = itemView.findViewById(R.id.tvSinopse)

    }
}