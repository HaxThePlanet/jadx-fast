package com.google.android.gms.common.api.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.c.e;

/* loaded from: classes2.dex */
final class h0 implements c.e {

    final com.google.android.gms.common.api.internal.i0 a;
    h0(com.google.android.gms.common.api.internal.i0 i0) {
        this.a = i0;
        super();
    }

    @Override // com.google.android.gms.common.internal.c$e
    public final void a() {
        g0 g0Var = new g0(this);
        g.D(i0Var.m).post(g0Var);
    }
}
