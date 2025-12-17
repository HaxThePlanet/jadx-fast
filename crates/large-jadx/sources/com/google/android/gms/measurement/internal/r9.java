package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
abstract class r9 extends com.google.android.gms.measurement.internal.q9 {

    private boolean c;
    r9(com.google.android.gms.measurement.internal.ba ba) {
        super(ba);
        this.b.q();
    }

    @Override // com.google.android.gms.measurement.internal.q9
    protected final void i() {
        if (!k()) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Not initialized");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.measurement.internal.q9
    public final void j() {
        if (this.c) {
        } else {
            l();
            this.b.l();
            this.c = true;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can't initialize twice");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.measurement.internal.q9
    final boolean k() {
        if (this.c) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.q9
    protected abstract boolean l();
}
