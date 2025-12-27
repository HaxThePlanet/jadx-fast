package io.grpc.j1;

/* compiled from: SharedResourcePool.java */
/* loaded from: classes3.dex */
public final class g2<T> implements p1<T> {

    private final f2.d<T> a;
    private g2(f2.d<T> dVar) {
        super();
        this.a = dVar;
    }

    public static <T> g2<T> c(f2.d<T> dVar) {
        return new g2(dVar);
    }

    public T a() {
        return f2.d(this.a);
    }

    public T b(Object object) {
        f2.f(this.a, object);
        return null;
    }
}
