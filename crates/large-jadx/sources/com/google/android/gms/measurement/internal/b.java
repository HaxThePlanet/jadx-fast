package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;

/* loaded from: classes2.dex */
public final class b {
    b(Context context) {
        super();
    }

    public static final boolean a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return 1;
        }
        return 0;
    }
}
