package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class i7 {
    public static <T> com.google.android.gms.internal.measurement.e7<T> a(com.google.android.gms.internal.measurement.e7<T> e7) {
        boolean z;
        Object g7Var;
        if (!e7 instanceof g7) {
            if (e7 instanceof f7) {
            } else {
                if (e7 instanceof Serializable) {
                    g7Var = new f7(e7);
                } else {
                    g7Var = new g7(e7);
                }
            }
            return g7Var;
        }
        return e7;
    }

    public static <T> com.google.android.gms.internal.measurement.e7<T> b(T t) {
        h7 h7Var = new h7(t);
        return h7Var;
    }
}
