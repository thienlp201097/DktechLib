package com.lib.dktechads

import com.admob.max.dktlibrary.AppOpenManager
import com.admob.max.dktlibrary.adjust.AdjustUtils
import com.admob.max.dktlibrary.application.AdsApplication

class MyApplication : AdsApplication() {
    override fun onCreateApplication() {
        AdjustUtils.initAdjust(this,"",false)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        if (level == TRIM_MEMORY_UI_HIDDEN){
            AppOpenManager.getInstance().timeToBackground = System.currentTimeMillis()
        }
    }
}