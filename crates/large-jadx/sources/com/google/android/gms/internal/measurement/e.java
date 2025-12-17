package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class e implements Iterator<com.google.android.gms.internal.measurement.q> {

    private int a = 0;
    final com.google.android.gms.internal.measurement.f b;
    e(com.google.android.gms.internal.measurement.f f) {
        this.b = f;
        super();
        final int obj1 = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.a < this.b.q()) {
            return 1;
        }
        return 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.a >= this.b.q()) {
        } else {
            int i3 = this.a;
            this.a = i3 + 1;
            return this.b.s(i3);
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("Out of bounds index: ");
        stringBuilder.append(this.a);
        NoSuchElementException noSuchElementException = new NoSuchElementException(stringBuilder.toString());
        throw noSuchElementException;
    }
}
