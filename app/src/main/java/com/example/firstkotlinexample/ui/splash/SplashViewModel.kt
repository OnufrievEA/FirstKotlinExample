package com.example.firstkotlinexample.ui.splash

import com.example.firstkotlinexample.data.NotesRepository
import com.example.firstkotlinexample.data.errors.NoAuthException
import com.example.firstkotlinexample.ui.base.BaseViewModel


class SplashViewModel : BaseViewModel<Boolean?, SplashViewState>() {

    fun requestUser() {
        NotesRepository.getCurrentUser().observeForever {
            viewStateLiveData.value = it?.let {
                SplashViewState(authenticated = true)
            } ?: SplashViewState(error = NoAuthException())
        }
    }
}
