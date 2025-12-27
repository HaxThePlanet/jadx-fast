package com.bumptech.glide.q;

import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.t.j;
import d.e.a;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LoadPathCache.java */
/* loaded from: classes.dex */
public class c {

    private static final s<?, ?, ?> c;
    private final a<j, s<?, ?, ?>> a = new a<>();
    private final AtomicReference<j> b = new AtomicReference<>();
    static {
        i iVar = new i(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null);
        i sVar = new i(Object.class, Object.class, Object.class, Collections.singletonList(iVar), null);
        c.c = sVar;
    }

    public c() {
        super();
        a aVar = new a();
        AtomicReference atomicReference = new AtomicReference();
    }

    private j b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        Object andSet;
        if ((j)this.b.getAndSet(null) == null) {
            j jVar = new j();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public <Data, TResource, Transcode> s<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        final j jVar = b(cls, cls2, cls3);
        synchronized (aVar) {
            try {
            } catch (Throwable th) {
            }
        }
        this.b.set(jVar);
        return (s)this.a.get(jVar);
    }

    public boolean c(s<?, ?, ?> sVar) {
        return c.c.equals(sVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, s<?, ?, ?> sVar) {
        synchronized (aVar) {
            try {
                if (sVar == null) {
                    sVar = c.c;
                }
                this.a.put(new j(cls, cls2, cls3), sVar);
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }
}
