package com.google.android.gms.internal.firebase-auth-api;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
final class h0 {

    private static final com.google.android.gms.internal.firebase-auth-api.h0 c;
    private final com.google.android.gms.internal.firebase-auth-api.m0 a;
    private final ConcurrentMap<Class<?>, com.google.android.gms.internal.firebase-auth-api.l0<?>> b;
    static {
        h0 h0Var = new h0();
        h0.c = h0Var;
    }

    private h0() {
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.b = concurrentHashMap;
        q qVar = new q();
        this.a = qVar;
    }

    public static com.google.android.gms.internal.firebase-auth-api.h0 a() {
        return h0.c;
    }

    public final <T> com.google.android.gms.internal.firebase-auth-api.l0<T> b(Class<T> class) {
        Object str;
        Object obj;
        Object obj3;
        str = "messageType";
        e.f(class, str);
        obj = this.a.c(class);
        e.f(class, str);
        e.f(obj, "schema");
        obj3 = this.b.putIfAbsent(class, obj);
        if ((l0)this.b.get(class) == null && (l0)obj3 == null) {
            obj = this.a.c(class);
            e.f(class, str);
            e.f(obj, "schema");
            obj3 = this.b.putIfAbsent(class, obj);
            if ((l0)(l0)obj3 == null) {
            }
            return (l0)(l0)obj3;
        }
        return obj;
    }
}
