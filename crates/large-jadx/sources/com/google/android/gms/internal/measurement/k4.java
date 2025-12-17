package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class k4 extends com.google.android.gms.internal.measurement.t8<com.google.android.gms.internal.measurement.l4, com.google.android.gms.internal.measurement.k4> implements com.google.android.gms.internal.measurement.z9 {
    private k4() {
        super(l4.y());
    }

    k4(com.google.android.gms.internal.measurement.g4 g4) {
        super(l4.y());
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.k4 s(int i) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        l4.B((l4)this.b, i);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.k4 t(com.google.android.gms.internal.measurement.e5 e5) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        l4.C((l4)this.b, (f5)e5.l());
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.k4 u(boolean z) {
        boolean z2;
        if (this.c) {
            n();
            this.c = false;
        }
        l4.E((l4)this.b, z);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.k4 v(com.google.android.gms.internal.measurement.f5 f5) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        l4.D((l4)this.b, f5);
        return this;
    }
}
