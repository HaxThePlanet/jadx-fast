package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class m3 extends com.google.android.gms.internal.measurement.t8<com.google.android.gms.internal.measurement.n3, com.google.android.gms.internal.measurement.m3> implements com.google.android.gms.internal.measurement.z9 {
    private m3() {
        super(n3.w());
    }

    m3(com.google.android.gms.internal.measurement.h3 h3) {
        super(n3.w());
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.m3 s(String string) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        n3.B((n3)this.b, string);
        return this;
    }
}
