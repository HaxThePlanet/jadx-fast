package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class h5 implements com.google.android.gms.internal.firebase-auth-api.gc {

    private final String a;
    private final int b;
    private com.google.android.gms.internal.firebase-auth-api.n7 c;
    private com.google.android.gms.internal.firebase-auth-api.o6 d;
    private int e;
    private com.google.android.gms.internal.firebase-auth-api.a8 f;
    h5(com.google.android.gms.internal.firebase-auth-api.fa fa) {
        String string;
        super();
        String str = fa.E();
        this.a = str;
        if (str.equals(e3.b)) {
            this.c = (n7)c3.d(fa);
            this.b = q7.C(fa.D(), lr.a()).z();
        }
        String str7 = "invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat";
        if (str.equals(e3.a)) {
            com.google.android.gms.internal.firebase-auth-api.r6 r6Var = r6.B(fa.D(), lr.a());
            this.d = (o6)c3.d(fa);
            this.e = r6Var.C().z();
            this.b = i += obj4;
        }
        if (str.equals(s4.a)) {
            this.f = (a8)c3.d(fa);
            this.b = d8.C(fa.D(), lr.a()).z();
        }
        String valueOf = String.valueOf(str);
        String str6 = "unsupported AEAD DEM key type: ";
        if (valueOf.length() != 0) {
            string = str6.concat(valueOf);
        } else {
            string = new String(str6);
        }
        GeneralSecurityException obj4 = new GeneralSecurityException(string);
        throw obj4;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gc
    public final com.google.android.gms.internal.firebase-auth-api.i5 a(byte[] bArr) {
        Class<com.google.android.gms.internal.firebase-auth-api.u1> obj = u1.class;
        if (bArr.length != this.b) {
        } else {
            int i4 = 0;
            if (this.a.equals(e3.b)) {
                com.google.android.gms.internal.firebase-auth-api.m7 m7Var = n7.A();
                m7Var.d(this.c);
                m7Var.j(wq.w(bArr, i4, this.b));
                i5 i5Var3 = new i5((u1)c3.h(this.a, (n7)m7Var.e(), obj));
                return i5Var3;
            }
            if (this.a.equals(e3.a)) {
                com.google.android.gms.internal.firebase-auth-api.u6 u6Var = v6.A();
                u6Var.d(this.d.D());
                u6Var.j(wq.v(Arrays.copyOfRange(bArr, i4, this.e)));
                com.google.android.gms.internal.firebase-auth-api.n9 n9Var = o9.A();
                n9Var.d(this.d.E());
                n9Var.j(wq.v(Arrays.copyOfRange(bArr, this.e, this.b)));
                com.google.android.gms.internal.firebase-auth-api.n6 n6Var = o6.A();
                n6Var.s(this.d.z());
                n6Var.j((v6)u6Var.e());
                n6Var.m((o9)n9Var.e());
                i5 i5Var2 = new i5((u1)c3.h(this.a, (o6)n6Var.e(), obj));
                return i5Var2;
            }
            if (!this.a.equals(s4.a)) {
            } else {
                com.google.android.gms.internal.firebase-auth-api.z7 z7Var = a8.A();
                z7Var.d(this.f);
                z7Var.j(wq.w(bArr, i4, this.b));
                i5 i5Var = new i5((y1)c3.h(this.a, (a8)z7Var.e(), y1.class));
                return i5Var;
            }
            GeneralSecurityException obj5 = new GeneralSecurityException("unknown DEM key type");
            throw obj5;
        }
        obj5 = new GeneralSecurityException("Symmetric key has incorrect length");
        throw obj5;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gc
    public final int zza() {
        return this.b;
    }
}
