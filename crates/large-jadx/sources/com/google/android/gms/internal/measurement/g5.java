package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class g5 extends com.google.android.gms.internal.measurement.t8<com.google.android.gms.internal.measurement.h5, com.google.android.gms.internal.measurement.g5> implements com.google.android.gms.internal.measurement.z9 {
    private g5() {
        super(h5.A());
    }

    g5(com.google.android.gms.internal.measurement.g4 g4) {
        super(h5.A());
    }

    public final com.google.android.gms.internal.measurement.g5 s(Iterable<? extends Long> iterable) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        h5.D((h5)this.b, iterable);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.g5 t(int i) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        h5.C((h5)this.b, i);
        return this;
    }
}
