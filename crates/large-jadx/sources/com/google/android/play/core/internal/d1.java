package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;

/* loaded from: classes2.dex */
public final class d1 {
    public static void a(PackageManager packageManager, ComponentName componentName2, int i3) {
        int i;
        String className;
        int i6;
        ComponentInfo[][] arr;
        android.content.pm.ServiceInfo[] services;
        int i5;
        int i4;
        int i2;
        boolean equals;
        int obj12;
        obj12 = packageManager.getComponentEnabledSetting(componentName2);
        final int i7 = 1;
        if (obj12 != i7) {
            i = 2;
            if (obj12 != i) {
                obj12 = packageManager.getPackageInfo(componentName2.getPackageName(), 516);
                i6 = 3;
                arr = new ComponentInfo[i6];
                i5 = 0;
                arr[i5] = obj12.activities;
                arr[i7] = obj12.services;
                arr[i] = obj12.providers;
                obj12 = i5;
                while (obj12 < i6) {
                    i = arr[obj12];
                    if (i == 0) {
                        break;
                    } else {
                    }
                    i4 = i5;
                    while (i4 < i.length) {
                        i4++;
                    }
                    obj12++;
                    i4++;
                }
                i2 = 0;
                if (i2 == 0) {
                    packageManager.setComponentEnabledSetting(componentName2, i7, i7);
                } else {
                    if (i2.isEnabled()) {
                    } else {
                    }
                }
            } else {
            }
        }
    }
}
