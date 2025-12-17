package com.bumptech.glide.load.m;

import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import d.h.k.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class p {

    private final com.bumptech.glide.load.m.r a;
    private final com.bumptech.glide.load.m.p.a b;

    private static class a {

        private final Map<Class<?>, com.bumptech.glide.load.m.p.a.a<?>> a;
        a() {
            super();
            HashMap hashMap = new HashMap();
            this.a = hashMap;
        }

        public void a() {
            this.a.clear();
        }

        public <Model> List<com.bumptech.glide.load.m.n<Model, ?>> b(Class<Model> class) {
            int obj2;
            obj2 = this.a.get(class);
            obj2 = (p.a.a)obj2 == null ? 0 : obj2.a;
            return obj2;
        }

        public <Model> void c(Class<Model> class, List<com.bumptech.glide.load.m.n<Model, ?>> list2) {
            p.a.a aVar = new p.a.a(list2);
            if ((p.a.a)this.a.put(class, aVar) != null) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Already cached loaders for model: ");
            stringBuilder.append(class);
            IllegalStateException obj4 = new IllegalStateException(stringBuilder.toString());
            throw obj4;
        }
    }
    private p(com.bumptech.glide.load.m.r r) {
        super();
        p.a aVar = new p.a();
        this.b = aVar;
        this.a = r;
    }

    public p(f<List<Throwable>> f) {
        r rVar = new r(f);
        super(rVar);
    }

    private static <A> Class<A> b(A a) {
        return a.getClass();
    }

    private <A> List<com.bumptech.glide.load.m.n<A, ?>> e(Class<A> class) {
        List unmodifiableList;
        com.bumptech.glide.load.m.p.a aVar;
        synchronized (this) {
            try {
                this.b.c(class, Collections.unmodifiableList(this.a.e(class)));
                return unmodifiableList;
                throw class;
            }
        }
    }

    public <Model, Data> void a(Class<Model> class, Class<Data> class2, com.bumptech.glide.load.m.o<? extends Model, ? extends Data> o3) {
        this.a.b(class, class2, o3);
        this.b.a();
        return;
        synchronized (this) {
            this.a.b(class, class2, o3);
            this.b.a();
        }
    }

    public List<Class<?>> c(Class<?> class) {
        return this.a.g(class);
        synchronized (this) {
            return this.a.g(class);
        }
    }

    public <A> List<com.bumptech.glide.load.m.n<A, ?>> d(A a) {
        List emptyList;
        int i2;
        int i;
        Object obj;
        boolean z;
        List list = e(p.b(a));
        if (list.isEmpty()) {
        } else {
            int size = list.size();
            emptyList = Collections.emptyList();
            final int i3 = 0;
            i2 = 1;
            i = i3;
            while (i < size) {
                obj = list.get(i);
                if ((n)obj.a(a) && i2 != 0) {
                }
                i++;
                if (i2 != 0) {
                }
                emptyList.add(obj);
                emptyList = new ArrayList(size - i);
                i2 = i3;
            }
            if (emptyList.isEmpty()) {
            } else {
                return emptyList;
            }
            Registry.NoModelLoaderAvailableException noModelLoaderAvailableException2 = new Registry.NoModelLoaderAvailableException(a, list);
            throw noModelLoaderAvailableException2;
        }
        Registry.NoModelLoaderAvailableException noModelLoaderAvailableException = new Registry.NoModelLoaderAvailableException(a);
        throw noModelLoaderAvailableException;
    }
}
