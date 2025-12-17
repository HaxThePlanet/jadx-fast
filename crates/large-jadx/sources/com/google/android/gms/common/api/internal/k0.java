package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.b;
import java.util.Map;

/* loaded from: classes2.dex */
final class k0 implements Runnable {

    final b a;
    final com.google.android.gms.common.api.internal.l0 b;
    k0(com.google.android.gms.common.api.internal.l0 l0, b b2) {
        this.b = l0;
        this.a = b2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = g.h(l0Var.f).get(l0.d(this.b));
        if ((i0)obj == null) {
        }
        final int i = 0;
        l0.e(this.b, true);
        if (this.a.n2() && l0.f(this.b).requiresSignIn()) {
            l0.e(this.b, true);
            if (l0.f(this.b).requiresSignIn()) {
                l0.g(this.b);
            }
            l0.f(this.b).getRemoteService(i, l0.f(this.b).getScopesForConnectionlessNonSignIn());
        }
        (i0)obj.s(this.a, i);
    }
}
