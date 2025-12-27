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
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* compiled from: CropImageView.java */
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
    private CropImageView.k I;
    private boolean J = false;
    private boolean K = true;
    private boolean L = true;
    private boolean M = true;
    private int N;
    private CropImageView.g O;
    private CropImageView.f P;
    private CropImageView.h Q;
    private CropImageView.i R;
    private CropImageView.e S;
    private Uri T;
    private int U = 1;
    private float V = 1f;
    private float W;
    private final ImageView a;
    private float a0;
    private final CropOverlayView b;
    private RectF b0;
    private final Matrix c = new Matrix();
    private int c0;
    private boolean d0;
    private Uri e0;
    private WeakReference<b> f0;
    private WeakReference<a> g0;
    private final Matrix v = new Matrix();
    private final ProgressBar w;
    private final float[] x;
    private final float[] y;
    private e z;

    public static class b {

        private final Uri a;
        private final Uri b;
        private final Exception c;
        private final float[] v;
        private final Rect w;
        private final Rect x;
        private final int y;
        private final int z;
        b(Bitmap bitmap, Uri uri, Bitmap bitmap2, Uri uri2, Exception exc, float[] fArr, Rect rect, Rect rect2, int i, int i2) {
            super();
            this.a = uri;
            this.b = uri2;
            this.c = exc;
            this.v = fArr;
            this.w = rect;
            this.x = rect2;
            this.y = i;
            this.z = i2;
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

    public enum c {

        OVAL,
        RECTANGLE;
    }

    public enum d {

        OFF,
        ON,
        ON_TOUCH;
    }

    public interface e {
        void b(CropImageView cropImageView, CropImageView.b bVar);
    }

    public interface f {
        void a(Rect rect);
    }

    public interface g {
        void a(Rect rect);
    }

    public interface h {
        void a();
    }

    public interface i {
        void a(CropImageView cropImageView, Uri uri, Exception exc);
    }

    public enum j {

        NONE,
        RESIZE_EXACT,
        RESIZE_FIT,
        RESIZE_INSIDE,
        SAMPLING;
    }

    public enum k {

        CENTER,
        CENTER_CROP,
        CENTER_INSIDE,
        FIT_CENTER;
    }

    class a implements CropOverlayView.b {

        final /* synthetic */ CropImageView a;
        a() {
            this.a = cropImageView;
            super();
        }

        public void a(boolean z) {
            boolean z2 = true;
            this.a.k(z, z2);
            com.theartofdev.edmodo.cropper.CropImageView.g gVar = this.a.O;
            if (gVar != null && !z) {
                gVar.a(this.a.getCropRect());
            }
            com.theartofdev.edmodo.cropper.CropImageView.f fVar = this.a.P;
            if (fVar != null && z) {
                fVar.a(this.a.getCropRect());
            }
        }
    }
    public CropImageView(Context context, AttributeSet set) {
        int i;
        Intent intent;
        int i2;
        int i3 = 0;
        com.theartofdev.edmodo.cropper.f fVar;
        String str;
        super(context, set);
        Matrix matrix = new Matrix();
        Matrix matrix2 = new Matrix();
        int i4 = 8;
        this.x = new float[i4];
        this.y = new float[i4];
        i = 0;
        boolean z3 = true;
        i3 = 0;
        if (context instanceof Activity) {
            intent = (Activity)context.getIntent();
        } else {
        }
        if (intent != null && bundleExtra != null) {
        }
        if (i3 == 0) {
            fVar = new f();
            if (set != null) {
                TypedArray styledAttributes = context.obtainStyledAttributes(set, m.a, i, i);
                try {
                    i = m.l;
                    fVar.D = styledAttributes.getBoolean(i, fVar.D);
                    i2 = m.b;
                    fVar.E = styledAttributes.getInteger(i2, fVar.E);
                    fVar.F = styledAttributes.getInteger(m.c, fVar.F);
                    fVar.w = CropImageView.k.values()[styledAttributes.getInt(m.A, fVar.w.ordinal())];
                    fVar.z = styledAttributes.getBoolean(m.d, fVar.z);
                    fVar.A = styledAttributes.getBoolean(m.y, fVar.A);
                    fVar.B = styledAttributes.getInteger(m.t, fVar.B);
                    fVar.a = CropImageView.c.values()[styledAttributes.getInt(m.B, fVar.a.ordinal())];
                    fVar.v = CropImageView.d.values()[styledAttributes.getInt(m.n, fVar.v.ordinal())];
                    fVar.b = styledAttributes.getDimension(m.E, fVar.b);
                    fVar.c = styledAttributes.getDimension(m.F, fVar.c);
                    fVar.C = styledAttributes.getFloat(m.q, fVar.C);
                    fVar.G = styledAttributes.getDimension(m.k, fVar.G);
                    fVar.H = styledAttributes.getInteger(m.j, fVar.H);
                    int i16 = m.i;
                    fVar.I = styledAttributes.getDimension(i16, fVar.I);
                    fVar.J = styledAttributes.getDimension(m.h, fVar.J);
                    fVar.K = styledAttributes.getDimension(m.g, fVar.K);
                    fVar.L = styledAttributes.getInteger(m.f, fVar.L);
                    fVar.M = styledAttributes.getDimension(m.p, fVar.M);
                    fVar.N = styledAttributes.getInteger(m.o, fVar.N);
                    fVar.O = styledAttributes.getInteger(m.e, fVar.O);
                    fVar.x = styledAttributes.getBoolean(m.C, this.K);
                    fVar.y = styledAttributes.getBoolean(m.D, this.L);
                    fVar.I = styledAttributes.getDimension(i16, fVar.I);
                    fVar.P = (int)(styledAttributes.getDimension(m.x, (float)fVar.P));
                    fVar.Q = (int)(styledAttributes.getDimension(m.w, (float)fVar.Q));
                    fVar.R = (int)(styledAttributes.getFloat(m.v, (float)fVar.R));
                    fVar.S = (int)(styledAttributes.getFloat(m.u, (float)fVar.S));
                    fVar.T = (int)(styledAttributes.getFloat(m.s, (float)fVar.T));
                    fVar.U = (int)(styledAttributes.getFloat(m.r, (float)fVar.U));
                    int i29 = m.m;
                    fVar.k0 = styledAttributes.getBoolean(i29, fVar.k0);
                    fVar.l0 = styledAttributes.getBoolean(i29, fVar.l0);
                    this.J = styledAttributes.getBoolean(m.z, this.J);
                    if (styledAttributes.hasValue(i2) && styledAttributes.hasValue(m.b) && !styledAttributes.hasValue(m.l)) {
                        fVar.D = z3;
                    }
                } finally {
                    set.recycle();
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) context;
                }
                styledAttributes.recycle();
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
        View inflate = LayoutInflater.from(context).inflate(j.b, this, z3);
        View viewById2 = inflate.findViewById(i.c);
        this.a = viewById2;
        viewById2.setScaleType(ImageView.ScaleType.MATRIX);
        View viewById3 = inflate.findViewById(i.a);
        this.b = viewById3;
        viewById3.setCropWindowChangeListener(new CropImageView.a(this));
        viewById3.setInitialAttributeValues(fVar);
        this.w = (ProgressBar)inflate.findViewById(i.b);
        s();
    }

    static /* synthetic */ void a(CropImageView cropImageView, boolean z, boolean z2) {
        cropImageView.k(z, z2);
    }

    static /* synthetic */ CropImageView.g b(CropImageView cropImageView) {
        return cropImageView.O;
    }

    static /* synthetic */ CropImageView.f c(CropImageView cropImageView) {
        return cropImageView.P;
    }

    private void d(float f, float f2, boolean z, boolean z2) {
        float f3 = 0;
        int i;
        int i3;
        float f7;
        Matrix matrix;
        float f9;
        int cmp3;
        float f12;
        Matrix matrix2;
        float f14;
        float f13;
        if (this.A != null) {
            f3 = 0.0f;
            if (f > 0.0f) {
                if (f2 > 0.0f) {
                    this.c.invert(this.v);
                    RectF cropWindowRect = this.b.getCropWindowRect();
                    this.v.mapRect(cropWindowRect);
                    this.c.reset();
                    float f5 = 2f;
                    f4 = (f - (float)this.A.getWidth()) / f5;
                    f6 = (f2 - (float)this.A.getHeight()) / f5;
                    this.c.postTranslate(f4, f6);
                    l();
                    if (this.C > 0) {
                        this.c.postRotate((float)i2, c.q(this.x), c.r(this.x));
                        l();
                    }
                    float min = Math.min(f / c.x(this.x), f2 / c.t(this.x));
                    if (this.I != CropImageView.k.FIT_CENTER) {
                        f9 = 1f;
                        if (this.I == CropImageView.k.CENTER_INSIDE) {
                            if (min >= f9) {
                                if (min > f9 && this.M) {
                                    this.c.postScale(min, min, c.q(this.x), c.r(this.x));
                                    l();
                                }
                            }
                        }
                    }
                    i = this.D ? -f17 : this.V;
                    i3 = this.E ? -f24 : this.V;
                    this.c.postScale(i, i3, c.q(this.x), c.r(this.x));
                    l();
                    this.c.mapRect(cropWindowRect);
                    if (z) {
                        float f47 = c.x(this.x);
                        if (f > f47) {
                        } else {
                            f14 = (float)getWidth() - c.v(this.x);
                            f3 = (Math.max(Math.min((f / f5) - cropWindowRect.centerX(), -c.u(this.x)), f14)) / i;
                        }
                        this.W = f3;
                        float f32 = c.t(this.x);
                        if (f2 <= f32) {
                            f12 = (float)getHeight() - c.p(this.x);
                            f3 = (Math.max(Math.min((f2 / f5) - cropWindowRect.centerY(), -c.w(this.x)), f12)) / i3;
                        }
                        this.a0 = f3;
                    } else {
                        f3 = -cropWindowRect.right + f;
                        this.W = (Math.min(Math.max(this.W * i, -cropWindowRect.left), f3)) / i;
                        f14 = -cropWindowRect.bottom + f2;
                        f11 = (Math.min(Math.max(this.a0 * i3, -cropWindowRect.top), f14)) / i3;
                        this.a0 = f11;
                    }
                    f13 = this.a0 * i3;
                    this.c.postTranslate(this.W * i, f13);
                    cropWindowRect.offset(this.W * i, this.a0 * i3);
                    this.b.setCropWindowRect(cropWindowRect);
                    l();
                    this.b.invalidate();
                    if (z2) {
                        this.z.a(this.x, this.c);
                        this.a.startAnimation(this.z);
                    } else {
                        this.a.setImageMatrix(this.c);
                    }
                    z = false;
                    u(z);
                }
            }
        }
    }

    private void e() {
        int i;
        if (this.A != null && this.H <= 0 && this.T != null) {
            this.A.recycle();
        }
        Bitmap bitmap2 = null;
        this.A = bitmap2;
        int i2 = 0;
        this.H = i2;
        this.T = bitmap2;
        this.U = 1;
        this.C = i2;
        this.V = 1f;
        float f = 0.0f;
        this.W = f;
        this.a0 = f;
        this.c.reset();
        this.e0 = bitmap2;
        this.a.setImageBitmap(bitmap2);
        r();
    }

    private static int j(int i, int i2, int i3) {
        int i32;
        int i4 = 1073741824;
        if (i != 1073741824) {
            i4 = Integer.MIN_VALUE;
            if (i == Integer.MIN_VALUE) {
                i32 = Math.min(i3, i2);
            } else {
                i32 = i3;
            }
        }
        return i32;
    }

    private void k(boolean z, boolean z2) {
        int width;
        int height = 0;
        int cmp = 1;
        RectF cropWindowRect;
        float min = 0;
        float min2;
        int cmp3 = 1057132380;
        float f = 1056964608;
        float f2;
        float f3 = 1059313418;
        float f4;
        width = getWidth();
        height = getHeight();
        if (this.A != null && width > 0 && height > 0) {
            cropWindowRect = this.b.getCropWindowRect();
            min = 0.0f;
            if (z) {
                if (cropWindowRect.left >= 0.0f) {
                    if (cropWindowRect.top >= 0.0f) {
                        min = (float)width;
                        if (cropWindowRect.right <= 0.0f) {
                            float f11 = (float)height;
                            if (cropWindowRect.bottom > this.b) {
                                boolean z4 = false;
                                d((float)width, (float)height, z4, z4);
                            }
                        }
                    }
                }
            } else {
                min = 1f;
                if (!this.M) {
                    if (this.V > min) {
                        min2 = (float)this.N;
                        if (this.V < this.N) {
                            float width2 = cropWindowRect.width();
                            min2 = (float)width;
                            f = 0.5f;
                            f2 = min2 * f;
                            if (width2 < f2) {
                                float height3 = cropWindowRect.height();
                                f2 = (float)height;
                                f = f * f2;
                                if (height3 < 0.5f) {
                                    f3 = 0.64f;
                                    f = (cropWindowRect.height() / this.V) / f3;
                                    f2 = f2 / f;
                                    min = Math.min((float)this.N, Math.min(min2 / (cropWindowRect.width() / this.V) / f3, f2));
                                } else {
                                }
                            }
                        }
                        if (this.V > min) {
                            float width4 = cropWindowRect.width();
                            f = (float)width;
                            f2 = 0.65f;
                            f3 = f * f2;
                            if (width4 <= f3) {
                                float height4 = cropWindowRect.height();
                                f3 = (float)height * f2;
                                if (height4 > f3) {
                                    float f22 = 0.51f;
                                    f = f / (cropWindowRect.width() / this.V) / f22;
                                    min = Math.max(min, Math.min(f, (float)height / (cropWindowRect.height() / this.V) / f22));
                                }
                            }
                        }
                        if (this.M) {
                        }
                        if (min > 0.0f && min != this.V) {
                            if (cropWindowRect.top && this.z == null) {
                                this.z = new e(this.a, this.b);
                                this.z.b(this.x, this.c);
                            }
                            this.V = min;
                            d((float)width, (float)height, true, z2);
                        }
                    }
                }
            }
            if (this.Q != null && !z) {
                this.Q.a();
            }
        }
    }

    private void l() {
        int i = 0;
        final float f2 = 0.0f;
        this.x[i] = f2;
        final int i2 = 1;
        this.x[i2] = f2;
        final int i4 = 2;
        this.x[i4] = (float)this.A.getWidth();
        int i3 = 3;
        this.x[i3] = f2;
        final int i6 = 4;
        this.x[i6] = (float)this.A.getWidth();
        final int i7 = 5;
        this.x[i7] = (float)this.A.getHeight();
        int i5 = 6;
        this.x[i5] = f2;
        final int i8 = 7;
        this.x[i8] = (float)this.A.getHeight();
        this.c.mapPoints(this.x);
        this.y[i] = f2;
        this.y[i2] = f2;
        float f = 100f;
        this.y[i4] = f;
        this.y[i3] = f2;
        this.y[i6] = f;
        this.y[i7] = f;
        this.y[i5] = f2;
        this.y[i8] = f;
        this.c.mapPoints(this.y);
    }

    private void q(Bitmap bitmap, int i, Uri uri, int i2, int i3) {
        if (this.A == null || !this.A.equals(bitmap)) {
            this.a.clearAnimation();
            e();
            this.A = bitmap;
            this.a.setImageBitmap(bitmap);
            this.T = uri;
            this.H = i;
            this.U = i2;
            this.C = i3;
            f = (float)getHeight();
            boolean z = true;
            boolean z2 = false;
            d((float)getWidth(), f, z, z2);
            if (this.b != null) {
                this.b.r();
                r();
            }
        }
    }

    private void r() {
        int i = 4;
        if (this.b != null && this.K) {
            int r1 = this.A != null ? 0 : 4;
            this.b.setVisibility((this.A != null ? 0 : 4));
        }
    }

    private void s() {
        int i = 1;
        i = 0;
        if (!this.L || this.A == null) {
        } else {
            int r0 = 1;
        }
        if (this.g0 == 0) {
            i = 4;
        }
        this.w.setVisibility(i);
    }

    private void u(boolean z) {
        float[] fArr = null;
        if (this.A != null && !z) {
            float f7 = 100f;
            f = (float)this.U * f7 / c.t(this.y);
            f2 = (float)getWidth();
            f3 = (float)getHeight();
            this.b.t(f2, f3, (float)this.U * f7 / c.x(this.y), f);
        }
        z = z ? 0 : this.x;
        this.b.s((z ? 0 : this.x), this.getWidth(), this.getHeight());
    }

    @Override // android.widget.FrameLayout
    public void f() {
        final boolean z2 = true;
        this.D ^= z2;
        d((float)getWidth(), (float)getHeight(), z2, false);
    }

    @Override // android.widget.FrameLayout
    public void g() {
        final boolean z2 = true;
        this.E ^= z2;
        d((float)getWidth(), (float)getHeight(), z2, false);
    }

    @Override // android.widget.FrameLayout
    public Pair<Integer, Integer> getAspectRatio() {
        return new Pair(Integer.valueOf(this.b.getAspectRatioX()), Integer.valueOf(this.b.getAspectRatioY()));
    }

    @Override // android.widget.FrameLayout
    public float[] getCropPoints() {
        int i = 0;
        RectF cropWindowRect = this.b.getCropWindowRect();
        final int i2 = 8;
        final float[] fArr = new float[i2];
        i = 0;
        fArr[i] = cropWindowRect.left;
        fArr[1] = cropWindowRect.top;
        fArr[2] = cropWindowRect.right;
        fArr[3] = cropWindowRect.top;
        fArr[4] = cropWindowRect.right;
        fArr[5] = cropWindowRect.bottom;
        fArr[6] = cropWindowRect.left;
        fArr[7] = cropWindowRect.bottom;
        this.c.invert(this.v);
        this.v.mapPoints(fArr);
        while (i < i2) {
            matrix2 = (float)this.U;
            matrix = fArr[i] * matrix2;
            fArr[i] = matrix;
            i = i + 1;
        }
        return fArr;
    }

    @Override // android.widget.FrameLayout
    public Rect getCropRect() {
        if (this.A == null) {
            return null;
        }
        return c.s(cropPoints, i2, i, this.b.m(), this.b.getAspectRatioX(), this.b.getAspectRatioY());
    }

    @Override // android.widget.FrameLayout
    public CropImageView.c getCropShape() {
        return this.b.getCropShape();
    }

    @Override // android.widget.FrameLayout
    public RectF getCropWindowRect() {
        if (this.b == null) {
            return null;
        }
        return this.b.getCropWindowRect();
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
    public CropImageView.d getGuidelines() {
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
    public CropImageView.k getScaleType() {
        return this.I;
    }

    @Override // android.widget.FrameLayout
    public Rect getWholeImageRect() {
        if (this.A == null) {
            return null;
        }
        final int i5 = 0;
        return new Rect(i5, i5, this.A.getWidth() * i, this.A.getHeight() * i);
    }

    @Override // android.widget.FrameLayout
    public Bitmap h(int i, int i2, CropImageView.j jVar) {
        Bitmap bitmap = null;
        int i22;
        Bitmap bitmap2;
        Uri uri2;
        float[] cropPoints;
        int i5;
        int aspectRatioX;
        int aspectRatioY;
        boolean z2;
        int aspectRatioX2;
        int aspectRatioY2;
        boolean z;
        boolean z3;
        final Object i6 = this;
        com.theartofdev.edmodo.cropper.CropImageView.j jVar32 = jVar;
        if (i6.A != null) {
            i6.a.clearAnimation();
            com.theartofdev.edmodo.cropper.CropImageView.j nONE2 = CropImageView.j.NONE;
            i22 = 0;
            int r15 = jVar32 != CropImageView.j.NONE ? i : 0;
            if (jVar32 != CropImageView.j.NONE) {
                i22 = i2;
            }
            if (i6.T == null) {
            } else {
                int i4 = 1;
                if (i6.U > 1 || jVar32 == CropImageView.j.SAMPLING) {
                    aspectRatioX = i6.A.getWidth() * i6.U;
                    aspectRatioY = i6.A.getHeight() * i6.U;
                }
            }
            bitmap = c.y(bitmap2, i22, i22, jVar);
        } else {
            int i7 = 0;
        }
        return bitmap;
    }

    @Override // android.widget.FrameLayout
    public void i(int i, int i2, CropImageView.j jVar) {
        if (this.S == null) {
            throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
        } else {
            this.t(i, i2, jVar, null, null, 0);
            return;
        }
    }

    @Override // android.widget.FrameLayout
    void m(a.a aVar) {
        this.g0 = null;
        s();
        if (this.S != null) {
            CropImageView.b bVar = new CropImageView.b(this.A, this.T, aVar.a, aVar.b, aVar.c, getCropPoints(), getCropRect(), getWholeImageRect(), getRotatedDegrees(), aVar.d);
            this.S.b(this, bVar);
        }
    }

    @Override // android.widget.FrameLayout
    void n(b.a aVar) {
        Object obj;
        this.f0 = null;
        s();
        if (aVar.e == null) {
            this.B = aVar.d;
            int i = 0;
            this.q(aVar.b, i, aVar.a, aVar.c, aVar.d);
        }
        if (this.R != null) {
            this.R.a(this, aVar.a, aVar.e);
        }
    }

    @Override // android.widget.FrameLayout
    public void o(int i) {
        int i3;
        int i4;
        float height;
        float height2;
        final Object i9 = this;
        i2 = i;
        if (i9.A != null && i2 < 0) {
            i3 = (i2 % 360) + 360;
            i4 = 1;
            i4 = 0;
            if (i9.b.m() || i3 > 45) {
            } else {
                int i5 = 135;
                int r2 = i4;
            }
            rectF = c.c;
            c.c.set(i9.b.getCropWindowRect());
            if (i9.A != 0) {
                height = c.c.height();
            } else {
                height = c.c.width();
            }
            float f4 = 2f;
            if (i9.A != 0) {
                height2 = c.c.width();
            } else {
                height2 = c.c.height();
            }
            height2 /= f4;
            if (i9.A != 0) {
                i9.D = i9.E;
                i9.E = i9.D;
            }
            i9.c.invert(i9.v);
            float[] fArr2 = c.d;
            fArr2[i4] = c.c.centerX();
            fArr2[i4] = c.c.centerY();
            int i15 = 2;
            float f32 = 0.0f;
            fArr2[i15] = f32;
            int i20 = 3;
            fArr2[i20] = f32;
            int i7 = 4;
            float f6 = 1f;
            fArr2[i7] = f6;
            int i8 = 5;
            fArr2[i8] = f32;
            i9.v.mapPoints(fArr2);
            i9.C = (i9.C + i3) % 360;
            i9.d((float)getWidth(), (float)getHeight(), true, false);
            fArr = c.e;
            i9.c.mapPoints(fArr, fArr2);
            double d3 = 2d;
            d2 = (double)i9.V / (Math.sqrt((Math.pow((double)(fArr[i7] - fArr[i15]), d3)) + (Math.pow((double)(fArr[i8] - fArr[i20]), d3))));
            float f15 = (float)d2;
            i9.V = f15;
            i9.V = Math.max(f15, f6);
            boolean z5 = true;
            i9.d((float)getWidth(), (float)getHeight(), z5, false);
            i9.c.mapPoints(fArr, fArr2);
            d = (double)(fArr[i8] - fArr[3]);
            double sqrt = Math.sqrt((Math.pow((double)(fArr[4] - fArr[2]), d3)) + (Math.pow(d, d3)));
            float f25 = (float)(double)(height / f4) * sqrt;
            float f21 = (float)(double)i6 * sqrt;
            int i14 = 0;
            f2 = fArr[i14] - f25;
            int i10 = 1;
            f3 = fArr[i10] - f21;
            f5 = fArr[i14] + f25;
            c.c.set(f2, f3, f5, fArr[i10] + f21);
            i9.b.r();
            i9.b.setCropWindowRect(c.c);
            f = (float)getHeight();
            boolean z2 = false;
            i9.d((float)getWidth(), f, true, z2);
            i9.k(z2, z2);
            i9.b.i();
        }
    }

    @Override // android.widget.FrameLayout
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i6;
        super.onLayout(z, i, i2, i3, i4);
        final boolean z3 = true;
        if (this.F <= 0 || this.G <= 0) {
            u(z3);
        } else {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = this.F;
            layoutParams.height = this.G;
            setLayoutParams(layoutParams);
            if (this.A == null) {
                u(z3);
            } else {
                float f2 = (float)(i3 - i);
                i7 = i4 - i2;
                f = (float)i7;
                boolean z2 = false;
                d(f2, f, z3, z2);
                if (this.b0 != null) {
                    if (this.c0 != this.B) {
                        this.C = this.c0;
                        d(f2, f, z3, z2);
                    }
                    this.c.mapRect(this.b0);
                    this.b.setCropWindowRect(this.b0);
                    k(z2, z2);
                    this.b.i();
                    this.b0 = null;
                } else {
                    if (this.d0) {
                        this.d0 = z2;
                        k(z2, z2);
                    }
                }
            }
        }
    }

    @Override // android.widget.FrameLayout
    protected void onMeasure(int i, int i2) {
        int i3;
        int i22;
        double d;
        double d3;
        double d4;
        super.onMeasure(i, i2);
        i3 = View.MeasureSpec.getSize(i);
        i22 = View.MeasureSpec.getSize(i2);
        if (this.A != null) {
            if (i22 == 0) {
                i22 = this.A.getHeight();
            }
            double d9 = Double.POSITIVE_INFINITY;
            if (i3 < this.A.getWidth()) {
                d2 = (double)this.A.getWidth();
                d = (double)i3 / d2;
            } else {
                long l = d9;
            }
            if (i22 < this.A.getHeight()) {
                d4 = (double)this.A.getHeight();
                d3 = (double)i22 / d4;
            } else {
                long l2 = d9;
            }
            if (d == Double.POSITIVE_INFINITY) {
                if (d3 != Double.POSITIVE_INFINITY) {
                    if (d <= d3) {
                        i22 = (int)(double)this.A.getHeight() * d;
                    } else {
                        i3 = (int)(double)this.A.getWidth() * d3;
                    }
                } else {
                    i3 = this.A.getWidth();
                    i22 = this.A.getHeight();
                }
            }
            i3 = CropImageView.j(View.MeasureSpec.getMode(i), i3, i3);
            i22 = CropImageView.j(View.MeasureSpec.getMode(i2), i22, i22);
            this.F = i3;
            this.G = i22;
            setMeasuredDimension(i3, i22);
        } else {
            setMeasuredDimension(i3, i22);
        }
    }

    @Override // android.widget.FrameLayout
    public void onRestoreInstanceState(Parcelable parcelable) {
        Object obj;
        String string;
        Uri uri;
        int cmp;
        com.theartofdev.edmodo.cropper.CropImageView.c str;
        Bitmap bitmap;
        Pair pair2 = null;
        Object obj2;
        int _int;
        int i = 0;
        z = parcelable instanceof Bundle;
        if (parcelable instanceof Bundle) {
            if (this.f0 == null && this.T == null && this.A == null && this.H == 0) {
                Parcelable parcelable2 = parcelable.getParcelable("LOADED_IMAGE_URI");
                if (parcelable2 != null) {
                    string = parcelable.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                    if (string != null) {
                        pair = c.g;
                        pair2 = null;
                        if (c.g != null) {
                            if ((String)c.g.first.equals(string)) {
                            } else {
                                int i3 = pair2;
                            }
                        }
                        c.g = pair2;
                        if (pair.first != null && !pair.first.isRecycled()) {
                            i = 0;
                            this.q(bitmap, 0, parcelable2, parcelable.getInt("LOADED_SAMPLE_SIZE"), i);
                        }
                    }
                    if (this.T == null) {
                        setImageUriAsync(parcelable2);
                    }
                } else {
                    int _int4 = parcelable.getInt("LOADED_IMAGE_RESOURCE");
                    if (_int4 > 0) {
                        setImageResource(_int4);
                    } else {
                        parcelable2 = parcelable.getParcelable("LOADING_IMAGE_URI");
                        if (parcelable2 != null) {
                            setImageUriAsync(parcelable2);
                        }
                    }
                }
                int _int2 = parcelable.getInt("DEGREES_ROTATED");
                this.c0 = _int2;
                this.C = _int2;
                Parcelable parcelable4 = parcelable.getParcelable("INITIAL_CROP_RECT");
                if (parcelable4 != null) {
                    if (parcelable4.width() > 0 || parcelable4.height() > 0) {
                        this.b.setInitialCropWindowRect(parcelable4);
                    }
                }
                Parcelable parcelable5 = parcelable.getParcelable("CROP_WINDOW_RECT");
                if (parcelable5 != null) {
                    float width = parcelable5.width();
                    float f = 0.0f;
                    if (width <= 0.0f) {
                        float height2 = parcelable5.height();
                        if (height2 > 0.0f) {
                            this.b0 = parcelable5;
                        }
                    }
                }
                this.b.setCropShape(CropImageView.c.valueOf(parcelable.getString("CROP_SHAPE")));
                this.M = parcelable.getBoolean("CROP_AUTO_ZOOM_ENABLED");
                this.N = parcelable.getInt("CROP_MAX_ZOOM");
                this.D = parcelable.getBoolean("CROP_FLIP_HORIZONTALLY");
                this.E = parcelable.getBoolean("CROP_FLIP_VERTICALLY");
            }
            super.onRestoreInstanceState(parcelable.getParcelable("instanceState"));
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // android.widget.FrameLayout
    public Parcelable onSaveInstanceState() {
        int i = 1;
        Object obj2;
        boolean z;
        i = 1;
        if (this.T == null && this.A == null && this.H < i) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        if (this.J && this.T == null && this.H < i) {
            this.e0 = c.D(getContext(), this.A, this.e0);
        }
        if (this.T != null && this.A != null) {
            String uuid2 = UUID.randomUUID().toString();
            c.g = new Pair(uuid2, new WeakReference(this.A));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", uuid2);
        }
        if (this.f0 != null) {
            Object obj = this.f0.get();
            if (obj != null) {
                bundle.putParcelable("LOADING_IMAGE_URI", obj.b());
            }
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", obj2);
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
        int i5 = 0;
        super.onSizeChanged(i, i2, i3, i4);
        i = i3 > 0 && i4 > 0 ? 1 : 0;
        this.d0 = (i3 > 0 && i4 > 0 ? 1 : 0);
    }

    @Override // android.widget.FrameLayout
    public void p(Uri uri, Bitmap.CompressFormat compressFormat, int i, int i2, int i3, CropImageView.j jVar) {
        if (this.S == null) {
            throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
        } else {
            this.t(i2, i3, jVar, uri, compressFormat, i);
            return;
        }
    }

    @Override // android.widget.FrameLayout
    public void setAutoZoomEnabled(boolean z) {
        if (this.M != z) {
            this.M = z;
            boolean z3 = false;
            k(z3, z3);
            this.b.invalidate();
        }
    }

    @Override // android.widget.FrameLayout
    public void setCropRect(Rect rect) {
        this.b.setInitialCropWindowRect(rect);
    }

    @Override // android.widget.FrameLayout
    public void setCropShape(CropImageView.c cVar) {
        this.b.setCropShape(cVar);
    }

    @Override // android.widget.FrameLayout
    public void setFixedAspectRatio(boolean z) {
        this.b.setFixedAspectRatio(z);
    }

    @Override // android.widget.FrameLayout
    public void setFlippedHorizontally(boolean z) {
        if (this.D != z) {
            this.D = z;
            f = (float)getWidth();
            boolean z3 = true;
            boolean z4 = false;
            d(f, (float)getHeight(), z3, z4);
        }
    }

    @Override // android.widget.FrameLayout
    public void setFlippedVertically(boolean z) {
        if (this.E != z) {
            this.E = z;
            f = (float)getWidth();
            boolean z3 = true;
            boolean z4 = false;
            d(f, (float)getHeight(), z3, z4);
        }
    }

    @Override // android.widget.FrameLayout
    public void setGuidelines(CropImageView.d dVar) {
        this.b.setGuidelines(dVar);
    }

    @Override // android.widget.FrameLayout
    public void setImageBitmap(Bitmap bitmap) {
        this.b.setInitialCropWindowRect(null);
        this.q(bitmap, 0, null, 1, 0);
    }

    @Override // android.widget.FrameLayout
    public void setImageResource(int i) throws android.content.res.Resources.NotFoundException {
        if (i != 0) {
            this.b.setInitialCropWindowRect(null);
            Uri uri = null;
            int i3 = 1;
            int i4 = 0;
            this.q(BitmapFactory.decodeResource(getResources(), i), i, uri, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout
    public void setImageUriAsync(Uri uri) {
        int i;
        if (uri != null) {
            RectF rectF = null;
            Object obj2 = this.f0 != null ? (b)obj2 : rectF;
            if (this.f0 != 0) {
                boolean z = true;
                i.cancel(z);
            }
            e();
            this.b0 = rectF;
            int i2 = 0;
            this.c0 = i2;
            this.b.setInitialCropWindowRect(rectF);
            WeakReference weakReference2 = new WeakReference(new b(this, uri));
            this.f0 = weakReference2;
            (b)weakReference2.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[i2]);
            s();
        }
    }

    @Override // android.widget.FrameLayout
    public void setMaxZoom(int i) {
        if (this.N != i && i > 0) {
            this.N = i;
            boolean z = false;
            k(z, z);
            this.b.invalidate();
        }
    }

    @Override // android.widget.FrameLayout
    public void setMultiTouchEnabled(boolean z) {
        if (this.b.u(z)) {
            boolean z3 = false;
            k(z3, z3);
            this.b.invalidate();
        }
    }

    @Override // android.widget.FrameLayout
    public void setOnCropImageCompleteListener(CropImageView.e eVar) {
        this.S = eVar;
    }

    @Override // android.widget.FrameLayout
    public void setOnCropWindowChangedListener(CropImageView.h hVar) {
        this.Q = hVar;
    }

    @Override // android.widget.FrameLayout
    public void setOnSetCropOverlayMovedListener(CropImageView.f fVar) {
        this.P = fVar;
    }

    @Override // android.widget.FrameLayout
    public void setOnSetCropOverlayReleasedListener(CropImageView.g gVar) {
        this.O = gVar;
    }

    @Override // android.widget.FrameLayout
    public void setOnSetImageUriCompleteListener(CropImageView.i iVar) {
        this.R = iVar;
    }

    @Override // android.widget.FrameLayout
    public void setRotatedDegrees(int i) {
        if (this.C != i) {
            i2 = i - i3;
            o(i2);
        }
    }

    @Override // android.widget.FrameLayout
    public void setSaveBitmapToInstanceState(boolean z) {
        this.J = z;
    }

    @Override // android.widget.FrameLayout
    public void setScaleType(CropImageView.k kVar) {
        if (kVar != this.I) {
            this.I = kVar;
            this.V = 1f;
            float f = 0.0f;
            this.a0 = f;
            this.W = f;
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
        if (f >= 0) {
            this.b.setSnapRadius(f);
        }
    }

    @Override // android.widget.FrameLayout
    public void t(int i, int i2, CropImageView.j jVar, Uri uri, Bitmap.CompressFormat compressFormat, int i3) {
        com.theartofdev.edmodo.cropper.CropImageView cropImageView;
        int i4;
        int i5;
        int aspectRatioX;
        boolean z;
        int i7;
        int i22;
        boolean z5;
        boolean z4;
        com.theartofdev.edmodo.cropper.CropImageView.j jVar32;
        Bitmap.CompressFormat compressFormat52;
        int i62;
        com.theartofdev.edmodo.cropper.a aVar;
        WeakReference weakReference;
        com.theartofdev.edmodo.cropper.a aVar2;
        Object obj2 = this;
        jVar32 = jVar;
        if (obj2.A != null) {
            obj2.a.clearAnimation();
            Object obj3 = obj2.g0 != null ? (a)obj3 : 0;
            boolean z6 = true;
            if (obj2.a != 0) {
                i3.cancel(z6);
            }
            com.theartofdev.edmodo.cropper.CropImageView.j nONE2 = CropImageView.j.NONE;
            int r10 = jVar32 != CropImageView.j.NONE ? i : 0;
            int r16 = jVar32 != CropImageView.j.NONE ? i2 : 0;
            i5 = obj2.A.getWidth() * obj2.U;
            aspectRatioX = obj2.A.getHeight() * i9;
            if (obj2.T == null || obj2.U <= z6) {
                aVar2 = new a(this, bitmap, getCropPoints(), obj2.C, obj2.b.m(), obj2.b.getAspectRatioX(), obj2.b.getAspectRatioY(), i7, i22, z3, z2, jVar, uri, compressFormat, i3);
                weakReference = new WeakReference(aVar2);
                this.g0 = weakReference;
            } else {
                if (jVar32 == CropImageView.j.SAMPLING) {
                    aVar = new a(this, obj2.T, getCropPoints(), obj2.C, obj2.A.getWidth() * obj2.U, obj2.A.getHeight() * i9, obj2.b.m(), obj2.b.getAspectRatioX(), obj2.b.getAspectRatioY(), i7, i22, obj2.D, z4, jVar, uri, compressFormat, i3);
                    weakReference = new WeakReference(aVar);
                    cropImageView = this;
                    cropImageView.g0 = weakReference;
                }
            }
            (a)cropImageView.g0.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            s();
        } else {
        }
    }
}
