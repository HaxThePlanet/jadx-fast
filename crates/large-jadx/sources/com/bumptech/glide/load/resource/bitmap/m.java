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
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.t.g;
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

/* loaded from: classes.dex */
public final class m {

    public static final g<b> f;
    public static final g<i> g;
    public static final g<Boolean> h;
    public static final g<Boolean> i;
    private static final Set<String> j;
    private static final com.bumptech.glide.load.resource.bitmap.m.b k;
    private static final Set<ImageHeaderParser.ImageType> l;
    private static final Queue<BitmapFactory.Options> m;
    private final e a;
    private final DisplayMetrics b;
    private final b c;
    private final List<ImageHeaderParser> d;
    private final com.bumptech.glide.load.resource.bitmap.r e;

    public interface b {
        public abstract void a(e e, Bitmap bitmap2);

        public abstract void b();
    }

    class a implements com.bumptech.glide.load.resource.bitmap.m.b {
        @Override // com.bumptech.glide.load.resource.bitmap.m$b
        public void a(e e, Bitmap bitmap2) {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m$b
        public void b() {
        }
    }
    static {
        m.f = g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", b.DEFAULT);
        m.g = g.e("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
        g gVar3 = l.f;
        Boolean fALSE = Boolean.FALSE;
        m.h = g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", fALSE);
        m.i = g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", fALSE);
        HashSet hashSet = new HashSet(Arrays.asList(/* result */));
        m.j = Collections.unmodifiableSet(hashSet);
        m.a aVar = new m.a();
        m.k = aVar;
        m.l = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        m.m = l.e(0);
    }

    public m(List<ImageHeaderParser> list, DisplayMetrics displayMetrics2, e e3, b b4) {
        super();
        this.e = r.b();
        this.d = list;
        k.d(displayMetrics2);
        this.b = (DisplayMetrics)displayMetrics2;
        k.d(e3);
        this.a = (e)e3;
        k.d(b4);
        this.c = (b)b4;
    }

    private static int a(double d) {
        int i = m.l(d);
        int i3 = m.x(d3 *= d);
        return m.x(obj4 *= d2);
    }

    private void b(com.bumptech.glide.load.resource.bitmap.s s, b b2, boolean z3, boolean z4, BitmapFactory.Options bitmapFactory$Options5, int i6, int i7) {
        ImageHeaderParser.ImageType obj7;
        b obj8;
        b obj9;
        int obj10;
        String obj12;
        String obj13;
        if (this.e.i(i6, i7, options5, z3, z4)) {
        }
        if (b2 != b.PREFER_ARGB_8888) {
            if (Build.VERSION.SDK_INT == 16) {
            } else {
                obj9 = 0;
                obj7 = s.d().hasAlpha() ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                options5.inPreferredConfig = obj7;
                if (obj7 == Bitmap.Config.RGB_565) {
                    options5.inDither = true;
                }
            }
        }
        options5.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    private static void c(ImageHeaderParser.ImageType imageHeaderParser$ImageType, com.bumptech.glide.load.resource.bitmap.s s2, com.bumptech.glide.load.resource.bitmap.m.b m$b3, e e4, com.bumptech.glide.load.resource.bitmap.l l5, int i6, int i7, int i8, int i9, int i10, BitmapFactory.Options bitmapFactory$Options11) {
        int i;
        float f;
        int string;
        Object string2;
        int i4;
        boolean z;
        boolean stringBuilder;
        boolean stringBuilder2;
        int i13;
        int round;
        ImageHeaderParser.ImageType pNG_A;
        int str;
        int str2;
        com.bumptech.glide.load.resource.bitmap.l.e cmp;
        int str3;
        int i12;
        String contains;
        int i5;
        Set floor;
        int i14;
        int i2;
        int i11;
        com.bumptech.glide.load.resource.bitmap.l.e mEMORY;
        int i3;
        string2 = imageType;
        Object obj = l5;
        str = i7;
        int i23 = i8;
        str2 = i9;
        final int i26 = i10;
        final Object obj2 = options11;
        String str17 = "]";
        contains = "Downsampler";
        String str20 = "x";
        if (str > 0) {
            if (i23 <= 0) {
            } else {
                if (m.r(i6)) {
                    i2 = str;
                    i14 = i23;
                } else {
                    i14 = str;
                    i2 = i23;
                }
                final float f6 = obj.b(i14, i2, str2, i26);
                if (Float.compare(f6, i30) <= 0) {
                } else {
                    cmp = obj.a(i14, i2, str2, i26);
                    if (cmp == null) {
                    } else {
                        i11 = (float)i14;
                        i3 = (float)i2;
                        int i24 = f6 * i3;
                        int i25 = i14 / i33;
                        int i22 = i2 / i21;
                        mEMORY = l.e.MEMORY;
                        if (cmp == mEMORY) {
                            i13 = Math.max(i25, i22);
                        } else {
                            i13 = Math.min(i25, i22);
                        }
                        int sDK_INT = Build.VERSION.SDK_INT;
                        if (sDK_INT <= 23 && m.j.contains(obj2.outMimeType)) {
                            if (m.j.contains(obj2.outMimeType)) {
                                i12 = 1;
                            } else {
                                i13 = Math.max(1, Integer.highestOneBit(i13));
                                if (cmp == mEMORY && Float.compare(f5, i5) < 0) {
                                    if (Float.compare(f5, i5) < 0) {
                                        i13 <<= 1;
                                    }
                                }
                                i12 = i13;
                            }
                        } else {
                        }
                        obj2.inSampleSize = i12;
                        str3 = 0;
                        if (string2 == ImageHeaderParser.ImageType.JPEG) {
                            float f3 = (float)i17;
                            floor = i12 / 8;
                            if (floor > 0) {
                                round /= floor;
                                string /= floor;
                            }
                        } else {
                            if (string2 != ImageHeaderParser.ImageType.PNG) {
                                if (string2 == ImageHeaderParser.ImageType.PNG_A) {
                                    f = (float)i12;
                                    round = (int)floor3;
                                    floor = Math.floor((double)i3);
                                    string = (int)floor;
                                } else {
                                    if (imageType.isWebp()) {
                                        if (sDK_INT >= 24) {
                                            float f2 = (float)i12;
                                            round = Math.round(i11 /= f2);
                                            string = Math.round(i3 /= f2);
                                        } else {
                                            f = (float)i12;
                                            round = (int)floor2;
                                            floor = Math.floor((double)i3);
                                        }
                                    } else {
                                        if (i14 % i12 == 0) {
                                            if (i2 % i12 != 0) {
                                                int[] iArr = m.m(s2, obj2, b3, e4);
                                                round = iArr[str3];
                                                string = iArr[1];
                                            } else {
                                                round = i14 / i12;
                                                string = i2 / i12;
                                            }
                                        } else {
                                        }
                                    }
                                }
                            } else {
                            }
                        }
                        double d6 = (double)f4;
                        if (sDK_INT >= 19) {
                            obj2.inTargetDensity = m.a(d6);
                            obj2.inDensity = m.l(d6);
                        }
                        if (m.s(options11)) {
                            obj2.inScaled = true;
                        } else {
                            obj2.inTargetDensity = str3;
                            obj2.inDensity = str3;
                        }
                        String str15 = str24;
                        if (Log.isLoggable(str15, 2)) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Calculate scaling, source: [");
                            stringBuilder.append(i7);
                            i11 = str23;
                            stringBuilder.append(i11);
                            stringBuilder.append(i8);
                            stringBuilder.append("], degreesToRotate: ");
                            stringBuilder.append(i6);
                            stringBuilder.append(", target: [");
                            stringBuilder.append(str2);
                            stringBuilder.append(i11);
                            stringBuilder.append(i26);
                            stringBuilder.append("], power of two scaled: [");
                            stringBuilder.append(round);
                            stringBuilder.append(i11);
                            stringBuilder.append(string);
                            stringBuilder.append("], exact scale factor: ");
                            stringBuilder.append(f6);
                            stringBuilder.append(", power of 2 sample size: ");
                            stringBuilder.append(i12);
                            stringBuilder.append(", adjusted scale factor: ");
                            stringBuilder.append(d6);
                            stringBuilder.append(", target density: ");
                            stringBuilder.append(obj2.inTargetDensity);
                            stringBuilder.append(", density: ");
                            stringBuilder.append(obj2.inDensity);
                            Log.v(str15, stringBuilder.toString());
                        }
                    }
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Cannot round with null rounding");
                    throw illegalArgumentException2;
                }
            }
            String str21 = str20;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Cannot scale with factor: ");
            stringBuilder3.append(f6);
            stringBuilder3.append(" from: ");
            stringBuilder3.append(obj);
            stringBuilder3.append(", source: [");
            stringBuilder3.append(str);
            stringBuilder3.append(str21);
            stringBuilder3.append(i23);
            stringBuilder3.append("], target: [");
            stringBuilder3.append(str2);
            stringBuilder3.append(str21);
            stringBuilder3.append(i26);
            stringBuilder3.append(str17);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder3.toString());
            throw illegalArgumentException;
        }
        String str16 = contains;
        if (Log.isLoggable(str16, 3)) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unable to determine dimensions for: ");
            stringBuilder2.append(string2);
            stringBuilder2.append(" with target [");
            stringBuilder2.append(str2);
            stringBuilder2.append(str20);
            stringBuilder2.append(i26);
            stringBuilder2.append(str17);
            Log.d(str16, stringBuilder2.toString());
        }
    }

