package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.load.engine.a0.a.a;
import com.bumptech.glide.load.engine.a0.f;
import com.bumptech.glide.load.engine.a0.g;
import com.bumptech.glide.load.engine.a0.h;
import com.bumptech.glide.load.engine.a0.i;
import com.bumptech.glide.load.engine.a0.i.a;
import com.bumptech.glide.load.engine.b0.a;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.engine.z.f;
import com.bumptech.glide.load.engine.z.j;
import com.bumptech.glide.load.engine.z.k;
import com.bumptech.glide.o.d;
import com.bumptech.glide.o.f;
import com.bumptech.glide.o.p;
import com.bumptech.glide.o.p.b;
import com.bumptech.glide.r.f;
import com.bumptech.glide.r.g;
import d.e.a;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class d {

    private final Map<Class<?>, com.bumptech.glide.l<?, ?>> a;
    private final com.bumptech.glide.f.a b;
    private k c;
    private e d;
    private b e;
    private h f;
    private a g;
    private a h;
    private a.a i;
    private i j;
    private d k;
    private int l = 4;
    private com.bumptech.glide.c.a m;
    private p.b n;
    private a o;
    private boolean p;
    private List<f<Object>> q;

    static final class b {
    }

    static final class c {
    }

    public static final class d {
    }

    public static final class e {
    }

    class a implements com.bumptech.glide.c.a {
        a(com.bumptech.glide.d d) {
            super();
        }

        @Override // com.bumptech.glide.c$a
        public g build() {
            g gVar = new g();
            return gVar;
        }
    }
    public d() {
        super();
        a aVar = new a();
        this.a = aVar;
        f.a aVar2 = new f.a();
        this.b = aVar2;
        int i = 4;
        d.a aVar3 = new d.a(this);
        this.m = aVar3;
    }

    com.bumptech.glide.c a(Context context) {
        a aVar8;
        a aVar7;
        a aVar2;
        i iVar;
        d fVar3;
        e fVar;
        b jVar;
        h gVar;
        a.a fVar2;
        k kVar;
        List unmodifiableList;
        k kVar2;
        long l;
        a.a aVar5;
        a aVar;
        a aVar3;
        a aVar6;
        a aVar4;
        boolean z;
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
            i.a aVar9 = new i.a(context);
            this.j = aVar9.a();
        }
        if (this.k == null) {
            fVar3 = new f();
            this.k = fVar3;
        }
        if (this.d == null) {
            fVar = this.j.b();
            if (fVar > 0) {
                kVar2 = new k((long)fVar, obj3);
                this.d = kVar2;
            } else {
                fVar = new f();
                this.d = fVar;
            }
        }
        if (this.e == null) {
            jVar = new j(this.j.a());
            this.e = jVar;
        }
        if (this.f == null) {
            gVar = new g((long)i, l);
            this.f = gVar;
        }
        if (this.i == null) {
            fVar2 = new f(context);
            this.i = fVar2;
        }
        if (this.c == null) {
            super(this.f, this.i, this.h, this.g, a.h(), this.o, this.p);
            this.c = kVar;
        }
        List list = this.q;
        if (list == null) {
            this.q = Collections.emptyList();
        } else {
            this.q = Collections.unmodifiableList(list);
        }
        final com.bumptech.glide.f fVar4 = this.b.b();
        p pVar = new p(this.n, fVar4);
        super(context, this.c, this.f, this.d, this.e, pVar, this.k, this.l, this.m, this.a, this.q, fVar4);
        return cVar;
    }

    public com.bumptech.glide.d b(a.a a$a) {
        this.i = a;
        return this;
    }

    void c(p.b p$b) {
        this.n = b;
    }
}
