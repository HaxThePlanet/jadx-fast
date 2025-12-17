package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;

/* loaded from: classes2.dex */
final class n0 extends com.google.common.collect.p0<Comparable> implements Serializable {

    static final com.google.common.collect.n0 a;
    private static final long serialVersionUID;
    static {
        n0 n0Var = new n0();
        n0.a = n0Var;
    }

    private Object readResolve() {
        return n0.a;
    }

    @Override // com.google.common.collect.p0
    public int compare(Object object, Object object2) {
        return g((Comparable)object, (Comparable)object2);
    }

    public <S extends Comparable> com.google.common.collect.p0<S> f() {
        return u0.a;
    }

    @Override // com.google.common.collect.p0
    public int g(Comparable comparable, Comparable comparable2) {
        n.o(comparable);
        n.o(comparable2);
        return comparable.compareTo(comparable2);
    }

    @Override // com.google.common.collect.p0
    public String toString() {
        return "Ordering.natural()";
    }
}
