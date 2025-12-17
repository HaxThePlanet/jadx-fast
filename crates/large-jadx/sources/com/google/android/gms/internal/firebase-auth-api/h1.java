package com.google.android.gms.internal.firebase-auth-api;

import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class h1 extends com.google.android.gms.internal.firebase-auth-api.i1 {
    h1(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.i1
    public final double a(Object object, long l2) {
        return Double.longBitsToDouble(k(object, l2));
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.i1
    public final float b(Object object, long l2) {
        return Float.intBitsToFloat(j(object, l2));
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.i1
    public final void c(Object object, long l2, boolean z3) {
        if (j1.i) {
            j1.p(object, l2, z3);
        }
        j1.q(object, l2, z3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.i1
    public final void d(Object object, long l2, byte b3) {
        if (j1.i) {
            j1.n(object, l2, b3);
        }
        j1.o(object, l2, b3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.i1
    public final void e(Object object, long l2, double d3) {
        this.o(object, l2, obj3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.i1
    public final void f(Object object, long l2, float f3) {
        n(object, l2, f3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.i1
    public final boolean g(Object object, long l2) {
        if (j1.i) {
            return j1.y(object, l2);
        }
        return j1.z(object, l2);
    }
}
