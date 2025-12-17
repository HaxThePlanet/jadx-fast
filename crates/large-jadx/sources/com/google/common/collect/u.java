package com.google.common.collect;

import java.io.Serializable;

/* loaded from: classes2.dex */
class u<K, V>  extends com.google.common.collect.e<K, V> implements Serializable {

    private static final long serialVersionUID;
    final K key;
    final V value;
    u(K k, V v2) {
        super();
        this.key = k;
        this.value = v2;
    }

    public final K getKey() {
        return this.key;
    }

    public final V getValue() {
        return this.value;
    }

    public final V setValue(V v) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }
}
