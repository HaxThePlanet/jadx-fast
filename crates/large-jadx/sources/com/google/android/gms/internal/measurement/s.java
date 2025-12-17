package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class s implements Iterator<com.google.android.gms.internal.measurement.q> {

    private int a = 0;
    final com.google.android.gms.internal.measurement.u b;
    s(com.google.android.gms.internal.measurement.u u) {
        this.b = u;
        super();
        final int obj1 = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.a < u.g(this.b).length()) {
            return 1;
        }
        return 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.a >= u.g(this.b).length()) {
        } else {
            int i2 = this.a;
            this.a = i2 + 1;
            u uVar = new u(String.valueOf(i2));
            return uVar;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}
