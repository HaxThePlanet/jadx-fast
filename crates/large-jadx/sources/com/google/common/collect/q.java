package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class q<K, V>  extends com.google.common.collect.r implements Map<K, V> {
    protected abstract Map<K, V> c();

    @Override // com.google.common.collect.r
    public void clear() {
        c().clear();
    }

    @Override // com.google.common.collect.r
    public boolean containsKey(Object object) {
        return c().containsKey(object);
    }

    @Override // com.google.common.collect.r
    public boolean containsValue(Object object) {
        return c().containsValue(object);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return c().entrySet();
    }

    @Override // com.google.common.collect.r
    public boolean equals(Object object) {
        Map map;
        int obj2;
        if (object != this) {
            if (c().equals(object)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    public V get(Object object) {
        return c().get(object);
    }

    @Override // com.google.common.collect.r
    public int hashCode() {
        return c().hashCode();
    }

    @Override // com.google.common.collect.r
    public boolean isEmpty() {
        return c().isEmpty();
    }

    public Set<K> keySet() {
        return c().keySet();
    }

    public V put(K k, V v2) {
        return c().put(k, v2);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        c().putAll(map);
    }

    public V remove(Object object) {
        return c().remove(object);
    }

    @Override // com.google.common.collect.r
    public int size() {
        return c().size();
    }

    public Collection<V> values() {
        return c().values();
    }
}
