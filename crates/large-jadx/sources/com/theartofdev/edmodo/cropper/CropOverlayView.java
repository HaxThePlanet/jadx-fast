package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.ViewParent;
import java.util.Arrays;

/* compiled from: CropOverlayView.java */
/* loaded from: classes2.dex */
public class CropOverlayView extends View {

    private Paint A;
    private Path B = new Path();
    private final float[] C;
    private final RectF D = new RectF();
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private float K;
    private h L;
    private boolean M;
    private int N;
    private int O;
    private float P;
    private CropImageView.d Q;
    private CropImageView.c R;
    private final Rect S = new Rect();
    private boolean T;
    private Integer U;
    private ScaleGestureDetector a;
    private boolean b;
    private final g c = new g();
    private CropOverlayView.b v;
    private final RectF w = new RectF();
    private Paint x;
    private Paint y;
    private Paint z;

    static class a {
    }

    public interface b {
        void a(boolean z);
    }

    private class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        final /* synthetic */ CropOverlayView a;
        private c() {
            this.a = cropOverlayView;
            super();
        }

        @Override // android.view.ScaleGestureDetector$SimpleOnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            RectF rectF = this.a.c.h();
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            float f5 = 2f;
            f = scaleGestureDetector.getCurrentSpanY() / f5;
            float f8 = scaleGestureDetector.getCurrentSpanX() / f5;
            float f6 = focusY - f;
            final float f7 = focusX - f8;
            focusX += f8;
            focusY += f;
            if (f7 < f2) {
                if (f6 <= f3) {
                    float f9 = 0.0f;
                    if (f7 >= 0.0f) {
                        float f4 = this.a.c.c();
                        if (f2 <= f4) {
                            if (f6 >= 0.0f) {
                                float f10 = this.a.c.b();
                                if (f3 <= f10) {
                                    rectF.set(f7, f6, f2, f3);
                                    this.a.c.r(rectF);
                                    this.a.invalidate();
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }

        /* synthetic */ c(CropOverlayView.a aVar) {
            this(cropOverlayView);
        }
    }
    public CropOverlayView(Context context, AttributeSet set) {
        super(context, set);
        com.theartofdev.edmodo.cropper.g gVar = new g();
        RectF rectF = new RectF();
        Path path = new Path();
        this.C = new float[8];
        RectF rectF2 = new RectF();
        this.P = (float)this.N / (float)this.O;
        Rect rect = new Rect();
    }

    static /* synthetic */ g a(CropOverlayView cropOverlayView) {
        return cropOverlayView.c;
    }

    private boolean b(RectF rectF) {
        float f2;
        float f3;
        float f;
        float max;
        float max2;
        float f4;
        float f5;
        float min2;
        float f6;
        float min;
        float f7;
        float f8;
        Object rectF3 = this;
        Object rectF2 = rectF;
        f = c.u(rectF3.C);
        float f12 = c.w(rectF3.C);
        f2 = c.v(rectF3.C);
        float f17 = c.p(rectF3.C);
        int i4 = 0;
        if (!n()) {
            rectF3.D.set(f, f12, f2, f17);
            return false;
        }
        f3 = fArr5[i4];
        int i5 = 1;
        f4 = fArr5[i5];
        int cmp = 4;
        f5 = fArr5[cmp];
        int i = 5;
        f6 = fArr5[i];
        int i7 = 6;
        f7 = fArr5[i7];
        int i8 = 7;
        f8 = fArr5[i8];
        float f51 = fArr5[i8];
        float f53 = fArr5[i5];
        int i9 = 2;
        final int i10 = 3;
        if (f51 < f53) {
            float f23 = fArr5[i5];
            float f29 = fArr5[i10];
            if (f23 < f29) {
                f3 = fArr5[i7];
                f4 = fArr5[i8];
                f5 = fArr5[i9];
                f6 = fArr5[i10];
                f7 = fArr5[cmp];
                f8 = fArr5[i];
            } else {
                f3 = fArr5[cmp];
                f4 = fArr5[i];
                f5 = fArr5[i4];
                f6 = fArr5[i5];
                f7 = fArr5[i9];
                f8 = fArr5[i10];
            }
        } else {
            float f31 = fArr5[i5];
            float f38 = fArr5[i10];
            if (f31 > f38) {
                f3 = fArr5[i9];
                f4 = fArr5[i10];
                f5 = fArr5[i7];
                f6 = fArr5[i8];
                f7 = fArr5[i4];
                f8 = fArr5[i5];
            }
        }
        float f49 = (f8 - f4) / (f7 - f3);
        float f18 = -1f / f49;
        float f22 = f4 - (f49 * f3);
        f4 -= f24;
        float f26 = f6 - (f49 * f5);
        f6 -= f36;
        float f33 = (rectF.centerY() - rectF2.top) / (rectF.centerX() - left24);
        int i6 = -f33;
        float f40 = top22 - (left24 * f33);
        float f43 = top22 - (i6 * right22);
        float f52 = f49 - f33;
        f = (f40 - f22) / f52;
        float r9 = f;
        max = Math.max(f, f);
        max = f / (f18 - f33);
        if (r9 >= rectF2.right) {
        }
        max2 = Math.max(max, max);
        float f35 = f18 - i6;
        max2 = (f43 - f42) / f35;
        if (rectF2.right >= rectF2.right) {
        }
        float max3 = Math.max(max2, max2);
        f2 = (f43 - f30) / f35;
        if (rectF3.C <= rectF2.left) {
        }
        min = Math.min(f2, f2);
        min = (f43 - f26) / (f49 - i6);
        if (rectF2.top <= rectF2.left) {
        }
        min2 = Math.min(min, min);
        min2 = (f40 - f26) / f52;
        if (rectF2.left <= rectF2.left) {
        }
        float min3 = Math.min(min2, min2);
        this.D.left = max3;
        this.D.top = Math.max(f12, Math.max((f49 * max3) + f22, (f18 * min3) + f30));
        this.D.right = min3;
        this.D.bottom = Math.min(f17, Math.min((f18 * max3) + f42, (f49 * min3) + f26));
        return true;
    }

    private void c(boolean z) {
        try {
            this.v.a(z);
        } catch (Exception e) {
            Log.e("AIC", "Exception in crop window changed", e);
        }
    }

    private void d(Canvas canvas) {
        Path path;
        float right2;
        float f;
        RectF rectF2 = this.c.h();
        float f3 = 0.0f;
        float max = Math.max(c.u(this.C), f3);
        float max2 = Math.max(c.w(this.C), f3);
        final float canvas2 = Math.min(c.v(this.C), (float)getWidth());
        float min = Math.min(c.p(this.C), (float)getHeight());
        int i2 = 26;
        int i = 17;
        if (this.R != CropImageView.c.RECTANGLE) {
            this.B.reset();
            sDK_INT2 = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT <= i) {
                if (this.R == CropImageView.c.OVAL) {
                    float top2 = 2f;
                    left2 = rectF2.left + top2;
                    right2 = rectF2.top + top2;
                    f = rectF2.right - top2;
                    bottom2 = rectF2.bottom - top2;
                    this.w.set(left2, right2, f, bottom2);
                } else {
                    this.w.set(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom);
                }
            }
            this.B.addOval(this.w, Path.Direction.CW);
            canvas.save();
            if (Build.VERSION.SDK_INT >= i2) {
                canvas.clipOutPath(this.B);
            } else {
                canvas.clipPath(this.B, Region.Op.XOR);
            }
            canvas.drawRect(max, max2, canvas2, min, this.A);
            canvas.restore();
        } else {
            if (!n() || Build.VERSION.SDK_INT <= i) {
                canvas2 = canvas;
                canvas2.drawRect(max, max2, canvas2, rectF2.top, this.A);
                canvas2.drawRect(max, rectF2.bottom, canvas2, min, this.A);
                canvas2.drawRect(max, rectF2.top, rectF2.left, rectF2.bottom, this.A);
                canvas.drawRect(rectF2.right, rectF2.top, canvas2, rectF2.bottom, this.A);
            }
        }
    }

    private void e(Canvas canvas) {
        if (this.x != null) {
            RectF rectF = this.c.h();
            float f = this.x.getStrokeWidth() / 2f;
            rectF.inset(f, f);
            if (this.R == CropImageView.c.RECTANGLE) {
                canvas.drawRect(rectF, this.x);
            } else {
                canvas.drawOval(rectF, this.x);
            }
        }
    }

    private void f(Canvas canvas) {
        int i;
        if (this.y != null) {
            i = 0;
            if (this.x != null) {
                float strokeWidth = this.x.getStrokeWidth();
            } else {
            }
            float strokeWidth2 = this.y.getStrokeWidth();
            float f15 = 2f;
            float f19 = strokeWidth2 / f15;
            if (this.R == CropImageView.c.RECTANGLE) {
            }
            i += f19;
            RectF rectF = this.c.h();
            rectF.inset(f12, f12);
            f = (strokeWidth2 - i) / f15;
            f3 = f19 + f;
            obj = canvas;
            obj.drawLine(left2 - f, top2 - f3, left2 - f, top2 + this.H, this.y);
            obj.drawLine(left22 - f3, top22 - f, left22 + this.H, top22 - f, this.y);
            obj.drawLine(right2 + f, top23 - f3, right2 + f, top23 + this.H, this.y);
            obj.drawLine(right22 + f3, top24 - f, right22 - this.H, top24 - f, this.y);
            obj.drawLine(left23 - f, bottom22 + f3, left23 - f, bottom22 - this.H, this.y);
            obj.drawLine(left24 - f3, bottom23 + f, left24 + this.H, bottom23 + f, this.y);
            obj.drawLine(right23 + f, bottom24 + f3, right23 + f, bottom24 - this.H, this.y);
            f4 = right24 + f3;
            f5 = bottom2 + f;
            f6 = right24 - this.H;
            f7 = bottom2 + f;
            obj.drawLine(f4, f5, f6, f7, this.y);
        }
    }

    private void g(Canvas canvas) {
        int i = 0;
        final Object canvas3 = this;
        if (canvas3.z != null && canvas3.x != null) {
            float strokeWidth = canvas3.x.getStrokeWidth();
            RectF rectF = canvas3.c.h();
            rectF.inset(i, i);
            float f20 = 3f;
            f = rectF.width() / f20;
            f2 = rectF.height() / f20;
            if (canvas3.R == CropImageView.c.OVAL) {
                float canvas2 = 2f;
                float f22 = (rectF.width() / canvas2) - i;
                left2 = (rectF.height() / canvas2) - i;
                float f4 = rectF.left + f;
                float f6 = rectF.right - f;
                float f9 = (float)(double)left2 * (Math.sin(Math.acos((double)(f22 - f) / f22)));
                canvas.drawLine(f4, (rectF.top + left2) - f9, f4, (rectF.bottom - left2) + f9, canvas3.z);
                canvas.drawLine(f6, (rectF.top + left2) - f9, f6, (rectF.bottom - left2) + f9, paint2);
                canvas2 = rectF.top + f2;
                canvas2 = rectF.bottom - f2;
                float f12 = (float)(double)f22 * (Math.cos(Math.asin((double)(left2 - f2) / left2)));
                right2 = (rectF.left + f22) - f12;
                canvas2 = (rectF.right - f22) + f12;
                canvas.drawLine(right2, canvas2, canvas2, canvas2, canvas3.z);
                f = rectF.left + f22;
                right22 = f - f12;
                canvas.drawLine(right22, canvas2, (rectF.right - f22) + f12, canvas2, paint);
            } else {
                float f3 = rectF.left + f;
                float f5 = rectF.right - f;
                canvas2 = canvas;
                canvas2.drawLine(f3, rectF.top, f3, rectF.bottom, canvas3.z);
                canvas.drawLine(f5, rectF.top, f5, rectF.bottom, canvas3.z);
                canvas2 = rectF.top + f2;
                canvas2 = rectF.bottom - f2;
                canvas2.drawLine(rectF.left, canvas2, rectF.right, canvas2, canvas3.z);
                canvas.drawLine(rectF.left, canvas2, rectF.right, canvas2, paint);
            }
        }
    }

    private void h(RectF rectF) {
        float height = 0;
        float min;
        float min2;
        float width = rectF.width();
        float f23 = this.c.e();
        float f = 2f;
        if (width < f23) {
            float f8 = (this.c.e() - rectF.width()) / f;
            rectF.left -= f8;
            rectF.right += f8;
        }
        float height2 = rectF.height();
        float f3 = this.c.d();
        if (height2 < f3) {
            float f11 = (this.c.d() - rectF.height()) / f;
            rectF.top -= f11;
            rectF.bottom += f11;
        }
        float width2 = rectF.width();
        float f4 = this.c.c();
        if (width2 > f4) {
            float f22 = (rectF.width() - this.c.c()) / f;
            rectF.left += f22;
            rectF.right -= f22;
        }
        float height3 = rectF.height();
        float f5 = this.c.b();
        if (height3 > f5) {
            float f13 = (rectF.height() - this.c.b()) / f;
            rectF.top += f13;
            rectF.bottom -= f13;
        }
        b(rectF);
        float width3 = this.D.width();
        height = 0.0f;
        if (width3 > 0.0f && height5 > 0.0f) {
            float max = Math.max(this.D.left, 0.0f);
            height = Math.max(this.D.top, 0.0f);
            min = Math.min(this.D.right, (float)getWidth());
            min2 = Math.min(this.D.bottom, (float)getHeight());
            if (rectF.left < max) {
                rectF.left = max;
            }
            if (rectF.top < height) {
                rectF.top = height;
            }
            if (rectF.right > min) {
                rectF.right = min;
            }
            if (rectF.bottom > min2) {
                rectF.bottom = min2;
            }
        }
        if (this.M) {
            double d = (double)(Math.abs(rectF.width() - (rectF.height() * this.P)));
            double d2 = 0.1d;
            if (this.c > 0.1d) {
                float width5 = rectF.width();
                float f31 = rectF.height() * this.P;
                if (width5 > this.c) {
                    float f20 = (Math.abs((rectF.height() * this.P) - rectF.width())) / f;
                    rectF.left += f20;
                    rectF.right -= f20;
                } else {
                    float f17 = (Math.abs((rectF.width() / this.P) - rectF.height())) / f;
                    rectF.top += f17;
                    rectF.bottom -= f17;
                }
            }
        }
    }

    private static Paint j(int i) {
        final Paint paint = new Paint();
        paint.setColor(i);
        return paint;
    }

    private static Paint k(float f, int i) {
        if (f > 0) {
            Paint paint = new Paint();
            paint.setColor(i);
            paint.setStrokeWidth(f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            return paint;
        }
        return null;
    }

    private void l() {
        float max2;
        float min2;
        float min3;
        float left2;
        float f;
        float f2;
        float f3 = 1073741824;
        boolean z;
        float f10 = 0.0f;
        float max = Math.max(c.u(this.C), f10);
        max2 = Math.max(c.w(this.C), f10);
        min2 = Math.min(c.v(this.C), (float)getWidth());
        min3 = Math.min(c.p(this.C), (float)getHeight());
        if (min2 > max) {
            if (min3 > max2) {
                RectF rectF = new RectF();
                this.T = true;
                f = min2 - max;
                f2 = f26 * f;
                f3 = min3 - max2;
                left2 = f26 * f3;
                if (this.S.width() > 0) {
                    if (this.S.height() > 0) {
                        rectF.left = (float)this.S.left / this.c.k() + max;
                        rectF.top = (float)this.S.top / this.c.j() + max2;
                        rectF.right = rectF.left + (float)this.S.width() / this.c.k();
                        f = (float)this.S.height() / this.c.j();
                        rectF.bottom = rectF.top + f;
                        rectF.left = Math.max(max, rectF.left);
                        rectF.top = Math.max(max2, rectF.top);
                        rectF.right = Math.min(min2, rectF.right);
                        rectF.bottom = Math.min(min3, rectF.bottom);
                    } else {
                        if (this.M) {
                            if (min2 > max) {
                                if (min3 <= max2) {
                                    min = max + f2;
                                    rectF.left = min;
                                    max2 = max2 + left2;
                                    rectF.top = max2;
                                    min2 = min2 - f2;
                                    rectF.right = min2;
                                    min3 = min3 - left2;
                                    rectF.bottom = min3;
                                } else {
                                    f /= f3;
                                    f3 = 2f;
                                    if (this.c > this.P) {
                                        rectF.top = max2 + left2;
                                        rectF.bottom = min3 - left2;
                                        float f9 = (float)getWidth() / f3;
                                        this.P = (float)this.N / (float)this.O;
                                        max2 = (Math.max(this.c.e(), rectF.height() * this.P)) / f3;
                                        min2 = f9 - max2;
                                        rectF.left = min2;
                                        min = f9 + max2;
                                        rectF.right = min;
                                    } else {
                                        rectF.left = max + f2;
                                        rectF.right = min2 - f2;
                                        float f7 = (float)getHeight() / f3;
                                        max2 = (Math.max(this.c.d(), rectF.width() / this.P)) / f3;
                                        min2 = f7 - max2;
                                        rectF.top = min2;
                                        min = f7 + max2;
                                        rectF.bottom = min;
                                    }
                                }
                            }
                        }
                    }
                }
                h(rectF);
                this.c.r(rectF);
            }
        }
    }

    private boolean n() {
        boolean z = false;
        float f2 = fArr[0];
        float f4 = fArr[6];
        int i = 1;
        if (f2 != f4) {
            float f3 = fArr[i];
            int i2 = 7;
            float f = fArr[i2];
            if (f3 != this.C) {
            }
        }
        return z;
    }

    private void o(float f, float f2) {
        final com.theartofdev.edmodo.cropper.h hVar = this.c.f(f, f2, this.J, this.R);
        this.L = hVar;
        if (hVar != null) {
            invalidate();
        }
    }

    private void p(float f, float f2) {
        float f3 = 0;
        if (this.L != null) {
            RectF rectF = this.c.h();
            if (b(rectF)) {
                int i3 = 0;
            }
            this.L.m(rectF, f, f2, this.D, this.E, this.F, f3, this.M, this.P);
            this.c.r(rectF);
            boolean z2 = true;
            c(z2);
            invalidate();
        }
    }

    private void q() {
        if (this.L != null) {
            this.L = null;
            c(false);
            invalidate();
        }
    }

    @Override // android.view.View
    public int getAspectRatioX() {
        return this.N;
    }

    @Override // android.view.View
    public int getAspectRatioY() {
        return this.O;
    }

    @Override // android.view.View
    public CropImageView.c getCropShape() {
        return this.R;
    }

    @Override // android.view.View
    public RectF getCropWindowRect() {
        return this.c.h();
    }

    @Override // android.view.View
    public CropImageView.d getGuidelines() {
        return this.Q;
    }

    @Override // android.view.View
    public Rect getInitialCropWindowRect() {
        return this.S;
    }

    @Override // android.view.View
    public void i() {
        final RectF cropWindowRect = getCropWindowRect();
        h(cropWindowRect);
        this.c.r(cropWindowRect);
    }

    @Override // android.view.View
    public boolean m() {
        return this.M;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
        if (this.c.s()) {
            if (this.Q == CropImageView.d.ON) {
                g(canvas);
            } else {
                if (this.Q == CropImageView.d.ON_TOUCH && this.L != null) {
                    g(canvas);
                }
            }
        }
        e(canvas);
        f(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        final boolean z2 = false;
        if (isEnabled() && this.b) {
            this.a.onTouchEvent(motionEvent);
            int action = motionEvent.getAction();
            final int i3 = 1;
            if (action != 0 && action != i3) {
                int i = 2;
                if (action != 2 && action != 3) {
                    return false;
                }
                p(motionEvent.getX(), motionEvent.getY());
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            o(motionEvent.getX(), motionEvent.getY());
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void r() {
        if (this.T) {
            setCropWindowRect(c.b);
            l();
            invalidate();
        }
    }

    @Override // android.view.View
    public void s(float[] fArr, int i, int i2) {
        float[] fArr2;
        int length;
        RectF rectF;
        if (fArr != null) {
            if (!Arrays.equals(this.C, fArr) && fArr == null) {
                Arrays.fill(this.C, 0.0f);
                this.E = i;
                this.F = i2;
                rectF = this.c.h();
                float width = rectF.width();
                if (width != 0.0f) {
                    float height = rectF.height();
                    if (height == 0.0f) {
                        l();
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setAspectRatioX(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else {
            if (this.N != i) {
                this.N = i;
                this.P = (float)i / (float)this.O;
                if (this.T) {
                    l();
                    invalidate();
                }
            }
            return;
        }
    }

    @Override // android.view.View
    public void setAspectRatioY(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else {
            if (this.O != i) {
                this.O = i;
                this.P = (float)this.N / (float)i;
                if (this.T) {
                    l();
                    invalidate();
                }
            }
            return;
        }
    }

    @Override // android.view.View
    public void setCropShape(CropImageView.c cVar) {
        int sDK_INT2 = 1;
        int i = 17;
        int value;
        if (this.R != cVar) {
            this.R = cVar;
            i = 17;
            if (Build.VERSION.SDK_INT <= 17) {
                Paint paint = null;
                if (cVar == CropImageView.c.OVAL) {
                    Integer num = Integer.valueOf(getLayerType());
                    this.U = num;
                    sDK_INT2 = 1;
                    if (num.intValue() != sDK_INT2) {
                        setLayerType(sDK_INT2, paint);
                    } else {
                        this.U = paint;
                    }
                } else {
                    if (this.U != null) {
                        setLayerType(this.U.intValue(), paint);
                        this.U = paint;
                    }
                }
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void setCropWindowChangeListener(CropOverlayView.b bVar) {
        this.v = bVar;
    }

    @Override // android.view.View
    public void setCropWindowRect(RectF rectF) {
        this.c.r(rectF);
    }

    @Override // android.view.View
    public void setFixedAspectRatio(boolean z) {
        if (this.M != z) {
            this.M = z;
            if (this.T) {
                l();
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void setGuidelines(CropImageView.d dVar) {
        if (this.Q != dVar) {
            this.Q = dVar;
            if (this.T) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void setInitialAttributeValues(f fVar) {
        this.c.q(fVar);
        setCropShape(fVar.a);
        setSnapRadius(fVar.b);
        setGuidelines(fVar.v);
        setFixedAspectRatio(fVar.D);
        setAspectRatioX(fVar.E);
        setAspectRatioY(fVar.F);
        u(fVar.A);
        this.J = fVar.c;
        this.I = fVar.C;
        this.x = CropOverlayView.k(fVar.G, fVar.H);
        this.G = fVar.J;
        this.H = fVar.K;
        this.y = CropOverlayView.k(fVar.I, fVar.L);
        this.z = CropOverlayView.k(fVar.M, fVar.N);
        this.A = CropOverlayView.j(fVar.O);
    }

    @Override // android.view.View
    public void setInitialCropWindowRect(Rect rect) {
        Rect rect2;
        if (rect == null) {
            rect2 = c.a;
        }
        this.S.set(rect2);
        if (this.T) {
            l();
            invalidate();
            boolean z = false;
            c(z);
        }
    }

    @Override // android.view.View
    public void setSnapRadius(float f) {
        this.K = f;
    }

    @Override // android.view.View
    public void t(float f, float f2, float f3, float f4) {
        this.c.p(f, f2, f3, f4);
    }

    @Override // android.view.View
    public boolean u(boolean z) {
        if (this.b != z) {
            this.b = z;
            if (this.a && this.a == null) {
                com.theartofdev.edmodo.cropper.CropOverlayView.a aVar = null;
                this.a = new ScaleGestureDetector(getContext(), new CropOverlayView.c(this, aVar));
            }
            return true;
        }
        return false;
    }
}
