package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.d.a;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.s0;
import f.c.a.d.e.a;
import f.c.a.d.e.b.d;
import f.c.a.d.e.b.l;
import f.c.a.d.e.f;
import f.c.a.d.e.g;
import java.util.Set;

/* loaded from: classes2.dex */
public final class a1 extends d implements d.a, d.b {

    private static final a.a<? extends g, a> h;
    private final Context a;
    private final Handler b;
    private final a.a<? extends g, a> c;
    private final Set<Scope> d;
    private final d e;
    private g f;
    private com.google.android.gms.common.api.internal.z0 g;
    static {
        a1.h = f.c;
    }

    public a1(Context context, Handler handler2, d d3) {
        super();
        this.a = context;
        this.b = handler2;
        r.k(d3, "ClientSettings must not be null");
        this.e = (d)d3;
        this.d = d3.g();
        this.c = a1.h;
    }

    static com.google.android.gms.common.api.internal.z0 s2(com.google.android.gms.common.api.internal.a1 a1) {
        return a1.g;
    }

    static void t2(com.google.android.gms.common.api.internal.a1 a1, l l2) {
        b bVar;
        boolean exception;
        String str;
        String obj4;
        if (l2.j2().n2()) {
            obj4 = l2.k2();
            r.j(obj4);
            bVar = (s0)obj4.k2();
            if (!bVar.n2()) {
                obj4 = String.valueOf(bVar);
                StringBuilder stringBuilder = new StringBuilder(length += 48);
                stringBuilder.append("Sign-in succeeded with resolve account failure: ");
                stringBuilder.append(obj4);
                exception = new Exception();
                Log.wtf("SignInCoordinator", stringBuilder.toString(), exception);
                a1.g.c(bVar);
            } else {
                a1.g.b(obj4.j2(), a1.d);
            }
        } else {
        }
        a1.f.disconnect();
    }

    @Override // f.c.a.d.e.b.d
    public final void U(l l) {
        y0 y0Var = new y0(this, l);
        this.b.post(y0Var);
    }

    @Override // f.c.a.d.e.b.d
    public final void j(int i) {
        this.f.disconnect();
    }

    @Override // f.c.a.d.e.b.d
    public final void m(b b) {
        this.g.c(b);
    }

    @Override // f.c.a.d.e.b.d
    public final void n(Bundle bundle) {
        this.f.b(this);
    }

    @Override // f.c.a.d.e.b.d
    public final void q2(com.google.android.gms.common.api.internal.z0 z0) {
        Set obj10;
        g gVar = this.f;
        if (gVar != null) {
            gVar.disconnect();
        }
        this.e.k(Integer.valueOf(System.identityHashCode(this)));
        final d dVar2 = this.e;
        this.f = this.c.buildClient(this.a, this.b.getLooper(), dVar2, dVar2.i(), this, this);
        this.g = z0;
        obj10 = this.d;
        if (obj10 != null && obj10.isEmpty()) {
            if (obj10.isEmpty()) {
            }
            this.f.a();
        }
        x0 x0Var = new x0(this);
        this.b.post(x0Var);
    }

    @Override // f.c.a.d.e.b.d
    public final void r2() {
        final g gVar = this.f;
        if (gVar != null) {
            gVar.disconnect();
        }
    }
}
