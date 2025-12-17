package com.google.common.collect;

import com.google.common.base.g;
import com.google.common.base.k;
import com.google.common.base.n;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class h0 {

    static class e extends AbstractCollection<V> {

        final Map<K, V> a;
        e(Map<K, V> map) {
            super();
            n.o(map);
            this.a = (Map)map;
        }

        final Map<K, V> b() {
            return this.a;
        }

        @Override // java.util.AbstractCollection
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection
        public boolean contains(Object object) {
            return b().containsValue(object);
        }

        @Override // java.util.AbstractCollection
        public boolean isEmpty() {
            return b().isEmpty();
        }

        public Iterator<V> iterator() {
            return h0.k(b().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection
        public boolean remove(Object object) {
            boolean next;
            Object obj;
            try {
                return super.remove(object);
                Map key = b();
                key = key.entrySet();
                key = key.iterator();
                next = key.hasNext();
                next = key.next();
                obj = (Map.Entry)next.getValue();
                obj = k.a(object, obj);
            }
            object = null;
            return object;
        }

        public boolean removeAll(Collection<?> collection) {
            Map iterator;
            boolean key;
            Object contains;
            try {
                n.o(collection);
                return super.removeAll((Collection)collection);
                java.util.HashSet set = y0.d();
                iterator = b();
                iterator = iterator.entrySet();
                iterator = iterator.iterator();
                key = iterator.hasNext();
                key = iterator.next();
                contains = (Map.Entry)key.getValue();
                contains = collection.contains(contains);
                if (key != null && contains != null) {
                }
                key = iterator.next();
                contains = (Map.Entry)key.getValue();
                contains = collection.contains(contains);
                if (contains != null) {
                }
                key = key.getKey();
                set.add(key);
                collection = b();
                collection = collection.keySet();
                collection = collection.removeAll(set);
                return collection;
            }
        }

        public boolean retainAll(Collection<?> collection) {
            Map iterator;
            boolean key;
            Object contains;
            try {
                n.o(collection);
                return super.retainAll((Collection)collection);
                java.util.HashSet set = y0.d();
                iterator = b();
                iterator = iterator.entrySet();
                iterator = iterator.iterator();
                key = iterator.hasNext();
                key = iterator.next();
                contains = (Map.Entry)key.getValue();
                contains = collection.contains(contains);
                if (key != null && contains != null) {
                }
                key = iterator.next();
                contains = (Map.Entry)key.getValue();
                contains = collection.contains(contains);
                if (contains != null) {
                }
                key = key.getKey();
                set.add(key);
                collection = b();
                collection = collection.keySet();
                collection = collection.retainAll(set);
                return collection;
            }
        }

        @Override // java.util.AbstractCollection
        public int size() {
            return b().size();
        }
    }

    static abstract class f extends AbstractMap<K, V> {

        private transient Set<Map.Entry<K, V>> a;
        private transient Collection<V> b;
        abstract Set<Map.Entry<K, V>> a();

        Collection<V> c() {
            h0.e eVar = new h0.e(this);
            return eVar;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set set;
            if (this.a == null) {
                this.a = a();
            }
            return set;
        }

        public Collection<V> values() {
            Collection collection;
            if (this.b == null) {
                this.b = c();
            }
            return collection;
        }
    }

    class a extends com.google.common.collect.a1<Map.Entry<K, V>, V> {
        a(Iterator iterator) {
            super(iterator);
        }

        @Override // com.google.common.collect.a1
        Object b(Object object) {
            return c((Map.Entry)object);
        }

        V c(Map.Entry<K, V> map$Entry) {
            return entry.getValue();
        }
    }

    private static enum b implements g<Map.Entry<?, ?>, Object> {

        KEY,
        VALUE;
        private static com.google.common.collect.h0.b[] $values() {
            com.google.common.collect.h0.b[] arr = new h0.b[2];
            return arr;
        }

        public abstract T apply(F f);
    }

    static abstract class c extends com.google.common.collect.y0.b<Map.Entry<K, V>> {
        abstract Map<K, V> b();

        @Override // com.google.common.collect.y0$b
        public void clear() {
            b().clear();
        }

        @Override // com.google.common.collect.y0$b
        public abstract boolean contains(Object object);

        @Override // com.google.common.collect.y0$b
        public boolean isEmpty() {
            return b().isEmpty();
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                n.o(collection);
                return super.removeAll((Collection)collection);
                collection = collection.iterator();
                collection = y0.h(this, collection);
                return collection;
            }
        }

        public boolean retainAll(Collection<?> collection) {
            boolean key;
            boolean contains;
            try {
                n.o(collection);
                return super.retainAll((Collection)collection);
                int i = collection.size();
                i = y0.e(i);
                collection = collection.iterator();
                key = collection.hasNext();
                key = collection.next();
                if (key != null && contains(key)) {
                }
                key = collection.next();
                if (contains(key)) {
                }
                key = (Map.Entry)key.getKey();
                i.add(key);
                collection = b();
                collection = collection.keySet();
                collection = collection.retainAll(i);
                return collection;
            }
        }

        @Override // com.google.common.collect.y0$b
        public int size() {
            return b().size();
        }
    }

    static class d extends com.google.common.collect.y0.b<K> {

        final Map<K, V> a;
        d(Map<K, V> map) {
            super();
            n.o(map);
            this.a = (Map)map;
        }

        Map<K, V> b() {
            return this.a;
        }

        @Override // com.google.common.collect.y0$b
        public boolean contains(Object object) {
            return b().containsKey(object);
        }

        @Override // com.google.common.collect.y0$b
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // com.google.common.collect.y0$b
        public int size() {
            return b().size();
        }
    }
    static int a(int i) {
        if (i < 3) {
            i.b(i, "expectedSize");
            return i++;
        }
        if (i < 1073741824) {
            return (int)obj1;
        }
        return Integer.MAX_VALUE;
    }

    static boolean b(Map<?, ?> map, Object object2) {
        if (map == object2) {
            return 1;
        }
        if (object2 instanceof Map != null) {
            return map.entrySet().equals((Map)object2.entrySet());
        }
        return 0;
    }

    public static <K, V> Map.Entry<K, V> c(K k, V v2) {
        u uVar = new u(k, v2);
        return uVar;
    }

    static <K> g<Map.Entry<K, ?>, K> d() {
        return h0.b.KEY;
    }

    public static <K, V> IdentityHashMap<K, V> e() {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        return identityHashMap;
    }

    static boolean f(Map<?, ?> map, Object object2) {
        n.o(map);
        return map.containsKey(object2);
    }

    static <V> V g(Map<?, V> map, Object object2) {
        n.o(map);
        return map.get(object2);
    }

    static <V> V h(Map<?, V> map, Object object2) {
        n.o(map);
        return map.remove(object2);
    }

    static String i(Map<?, ?> map) {
        int str;
        Object value;
        int i;
        StringBuilder sb = j.a(map.size());
        sb.append('{');
        Iterator obj4 = map.entrySet().iterator();
        str = 1;
        while (obj4.hasNext()) {
            Object next2 = obj4.next();
            if (str == null) {
            }
            str = 0;
            sb.append((Map.Entry)next2.getKey());
            sb.append('=');
            sb.append(next2.getValue());
            sb.append(", ");
        }
        sb.append('}');
        return sb.toString();
    }

    static <V> g<Map.Entry<?, V>, V> j() {
        return h0.b.VALUE;
    }

    static <K, V> Iterator<V> k(Iterator<Map.Entry<K, V>> iterator) {
        h0.a aVar = new h0.a(iterator);
        return aVar;
    }
}
