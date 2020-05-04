package com.otus.otusfragmentsnew.recyclerTwo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FilmsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: FilmsItem) {
        (itemView as TextView).text = item.title
    }
}