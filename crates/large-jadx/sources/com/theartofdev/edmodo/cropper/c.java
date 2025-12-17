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
import java.io.InputStream;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

/* loaded from: classes2.dex */
final class c {

    static final Rect a;
    static final RectF b;
    static final RectF c;
    static final float[] d;
    static final float[] e;
    private static int f;
    static Pair<String, WeakReference<Bitmap>> g;

    static final class a {

        public final Bitmap a;
        final int b;
        a(Bitmap bitmap, int i2) {
            super();
            this.a = bitmap;
            this.b = i2;
        }
    }

    static final class b {

        public final Bitmap a;
        final int b;
        b(Bitmap bitmap, int i2) {
            super();
            this.a = bitmap;
            this.b = i2;
        }
    }
    static {
        Rect rect = new Rect();
        c.a = rect;
        RectF rectF = new RectF();
        c.b = rectF;
        RectF rectF2 = new RectF();
        c.c = rectF2;
        int i = 6;
        c.d = new float[i];
        c.e = new float[i];
    }

    static com.theartofdev.edmodo.cropper.c.b A(Bitmap bitmap, Context context2, Uri uri3) {
        int i;
        com.theartofdev.edmodo.cropper.c.b obj1;
        Object obj2;
        Object obj3;
        i = 0;
        obj2 = context2.getContentResolver().openInputStream(uri3);
        if (obj2 != null) {
            try {
                obj3 = new a(obj2);
                obj2.close();
                i = obj3;
                if (i != 0) {
                } else {
                }
                obj1 = c.B(bitmap, i);
                obj2 = new c.b(bitmap, 0);
                obj1 = obj2;
                return obj1;
            } catch (Exception e) {
            }
        }
    }

    static com.theartofdev.edmodo.cropper.c.b B(Bitmap bitmap, a a2) {
        int i;
        int obj3;
        obj3 = a2.c("Orientation", 1);
        if (obj3 != 3) {
            if (obj3 != 6) {
                obj3 = obj3 != 8 ? 0 : 270;
            } else {
                obj3 = 90;
            }
        } else {
            obj3 = 180;
        }
        c.b bVar = new c.b(bitmap, obj3);
        return bVar;
    }

    static void C(Context context, Bitmap bitmap2, Uri uri3, Bitmap.CompressFormat bitmap$CompressFormat4, int i5) {
        int i = 0;
        java.io.OutputStream outputStream = context.getContentResolver().openOutputStream(uri3);
        bitmap2.compress(compressFormat4, i5, outputStream);
        c.c(outputStream);
    }

    static Uri D(Context context, Bitmap bitmap2, Uri uri3) {
        int jPEG;
        String exists;
        Object cacheDir;
        Uri obj5;
        jPEG = 1;
        if (uri3 == null) {
            obj5 = Uri.fromFile(File.createTempFile("aic_state_store_temp", ".jpg", context.getCacheDir()));
        } else {
            File file = new File(uri3.getPath());
            if (file.exists() != null) {
                try {
                    jPEG = 0;
                    if (jPEG != 0) {
                    }
                    c.C(context, bitmap2, obj5, Bitmap.CompressFormat.JPEG, 95);
                    return obj5;
                    bitmap2 = "AIC";
                    uri3 = "Failed to write bitmap to temp file for image-cropper save instance state";
                    Log.w(bitmap2, uri3, context);
                    context = null;
                    return context;
                }
            }
        }
    }

    private static int a(int i, int i2) {
        int i3;
        int i6;
        int i4;
        int i5;
        if (c.f == 0) {
            c.f = c.o();
        }
        i4 = 1;
        if (c.f > 0) {
        }
        return i4;
    }

