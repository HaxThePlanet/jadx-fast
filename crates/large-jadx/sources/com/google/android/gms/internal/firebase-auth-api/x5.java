package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class x5 extends com.google.android.gms.internal.firebase-auth-api.j2<com.google.android.gms.internal.firebase-auth-api.o9> {
    public x5() {
        com.google.android.gms.internal.firebase-auth-api.i2[] arr = new i2[1];
        v5 v5Var = new v5(q2.class);
        super(o9.class, arr);
    }

    static void j(com.google.android.gms.internal.firebase-auth-api.u9 u9) {
        x5.m(u9);
    }

    static com.google.android.gms.internal.firebase-auth-api.g2 k(int i, int i2, com.google.android.gms.internal.firebase-auth-api.l9 l93, int i4) {
        final com.google.android.gms.internal.firebase-auth-api.q9 q9Var = r9.A();
        final com.google.android.gms.internal.firebase-auth-api.t9 t9Var = u9.B();
        t9Var.j(l93);
        t9Var.m(i2);
        q9Var.m((u9)t9Var.e());
        q9Var.j(i);
        g2 g2Var = new g2((r9)q9Var.e(), i4);
        return g2Var;
    }

    public static final void l(com.google.android.gms.internal.firebase-auth-api.o9 o9) {
        ed.c(o9.z(), 0);
        if (o9.F().g() < 16) {
        } else {
            x5.m(o9.E());
        }
        GeneralSecurityException obj2 = new GeneralSecurityException("key too short");
        throw obj2;
    }

    private static void m(com.google.android.gms.internal.firebase-auth-api.u9 u9) {
        int i;
        int i2;
        int obj3;
        if (u9.z() < 10) {
        } else {
            com.google.android.gms.internal.firebase-auth-api.l9 zza = l9.zza;
            int ordinal = u9.A().ordinal();
            final String str3 = "tag size too big";
            if (ordinal != 1 && ordinal != 2 && ordinal != 3 && ordinal != 4) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            if (ordinal != 5) {
                            } else {
                                if (u9.z() > 28) {
                                } else {
                                }
                                obj3 = new GeneralSecurityException(str3);
                                throw obj3;
                            }
                            obj3 = new GeneralSecurityException("unknown hash type");
                            throw obj3;
                        }
                        if (u9.z() > 64) {
                        } else {
                        }
                        obj3 = new GeneralSecurityException(str3);
                        throw obj3;
                    }
                    if (u9.z() > 32) {
                    } else {
                    }
                    obj3 = new GeneralSecurityException(str3);
                    throw obj3;
                }
                if (u9.z() > 48) {
                } else {
                }
                obj3 = new GeneralSecurityException(str3);
                throw obj3;
            }
            if (u9.z() > 20) {
            } else {
            }
            obj3 = new GeneralSecurityException(str3);
            throw obj3;
        }
        obj3 = new GeneralSecurityException("tag size too small");
        throw obj3;
    }

    public final com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.r9, com.google.android.gms.internal.firebase-auth-api.o9> a() {
        w5 w5Var = new w5(this, r9.class);
        return w5Var;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.z9 b() {
        return z9.zzb;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.y c(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return o9.D(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final String g() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final void i(com.google.android.gms.internal.firebase-auth-api.y y) {
        x5.l((o9)y);
    }
}
