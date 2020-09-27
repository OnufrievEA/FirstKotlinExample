package com.example.firstkotlinexample.ui.note

import com.example.firstkotlinexample.data.entity.Note
import com.example.firstkotlinexample.ui.base.BaseViewState

class NoteViewState(val note: Note? = null, error: Throwable? = null) :
    BaseViewState<Note?>(note, error)