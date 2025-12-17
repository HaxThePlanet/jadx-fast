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

/* loaded from: classes2.dex */
public class CropOverlayView extends View {

    private Paint A;
    private Path B;
    private final float[] C;
    private final RectF D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private float K;
    private com.theartofdev.edmodo.cropper.h L;
    private boolean M;
    private int N;
    private int O;
    private float P;
    private com.theartofdev.edmodo.cropper.CropImageView.d Q;
    private com.theartofdev.edmodo.cropper.CropImageView.c R;
    private final Rect S;
    private boolean T;
    private Integer U;
    private ScaleGestureDetector a;
    private boolean b;
    private final com.theartofdev.edmodo.cropper.g c;
    private com.theartofdev.edmodo.cropper.CropOverlayView.b v;
    private final RectF w;
    private Paint x;
    private Paint y;
    private Paint z;

    static class a {
    }

    public interface b {
        public abstract void a(boolean z);
    }

    private class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        final com.theartofdev.edmodo.cropper.CropOverlayView a;
        private c(com.theartofdev.edmodo.cropper.CropOverlayView cropOverlayView) {
            this.a = cropOverlayView;
            super();
        }

        c(com.theartofdev.edmodo.cropper.CropOverlayView cropOverlayView, com.theartofdev.edmodo.cropper.CropOverlayView.a cropOverlayView$a2) {
            super(cropOverlayView);
        }

