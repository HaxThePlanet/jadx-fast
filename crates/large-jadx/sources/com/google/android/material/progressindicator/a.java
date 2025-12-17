package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;

/* loaded from: classes2.dex */
public class a {

    private static float a = 1f;
    static {
    }

    public float a(ContentResolver contentResolver) {
        final int sDK_INT = Build.VERSION.SDK_INT;
        final int i = 1065353216;
        final String str = "animator_duration_scale";
        if (sDK_INT >= 17) {
            return Settings.Global.getFloat(contentResolver, str, i);
        }
        if (sDK_INT == 16) {
            return Settings.System.getFloat(contentResolver, str, i);
        }
        return a.a;
    }
}
