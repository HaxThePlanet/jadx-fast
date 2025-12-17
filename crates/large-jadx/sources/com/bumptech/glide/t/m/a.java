package com.bumptech.glide.t.m;

import android.util.Log;
import d.h.k.f;
import d.h.k.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    private static final com.bumptech.glide.t.m.a.g<Object> a;

    public interface d {
        public abstract T a();
    }

    public interface f {
        public abstract com.bumptech.glide.t.m.c f();
    }

    public interface g {
        public abstract void a(T t);
    }

    class a implements com.bumptech.glide.t.m.a.g<Object> {
        @Override // com.bumptech.glide.t.m.a$g
        public void a(Object object) {
        }
    }

    class b implements com.bumptech.glide.t.m.a.d<List<T>> {
        @Override // com.bumptech.glide.t.m.a$d
        public Object a() {
            return b();
        }

        public List<T> b() {
            ArrayList arrayList = new ArrayList();
            return arrayList;
        }
    }

    class c implements com.bumptech.glide.t.m.a.g<List<T>> {
        @Override // com.bumptech.glide.t.m.a$g
        public void a(Object object) {
            b((List)object);
        }

        public void b(List<T> list) {
            list.clear();
        }
    }

    private static final class e implements f<T> {

        private final com.bumptech.glide.t.m.a.d<T> a;
        private final com.bumptech.glide.t.m.a.g<T> b;
        private final f<T> c;
        e(f<T> f, com.bumptech.glide.t.m.a.d<T> a$d2, com.bumptech.glide.t.m.a.g<T> a$g3) {
            super();
            this.c = f;
            this.a = d2;
            this.b = g3;
        }

        public boolean a(T t) {
            boolean z;
            int i;
            if (t instanceof a.f) {
                (a.f)t.f().b(true);
            }
            this.b.a(t);
            return this.c.a(t);
        }

        public T b() {
            Object obj;
            boolean loggable;
            boolean z;
            String str;
            Class class;
            str = "FactoryPools";
            if (this.c.b() == null && Log.isLoggable(str, 2)) {
                str = "FactoryPools";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Created new ");
                    stringBuilder.append(this.a.a().getClass());
                    Log.v(str, stringBuilder.toString());
                }
            }
            if (obj instanceof a.f) {
                (a.f)obj.f().b(false);
            }
            return obj;
        }
    }
    static {
        a.a aVar = new a.a();
        a.a = aVar;
    }

    private static <T extends com.bumptech.glide.t.m.a.f> f<T> a(f<T> f, com.bumptech.glide.t.m.a.d<T> a$d2) {
        return a.b(f, d2, a.c());
    }

    private static <T> f<T> b(f<T> f, com.bumptech.glide.t.m.a.d<T> a$d2, com.bumptech.glide.t.m.a.g<T> a$g3) {
        a.e eVar = new a.e(f, d2, g3);
        return eVar;
    }

    private static <T> com.bumptech.glide.t.m.a.g<T> c() {
        return a.a;
    }

    public static <T extends com.bumptech.glide.t.m.a.f> f<T> d(int i, com.bumptech.glide.t.m.a.d<T> a$d2) {
        h hVar = new h(i);
        return a.a(hVar, d2);
    }

    public static <T> f<List<T>> e() {
        return a.f(20);
    }

    public static <T> f<List<T>> f(int i) {
        h hVar = new h(i);
        a.b obj2 = new a.b();
        a.c cVar = new a.c();
        return a.b(hVar, obj2, cVar);
    }
}
