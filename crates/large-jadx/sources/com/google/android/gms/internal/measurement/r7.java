package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class r7 extends com.google.android.gms.internal.measurement.s7 {

    private int a = 0;
    private final int b;
    final com.google.android.gms.internal.measurement.x7 c;
    r7(com.google.android.gms.internal.measurement.x7 x7) {
        this.c = x7;
        super();
        final int i = 0;
        this.b = x7.g();
    }

    @Override // com.google.android.gms.internal.measurement.s7
    public final boolean hasNext() {
        if (this.a < this.b) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.s7
    public final byte zza() {
        int i = this.a;
        if (i >= this.b) {
        } else {
            this.a = i + 1;
            return this.c.d(i);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}
