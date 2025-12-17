package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class na implements Iterator<Object> {
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    @Override // java.util.Iterator
    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}
