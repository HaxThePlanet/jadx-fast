package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class m4 extends com.google.android.gms.internal.measurement.t8<com.google.android.gms.internal.measurement.n4, com.google.android.gms.internal.measurement.m4> implements com.google.android.gms.internal.measurement.z9 {
    private m4() {
        super(n4.z());
    }

    m4(com.google.android.gms.internal.measurement.g4 g4) {
        super(n4.z());
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.m4 s(long l) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        n4.B((n4)this.b, l);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.m4 t(int i) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        n4.A((n4)this.b, i);
        return this;
    }
}
