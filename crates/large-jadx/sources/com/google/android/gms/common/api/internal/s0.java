package com.google.android.gms.common.api.internal;

import android.os.IBinder;

/* loaded from: classes2.dex */
final class s0 implements Runnable {

    private final com.google.android.gms.common.api.internal.l a;
    private final IBinder b;
    s0(com.google.android.gms.common.api.internal.l l, IBinder iBinder2) {
        super();
        this.a = l;
        this.b = iBinder2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.e(this.b);
    }
}
