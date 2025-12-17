package com.bumptech.glide.load.engine;

import com.bumptech.glide.Registry;
import com.bumptech.glide.e;
import com.bumptech.glide.h;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.m.n;
import com.bumptech.glide.load.m.n.a;
import com.bumptech.glide.load.n.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes.dex */
final class g<Transcode>  {

    private final List<n.a<?>> a;
    private final List<f> b;
    private e c;
    private Object d;
    private int e;
    private int f;
    private Class<?> g;
    private com.bumptech.glide.load.engine.h.e h;
    private h i;
    private Map<Class<?>, l<?>> j;
    private Class<Transcode> k;
    private boolean l;
    private boolean m;
    private f n;
    private h o;
    private com.bumptech.glide.load.engine.j p;
    private boolean q;
    private boolean r;
    g() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.b = arrayList2;
    }

    void a() {
        int i = 0;
        this.c = i;
        this.d = i;
        this.n = i;
        this.g = i;
        this.k = i;
        this.i = i;
        this.o = i;
        this.j = i;
        this.p = i;
        this.a.clear();
        int i2 = 0;
        this.l = i2;
        this.b.clear();
        this.m = i2;
    }

    b b() {
        return this.c.b();
    }

    List<f> c() {
        boolean z;
        int size;
        int i;
        int i3;
        Object obj;
        int i2;
        boolean contains;
        int size2;
        f contains2;
        Object obj2;
        if (!this.m) {
            this.m = true;
            this.b.clear();
            z = g();
            i = 0;
            i3 = i;
            while (i3 < z.size()) {
                obj = z.get(i3);
                if (!this.b.contains(obj.a)) {
                }
                i2 = i;
                while (i2 < obj.b.size()) {
                    if (!this.b.contains(obj.b.get(i2))) {
                    }
                    i2++;
                    this.b.add(obj.b.get(i2));
                }
                i3++;
                if (!this.b.contains(obj.b.get(i2))) {
                }
                i2++;
                this.b.add(obj.b.get(i2));
                this.b.add(obj.a);
            }
        }
        return this.b;
    }

    a d() {
        return this.h.a();
    }

    com.bumptech.glide.load.engine.j e() {
        return this.p;
    }

    int f() {
        return this.f;
    }

    List<n.a<?>> g() {
        boolean z;
        int i;
        int size;
        n.a aVar;
        Object obj;
        int i3;
        int i2;
        h hVar;
        if (!this.l) {
            this.l = true;
            this.a.clear();
            z = this.c.i().i(this.d);
            i = 0;
            while (i < z.size()) {
                aVar = (n)z.get(i).b(this.d, this.e, this.f, this.i);
                if (aVar != null) {
                }
                i++;
                this.a.add(aVar);
            }
        }
        return this.a;
    }

    <Data> com.bumptech.glide.load.engine.s<Data, ?, Transcode> h(Class<Data> class) {
        return this.c.i().h(class, this.g, this.k);
    }

    Class<?> i() {
        return this.d.getClass();
    }

    List<n<File, ?>> j(File file) {
        return this.c.i().i(file);
    }

    h k() {
        return this.i;
    }

    h l() {
        return this.o;
    }

    List<Class<?>> m() {
        return this.c.i().j(this.d.getClass(), this.g, this.k);
    }

    <Z> k<Z> n(com.bumptech.glide.load.engine.u<Z> u) {
        return this.c.i().k(u);
    }

    <T> e<T> o(T t) {
        return this.c.i().l(t);
    }

    f p() {
        return this.n;
    }

    <X> d<X> q(X x) {
        return this.c.i().m(x);
    }

    Class<?> r() {
        return this.k;
    }

    <Z> l<Z> s(Class<Z> class) {
        Object value;
        boolean empty;
        Iterator iterator;
        boolean next;
        boolean assignableFrom;
        if ((l)this.j.get(class) == null) {
            iterator = this.j.entrySet().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((Class)(Map.Entry)next.getKey().isAssignableFrom(class)) {
                    break;
                } else {
                }
            }
        }
        if (value == null && this.j.isEmpty()) {
            if (this.j.isEmpty()) {
                if (this.q) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Missing transformation for ");
                stringBuilder.append(class);
                stringBuilder.append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            }
            return c.c();
        }
        return value;
    }

    int t() {
        return this.e;
    }

    boolean u(Class<?> class) {
        int obj1;
        obj1 = h(class) != null ? 1 : 0;
        return obj1;
    }

    <R> void v(e e, Object object2, f f3, int i4, int i5, com.bumptech.glide.load.engine.j j6, Class<?> class7, Class<R> class8, h h9, h h10, Map<Class<?>, l<?>> map11, boolean z12, boolean z13, com.bumptech.glide.load.engine.h.e h$e14) {
        this.c = e;
        this.d = object2;
        this.n = f3;
        this.e = i4;
        this.f = i5;
        this.p = j6;
        this.g = class7;
        this.h = e14;
        this.k = class8;
        this.o = h9;
        this.i = h10;
        this.j = map11;
        this.q = z12;
        this.r = z13;
    }

    boolean w(com.bumptech.glide.load.engine.u<?> u) {
        return this.c.i().n(u);
    }

    boolean x() {
        return this.r;
    }

    boolean y(f f) {
        int i;
        boolean equals;
        final List list = g();
        final int i2 = 0;
        i = i2;
        while (i < list.size()) {
            i++;
        }
        return i2;
    }
}
