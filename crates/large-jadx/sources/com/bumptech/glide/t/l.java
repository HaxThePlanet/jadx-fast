package com.bumptech.glide.t;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.m.l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class l {

    private static final char[] a;
    private static final char[] b;
    private static volatile Handler c;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            l.a.a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                l.a.a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                l.a.a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                l.a.a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                l.a.a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    static {
        l.a = "0123456789abcdef".toCharArray();
        l.b = new char[64];
    }

    private l() {
        super();
    }

    public static void a() {
        if (!l.r()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean b(Object object, Object object2) {
        boolean z3 = false;
        if (object == null) {
            object = object2 == null ? 1 : 0;
            return (object2 == null ? 1 : 0);
        }
        if ((object2 == null ? 1 : 0) instanceof l) {
            return object.a(object2);
        }
        return object.equals(object2);
    }

    public static boolean c(Object object, Object object2) {
        boolean equals = false;
        if (object == null) {
            object = object2 == null ? 1 : 0;
        } else {
            object = object.equals(object2);
        }
        return (object2 == null ? 1 : 0);
    }

    private static String d(byte[] bArr, char[] cArr) throws java.io.UnsupportedEncodingException {
        int i = 0;
        i = 0;
        while (i < bArr.length) {
            int i3 = bArr[i] & 255;
            int i5 = i * 2;
            cArr = l.a;
            cArr[i5] = cArr[i3 >>> 4];
            i2 = i5 + 1;
            cArr[i2] = cArr[i3 & 15];
            i = i + 1;
        }
        return new String(cArr);
    }

    public static <T> Queue<T> e(int i) {
        return new ArrayDeque(i);
    }

    public static int f(int i, int i2, Bitmap.Config config) {
        return (i * i2) * l.h(config);
    }

    public static int g(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Cannot obtain size for recycled Bitmap: ";
            String str2 = "[";
            int width = bitmap.getWidth();
            String str3 = "x";
            int height2 = bitmap.getHeight();
            String str4 = "] ";
            Bitmap.Config config = bitmap.getConfig();
            bitmap = str + bitmap + str2 + width + str3 + height2 + str4 + config;
            throw new IllegalStateException(bitmap);
        } else {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                } catch (java.lang.NullPointerException unused) {
                    return bitmap.getHeight() * bitmap.getRowBytes();
                }
                return bitmap.getAllocationByteCount();
            }
        }
    }

    public static int h(Bitmap.Config config) {
        int i = 8;
        Bitmap.Config config2;
        if (config == null) {
            config2 = Bitmap.Config.ARGB_8888;
        }
        int i2 = l.a.a[config2.ordinal()];
        i = 4;
        i = 2;
        i = 1;
        if (i2 == i) {
        } else {
            if (i2 == i || i2 == 3) {
            } else {
                if (i2 == 4) {
                    i = 8;
                }
            }
        }
        return i;
    }

    public static <T> List<T> i(Collection<T> collection) {
        final ArrayList arrayList = new ArrayList(collection.size());
        final Iterator it = collection.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        return arrayList;
    }

    private static Handler j() {
        Handler handler2;
        Looper mainLooper;
        if (l.c == null) {
            handler = l.class;
            synchronized (handler) {
                try {
                    if (l.c == null) {
                        l.c = new Handler(Looper.getMainLooper());
                    }
                } catch (Throwable th) {
                }
            }
        }
        return l.c;
    }

    public static int k(float f) {
        return l.l(f, 17);
    }

    public static int l(float f, int i) {
        return l.n(Float.floatToIntBits(f), i);
    }

    public static int m(int i) {
        return l.n(i, 17);
    }

    public static int o(Object object, int i) {
        if (object == null) {
            i = 0;
        } else {
            i = object.hashCode();
        }
        return l.n(i, i);
    }

    public static int p(boolean z, int i) {
        return l.n(z, i);
    }

    public static boolean q() {
        return !l.r();
    }

    public static boolean r() {
        boolean z = true;
        int r0 = Looper.myLooper() == Looper.getMainLooper() ? 1 : 0;
        return (Looper.myLooper() == Looper.getMainLooper() ? 1 : 0);
    }

    public static boolean t(int i, int i2) {
        boolean z2 = false;
        i = l.s(i) && l.s(i2) ? 1 : 0;
        return (l.s(i) && l.s(i2) ? 1 : 0);
    }

    public static void u(Runnable runnable) {
        l.j().post(runnable);
    }

    public static void v(Runnable runnable) {
        l.j().removeCallbacks(runnable);
    }

    public static String w(byte[] bArr) {
        final char[] cArr = l.b;
        synchronized (cArr) {
            try {
                return l.d(bArr, cArr);
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public static int n(int i, int i2) {
        return (i2 * 31) + i;
    }

    private static boolean s(int i) {
        int i2 = -2147483648;
        boolean z = false;
        if (i > 0 || i == Integer.MIN_VALUE) {
            int i4 = 1;
        }
        return z;
    }
}
