package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class z3 extends com.google.android.gms.internal.measurement.t8<com.google.android.gms.internal.measurement.b4, com.google.android.gms.internal.measurement.z3> implements com.google.android.gms.internal.measurement.z9 {
    private z3() {
        super(b4.x());
    }

    z3(com.google.android.gms.internal.measurement.y3 y3) {
        super(b4.x());
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final int s() {
        return (b4)this.b.w();
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.z3 t(String string) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        b4.z((b4)this.b, string);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final String u() {
        return (b4)this.b.y();
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final boolean v() {
        return (b4)this.b.A();
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final boolean w() {
        return (b4)this.b.B();
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final boolean x() {
        return (b4)this.b.C();
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final boolean y() {
        return (b4)this.b.D();
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final boolean z() {
        return (b4)this.b.E();
    }
}
