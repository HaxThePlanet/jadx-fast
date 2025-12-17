package com.google.common.collect;

import com.google.common.base.g;
import com.google.common.base.k;
import com.google.common.base.n;
import java.io.Serializable;

/* loaded from: classes2.dex */
final class h<F, T>  extends com.google.common.collect.p0<F> implements Serializable {

    private static final long serialVersionUID;
    final g<F, ? extends T> function;
    final com.google.common.collect.p0<T> ordering;
    h(g<F, ? extends T> g, com.google.common.collect.p0<T> p02) {
        super();
        n.o(g);
        this.function = (g)g;
        n.o(p02);
        this.ordering = (p0)p02;
    }

    public int compare(F f, F f2) {
        return this.ordering.compare(this.function.apply(f), this.function.apply(f2));
    }

    @Override // com.google.common.collect.p0
    public boolean equals(Object object) {
        int i;
        boolean ordering;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof h) {
            if (this.function.equals(object.function) && this.ordering.equals(object.ordering)) {
                if (this.ordering.equals(object.ordering)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.common.collect.p0
    public int hashCode() {
        Object[] arr = new Object[2];
        return k.b(this.function, this.ordering);
    }

    @Override // com.google.common.collect.p0
    public String toString() {
        String valueOf = String.valueOf(this.ordering);
        String valueOf2 = String.valueOf(this.function);
        StringBuilder stringBuilder = new StringBuilder(i += length2);
        stringBuilder.append(valueOf);
        stringBuilder.append(".onResultOf(");
        stringBuilder.append(valueOf2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
