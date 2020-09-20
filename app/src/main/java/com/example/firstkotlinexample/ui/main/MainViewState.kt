package com.example.firstkotlinexample.ui.main

import com.example.firstkotlinexample.data.entity.Note
import com.example.firstkotlinexample.ui.base.BaseViewState

class MainViewState(val notes: List<Note>? = null, error: Throwable? = null) : BaseViewState<List<Note>?>(notes, error)