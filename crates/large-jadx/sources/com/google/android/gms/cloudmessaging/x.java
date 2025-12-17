package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.o.b;
import com.google.android.gms.common.o.c;
import com.google.android.gms.common.util.l;
import java.util.List;

/* loaded from: classes2.dex */
public final class x {

    private final Context a;
    private int b;
    private int c = 0;
    public x(Context context) {
        super();
        final int i = 0;
        this.a = context;
    }

    public final int a() {
        android.content.pm.PackageInfo versionCode;
        b string;
        int stringBuilder;
        synchronized (this) {
            try {
                versionCode = c.a(this.a).e("com.google.android.gms", 0);
                Throwable th = String.valueOf(th);
                string = String.valueOf(th);
                string = string.length();
                string += 23;
                stringBuilder = new StringBuilder(string);
                string = "Failed to find package ";
                stringBuilder.append(string);
                stringBuilder.append(th);
                th = "Metadata";
                string = stringBuilder.toString();
                Log.w(th, string);
                th = null;
                if (versionCode != null) {
                }
                this.b = versionCode.versionCode;
                return this.b;
                throw th;
            } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
            } catch (Throwable th1) {
            }
        }
    }

    public final int b() {
        List broadcastReceivers;
        boolean intentServices;
        int i;
        String str;
        int i2 = this.c;
        synchronized (this) {
            try {
                return i2;
                PackageManager packageManager = this.a.getPackageManager();
                int i6 = 0;
            }
            Log.e("Metadata", "Google Play services missing or without correct permission.");
            return i6;
        }
    }
}
