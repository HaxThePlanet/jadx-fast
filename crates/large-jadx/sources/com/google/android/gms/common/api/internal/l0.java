package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.c.c;
import com.google.android.gms.common.internal.k;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
final class l0 implements c.c, com.google.android.gms.common.api.internal.z0 {

    private final a.f a;
    private final com.google.android.gms.common.api.internal.c<?> b;
    private k c = null;
    private Set<Scope> d = null;
    private boolean e = false;
    final com.google.android.gms.common.api.internal.g f;
    public l0(com.google.android.gms.common.api.internal.g g, a.f a$f2, com.google.android.gms.common.api.internal.c c3) {
        this.f = g;
        super();
        int obj1 = 0;
        obj1 = 0;
        this.a = f2;
        this.b = c3;
    }

    static com.google.android.gms.common.api.internal.c d(com.google.android.gms.common.api.internal.l0 l0) {
        return l0.b;
    }

    static boolean e(com.google.android.gms.common.api.internal.l0 l0, boolean z2) {
        final int obj1 = 1;
        l0.e = obj1;
        return obj1;
    }

    static a.f f(com.google.android.gms.common.api.internal.l0 l0) {
        return l0.a;
    }

    static void g(com.google.android.gms.common.api.internal.l0 l0) {
        l0.h();
    }

    private final void h() {
        boolean z;
        a.f fVar;
        Set set;
        z = this.c;
        if (this.e && z != null) {
            z = this.c;
            if (z != null) {
                this.a.getRemoteService(z, this.d);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.c$c
    public final void a(b b) {
        k0 k0Var = new k0(this, b);
        g.D(this.f).post(k0Var);
    }

    public final void b(k k, Set<Scope> set2) {
        if (k != null && set2 == null) {
            if (set2 == null) {
            }
            this.c = k;
            this.d = set2;
            h();
        }
        Exception obj2 = new Exception();
        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", obj2);
        obj2 = new b(4);
        c(obj2);
    }

    @Override // com.google.android.gms.common.internal.c$c
    public final void c(b b) {
        Object obj = g.h(this.f).get(this.b);
        if ((i0)obj != null) {
            (i0)obj.r(b);
        }
    }
}
