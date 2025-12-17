package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class c<K, V>  extends com.google.common.collect.d<K, V> implements com.google.common.collect.c0<K, V> {

    private static final long serialVersionUID = 6588350623831699109L;
    protected c(Map<K, Collection<V>> map) {
        super(map);
    }

    public Map<K, Collection<V>> a() {
        return super.a();
    }

    @Override // com.google.common.collect.d
    public boolean equals(Object object) {
        return super.equals(object);
    }

    public boolean put(K k, V v2) {
        return super.put(k, v2);
    }

    <E> Collection<E> w(Collection<E> collection) {
        return Collections.unmodifiableList((List)collection);
    }

    Collection<V> x(K k, Collection<V> collection2) {
        return y(k, (List)collection2, 0);
    }
}
