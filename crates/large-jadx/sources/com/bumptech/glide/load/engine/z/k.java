package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool.java */
/* loaded from: classes.dex */
public class k implements e {

    private static final Bitmap.Config j;
    private final l a;
    private final Set<Bitmap.Config> b;
    private final k.a c;
    private long d;
    private long e;
    private int f;
    private int g;
    private int h;
    private int i;

    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    private static final class b implements k.a {
        b() {
            super();
        }

        public void a(Bitmap bitmap) {
        }

        public void b(Bitmap bitmap) {
        }
    }
    static {
        k.j = Bitmap.Config.ARGB_8888;
    }

    k(long j, l lVar, Set<Bitmap.Config> set) {
        super();
        this.d = j;
        this.a = lVar;
        this.b = set;
        this.c = new k.b();
    }

    private static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (config == Bitmap.Config.HARDWARE) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Cannot create a mutable Bitmap with config: ";
            String str2 = ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions";
            config = str + config + str2;
            throw new IllegalArgumentException(config);
        }
    }

    private static Bitmap g(int i, int i2, Bitmap.Config config) {
        if (config == null) {
            config = k.j;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    private void i() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Hits=";
        String str3 = ", misses=";
        String str4 = ", puts=";
        String str5 = ", evictions=";
        String str6 = ", currentSize=";
        String str7 = ", maxSize=";
        String str8 = "\nStrategy=";
        str = str2 + this.f + str3 + this.g + str4 + this.h + str5 + this.i + str6 + this.e + str7 + this.d + str8 + this.a;
        Log.v("LruBitmapPool", str);
    }

    private void j() {
        q(this.d);
    }

    private static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        sDK_INT2 = Build.VERSION.SDK_INT;
        int i = 19;
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l l() {
        com.bumptech.glide.load.engine.z.n nVar;
        n r0 = Build.VERSION.SDK_INT >= 19 ? new n() : new c();
        return (Build.VERSION.SDK_INT >= 19 ? new n() : new c());
    }

    private synchronized Bitmap m(int i, int i2, Bitmap.Config config) {
        Bitmap.Config config32;
        int i4 = 3;
        String str;
        k.f(config);
        Bitmap.Config r1 = config != null ? config : k.j;
        Bitmap bitmap = this.a.d(i, i2, (config != null ? config : k.j));
        if (bitmap == null) {
            i4 = 3;
            if (Log.isLoggable("LruBitmapPool", i4)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str9 = "Missing bitmap=";
                str = this.a.a(i, i2, config);
                str7 = str9 + str;
                Log.d("LruBitmapPool", str7);
            }
            this.g++;
        } else {
            this.f++;
            this.e -= l3;
            this.c.a(bitmap);
            k.p(bitmap);
        }
        int i5 = 2;
        if (Log.isLoggable("LruBitmapPool", i5)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str8 = "Get bitmap=";
            String str10 = this.a.a(i, i2, config);
            str2 = str8 + str10;
            Log.v("LruBitmapPool", str2);
        }
        h();
        return bitmap;
    }

    private static void o(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        k.o(bitmap);
    }

    private synchronized void q(long j) {
        boolean loggable;
        int i = 3;
        long l;
        while (this.e > j) {
            Bitmap last = this.a.removeLast();
            if (last == null) {
                int i2 = 5;
            }
        }
    }

    public void a(int i) {
        int sDK_INT2 = 40;
        boolean loggable;
        String str;
        String str2 = "LruBitmapPool";
        if (Log.isLoggable(str2, 3)) {
            StringBuilder stringBuilder = new StringBuilder();
            str = "trimMemory, level=";
            str3 = str + i;
            Log.d(str2, str3);
        }
        sDK_INT2 = 40;
        if (i < 40) {
            int i2 = 23;
            int i3 = 20;
            if (Build.VERSION.SDK_INT < i2 || i < i3) {
                if (i >= i3 || i == 15) {
                    q(n() / 2L);
                }
            } else {
                b();
            }
        }
    }

    public void b() {
        boolean loggable;
        String str = "LruBitmapPool";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "clearMemory");
        }
        q(0L);
    }

    public synchronized void c(Bitmap bitmap) {
        long l;
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else {
            try {
                int i = 2;
                l = (long)this.a.b(bitmap);
                this.a.c(bitmap);
                this.c.b(bitmap);
                this.h++;
                this.e += l5;
                if (Log.isLoggable("LruBitmapPool", i)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str9 = "Put bitmap in pool=";
                    String str14 = this.a.e(bitmap);
                    str = str9 + str14;
                    Log.v("LruBitmapPool", str);
                }
                h();
                j();
            } catch (Throwable unused) {
            }
            try {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public Bitmap d(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap;
        bitmap = m(i, i2, config);
        if (bitmap != null) {
            int i3 = 0;
            bitmap.eraseColor(i3);
        } else {
            bitmap = k.g(i, i2, config);
        }
        return bitmap;
    }

    public Bitmap e(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap;
        if (m(i, i2, config) == null) {
            bitmap = k.g(i, i2, config);
        }
        return bitmap;
    }

    public long n() {
        return this.d;
    }

    public k(long j) {
        this(j, r4, k.l(), k.k());
    }
}
