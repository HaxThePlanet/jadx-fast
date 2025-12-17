package com.appsflyer.internal;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

/* loaded from: classes.dex */
final class u {

    static final class d {

        static final com.appsflyer.internal.u AFInAppEventParameterName;
        static {
            u uVar = new u();
            u.d.AFInAppEventParameterName = uVar;
        }
    }
    private static boolean values(Context context, String[] string2Arr2) {
        int i;
        boolean z;
        final int i2 = 0;
        i = i2;
        while (i < string2Arr2.length) {
            i++;
        }
        return i2;
    }

    final Location AFKeystoreWrapper(Context context) {
        int strArr;
        int i;
        Location lastKnownLocation;
        int str;
        int i2;
        Location obj9;
        String str2 = "android.permission.ACCESS_FINE_LOCATION";
        i = 0;
        Object systemService = context.getSystemService("location");
        if (u.values(context, /* result */)) {
            lastKnownLocation = (LocationManager)systemService.getLastKnownLocation("network");
        } else {
            lastKnownLocation = i;
        }
        try {
            if (u.values(context, /* result */)) {
            } else {
            }
            obj9 = systemService.getLastKnownLocation("gps");
            obj9 = i;
            if (obj9 == null && lastKnownLocation == null) {
            } else {
            }
            if (lastKnownLocation == null) {
            } else {
            }
            lastKnownLocation = i;
            if (obj9 == null && lastKnownLocation != null) {
            } else {
            }
            if (lastKnownLocation != null) {
            } else {
            }
            if (lastKnownLocation == null) {
            } else {
            }
            if (obj9 == null && Long.compare(i2, str) < 0) {
            } else {
            }
            if (Long.compare(i2, str) < 0) {
            } else {
            }
            lastKnownLocation = obj9;
            if (lastKnownLocation != null) {
            }
            i = lastKnownLocation;
            return i;
        }
    }
}
