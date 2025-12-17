package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class i6 implements Runnable {

    public final com.google.android.gms.measurement.internal.i7 a;
    public final Bundle b;
    public i6(com.google.android.gms.measurement.internal.i7 i7, Bundle bundle2) {
        super();
        this.a = i7;
        this.b = bundle2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.q(this.b);
    }
}
