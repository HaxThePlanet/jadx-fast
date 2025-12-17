package com.bumptech.glide.load.resource.bitmap;

import android.os.Build.VERSION;
import com.bumptech.glide.load.g;

/* loaded from: classes.dex */
public abstract class l {

    public static final com.bumptech.glide.load.resource.bitmap.l a;
    public static final com.bumptech.glide.load.resource.bitmap.l b;
    public static final com.bumptech.glide.load.resource.bitmap.l c;
    public static final com.bumptech.glide.load.resource.bitmap.l d;
    public static final com.bumptech.glide.load.resource.bitmap.l e;
    public static final g<com.bumptech.glide.load.resource.bitmap.l> f;
    static final boolean g = false;

    public static enum e {

        MEMORY,
        QUALITY;
    }

    private static class a extends com.bumptech.glide.load.resource.bitmap.l {
        @Override // com.bumptech.glide.load.resource.bitmap.l
        public com.bumptech.glide.load.resource.bitmap.l.e a(int i, int i2, int i3, int i4) {
            int cmp;
            com.bumptech.glide.load.resource.bitmap.l.e obj3;
            if (Float.compare(f, i5) == 0) {
                obj3 = l.e.QUALITY;
            } else {
                obj3 = l.a.a(i, i2, i3, i4);
            }
            return obj3;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public float b(int i, int i2, int i3, int i4) {
            return Math.min(1065353216, l.a.b(i, i2, i3, i4));
        }
    }

    private static class b extends com.bumptech.glide.load.resource.bitmap.l {
        @Override // com.bumptech.glide.load.resource.bitmap.l
        public com.bumptech.glide.load.resource.bitmap.l.e a(int i, int i2, int i3, int i4) {
            return l.e.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public float b(int i, int i2, int i3, int i4) {
            return Math.max(obj3 /= obj1, obj1 /= obj2);
        }
    }

    private static class c extends com.bumptech.glide.load.resource.bitmap.l {
        @Override // com.bumptech.glide.load.resource.bitmap.l
        public com.bumptech.glide.load.resource.bitmap.l.e a(int i, int i2, int i3, int i4) {
            if (l.g) {
                return l.e.QUALITY;
            }
            return l.e.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public float b(int i, int i2, int i3, int i4) {
            int obj2;
            int obj3;
            if (l.g) {
                return Math.min(obj4 /= obj2, obj2 /= obj3);
            }
            obj2 = Math.max(i2 /= i4, i /= i3);
            if (obj2 == null) {
            } else {
                obj3 /= obj2;
            }
            return obj3;
        }
    }

    private static class d extends com.bumptech.glide.load.resource.bitmap.l {
        @Override // com.bumptech.glide.load.resource.bitmap.l
        public com.bumptech.glide.load.resource.bitmap.l.e a(int i, int i2, int i3, int i4) {
            return l.e.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public float b(int i, int i2, int i3, int i4) {
            return 1065353216;
        }
    }
    static {
        l.c cVar = new l.c();
        l.a = cVar;
        l.a aVar = new l.a();
        l.b = aVar;
        l.b bVar = new l.b();
        l.c = bVar;
        l.d dVar = new l.d();
        l.d = dVar;
        l.e = bVar;
        l.f = g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", bVar);
        if (Build.VERSION.SDK_INT >= 19) {
            int i = 1;
        }
        int i2 = 0;
    }

    public abstract com.bumptech.glide.load.resource.bitmap.l.e a(int i, int i2, int i3, int i4);

    public abstract float b(int i, int i2, int i3, int i4);
}
