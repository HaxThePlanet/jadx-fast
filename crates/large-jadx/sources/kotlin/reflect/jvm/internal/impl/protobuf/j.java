package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

/* loaded from: classes3.dex */
public class j extends kotlin.reflect.jvm.internal.impl.protobuf.k {

    private final kotlin.reflect.jvm.internal.impl.protobuf.o e;

    static class a {
    }

    static class b implements Map.Entry<K, Object> {

        private Map.Entry<K, kotlin.reflect.jvm.internal.impl.protobuf.j> a;
        private b(Map.Entry<K, kotlin.reflect.jvm.internal.impl.protobuf.j> map$Entry) {
            super();
            this.a = entry;
        }

        b(Map.Entry map$Entry, kotlin.reflect.jvm.internal.impl.protobuf.j.a j$a2) {
            super(entry);
        }

        public K getKey() {
            return this.a.getKey();
        }

        @Override // java.util.Map$Entry
        public Object getValue() {
            Object value = this.a.getValue();
            if ((j)value == null) {
                return null;
            }
            return (j)value.e();
        }

        @Override // java.util.Map$Entry
        public Object setValue(Object object) {
            if (!object instanceof o) {
            } else {
                return (j)this.a.getValue().d((o)object);
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
            if (value instanceof j) {
                j.b bVar = new j.b(next, 0);
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
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.k
    public kotlin.reflect.jvm.internal.impl.protobuf.o e() {
        return c(this.e);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.k
    public boolean equals(Object object) {
        return e().equals(object);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.k
    public int hashCode() {
        return e().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.k
    public String toString() {
        return e().toString();
    }
}
