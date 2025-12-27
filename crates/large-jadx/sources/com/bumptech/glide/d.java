package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.load.engine.a0.a.a;
import com.bumptech.glide.load.engine.a0.h;
import com.bumptech.glide.load.engine.a0.i;
import com.bumptech.glide.load.engine.a0.i.a;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.engine.z.j;
import com.bumptech.glide.o.d;
import com.bumptech.glide.o.p;
import com.bumptech.glide.o.p.b;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: GlideBuilder.java */
/* loaded from: classes.dex */
public final class d {

    private final Map<Class<?>, l<?, ?>> a = new a<>();
    private final f.a b = new f$a();
    private com.bumptech.glide.load.engine.k c;
    private e d;
    private b e;
    private h f;
    private com.bumptech.glide.load.engine.b0.a g;
    private com.bumptech.glide.load.engine.b0.a h;
    private a.a i;
    private i j;
    private d k;
    private int l = 4;
    private c.a m = new d$a();
    private p.b n;
    private com.bumptech.glide.load.engine.b0.a o;
    private boolean p;
    private List<com.bumptech.glide.r.f<Object>> q;

    static final class b {
        b() {
            super();
        }
    }

    static final class c {
        c() {
            super();
        }
    }

    public static final class d {
    }

    public static final class e {
        private e() {
            super();
        }
    }

    class a implements c.a {
        a() {
            super();
        }

        public com.bumptech.glide.r.g build() {
            return new g();
        }
    }
    public d() {
        super();
        d.e.a aVar = new a();
        com.bumptech.glide.f.a aVar2 = new f.a();
        com.bumptech.glide.d.a aVar3 = new d.a(this);
    }

    c a(Context context) {
        com.bumptech.glide.load.engine.z.k kVar2;
        long l;
        if (this.g == null) {
            this.g = a.g();
        }
        if (this.h == null) {
            this.h = a.e();
        }
        if (this.o == null) {
            this.o = a.c();
        }
        if (this.j == null) {
            this.j = new i.a(context).a();
        }
        if (this.k == null) {
            this.k = new f();
        }
        if (this.d == null) {
            int i = this.j.b();
            if (i > 0) {
                l = (long)i;
                this.d = new k(l, r3);
            } else {
                this.d = new f();
            }
        }
        if (this.e == null) {
            this.e = new j(this.j.a());
        }
        if (this.f == null) {
            this.f = new g((long)this.j.d(), l);
        }
        if (this.i == null) {
            this.i = new f(context);
        }
        if (this.c == null) {
            k kVar = new k(this.f, this.i, this.h, this.g, a.h(), this.o, this.p);
            this.c = kVar;
        }
        if (this.q == null) {
            this.q = Collections.emptyList();
        } else {
            this.q = Collections.unmodifiableList(this.q);
        }
        final com.bumptech.glide.f fVar4 = this.b.b();
        c cVar = new c(context, this.c, this.f, this.d, this.e, new p(this.n, fVar4), this.k, this.l, this.m, this.a, this.q, fVar4);
        return cVar;
    }

    public d b(a.a aVar) {
        this.i = aVar;
        return this;
    }

    void c(p.b bVar) {
        this.n = bVar;
    }
}
