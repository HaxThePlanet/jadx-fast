package com.bumptech.glide;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.e.a;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.m.n;
import com.bumptech.glide.load.m.o;
import com.bumptech.glide.load.m.p;
import com.bumptech.glide.q.b;
import com.bumptech.glide.q.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Registry.java */
/* loaded from: classes.dex */
public class Registry {

    private final p a = new p();
    private final com.bumptech.glide.q.a b = new a();
    private final com.bumptech.glide.q.e c = new e();
    private final com.bumptech.glide.q.f d = new f();
    private final com.bumptech.glide.load.data.f e = new f();
    private final com.bumptech.glide.load.n.h.f f = new f();
    private final b g = new b();
    private final com.bumptech.glide.q.d h = new d();
    private final c i = new c();
    private final d.h.k.f<List<Throwable>> j;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends Registry.MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends Registry.MissingComponentException {
        public NoModelLoaderAvailableException(Object object) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Failed to find any ModelLoaders registered for model class: ";
            Class cls = object.getClass();
            str2 = str + cls;
            super(str2);
        }

        public NoModelLoaderAvailableException(M m, List<n<M, ?>> list) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Found ModelLoaders for model class: ";
            final String str3 = ", but none that handle this specific model instance: ";
            str2 = str + list + str3 + m;
            super(str2);
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Failed to find any ModelLoaders for model: ";
            String str2 = " and data: ";
            str3 = str + cls + str2 + cls2;
            super(str3);
        }
    }

    public static class NoResultEncoderAvailableException extends Registry.MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Failed to find result encoder for resource class: ";
            String str2 = ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.";
            str3 = str + cls + str2;
            super(str3);
        }
    }

    public static class NoSourceEncoderAvailableException extends Registry.MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Failed to find source encoder for data class: ";
            str2 = str + cls;
            super(str2);
        }
    }
    public Registry() {
        super();
        com.bumptech.glide.q.d dVar = new d();
        c cVar = new c();
        d.h.k.f fVar = a.e();
        this.j = fVar;
        p pVar = new p(fVar);
        com.bumptech.glide.q.a aVar = new a();
        com.bumptech.glide.q.e eVar = new e();
        com.bumptech.glide.q.f fVar2 = new f();
        com.bumptech.glide.load.data.f fVar3 = new f();
        com.bumptech.glide.load.n.h.f fVar4 = new f();
        b bVar = new b();
        r(Arrays.asList(new String[] { "Animation", "Bitmap", "BitmapDrawable" }));
    }

    private <Data, TResource, Transcode> List<i<Data, TResource, Transcode>> f(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        Class cls4;
        Class cls5;
        Class cls6;
        List list2;
        com.bumptech.glide.load.n.h.e eVar;
        d.h.k.f fVar;
        i iVar;
        final ArrayList arrayList = new ArrayList();
        Iterator it2 = this.c.d(cls, cls2).iterator();
        while (it2.hasNext()) {
            com.bumptech.glide.q.e item = it2.next();
            Iterator it = this.f.b(item, cls3).iterator();
            while (it.hasNext()) {
                cls6 = it.next();
                i list = new i(cls, item, cls6, this.c.b(cls, item), this.f.a(item, cls6), this.j);
                arrayList.add(iVar);
            }
            cls6 = it.next();
            list = new i(cls, item, cls6, this.c.b(cls, item), this.f.a(item, cls6), this.j);
            arrayList.add(iVar);
        }
        return arrayList;
    }

    public <Data> Registry a(Class<Data> cls, com.bumptech.glide.load.d<Data> dVar) {
        this.b.a(cls, dVar);
        return this;
    }

    public <TResource> Registry b(Class<TResource> cls, k<TResource> kVar) {
        this.d.a(cls, kVar);
        return this;
    }

    public <Data, TResource> Registry c(Class<Data> cls, Class<TResource> cls2, j<Data, TResource> jVar) {
        e("legacy_append", cls, cls2, jVar);
        return this;
    }

    public <Model, Data> Registry d(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        this.a.a(cls, cls2, oVar);
        return this;
    }

    public <Data, TResource> Registry e(String str, Class<Data> cls, Class<TResource> cls2, j<Data, TResource> jVar) {
        this.c.a(str, jVar, cls, cls2);
        return this;
    }

    public List<ImageHeaderParser> g() throws Registry.NoImageHeaderParserException {
        List list = this.g.b();
        if (list.isEmpty()) {
            throw new Registry.NoImageHeaderParserException();
        } else {
            return list;
        }
    }

    public <Data, TResource, Transcode> s<Data, TResource, Transcode> h(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        s sVar;
        Class cls4;
        Class cls22;
        Class cls32;
        d.h.k.f fVar;
        sVar = this.i.a(cls, cls2, cls3);
        final int i = 0;
        if (this.i.c(sVar)) {
            return null;
        }
        if (sVar == null) {
            List list = f(cls, cls2, cls3);
            if (list.isEmpty()) {
            } else {
                sVar = new s(cls, cls2, cls3, list, this.j);
            }
            this.i.d(cls, cls2, cls3, sVar);
        }
        return sVar;
    }

    public <Model> List<n<Model, ?>> i(Model model) {
        return this.a.d(model);
    }

    public <Model, TResource, Transcode> List<Class<?>> j(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List list;
        boolean hasNext;
        boolean contains;
        if (this.h.a(cls, cls2, cls3) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.a.c(cls).iterator();
            while (it2.hasNext()) {
                Iterator it = this.c.d((Class)it2.next(), cls2).iterator();
                while (it.hasNext()) {
                    com.bumptech.glide.q.e item = it.next();
                }
                item = it.next();
            }
            this.h.b(cls, cls2, cls3, Collections.unmodifiableList(arrayList));
        }
        return list;
    }

    public <X> k<X> k(u<X> uVar) throws Registry.NoResultEncoderAvailableException {
        k kVar = this.d.b(uVar.b());
        if (kVar == null) {
            throw new Registry.NoResultEncoderAvailableException(uVar.b());
        } else {
            return kVar;
        }
    }

    public <X> com.bumptech.glide.load.data.e<X> l(X x) {
        return this.e.a(x);
    }

    public <X> com.bumptech.glide.load.d<X> m(X x) throws Registry.NoSourceEncoderAvailableException {
        com.bumptech.glide.load.d dVar = this.b.b(x.getClass());
        if (dVar == null) {
            throw new Registry.NoSourceEncoderAvailableException(x.getClass());
        } else {
            return dVar;
        }
    }

    public boolean n(u<?> uVar) {
        boolean z = true;
        uVar = this.d.b(uVar.b()) != null ? 1 : 0;
        return (this.d.b(uVar.b()) != null ? 1 : 0);
    }

    public Registry o(ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }

    public Registry p(e.a<?> aVar) {
        this.e.b(aVar);
        return this;
    }

    public <TResource, Transcode> Registry q(Class<TResource> cls, Class<Transcode> cls2, com.bumptech.glide.load.n.h.e<TResource, Transcode> eVar) {
        this.f.c(cls, cls2, eVar);
        return this;
    }

    public final Registry r(List<String> list) {
        final ArrayList arrayList = new ArrayList(list.size());
        item = "legacy_prepend_all";
        arrayList.add(item);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String)it.next());
        }
        arrayList.add("legacy_append");
        this.c.e(arrayList);
        return this;
    }
}
