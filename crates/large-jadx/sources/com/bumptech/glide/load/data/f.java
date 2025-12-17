package com.bumptech.glide.load.data;

import com.bumptech.glide.t.k;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class f {

    private static final com.bumptech.glide.load.data.e.a<?> b;
    private final Map<Class<?>, com.bumptech.glide.load.data.e.a<?>> a;

    class a implements com.bumptech.glide.load.data.e.a<Object> {
        public Class<Object> a() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implemented");
            throw unsupportedOperationException;
        }

        public com.bumptech.glide.load.data.e<Object> b(Object object) {
            f.b bVar = new f.b(object);
            return bVar;
        }
    }

    private static final class b implements com.bumptech.glide.load.data.e<Object> {

        private final Object a;
        b(Object object) {
            super();
            this.a = object;
        }

        @Override // com.bumptech.glide.load.data.e
        public Object a() {
            return this.a;
        }

        @Override // com.bumptech.glide.load.data.e
        public void b() {
        }
    }
    static {
        f.a aVar = new f.a();
        f.b = aVar;
    }

    public f() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
    }

    public <T> com.bumptech.glide.load.data.e<T> a(T t) {
        Object obj;
        Object iterator;
        boolean next;
        boolean assignableFrom;
        Class class;
        k.d(t);
        synchronized (this) {
            try {
                iterator = this.a.values().iterator();
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if ((e.a)next.a().isAssignableFrom(t.getClass())) {
                        break;
                    } else {
                    }
                }
                next = iterator.next();
                if ((e.a)next.a().isAssignableFrom(t.getClass())) {
                } else {
                }
                obj = next;
                if (obj == null) {
                }
                obj = f.b;
                return obj.b(t);
                throw t;
            }
        }
    }

    public void b(com.bumptech.glide.load.data.e.a<?> e$a) {
        this.a.put(a.a(), a);
        return;
        synchronized (this) {
            this.a.put(a.a(), a);
        }
    }
}
