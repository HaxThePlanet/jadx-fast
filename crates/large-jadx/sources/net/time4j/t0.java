package net.time4j;

import net.time4j.engine.u;

/* loaded from: classes3.dex */
final class t0<T>  implements u<T> {

    private final u<T> a;
    private final Object b;
    private t0(u<T> u, Object object2) {
        super();
        this.a = u;
        this.b = object2;
    }

    static <T> net.time4j.t0 a(u<T> u, Object object2) {
        t0 t0Var = new t0(u, object2);
        return t0Var;
    }

    public T apply(T t) {
        return this.a.apply(t);
    }
}
