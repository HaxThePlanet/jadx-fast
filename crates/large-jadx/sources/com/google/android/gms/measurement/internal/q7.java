package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes2.dex */
final class q7 implements Runnable {

    final Bundle a;
    final com.google.android.gms.measurement.internal.p7 b;
    final com.google.android.gms.measurement.internal.p7 c;
    final long v;
    final com.google.android.gms.measurement.internal.w7 w;
    q7(com.google.android.gms.measurement.internal.w7 w7, Bundle bundle2, com.google.android.gms.measurement.internal.p7 p73, com.google.android.gms.measurement.internal.p7 p74, long l5) {
        this.w = w7;
        this.a = bundle2;
        this.b = p73;
        this.c = p74;
        this.v = l5;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        w7.x(this.w, this.a, this.b, this.c, this.v);
    }
}
