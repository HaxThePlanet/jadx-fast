package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
final class ab implements ListIterator<String> {

    final ListIterator<String> a;
    final int b;
    final com.google.android.gms.internal.measurement.cb c;
    ab(com.google.android.gms.internal.measurement.cb cb, int i2) {
        this.c = cb;
        this.b = i2;
        super();
        this.a = cb.b(cb).listIterator(i2);
    }

    @Override // java.util.ListIterator
    public final void add(Object object) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // java.util.ListIterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.a.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final Object next() {
        return (String)this.a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return (String)this.a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.a.previousIndex();
    }

    @Override // java.util.ListIterator
    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // java.util.ListIterator
    public final void set(Object object) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }
}
