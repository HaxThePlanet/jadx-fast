package com.google.android.gms.internal.firebase-auth-api;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.spec.ECPrivateKeySpec;

/* loaded from: classes2.dex */
final class v4 extends com.google.android.gms.internal.firebase-auth-api.i2<com.google.android.gms.internal.firebase-auth-api.z1, com.google.android.gms.internal.firebase-auth-api.y8> {
    v4(Class class) {
        super(class);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.i2
    public final Object b(Object object) {
        com.google.android.gms.internal.firebase-auth-api.v8 v8Var = (y8)object.D().A();
        com.google.android.gms.internal.firebase-auth-api.e9 e9Var = v8Var.E();
        BigInteger bigInteger = new BigInteger(1, object.E().B());
        ECPrivateKeySpec obj9 = new ECPrivateKeySpec(bigInteger, kc.f(g5.c(e9Var.C())));
        h5 h5Var = new h5(v8Var.A().C());
        super((ECPrivateKey)(KeyFactory)mc.i.a("EC").generatePrivate(obj9), e9Var.E().B(), g5.a(e9Var.D()), g5.d(v8Var.z()), h5Var);
        return obj9;
    }
}
