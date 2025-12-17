package com.google.android.gms.internal.firebase-auth-api;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes2.dex */
class v0<K extends Comparable<K>, V>  extends AbstractMap<K, V> {

    private final int a;
    private List<com.google.android.gms.internal.firebase-auth-api.s0> b;
    private Map<K, V> c;
    private boolean v;
    private volatile com.google.android.gms.internal.firebase-auth-api.u0 w;
    private Map<K, V> x;
    v0(int i, com.google.android.gms.internal.firebase-auth-api.o0 o02) {
        super();
        this.a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
        this.x = Collections.emptyMap();
    }

    static Object e(com.google.android.gms.internal.firebase-auth-api.v0 v0, int i2) {
        return v0.m(i2);
    }

    static List g(com.google.android.gms.internal.firebase-auth-api.v0 v0) {
        return v0.b;
    }

    static Map i(com.google.android.gms.internal.firebase-auth-api.v0 v0) {
        return v0.c;
    }

    static void j(com.google.android.gms.internal.firebase-auth-api.v0 v0) {
        v0.o();
    }

    private final int l(K k) {
        int i;
        int i2;
        int compareTo;
        int compareTo2;
        size--;
        i2 = 0;
        compareTo = k.compareTo((s0)this.b.get(i).a());
        if (i >= 0 && compareTo > 0) {
            compareTo = k.compareTo((s0)this.b.get(i).a());
            if (compareTo > 0) {
                return -i3;
            }
            if (compareTo != 0) {
            }
            return i;
        }
        while (i2 <= i) {
            i5 /= 2;
            compareTo2 = k.compareTo((s0)this.b.get(i6).a());
            i2 = compareTo;
            i = compareTo;
        }
        return -i4;
    }

    private final V m(int i) {
        boolean iterator;
        List list;
        com.google.android.gms.internal.firebase-auth-api.s0 s0Var;
        Object value;
        Object key;
        o();
        if (!this.c.isEmpty()) {
            iterator = n().entrySet().iterator();
            Object next = iterator.next();
            s0Var = new s0(this, (Comparable)(Map.Entry)next.getKey(), next.getValue());
            this.b.add(s0Var);
            iterator.remove();
        }
        return (s0)this.b.remove(i).getValue();
    }

    private final SortedMap<K, V> n() {
        boolean descendingMap;
        o();
        if (this.c.isEmpty() && map3 instanceof TreeMap == null) {
            if (map3 instanceof TreeMap == null) {
                TreeMap treeMap = new TreeMap();
                this.c = treeMap;
                this.x = (TreeMap)treeMap.descendingMap();
            }
        }
        return (SortedMap)this.c;
    }

    private final void o() {
        if (this.v) {
        } else {
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // java.util.AbstractMap
    public void a() {
        Map unmodifiableMap;
        Map unmodifiableMap2;
        boolean z;
        if (!this.v) {
            if (this.c.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(this.c);
            }
            this.c = unmodifiableMap;
            if (this.x.isEmpty()) {
                unmodifiableMap2 = Collections.emptyMap();
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(this.x);
            }
            this.x = unmodifiableMap2;
            this.v = true;
        }
    }

    @Override // java.util.AbstractMap
    public final int c() {
        return this.b.size();
    }

    @Override // java.util.AbstractMap
    public final void clear() {
        boolean empty;
        boolean empty2;
        o();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
    }

    @Override // java.util.AbstractMap
    public final boolean containsKey(Object object) {
        int i;
        Comparable obj2;
        if (l((Comparable)object) < 0 && this.c.containsKey(object)) {
            if (this.c.containsKey(object)) {
            }
            return 0;
        }
        return 1;
    }

    public final Iterable<Map.Entry<K, V>> d() {
        Object entrySet;
        if (this.c.isEmpty()) {
            entrySet = r0.a();
        } else {
            entrySet = this.c.entrySet();
        }
        return entrySet;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        com.google.android.gms.internal.firebase-auth-api.u0 u0Var;
        int i;
        if (this.w == null) {
            u0Var = new u0(this, 0);
            this.w = u0Var;
        }
        return this.w;
    }

    @Override // java.util.AbstractMap
    public final boolean equals(Object object) {
        int i;
        boolean equals;
        Map.Entry map;
        int i2 = 1;
        if (this == object) {
            return i2;
        }
        if (!object instanceof v0) {
            return super.equals(object);
        }
        int size = size();
        final int i4 = 0;
        if (size != (v0)object.size()) {
            return i4;
        }
        int i3 = c();
        if (i3 == object.c()) {
            i = i4;
            while (i < i3) {
                i++;
            }
            if (i3 != size) {
                return this.c.equals(object.c);
            }
            return i2;
        }
        return entrySet().equals(object.entrySet());
    }

    public final V f(K k, V v2) {
        boolean arrayList;
        int value;
        int i;
        int i2;
        Comparable comparable;
        o();
        int i3 = l(k);
        if (i3 >= 0) {
            return (s0)this.b.get(i3).setValue(v2);
        }
        o();
        if (this.b.isEmpty() && list2 instanceof ArrayList == null) {
            if (list2 instanceof ArrayList == null) {
                arrayList = new ArrayList(this.a);
                this.b = arrayList;
            }
        }
        int i5 = -i4;
        if (i5 >= this.a) {
            return n().put(k, v2);
        }
        i2 = this.a;
        if (this.b.size() == i2) {
            Object remove = this.b.remove(i2--);
            n().put((s0)remove.a(), remove.getValue());
        }
        s0 s0Var = new s0(this, k, v2);
        this.b.add(i5, s0Var);
        return 0;
    }

    public final V get(Object object) {
        int i = l((Comparable)object);
        if (i >= 0) {
            return (s0)this.b.get(i).getValue();
        }
        return this.c.get(object);
    }

    public final Map.Entry<K, V> h(int i) {
        return (Map.Entry)this.b.get(i);
    }

    @Override // java.util.AbstractMap
    public final int hashCode() {
        int size;
        int i3;
        int i2;
        int i;
        i2 = i3;
        while (i3 < c()) {
            i2 += i;
            i3++;
        }
        if (this.c.size() > 0) {
            i2 += size;
        }
        return i2;
    }

    @Override // java.util.AbstractMap
    public final boolean k() {
        return this.v;
    }

    @Override // java.util.AbstractMap
    public final Object put(Object object, Object object2) {
        return f((Comparable)object, object2);
    }

    public final V remove(Object object) {
        o();
        int i = l((Comparable)object);
        if (i >= 0) {
            return m(i);
        }
        if (this.c.isEmpty()) {
            return 0;
        }
        return this.c.remove(object);
    }

    @Override // java.util.AbstractMap
    public final int size() {
        return size += size2;
    }
}
