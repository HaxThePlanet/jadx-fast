package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
abstract class w5 extends com.google.android.gms.measurement.internal.v5 {

    private boolean b;
    w5(com.google.android.gms.measurement.internal.b5 b5) {
        super(b5);
        this.a.i();
    }

    @Override // com.google.android.gms.measurement.internal.v5
    protected void i() {
    }

    @Override // com.google.android.gms.measurement.internal.v5
    protected abstract boolean j();

    @Override // com.google.android.gms.measurement.internal.v5
    protected final void k() {
        if (!n()) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Not initialized");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.measurement.internal.v5
    public final void l() {
        boolean z;
        if (this.b) {
        } else {
            if (!j()) {
                this.a.g();
                this.b = true;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can't initialize twice");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.measurement.internal.v5
    public final void m() {
        if (this.b) {
        } else {
            i();
            this.a.g();
            this.b = true;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can't initialize twice");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.measurement.internal.v5
    final boolean n() {
        if (this.b) {
            return 1;
        }
        return 0;
    }
}
