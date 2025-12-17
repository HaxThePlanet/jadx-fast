package com.google.firebase.inappmessaging.dagger.internal;

import j.a.a;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class MapFactory<K, V>  extends com.google.firebase.inappmessaging.dagger.internal.AbstractMapFactory<K, V, V> {

    private static final a<Map<Object, Object>> EMPTY;

    public static final class Builder extends com.google.firebase.inappmessaging.dagger.internal.AbstractMapFactory.Builder<K, V, V> {
        private Builder(int i) {
            super(i);
        }

        Builder(int i, com.google.firebase.inappmessaging.dagger.internal.MapFactory.1 mapFactory$12) {
            super(i);
        }

        public com.google.firebase.inappmessaging.dagger.internal.MapFactory<K, V> build() {
            MapFactory mapFactory = new MapFactory(this.map, 0);
            return mapFactory;
        }

        @Override // com.google.firebase.inappmessaging.dagger.internal.AbstractMapFactory$Builder
        public com.google.firebase.inappmessaging.dagger.internal.AbstractMapFactory.Builder put(Object object, a a2) {
            return put(object, a2);
        }

        public com.google.firebase.inappmessaging.dagger.internal.MapFactory.Builder<K, V> put(K k, a<V> a2) {
            super.put(k, a2);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.dagger.internal.AbstractMapFactory$Builder
        public com.google.firebase.inappmessaging.dagger.internal.AbstractMapFactory.Builder putAll(a a) {
            return putAll(a);
        }

        public com.google.firebase.inappmessaging.dagger.internal.MapFactory.Builder<K, V> putAll(a<Map<K, V>> a) {
            super.putAll(a);
            return this;
        }
    }
    static {
        MapFactory.EMPTY = InstanceFactory.create(Collections.emptyMap());
    }

    private MapFactory(Map<K, a<V>> map) {
        super(map);
    }

    MapFactory(Map map, com.google.firebase.inappmessaging.dagger.internal.MapFactory.1 mapFactory$12) {
        super(map);
    }

    public static <K, V> com.google.firebase.inappmessaging.dagger.internal.MapFactory.Builder<K, V> builder(int i) {
        MapFactory.Builder builder = new MapFactory.Builder(i, 0);
        return builder;
    }

    public static <K, V> a<Map<K, V>> emptyMapProvider() {
        return MapFactory.EMPTY;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.AbstractMapFactory
    public Object get() {
        return get();
    }

    public Map<K, V> get() {
        Object obj;
        Object key;
        java.util.LinkedHashMap linkedHashMapWithExpectedSize = DaggerCollections.newLinkedHashMapWithExpectedSize(contributingMap().size());
        Iterator iterator = contributingMap().entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            linkedHashMapWithExpectedSize.put(next2.getKey(), (a)next2.getValue().get());
        }
        return Collections.unmodifiableMap(linkedHashMapWithExpectedSize);
    }
}
