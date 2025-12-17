package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Set;

/* loaded from: classes2.dex */
final class y2 implements com.google.android.gms.internal.firebase-auth-api.b3 {

    final com.google.android.gms.internal.firebase-auth-api.j2 a;
    y2(com.google.android.gms.internal.firebase-auth-api.j2 j2) {
        this.a = j2;
        super();
    }

    public final Set<Class<?>> a() {
        return this.a.h();
    }

    public final Class<?> b() {
        return 0;
    }

    public final <Q> com.google.android.gms.internal.firebase-auth-api.b2<Q> c(Class<Q> class) {
        try {
            d2 d2Var = new d2(this.a, class);
            return d2Var;
            GeneralSecurityException generalSecurityException = new GeneralSecurityException("Primitive type not supported", class);
            throw generalSecurityException;
        }
    }

    public final com.google.android.gms.internal.firebase-auth-api.b2<?> zzb() {
        final com.google.android.gms.internal.firebase-auth-api.j2 j2Var = this.a;
        d2 d2Var = new d2(j2Var, j2Var.d());
        return d2Var;
    }

    public final Class<?> zzc() {
        return this.a.getClass();
    }
}
