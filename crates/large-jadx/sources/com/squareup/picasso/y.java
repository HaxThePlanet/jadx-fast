package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import l.d0;

/* loaded from: classes2.dex */
public abstract class y {

    public static final class a {

        private final com.squareup.picasso.t.e a;
        private final Bitmap b;
        private final d0 c;
        private final int d;
        public a(Bitmap bitmap, com.squareup.picasso.t.e t$e2) {
            f0.d(bitmap, "bitmap == null");
            super((Bitmap)bitmap, 0, e2, 0);
        }

        a(Bitmap bitmap, d0 d02, com.squareup.picasso.t.e t$e3, int i4) {
            int i2;
            int i;
            super();
            final int i3 = 0;
            i = bitmap != null ? i2 : i3;
            if (d02 != null) {
            } else {
                i2 = i3;
            }
            if (i == i2) {
            } else {
                this.b = bitmap;
                this.c = d02;
                f0.d(e3, "loadedFrom == null");
                this.a = (t.e)e3;
                this.d = i4;
            }
            AssertionError obj4 = new AssertionError();
            throw obj4;
        }

        public a(d0 d0, com.squareup.picasso.t.e t$e2) {
            f0.d(d0, "source == null");
            super(0, (d0)d0, e2, 0);
        }

        public Bitmap a() {
            return this.b;
        }

        int b() {
            return this.d;
        }

        public com.squareup.picasso.t.e c() {
            return this.a;
        }

        public d0 d() {
            return this.c;
        }
    }
    static void a(int i, int i2, int i3, int i4, BitmapFactory.Options bitmapFactory$Options5, com.squareup.picasso.w w6) {
        double floor;
        int obj2;
        int obj3;
        boolean obj4;
        int obj5;
        if (i4 <= i2) {
            if (i3 > i) {
                if (i2 == 0) {
                    obj3 /= obj2;
                    obj2 = Math.floor((double)obj3);
                    obj2 = (int)obj2;
                } else {
                }
            } else {
                obj2 = 1;
            }
        } else {
        }
        options5.inSampleSize = obj2;
        options5.inJustDecodeBounds = false;
    }

    static void b(int i, int i2, BitmapFactory.Options bitmapFactory$Options3, com.squareup.picasso.w w4) {
        y.a(i, i2, options3.outWidth, options3.outHeight, options3, w4);
    }

    static BitmapFactory.Options d(com.squareup.picasso.w w) {
        boolean z2;
        int i;
        BitmapFactory.Options options;
        boolean z;
        Object obj4;
        z2 = w.c();
        i = w.s != null ? 1 : 0;
        options = 0;
        if (!z2 && i == 0) {
            if (i == 0) {
                options = new BitmapFactory.Options();
                options.inJustDecodeBounds = z2;
                z2 = w.r;
                options.inInputShareable = z2;
                options.inPurgeable = z2;
                if (w.r && i != 0) {
                    options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = z2;
                    z2 = w.r;
                    options.inInputShareable = z2;
                    options.inPurgeable = z2;
                    if (i != 0) {
                        options.inPreferredConfig = w.s;
                    }
                }
            } else {
            }
        } else {
        }
        return options;
    }

    static boolean g(BitmapFactory.Options bitmapFactory$Options) {
        Object obj0;
        if (options != null && options.inJustDecodeBounds) {
            obj0 = options.inJustDecodeBounds ? 1 : 0;
        } else {
        }
        return obj0;
    }

    public abstract boolean c(com.squareup.picasso.w w);

    int e() {
        return 0;
    }

    public abstract com.squareup.picasso.y.a f(com.squareup.picasso.w w, int i2);

    boolean h(boolean z, NetworkInfo networkInfo2) {
        return 0;
    }

    boolean i() {
        return 0;
    }
}
