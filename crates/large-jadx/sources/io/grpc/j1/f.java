package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.v;
import java.io.Closeable;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class f implements io.grpc.j1.y {

    private final io.grpc.j1.l1.b a;
    private final io.grpc.j1.g b;
    private final io.grpc.j1.l1 c;

    class a implements Runnable {

        final int a;
        final io.grpc.j1.f b;
        a(io.grpc.j1.f f, int i2) {
            this.b = f;
            this.a = i2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            io.grpc.j1.l1 l1Var;
            int i;
            if (f.a(this.b).isClosed()) {
            }
            f.a(this.b).e(this.a);
        }
    }

    class b implements Runnable {

        final io.grpc.j1.v1 a;
        final io.grpc.j1.f b;
        b(io.grpc.j1.f f, io.grpc.j1.v1 v12) {
            this.b = f;
            this.a = v12;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            io.grpc.j1.l1 l1Var;
            io.grpc.j1.v1 v1Var;
            try {
                f.a(this.b).k(this.a);
                io.grpc.j1.f fVar2 = this.b;
                fVar2 = f.b(fVar2);
                fVar2.d(th);
                Throwable th = this.b;
                th = f.a(th);
                th.close();
            }
        }
    }

    class c implements Closeable {

        final io.grpc.j1.v1 a;
        c(io.grpc.j1.f f, io.grpc.j1.v1 v12) {
            this.a = v12;
            super();
        }

        @Override // java.io.Closeable
        public void close() {
            this.a.close();
        }
    }

    class d implements Runnable {

        final io.grpc.j1.f a;
        d(io.grpc.j1.f f) {
            this.a = f;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            f.a(this.a).i();
        }
    }

    class e implements Runnable {

        final io.grpc.j1.f a;
        e(io.grpc.j1.f f) {
            this.a = f;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            f.a(this.a).close();
        }
    }

    private class g implements io.grpc.j1.k2.a {

        private final Runnable a;
        private boolean b;
        final io.grpc.j1.f c;
        private g(io.grpc.j1.f f, Runnable runnable2) {
            this.c = f;
            super();
            this.b = false;
            this.a = runnable2;
        }

        g(io.grpc.j1.f f, Runnable runnable2, io.grpc.j1.f.a f$a3) {
            super(f, runnable2);
        }

        private void a() {
            boolean z;
            if (!this.b) {
                this.a.run();
                this.b = true;
            }
        }

        @Override // io.grpc.j1.k2$a
        public InputStream next() {
            a();
            return f.b(this.c).f();
        }
    }

    interface h extends io.grpc.j1.g.d {
    }

    private class f extends io.grpc.j1.f.g implements Closeable {

        private final Closeable v;
        public f(io.grpc.j1.f f, Runnable runnable2, Closeable closeable3) {
            super(f, runnable2, 0);
            this.v = closeable3;
        }

        @Override // io.grpc.j1.f$g
        public void close() {
            this.v.close();
        }
    }
    f(io.grpc.j1.l1.b l1$b, io.grpc.j1.f.h f$h2, io.grpc.j1.l1 l13) {
        super();
        n.p(b, "listener");
        h2 h2Var = new h2((l1.b)b);
        this.a = h2Var;
        g obj3 = new g(h2Var, h2);
        this.b = obj3;
        l13.E(obj3);
        this.c = l13;
    }

    static io.grpc.j1.l1 a(io.grpc.j1.f f) {
        return f.c;
    }

    static io.grpc.j1.g b(io.grpc.j1.f f) {
        return f.b;
    }

    @Override // io.grpc.j1.y
    public void close() {
        this.c.F();
        f.e eVar = new f.e(this);
        f.g gVar = new f.g(this, eVar, 0);
        this.a.a(gVar);
    }

    @Override // io.grpc.j1.y
    public void e(int i) {
        f.a aVar = new f.a(this, i);
        f.g gVar = new f.g(this, aVar, 0);
        this.a.a(gVar);
    }

    @Override // io.grpc.j1.y
    public void f(int i) {
        this.c.f(i);
    }

    @Override // io.grpc.j1.y
    public void i() {
        f.d dVar = new f.d(this);
        f.g gVar = new f.g(this, dVar, 0);
        this.a.a(gVar);
    }

    @Override // io.grpc.j1.y
    public void j(v v) {
        this.c.j(v);
    }

    @Override // io.grpc.j1.y
    public void k(io.grpc.j1.v1 v1) {
        f.b bVar2 = new f.b(this, v1);
        f.c cVar = new f.c(this, v1);
        f.f fVar = new f.f(this, bVar2, cVar);
        this.a.a(fVar);
    }
}
