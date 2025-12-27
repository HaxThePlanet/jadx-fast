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
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: TransformationUtils.java */
/* loaded from: classes.dex */
public final class a0 {

    private static final Paint a = new Paint(6);
    private static final Paint b = new Paint(7);
    private static final Paint c = new Paint(7);
    private static final Set<String> d = new HashSet<>();
    private static final Lock e = new a0$c();

    private interface b {
        void a(Canvas canvas, Paint paint, RectF rectF);
    }

    private static final class c implements Lock {
        c() {
            super();
        }

        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        public void lock() {
        }

        public void lockInterruptibly() {
        }

        public boolean tryLock() {
            return true;
        }

        public boolean tryLock(long j, TimeUnit timeUnit) {
            return true;
        }

        public void unlock() {
        }
    }

    class a implements a0.b {

        final /* synthetic */ int a;
        a(int i) {
            this.a = i;
            super();
        }

        public void a(Canvas canvas, Paint paint, RectF rectF) {
            canvas.drawRoundRect(rectF, (float)i, (float)i, paint);
        }
    }
    static {
        ReentrantLock reentrantLock = new ReentrantLock();
    }

    private static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        final Lock lock = a0.e;
        lock.lock();
        try {
            final Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, a0.a);
            a0.e(canvas);
        } finally {
            bitmap2 = a0.e;
            bitmap2.unlock();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) bitmap;
        }
        lock.unlock();
    }

    public static Bitmap b(e eVar, Bitmap bitmap, int i, int i2) {
        float f;
        float f3;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        i = 0;
        final float f15 = 0.5f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            f = (float)i2 / (float)bitmap.getHeight();
            f6 = (float)bitmap.getWidth() * f;
        } else {
            f = (float)i / (float)bitmap.getWidth();
            f6 = (float)bitmap.getHeight() * f;
            f3 = (float)i2 - f6 * f15;
        }
        matrix.setScale(f, f);
        i += f15;
        f3 += f15;
        matrix.postTranslate(f2, f4);
        bitmap = eVar.d(i, i2, a0.k(bitmap));
        a0.q(bitmap, bitmap);
        a0.a(bitmap, bitmap, matrix);
        return bitmap;
    }

    public static Bitmap c(e eVar, Bitmap bitmap, int i, int i2) {
        i = 2;
        final String str2 = "TransformationUtils";
        if (bitmap.getWidth() <= i && bitmap.getHeight() <= i2 && Log.isLoggable(str2, i)) {
            Log.v(str2, "requested target size larger or equal to input, returning input");
            return bitmap;
        }
        if (Log.isLoggable(str2, i)) {
            Log.v(str2, "requested target size too big for input, fit centering instead");
        }
        return a0.f(eVar, bitmap, i, i2);
    }

    public static Bitmap d(e eVar, Bitmap bitmap, int i, int i2) {
        int min = Math.min(i, i2);
        float f13 = (float)min;
        float f = 2f;
        float f2 = f13 / f;
        float f3 = (float)bitmap.getWidth();
        float f6 = (float)bitmap.getHeight();
        float max = Math.max(f13 / f3, f13 / f6);
        f3 *= max;
        max *= f6;
        float f8 = (f13 - f4) / f;
        float f15 = (f13 - f10) / f;
        Bitmap bitmap3 = a0.g(eVar, bitmap);
        bitmap = eVar.d(min, min, a0.h(bitmap));
        bitmap.setHasAlpha(true);
        Lock lock = a0.e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap);
            canvas.drawCircle(f2, f2, f2, a0.b);
            canvas.drawBitmap(bitmap3, null, new RectF(f8, f15, f4 + f8, f10 + f15), a0.c);
            a0.e(canvas);
        } finally {
            bitmap = a0.e;
            bitmap.unlock();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) eVar;
        }
        lock.unlock();
        if (!bitmap3.equals(bitmap)) {
            eVar.c(bitmap3);
        }
        return bitmap;
    }

    private static void e(Canvas canvas) {
        canvas.setBitmap(null);
    }

    public static Bitmap f(e eVar, Bitmap bitmap, int i, int i2) {
        i2 = 2;
        final String str5 = "TransformationUtils";
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2 && Log.isLoggable(str5, i2)) {
            Log.v(str5, "requested target size matches input, returning input");
            return bitmap;
        }
        float min = Math.min((float)i / (float)bitmap.getWidth(), (float)i2 / (float)bitmap.getHeight());
        if (bitmap.getWidth() == Math.round((float)bitmap.getWidth() * min) && bitmap.getHeight() == Math.round((float)bitmap.getHeight() * min) && Log.isLoggable(str5, i2)) {
            Log.v(str5, "adjusted target size matches input, returning input");
            return bitmap;
        }
        i = (int)(float)bitmap.getWidth() * min;
        bitmap = eVar.d(i, (int)(float)bitmap.getHeight() * min, a0.k(bitmap));
        a0.q(bitmap, bitmap);
        if (Log.isLoggable(str5, i2)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str6 = "request: ";
            String str9 = "x";
            str11 = str6 + i + str9 + i2;
            Log.v(str5, str11);
            StringBuilder stringBuilder3 = new StringBuilder();
            String str3 = "toFit:   ";
            int width = bitmap.getWidth();
            int height2 = bitmap.getHeight();
            str12 = str3 + width + str9 + height2;
            Log.v(str5, str12);
            StringBuilder stringBuilder4 = new StringBuilder();
            String str4 = "toReuse: ";
            int width2 = bitmap.getWidth();
            int height6 = bitmap.getHeight();
            str10 = str4 + width2 + str9 + height6;
            Log.v(str5, str10);
            StringBuilder stringBuilder2 = new StringBuilder();
            str2 = "minPct:   ";
            str = str2 + min;
            Log.v(str5, str);
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a0.a(bitmap, bitmap, matrix);
        return bitmap;
    }

    private static Bitmap g(e eVar, Bitmap bitmap) {
        Bitmap.Config config = a0.h(bitmap);
        if (config.equals(bitmap.getConfig())) {
            return bitmap;
        }
        bitmap = eVar.d(bitmap.getWidth(), bitmap.getHeight(), config);
        float f = 0.0f;
        new Canvas(bitmap).drawBitmap(bitmap, f, f, null);
        return bitmap;
    }

    private static Bitmap.Config h(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 26) {
            if (Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
                return Bitmap.Config.RGBA_F16;
            }
        }
        return Bitmap.Config.ARGB_8888;
    }

    public static Lock i() {
        return a0.e;
    }

    private static Bitmap.Config k(Bitmap bitmap) {
        Bitmap.Config config;
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        return config;
    }

    static void l(int i, Matrix matrix) {
        final float f = -90f;
        final float f2 = 90f;
        final float f3 = 180f;
        final float f4 = 1f;
        final float f5 = -1f;
        switch (i) {
            case 2:
                matrix.setScale(f5, f4);
                break;
            case 3:
                matrix.setRotate(f3);
                break;
            case 4:
                matrix.setRotate(f3);
                matrix.postScale(f5, f4);
                break;
            case 5:
                matrix.setRotate(f2);
                matrix.postScale(f5, f4);
                break;
            case 6:
                matrix.setRotate(f2);
                break;
            case 7:
                matrix.setRotate(f);
                matrix.postScale(f5, f4);
                break;
            case 8:
                matrix.setRotate(f);
                break;
            default:
        }
    }

    public static Bitmap n(e eVar, Bitmap bitmap, int i) {
        if (!a0.m(i)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        a0.l(i, matrix);
        float f3 = 0.0f;
        RectF rectF = new RectF(f3, f3, (float)bitmap.getWidth(), (float)bitmap.getHeight());
        matrix.mapRect(rectF);
        bitmap = eVar.d(Math.round(rectF.width()), Math.round(rectF.height()), a0.k(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        bitmap.setHasAlpha(bitmap.hasAlpha());
        a0.a(bitmap, bitmap, matrix);
        return bitmap;
    }

    public static Bitmap o(e eVar, Bitmap bitmap, int i) {
        boolean z = true;
        int r0 = i > 0 ? 1 : 0;
        k.a((i > 0 ? 1 : 0), "roundingRadius must be greater than 0.");
        return a0.p(eVar, bitmap, (i > 0 ? 1 : 0));
    }

    private static Bitmap p(e eVar, Bitmap bitmap, a0.b bVar) {
        final Bitmap bitmap3 = a0.g(eVar, bitmap);
        bitmap = eVar.d(bitmap3.getWidth(), bitmap3.getHeight(), a0.h(bitmap));
        boolean z = true;
        bitmap.setHasAlpha(z);
        Shader.TileMode cLAMP2 = Shader.TileMode.CLAMP;
        Paint paint = new Paint();
        paint.setAntiAlias(z);
        paint.setShader(new BitmapShader(bitmap3, cLAMP2, cLAMP2));
        float f3 = 0.0f;
        Lock lock = a0.e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            bVar.a(canvas, paint, new RectF(f3, f3, (float)bitmap.getWidth(), (float)bitmap.getHeight()));
            a0.e(canvas);
        } finally {
            bitmap = a0.e;
            bitmap.unlock();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) eVar;
        }
        lock.unlock();
        if (!bitmap3.equals(bitmap)) {
            eVar.c(bitmap3);
        }
        return bitmap;
    }

    public static void q(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    public static int j(int i) {
        int i2 = 90;
        switch (i) {
            case 3:
                i2 = 180;
                break;
            case 4:
                i2 = 90;
                break;
            case 5:
                i2 = 270;
                break;
            default:
                i2 = 0;
        }
        return i2;
    }

    public static boolean m(int i) {
        if (/* condition */) {
            return true;
        }
        return false;
    }
}
