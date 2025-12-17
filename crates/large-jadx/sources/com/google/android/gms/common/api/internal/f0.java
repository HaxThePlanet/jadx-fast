package com.google.android.gms.common.api.internal;

/* loaded from: classes2.dex */
final class f0 implements Runnable {

    final int a;
    final com.google.android.gms.common.api.internal.i0 b;
    f0(com.google.android.gms.common.api.internal.i0 i0, int i2) {
        this.b = i0;
        this.a = i2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        i0.P(this.b, this.a);
    }
}
