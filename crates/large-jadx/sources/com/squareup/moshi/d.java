package com.squareup.moshi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes2.dex */
abstract class d<C extends Collection<T>, T>  extends com.squareup.moshi.f<C> {

    public static final com.squareup.moshi.f.d b;
    private final com.squareup.moshi.f<T> a;

    class a implements com.squareup.moshi.f.d {
        public com.squareup.moshi.f<?> a(Type type, Set<? extends Annotation> set2, com.squareup.moshi.r r3) {
            Class<java.util.List> obj4;
            final Class cls = t.g(type);
            final int i = 0;
            if (!set2.isEmpty()) {
                return i;
            }
            if (cls != List.class) {
                if (cls == Collection.class) {
                } else {
                    if (cls == Set.class) {
                        return d.n(type, r3).f();
                    }
                }
                return i;
            }
            return d.l(type, r3).f();
        }
    }

    class b extends com.squareup.moshi.d<Collection<T>, T> {
        b(com.squareup.moshi.f f) {
            super(f, 0);
        }

        @Override // com.squareup.moshi.d
        public Object b(com.squareup.moshi.i i) {
            return super.k(i);
        }

        @Override // com.squareup.moshi.d
        public void i(com.squareup.moshi.o o, Object object2) {
            super.o(o, (Collection)object2);
        }

        Collection<T> m() {
            ArrayList arrayList = new ArrayList();
            return arrayList;
        }
    }

    class c extends com.squareup.moshi.d<Set<T>, T> {
        c(com.squareup.moshi.f f) {
            super(f, 0);
        }

        @Override // com.squareup.moshi.d
        public Object b(com.squareup.moshi.i i) {
            return super.k(i);
        }

        @Override // com.squareup.moshi.d
        public void i(com.squareup.moshi.o o, Object object2) {
            super.o(o, (Collection)object2);
        }

        @Override // com.squareup.moshi.d
        Collection m() {
            return p();
        }

        Set<T> p() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            return linkedHashSet;
        }
    }
    static {
        d.a aVar = new d.a();
        d.b = aVar;
    }

    private d(com.squareup.moshi.f<T> f) {
        super();
        this.a = f;
    }

    d(com.squareup.moshi.f f, com.squareup.moshi.d.a d$a2) {
        super(f);
    }

    static <T> com.squareup.moshi.f<Collection<T>> l(Type type, com.squareup.moshi.r r2) {
        d.b obj2 = new d.b(r2.d(t.c(type, Collection.class)));
        return obj2;
    }

    static <T> com.squareup.moshi.f<Set<T>> n(Type type, com.squareup.moshi.r r2) {
        d.c obj2 = new d.c(r2.d(t.c(type, Collection.class)));
        return obj2;
    }

    public C k(com.squareup.moshi.i i) {
        Object obj;
        final Collection collection = m();
        i.a();
        while (i.j()) {
            collection.add(this.a.b(i));
        }
        i.e();
        return collection;
    }

    abstract C m();

    public void o(com.squareup.moshi.o o, C c2) {
        Object next;
        com.squareup.moshi.f fVar;
        o.a();
        final Iterator obj4 = c2.iterator();
        for (Object next : obj4) {
            this.a.i(o, next);
        }
        o.f();
    }

    @Override // com.squareup.moshi.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(".collection()");
        return stringBuilder.toString();
    }
}
