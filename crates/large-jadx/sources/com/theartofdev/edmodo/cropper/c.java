package com.theartofdev.edmodo.cropper;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import d.l.a.a;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

/* compiled from: BitmapUtils.java */
/* loaded from: classes2.dex */
final class c {

    static final Rect a = new Rect();
    static final RectF b = new RectF();
    static final RectF c = new RectF();
    static final float[] d;
    static final float[] e;
    private static int f;
    static Pair<String, WeakReference<Bitmap>> g;

    static final class a {

        public final Bitmap a;
        final int b;
        a(Bitmap bitmap, int i) {
            super();
            this.a = bitmap;
            this.b = i;
        }
    }

    static final class b {

        public final Bitmap a;
        final int b;
        b(Bitmap bitmap, int i) {
            super();
            this.a = bitmap;
            this.b = i;
        }
    }
    static {
        int i = 6;
        c.d = new float[i];
        c.e = new float[i];
    }

    static c.b A(Bitmap bitmap, Context context, Uri uri) throws java.io.FileNotFoundException, IOException {
        a uri32 = null;
        com.theartofdev.edmodo.cropper.c.b context22;
        int i2 = 0;
        try {
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
        } catch (Exception unused) {
        }
        if (uri32 != null) {
            context22 = c.B(bitmap, uri32);
        } else {
            int i = 0;
        }
        return context22;
    }

    static c.b B(Bitmap bitmap, a aVar) {
        int i2 = 180;
        int i4 = aVar.c("Orientation", 1);
        int i = 3;
        if (i4 == 3) {
            i2 = 180;
        } else {
            i = 6;
            if (i4 != 6) {
                i = 8;
                aVar = i4 != 8 ? 0 : 270;
            } else {
                i2 = 90;
            }
        }
        return new c.b(bitmap, i2);
    }

    static void C(Context context, Bitmap bitmap, Uri uri, Bitmap.CompressFormat compressFormat, int i) {
        try {
            java.io.OutputStream outputStream = context.getContentResolver().openOutputStream(uri);
            bitmap.compress(compressFormat, i, outputStream);
        } finally {
            c.c(closeable);
            throw context;
        }
        c.c(outputStream);
    }

    static Uri D(Context context, Bitmap bitmap, Uri uri) throws IOException {
        int i = 1;
        String str;
        Uri file;
        i = 1;
        if (uri == null) {
            try {
                str = ".jpg";
                file = Uri.fromFile(File.createTempFile("aic_state_store_temp", str, context.getCacheDir()));
                if (new File(uri.getPath()).exists()) {
                    i = 0;
                }
                if (i != 0) {
                    c.C(context, bitmap, file, Bitmap.CompressFormat.JPEG, 95);
                }
            } catch (Exception e) {
                bitmap = "AIC";
                uri = "Failed to write bitmap to temp file for image-cropper save instance state";
                Log.w(bitmap, uri, e);
                e = null;
                return e;
            }
            return file;
        }
    }

    private static int a(int i, int i2) {
        int i4;
        int i5 = 1;
        if (c.f == 0) {
            c.f = c.o();
        }
        i5 = 1;
        if (c.f > 0) {
            i4 = i2 / i5;
            i6 = c.f;
            while (i2 / i5 <= c.f) {
                i4 = i / i5;
            }
        }
        return i5;
    }

    private static int b(int i, int i2, int i3, int i4) {
        int i5 = 1;
        i5 = 1;
        if (i2 > i4 || i > i3) {
            i6 = (i2 / 2) / i5;
            while (i2 / 2 / i5 > i4) {
                i6 = (i / 2) / i5;
            }
        }
        return i5;
    }