        @Override // android.view.ScaleGestureDetector$SimpleOnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            int cmp;
            int obj7;
            RectF rectF = CropOverlayView.a(this.a).h();
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            int i3 = 1073741824;
            currentSpanY /= i3;
            obj7 /= i3;
            int i4 = focusY - cmp;
            final int i5 = focusX - obj7;
            focusX += obj7;
            focusY += cmp;
            obj7 = 0;
            if (Float.compare(i5, i) < 0 && Float.compare(i4, i2) <= 0 && Float.compare(i5, obj7) >= 0 && Float.compare(i, f) <= 0 && Float.compare(i4, obj7) >= 0 && Float.compare(i2, obj7) <= 0) {
                if (Float.compare(i4, i2) <= 0) {
                    obj7 = 0;
                    if (Float.compare(i5, obj7) >= 0) {
                        if (Float.compare(i, f) <= 0) {
                            if (Float.compare(i4, obj7) >= 0) {
                                if (Float.compare(i2, obj7) <= 0) {
                                    rectF.set(i5, i4, i, i2);
                                    CropOverlayView.a(this.a).r(rectF);
                                    this.a.invalidate();
                                }
                            }
                        }
                    }
                }
            }
            return 1;
        }
    }
    public CropOverlayView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        g obj1 = new g();
        this.c = obj1;
        obj1 = new RectF();
        this.w = obj1;
        obj1 = new Path();
        this.B = obj1;
        this.C = new float[8];
        obj1 = new RectF();
        this.D = obj1;
        this.P = obj1 /= obj2;
        obj1 = new Rect();
        this.S = obj1;
    }

    static com.theartofdev.edmodo.cropper.g a(com.theartofdev.edmodo.cropper.CropOverlayView cropOverlayView) {
        return cropOverlayView.c;
    }

    private boolean b(RectF rectF) {
        int i2;
        float f5;
        int i4;
        int i3;
        int i7;
        float f4;
        int cmp;
        float f3;
        int i6;
        float i5;
        float f;
        float i;
        float f6;
        float f2;
        Object obj = this;
        Object obj2 = rectF;
        float f9 = c.u(obj.C);
        float f16 = c.w(obj.C);
        float f19 = c.v(obj.C);
        float f20 = c.p(obj.C);
        int i20 = 0;
        if (!n()) {
            obj.D.set(f9, f16, f19, f20);
            return i20;
        }
        float[] fArr5 = obj.C;
        f5 = fArr5[i20];
        int i26 = 1;
        f4 = fArr5[i26];
        cmp = 4;
        f3 = fArr5[cmp];
        i6 = 5;
        f = fArr5[i6];
        int i41 = 6;
        f6 = fArr5[i41];
        int i45 = 7;
        f2 = fArr5[i45];
        int i53 = 2;
        final int i54 = 3;
        if (Float.compare(f24, f25) < 0) {
            if (Float.compare(f21, f22) < 0) {
                f5 = fArr5[i41];
                f4 = fArr5[i45];
                f3 = fArr5[i53];
                f = fArr5[i54];
                f6 = fArr5[cmp];
                f2 = fArr5[i6];
            } else {
                f5 = fArr5[cmp];
                f4 = fArr5[i6];
                f3 = fArr5[i20];
                f = fArr5[i26];
                f6 = fArr5[i53];
                f2 = fArr5[i54];
            }
        } else {
            if (Float.compare(f23, i6) > 0) {
                f5 = fArr5[i53];
                f4 = fArr5[i54];
                f3 = fArr5[i41];
                f = fArr5[i45];
                f6 = fArr5[i20];
                f2 = fArr5[i26];
            }
        }
        i49 /= i44;
        i16 /= i50;
        int i22 = f4 - i21;
        f4 -= i23;
        int i25 = f - i24;
        f -= i34;
        float left4 = obj2.left;
        i30 /= i35;
        int i36 = -i31;
        float top2 = obj2.top;
        int i38 = top2 - i37;
        float right2 = obj2.right;
        top2 -= i46;
        int i52 = i50 - i31;
        i47 /= i52;
        i4 = Float.compare(i48, right2) < 0 ? i48 : f9;
        float f10 = Math.max(f9, i4);
        if (Float.compare(i3, right3) < 0) {
        } else {
            i3 = f10;
        }
        float f11 = Math.max(f10, i3);
        int i33 = i17 - i36;
        if (Float.compare(i7, right) < 0) {
        } else {
            i7 = f11;
        }
        float f7 = Math.max(f11, i7);
        if (Float.compare(i2, left3) > 0) {
        } else {
            i2 = f19;
        }
        float f12 = Math.min(f19, i2);
        if (Float.compare(i, left2) > 0) {
        } else {
            i = f12;
        }
        float f13 = Math.min(f12, i);
        if (Float.compare(i5, left) > 0) {
        } else {
            i5 = f13;
        }
        float f8 = Math.min(f13, i5);
        RectF rectF3 = obj3.D;
        rectF3.left = f7;
        rectF3.top = Math.max(f16, Math.max(i10 += i22, i14 += i29));
        rectF3.right = f8;
        rectF3.bottom = Math.min(f20, Math.min(i18 += i40, i51 + i25));
        return 1;
    }

    private void c(boolean z) {
        com.theartofdev.edmodo.cropper.CropOverlayView.b view;
        String str;
        boolean obj3;
        try {
            view = this.v;
            if (view != null) {
            }
            view.a(z);
            Log.e("AIC", "Exception in crop window changed", z);
        }
    }

    private void d(Canvas canvas) {
        Object rectF;
        float bottom;
        float f;
        int sDK_INT;
        Path path;
        boolean sDK_INT2;
        float f3;
        com.theartofdev.edmodo.cropper.CropImageView.c rECTANGLE;
        RectF rectF2;
        Object iNTERSECT;
        float top;
        float f2;
        float right;
        int oVAL;
        float left;
        Paint top3;
        float top2;
        float bottom2;
        int i;
        rectF = this.c.h();
        int i2 = 0;
        float f5 = Math.max(c.u(this.C), i2);
        top = Math.max(c.w(this.C), i2);
        final float f22 = Math.min(c.v(this.C), (float)width);
        float f8 = Math.min(c.p(this.C), (float)height);
        int i3 = 26;
        oVAL = 17;
        if (this.R == CropImageView.c.RECTANGLE) {
            if (n()) {
                sDK_INT2 = Build.VERSION.SDK_INT;
                if (sDK_INT2 <= oVAL) {
                    f = canvas;
                    f3 = f5;
                    float f12 = f22;
                    f.drawRect(f3, top, f12, rectF.top, this.A);
                    f.drawRect(f3, rectF.bottom, f12, f8, this.A);
                    f.drawRect(f3, rectF.top, rectF.left, rectF.bottom, this.A);
                    canvas.drawRect(rectF.right, rectF.top, f22, rectF.bottom, this.A);
                } else {
                    this.B.reset();
                    float[] fArr5 = this.C;
                    this.B.moveTo(fArr5[0], fArr5[1]);
                    float[] fArr6 = this.C;
                    this.B.lineTo(fArr6[2], fArr6[3]);
                    float[] fArr7 = this.C;
                    this.B.lineTo(fArr7[4], fArr7[5]);
                    float[] fArr8 = this.C;
                    this.B.lineTo(fArr8[6], fArr8[7]);
                    this.B.close();
                    canvas.save();
                    if (sDK_INT2 >= i3) {
                        canvas.clipOutPath(this.B);
                    } else {
                        canvas.clipPath(this.B, Region.Op.INTERSECT);
                    }
                    canvas.clipRect(rectF, Region.Op.XOR);
                    canvas.drawRect(f5, top, f22, f8, this.A);
                    canvas.restore();
                }
            } else {
            }
        } else {
            this.B.reset();
            sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT <= oVAL && this.R == CropImageView.c.OVAL) {
                if (this.R == CropImageView.c.OVAL) {
                    top2 = 1073741824;
                    this.w.set(left3 += top2, top5 += top2, right2 -= top2, bottom3 -= top2);
                } else {
                    this.w.set(rectF.left, rectF.top, rectF.right, rectF.bottom);
                }
            } else {
            }
            this.B.addOval(this.w, Path.Direction.CW);
            canvas.save();
            if (sDK_INT >= i3) {
                canvas.clipOutPath(this.B);
            } else {
                canvas.clipPath(this.B, Region.Op.XOR);
            }
            canvas.drawRect(f5, top, f22, f8, this.A);
            canvas.restore();
        }
    }

    private void e(Canvas canvas) {
        Paint paint;
        RectF rectF;
        com.theartofdev.edmodo.cropper.CropImageView.c rECTANGLE;
        paint = this.x;
        if (paint != null) {
            rectF = this.c.h();
            strokeWidth /= i2;
            rectF.inset(i, i);
            if (this.R == CropImageView.c.RECTANGLE) {
                canvas.drawRect(rectF, this.x);
            } else {
                canvas.drawOval(rectF, this.x);
            }
        }
    }

    private void f(Canvas canvas) {
        Paint right;
        int strokeWidth;
        float bottom;
        int i2;
        int i3;
        float f;
        int i7;
        RectF rectF;
        Object obj;
        int i4;
        int i5;
        int i6;
        int i;
        Paint paint;
        if (this.y != null) {
            Paint paint2 = this.x;
            if (paint2 != null) {
                strokeWidth = paint2.getStrokeWidth();
            } else {
                strokeWidth = i2;
            }
            float strokeWidth2 = this.y.getStrokeWidth();
            int i10 = 1073741824;
            int i11 = strokeWidth2 / i10;
            if (this.R == CropImageView.c.RECTANGLE) {
                i2 = this.G;
            }
            i2 += i11;
            rectF = this.c.h();
            rectF.inset(i8, i8);
            i9 /= i10;
            i11 += i3;
            float left = rectF.left;
            float top = rectF.top;
            obj = canvas;
            obj.drawLine(left - i3, top - i7, left - i3, top + f2, this.y);
            float left2 = rectF.left;
            float top2 = rectF.top;
            obj.drawLine(left2 - i7, top2 - i3, left2 + f6, top2 - i3, this.y);
            float right2 = rectF.right;
            float top3 = rectF.top;
            obj.drawLine(right2 + i3, top3 - i7, right2 + i3, top3 + f3, this.y);
            float right3 = rectF.right;
            float top4 = rectF.top;
            obj.drawLine(right3 + i7, top4 - i3, right3 - f7, top4 - i3, this.y);
            float left3 = rectF.left;
            float bottom2 = rectF.bottom;
            obj.drawLine(left3 - i3, bottom2 + i7, left3 - i3, bottom2 - f4, this.y);
            float left4 = rectF.left;
            float bottom3 = rectF.bottom;
            obj.drawLine(left4 - i7, bottom3 + i3, left4 + f8, bottom3 + i3, this.y);
            float right4 = rectF.right;
            float bottom4 = rectF.bottom;
            obj.drawLine(right4 + i3, bottom4 + i7, right4 + i3, bottom4 - f5, this.y);
            right = rectF.right;
            bottom = rectF.bottom;
            obj.drawLine(right + i7, bottom + i3, right - f, bottom + i3, this.y);
        }
    }

    private void g(Canvas canvas) {
        Paint paint2;
        int strokeWidth;
        RectF rectF;
        int i5;
        com.theartofdev.edmodo.cropper.CropImageView.c view;
        int i7;
        int i8;
        float left2;
        int i2;
        float right2;
        int i;
        int i3;
        float left;
        double d;
        float right;
        int i6;
        Paint paint;
        int i4;
        Paint paint3;
        final Object obj = this;
        if (obj.z != null) {
            Paint paint4 = obj.x;
            if (paint4 != null) {
                strokeWidth = paint4.getStrokeWidth();
            } else {
                strokeWidth = 0;
            }
            rectF = obj.c.h();
            rectF.inset(strokeWidth, strokeWidth);
            int i19 = 1077936128;
            width /= i19;
            height /= i19;
            if (obj.R == CropImageView.c.OVAL) {
                i8 = 1073741824;
                i20 -= strokeWidth;
                i22 -= strokeWidth;
                int i31 = left4 + i5;
                int i37 = right4 - i5;
                float f = (float)i23;
                canvas.drawLine(i31, i13 - f, i31, i14 + f, obj.z);
                canvas.drawLine(i37, i15 - f, i37, i16 + f, obj.z);
                left = top2 + i7;
                i4 = bottom2 - i7;
                float f2 = (float)i25;
                canvas.drawLine(i17 - f2, left, i18 + f2, left, obj.z);
                canvas.drawLine(i5 - f2, i4, rectF + f2, i4, obj.z);
            } else {
                int i26 = left3 + i5;
                int i34 = right3 - i5;
                i8 = canvas;
                i8.drawLine(i26, rectF.top, i26, rectF.bottom, obj.z);
                canvas.drawLine(i34, rectF.top, i34, rectF.bottom, obj.z);
                i = top + i7;
                i6 = bottom - i7;
                i8.drawLine(rectF.left, i, rectF.right, i, obj.z);
                canvas.drawLine(rectF.left, i6, rectF.right, i6, obj.z);
            }
        }
    }

    private void h(RectF rectF) {
        int cmp6;
        int cmp3;
        int cmp5;
        int cmp4;
        int cmp2;
        boolean cmp;
        int i;
        int i2;
        float f3;
        float f;
        float f2;
        int height;
        float f5;
        float f4;
        int cmp7;
        i = 1073741824;
        if (Float.compare(width, f12) < 0) {
            i3 /= i;
            rectF.left = left3 -= cmp6;
            rectF.right = right3 += cmp6;
        }
        if (Float.compare(height2, f3) < 0) {
            i4 /= i;
            rectF.top = top3 -= cmp3;
            rectF.bottom = bottom3 += cmp3;
        }
        if (Float.compare(width2, f) > 0) {
            i11 /= i;
            rectF.left = left4 += cmp5;
            rectF.right = right4 -= cmp5;
        }
        if (Float.compare(height3, f2) > 0) {
            i5 /= i;
            rectF.top = top4 += cmp4;
            rectF.bottom = bottom4 -= cmp4;
        }
        b(rectF);
        height = 0;
        float f8 = Math.max(rectF4.left, height);
        height = Math.max(rectF5.top, height);
        f5 = Math.min(rectF6.right, (float)width9);
        f4 = Math.min(rectF7.bottom, (float)height10);
        if (Float.compare(width3, height) > 0 && Float.compare(height5, height) > 0 && Float.compare(left5, f8) < 0) {
            if (Float.compare(height5, height) > 0) {
                f8 = Math.max(rectF4.left, height);
                height = Math.max(rectF5.top, height);
                f5 = Math.min(rectF6.right, (float)width9);
                f4 = Math.min(rectF7.bottom, (float)height10);
                if (Float.compare(left5, f8) < 0) {
                    rectF.left = f8;
                }
                if (Float.compare(top, height) < 0) {
                    rectF.top = height;
                }
                if (Float.compare(right, f5) > 0) {
                    rectF.right = f5;
                }
                if (Float.compare(bottom, f4) > 0) {
                    rectF.bottom = f4;
                }
            }
        }
        if (this.M && Double.compare(height, f4) > 0) {
            if (Double.compare(height, f4) > 0) {
                if (Float.compare(width5, i18) > 0) {
                    f11 /= i;
                    rectF.left = left2 += cmp;
                    rectF.right = right2 -= cmp;
                } else {
                    f10 /= i;
                    rectF.top = top2 += cmp;
                    rectF.bottom = bottom2 -= cmp;
                }
            }
        }
    }

    private static Paint j(int i) {
        Paint paint = new Paint();
        paint.setColor(i);
        return paint;
    }

    private static Paint k(float f, int i2) {
        if (Float.compare(f, i) > 0) {
            Paint paint = new Paint();
            paint.setColor(i2);
            paint.setStrokeWidth(f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            return paint;
        }
        return null;
    }

    private void l() {
        float f2;
        int i;
        float f3;
        float f;
        float f4;
        int rectF;
        int left;
        int cmp;
        int i3;
        int i2;
        boolean height;
        int i7 = 0;
        f2 = Math.max(c.u(this.C), i7);
        f3 = Math.max(c.w(this.C), i7);
        f = Math.min(c.v(this.C), (float)width3);
        f4 = Math.min(c.p(this.C), (float)height4);
        if (Float.compare(f, f2) > 0) {
            if (Float.compare(f4, f3) <= 0) {
            } else {
                rectF = new RectF();
                this.T = true;
                float f22 = this.I;
                cmp = f - f2;
                i3 = f22 * cmp;
                i2 = f4 - f3;
                f22 *= i2;
                if (this.S.width() > 0 && this.S.height() > 0) {
                    if (this.S.height() > 0) {
                        rectF.left = i17 += f2;
                        rectF.top = i19 += f3;
                        rectF.right = left3 += i24;
                        rectF.bottom = top3 += cmp;
                        rectF.left = Math.max(f2, rectF.left);
                        rectF.top = Math.max(f3, rectF.top);
                        rectF.right = Math.min(f, rectF.right);
                        rectF.bottom = Math.min(f4, rectF.bottom);
                    } else {
                        if (this.M && Float.compare(f, f2) > 0 && Float.compare(f4, f3) > 0) {
                            if (Float.compare(f, f2) > 0) {
                                if (Float.compare(f4, f3) > 0) {
                                    i2 = 1073741824;
                                    if (Float.compare(i23, f30) > 0) {
                                        rectF.top = f3 += left;
                                        rectF.bottom = f4 -= left;
                                        f7 /= i2;
                                        this.P = f13 /= f18;
                                        f15 /= i2;
                                        rectF.left = i6 - f3;
                                        rectF.right = i6 += f3;
                                    } else {
                                        rectF.left = f2 += i3;
                                        rectF.right = f -= i3;
                                        f6 /= i2;
                                        f12 /= i2;
                                        rectF.top = i5 - f3;
                                        rectF.bottom = i5 += f3;
                                    }
                                } else {
                                    rectF.left = f2 += i3;
                                    rectF.top = f3 += left;
                                    rectF.right = f -= i3;
                                    rectF.bottom = f4 -= left;
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                } else {
                }
                h(rectF);
                this.c.r(rectF);
            }
        }
    }

    private boolean n() {
        float[] cmp;
        int i;
        int cmp2;
        int i2;
        cmp = this.C;
        int i4 = 1;
        if (Float.compare(f2, f3) != 0 && Float.compare(cmp2, f) != 0) {
            if (Float.compare(cmp2, f) != 0) {
                i = i4;
            }
        }
        return i;
    }

    private void o(float f, float f2) {
        final com.theartofdev.edmodo.cropper.h obj4 = this.c.f(f, f2, this.J, this.R);
        this.L = obj4;
        if (obj4 != null) {
            invalidate();
        }
    }

    private void p(float f, float f2) {
        float hVar2;
        RectF rectF;
        com.theartofdev.edmodo.cropper.h hVar;
        RectF rectF2;
        float f4;
        float f6;
        RectF rectF3;
        int i2;
        int i;
        float f3;
        boolean z;
        float f5;
        int obj13;
        hVar2 = this.K;
        rectF = this.c.h();
        if (this.L != null && b(rectF)) {
            hVar2 = this.K;
            rectF = this.c.h();
            if (b(rectF)) {
                hVar2 = 0;
            }
            this.L.m(rectF, f, f2, this.D, this.E, this.F, hVar2, this.M, this.P);
            this.c.r(rectF);
            c(true);
            invalidate();
        }
    }

    private void q() {
        com.theartofdev.edmodo.cropper.h hVar;
        if (this.L != null) {
            this.L = 0;
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
    public com.theartofdev.edmodo.cropper.CropImageView.c getCropShape() {
        return this.R;
    }

    @Override // android.view.View
    public RectF getCropWindowRect() {
        return this.c.h();
    }

    @Override // android.view.View
    public com.theartofdev.edmodo.cropper.CropImageView.d getGuidelines() {
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
        boolean z;
        com.theartofdev.edmodo.cropper.CropImageView.d oN_TOUCH;
        super.onDraw(canvas);
        d(canvas);
        if (this.c.s()) {
            z = this.Q;
            if (z == CropImageView.d.ON) {
                g(canvas);
            } else {
                if (z == CropImageView.d.ON_TOUCH && this.L != null) {
                    if (this.L != null) {
                        g(canvas);
                    }
                }
            }
        }
        e(canvas);
        f(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int i;
        MotionEvent obj5;
        final int i2 = 0;
        if (isEnabled() && this.b) {
            if (this.b) {
                this.a.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            final int i3 = 1;
            if (action != 0 && action != i3 && action != 2 && action != 3) {
                if (action != i3) {
                    if (action != 2) {
                        if (action != 3) {
                            return i2;
                        }
                    }
                    p(motionEvent.getX(), motionEvent.getY());
                    getParent().requestDisallowInterceptTouchEvent(i3);
                    return i3;
                }
                getParent().requestDisallowInterceptTouchEvent(i2);
                q();
                return i3;
            }
            o(motionEvent.getX(), motionEvent.getY());
            return i3;
        }
        return i2;
    }

    @Override // android.view.View
    public void r() {
        boolean z;
        if (this.T) {
            setCropWindowRect(c.b);
            l();
            invalidate();
        }
    }

    @Override // android.view.View
    public void s(float[] fArr, int i2, int i3) {
        boolean equals;
        float[] fArr2;
        int length;
        int i;
        float[] obj5;
        int obj6;
        if (fArr != null) {
            if (!Arrays.equals(this.C, fArr)) {
                equals = 0;
                if (fArr == null) {
                    Arrays.fill(this.C, equals);
                } else {
                    i = 0;
                    System.arraycopy(fArr, i, this.C, i, fArr.length);
                }
                this.E = i2;
                this.F = i3;
                obj5 = this.c.h();
                if (Float.compare(obj6, equals) != 0) {
                    if (Float.compare(obj5, equals) == 0) {
                        l();
                    }
                } else {
                }
            }
        } else {
        }
    }

    @Override // android.view.View
    public void setAspectRatioX(int i) {
        int i2;
        int obj2;
        if (i <= 0) {
        } else {
            this.N = i;
            this.P = obj2 /= i2;
            if (this.N != i && this.T) {
                this.N = i;
                this.P = obj2 /= i2;
                if (this.T) {
                    l();
                    invalidate();
                }
            }
        }
        obj2 = new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        throw obj2;
    }

    @Override // android.view.View
    public void setAspectRatioY(int i) {
        int i2;
        int obj2;
        if (i <= 0) {
        } else {
            this.O = i;
            this.P = f /= obj2;
            if (this.O != i && this.T) {
                this.O = i;
                this.P = f /= obj2;
                if (this.T) {
                    l();
                    invalidate();
                }
            }
        }
        obj2 = new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        throw obj2;
    }

    @Override // android.view.View
    public void setCropShape(com.theartofdev.edmodo.cropper.CropImageView.c cropImageView$c) {
        com.theartofdev.edmodo.cropper.CropImageView.c sDK_INT;
        int i;
        com.theartofdev.edmodo.cropper.CropImageView.c obj3;
        this.R = c;
        if (this.R != c && Build.VERSION.SDK_INT <= 17) {
            this.R = c;
            if (Build.VERSION.SDK_INT <= 17) {
                i = 0;
                if (c == CropImageView.c.OVAL) {
                    obj3 = Integer.valueOf(getLayerType());
                    this.U = obj3;
                    sDK_INT = 1;
                    if (obj3.intValue() != sDK_INT) {
                        setLayerType(sDK_INT, i);
                    } else {
                        this.U = i;
                    }
                } else {
                    obj3 = this.U;
                    if (obj3 != null) {
                        setLayerType(obj3.intValue(), i);
                        this.U = i;
                    }
                }
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void setCropWindowChangeListener(com.theartofdev.edmodo.cropper.CropOverlayView.b cropOverlayView$b) {
        this.v = b;
    }

    @Override // android.view.View
    public void setCropWindowRect(RectF rectF) {
        this.c.r(rectF);
    }

    @Override // android.view.View
    public void setFixedAspectRatio(boolean z) {
        boolean obj2;
        this.M = z;
        if (this.M != z && this.T) {
            this.M = z;
            if (this.T) {
                l();
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void setGuidelines(com.theartofdev.edmodo.cropper.CropImageView.d cropImageView$d) {
        com.theartofdev.edmodo.cropper.CropImageView.d obj2;
        this.Q = d;
        if (this.Q != d && this.T) {
            this.Q = d;
            if (this.T) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void setInitialAttributeValues(com.theartofdev.edmodo.cropper.f f) {
        this.c.q(f);
        setCropShape(f.a);
        setSnapRadius(f.b);
        setGuidelines(f.v);
        setFixedAspectRatio(f.D);
        setAspectRatioX(f.E);
        setAspectRatioY(f.F);
        u(f.A);
        this.J = f.c;
        this.I = f.C;
        this.x = CropOverlayView.k(f.G, f.H);
        this.G = f.J;
        this.H = f.K;
        this.y = CropOverlayView.k(f.I, f.L);
        this.z = CropOverlayView.k(f.M, f.N);
        this.A = CropOverlayView.j(f.O);
    }

    @Override // android.view.View
    public void setInitialCropWindowRect(Rect rect) {
        Rect obj2;
        if (rect != null) {
        } else {
            obj2 = c.a;
        }
        this.S.set(obj2);
        if (this.T) {
            l();
            invalidate();
            c(false);
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
        boolean context;
        com.theartofdev.edmodo.cropper.CropOverlayView.c cVar;
        int i;
        boolean obj4;
        this.b = z;
        if (this.b != z && z && this.a == null) {
            this.b = z;
            if (z) {
                if (this.a == null) {
                    cVar = new CropOverlayView.c(this, 0);
                    obj4 = new ScaleGestureDetector(getContext(), cVar);
                    this.a = obj4;
                }
            }
            return 1;
        }
        return 0;
    }
}
