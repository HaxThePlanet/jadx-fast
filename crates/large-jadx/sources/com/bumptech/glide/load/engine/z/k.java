package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class k implements com.bumptech.glide.load.engine.z.e {

    private static final Bitmap.Config j;
    private final com.bumptech.glide.load.engine.z.l a;
    private final Set<Bitmap.Config> b;
    private final com.bumptech.glide.load.engine.z.k.a c;
    private long d;
    private long e;
    private int f;
    private int g;
    private int h;
    private int i;

    private interface a {
        public abstract void a(Bitmap bitmap);

        public abstract void b(Bitmap bitmap);
    }

    private static final class b implements com.bumptech.glide.load.engine.z.k.a {
        @Override // com.bumptech.glide.load.engine.z.k$a
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.z.k$a
        public void b(Bitmap bitmap) {
        }
    }
    static {
        k.j = Bitmap.Config.ARGB_8888;
    }

    public k(long l) {
        super(l, obj4, k.l(), k.k());
    }

    k(long l, com.bumptech.glide.load.engine.z.l l2, Set<Bitmap.Config> set3) {
        super();
        this.d = l;
        this.a = set3;
        this.b = obj4;
        k.b obj1 = new k.b();
        this.c = obj1;
    }

    private static void f(Bitmap.Config bitmap$Config) {
        if (Build.VERSION.SDK_INT < 26) {
        }
        if (config == Bitmap.Config.HARDWARE) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot create a mutable Bitmap with config: ");
        stringBuilder.append(config);
        stringBuilder.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private static Bitmap g(int i, int i2, Bitmap.Config bitmap$Config3) {
        Bitmap.Config obj2;
        if (config3 != null) {
        } else {
            obj2 = k.j;
        }
        return Bitmap.createBitmap(i, i2, obj2);
    }

    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    private void i() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hits=");
        stringBuilder.append(this.f);
        stringBuilder.append(", misses=");
        stringBuilder.append(this.g);
        stringBuilder.append(", puts=");
        stringBuilder.append(this.h);
        stringBuilder.append(", evictions=");
        stringBuilder.append(this.i);
        stringBuilder.append(", currentSize=");
        stringBuilder.append(this.e);
        stringBuilder.append(", maxSize=");
        stringBuilder.append(this.d);
        stringBuilder.append("\nStrategy=");
        stringBuilder.append(this.a);
        Log.v("LruBitmapPool", stringBuilder.toString());
    }

    private void j() {
        q(this.d);
    }

    private static Set<Bitmap.Config> k() {
        int hARDWARE;
        int i;
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hARDWARE = Build.VERSION.SDK_INT;
        if (hARDWARE >= 19) {
            hashSet.add(0);
        }
        if (hARDWARE >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static com.bumptech.glide.load.engine.z.l l() {
        Object nVar;
        if (Build.VERSION.SDK_INT >= 19) {
            nVar = new n();
        } else {
            nVar = new c();
        }
        return nVar;
    }

    private Bitmap m(int i, int i2, Bitmap.Config bitmap$Config3) {
        Bitmap.Config config;
        com.bumptech.glide.load.engine.z.k.a aVar;
        boolean loggable;
        boolean loggable2;
        int string;
        int stringBuilder;
        long l;
        int obj6;
        k.f(config3);
        synchronized (this) {
            try {
                config = config3;
                config = k.j;
                Bitmap bitmap = this.a.d(i, i2, config);
                if (bitmap == null) {
                } else {
                }
                if (Log.isLoggable("LruBitmapPool", 3)) {
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Missing bitmap=");
                stringBuilder2.append(this.a.a(i, i2, config3));
                Log.d("LruBitmapPool", stringBuilder2.toString());
                this.g = i6++;
                this.f = i3++;
                this.e = l2 -= l;
                this.c.a(bitmap);
                k.p(bitmap);
                if (Log.isLoggable("LruBitmapPool", 2)) {
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Get bitmap=");
                stringBuilder.append(this.a.a(i, i2, config3));
                Log.v("LruBitmapPool", stringBuilder.toString());
                h();
                return bitmap;
                throw i;
            }
        }
    }

    private static void o(Bitmap bitmap) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        k.o(bitmap);
    }

    private void q(long l) {
        Bitmap last;
        boolean loggable;
        int string;
        long l2;
        boolean obj6;
        int obj7;
        synchronized (this) {
            try {
                while (Long.compare(l3, l) > 0) {
                    last = this.a.removeLast();
                    this.c.a(last);
                    this.e = l4 -= l2;
                    this.i = i2++;
                    if (Log.isLoggable("LruBitmapPool", 3)) {
                    }
                    h();
                    last.recycle();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Evicting bitmap=");
                    stringBuilder.append(this.a.e(last));
                    Log.d("LruBitmapPool", stringBuilder.toString());
                }
                last = this.a.removeLast();
                if (last == null) {
                } else {
                }
                if (Log.isLoggable("LruBitmapPool", 5)) {
                }
                Log.w("LruBitmapPool", "Size mismatch, resetting");
                i();
                this.e = 0;
                this.c.a(last);
                this.e = l4 -= l2;
                this.i = i2++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Evicting bitmap=");
                stringBuilder.append(this.a.e(last));
                Log.d("LruBitmapPool", stringBuilder.toString());
                h();
                last.recycle();
                throw l;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public void a(int i) {
        int sDK_INT;
        boolean loggable;
        String str;
        String str2 = "LruBitmapPool";
        if (Log.isLoggable(str2, 3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("trimMemory, level=");
            stringBuilder.append(i);
            Log.d(str2, stringBuilder.toString());
        }
        if (i < 40) {
            loggable = 23;
            str = 20;
            if (Build.VERSION.SDK_INT >= loggable && i >= str) {
                if (i >= str) {
                    b();
                } else {
                    if (i < str) {
                        if (i == 15) {
                            q(l /= str);
                        }
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public void b() {
        boolean loggable;
        String str = "LruBitmapPool";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "clearMemory");
        }
        q(0);
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public void c(Bitmap bitmap) {
        boolean loggable;
        boolean contains2;
        boolean loggable2;
        int stringBuilder;
        int i;
        long contains;
        Bitmap.Config config;
        long l;
        Object obj7;
        synchronized (this) {
            if (bitmap.isRecycled()) {
            } else {
                stringBuilder = 2;
                if (bitmap.isMutable() && Long.compare(contains, l) <= 0) {
                    try {
                        if (Long.compare(contains, l) <= 0) {
                        }
                        if (!this.b.contains(bitmap.getConfig())) {
                        } else {
                        }
                        this.a.c(bitmap);
                        this.c.b(bitmap);
                        this.h = i4++;
                        this.e = l2 += l3;
                        if (Log.isLoggable("LruBitmapPool", stringBuilder)) {
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Put bitmap in pool=");
                        stringBuilder.append(this.a.e(bitmap));
                        Log.v("LruBitmapPool", stringBuilder.toString());
                        h();
                        j();
                        if (Log.isLoggable("LruBitmapPool", stringBuilder)) {
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Reject bitmap from pool, bitmap: ");
                        stringBuilder2.append(this.a.e(bitmap));
                        stringBuilder2.append(", is mutable: ");
                        stringBuilder2.append(bitmap.isMutable());
                        stringBuilder2.append(", is allowed config: ");
                        stringBuilder2.append(this.b.contains(bitmap.getConfig()));
                        Log.v("LruBitmapPool", stringBuilder2.toString());
                        bitmap.recycle();
                        obj7 = new IllegalStateException("Cannot pool recycled bitmap");
                        throw obj7;
                        obj7 = new NullPointerException("Bitmap must not be null");
                        throw obj7;
                        throw bitmap;
                    }
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public Bitmap d(int i, int i2, Bitmap.Config bitmap$Config3) {
        Bitmap bitmap;
        int obj2;
        bitmap = m(i, i2, config3);
        if (bitmap != null) {
            bitmap.eraseColor(0);
        } else {
            bitmap = k.g(i, i2, config3);
        }
        return bitmap;
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public Bitmap e(int i, int i2, Bitmap.Config bitmap$Config3) {
        Bitmap bitmap;
        if (m(i, i2, config3) == null) {
            bitmap = k.g(i, i2, config3);
        }
        return bitmap;
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public long n() {
        return this.d;
    }
}
