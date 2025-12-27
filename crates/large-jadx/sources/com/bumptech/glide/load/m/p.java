package com.bumptech.glide.load.m;

import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import d.h.k.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ModelLoaderRegistry.java */
/* loaded from: classes.dex */
public class p {

    private final r a;
    private final p.a b;

    private static class a {

        private final Map<Class<?>, p.a.a<?>> a = new HashMap<>();
        a() {
            super();
            final HashMap hashMap = new HashMap();
        }

        public void a() {
            this.a.clear();
        }

        public <Model> List<n<Model, ?>> b(Class<Model> cls) {
            int i = 0;
            Object value = this.a.get(cls);
            cls = value == null ? 0 : value.a;
            return (value == null ? 0 : value.a);
        }

        public <Model> void c(Class<Model> cls, List<n<Model, ?>> list) {
            if ((p.a.a)this.a.put(cls, new p.a.a(list)) != null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Already cached loaders for model: ";
                cls = str + cls;
                throw new IllegalStateException(cls);
            }
        }
    }
    public p(f<List<Throwable>> fVar) {
        this(new r(fVar));
    }

    private static <A> Class<A> b(A a) {
        return a.getClass();
    }

    private synchronized <A> List<n<A, ?>> e(Class<A> cls) {
        List unmodifiable;
        if (this.b.b(cls) == null) {
            this.b.c(cls, Collections.unmodifiableList(this.a.e(cls)));
        }
        return unmodifiable;
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        this.a.b(cls, cls2, oVar);
        this.b.a();
    }

    public synchronized List<Class<?>> c(Class<?> cls) {
        return this.a.g(cls);
    }

    public <A> List<n<A, ?>> d(A a) throws Registry.NoModelLoaderAvailableException {
        List emptyList;
        int i = 1;
        List list = e(p.b(a));
        if (list.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(a);
        } else {
            int size = list.size();
            emptyList = Collections.emptyList();
            i = 0;
            i = 1;
            while (i < size) {
                Object item = list.get(i);
                i = i + 1;
            }
            if (emptyList.isEmpty()) {
                throw new Registry.NoModelLoaderAvailableException(a, list);
            } else {
                return emptyList;
            }
        }
    }

    private p(r rVar) {
        super();
        this.b = new p.a();
        this.a = rVar;
    }
}
