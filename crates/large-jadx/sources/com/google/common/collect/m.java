package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class m<T>  extends com.google.common.collect.p0<T> implements Serializable {

    private static final long serialVersionUID;
    final Comparator<T> comparator;
    m(Comparator<T> comparator) {
        super();
        n.o(comparator);
        this.comparator = (Comparator)comparator;
    }

    public int compare(T t, T t2) {
        return this.comparator.compare(t, t2);
    }

    @Override // com.google.common.collect.p0
    public boolean equals(Object object) {
        if (object == this) {
            return 1;
        }
        if (object instanceof m) {
            return this.comparator.equals(object.comparator);
        }
        return 0;
    }

    @Override // com.google.common.collect.p0
    public int hashCode() {
        return this.comparator.hashCode();
    }

    @Override // com.google.common.collect.p0
    public String toString() {
        return this.comparator.toString();
    }
}
