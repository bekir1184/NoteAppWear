package com.beko.noteappwear.ui.main

import androidx.lifecycle.LiveData
import com.beko.noteappwear.data.Note
import com.beko.noteappwear.data.NoteDao

class NoteRepository(
    private val noteDao: NoteDao
) {
    val readAllNote : LiveData<List<Note>> = noteDao.readAllNote()

    suspend fun addNote(note: Note){
        noteDao.addNote(note)
    }
}