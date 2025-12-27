package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.l;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

/* compiled from: Downsampler.java */
/* loaded from: classes.dex */
public final class m {

    public static final com.bumptech.glide.load.g<com.bumptech.glide.load.b> f;
    public static final com.bumptech.glide.load.g<i> g;
    public static final com.bumptech.glide.load.g<Boolean> h;
    public static final com.bumptech.glide.load.g<Boolean> i;
    private static final Set<String> j;
    private static final m.b k = new m$a();
    private static final Set<ImageHeaderParser.ImageType> l;
    private static final Queue<BitmapFactory.Options> m;
    private final e a;
    private final DisplayMetrics b;
    private final com.bumptech.glide.load.engine.z.b c;
    private final List<ImageHeaderParser> d;
    private final r e;

    public interface b {
        void a(e eVar, Bitmap bitmap);

        void b();
    }

    class a implements m.b {
        a() {
            super();
        }

        public void a(e eVar, Bitmap bitmap) {
        }

        public void b() {
        }
    }
    static {
        m.f = g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", b.DEFAULT);
        m.g = g.e("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
        Boolean fALSE2 = Boolean.FALSE;
        m.h = g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", fALSE2);
        m.i = g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", fALSE2);
        m.j = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "image/vnd.wap.wbmp", "image/x-ico" })));
        m.l = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        m.m = l.e(0);
    }

    public m(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, e eVar, com.bumptech.glide.load.engine.z.b bVar) {
        super();
        this.e = r.b();
        this.d = list;
        k.d(displayMetrics);
        this.b = displayMetrics;
        k.d(eVar);
        this.a = eVar;
        k.d(bVar);
        this.c = bVar;
    }

    private static int a(double d) {
        int i = m.l(d);
        int i2 = m.x((double)i * d);
        return m.x((d / (double)(float)i2 / (float)i) * (double)i2);
    }

    private void b(s sVar, com.bumptech.glide.load.b bVar, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        Bitmap.Config config;
        if (this.e.i(i, i2, options, z, z2)) {
            return;
        }
        if (bVar != b.PREFER_ARGB_8888) {
            i = 16;
            if (Build.VERSION.SDK_INT != 16) {
                try {
                } catch (java.io.IOException ioException) {
                    z2 = 3;
                    i = "Downsampler";
                    z2 = Log.isLoggable(i, z2);
                }
                ioException = sVar.d().hasAlpha() ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                options.inPreferredConfig = ioException;
                if (ioException == Bitmap.Config.RGB_565) {
                    options.inDither = true;
                }
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    private static void c(ImageHeaderParser.ImageType imageType, s sVar, m.b bVar, e eVar, l lVar, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) {
        int rounded;
        int max;
        int rounded2;
        com.bumptech.glide.load.resource.bitmap.l.e eVar2;
        Set set;
        double floored;
        int i72;
        float f2;
        float f3;
        imageType2 = imageType;
        String lVar52 = lVar;
        i72 = i2;
        i72 = i3;
        i92 = i4;
        final int i102 = i5;
        final BitmapFactory.Options options112 = options;
        String str18 = "]";
        str = "Downsampler";
        String str2 = "x";
        if (Log.isLoggable(str, 3)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str14 = "Unable to determine dimensions for: ";
            String str9 = " with target [";
            str10 = str14 + imageType2 + str9 + i92 + str2 + i102 + str18;
            Log.d(str, str10);
        }
    }

    private u<Bitmap> e(s sVar, int i, int i2, h hVar, m.b bVar) {
        final Object sVar3 = this;
        hVar42 = hVar;
        final BitmapFactory.Options options = m.k();
        options.inTempStorage = obj;
        com.bumptech.glide.load.g gVar5 = m.i;
        if (hVar42.c(gVar5) != null) {
            Throwable th = (Boolean)hVar42.c(m.i).booleanValue() ? 1 : 0;
        }
        try {
        } finally {
            m.v(options2);
            obj9.c.d(obj10);
            throw ((Boolean)hVar42.c(m.i).booleanValue() ? 1 : 0);
        }
        m.v(options);
        sVar3.c.d(obj);
        return e.d(this.h(sVar, options, (l)hVar42.c(l.f), (b)hVar42.c(m.f), (i)hVar42.c(m.g), ((Boolean)hVar42.c(m.i).booleanValue() ? 1 : 0), i, i2, (Boolean)hVar42.c(m.h).booleanValue(), bVar), sVar3.a);
    }

    private Bitmap h(s sVar, BitmapFactory.Options options, l lVar, com.bumptech.glide.load.b bVar, i iVar, boolean z, int i, int i2, boolean z2, m.b bVar2) {
        ColorSpace.Named sRGB2;
        Object obj;
        int bVar42;
        boolean equals;
        String bVar44;
        obj = this;
        BitmapFactory.Options options22 = options;
        com.bumptech.glide.load.resource.bitmap.m.b bVar102 = bVar2;
        int[] iArr = m.m(sVar, options22, bVar102, obj.a);
        bVar42 = 0;
        bVar42 = iArr[bVar42];
        bVar42 = 1;
        bVar42 = iArr[bVar42];
        int i10 = -1;
        if (bVar42 == i10 || bVar42 == i10) {
        }
        int i3 = sVar.a();
        int i13 = a0.j(i3);
        int i11 = Integer.MIN_VALUE;
        bVar42 = i;
        if (bVar42 == Integer.MIN_VALUE) {
            bVar42 = i2;
            int r25 = bVar42;
        } else {
            bVar42 = i2;
        }
        if (bVar42 == Integer.MIN_VALUE) {
            int r26 = bVar42;
        } else {
        }
        ImageHeaderParser.ImageType z62 = sVar.d();
        m.c(z62, sVar, bVar2, obj.a, lVar, i13, bVar42, bVar42, bVar42, bVar42, options);
        this.b(sVar, bVar, bVar42, a0.m(i3), options, bVar42, bVar42);
        sDK_INT2 = Build.VERSION.SDK_INT;
        int r2 = bVar42;
        bVar44 = "Downsampler";
        if (!(options22.inSampleSize != Integer.MIN_VALUE || bVar42 != 0)) {
            obj = this;
            if (obj.z(z62)) {
                if (obj.a < 0 || obj.a < 0 || !z2 || bVar42 == 0) {
                    if (m.s(options)) {
                        float f2 = (float)options22.inTargetDensity / (float)options22.inDensity;
                    } else {
                        i = 1065353216;
                    }
                    float f12 = (float)inSampleSize22;
                    double ceiled = Math.ceil((double)(float)bVar42 / f12);
                    double ceiled2 = Math.ceil((double)(float)bVar42 / f12);
                    bVar42 = Math.round((float)ceiled * i);
                    bVar42 = Math.round((float)ceiled2 * i);
                    bVar42 = 2;
                    if (Log.isLoggable(bVar44, bVar42)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str7 = "Calculated target [";
                        String str8 = "x";
                        String str2 = "] for source [";
                        String str3 = "], sampleSize: ";
                        String str4 = ", targetDensity: ";
                        String str5 = ", density: ";
                        String str6 = ", density multiplier: ";
                        str = str7 + bVar42 + str8 + bVar42 + str2 + bVar42 + str8 + bVar42 + str3 + options22.inSampleSize + str4 + options22.inTargetDensity + str5 + options22.inDensity + str6 + i;
                        Log.v(bVar44, str);
                    } else {
                    }
                } else {
                    bVar42 = r26;
                }
                if (bVar42 > 0 && bVar42 > 0) {
                    m.y(options22, obj.a, bVar42, bVar42);
                }
            } else {
            }
        }
        if (iVar52 != null && Build.VERSION.SDK_INT >= 28 && iVar52 == i.DISPLAY_P3) {
            if (options22.outColorSpace != null && options22.outColorSpace.isWideGamut()) {
                bVar42 = 1;
            }
            ColorSpace.Named r0 = bVar42 != 0 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB;
            options22.inPreferredColorSpace = (bVar42 != 0 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        }
        Bitmap bitmap = m.i(sVar, options22, bVar102, obj.a);
        bVar102.a(obj.a, bitmap);
        if (Log.isLoggable(bVar44, 2)) {
            m.t(bVar42, bVar42, options22.outMimeType, options, bitmap, i, i2, g.b());
        }
        i2 = 0;
        if (bitmap != null) {
            bitmap.setDensity(obj.b.densityDpi);
            if (!bitmap.equals(a0.n(obj.a, bitmap, i3))) {
                obj.a.c(bitmap);
            }
        }
        return i2;
    }

    private static Bitmap i(s sVar, BitmapFactory.Options options, m.b bVar, e eVar) {
        int i;
        int str3;
        if (!options.inJustDecodeBounds) {
            bVar.b();
            sVar.c();
        }
        a0.i().lock();
        try {
        } catch (Throwable th) {
        }
        a0.i().unlock();
        return sVar.b(options);
    }

    private static String j(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = " (";
            int allocationByteCount = bitmap.getAllocationByteCount();
            str2 = ")";
            str = str3 + allocationByteCount + str2;
        } else {
            str = "";
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        String str4 = "[";
        int width = bitmap.getWidth();
        String str5 = "x";
        int height = bitmap.getHeight();
        String str6 = "] ";
        Bitmap.Config config = bitmap.getConfig();
        str7 = str4 + width + str5 + height + str6 + config + str;
        return str7;
    }

    private static synchronized BitmapFactory.Options k() {
        Object poll;
        final Class<com.bumptech.glide.load.resource.bitmap.m> obj2 = m.class;
        try {
            final Queue queue = m.m;
        } catch (Throwable th) {
        }
        try {
        } catch (Throwable th) {
        }
        if ((BitmapFactory.Options)queue.poll() == null) {
            try {
                m.w(new BitmapFactory.Options());
            } catch (Throwable th) {
            }
        }
        return poll;
    }

    private static int l(double d) {
        double d2;
        double d3 = 1d;
        if (d > d3) {
            d2 = d3 / d;
        }
        return (int)(Math.round(d2 * 2147483647d));
    }

    private static int[] m(s sVar, BitmapFactory.Options options, m.b bVar, e eVar) {
        final boolean z = true;
        options.inJustDecodeBounds = z;
        m.i(sVar, options, bVar, eVar);
        boolean z2 = false;
        options.inJustDecodeBounds = z2;
        int[] iArr = new int[2];
        iArr[z2] = options.outWidth;
        iArr[z] = options.outHeight;
        return iArr;
    }

    private static String n(BitmapFactory.Options options) {
        return m.j(options.inBitmap);
    }

    private static boolean s(BitmapFactory.Options options) {
        boolean z = true;
        options = options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity ? 1 : 0;
        return (options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity ? 1 : 0);
    }

    private static void t(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        final StringBuilder stringBuilder = new StringBuilder();
        str = "Decoded ";
        String str15 = m.j(bitmap);
        String str16 = " from [";
        String str2 = "x";
        String str10 = "] ";
        String str11 = " with inBitmap ";
        String str12 = m.n(options);
        String str13 = " for [";
        String str4 = "], sample size: ";
        String str5 = ", density: ";
        String str6 = ", target density: ";
        String str7 = ", thread: ";
        String name = Thread.currentThread().getName();
        String str8 = ", duration: ";
        double d = g.a(j);
        str9 = str + str15 + str16 + i + str2 + i2 + str10 + str + str11 + str12 + str13 + i3 + str2 + i4 + str4 + options.inSampleSize + str5 + options.inDensity + str6 + options.inTargetDensity + str7 + name + str8 + d;
        Log.v("Downsampler", str9);
    }

    private static IOException u(java.lang.IllegalArgumentException exc, int i, int i2, String str, BitmapFactory.Options options) {
        final StringBuilder stringBuilder = new StringBuilder();
        str = "Exception decoding bitmap, outWidth: ";
        String str2 = ", outHeight: ";
        String str3 = ", outMimeType: ";
        String str5 = ", inBitmap: ";
        String str6 = m.n(options);
        i = str + i + str2 + i2 + str3 + str + str5 + str6;
        return new IOException(i, exc);
    }

    private static void v(BitmapFactory.Options options) {
        m.w(options);
        final Queue queue = m.m;
        synchronized (queue) {
            try {
                queue.offer(options);
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    private static void w(BitmapFactory.Options options) {
        final byte[] bArr = null;
        options.inTempStorage = bArr;
        final boolean z = false;
        options.inDither = z;
        options.inScaled = z;
        final int i = 1;
        options.inSampleSize = i;
        options.inPreferredConfig = bArr;
        options.inJustDecodeBounds = z;
        options.inDensity = z;
        options.inTargetDensity = z;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = bArr;
            options.outColorSpace = bArr;
            options.outConfig = bArr;
        }
        options.outWidth = z;
        options.outHeight = z;
        options.outMimeType = bArr;
        options.inBitmap = bArr;
        options.inMutable = true;
    }

    private static void y(BitmapFactory.Options options, e eVar, int i, int i2) {
        Bitmap.Config inPreferredConfig2 = null;
        if (Build.VERSION.SDK_INT >= 26) {
            if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
                return;
            }
        } else {
            i = 0;
        }
        if (options.outConfig == null) {
        }
        options.inBitmap = eVar.e(i, i2, inPreferredConfig2);
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return m.l.contains(imageType);
    }

    public u<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, h hVar) {
        return this.e(new s.c(parcelFileDescriptor, this.d, this.c), i, i2, hVar, m.k);
    }

    public u<Bitmap> f(InputStream inputStream, int i, int i2, h hVar, m.b bVar) {
        return this.e(new s.b(inputStream, this.d, this.c), i, i2, hVar, bVar);
    }

    public u<Bitmap> g(ByteBuffer byteBuffer, int i, int i2, h hVar) {
        return this.e(new s.a(byteBuffer, this.d, this.c), i, i2, hVar, m.k);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    private static boolean r(int i) {
        int i2 = 90;
        boolean z = false;
        i2 = 90;
        if (i == 90 || i == 270) {
            int i4 = 1;
        }
        return z;
    }

    private static int x(double d) {
        return (int)(d + 0.5d);
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }
}
