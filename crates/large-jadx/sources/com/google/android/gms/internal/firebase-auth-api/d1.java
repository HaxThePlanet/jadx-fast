package com.google.android.gms.internal.firebase-auth-api;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class d1 implements Iterator<String> {

    final Iterator<String> a;
    final com.google.android.gms.internal.firebase-auth-api.e1 b;
    d1(com.google.android.gms.internal.firebase-auth-api.e1 e1) {
        this.b = e1;
        super();
        this.a = e1.b(e1).iterator();
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
