package com.google.firebase.inappmessaging.dagger.internal;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class MapBuilder<K, V>  {

    private final Map<K, V> contributions;
    private MapBuilder(int i) {
        super();
        this.contributions = DaggerCollections.newLinkedHashMapWithExpectedSize(i);
    }

    public static <K, V> com.google.firebase.inappmessaging.dagger.internal.MapBuilder<K, V> newMapBuilder(int i) {
        MapBuilder mapBuilder = new MapBuilder(i);
        return mapBuilder;
    }

    public Map<K, V> build() {
        if (this.contributions.size() != 0) {
            return Collections.unmodifiableMap(this.contributions);
        }
        return Collections.emptyMap();
    }

    public com.google.firebase.inappmessaging.dagger.internal.MapBuilder<K, V> put(K k, V v2) {
        this.contributions.put(k, v2);
        return this;
    }

    public com.google.firebase.inappmessaging.dagger.internal.MapBuilder<K, V> putAll(Map<K, V> map) {
        this.contributions.putAll(map);
        return this;
    }
}
