package com.beko.noteappwear.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.beko.noteappwear.R
import com.beko.noteappwear.data.Note


class NotesAdapter(val main: MutableList<Note>): RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title  = holder.itemView.findViewById<TextView>(R.id.title)
        val content  = holder.itemView.findViewById<TextView>(R.id.content)
        title.text = main[position].title
        content.text = main[position].content
    }

    override fun getItemCount(): Int {
        return  main.size
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}