package com.beko.noteappwear.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.beko.noteappwear.data.Note
import com.beko.noteappwear.data.NoteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllNote : LiveData<List<Note>>
    private val repository  : NoteRepository

    init {
        val noteDao = NoteDatabase.getDatebase(application).noteDao()
        repository = NoteRepository(noteDao)
        readAllNote = repository.readAllNote
    }

    fun addNote(note: Note){
        viewModelScope.launch(Dispatchers.IO){
            repository.addNote(note)
        }
    }
}