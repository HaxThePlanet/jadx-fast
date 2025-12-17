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

/* loaded from: classes.dex */
public final class l {

    private static final char[] a;
    private static final char[] b;
    private static volatile Handler c;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            l.a.a = iArr;
            iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            l.a.a[Bitmap.Config.RGB_565.ordinal()] = 2;
            l.a.a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            l.a.a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            l.a.a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
        }
    }
    static {
        l.a = "0123456789abcdef".toCharArray();
        l.b = new char[64];
    }

    public static void a() {
        if (!l.r()) {
        } else {
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must call this method on the main thread");
        throw illegalArgumentException;
    }

    public static boolean b(Object object, Object object2) {
        int obj1;
        if (object == null) {
            obj1 = object2 == null ? 1 : 0;
            return obj1;
        }
        if (object instanceof l) {
            return (l)object.a(object2);
        }
        return object.equals(object2);
    }

    public static boolean c(Object object, Object object2) {
        int obj0;
        if (object == null) {
            obj0 = object2 == null ? 1 : 0;
        } else {
            obj0 = object.equals(object2);
        }
        return obj0;
    }

    private static String d(byte[] bArr, char[] c2Arr2) {
        int i;
        char c;
        int i2;
        char[] cArr;
        char c2;
        i = 0;
        for (byte b : bArr) {
            b &= 255;
            int i5 = i * 2;
            cArr = l.a;
            c2Arr2[i5] = cArr[i3 >>> 4];
            c2Arr2[i5++] = cArr[i3 &= 15];
        }
        String obj5 = new String(c2Arr2);
        return obj5;
    }

    public static <T> Queue<T> e(int i) {
        ArrayDeque arrayDeque = new ArrayDeque(i);
        return arrayDeque;
    }

    public static int f(int i, int i2, Bitmap.Config bitmap$Config3) {
        return obj0 *= obj1;
    }

    public static int g(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
        } else {
            if (Build.VERSION.SDK_INT >= 19) {
                return bitmap.getAllocationByteCount();
            }
            return height *= obj3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot obtain size for recycled Bitmap: ");
        stringBuilder.append(bitmap);
        stringBuilder.append("[");
        stringBuilder.append(bitmap.getWidth());
        stringBuilder.append("x");
        stringBuilder.append(bitmap.getHeight());
        stringBuilder.append("] ");
        stringBuilder.append(bitmap.getConfig());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    public static int h(Bitmap.Config bitmap$Config) {
        int i;
        int i2;
        Bitmap.Config obj3;
        if (config == null) {
            obj3 = Bitmap.Config.ARGB_8888;
        }
        obj3 = l.a.a[obj3.ordinal()];
        final int i3 = 2;
        i2 = 1;
        if (obj3 != i2) {
            if (obj3 != i3 && obj3 != 3) {
                if (obj3 != 3) {
                    if (obj3 != 4) {
                    } else {
                        i = 8;
                    }
                } else {
                    i = i3;
                }
            } else {
            }
        } else {
            i = i2;
        }
        return i;
    }

    public static <T> List<T> i(Collection<T> collection) {
        int size;
        ArrayList arrayList = new ArrayList(collection.size());
        final Iterator obj2 = collection.iterator();
        while (obj2.hasNext()) {
            size = obj2.next();
            if (size != 0) {
            }
            arrayList.add(size);
        }
        return arrayList;
    }

    private static Handler j() {
        Handler handler;
        Handler handler2;
        Looper mainLooper;
        handler = l.class;
        if (l.c == null && l.c == null) {
            handler = l.class;
            synchronized (handler) {
                handler2 = new Handler(Looper.getMainLooper());
                l.c = handler2;
            }
        }
        return l.c;
    }

    public static int k(float f) {
        return l.l(f, 17);
    }

    public static int l(float f, int i2) {
        return l.n(Float.floatToIntBits(f), i2);
    }

    public static int m(int i) {
        return l.n(i, 17);
    }

    public static int n(int i, int i2) {
        return obj1 += i;
    }

    public static int o(Object object, int i2) {
        int obj0;
        if (object == null) {
            obj0 = 0;
        } else {
            obj0 = object.hashCode();
        }
        return l.n(obj0, i2);
    }

    public static int p(boolean z, int i2) {
        return l.n(z, i2);
    }

    public static boolean q() {
        return z ^= 1;
    }

    public static boolean r() {
        int i;
        i = Looper.myLooper() == Looper.getMainLooper() ? 1 : 0;
        return i;
    }

    private static boolean s(int i) {
        int i2;
        int obj1;
        if (i <= 0) {
            if (i == Integer.MIN_VALUE) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    public static boolean t(int i, int i2) {
        boolean obj0;
        if (l.s(i) && l.s(i2)) {
            obj0 = l.s(i2) ? 1 : 0;
        } else {
        }
        return obj0;
    }

    public static void u(Runnable runnable) {
        l.j().post(runnable);
    }

    public static void v(Runnable runnable) {
        l.j().removeCallbacks(runnable);
    }

    public static String w(byte[] bArr) {
        final char[] cArr = l.b;
        return l.d(bArr, cArr);
        synchronized (cArr) {
            cArr = l.b;
            return l.d(bArr, cArr);
        }
    }
}
