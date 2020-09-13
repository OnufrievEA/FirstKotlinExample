package com.example.firstkotlinexample.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.firstkotlinexample.R
import com.example.firstkotlinexample.data.model.Color
import com.example.firstkotlinexample.data.model.Note
import com.example.firstkotlinexample.ui.main.App
import java.util.*

object Repository {

    private val notesLiveData = MutableLiveData<List<Note>>()
    private val appRes = App.getContext().resources

    private val titles: Array<String> = appRes.getStringArray(R.array.titles)
    private val descriptions: Array<String> = appRes.getStringArray(R.array.notes)
    private val colors: Array<Color> = Color.values()
    private val uuids: Array<String> = Array(titles.size) { UUID.randomUUID().toString() }

    private val notes: MutableList<Note> = mutableListOf()

    init {
        for (i in titles.indices) {
            notes.add(i, Note(uuids[i], titles[i], descriptions[i], colors[i % colors.size]))
            notesLiveData.value = notes
        }
    }

    fun getNotes(): LiveData<List<Note>> {
        return notesLiveData
    }

    fun saveNote(note: Note) {
        addOrReplace(note)
        notesLiveData.value = notes
    }

    private fun addOrReplace(note: Note) {
        for (i in 0 until notes.size) {
            if (notes[i].id == note.id) {
                notes[i] = note
                return
            }
        }

        notes.add(note)
    }
}



