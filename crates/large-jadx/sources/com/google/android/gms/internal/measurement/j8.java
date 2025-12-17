package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class j8 {

    private static volatile com.google.android.gms.internal.measurement.j8 b;
    private static volatile com.google.android.gms.internal.measurement.j8 c;
    static final com.google.android.gms.internal.measurement.j8 d;
    private final Map<com.google.android.gms.internal.measurement.i8, com.google.android.gms.internal.measurement.v8<?, ?>> a;
    static {
        j8 j8Var = new j8(1);
        j8.d = j8Var;
    }

    j8() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
    }

    j8(boolean z) {
        super();
        this.a = Collections.emptyMap();
    }

    public static com.google.android.gms.internal.measurement.j8 a() {
        com.google.android.gms.internal.measurement.j8 j8Var;
        Class<com.google.android.gms.internal.measurement.j8> obj;
        obj = j8.class;
        if (j8.b == null && j8.b == null) {
            obj = j8.class;
            synchronized (obj) {
                j8.b = j8.d;
            }
        }
        return j8Var;
    }

    public static com.google.android.gms.internal.measurement.j8 b() {
        final Class<com.google.android.gms.internal.measurement.j8> obj = j8.class;
        com.google.android.gms.internal.measurement.j8 j8Var = j8.c;
        if (j8Var != null) {
            return j8Var;
        }
        com.google.android.gms.internal.measurement.j8 j8Var2 = j8.c;
        synchronized (obj) {
            return j8Var2;
        }
    }

    public final <ContainingType extends com.google.android.gms.internal.measurement.y9> com.google.android.gms.internal.measurement.v8<ContainingType, ?> c(ContainingType containingtype, int i2) {
        i8 i8Var = new i8(containingtype, i2);
        return (v8)this.a.get(i8Var);
    }
}
