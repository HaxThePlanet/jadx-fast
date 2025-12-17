package com.google.android.gms.internal.firebase-auth-api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class lr {

    private static volatile com.google.android.gms.internal.firebase-auth-api.lr b;
    static final com.google.android.gms.internal.firebase-auth-api.lr c;
    private final Map<com.google.android.gms.internal.firebase-auth-api.kr, com.google.android.gms.internal.firebase-auth-api.wr<?, ?>> a;
    static {
        lr lrVar = new lr(1);
        lr.c = lrVar;
    }

    lr() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
    }

    lr(boolean z) {
        super();
        this.a = Collections.emptyMap();
    }

    public static com.google.android.gms.internal.firebase-auth-api.lr a() {
        com.google.android.gms.internal.firebase-auth-api.lr lrVar;
        Class<com.google.android.gms.internal.firebase-auth-api.lr> obj;
        obj = lr.class;
        if (lr.b == null && lr.b == null) {
            obj = lr.class;
            synchronized (obj) {
                lr.b = lr.c;
            }
        }
        return lrVar;
    }

    public final <ContainingType extends com.google.android.gms.internal.firebase-auth-api.y> com.google.android.gms.internal.firebase-auth-api.wr<ContainingType, ?> b(ContainingType containingtype, int i2) {
        kr krVar = new kr(containingtype, i2);
        return (wr)this.a.get(krVar);
    }
}
