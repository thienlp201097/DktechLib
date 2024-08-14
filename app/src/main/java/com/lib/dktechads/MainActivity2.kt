package com.lib.dktechads

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.admob.max.dktlibrary.AdmobUtils
import com.admob.max.dktlibrary.AdmobUtils.BannerCollapsibleAdCallback
import com.admob.max.dktlibrary.ApplovinUtil
import com.admob.max.dktlibrary.callback_applovin.BannerCallback
import com.admob.max.dktlibrary.callback_applovin.InterstititialCallback
import com.admob.max.dktlibrary.utils.admod.remote.BannerPlugin
import com.applovin.mediation.MaxAd
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdValue
import com.google.android.gms.ads.AdView
import com.lib.dktechads.utils.AdsManager

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val btn = findViewById<Button>(R.id.btn_2)
        val bannerContainer = findViewById<FrameLayout>(R.id.banner_container)
        btn.setOnClickListener {
                ApplovinUtil.loadAndShowInterstitialsWithDialogCheckTime(this,AdsManager.interHolder,object :
                    InterstititialCallback {
                    override fun onInterstitialReady() {

                    }

                    override fun onInterstitialClosed() {


                    }

                    override fun onInterstitialLoadFail(error: String) {


                    }

                    override fun onInterstitialShowSucceed() {

                    }

                    override fun onAdRevenuePaid(ad: MaxAd) {

                    }

                })
        }

        AdmobUtils.loadAndShowBannerWithConfig(this,"",5,1000,bannerContainer,BannerPlugin.BannerConfig.TYPE_COLLAPSIBLE_BOTTOM,object :
            BannerCollapsibleAdCallback{
            override fun onClickAds() {
                
            }

            override fun onBannerAdLoaded(adSize: AdSize) {
                
            }

            override fun onAdFail(message: String) {
                
            }

            override fun onAdPaid(adValue: AdValue, mAdView: AdView) {
                
            }

        })
    }
    override fun onResume() {
//        
//        ApplovinUtil.showBanner(this,bannerContainer,"banner_main", object : BannerCallback {
//            override fun onBannerLoadFail(error: String) {
//            }
//
//            override fun onBannerShowSucceed() {
//            }
//
//            override fun onAdRevenuePaid(ad: MaxAd) {
//
//            }
//        })
        super.onResume()
    }
}