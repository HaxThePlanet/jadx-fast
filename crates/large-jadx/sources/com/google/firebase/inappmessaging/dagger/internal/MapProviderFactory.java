package com.google.firebase.inappmessaging.dagger.internal;

import com.google.firebase.inappmessaging.dagger.Lazy;
import j.a.a;
import java.util.Map;

/* loaded from: classes2.dex */
public final class MapProviderFactory<K, V>  extends com.google.firebase.inappmessaging.dagger.internal.AbstractMapFactory<K, V, a<V>> implements Lazy<Map<K, a<V>>> {

    public static final class Builder extends com.google.firebase.inappmessaging.dagger.internal.AbstractMapFactory.Builder<K, V, a<V>> {
        private Builder(int i) {
            super(i);
        }

        Builder(int i, com.google.firebase.inappmessaging.dagger.internal.MapProviderFactory.1 mapProviderFactory$12) {
            super(i);
        }

        public com.google.firebase.inappmessaging.dagger.internal.MapProviderFactory<K, V> build() {
            MapProviderFactory mapProviderFactory = new MapProviderFactory(this.map, 0);
            return mapProviderFactory;
        }

        @Override // com.google.firebase.inappmessaging.dagger.internal.AbstractMapFactory$Builder
        public com.google.firebase.inappmessaging.dagger.internal.AbstractMapFactory.Builder put(Object object, a a2) {
            return put(object, a2);
        }

        public com.google.firebase.inappmessaging.dagger.internal.MapProviderFactory.Builder<K, V> put(K k, a<V> a2) {
            super.put(k, a2);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.dagger.internal.AbstractMapFactory$Builder
        public com.google.firebase.inappmessaging.dagger.internal.AbstractMapFactory.Builder putAll(a a) {
            return putAll(a);
        }

        public com.google.firebase.inappmessaging.dagger.internal.MapProviderFactory.Builder<K, V> putAll(a<Map<K, a<V>>> a) {
            super.putAll(a);
            return this;
        }
    }
    private MapProviderFactory(Map<K, a<V>> map) {
        super(map);
    }

    MapProviderFactory(Map map, com.google.firebase.inappmessaging.dagger.internal.MapProviderFactory.1 mapProviderFactory$12) {
        super(map);
    }

    public static <K, V> com.google.firebase.inappmessaging.dagger.internal.MapProviderFactory.Builder<K, V> builder(int i) {
        MapProviderFactory.Builder builder = new MapProviderFactory.Builder(i, 0);
        return builder;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.AbstractMapFactory
    public Object get() {
        return get();
    }

    public Map<K, a<V>> get() {
        return contributingMap();
    }
}
