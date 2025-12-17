package com.bumptech.glide.load.n.h;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class f {

    private final List<com.bumptech.glide.load.n.h.f.a<?, ?>> a;

    private static final class a {

        final Class<Z> a;
        final Class<R> b;
        final com.bumptech.glide.load.n.h.e<Z, R> c;
        a(Class<Z> class, Class<R> class2, com.bumptech.glide.load.n.h.e<Z, R> e3) {
            super();
            this.a = class;
            this.b = class2;
            this.c = e3;
        }

        public boolean a(Class<?> class, Class<?> class2) {
            boolean obj2;
            if (this.a.isAssignableFrom(class) && class2.isAssignableFrom(this.b)) {
                obj2 = class2.isAssignableFrom(this.b) ? 1 : 0;
            } else {
            }
            return obj2;
        }
    }
    public f() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
    }

    public <Z, R> com.bumptech.glide.load.n.h.e<Z, R> a(Class<Z> class, Class<R> class2) {
        Object next;
        boolean z;
        synchronized (this) {
            try {
                return g.b();
                Iterator iterator = this.a.iterator();
                for (f.a next : iterator) {
                }
                next = iterator.next();
                if ((f.a)next.a(class, class2)) {
                } else {
                }
                return next.c;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No transcoder registered to transcode from ");
                stringBuilder.append(class);
                stringBuilder.append(" to ");
                stringBuilder.append(class2);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
                throw class;
            }
        }
    }

    public <Z, R> List<Class<R>> b(Class<Z> class, Class<R> class2) {
        Object next;
        boolean contains;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                arrayList.add(class2);
                return arrayList;
                Iterator iterator = this.a.iterator();
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if ((f.a)next.a(class, class2) && !arrayList.contains(next.b)) {
                    }
                    if (!arrayList.contains(next.b)) {
                    }
                    arrayList.add(next.b);
                }
                next = iterator.next();
                if ((f.a)next.a(class, class2) && !arrayList.contains(next.b)) {
                }
                if (!arrayList.contains(next.b)) {
                }
                arrayList.add(next.b);
                return arrayList;
                throw class;
            }
        }
    }

    public <Z, R> void c(Class<Z> class, Class<R> class2, com.bumptech.glide.load.n.h.e<Z, R> e3) {
        f.a aVar = new f.a(class, class2, e3);
        this.a.add(aVar);
        return;
        synchronized (this) {
            aVar = new f.a(class, class2, e3);
            this.a.add(aVar);
        }
    }
}
