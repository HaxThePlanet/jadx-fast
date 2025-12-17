package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class k3 extends com.google.android.gms.internal.measurement.t8<com.google.android.gms.internal.measurement.l3, com.google.android.gms.internal.measurement.k3> implements com.google.android.gms.internal.measurement.z9 {
    private k3() {
        super(l3.z());
    }

    k3(com.google.android.gms.internal.measurement.h3 h3) {
        super(l3.z());
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final int s() {
        return (l3)this.b.w();
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.k3 t(String string) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        l3.E((l3)this.b, string);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.k3 u(int i, com.google.android.gms.internal.measurement.n3 n32) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        l3.F((l3)this.b, i, n32);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.n3 v(int i) {
        return (l3)this.b.A(i);
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final String w() {
        return (l3)this.b.C();
    }
}
