package net.time4j.engine;

import java.util.Objects;

/* compiled from: StdOperator.java */
/* loaded from: classes3.dex */
public final class e0<T extends q<T>> implements u<T> {

    private final int a;
    private final p<?> b;
    private final Object c;
    private e0(int i, p<?> pVar) {
        this(i, pVar, null);
    }

    private static <U, T extends i0<U, T>> T a(i0<U, T> i0Var, p<?> pVar, boolean z) {
        final Object obj2 = i0Var.J().F(pVar);
        long l = 1L;
        if (z) {
            return i0Var.M(l, obj2);
        }
        return i0Var.L(l, obj2);
    }

    public static <T extends q<T>> u<T> c(p<?> pVar) {
        return new e0(4, pVar);
    }

    public static <T extends q<T>> u<T> d(p<?> pVar) {
        return new e0(3, pVar);
    }

    private <V> T e(q<T> qVar, p<V> pVar) {
        net.time4j.engine.q qVar2;
        net.time4j.engine.p childAtCeiling;
        qVar2 = qVar.z();
        childAtCeiling = qVar2.y().v(childAtCeiling).getChildAtCeiling(qVar2);
        while (childAtCeiling != null) {
            qVar2 = q(qVar2, childAtCeiling);
            childAtCeiling = qVar2.y().v(childAtCeiling).getChildAtCeiling(qVar2);
        }
        return qVar2;
    }

    public static <T extends q<T>> u<T> f(p<?> pVar) {
        return new e0(6, pVar);
    }

    private <V> T g(q<T> qVar, p<V> pVar) {
        net.time4j.engine.q qVar2;
        net.time4j.engine.p childAtFloor;
        qVar2 = qVar.z();
        childAtFloor = qVar2.y().v(childAtFloor).getChildAtFloor(qVar2);
        while (childAtFloor != null) {
            qVar2 = r(qVar2, childAtFloor);
            childAtFloor = qVar2.y().v(childAtFloor).getChildAtFloor(qVar2);
        }
        return qVar2;
    }

    public static <T extends q<T>> u<T> h(p<?> pVar) {
        return new e0(7, pVar);
    }

    private <V> T i(q<T> qVar, p<V> pVar) {
        return qVar.G(pVar, qVar.r(pVar));
    }

    public static <T extends q<T>> u<T> j(p<?> pVar) {
        return new e0(2, pVar);
    }

    private <V> T k(q<T> qVar, p<V> pVar) {
        return qVar.G(pVar, qVar.w(pVar));
    }

    public static <T extends q<T>> u<T> l(p<?> pVar) {
        return new e0(1, pVar);
    }

    private T m(T t, boolean z) throws ChronoException {
        if (!(t instanceof i0)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Base units not supported by: ";
            Class cls2 = t.y().l();
            t = str + cls2;
            throw new ChronoException(t);
        } else {
            return (q)t.y().l().cast(e0.a((i0)i0.class.cast(t), this.b, z));
        }
    }

    public static <T extends q<T>, V> u<T> n(V v, p<V> pVar) {
        return new e0(0, pVar, v);
    }

    public static <T extends q<T>, V> u<T> o(V v, p<V> pVar) {
        return new e0(5, pVar, v);
    }

    private <V> T p(q<T> qVar, p<V> pVar, Object object, boolean z) {
        net.time4j.engine.q qVar2 = qVar.z();
        return (q)qVar2.y().v(pVar).withValue(qVar2, pVar.getType().cast(object), z);
    }

    private <V> T q(T t, p<V> pVar) {
        net.time4j.engine.y yVar = t.y().v(pVar);
        return (q)yVar.withValue(t, yVar.getMaximum(t), pVar.isLenient());
    }

    private <V> T r(T t, p<V> pVar) {
        net.time4j.engine.y yVar = t.y().v(pVar);
        return (q)yVar.withValue(t, yVar.getMinimum(t), pVar.isLenient());
    }

    public T b(T t) {
        boolean z = true;
        boolean z2 = false;
        switch (this.a) {
            case 0:
                return this.p(t, this.b, this.c, z2);
            case 1:
                return this.k(t, this.b);
            case 2:
                return this.i(t, this.b);
            case 3:
                return this.g(t, this.b);
            case 4:
                return this.e(t, this.b);
            case 5:
                return this.p(t, this.b, this.c, this.c);
            case 6:
                return this.m(t, this.c);
            case 7:
                return this.m(t, this.c);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Unknown mode: ";
                r0 = str + this.a;
                throw new UnsupportedOperationException(str + i3);
        }
    }

    private e0(int i, p<?> pVar, Object object) {
        super();
        Objects.requireNonNull(pVar, "Missing chronological element.");
        this.a = i;
        this.b = pVar;
        this.c = object;
    }
}
