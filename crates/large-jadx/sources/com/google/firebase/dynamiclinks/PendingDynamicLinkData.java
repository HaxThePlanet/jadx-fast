package com.google.firebase.dynamiclinks;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;
import com.google.firebase.dynamiclinks.internal.DynamicLinkUTMParams;

/* loaded from: classes2.dex */
public class PendingDynamicLinkData {

    private final DynamicLinkData dynamicLinkData;
    private final DynamicLinkUTMParams dynamicLinkUTMParams;
    public PendingDynamicLinkData(DynamicLinkData dynamicLinkData) {
        int currentTimeMillis;
        super();
        if (dynamicLinkData == null) {
            final int obj5 = 0;
            this.dynamicLinkData = obj5;
            this.dynamicLinkUTMParams = obj5;
        }
        if (Long.compare(clickTimestamp, i) == 0) {
            dynamicLinkData.setClickTimestamp(h.b().currentTimeMillis());
        }
        this.dynamicLinkData = dynamicLinkData;
        DynamicLinkUTMParams dynamicLinkUTMParams = new DynamicLinkUTMParams(dynamicLinkData);
        this.dynamicLinkUTMParams = dynamicLinkUTMParams;
    }

    protected PendingDynamicLinkData(String string, int i2, long l3, Uri uri4) {
        super();
        super(0, string, i2, l3, obj5, 0, obj14);
        this.dynamicLinkData = dynamicLinkData2;
        DynamicLinkUTMParams obj10 = new DynamicLinkUTMParams(dynamicLinkData2);
        this.dynamicLinkUTMParams = obj10;
    }

    public long getClickTimestamp() {
        DynamicLinkData dynamicLinkData = this.dynamicLinkData;
        if (dynamicLinkData == null) {
            return 0;
        }
        return dynamicLinkData.getClickTimestamp();
    }

    public Bundle getExtensions() {
        DynamicLinkData dynamicLinkData = this.dynamicLinkData;
        if (dynamicLinkData == null) {
            Bundle bundle = new Bundle();
            return bundle;
        }
        return dynamicLinkData.getExtensionBundle();
    }

    public Uri getLink() {
        DynamicLinkData dynamicLinkData = this.dynamicLinkData;
        final int i = 0;
        if (dynamicLinkData == null) {
            return i;
        }
        String deepLink = dynamicLinkData.getDeepLink();
        if (deepLink != null) {
            return Uri.parse(deepLink);
        }
        return i;
    }

    public int getMinimumAppVersion() {
        DynamicLinkData dynamicLinkData = this.dynamicLinkData;
        if (dynamicLinkData == null) {
            return 0;
        }
        return dynamicLinkData.getMinVersion();
    }

    public Uri getRedirectUrl() {
        DynamicLinkData dynamicLinkData = this.dynamicLinkData;
        if (dynamicLinkData == null) {
            return null;
        }
        return dynamicLinkData.getRedirectUrl();
    }

    public Intent getUpdateAppIntent(Context context) {
        int obj4;
        final int i = 0;
        if (getMinimumAppVersion() == 0) {
            return i;
        }
        if (obj4.versionCode < getMinimumAppVersion() && getRedirectUrl() != null) {
            if (getRedirectUrl() != null) {
                obj4 = new Intent("android.intent.action.VIEW");
                return obj4.setData(getRedirectUrl()).setPackage("com.android.vending");
            }
        }
        return i;
    }

    public Bundle getUtmParameters() {
        DynamicLinkUTMParams dynamicLinkUTMParams = this.dynamicLinkUTMParams;
        if (dynamicLinkUTMParams == null) {
            Bundle bundle = new Bundle();
            return bundle;
        }
        return dynamicLinkUTMParams.asBundle();
    }
}
