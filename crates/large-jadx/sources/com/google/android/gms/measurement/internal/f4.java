package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
abstract class f4 extends com.google.android.gms.measurement.internal.e3 {

    private boolean b;
    f4(com.google.android.gms.measurement.internal.b5 b5) {
        super(b5);
        this.a.i();
    }

    @Override // com.google.android.gms.measurement.internal.e3
    protected final void i() {
        if (!m()) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Not initialized");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.measurement.internal.e3
    public final void j() {
        boolean z;
        if (this.b) {
        } else {
            if (!n()) {
                this.a.g();
                this.b = true;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can't initialize twice");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.measurement.internal.e3
    public final void k() {
        if (this.b) {
        } else {
            l();
            this.a.g();
            this.b = true;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can't initialize twice");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.measurement.internal.e3
    protected void l() {
    }

    @Override // com.google.android.gms.measurement.internal.e3
    final boolean m() {
        if (this.b) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.e3
    protected abstract boolean n();
}
