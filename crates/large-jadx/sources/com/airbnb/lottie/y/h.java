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
import com.airbnb.lottie.c;
import com.airbnb.lottie.t.b.s;
import com.airbnb.lottie.t.c.c;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class h {

    private static final java.lang.ThreadLocal<PathMeasure> a;
    private static final java.lang.ThreadLocal<Path> b;
    private static final java.lang.ThreadLocal<Path> c;
    private static final java.lang.ThreadLocal<float[]> d;
    private static final float e = 4611686018427387904L;
    private static float f;

    class a extends java.lang.ThreadLocal<PathMeasure> {
        @Override // java.lang.ThreadLocal
        protected PathMeasure a() {
            PathMeasure pathMeasure = new PathMeasure();
            return pathMeasure;
        }

        @Override // java.lang.ThreadLocal
        protected Object initialValue() {
            return a();
        }
    }

    class b extends java.lang.ThreadLocal<Path> {
        @Override // java.lang.ThreadLocal
        protected Path a() {
            Path path = new Path();
            return path;
        }

        @Override // java.lang.ThreadLocal
        protected Object initialValue() {
            return a();
        }
    }

    class c extends java.lang.ThreadLocal<Path> {
        @Override // java.lang.ThreadLocal
        protected Path a() {
            Path path = new Path();
            return path;
        }

        @Override // java.lang.ThreadLocal
        protected Object initialValue() {
            return a();
        }
    }

    class d extends java.lang.ThreadLocal<float[]> {
        @Override // java.lang.ThreadLocal
        protected float[] a() {
            return new float[4];
        }

        @Override // java.lang.ThreadLocal
        protected Object initialValue() {
            return a();
        }
    }
    static {
        h.a aVar = new h.a();
        h.a = aVar;
        h.b bVar = new h.b();
        h.b = bVar;
        h.c cVar = new h.c();
        h.c = cVar;
        h.d dVar = new h.d();
        h.d = dVar;
        long l = 4611686018427387904L;
        float f = (float)i2;
        h.f = -1082130432;
    }

    public static void a(Path path, float f2, float f3, float f4) {
        int cmp2;
        int i;
        int cmp3;
        int cmp;
        long l;
        int obj11;
        int obj12;
        final String str = "applyTrimPathIfNeeded";
        c.a(str);
        Object obj = h.a.get();
        Object obj2 = h.b.get();
        Object obj3 = h.c.get();
        (PathMeasure)obj.setPath(path, false);
        float length = obj.getLength();
        cmp2 = 1065353216;
        final int i4 = 0;
        if (Float.compare(f2, cmp2) == 0 && Float.compare(f3, i4) == 0) {
            if (Float.compare(f3, i4) == 0) {
                c.b(str);
            }
        }
        if (Float.compare(length, cmp2) >= 0) {
            if (Double.compare(d, l) < 0) {
            } else {
                f2 *= length;
                f3 *= length;
                f4 *= length;
                f5 += obj13;
                obj11 += obj13;
                if (Float.compare(i, length) >= 0 && Float.compare(obj11, length) >= 0) {
                    if (Float.compare(obj11, length) >= 0) {
                        i = (float)obj12;
                        obj11 = (float)obj11;
                    }
                }
                if (Float.compare(i, i4) < 0) {
                    i = (float)obj12;
                }
                if (Float.compare(obj11, i4) < 0) {
                    obj11 = (float)obj11;
                }
                obj12 = Float.compare(i, obj11);
                if (obj12 == null) {
                    path.reset();
                    c.b(str);
                }
                if (obj12 >= 0) {
                    i -= length;
                }
                (Path)obj2.reset();
                obj12 = 1;
                obj.getSegment(i, obj11, obj2, obj12);
                if (Float.compare(obj11, length) > 0) {
                    (Path)obj3.reset();
                    obj.getSegment(i4, obj11 %= length, obj3, obj12);
                    obj2.addPath(obj3);
                } else {
                    if (Float.compare(i, i4) < 0) {
                        obj3.reset();
                        obj.getSegment(i += length, length, obj3, obj12);
                        obj2.addPath(obj3);
                    }
                }
            }
            path.set(obj2);
            c.b(str);
        }
        c.b(str);
    }

    public static void b(Path path, s s2) {
        int z;
        int i;
        int i2;
        int obj4;
        if (s2 != null) {
            if (s2.j()) {
            } else {
                int i3 = 1120403456;
                h.a(path, f /= i3, f2 /= i3, obj4 /= i2);
            }
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            closeable.close();
        }
    }

    public static Path d(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        int cmp;
        float f;
        int i2;
        int i3;
        int i;
        float f3;
        float f2;
        float obj8;
        Object obj9;
        float obj10;
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null) {
            if (pointF4 != null) {
                f = 0;
                if (Float.compare(length, f) == 0) {
                    if (Float.compare(length2, f) != 0) {
                        f3 = pointF2.x;
                        f2 = pointF2.y;
                        path.cubicTo(f5 += f4, obj8 + obj10, f3 + obj8, f2 + obj8, f3, f2);
                    } else {
                        path.lineTo(pointF2.x, pointF2.y);
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return path;
    }

    public static float e() {
        int density;
        if (Float.compare(f, i) == 0) {
            h.f = displayMetrics.density;
        }
        return h.f;
    }

    public static float f(Context context) {
        final int i = 1065353216;
        final String str = "animator_duration_scale";
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getFloat(context.getContentResolver(), str, i);
        }
        return Settings.System.getFloat(context.getContentResolver(), str, i);
    }

    public static float g(Matrix matrix) {
        Object obj = h.d.get();
        int i2 = 0;
        int i6 = 0;
        (float[])obj[i2] = i6;
        final int i7 = 1;
        obj[i7] = i6;
        float f = h.e;
        final int i8 = 2;
        obj[i8] = f;
        final int i9 = 3;
        obj[i9] = f;
        matrix.mapPoints(obj);
        i4 -= i;
        return (float)hypot;
    }

    public static boolean h(Matrix matrix) {
        Object obj;
        int obj6;
        obj = h.d.get();
        final int i = 0;
        int i2 = 0;
        (float[])obj[i] = i2;
        final int i6 = 1;
        obj[i6] = i2;
        final int i7 = 2;
        obj[i7] = 1192366779;
        final int i8 = 3;
        obj[i8] = 1192924988;
        matrix.mapPoints(obj);
        if (Float.compare(obj6, i5) != 0 && Float.compare(obj6, obj) == 0) {
            if (Float.compare(obj6, obj) == 0) {
            }
            return i;
        }
        return i6;
    }

    public static int i(float f, float f2, float f3, float f4) {
        int cmp;
        int obj2;
        final int i = 0;
        if (Float.compare(f, i) != 0) {
            obj2 = (int)cmp;
        } else {
            obj2 = 17;
        }
        if (Float.compare(f2, i) != 0) {
            obj2 = (int)obj2;
        }
        if (Float.compare(f3, i) != 0) {
            obj2 = (int)obj2;
        }
        if (Float.compare(f4, i) != 0) {
            obj2 = (int)obj2;
        }
        return obj2;
    }

    public static boolean j(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        i7 = 0;
        if (i < i4) {
            return i7;
        }
        final int i8 = 1;
        if (i > i4) {
            return i8;
        }
        if (i2 < i5) {
            return i7;
        }
        if (i2 > i5) {
            return i8;
        }
        if (i3 >= i6) {
            i7 = i8;
        }
        return i7;
    }

    public static boolean k(Throwable throwable) {
        boolean z;
        int obj1;
        if (throwable instanceof SocketException == null && throwable instanceof ClosedChannelException == null && throwable instanceof InterruptedIOException == null && throwable instanceof ProtocolException == null && throwable instanceof SSLException == null && throwable instanceof UnknownHostException == null) {
            if (throwable instanceof ClosedChannelException == null) {
                if (throwable instanceof InterruptedIOException == null) {
                    if (throwable instanceof ProtocolException == null) {
                        if (throwable instanceof SSLException == null) {
                            if (throwable instanceof UnknownHostException == null) {
                                if (throwable instanceof UnknownServiceException != null) {
                                    obj1 = 1;
                                } else {
                                    obj1 = 0;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    public static Bitmap l(Bitmap bitmap, int i2, int i3) {
        int height;
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            if (bitmap.getHeight() == i3) {
                return bitmap;
            }
        }
        bitmap.recycle();
        return Bitmap.createScaledBitmap(bitmap, i2, i3, true);
    }

    public static void m(Canvas canvas, RectF rectF2, Paint paint3) {
        h.n(canvas, rectF2, paint3, 31);
    }

    public static void n(Canvas canvas, RectF rectF2, Paint paint3, int i4) {
        final String str = "Utils#saveLayer";
        c.a(str);
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF2, paint3, i4);
        } else {
            canvas.saveLayer(rectF2, paint3);
        }
        c.b(str);
    }
}
