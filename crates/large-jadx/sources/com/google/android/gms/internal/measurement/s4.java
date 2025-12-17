package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class s4 extends com.google.android.gms.internal.measurement.t8<com.google.android.gms.internal.measurement.t4, com.google.android.gms.internal.measurement.s4> implements com.google.android.gms.internal.measurement.z9 {
    private s4() {
        super(t4.B());
    }

    s4(com.google.android.gms.internal.measurement.g4 g4) {
        super(t4.B());
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.s4 A(long l) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        t4.I((t4)this.b, l);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.s4 B(String string) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        t4.F((t4)this.b, string);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.s4 C(String string) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        t4.G((t4)this.b, string);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final int s() {
        return (t4)this.b.y();
    }

    public final com.google.android.gms.internal.measurement.s4 t(Iterable<? extends com.google.android.gms.internal.measurement.t4> iterable) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        t4.N((t4)this.b, iterable);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.s4 u(com.google.android.gms.internal.measurement.s4 s4) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        t4.M((t4)this.b, (t4)s4.l());
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.s4 v() {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        t4.L((t4)this.b);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.s4 w() {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        t4.J((t4)this.b);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.s4 x() {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        t4.O((t4)this.b);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.s4 y() {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        t4.H((t4)this.b);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.s4 z(double d) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        t4.K((t4)this.b, d);
        return this;
    }
}
