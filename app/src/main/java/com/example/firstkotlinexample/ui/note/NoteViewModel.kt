package com.example.firstkotlinexample.ui.note

import androidx.lifecycle.ViewModel
import com.example.firstkotlinexample.data.Repository
import com.example.firstkotlinexample.data.model.Note

class NoteViewModel : ViewModel() {

    private var pendingNote: Note? = null


    fun save(note: Note) {
        pendingNote = note
    }

    override fun onCleared() {
        pendingNote?.let {
            Repository.saveNote(it)
        }
    }
}