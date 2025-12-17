package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class o4 extends com.google.android.gms.internal.measurement.t8<com.google.android.gms.internal.measurement.p4, com.google.android.gms.internal.measurement.o4> implements com.google.android.gms.internal.measurement.z9 {
    private o4() {
        super(p4.B());
    }

    o4(com.google.android.gms.internal.measurement.g4 g4) {
        super(p4.B());
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.o4 A(String string) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        p4.K((p4)this.b, string);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.o4 B(int i, com.google.android.gms.internal.measurement.s4 s42) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        p4.F((p4)this.b, i, (t4)s42.l());
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.o4 C(int i, com.google.android.gms.internal.measurement.t4 t42) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        p4.F((p4)this.b, i, t42);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.o4 D(long l) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        p4.M((p4)this.b, l);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.o4 E(long l) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        p4.L((p4)this.b, l);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.t4 F(int i) {
        return (p4)this.b.C(i);
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final String G() {
        return (p4)this.b.D();
    }

    public final List<com.google.android.gms.internal.measurement.t4> H() {
        return Collections.unmodifiableList((p4)this.b.E());
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final int s() {
        return (p4)this.b.x();
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final long t() {
        return (p4)this.b.y();
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final long u() {
        return (p4)this.b.z();
    }

    public final com.google.android.gms.internal.measurement.o4 v(Iterable<? extends com.google.android.gms.internal.measurement.t4> iterable) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        p4.H((p4)this.b, iterable);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.o4 w(com.google.android.gms.internal.measurement.s4 s4) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        p4.G((p4)this.b, (t4)s4.l());
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.o4 x(com.google.android.gms.internal.measurement.t4 t4) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        p4.G((p4)this.b, t4);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.o4 y() {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        p4.I((p4)this.b);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.o4 z(int i) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        p4.J((p4)this.b, i);
        return this;
    }
}
