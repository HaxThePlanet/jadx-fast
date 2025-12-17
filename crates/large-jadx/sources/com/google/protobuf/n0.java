package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class n0<K, V>  extends LinkedHashMap<K, V> {

    private static final com.google.protobuf.n0 a;
    private boolean isMutable = true;
    static {
        n0 n0Var = new n0();
        n0.a = n0Var;
        n0Var.k();
    }

    private n0() {
        super();
        final int i = 1;
    }

    private n0(Map<K, V> map) {
        super(map);
        final int obj1 = 1;
    }

    static <K, V> int a(Map<K, V> map) {
        int i;
        int i2;
        int i3;
        Iterator obj3 = map.entrySet().iterator();
        i = 0;
        for (Map.Entry next2 : obj3) {
            i += i2;
        }
        return i;
    }

    private static int c(Object object) {
        if (object instanceof byte[]) {
            return c0.d((byte[])object);
        }
        if (object instanceof c0.c) {
        } else {
            return object.hashCode();
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    private static void d(Map<?, ?> map) {
        Object obj;
        Iterator iterator = map.keySet().iterator();
        for (Object next2 : iterator) {
            c0.a(next2);
            c0.a(map.get(next2));
        }
    }

    public static <K, V> com.google.protobuf.n0<K, V> e() {
        return n0.a;
    }

    private void f() {
        if (!j()) {
        } else {
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    private static boolean g(Object object, Object object2) {
        boolean z;
        if (object instanceof byte[] && object2 instanceof byte[]) {
            if (object2 instanceof byte[]) {
                return Arrays.equals((byte[])object, (byte[])object2);
            }
        }
        return object.equals(object2);
    }

    static <K, V> boolean h(Map<K, V> map, Map<K, V> map2) {
        int size;
        int value;
        final int i = 1;
        if (map == map2) {
            return i;
        }
        final int i2 = 0;
        if (map.size() != map2.size()) {
            return i2;
        }
        Iterator obj4 = map.entrySet().iterator();
        for (Map.Entry next2 : obj4) {
        }
        return i;
    }

    @Override // java.util.LinkedHashMap
    public void clear() {
        f();
        super.clear();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set emptySet;
        if (isEmpty()) {
            emptySet = Collections.emptySet();
        } else {
            emptySet = super.entrySet();
        }
        return emptySet;
    }

    @Override // java.util.LinkedHashMap
    public boolean equals(Object object) {
        Object obj2;
        if (object instanceof Map != null && n0.h(this, (Map)object)) {
            obj2 = n0.h(this, (Map)object) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // java.util.LinkedHashMap
    public int hashCode() {
        return n0.a(this);
    }

    @Override // java.util.LinkedHashMap
    public boolean j() {
        return this.isMutable;
    }

    @Override // java.util.LinkedHashMap
    public void k() {
        this.isMutable = false;
    }

    public void l(com.google.protobuf.n0<K, V> n0) {
        f();
        if (!n0.isEmpty()) {
            putAll(n0);
        }
    }

    public com.google.protobuf.n0<K, V> m() {
        com.google.protobuf.n0 n0Var;
        if (isEmpty()) {
            n0Var = new n0();
        } else {
            n0Var = new n0(this);
        }
        return n0Var;
    }

    public V put(K k, V v2) {
        f();
        c0.a(k);
        c0.a(v2);
        return super.put(k, v2);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        f();
        n0.d(map);
        super.putAll(map);
    }

    public V remove(Object object) {
        f();
        return super.remove(object);
    }
}
