package com.bumptech.glide;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.data.e.a;
import com.bumptech.glide.load.data.f;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.m.n;
import com.bumptech.glide.load.m.o;
import com.bumptech.glide.load.m.p;
import com.bumptech.glide.load.n.h.e;
import com.bumptech.glide.load.n.h.f;
import com.bumptech.glide.q.a;
import com.bumptech.glide.q.b;
import com.bumptech.glide.q.c;
import com.bumptech.glide.q.d;
import com.bumptech.glide.q.e;
import com.bumptech.glide.q.f;
import com.bumptech.glide.t.m.a;
import d.h.k.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Registry {

    private final p a;
    private final a b;
    private final e c;
    private final f d;
    private final f e;
    private final f f;
    private final b g;
    private final d h;
    private final c i;
    private final f<List<Throwable>> j;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String string) {
            super(string);
        }
    }

    public static final class NoImageHeaderParserException extends com.bumptech.glide.Registry.MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends com.bumptech.glide.Registry.MissingComponentException {
        public NoModelLoaderAvailableException(Class<?> class, Class<?> class2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to find any ModelLoaders for model: ");
            stringBuilder.append(class);
            stringBuilder.append(" and data: ");
            stringBuilder.append(class2);
            super(stringBuilder.toString());
        }

        public NoModelLoaderAvailableException(Object object) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to find any ModelLoaders registered for model class: ");
            stringBuilder.append(object.getClass());
            super(stringBuilder.toString());
        }

        public NoModelLoaderAvailableException(M m, List<n<M, ?>> list2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Found ModelLoaders for model class: ");
            stringBuilder.append(list2);
            stringBuilder.append(", but none that handle this specific model instance: ");
            stringBuilder.append(m);
            super(stringBuilder.toString());
        }
    }

    public static class NoResultEncoderAvailableException extends com.bumptech.glide.Registry.MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> class) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to find result encoder for resource class: ");
            stringBuilder.append(class);
            stringBuilder.append(", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
            super(stringBuilder.toString());
        }
    }

    public static class NoSourceEncoderAvailableException extends com.bumptech.glide.Registry.MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> class) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to find source encoder for data class: ");
            stringBuilder.append(class);
            super(stringBuilder.toString());
        }
    }
    public Registry() {
        super();
        d dVar = new d();
        this.h = dVar;
        c cVar = new c();
        this.i = cVar;
        f fVar = a.e();
        this.j = fVar;
        p pVar = new p(fVar);
        this.a = pVar;
        a aVar = new a();
        this.b = aVar;
        e eVar = new e();
        this.c = eVar;
        f fVar2 = new f();
        this.d = fVar2;
        f fVar3 = new f();
        this.e = fVar3;
        f fVar4 = new f();
        this.f = fVar4;
        b bVar = new b();
        this.g = bVar;
        r(Arrays.asList(/* result */));
    }

    private <Data, TResource, Transcode> List<i<Data, TResource, Transcode>> f(Class<Data> class, Class<TResource> class2, Class<Transcode> class3) {
        e next2;
        boolean next;
        List list;
        Class cls;
        e eVar;
        Object obj;
        List list2;
        e eVar2;
        f fVar;
        Iterator iterator;
        i iVar;
        ArrayList arrayList = new ArrayList();
        Iterator obj13 = this.c.d(class, class2).iterator();
        for (Class next2 : obj13) {
            iterator = this.f.b(next2, class3).iterator();
            for (Object next4 : iterator) {
                obj = next4;
                super(class, next2, obj, this.c.b(class, next2), this.f.a(next2, (Class)obj), this.j);
                arrayList.add(iVar);
            }
            obj = next4;
            super(class, next2, obj, this.c.b(class, next2), this.f.a(next2, (Class)obj), this.j);
            arrayList.add(iVar);
        }
        return arrayList;
    }

    public <Data> com.bumptech.glide.Registry a(Class<Data> class, d<Data> d2) {
        this.b.a(class, d2);
        return this;
    }

    public <TResource> com.bumptech.glide.Registry b(Class<TResource> class, k<TResource> k2) {
        this.d.a(class, k2);
        return this;
    }

    public <Data, TResource> com.bumptech.glide.Registry c(Class<Data> class, Class<TResource> class2, j<Data, TResource> j3) {
        e("legacy_append", class, class2, j3);
        return this;
    }

    public <Model, Data> com.bumptech.glide.Registry d(Class<Model> class, Class<Data> class2, o<Model, Data> o3) {
        this.a.a(class, class2, o3);
        return this;
    }

    public <Data, TResource> com.bumptech.glide.Registry e(String string, Class<Data> class2, Class<TResource> class3, j<Data, TResource> j4) {
        this.c.a(string, j4, class2, class3);
        return this;
    }

    public List<ImageHeaderParser> g() {
        List list = this.g.b();
        if (list.isEmpty()) {
        } else {
            return list;
        }
        Registry.NoImageHeaderParserException noImageHeaderParserException = new Registry.NoImageHeaderParserException();
        throw noImageHeaderParserException;
    }

    public <Data, TResource, Transcode> s<Data, TResource, Transcode> h(Class<Data> class, Class<TResource> class2, Class<Transcode> class3) {
        s sVar;
        boolean z;
        s sVar2;
        Class cls3;
        Class cls;
        Class cls2;
        List list;
        f fVar;
        sVar = this.i.a(class, class2, class3);
        final int i = 0;
        if (this.i.c(sVar)) {
            return i;
        }
        if (sVar == null) {
            list = f(class, class2, class3);
            if (list.isEmpty()) {
                sVar = i;
            } else {
                super(class, class2, class3, list, this.j);
            }
            this.i.d(class, class2, class3, sVar);
        }
        return sVar;
    }

    public <Model> List<n<Model, ?>> i(Model model) {
        return this.a.d(model);
    }

    public <Model, TResource, Transcode> List<Class<?>> j(Class<Model> class, Class<TResource> class2, Class<Transcode> class3) {
        Object arrayList;
        d dVar;
        List unmodifiableList;
        boolean next;
        e next2;
        boolean contains;
        if (this.h.a(class, class2, class3) == null) {
            arrayList = new ArrayList();
            Iterator iterator = this.a.c(class).iterator();
            for (Class next4 : iterator) {
                unmodifiableList = this.c.d(next4, class2).iterator();
                while (unmodifiableList.hasNext()) {
                    next2 = unmodifiableList.next();
                    if (!this.f.b((Class)next2, class3).isEmpty() && !arrayList.contains(next2)) {
                    }
                    if (!arrayList.contains(next2)) {
                    }
                    arrayList.add(next2);
                }
                next2 = unmodifiableList.next();
                if (!this.f.b((Class)next2, class3).isEmpty() && !arrayList.contains(next2)) {
                }
                if (!arrayList.contains(next2)) {
                }
                arrayList.add(next2);
            }
            this.h.b(class, class2, class3, Collections.unmodifiableList(arrayList));
        }
        return arrayList;
    }

    public <X> k<X> k(u<X> u) {
        k kVar = this.d.b(u.b());
        if (kVar == null) {
        } else {
            return kVar;
        }
        Registry.NoResultEncoderAvailableException noResultEncoderAvailableException = new Registry.NoResultEncoderAvailableException(u.b());
        throw noResultEncoderAvailableException;
    }

    public <X> e<X> l(X x) {
        return this.e.a(x);
    }

    public <X> d<X> m(X x) {
        d dVar = this.b.b(x.getClass());
        if (dVar == null) {
        } else {
            return dVar;
        }
        Registry.NoSourceEncoderAvailableException noSourceEncoderAvailableException = new Registry.NoSourceEncoderAvailableException(x.getClass());
        throw noSourceEncoderAvailableException;
    }

    public boolean n(u<?> u) {
        int obj2;
        obj2 = this.d.b(u.b()) != null ? 1 : 0;
        return obj2;
    }

    public com.bumptech.glide.Registry o(ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }

    public com.bumptech.glide.Registry p(e.a<?> e$a) {
        this.e.b(a);
        return this;
    }

    public <TResource, Transcode> com.bumptech.glide.Registry q(Class<TResource> class, Class<Transcode> class2, e<TResource, Transcode> e3) {
        this.f.c(class, class2, e3);
        return this;
    }

    public final com.bumptech.glide.Registry r(List<String> list) {
        String next;
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator obj3 = list.iterator();
        for (String next : obj3) {
            arrayList.add(next);
        }
        arrayList.add("legacy_append");
        this.c.e(arrayList);
        return this;
    }
}
