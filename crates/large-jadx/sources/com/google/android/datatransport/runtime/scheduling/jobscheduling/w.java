package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a;
import f.c.a.b.i.a0.j.i0;
import f.c.a.b.i.w.b.b;
import j.a.a;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class w implements b<com.google.android.datatransport.runtime.scheduling.jobscheduling.v> {

    private final a<Executor> a;
    private final a<i0> b;
    private final a<com.google.android.datatransport.runtime.scheduling.jobscheduling.x> c;
    private final a<a> d;
    public w(a<Executor> a, a<i0> a2, a<com.google.android.datatransport.runtime.scheduling.jobscheduling.x> a3, a<a> a4) {
        super();
        this.a = a;
        this.b = a2;
        this.c = a3;
        this.d = a4;
    }

    public static com.google.android.datatransport.runtime.scheduling.jobscheduling.w a(a<Executor> a, a<i0> a2, a<com.google.android.datatransport.runtime.scheduling.jobscheduling.x> a3, a<a> a4) {
        w wVar = new w(a, a2, a3, a4);
        return wVar;
    }

    public static com.google.android.datatransport.runtime.scheduling.jobscheduling.v c(Executor executor, i0 i02, com.google.android.datatransport.runtime.scheduling.jobscheduling.x x3, a a4) {
        v vVar = new v(executor, i02, x3, a4);
        return vVar;
    }

    @Override // f.c.a.b.i.w.b.b
    public com.google.android.datatransport.runtime.scheduling.jobscheduling.v b() {
        return w.c((Executor)this.a.get(), (i0)this.b.get(), (x)this.c.get(), (a)this.d.get());
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return b();
    }
}
