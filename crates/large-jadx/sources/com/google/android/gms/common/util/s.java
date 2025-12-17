package com.google.android.gms.common.util;

import android.os.Looper;

/* loaded from: classes2.dex */
public final class s {
    public static boolean a() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return 1;
        }
        return 0;
    }
}
