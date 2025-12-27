package io.grpc.j1;

import com.google.common.base.n;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: ApplicationThreadDeframerListener.java */
/* loaded from: classes3.dex */
final class g implements l1.b {

    private final g.d a;
    private final l1.b b;
    private final Queue<InputStream> c = new ArrayDeque<>();

    class a implements Runnable {

        final /* synthetic */ int a;
        final /* synthetic */ g b;
        a(int i) {
            this.b = gVar;
            this.a = i;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.b.c(this.a);
        }
    }

    class b implements Runnable {

        final /* synthetic */ boolean a;
        final /* synthetic */ g b;
        b(boolean z) {
            this.b = gVar;
            this.a = z;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.b.b(this.a);
        }
    }

    class c implements Runnable {

        final /* synthetic */ Throwable a;
        final /* synthetic */ g b;
        c(Throwable th) {
            this.b = gVar;
            this.a = th;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.b.d(this.a);
        }
    }

    public interface d {
        void e(Runnable runnable);
    }
    public g(l1.b bVar, g.d dVar) {
        super();
        ArrayDeque arrayDeque = new ArrayDeque();
        n.p(bVar, "listener");
        this.b = bVar;
        n.p(dVar, "transportExecutor");
        this.a = dVar;
    }

    static /* synthetic */ l1.b e(g gVar) {
        return gVar.b;
    }

    public void a(k2.a aVar) {
        final InputStream next = aVar.next();
        while (next != null) {
            this.c.add(next);
            next = aVar.next();
        }
    }

    public void b(boolean z) {
        this.a.e(new g.b(this, z));
    }

    public void c(int i) {
        this.a.e(new g.a(this, i));
    }

    public void d(Throwable th) {
        this.a.e(new g.c(this, th));
    }

    public InputStream f() {
        return (InputStream)this.c.poll();
    }
}
