package com.google.firebase.inappmessaging.display.dagger.internal;

import j.a.a;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class AbstractMapFactory<K, V, V2>  implements com.google.firebase.inappmessaging.display.dagger.internal.Factory<Map<K, V2>> {

    private final Map<K, a<V>> contributingMap;

    public static abstract class Builder {

        final LinkedHashMap<K, a<V>> map;
        Builder(int i) {
            super();
            this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(i);
        }

        com.google.firebase.inappmessaging.display.dagger.internal.AbstractMapFactory.Builder<K, V, V2> put(K k, a<V> a2) {
            this.map.put(Preconditions.checkNotNull(k, "key"), Preconditions.checkNotNull(a2, "provider"));
            return this;
        }

        com.google.firebase.inappmessaging.display.dagger.internal.AbstractMapFactory.Builder<K, V, V2> putAll(a<Map<K, V2>> a) {
            if (a instanceof DelegateFactory != null) {
                return putAll((DelegateFactory)a.getDelegate());
            }
            this.map.putAll(AbstractMapFactory.access$000((AbstractMapFactory)a));
            return this;
        }
    }
    AbstractMapFactory(Map<K, a<V>> map) {
        super();
        this.contributingMap = Collections.unmodifiableMap(map);
    }

    static Map access$000(com.google.firebase.inappmessaging.display.dagger.internal.AbstractMapFactory abstractMapFactory) {
        return abstractMapFactory.contributingMap;
    }

    final Map<K, a<V>> contributingMap() {
        return this.contributingMap;
    }

    public abstract T get();
}
