package io.grpc;

import com.google.common.base.k;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class a {

    public static final io.grpc.a b;
    private final Map<io.grpc.a.c<?>, Object> a;

    static class a {
    }

    public static final class b {

        private io.grpc.a a;
        private Map<io.grpc.a.c<?>, Object> b;
        static {
        }

        private b(io.grpc.a a) {
            super();
            this.a = a;
        }

        b(io.grpc.a a, io.grpc.a.a a$a2) {
            super(a);
        }

        private Map<io.grpc.a.c<?>, Object> b(int i) {
            Object identityHashMap;
            if (this.b == null) {
                identityHashMap = new IdentityHashMap(i);
                this.b = identityHashMap;
            }
            return this.b;
        }

        public io.grpc.a a() {
            Object aVar;
            Object value;
            boolean key2;
            Object key;
            if (this.b != null) {
                Iterator iterator = a.a(this.a).entrySet().iterator();
                while (iterator.hasNext()) {
                    value = iterator.next();
                    if (!this.b.containsKey((Map.Entry)value.getKey())) {
                    }
                    this.b.put(value.getKey(), value.getValue());
                }
                key2 = 0;
                aVar = new a(this.b, key2);
                this.a = aVar;
                this.b = key2;
            }
            return this.a;
        }

        public <T> io.grpc.a.b c(io.grpc.a.c<T> a$c) {
            boolean identityHashMap;
            io.grpc.a aVar;
            int i;
            if (a.a(this.a).containsKey(c)) {
                identityHashMap = new IdentityHashMap(a.a(this.a));
                identityHashMap.remove(c);
                aVar = new a(identityHashMap, 0);
                this.a = aVar;
            }
            Map map2 = this.b;
            if (map2 != null) {
                map2.remove(c);
            }
            return this;
        }

        public <T> io.grpc.a.b d(io.grpc.a.c<T> a$c, T t2) {
            b(1).put(c, t2);
            return this;
        }
    }

    public static final class c {

        private final String a;
        private c(String string) {
            super();
            this.a = string;
        }

        public static <T> io.grpc.a.c<T> a(String string) {
            a.c cVar = new a.c(string);
            return cVar;
        }

        public String toString() {
            return this.a;
        }
    }
    static {
        a aVar = new a(Collections.emptyMap());
        a.b = aVar;
    }

    private a(Map<io.grpc.a.c<?>, Object> map) {
        super();
        this.a = map;
    }

    a(Map map, io.grpc.a.a a$a2) {
        super(map);
    }

    static Map a(io.grpc.a a) {
        return a.a;
    }

    public static io.grpc.a.b c() {
        a.b bVar = new a.b(a.b, 0);
        return bVar;
    }

    public <T> T b(io.grpc.a.c<T> a$c) {
        return this.a.get(c);
    }

    public io.grpc.a.b d() {
        a.b bVar = new a.b(this, 0);
        return bVar;
    }

    public boolean equals(Object object) {
        Class<io.grpc.a> obj;
        int size;
        Class class;
        Object value;
        Map map;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (a.class != object.getClass()) {
            } else {
                if (this.a.size() != object.a.size()) {
                    return i2;
                }
                Iterator iterator = this.a.entrySet().iterator();
                for (Map.Entry next2 : iterator) {
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        int i2;
        int i;
        Object[] arr;
        int i3;
        Iterator iterator = this.a.entrySet().iterator();
        final int i4 = 0;
        i2 = i4;
        for (Map.Entry next2 : iterator) {
            arr = new Object[2];
            arr[i4] = next2.getKey();
            arr[1] = next2.getValue();
            i2 += i;
        }
        return i2;
    }

    public String toString() {
        return this.a.toString();
    }
}
