package com.example.firstkotlinexample.data.provider

import androidx.lifecycle.LiveData
import com.example.firstkotlinexample.data.entity.Note
import com.example.firstkotlinexample.data.entity.User
import com.example.firstkotlinexample.data.model.NoteResult


interface RemoteDataProvider {
    fun subscribeToAllNotes(): LiveData<NoteResult>
    fun getNoteById(id: String): LiveData<NoteResult>
    fun saveNote(note: Note): LiveData<NoteResult>
    fun getCurrentUser(): LiveData<User?>
}