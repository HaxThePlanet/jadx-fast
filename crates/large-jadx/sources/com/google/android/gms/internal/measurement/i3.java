package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class i3 extends com.google.android.gms.internal.measurement.t8<com.google.android.gms.internal.measurement.j3, com.google.android.gms.internal.measurement.i3> implements com.google.android.gms.internal.measurement.z9 {
    private i3() {
        super(j3.z());
    }

    i3(com.google.android.gms.internal.measurement.h3 h3) {
        super(j3.z());
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final int s() {
        return (j3)this.b.x();
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final int t() {
        return (j3)this.b.y();
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.i3 u(int i, com.google.android.gms.internal.measurement.k3 k32) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        j3.F((j3)this.b, i, (l3)k32.l());
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.i3 v(int i, com.google.android.gms.internal.measurement.s3 s32) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        j3.E((j3)this.b, i, (t3)s32.l());
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.l3 w(int i) {
        return (j3)this.b.A(i);
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.t3 x(int i) {
        return (j3)this.b.B(i);
    }
}
