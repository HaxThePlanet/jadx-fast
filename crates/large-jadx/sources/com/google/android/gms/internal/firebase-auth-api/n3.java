package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
final class n3 extends com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.y6, com.google.android.gms.internal.firebase-auth-api.v6> {

    final com.google.android.gms.internal.firebase-auth-api.o3 b;
    n3(com.google.android.gms.internal.firebase-auth-api.o3 o3, Class class2) {
        this.b = o3;
        super(class2);
    }

    public static final com.google.android.gms.internal.firebase-auth-api.v6 g(com.google.android.gms.internal.firebase-auth-api.y6 y6) {
        final com.google.android.gms.internal.firebase-auth-api.u6 u6Var = v6.A();
        u6Var.m(y6.E());
        u6Var.j(wq.v(cd.a(y6.z())));
        u6Var.s(0);
        return (v6)u6Var.e();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final com.google.android.gms.internal.firebase-auth-api.y a(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return y6.D(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final Object c(com.google.android.gms.internal.firebase-auth-api.y y) {
        return n3.g((y6)y);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final void e(com.google.android.gms.internal.firebase-auth-api.y y) {
        f((y6)y);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final void f(com.google.android.gms.internal.firebase-auth-api.y6 y6) {
        ed.b(y6.z());
        o3.j(this.b, y6.E());
    }
}
