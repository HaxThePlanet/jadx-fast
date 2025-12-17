package com.bumptech.glide.t;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes.dex */
public class h<T, Y>  {

    private final Map<T, com.bumptech.glide.t.h.a<Y>> a;
    private long b;
    private long c;

    static final class a {

        final Y a;
        final int b;
        a(Y y, int i2) {
            super();
            this.a = y;
            this.b = i2;
        }
    }
    public h(long l) {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap(100, 1061158912, 1);
        this.a = linkedHashMap;
        this.b = l;
    }

    private void f() {
        m(this.b);
    }

    public void b() {
        m(0);
    }

    public Y g(T t) {
        Object obj2;
        obj2 = this.a.get(t);
        synchronized (this) {
            try {
                obj2 = obj2.a;
                obj2 = 0;
                return obj2;
                throw t;
            }
        }
    }

    public long h() {
        return this.b;
        synchronized (this) {
            return this.b;
        }
    }

    protected int i(Y y) {
        return 1;
    }

    protected void j(T t, Y y2) {
    }

    public Y k(T t, Y y2) {
        Object map;
        com.bumptech.glide.t.h.a aVar;
        int cmp;
        int i;
        int i2;
        Object obj9;
        int i3 = i(y2);
        long l = (long)i3;
        i = 0;
        synchronized (this) {
            try {
                j(t, y2);
                return i;
                if (y2 != null) {
                }
                this.c = l4 += l;
                if (y2 == null) {
                } else {
                }
                aVar = i;
                aVar = new h.a(y2, i3);
                Object obj = this.a.put(t, aVar);
                this.c = l2 -= i2;
                if ((h.a)obj != null && !obj.a.equals(y2)) {
                }
                this.c = l2 -= i2;
                if (!obj.a.equals(y2)) {
                }
                j(t, obj.a);
                f();
                if ((h.a)obj != null) {
                }
                i = obj.a;
                return i;
                throw t;
            }
        }
    }

    public Y l(T t) {
        Object obj5 = this.a.remove(t);
        synchronized (this) {
            try {
                return 0;
                this.c = l -= l2;
                return obj5.a;
                throw t;
            }
        }
    }

    protected void m(long l) {
        Object obj;
        Object key;
        Object value;
        int i;
        long l2;
        synchronized (this) {
            try {
                while (Long.compare(l3, l) > 0) {
                    Iterator iterator = this.a.entrySet().iterator();
                    Object next = iterator.next();
                    value = (Map.Entry)next.getValue();
                    this.c = l4 -= l2;
                    iterator.remove();
                    j(next.getKey(), value.a);
                }
                iterator = this.a.entrySet().iterator();
                next = iterator.next();
                value = (Map.Entry)next.getValue();
                this.c = l4 -= l2;
                iterator.remove();
                j(next.getKey(), value.a);
                throw l;
            }
        }
    }
}
