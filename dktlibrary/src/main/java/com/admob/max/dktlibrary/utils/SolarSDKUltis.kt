package com.admob.max.dktlibrary.utils

import android.content.Context
import android.util.Log
import com.reyun.solar.engine.SolarEngineConfig
import com.reyun.solar.engine.SolarEngineManager

object SolarSDKUtils {
    fun initSdk(context: Context,key: String){
        val config = SolarEngineConfig.Builder().build()
        SolarEngineManager.getInstance().initialize(
            context, key, config
        ) { code ->
            Log.d("==initSdk==", "initSdk: code $code")
        }
    }

    fun preInitSolarSdk(context: Context,key: String){
        SolarEngineManager.getInstance().preInit(context, key);
    }
}
