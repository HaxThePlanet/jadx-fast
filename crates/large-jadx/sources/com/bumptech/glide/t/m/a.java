package com.bumptech.glide.t.m;

import android.util.Log;
import d.h.k.f;
import d.h.k.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FactoryPools.java */
/* loaded from: classes.dex */
public final class a {

    private static final a.g<Object> a = new a$a<>();

    public interface d<T> {
        T a();
    }

    public interface f {
        c f();
    }

    public interface g<T> {
        void a(T t);
    }

    class a implements a.g<Object> {
        a() {
            super();
        }

        public void a(Object object) {
        }
    }

    class b implements a.d<List<T>> {
        b() {
            super();
        }

        public List<T> b() {
            return new ArrayList();
        }
    }

    class c implements a.g<List<T>> {
        c() {
            super();
        }

        public void b(List<T> list) {
            list.clear();
        }
    }

    private static final class e<T> implements f<T> {

        private final a.d<T> a;
        private final a.g<T> b;
        private final f<T> c;
        e(f<T> fVar, a.d<T> dVar, a.g<T> gVar) {
            super();
            this.c = fVar;
            this.a = dVar;
            this.b = gVar;
        }

        public boolean a(T t) {
            z = t instanceof a.f;
            if (t instanceof a.f) {
                boolean z2 = true;
                (a.f)t.f().b(z2);
            }
            this.b.a(t);
            return this.c.a(t);
        }

        public T b() {
            Object obj;
            String str;
            if (this.c.b() == null && Log.isLoggable(str, 2)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "Created new ";
                Class cls = this.a.a().getClass();
                str2 = str3 + cls;
                Log.v(str, str2);
            }
            z = obj instanceof a.f;
            if (obj instanceof a.f) {
                (a.f)obj.f().b(false);
            }
            return obj;
        }
    }

    private static <T extends a.f> f<T> a(f<T> fVar, a.d<T> dVar) {
        return a.b(fVar, dVar, a.c());
    }

    private static <T> f<T> b(f<T> fVar, a.d<T> dVar, a.g<T> gVar) {
        return new a.e(fVar, dVar, gVar);
    }

    private static <T> a.g<T> c() {
        return a.a;
    }

    public static <T extends a.f> f<T> d(int i, a.d<T> dVar) {
        return a.a(new h(i), dVar);
    }

    public static <T> f<List<T>> e() {
        return a.f(20);
    }

    public static <T> f<List<T>> f(int i) {
        return a.b(new h(i), new a.b(), new a.c());
    }
}
