package com.squareup.moshi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: CollectionJsonAdapter.java */
/* loaded from: classes2.dex */
abstract class d<C extends Collection<T>, T> extends f<C> {

    public static final f.d b = new d$a();
    private final f<T> a;

    class a implements f.d {
        a() {
            super();
        }

        public f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
            final Class cls = t.g(type);
            final int i = 0;
            if (!set.isEmpty()) {
                return null;
            }
            obj = List.class;
            return d.l(type, rVar).f();
        }
    }

    class b extends d<Collection<T>, T> {
        b(f fVar) {
            super(fVar, null);
        }

        @Override // com.squareup.moshi.d
        Collection<T> m() {
            return new ArrayList();
        }
    }

    class c extends d<Set<T>, T> {
        c(f fVar) {
            super(fVar, null);
        }

        @Override // com.squareup.moshi.d
        Set<T> p() {
            return new LinkedHashSet();
        }
    }

    /* synthetic */ d(f fVar, d.a aVar) {
        this(fVar);
    }

    static <T> f<Collection<T>> l(Type type, r rVar) {
        return new d.b(rVar.d(t.c(type, Collection.class)));
    }

    static <T> f<Set<T>> n(Type type, r rVar) {
        return new d.c(rVar.d(t.c(type, Collection.class)));
    }

    @Override // com.squareup.moshi.f
    public C k(i iVar) {
        final Collection collection = m();
        iVar.a();
        while (iVar.j()) {
            collection.add(this.a.b(iVar));
        }
        iVar.e();
        return collection;
    }

    @Override // com.squareup.moshi.f
    public void o(o oVar, C c) {
        oVar.a();
        final Iterator it = c.iterator();
        while (it.hasNext()) {
            this.a.i(oVar, it.next());
        }
        oVar.f();
    }

    @Override // com.squareup.moshi.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = ".collection()";
        str = this.a + str2;
        return str;
    }

    private d(f<T> fVar) {
        super();
        this.a = fVar;
    }

    @Override // com.squareup.moshi.f
    abstract C m();
}
