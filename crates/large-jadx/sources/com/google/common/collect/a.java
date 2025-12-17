package com.google.common.collect;

import com.google.common.base.n;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
abstract class a<E>  extends com.google.common.collect.c1<E> {

    private final int a;
    private int b;
    protected a(int i, int i2) {
        super();
        n.r(i2, i);
        this.a = i;
        this.b = i2;
    }

    protected abstract E b(int i);

    @Override // com.google.common.collect.c1
    public final boolean hasNext() {
        int i;
        i = this.b < this.a ? 1 : 0;
        return i;
    }

    @Override // com.google.common.collect.c1
    public final boolean hasPrevious() {
        int i;
        i = this.b > 0 ? 1 : 0;
        return i;
    }

    public final E next() {
        if (!hasNext()) {
        } else {
            int i = this.b;
            this.b = i + 1;
            return b(i);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    @Override // com.google.common.collect.c1
    public final int nextIndex() {
        return this.b;
    }

    public final E previous() {
        if (!hasPrevious()) {
        } else {
            i--;
            this.b = i2;
            return b(i2);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    @Override // com.google.common.collect.c1
    public final int previousIndex() {
        return i--;
    }
}
