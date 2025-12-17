package com.bumptech.glide.q;

import com.bumptech.glide.t.j;
import d.e.a;
import d.e.g;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class d {

    private final AtomicReference<j> a;
    private final a<j, List<Class<?>>> b;
    public d() {
        super();
        AtomicReference atomicReference = new AtomicReference();
        this.a = atomicReference;
        a aVar = new a();
        this.b = aVar;
    }

    public List<Class<?>> a(Class<?> class, Class<?> class2, Class<?> class3) {
        Object andSet;
        andSet = this.a.getAndSet(0);
        if ((j)andSet == null) {
            andSet = new j(class, class2, class3);
        } else {
            (j)andSet.a(class, class2, class3);
        }
        a obj3 = this.b;
        this.a.set(andSet);
        return (List)this.b.get(andSet);
        synchronized (obj3) {
            obj3 = this.b;
            this.a.set(andSet);
            return (List)this.b.get(andSet);
        }
    }

    public void b(Class<?> class, Class<?> class2, Class<?> class3, List<Class<?>> list4) {
        final a aVar = this.b;
        j jVar = new j(class, class2, class3);
        this.b.put(jVar, list4);
        return;
        synchronized (aVar) {
            aVar = this.b;
            jVar = new j(class, class2, class3);
            this.b.put(jVar, list4);
        }
    }
}
