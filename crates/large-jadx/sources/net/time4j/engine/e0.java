package net.time4j.engine;

import java.util.Objects;

/* loaded from: classes3.dex */
public final class e0<T extends net.time4j.engine.q<T>>  implements net.time4j.engine.u<T> {

    private final int a;
    private final net.time4j.engine.p<?> b;
    private final Object c;
    private e0(int i, net.time4j.engine.p<?> p2) {
        super(i, p2, 0);
    }

    private e0(int i, net.time4j.engine.p<?> p2, Object object3) {
        super();
        Objects.requireNonNull(p2, "Missing chronological element.");
        this.a = i;
        this.b = p2;
        this.c = object3;
    }

    private static <U, T extends net.time4j.engine.i0<U, T>> T a(net.time4j.engine.i0<U, T> i0, net.time4j.engine.p<?> p2, boolean z3) {
        final Object obj3 = i0.J().F(p2);
        int i = 1;
        if (z3) {
            return i0.M(i, obj1);
        }
        return i0.L(i, obj1);
    }

    public static <T extends net.time4j.engine.q<T>> net.time4j.engine.u<T> c(net.time4j.engine.p<?> p) {
        e0 e0Var = new e0(4, p);
        return e0Var;
    }

    public static <T extends net.time4j.engine.q<T>> net.time4j.engine.u<T> d(net.time4j.engine.p<?> p) {
        e0 e0Var = new e0(3, p);
        return e0Var;
    }

    private <V> T e(net.time4j.engine.q<T> q, net.time4j.engine.p<V> p2) {
        net.time4j.engine.w wVar;
        net.time4j.engine.q obj2;
        net.time4j.engine.p obj3;
        obj2 = q.z();
        obj3 = obj2.y().v(obj3).getChildAtCeiling(obj2);
        while (obj3 != null) {
            obj2 = q(obj2, obj3);
            obj3 = obj2.y().v(obj3).getChildAtCeiling(obj2);
        }
        return obj2;
    }

    public static <T extends net.time4j.engine.q<T>> net.time4j.engine.u<T> f(net.time4j.engine.p<?> p) {
        e0 e0Var = new e0(6, p);
        return e0Var;
    }

    private <V> T g(net.time4j.engine.q<T> q, net.time4j.engine.p<V> p2) {
        net.time4j.engine.w wVar;
        net.time4j.engine.q obj2;
        net.time4j.engine.p obj3;
        obj2 = q.z();
        obj3 = obj2.y().v(obj3).getChildAtFloor(obj2);
        while (obj3 != null) {
            obj2 = r(obj2, obj3);
            obj3 = obj2.y().v(obj3).getChildAtFloor(obj2);
        }
        return obj2;
    }

    public static <T extends net.time4j.engine.q<T>> net.time4j.engine.u<T> h(net.time4j.engine.p<?> p) {
        e0 e0Var = new e0(7, p);
        return e0Var;
    }

    private <V> T i(net.time4j.engine.q<T> q, net.time4j.engine.p<V> p2) {
        return q.G(p2, q.r(p2));
    }

    public static <T extends net.time4j.engine.q<T>> net.time4j.engine.u<T> j(net.time4j.engine.p<?> p) {
        e0 e0Var = new e0(2, p);
        return e0Var;
    }

    private <V> T k(net.time4j.engine.q<T> q, net.time4j.engine.p<V> p2) {
        return q.G(p2, q.w(p2));
    }

    public static <T extends net.time4j.engine.q<T>> net.time4j.engine.u<T> l(net.time4j.engine.p<?> p) {
        e0 e0Var = new e0(1, p);
        return e0Var;
    }

    private T m(T t, boolean z2) {
        if (!t instanceof i0) {
        } else {
            return (q)t.y().l().cast(e0.a((i0)i0.class.cast(t), this.b, z2));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Base units not supported by: ");
        stringBuilder.append(t.y().l());
        ChronoException obj4 = new ChronoException(stringBuilder.toString());
        throw obj4;
    }

    public static <T extends net.time4j.engine.q<T>, V> net.time4j.engine.u<T> n(V v, net.time4j.engine.p<V> p2) {
        e0 e0Var = new e0(0, p2, v);
        return e0Var;
    }

    public static <T extends net.time4j.engine.q<T>, V> net.time4j.engine.u<T> o(V v, net.time4j.engine.p<V> p2) {
        e0 e0Var = new e0(5, p2, v);
        return e0Var;
    }

    private <V> T p(net.time4j.engine.q<T> q, net.time4j.engine.p<V> p2, Object object3, boolean z4) {
        net.time4j.engine.q obj2 = q.z();
        return (q)obj2.y().v(p2).withValue(obj2, p2.getType().cast(object3), z4);
    }

    private <V> T q(T t, net.time4j.engine.p<V> p2) {
        net.time4j.engine.y yVar = t.y().v(p2);
        return (q)yVar.withValue(t, yVar.getMaximum(t), p2.isLenient());
    }

    private <V> T r(T t, net.time4j.engine.p<V> p2) {
        net.time4j.engine.y yVar = t.y().v(p2);
        return (q)yVar.withValue(t, yVar.getMinimum(t), p2.isLenient());
    }

    @Override // net.time4j.engine.u
    public Object apply(Object object) {
        return b((q)object);
    }

    public T b(T t) {
        int i3 = 1;
        int i5 = 0;
        switch (i2) {
            case 0:
                return p(t, this.b, this.c, i5);
            case 1:
                return k(t, this.b);
            case 2:
                return i(t, this.b);
            case 3:
                return g(t, this.b);
            case 4:
                return e(t, this.b);
            case 5:
                return p(t, this.b, this.c, i3);
            case 6:
                return m(t, i5);
            case 7:
                return m(t, i3);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown mode: ");
                stringBuilder.append(this.a);
                UnsupportedOperationException obj4 = new UnsupportedOperationException(stringBuilder.toString());
                throw obj4;
        }
    }
}
