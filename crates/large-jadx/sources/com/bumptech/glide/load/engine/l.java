package com.bumptech.glide.load.engine;

import com.bumptech.glide.r.h;
import com.bumptech.glide.t.e;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.m.a.f;
import com.bumptech.glide.t.m.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: EngineJob.java */
/* loaded from: classes.dex */
class l<R> implements h.b<R>, a.f {

    private static final l.c R = new l$c();
    private final com.bumptech.glide.load.engine.b0.a A;
    private final com.bumptech.glide.load.engine.b0.a B;
    private final AtomicInteger C;
    private com.bumptech.glide.load.f D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private u<?> I;
    com.bumptech.glide.load.a J;
    private boolean K;
    GlideException L;
    private boolean M;
    p<?> N;
    private h<R> O;
    private volatile boolean P;
    private boolean Q;
    final l.e a;
    private final c b;
    private final p.a c;
    private final d.h.k.f<l<?>> v;
    private final l.c w;
    private final m x;
    private final com.bumptech.glide.load.engine.b0.a y;
    private final com.bumptech.glide.load.engine.b0.a z;

    private class a implements Runnable {

        private final h a;
        final /* synthetic */ l b;
        a(h hVar) {
            this.b = lVar;
            super();
            this.a = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj2 = this.a.h();
            synchronized (obj2) {
                synchronized (lVar) {
                    try {
                        if (this.b.a.d(this.a)) {
                            this.b.e(this.a);
                        }
                        this.b.i();
                    } catch (Throwable th) {
                    }
                }
            }
            try {
            } catch (Throwable th) {
            }
        }
    }

    private class b implements Runnable {

        private final h a;
        final /* synthetic */ l b;
        b(h hVar) {
            this.b = lVar;
            super();
            this.a = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj2 = this.a.h();
            synchronized (obj2) {
                synchronized (lVar) {
                    try {
                        if (this.b.a.d(this.a)) {
                            this.b.N.c();
                            this.b.g(this.a);
                            this.b.r(this.a);
                        }
                        this.b.i();
                    } catch (Throwable th) {
                    }
                }
            }
            try {
            } catch (Throwable th) {
            }
        }
    }

    static class c {
        c() {
            super();
        }

        public <R> p<R> a(u<R> uVar, boolean z, com.bumptech.glide.load.f fVar, p.a aVar) {
            p pVar = new p(uVar, z, true, fVar, aVar);
            return pVar;
        }
    }

    static final class d {

        final h a;
        final Executor b;
        d(h hVar, Executor executor) {
            super();
            this.a = hVar;
            this.b = executor;
        }

