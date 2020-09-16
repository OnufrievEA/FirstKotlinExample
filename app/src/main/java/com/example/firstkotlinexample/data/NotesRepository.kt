package com.example.firstkotlinexample.data

import com.example.firstkotlinexample.data.entity.Note
import ru.geekbrains.gb_kotlin.data.provider.FirestoreDataProvider
import ru.geekbrains.gb_kotlin.data.provider.RemoteDataProvider


object NotesRepository {
    val remoteProvider: RemoteDataProvider = FirestoreDataProvider()

    fun getNotes() = remoteProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = remoteProvider.saveNote(note)
    fun getNoteById(id: String) = remoteProvider.getNoteById(id)
}