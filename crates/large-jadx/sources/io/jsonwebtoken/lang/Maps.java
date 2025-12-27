package io.jsonwebtoken.lang;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Maps.java */
/* loaded from: classes3.dex */
public final class Maps {

    public interface MapBuilder<K, V> {
        Maps.MapBuilder<K, V> and(K k, V v);

        Map<K, V> build();
    }

    private static class HashMapBuilder<K, V> implements Maps.MapBuilder<K, V> {

        private final Map<K, V> data;
        private HashMapBuilder() {
            super();
            this.data = new HashMap();
        }

        public Maps.MapBuilder<K, V> and(K k, V v) {
            this.data.put(k, v);
            return this;
        }

        public Map<K, V> build() {
            return Collections.unmodifiableMap(this.data);
        }

        /* synthetic */ HashMapBuilder() {
            this();
        }
    }
    private Maps() {
        super();
    }

    public static <K, V> Maps.MapBuilder<K, V> of(K k, V v) {
        return new Maps.HashMapBuilder(null).and(k, v);
    }
}
