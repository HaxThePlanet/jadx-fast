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

/* loaded from: classes.dex */
public class n implements com.bumptech.glide.load.engine.z.l {

    private static final Bitmap.Config[] d;
    private static final Bitmap.Config[] e;
    private static final Bitmap.Config[] f;
    private static final Bitmap.Config[] g;
    private static final Bitmap.Config[] h;
    private final com.bumptech.glide.load.engine.z.n.c a;
    private final com.bumptech.glide.load.engine.z.h<com.bumptech.glide.load.engine.z.n.b, Bitmap> b;
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> c;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            n.a.a = iArr;
            iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            n.a.a[Bitmap.Config.RGB_565.ordinal()] = 2;
            n.a.a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            n.a.a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
        }
    }

    static final class b implements com.bumptech.glide.load.engine.z.m {

        private final com.bumptech.glide.load.engine.z.n.c a;
        int b;
        private Bitmap.Config c;
        public b(com.bumptech.glide.load.engine.z.n.c n$c) {
            super();
            this.a = c;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public void a() {
            this.a.c(this);
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public void b(int i, Bitmap.Config bitmap$Config2) {
            this.b = i;
            this.c = config2;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public boolean equals(Object object) {
            boolean i;
            int i3;
            int i2;
            Object obj4;
            i3 = 0;
            if (object instanceof n.b && this.b == object.b && l.c(this.c, object.c)) {
                if (this.b == object.b) {
                    if (l.c(this.c, object.c)) {
                        i3 = 1;
                    }
                }
            }
            return i3;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public int hashCode() {
            int i;
            Bitmap.Config config = this.c;
            if (config != null) {
                i = config.hashCode();
            } else {
                i = 0;
            }
            return i3 += i;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public String toString() {
            return n.h(this.b, this.c);
        }
    }

    static class c extends com.bumptech.glide.load.engine.z.d<com.bumptech.glide.load.engine.z.n.b> {
        @Override // com.bumptech.glide.load.engine.z.d
        protected com.bumptech.glide.load.engine.z.m a() {
            return d();
        }

        @Override // com.bumptech.glide.load.engine.z.d
        protected com.bumptech.glide.load.engine.z.n.b d() {
            n.b bVar = new n.b(this);
            return bVar;
        }

        @Override // com.bumptech.glide.load.engine.z.d
        public com.bumptech.glide.load.engine.z.n.b e(int i, Bitmap.Config bitmap$Config2) {
            final com.bumptech.glide.load.engine.z.m mVar = b();
            (n.b)mVar.b(i, config2);
            return mVar;
        }
    }
    static {
        Bitmap.Config[] copyOf;
        int sDK_INT;
        int i;
        copyOf = new Bitmap.Config[2];
        final int i5 = 0;
        copyOf[i5] = Bitmap.Config.ARGB_8888;
        final int i6 = 1;
        copyOf[i6] = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            copyOf = Arrays.copyOf(copyOf, 3);
            (Bitmap.Config[])copyOf[length -= i6] = Bitmap.Config.RGBA_F16;
        }
        n.d = copyOf;
        n.e = copyOf;
        Bitmap.Config[] arr = new Bitmap.Config[i6];
        arr[i5] = Bitmap.Config.RGB_565;
        n.f = arr;
        Bitmap.Config[] arr2 = new Bitmap.Config[i6];
        arr2[i5] = Bitmap.Config.ARGB_4444;
        n.g = arr2;
        Bitmap.Config[] arr3 = new Bitmap.Config[i6];
        arr3[i5] = Bitmap.Config.ALPHA_8;
        n.h = arr3;
    }

    public n() {
        super();
        n.c cVar = new n.c();
        this.a = cVar;
        h hVar = new h();
        this.b = hVar;
        HashMap hashMap = new HashMap();
        this.c = hashMap;
    }

    private void f(Integer integer, Bitmap bitmap2) {
        Integer obj5;
        NavigableMap map = j(bitmap2.getConfig());
        Object obj = map.get(integer);
        if ((Integer)obj == null) {
        } else {
            int i = 1;
            if ((Integer)obj.intValue() == i) {
                map.remove(integer);
            } else {
                map.put(integer, Integer.valueOf(obj5 -= i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tried to decrement empty size, size: ");
        stringBuilder.append(integer);
        stringBuilder.append(", removed: ");
        stringBuilder.append(e(bitmap2));
        stringBuilder.append(", this: ");
        stringBuilder.append(this);
        NullPointerException nullPointerException = new NullPointerException(stringBuilder.toString());
        throw nullPointerException;
    }

    private com.bumptech.glide.load.engine.z.n.b g(int i, Bitmap.Config bitmap$Config2) {
        com.bumptech.glide.load.engine.z.n.b bVar;
        Bitmap.Config[] intValue;
        int i3;
        Bitmap.Config config;
        Object ceilingKey;
        Integer intValue2;
        int i2;
        int obj9;
        Bitmap.Config obj10;
        intValue = n.i(config2);
        i3 = 0;
        while (i3 < intValue.length) {
            config = intValue[i3];
            ceilingKey = j(config).ceilingKey(Integer.valueOf(i));
            if ((Integer)ceilingKey != null) {
                break;
            } else {
            }
            i3++;
            if ((Integer)ceilingKey.intValue() <= i * 8) {
                break;
            } else {
            }
        }
        return bVar;
    }

    static String h(int i, Bitmap.Config bitmap$Config2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(i);
        stringBuilder.append("](");
        stringBuilder.append(config2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private static Bitmap.Config[] i(Bitmap.Config bitmap$Config) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            if (Bitmap.Config.RGBA_F16.equals(config)) {
                return n.e;
            }
        }
        int i = n.a.a[config.ordinal()];
        int i3 = 1;
        if (i != i3 && i != 2 && i != 3 && i != 4) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        Bitmap.Config[] arr = new Bitmap.Config[i3];
                        arr[0] = config;
                        return arr;
                    }
                    return n.h;
                }
                return n.g;
            }
            return n.f;
        }
        return n.d;
    }

    private NavigableMap<Integer, Integer> j(Bitmap.Config bitmap$Config) {
        Object treeMap;
        Map map;
        if ((NavigableMap)this.c.get(config) == null) {
            treeMap = new TreeMap();
            this.c.put(config, treeMap);
        }
        return treeMap;
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String a(int i, int i2, Bitmap.Config bitmap$Config3) {
        return n.h(l.f(i, i2, config3), config3);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public int b(Bitmap bitmap) {
        return l.g(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public void c(Bitmap bitmap) {
        Object intValue;
        int i;
        com.bumptech.glide.load.engine.z.n.b bVar = this.a.e(l.g(bitmap), bitmap.getConfig());
        this.b.d(bVar, bitmap);
        NavigableMap obj4 = j(bitmap.getConfig());
        intValue = obj4.get(Integer.valueOf(bVar.b));
        if ((Integer)intValue == null) {
        } else {
            i += intValue;
        }
        obj4.put(Integer.valueOf(bVar.b), Integer.valueOf(i));
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public Bitmap d(int i, int i2, Bitmap.Config bitmap$Config3) {
        Object valueOf;
        valueOf = g(l.f(i, i2, config3), config3);
        Object obj = this.b.a(valueOf);
        if ((Bitmap)obj != null) {
            f(Integer.valueOf(valueOf.b), (Bitmap)obj);
            obj.reconfigure(i, i2, config3);
        }
        return obj;
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String e(Bitmap bitmap) {
        return n.h(l.g(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public Bitmap removeLast() {
        Integer valueOf;
        Object obj = this.b.f();
        if ((Bitmap)obj != null) {
            f(Integer.valueOf(l.g((Bitmap)obj)), obj);
        }
        return obj;
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String toString() {
        boolean empty;
        String str;
        boolean length;
        int str2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SizeConfigStrategy{groupedMap=");
        stringBuilder.append(this.b);
        stringBuilder.append(", sortedSizes=(");
        Iterator iterator = this.c.entrySet().iterator();
        for (Map.Entry next : iterator) {
            stringBuilder.append(next.getKey());
            stringBuilder.append('[');
            stringBuilder.append(next.getValue());
            stringBuilder.append("], ");
        }
        if (!this.c.isEmpty()) {
            stringBuilder.replace(length2 += -2, stringBuilder.length(), "");
        }
        stringBuilder.append(")}");
        return stringBuilder.toString();
    }
}
