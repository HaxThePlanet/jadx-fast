package com.theartofdev.edmodo.cropper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* loaded from: classes2.dex */
public class CropImageView extends FrameLayout {

    private Bitmap A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private com.theartofdev.edmodo.cropper.CropImageView.k I;
    private boolean J = false;
    private boolean K = true;
    private boolean L = true;
    private boolean M = true;
    private int N;
    private com.theartofdev.edmodo.cropper.CropImageView.g O;
    private com.theartofdev.edmodo.cropper.CropImageView.f P;
    private com.theartofdev.edmodo.cropper.CropImageView.h Q;
    private com.theartofdev.edmodo.cropper.CropImageView.i R;
    private com.theartofdev.edmodo.cropper.CropImageView.e S;
    private Uri T;
    private int U = 1;
    private float V = 1f;
    private float W;
    private final ImageView a;
    private float a0;
    private final com.theartofdev.edmodo.cropper.CropOverlayView b;
    private RectF b0;
    private final Matrix c;
    private int c0;
    private boolean d0;
    private Uri e0;
    private WeakReference<com.theartofdev.edmodo.cropper.b> f0;
    private WeakReference<com.theartofdev.edmodo.cropper.a> g0;
    private final Matrix v;
    private final ProgressBar w;
    private final float[] x;
    private final float[] y;
    private com.theartofdev.edmodo.cropper.e z;

    public static class b {

        private final Uri a;
        private final Uri b;
        private final Exception c;
        private final float[] v;
        private final Rect w;
        private final Rect x;
        private final int y;
        private final int z;
        b(Bitmap bitmap, Uri uri2, Bitmap bitmap3, Uri uri4, Exception exception5, float[] f6Arr6, Rect rect7, Rect rect8, int i9, int i10) {
            super();
            this.a = uri2;
            this.b = uri4;
            this.c = exception5;
            this.v = f6Arr6;
            this.w = rect7;
            this.x = rect8;
            this.y = i9;
            this.z = i10;
        }

        public float[] a() {
            return this.v;
        }

        public Rect b() {
            return this.w;
        }

        public Exception c() {
            return this.c;
        }

        public Uri d() {
            return this.a;
        }

        public int e() {
            return this.y;
        }

        public int f() {
            return this.z;
        }

        public Uri g() {
            return this.b;
        }

        public Rect h() {
            return this.x;
        }
    }

    public static enum c {

        RECTANGLE,
        OVAL;
    }

    public static enum d {

        OFF,
        ON_TOUCH,
        ON;
    }

    public interface e {
        public abstract void b(com.theartofdev.edmodo.cropper.CropImageView cropImageView, com.theartofdev.edmodo.cropper.CropImageView.b cropImageView$b2);
    }

    public interface f {
        public abstract void a(Rect rect);
    }

    public interface g {
        public abstract void a(Rect rect);
    }

    public interface h {
        public abstract void a();
    }

    public interface i {
        public abstract void a(com.theartofdev.edmodo.cropper.CropImageView cropImageView, Uri uri2, Exception exception3);
    }

    public static enum j {

        NONE,
        SAMPLING,
        RESIZE_INSIDE,
        RESIZE_FIT,
        RESIZE_EXACT;
    }

    public static enum k {

        FIT_CENTER,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE;
    }

    class a implements com.theartofdev.edmodo.cropper.CropOverlayView.b {

        final com.theartofdev.edmodo.cropper.CropImageView a;
        a(com.theartofdev.edmodo.cropper.CropImageView cropImageView) {
            this.a = cropImageView;
            super();
        }

