package com.bumptech.glide.q;

import com.bumptech.glide.load.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: EncoderRegistry.java */
/* loaded from: classes.dex */
public class a {

    private final List<a.a<?>> a = new ArrayList<>();

    private static final class a<T> {

        private final Class<T> a;
        final d<T> b;
        a(Class<T> cls, d<T> dVar) {
            super();
            this.a = cls;
            this.b = dVar;
        }

        boolean a(Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }
    public a() {
        super();
        final ArrayList arrayList = new ArrayList();
    }

    public synchronized <T> void a(Class<T> cls, d<T> dVar) {
        this.a.add(new a.a(cls, dVar));
    }

    public synchronized <T> d<T> b(Class<T> cls) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (item.a(cls)) {
            }
        }
        return null;
    }
}
