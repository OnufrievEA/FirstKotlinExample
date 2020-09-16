package com.example.firstkotlinexample.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.firstkotlinexample.R
import com.example.firstkotlinexample.data.entity.Note
import com.example.firstkotlinexample.ui.note.NoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private val adapter = MainAdapter(object : MainAdapter.OnItemClickListener {
        override fun onItemClick(note: Note) {
            openNoteScreen(note)
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainRecycler.adapter = adapter

        mainViewModel.viewState().observe(this, Observer<MainViewState> { t ->
            t?.let { adapter.notes = it.notes }
        })

        fab.setOnClickListener {
            NoteActivity.start(this)
        }
    }

    private fun openNoteScreen(note: Note?) {
        NoteActivity.start(this, note)
    }
}