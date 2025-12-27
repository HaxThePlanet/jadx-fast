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

/* compiled from: DelayedStream.java */
/* loaded from: classes3.dex */
class b0 implements q {

    private volatile boolean a;
    private r b;
    private q c;
    private d1 d;
    private List<Runnable> e = new ArrayList<>();
    private b0.p f;
    private long g;
    private long h;
    private List<Runnable> i = new ArrayList<>();

    class a implements Runnable {

        final /* synthetic */ int a;
        final /* synthetic */ b0 b;
        a(int i) {
            this.b = b0Var;
            this.a = i;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.c.e(this.a);
        }
    }

    class b implements Runnable {

        final /* synthetic */ b0 a;
        b() {
            this.a = b0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.c.o();
        }
    }

    class c implements Runnable {

        final /* synthetic */ o a;
        final /* synthetic */ b0 b;
        c(o oVar) {
            this.b = b0Var;
            this.a = oVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.c.d(this.a);
        }
    }

    class d implements Runnable {

        final /* synthetic */ boolean a;
        final /* synthetic */ b0 b;
        d(boolean z) {
            this.b = b0Var;
            this.a = z;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.c.q(this.a);
        }
    }

    class e implements Runnable {

        final /* synthetic */ w a;
        final /* synthetic */ b0 b;
        e(w wVar) {
            this.b = b0Var;
            this.a = wVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.c.h(this.a);
        }
    }

    class f implements Runnable {

        final /* synthetic */ boolean a;
        final /* synthetic */ b0 b;
        f(boolean z) {
            this.b = b0Var;
            this.a = z;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.c.b(this.a);
        }
    }

    class g implements Runnable {

        final /* synthetic */ int a;
        final /* synthetic */ b0 b;
        g(int i) {
            this.b = b0Var;
            this.a = i;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.c.f(this.a);
        }
    }

    class h implements Runnable {

        final /* synthetic */ int a;
        final /* synthetic */ b0 b;
        h(int i) {
            this.b = b0Var;
            this.a = i;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.c.g(this.a);
        }
    }

    class i implements Runnable {

        final /* synthetic */ u a;
        final /* synthetic */ b0 b;
        i(u uVar) {
            this.b = b0Var;
            this.a = uVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.c.l(this.a);
        }
    }

    class j implements Runnable {

        final /* synthetic */ b0 a;
        j() {
            this.a = b0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.t();
        }
    }

    class k implements Runnable {

        final /* synthetic */ String a;
        final /* synthetic */ b0 b;
        k(String str) {
            this.b = b0Var;
            this.a = str;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.c.i(this.a);
        }
    }

    class l implements Runnable {

        final /* synthetic */ InputStream a;
        final /* synthetic */ b0 b;
        l(InputStream inputStream) {
            this.b = b0Var;
            this.a = inputStream;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.c.n(this.a);
        }
    }

    class m implements Runnable {

        final /* synthetic */ b0 a;
        m() {
            this.a = b0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.c.flush();
        }
    }

    class n implements Runnable {

        final /* synthetic */ d1 a;
        final /* synthetic */ b0 b;
        n(d1 d1Var) {
            this.b = b0Var;
            this.a = d1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.c.c(this.a);
        }
    }

    class o implements Runnable {

        final /* synthetic */ b0 a;
        o() {
            this.a = b0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.c.k();
        }
    }

    private static class p implements r {

        private final r a;
        private volatile boolean b;
        private List<Runnable> c = new ArrayList<>();
        public p(r rVar) {
            super();
            final ArrayList arrayList = new ArrayList();
            this.a = rVar;
        }

        static /* synthetic */ r e(b0.p pVar) {
            return pVar.a;
        }

        private void f(Runnable runnable) {
            synchronized (this) {
                try {
                    if (!this.b) {
                        this.c.add(runnable);
                        return;
                    }
                } catch (Throwable th) {
                }
            }
            th.run();
        }

        public void a(k2.a aVar) {
            if (this.b) {
                this.a.a(aVar);
            } else {
                f(new b0.p.a(this, aVar));
            }
        }

        public void b(t0 t0Var) {
            f(new b0.p.c(this, t0Var));
        }

