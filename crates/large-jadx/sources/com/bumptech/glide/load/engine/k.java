package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.e;
import com.bumptech.glide.load.engine.a0.a.a;
import com.bumptech.glide.load.engine.a0.b;
import com.bumptech.glide.load.engine.a0.h.a;
import com.bumptech.glide.load.l;
import com.bumptech.glide.t.g;
import com.bumptech.glide.t.k;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: Engine.java */
/* loaded from: classes.dex */
public class k implements m, h.a, p.a {

    private static final boolean i = false;
    private final r a;
    private final o b;
    private final com.bumptech.glide.load.engine.a0.h c;
    private final k.b d;
    private final x e;
    private final k.c f;
    private final k.a g;
    private final a h;

    static class a {

        final h.e a;
        final d.h.k.f<h<?>> b;
        private int c;
        a(h.e eVar) {
            super();
            this.b = a.d(150, new k.a.a(this));
            this.a = eVar;
        }

        <R> h<R> a(e eVar, Object object, n nVar, com.bumptech.glide.load.f fVar, int i, int i2, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, l<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.h hVar2, h.b<R> bVar) {
            final Object eVar4 = this;
            Object eVar2 = eVar4.b.b();
            k.d(eVar2);
            eVar4.c++;
            eVar2.s(eVar, object, nVar, fVar, i, i2, cls, cls2, hVar, jVar, map, z, z2, z3, hVar2, bVar, i);
            return eVar2;
        }
    }

    static class b {

        final com.bumptech.glide.load.engine.b0.a a;
        final com.bumptech.glide.load.engine.b0.a b;
        final com.bumptech.glide.load.engine.b0.a c;
        final com.bumptech.glide.load.engine.b0.a d;
        final m e;
        final p.a f;
        final d.h.k.f<l<?>> g;
        b(com.bumptech.glide.load.engine.b0.a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, m mVar, p.a aVar5) {
            super();
            this.g = a.d(150, new k.b.a(this));
            this.a = aVar;
            this.b = aVar2;
            this.c = aVar3;
            this.d = aVar4;
            this.e = mVar;
            this.f = aVar5;
        }

        <R> l<R> a(com.bumptech.glide.load.f fVar, boolean z, boolean z2, boolean z3, boolean z4) {
            Object obj = this.g.b();
            k.d(obj);
            obj.l(fVar, z, z2, z3, z4);
            return obj;
        }
    }

    public class d {

        private final l<?> a;
        private final com.bumptech.glide.r.h b;
        final /* synthetic */ k c;
        d(com.bumptech.glide.r.h hVar, l lVar) {
            this.c = kVar;
            super();
            this.b = hVar;
            this.a = lVar;
        }

