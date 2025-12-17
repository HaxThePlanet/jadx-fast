package com.bumptech.glide.load.engine.z;

import android.util.Log;
import com.bumptech.glide.t.k;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class j implements com.bumptech.glide.load.engine.z.b {

    private final com.bumptech.glide.load.engine.z.h<com.bumptech.glide.load.engine.z.j.a, Object> a;
    private final com.bumptech.glide.load.engine.z.j.b b;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> c;
    private final Map<Class<?>, com.bumptech.glide.load.engine.z.a<?>> d;
    private final int e;
    private int f;

    private static final class a implements com.bumptech.glide.load.engine.z.m {

        private final com.bumptech.glide.load.engine.z.j.b a;
        int b;
        private Class<?> c;
        a(com.bumptech.glide.load.engine.z.j.b j$b) {
            super();
            this.a = b;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public void a() {
            this.a.c(this);
        }

        void b(int i, Class<?> class2) {
            this.b = i;
            this.c = class2;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public boolean equals(Object object) {
            boolean i2;
            int i3;
            int i;
            Object obj4;
            i3 = 0;
            if (object instanceof j.a && this.b == object.b && this.c == object.c) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        i3 = 1;
                    }
                }
            }
            return i3;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public int hashCode() {
            int i;
            Class cls = this.c;
            if (cls != null) {
                i = cls.hashCode();
            } else {
                i = 0;
            }
            return i3 += i;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Key{size=");
            stringBuilder.append(this.b);
            stringBuilder.append("array=");
            stringBuilder.append(this.c);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static final class b extends com.bumptech.glide.load.engine.z.d<com.bumptech.glide.load.engine.z.j.a> {
        @Override // com.bumptech.glide.load.engine.z.d
        protected com.bumptech.glide.load.engine.z.m a() {
            return d();
        }

        @Override // com.bumptech.glide.load.engine.z.d
        protected com.bumptech.glide.load.engine.z.j.a d() {
            j.a aVar = new j.a(this);
            return aVar;
        }

        com.bumptech.glide.load.engine.z.j.a e(int i, Class<?> class2) {
            final com.bumptech.glide.load.engine.z.m mVar = b();
            (j.a)mVar.b(i, class2);
            return mVar;
        }
    }
    public j(int i) {
        super();
        h hVar = new h();
        this.a = hVar;
        j.b bVar = new j.b();
        this.b = bVar;
        HashMap hashMap = new HashMap();
        this.c = hashMap;
        HashMap hashMap2 = new HashMap();
        this.d = hashMap2;
        this.e = i;
    }

    private void f(int i, Class<?> class2) {
        Object valueOf;
        Integer obj4;
        NavigableMap obj5 = m(class2);
        valueOf = obj5.get(Integer.valueOf(i));
        if ((Integer)valueOf == null) {
        } else {
            final int i3 = 1;
            if ((Integer)valueOf.intValue() == i3) {
                obj5.remove(Integer.valueOf(i));
            } else {
                obj5.put(Integer.valueOf(i), Integer.valueOf(intValue -= i3));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tried to decrement empty size, size: ");
        stringBuilder.append(i);
        stringBuilder.append(", this: ");
        stringBuilder.append(this);
        obj5 = new NullPointerException(stringBuilder.toString());
        throw obj5;
    }

    private void g() {
        h(this.e);
    }

    private void h(int i) {
        Object string;
        com.bumptech.glide.load.engine.z.a aVar;
        boolean loggable;
        int stringBuilder;
        int str;
        while (this.f > i) {
            string = this.a.f();
            k.d(string);
            aVar = i(string);
            this.f = i4 -= i8;
            f(aVar.b(string), string.getClass());
            if (Log.isLoggable(aVar.getTag(), 2)) {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("evicted: ");
            stringBuilder.append(aVar.b(string));
            Log.v(aVar.getTag(), stringBuilder.toString());
        }
    }

    private <T> com.bumptech.glide.load.engine.z.a<T> i(T t) {
        return j(t.getClass());
    }

    private <T> com.bumptech.glide.load.engine.z.a<T> j(Class<T> class) {
        Object gVar;
        Map map;
        if ((a)this.d.get(class) == null) {
            if (class.equals(int[].class)) {
                gVar = new i();
                this.d.put(class, gVar);
            } else {
                if (!class.equals(byte[].class)) {
                } else {
                    gVar = new g();
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No array pool found for: ");
            stringBuilder.append(class.getSimpleName());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        return gVar;
    }

    private <T> T k(com.bumptech.glide.load.engine.z.j.a j$a) {
        return this.a.a(a);
    }

    private <T> T l(com.bumptech.glide.load.engine.z.j.a j$a, Class<T> class2) {
        int string;
        Object array;
        int str;
        int i2;
        int i;
        com.bumptech.glide.load.engine.z.j.a obj6;
        boolean obj7;
        final com.bumptech.glide.load.engine.z.a aVar = j(class2);
        array = k(a);
        if (array != null) {
            this.f = i3 -= i2;
            f(aVar.b(array), class2);
        }
        if (array == null && Log.isLoggable(aVar.getTag(), 2)) {
            if (Log.isLoggable(aVar.getTag(), 2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Allocated ");
                stringBuilder.append(a.b);
                stringBuilder.append(" bytes");
                Log.v(aVar.getTag(), stringBuilder.toString());
            }
            array = aVar.newArray(a.b);
        }
        return array;
    }

    private NavigableMap<Integer, Integer> m(Class<?> class) {
        Object treeMap;
        Map map;
        if ((NavigableMap)this.c.get(class) == null) {
            treeMap = new TreeMap();
            this.c.put(class, treeMap);
        }
        return treeMap;
    }

    private boolean n() {
        int i3;
        int i2;
        int i;
        i2 = this.f;
        if (i2 != 0) {
            if (i4 /= i2 >= 2) {
                i3 = 1;
            } else {
                i3 = 0;
            }
        } else {
        }
        return i3;
    }

    private boolean o(int i) {
        int obj2;
        obj2 = i <= i2 /= 2 ? 1 : 0;
        return obj2;
    }

    private boolean p(int i, Integer integer2) {
        boolean z;
        int obj2;
        int obj3;
        if (integer2 != 0) {
            if (!n()) {
                obj2 = integer2.intValue() <= i *= 8 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public void a(int i) {
        int i2;
        int obj2;
        synchronized (this) {
            b();
        }
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public void b() {
        h(0);
        return;
        synchronized (this) {
            h(0);
        }
    }

    public <T> T c(int i, Class<T> class2) {
        return l(this.b.e(i, class2), class2);
        synchronized (this) {
            return l(this.b.e(i, class2), class2);
        }
    }

    public <T> void d(T t) {
        Object intValue;
        int i;
        Class class = t.getClass();
        com.bumptech.glide.load.engine.z.a aVar = j(class);
        int i5 = aVar.b(t);
        i3 *= i5;
        synchronized (this) {
            try {
                com.bumptech.glide.load.engine.z.j.a aVar2 = this.b.e(i5, class);
                this.a.d(aVar2, t);
                NavigableMap obj5 = m(class);
                intValue = obj5.get(Integer.valueOf(aVar2.b));
                if ((Integer)intValue == null) {
                } else {
                }
                i += intValue;
                obj5.put(Integer.valueOf(aVar2.b), Integer.valueOf(i));
                this.f = obj5 += i4;
                g();
                throw t;
            }
        }
    }

    public <T> T e(int i, Class<T> class2) {
        int intValue;
        com.bumptech.glide.load.engine.z.j.a obj3;
        Object ceilingKey = m(class2).ceilingKey(Integer.valueOf(i));
        synchronized (this) {
            try {
                obj3 = this.b.e(ceilingKey.intValue(), class2);
                obj3 = this.b.e(i, class2);
                return l(obj3, class2);
                throw i;
            }
        }
    }
}
