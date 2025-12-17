package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.b0.a;
import com.bumptech.glide.load.f;
import com.bumptech.glide.r.h;
import com.bumptech.glide.t.e;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.m.a.f;
import com.bumptech.glide.t.m.c;
import d.h.k.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class l<R>  implements com.bumptech.glide.load.engine.h.b<R>, a.f {

    private static final com.bumptech.glide.load.engine.l.c R;
    private final a A;
    private final a B;
    private final AtomicInteger C;
    private f D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private com.bumptech.glide.load.engine.u<?> I;
    a J;
    private boolean K;
    com.bumptech.glide.load.engine.GlideException L;
    private boolean M;
    com.bumptech.glide.load.engine.p<?> N;
    private com.bumptech.glide.load.engine.h<R> O;
    private volatile boolean P;
    private boolean Q;
    final com.bumptech.glide.load.engine.l.e a;
    private final c b;
    private final com.bumptech.glide.load.engine.p.a c;
    private final f<com.bumptech.glide.load.engine.l<?>> v;
    private final com.bumptech.glide.load.engine.l.c w;
    private final com.bumptech.glide.load.engine.m x;
    private final a y;
    private final a z;

    private class a implements Runnable {

        private final h a;
        final com.bumptech.glide.load.engine.l b;
        a(com.bumptech.glide.load.engine.l l, h h2) {
            this.b = l;
            super();
            this.a = h2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            h hVar;
            Object obj = this.a.h();
            final com.bumptech.glide.load.engine.l lVar = this.b;
            synchronized (obj) {
                this.b.e(this.a);
                this.b.i();
            }
        }
    }

    private class b implements Runnable {

        private final h a;
        final com.bumptech.glide.load.engine.l b;
        b(com.bumptech.glide.load.engine.l l, h h2) {
            this.b = l;
            super();
            this.a = h2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            h hVar;
            Object obj = this.a.h();
            final com.bumptech.glide.load.engine.l lVar = this.b;
            synchronized (obj) {
                lVar4.N.c();
                this.b.g(this.a);
                this.b.r(this.a);
                this.b.i();
            }
        }
    }

    static class c {
        public <R> com.bumptech.glide.load.engine.p<R> a(com.bumptech.glide.load.engine.u<R> u, boolean z2, f f3, com.bumptech.glide.load.engine.p.a p$a4) {
            super(u, z2, 1, f3, a4);
            return pVar2;
        }
    }

    static final class d {

        final h a;
        final Executor b;
        d(h h, Executor executor2) {
            super();
            this.a = h;
            this.b = executor2;
        }

        public boolean equals(Object object) {
            if (object instanceof l.d) {
                return this.a.equals(object.a);
            }
            return 0;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    static final class e implements Iterable<com.bumptech.glide.load.engine.l.d> {

        private final List<com.bumptech.glide.load.engine.l.d> a;
        e() {
            ArrayList arrayList = new ArrayList(2);
            super(arrayList);
        }

        e(List<com.bumptech.glide.load.engine.l.d> list) {
            super();
            this.a = list;
        }

        private static com.bumptech.glide.load.engine.l.d h(h h) {
            l.d dVar = new l.d(h, e.a());
            return dVar;
        }

        @Override // java.lang.Iterable
        void b(h h, Executor executor2) {
            l.d dVar = new l.d(h, executor2);
            this.a.add(dVar);
        }

        @Override // java.lang.Iterable
        void clear() {
            this.a.clear();
        }

        @Override // java.lang.Iterable
        boolean d(h h) {
            return this.a.contains(l.e.h(h));
        }

        @Override // java.lang.Iterable
        com.bumptech.glide.load.engine.l.e g() {
            ArrayList arrayList = new ArrayList(this.a);
            l.e eVar = new l.e(arrayList);
            return eVar;
        }

        @Override // java.lang.Iterable
        void i(h h) {
            this.a.remove(l.e.h(h));
        }

        @Override // java.lang.Iterable
        boolean isEmpty() {
            return this.a.isEmpty();
        }

        public Iterator<com.bumptech.glide.load.engine.l.d> iterator() {
            return this.a.iterator();
        }

        @Override // java.lang.Iterable
        int size() {
            return this.a.size();
        }
    }
    static {
        l.c cVar = new l.c();
        l.R = cVar;
    }

    l(a a, a a2, a a3, a a4, com.bumptech.glide.load.engine.m m5, com.bumptech.glide.load.engine.p.a p$a6, f<com.bumptech.glide.load.engine.l<?>> f7) {
        super(a, a2, a3, a4, m5, a6, f7, l.R);
    }

    l(a a, a a2, a a3, a a4, com.bumptech.glide.load.engine.m m5, com.bumptech.glide.load.engine.p.a p$a6, f<com.bumptech.glide.load.engine.l<?>> f7, com.bumptech.glide.load.engine.l.c l$c8) {
        super();
        l.e eVar = new l.e();
        this.a = eVar;
        this.b = c.a();
        AtomicInteger atomicInteger = new AtomicInteger();
        this.C = atomicInteger;
        this.y = a;
        this.z = a2;
        this.A = a3;
        this.B = a4;
        this.x = m5;
        this.c = a6;
        this.v = f7;
        this.w = c8;
    }

    private a j() {
        a aVar;
        aVar = this.F ? this.A : z2 ? this.B : this.z;
        return aVar;
    }

    private boolean m() {
        boolean z;
        int i;
        if (!this.M && !this.K) {
            if (!this.K) {
                if (this.P) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private void q() {
        synchronized (this) {
            try {
                this.a.clear();
                int i = 0;
                this.D = i;
                this.N = i;
                this.I = i;
                final int i2 = 0;
                this.M = i2;
                this.P = i2;
                this.K = i2;
                this.Q = i2;
                this.O.B(i2);
                this.O = i;
                this.L = i;
                this.J = i;
                this.v.a(this);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                throw illegalArgumentException;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.h$b
    public void a(com.bumptech.glide.load.engine.GlideException glideException) {
        this.L = glideException;
        n();
        return;
        synchronized (this) {
            this.L = glideException;
            n();
        }
    }

    @Override // com.bumptech.glide.load.engine.h$b
    void b(h h, Executor executor2) {
        com.bumptech.glide.load.engine.l.a aVar;
        int i;
        Object obj3;
        this.b.c();
        this.a.b(h, executor2);
        i = 1;
        synchronized (this) {
            try {
                k(i);
                aVar = new l.b(this, h);
                executor2.execute(aVar);
                if (this.M) {
                } else {
                }
                k(i);
                aVar = new l.a(this, h);
                executor2.execute(aVar);
                if (!this.P) {
                } else {
                }
                i = 0;
                k.a(i, "Cannot add callbacks to a cancelled EngineJob");
                throw h;
            }
        }
    }

    public void c(com.bumptech.glide.load.engine.u<R> u, a a2, boolean z3) {
        this.I = u;
        this.J = a2;
        this.Q = z3;
        o();
        return;
        synchronized (this) {
            this.I = u;
            this.J = a2;
            this.Q = z3;
            o();
        }
    }

    public void d(com.bumptech.glide.load.engine.h<?> h) {
        j().execute(h);
    }

    @Override // com.bumptech.glide.load.engine.h$b
    void e(h h) {
        try {
            h.a(this.L);
            b bVar = new b(h);
            throw bVar;
        }
    }

    @Override // com.bumptech.glide.load.engine.h$b
    public c f() {
        return this.b;
    }

    @Override // com.bumptech.glide.load.engine.h$b
    void g(h h) {
        try {
            h.c(this.N, this.J, this.Q);
            b bVar = new b(h);
            throw bVar;
        }
    }

    @Override // com.bumptech.glide.load.engine.h$b
    void h() {
        if (m()) {
        }
        this.P = true;
        this.O.i();
        this.x.c(this, this.D);
    }

    @Override // com.bumptech.glide.load.engine.h$b
    void i() {
        int i2;
        int i;
        this.b.c();
        k.a(m(), "Not yet complete!");
        int decrementAndGet = this.C.decrementAndGet();
        synchronized (this) {
            try {
                i = 1;
                i = 0;
                k.a(i, "Can't decrement below 0");
                if (decrementAndGet == 0) {
                } else {
                }
                i2 = this.N;
                q();
                i2 = 0;
                if (i2 != 0) {
                }
                i2.f();
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.h$b
    void k(int i) {
        int obj3;
        k.a(m(), "Not yet complete!");
        synchronized (this) {
            try {
                obj3 = this.N;
                if (obj3 != null) {
                }
                obj3.c();
                throw i;
            }
        }
    }

    com.bumptech.glide.load.engine.l<R> l(f f, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.D = f;
        this.E = z2;
        this.F = z3;
        this.G = z4;
        this.H = z5;
        return this;
        synchronized (this) {
            this.D = f;
            this.E = z2;
            this.F = z3;
            this.G = z4;
            this.H = z5;
            return this;
        }
    }

    @Override // com.bumptech.glide.load.engine.h$b
    void n() {
        f fVar;
        com.bumptech.glide.load.engine.l.e eVar;
        int aVar;
        this.b.c();
        synchronized (this) {
            try {
                q();
                if (this.a.isEmpty()) {
                } else {
                }
                if (this.M) {
                } else {
                }
                int i = 1;
                this.M = i;
                eVar = this.a.g();
                k(size += i);
                this.x.b(this, this.D, 0);
                Iterator iterator = eVar.iterator();
                for (l.d next2 : iterator) {
                    aVar = new l.a(this, next2.a);
                    next2.b.execute(aVar);
                }
                Object next2 = iterator.next();
                aVar = new l.a(this, next2.a);
                next2.b.execute(aVar);
                i();
                IllegalStateException illegalStateException = new IllegalStateException("Already failed once");
                throw illegalStateException;
                IllegalStateException illegalStateException2 = new IllegalStateException("Received an exception without any callbacks to notify");
                throw illegalStateException2;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.h$b
    void o() {
        com.bumptech.glide.load.engine.l.e eVar;
        com.bumptech.glide.load.engine.p pVar;
        com.bumptech.glide.load.engine.m bVar;
        this.b.c();
        synchronized (this) {
            try {
                this.I.a();
                q();
                if (this.a.isEmpty()) {
                } else {
                }
                if (this.K) {
                } else {
                }
                this.N = this.w.a(this.I, this.E, this.D, this.c);
                int i = 1;
                this.K = i;
                eVar = this.a.g();
                k(size += i);
                this.x.b(this, this.D, this.N);
                Iterator iterator = eVar.iterator();
                for (l.d next2 : iterator) {
                    bVar = new l.b(this, next2.a);
                    next2.b.execute(bVar);
                }
                Object next2 = iterator.next();
                bVar = new l.b(this, next2.a);
                next2.b.execute(bVar);
                i();
                IllegalStateException illegalStateException = new IllegalStateException("Already have resource");
                throw illegalStateException;
                IllegalStateException illegalStateException2 = new IllegalStateException("Received a resource without any callbacks to notify");
                throw illegalStateException2;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.h$b
    boolean p() {
        return this.H;
    }

    @Override // com.bumptech.glide.load.engine.h$b
    void r(h h) {
        boolean obj2;
        this.b.c();
        this.a.i(h);
        synchronized (this) {
            try {
                h();
                if (!this.K) {
                } else {
                }
                if (this.M) {
                } else {
                }
                obj2 = 0;
                obj2 = 1;
                if (obj2 != null && this.C.get() == 0) {
                }
                if (this.C.get() == 0) {
                }
                q();
                throw h;
            }
        }
    }

    public void s(com.bumptech.glide.load.engine.h<R> h) {
        a aVar;
        this.O = h;
        synchronized (this) {
            try {
                aVar = this.y;
                aVar = j();
                aVar.execute(h);
                throw h;
            }
        }
    }
}
