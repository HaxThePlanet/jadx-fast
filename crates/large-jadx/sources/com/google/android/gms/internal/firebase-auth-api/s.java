package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class s<K, V>  extends LinkedHashMap<K, V> {

    private static final com.google.android.gms.internal.firebase-auth-api.s a;
    private boolean zzb = true;
    static {
        s sVar = new s();
        s.a = sVar;
        sVar.zzb = false;
    }

    private s() {
        super();
        final int i = 1;
    }

    private s(Map<K, V> map) {
        super(map);
        final int obj1 = 1;
    }

    public static <K, V> com.google.android.gms.internal.firebase-auth-api.s<K, V> a() {
        return s.a;
    }

    private static int g(Object object) {
        if (object instanceof byte[]) {
            return e.b((byte[])object);
        }
        if (object instanceof zr) {
        } else {
            return object.hashCode();
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    private final void h() {
        if (!this.zzb) {
        } else {
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final com.google.android.gms.internal.firebase-auth-api.s<K, V> c() {
        com.google.android.gms.internal.firebase-auth-api.s sVar;
        if (isEmpty()) {
            sVar = new s();
        } else {
            sVar = new s(this);
        }
        return sVar;
    }

    @Override // java.util.LinkedHashMap
    public final void clear() {
        h();
        super.clear();
    }

    @Override // java.util.LinkedHashMap
    public final void d() {
        this.zzb = false;
    }

    public final void e(com.google.android.gms.internal.firebase-auth-api.s<K, V> s) {
        h();
        if (!s.isEmpty()) {
            putAll(s);
        }
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        Set emptySet;
        if (isEmpty()) {
            emptySet = Collections.emptySet();
        } else {
            emptySet = super.entrySet();
        }
        return emptySet;
    }

    @Override // java.util.LinkedHashMap
    public final boolean equals(Object object) {
        Iterator iterator;
        int equals;
        Object value;
        boolean z;
        if (object instanceof Map != null) {
            if (this == (Map)object) {
            } else {
                if (size() != (Map)object.size()) {
                } else {
                    iterator = entrySet().iterator();
                    for (Map.Entry equals : iterator) {
                        value = equals.getValue();
                        Object obj = object.get(equals.getKey());
                        if (value instanceof byte[] && obj instanceof byte[]) {
                        } else {
                        }
                        equals = value.equals(obj);
                        if (obj instanceof byte[]) {
                        } else {
                        }
                        equals = Arrays.equals((byte[])value, (byte[])obj);
                    }
                }
            }
            return 1;
        }
        return 0;
    }

    @Override // java.util.LinkedHashMap
    public final boolean f() {
        return this.zzb;
    }

    @Override // java.util.LinkedHashMap
    public final int hashCode() {
        int i;
        int i2;
        int i3;
        Iterator iterator = entrySet().iterator();
        i = 0;
        for (Map.Entry next2 : iterator) {
            i += i2;
        }
        return i;
    }

    public final V put(K k, V v2) {
        h();
        e.e(k);
        e.e(v2);
        return super.put(k, v2);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        Object obj;
        h();
        Iterator iterator = map.keySet().iterator();
        for (Object next2 : iterator) {
            e.e(next2);
            e.e(map.get(next2));
        }
        super.putAll(map);
    }

    public final V remove(Object object) {
        h();
        return super.remove(object);
    }
}
