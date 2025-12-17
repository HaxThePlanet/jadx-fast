package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a.f;

/* loaded from: classes2.dex */
final class g0 implements Runnable {

    final com.google.android.gms.common.api.internal.h0 a;
    g0(com.google.android.gms.common.api.internal.h0 h0) {
        this.a = h0;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        i0.a(h0Var.a).disconnect(String.valueOf(i0.a(h0Var2.a).getClass().getName()).concat(" disconnecting because it was signed out."));
    }
}
