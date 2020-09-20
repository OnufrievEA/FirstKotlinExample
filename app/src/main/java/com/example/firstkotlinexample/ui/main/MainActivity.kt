package com.example.firstkotlinexample.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstkotlinexample.R
import com.example.firstkotlinexample.data.entity.Note
import com.example.firstkotlinexample.ui.base.BaseActivity
import com.example.firstkotlinexample.ui.base.BaseViewModel
import com.example.firstkotlinexample.ui.note.NoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<List<Note>?, MainViewState>() {

    override val viewModel: BaseViewModel<List<Note>?, MainViewState> by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override val layoutRes = R.layout.activity_main

    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        mainRecycler.layoutManager = GridLayoutManager(this, 2)
        adapter = MainAdapter {
            NoteActivity.start(this, it.id)
        }
        mainRecycler.adapter = adapter
        fab.setOnClickListener {
            NoteActivity.start(this)
        }
    }

    override fun renderData(data: List<Note>?) {
        data?.let {
            adapter.notes = it
        }
    }
}