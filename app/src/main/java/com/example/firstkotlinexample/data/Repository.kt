package com.example.firstkotlinexample.data

import android.content.Context
import com.example.firstkotlinexample.R
import com.example.firstkotlinexample.data.model.Note

data class Repository(val context: Context) {

    private val titles: Array<String> = context.resources.getStringArray(R.array.titles)
    private val notes: Array<String> = context.resources.getStringArray(R.array.notes)
    private val colors: IntArray = context.resources.getIntArray(R.array.colors)

    val noteList: MutableList<Note> = mutableListOf()

    init {
        for (i in titles.indices) {
            noteList.add(i, Note(titles[i], notes[i], colors[i]))
        }
    }
}



