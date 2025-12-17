package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class bb implements Iterator<String> {

    final Iterator<String> a;
    final com.google.android.gms.internal.measurement.cb b;
    bb(com.google.android.gms.internal.measurement.cb cb) {
        this.b = cb;
        super();
        this.a = cb.b(cb).iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String)this.a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}
