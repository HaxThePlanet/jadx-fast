package io.jsonwebtoken.lang;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Maps {

    public interface MapBuilder {
        public abstract io.jsonwebtoken.lang.Maps.MapBuilder<K, V> and(K k, V v2);

        public abstract Map<K, V> build();
    }

    private static class HashMapBuilder implements io.jsonwebtoken.lang.Maps.MapBuilder<K, V> {

        private final Map<K, V> data;
        private HashMapBuilder() {
            super();
            HashMap hashMap = new HashMap();
            this.data = hashMap;
        }

        HashMapBuilder(io.jsonwebtoken.lang.Maps.1 maps$1) {
            super();
        }

        public io.jsonwebtoken.lang.Maps.MapBuilder<K, V> and(K k, V v2) {
            this.data.put(k, v2);
            return this;
        }

        public Map<K, V> build() {
            return Collections.unmodifiableMap(this.data);
        }
    }
    public static <K, V> io.jsonwebtoken.lang.Maps.MapBuilder<K, V> of(K k, V v2) {
        Maps.HashMapBuilder hashMapBuilder = new Maps.HashMapBuilder(0);
        return hashMapBuilder.and(k, v2);
    }
}
