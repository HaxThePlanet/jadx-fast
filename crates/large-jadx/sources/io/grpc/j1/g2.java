package io.grpc.j1;

/* loaded from: classes3.dex */
public final class g2<T>  implements io.grpc.j1.p1<T> {

    private final io.grpc.j1.f2.d<T> a;
    private g2(io.grpc.j1.f2.d<T> f2$d) {
        super();
        this.a = d;
    }

    public static <T> io.grpc.j1.g2<T> c(io.grpc.j1.f2.d<T> f2$d) {
        g2 g2Var = new g2(d);
        return g2Var;
    }

    public T a() {
        return f2.d(this.a);
    }

    public T b(Object object) {
        f2.f(this.a, object);
        return 0;
    }
}