        @Override // com.theartofdev.edmodo.cropper.CropOverlayView$b
        public void a(boolean z) {
            int cropRect;
            boolean obj3;
            CropImageView.a(this.a, z, true);
            com.theartofdev.edmodo.cropper.CropImageView.g view3 = CropImageView.b(this.a);
            if (view3 != null && !z) {
                if (!z) {
                    view3.a(this.a.getCropRect());
                }
            }
            com.theartofdev.edmodo.cropper.CropImageView.f view5 = CropImageView.c(this.a);
            if (view5 != null && z) {
                if (z) {
                    view5.a(this.a.getCropRect());
                }
            }
        }
    }
    public CropImageView(Context context, AttributeSet attributeSet2) {
        int value2;
        int bundleExtra;
        int fVar;
        String value;
        boolean z;
        boolean z2;
        Object obj9;
        super(context, attributeSet2);
        Matrix matrix = new Matrix();
        this.c = matrix;
        Matrix matrix2 = new Matrix();
        this.v = matrix2;
        int i = 8;
        this.x = new float[i];
        this.y = new float[i];
        value2 = 0;
        int i2 = 1;
        int i3 = 1065353216;
        if (context instanceof Activity != null) {
            bundleExtra = (Activity)context.getIntent();
        } else {
            bundleExtra = fVar;
        }
        bundleExtra = bundleExtra.getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE");
        if (bundleExtra != 0 && bundleExtra != null) {
            bundleExtra = bundleExtra.getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE");
            if (bundleExtra != null) {
                fVar = bundleExtra;
            }
        }
        fVar = new f();
        obj9 = context.obtainStyledAttributes(attributeSet2, m.a, value2, value2);
        value2 = m.l;
        fVar.D = obj9.getBoolean(value2, fVar.D);
        bundleExtra = m.b;
        fVar.E = obj9.getInteger(bundleExtra, fVar.E);
        fVar.F = obj9.getInteger(m.c, fVar.F);
        fVar.w = CropImageView.k.values()[obj9.getInt(m.A, fVar.w.ordinal())];
        fVar.z = obj9.getBoolean(m.d, fVar.z);
        fVar.A = obj9.getBoolean(m.y, fVar.A);
        fVar.B = obj9.getInteger(m.t, fVar.B);
        fVar.a = CropImageView.c.values()[obj9.getInt(m.B, fVar.a.ordinal())];
        fVar.v = CropImageView.d.values()[obj9.getInt(m.n, fVar.v.ordinal())];
        fVar.b = obj9.getDimension(m.E, fVar.b);
        fVar.c = obj9.getDimension(m.F, fVar.c);
        fVar.C = obj9.getFloat(m.q, fVar.C);
        fVar.G = obj9.getDimension(m.k, fVar.G);
        fVar.H = obj9.getInteger(m.j, fVar.H);
        int i14 = m.i;
        fVar.I = obj9.getDimension(i14, fVar.I);
        fVar.J = obj9.getDimension(m.h, fVar.J);
        fVar.K = obj9.getDimension(m.g, fVar.K);
        fVar.L = obj9.getInteger(m.f, fVar.L);
        fVar.M = obj9.getDimension(m.p, fVar.M);
        fVar.N = obj9.getInteger(m.o, fVar.N);
        fVar.O = obj9.getInteger(m.e, fVar.O);
        fVar.x = obj9.getBoolean(m.C, this.K);
        fVar.y = obj9.getBoolean(m.D, this.L);
        fVar.I = obj9.getDimension(i14, fVar.I);
        fVar.P = (int)dimension5;
        fVar.Q = (int)dimension6;
        fVar.R = (int)float2;
        fVar.S = (int)float3;
        fVar.T = (int)float4;
        fVar.U = (int)float5;
        int i27 = m.m;
        fVar.k0 = obj9.getBoolean(i27, fVar.k0);
        fVar.l0 = obj9.getBoolean(i27, fVar.l0);
        this.J = obj9.getBoolean(m.z, this.J);
        if (fVar == 0 && attributeSet2 != null && obj9.hasValue(bundleExtra) && obj9.hasValue(bundleExtra) && !obj9.hasValue(value2)) {
            fVar = new f();
            if (attributeSet2 != null) {
                obj9 = context.obtainStyledAttributes(attributeSet2, m.a, value2, value2);
                value2 = m.l;
                fVar.D = obj9.getBoolean(value2, fVar.D);
                bundleExtra = m.b;
                fVar.E = obj9.getInteger(bundleExtra, fVar.E);
                fVar.F = obj9.getInteger(m.c, fVar.F);
                fVar.w = CropImageView.k.values()[obj9.getInt(m.A, fVar.w.ordinal())];
                fVar.z = obj9.getBoolean(m.d, fVar.z);
                fVar.A = obj9.getBoolean(m.y, fVar.A);
                fVar.B = obj9.getInteger(m.t, fVar.B);
                fVar.a = CropImageView.c.values()[obj9.getInt(m.B, fVar.a.ordinal())];
                fVar.v = CropImageView.d.values()[obj9.getInt(m.n, fVar.v.ordinal())];
                fVar.b = obj9.getDimension(m.E, fVar.b);
                fVar.c = obj9.getDimension(m.F, fVar.c);
                fVar.C = obj9.getFloat(m.q, fVar.C);
                fVar.G = obj9.getDimension(m.k, fVar.G);
                fVar.H = obj9.getInteger(m.j, fVar.H);
                i14 = m.i;
                fVar.I = obj9.getDimension(i14, fVar.I);
                fVar.J = obj9.getDimension(m.h, fVar.J);
                fVar.K = obj9.getDimension(m.g, fVar.K);
                fVar.L = obj9.getInteger(m.f, fVar.L);
                fVar.M = obj9.getDimension(m.p, fVar.M);
                fVar.N = obj9.getInteger(m.o, fVar.N);
                fVar.O = obj9.getInteger(m.e, fVar.O);
                fVar.x = obj9.getBoolean(m.C, this.K);
                fVar.y = obj9.getBoolean(m.D, this.L);
                fVar.I = obj9.getDimension(i14, fVar.I);
                fVar.P = (int)dimension5;
                fVar.Q = (int)dimension6;
                fVar.R = (int)float2;
                fVar.S = (int)float3;
                fVar.T = (int)float4;
                fVar.U = (int)float5;
                i27 = m.m;
                fVar.k0 = obj9.getBoolean(i27, fVar.k0);
                fVar.l0 = obj9.getBoolean(i27, fVar.l0);
                this.J = obj9.getBoolean(m.z, this.J);
                if (obj9.hasValue(bundleExtra)) {
                    if (obj9.hasValue(bundleExtra)) {
                        if (!obj9.hasValue(value2)) {
                            fVar.D = i2;
                        }
                    }
                }
                obj9.recycle();
            }
        }
        fVar.a();
        this.I = fVar.w;
        this.M = fVar.z;
        this.N = fVar.B;
        this.K = fVar.x;
        this.L = fVar.y;
        this.D = fVar.k0;
        this.E = fVar.l0;
        View obj8 = LayoutInflater.from(context).inflate(j.b, this, i2);
        obj9 = obj8.findViewById(i.c);
        this.a = (ImageView)obj9;
        obj9.setScaleType(ImageView.ScaleType.MATRIX);
        obj9 = obj8.findViewById(i.a);
        this.b = (CropOverlayView)obj9;
        CropImageView.a aVar = new CropImageView.a(this);
        obj9.setCropWindowChangeListener(aVar);
        obj9.setInitialAttributeValues(fVar);
        this.w = (ProgressBar)obj8.findViewById(i.b);
        s();
    }

    static void a(com.theartofdev.edmodo.cropper.CropImageView cropImageView, boolean z2, boolean z3) {
        cropImageView.k(z2, z3);
    }

    static com.theartofdev.edmodo.cropper.CropImageView.g b(com.theartofdev.edmodo.cropper.CropImageView cropImageView) {
        return cropImageView.O;
    }

    static com.theartofdev.edmodo.cropper.CropImageView.f c(com.theartofdev.edmodo.cropper.CropImageView cropImageView) {
        return cropImageView.P;
    }

