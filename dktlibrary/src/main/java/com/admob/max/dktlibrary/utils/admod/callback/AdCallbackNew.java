package com.admob.max.dktlibrary.utils.admod.callback;

import com.google.android.gms.ads.AdValue;

public interface AdCallbackNew {
    void onAdClosed();
    void onEventClickAdClosed();
    void onAdShowed();
    void onAdLoaded();
    void onAdFail();
    void onPaid(AdValue adValue, String adUnitAds);
}
