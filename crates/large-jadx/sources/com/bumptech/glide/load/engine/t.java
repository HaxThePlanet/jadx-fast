package com.bumptech.glide.load.engine;

import com.bumptech.glide.t.k;
import com.bumptech.glide.t.m.a;
import com.bumptech.glide.t.m.a.d;
import com.bumptech.glide.t.m.a.f;
import com.bumptech.glide.t.m.c;
import d.h.k.f;

/* loaded from: classes.dex */
final class t<Z>  implements com.bumptech.glide.load.engine.u<Z>, a.f {

    private static final f<com.bumptech.glide.load.engine.t<?>> w;
    private final c a;
    private com.bumptech.glide.load.engine.u<Z> b;
    private boolean c;
    private boolean v;

    class a implements a.d<com.bumptech.glide.load.engine.t<?>> {
        @Override // com.bumptech.glide.t.m.a$d
        public Object a() {
            return b();
        }

        public com.bumptech.glide.load.engine.t<?> b() {
            t tVar = new t();
            return tVar;
        }
    }
    static {
        t.a aVar = new t.a();
        t.w = a.d(20, aVar);
    }

    t() {
        super();
        this.a = c.a();
    }

    private void c(com.bumptech.glide.load.engine.u<Z> u) {
        this.v = false;
        this.c = true;
        this.b = u;
    }

    static <Z> com.bumptech.glide.load.engine.t<Z> d(com.bumptech.glide.load.engine.u<Z> u) {
        Object obj = t.w.b();
        k.d((t)obj);
        (t)obj.c(u);
        return obj;
    }

    private void e() {
        this.b = 0;
        t.w.a(this);
    }

    @Override // com.bumptech.glide.load.engine.u
    public void a() {
        boolean z;
        this.a.c();
        this.v = true;
        synchronized (this) {
            try {
                this.b.a();
                e();
                throw th;
            }
        }
    }

    public Class<Z> b() {
        return this.b.b();
    }

    @Override // com.bumptech.glide.load.engine.u
    public c f() {
        return this.a;
    }

    @Override // com.bumptech.glide.load.engine.u
    void g() {
        this.a.c();
        synchronized (this) {
            try {
                this.c = false;
                if (this.v) {
                }
                a();
                IllegalStateException illegalStateException = new IllegalStateException("Already unlocked");
                throw illegalStateException;
                throw th;
            }
        }
    }

    public Z get() {
        return this.b.get();
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return this.b.getSize();
    }
}
