package com.admob.max.dktlibrary.callback_applovin;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;

public interface NativeAdCallback {
    void onNativeAdLoaded();
    void onLoadedAndGetNativeAd(MaxAd ad, MaxNativeAdView adView);
    void onAdRevenuePaid(MaxAd ad);
    void onAdFail();
}
