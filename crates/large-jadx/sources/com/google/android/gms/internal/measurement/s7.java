package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
abstract class s7 implements com.google.android.gms.internal.measurement.u7 {
    @Override // com.google.android.gms.internal.measurement.u7
    public final Object next() {
        return Byte.valueOf(zza());
    }

    @Override // com.google.android.gms.internal.measurement.u7
    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}
