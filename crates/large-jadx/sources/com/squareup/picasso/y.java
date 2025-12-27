package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import l.d0;

/* compiled from: RequestHandler.java */
/* loaded from: classes2.dex */
public abstract class y {

    public static final class a {

        private final t.e a;
        private final Bitmap b;
        private final d0 c;
        private final int d;
        public a(Bitmap bitmap, t.e eVar) {
            f0.d(bitmap, "bitmap == null");
            this(bitmap, null, eVar, 0);
        }

        public Bitmap a() {
            return this.b;
        }

        int b() {
            return this.d;
        }

        public t.e c() {
            return this.a;
        }

        public d0 d() {
            return this.c;
        }

        public a(d0 d0Var, t.e eVar) {
            f0.d(d0Var, "source == null");
            this(null, d0Var, eVar, 0);
        }

        a(Bitmap bitmap, d0 d0Var, t.e eVar, int i) {
            super();
            i = 1;
            i = 0;
            int r2 = bitmap != null ? 1 : i;
            if (d0Var == null) {
            }
            if (i == i) {
                throw new AssertionError();
            } else {
                this.b = bitmap;
                this.c = d0Var;
                f0.d(eVar, "loadedFrom == null");
                this.a = eVar;
                this.d = i;
                return;
            }
        }
    }
    static void a(int i, int i2, int i3, int i4, BitmapFactory.Options options, w wVar) {
        int min = 1;
        double floored2;
        double d5;
        if (!(i4 <= i2 || i3 > i)) {
            if (i2 == 0) {
                float f9 = (float)i3 / (float)i;
                floored2 = Math.floor((double)f9);
                min = (int)floored2;
            }
        }
        options.inSampleSize = min;
        options.inJustDecodeBounds = false;
    }

    static void b(int i, int i2, BitmapFactory.Options options, w wVar) {
        y.a(i, i2, options.outWidth, options.outHeight, options, wVar);
    }

    static BitmapFactory.Options d(w wVar) {
        int i = 0;
        BitmapFactory.Options options = null;
        boolean z2;
        boolean z = wVar.c();
        int r1 = wVar.s != null ? 1 : 0;
        int i2 = 0;
        if (z || wVar.s == 0 || wVar.r) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = z;
            options.inInputShareable = wVar.r;
            options.inPurgeable = wVar.r;
            if (wVar.s != 0) {
                options.inPreferredConfig = wVar.s;
            }
        }
        return options;
    }

    static boolean g(BitmapFactory.Options options) {
        boolean z = false;
        options = options.inJustDecodeBounds != null && options.inJustDecodeBounds ? 1 : 0;
        return (options.inJustDecodeBounds != null && options.inJustDecodeBounds ? 1 : 0);
    }

    public abstract boolean c(w wVar);

    int e() {
        return 0;
    }

    public abstract y.a f(w wVar, int i);

    boolean h(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    boolean i() {
        return false;
    }
}
