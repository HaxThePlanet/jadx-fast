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

/* compiled from: MultiModelLoaderFactory.java */
/* loaded from: classes.dex */
public class r {

    private static final r.c e = new r$c();
    private static final n<Object, Object> f = new r$a<>();
    private final List<r.b<?, ?>> a;
    private final r.c b;
    private final Set<r.b<?, ?>> c;
    private final f<List<Throwable>> d;

    private static class b<Model, Data> {

        private final Class<Model> a;
        final Class<Data> b;
        final o<? extends Model, ? extends Data> c;
        public b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
            super();
            this.a = cls;
            this.b = cls2;
            this.c = oVar;
        }

        public boolean a(Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }

        public boolean b(Class<?> cls, Class<?> cls2) {
            boolean z = false;
            if (a(cls)) {
                cls = this.b.isAssignableFrom(cls2) ? 1 : 0;
            }
            return (this.b.isAssignableFrom(cls2) ? 1 : 0);
        }
    }

    static class c {
        c() {
            super();
        }

        public <Model, Data> q<Model, Data> a(List<n<Model, Data>> list, f<List<Throwable>> fVar) {
            return new q(list, fVar);
        }
    }

    private static class a implements n<Object, Object> {
        a() {
            super();
        }

        public boolean a(Object object) {
            return false;
        }

        public n.a<Object> b(Object object, int i, int i2, h hVar) {
            return null;
        }
    }

    public r(f<List<Throwable>> fVar) {
        this(fVar, r.e);
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar, boolean z) {
        int size = 0;
        if (z) {
            size = this.a.size();
        } else {
            size = 0;
        }
        this.a.add(size, new r.b(cls, cls2, oVar));
    }

    private <Model, Data> n<Model, Data> c(r.b<?, ?> bVar) {
        com.bumptech.glide.load.m.n nVar = bVar.c.b(this);
        k.d(nVar);
        return nVar;
    }

    private static <Model, Data> n<Model, Data> f() {
        return r.f;
    }

    synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    public synchronized <Model, Data> n<Model, Data> d(Class<Model> cls, Class<Data> cls2) {
        int i;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.a.iterator();
        i = 0;
        i = 1;
        while (it.hasNext()) {
            Object item = it.next();
            if (this.c.contains(item)) {
            } else {
                if (item.b(cls, cls2)) {
                    this.c.add(item);
                    arrayList.add(c(item));
                    this.c.remove(item);
                }
            }
        }
        if (i != 0) {
            return r.f();
        } else {
            throw new Registry.NoModelLoaderAvailableException(cls, cls2);
        }
    }

    synchronized <Model> List<n<Model, ?>> e(Class<Model> cls) {
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.a.iterator();
        Object item = it.next();
        this.c.add(item);
        arrayList.add(c(item));
        this.c.remove(item);
        return arrayList;
    }

    synchronized List<Class<?>> g(Class<?> cls) {
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.a.iterator();
        Object item = it.next();
        arrayList.add(item.b);
        return arrayList;
    }

    r(f<List<Throwable>> fVar, r.c cVar) {
        super();
        this.a = new ArrayList();
        this.c = new HashSet();
        this.d = fVar;
        this.b = cVar;
    }
}
