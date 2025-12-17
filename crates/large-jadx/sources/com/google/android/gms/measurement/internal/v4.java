package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class v4 implements java.lang.Thread.UncaughtExceptionHandler {

    private final String a;
    final com.google.android.gms.measurement.internal.y4 b;
    public v4(com.google.android.gms.measurement.internal.y4 y4, String string2) {
        this.b = y4;
        super();
        r.j(string2);
        this.a = string2;
    }

    @Override // java.lang.Thread$UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable throwable2) {
        obj2.a.b().r().b(this.a, throwable2);
        return;
        synchronized (this) {
            obj2.a.b().r().b(this.a, throwable2);
        }
    }
}
