package com.example.firstkotlinexample.ui.splash

import com.example.firstkotlinexample.ui.base.BaseViewState


class SplashViewState(authenticated: Boolean? = null, error: Throwable? = null) :
    BaseViewState<Boolean?>(authenticated, error)