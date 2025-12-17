package io.grpc.j1;

import com.google.common.base.n;

/* loaded from: classes3.dex */
public final class o2 {

    private static final io.grpc.j1.o2.b i;
    private final io.grpc.j1.l2 a;
    private long b;
    private long c;
    private long d;
    private long e;
    private io.grpc.j1.o2.c f;
    private long g;
    private final io.grpc.j1.e1 h;

    static class a {
    }

    public static final class b {

        private final io.grpc.j1.l2 a;
        public b(io.grpc.j1.l2 l2) {
            super();
            this.a = l2;
        }

        public io.grpc.j1.o2 a() {
            o2 o2Var = new o2(this.a, 0);
            return o2Var;
        }
    }

    public interface c {
    }
    static {
        o2.b bVar = new o2.b(l2.a);
        o2.i = bVar;
    }

    public o2() {
        super();
        this.h = f1.a();
        this.a = l2.a;
    }

    private o2(io.grpc.j1.l2 l2) {
        super();
        this.h = f1.a();
        this.a = l2;
    }

    o2(io.grpc.j1.l2 l2, io.grpc.j1.o2.a o2$a2) {
        super(l2);
    }

    public static io.grpc.j1.o2.b a() {
        return o2.i;
    }

    public void b() {
        this.e = l += i2;
    }

    public void c() {
        this.b = l += i2;
        this.a.a();
    }

    public void d() {
        this.h.add(1);
        this.a.a();
    }

    public void e(int i) {
        if (i == 0) {
        }
        this.g = l += l2;
        this.a.a();
    }

    public void f(boolean z) {
        int i;
        final int i2 = 1;
        if (z) {
            this.c = l += i2;
        } else {
            this.d = l2 += i2;
        }
    }

    public void g(io.grpc.j1.o2.c o2$c) {
        n.o(c);
        this.f = (o2.c)c;
    }
}
