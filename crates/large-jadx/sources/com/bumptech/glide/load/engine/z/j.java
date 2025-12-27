package com.bumptech.glide.load.engine.z;

import android.util.Log;
import com.bumptech.glide.t.k;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: LruArrayPool.java */
/* loaded from: classes.dex */
public final class j implements b {

    private final h<j.a, Object> a = new h<>();
    private final j.b b = new j$b();
    private final Map<Class<?>, NavigableMap<Integer, Integer>> c = new HashMap<>();
    private final Map<Class<?>, a<?>> d = new HashMap<>();
    private final int e;
    private int f;

    private static final class a implements m {

        private final j.b a;
        int b;
        private Class<?> c;
        a(j.b bVar) {
            super();
            this.a = bVar;
        }

        public void a() {
            this.a.c(this);
        }

        void b(int i, Class<?> cls) {
            this.b = i;
            this.c = cls;
        }

        @Override // java.lang.Object
        public boolean equals(Object object) {
            boolean z2 = false;
            z = object instanceof j.a;
            int i3 = 0;
            if (object instanceof j.a) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        int i4 = 1;
                    }
                }
            }
            return z2;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i = 0;
            if (this.c != null) {
                i = this.c.hashCode();
            } else {
                i = 0;
            }
            return (this.b * 31) + i;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Key{size=";
            String str3 = "array=";
            str = str2 + this.b + str3 + this.c + 125;
            return str;
        }
    }

    private static final class b extends d<j.a> {
        b() {
            super();
        }

        @Override // com.bumptech.glide.load.engine.z.d
        protected j.a d() {
            return new j.a(this);
        }

        @Override // com.bumptech.glide.load.engine.z.d
        j.a e(int i, Class<?> cls) {
            final com.bumptech.glide.load.engine.z.m mVar = b();
            mVar.b(i, cls);
            return mVar;
        }
    }
    public j(int i) {
        super();
        com.bumptech.glide.load.engine.z.h hVar = new h();
        com.bumptech.glide.load.engine.z.j.b bVar = new j.b();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        this.e = i;
    }

    private void f(int i, Class<?> cls) {
        NavigableMap navigableMap = m(cls);
        Object value = navigableMap.get(Integer.valueOf(i));
        if (value == null) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Tried to decrement empty size, size: ";
            String str2 = ", this: ";
            i = str + i + str2 + this;
            throw new NullPointerException(i);
        } else {
            final int i3 = 1;
            if (value.intValue() == i3) {
                navigableMap.remove(Integer.valueOf(i));
            } else {
                navigableMap.put(Integer.valueOf(i), Integer.valueOf(value.intValue() - i3));
            }
            return;
        }
    }

    private void g() {
        h(this.e);
    }

    private void h(int i) {
        while (this.f > i) {
            Object obj = this.a.f();
            k.d(obj);
            com.bumptech.glide.load.engine.z.a aVar = i(obj);
            this.f -= i10;
            f(aVar.b(obj), obj.getClass());
            int i2 = 2;
        }
    }

    private <T> a<T> i(T t) {
        return j(t.getClass());
    }

    private <T> a<T> j(Class<T> cls) {
        Object value;
        com.bumptech.glide.load.engine.z.g gVar;
        if ((a)this.d.get(cls) == null) {
            if (cls.equals(int[].class)) {
                com.bumptech.glide.load.engine.z.i iVar = new i();
                this.d.put(cls, gVar);
            } else {
                if (cls.equals(byte[].class)) {
                    gVar = new g();
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "No array pool found for: ";
            String simpleName = cls.getSimpleName();
            cls = str + simpleName;
            throw new IllegalArgumentException(cls);
        }
        return value;
    }

    private <T> T k(j.a aVar) {
        return this.a.a(aVar);
    }

    private <T> T l(j.a aVar, Class<T> cls) {
        Object array;
        int i2;
        boolean loggable;
        final com.bumptech.glide.load.engine.z.a aVar2 = j(cls);
        array = k(aVar);
        if (array != null) {
            i3 = aVar2.b(array) * aVar2.a();
            this.f -= i3;
            f(aVar2.b(array), cls);
        }
        if (array == null) {
            int i = 2;
            if (Log.isLoggable(aVar2.getTag(), i)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "Allocated ";
                String str3 = " bytes";
                str = str2 + aVar.b + str3;
                Log.v(aVar2.getTag(), str);
            }
            array = aVar2.newArray(aVar.b);
        }
        return array;
    }

    private NavigableMap<Integer, Integer> m(Class<?> cls) {
        Object value;
        if ((NavigableMap)this.c.get(cls) == null) {
            this.c.put(cls, new TreeMap());
        }
        return value;
    }

    private boolean n() {
        boolean z = false;
        int i2;
        if (this.f != 0) {
            i2 = this.e / i;
            int i = 2;
            if (this.e / i >= 2) {
                int i4 = 1;
            } else {
                int i3 = 0;
            }
        }
        return z;
    }

    private boolean o(int i) {
        boolean z = true;
        i = i <= this.e / 2 ? 1 : 0;
        return (i <= this.e / 2 ? 1 : 0);
    }

    private boolean p(int i, Integer integer) {
        boolean z;
        boolean z2 = true;
        int value;
        if (integer == null || !this.n()) {
            int i4 = 0;
        } else {
            i2 = i * 8;
            i = integer.intValue() <= i * 8 ? 1 : 0;
        }
        return (integer.intValue() <= i * 8 ? 1 : 0);
    }

    public synchronized void a(int i) {
        int i2 = 20;
        i2 = 40;
        if (i >= 40) {
            try {
                b();
                i2 = 20;
                if (i >= 20 || i == 15) {
                    i3 = this.e / 2;
                    h(i3);
                }
            } catch (Throwable th) {
            }
        }
    }

    public synchronized void b() {
        h(0);
    }

    public synchronized <T> T c(int i, Class<T> cls) {
        return l(this.b.e(i, cls), cls);
    }

    public synchronized <T> void d(T t) {
        int i = 1;
        Class cls = t.getClass();
        com.bumptech.glide.load.engine.z.a aVar = j(cls);
        int i5 = aVar.b(t);
        int i4 = aVar.a() * i5;
        if (!o(i4)) {
            return;
        }
        com.bumptech.glide.load.engine.z.j.a aVar2 = this.b.e(i5, cls);
        this.a.d(aVar2, t);
        NavigableMap navigableMap = m(cls);
        Object value2 = navigableMap.get(Integer.valueOf(aVar2.b));
        i = 1;
        if (value2 != null) {
            i = 1 + value2.intValue();
        }
        navigableMap.put(Integer.valueOf(aVar2.b), Integer.valueOf(i));
        this.f += i4;
        g();
    }

    public synchronized <T> T e(int i, Class<T> cls) {
        com.bumptech.glide.load.engine.z.j.a aVar;
        Object ceilingKey = m(cls).ceilingKey(Integer.valueOf(i));
        if (p(i, ceilingKey)) {
            aVar = this.b.e(ceilingKey.intValue(), cls);
        } else {
            aVar = this.b.e(i, cls);
        }
        return l(aVar, cls);
    }
}
