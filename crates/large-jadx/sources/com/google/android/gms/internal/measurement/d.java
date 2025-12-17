package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class d implements Iterator<com.google.android.gms.internal.measurement.q> {

    final Iterator a;
    final Iterator b;
    d(com.google.android.gms.internal.measurement.f f, Iterator iterator2, Iterator iterator3) {
        this.a = iterator2;
        this.b = iterator3;
        super();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.a.hasNext()) {
            return 1;
        }
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        com.google.android.gms.internal.measurement.u uVar;
        Object string;
        if (this.a.hasNext()) {
            uVar = new u((Integer)this.a.next().toString());
            return uVar;
        } else {
            if (!this.b.hasNext()) {
            } else {
                uVar = new u((String)this.b.next());
            }
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}
