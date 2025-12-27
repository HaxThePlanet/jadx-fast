package com.airbnb.lottie.y;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.DisplayMetrics;
import com.airbnb.lottie.t.b.s;
import java.io.Closeable;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
public final class h {

    private static final java.lang.ThreadLocal<PathMeasure> a = new h$a<>();
    private static final java.lang.ThreadLocal<Path> b = new h$b<>();
    private static final java.lang.ThreadLocal<Path> c = new h$c<>();
    private static final java.lang.ThreadLocal<float[]> d = new h$d<>();
    private static final float e = 0.0f;
    private static float f;

    class a extends java.lang.ThreadLocal<PathMeasure> {
        a() {
            super();
        }

        @Override // java.lang.ThreadLocal
        protected PathMeasure a() {
            return new PathMeasure();
        }
    }

    class b extends java.lang.ThreadLocal<Path> {
        b() {
            super();
        }

        @Override // java.lang.ThreadLocal
        protected Path a() {
            return new Path();
        }
    }

    class c extends java.lang.ThreadLocal<Path> {
        c() {
            super();
        }

        @Override // java.lang.ThreadLocal
        protected Path a() {
            return new Path();
        }
    }

    class d extends java.lang.ThreadLocal<float[]> {
        d() {
            super();
        }

        @Override // java.lang.ThreadLocal
        protected float[] a() {
            return new float[4];
        }
    }
    static {
        double d = 2d;
        h.e = (float)(Math.sqrt(d) / d);
        h.f = -1f;
    }

    public static void a(Path path, float f, float f2, float f3) {
        float f5;
        float f6;
        final String str = "applyTrimPathIfNeeded";
        c.a(str);
        Object obj = h.a.get();
        Object obj2 = h.b.get();
        Object obj3 = h.c.get();
        obj.setPath(path, false);
        float length = obj.getLength();
        f = 1f;
        final float f10 = 0.0f;
        if (f == f && f2 == 0.0f) {
            c.b(str);
            return;
        }
        if (length >= f) {
            double d2 = (double)(Math.abs((f2 - f) - f));
            double d = 0.01d;
            if (d2 >= 0.01d) {
                f *= length;
                f2 *= length;
                f3 *= length;
                f5 = (Math.min(f11, f12)) + f13;
                f6 = (Math.max(f11, f12)) + f13;
                if (f5 >= length && f6 >= length) {
                    f5 = (float)(g.g(f5, length));
                    f6 = (float)(g.g(f6, length));
                }
                if (f5 < 0.0f) {
                    f5 = (float)(g.g(f5, length));
                }
                if (f6 < 0.0f) {
                    f6 = (float)(g.g(f6, length));
                }
                if (f5 == f6) {
                    path.reset();
                    c.b(str);
                    return;
                }
                if (f5 >= f6) {
                    f5 = f5 - length;
                }
                obj2.reset();
                boolean z = true;
                obj.getSegment(f5, f6, obj2, z);
                if (f6 > length) {
                    obj3.reset();
                    f7 = f6 % length;
                    obj.getSegment(0.0f, f7, obj3, z);
                    obj2.addPath(obj3);
                } else {
                    if (f5 < 0.0f) {
                        obj3.reset();
                        f5 = f5 + length;
                        obj.getSegment(f5, length, obj3, z);
                        obj2.addPath(obj3);
                    }
                }
            }
            path.set(obj2);
            c.b(str);
            return;
        }
        c.b(str);
    }

    public static void b(Path path, s sVar) {
    }

