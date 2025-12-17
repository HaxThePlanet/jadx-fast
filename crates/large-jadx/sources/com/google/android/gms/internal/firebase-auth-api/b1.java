package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
final class b1 extends com.google.android.gms.internal.firebase-auth-api.y0<com.google.android.gms.internal.firebase-auth-api.a1, com.google.android.gms.internal.firebase-auth-api.a1> {
    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final int a(Object object) {
        return (a1)object.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final int b(Object object) {
        return (a1)object.b();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final Object c(Object object) {
        com.google.android.gms.internal.firebase-auth-api.a1 zzc;
        if (object.zzc == a1.c()) {
            object.zzc = a1.e();
        }
        return zzc;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final Object d(Object object) {
        return object.zzc;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final Object e(Object object, Object object2) {
        if ((a1)object2.equals(a1.c())) {
            return object;
        }
        return a1.d((a1)object, object2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final Object f() {
        return a1.e();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final Object g(Object object) {
        (a1)object.f();
        return object;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final void h(Object object, int i2, int i3) {
        (a1)object.h(obj2 |= 5, Integer.valueOf(i3));
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final void i(Object object, int i2, long l3) {
        (a1)object.h(obj2 |= 1, Long.valueOf(l3));
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final void j(Object object, int i2, Object object3) {
        (a1)object.h(obj2 |= 3, object3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final void k(Object object, int i2, com.google.android.gms.internal.firebase-auth-api.wq wq3) {
        (a1)object.h(obj2 |= 2, wq3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final void l(Object object, int i2, long l3) {
        (a1)object.h(i2 <<= 3, Long.valueOf(l3));
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final void m(Object object) {
        object.zzc.f();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final void n(Object object, Object object2) {
        object.zzc = (a1)object2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final void o(Object object, Object object2) {
        object.zzc = (a1)object2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final boolean q(com.google.android.gms.internal.firebase-auth-api.k0 k0) {
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.y0
    final void r(Object object, com.google.android.gms.internal.firebase-auth-api.hr hr2) {
        (a1)object.i(hr2);
    }
}
