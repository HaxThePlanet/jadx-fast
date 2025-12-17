package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.e;
import com.bumptech.glide.h;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.engine.a0.a.a;
import com.bumptech.glide.load.engine.a0.b;
import com.bumptech.glide.load.engine.a0.h;
import com.bumptech.glide.load.engine.a0.h.a;
import com.bumptech.glide.load.engine.b0.a;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.l;
import com.bumptech.glide.r.h;
import com.bumptech.glide.t.g;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.m.a;
import d.h.k.f;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class k implements com.bumptech.glide.load.engine.m, h.a, com.bumptech.glide.load.engine.p.a {

    private static final boolean i;
    private final com.bumptech.glide.load.engine.r a;
    private final com.bumptech.glide.load.engine.o b;
    private final h c;
    private final com.bumptech.glide.load.engine.k.b d;
    private final com.bumptech.glide.load.engine.x e;
    private final com.bumptech.glide.load.engine.k.c f;
    private final com.bumptech.glide.load.engine.k.a g;
    private final com.bumptech.glide.load.engine.a h;

    static class a {

        final com.bumptech.glide.load.engine.h.e a;
        final f<com.bumptech.glide.load.engine.h<?>> b;
        private int c;
        a(com.bumptech.glide.load.engine.h.e h$e) {
            super();
            k.a.a aVar = new k.a.a(this);
            this.b = a.d(150, aVar);
            this.a = e;
        }

        <R> com.bumptech.glide.load.engine.h<R> a(e e, Object object2, com.bumptech.glide.load.engine.n n3, f f4, int i5, int i6, Class<?> class7, Class<R> class8, h h9, com.bumptech.glide.load.engine.j j10, Map<Class<?>, l<?>> map11, boolean z12, boolean z13, boolean z14, h h15, com.bumptech.glide.load.engine.h.b<R> h$b16) {
            final Object obj = this;
            Object obj2 = obj.b.b();
            k.d((h)obj2);
            final Object obj6 = obj2;
            int i = obj.c;
            obj.c = i++;
            (h)obj6.s(e, object2, n3, f4, i5, i6, class7, class8, h9, j10, map11, z12, z13, z14, h15, b16, i);
            return obj6;
        }
    }

    static class b {

        final a a;
        final a b;
        final a c;
        final a d;
        final com.bumptech.glide.load.engine.m e;
        final com.bumptech.glide.load.engine.p.a f;
        final f<com.bumptech.glide.load.engine.l<?>> g;
        b(a a, a a2, a a3, a a4, com.bumptech.glide.load.engine.m m5, com.bumptech.glide.load.engine.p.a p$a6) {
            super();
            k.b.a aVar = new k.b.a(this);
            this.g = a.d(150, aVar);
            this.a = a;
            this.b = a2;
            this.c = a3;
            this.d = a4;
            this.e = m5;
            this.f = a6;
        }

        <R> com.bumptech.glide.load.engine.l<R> a(f f, boolean z2, boolean z3, boolean z4, boolean z5) {
            Object obj = this.g.b();
            k.d((l)obj);
            (l)obj.l(f, z2, z3, z4, z5);
            return obj;
        }
    }

    public class d {

        private final com.bumptech.glide.load.engine.l<?> a;
        private final h b;
        final com.bumptech.glide.load.engine.k c;
        d(com.bumptech.glide.load.engine.k k, h h2, com.bumptech.glide.load.engine.l l3) {
            this.c = k;
            super();
            this.b = h2;
            this.a = l3;
        }

        public void a() {
            final com.bumptech.glide.load.engine.k kVar = this.c;
            this.a.r(this.b);
            return;
            synchronized (kVar) {
                kVar = this.c;
                this.a.r(this.b);
            }
        }
    }

    private static class c implements com.bumptech.glide.load.engine.h.e {

        private final a.a a;
        private volatile a b;
        c(a.a a$a) {
            super();
            this.a = a;
        }

        @Override // com.bumptech.glide.load.engine.h$e
        public a a() {
            a bVar;
            a build;
            if (this.b == null && this.b == null) {
                synchronized (this) {
                    this.b = this.a.build();
                    if (this.b == null) {
                        bVar = new b();
                        this.b = bVar;
                    }
                    try {
                        throw th;
                        return this.b;
                    }
                }
            }
        }
    }
    static {
        k.i = Log.isLoggable("Engine", 2);
    }

    k(h h, a.a a$a2, a a3, a a4, a a5, a a6, com.bumptech.glide.load.engine.r r7, com.bumptech.glide.load.engine.o o8, com.bumptech.glide.load.engine.a a9, com.bumptech.glide.load.engine.k.b k$b10, com.bumptech.glide.load.engine.k.a k$a11, com.bumptech.glide.load.engine.x x12, boolean z13) {
        com.bumptech.glide.load.engine.a aVar3;
        com.bumptech.glide.load.engine.o oVar;
        com.bumptech.glide.load.engine.r rVar;
        com.bumptech.glide.load.engine.k.a aVar2;
        com.bumptech.glide.load.engine.x xVar;
        boolean z;
        a aVar;
        a aVar4;
        a aVar5;
        com.bumptech.glide.load.engine.p.a aVar6;
        com.bumptech.glide.load.engine.p.a aVar7;
        com.bumptech.glide.load.engine.k.b bVar;
        final Object obj = this;
        super();
        obj.c = h;
        a.a aVar8 = a2;
        k.c cVar = new k.c(a2);
        obj.f = cVar;
        if (a9 == null) {
            aVar3 = new a(z13);
        } else {
            aVar3 = a9;
        }
        obj.h = aVar3;
        aVar3.f(this);
        if (o8 == null) {
            oVar = new o();
        } else {
            oVar = o8;
        }
        obj.b = oVar;
        if (r7 == null) {
            rVar = new r();
        } else {
            rVar = r7;
        }
        obj.a = rVar;
        if (b10 == null) {
            super(a3, a4, a5, a6, this, this);
        } else {
            bVar = b10;
        }
        obj.d = bVar;
        if (a11 == null) {
            aVar2 = new k.a(cVar);
        } else {
            aVar2 = a11;
        }
        obj.g = aVar2;
        if (x12 == null) {
            xVar = new x();
        } else {
            xVar = x12;
        }
        obj.e = xVar;
        h.e(this);
    }

    public k(h h, a.a a$a2, a a3, a a4, a a5, a a6, boolean z7) {
        super(h, a2, a3, a4, a5, a6, 0, 0, 0, 0, 0, 0, z7);
    }

    private com.bumptech.glide.load.engine.p<?> e(f f) {
        h pVar2;
        com.bumptech.glide.load.engine.p pVar;
        int i2;
        int i;
        f fVar;
        Object obj;
        int obj8;
        final com.bumptech.glide.load.engine.u uVar = this.c.d(f);
        if (uVar == null) {
            obj8 = 0;
        } else {
            if (uVar instanceof p) {
                obj8 = uVar;
            } else {
                super(uVar, 1, 1, f, this);
                obj8 = pVar2;
            }
        }
        return obj8;
    }

    private com.bumptech.glide.load.engine.p<?> g(f f) {
        final com.bumptech.glide.load.engine.p obj2 = this.h.e(f);
        if (obj2 != null) {
            obj2.c();
        }
        return obj2;
    }

    private com.bumptech.glide.load.engine.p<?> h(f f) {
        com.bumptech.glide.load.engine.a aVar;
        final com.bumptech.glide.load.engine.p pVar = e(f);
        if (pVar != null) {
            pVar.c();
            this.h.a(f, pVar);
        }
        return pVar;
    }

    private com.bumptech.glide.load.engine.p<?> i(com.bumptech.glide.load.engine.n n, boolean z2, long l3) {
        boolean str;
        boolean str2;
        int i = 0;
        if (!z2) {
            return i;
        }
        com.bumptech.glide.load.engine.p obj3 = g(n);
        if (obj3 != null && k.i) {
            if (k.i) {
                k.j("Loaded resource from active resources", l3, obj5);
            }
            return obj3;
        }
        obj3 = h(n);
        if (obj3 != null && k.i) {
            if (k.i) {
                k.j("Loaded resource from cache", l3, obj5);
            }
            return obj3;
        }
        return i;
    }

    private static void j(String string, long l2, f f3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" in ");
        stringBuilder.append(g.a(l2));
        stringBuilder.append("ms, key: ");
        stringBuilder.append(obj4);
        Log.v("Engine", stringBuilder.toString());
    }

    private <R> com.bumptech.glide.load.engine.k.d l(e e, Object object2, f f3, int i4, int i5, Class<?> class6, Class<R> class7, h h8, com.bumptech.glide.load.engine.j j9, Map<Class<?>, l<?>> map10, boolean z11, boolean z12, h h13, boolean z14, boolean z15, boolean z16, boolean z17, h h18, Executor executor19, com.bumptech.glide.load.engine.n n20, long l21) {
        boolean str;
        boolean str2;
        Object nVar;
        final Object obj = this;
        h hVar = h18;
        f fVar5 = n20;
        com.bumptech.glide.load.engine.l lVar2 = obj.a.a(fVar5, z17);
        lVar2.b(hVar, executor19);
        if (lVar2 != null && k.i) {
            lVar2.b(hVar, executor);
            if (k.i) {
                k.j("Added to existing load", l21, obj14);
            }
            k.d dVar = new k.d(obj, hVar, lVar2);
            return dVar;
        }
        com.bumptech.glide.load.engine.l lVar4 = obj.d.a(n20, z14, z15, z16, z17);
        f fVar4 = f3;
        com.bumptech.glide.load.engine.l lVar = lVar4;
        f fVar = fVar5;
        obj.a.c(fVar, lVar);
        com.bumptech.glide.load.engine.l lVar3 = lVar;
        h hVar2 = h18;
        lVar3.b(hVar2, executor19);
        lVar3.s(obj.g.a(e, object2, n20, fVar4, i4, i5, class6, class7, h8, j9, map10, z11, z12, z17, h13, lVar4));
        if (k.i) {
            k.j("Started new load", l21, fVar4);
        }
        k.d dVar2 = new k.d(obj, hVar2, lVar3);
        return dVar2;
    }

    public void a(com.bumptech.glide.load.engine.u<?> u) {
        this.e.a(u, true);
    }

    public void b(com.bumptech.glide.load.engine.l<?> l, f f2, com.bumptech.glide.load.engine.p<?> p3) {
        boolean z;
        synchronized (this) {
            if (p3.e()) {
                this.h.a(f2, p3);
            }
            try {
                this.a.d(f2, l);
                throw l;
            }
        }
    }

    public void c(com.bumptech.glide.load.engine.l<?> l, f f2) {
        this.a.d(f2, l);
        return;
        synchronized (this) {
            this.a.d(f2, l);
        }
    }

    public void d(f f, com.bumptech.glide.load.engine.p<?> p2) {
        h hVar;
        Object obj2;
        this.h.d(f);
        if (p2.e()) {
            this.c.c(f, p2);
        } else {
            this.e.a(p2, false);
        }
    }

    public <R> com.bumptech.glide.load.engine.k.d f(e e, Object object2, f f3, int i4, int i5, Class<?> class6, Class<R> class7, h h8, com.bumptech.glide.load.engine.j j9, Map<Class<?>, l<?>> map10, boolean z11, boolean z12, h h13, boolean z14, boolean z15, boolean z16, boolean z17, h h18, Executor executor19) {
        long l;
        Object obj4 = this;
        if (k.i) {
            l = g.b();
        } else {
            l = 0;
        }
        long l2 = l;
        com.bumptech.glide.load.engine.n nVar = obj4.b.a(object2, f3, i4, i5, map10, class6, class7, h13);
        com.bumptech.glide.load.engine.p pVar = obj4.i(nVar, z14, l2);
        synchronized (this) {
            return this.l(e, object2, f3, i4, i5, class6, class7, h8, j9, map10, z11, z12, h13, z14, z15, z16, z17, h18, executor19, nVar, l2);
        }
    }

    public void k(com.bumptech.glide.load.engine.u<?> u) {
        if (!u instanceof p) {
        } else {
            (p)u.f();
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Cannot release anything but an EngineResource");
        throw obj2;
    }
}