    private u<Bitmap> e(com.bumptech.glide.load.resource.bitmap.s s, int i2, int i3, h h4, com.bumptech.glide.load.resource.bitmap.m.b m$b5) {
        boolean booleanValue;
        int i;
        final Object obj13 = this;
        booleanValue = h4;
        final Object obj14 = obj2;
        final BitmapFactory.Options factory2 = m.k();
        factory2.inTempStorage = (byte[])obj14;
        g gVar5 = m.i;
        if (booleanValue.c(gVar5) != null && (Boolean)booleanValue.c(gVar5).booleanValue()) {
            i = (Boolean)booleanValue.c(gVar5).booleanValue() ? 1 : 0;
        } else {
        }
        m.v(factory2);
        obj13.c.d(obj14);
        return e.d(this.h(s, factory2, (l)booleanValue.c(l.f), (b)booleanValue.c(m.f), (i)booleanValue.c(m.g), i, i2, i3, (Boolean)booleanValue.c(m.h).booleanValue(), b5), obj13.a);
    }

    private Bitmap h(com.bumptech.glide.load.resource.bitmap.s s, BitmapFactory.Options bitmapFactory$Options2, com.bumptech.glide.load.resource.bitmap.l l3, b b4, i i5, boolean z6, int i7, int i8, boolean z9, com.bumptech.glide.load.resource.bitmap.m.b m$b10) {
        i outColorSpace;
        ColorSpace.Named sRGB;
        int sDK_INT;
        Object obj;
        int i6;
        int string;
        int i2;
        int equals;
        int round;
        boolean inSampleSize;
        int stringBuilder;
        String str2;
        boolean i3;
        int str;
        boolean z;
        int i9;
        int i11;
        Object bVar;
        Object iVar;
        BitmapFactory.Options factory;
        int loggable;
        int i12;
        int i10;
        int i4;
        int i;
        int obj31;
        Object obj3 = this;
        BitmapFactory.Options factory2 = options2;
        com.bumptech.glide.load.resource.bitmap.m.b bVar3 = b10;
        int[] iArr = m.m(s, factory2, bVar3, obj3.a);
        i12 = 0;
        int i17 = iArr[i12];
        int i15 = 1;
        int i13 = iArr[i15];
        int i26 = -1;
        if (i17 != i26) {
            if (i13 == i26) {
                i10 = i12;
            } else {
                i10 = z6;
            }
        } else {
        }
        int i30 = s.a();
        int i29 = a0.j(i30);
        i3 = Integer.MIN_VALUE;
        int i28 = i7;
        if (i28 == i3) {
            i9 = i8;
            i4 = m.r(i29) ? i13 : i17;
        } else {
            i9 = i8;
            i4 = i28;
        }
        if (i9 == i3) {
            i = m.r(i29) ? i17 : i13;
        } else {
            i = i9;
        }
        ImageHeaderParser.ImageType imageType4 = s.d();
        final int i32 = i4;
        m.c(imageType4, s, b10, obj3.a, l3, i29, i17, i13, i32, i, options2);
        int i27 = i13;
        str = i15;
        i11 = i17;
        bVar = bVar3;
        iVar = iVar2;
        factory = factory2;
        this.b(s, b4, i10, a0.m(i30), options2, i4, i);
        sDK_INT = Build.VERSION.SDK_INT;
        i6 = sDK_INT >= 19 ? str : i12;
        round = "Downsampler";
        if (factory.inSampleSize != str) {
            if (i6 != 0) {
                obj = this;
                if (obj.z(imageType4)) {
                    if (i11 >= 0 && i27 >= 0 && z9 && i6 != 0) {
                        if (i27 >= 0) {
                            if (z9) {
                                if (i6 != 0) {
                                    str2 = round;
                                    i6 = i4;
                                    round = i;
                                } else {
                                    if (m.s(options2)) {
                                        f /= inSampleSize;
                                    } else {
                                        string = 1065353216;
                                    }
                                    inSampleSize = factory.inSampleSize;
                                    float f6 = (float)inSampleSize;
                                    equals = Math.round(f2 *= string);
                                    str2 = obj31;
                                    if (Log.isLoggable(str2, 2)) {
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append("Calculated target [");
                                        stringBuilder.append(equals);
                                        str = "x";
                                        stringBuilder.append(str);
                                        stringBuilder.append(Math.round(f4 *= string));
                                        obj31 = equals;
                                        stringBuilder.append("] for source [");
                                        stringBuilder.append(i11);
                                        stringBuilder.append(str);
                                        stringBuilder.append(i27);
                                        stringBuilder.append("], sampleSize: ");
                                        stringBuilder.append(inSampleSize);
                                        stringBuilder.append(", targetDensity: ");
                                        stringBuilder.append(factory.inTargetDensity);
                                        stringBuilder.append(", density: ");
                                        stringBuilder.append(factory.inDensity);
                                        stringBuilder.append(", density multiplier: ");
                                        stringBuilder.append(string);
                                        Log.v(str2, stringBuilder.toString());
                                    } else {
                                        obj31 = equals;
                                    }
                                    i6 = obj31;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                    if (i6 > 0 && round > 0) {
                        if (round > 0) {
                            m.y(factory, obj.a, i6, round);
                        }
                    }
                } else {
                    str2 = round;
                }
            } else {
                obj = this;
            }
        } else {
        }
        if (iVar != null) {
            if (sDK_INT >= 28) {
                outColorSpace = factory.outColorSpace;
                if (iVar == i.DISPLAY_P3 && outColorSpace != null && outColorSpace.isWideGamut()) {
                    outColorSpace = factory.outColorSpace;
                    if (outColorSpace != null) {
                        if (outColorSpace.isWideGamut()) {
                            i12 = 1;
                        }
                    }
                }
                sRGB = i12 != 0 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB;
                factory.inPreferredColorSpace = ColorSpace.get(sRGB);
            } else {
                if (sDK_INT >= 26) {
                    factory.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                }
            }
        }
        Bitmap bitmap = m.i(s, factory, bVar, obj.a);
        bVar.a(obj.a, bitmap);
        if (Log.isLoggable(str2, 2)) {
            m.t(i11, i27, factory2.outMimeType, options2, bitmap, i7, i8, g.b());
        }
        i2 = 0;
        bitmap.setDensity(displayMetrics.densityDpi);
        if (bitmap != null && !bitmap.equals(a0.n(obj.a, bitmap, i30))) {
            bitmap.setDensity(displayMetrics.densityDpi);
            if (!bitmap.equals(a0.n(obj.a, bitmap, i25))) {
                obj.a.c(bitmap);
            }
        }
        return i2;
    }

    private static Bitmap i(com.bumptech.glide.load.resource.bitmap.s s, BitmapFactory.Options bitmapFactory$Options2, com.bumptech.glide.load.resource.bitmap.m.b m$b3, e e4) {
        int i;
        int str;
        Throwable th;
        final String str3 = "Downsampler";
        if (!options2.inJustDecodeBounds) {
            b3.b();
            s.c();
        }
        int outWidth = options2.outWidth;
        final int outHeight = options2.outHeight;
        final String outMimeType = options2.outMimeType;
        a0.i().lock();
        a0.i().unlock();
        return s.b(options2);
    }

    private static String j(Bitmap bitmap) {
        String string;
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" (");
            stringBuilder.append(bitmap.getAllocationByteCount());
            stringBuilder.append(")");
            string = stringBuilder.toString();
        } else {
            string = "";
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("[");
        stringBuilder2.append(bitmap.getWidth());
        stringBuilder2.append("x");
        stringBuilder2.append(bitmap.getHeight());
        stringBuilder2.append("] ");
        stringBuilder2.append(bitmap.getConfig());
        stringBuilder2.append(string);
        return stringBuilder2.toString();
    }

    private static BitmapFactory.Options k() {
        Object options;
        final Class<com.bumptech.glide.load.resource.bitmap.m> obj = m.class;
        final Queue queue = m.m;
        synchronized (obj) {
            obj = m.class;
            queue = m.m;
        }
        options = new BitmapFactory.Options();
        m.w(options);
        return options;
    }

    private static int l(double d) {
        long obj3;
        long l = 4607182418800017408L;
        if (Double.compare(d, l) <= 0) {
        } else {
            obj3 = l / d;
        }
        return (int)obj3;
    }

    private static int[] m(com.bumptech.glide.load.resource.bitmap.s s, BitmapFactory.Options bitmapFactory$Options2, com.bumptech.glide.load.resource.bitmap.m.b m$b3, e e4) {
        final int i = 1;
        options2.inJustDecodeBounds = i;
        m.i(s, options2, b3, e4);
        int obj1 = 0;
        options2.inJustDecodeBounds = obj1;
        int[] obj3 = new int[2];
        obj3[obj1] = options2.outWidth;
        obj3[i] = options2.outHeight;
        return obj3;
    }

    private static String n(BitmapFactory.Options bitmapFactory$Options) {
        return m.j(options.inBitmap);
    }

    private static boolean r(int i) {
        int i2;
        int obj1;
        if (i != 90) {
            if (i == 270) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    private static boolean s(BitmapFactory.Options bitmapFactory$Options) {
        int obj1;
        final int inTargetDensity = options.inTargetDensity;
        obj1 = options.inDensity;
        if (inTargetDensity > 0 && obj1 > 0 && inTargetDensity != obj1) {
            obj1 = options.inDensity;
            if (obj1 > 0) {
                obj1 = inTargetDensity != obj1 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj1;
    }

    private static void t(int i, int i2, String string3, BitmapFactory.Options bitmapFactory$Options4, Bitmap bitmap5, int i6, int i7, long l8) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Decoded ");
        stringBuilder.append(m.j(bitmap5));
        stringBuilder.append(" from [");
        stringBuilder.append(i);
        String obj2 = "x";
        stringBuilder.append(obj2);
        stringBuilder.append(i2);
        stringBuilder.append("] ");
        stringBuilder.append(string3);
        stringBuilder.append(" with inBitmap ");
        stringBuilder.append(m.n(options4));
        String obj3 = " for [";
        stringBuilder.append(obj3);
        stringBuilder.append(i6);
        stringBuilder.append(obj2);
        stringBuilder.append(i7);
        stringBuilder.append("], sample size: ");
        stringBuilder.append(options4.inSampleSize);
        stringBuilder.append(", density: ");
        stringBuilder.append(options4.inDensity);
        stringBuilder.append(", target density: ");
        stringBuilder.append(options4.inTargetDensity);
        stringBuilder.append(", thread: ");
        stringBuilder.append(Thread.currentThread().getName());
        stringBuilder.append(", duration: ");
        stringBuilder.append(g.a(l8));
        Log.v("Downsampler", stringBuilder.toString());
    }

    private static IOException u(java.lang.IllegalArgumentException illegalArgumentException, int i2, int i3, String string4, BitmapFactory.Options bitmapFactory$Options5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Exception decoding bitmap, outWidth: ");
        stringBuilder.append(i2);
        stringBuilder.append(", outHeight: ");
        stringBuilder.append(i3);
        stringBuilder.append(", outMimeType: ");
        stringBuilder.append(string4);
        stringBuilder.append(", inBitmap: ");
        stringBuilder.append(m.n(options5));
        IOException iOException = new IOException(stringBuilder.toString(), illegalArgumentException);
        return iOException;
    }

    private static void v(BitmapFactory.Options bitmapFactory$Options) {
        m.w(options);
        final Queue queue = m.m;
        queue.offer(options);
        return;
        synchronized (queue) {
            m.w(options);
            queue = m.m;
            queue.offer(options);
        }
    }

    private static void w(BitmapFactory.Options bitmapFactory$Options) {
        final int i = 0;
        options.inTempStorage = i;
        final int i2 = 0;
        options.inDither = i2;
        options.inScaled = i2;
        final int i3 = 1;
        options.inSampleSize = i3;
        options.inPreferredConfig = i;
        options.inJustDecodeBounds = i2;
        options.inDensity = i2;
        options.inTargetDensity = i2;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = i;
            options.outColorSpace = i;
            options.outConfig = i;
        }
        options.outWidth = i2;
        options.outHeight = i2;
        options.outMimeType = i;
        options.inBitmap = i;
        options.inMutable = i3;
    }

    private static int x(double d) {
        return (int)obj2;
    }

    private static void y(BitmapFactory.Options bitmapFactory$Options, e e2, int i3, int i4) {
        Bitmap.Config inPreferredConfig;
        Bitmap.Config hARDWARE;
        if (Build.VERSION.SDK_INT >= 26) {
            if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            }
            inPreferredConfig = options.outConfig;
        } else {
            inPreferredConfig = 0;
        }
        if (inPreferredConfig == null) {
            inPreferredConfig = options.inPreferredConfig;
        }
        options.inBitmap = e2.e(i3, i4, inPreferredConfig);
    }

    private boolean z(ImageHeaderParser.ImageType imageHeaderParser$ImageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return 1;
        }
        return m.l.contains(imageType);
    }

    public u<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, h h4) {
        s.c cVar = new s.c(parcelFileDescriptor, this.d, this.c);
        return this.e(cVar, i2, i3, h4, m.k);
    }

    public u<Bitmap> f(InputStream inputStream, int i2, int i3, h h4, com.bumptech.glide.load.resource.bitmap.m.b m$b5) {
        s.b bVar = new s.b(inputStream, this.d, this.c);
        return this.e(bVar, i2, i3, h4, b5);
    }

    public u<Bitmap> g(ByteBuffer byteBuffer, int i2, int i3, h h4) {
        s.a aVar = new s.a(byteBuffer, this.d, this.c);
        return this.e(aVar, i2, i3, h4, m.k);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean p(InputStream inputStream) {
        return 1;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return 1;
    }
}
