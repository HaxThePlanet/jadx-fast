package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class r9<K, V>  extends LinkedHashMap<K, V> {

    private static final com.google.android.gms.internal.measurement.r9 a;
    private boolean zzb = true;
    static {
        r9 r9Var = new r9();
        r9.a = r9Var;
        r9Var.zzb = false;
    }

    private r9() {
        super();
        final int i = 1;
    }

    private r9(Map<K, V> map) {
        super(map);
        final int obj1 = 1;
    }

    public static <K, V> com.google.android.gms.internal.measurement.r9<K, V> a() {
        return r9.a;
    }

    private static int g(Object object) {
        if (object instanceof byte[]) {
            return d9.b((byte[])object);
        }
        return object.hashCode();
    }

    private final void h() {
        if (!this.zzb) {
        } else {
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final com.google.android.gms.internal.measurement.r9<K, V> c() {
        com.google.android.gms.internal.measurement.r9 r9Var;
        if (isEmpty()) {
            r9Var = new r9();
        } else {
            r9Var = new r9(this);
        }
        return r9Var;
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

    public final void e(com.google.android.gms.internal.measurement.r9<K, V> r9) {
        h();
        if (!r9.isEmpty()) {
            putAll(r9);
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
        int i3;
        int i;
        int i2;
        Iterator iterator = entrySet().iterator();
        i3 = 0;
        for (Map.Entry next2 : iterator) {
            i3 += i;
        }
        return i3;
    }

    public final V put(K k, V v2) {
        h();
        d9.e(k);
        d9.e(v2);
        return super.put(k, v2);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        Object obj;
        h();
        Iterator iterator = map.keySet().iterator();
        for (Object next2 : iterator) {
            d9.e(next2);
            d9.e(map.get(next2));
        }
        super.putAll(map);
    }

    public final V remove(Object object) {
        h();
        return super.remove(object);
    }
}