    private void d(float f, float f2, boolean z3, boolean z4) {
        Bitmap bitmap;
        int cropWindowRect;
        int i6;
        int i5;
        int i4;
        int i2;
        com.theartofdev.edmodo.cropper.CropImageView.k cmp;
        int i;
        Matrix matrix;
        int i3;
        com.theartofdev.edmodo.cropper.CropImageView.k cENTER_INSIDE;
        float f4;
        float f3;
        int obj9;
        int obj10;
        int obj11;
        bitmap = 0;
        this.c.invert(this.v);
        cropWindowRect = this.b.getCropWindowRect();
        this.v.mapRect(cropWindowRect);
        this.c.reset();
        i = 1073741824;
        this.c.postTranslate(i10 /= i, i12 /= i);
        l();
        i5 = this.C;
        if (this.A != null && Float.compare(f, bitmap) > 0 && Float.compare(f2, bitmap) > 0 && i5 > 0) {
            bitmap = 0;
            if (Float.compare(f, bitmap) > 0) {
                if (Float.compare(f2, bitmap) > 0) {
                    this.c.invert(this.v);
                    cropWindowRect = this.b.getCropWindowRect();
                    this.v.mapRect(cropWindowRect);
                    this.c.reset();
                    i = 1073741824;
                    this.c.postTranslate(i10 /= i, i12 /= i);
                    l();
                    i5 = this.C;
                    if (i5 > 0) {
                        this.c.postRotate((float)i5, c.q(this.x), c.r(this.x));
                        l();
                    }
                    float f6 = Math.min(f / f5, f2 / f9);
                    cmp = this.I;
                    if (cmp != CropImageView.k.FIT_CENTER) {
                        f4 = 1065353216;
                        if (cmp == CropImageView.k.CENTER_INSIDE) {
                            if (Float.compare(f6, f4) >= 0) {
                                if (Float.compare(f6, f4) > 0 && this.M) {
                                    if (this.M) {
                                        this.c.postScale(f6, f6, c.q(this.x), c.r(this.x));
                                        l();
                                    }
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                    i6 = this.D ? -f7 : this.V;
                    i4 = this.E ? -f10 : this.V;
                    this.c.postScale(i6, i4, c.q(this.x), c.r(this.x));
                    l();
                    this.c.mapRect(cropWindowRect);
                    if (z3 != 0) {
                        if (Float.compare(f, obj11) > 0) {
                            obj9 = bitmap;
                        } else {
                            obj9 /= i6;
                        }
                        this.W = obj9;
                        if (Float.compare(f2, obj9) > 0) {
                        } else {
                            bitmap = obj9 / i4;
                        }
                        this.a0 = bitmap;
                    } else {
                        this.W = obj9 /= i6;
                        this.a0 = obj9 /= i4;
                    }
                    this.c.postTranslate(obj10 *= i6, obj11 *= i4);
                    cropWindowRect.offset(obj9 *= i6, obj10 *= i4);
                    this.b.setCropWindowRect(cropWindowRect);
                    l();
                    this.b.invalidate();
                    if (z4) {
                        this.z.a(this.x, this.c);
                        this.a.startAnimation(this.z);
                    } else {
                        this.a.setImageMatrix(this.c);
                    }
                    u(false);
                }
            }
        }
    }

    private void e() {
        int i;
        Bitmap bitmap = this.A;
        if (bitmap != null) {
            if (this.H <= 0) {
                if (this.T != null) {
                    bitmap.recycle();
                }
            } else {
            }
        }
        int i2 = 0;
        this.A = i2;
        int i3 = 0;
        this.H = i3;
        this.T = i2;
        this.U = 1;
        this.C = i3;
        this.V = 1065353216;
        int i5 = 0;
        this.W = i5;
        this.a0 = i5;
        this.c.reset();
        this.e0 = i2;
        this.a.setImageBitmap(i2);
        r();
    }

    private static int j(int i, int i2, int i3) {
        int i4;
        int obj2;
        if (i == 1073741824) {
        } else {
            if (i == Integer.MIN_VALUE) {
                obj2 = Math.min(i3, i2);
            } else {
                obj2 = i3;
            }
        }
        return obj2;
    }

    private void k(boolean z, boolean z2) {
        int width;
        int height;
        Bitmap cropWindowRect;
        com.theartofdev.edmodo.cropper.e eVar;
        int i4;
        float cmp;
        int cmp3;
        float f3;
        int cmp2;
        float f;
        int i3;
        int i;
        int i2;
        float f2;
        boolean obj13;
        width = getWidth();
        height = getHeight();
        if (this.A != null && width > 0 && height > 0) {
            if (width > 0) {
                if (height > 0) {
                    cropWindowRect = this.b.getCropWindowRect();
                    i4 = 0;
                    if (z) {
                        if (Float.compare(obj13, i4) >= 0 && Float.compare(obj13, i4) >= 0 && Float.compare(obj13, i4) <= 0) {
                            if (Float.compare(obj13, i4) >= 0) {
                                if (Float.compare(obj13, i4) <= 0) {
                                    if (Float.compare(obj13, cropWindowRect) > 0) {
                                        height = 0;
                                        d((float)width, (float)height, height, height);
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                        f3 = 1065353216;
                        if (!this.M) {
                            if (Float.compare(f8, f3) > 0) {
                                f = (float)width;
                                i3 = 1056964608;
                                i = (float)height;
                                if (Float.compare(f5, f) < 0 && Float.compare(width2, i) < 0 && Float.compare(height3, i3) < 0) {
                                    f = (float)width;
                                    i3 = 1056964608;
                                    if (Float.compare(width2, i) < 0) {
                                        i = (float)height;
                                        if (Float.compare(height3, i3) < 0) {
                                            i2 = 1059313418;
                                            cmp = Math.min((float)i7, Math.min(f /= i14, i /= i3));
                                        } else {
                                            cmp = i4;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                                if (Float.compare(f9, f3) > 0) {
                                    i3 = (float)width;
                                    i = 1059481190;
                                    if (Float.compare(width4, i2) <= 0) {
                                        if (Float.compare(height4, i2) > 0) {
                                            cmp2 = 1057132380;
                                            cmp = Math.max(f3, Math.min(i3 /= i9, f7 /= i6));
                                        }
                                    } else {
                                    }
                                }
                                if (!this.M) {
                                } else {
                                    f3 = cmp;
                                }
                                if (Float.compare(f3, i4) > 0 && Float.compare(f3, f4) != 0 && z2 && this.z == null) {
                                    if (Float.compare(f3, f4) != 0) {
                                        if (z2) {
                                            if (this.z == null) {
                                                eVar = new e(this.a, this.b);
                                                this.z = eVar;
                                            }
                                            this.z.b(this.x, this.c);
                                        }
                                        this.V = f3;
                                        d((float)width, (float)height, true, z2);
                                    }
                                }
                            }
                        } else {
                        }
                    }
                    obj13 = this.Q;
                    if (obj13 != null && !z) {
                        if (!z) {
                            obj13.a();
                        }
                    }
                }
            }
        }
    }

    private void l() {
        float[] fArr = this.x;
        int i = 0;
        final int i3 = 0;
        fArr[i] = i3;
        final int i4 = 1;
        fArr[i4] = i3;
        final int i6 = 2;
        fArr[i6] = (float)width;
        float[] fArr2 = this.x;
        int i5 = 3;
        fArr2[i5] = i3;
        final int i8 = 4;
        fArr2[i8] = (float)width2;
        final int i9 = 5;
        this.x[i9] = (float)height;
        float[] fArr4 = this.x;
        int i7 = 6;
        fArr4[i7] = i3;
        final int i10 = 7;
        fArr4[i10] = (float)height2;
        this.c.mapPoints(this.x);
        float[] fArr5 = this.y;
        fArr5[i] = i3;
        fArr5[i4] = i3;
        int i2 = 1120403456;
        fArr5[i6] = i2;
        fArr5[i5] = i3;
        fArr5[i8] = i2;
        fArr5[i9] = i2;
        fArr5[i7] = i3;
        fArr5[i10] = i2;
        this.c.mapPoints(fArr5);
    }

    private void q(Bitmap bitmap, int i2, Uri uri3, int i4, int i5) {
        boolean equals;
        Object obj2;
        int obj3;
        Uri obj4;
        int obj5;
        equals = this.A;
        if (equals != null) {
            this.a.clearAnimation();
            e();
            this.A = bitmap;
            this.a.setImageBitmap(bitmap);
            this.T = uri3;
            this.H = i2;
            this.U = i4;
            this.C = i5;
            d((float)obj2, (float)obj3, true, false);
            obj2 = this.b;
            if (!equals.equals(bitmap) && obj2 != null) {
                this.a.clearAnimation();
                e();
                this.A = bitmap;
                this.a.setImageBitmap(bitmap);
                this.T = uri3;
                this.H = i2;
                this.U = i4;
                this.C = i5;
                d((float)obj2, (float)obj3, true, false);
                obj2 = this.b;
                if (obj2 != null) {
                    obj2.r();
                    r();
                }
            }
        } else {
        }
    }

    private void r() {
        int i;
        boolean z;
        final com.theartofdev.edmodo.cropper.CropOverlayView view = this.b;
        if (view != null) {
            if (this.K && this.A != null) {
                i = this.A != null ? 0 : 4;
            } else {
            }
            view.setVisibility(i);
        }
    }

    private void s() {
        int i;
        boolean z;
        int i2;
        if (this.L) {
            if (this.A == null) {
                if (this.f0 == null) {
                    i = this.g0 != null ? 1 : i2;
                } else {
                }
            } else {
            }
        } else {
        }
        if (i != 0) {
        } else {
            i2 = 4;
        }
        this.w.setVisibility(i2);
    }

    private void u(boolean z) {
        Bitmap bitmap;
        com.theartofdev.edmodo.cropper.CropOverlayView view;
        int i;
        float f2;
        float f;
        float[] obj6;
        if (this.A != null && !z) {
            if (!z) {
                int i4 = 1120403456;
                this.b.t((float)width2, (float)height2, i3 /= f5, i6 /= f4);
            }
        }
        obj6 = z ? 0 : this.x;
        this.b.s(obj6, getWidth(), getHeight());
    }

    @Override // android.widget.FrameLayout
    public void f() {
        final int i2 = 1;
        this.D = z ^= i2;
        d((float)width, (float)height, i2, false);
    }

    @Override // android.widget.FrameLayout
    public void g() {
        final int i2 = 1;
        this.E = z ^= i2;
        d((float)width, (float)height, i2, false);
    }

    public Pair<Integer, Integer> getAspectRatio() {
        Pair pair = new Pair(Integer.valueOf(this.b.getAspectRatioX()), Integer.valueOf(this.b.getAspectRatioY()));
        return pair;
    }

    @Override // android.widget.FrameLayout
    public float[] getCropPoints() {
        Matrix matrix;
        Matrix matrix2;
        int i;
        RectF cropWindowRect = this.b.getCropWindowRect();
        final int i2 = 8;
        final float[] fArr = new float[i2];
        float left = cropWindowRect.left;
        fArr[0] = left;
        float top = cropWindowRect.top;
        fArr[1] = top;
        float right = cropWindowRect.right;
        fArr[2] = right;
        fArr[3] = top;
        fArr[4] = right;
        float bottom = cropWindowRect.bottom;
        fArr[5] = bottom;
        fArr[6] = left;
        fArr[7] = bottom;
        this.c.invert(this.v);
        this.v.mapPoints(fArr);
        while (i < i2) {
            fArr[i] = f *= matrix2;
            i++;
        }
        return fArr;
    }

    @Override // android.widget.FrameLayout
    public Rect getCropRect() {
        int i = this.U;
        Bitmap bitmap = this.A;
        if (bitmap == null) {
            return null;
        }
        return c.s(getCropPoints(), width *= i, i *= height, this.b.m(), this.b.getAspectRatioX(), this.b.getAspectRatioY());
    }

    @Override // android.widget.FrameLayout
    public com.theartofdev.edmodo.cropper.CropImageView.c getCropShape() {
        return this.b.getCropShape();
    }

    @Override // android.widget.FrameLayout
    public RectF getCropWindowRect() {
        com.theartofdev.edmodo.cropper.CropOverlayView view = this.b;
        if (view == null) {
            return null;
        }
        return view.getCropWindowRect();
    }

    @Override // android.widget.FrameLayout
    public Bitmap getCroppedImage() {
        final int i = 0;
        return h(i, i, CropImageView.j.NONE);
    }

    @Override // android.widget.FrameLayout
    public void getCroppedImageAsync() {
        final int i = 0;
        i(i, i, CropImageView.j.NONE);
    }

    @Override // android.widget.FrameLayout
    public com.theartofdev.edmodo.cropper.CropImageView.d getGuidelines() {
        return this.b.getGuidelines();
    }

    @Override // android.widget.FrameLayout
    public int getImageResource() {
        return this.H;
    }

    @Override // android.widget.FrameLayout
    public Uri getImageUri() {
        return this.T;
    }

    @Override // android.widget.FrameLayout
    public int getMaxZoom() {
        return this.N;
    }

    @Override // android.widget.FrameLayout
    public int getRotatedDegrees() {
        return this.C;
    }

    @Override // android.widget.FrameLayout
    public com.theartofdev.edmodo.cropper.CropImageView.k getScaleType() {
        return this.I;
    }

    @Override // android.widget.FrameLayout
    public Rect getWholeImageRect() {
        int i = this.U;
        Bitmap bitmap = this.A;
        if (bitmap == null) {
            return null;
        }
        final int i5 = 0;
        Rect rect = new Rect(i5, i5, width *= i, height *= i);
        return rect;
    }

    @Override // android.widget.FrameLayout
    public Bitmap h(int i, int i2, com.theartofdev.edmodo.cropper.CropImageView.j cropImageView$j3) {
        Bitmap bitmap2;
        int i8;
        Bitmap bitmap;
        int sAMPLING;
        int i5;
        int i3;
        Object context;
        Uri cropPoints;
        float[] cropPoints2;
        int i6;
        int aspectRatioX2;
        int aspectRatioY;
        boolean z3;
        int aspectRatioX;
        int aspectRatioY2;
        int i4;
        int i7;
        boolean z;
        boolean z2;
        final Object obj = this;
        com.theartofdev.edmodo.cropper.CropImageView.j view = j3;
        if (obj.A != null) {
            obj.a.clearAnimation();
            com.theartofdev.edmodo.cropper.CropImageView.j nONE = CropImageView.j.NONE;
            z = view != nONE ? i : i5;
            if (view != nONE) {
                i5 = i2;
            }
            if (obj.T != null) {
                if (obj.U <= 1) {
                    if (view == CropImageView.j.SAMPLING) {
                        i8 = z;
                        bitmap = aVar.a;
                    } else {
                        i8 = z;
                        bitmap = aVar2.a;
                    }
                } else {
                }
            } else {
            }
            bitmap2 = c.y(bitmap, i8, i5, j3);
        } else {
            bitmap2 = 0;
        }
        return bitmap2;
    }

    @Override // android.widget.FrameLayout
    public void i(int i, int i2, com.theartofdev.edmodo.cropper.CropImageView.j cropImageView$j3) {
        if (this.S == null) {
        } else {
            this.t(i, i2, j3, 0, 0, 0);
        }
        IllegalArgumentException obj9 = new IllegalArgumentException("mOnCropImageCompleteListener is not set");
        throw obj9;
    }

    @Override // android.widget.FrameLayout
    void m(com.theartofdev.edmodo.cropper.a.a a$a) {
        com.theartofdev.edmodo.cropper.CropImageView.b view;
        Bitmap bitmap;
        Uri uri2;
        Bitmap bitmap2;
        Uri uri;
        Exception exc;
        float[] cropPoints;
        Rect cropRect;
        Rect wholeImageRect;
        int rotatedDegrees;
        int i;
        com.theartofdev.edmodo.cropper.CropImageView.b bVar;
        this.g0 = 0;
        s();
        com.theartofdev.edmodo.cropper.CropImageView.e view2 = this.S;
        if (view2 != null) {
            super(this.A, this.T, a.a, a.b, a.c, getCropPoints(), getCropRect(), getWholeImageRect(), getRotatedDegrees(), a.d);
            view2.b(this, bVar);
        }
    }

    @Override // android.widget.FrameLayout
    void n(com.theartofdev.edmodo.cropper.b.a b$a) {
        Object obj;
        Bitmap bitmap;
        int i2;
        Uri uri;
        int i3;
        int i;
        Object obj8;
        this.f0 = 0;
        s();
        if (a.e == null) {
            i = a.d;
            this.B = i;
            this.q(a.b, 0, a.a, a.c, i);
        }
        com.theartofdev.edmodo.cropper.CropImageView.i view = this.R;
        if (view != null) {
            view.a(this, a.a, a.e);
        }
    }

    @Override // android.widget.FrameLayout
    public void o(int i) {
        int i9;
        int i10;
        Bitmap bitmap;
        int i6;
        boolean z;
        float f2;
        int i13;
        RectF rectF;
        int i8;
        float height2;
        int i4;
        int i11;
        int i2;
        float height;
        float[] fArr;
        double d;
        int i12;
        int i7;
        int i3;
        int i5;
        float f4;
        float f3;
        float f;
        int obj20;
        final Object obj = this;
        i9 = i;
        if (obj.A != null) {
            i10 = i9 < 0 ? i17 + 360 : i9 % 360;
            int i21 = 1;
            int i24 = 0;
            if (!obj.b.m()) {
                if (i10 > 45) {
                    if (i10 >= 135) {
                        if (i10 > 215 && i10 < 305) {
                            i6 = i10 < 305 ? i21 : i24;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            rectF = c.c;
            rectF.set(obj.b.getCropWindowRect());
            if (i6 != 0) {
                height2 = rectF.height();
            } else {
                height2 = rectF.width();
            }
            i11 = 1073741824;
            if (i6 != 0) {
                height = rectF.width();
            } else {
                height = rectF.height();
            }
            height /= i11;
            if (i6 != 0) {
                obj.D = obj.E;
                obj.E = obj.D;
            }
            obj.c.invert(obj.v);
            float[] fArr2 = c.d;
            fArr2[i24] = rectF.centerX();
            fArr2[i21] = rectF.centerY();
            int i28 = 2;
            int i35 = 0;
            fArr2[i28] = i35;
            int i39 = 3;
            fArr2[i39] = i35;
            i12 = 4;
            i7 = 1065353216;
            fArr2[i12] = i7;
            i3 = 5;
            fArr2[i3] = i35;
            obj.v.mapPoints(fArr2);
            obj.C = i37 %= 360;
            obj.d((float)width, (float)height5, i21, i24);
            fArr = c.e;
            obj.c.mapPoints(fArr, fArr2);
            long l = 4611686018427387904L;
            float f8 = (float)i5;
            obj.V = f8;
            obj.V = Math.max(f8, i7);
            int i33 = 1;
            obj.d((float)width2, (float)height4, i33, false);
            obj.c.mapPoints(fArr, fArr2);
            double sqrt = Math.sqrt(d8 += d2);
            float f15 = (float)i26;
            float f13 = (float)i27;
            int i22 = 0;
            int i16 = 1;
            rectF.set(f16 -= f15, f19 -= f13, f20 += f15, f14 += f13);
            obj.b.r();
            obj.b.setCropWindowRect(rectF);
            i13 = 0;
            obj.d((float)width3, (float)height3, i16, i13);
            obj.k(i13, i13);
            obj.b.i();
        }
    }

    @Override // android.widget.FrameLayout
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i;
        int obj3;
        int obj4;
        int obj5;
        int obj6;
        int obj7;
        super.onLayout(z, i2, i3, i4, i5);
        final int i6 = 1;
        if (this.F > 0 && this.G > 0) {
            if (this.G > 0) {
                obj3 = getLayoutParams();
                obj3.width = this.F;
                obj3.height = this.G;
                setLayoutParams(obj3);
                if (this.A != null) {
                    obj3 = (float)obj6;
                    obj4 = (float)obj7;
                    obj5 = 0;
                    d(obj3, obj4, i6, obj5);
                    if (this.b0 != null) {
                        obj6 = this.c0;
                        if (obj6 != this.B) {
                            this.C = obj6;
                            d(obj3, obj4, i6, obj5);
                        }
                        this.c.mapRect(this.b0);
                        this.b.setCropWindowRect(this.b0);
                        k(obj5, obj5);
                        this.b.i();
                        this.b0 = 0;
                    } else {
                        if (this.d0) {
                            this.d0 = obj5;
                            k(obj5, obj5);
                        }
                    }
                } else {
                    u(i6);
                }
            } else {
                u(i6);
            }
        } else {
        }
    }

    @Override // android.widget.FrameLayout
    protected void onMeasure(int i, int i2) {
        int width2;
        int height;
        int cmp;
        int width;
        int height2;
        int i3;
        double d2;
        double d;
        int obj12;
        int obj13;
        super.onMeasure(i, i2);
        obj12 = View.MeasureSpec.getSize(i);
        obj13 = View.MeasureSpec.getSize(i2);
        width = this.A;
        if (width != null) {
            if (obj13 == null) {
                obj13 = width.getHeight();
            }
            long l = 9218868437227405312L;
            if (obj12 < this.A.getWidth()) {
                d5 /= d2;
            } else {
                i3 = l;
            }
            if (obj13 < this.A.getHeight()) {
                d6 /= d;
            } else {
                d2 = l;
            }
            if (Double.compare(i3, l) == 0) {
                if (Double.compare(d2, l) != 0) {
                    if (Double.compare(i3, d2) <= 0) {
                        height2 = (int)i4;
                        width = obj12;
                    } else {
                        width = (int)i5;
                        height2 = obj13;
                    }
                } else {
                    width = this.A.getWidth();
                    height2 = this.A.getHeight();
                }
            } else {
            }
            obj12 = CropImageView.j(View.MeasureSpec.getMode(i), obj12, width);
            obj13 = CropImageView.j(View.MeasureSpec.getMode(i2), obj13, height2);
            this.F = obj12;
            this.G = obj13;
            setMeasuredDimension(obj12, obj13);
        } else {
            setMeasuredDimension(obj12, obj13);
        }
    }

    @Override // android.widget.FrameLayout
    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean str;
        Parcelable parcelable3;
        WeakReference boolean;
        Object valueOf;
        String recycled;
        Object obj;
        Object first;
        int i;
        Parcelable parcelable2;
        int int;
        int i2;
        Object obj8;
        if (parcelable instanceof Bundle != null) {
            if (this.f0 == null && this.T == null && this.A == null && this.H == 0) {
                if (this.T == null) {
                    if (this.A == null) {
                        if (this.H == 0) {
                            parcelable3 = (Bundle)parcelable.getParcelable("LOADED_IMAGE_URI");
                            if ((Uri)parcelable3 != null) {
                                recycled = parcelable.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                                if (recycled != null) {
                                    first = c.g;
                                    i = 0;
                                    if (first != null && (String)first.first.equals(recycled)) {
                                        if ((String)first.first.equals(recycled)) {
                                            obj = recycled;
                                        } else {
                                            obj = i;
                                        }
                                    } else {
                                    }
                                    c.g = i;
                                    if (obj != null && !obj.isRecycled()) {
                                        if (!obj.isRecycled()) {
                                            this.q(obj, 0, (Uri)parcelable3, parcelable.getInt("LOADED_SAMPLE_SIZE"), 0);
                                        }
                                    }
                                }
                                if (this.T == null) {
                                    setImageUriAsync(parcelable3);
                                }
                            } else {
                                parcelable3 = parcelable.getInt("LOADED_IMAGE_RESOURCE");
                                if (parcelable3 > 0) {
                                    setImageResource(parcelable3);
                                } else {
                                    parcelable3 = parcelable.getParcelable("LOADING_IMAGE_URI");
                                    if ((Uri)parcelable3 != null) {
                                        setImageUriAsync((Uri)parcelable3);
                                    }
                                }
                            }
                            int int2 = parcelable.getInt("DEGREES_ROTATED");
                            this.c0 = int2;
                            this.C = int2;
                            Parcelable parcelable4 = parcelable.getParcelable("INITIAL_CROP_RECT");
                            if ((Rect)parcelable4 != null) {
                                if ((Rect)parcelable4.width() <= 0) {
                                    if (parcelable4.height() > 0) {
                                        this.b.setInitialCropWindowRect(parcelable4);
                                    }
                                } else {
                                }
                            }
                            Parcelable parcelable5 = parcelable.getParcelable("CROP_WINDOW_RECT");
                            if ((RectF)parcelable5 != null) {
                                obj = 0;
                                if (Float.compare(width, obj) <= 0) {
                                    if (Float.compare(height, obj) > 0) {
                                        this.b0 = parcelable5;
                                    }
                                } else {
                                }
                            }
                            this.b.setCropShape(CropImageView.c.valueOf(parcelable.getString("CROP_SHAPE")));
                            this.M = parcelable.getBoolean("CROP_AUTO_ZOOM_ENABLED");
                            this.N = parcelable.getInt("CROP_MAX_ZOOM");
                            this.D = parcelable.getBoolean("CROP_FLIP_HORIZONTALLY");
                            this.E = parcelable.getBoolean("CROP_FLIP_VERTICALLY");
                        }
                    }
                }
            }
            super.onRestoreInstanceState(parcelable.getParcelable("instanceState"));
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // android.widget.FrameLayout
    public Parcelable onSaveInstanceState() {
        Uri uri2;
        int context;
        Object weakReference;
        Uri uri;
        boolean str;
        WeakReference weakReference2;
        Bitmap bitmap;
        context = 1;
        if (this.T == null && this.A == null && this.H < context) {
            if (this.A == null) {
                if (this.H < context) {
                    return super.onSaveInstanceState();
                }
            }
        }
        Bundle bundle = new Bundle();
        if (this.J && this.T == null && this.H < context) {
            if (this.T == null) {
                if (this.H < context) {
                    this.e0 = c.D(getContext(), this.A, this.e0);
                }
            }
        }
        if (uri != null && this.A != null) {
            if (this.A != null) {
                context = UUID.randomUUID().toString();
                weakReference2 = new WeakReference(this.A);
                Pair pair = new Pair(context, weakReference2);
                c.g = pair;
                bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", context);
            }
        }
        weakReference = this.f0;
        weakReference = weakReference.get();
        if (weakReference != null && (b)weakReference != null) {
            weakReference = weakReference.get();
            if ((b)(b)weakReference != null) {
                bundle.putParcelable("LOADING_IMAGE_URI", (b)(b)weakReference.b());
            }
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", uri);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.H);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.U);
        bundle.putInt("DEGREES_ROTATED", this.C);
        bundle.putParcelable("INITIAL_CROP_RECT", this.b.getInitialCropWindowRect());
        RectF rectF = c.c;
        rectF.set(this.b.getCropWindowRect());
        this.c.invert(this.v);
        this.v.mapRect(rectF);
        bundle.putParcelable("CROP_WINDOW_RECT", rectF);
        bundle.putString("CROP_SHAPE", this.b.getCropShape().name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.M);
        bundle.putInt("CROP_MAX_ZOOM", this.N);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.D);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.E);
        return bundle;
    }

    @Override // android.widget.FrameLayout
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int obj1;
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 > 0 && i4 > 0) {
            obj1 = i4 > 0 ? 1 : 0;
        } else {
        }
        this.d0 = obj1;
    }

    @Override // android.widget.FrameLayout
    public void p(Uri uri, Bitmap.CompressFormat bitmap$CompressFormat2, int i3, int i4, int i5, com.theartofdev.edmodo.cropper.CropImageView.j cropImageView$j6) {
        if (this.S == null) {
        } else {
            this.t(i4, i5, j6, uri, compressFormat2, i3);
        }
        IllegalArgumentException obj8 = new IllegalArgumentException("mOnCropImageCompleteListener is not set");
        throw obj8;
    }

    @Override // android.widget.FrameLayout
    public void setAutoZoomEnabled(boolean z) {
        boolean obj2;
        if (this.M != z) {
            this.M = z;
            obj2 = 0;
            k(obj2, obj2);
            this.b.invalidate();
        }
    }

    @Override // android.widget.FrameLayout
    public void setCropRect(Rect rect) {
        this.b.setInitialCropWindowRect(rect);
    }

    @Override // android.widget.FrameLayout
    public void setCropShape(com.theartofdev.edmodo.cropper.CropImageView.c cropImageView$c) {
        this.b.setCropShape(c);
    }

    @Override // android.widget.FrameLayout
    public void setFixedAspectRatio(boolean z) {
        this.b.setFixedAspectRatio(z);
    }

    @Override // android.widget.FrameLayout
    public void setFlippedHorizontally(boolean z) {
        boolean z2;
        int i2;
        int i;
        boolean obj4;
        if (this.D != z) {
            this.D = z;
            d((float)obj4, (float)height, true, false);
        }
    }

    @Override // android.widget.FrameLayout
    public void setFlippedVertically(boolean z) {
        boolean z2;
        int i;
        int i2;
        boolean obj4;
        if (this.E != z) {
            this.E = z;
            d((float)obj4, (float)height, true, false);
        }
    }

    @Override // android.widget.FrameLayout
    public void setGuidelines(com.theartofdev.edmodo.cropper.CropImageView.d cropImageView$d) {
        this.b.setGuidelines(d);
    }

    @Override // android.widget.FrameLayout
    public void setImageBitmap(Bitmap bitmap) {
        this.b.setInitialCropWindowRect(0);
        this.q(bitmap, 0, 0, 1, 0);
    }

    @Override // android.widget.FrameLayout
    public void setImageResource(int i) {
        android.content.res.Resources resources;
        Object obj;
        Bitmap decodeResource;
        int i5;
        int i3;
        int i4;
        int i2;
        if (i != 0) {
            this.b.setInitialCropWindowRect(0);
            this.q(BitmapFactory.decodeResource(getResources(), i), i, 0, 1, 0);
        }
    }

    @Override // android.widget.FrameLayout
    public void setImageUriAsync(Uri uri) {
        Void[] arr;
        int i;
        java.util.concurrent.Executor tHREAD_POOL_EXECUTOR;
        com.theartofdev.edmodo.cropper.b bVar;
        Object obj4;
        if (uri != null) {
            WeakReference weakReference = this.f0;
            int i3 = 0;
            if (weakReference != null) {
                i = weakReference.get();
            } else {
                i = i3;
            }
            if (i != 0) {
                i.cancel(true);
            }
            e();
            this.b0 = i3;
            int i2 = 0;
            this.c0 = i2;
            this.b.setInitialCropWindowRect(i3);
            bVar = new b(this, uri);
            WeakReference weakReference2 = new WeakReference(bVar);
            this.f0 = weakReference2;
            (b)weakReference2.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[i2]);
            s();
        }
    }

    @Override // android.widget.FrameLayout
    public void setMaxZoom(int i) {
        int obj2;
        if (this.N != i && i > 0) {
            if (i > 0) {
                this.N = i;
                obj2 = 0;
                k(obj2, obj2);
                this.b.invalidate();
            }
        }
    }

    @Override // android.widget.FrameLayout
    public void setMultiTouchEnabled(boolean z) {
        boolean obj2;
        if (this.b.u(z)) {
            obj2 = 0;
            k(obj2, obj2);
            this.b.invalidate();
        }
    }

    @Override // android.widget.FrameLayout
    public void setOnCropImageCompleteListener(com.theartofdev.edmodo.cropper.CropImageView.e cropImageView$e) {
        this.S = e;
    }

    @Override // android.widget.FrameLayout
    public void setOnCropWindowChangedListener(com.theartofdev.edmodo.cropper.CropImageView.h cropImageView$h) {
        this.Q = h;
    }

    @Override // android.widget.FrameLayout
    public void setOnSetCropOverlayMovedListener(com.theartofdev.edmodo.cropper.CropImageView.f cropImageView$f) {
        this.P = f;
    }

    @Override // android.widget.FrameLayout
    public void setOnSetCropOverlayReleasedListener(com.theartofdev.edmodo.cropper.CropImageView.g cropImageView$g) {
        this.O = g;
    }

    @Override // android.widget.FrameLayout
    public void setOnSetImageUriCompleteListener(com.theartofdev.edmodo.cropper.CropImageView.i cropImageView$i) {
        this.R = i;
    }

    @Override // android.widget.FrameLayout
    public void setRotatedDegrees(int i) {
        int obj2;
        final int i2 = this.C;
        if (i2 != i) {
            o(i -= i2);
        }
    }

    @Override // android.widget.FrameLayout
    public void setSaveBitmapToInstanceState(boolean z) {
        this.J = z;
    }

    @Override // android.widget.FrameLayout
    public void setScaleType(com.theartofdev.edmodo.cropper.CropImageView.k cropImageView$k) {
        Object obj2;
        if (k != this.I) {
            this.I = k;
            this.V = 1065353216;
            obj2 = 0;
            this.a0 = obj2;
            this.W = obj2;
            this.b.r();
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout
    public void setShowCropOverlay(boolean z) {
        if (this.K != z) {
            this.K = z;
            r();
        }
    }

    @Override // android.widget.FrameLayout
    public void setShowProgressBar(boolean z) {
        if (this.L != z) {
            this.L = z;
            s();
        }
    }

    @Override // android.widget.FrameLayout
    public void setSnapRadius(float f) {
        int cmp;
        if (Float.compare(f, i) >= 0) {
            this.b.setSnapRadius(f);
        }
    }

    @Override // android.widget.FrameLayout
    public void t(int i, int i2, com.theartofdev.edmodo.cropper.CropImageView.j cropImageView$j3, Uri uri4, Bitmap.CompressFormat bitmap$CompressFormat5, int i6) {
        int i5;
        WeakReference weakReference;
        Object sAMPLING;
        Object obj;
        Object obj2;
        Object tHREAD_POOL_EXECUTOR;
        float[] cropPoints;
        Void[] arr;
        int i7;
        int i3;
        int aspectRatioX2;
        boolean aspectRatioY2;
        int aspectRatioX;
        int aspectRatioY;
        int i8;
        int i9;
        boolean z2;
        boolean z;
        Object view;
        Object obj3;
        int i10;
        int i4;
        com.theartofdev.edmodo.cropper.a aVar;
        WeakReference weakReference2;
        com.theartofdev.edmodo.cropper.a aVar2;
        WeakReference weakReference3;
        obj3 = this;
        view = j3;
        tHREAD_POOL_EXECUTOR = obj3.A;
        if (tHREAD_POOL_EXECUTOR != null) {
            obj3.a.clearAnimation();
            WeakReference weakReference4 = obj3.g0;
            if (weakReference4 != null) {
                i5 = weakReference4.get();
            } else {
                i5 = 0;
            }
            int i11 = 1;
            if (i5 != 0) {
                i5.cancel(i11);
            }
            com.theartofdev.edmodo.cropper.CropImageView.j nONE = CropImageView.j.NONE;
            i8 = view != nONE ? i : 0;
            i10 = view != nONE ? i2 : 0;
            int i13 = obj3.U;
            if (obj3.T != null) {
                if (i13 <= i11) {
                    if (view == CropImageView.j.SAMPLING) {
                        super(this, obj3.T, getCropPoints(), obj3.C, width * i12, height * i13, obj3.b.m(), obj3.b.getAspectRatioX(), obj3.b.getAspectRatioY(), i8, i10, obj3.D, obj3.E, j3, uri4, compressFormat5, i6);
                        weakReference = weakReference2;
                        super(aVar8);
                        obj3 = this;
                        obj3.g0 = weakReference;
                        obj2 = obj3;
                    } else {
                        super(this, tHREAD_POOL_EXECUTOR, getCropPoints(), obj3.C, obj3.b.m(), obj3.b.getAspectRatioX(), obj3.b.getAspectRatioY(), i8, i10, obj3.D, obj3.E, j3, uri4, compressFormat5, i6);
                        weakReference = weakReference3;
                        super(aVar7);
                        obj2.g0 = weakReference;
                    }
                } else {
                }
            } else {
            }
            (a)obj2.g0.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            s();
        } else {
            obj2 = obj3;
        }
    }
}
