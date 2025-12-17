package com.google.android.gms.measurement.internal;

import java.util.Map;

/* loaded from: classes2.dex */
public final class k7 implements Runnable {

    public final com.google.android.gms.measurement.internal.l7 a;
    public final int b;
    public final Exception c;
    public final byte[] v;
    public final Map w;
    public k7(com.google.android.gms.measurement.internal.l7 l7, int i2, Exception exception3, byte[] b4Arr4, Map map5) {
        super();
        this.a = l7;
        this.b = i2;
        this.c = exception3;
        this.v = b4Arr4;
        this.w = map5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.b, this.c, this.v, this.w);
    }
}
