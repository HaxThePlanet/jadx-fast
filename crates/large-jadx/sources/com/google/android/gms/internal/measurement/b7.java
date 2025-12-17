package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* loaded from: classes2.dex */
public abstract class b7<T>  implements Serializable {
    public static <T> com.google.android.gms.internal.measurement.b7<T> c() {
        return z6.a;
    }

    public static <T> com.google.android.gms.internal.measurement.b7<T> d(T t) {
        d7 d7Var = new d7(t);
        return d7Var;
    }

    public abstract T a();

    @Override // java.io.Serializable
    public abstract boolean b();
}
