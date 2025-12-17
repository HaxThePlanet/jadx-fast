package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.o.b;
import com.google.android.gms.common.o.c;

/* loaded from: classes2.dex */
public final class j4 {

    final com.google.android.gms.measurement.internal.b5 a;
    j4(com.google.android.gms.measurement.internal.ba ba) {
        super();
        this.a = ba.a0();
    }

    final boolean a() {
        int i;
        b bVar = c.a(this.a.f());
        if (bVar == null) {
            try {
                this.a.b().v().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return 0;
                if (packageInfo.versionCode >= 80837300) {
                }
                i = 1;
                return i;
                com.google.android.gms.measurement.internal.b5 b5Var3 = this.a;
                b5Var3 = b5Var3.b();
                b5Var3 = b5Var3.v();
                b5Var3.b("Failed to retrieve Play Store version for Install Referrer", th);
                return obj0;
            }
        }
    }
}
