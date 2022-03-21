package com.beko.noteappwear.ui

import android.app.Activity
import android.os.Bundle
import androidx.wear.ambient.AmbientModeSupport
import androidx.wear.widget.WearableLinearLayoutManager
import com.beko.noteappwear.databinding.ActivityMain2Binding
import com.beko.noteappwear.ui.adapter.NotesAdapter
import com.beko.noteappwear.ui.models.Note


class MainActivity : Activity(){
    private lateinit var ambientController: AmbientModeSupport.AmbientController
    private lateinit var binding :  ActivityMain2Binding
    private lateinit var notelist : MutableList<Note>
    private lateinit var adapter: NotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        notelist = ArrayList()
        notelist.add(Note(1,"Test başlığı","Notum bu"))
        notelist.add(Note(2,"Buraya başlık","Notum bu"))
        notelist.add(Note(3,"Başlık","Notum bu"))
        notelist.add(Note(4,"Bugun falan","Notum bu"))
        notelist.add(Note(5,"Yarına not","Notum bu"))
        notelist.add(Note(6,"Şifrelerim","Notum bu"))

        adapter = NotesAdapter(notelist,this)

        binding.recyclerView.isEdgeItemsCenteringEnabled = true
        binding.recyclerView.layoutManager = WearableLinearLayoutManager(this)
        binding.recyclerView.isCircularScrollingGestureEnabled = true;
        binding.recyclerView.isEdgeItemsCenteringEnabled = true
        binding.recyclerView.adapter = adapter

    }

}