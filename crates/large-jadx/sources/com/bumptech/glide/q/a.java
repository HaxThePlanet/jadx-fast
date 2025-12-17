package com.bumptech.glide.q;

import com.bumptech.glide.load.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    private final List<com.bumptech.glide.q.a.a<?>> a;

    private static final class a {

        private final Class<T> a;
        final d<T> b;
        a(Class<T> class, d<T> d2) {
            super();
            this.a = class;
            this.b = d2;
        }

        boolean a(Class<?> class) {
            return this.a.isAssignableFrom(class);
        }
    }
    public a() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
    }

    public <T> void a(Class<T> class, d<T> d2) {
        a.a aVar = new a.a(class, d2);
        this.a.add(aVar);
        return;
        synchronized (this) {
            aVar = new a.a(class, d2);
            this.a.add(aVar);
        }
    }

    public <T> d<T> b(Class<T> class) {
        Object next;
        boolean z;
        Iterator iterator = this.a.iterator();
        synchronized (this) {
            try {
                for (a.a next : iterator) {
                }
                next = iterator.next();
                if ((a.a)next.a(class)) {
                } else {
                }
                return next.b;
                return 0;
                throw class;
            }
        }
    }
}
