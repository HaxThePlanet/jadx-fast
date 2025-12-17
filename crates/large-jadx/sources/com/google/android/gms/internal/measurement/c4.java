package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class c4 extends com.google.android.gms.internal.measurement.t8<com.google.android.gms.internal.measurement.d4, com.google.android.gms.internal.measurement.c4> implements com.google.android.gms.internal.measurement.z9 {
    private c4() {
        super(d4.B());
    }

    c4(com.google.android.gms.internal.measurement.y3 y3) {
        super(d4.B());
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final int s() {
        return (d4)this.b.x();
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.b4 t(int i) {
        return (d4)this.b.z(i);
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.c4 u() {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        d4.I((d4)this.b);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.c4 v(int i, com.google.android.gms.internal.measurement.z3 z32) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        d4.H((d4)this.b, i, (b4)z32.l());
        return this;
    }

    public final List<com.google.android.gms.internal.measurement.j3> w() {
        return Collections.unmodifiableList((d4)this.b.E());
    }
}
