package com.bumptech.glide.load.resource.bitmap;

import android.os.Build.VERSION;
import com.bumptech.glide.load.g;

/* compiled from: DownsampleStrategy.java */
/* loaded from: classes.dex */
public abstract class l {

    public static final l a = new l$c();
    public static final l b = new l$a();
    public static final l c = new l$b();
    public static final l d = new l$d();
    public static final l e = new l$b();
    public static final g<l> f;
    static final boolean g = false;

    public enum e {

        MEMORY,
        QUALITY;
    }

    private static class a extends l {
        a() {
            super();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public l.e a(int i, int i2, int i3, int i4) {
            com.bumptech.glide.load.resource.bitmap.l.e qUALITY2;
            float f = b(i, i2, i3, i4);
            if (f == 1065353216) {
                qUALITY2 = l.e.QUALITY;
            } else {
                qUALITY2 = l.a.a(i, i2, i3, i4);
            }
            return qUALITY2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public float b(int i, int i2, int i3, int i4) {
            return Math.min(1f, l.a.b(i, i2, i3, i4));
        }
    }

    private static class b extends l {
        b() {
            super();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public l.e a(int i, int i2, int i3, int i4) {
            return l.e.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public float b(int i, int i2, int i3, int i4) {
            return Math.max((float)i3 / (float)i, (float)i4 / (float)i2);
        }
    }

    private static class c extends l {
        c() {
            super();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public l.e a(int i, int i2, int i3, int i4) {
            if (l.g) {
                return l.e.QUALITY;
            }
            return l.e.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public float b(int i, int i2, int i3, int i4) {
            float f = 1065353216;
            if (l.g) {
                return Math.min((float)i3 / (float)i, (float)i4 / (float)i2);
            }
            int max = Math.max(i2 / i4, i / i3);
            f = 1f;
            if (max != 0) {
                f = 1f / (float)Integer.highestOneBit(max);
            }
            return f;
        }
    }

    private static class d extends l {
        d() {
            super();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public l.e a(int i, int i2, int i3, int i4) {
            return l.e.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public float b(int i, int i2, int i3, int i4) {
            return 1065353216;
        }
    }
    static {
        l.f = g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", obj);
        Object obj = Build.VERSION.SDK_INT >= 19 ? 1 : 0;
    }

    public abstract l.e a(int i, int i2, int i3, int i4);

    public abstract float b(int i, int i2, int i3, int i4);
}
