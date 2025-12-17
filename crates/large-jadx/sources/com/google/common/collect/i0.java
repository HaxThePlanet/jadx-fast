package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
public interface i0<K, V>  {
    public abstract Map<K, Collection<V>> a();

    public abstract void clear();

    public abstract boolean put(K k, V v2);

    public abstract int size();

    public abstract Collection<V> values();
}
