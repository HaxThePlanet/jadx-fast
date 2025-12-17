package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class j6 implements Runnable {

    public final com.google.android.gms.measurement.internal.i7 a;
    public final Bundle b;
    public final long c;
    public j6(com.google.android.gms.measurement.internal.i7 i7, Bundle bundle2, long l3) {
        super();
        this.a = i7;
        this.b = bundle2;
        this.c = l3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.p(this.b, this.c);
    }
}
