package com.example.firstkotlinexample.ui.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstkotlinexample.data.Repository

class MainViewModel(context: Context) : ViewModel() {

    private val repository = Repository(context)
    private val viewStateLiveData: MutableLiveData<MainViewState> = MutableLiveData()

    init {
        viewStateLiveData.value = MainViewState(repository.noteList)
    }

    fun viewState(): LiveData<MainViewState> = viewStateLiveData
}