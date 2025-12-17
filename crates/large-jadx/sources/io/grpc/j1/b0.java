package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.a;
import io.grpc.d1;
import io.grpc.o;
import io.grpc.t0;
import io.grpc.u;
import io.grpc.w;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class b0 implements io.grpc.j1.q {

    private volatile boolean a;
    private io.grpc.j1.r b;
    private io.grpc.j1.q c;
    private d1 d;
    private List<Runnable> e;
    private io.grpc.j1.b0.p f;
    private long g;
    private long h;
    private List<Runnable> i;

    class a implements Runnable {

        final int a;
        final io.grpc.j1.b0 b;
        a(io.grpc.j1.b0 b0, int i2) {
            this.b = b0;
            this.a = i2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.p(this.b).e(this.a);
        }
    }

    class b implements Runnable {

        final io.grpc.j1.b0 a;
        b(io.grpc.j1.b0 b0) {
            this.a = b0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.p(this.a).o();
        }
    }

    class c implements Runnable {

        final o a;
        final io.grpc.j1.b0 b;
        c(io.grpc.j1.b0 b0, o o2) {
            this.b = b0;
            this.a = o2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.p(this.b).d(this.a);
        }
    }

    class d implements Runnable {

        final boolean a;
        final io.grpc.j1.b0 b;
        d(io.grpc.j1.b0 b0, boolean z2) {
            this.b = b0;
            this.a = z2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.p(this.b).q(this.a);
        }
    }

    class e implements Runnable {

        final w a;
        final io.grpc.j1.b0 b;
        e(io.grpc.j1.b0 b0, w w2) {
            this.b = b0;
            this.a = w2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.p(this.b).h(this.a);
        }
    }

    class f implements Runnable {

        final boolean a;
        final io.grpc.j1.b0 b;
        f(io.grpc.j1.b0 b0, boolean z2) {
            this.b = b0;
            this.a = z2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.p(this.b).b(this.a);
        }
    }

    class g implements Runnable {

        final int a;
        final io.grpc.j1.b0 b;
        g(io.grpc.j1.b0 b0, int i2) {
            this.b = b0;
            this.a = i2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.p(this.b).f(this.a);
        }
    }

    class h implements Runnable {

        final int a;
        final io.grpc.j1.b0 b;
        h(io.grpc.j1.b0 b0, int i2) {
            this.b = b0;
            this.a = i2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.p(this.b).g(this.a);
        }
    }

    class i implements Runnable {

        final u a;
        final io.grpc.j1.b0 b;
        i(io.grpc.j1.b0 b0, u u2) {
            this.b = b0;
            this.a = u2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.p(this.b).l(this.a);
        }
    }

    class j implements Runnable {

        final io.grpc.j1.b0 a;
        j(io.grpc.j1.b0 b0) {
            this.a = b0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.r(this.a);
        }
    }

    class k implements Runnable {

        final String a;
        final io.grpc.j1.b0 b;
        k(io.grpc.j1.b0 b0, String string2) {
            this.b = b0;
            this.a = string2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.p(this.b).i(this.a);
        }
    }

    class l implements Runnable {

        final InputStream a;
        final io.grpc.j1.b0 b;
        l(io.grpc.j1.b0 b0, InputStream inputStream2) {
            this.b = b0;
            this.a = inputStream2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.p(this.b).n(this.a);
        }
    }

    class m implements Runnable {

        final io.grpc.j1.b0 a;
        m(io.grpc.j1.b0 b0) {
            this.a = b0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.p(this.a).flush();
        }
    }

    class n implements Runnable {

        final d1 a;
        final io.grpc.j1.b0 b;
        n(io.grpc.j1.b0 b0, d1 d12) {
            this.b = b0;
            this.a = d12;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.p(this.b).c(this.a);
        }
    }

    class o implements Runnable {

        final io.grpc.j1.b0 a;
        o(io.grpc.j1.b0 b0) {
            this.a = b0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.p(this.a).k();
        }
    }

    private static class p implements io.grpc.j1.r {

        private final io.grpc.j1.r a;
        private volatile boolean b;
        private List<Runnable> c;
        static {
        }

        public p(io.grpc.j1.r r) {
            super();
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            this.a = r;
        }

        static io.grpc.j1.r e(io.grpc.j1.b0.p b0$p) {
            return p.a;
        }

        private void f(Runnable runnable) {
            synchronized (this) {
                try {
                    this.c.add(runnable);
                    runnable.run();
                    throw runnable;
                }
            }
        }

        @Override // io.grpc.j1.r
        public void a(io.grpc.j1.k2.a k2$a) {
            Object aVar;
            if (this.b) {
                this.a.a(a);
            } else {
                aVar = new b0.p.a(this, a);
                f(aVar);
            }
        }

        @Override // io.grpc.j1.r
        public void b(t0 t0) {
            b0.p.c cVar = new b0.p.c(this, t0);
            f(cVar);
        }

        @Override // io.grpc.j1.r
        public void c() {
            Object bVar;
            if (this.b) {
                this.a.c();
            } else {
                bVar = new b0.p.b(this);
                f(bVar);
            }
        }

        @Override // io.grpc.j1.r
        public void d(d1 d1, io.grpc.j1.r.a r$a2, t0 t03) {
            b0.p.d dVar = new b0.p.d(this, d1, a2, t03);
            f(dVar);
        }

        @Override // io.grpc.j1.r
        public void g() {
            ArrayList arrayList;
            List list;
            boolean next;
            arrayList = new ArrayList();
            synchronized (this) {
                this.c = 0;
                this.b = true;
            }
            for (Runnable next : iterator) {
                next.run();
            }
            try {
                list.clear();
                arrayList = list;
                throw th;
            }
        }
    }
    static {
    }

    b0() {
        super();
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.i = arrayList2;
    }

    static io.grpc.j1.q p(io.grpc.j1.b0 b0) {
        return b0.c;
    }

    static void r(io.grpc.j1.b0 b0) {
        b0.t();
    }

    private void s(Runnable runnable) {
        int i;
        i = this.b != null ? 1 : 0;
        n.v(i, "May only be called after start");
        synchronized (this) {
            this.e.add(runnable);
        }
    }

    private void t() {
        ArrayList arrayList;
        List list;
        boolean next;
        arrayList = new ArrayList();
        synchronized (this) {
            this.e = 0;
            this.a = true;
            io.grpc.j1.b0.p pVar = this.f;
            if (pVar != null) {
            }
        }
        pVar.g();
    }

    private void u(io.grpc.j1.r r) {
        Object next;
        Iterator iterator = this.i.iterator();
        for (Runnable next : iterator) {
            next.run();
        }
        this.i = 0;
        this.c.m(r);
    }

    private void w(io.grpc.j1.q q) {
        int i;
        io.grpc.j1.q qVar = this.c;
        i = qVar == null ? 1 : 0;
        n.x(i, "realStream already set to %s", qVar);
        this.c = q;
        this.h = System.nanoTime();
    }

    @Override // io.grpc.j1.q
    public boolean a() {
        if (this.a) {
            return this.c.a();
        }
        return 0;
    }

    @Override // io.grpc.j1.q
    public void b(boolean z) {
        int i;
        Object fVar;
        i = this.b != null ? 1 : 0;
        n.v(i, "May only be called after start");
        if (this.a) {
            this.c.b(z);
        } else {
            fVar = new b0.f(this, z);
            s(fVar);
        }
    }

    @Override // io.grpc.j1.q
    public void c(d1 d1) {
        int i;
        io.grpc.j1.q qVar;
        Object nVar;
        int pROCESSED;
        t0 t0Var;
        t0Var = 0;
        i = this.b != null ? pROCESSED : t0Var;
        n.v(i, "May only be called after start");
        n.p(d1, "reason");
        synchronized (this) {
            w(o1.a);
            this.d = d1;
            pROCESSED = t0Var;
            if (pROCESSED != 0) {
            } else {
                t();
                v(d1);
                t0Var = new t0();
                this.b.d(d1, r.a.PROCESSED, t0Var);
            }
        }
        nVar = new b0.n(this, d1);
        s(nVar);
    }

    @Override // io.grpc.j1.q
    public void d(o o) {
        int i;
        i = this.b == null ? 1 : 0;
        n.v(i, "May only be called before start");
        n.p(o, "compressor");
        b0.c cVar = new b0.c(this, o);
        this.i.add(cVar);
    }

    @Override // io.grpc.j1.q
    public void e(int i) {
        int i2;
        Object aVar;
        i2 = this.b != null ? 1 : 0;
        n.v(i2, "May only be called after start");
        if (this.a) {
            this.c.e(i);
        } else {
            aVar = new b0.a(this, i);
            s(aVar);
        }
    }

    @Override // io.grpc.j1.q
    public void f(int i) {
        int i2;
        i2 = this.b == null ? 1 : 0;
        n.v(i2, "May only be called before start");
        b0.g gVar = new b0.g(this, i);
        this.i.add(gVar);
    }

    @Override // io.grpc.j1.q
    public void flush() {
        int i;
        Object mVar;
        i = this.b != null ? 1 : 0;
        n.v(i, "May only be called after start");
        if (this.a) {
            this.c.flush();
        } else {
            mVar = new b0.m(this);
            s(mVar);
        }
    }

    @Override // io.grpc.j1.q
    public void g(int i) {
        int i2;
        i2 = this.b == null ? 1 : 0;
        n.v(i2, "May only be called before start");
        b0.h hVar = new b0.h(this, i);
        this.i.add(hVar);
    }

    @Override // io.grpc.j1.q
    public a getAttributes() {
        io.grpc.j1.q qVar = this.c;
        synchronized (this) {
            qVar = this.c;
        }
        try {
            return qVar.getAttributes();
            return a.b;
            throw th;
        }
    }

    @Override // io.grpc.j1.q
    public void h(w w) {
        int i;
        i = this.b == null ? 1 : 0;
        n.v(i, "May only be called before start");
        n.p(w, "decompressorRegistry");
        b0.e eVar = new b0.e(this, w);
        this.i.add(eVar);
    }

    @Override // io.grpc.j1.q
    public void i(String string) {
        int i;
        i = this.b == null ? 1 : 0;
        n.v(i, "May only be called before start");
        n.p(string, "authority");
        b0.k kVar = new b0.k(this, string);
        this.i.add(kVar);
    }

    @Override // io.grpc.j1.q
    public void j(io.grpc.j1.x0 x0) {
        Object str;
        Long valueOf;
        long l;
        synchronized (this) {
            try {
                if (this.c != null) {
                } else {
                }
                x0.b("buffered_nanos", Long.valueOf(l2 -= l));
                this.c.j(x0);
                x0.b("buffered_nanos", Long.valueOf(nanoTime -= l));
                x0.a("waiting_for_connection");
                throw x0;
            }
        }
    }

    @Override // io.grpc.j1.q
    public void k() {
        int i;
        i = this.b != null ? 1 : 0;
        n.v(i, "May only be called after start");
        b0.o oVar = new b0.o(this);
        s(oVar);
    }

    @Override // io.grpc.j1.q
    public void l(u u) {
        int i;
        i = this.b == null ? 1 : 0;
        n.v(i, "May only be called before start");
        b0.i iVar = new b0.i(this, u);
        this.i.add(iVar);
    }

    @Override // io.grpc.j1.q
    public void m(io.grpc.j1.r r) {
        int i;
        io.grpc.j1.b0.p pVar;
        Object obj5;
        n.p(r, "listener");
        i = this.b == null ? 1 : 0;
        n.v(i, "already started");
        d1 d1Var = this.d;
        boolean z = this.a;
        synchronized (this) {
            pVar = new b0.p(r);
            this.f = pVar;
            obj5 = pVar;
            this.b = obj5;
            this.g = System.nanoTime();
            if (d1Var != null) {
            }
            if (z) {
                u(obj5);
            }
        }
        t0 t0Var = new t0();
        obj5.d(d1Var, r.a.PROCESSED, t0Var);
    }

    @Override // io.grpc.j1.q
    public void n(InputStream inputStream) {
        int i;
        Object lVar;
        i = this.b != null ? 1 : 0;
        n.v(i, "May only be called after start");
        n.p(inputStream, "message");
        if (this.a) {
            this.c.n(inputStream);
        } else {
            lVar = new b0.l(this, inputStream);
            s(lVar);
        }
    }

    @Override // io.grpc.j1.q
    public void o() {
        int i;
        i = this.b == null ? 1 : 0;
        n.v(i, "May only be called before start");
        b0.b bVar = new b0.b(this);
        this.i.add(bVar);
    }

    @Override // io.grpc.j1.q
    public void q(boolean z) {
        int i;
        i = this.b == null ? 1 : 0;
        n.v(i, "May only be called before start");
        b0.d dVar = new b0.d(this, z);
        this.i.add(dVar);
    }

    @Override // io.grpc.j1.q
    protected void v(d1 d1) {
    }

    @Override // io.grpc.j1.q
    final Runnable x(io.grpc.j1.q q) {
        String str;
        final int i = 0;
        synchronized (this) {
            try {
                return i;
                n.p(q, "stream");
                w(q);
                io.grpc.j1.r obj3 = this.b;
                if (obj3 == null) {
                }
                this.e = i;
                this.a = true;
                if (obj3 == null) {
                }
                return i;
                u(obj3);
                obj3 = new b0.j(this);
                return obj3;
                throw q;
            }
        }
    }
}
