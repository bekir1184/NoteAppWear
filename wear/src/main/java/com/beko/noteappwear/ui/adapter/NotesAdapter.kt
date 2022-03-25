package com.beko.noteappwear.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.beko.noteappwear.R
import com.beko.noteappwear.ui.models.Note

class NotesAdapter(
    val main: MutableList<Note>,
    private val onClickListener: (Note) -> Unit
    ): RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.note_item2,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title  = holder.itemView.findViewById<TextView>(R.id.title)
        title.text = main[position].title
        holder.itemView.setOnClickListener {
            onClickListener(main[position])
            println("Tik")
        }
    }

    override fun getItemCount(): Int {
       return  main.size
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}