    private static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
                return;
            }
        }
    }

    static c.a d(Context context, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3) {
        try {
        } catch (java.lang.OutOfMemoryError e) {
            Throwable runtimeException = e;
            i3 *= 2;
            Throwable e2 = 16;
        }
        return c.e(context, uri, fArr, i, i2, i3, z, i4, i5, i6, i7, z2, z3, i);
    }

    private static c.a e(Context context, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3, int i8) throws c.a {
        Object obj;
        float[] fArr32;
        int i102;
        Bitmap bitmap;
        int i82;
        int i42 = i;
        final Rect rect = c.s(fArr, i2, i3, z, i4, i5);
        i102 = i6 > 0 ? i6 : i102;
        i82 = i7 > 0 ? i7 : i82;
        try {
            com.theartofdev.edmodo.cropper.c.a aVar = c.m(context, uri, rect, i102, i82, i8);
        } catch (java.lang.OutOfMemoryError e) {
        }
        if (aVar.a != null) {
            try {
            } catch (java.lang.OutOfMemoryError e) {
            }
            try {
                i = i42 % 90;
                if (i42 % 90 != 0) {
                    bitmap = c.i(bitmap, fArr, rect, i, z, i4, i5);
                }
            } catch (java.lang.OutOfMemoryError e) {
                obj = obj2;
            }
            return new c.a(bitmap, aVar.b);
        }
        return c.f(context, uri, fArr, i, z, i4, i5, i8, rect, i102, i82, z2, z3);
    }

    private static c.a f(Context context, Uri uri, float[] fArr, int i, boolean z, int i2, int i3, int i4, Rect rect, int i5, int i6, boolean z2, boolean z3) {
        Object fArr32;
        Bitmap bitmap = null;
        fArr32 = fArr;
        i2 = 0;
        try {
            final BitmapFactory.Options options = new BitmapFactory.Options();
            i3 *= i4;
            options.inSampleSize = i5;
            Bitmap bitmap2 = c.j(context.getContentResolver(), uri, options);
        } catch (Throwable unused) {
        }
        if (bitmap2 != null) {
            try {
                int length2 = fArr32.length;
                fArr = new float[length2];
                length = fArr32.length;
                i = 0;
                System.arraycopy(fArr32, i, fArr, i, length);
                while (i < length2) {
                    length = (float)options.inSampleSize;
                    fArr32 = fArr[i] / length;
                    fArr[i] = fArr32;
                    i = i + 1;
                }
                float f = 1f;
            } catch (Throwable unused) {
            }
            if (c.h(bitmap2, fArr, i, z, i2, i3, f, z2, z3) != bitmap2) {
                try {
                    bitmap2.recycle();
                    obj.recycle();
                    throw th;
                } catch (Throwable th) {
                }
            }
        }
        return new c.a(bitmap, i5);
    }

    static c.a g(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, boolean z2, boolean z3) {
        final int i7 = 1;
        try {
        } catch (java.lang.OutOfMemoryError e) {
            int i4 = i4 * 2;
        }
        return new c.a(c.h(bitmap, fArr, i, z, i2, i3, 1f / (float)i7, z2, z3), i7);
    }

    private static Bitmap h(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, float f, boolean z2, boolean z3) {
        int f72;
        Bitmap bitmap3;
        final int i32 = i;
        f72 = f;
        final Rect rect = c.s(fArr, bitmap.getWidth(), bitmap.getHeight(), z, i2, i3);
        Matrix matrix = new Matrix();
        matrix.setRotate((float)i32, (float)(bitmap.getWidth() / 2), (float)(bitmap.getHeight() / 2));
        int r1 = z2 ? -f72 : f72;
        if (z3) {
            f72 = -f72;
        }
        matrix.postScale(f72, f72);
        z = true;
        if (Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), matrix, z) == bitmap) {
            bitmap3 = bitmap.copy(bitmap.getConfig(), false);
        }
        i = i32 % 90;
        if (i32 % 90 != 0) {
            bitmap3 = c.i(bitmap3, fArr, rect, i, z, i2, i3);
        }
        return bitmap3;
    }

    private static Bitmap i(Bitmap bitmap, float[] fArr, Rect rect, int i, boolean z, int i2, int i3) {
        double radians;
        int i42 = 0;
        int cmp;
        double d;
        float f;
        double sin;
        Bitmap fArr22;
        int left2;
        i = i % 90;
        if (i % 90 != 0) {
            radians = Math.toRadians((double)i);
            i2 = 90;
            if (i < 90 || i > 180) {
            } else {
                i2 = 270;
                if (rect.left >= 270) {
                }
            }
            i42 = 0;
            for (int i8 : fArr) {
                f = (float)(left2 - 1);
                if (i8 >= f) {
                    break;
                }
            }
            i3 = i42 + i42;
            rect.set(i42, i42, i3, i42 + i42);
            if (z) {
                c.n(rect, i2, i3);
            }
            fArr22 = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
            if (bitmap != fArr22) {
                bitmap.recycle();
            }
        }
        return fArr22;
    }

    private static Bitmap j(ContentResolver contentResolver, Uri uri, BitmapFactory.Options options) {
        try {
            InputStream inputStream = contentResolver.openInputStream(uri);
        } catch (Throwable th) {
        }
        c.c(inputStream);
        return BitmapFactory.decodeStream(inputStream, c.a, options);
    }

    private static BitmapFactory.Options k(ContentResolver contentResolver, Uri uri) {
        try {
            final InputStream inputStream = contentResolver.openInputStream(uri);
        } catch (Throwable th) {
        }
        try {
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, c.a, options);
            options.inJustDecodeBounds = false;
        } catch (Throwable th) {
        }
        c.c(inputStream);
        return options;
    }

    static c.a l(Context context, Uri uri, int i, int i2) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            final BitmapFactory.Options options = c.k(contentResolver, uri);
            i = -1;
            if (options.outWidth == i) {
                if (options.outHeight == i) {
                    throw new RuntimeException("File is not a picture");
                }
            }
            options.inSampleSize = Math.max(c.b(options.outWidth, options.outHeight, i, i2), c.a(options.outWidth, options.outHeight));
        } catch (Exception e) {
            i2 = new StringBuilder();
            i2.append("Failed to load sampled bitmap: ");
            i2.append(uri);
            uri = "\r\n";
            i2.append(uri);
            uri = e.getMessage();
            i2.append(uri);
            uri = i2.toString();
            i = new RuntimeException(uri, e);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        }
        return new c.a(c.j(contentResolver, uri, options), options.inSampleSize);
    }

    private static c.a m(Context context, Uri uri, Rect rect, int i, int i2, int i3) {
        try {
            final BitmapFactory.Options options = new BitmapFactory.Options();
            i = i3 * (c.b(rect.width(), rect.height(), i, i2));
            options.inSampleSize = i;
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
        } catch (Throwable th) {
            i = context2;
        } catch (Exception e1) {
            i = context2;
        }
        try {
            BitmapRegionDecoder bitmapRegionDecoder = BitmapRegionDecoder.newInstance(inputStream, false);
        } catch (Throwable th) {
            i = context2;
        } catch (Exception e1) {
            i = context2;
        }
        try {
        } catch (Throwable th) {
        } catch (Exception e1) {
        } catch (java.lang.OutOfMemoryError unused) {
        }
        c.c(inputStream);
        if (bitmapRegionDecoder != null) {
            bitmapRegionDecoder.recycle();
        }
        return new c.a(bitmapRegionDecoder.decodeRegion(e1, options), options.inSampleSize);
    }

    private static void n(Rect rect, int i, int i2) {
        if (i == i2) {
            if (rect.width() != rect.height()) {
                if (rect.height() > rect.width()) {
                    height2 = rect.height() - rect.width();
                    rect.bottom -= height2;
                } else {
                    height2 = rect.width() - rect.height();
                    rect.right -= height2;
                }
            }
        }
    }

    private static int o() {
        int i;
        try {
            final javax.microedition.khronos.egl.EGL eGL = EGLContext.getEGL();
            javax.microedition.khronos.egl.EGLDisplay eglGetDisplay = eGL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            eGL.eglInitialize(eglGetDisplay, new int[2]);
            int i6 = 1;
            final int[] iArr3 = new int[i6];
            i = 0;
            eGL.eglGetConfigs(eglGetDisplay, null, i, iArr3);
            javax.microedition.khronos.egl.EGLConfig[] arr = new EGLConfig[iArr3[i]];
            eGL.eglGetConfigs(eglGetDisplay, arr, iArr3[i], iArr3);
            int[] iArr2 = new int[i6];
            while (i < iArr3[i]) {
                int i3 = 12332;
                eGL.eglGetConfigAttrib(eglGetDisplay, arr[i], i3, iArr2);
                if (i < iArr2[i]) {
                    i = iArr2[i];
                }
                i = i + 1;
            }
            eGL.eglTerminate(eglGetDisplay);
        } catch (Exception unused) {
            return Math.max(i, 2048);
        }
    }

    static float p(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    static float q(float[] fArr) {
        return (c.v(fArr) + c.u(fArr)) / 2f;
    }

    static float r(float[] fArr) {
        return (c.p(fArr) + c.w(fArr)) / 2f;
    }

    static Rect s(float[] fArr, int i, int i2, boolean z, int i3, int i4) {
        float f2 = 0.0f;
        Rect rect = new Rect(Math.round(Math.max(f2, c.u(fArr))), Math.round(Math.max(f2, c.w(fArr))), Math.round(Math.min((float)i, c.v(fArr))), Math.round(Math.min((float)i2, c.p(fArr))));
        if (z) {
            c.n(rect, i3, i4);
        }
        return rect;
    }

    static float t(float[] fArr) {
        return c.p(fArr) - c.w(fArr);
    }

    static float u(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    static float v(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    static float w(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    static float x(float[] fArr) {
        return c.v(fArr) - c.u(fArr);
    }

    static Bitmap y(Bitmap bitmap, int i, int i2, CropImageView.j jVar) {
        Bitmap scaledBitmap = null;
        com.theartofdev.edmodo.cropper.CropImageView.j rESIZE_EXACT2;
        float f;
        int cmp;
        if (i > 0 && i2 > 0 && jVar != CropImageView.j.RESIZE_FIT && jVar != CropImageView.j.RESIZE_INSIDE && jVar == CropImageView.j.RESIZE_EXACT) {
            int i4 = 0;
            boolean z = false;
            if (jVar == CropImageView.j.RESIZE_EXACT) {
                scaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, z);
            } else {
                float f2 = (float)bitmap.getWidth();
                f = (float)bitmap.getHeight();
                float max = Math.max(f2 / (float)i, f / (float)i2);
                if (max > 1065353216 || jVar == CropImageView.j.RESIZE_FIT) {
                    cmp = (int)(f2 / max);
                    f = f / max;
                    i = (int)f;
                    scaledBitmap = Bitmap.createScaledBitmap(bitmap, cmp, i, z);
                }
            }
            if (CropImageView.j.RESIZE_INSIDE != null && CropImageView.j.RESIZE_INSIDE != bitmap) {
                bitmap.recycle();
                return scaledBitmap;
            }
        }
        return bitmap;
    }

    private static Bitmap z(Bitmap bitmap, int i, boolean z, boolean z2) {
        int i22 = -1082130432;
        final Matrix matrix = new Matrix();
        matrix.setRotate((float)i);
        i22 = -1082130432;
        i22 = 1065353216;
        z = z ? -1082130432 : i22;
        if (!(z2)) {
        }
        matrix.postScale(i22, i22);
        Bitmap bitmap3 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        if (bitmap3 != bitmap) {
            bitmap.recycle();
        }
        return bitmap3;
    }
}
