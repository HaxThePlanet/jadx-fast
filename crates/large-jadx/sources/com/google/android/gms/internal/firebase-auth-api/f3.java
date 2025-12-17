package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
@Deprecated
public final class f3 {

    public static final com.google.android.gms.internal.firebase-auth-api.fa a;
    public static final com.google.android.gms.internal.firebase-auth-api.fa b;
    static {
        int i = 16;
        f3.a = f3.c(i);
        int i2 = 32;
        f3.c(i2);
        f3.b(i, i);
        f3.b(i2, i);
        com.google.android.gms.internal.firebase-auth-api.l9 zzd = l9.zzd;
        f3.b = f3.a(i, i, i2, i, zzd);
        f3.a(i2, i, i2, i2, zzd);
        com.google.android.gms.internal.firebase-auth-api.ea eaVar = fa.z();
        b4 b4Var = new b4();
        eaVar.m("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        com.google.android.gms.internal.firebase-auth-api.hb zzb = hb.zzb;
        eaVar.j(zzb);
        com.google.android.gms.internal.firebase-auth-api.xr xrVar = eaVar.e();
        com.google.android.gms.internal.firebase-auth-api.ea eaVar2 = fa.z();
        l4 l4Var = new l4();
        eaVar2.m("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        eaVar2.j(zzb);
        com.google.android.gms.internal.firebase-auth-api.xr xrVar2 = eaVar2.e();
    }

    public static com.google.android.gms.internal.firebase-auth-api.fa a(int i, int i2, int i3, int i4, com.google.android.gms.internal.firebase-auth-api.l9 l95) {
        com.google.android.gms.internal.firebase-auth-api.x6 obj2 = y6.A();
        com.google.android.gms.internal.firebase-auth-api.a7 obj3 = b7.A();
        obj3.j(16);
        obj2.m((b7)obj3.e());
        obj2.j(i);
        obj2 = r9.A();
        obj3 = u9.B();
        obj3.j(l95);
        obj3.m(i4);
        obj2.m((u9)obj3.e());
        obj2.j(32);
        obj3 = r6.z();
        obj3.j((y6)obj2.e());
        obj3.m((r9)obj2.e());
        obj2 = fa.z();
        obj2.s((r6)obj3.e().g());
        l3 obj1 = new l3();
        obj2.m("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        obj2.j(hb.zzb);
        return (fa)obj2.e();
    }

    public static com.google.android.gms.internal.firebase-auth-api.fa b(int i, int i2) {
        com.google.android.gms.internal.firebase-auth-api.g7 obj2 = h7.A();
        obj2.j(i);
        com.google.android.gms.internal.firebase-auth-api.j7 obj1 = k7.A();
        obj1.j(16);
        obj2.m((k7)obj1.e());
        obj2 = fa.z();
        obj2.s((h7)obj2.e().g());
        obj1 = new s3();
        obj2.m("type.googleapis.com/google.crypto.tink.AesEaxKey");
        obj2.j(hb.zzb);
        return (fa)obj2.e();
    }

    public static com.google.android.gms.internal.firebase-auth-api.fa c(int i) {
        com.google.android.gms.internal.firebase-auth-api.p7 p7Var = q7.A();
        p7Var.j(i);
        com.google.android.gms.internal.firebase-auth-api.ea eaVar = fa.z();
        eaVar.s((q7)p7Var.e().g());
        v3 obj1 = new v3();
        eaVar.m("type.googleapis.com/google.crypto.tink.AesGcmKey");
        eaVar.j(hb.zzb);
        return (fa)eaVar.e();
    }
}
