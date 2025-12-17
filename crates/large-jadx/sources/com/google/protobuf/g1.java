package com.google.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
final class g1 {

    private static final com.google.protobuf.g1 c;
    private final com.google.protobuf.m1 a;
    private final ConcurrentMap<Class<?>, com.google.protobuf.l1<?>> b;
    static {
        g1 g1Var = new g1();
        g1.c = g1Var;
    }

    private g1() {
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.b = concurrentHashMap;
        l0 l0Var = new l0();
        this.a = l0Var;
    }

    public static com.google.protobuf.g1 a() {
        return g1.c;
    }

    public <T> void b(T t, com.google.protobuf.j1 j12, com.google.protobuf.q q3) {
        e(t).e(t, j12, q3);
    }

    public com.google.protobuf.l1<?> c(Class<?> class, com.google.protobuf.l1<?> l12) {
        c0.b(class, "messageType");
        c0.b(l12, "schema");
        return (l1)this.b.putIfAbsent(class, l12);
    }

    public <T> com.google.protobuf.l1<T> d(Class<T> class) {
        Object obj;
        Object obj2;
        c0.b(class, "messageType");
        obj2 = c(class, this.a.a(class));
        if ((l1)this.b.get(class) == null && obj2 != null) {
            obj2 = c(class, this.a.a(class));
            if (obj2 != null) {
                obj = obj2;
            }
        }
        return obj;
    }

    public <T> com.google.protobuf.l1<T> e(T t) {
        return d(t.getClass());
    }
}
