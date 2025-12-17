package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class s3 extends com.google.android.gms.internal.measurement.t8<com.google.android.gms.internal.measurement.t3, com.google.android.gms.internal.measurement.s3> implements com.google.android.gms.internal.measurement.z9 {
    private s3() {
        super(t3.z());
    }

    s3(com.google.android.gms.internal.measurement.h3 h3) {
        super(t3.z());
    }

    @Override // com.google.android.gms.internal.measurement.t8
    public final com.google.android.gms.internal.measurement.s3 s(String string) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        t3.B((t3)this.b, string);
        return this;
    }
}
