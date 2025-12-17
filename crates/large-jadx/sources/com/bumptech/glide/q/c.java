package com.bumptech.glide.q;

import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.n.h.g;
import com.bumptech.glide.t.j;
import d.e.a;
import d.e.g;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class c {

    private static final s<?, ?, ?> c;
    private final a<j, s<?, ?, ?>> a;
    private final AtomicReference<j> b;
    static {
        g gVar = new g();
        super(Object.class, Object.class, Object.class, Collections.emptyList(), gVar, 0);
        i sVar = new i(Object.class, Object.class, Object.class, Collections.singletonList(iVar), 0);
        c.c = sVar2;
    }

    public c() {
        super();
        a aVar = new a();
        this.a = aVar;
        AtomicReference atomicReference = new AtomicReference();
        this.b = atomicReference;
    }

    private j b(Class<?> class, Class<?> class2, Class<?> class3) {
        Object andSet;
        if ((j)this.b.getAndSet(0) == null) {
            andSet = new j();
        }
        andSet.a(class, class2, class3);
        return andSet;
    }

    public <Data, TResource, Transcode> s<Data, TResource, Transcode> a(Class<Data> class, Class<TResource> class2, Class<Transcode> class3) {
        final j obj1 = b(class, class2, class3);
        a obj2 = this.a;
        this.b.set(obj1);
        return (s)this.a.get(obj1);
        synchronized (obj2) {
            obj1 = b(class, class2, class3);
            obj2 = this.a;
            this.b.set(obj1);
            return (s)this.a.get(obj1);
        }
    }

    public boolean c(s<?, ?, ?> s) {
        return c.c.equals(s);
    }

    public void d(Class<?> class, Class<?> class2, Class<?> class3, s<?, ?, ?> s4) {
        s obj7;
        final a aVar = this.a;
        j jVar = new j(class, class2, class3);
        synchronized (aVar) {
            try {
                this.a.put(jVar, obj7);
                throw class;
            }
        }
    }
}
