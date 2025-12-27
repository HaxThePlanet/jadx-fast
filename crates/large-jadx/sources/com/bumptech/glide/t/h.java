package com.bumptech.glide.t;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class h<T, Y> {

    private final Map<T, h.a<Y>> a = new LinkedHashMap<>(100, 1061158912, 1);
    private long b;
    private long c;

    static final class a<Y> {

        final Y a;
        final int b;
        a(Y y, int i) {
            super();
            this.a = y;
            this.b = i;
        }
    }
    public h(long j) {
        super();
        final LinkedHashMap linkedHashMap = new LinkedHashMap(100, 0.75f, true);
        this.b = j;
    }

    private void f() {
        m(this.b);
    }

    public void b() {
        m(0L);
    }

    public synchronized Y g(T t) {
        int i = 0;
        Object value = this.a.get(t);
        i = 0;
        return i;
    }

    public synchronized long h() {
        return this.b;
    }

    public synchronized Y k(T t, Y y) {
        com.bumptech.glide.t.h.a aVar;
        int i = 0;
        long l;
        int i2 = i(y);
        long l2 = (long)i2;
        i = 0;
        j(t, y);
        if (y != null) {
            this.c += l2;
            int r2 = y == null ? i : new h.a(y, i2);
            Object obj = this.a.put(t, (y == null ? i : new h.a(y, i2)));
            if (obj != null && !obj.a.equals(y)) {
                j(t, obj.a);
            }
            f();
            if (obj != null) {
            }
            return i;
        }
    }

    public synchronized Y l(T t) {
        Object remove = this.a.remove(t);
        if (remove == null) {
            return null;
        }
        this.c -= l3;
        return remove.a;
    }

    protected synchronized void m(long j) {
        while (this.c > j) {
            Iterator it = this.a.entrySet().iterator();
            Object item = it.next();
            Object value = item.getValue();
            l2 = (long)value.b;
            this.c -= l2;
            it.remove();
            j(item.getKey(), value.a);
            it = this.a.entrySet().iterator();
            item = it.next();
            value = item.getValue();
            l2 = (long)value.b;
            this.c -= l2;
            it.remove();
            j(item.getKey(), value.a);
        }
    }

    protected int i(Y y) {
        return 1;
    }

    protected void j(T t, Y y) {
    }
}
