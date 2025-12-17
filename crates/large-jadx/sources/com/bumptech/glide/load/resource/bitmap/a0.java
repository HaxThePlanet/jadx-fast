package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.t.k;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class a0 {

    private static final Paint a;
    private static final Paint b;
    private static final Paint c;
    private static final Set<String> d;
    private static final Lock e;

    private interface b {
        public abstract void a(Canvas canvas, Paint paint2, RectF rectF3);
    }

    private static final class c implements Lock {
        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
            throw unsupportedOperationException;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return 1;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long l, TimeUnit timeUnit2) {
            return 1;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    class a implements com.bumptech.glide.load.resource.bitmap.a0.b {

        final int a;
        a(int i) {
            this.a = i;
            super();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a0$b
        public void a(Canvas canvas, Paint paint2, RectF rectF3) {
            int i = this.a;
            canvas.drawRoundRect(rectF3, (float)i, (float)i, paint2);
        }
    }
    static {
        Object reentrantLock;
        Paint paint = new Paint(6);
        a0.a = paint;
        int i2 = 7;
        Paint paint2 = new Paint(i2);
        a0.b = paint2;
        HashSet hashSet = new HashSet(Arrays.asList(/* result */));
        a0.d = hashSet;
        if (hashSet.contains(Build.MODEL)) {
            reentrantLock = new ReentrantLock();
        } else {
            reentrantLock = new a0.c();
        }
        a0.e = reentrantLock;
        Paint paint3 = new Paint(i2);
        a0.c = paint3;
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        paint3.setXfermode(porterDuffXfermode);
    }

    private static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix3) {
        final Lock lock = a0.e;
        lock.lock();
        Canvas canvas = new Canvas(bitmap2);
        canvas.drawBitmap(bitmap, matrix3, a0.a);
        a0.e(canvas);
        lock.unlock();
    }

    public static Bitmap b(e e, Bitmap bitmap2, int i3, int i4) {
        int height;
        int i2;
        int i;
        int i5;
        int i6;
        int i7;
        if (bitmap2.getWidth() == i3 && bitmap2.getHeight() == i4) {
            if (bitmap2.getHeight() == i4) {
                return bitmap2;
            }
        }
        Matrix matrix = new Matrix();
        final int i17 = 1056964608;
        if (width *= i4 > height2 *= i3) {
            i5 = i15;
            i = i7;
        } else {
            i11 *= i17;
        }
        matrix.setScale(i2, i2);
        matrix.postTranslate((float)i9, (float)i13);
        final Bitmap obj7 = e.d(i3, i4, a0.k(bitmap2));
        a0.q(bitmap2, obj7);
        a0.a(bitmap2, obj7, matrix);
        return obj7;
    }

    public static Bitmap c(e e, Bitmap bitmap2, int i3, int i4) {
        int height;
        boolean loggable;
        boolean obj3;
        final int i = 2;
        final String str = "TransformationUtils";
        if (bitmap2.getWidth() <= i3 && bitmap2.getHeight() <= i4 && Log.isLoggable(str, i)) {
            if (bitmap2.getHeight() <= i4) {
                if (Log.isLoggable(str, i)) {
                    Log.v(str, "requested target size larger or equal to input, returning input");
                }
                return bitmap2;
            }
        }
        if (Log.isLoggable(str, i)) {
            Log.v(str, "requested target size too big for input, fit centering instead");
        }
        return a0.f(e, bitmap2, i3, i4);
    }

    public static Bitmap d(e e, Bitmap bitmap2, int i3, int i4) {
        int obj8 = Math.min(i3, i4);
        float obj9 = (float)obj8;
        int i = 1073741824;
        int i2 = obj9 / i;
        float f = (float)width;
        float f2 = (float)height;
        float f3 = Math.max(obj9 / f, obj9 / f2);
        f *= f3;
        f3 *= f2;
        i9 /= i;
        obj9 /= i;
        RectF rectF = new RectF(i10, obj9, i6 += i10, i12 += obj9);
        obj9 = a0.g(e, bitmap2);
        obj8 = e.d(obj8, obj8, a0.h(bitmap2));
        obj8.setHasAlpha(true);
        Lock lock = a0.e;
        lock.lock();
        Canvas canvas = new Canvas(obj8);
        canvas.drawCircle(i2, i2, i2, a0.b);
        canvas.drawBitmap(obj9, 0, rectF, a0.c);
        a0.e(canvas);
        lock.unlock();
        if (!obj9.equals(bitmap2)) {
            e.c(obj9);
        }
        return obj8;
    }

    private static void e(Canvas canvas) {
        canvas.setBitmap(0);
    }

    public static Bitmap f(e e, Bitmap bitmap2, int i3, int i4) {
        int height2;
        boolean loggable;
        int height;
        int str;
        boolean obj6;
        int obj8;
        int obj9;
        int i2 = 2;
        final String str4 = "TransformationUtils";
        if (bitmap2.getWidth() == i3 && bitmap2.getHeight() == i4 && Log.isLoggable(str4, i2)) {
            if (bitmap2.getHeight() == i4) {
                if (Log.isLoggable(str4, i2)) {
                    Log.v(str4, "requested target size matches input, returning input");
                }
                return bitmap2;
            }
        }
        float f2 = Math.min(f /= f3, f4 /= f7);
        if (bitmap2.getWidth() == Math.round(f5 *= f2) && bitmap2.getHeight() == Math.round(f8 *= f2) && Log.isLoggable(str4, i2)) {
            if (bitmap2.getHeight() == Math.round(f8 *= f2)) {
                if (Log.isLoggable(str4, i2)) {
                    Log.v(str4, "adjusted target size matches input, returning input");
                }
                return bitmap2;
            }
        }
        obj6 = e.d((int)i7, (int)i9, a0.k(bitmap2));
        a0.q(bitmap2, obj6);
        if (Log.isLoggable(str4, i2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("request: ");
            stringBuilder.append(i3);
            obj8 = "x";
            stringBuilder.append(obj8);
            stringBuilder.append(i4);
            Log.v(str4, stringBuilder.toString());
            obj9 = new StringBuilder();
            obj9.append("toFit:   ");
            obj9.append(bitmap2.getWidth());
            obj9.append(obj8);
            obj9.append(bitmap2.getHeight());
            Log.v(str4, obj9.toString());
            obj9 = new StringBuilder();
            obj9.append("toReuse: ");
            obj9.append(obj6.getWidth());
            obj9.append(obj8);
            obj9.append(obj6.getHeight());
            Log.v(str4, obj9.toString());
            obj8 = new StringBuilder();
            obj8.append("minPct:   ");
            obj8.append(f2);
            Log.v(str4, obj8.toString());
        }
        obj8 = new Matrix();
        obj8.setScale(f2, f2);
        a0.a(bitmap2, obj6, obj8);
        return obj6;
    }

    private static Bitmap g(e e, Bitmap bitmap2) {
        Bitmap.Config config = a0.h(bitmap2);
        if (config.equals(bitmap2.getConfig())) {
            return bitmap2;
        }
        final Bitmap obj3 = e.d(bitmap2.getWidth(), bitmap2.getHeight(), config);
        Canvas canvas = new Canvas(obj3);
        int i2 = 0;
        canvas.drawBitmap(bitmap2, i2, i2, 0);
        return obj3;
    }

    private static Bitmap.Config h(Bitmap bitmap) {
        int sDK_INT;
        boolean obj2;
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            if (Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
                return Bitmap.Config.RGBA_F16;
            }
        }
        return Bitmap.Config.ARGB_8888;
    }

    public static Lock i() {
        return a0.e;
    }

    public static int j(int i) {
        int obj0;
        switch (i) {
            case 3:
                obj0 = 180;
                break;
            case 4:
                obj0 = 90;
                break;
            case 5:
                obj0 = 270;
                break;
            default:
                obj0 = 0;
        }
        return obj0;
    }

    private static Bitmap.Config k(Bitmap bitmap) {
        Bitmap.Config obj1;
        if (bitmap.getConfig() != null) {
            obj1 = bitmap.getConfig();
        } else {
            obj1 = Bitmap.Config.ARGB_8888;
        }
        return obj1;
    }

    static void l(int i, Matrix matrix2) {
        final int i2 = -1028390912;
        final int i3 = 1119092736;
        final int i4 = 1127481344;
        final int i5 = 1065353216;
        final int i6 = -1082130432;
        switch (i) {
            case 2:
                matrix2.setScale(i6, i5);
                break;
            case 3:
                matrix2.setRotate(i4);
                break;
            case 4:
                matrix2.setRotate(i4);
                matrix2.postScale(i6, i5);
                break;
            case 5:
                matrix2.setRotate(i3);
                matrix2.postScale(i6, i5);
                break;
            case 6:
                matrix2.setRotate(i3);
                break;
            case 7:
                matrix2.setRotate(i2);
                matrix2.postScale(i6, i5);
                break;
            case 8:
                matrix2.setRotate(i2);
                break;
            default:
        }
    }

    public static boolean m(int i) {
        if (/* condition */) {
            return 1;
        }
        return 0;
    }

    public static Bitmap n(e e, Bitmap bitmap2, int i3) {
        if (!a0.m(i3)) {
            return bitmap2;
        }
        Matrix matrix = new Matrix();
        a0.l(i3, matrix);
        int i2 = 0;
        RectF obj6 = new RectF(i2, i2, (float)width, (float)height);
        matrix.mapRect(obj6);
        final Bitmap obj4 = e.d(Math.round(obj6.width()), Math.round(obj6.height()), a0.k(bitmap2));
        matrix.postTranslate(-left, -obj6);
        obj4.setHasAlpha(bitmap2.hasAlpha());
        a0.a(bitmap2, obj4, matrix);
        return obj4;
    }

    public static Bitmap o(e e, Bitmap bitmap2, int i3) {
        int i;
        i = i3 > 0 ? 1 : 0;
        k.a(i, "roundingRadius must be greater than 0.");
        a0.a aVar = new a0.a(i3);
        return a0.p(e, bitmap2, aVar);
    }

    private static Bitmap p(e e, Bitmap bitmap2, com.bumptech.glide.load.resource.bitmap.a0.b a0$b3) {
        final Bitmap bitmap3 = a0.g(e, bitmap2);
        Bitmap bitmap = e.d(bitmap3.getWidth(), bitmap3.getHeight(), a0.h(bitmap2));
        int i = 1;
        bitmap.setHasAlpha(i);
        Shader.TileMode cLAMP = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap3, cLAMP, cLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(i);
        paint.setShader(bitmapShader);
        int i2 = 0;
        RectF rectF = new RectF(i2, i2, (float)width2, (float)height2);
        Lock lock = a0.e;
        lock.lock();
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        b3.a(canvas, paint, rectF);
        a0.e(canvas);
        lock.unlock();
        if (!bitmap3.equals(bitmap2)) {
            e.c(bitmap3);
        }
        return bitmap;
    }

    public static void q(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
