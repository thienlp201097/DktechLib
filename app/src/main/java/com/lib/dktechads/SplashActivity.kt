package com.lib.dktechads

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.admob.max.dktlibrary.AdmobUtils
import com.admob.max.dktlibrary.AppOpenManager
import com.admob.max.dktlibrary.ApplovinUtil
import com.admob.max.dktlibrary.R
import com.admob.max.dktlibrary.callback_applovin.NativeCallBackNew
import com.admob.max.dktlibrary.firebase.FireBaseConfig
import com.admob.max.dktlibrary.utils.Utils
import com.admob.max.dktlibrary.utils.admod.callback.MobileAdsListener
import com.applovin.mediation.MaxAd
import com.applovin.mediation.nativeAds.MaxNativeAdView
import com.lib.dktechads.databinding.ActivitySplashBinding
import com.lib.dktechads.utils.AdsManager
import com.lib.dktechads.utils.AdsManagerAdmod


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FireBaseConfig.initRemoteConfig(R.xml.remote_config_defaults,object : FireBaseConfig.CompleteListener{
            override fun onComplete() {
                FireBaseConfig.getValue("test")
                AdmobUtils.initAdmob(this@SplashActivity, isDebug = true, isEnableAds = true,false, object : MobileAdsListener {
                    override fun onSuccess() {
                        Log.d("==initAdmob==", "initAdmob onSuccess: ")
                        AppOpenManager.getInstance()
                            .init(application, getString(R.string.test_ads_admob_app_open_new))
                        AppOpenManager.getInstance()
                            .disableAppResumeWithActivity(SplashActivity::class.java)
                        AppOpenManager.getInstance().setTestAds(false)

                        AdsManagerAdmod.loadAndShowInterSplash(this@SplashActivity,AdsManagerAdmod.interholder,object : AdsManagerAdmod.AdListener{
                            override fun onAdClosed() {
                                Utils.getInstance().replaceActivity(this@SplashActivity, MainActivity::class.java)

                            }

                            override fun onFailed() {
                                Utils.getInstance().replaceActivity(this@SplashActivity, MainActivity::class.java)

                            }
                        })
                    }
                })
            }
        })
    }
}