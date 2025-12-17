package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class ca<T>  implements com.google.android.gms.internal.measurement.ja<T> {

    private final com.google.android.gms.internal.measurement.y9 a;
    private final com.google.android.gms.internal.measurement.xa<?, ?> b;
    private final boolean c;
    private final com.google.android.gms.internal.measurement.k8<?> d;
    private ca(com.google.android.gms.internal.measurement.xa<?, ?> xa, com.google.android.gms.internal.measurement.k8<?> k82, com.google.android.gms.internal.measurement.y9 y93) {
        super();
        this.b = xa;
        this.c = k82.c(y93);
        this.d = k82;
        this.a = y93;
    }

    static <T> com.google.android.gms.internal.measurement.ca<T> j(com.google.android.gms.internal.measurement.xa<?, ?> xa, com.google.android.gms.internal.measurement.k8<?> k82, com.google.android.gms.internal.measurement.y9 y93) {
        ca caVar = new ca(xa, k82, y93);
        return caVar;
    }

    public final T a() {
        return this.a.f().t0();
    }

    public final int b(T t) {
        if (this.c) {
        } else {
            return this.b.c(t).hashCode();
        }
        this.d.a(t);
        throw 0;
    }

    public final void c(T t) {
        this.b.g(t);
        this.d.b(t);
    }

    public final int d(T t) {
        com.google.android.gms.internal.measurement.xa xaVar = this.b;
        if (this.c) {
        } else {
            return xaVar.b(xaVar.c(t));
        }
        this.d.a(t);
        throw 0;
    }

    public final void e(T t, T t2) {
        la.f(this.b, t, t2);
        if (this.c) {
        } else {
        }
        la.e(this.d, t, t2);
        throw 0;
    }

    public final boolean f(T t) {
        this.d.a(t);
        throw 0;
    }

    public final void g(T t, byte[] b2Arr2, int i3, int i4, com.google.android.gms.internal.measurement.n7 n75) {
        com.google.android.gms.internal.measurement.ya obj3;
        final Object obj2 = t;
        if (obj2.zzc != ya.c()) {
        } else {
            obj2.zzc = ya.e();
        }
        throw 0;
    }

    public final boolean h(T t, T t2) {
        if (!this.b.c(t).equals(this.b.c(t2))) {
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

    public final void i(T t, com.google.android.gms.internal.measurement.f8 f82) {
        this.d.a(t);
        throw 0;
    }
}
