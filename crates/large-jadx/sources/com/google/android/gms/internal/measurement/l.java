package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class l implements Iterator<com.google.android.gms.internal.measurement.q> {

    final Iterator a;
    l(Iterator iterator) {
        this.a = iterator;
        super();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        u uVar = new u((String)this.a.next());
        return uVar;
    }
}
