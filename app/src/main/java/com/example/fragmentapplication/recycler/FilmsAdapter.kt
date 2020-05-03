package com.otus.otusfragmentsnew.recyclerTwo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentapplication.R

class FilmsAdapter(private val layoutInflater: LayoutInflater,
                  private val items: List<FilmsItem>,
                  private val listener: ((newsItem: FilmsItem) -> Unit)?) : RecyclerView.Adapter<FilmsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        return FilmsViewHolder(layoutInflater.inflate(R.layout.item_films, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.bind(items[position])

        holder.itemView.setOnClickListener {
            listener?.invoke(items[position])
        }
    }
}