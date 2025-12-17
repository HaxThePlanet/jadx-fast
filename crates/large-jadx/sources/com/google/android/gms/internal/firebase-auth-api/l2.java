package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class l2 {

    private final com.google.android.gms.internal.firebase-auth-api.ka a;
    private l2(com.google.android.gms.internal.firebase-auth-api.ka ka) {
        super();
        this.a = ka;
    }

    public static com.google.android.gms.internal.firebase-auth-api.l2 e() {
        l2 l2Var = new l2(na.B());
        return l2Var;
    }

    public static com.google.android.gms.internal.firebase-auth-api.l2 f(com.google.android.gms.internal.firebase-auth-api.k2 k2) {
        l2 l2Var = new l2((ka)k2.c().t());
        return l2Var;
    }

    private final int g() {
        int i;
        boolean z;
        i = l2.h();
        synchronized (this) {
            try {
                while (k(i)) {
                    i = l2.h();
                }
                i = l2.h();
                return i;
                throw th;
            }
        }
    }

    private static int h() {
        int i2;
        int i;
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        final int i4 = 0;
        i2 = i4;
        while (i2 == 0) {
            secureRandom.nextBytes(bArr);
            i8 |= i;
        }
        return i2;
    }

    private final com.google.android.gms.internal.firebase-auth-api.ma i(com.google.android.gms.internal.firebase-auth-api.aa aa, com.google.android.gms.internal.firebase-auth-api.hb hb2) {
        synchronized (this) {
            try {
                com.google.android.gms.internal.firebase-auth-api.la laVar = ma.C();
                laVar.j(aa);
                laVar.m(g());
                laVar.t(ca.zzb);
                laVar.s(hb2);
                return (ma)laVar.e();
                GeneralSecurityException obj3 = new GeneralSecurityException("unknown output prefix type");
                throw obj3;
                throw aa;
            }
        }
    }

    private final com.google.android.gms.internal.firebase-auth-api.ma j(com.google.android.gms.internal.firebase-auth-api.fa fa) {
        return i(c3.c(fa), fa.C());
        synchronized (this) {
            return i(c3.c(fa), fa.C());
        }
    }

    private final boolean k(int i) {
        int next;
        int obj3;
        Iterator iterator = this.a.u().iterator();
        synchronized (this) {
            try {
                for (ma next2 : iterator) {
                }
                if ((ma)iterator.next().z() == i) {
                } else {
                }
                obj3 = 1;
                return obj3;
                obj3 = 0;
                throw i;
            }
        }
    }

    @Deprecated
    public final int a(com.google.android.gms.internal.firebase-auth-api.fa fa, boolean z2) {
        com.google.android.gms.internal.firebase-auth-api.ma obj1 = j(fa);
        this.a.m(obj1);
        return obj1.z();
        synchronized (this) {
            obj1 = j(fa);
            this.a.m(obj1);
            return obj1.z();
        }
    }

    public final com.google.android.gms.internal.firebase-auth-api.k2 b() {
        return k2.a((na)this.a.e());
        synchronized (this) {
            return k2.a((na)this.a.e());
        }
    }

    public final com.google.android.gms.internal.firebase-auth-api.l2 c(com.google.android.gms.internal.firebase-auth-api.e2 e2) {
        a(e2.a(), false);
        return this;
        synchronized (this) {
            a(e2.a(), false);
            return this;
        }
    }

    public final com.google.android.gms.internal.firebase-auth-api.l2 d(int i) {
        int i3;
        com.google.android.gms.internal.firebase-auth-api.ma maVar;
        int i2;
        i3 = 0;
        synchronized (this) {
            while (i3 < this.a.j()) {
                maVar = this.a.t(i3);
                i3++;
            }
            StringBuilder stringBuilder = new StringBuilder(26);
            stringBuilder.append("key not found: ");
            stringBuilder.append(i);
            GeneralSecurityException generalSecurityException = new GeneralSecurityException(stringBuilder.toString());
            throw generalSecurityException;
        }
    }
}
