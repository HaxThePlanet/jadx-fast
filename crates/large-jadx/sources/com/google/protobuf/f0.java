package com.google.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
public class f0 extends com.google.protobuf.g0 {

    private final com.google.protobuf.t0 e;

    static class a {
    }

    static class b implements Map.Entry<K, Object> {

        private Map.Entry<K, com.google.protobuf.f0> a;
        private b(Map.Entry<K, com.google.protobuf.f0> map$Entry) {
            super();
            this.a = entry;
        }

        b(Map.Entry map$Entry, com.google.protobuf.f0.a f0$a2) {
            super(entry);
        }

        @Override // java.util.Map$Entry
        public com.google.protobuf.f0 a() {
            return (f0)this.a.getValue();
        }

        public K getKey() {
            return this.a.getKey();
        }

        @Override // java.util.Map$Entry
        public Object getValue() {
            Object value = this.a.getValue();
            if ((f0)value == null) {
                return null;
            }
            return (f0)value.f();
        }

        @Override // java.util.Map$Entry
        public Object setValue(Object object) {
            if (!object instanceof t0) {
            } else {
                return (f0)this.a.getValue().d((t0)object);
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
            throw obj2;
        }
    }

    static class c implements Iterator<Map.Entry<K, Object>> {

        private Iterator<Map.Entry<K, Object>> a;
        public c(Iterator<Map.Entry<K, Object>> iterator) {
            super();
            this.a = iterator;
        }

        public Map.Entry<K, Object> b() {
            Object next = this.a.next();
            if (value instanceof f0) {
                f0.b bVar = new f0.b(next, 0);
                return bVar;
            }
            return next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return b();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.a.remove();
        }
    }
    @Override // com.google.protobuf.g0
    public boolean equals(Object object) {
        return f().equals(object);
    }

    @Override // com.google.protobuf.g0
    public com.google.protobuf.t0 f() {
        return c(this.e);
    }

    @Override // com.google.protobuf.g0
    public int hashCode() {
        return f().hashCode();
    }

    @Override // com.google.protobuf.g0
    public String toString() {
        return f().toString();
    }
}
