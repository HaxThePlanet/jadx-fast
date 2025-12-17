package com.google.android.gms.common.api.internal;

import f.c.a.d.e.b.l;

/* loaded from: classes2.dex */
final class y0 implements Runnable {

    final l a;
    final com.google.android.gms.common.api.internal.a1 b;
    y0(com.google.android.gms.common.api.internal.a1 a1, l l2) {
        this.b = a1;
        this.a = l2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a1.t2(this.b, this.a);
    }
}
