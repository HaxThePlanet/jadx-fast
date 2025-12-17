package com.google.firebase.dynamiclinks.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class DynamicLinkUTMParams {

    public static final String KEY_CAMPAIGN = "campaign";
    public static final String KEY_CAMPAIGN_BUNDLE = "_cmp";
    public static final String KEY_MEDIUM = "medium";
    public static final String KEY_SCION_DATA_BUNDLE = "scionData";
    public static final String KEY_SOURCE = "source";
    public static final String KEY_UTM_CAMPAIGN = "utm_campaign";
    public static final String KEY_UTM_MEDIUM = "utm_medium";
    public static final String KEY_UTM_SOURCE = "utm_source";
    private final com.google.firebase.dynamiclinks.internal.DynamicLinkData dynamicLinkData;
    private final Bundle utmParamsBundle;
    public DynamicLinkUTMParams(com.google.firebase.dynamiclinks.internal.DynamicLinkData dynamicLinkData) {
        super();
        this.dynamicLinkData = dynamicLinkData;
        this.utmParamsBundle = DynamicLinkUTMParams.initUTMParamsBundle(dynamicLinkData);
    }

    private static void checkAndAdd(String string, String string2, Bundle bundle3, Bundle bundle4) {
        final String obj0 = bundle3.getString(string);
        if (!TextUtils.isEmpty(obj0)) {
            bundle4.putString(string2, obj0);
        }
    }

    private static Bundle initUTMParamsBundle(com.google.firebase.dynamiclinks.internal.DynamicLinkData dynamicLinkData) {
        Object extensionBundle;
        String str;
        Bundle obj3;
        Bundle bundle = new Bundle();
        if (dynamicLinkData != null) {
            if (dynamicLinkData.getExtensionBundle() == null) {
            } else {
                obj3 = dynamicLinkData.getExtensionBundle().getBundle("scionData");
                if (obj3 == null) {
                    return bundle;
                }
                obj3 = obj3.getBundle("_cmp");
                if (obj3 == null) {
                    return bundle;
                }
                DynamicLinkUTMParams.checkAndAdd("medium", "utm_medium", obj3, bundle);
                DynamicLinkUTMParams.checkAndAdd("source", "utm_source", obj3, bundle);
                DynamicLinkUTMParams.checkAndAdd("campaign", "utm_campaign", obj3, bundle);
            }
        }
        return bundle;
    }

    public Bundle asBundle() {
        Bundle bundle = new Bundle(this.utmParamsBundle);
        return bundle;
    }
}
