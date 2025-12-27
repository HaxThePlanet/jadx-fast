package com.theartofdev.edmodo.cropper;

import android.accounts.Account;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

/* compiled from: CropWindowMoveHandler.java */
/* loaded from: classes2.dex */
final class h {

    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final h.b e;
    private final PointF f = new PointF();

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[h.b.values().length];
            h.a.a = iArr;
            try {
                iArr[h.b.TOP_LEFT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h.a.a[h.b.TOP_RIGHT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h.a.a[h.b.BOTTOM_LEFT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h.a.a[h.b.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h.a.a[h.b.LEFT.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h.a.a[h.b.TOP.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h.a.a[h.b.RIGHT.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h.a.a[h.b.BOTTOM.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h.a.a[h.b.CENTER.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    public enum b {

        BOTTOM,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        CENTER,
        LEFT,
        RIGHT,
        TOP,
        TOP_LEFT,
        TOP_RIGHT;
    }
    static {
        final Matrix matrix = new Matrix();
    }

    public h(h.b bVar, g gVar, float f, float f2) {
        super();
        final PointF pointF = new PointF();
        this.e = bVar;
        this.a = gVar.e();
        this.b = gVar.d();
        this.c = gVar.c();
        this.d = gVar.b();
        l(gVar.h(), f, f2);
    }

    private void a(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        int cmp3;
        float f4 = 1066192077;
        float i42;
        float f10;
        int cmp5;
        f9 = (float)i;
        if (f > f9) {
            i42 = (f - f9) / 1.05f + f9;
            f4 = 1.1f;
            f9 = (i42 - f9) / f4;
            pointF.y -= f9;
        }
        if (i42 > rectF2.bottom) {
            float f8 = 2f;
            f4 = (i42 - i42) / f8;
            pointF2.y -= f4;
        }
        float f11 = i42 - i42;
        if (this.f < f2) {
        }
        float f14 = i42 - top2;
        if (pointF2.y < this.b) {
            i42 = top2 + f17;
        }
        float f15 = i42 - top2;
        if (pointF2.y > this.d) {
            i42 = top2 + f7;
        }
        f3 = i42 - i42;
        if (pointF2.y < f2) {
        }
        if (f3 > 0) {
            f10 = (i42 - top2) * f3;
            if (f10 < this.a) {
                f3 = f3 / f3;
                top2 = top2 + f3;
                i42 = (Math.min(rectF2.bottom, top2)) - rectF.top;
                f10 = i42 * f3;
            }
            if (f10 > this.c) {
                i42 = (Math.min(rectF2.bottom, rectF.top + (i42 / f3))) - rectF.top;
                f10 = i42 * f3;
            }
            if (!z || !z2) {
                if (z && f33 < rectF2.left) {
                    i42 = (Math.min(rectF2.bottom, rectF.top + (i42 - left2) / f3)) - rectF.top;
                    f10 = i42 * f3;
                }
                if (z2) {
                    f10 += i42;
                    if (f26 > rectF2.right) {
                        i42 = Math.min(i42, Math.min(rectF2.bottom, rectF.top + (right2 - i42) / f3));
                    }
                }
            } else {
                i42 = Math.min(i42, Math.min(rectF2.bottom, rectF.top + (rectF2.width() / f3)));
            }
        }
        rectF.bottom = i42;
    }

    private void b(RectF rectF, float f) {
        rectF.bottom = rectF.top + (rectF.width() / f);
    }

    private void c(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        int cmp2;
        float right2;
        float f7;
        float max;
        float f11;
        float top2;
        f = 0.0f;
        if (f < 0.0f) {
            max = f / 1.05f;
            f7 = max / 1.1f;
            pointF.x -= f7;
        }
        if (max < rectF2.left) {
            float f10 = 2f;
            f9 = (max - max) / f10;
            pointF2.x -= f9;
        }
        float f14 = max - max;
        if (this.f < f2) {
        }
        float f16 = right2 - max;
        if (pointF2.x < this.a) {
            max = right2 - f19;
        }
        float f17 = right2 - max;
        if (pointF2.x > this.c) {
            max = right2 - f20;
        }
        f8 = max - max;
        if (pointF2.x < f2) {
        }
        if (f3 > 0.0f) {
            f11 = (right2 - max) / f3;
            if (f11 < this.b) {
                f3 = f3 * f3;
                right2 = right2 - f3;
                f11 = (rectF.right - (Math.max(rectF2.left, right2))) / f3;
            }
            if (f11 > this.d) {
                f = f * f3;
                f11 = (rectF.right - (Math.max(rectF2.left, rectF.right - f))) / f3;
            }
            if (!z || !z2) {
                if (rectF.bottom && 0.0f < rectF2.top) {
                    top2 = (top2 - top22) * f3;
                    f11 = (rectF.right - (Math.max(rectF2.left, rectF.right - top2))) / f3;
                }
                if (z2) {
                    f11 += top2;
                    if (rectF.right - top2 > rectF2.bottom) {
                        bottom2 = (bottom2 - top2) * f3;
                        max = Math.max(max, Math.max(rectF2.left, rectF.right - bottom2));
                    }
                }
            } else {
                top2 = rectF.right - (rectF2.height() * f3);
                max = Math.max(max, Math.max(rectF2.left, top2));
            }
        }
        rectF.left = max;
    }

    private void d(RectF rectF, float f) {
        rectF.left = rectF.right - (rectF.height() * f);
    }

    private void e(RectF rectF, RectF rectF2, float f) {
        float f5 = 0.0f;
        rectF.inset((rectF.width() - (rectF.height() * f)) / 2f, f5);
        if (rectF.left < rectF2.left) {
            left2 = left2 - left22;
            rectF.offset(left2, 0.0f);
        }
        if (rectF.right > rectF2.right) {
            right2 = right2 - right22;
            rectF.offset(right2, 0.0f);
        }
    }

    private void f(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        int cmp3;
        float f4 = 1066192077;
        float i42;
        float f10;
        int cmp5;
        f9 = (float)i;
        if (f > f9) {
            i42 = (f - f9) / 1.05f + f9;
            f4 = 1.1f;
            f9 = (i42 - f9) / f4;
            pointF.x -= f9;
        }
        if (i42 > rectF2.right) {
            float f8 = 2f;
            f4 = (i42 - i42) / f8;
            pointF2.x -= f4;
        }
        float f11 = i42 - i42;
        if (this.f < f2) {
        }
        float f14 = i42 - left2;
        if (pointF.x < this.a) {
            i42 = left2 + f17;
        }
        float f15 = i42 - left2;
        if (pointF.x > this.c) {
            i42 = left2 + f7;
        }
        f3 = i42 - i42;
        if (pointF.x < f2) {
        }
        if (f3 > 0) {
            f10 = (i42 - left2) / f3;
            if (f10 < this.b) {
                f3 = f3 * f3;
                left2 = left2 + f3;
                i42 = (Math.min(rectF2.right, left2)) - rectF.left;
                f10 = i42 / f3;
            }
            if (f10 > this.d) {
                i42 = (Math.min(rectF2.right, rectF.left + (i42 * f3))) - rectF.left;
                f10 = i42 / f3;
            }
            if (!z || !z2) {
                if (z && f33 < rectF2.top) {
                    i42 = (Math.min(rectF2.right, rectF.left + (i42 - top2) * f3)) - rectF.left;
                    f10 = i42 / f3;
                }
                if (z2) {
                    f10 += i42;
                    if (f26 > rectF2.bottom) {
                        i42 = Math.min(i42, Math.min(rectF2.right, rectF.left + (bottom2 - i42) * f3));
                    }
                }
            } else {
                i42 = Math.min(i42, Math.min(rectF2.right, rectF.left + (rectF2.height() * f3)));
            }
        }
        rectF.right = i42;
    }

    private void g(RectF rectF, float f) {
        rectF.right = rectF.left + (rectF.height() * f);
    }

    private void h(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        int cmp2;
        float bottom2;
        float f7;
        float max;
        float f11;
        float left2;
        f = 0.0f;
        if (f < 0.0f) {
            max = f / 1.05f;
            f7 = max / 1.1f;
            pointF.y -= f7;
        }
        if (max < rectF2.top) {
            float f10 = 2f;
            f9 = (max - max) / f10;
            pointF2.y -= f9;
        }
        float f14 = max - max;
        if (this.f < f2) {
        }
        float f16 = bottom2 - max;
        if (pointF2.y < this.b) {
            max = bottom2 - f19;
        }
        float f17 = bottom2 - max;
        if (pointF2.y > this.d) {
            max = bottom2 - f20;
        }
        f8 = max - max;
        if (pointF2.y < f2) {
        }
        if (f3 > 0.0f) {
            f11 = (bottom2 - max) * f3;
            if (f11 < this.a) {
                f3 = f3 / f3;
                bottom2 = bottom2 - f3;
                f11 = (rectF.bottom - (Math.max(rectF2.top, bottom2))) * f3;
            }
            if (f11 > this.c) {
                f = f / f3;
                f11 = (rectF.bottom - (Math.max(rectF2.top, rectF.bottom - f))) * f3;
            }
            if (!z || !z2) {
                if (rectF.right && this.c < rectF2.left) {
                    left2 = (left2 - left22) / f3;
                    f11 = (rectF.bottom - (Math.max(rectF2.top, rectF.bottom - left2))) * f3;
                }
                if (z2) {
                    f11 += left2;
                    if (rectF.bottom - f > rectF2.right) {
                        right2 = (right2 - left2) / f3;
                        max = Math.max(max, Math.max(rectF2.top, rectF.bottom - right2));
                    }
                }
            } else {
                left2 = rectF.bottom - (rectF2.width() / f3);
                max = Math.max(max, Math.max(rectF2.top, left2));
            }
        }
        rectF.top = max;
    }

    private void i(RectF rectF, RectF rectF2, float f) {
        float f5 = 0.0f;
        rectF.inset(f5, (rectF.height() - (rectF.width() / f)) / 2f);
        if (rectF.top < rectF2.top) {
            top2 = top2 - top22;
            rectF.offset(0.0f, top2);
        }
        if (rectF.bottom > rectF2.bottom) {
            bottom2 = bottom2 - bottom22;
            rectF.offset(0.0f, bottom2);
        }
    }

    private void j(RectF rectF, float f) {
        rectF.top = rectF.bottom - (rectF.width() / f);
    }

    private void l(RectF rectF, float f, float f2) {
        int i2;
        float rectF2 = 0;
        int i3 = 0;
        float left2;
        float centerY;
        i3 = 0;
        switch (h.a.a[this.e.ordinal()]) {
            case 1: /* ordinal */
                f = rectF.left - f;
                centerY -= f2;
                break;
            case 2: /* ordinal */
                float f4 = rectF.right - f;
                centerY -= f2;
                break;
            case 3: /* ordinal */
                float f6 = rectF.left - f;
                centerY -= f2;
                break;
            case 4: /* ordinal */
                float f7 = rectF.right - f;
                centerY -= f2;
                break;
            case 5: /* ordinal */
                break;
            case 6: /* ordinal */
                centerY -= f2;
                break;
            case 7: /* ordinal */
                break;
            case 8: /* ordinal */
                centerY -= f2;
                break;
            case 9: /* ordinal */
                float f5 = rectF.bottom.centerX() - f;
                centerY = rectF.centerY();
                centerY -= f2;
                break;
            default:
        }
        this.f.x = rectF2;
        this.f.y = i3;
    }

    private void n(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3) {
        float f4;
        float f5;
        float f6;
        float f8;
        f6 = f - rectF.centerX();
        f8 = f2 - rectF.centerY();
        float f11 = left2 + f6;
        final float f12 = 0.0f;
        final float f13 = 2f;
        final float f14 = 1.05f;
        if (f11 >= 0.0f) {
            f5 = right2 + f6;
            float f16 = (float)i;
            if (f5 <= f16) {
                left2 = left2 + f6;
                if (rectF.left >= rectF2.left) {
                    f4 = right2 + f6;
                    if (rectF.right > rectF2.right) {
                        f6 = f6 / f14;
                        f4 = f6 / f13;
                        pointF2.x -= f4;
                    }
                }
            }
        }
        float f9 = top2 + f8;
        if (pointF2.x >= 0.0f) {
            f4 = bottom2 + f8;
            float f17 = (float)i2;
            if (rectF.right <= f17) {
                float f15 = top2 + f8;
                if (rectF.top >= rectF2.top) {
                    f = bottom2 + f8;
                    if (pointF2.x > rectF2.bottom) {
                        f8 = f8 / f14;
                        f = f8 / f13;
                        pointF.y -= f;
                    }
                }
            }
        }
        rectF.offset(f6, f8);
        q(rectF, rectF2, f3);
    }

    private void o(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3, float f4) {
        rectF2 = rectF;
        f22 = f;
        float f22 = f2;
        final RectF rectF42 = rectF2;
        final float f72 = f4;
        switch (h.a.a[this.e.ordinal()]) {
            case 1: /* ordinal */
                float f6 = h.k(f, f22, rectF2.right, rectF2.bottom);
                boolean z = false;
                this.h(rectF, f2, rectF2, f3, f4, true, false);
                d(rectF, f72);
                z = false;
                this.c(rectF, f, rectF2, f3, f4, true, false);
                j(rectF, f72);
                break;
            case 2: /* ordinal */
                float f5 = h.k(rectF2.left, f22, f, rectF2.bottom);
                z = true;
                this.h(rectF, f2, rectF2, f3, f4, false, true);
                g(rectF, f72);
                z = true;
                boolean z2 = false;
                this.f(rectF, f, rectF2, i, f3, f4, true, false);
                j(rectF, f72);
                break;
            case 3: /* ordinal */
                f4 = h.k(f, rectF2.top, rectF2.right, f22);
                z = true;
                z2 = false;
                this.a(rectF, f2, rectF2, i2, f3, f4, true, false);
                d(rectF, f72);
                z = true;
                this.c(rectF, f, rectF2, f3, f4, false, true);
                b(rectF, f72);
                break;
            case 4: /* ordinal */
                f = h.k(rectF2.left, rectF2.top, f, f22);
                z = false;
                z2 = true;
                this.a(rectF, f2, rectF2, i2, f3, f4, false, true);
                g(rectF, f72);
                z = false;
                z2 = true;
                this.f(rectF, f, rectF2, i, f3, f4, false, true);
                b(rectF, f72);
                break;
            case 5: /* ordinal */
                z = true;
                this.c(rectF, f, rectF2, f3, f4, true, true);
                i(rectF, rectF42, f72);
                break;
            case 6: /* ordinal */
                z = true;
                this.h(rectF, f2, rectF2, f3, f4, true, true);
                e(rectF, rectF42, f72);
                break;
            case 7: /* ordinal */
                z = true;
                z2 = true;
                this.f(rectF, f, rectF2, i, f3, f4, true, true);
                i(rectF, rectF42, f72);
                break;
            case 8: /* ordinal */
                z = true;
                z2 = true;
                this.a(rectF, f2, rectF2, i2, f3, f4, true, true);
                e(rectF, rectF42, f72);
                break;
            default:
        }
    }

    private void p(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3) {
        switch (h.a.a[this.e.ordinal()]) {
            case 1: /* ordinal */
                float f72 = 0.0f;
                boolean z = false;
                boolean z2 = false;
                Object rectF3 = this;
                rectF2 = rectF;
                rectF42 = rectF2;
                f72 = f3;
                rectF3.h(rectF2, f2, rectF42, f72, 0.0f, z, z2);
                rectF3.c(rectF2, f, rectF42, f72, 0.0f, z, z2);
                break;
            case 2: /* ordinal */
                z2 = false;
                ordinal = this;
                rectF2 = rectF;
                rectF42 = rectF2;
                ordinal.h(rectF2, f2, rectF42, f3, 0.0f, false, z2);
                boolean z3 = false;
                ordinal.f(rectF2, f, rectF42, i, f3, 0.0f, z2, false);
                break;
            case 3: /* ordinal */
                z2 = false;
                z3 = false;
                rectF3 = this;
                rectF2 = rectF;
                rectF42 = rectF2;
                rectF3.a(rectF2, f2, rectF42, i2, f3, 0.0f, z2, false);
                f72 = 0.0f;
                z = false;
                rectF3.c(rectF2, f, rectF42, f3, 0.0f, false, z2);
                break;
            case 4: /* ordinal */
                float f4 = 0.0f;
                z2 = false;
                z3 = false;
                rectF3 = this;
                rectF2 = rectF;
                rectF42 = rectF2;
                f72 = f3;
                rectF3.a(rectF2, f2, rectF42, i2, f72, 0.0f, z2, z3);
                rectF3.f(rectF2, f, rectF42, i, f72, 0.0f, z2, z3);
                break;
            case 5: /* ordinal */
                f72 = 0.0f;
                z = false;
                z2 = false;
                this.c(rectF, f, rectF2, f3, 0.0f, false, false);
                break;
            case 6: /* ordinal */
                f72 = 0.0f;
                z = false;
                z2 = false;
                this.h(rectF, f2, rectF2, f3, 0.0f, false, false);
                break;
            case 7: /* ordinal */
                z2 = false;
                z3 = false;
                this.f(rectF, f, rectF2, i, f3, 0.0f, false, false);
                break;
            case 8: /* ordinal */
                z2 = false;
                z3 = false;
                this.a(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                break;
            default:
        }
    }

    private void q(RectF rectF, RectF rectF2, float f) {
        f = left2 + f;
        final float f5 = 0.0f;
        if (rectF.left < f) {
            left2 = left2 - left22;
            rectF.offset(left2, 0.0f);
        }
        float f2 = top2 + f;
        if (rectF.top < f2) {
            top2 = top2 - top22;
            rectF.offset(0.0f, top2);
        }
        float f4 = right2 - f;
        if (rectF.right > f4) {
            right2 = right2 - right22;
            rectF.offset(right2, 0.0f);
        }
        float f6 = bottom2 - f;
        if (rectF.bottom > f6) {
            bottom2 = bottom2 - bottom22;
            rectF.offset(0.0f, bottom2);
        }
    }

    public void m(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3, boolean z, float f4) {
        final Object obj = this;
        final float f5 = f + pointF.x;
        final float f6 = f2 + pointF.y;
        if (obj.e == h.b.CENTER) {
            this.n(rectF, f5, f6, rectF2, i, i2, f3);
        } else {
            if (z) {
                this.o(rectF, f5, f6, rectF2, i, i2, f3, f4);
            } else {
                this.p(rectF, f5, f6, rectF2, i, i2, f3);
            }
        }
    }

    private static float k(float f, float f2, float f3, float f4) {
        return (f3 - f) / (f4 - f2);
    }
}
