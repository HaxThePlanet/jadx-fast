package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.v;
import java.io.Closeable;
import java.io.InputStream;

/* compiled from: ApplicationThreadDeframer.java */
/* loaded from: classes3.dex */
public class f implements y {

    private final l1.b a = new h2();
    private final g b = new g();
    private final l1 c;

    class a implements Runnable {

        final /* synthetic */ int a;
        final /* synthetic */ f b;
        a(int i) {
            this.b = fVar;
            this.a = i;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b.c.isClosed()) {
                return;
            }
            try {
                this.b.c.e(this.a);
            } catch (Throwable th) {
                io.grpc.j1.f fVar3 = this.b.b;
                this.b.d(th);
                th = this.b.c;
                this.b.close();
            }
        }
    }

    class b implements Runnable {

        final /* synthetic */ v1 a;
        final /* synthetic */ f b;
        b(v1 v1Var) {
            this.b = fVar;
            this.a = v1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.c.k(this.a);
            } catch (Throwable th) {
                io.grpc.j1.f fVar2 = this.b.b;
                this.b.d(th);
                th = this.b.c;
                this.b.close();
            }
        }
    }

    class c implements Closeable {

        final /* synthetic */ v1 a;
        c(v1 v1Var) {
            this.a = v1Var;
            super();
        }

        @Override // java.io.Closeable
        public void close() {
            this.a.close();
        }
    }

    class d implements Runnable {

        final /* synthetic */ f a;
        d() {
            this.a = fVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.c.i();
        }
    }

    class e implements Runnable {

        final /* synthetic */ f a;
        e() {
            this.a = fVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.c.close();
        }
    }

    private class g implements k2.a {

        private final Runnable a;
        private boolean b;
        final /* synthetic */ f c;
        /* synthetic */ g(Runnable runnable, f.a aVar) {
            this(fVar, runnable);
        }

        private void a() {
            if (!this.b) {
                this.a.run();
                boolean z = true;
                this.b = z;
            }
        }

        public InputStream next() {
            a();
            return this.c.b.f();
        }

        private g(Runnable runnable) {
            this.c = fVar;
            super();
            this.b = false;
            this.a = runnable;
        }
    }

    interface h extends g.d {
    }

    private class f extends f.g implements Closeable {

        private final Closeable v;
        public f(Runnable runnable, Closeable closeable) {
            super(fVar, runnable, null);
            this.v = closeable;
        }

        @Override // io.grpc.j1.f$g
        public void close() throws java.io.IOException {
            this.v.close();
        }
    }
    f(l1.b bVar, f.h hVar, l1 l1Var) {
        super();
        n.p(bVar, "listener");
        l1Var.E(new g(new h2(bVar), hVar));
        this.c = l1Var;
    }

    static /* synthetic */ l1 a(f fVar) {
        return fVar.c;
    }

    static /* synthetic */ g b(f fVar) {
        return fVar.b;
    }

    public void close() {
        this.c.F();
        this.a.a(new f.g(this, new f.e(this), null));
    }

    public void e(int i) {
        this.a.a(new f.g(this, new f.a(this, i), null));
    }

    public void f(int i) {
        this.c.f(i);
    }

    public void i() {
        this.a.a(new f.g(this, new f.d(this), null));
    }

    public void j(v vVar) {
        this.c.j(vVar);
    }

    public void k(v1 v1Var) {
        this.a.a(new f.f(this, new f.b(this, v1Var), new f.c(this, v1Var)));
    }
}