    public static void c(Closeable closeable) throws java.io.IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
                return;
            }
        }
    }

    public static Path d(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        float f;
        float f2 = 0;
        final Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null) {
            float length = pointF3.length();
            f2 = 0.0f;
            if (length == 0.0f) {
                float length2 = pointF4.length();
                if (length2 != 0.0f) {
                    f2 = pointF3.x + pointF.x;
                    f3 = pointF.y + pointF3.y;
                    f4 = f6 + pointF4.x;
                    f5 = f7 + pointF4.y;
                    path.cubicTo(f2, f3, f4, f5, pointF2.x, pointF2.y);
                } else {
                    path.lineTo(pointF2.x, pointF2.y);
                }
            }
        }
        return path;
    }

    public static float e() {
        float f = h.f;
        if (h.f == -1082130432) {
            h.f = Resources.getSystem().getDisplayMetrics().density;
        }
        return h.f;
    }

    public static float f(Context context) throws android.provider.Settings.SettingNotFoundException {
        final float f = 1f;
        final String str = "animator_duration_scale";
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getFloat(context.getContentResolver(), str, f);
        }
        return Settings.System.getFloat(context.getContentResolver(), str, f);
    }

    public static float g(Matrix matrix) {
        Object obj = h.d.get();
        int i2 = 0;
        int i5 = 0;
        obj[i2] = i5;
        final int i6 = 1;
        obj[i6] = i5;
        float f2 = h.e;
        final int i7 = 2;
        obj[i7] = f2;
        final int i8 = 3;
        obj[i8] = f2;
        matrix.mapPoints(obj);
        float f = obj[i8] - obj[i6];
        return (float)(Math.hypot((double)(obj[i7] - obj[i2]), (double)f));
    }

    public static boolean h(Matrix matrix) {
        Object obj = h.d.get();
        final int i2 = 0;
        int i3 = 0;
        obj[i2] = i3;
        final int i7 = 1;
        obj[i7] = i3;
        final int i8 = 2;
        obj[i8] = 1192366779;
        final int i9 = 3;
        obj[i9] = 1192924988;
        matrix.mapPoints(obj);
        int i10 = obj[i2];
        int i6 = obj[i8];
        if (i10 != i6) {
            int i11 = obj[i7];
            int i = obj[i9];
            return false;
        }
        return true;
    }

    public static boolean k(Throwable th) {
        boolean z;
        boolean z3 = true;
        z = th instanceof SocketException;
        if (!(th instanceof SocketException)) {
            z = th instanceof ClosedChannelException;
            if (!(th instanceof ClosedChannelException)) {
                z = th instanceof InterruptedIOException;
                if (!(th instanceof InterruptedIOException)) {
                    z = th instanceof ProtocolException;
                    if (!(th instanceof ProtocolException)) {
                        z = th instanceof SSLException;
                        if (!(th instanceof SSLException)) {
                            z = th instanceof UnknownHostException;
                            if (!(th instanceof UnknownHostException)) {
                                z2 = th instanceof UnknownServiceException;
                                if (th instanceof UnknownServiceException) {
                                    int i = 1;
                                } else {
                                    int i2 = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z3;
    }

    public static Bitmap l(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        bitmap.recycle();
        return Bitmap.createScaledBitmap(bitmap, i, i2, true);
    }

    public static void m(Canvas canvas, RectF rectF, Paint paint) {
        h.n(canvas, rectF, paint, 31);
    }

    public static void n(Canvas canvas, RectF rectF, Paint paint, int i) {
        final String str = "Utils#saveLayer";
        c.a(str);
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        c.b(str);
    }

    public static int i(float f, float f2, float f3, float f4) {
        int i = 17;
        final float f5 = 0.0f;
        if (f != 0.0f) {
            i = (int)(float)527 * f;
        } else {
            i = 17;
        }
        if (f2 != 0.0f) {
            i = (int)(float)(i * 31) * f2;
        }
        if (f3 != 0.0f) {
            i = (int)(float)(i * 31) * f3;
        }
        if (f4 != 0.0f) {
            i = (int)(float)(i * 31) * f4;
        }
        return i;
    }

    public static boolean j(int i, int i2, int i3, int i4, int i5, int i6) {
        boolean z = false;
        z = false;
        if (i < i4) {
            return false;
        }
        final int i7 = 1;
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        if (i2 > i5) {
            return true;
        }
        if (i3 >= i6) {
        }
        return z;
    }
}
