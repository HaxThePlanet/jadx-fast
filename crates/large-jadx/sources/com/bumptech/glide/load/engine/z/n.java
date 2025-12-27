package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.bumptech.glide.t.l;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: SizeConfigStrategy.java */
/* loaded from: classes.dex */
public class n implements l {

    private static final Bitmap.Config[] d;
    private static final Bitmap.Config[] e;
    private static final Bitmap.Config[] f;
    private static final Bitmap.Config[] g;
    private static final Bitmap.Config[] h;
    private final n.c a = new n$c();
    private final h<n.b, Bitmap> b = new h<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> c = new HashMap<>();

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            n.a.a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                n.a.a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                n.a.a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                n.a.a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    static final class b implements m {

        private final n.c a;
        int b;
        private Bitmap.Config c;
        public b(n.c cVar) {
            super();
            this.a = cVar;
        }

        public void a() {
            this.a.c(this);
        }

        public void b(int i, Bitmap.Config config) {
            this.b = i;
            this.c = config;
        }

        @Override // java.lang.Object
        public boolean equals(Object object) {
            boolean z3 = false;
            z = object instanceof n.b;
            int i3 = 0;
            if (object instanceof n.b) {
                if (this.b == object.b) {
                    if (l.c(this.c, object.c)) {
                        int i4 = 1;
                    }
                }
            }
            return z3;
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
            return n.h(this.b, this.c);
        }
    }

    static class c extends d<n.b> {
        c() {
            super();
        }

        @Override // com.bumptech.glide.load.engine.z.d
        protected n.b d() {
            return new n.b(this);
        }

        @Override // com.bumptech.glide.load.engine.z.d
        public n.b e(int i, Bitmap.Config config) {
            final com.bumptech.glide.load.engine.z.m mVar = b();
            mVar.b(i, config);
            return mVar;
        }
    }
    static {
        Bitmap.Config[] arr;
        arr = new Bitmap.Config[2];
        final int i5 = 0;
        arr[i5] = Bitmap.Config.ARGB_8888;
        final int i6 = 1;
        arr[i6] = 0;
        int i = 26;
        if (Build.VERSION.SDK_INT >= 26) {
            Object[] copy = Arrays.copyOf(arr, 3);
            sDK_INT2 = copy.length - i6;
            copy[sDK_INT2] = Bitmap.Config.RGBA_F16;
        }
        n.d = arr;
        n.e = arr;
        Bitmap.Config[] arr2 = new Bitmap.Config[i6];
        n.f = new Bitmap.Config[] { Bitmap.Config.RGB_565 };
        Bitmap.Config[] arr3 = new Bitmap.Config[i6];
        n.g = new Bitmap.Config[] { Bitmap.Config.ARGB_4444 };
        Bitmap.Config[] arr4 = new Bitmap.Config[i6];
        n.h = new Bitmap.Config[] { Bitmap.Config.ALPHA_8 };
    }

    public n() {
        super();
        com.bumptech.glide.load.engine.z.n.c cVar = new n.c();
        com.bumptech.glide.load.engine.z.h hVar = new h();
        HashMap hashMap = new HashMap();
    }

    private void f(Integer integer, Bitmap bitmap) {
        NavigableMap navigableMap = j(bitmap.getConfig());
        Object value = navigableMap.get(integer);
        if (value == null) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Tried to decrement empty size, size: ";
            String str2 = ", removed: ";
            String str3 = e(bitmap);
            String str4 = ", this: ";
            integer = str + integer + str2 + str3 + str4 + this;
            throw new NullPointerException(integer);
        } else {
            int i = 1;
            if (value.intValue() == i) {
                navigableMap.remove(integer);
            } else {
                navigableMap.put(integer, Integer.valueOf(value.intValue() - i));
            }
            return;
        }
    }

    private n.b g(int i, Bitmap.Config config) {
        com.bumptech.glide.load.engine.z.n.b bVar;
        int i2 = 0;
        Object ceilingKey;
        Integer num;
        int i3;
        Bitmap.Config[] objArr = n.i(config);
        i2 = 0;
        for (Bitmap.Config config : objArr) {
            ceilingKey = j(config).ceilingKey(Integer.valueOf(i));
            if (ceilingKey != null) {
                i3 = i * 8;
            }
        }
        return bVar;
    }

    static String h(int i, Bitmap.Config config) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "[";
        String str2 = "](";
        String str3 = ")";
        str4 = str + i + str2 + config + str3;
        return str4;
    }

    private static Bitmap.Config[] i(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26) {
            if (Bitmap.Config.RGBA_F16.equals(config)) {
                return n.e;
            }
        }
        int i = n.a.a[config.ordinal()];
        int i3 = 1;
        if (Bitmap.Config.RGBA_F16 != i3 && Bitmap.Config.RGBA_F16 != 2) {
            if (Bitmap.Config.RGBA_F16 != 3 && Bitmap.Config.RGBA_F16 != 4) {
                Bitmap.Config[] arr = new Bitmap.Config[i3];
                return new Bitmap.Config[] { config };
            }
            return n.g;
        }
        return n.d;
    }

    private NavigableMap<Integer, Integer> j(Bitmap.Config config) {
        Object value;
        if ((NavigableMap)this.c.get(config) == null) {
            this.c.put(config, new TreeMap());
        }
        return value;
    }

    public String a(int i, int i2, Bitmap.Config config) {
        return n.h(l.f(i, i2, config), config);
    }

    public int b(Bitmap bitmap) {
        return l.g(bitmap);
    }

    public void c(Bitmap bitmap) {
        int i = 1;
        com.bumptech.glide.load.engine.z.n.b bVar = this.a.e(l.g(bitmap), bitmap.getConfig());
        this.b.d(bVar, bitmap);
        NavigableMap navigableMap = j(bitmap.getConfig());
        Object value = navigableMap.get(Integer.valueOf(bVar.b));
        i = 1;
        if (value != null) {
            i = 1 + value.intValue();
        }
        navigableMap.put(Integer.valueOf(bVar.b), Integer.valueOf(i));
    }

    public Bitmap d(int i, int i2, Bitmap.Config config) {
        com.bumptech.glide.load.engine.z.n.b bVar = g(l.f(i, i2, config), config);
        Object obj = this.b.a(bVar);
        if (obj != null) {
            f(Integer.valueOf(bVar.b), obj);
            obj.reconfigure(i, i2, config);
        }
        return obj;
    }

    public String e(Bitmap bitmap) {
        return n.h(l.g(bitmap), bitmap.getConfig());
    }

    public Bitmap removeLast() {
        Object obj = this.b.f();
        if (obj != null) {
            f(Integer.valueOf(l.g(obj)), obj);
        }
        return obj;
    }

    @Override // java.lang.Object
    public String toString() {
        char c = 91;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SizeConfigStrategy{groupedMap=");
        stringBuilder.append(this.b);
        stringBuilder.append(", sortedSizes=(");
        Iterator it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            stringBuilder.append(item.getKey());
            c = '[';
            stringBuilder.append(c);
            stringBuilder.append(item.getValue());
            str = "], ";
            stringBuilder.append(str);
        }
        if (!this.c.isEmpty()) {
            stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
        }
        stringBuilder.append(")}");
        return stringBuilder.toString();
    }
}
