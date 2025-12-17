package com.google.android.gms.internal.firebase-auth-api;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class d3 {
    static {
        Charset.forName("UTF-8");
    }

    public static com.google.android.gms.internal.firebase-auth-api.sa a(com.google.android.gms.internal.firebase-auth-api.na na) {
        int i;
        com.google.android.gms.internal.firebase-auth-api.qa qaVar;
        com.google.android.gms.internal.firebase-auth-api.hb hbVar;
        final com.google.android.gms.internal.firebase-auth-api.pa paVar = sa.z();
        paVar.m(na.A());
        Iterator obj4 = na.F().iterator();
        for (ma next2 : obj4) {
            qaVar = ra.A();
            qaVar.t(next2.A().E());
            qaVar.s(next2.B());
            qaVar.m(next2.E());
            qaVar.j(next2.z());
            paVar.j((ra)qaVar.e());
        }
        return (sa)paVar.e();
    }

    public static void b(com.google.android.gms.internal.firebase-auth-api.na na) {
        int i;
        int i3;
        int i2;
        Object next;
        Enum zzd;
        com.google.android.gms.internal.firebase-auth-api.ca zzb;
        Iterator obj9 = na.F().iterator();
        int i5 = 0;
        int i6 = 1;
        i3 = i;
        i2 = i6;
        for (ma next : obj9) {
            if (next.A().A() != z9.zzd) {
            } else {
            }
            next = i6;
            i2 &= next;
            i++;
            next = i5;
            i3 = i6;
        }
        if (i == 0) {
        } else {
            if (i3 == 0) {
                if (i2 == 0) {
                } else {
                }
                obj9 = new GeneralSecurityException("keyset doesn't contain a valid primary key");
                throw obj9;
            }
        }
        obj9 = new GeneralSecurityException("keyset must contain at least one ENABLED key");
        throw obj9;
    }
}
