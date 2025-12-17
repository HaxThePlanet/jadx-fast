package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
abstract class y0<T, B>  {
    abstract int a(T t);

    abstract int b(T t);

    abstract B c(Object object);

    abstract T d(Object object);

    abstract T e(T t, T t2);

    abstract B f();

    abstract T g(B b);

    abstract void h(B b, int i2, int i3);

    abstract void i(B b, int i2, long l3);

    abstract void j(B b, int i2, T t3);

    abstract void k(B b, int i2, com.google.android.gms.internal.firebase-auth-api.wq wq3);

    abstract void l(B b, int i2, long l3);

    abstract void m(Object object);

    abstract void n(Object object, B b2);

    abstract void o(Object object, T t2);

    final boolean p(B b, com.google.android.gms.internal.firebase-auth-api.k0 k02) {
        int i;
        int i2;
        int i3 = k02.b();
        final int i5 = i3 >>> 3;
        i3 &= 7;
        final int i6 = 1;
        int i8 = 4;
        if (i4 != 0 && i4 != i6 && i4 != 2 && i4 != 3 && i4 != i8) {
            if (i4 != i6) {
                if (i4 != 2) {
                    i8 = 4;
                    if (i4 != 3) {
                        if (i4 != i8) {
                            if (i4 != 5) {
                            } else {
                                h(b, i5, k02.c());
                                return i6;
                            }
                            throw zzaae.a();
                        }
                        return 0;
                    }
                    Object obj = f();
                    while (k02.zzc() != Integer.MAX_VALUE) {
                        if (p(obj, k02) != 0) {
                        }
                    }
                    if (i8 |= i != k02.b()) {
                    } else {
                        g(obj);
                        j(b, i5, obj);
                        return i6;
                    }
                    throw zzaae.b();
                }
                k(b, i5, k02.e());
                return i6;
            }
            i(b, i5, k02.zzk());
            return i6;
        }
        l(b, i5, k02.h());
        return i6;
    }

    abstract boolean q(com.google.android.gms.internal.firebase-auth-api.k0 k0);

    abstract void r(T t, com.google.android.gms.internal.firebase-auth-api.hr hr2);
}
