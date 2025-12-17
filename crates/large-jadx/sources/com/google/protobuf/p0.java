package com.google.protobuf;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
class p0 implements com.google.protobuf.o0 {
    private static <K, V> int i(int i, Object object2, Object object3) {
        boolean empty;
        int i2;
        Object key;
        if ((n0)object2.isEmpty()) {
            return 0;
        }
        Iterator obj4 = object2.entrySet().iterator();
        for (Map.Entry next2 : obj4) {
            i2 += empty;
        }
        return i2;
    }

    private static <K, V> com.google.protobuf.n0<K, V> j(Object object, Object object2) {
        boolean empty;
        com.google.protobuf.n0 obj1;
        if (!(n0)object2.isEmpty() && !(n0)object.j()) {
            if (!object.j()) {
                obj1 = object.m();
            }
            obj1.l(object2);
        }
        return obj1;
    }

    @Override // com.google.protobuf.o0
    public Object a(Object object, Object object2) {
        return p0.j(object, object2);
    }

    @Override // com.google.protobuf.o0
    public Object b(Object object) {
        (n0)object.k();
        return object;
    }

    public com.google.protobuf.m0.a<?, ?> c(Object object) {
        return (m0)object.c();
    }

    public Map<?, ?> d(Object object) {
        return (n0)object;
    }

    @Override // com.google.protobuf.o0
    public Object e(Object object) {
        return n0.e().m();
    }

    @Override // com.google.protobuf.o0
    public int f(int i, Object object2, Object object3) {
        return p0.i(i, object2, object3);
    }

    @Override // com.google.protobuf.o0
    public boolean g(Object object) {
        return obj1 ^= 1;
    }

    public Map<?, ?> h(Object object) {
        return (n0)object;
    }
}
