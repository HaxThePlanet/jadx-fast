package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;

/* loaded from: classes2.dex */
public final class l6 {

    static volatile com.google.android.gms.internal.measurement.b7<Boolean> a;
    private static final Object b;
    static {
        l6.a = b7.c();
        Object object = new Object();
        l6.b = object;
    }

    public static boolean a(Context context, Uri uri2) {
        boolean resolveContentProvider;
        int i2;
        String packageName;
        int i;
        int i3;
        int obj5;
        String obj6 = uri2.getAuthority();
        i2 = 0;
        if (!"com.google.android.gms.phenotype".equals(obj6)) {
            String.valueOf(obj6).length();
            Log.e("PhenotypeClientHelper", String.valueOf(obj6).concat(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."));
            return i2;
        }
        if (l6.a.b()) {
            return (Boolean)l6.a.a().booleanValue();
        }
        obj6 = l6.b;
        synchronized (obj6) {
            return (Boolean)l6.a.a().booleanValue();
        }
    }
}
