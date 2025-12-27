package io.grpc;

import com.google.common.base.k;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: Attributes.java */
/* loaded from: classes2.dex */
public final class a {

    public static final a b = new a();
    private final Map<a.c<?>, Object> a;

    static class a {
    }

    public static final class b {

        private a a;
        private Map<a.c<?>, Object> b;
        /* synthetic */ b(a.a aVar) {
            this(aVar);
        }

        private Map<a.c<?>, Object> b(int i) {
            if (this.b == null) {
                this.b = new IdentityHashMap(i);
            }
            return this.b;
        }

        public a a() {
            Object key2;
            if (this.b != null) {
                Iterator it = this.a.a.entrySet().iterator();
                while (it.hasNext()) {
                    Object value = it.next();
                }
                io.grpc.a.a aVar = null;
                this.a = new a(this.b, aVar);
                this.b = aVar;
            }
            return this.a;
        }

        public <T> a.b c(a.c<T> cVar) {
            if (this.a.a.containsKey(cVar)) {
                IdentityHashMap identityHashMap = new IdentityHashMap(this.a.a);
                identityHashMap.remove(cVar);
                io.grpc.a.a aVar2 = null;
                this.a = new a(identityHashMap, aVar2);
            }
            if (this.b != null) {
                this.b.remove(cVar);
            }
            return this;
        }

        public <T> a.b d(a.c<T> cVar, T t) {
            b(1).put(cVar, t);
            return this;
        }

        private b() {
            super();
            this.a = aVar;
        }

    }

    public static final class c<T> {

        private final String a;
        private c(String str) {
            super();
            this.a = str;
        }

        public static <T> a.c<T> a(String str) {
            return new a.c(str);
        }

        public String toString() {
            return this.a;
        }
    }
    static {
    }

    /* synthetic */ a(Map map, a.a aVar) {
        this(map);
    }

    static /* synthetic */ Map a(a aVar) {
        return aVar.a;
    }

    public static a.b c() {
        return new a.b(a.b, null);
    }

    public <T> T b(a.c<T> cVar) {
        return this.a.get(cVar);
    }

    public a.b d() {
        return new a.b(this, null);
    }

    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = a.class;
            if (obj == object.getClass()) {
                if (this.a.size() != object.a.size()) {
                    return false;
                }
                Iterator it = this.a.entrySet().iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    if (!k.a(item.getValue(), object.a.get(item.getKey()))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        Iterator it = this.a.entrySet().iterator();
        i = 0;
        while (it.hasNext()) {
            Object item = it.next();
            Object[] arr = new Object[2];
            arr[i] = item.getKey();
            int i3 = 1;
            arr[i3] = item.getValue();
            i = i + k.b(arr);
        }
        return i;
    }

    public String toString() {
        return this.a.toString();
    }

    private a(Map<a.c<?>, Object> map) {
        super();
        this.a = map;
    }
}
