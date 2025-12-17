package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.measurement.internal.u4;

/* loaded from: classes2.dex */
final class z1 extends com.google.android.gms.internal.measurement.u2 {

    final com.google.android.gms.internal.measurement.g3 A;
    final String w;
    final String x;
    final Context y;
    final Bundle z;
    z1(com.google.android.gms.internal.measurement.g3 g3, String string2, String string3, Context context4, Bundle bundle5) {
        this.A = g3;
        this.w = string2;
        this.x = string3;
        this.y = context4;
        this.z = bundle5;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    public final void a() {
        boolean z;
        int i5;
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        String str2 = "com.google.android.gms.measurement.dynamite";
        final int i8 = 1;
        if (g3.p(this.A, this.w, this.x)) {
            i3 = z;
            i4 = i5;
            i2 = str;
        } else {
            i4 = i3;
        }
        r.j(this.y);
        com.google.android.gms.internal.measurement.g3 g3Var4 = this.A;
        g3.K(g3Var4, g3Var4.z(this.y, i8));
        if (g3.y(this.A) == null) {
            try {
                Log.w(g3.C(this.A), "Failed to connect to measurement client.");
                int i9 = DynamiteModule.a(this.y, str2);
                int i6 = DynamiteModule.c(this.y, str2);
                if (i6 < i9) {
                } else {
                }
                i = i8;
                i = i7;
                final long l2 = (long)i10;
                super(46000, str, l2, obj7, i, i2, i3, i4, this.z, u4.a(this.y));
                com.google.android.gms.internal.measurement.f1 f1Var2 = g3.y(this.A);
                r.j(f1Var2);
                (f1)f1Var2.initialize(b.p2(this.y), o1Var, this.a);
                g3.L(this.A, th, obj2, obj1);
            }
        }
    }
}