        public void c() {
            if (this.b) {
                this.a.c();
            } else {
                f(new b0.p.b(this));
            }
        }

        public void d(d1 d1Var, r.a aVar, t0 t0Var) {
            f(new b0.p.d(this, d1Var, aVar, t0Var));
        }

        public void g() {
            ArrayList arrayList;
            boolean hasNext;
            arrayList = new ArrayList();
            synchronized (this) {
                try {
                    this.c = null;
                    this.b = true;
                    return;
                } catch (Throwable th) {
                }
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                (Runnable)it.next().run();
            }
            list.clear();
            arrayList = list;
        }

    }
    b0() {
        super();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
    }

    static /* synthetic */ q p(b0 b0Var) {
        return b0Var.c;
    }

    static /* synthetic */ void r(b0 b0Var) {
        b0Var.t();
    }

    private void s(Runnable runnable) {
        boolean z = false;
        int r0 = this.b != null ? 1 : 0;
        n.v((this.b != null ? 1 : 0), "May only be called after start");
        synchronized (this) {
            try {
                if (!this.a) {
                    this.e.add(runnable);
                    return;
                }
            } catch (Throwable th) {
            }
        }
        th.run();
    }

    private void t() {
        ArrayList arrayList;
        boolean hasNext;
        arrayList = new ArrayList();
        synchronized (this) {
            try {
                this.e = null;
                this.a = true;
            } catch (Throwable th) {
            }
            try {
                this.e = arrayList;
            } catch (Throwable th) {
            }
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                (Runnable)it.next().run();
            }
            this.e.clear();
            arrayList = list;
        }
        if (this.f != null) {
            this.f.g();
        }
    }

    private void u(r rVar) {
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            (Runnable)it.next().run();
        }
        this.i = null;
        this.c.m(rVar);
    }

    private void w(q qVar) {
        boolean z = true;
        int r1 = this.c == null ? 1 : 0;
        n.x((this.c == null ? 1 : 0), "realStream already set to %s", this.c);
        this.c = qVar;
        this.h = System.nanoTime();
    }

    public boolean a() {
        if (this.a) {
            return this.c.a();
        }
        return false;
    }

    public void b(boolean z) {
        boolean z2 = true;
        int r0 = this.b != null ? 1 : 0;
        n.v((this.b != null ? 1 : 0), "May only be called after start");
        if (this.a) {
            this.c.b(z);
        } else {
            s(new b0.f(this, z));
        }
    }

    public void c(d1 d1Var) {
        boolean z;
        int i = 1;
        i = 1;
        i = 0;
        int r0 = this.b != null ? 1 : i;
        n.v((this.b != null ? 1 : i), "May only be called after start");
        n.p(d1Var, (this.b != null ? 1 : i));
        synchronized (this) {
            try {
                if (this.c == null) {
                    w(o1.a);
                    this.d = d1Var;
                }
            } catch (Throwable th) {
            }
        }
        if (i != 0) {
            s(new b0.n(this, th));
        } else {
            t();
            v(th);
            this.b.d(th, r.a.PROCESSED, new t0());
        }
    }

    public void d(o oVar) {
        boolean z = true;
        int r0 = this.b == null ? 1 : 0;
        n.v((this.b == null ? 1 : 0), "May only be called before start");
        n.p(oVar, (this.b == null ? 1 : 0));
        (this.b == null ? 1 : 0).add(new b0.c(this, oVar));
    }

    public void e(int i) {
        boolean z = true;
        int r0 = this.b != null ? 1 : 0;
        n.v((this.b != null ? 1 : 0), "May only be called after start");
        if (this.a) {
            this.c.e(i);
        } else {
            s(new b0.a(this, i));
        }
    }

    public void f(int i) {
        boolean z = true;
        int r0 = this.b == null ? 1 : 0;
        n.v((this.b == null ? 1 : 0), "May only be called before start");
        (this.b == null ? 1 : 0).add(new b0.g(this, i));
    }

    public void flush() {
        boolean z = true;
        int r0 = this.b != null ? 1 : 0;
        n.v((this.b != null ? 1 : 0), "May only be called after start");
        if (this.a) {
            this.c.flush();
        } else {
            s(new b0.m(this));
        }
    }

    public void g(int i) {
        boolean z = true;
        int r0 = this.b == null ? 1 : 0;
        n.v((this.b == null ? 1 : 0), "May only be called before start");
        (this.b == null ? 1 : 0).add(new b0.h(this, i));
    }

    public a getAttributes() {
        synchronized (this) {
            try {
            } catch (Throwable th) {
            }
        }
        if (this.c != null) {
            return this.c.getAttributes();
        }
        return a.b;
    }

    public void h(w wVar) {
        boolean z = true;
        int r0 = this.b == null ? 1 : 0;
        n.v((this.b == null ? 1 : 0), "May only be called before start");
        n.p(wVar, (this.b == null ? 1 : 0));
        (this.b == null ? 1 : 0).add(new b0.e(this, wVar));
    }

    public void i(String str) {
        boolean z = true;
        int r0 = this.b == null ? 1 : 0;
        n.v((this.b == null ? 1 : 0), "May only be called before start");
        n.p(str, (this.b == null ? 1 : 0));
        (this.b == null ? 1 : 0).add(new b0.k(this, str));
    }

    public void j(x0 x0Var) {
        synchronized (this) {
            try {
                if (this.b == null) {
                    return;
                }
                if (this.c != null) {
                    x0Var.b("buffered_nanos", Long.valueOf(this.h - this.g));
                    this.c.j(x0Var);
                } else {
                    x0Var.b("buffered_nanos", Long.valueOf(System.nanoTime() - this.g));
                    str = "waiting_for_connection";
                    x0Var.a(str);
                }
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public void k() {
        boolean z = true;
        int r0 = this.b != null ? 1 : 0;
        n.v((this.b != null ? 1 : 0), "May only be called after start");
        s((this.b != null ? 1 : 0));
    }

    public void l(u uVar) {
        boolean z = true;
        int r0 = this.b == null ? 1 : 0;
        n.v((this.b == null ? 1 : 0), "May only be called before start");
        (this.b == null ? 1 : 0).add(new b0.i(this, uVar));
    }

    public void m(r rVar) {
        boolean z = false;
        io.grpc.j1.b0.p pVar;
        n.p(rVar, "listener");
        int r0 = this.b == null ? 1 : 0;
        n.v((this.b == null ? 1 : 0), "already started");
        synchronized (this) {
            try {
                if (!this.a) {
                    pVar = new b0.p(rVar);
                    this.f = pVar;
                }
                this.b = pVar;
                this.g = System.nanoTime();
            } catch (Throwable th) {
            }
        }
        if (this.d != null) {
            pVar.d(this.d, r.a.PROCESSED, new t0());
            return;
        }
        if (this.a) {
            u(pVar);
        }
    }

    public void n(InputStream inputStream) {
        boolean z = true;
        int r0 = this.b != null ? 1 : 0;
        n.v((this.b != null ? 1 : 0), "May only be called after start");
        n.p(inputStream, (this.b != null ? 1 : 0));
        if (this.a) {
            this.c.n(inputStream);
        } else {
            s(new b0.l(this, inputStream));
        }
    }

    public void o() {
        boolean z = true;
        int r0 = this.b == null ? 1 : 0;
        n.v((this.b == null ? 1 : 0), "May only be called before start");
        (this.b == null ? 1 : 0).add(new b0.b(this));
    }

    public void q(boolean z) {
        boolean z2 = true;
        int r0 = this.b == null ? 1 : 0;
        n.v((this.b == null ? 1 : 0), "May only be called before start");
        (this.b == null ? 1 : 0).add(new b0.d(this, z));
    }

    final Runnable x(q qVar) {
        synchronized (this) {
            try {
                final List list = null;
                if (this.c != null) {
                    return list;
                }
                str = "stream";
                n.p(qVar, str);
                w(qVar);
                if (this.b == null) {
                    this.e = list;
                    this.a = true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.b == null) {
            return list;
        }
        u(this.b);
        return new b0.j(this);
    }


    protected void v(d1 d1Var) {
    }
}
