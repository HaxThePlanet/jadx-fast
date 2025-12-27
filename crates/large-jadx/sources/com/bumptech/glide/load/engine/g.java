package com.bumptech.glide.load.engine;

import com.bumptech.glide.Registry;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.f;
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

/* compiled from: DecodeHelper.java */
/* loaded from: classes.dex */
final class g<Transcode> {

    private final List<n.a<?>> a = new ArrayList<>();
    private final List<f> b = new ArrayList<>();
    private com.bumptech.glide.e c;
    private Object d;
    private int e;
    private int f;
    private Class<?> g;
    private h.e h;
    private com.bumptech.glide.load.h i;
    private Map<Class<?>, l<?>> j;
    private Class<Transcode> k;
    private boolean l;
    private boolean m;
    private f n;
    private com.bumptech.glide.h o;
    private j p;
    private boolean q;
    private boolean r;
    g() {
        super();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
    }

    void a() {
        com.bumptech.glide.e eVar = null;
        this.c = eVar;
        this.d = eVar;
        this.n = eVar;
        this.g = eVar;
        this.k = eVar;
        this.i = eVar;
        this.o = eVar;
        this.j = eVar;
        this.p = eVar;
        this.a.clear();
        boolean z = false;
        this.l = z;
        this.b.clear();
        this.m = z;
    }

    b b() {
        return this.c.b();
    }

    List<f> c() {
        int i;
        Object item;
        int size2;
        f fVar;
        Object item2;
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List list3 = g();
            i = 0;
            while (i < list3.size()) {
                item = list3.get(i);
                while (this.b < item.b.size()) {
                    i = i + 1;
                }
                i = i + 1;
                i = i + 1;
            }
        }
        return this.b;
    }

    a d() {
        return this.h.a();
    }

    j e() {
        return this.p;
    }

    int f() {
        return this.f;
    }

    List<n.a<?>> g() {
        int i = 0;
        n.a aVar;
        Object obj;
        int i2;
        int i3;
        com.bumptech.glide.load.h hVar;
        if (!this.l) {
            this.l = true;
            this.a.clear();
            List list2 = this.c.i().i(this.d);
            i = 0;
            while (this.d < list2.size()) {
                aVar = (n)list2.get(i).b(this.d, this.e, this.f, this.i);
                i = i + 1;
            }
        }
        return this.a;
    }

    <Data> s<Data, ?, Transcode> h(Class<Data> cls) {
        return this.c.i().h(cls, this.g, this.k);
    }

    Class<?> i() {
        return this.d.getClass();
    }

    List<n<File, ?>> j(File file) {
        return this.c.i().i(file);
    }

    com.bumptech.glide.load.h k() {
        return this.i;
    }

    com.bumptech.glide.h l() {
        return this.o;
    }

    List<Class<?>> m() {
        return this.c.i().j(this.d.getClass(), this.g, this.k);
    }

    <Z> k<Z> n(u<Z> uVar) {
        return this.c.i().k(uVar);
    }

    <T> com.bumptech.glide.load.data.e<T> o(T t) {
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

    <Z> l<Z> s(Class<Z> cls) {
        Object value;
        boolean assignableFrom;
        if ((l)this.j.get(cls) == null) {
            Iterator it = this.j.entrySet().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                if ((Class)item.getKey().isAssignableFrom(cls)) {
                    break;
                }
            }
        }
        if (this.j == null) {
            return c.c();
        }
        return value;
    }

    int t() {
        return this.e;
    }

    boolean u(Class<?> cls) {
        boolean z = true;
        cls = h(cls) != null ? 1 : 0;
        return (h(cls) != null ? 1 : 0);
    }

    <R> void v(com.bumptech.glide.e eVar, Object object, f fVar, int i, int i2, j jVar, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, com.bumptech.glide.load.h hVar2, Map<Class<?>, l<?>> map, boolean z, boolean z2, h.e eVar2) {
        this.c = eVar;
        this.d = object;
        this.n = fVar;
        this.e = i;
        this.f = i2;
        this.p = jVar;
        this.g = cls;
        this.h = eVar2;
        this.k = cls2;
        this.o = hVar;
        this.i = hVar2;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    boolean w(u<?> uVar) {
        return this.c.i().n(uVar);
    }

    boolean x() {
        return this.r;
    }

    boolean y(f fVar) {
        int i;
        final List list = g();
        i = 0;
        while (i < list.size()) {
            if ((n.a)list.get(i).a.equals(fVar)) {
                return true;
            }
        }
        return false;
    }
}
