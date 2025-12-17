package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes2.dex */
final class e7 implements Runnable {

    final boolean a;
    final Uri b;
    final String c;
    final String v;
    final com.google.android.gms.measurement.internal.g7 w;
    e7(com.google.android.gms.measurement.internal.g7 g7, boolean z2, Uri uri3, String string4, String string5) {
        this.w = g7;
        this.a = z2;
        this.b = uri3;
        this.c = string4;
        this.v = string5;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean empty;
        Object obj;
        boolean contains;
        boolean format;
        Object str;
        String str3;
        Bundle bundle;
        com.google.android.gms.measurement.internal.ia iaVar;
        Uri contains2;
        String concat;
        String str2;
        String valueOf;
        int str4;
        int string;
        final Object obj2 = this;
        final com.google.android.gms.measurement.internal.g7 g7Var = obj2.w;
        str3 = obj2.c;
        final String str10 = obj2.v;
        g7Var.a.h();
        iaVar = i7Var12.a.N();
        final String str13 = "Activity created with data 'referrer' without required params";
        str2 = "_cis";
        final String str14 = "utm_medium";
        final String str15 = "utm_source";
        final String str16 = "utm_campaign";
        final int i3 = 0;
        final String str17 = "gclid";
        if (TextUtils.isEmpty(str10)) {
            bundle = i3;
        } else {
        }
        String str11 = "_cmp";
        z = i7Var.a.N().t0(obj2.b);
        z.putString(str2, "intent");
        if (obj2.a && z != null && !z.containsKey(str17) && bundle != null && bundle.containsKey(str17)) {
            z = i7Var.a.N().t0(str);
            if (z != null) {
                z.putString(str2, "intent");
                if (!z.containsKey(str17)) {
                    if (bundle != null) {
                        if (bundle.containsKey(str17)) {
                            try {
                                Object[] arr = new Object[1];
                                z.putString("_cer", String.format("gclid=%s", bundle.getString(str17)));
                                g7Var.a.u(str3, str11, z);
                                i7Var10.n.a(str3, z);
                                i7Var2.a.b().q().b("Activity created with referrer", str10);
                                str = "_ldl";
                                str2 = "auto";
                                if (i7Var3.a.z().B(i3, c3.b0)) {
                                }
                                if (bundle != null) {
                                } else {
                                }
                                g7Var.a.u(str3, str11, bundle);
                                i7Var7.n.a(str3, bundle);
                                i7Var5.a.b().q().b("Referrer does not contain valid parameters", str10);
                                g7Var.a.L(str2, str, i3, true);
                            }
                        }
                    }
                }
            }
        }
    }
}
