package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: classes2.dex */
final class a6 extends ContentObserver {

    final com.google.android.gms.internal.measurement.c6 a;
    a6(com.google.android.gms.internal.measurement.c6 c6, Handler handler2) {
        this.a = c6;
        super(0);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.a.f();
    }
}
