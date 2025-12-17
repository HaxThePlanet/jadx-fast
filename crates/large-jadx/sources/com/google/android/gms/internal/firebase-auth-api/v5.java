package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
final class v5 extends com.google.android.gms.internal.firebase-auth-api.i2<com.google.android.gms.internal.firebase-auth-api.q2, com.google.android.gms.internal.firebase-auth-api.o9> {
    v5(Class class) {
        super(class);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.i2
    public final Object b(Object object) {
        com.google.android.gms.internal.firebase-auth-api.ad adVar;
        com.google.android.gms.internal.firebase-auth-api.zc zcVar;
        String str;
        SecretKeySpec secretKeySpec = new SecretKeySpec(object.F().B(), "HMAC");
        int obj5 = object.E().z();
        com.google.android.gms.internal.firebase-auth-api.l9 zza = l9.zza;
        int ordinal = (o9)object.E().A().ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        if (ordinal != 5) {
                        } else {
                            zcVar = new zc("HMACSHA224", secretKeySpec);
                            adVar = new ad(zcVar, obj5);
                        }
                        obj5 = new GeneralSecurityException("unknown hash");
                        throw obj5;
                    }
                    zcVar = new zc("HMACSHA512", secretKeySpec);
                    adVar = new ad(zcVar, obj5);
                } else {
                    zcVar = new zc("HMACSHA256", secretKeySpec);
                    adVar = new ad(zcVar, obj5);
                }
            } else {
                zcVar = new zc("HMACSHA384", secretKeySpec);
                adVar = new ad(zcVar, obj5);
            }
        } else {
            zcVar = new zc("HMACSHA1", secretKeySpec);
            adVar = new ad(zcVar, obj5);
        }
        return adVar;
    }
}
