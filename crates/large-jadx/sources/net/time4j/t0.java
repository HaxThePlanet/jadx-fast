package net.time4j;

import net.time4j.engine.u;

/* compiled from: ValueOperator.java */
/* loaded from: classes3.dex */
final class t0<T> implements u<T> {

    private final u<T> a;
    private final Object b;
    private t0(u<T> uVar, Object object) {
        super();
        this.a = uVar;
        this.b = object;
    }

    static <T> t0 a(u<T> uVar, Object object) {
        return new t0(uVar, object);
    }

    public T apply(T t) {
        return this.a.apply(t);
    }
}