        public void a() {
            synchronized (kVar) {
                try {
                    this.a.r(this.b);
                    return;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
    }

    private static class c implements h.e {

        private final a.a a;
        private volatile com.bumptech.glide.load.engine.a0.a b;
        c(a.a aVar) {
            super();
            this.a = aVar;
        }

        public com.bumptech.glide.load.engine.a0.a a() {
            com.bumptech.glide.load.engine.a0.a aVar;
            if (this.b == null) {
                synchronized (this) {
                    try {
                        if (this.b == null) {
                            this.b = this.a.build();
                        }
                        if (this.b == null) {
                            this.b = new b();
                        }
                    } catch (Throwable th) {
                    }
                }
            }
            return this.b;
        }
    }
    static {
        k.i = Log.isLoggable("Engine", 2);
    }

    public k(com.bumptech.glide.load.engine.a0.h hVar, a.a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, com.bumptech.glide.load.engine.b0.a aVar5, boolean z) {
        this(hVar, aVar, aVar2, aVar3, aVar4, aVar5, null, null, null, null, null, null, z);
    }

    private p<?> e(com.bumptech.glide.load.f fVar) {
        int i = 0;
        final com.bumptech.glide.load.engine.u uVar = this.c.d(fVar);
        if (uVar == null) {
            i = 0;
        } else {
            if (uVar instanceof p) {
            } else {
                boolean z = true;
                boolean z2 = true;
                p pVar = new p(uVar, z, z2, fVar, this);
            }
        }
        return i;
    }

    private p<?> g(com.bumptech.glide.load.f fVar) {
        final com.bumptech.glide.load.engine.p pVar = this.h.e(fVar);
        if (pVar != null) {
            pVar.c();
        }
        return pVar;
    }

    private p<?> h(com.bumptech.glide.load.f fVar) {
        final com.bumptech.glide.load.engine.p pVar = e(fVar);
        if (pVar != null) {
            pVar.c();
            this.h.a(fVar, pVar);
        }
        return pVar;
    }

    private p<?> i(n nVar, boolean z, long j) {
        int i = 0;
        if (!z) {
            return null;
        }
        com.bumptech.glide.load.engine.p pVar = g(nVar);
        if (pVar != null && k.i) {
            k.j("Loaded resource from active resources", j, nVar);
            return pVar;
        }
        com.bumptech.glide.load.engine.p pVar2 = h(nVar);
        if (pVar2 != null && k.i) {
            k.j("Loaded resource from cache", j, nVar);
            return pVar2;
        }
        return i;
    }

    private static void j(String str, long j, com.bumptech.glide.load.f fVar) {
        final StringBuilder stringBuilder = new StringBuilder();
        String str2 = " in ";
        double d = g.a(j);
        String str3 = "ms, key: ";
        str4 = str + str2 + d + str3 + fVar;
        Log.v("Engine", str4);
    }

    private <R> k.d l(e eVar, Object object, com.bumptech.glide.load.f fVar, int i, int i2, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, l<?>> map, boolean z, boolean z2, com.bumptech.glide.load.h hVar2, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.r.h hVar3, Executor executor, n nVar, long j) {
        final Object eVar3 = this;
        com.bumptech.glide.r.h hVar182 = hVar3;
        com.bumptech.glide.load.f nVar202 = nVar;
        com.bumptech.glide.load.engine.l lVar2 = eVar3.a.a(nVar202, z6);
        if (lVar2 != null) {
            lVar2.b(hVar182, executor);
            if (k.i) {
                k.j("Added to existing load", j, nVar202);
            }
            return new k.d(eVar3, hVar182, lVar2);
        }
        com.bumptech.glide.load.engine.l lVar = eVar3.d.a(nVar, z3, z4, z5, z6);
        com.bumptech.glide.load.f fVar32 = fVar;
        eVar3.a.c(nVar202, lVar);
        hVar182 = hVar3;
        lVar.b(hVar182, executor);
        lVar.s(eVar3.g.a(eVar, object, nVar, fVar32, i, i2, cls, cls2, hVar, jVar, map, z, z2, z6, hVar2, lVar));
        if (k.i) {
            k.j("Started new load", j, nVar202);
        }
        return new k.d(eVar3, hVar182, lVar);
    }

    public void a(u<?> uVar) {
        this.e.a(uVar, true);
    }

    public synchronized void b(l<?> lVar, com.bumptech.glide.load.f fVar, p<?> pVar) {
        if (pVar != null && pVar.e()) {
            this.h.a(fVar, pVar);
        }
        this.a.d(fVar, lVar);
    }

    public synchronized void c(l<?> lVar, com.bumptech.glide.load.f fVar) {
        this.a.d(fVar, lVar);
    }

    public void d(com.bumptech.glide.load.f fVar, p<?> pVar) {
        this.h.d(fVar);
        if (pVar.e()) {
            this.c.c(fVar, pVar);
        } else {
            this.e.a(pVar, false);
        }
    }

    public <R> k.d f(e eVar, Object object, com.bumptech.glide.load.f fVar, int i, int i2, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, l<?>> map, boolean z, boolean z2, com.bumptech.glide.load.h hVar2, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.r.h hVar3, Executor executor) {
        Object eVar3 = this;
        if (k.i) {
            long l = g.b();
        } else {
            i = 0;
        }
        com.bumptech.glide.load.engine.n nVar = eVar3.b.a(object, fVar, i, i2, map, cls, cls2, hVar2);
        synchronized (this) {
            try {
                com.bumptech.glide.load.engine.p pVar = eVar3.i(nVar, z3, i);
                if (pVar == null) {
                    return this.l(eVar, object, fVar, i, i2, cls, cls2, hVar, jVar, map, z, z2, hVar2, z3, z4, z5, z6, hVar3, executor, nVar, i);
                }
            } catch (Throwable th) {
            }
        }
        hVar3.c(pVar, a.MEMORY_CACHE, false);
        return null;
    }

    public void k(u<?> uVar) {
        if (!(uVar instanceof p)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        } else {
            uVar.f();
            return;
        }
    }

    k(com.bumptech.glide.load.engine.a0.h hVar, a.a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, com.bumptech.glide.load.engine.b0.a aVar5, r rVar, o oVar, a aVar6, k.b bVar, k.a aVar7, x xVar, boolean z) {
        com.bumptech.glide.load.engine.a aVar92;
        com.bumptech.glide.load.engine.o oVar82;
        com.bumptech.glide.load.engine.r rVar72;
        com.bumptech.glide.load.engine.k.a aVar112;
        com.bumptech.glide.load.engine.x xVar122;
        boolean z132;
        com.bumptech.glide.load.engine.k.b bVar102;
        final com.bumptech.glide.load.engine.p.a aVar8 = this;
        super();
        aVar8.c = hVar;
        final com.bumptech.glide.load.engine.k.c cVar = new k.c(aVar);
        aVar8.f = cVar;
        if (aVar6 == null) {
            aVar92 = new a(z);
        } else {
            aVar92 = aVar6;
        }
        aVar8.h = aVar92;
        aVar92.f(this);
        o r0 = oVar == null ? new o() : oVar;
        aVar8.b = (oVar == null ? new o() : oVar);
        r0 = rVar == null ? new r() : rVar;
        aVar8.a = (rVar == null ? new r() : rVar);
        if (bVar == null) {
            super(aVar2, aVar3, aVar4, aVar5, this, this);
        } else {
            bVar102 = bVar;
        }
        aVar8.d = bVar102;
        r0 = aVar7 == null ? new k.a(cVar) : aVar7;
        aVar8.g = (aVar7 == null ? new k.a(cVar) : aVar7);
        r0 = xVar == null ? new x() : xVar;
        aVar8.e = (xVar == null ? new x() : xVar);
        hVar.e(this);
    }
}
