package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;

/* loaded from: classes2.dex */
final class u0 extends com.google.common.collect.p0<Comparable> implements Serializable {

    static final com.google.common.collect.u0 a;
    private static final long serialVersionUID;
    static {
        u0 u0Var = new u0();
        u0.a = u0Var;
    }

    private Object readResolve() {
        return u0.a;
    }

    @Override // com.google.common.collect.p0
    public int compare(Object object, Object object2) {
        return g((Comparable)object, (Comparable)object2);
    }

    public <S extends Comparable> com.google.common.collect.p0<S> f() {
        return p0.c();
    }

    @Override // com.google.common.collect.p0
    public int g(Comparable comparable, Comparable comparable2) {
        n.o(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.common.collect.p0
    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
