package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class o6 implements Runnable {

    final String a;
    final String b;
    final Object c;
    final long v;
    final com.google.android.gms.measurement.internal.i7 w;
    o6(com.google.android.gms.measurement.internal.i7 i7, String string2, String string3, Object object4, long l5) {
        this.w = i7;
        this.a = string2;
        this.b = string3;
        this.c = object4;
        this.v = l5;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.w.N(this.a, this.b, this.c, this.v);
    }
}
