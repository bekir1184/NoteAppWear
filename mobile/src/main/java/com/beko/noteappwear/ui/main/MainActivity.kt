package com.beko.noteappwear.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.beko.noteappwear.data.Note
import com.beko.noteappwear.databinding.ActivityMainBinding
import com.beko.noteappwear.ui.adapter.NotesAdapter
import com.beko.noteappwear.ui.main.dialog.AddNoteDialog

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var notelist : MutableList<Note>
    private lateinit var adapter: NotesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycler()
        setClicks()
    }

    private fun setClicks() {
        binding.fab.setOnClickListener {
            val addNote = AddNoteDialog()
            addNote.show(supportFragmentManager,"TAG")
        }
    }

    private fun setRecycler() {
        notelist = ArrayList()
        notelist.add(Note(1,"Test başlığı","Notum bu"))
        notelist.add(Note(2,"Buraya başlık","Notum bu"))
        notelist.add(Note(3,"Başlık","Notum bu"))
        notelist.add(Note(4,"Bugun falan","Notum bu"))
        notelist.add(Note(5,"Yarına not","Notum bu"))
        notelist.add(Note(6,"Şifrelerim","Notum bu"))

        adapter = NotesAdapter(notelist)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}