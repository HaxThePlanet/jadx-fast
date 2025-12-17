package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class w4 extends com.google.android.gms.internal.measurement.t8<com.google.android.gms.internal.measurement.x4, com.google.android.gms.internal.measurement.w4> implements com.google.android.gms.internal.measurement.z9 {
    private w4() {
        super(x4.x());
    }

    w4(com.google.android.gms.internal.measurement.g4 g4) {
        super(x4.x());
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.w4 s(com.google.android.gms.internal.measurement.y4 y4) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        x4.A((x4)this.b, (z4)y4.l());
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.z4 t(int i) {
        return (x4)this.b.y(0);
    }
}
