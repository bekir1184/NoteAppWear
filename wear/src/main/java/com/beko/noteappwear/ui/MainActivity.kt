package com.beko.noteappwear.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.beko.noteappwear.R
import com.beko.noteappwear.databinding.ActivityMain2Binding
import com.beko.noteappwear.ui.adapter.NotesAdapter
import com.beko.noteappwear.ui.models.Note


class MainActivity : Activity(){
    private lateinit var binding :  ActivityMain2Binding
    private lateinit var notelist : MutableList<Note>
    private lateinit var adapter: NotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecylerView()
        setOnClick()


    }

    private fun setOnClick() {
        binding.addNote.setOnClickListener {
            val intent = Intent(this,AddNote::class.java)
            startActivity(intent)
        }
    }

    private fun setRecylerView() {
        notelist = ArrayList()
        val string: String = getString(R.string.lorem)
        notelist.add(Note(1,"Test başlığı",string))
        notelist.add(Note(2,"Buraya başlık",string))
        notelist.add(Note(3,"Başlık",string))
        notelist.add(Note(4,"Bugun falan",string))
        notelist.add(Note(5,"Yarına not",string))
        notelist.add(Note(6,"Şifrelerim",string))

        adapter = NotesAdapter(notelist) { note -> onListItemClick(note) }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun onListItemClick(note : Note) {
        println("Tak")
        val intent = Intent(this,Content::class.java)
        intent.putExtra("title", note.title)
        intent.putExtra("content",note.content)
        startActivity(intent)
    }

}