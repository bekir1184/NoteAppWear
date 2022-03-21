package com.beko.noteappwear.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.recyclerview.widget.RecyclerView
import com.beko.noteappwear.R
import com.beko.noteappwear.databinding.ActivityMain2Binding
import com.beko.noteappwear.databinding.NoteItemBinding
import com.beko.noteappwear.ui.models.Note

class NotesAdapter(val main: MutableList<Note>, val context: Context): RecyclerView.Adapter<NotesAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = DataBindingUtil.inflate<NoteItemBinding>(LayoutInflater.from(context), R.layout.note_item, parent, false)
        return Holder(binding)
    }

    override fun getItemCount() = main.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val mainItem = main[position]
        holder.binding.title.text = mainItem.title
        holder.binding.root.setOnClickListener {
            context.apply {
                if (mainItem.id == 1){
                    startActivity(Intent())
                } else{
                    startActivity(Intent())
                }
            }

        }
    }

    class Holder(val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}