    private static int b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        i5 = 1;
        if (i2 <= i4 && i > i3) {
            if (i > i3) {
            }
        }
        return i5;
    }

    private static void c(Closeable closeable) {
        if (closeable != null) {
            closeable.close();
        }
        try {
        }
    }

    static com.theartofdev.edmodo.cropper.c.a d(Context context, Uri uri2, float[] f3Arr3, int i4, int i5, int i6, boolean z7, int i8, int i9, int i10, int i11, boolean z12, boolean z13) {
        return c.e(context, uri2, f3Arr3, i4, i5, i6, z7, i8, i9, i10, i11, z12, z13, 1);
    }

    private static com.theartofdev.edmodo.cropper.c.a e(Context context, Uri uri2, float[] f3Arr3, int i4, int i5, int i6, boolean z7, int i8, int i9, int i10, int i11, boolean z12, boolean z13, int i14) {
        Object obj;
        int height;
        int i7;
        com.theartofdev.edmodo.cropper.c.a aVar;
        Object uri;
        Rect rect;
        int i;
        int i3;
        int i12;
        int i13;
        Bitmap bitmap;
        int i2;
        int i15 = i4;
        final Rect rect2 = c.s(f3Arr3, i5, i6, z7, i8, i9);
        if (i10 > 0) {
            i13 = i10;
        } else {
            i13 = height;
        }
        if (i11 > 0) {
            i2 = i11;
        } else {
            i2 = height;
        }
        int i16 = 0;
        int i24 = 1;
        aVar = c.m(context, uri2, rect2, i13, i2, i14);
        Bitmap bitmap2 = aVar.a;
        if (bitmap2 != null && i15 % 90 != 0) {
            if (i15 % 90 != 0) {
                bitmap = c.i(c.z(bitmap2, i15, z12, z13), f3Arr3, rect2, i4, z7, i8, i9);
            }
            c.a aVar2 = new c.a(bitmap, aVar.b);
            return aVar2;
        }
        return c.f(context, uri2, f3Arr3, i4, z7, i8, i9, i14, rect2, i13, i2, z12, z13);
    }

    private static com.theartofdev.edmodo.cropper.c.a f(Context context, Uri uri2, float[] f3Arr3, int i4, boolean z5, int i6, int i7, int i8, Rect rect9, int i10, int i11, boolean z12, boolean z13) {
        Object obj;
        int i9;
        int i5;
        int fArr;
        int i3;
        int length;
        boolean z3;
        int i13;
        int i12;
        int i;
        int i2;
        boolean z2;
        boolean z;
        obj = f3Arr3;
        i9 = 0;
        BitmapFactory.Options options = new BitmapFactory.Options();
        i14 *= i8;
        options.inSampleSize = i15;
        Bitmap bitmap = c.j(context.getContentResolver(), uri2, options);
        if (bitmap != null) {
            int length2 = obj.length;
            fArr = new float[length2];
            i13 = 0;
            System.arraycopy(obj, i13, fArr, i13, obj.length);
            while (i13 < length2) {
                fArr[i13] = f /= length;
                i13++;
            }
            if (c.h(bitmap, fArr, i4, z5, i6, i7, 1065353216, z12, z13) != bitmap) {
                try {
                    bitmap.recycle();
                    if (obj5 == null) {
                    } else {
                    }
                    obj5.recycle();
                    throw th;
                    c.a aVar = new c.a(i9, i15);
                    return aVar;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to load sampled bitmap: ");
                    stringBuilder.append(string);
                    Object string = "\r\n";
                    stringBuilder.append(string);
                    string = th.getMessage();
                    stringBuilder.append(string);
                    string = stringBuilder.toString();
                    RuntimeException runtimeException = new RuntimeException(string, th);
                    throw runtimeException;
                    if (runtimeException == null) {
                    } else {
                    }
                    runtimeException.recycle();
                    throw th;
                } catch (Throwable th) {
                }
            }
        }
    }

    static com.theartofdev.edmodo.cropper.c.a g(Bitmap bitmap, float[] f2Arr2, int i3, boolean z4, int i5, int i6, boolean z7, boolean z8) {
        final int i7 = i;
        c.a aVar = new c.a(c.h(bitmap, f2Arr2, i3, z4, i5, i6, i2 / f, z7, z8), i7);
        return aVar;
    }

    private static Bitmap h(Bitmap bitmap, float[] f2Arr2, int i3, boolean z4, int i5, int i6, float f7, boolean z8, boolean z9) {
        int i;
        Bitmap bitmap2;
        int i2;
        int left;
        int i7;
        int top;
        int width;
        int height;
        Matrix matrix;
        int i4;
        final int i12 = i3;
        i = f7;
        final Rect rect = c.s(f2Arr2, bitmap.getWidth(), bitmap.getHeight(), z4, i5, i6);
        matrix = new Matrix();
        matrix.setRotate((float)i12, (float)i8, (float)i9);
        i2 = z8 ? -i : i;
        if (z9) {
            i = -i;
        }
        matrix.postScale(i2, i);
        if (Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), matrix, true) == bitmap) {
            bitmap2 = bitmap.copy(bitmap.getConfig(), false);
        }
        if (i12 % 90 != 0) {
            bitmap2 = c.i(bitmap2, f2Arr2, rect, i3, z4, i5, i6);
        }
        return bitmap2;
    }

    private static Bitmap i(Bitmap bitmap, float[] f2Arr2, Rect rect3, int i4, boolean z5, int i6, int i7) {
        double radians;
        int i;
        int i5;
        int i2;
        int cmp;
        int i8;
        int i3;
        double d;
        Bitmap obj8;
        int obj9;
        Object obj10;
        int obj11;
        int obj12;
        if (i4 % 90 != 0) {
            radians = Math.toRadians((double)i4);
            if (i4 >= 90) {
                if (i4 > 180 && i4 < 270) {
                    if (i4 < 270) {
                        obj11 = rect3.left;
                    } else {
                        obj11 = rect3.right;
                    }
                } else {
                }
            } else {
            }
            i5 = 0;
            i2 = i5;
            while (i2 < f2Arr2.length) {
                i2 += 2;
                i3 = (float)i18;
            }
            i8 = obj11;
            rect3.set(i5, obj11, i8 += i5, obj9 += obj11);
            if (z5 != 0) {
                c.n(rect3, i6, i7);
            }
            obj9 = Bitmap.createBitmap(bitmap, rect3.left, rect3.top, rect3.width(), rect3.height());
            if (bitmap != obj9) {
                bitmap.recycle();
            }
            obj8 = obj9;
        }
        return obj8;
    }

    private static Bitmap j(ContentResolver contentResolver, Uri uri2, BitmapFactory.Options bitmapFactory$Options3) {
        int i = 0;
        InputStream inputStream = contentResolver.openInputStream(uri2);
        c.c(inputStream);
        return BitmapFactory.decodeStream(inputStream, c.a, options3);
    }

    private static BitmapFactory.Options k(ContentResolver contentResolver, Uri uri2) {
        try {
            final InputStream obj1 = contentResolver.openInputStream(uri2);
            BitmapFactory.Options obj2 = new BitmapFactory.Options();
            obj2.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(obj1, c.a, obj2);
            obj2.inJustDecodeBounds = false;
            c.c(obj1);
            return obj2;
            contentResolver = 0;
            c.c(contentResolver);
            throw uri2;
        } catch (Throwable th) {
        }
    }

    static com.theartofdev.edmodo.cropper.c.a l(Context context, Uri uri2, int i3, int i4) {
        int outHeight;
        try {
            ContentResolver obj4 = context.getContentResolver();
            final BitmapFactory.Options factory = c.k(obj4, uri2);
            int outWidth = factory.outWidth;
            int i = -1;
            if (outWidth == i) {
            }
            if (factory.outHeight == i) {
            } else {
            }
            obj4 = new RuntimeException("File is not a picture");
            throw obj4;
            factory.inSampleSize = Math.max(c.b(outWidth, factory.outHeight, i3, i4), c.a(factory.outWidth, factory.outHeight));
            c.a obj6 = new c.a(c.j(obj4, uri2, factory), factory.inSampleSize);
            return obj6;
            i4 = new StringBuilder();
            i4.append("Failed to load sampled bitmap: ");
            i4.append(uri2);
            uri2 = "\r\n";
            i4.append(uri2);
            uri2 = context.getMessage();
            i4.append(uri2);
            uri2 = i4.toString();
            i3 = new RuntimeException(uri2, context);
            throw i3;
        }
    }

    private static com.theartofdev.edmodo.cropper.c.a m(Context context, Uri uri2, Rect rect3, int i4, int i5, int i6) {
        int obj8;
        int obj9;
        final int i = 0;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i6 *= obj7;
        InputStream obj4 = context.getContentResolver().openInputStream(uri2);
        BitmapRegionDecoder obj7 = BitmapRegionDecoder.newInstance(obj4, false);
        try {
            obj8 = new c.a(obj7.decodeRegion(rect3, options), options.inSampleSize);
            c.c(obj4);
            if (obj7 != null) {
            }
            obj7.recycle();
            return obj8;
            i5 = obj1.inSampleSize;
            i5 *= 2;
            obj1.inSampleSize = i5;
            i6 = 512;
            if (i5 > i6) {
            } else {
            }
            c.c(context);
            if (i4 != 0) {
            }
            i4.recycle();
            uri2 = 1;
            context = new c.a(bitmap, uri2);
            return context;
            i4 = bitmap;
            Bitmap bitmap = context;
            i4 = bitmap;
            bitmap = context;
            i4 = bitmap;
            i4 = bitmap;
            i5 = new StringBuilder();
            i6 = "Failed to load sampled bitmap: ";
            i5.append(i6);
            i5.append(uri2);
            uri2 = "\r\n";
            i5.append(uri2);
            uri2 = rect3.getMessage();
            i5.append(uri2);
            uri2 = i5.toString();
            context = new RuntimeException(uri2, rect3);
            throw context;
            c.c(bitmap);
            if (i4 == 0) {
            } else {
            }
            i4.recycle();
            throw uri2;
        } catch (Exception e) {
        } catch (Throwable th1) {
        }
    }

    private static void n(Rect rect, int i2, int i3) {
        int height;
        int obj2;
        int obj3;
        if (i2 == i3 && rect.width() != rect.height()) {
            if (rect.width() != rect.height()) {
                if (rect.height() > rect.width()) {
                    rect.bottom = obj2 -= obj3;
                } else {
                    rect.right = obj2 -= obj3;
                }
            }
        }
    }

    private static int o() {
        int i;
        int i2;
        int i4;
        int i3;
        final javax.microedition.khronos.egl.EGL eGL = EGLContext.getEGL();
        javax.microedition.khronos.egl.EGLDisplay eglGetDisplay = (EGL10)eGL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        eGL.eglInitialize(eglGetDisplay, new int[2]);
        int i8 = 1;
        final int[] iArr3 = new int[i8];
        final int i11 = 0;
        eGL.eglGetConfigs(eglGetDisplay, 0, i11, iArr3);
        javax.microedition.khronos.egl.EGLConfig[] arr = new EGLConfig[iArr3[i11]];
        eGL.eglGetConfigs(eglGetDisplay, arr, iArr3[i11], iArr3);
        int[] iArr2 = new int[i8];
        i2 = i;
        while (i < iArr3[i11]) {
            eGL.eglGetConfigAttrib(eglGetDisplay, arr[i], 12332, iArr2);
            if (i2 < iArr2[i11]) {
            }
            i++;
            i2 = iArr2[i11];
        }
        eGL.eglTerminate(eglGetDisplay);
        return Math.max(i2, 2048);
    }

    static float p(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    static float q(float[] fArr) {
        return i /= obj1;
    }

    static float r(float[] fArr) {
        return i /= obj1;
    }

    static Rect s(float[] fArr, int i2, int i3, boolean z4, int i5, int i6) {
        int i = 0;
        Rect obj5 = new Rect(Math.round(Math.max(i, c.u(fArr))), Math.round(Math.max(i, c.w(fArr))), Math.round(Math.min((float)i2, c.v(fArr))), Math.round(Math.min((float)i3, c.p(fArr))));
        if (z4) {
            c.n(obj5, i5, i6);
        }
        return obj5;
    }

    static float t(float[] fArr) {
        return f -= obj1;
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
        return f -= obj1;
    }

    static Bitmap y(Bitmap bitmap, int i2, int i3, com.theartofdev.edmodo.cropper.CropImageView.j cropImageView$j4) {
        com.theartofdev.edmodo.cropper.CropImageView.j rESIZE_FIT;
        com.theartofdev.edmodo.cropper.CropImageView.j rESIZE_INSIDE;
        com.theartofdev.edmodo.cropper.CropImageView.j rESIZE_EXACT;
        int i4;
        int i;
        int obj6;
        int obj7;
        com.theartofdev.edmodo.cropper.CropImageView.j obj8;
        if (i2 > 0 && i3 > 0) {
            if (i3 > 0) {
                rESIZE_FIT = CropImageView.j.RESIZE_FIT;
                if (j4 != rESIZE_FIT && j4 != CropImageView.j.RESIZE_INSIDE) {
                    if (j4 != CropImageView.j.RESIZE_INSIDE) {
                        try {
                            if (j4 == CropImageView.j.RESIZE_EXACT) {
                            }
                            rESIZE_INSIDE = 0;
                            i4 = 0;
                            if (j4 == CropImageView.j.RESIZE_EXACT) {
                            } else {
                            }
                            rESIZE_INSIDE = Bitmap.createScaledBitmap(bitmap, i2, i3, i4);
                            rESIZE_EXACT = (float)width;
                            i = (float)height;
                            obj6 = Math.max(rESIZE_EXACT / obj6, i / obj7);
                            if (Float.compare(obj6, obj7) <= 0) {
                            } else {
                            }
                            if (j4 == rESIZE_FIT) {
                            }
                            rESIZE_INSIDE = Bitmap.createScaledBitmap(bitmap, (int)rESIZE_EXACT, (int)i, i4);
                            if (rESIZE_INSIDE != null && rESIZE_INSIDE != bitmap) {
                            }
                            if (rESIZE_INSIDE != bitmap) {
                            }
                            bitmap.recycle();
                            return rESIZE_INSIDE;
                            i3 = "AIC";
                            j4 = "Failed to resize cropped image, return bitmap before resize";
                            Log.w(i3, j4, i2);
                            return bitmap;
                        }
                    } else {
                    }
                } else {
                }
            }
        }
    }

    private static Bitmap z(Bitmap bitmap, int i2, boolean z3, boolean z4) {
        int obj8;
        int obj9;
        if (i2 <= 0 && !z3 && z4) {
            if (!z3) {
                if (z4) {
                }
                return bitmap;
            }
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float)i2);
        int i = 1065353216;
        obj9 = z3 ? obj8 : i;
        if (z4) {
        } else {
            obj8 = i;
        }
        matrix.postScale(obj9, obj8);
        obj8 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        if (obj8 != bitmap) {
            bitmap.recycle();
        }
        return obj8;
    }
}
