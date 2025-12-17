package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* loaded from: classes2.dex */
public final class y8 implements Runnable {

    public final com.google.android.gms.measurement.internal.c9 a;
    public final int b;
    public final com.google.android.gms.measurement.internal.q3 c;
    public final Intent v;
    public y8(com.google.android.gms.measurement.internal.c9 c9, int i2, com.google.android.gms.measurement.internal.q3 q33, Intent intent4) {
        super();
        this.a = c9;
        this.b = i2;
        this.c = q33;
        this.v = intent4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c(this.b, this.c, this.v);
    }
}
