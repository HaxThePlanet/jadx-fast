package com.bumptech.glide.q;

import com.bumptech.glide.load.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ResourceDecoderRegistry.java */
/* loaded from: classes.dex */
public class e {

    private final List<String> a = new ArrayList<>();
    private final Map<String, List<e.a<?, ?>>> b = new HashMap<>();

    private static class a<T, R> {

        private final Class<T> a;
        final Class<R> b;
        final j<T, R> c;
        public a(Class<T> cls, Class<R> cls2, j<T, R> jVar) {
            super();
            this.a = cls;
            this.b = cls2;
            this.c = jVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            boolean z = false;
            if (this.a.isAssignableFrom(cls)) {
                cls = cls2.isAssignableFrom(this.b) ? 1 : 0;
            }
            return (cls2.isAssignableFrom(this.b) ? 1 : 0);
        }
    }
    public e() {
        super();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
    }

    private synchronized List<e.a<?, ?>> c(String str) {
        Object value;
        if (!this.a.contains(str)) {
            this.a.add(str);
        }
        if ((List)this.b.get(str) == null) {
            this.b.put(str, new ArrayList());
        }
        return value;
    }

    public synchronized <T, R> void a(String str, j<T, R> jVar, Class<T> cls, Class<R> cls2) {
        c(str).add(new e.a(cls, cls2, jVar));
    }

    public synchronized <T, R> List<j<T, R>> b(Class<T> cls, Class<R> cls2) {
        boolean z;
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.a.iterator();
        Iterator value = this.b.get((String)it.next());
        value = value.iterator();
        Map item = value.next();
        arrayList.add(item.c);
        return arrayList;
    }

    public synchronized <T, R> List<Class<R>> d(Class<T> cls, Class<R> cls2) {
        boolean contains;
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.a.iterator();
        Iterator value = this.b.get((String)it.next());
        value = value.iterator();
        Map item = value.next();
        arrayList.add(item.b);
        return arrayList;
    }

    public synchronized void e(List<String> list) {
        this.a.clear();
        Iterator item = list.iterator();
        while (item.hasNext()) {
            this.a.add((String)item.next());
        }
        Iterator it = new ArrayList(this.a).iterator();
        item = it.next();
        this.a.add(item);
    }
}
