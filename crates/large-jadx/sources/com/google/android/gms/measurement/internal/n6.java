package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes2.dex */
final class n6 implements Runnable {

    final com.google.android.gms.measurement.internal.i7 A;
    final String a;
    final String b;
    final long c;
    final Bundle v;
    final boolean w;
    final boolean x;
    final boolean y;
    final String z;
    n6(com.google.android.gms.measurement.internal.i7 i7, String string2, String string3, long l4, Bundle bundle5, boolean z6, boolean z7, boolean z8, String string9) {
        this.A = i7;
        this.a = string2;
        this.b = string3;
        this.c = l4;
        this.v = z6;
        this.w = z7;
        this.x = z8;
        this.y = string9;
        this.z = obj10;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.A.w(this.a, this.b, this.c, obj4, this.v, this.w, this.x, this.y);
    }
}
