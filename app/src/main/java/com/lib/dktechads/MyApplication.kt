package com.lib.dktechads

import com.admob.max.dktlibrary.adjust.AdjustUtils
import com.admob.max.dktlibrary.application.AdsApplication

class MyApplication : AdsApplication() {
    override fun onCreateApplication() {
        AdjustUtils.initAdjust(this,"",false)
    }
}