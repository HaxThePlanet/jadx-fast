package com.bumptech.glide.load.m;

import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import com.bumptech.glide.load.h;
import com.bumptech.glide.t.k;
import d.h.k.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class r {

    private static final com.bumptech.glide.load.m.r.c e;
    private static final com.bumptech.glide.load.m.n<Object, Object> f;
    private final List<com.bumptech.glide.load.m.r.b<?, ?>> a;
    private final com.bumptech.glide.load.m.r.c b;
    private final Set<com.bumptech.glide.load.m.r.b<?, ?>> c;
    private final f<List<Throwable>> d;

    private static class b {

        private final Class<Model> a;
        final Class<Data> b;
        final com.bumptech.glide.load.m.o<? extends Model, ? extends Data> c;
        public b(Class<Model> class, Class<Data> class2, com.bumptech.glide.load.m.o<? extends Model, ? extends Data> o3) {
            super();
            this.a = class;
            this.b = class2;
            this.c = o3;
        }

        public boolean a(Class<?> class) {
            return this.a.isAssignableFrom(class);
        }

        public boolean b(Class<?> class, Class<?> class2) {
            boolean obj1;
            if (a(class) && this.b.isAssignableFrom(class2)) {
                obj1 = this.b.isAssignableFrom(class2) ? 1 : 0;
            } else {
            }
            return obj1;
        }
    }

    static class c {
        public <Model, Data> com.bumptech.glide.load.m.q<Model, Data> a(List<com.bumptech.glide.load.m.n<Model, Data>> list, f<List<Throwable>> f2) {
            q qVar = new q(list, f2);
            return qVar;
        }
    }

    private static class a implements com.bumptech.glide.load.m.n<Object, Object> {
        @Override // com.bumptech.glide.load.m.n
        public boolean a(Object object) {
            return 0;
        }

        public com.bumptech.glide.load.m.n.a<Object> b(Object object, int i2, int i3, h h4) {
            return 0;
        }
    }
    static {
        r.c cVar = new r.c();
        r.e = cVar;
        r.a aVar = new r.a();
        r.f = aVar;
    }

    public r(f<List<Throwable>> f) {
        super(f, r.e);
    }

    r(f<List<Throwable>> f, com.bumptech.glide.load.m.r.c r$c2) {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        HashSet hashSet = new HashSet();
        this.c = hashSet;
        this.d = f;
        this.b = c2;
    }

    private <Model, Data> void a(Class<Model> class, Class<Data> class2, com.bumptech.glide.load.m.o<? extends Model, ? extends Data> o3, boolean z4) {
        int obj3;
        r.b bVar = new r.b(class, class2, o3);
        final List obj2 = this.a;
        if (z4) {
            obj3 = obj2.size();
        } else {
            obj3 = 0;
        }
        obj2.add(obj3, bVar);
    }

    private <Model, Data> com.bumptech.glide.load.m.n<Model, Data> c(com.bumptech.glide.load.m.r.b<?, ?> r$b) {
        com.bumptech.glide.load.m.n obj1 = b.c.b(this);
        k.d(obj1);
        return (n)obj1;
    }

    private static <Model, Data> com.bumptech.glide.load.m.n<Model, Data> f() {
        return r.f;
    }

    <Model, Data> void b(Class<Model> class, Class<Data> class2, com.bumptech.glide.load.m.o<? extends Model, ? extends Data> o3) {
        a(class, class2, o3, true);
        return;
        synchronized (this) {
            a(class, class2, o3, true);
        }
    }

    public <Model, Data> com.bumptech.glide.load.m.n<Model, Data> d(Class<Model> class, Class<Data> class2) {
        int i;
        Object next;
        boolean contains;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.a.iterator();
        final int i2 = 0;
        final int i3 = 1;
        i = i2;
        synchronized (this) {
            try {
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if (this.c.contains((r.b)next)) {
                    } else {
                    }
                    if (next.b(class, class2)) {
                    }
                    this.c.add(next);
                    arrayList.add(c(next));
                    this.c.remove(next);
                    i = i3;
                }
                next = iterator.next();
                if (this.c.contains((r.b)next)) {
                } else {
                }
                i = i3;
                if (next.b(class, class2)) {
                }
                this.c.add(next);
                arrayList.add(c(next));
                this.c.remove(next);
                if (arrayList.size() > i3) {
                }
                return this.b.a(arrayList, this.d);
                if (arrayList.size() == i3) {
                }
                return (n)arrayList.get(i2);
                if (i == 0) {
                } else {
                }
                return r.f();
                Registry.NoModelLoaderAvailableException noModelLoaderAvailableException = new Registry.NoModelLoaderAvailableException(class, class2);
                throw noModelLoaderAvailableException;
                class2 = this.c;
                class2.clear();
                throw class;
                throw class;
            } catch (Throwable th) {
            }
        }
    }

    <Model> List<com.bumptech.glide.load.m.n<Model, ?>> e(Class<Model> class) {
        Object next;
        boolean contains;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.a.iterator();
        synchronized (this) {
            try {
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if (this.c.contains((r.b)next)) {
                    } else {
                    }
                    if (next.a(class)) {
                    }
                    this.c.add(next);
                    arrayList.add(c(next));
                    this.c.remove(next);
                }
                next = iterator.next();
                if (this.c.contains((r.b)next)) {
                } else {
                }
                if (next.a(class)) {
                }
                this.c.add(next);
                arrayList.add(c(next));
                this.c.remove(next);
                return arrayList;
                this.c.clear();
                throw class;
                throw class;
            } catch (Throwable th) {
            }
        }
    }

    List<Class<?>> g(Class<?> class) {
        Object next;
        boolean contains;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.a.iterator();
        synchronized (this) {
            try {
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if (!arrayList.contains(next.b) && (r.b)next.a(class)) {
                    }
                    if (next.a(class)) {
                    }
                    arrayList.add(next.b);
                }
                next = iterator.next();
                if (!arrayList.contains(next.b) && (r.b)next.a(class)) {
                }
                if (next.a(class)) {
                }
                arrayList.add(next.b);
                return arrayList;
                throw class;
            }
        }
    }
}
