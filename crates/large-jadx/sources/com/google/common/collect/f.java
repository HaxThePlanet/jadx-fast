package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
abstract class f<K, V>  implements com.google.common.collect.i0<K, V> {

    private transient Set<K> a;
    private transient Collection<V> b;
    private transient Map<K, Collection<V>> c;

    class a extends AbstractCollection<V> {

        final com.google.common.collect.f a;
        a(com.google.common.collect.f f) {
            this.a = f;
            super();
        }

        @Override // java.util.AbstractCollection
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection
        public boolean contains(Object object) {
            return this.a.b(object);
        }

        public Iterator<V> iterator() {
            return this.a.g();
        }

        @Override // java.util.AbstractCollection
        public int size() {
            return this.a.size();
        }
    }
    public Map<K, Collection<V>> a() {
        Map map;
        if (this.c == null) {
            this.c = c();
        }
        return map;
    }

    @Override // com.google.common.collect.i0
    public boolean b(Object object) {
        boolean contains;
        Iterator iterator = a().values().iterator();
        for (Collection next2 : iterator) {
        }
        return 0;
    }

    abstract Map<K, Collection<V>> c();

    abstract Set<K> d();

    abstract Collection<V> e();

    @Override // com.google.common.collect.i0
    public boolean equals(Object object) {
        return l0.a(this, object);
    }

    public Set<K> f() {
        Set set;
        if (this.a == null) {
            this.a = d();
        }
        return set;
    }

    abstract Iterator<V> g();

    @Override // com.google.common.collect.i0
    public int hashCode() {
        return a().hashCode();
    }

    @Override // com.google.common.collect.i0
    public String toString() {
        return a().toString();
    }

    public Collection<V> values() {
        Collection collection;
        if (this.b == null) {
            this.b = e();
        }
        return collection;
    }
}
