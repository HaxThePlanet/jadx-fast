package com.google.android.gms.cloudmessaging;

import android.os.Build.VERSION;
import android.util.Log;

/* loaded from: classes2.dex */
public final class h extends java.lang.ClassLoader {
    protected final Class<?> loadClass(String string, boolean z2) {
        boolean sDK_INT;
        int i;
        String obj4;
        if ("com.google.android.gms.iid.MessengerCompat".equals(string)) {
            String obj3 = "CloudMessengerCompat";
            obj4 = 3;
            if (!Log.isLoggable(obj3, obj4)) {
                if (Build.VERSION.SDK_INT == 23 && Log.isLoggable(obj3, obj4)) {
                    if (Log.isLoggable(obj3, obj4)) {
                        Log.d(obj3, "Using renamed FirebaseIidMessengerCompat class");
                    }
                }
            } else {
            }
            return i.class;
        }
        return super.loadClass(string, z2);
    }
}
