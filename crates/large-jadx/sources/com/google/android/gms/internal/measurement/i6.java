package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: classes2.dex */
final class i6 extends ContentObserver {
    i6(com.google.android.gms.internal.measurement.j6 j6, Handler handler2) {
        super(0);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        w6.e();
    }
}
