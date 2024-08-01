package com.admob.max.dktlibrary.utils.admod.callback;

import com.google.android.gms.ads.AdValue;

public interface AdLoadCallback {
    void onAdFail(String message);
    void onAdLoaded();
    void onPaid(AdValue adValue, String adUnitAds);
}
