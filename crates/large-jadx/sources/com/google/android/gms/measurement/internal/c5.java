package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class c5 implements Runnable {

    public final com.google.android.gms.measurement.internal.u5 a;
    public final String b;
    public final Bundle c;
    public c5(com.google.android.gms.measurement.internal.u5 u5, String string2, Bundle bundle3) {
        super();
        this.a = u5;
        this.b = string2;
        this.c = bundle3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.t2(this.b, this.c);
    }
}
