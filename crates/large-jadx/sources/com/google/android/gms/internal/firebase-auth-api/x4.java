package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class x4 extends com.google.android.gms.internal.firebase-auth-api.x2<com.google.android.gms.internal.firebase-auth-api.y8, com.google.android.gms.internal.firebase-auth-api.b9> {

    private static final byte[] d;
    static {
        x4.d = new byte[0];
    }

    x4() {
        com.google.android.gms.internal.firebase-auth-api.i2[] arr = new i2[1];
        v4 v4Var = new v4(z1.class);
        super(y8.class, b9.class, arr);
    }

    static byte[] j() {
        return x4.d;
    }

    static com.google.android.gms.internal.firebase-auth-api.g2 k(com.google.android.gms.internal.firebase-auth-api.g9 g9, com.google.android.gms.internal.firebase-auth-api.l9 l92, com.google.android.gms.internal.firebase-auth-api.l8 l83, com.google.android.gms.internal.firebase-auth-api.e2 e24, byte[] b5Arr5, int i6) {
        com.google.android.gms.internal.firebase-auth-api.hb obj6;
        com.google.android.gms.internal.firebase-auth-api.wq obj7;
        final com.google.android.gms.internal.firebase-auth-api.q8 q8Var = r8.z();
        final com.google.android.gms.internal.firebase-auth-api.d9 d9Var = e9.z();
        d9Var.j(g9);
        d9Var.m(l92);
        d9Var.s(wq.v(b5Arr5));
        com.google.android.gms.internal.firebase-auth-api.ea obj4 = fa.z();
        obj4.m(e24.b());
        obj4.s(wq.v(e24.c()));
        obj6--;
        if (obj6 != null) {
            if (obj6 != 1) {
                obj6 = obj6 != 2 ? hb.zze : hb.zzd;
            } else {
                obj6 = hb.zzc;
            }
        } else {
            obj6 = hb.zzb;
        }
        obj4.j(obj6);
        obj6 = o8.z();
        obj6.j((fa)obj4.e());
        obj6 = v8.B();
        obj6.s((e9)d9Var.e());
        obj6.j((o8)obj6.e());
        obj6.m(l83);
        q8Var.j((v8)obj6.e());
        g2 g2Var = new g2((r8)q8Var.e(), i6);
        return g2Var;
    }

    public static final void l(com.google.android.gms.internal.firebase-auth-api.y8 y8) {
        if (y8.E().g() == 0) {
        } else {
            ed.c(y8.z(), 0);
            g5.b(y8.D().A());
        }
        GeneralSecurityException obj2 = new GeneralSecurityException("invalid ECIES private key");
        throw obj2;
    }

    public final com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.r8, com.google.android.gms.internal.firebase-auth-api.y8> a() {
        w4 w4Var = new w4(this, r8.class);
        return w4Var;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.x2
    public final com.google.android.gms.internal.firebase-auth-api.z9 b() {
        return z9.zzc;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.x2
    public final com.google.android.gms.internal.firebase-auth-api.y c(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return y8.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.x2
    public final String g() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.x2
    public final void i(com.google.android.gms.internal.firebase-auth-api.y y) {
        x4.l((y8)y);
    }
}
