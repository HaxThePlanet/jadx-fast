package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.synchronization.a;
import f.c.a.b.i.a0.j.h0;
import f.c.a.b.i.a0.j.i0;
import f.c.a.b.i.b0.a;
import f.c.a.b.i.w.b.b;
import j.a.a;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class u implements b<com.google.android.datatransport.runtime.scheduling.jobscheduling.t> {

    private final a<Context> a;
    private final a<e> b;
    private final a<i0> c;
    private final a<com.google.android.datatransport.runtime.scheduling.jobscheduling.x> d;
    private final a<Executor> e;
    private final a<a> f;
    private final a<a> g;
    private final a<a> h;
    private final a<h0> i;
    public u(a<Context> a, a<e> a2, a<i0> a3, a<com.google.android.datatransport.runtime.scheduling.jobscheduling.x> a4, a<Executor> a5, a<a> a6, a<a> a7, a<a> a8, a<h0> a9) {
        super();
        this.a = a;
        this.b = a2;
        this.c = a3;
        this.d = a4;
        this.e = a5;
        this.f = a6;
        this.g = a7;
        this.h = a8;
        this.i = a9;
    }

    public static com.google.android.datatransport.runtime.scheduling.jobscheduling.u a(a<Context> a, a<e> a2, a<i0> a3, a<com.google.android.datatransport.runtime.scheduling.jobscheduling.x> a4, a<Executor> a5, a<a> a6, a<a> a7, a<a> a8, a<h0> a9) {
        super(a, a2, a3, a4, a5, a6, a7, a8, a9);
        return uVar2;
    }

    public static com.google.android.datatransport.runtime.scheduling.jobscheduling.t c(Context context, e e2, i0 i03, com.google.android.datatransport.runtime.scheduling.jobscheduling.x x4, Executor executor5, a a6, a a7, a a8, h0 h09) {
        super(context, e2, i03, x4, executor5, a6, a7, a8, h09);
        return tVar2;
    }

    @Override // f.c.a.b.i.w.b.b
    public com.google.android.datatransport.runtime.scheduling.jobscheduling.t b() {
        return u.c((Context)this.a.get(), (e)this.b.get(), (i0)this.c.get(), (x)this.d.get(), (Executor)this.e.get(), (a)this.f.get(), (a)this.g.get(), (a)this.h.get(), (h0)this.i.get());
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return b();
    }
}
