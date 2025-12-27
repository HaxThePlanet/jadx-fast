package com.bumptech.glide.load.n.h;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TranscoderRegistry.java */
/* loaded from: classes.dex */
public class f {

    private final List<f.a<?, ?>> a = new ArrayList<>();

    private static final class a<Z, R> {

        final Class<Z> a;
        final Class<R> b;
        final e<Z, R> c;
        a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
            super();
            this.a = cls;
            this.b = cls2;
            this.c = eVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            boolean z = false;
            if (this.a.isAssignableFrom(cls)) {
                cls = cls2.isAssignableFrom(this.b) ? 1 : 0;
            }
            return (cls2.isAssignableFrom(this.b) ? 1 : 0);
        }
    }
    public f() {
        super();
        final ArrayList arrayList = new ArrayList();
    }

    public synchronized <Z, R> e<Z, R> a(Class<Z> cls, Class<R> cls2) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (item.a(cls, cls2)) {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = "No transcoder registered to transcode from ";
        String str2 = " to ";
        cls = str + cls + str2 + cls2;
        throw new IllegalArgumentException(cls);
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        final ArrayList arrayList = new ArrayList();
        arrayList.add(cls2);
        Iterator it = this.a.iterator();
        Object item = it.next();
        arrayList.add(item.b);
        return arrayList;
    }

    public synchronized <Z, R> void c(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        this.a.add(new f.a(cls, cls2, eVar));
    }
}
