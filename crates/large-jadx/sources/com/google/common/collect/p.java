package com.google.common.collect;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public abstract class p<K, V>  extends com.google.common.collect.q<K, V> implements ConcurrentMap<K, V> {
    @Override // com.google.common.collect.q
    protected Object a() {
        return d();
    }

    @Override // com.google.common.collect.q
    protected Map c() {
        return d();
    }

    protected abstract ConcurrentMap<K, V> d();

    public V putIfAbsent(K k, V v2) {
        return d().putIfAbsent(k, v2);
    }

    @Override // com.google.common.collect.q
    public boolean remove(Object object, Object object2) {
        return d().remove(object, object2);
    }

    public V replace(K k, V v2) {
        return d().replace(k, v2);
    }

    public boolean replace(K k, V v2, V v3) {
        return d().replace(k, v2, v3);
    }
}
