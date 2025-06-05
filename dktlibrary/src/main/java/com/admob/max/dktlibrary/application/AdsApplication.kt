package com.admob.max.dktlibrary.application

import android.app.Activity
import android.app.Application
import android.os.Bundle

abstract class AdsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        onCreateApplication()
    }

    abstract fun onCreateApplication()
}