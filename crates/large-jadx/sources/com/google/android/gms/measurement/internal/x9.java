package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.e;

/* loaded from: classes2.dex */
final class x9 implements Runnable {

    final String a;
    final String b;
    final Bundle c;
    final com.google.android.gms.measurement.internal.y9 v;
    x9(com.google.android.gms.measurement.internal.y9 y9, String string2, String string3, Bundle bundle4) {
        this.v = y9;
        this.a = string2;
        this.b = "_err";
        this.c = bundle4;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.measurement.internal.u uVar = y9Var.a.f0().w0(this.a, this.b, this.c, "auto", y9Var2.a.c().currentTimeMillis(), obj7, false);
        r.j(uVar);
        y9Var3.a.j((u)uVar, this.a);
    }
}
