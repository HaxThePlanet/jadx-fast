package com.google.common.collect;

import com.google.common.base.n;
import java.util.Iterator;

/* loaded from: classes2.dex */
abstract class a1<F, T>  implements Iterator<T> {

    final Iterator<? extends F> a;
    a1(Iterator<? extends F> iterator) {
        super();
        n.o(iterator);
        this.a = (Iterator)iterator;
    }

    abstract T b(F f);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    public final T next() {
        return b(this.a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.a.remove();
    }
}
