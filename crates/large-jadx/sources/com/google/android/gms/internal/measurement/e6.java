package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* loaded from: classes2.dex */
public final class e6 {
    public static <V> V a(com.google.android.gms.internal.measurement.f6<V> f6) {
        long clearCallingIdentity;
        Object obj2;
        try {
            obj2 = f6.zza();
            clearCallingIdentity = Binder.clearCallingIdentity();
            f6 = f6.zza();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return obj2;
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw f6;
        } catch (Throwable th) {
        }
    }
}
