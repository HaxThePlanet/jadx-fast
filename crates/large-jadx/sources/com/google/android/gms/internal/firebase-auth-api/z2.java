package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Set;

/* loaded from: classes2.dex */
final class z2 implements com.google.android.gms.internal.firebase-auth-api.b3 {

    final com.google.android.gms.internal.firebase-auth-api.x2 a;
    final com.google.android.gms.internal.firebase-auth-api.j2 b;
    z2(com.google.android.gms.internal.firebase-auth-api.x2 x2, com.google.android.gms.internal.firebase-auth-api.j2 j22) {
        this.a = x2;
        this.b = j22;
        super();
    }

    public final Set<Class<?>> a() {
        return this.a.h();
    }

    public final Class<?> b() {
        return this.b.getClass();
    }

    public final <Q> com.google.android.gms.internal.firebase-auth-api.b2<Q> c(Class<Q> class) {
        try {
            w2 w2Var = new w2(this.a, this.b, class);
            return w2Var;
            GeneralSecurityException generalSecurityException = new GeneralSecurityException("Primitive type not supported", class);
            throw generalSecurityException;
        }
    }

    public final com.google.android.gms.internal.firebase-auth-api.b2<?> zzb() {
        final com.google.android.gms.internal.firebase-auth-api.x2 x2Var = this.a;
        w2 w2Var = new w2(x2Var, this.b, x2Var.d());
        return w2Var;
    }

    public final Class<?> zzc() {
        return this.a.getClass();
    }
}
