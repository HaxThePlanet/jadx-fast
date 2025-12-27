package io.grpc.j1;

import com.google.common.base.n;

/* compiled from: TransportTracer.java */
/* loaded from: classes3.dex */
public final class o2 {

    private static final o2.b i = new o2$b();
    private final l2 a;
    private long b;
    private long c;
    private long d;
    private long e;
    private o2.c f;
    private long g;
    private final e1 h;

    static class a {
    }

    public static final class b {

        private final l2 a;
        public b(l2 l2Var) {
            super();
            this.a = l2Var;
        }

        public o2 a() {
            return new o2(this.a, null);
        }
    }

    public interface c {
    }
    static {
    }

    /* synthetic */ o2(l2 l2Var, o2.a aVar) {
        this(l2Var);
    }

    public static o2.b a() {
        return o2.i;
    }

    public void b() {
        this.e++;
    }

    public void c() {
        this.b++;
        this.a.a();
    }

    public void d() {
        this.h.add(1L);
        this.a.a();
    }

    public void e(int i) {
        if (i == 0) {
            return;
        }
        this.g += l3;
        this.a.a();
    }

    public void f(boolean z) {
        final long l2 = 1L;
        if (z) {
            this.c += l2;
        } else {
            this.d += l2;
        }
    }

    public void g(o2.c cVar) {
        n.o(cVar);
        this.f = cVar;
    }

    public o2() {
        super();
        this.h = f1.a();
        this.a = l2.a;
    }

    private o2(l2 l2Var) {
        super();
        this.h = f1.a();
        this.a = l2Var;
    }
}
