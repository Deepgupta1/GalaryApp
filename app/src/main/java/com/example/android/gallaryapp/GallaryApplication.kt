package com.example.android.gallaryapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GallaryApplication:Application() {

    override fun onCreate() {
        super.onCreate()
    }
}