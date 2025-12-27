package com.bumptech.glide.load.engine.z;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap.java */
/* loaded from: classes.dex */
class h<K extends m, V> {

    private final h.a<K, V> a = new h$a<>();
    private final Map<K, h.a<K, V>> b = new HashMap<>();

    private static class a<K, V> {

        final K a;
        private List<V> b;
        h.a<K, V> c;
        h.a<K, V> d;
        a() {
            this(null);
        }

        public void a(V v) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.add(v);
        }

        public V b() {
            Object remove = null;
            int i = c();
            if (i > 0) {
                remove = this.b.remove(i - 1);
            } else {
                int i3 = 0;
            }
            return remove;
        }

        public int c() {
            int size = 0;
            if (this.b != null) {
                size = this.b.size();
            } else {
                size = 0;
            }
            return size;
        }

        a(K k) {
            super();
            this.d = this;
            this.c = this;
            this.a = k;
        }
    }
    h() {
        super();
        com.bumptech.glide.load.engine.z.h.a aVar = new h.a();
        HashMap hashMap = new HashMap();
    }

    private void b(h.a<K, V> aVar) {
        h.e(aVar);
        aVar.d = this.a;
        aVar.c = aVar2.c;
        h.g(aVar);
    }

    private void c(h.a<K, V> aVar) {
        h.e(aVar);
        aVar.d = aVar2.d;
        aVar.c = this.a;
        h.g(aVar);
    }

    private static <K, V> void e(h.a<K, V> aVar) {
        aVar.d.c = aVar.c;
        aVar.c.d = aVar.d;
    }

    private static <K, V> void g(h.a<K, V> aVar) {
        aVar.c.d = aVar;
        aVar.d.c = aVar;
    }

    public V a(K k) {
        com.bumptech.glide.load.engine.z.h.a aVar;
        if ((h.a)this.b.get(k) == null) {
            this.b.put(k, new h.a(k));
        } else {
            k.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(K k, V v) {
        com.bumptech.glide.load.engine.z.h.a aVar;
        if ((h.a)this.b.get(k) == null) {
            aVar = new h.a(k);
            c(aVar);
            this.b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public V f() {
        com.bumptech.glide.load.engine.z.h.a aVar;
        while (!aVar.equals(this.a)) {
            Object obj3 = aVar.b();
            if (obj3 != null) {
                return obj3;
            }
        }
        return null;
    }

    public String toString() {
        com.bumptech.glide.load.engine.z.h.a aVar;
        int length = 0;
        StringBuilder stringBuilder = new StringBuilder("GroupedLinkedMap( ");
        length = 0;
        while (!aVar.equals(this.a)) {
            length = 1;
            stringBuilder.append('{');
            stringBuilder.append(aVar.a);
            stringBuilder.append(':');
            stringBuilder.append(aVar.c());
            str = "}, ";
            stringBuilder.append(str);
        }
        if (length != 0) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        stringBuilder.append(" )");
        return stringBuilder.toString();
    }
}
