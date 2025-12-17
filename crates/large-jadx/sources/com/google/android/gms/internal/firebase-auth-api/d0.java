package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
final class d0<T>  implements com.google.android.gms.internal.firebase-auth-api.l0<T> {

    private final com.google.android.gms.internal.firebase-auth-api.y a;
    private final com.google.android.gms.internal.firebase-auth-api.y0<?, ?> b;
    private final boolean c;
    private final com.google.android.gms.internal.firebase-auth-api.mr<?> d;
    private d0(com.google.android.gms.internal.firebase-auth-api.y0<?, ?> y0, com.google.android.gms.internal.firebase-auth-api.mr<?> mr2, com.google.android.gms.internal.firebase-auth-api.y y3) {
        super();
        this.b = y0;
        this.c = mr2.h(y3);
        this.d = mr2;
        this.a = y3;
    }

    static <T> com.google.android.gms.internal.firebase-auth-api.d0<T> k(com.google.android.gms.internal.firebase-auth-api.y0<?, ?> y0, com.google.android.gms.internal.firebase-auth-api.mr<?> mr2, com.google.android.gms.internal.firebase-auth-api.y y3) {
        d0 d0Var = new d0(y0, mr2, y3);
        return d0Var;
    }

    public final T a() {
        return this.a.l().i();
    }

    public final int b(T t) {
        if (this.c) {
        } else {
            return this.b.d(t).hashCode();
        }
        this.d.a(t);
        throw 0;
    }

    public final void c(T t) {
        this.b.m(t);
        this.d.e(t);
    }

    public final int d(T t) {
        com.google.android.gms.internal.firebase-auth-api.y0 y0Var = this.b;
        if (this.c) {
        } else {
            return y0Var.b(y0Var.d(t));
        }
        this.d.a(t);
        throw 0;
    }

    public final void e(T t, T t2) {
        n0.f(this.b, t, t2);
        if (this.c) {
        } else {
        }
        n0.e(this.d, t, t2);
        throw 0;
    }

    public final void f(T t, com.google.android.gms.internal.firebase-auth-api.hr hr2) {
        this.d.a(t);
        throw 0;
    }

    public final boolean g(T t) {
        this.d.a(t);
        throw 0;
    }

    public final void h(T t, com.google.android.gms.internal.firebase-auth-api.k0 k02, com.google.android.gms.internal.firebase-auth-api.lr lr3) {
        Object obj;
        com.google.android.gms.internal.firebase-auth-api.y yVar;
        int i3;
        int i2;
        int i;
        int i4;
        final com.google.android.gms.internal.firebase-auth-api.y0 y0Var = this.b;
        final com.google.android.gms.internal.firebase-auth-api.mr mrVar = this.d;
        final Object obj2 = y0Var.c(t);
        final com.google.android.gms.internal.firebase-auth-api.qr qrVar = mrVar.b(t);
        int i8 = Integer.MAX_VALUE;
        while (k02.zzc() != i8) {
            int i6 = k02.b();
            obj = 0;
            i2 = i3;
            while (k02.zzc() == i8) {
                i = k02.b();
                if (k02.v()) {
                    break loop_11;
                }
                if (i3 != 0) {
                } else {
                }
                i2 = k02.e();
                mrVar.f(k02, i3, lr3, qrVar);
                i3 = mrVar.c(lr3, this.a, k02.zzj());
            }
            i = k02.b();
            if (i == 16) {
            } else {
            }
            if (i == 26) {
            } else {
            }
            if (k02.v()) {
            }
            if (i2 != 0) {
            }
            i8 = Integer.MAX_VALUE;
            if (i3 != 0) {
            } else {
            }
            y0Var.k(obj2, obj, i2);
            mrVar.g(i2, i3, lr3, qrVar);
            if (i3 != 0) {
            } else {
            }
            i2 = k02.e();
            mrVar.f(k02, i3, lr3, qrVar);
            i3 = mrVar.c(lr3, this.a, k02.zzj());
            obj = k02.v();
            obj = mrVar.c(lr3, this.a, i6 >>>= 3);
            obj = y0Var.p(obj2, k02);
            mrVar.f(k02, obj, lr3, qrVar);
        }
        y0Var.n(t, obj2);
    }

    public final void i(T t, byte[] b2Arr2, int i3, int i4, com.google.android.gms.internal.firebase-auth-api.mq mq5) {
        com.google.android.gms.internal.firebase-auth-api.a1 obj3;
        final Object obj2 = t;
        if (obj2.zzc != a1.c()) {
        } else {
            obj2.zzc = a1.e();
        }
        throw 0;
    }

    public final boolean j(T t, T t2) {
        if (!this.b.d(t).equals(this.b.d(t2))) {
            return 0;
        }
        if (this.c) {
        } else {
            return 1;
        }
        this.d.a(t);
        this.d.a(t2);
        throw 0;
    }
}