        public boolean equals(Object object) {
            if (object instanceof l.d) {
                return this.a.equals(object.a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    static final class e implements Iterable<l.d> {

        private final List<l.d> a;
        e() {
            this(new ArrayList(2));
        }

        private static l.d h(h hVar) {
            return new l.d(hVar, e.a());
        }

        void b(h hVar, Executor executor) {
            this.a.add(new l.d(hVar, executor));
        }

        void clear() {
            this.a.clear();
        }

        boolean d(h hVar) {
            return this.a.contains(l.e.h(hVar));
        }

        l.e g() {
            return new l.e(new ArrayList(this.a));
        }

        void i(h hVar) {
            this.a.remove(l.e.h(hVar));
        }

        boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator<l.d> iterator() {
            return this.a.iterator();
        }

        int size() {
            return this.a.size();
        }

        e(List<l.d> list) {
            super();
            this.a = list;
        }
    }

    l(com.bumptech.glide.load.engine.b0.a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, m mVar, p.a aVar5, d.h.k.f<l<?>> fVar) {
        this(aVar, aVar2, aVar3, aVar4, mVar, aVar5, fVar, l.R);
    }

    private com.bumptech.glide.load.engine.b0.a j() {
        com.bumptech.glide.load.engine.b0.a aVar;
        if (this.F) {
        } else {
            com.bumptech.glide.load.engine.b0.a r0 = this.G ? this.B : this.z;
        }
        return (this.G ? this.B : this.z);
    }

    private boolean m() {
        boolean z2 = false;
        if (this.M || !(this.K && !this.P)) {
            int i2 = 1;
        }
        return z2;
    }

    private synchronized void q() {
        this.a.clear();
        com.bumptech.glide.load.f fVar2 = null;
        this.D = fVar2;
        this.N = fVar2;
        this.I = fVar2;
        final boolean z = false;
        this.M = z;
        this.P = z;
        this.K = z;
        this.Q = z;
        this.O.B(z);
        this.O = fVar2;
        this.L = fVar2;
        this.J = fVar2;
        this.v.a(this);
        throw new IllegalArgumentException();
    }

    public void a(GlideException exc) {
        synchronized (this) {
            try {
                this.L = exc;
            } catch (Throwable th) {
            }
        }
        n();
    }

    synchronized void b(h hVar, Executor executor) {
        boolean z2 = false;
        this.b.c();
        this.a.b(hVar, executor);
        int i = 1;
        if (this.K) {
            k(i);
            executor.execute(new l.b(this, hVar));
        } else {
            if (this.M) {
                k(i);
                executor.execute(new l.a(this, hVar));
            } else {
                if (this.P) {
                    int i2 = 0;
                }
                str = "Cannot add callbacks to a cancelled EngineJob";
                k.a(z2, str);
            }
        }
    }

    public void c(u<R> uVar, com.bumptech.glide.load.a aVar, boolean z) {
        synchronized (this) {
            try {
                this.I = uVar;
                this.J = aVar;
                this.Q = z;
            } catch (Throwable th) {
            }
        }
        o();
    }

    public void d(h<?> hVar) {
        j().execute(hVar);
    }

    void e(h hVar) {
        try {
            hVar.a(this.L);
        } finally {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new b(hVar);
        }
    }

    public c f() {
        return this.b;
    }

    void g(h hVar) {
        try {
            hVar.c(this.N, this.J, this.Q);
        } finally {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new b(hVar);
        }
    }

    void h() {
        if (m()) {
            return;
        }
        this.P = true;
        this.O.i();
        this.x.c(this, this.D);
    }

    void i() {
        int i = 0;
        boolean z2 = false;
        synchronized (this) {
            try {
                this.b.c();
                k.a(m(), "Not yet complete!");
                int decrementAndGet = this.C.decrementAndGet();
                int r1 = decrementAndGet >= 0 ? 1 : 0;
                k.a((decrementAndGet >= 0 ? 1 : 0), "Can't decrement below 0");
                if (decrementAndGet == 0) {
                    q();
                } else {
                    i = 0;
                }
            } catch (Throwable th) {
            }
        }
        if (this.b != 0) {
            i.f();
        }
    }

    synchronized void k(int i) {
        k.a(m(), "Not yet complete!");
        if (this.N != null) {
            this.N.c();
        }
    }

    synchronized l<R> l(com.bumptech.glide.load.f fVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.D = fVar;
        this.E = z;
        this.F = z2;
        this.G = z3;
        this.H = z4;
        return this;
    }

    void n() {
        synchronized (this) {
            try {
                this.b.c();
                if (this.P) {
                    q();
                    return;
                }
                boolean z3 = true;
                this.M = z3;
                com.bumptech.glide.load.engine.l.e eVar = this.a.g();
                k(eVar.size() + z3);
            } catch (Throwable unused) {
            }
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        }
        com.bumptech.glide.load.engine.p pVar = null;
        this.x.b(this, this.D, pVar);
        Iterator it = eVar.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            item.b.execute(new l.a(this, item.a));
        }
        i();
    }

    void o() {
        synchronized (this) {
            try {
                this.b.c();
                if (this.P) {
                    this.I.a();
                    q();
                    return;
                }
                this.N = this.w.a(this.I, this.E, this.D, this.c);
                boolean z3 = true;
                this.K = z3;
                com.bumptech.glide.load.engine.l.e eVar = this.a.g();
                k(eVar.size() + z3);
            } catch (Throwable unused) {
            }
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
        this.x.b(this, this.D, this.N);
        Iterator it = eVar.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            item.b.execute(new l.b(this, item.a));
        }
        i();
    }

    boolean p() {
        return this.H;
    }

    synchronized void r(h hVar) {
        int i = 0;
        this.b.c();
        this.a.i(hVar);
        h();
        if (this.K || this.M) {
            i = 1;
        }
        if (this.C.get() == 0) {
            q();
        }
    }

    public synchronized void s(h<R> hVar) {
        com.bumptech.glide.load.engine.b0.a aVar;
        this.O = hVar;
        if (hVar.H()) {
        } else {
            aVar = j();
        }
        aVar.execute(hVar);
    }

    l(com.bumptech.glide.load.engine.b0.a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, m mVar, p.a aVar5, d.h.k.f<l<?>> fVar, l.c cVar) {
        super();
        this.a = new l.e();
        this.b = c.a();
        this.C = new AtomicInteger();
        this.y = aVar;
        this.z = aVar2;
        this.A = aVar3;
        this.B = aVar4;
        this.x = mVar;
        this.c = aVar5;
        this.v = fVar;
        this.w = cVar;
    }
}
