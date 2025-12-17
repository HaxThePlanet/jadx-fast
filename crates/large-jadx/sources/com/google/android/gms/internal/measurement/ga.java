package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
final class ga {

    private static final com.google.android.gms.internal.measurement.ga c;
    private final com.google.android.gms.internal.measurement.ka a;
    private final ConcurrentMap<Class<?>, com.google.android.gms.internal.measurement.ja<?>> b;
    static {
        ga gaVar = new ga();
        ga.c = gaVar;
    }

    private ga() {
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.b = concurrentHashMap;
        p9 p9Var = new p9();
        this.a = p9Var;
    }

    public static com.google.android.gms.internal.measurement.ga a() {
        return ga.c;
    }

    public final <T> com.google.android.gms.internal.measurement.ja<T> b(Class<T> class) {
        Object str;
        Object obj;
        Object obj3;
        str = "messageType";
        d9.f(class, str);
        obj = this.a.c(class);
        d9.f(class, str);
        d9.f(obj, "schema");
        obj3 = this.b.putIfAbsent(class, obj);
        if ((ja)this.b.get(class) == null && (ja)obj3 == null) {
            obj = this.a.c(class);
            d9.f(class, str);
            d9.f(obj, "schema");
            obj3 = this.b.putIfAbsent(class, obj);
            if ((ja)(ja)obj3 == null) {
            }
            return (ja)(ja)obj3;
        }
        return obj;
    }
}
