package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;

/* loaded from: classes2.dex */
final class v0<T>  extends com.google.common.collect.p0<T> implements Serializable {

    private static final long serialVersionUID;
    final com.google.common.collect.p0<? super T> forwardOrder;
    v0(com.google.common.collect.p0<? super T> p0) {
        super();
        n.o(p0);
        this.forwardOrder = (p0)p0;
    }

    public int compare(T t, T t2) {
        return this.forwardOrder.compare(t2, t);
    }

    @Override // com.google.common.collect.p0
    public boolean equals(Object object) {
        if (object == this) {
            return 1;
        }
        if (object instanceof v0) {
            return this.forwardOrder.equals(object.forwardOrder);
        }
        return 0;
    }

    public <S extends T> com.google.common.collect.p0<S> f() {
        return this.forwardOrder;
    }

    @Override // com.google.common.collect.p0
    public int hashCode() {
        return -i;
    }

    @Override // com.google.common.collect.p0
    public String toString() {
        String valueOf = String.valueOf(this.forwardOrder);
        StringBuilder stringBuilder = new StringBuilder(length += 10);
        stringBuilder.append(valueOf);
        stringBuilder.append(".reverse()");
        return stringBuilder.toString();
    }
}
