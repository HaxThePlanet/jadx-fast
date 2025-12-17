package com.bumptech.glide.load.engine.z;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class h<K extends com.bumptech.glide.load.engine.z.m, V>  {

    private final com.bumptech.glide.load.engine.z.h.a<K, V> a;
    private final Map<K, com.bumptech.glide.load.engine.z.h.a<K, V>> b;

    private static class a {

        final K a;
        private List<V> b;
        com.bumptech.glide.load.engine.z.h.a<K, V> c;
        com.bumptech.glide.load.engine.z.h.a<K, V> d;
        a() {
            super(0);
        }

        a(K k) {
            super();
            this.d = this;
            this.c = this;
            this.a = k;
        }

        public void a(V v) {
            Object arrayList;
            if (this.b == null) {
                arrayList = new ArrayList();
                this.b = arrayList;
            }
            this.b.add(v);
        }

        public V b() {
            Object remove;
            List list;
            int i = c();
            if (i > 0) {
                remove = this.b.remove(i--);
            } else {
                remove = 0;
            }
            return remove;
        }

        public int c() {
            int size;
            List list = this.b;
            if (list != null) {
                size = list.size();
            } else {
                size = 0;
            }
            return size;
        }
    }
    h() {
        super();
        h.a aVar = new h.a();
        this.a = aVar;
        HashMap hashMap = new HashMap();
        this.b = hashMap;
    }

    private void b(com.bumptech.glide.load.engine.z.h.a<K, V> h$a) {
        h.e(a);
        com.bumptech.glide.load.engine.z.h.a aVar = this.a;
        a.d = aVar;
        a.c = aVar.c;
        h.g(a);
    }

    private void c(com.bumptech.glide.load.engine.z.h.a<K, V> h$a) {
        h.e(a);
        final com.bumptech.glide.load.engine.z.h.a aVar = this.a;
        a.d = aVar.d;
        a.c = aVar;
        h.g(a);
    }

    private static <K, V> void e(com.bumptech.glide.load.engine.z.h.a<K, V> h$a) {
        final com.bumptech.glide.load.engine.z.h.a aVar = a.d;
        aVar.c = a.c;
        obj2.d = aVar;
    }

    private static <K, V> void g(com.bumptech.glide.load.engine.z.h.a<K, V> h$a) {
        aVar.d = a;
        aVar2.c = a;
    }

    public V a(K k) {
        Object aVar;
        Map map;
        if ((h.a)this.b.get(k) == null) {
            aVar = new h.a(k);
            this.b.put(k, aVar);
        } else {
            k.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(K k, V v2) {
        Object aVar;
        Map map;
        if ((h.a)this.b.get(k) == null) {
            aVar = new h.a(k);
            c(aVar);
            this.b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v2);
    }

    public V f() {
        com.bumptech.glide.load.engine.z.h.a aVar;
        Object obj;
        Object obj2;
        aVar = aVar2.d;
        while (!aVar.equals(this.a)) {
            Object obj3 = aVar.b();
            h.e(aVar);
            this.b.remove(aVar.a);
            (m)aVar.a.a();
            aVar = aVar.d;
        }
        return 0;
    }

    public String toString() {
        com.bumptech.glide.load.engine.z.h.a aVar;
        int length;
        String str;
        StringBuilder stringBuilder = new StringBuilder("GroupedLinkedMap( ");
        aVar = aVar2.c;
        length = 0;
        while (!aVar.equals(this.a)) {
            length = 1;
            stringBuilder.append('{');
            stringBuilder.append(aVar.a);
            stringBuilder.append(':');
            stringBuilder.append(aVar.c());
            stringBuilder.append("}, ");
            aVar = aVar.c;
        }
        if (length != 0) {
            stringBuilder.delete(length2 += -2, stringBuilder.length());
        }
        stringBuilder.append(" )");
        return stringBuilder.toString();
    }
}
