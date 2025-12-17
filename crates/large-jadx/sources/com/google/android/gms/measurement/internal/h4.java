package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.t0;

/* loaded from: classes2.dex */
final class h4 implements Runnable {

    final t0 a;
    final ServiceConnection b;
    final com.google.android.gms.measurement.internal.i4 c;
    h4(com.google.android.gms.measurement.internal.i4 i4, t0 t02, ServiceConnection serviceConnection3) {
        this.c = i4;
        this.a = t02;
        this.b = serviceConnection3;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object bundle;
        Object str;
        Bundle bundle2;
        com.google.android.gms.measurement.internal.i4 i4Var = this.c;
        final com.google.android.gms.measurement.internal.j4 j4Var = i4Var.b;
        j4Var.a.a().h();
        bundle2 = new Bundle();
        bundle2.putString("package_name", i4.a(i4Var));
        if (this.a.c(bundle2) != null) {
        } else {
            j4Var.a.b().r().a("Install Referrer Service returned a null response");
        }
        j4Var.a.a().h();
        b5.t();
        throw 0;
    }
}
