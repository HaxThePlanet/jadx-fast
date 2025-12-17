package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
@Deprecated
public final class f5 {

    private static final byte[] a;
    public static final com.google.android.gms.internal.firebase-auth-api.fa b;
    static {
        byte[] bArr = new byte[0];
        f5.a = bArr;
        final com.google.android.gms.internal.firebase-auth-api.g9 zzb = g9.zzb;
        final com.google.android.gms.internal.firebase-auth-api.l8 zzb2 = l8.zzb;
        final com.google.android.gms.internal.firebase-auth-api.hb zzb3 = hb.zzb;
        final com.google.android.gms.internal.firebase-auth-api.l9 l9Var = zzd2;
        com.google.android.gms.internal.firebase-auth-api.fa faVar2 = faVar4;
        final byte[] bArr2 = bArr;
        f5.b = f5.a(zzb, l9Var, zzb2, faVar2, zzb3, bArr2);
        com.google.android.gms.internal.firebase-auth-api.g9 g9Var2 = zzb;
        f5.a(g9Var2, l9Var, l8.zzc, faVar2, hb.zzd, bArr2);
        f5.a(g9Var2, l9Var, zzb2, f3.b, zzb3, bArr2);
    }

    public static com.google.android.gms.internal.firebase-auth-api.fa a(com.google.android.gms.internal.firebase-auth-api.g9 g9, com.google.android.gms.internal.firebase-auth-api.l9 l92, com.google.android.gms.internal.firebase-auth-api.l8 l83, com.google.android.gms.internal.firebase-auth-api.fa fa4, com.google.android.gms.internal.firebase-auth-api.hb hb5, byte[] b6Arr6) {
        final com.google.android.gms.internal.firebase-auth-api.q8 q8Var = r8.z();
        final com.google.android.gms.internal.firebase-auth-api.d9 d9Var = e9.z();
        d9Var.j(g9);
        d9Var.m(l92);
        d9Var.s(wq.v(b6Arr6));
        com.google.android.gms.internal.firebase-auth-api.n8 obj3 = o8.z();
        obj3.j(fa4);
        final com.google.android.gms.internal.firebase-auth-api.t8 obj5 = v8.B();
        obj5.s((e9)d9Var.e());
        obj5.j((o8)obj3.e());
        obj5.m(l83);
        q8Var.j((v8)obj5.e());
        obj3 = fa.z();
        x4 obj4 = new x4();
        obj3.m("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        obj3.j(hb5);
        obj3.s((r8)q8Var.e().g());
        return (fa)obj3.e();
    }
}
