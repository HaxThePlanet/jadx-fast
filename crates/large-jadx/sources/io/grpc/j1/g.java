package io.grpc.j1;

import com.google.common.base.n;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes3.dex */
final class g implements io.grpc.j1.l1.b {

    private final io.grpc.j1.g.d a;
    private final io.grpc.j1.l1.b b;
    private final Queue<InputStream> c;

    class a implements Runnable {

        final int a;
        final io.grpc.j1.g b;
        a(io.grpc.j1.g g, int i2) {
            this.b = g;
            this.a = i2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            g.e(this.b).c(this.a);
        }
    }

    class b implements Runnable {

        final boolean a;
        final io.grpc.j1.g b;
        b(io.grpc.j1.g g, boolean z2) {
            this.b = g;
            this.a = z2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            g.e(this.b).b(this.a);
        }
    }

    class c implements Runnable {

        final Throwable a;
        final io.grpc.j1.g b;
        c(io.grpc.j1.g g, Throwable throwable2) {
            this.b = g;
            this.a = throwable2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            g.e(this.b).d(this.a);
        }
    }

    public interface d {
        public abstract void e(Runnable runnable);
    }
    public g(io.grpc.j1.l1.b l1$b, io.grpc.j1.g.d g$d2) {
        super();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.c = arrayDeque;
        n.p(b, "listener");
        this.b = (l1.b)b;
        n.p(d2, "transportExecutor");
        this.a = (g.d)d2;
    }

    static io.grpc.j1.l1.b e(io.grpc.j1.g g) {
        return g.b;
    }

    @Override // io.grpc.j1.l1$b
    public void a(io.grpc.j1.k2.a k2$a) {
        final InputStream next = a.next();
        while (next != null) {
            this.c.add(next);
            next = a.next();
        }
    }

    @Override // io.grpc.j1.l1$b
    public void b(boolean z) {
        g.b bVar = new g.b(this, z);
        this.a.e(bVar);
    }

    @Override // io.grpc.j1.l1$b
    public void c(int i) {
        g.a aVar = new g.a(this, i);
        this.a.e(aVar);
    }

    @Override // io.grpc.j1.l1$b
    public void d(Throwable throwable) {
        g.c cVar = new g.c(this, throwable);
        this.a.e(cVar);
    }

    @Override // io.grpc.j1.l1$b
    public InputStream f() {
        return (InputStream)this.c.poll();
    }
}
