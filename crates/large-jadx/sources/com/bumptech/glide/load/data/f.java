package com.bumptech.glide.load.data;

import com.bumptech.glide.t.k;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DataRewinderRegistry.java */
/* loaded from: classes.dex */
public class f {

    private static final e.a<?> b = new f$a<>();
    private final Map<Class<?>, e.a<?>> a = new HashMap<>();

    class a implements e.a<Object> {
        a() {
            super();
        }

        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        public e<Object> b(Object object) {
            return new f.b(object);
        }
    }

    private static final class b implements e<Object> {

        private final Object a;
        b(Object object) {
            super();
            this.a = object;
        }

        public Object a() {
            return this.a;
        }

        public void b() {
        }
    }

    public f() {
        super();
        final HashMap hashMap = new HashMap();
    }

    public synchronized <T> e<T> a(T t) {
        Object value;
        boolean assignableFrom;
        Class cls2;
        k.d(t);
        if ((e.a)this.a.get(t.getClass()) == null) {
            Iterator it = this.a.values().iterator();
            while (it.hasNext()) {
                value = it.next();
                if (value.a().isAssignableFrom(t.getClass())) {
                    break;
                }
            }
        }
        if (this.a == null) {
            com.bumptech.glide.load.data.e.a aVar = f.b;
        }
        return value.b(t);
    }

    public synchronized void b(e.a<?> aVar) {
        this.a.put(aVar.a(), aVar);
    }
}
