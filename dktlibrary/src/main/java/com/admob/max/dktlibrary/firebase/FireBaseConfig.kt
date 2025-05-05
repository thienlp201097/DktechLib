package com.admob.max.dktlibrary.firebase

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.google.firebase.remoteconfig.ConfigUpdate
import com.google.firebase.remoteconfig.ConfigUpdateListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings


object FireBaseConfig {

    fun initRemoteConfig(layout : Int,completeListener: CompleteListener) {
        val mFirebaseRemoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings: FirebaseRemoteConfigSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(3600)
            .build()
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings)
        mFirebaseRemoteConfig.setDefaultsAsync(layout)

        mFirebaseRemoteConfig.addOnConfigUpdateListener(object : ConfigUpdateListener {
            override fun onUpdate(configUpdate: ConfigUpdate) {
                mFirebaseRemoteConfig.activate().addOnCompleteListener {
                    completeListener.onComplete()
                }
            }

            override fun onError(error: FirebaseRemoteConfigException) {
            }
        })

        mFirebaseRemoteConfig.fetchAndActivate().addOnCompleteListener {
            if (it.isSuccessful) {
                Handler(Looper.getMainLooper()).postDelayed({
                    completeListener.onComplete()
                }, 2000)
            }
        }
    }

    interface CompleteListener {
        fun onComplete()
    }

    fun getValue(key: String): String {
        val mFirebaseRemoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
        Log.d("==FireBaseConfig==", "getValue: $key ${mFirebaseRemoteConfig.getString(key)}")
        return mFirebaseRemoteConfig.getString(key)
    }
}