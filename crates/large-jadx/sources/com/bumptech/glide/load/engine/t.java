package com.bumptech.glide.load.engine;

import com.bumptech.glide.t.k;
import com.bumptech.glide.t.m.a;
import com.bumptech.glide.t.m.a.d;
import com.bumptech.glide.t.m.a.f;
import com.bumptech.glide.t.m.c;
import d.h.k.f;

/* compiled from: LockedResource.java */
/* loaded from: classes.dex */
final class t<Z> implements u<Z>, a.f {

    private static final f<t<?>> w;
    private final c a;
    private u<Z> b;
    private boolean c;
    private boolean v;

    class a implements a.d<t<?>> {
        a() {
            super();
        }

        public t<?> b() {
            return new t();
        }
    }
    static {
        t.w = a.d(20, new t.a());
    }

    t() {
        super();
        this.a = c.a();
    }

    private void c(u<Z> uVar) {
        this.v = false;
        this.c = true;
        this.b = uVar;
    }

    static <Z> t<Z> d(u<Z> uVar) {
        Object obj = t.w.b();
        k.d(obj);
        obj.c(uVar);
        return obj;
    }

    private void e() {
        this.b = null;
        t.w.a(this);
    }

    public synchronized void a() {
        this.a.c();
        this.v = true;
        if (!this.c) {
            this.b.a();
            e();
        }
    }

    public Class<Z> b() {
        return this.b.b();
    }

    public c f() {
        return this.a;
    }

    synchronized void g() {
        this.a.c();
        this.c = false;
        if (this.v) {
            a();
        }
        throw new IllegalStateException("Already unlocked");
    }

    public Z get() {
        return this.b.get();
    }

    public int getSize() {
        return this.b.getSize();
    }
}
