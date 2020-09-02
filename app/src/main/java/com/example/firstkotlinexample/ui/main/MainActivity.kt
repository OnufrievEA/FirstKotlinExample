package com.example.firstkotlinexample.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.firstkotlinexample.R
import com.example.firstkotlinexample.data.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val mainViewModelFactory = MainViewModelFactory(applicationContext)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        mainRecycler.adapter = adapter

        mainViewModel.viewState().observe(this, Observer<MainViewState> { t ->
            t?.let { adapter.noteList = it.noteList }
        })
    }
}