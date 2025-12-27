package com.bumptech.glide.q;

import com.bumptech.glide.t.j;
import d.e.a;
import d.e.g;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ModelToResourceClassCache.java */
/* loaded from: classes.dex */
public class d {

    private final AtomicReference<j> a = new AtomicReference<>();
    private final a<j, List<Class<?>>> b = new a<>();
    public d() {
        super();
        AtomicReference atomicReference = new AtomicReference();
        a aVar = new a();
    }

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        j jVar;
        Object andSet = this.a.getAndSet(null);
        if (andSet == null) {
            jVar = new j(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (aVar) {
            try {
            } catch (Throwable th) {
            }
        }
        this.a.set(jVar);
        return (List)this.b.get(jVar);
    }

    public void b(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (aVar) {
            try {
                this.b.put(new j(cls, cls2, cls3), list);
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }
}
