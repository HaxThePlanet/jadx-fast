package com.theartofdev.edmodo.cropper;

import android.accounts.Account;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

/* loaded from: classes2.dex */
final class h {

    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final com.theartofdev.edmodo.cropper.h.b e;
    private final PointF f;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            h.a.a = iArr;
            iArr[h.b.TOP_LEFT.ordinal()] = 1;
            h.a.a[h.b.TOP_RIGHT.ordinal()] = 2;
            h.a.a[h.b.BOTTOM_LEFT.ordinal()] = 3;
            h.a.a[h.b.BOTTOM_RIGHT.ordinal()] = 4;
            h.a.a[h.b.LEFT.ordinal()] = 5;
            h.a.a[h.b.TOP.ordinal()] = 6;
            h.a.a[h.b.RIGHT.ordinal()] = 7;
            h.a.a[h.b.BOTTOM.ordinal()] = 8;
            h.a.a[h.b.CENTER.ordinal()] = 9;
        }
    }

    public static enum b {

        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        CENTER;
    }
    static {
        Matrix matrix = new Matrix();
    }

    public h(com.theartofdev.edmodo.cropper.h.b h$b, com.theartofdev.edmodo.cropper.g g2, float f3, float f4) {
        super();
        PointF pointF = new PointF();
        this.f = pointF;
        this.e = b;
        this.a = g2.e();
        this.b = g2.d();
        this.c = g2.c();
        this.d = g2.b();
        l(g2.h(), f3, f4);
    }

    private void a(RectF rectF, float f2, RectF rectF3, int i4, float f5, float f6, boolean z7, boolean z8) {
        int cmp;
        int cmp2;
        float left;
        int i;
        int i2;
        int i5;
        float cmp3;
        int i3;
        float obj6;
        Object obj7;
        float obj8;
        int obj9;
        int obj11;
        obj8 = (float)i4;
        if (Float.compare(f2, obj8) > 0) {
            cmp = this.f;
            cmp.y = f -= obj8;
        }
        obj8 = rectF3.bottom;
        if (Float.compare(obj6, obj8) > 0) {
            cmp2 = this.f;
            cmp2.y = f3 -= i5;
        }
        if (Float.compare(i7, f5) < 0) {
            obj6 = obj8;
        }
        left = rectF.top;
        float f4 = this.b;
        if (Float.compare(i8, f4) < 0) {
            obj6 = left + f4;
        }
        cmp3 = this.d;
        if (Float.compare(i9, cmp3) > 0) {
            obj6 = left + cmp3;
        }
        if (Float.compare(i2, f5) < 0) {
            obj6 = obj8;
        }
        i2 = this.a;
        if (Float.compare(f6, obj9) > 0 && Float.compare(obj9, i2) < 0) {
            i2 = this.a;
            if (Float.compare(obj9, i2) < 0) {
                obj9 = obj8 * f6;
            }
            obj8 = this.c;
            if (Float.compare(obj9, obj8) > 0) {
                obj9 = obj8 * f6;
            }
            if (z7 != 0 && z8) {
                if (z8) {
                    obj6 = Math.min(obj6, Math.min(rectF3.bottom, obj9 += obj7));
                } else {
                    obj8 = rectF.right;
                    left = rectF3.left;
                    if (z7 != 0 && Float.compare(obj11, left) < 0) {
                        obj8 = rectF.right;
                        left = rectF3.left;
                        if (Float.compare(obj11, left) < 0) {
                            obj9 = obj8 * f6;
                        }
                    }
                    obj8 = rectF.left;
                    obj11 = rectF3.right;
                    if (z8 && Float.compare(obj9, obj11) > 0) {
                        obj8 = rectF.left;
                        obj11 = rectF3.right;
                        if (Float.compare(obj9, obj11) > 0) {
                            obj6 = Math.min(obj6, Math.min(rectF3.bottom, obj9 += obj11));
                        }
                    }
                }
            } else {
            }
        }
        rectF.bottom = obj6;
    }

    private void b(RectF rectF, float f2) {
        rectF.bottom = top += i2;
    }

    private void c(RectF rectF, float f2, RectF rectF3, float f4, float f5, boolean z6, boolean z7) {
        int cmp;
        float f;
        int cmp2;
        float left;
        int i4;
        int cmp3;
        float right;
        int i2;
        int cmp4;
        int i;
        int i3;
        int obj8;
        Object obj9;
        int obj10;
        float obj12;
        float obj13;
        cmp = 0;
        if (Float.compare(f2, cmp) < 0) {
            cmp2 = this.f;
            cmp2.x = f3 -= i2;
        }
        left = rectF3.left;
        if (Float.compare(obj8, left) < 0) {
            cmp3 = this.f;
            cmp3.x = f6 -= i;
        }
        if (Float.compare(i7, f4) < 0) {
            obj8 = left;
        }
        right = rectF.right;
        float f7 = this.a;
        if (Float.compare(i9, f7) < 0) {
            obj8 = right - f7;
        }
        float f8 = this.c;
        if (Float.compare(i10, f8) > 0) {
            obj8 = right - f8;
        }
        if (Float.compare(cmp4, f4) < 0) {
            obj8 = left;
        }
        f = this.b;
        if (Float.compare(f5, cmp) > 0 && Float.compare(obj10, f) < 0) {
            f = this.b;
            if (Float.compare(obj10, f) < 0) {
                obj10 /= f5;
            }
            cmp = this.d;
            if (Float.compare(obj10, cmp) > 0) {
                obj10 /= f5;
            }
            if (z6 != 0 && z7 != 0) {
                if (z7 != 0) {
                    obj8 = Math.max(obj8, Math.max(rectF3.left, obj12 -= obj9));
                } else {
                    obj12 = rectF.bottom;
                    left = rectF3.top;
                    if (z6 != 0 && Float.compare(i5, left) < 0) {
                        obj12 = rectF.bottom;
                        left = rectF3.top;
                        if (Float.compare(i5, left) < 0) {
                            obj10 /= f5;
                        }
                    }
                    obj12 = rectF.top;
                    obj13 = rectF3.bottom;
                    if (z7 != 0 && Float.compare(obj10, obj13) > 0) {
                        obj12 = rectF.top;
                        obj13 = rectF3.bottom;
                        if (Float.compare(obj10, obj13) > 0) {
                            obj8 = Math.max(obj8, Math.max(rectF3.left, obj10 -= obj13));
                        }
                    }
                }
            } else {
            }
        }
        rectF.left = obj8;
    }

    private void d(RectF rectF, float f2) {
        rectF.left = right -= i2;
    }

    private void e(RectF rectF, RectF rectF2, float f3) {
        float left;
        float obj5;
        int obj6 = 0;
        rectF.inset(i /= obj6, obj6);
        float left2 = rectF.left;
        left = rectF2.left;
        if (Float.compare(left2, left) < 0) {
            rectF.offset(left -= left2, obj6);
        }
        float right = rectF.right;
        obj5 = rectF2.right;
        if (Float.compare(right, obj5) > 0) {
            rectF.offset(obj5 -= right, obj6);
        }
    }

    private void f(RectF rectF, float f2, RectF rectF3, int i4, float f5, float f6, boolean z7, boolean z8) {
        int cmp3;
        int cmp2;
        float left;
        int i3;
        int i;
        int i2;
        float cmp;
        int i5;
        float obj6;
        Object obj7;
        float obj8;
        int obj9;
        int obj11;
        obj8 = (float)i4;
        if (Float.compare(f2, obj8) > 0) {
            cmp3 = this.f;
            cmp3.x = f -= obj8;
        }
        obj8 = rectF3.right;
        if (Float.compare(obj6, obj8) > 0) {
            cmp2 = this.f;
            cmp2.x = f3 -= i2;
        }
        if (Float.compare(i7, f5) < 0) {
            obj6 = obj8;
        }
        left = rectF.left;
        float f4 = this.a;
        if (Float.compare(i8, f4) < 0) {
            obj6 = left + f4;
        }
        cmp = this.c;
        if (Float.compare(i9, cmp) > 0) {
            obj6 = left + cmp;
        }
        if (Float.compare(i, f5) < 0) {
            obj6 = obj8;
        }
        i = this.b;
        if (Float.compare(f6, obj9) > 0 && Float.compare(obj9, i) < 0) {
            i = this.b;
            if (Float.compare(obj9, i) < 0) {
                obj9 = obj8 / f6;
            }
            obj8 = this.d;
            if (Float.compare(obj9, obj8) > 0) {
                obj9 = obj8 / f6;
            }
            if (z7 != 0 && z8) {
                if (z8) {
                    obj6 = Math.min(obj6, Math.min(rectF3.right, obj9 += obj7));
                } else {
                    obj8 = rectF.bottom;
                    left = rectF3.top;
                    if (z7 != 0 && Float.compare(obj11, left) < 0) {
                        obj8 = rectF.bottom;
                        left = rectF3.top;
                        if (Float.compare(obj11, left) < 0) {
                            obj9 = obj8 / f6;
                        }
                    }
                    obj8 = rectF.top;
                    obj11 = rectF3.bottom;
                    if (z8 && Float.compare(obj9, obj11) > 0) {
                        obj8 = rectF.top;
                        obj11 = rectF3.bottom;
                        if (Float.compare(obj9, obj11) > 0) {
                            obj6 = Math.min(obj6, Math.min(rectF3.right, obj9 += obj11));
                        }
                    }
                }
            } else {
            }
        }
        rectF.right = obj6;
    }

    private void g(RectF rectF, float f2) {
        rectF.right = left += i2;
    }

    private void h(RectF rectF, float f2, RectF rectF3, float f4, float f5, boolean z6, boolean z7) {
        int cmp;
        float f;
        int cmp4;
        float left;
        int i;
        int cmp3;
        float bottom;
        int i2;
        int cmp2;
        int i3;
        int i4;
        int obj8;
        Object obj9;
        int obj10;
        float obj12;
        float obj13;
        cmp = 0;
        if (Float.compare(f2, cmp) < 0) {
            cmp4 = this.f;
            cmp4.y = f3 -= i2;
        }
        left = rectF3.top;
        if (Float.compare(obj8, left) < 0) {
            cmp3 = this.f;
            cmp3.y = f6 -= i3;
        }
        if (Float.compare(i7, f4) < 0) {
            obj8 = left;
        }
        bottom = rectF.bottom;
        float f7 = this.b;
        if (Float.compare(i9, f7) < 0) {
            obj8 = bottom - f7;
        }
        float f8 = this.d;
        if (Float.compare(i10, f8) > 0) {
            obj8 = bottom - f8;
        }
        if (Float.compare(cmp2, f4) < 0) {
            obj8 = left;
        }
        f = this.a;
        if (Float.compare(f5, cmp) > 0 && Float.compare(obj10, f) < 0) {
            f = this.a;
            if (Float.compare(obj10, f) < 0) {
                obj10 *= f5;
            }
            cmp = this.c;
            if (Float.compare(obj10, cmp) > 0) {
                obj10 *= f5;
            }
            if (z6 != 0 && z7 != 0) {
                if (z7 != 0) {
                    obj8 = Math.max(obj8, Math.max(rectF3.top, obj12 -= obj9));
                } else {
                    obj12 = rectF.right;
                    left = rectF3.left;
                    if (z6 != 0 && Float.compare(i5, left) < 0) {
                        obj12 = rectF.right;
                        left = rectF3.left;
                        if (Float.compare(i5, left) < 0) {
                            obj10 *= f5;
                        }
                    }
                    obj12 = rectF.left;
                    obj13 = rectF3.right;
                    if (z7 != 0 && Float.compare(obj10, obj13) > 0) {
                        obj12 = rectF.left;
                        obj13 = rectF3.right;
                        if (Float.compare(obj10, obj13) > 0) {
                            obj8 = Math.max(obj8, Math.max(rectF3.top, obj10 -= obj13));
                        }
                    }
                }
            } else {
            }
        }
        rectF.top = obj8;
    }

    private void i(RectF rectF, RectF rectF2, float f3) {
        float top;
        float obj5;
        int obj6 = 0;
        rectF.inset(obj6, i /= obj6);
        float top2 = rectF.top;
        top = rectF2.top;
        if (Float.compare(top2, top) < 0) {
            rectF.offset(obj6, top -= top2);
        }
        float bottom = rectF.bottom;
        obj5 = rectF2.bottom;
        if (Float.compare(bottom, obj5) > 0) {
            rectF.offset(obj6, obj5 -= bottom);
        }
    }

    private void j(RectF rectF, float f2) {
        rectF.top = bottom -= i2;
    }

    private static float k(float f, float f2, float f3, float f4) {
        return obj2 /= obj3;
    }

    private void l(RectF rectF, float f2, float f3) {
        int centerX;
        int i;
        int i3;
        int i2;
        float obj4;
        i3 = 0;
        switch (centerX) {
            case 1:
                i3 = centerX - f2;
                obj4 = rectF.top;
                obj4 -= f3;
                break;
            case 2:
                i3 = centerX - f2;
                obj4 = rectF.top;
                obj4 -= f3;
                break;
            case 3:
                i3 = centerX - f2;
                obj4 = rectF.bottom;
                obj4 -= f3;
                break;
            case 4:
                i3 = centerX - f2;
                obj4 = rectF.bottom;
                obj4 -= f3;
                break;
            case 5:
                obj4 = rectF.left;
                i3 = obj4;
                obj4 = i2;
                break;
            case 6:
                obj4 = rectF.top;
                obj4 -= f3;
                break;
            case 7:
                obj4 = rectF.right;
                i3 = obj4;
                obj4 = i2;
                break;
            case 8:
                obj4 = rectF.bottom;
                obj4 -= f3;
                break;
            case 9:
                i3 = centerX - f2;
                obj4 = rectF.centerY();
                obj4 -= f3;
                break;
            default:
                obj4 = i3;
        }
        final PointF obj5 = this.f;
        obj5.x = i3;
        obj5.y = obj4;
    }

    private void n(RectF rectF, float f2, float f3, RectF rectF4, int i5, int i6, float f7) {
        int left;
        int bottom;
        int right;
        int i;
        int obj8;
        int obj9;
        int obj11;
        float obj12;
        f2 -= centerX;
        f3 -= centerY;
        left = rectF.left;
        final int i4 = 0;
        final int i7 = 1073741824;
        final int i8 = 1065772646;
        right = rectF.right;
        if (Float.compare(i3, i4) >= 0 && Float.compare(i, obj11) <= 0 && Float.compare(left, obj11) >= 0) {
            right = rectF.right;
            if (Float.compare(i, obj11) <= 0) {
                if (Float.compare(left, obj11) >= 0) {
                    if (Float.compare(right, obj11) > 0) {
                        obj11 = this.f;
                        obj11.x = f -= right;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        obj11 = rectF.top;
        bottom = rectF.bottom;
        if (Float.compare(i2, i4) >= 0 && Float.compare(right, obj12) <= 0 && Float.compare(obj11, obj12) >= 0) {
            bottom = rectF.bottom;
            if (Float.compare(right, obj12) <= 0) {
                if (Float.compare(obj11, obj12) >= 0) {
                    if (Float.compare(bottom, obj11) > 0) {
                        obj11 = this.f;
                        obj11.y = obj12 -= bottom;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        rectF.offset(obj8, obj9);
        q(rectF, rectF4, f7);
    }

    private void o(RectF rectF, float f2, float f3, RectF rectF4, int i5, int i6, float f7, float f8) {
        int i2;
        RectF ordinal;
        float f4;
        RectF f6;
        int i3;
        float f;
        float f5;
        int i;
        int i4;
        final Object obj2 = rectF;
        f4 = f2;
        f6 = f3;
        final RectF rectF2 = rectF4;
        final float f13 = f8;
        switch (i2) {
            case 1:
                this.h(rectF, f3, rectF4, f7, f8, true, false);
                d(rectF, f13);
                this.c(rectF, f2, rectF4, f7, f8, true, false);
                j(rectF, f13);
                break;
            case 2:
                this.h(rectF, f3, rectF4, f7, f8, false, true);
                g(rectF, f13);
                this.f(rectF, f2, rectF4, i5, f7, f8, true, false);
                j(rectF, f13);
                break;
            case 3:
                this.a(rectF, f3, rectF4, i6, f7, f8, true, false);
                d(rectF, f13);
                this.c(rectF, f2, rectF4, f7, f8, false, true);
                b(rectF, f13);
                break;
            case 4:
                this.a(rectF, f3, rectF4, i6, f7, f8, false, true);
                g(rectF, f13);
                this.f(rectF, f2, rectF4, i5, f7, f8, false, true);
                b(rectF, f13);
                break;
            case 5:
                this.c(rectF, f2, rectF4, f7, f8, true, true);
                i(rectF, rectF2, f13);
                break;
            case 6:
                this.h(rectF, f3, rectF4, f7, f8, true, true);
                e(rectF, rectF2, f13);
                break;
            case 7:
                this.f(rectF, f2, rectF4, i5, f7, f8, true, true);
                i(rectF, rectF2, f13);
                break;
            case 8:
                this.a(rectF, f3, rectF4, i6, f7, f8, true, true);
                e(rectF, rectF2, f13);
                break;
            default:
        }
    }

    private void p(RectF rectF, float f2, float f3, RectF rectF4, int i5, int i6, float f7) {
        int ordinal;
        RectF rectF3;
        float f;
        RectF rectF2;
        float f4;
        int i4;
        int i7;
        int i2;
        int i3;
        switch (i8) {
            case 1:
                i4 = 0;
                i7 = 0;
                i2 = 0;
                ordinal = this;
                rectF3 = rectF;
                rectF2 = rectF4;
                f4 = f7;
                ordinal.h(rectF3, f3, rectF2, f4, i4, i7, i2);
                ordinal.c(rectF3, f2, rectF2, f4, i4, i7, i2);
                break;
            case 2:
                i2 = 0;
                ordinal = this;
                rectF3 = rectF;
                rectF2 = rectF4;
                ordinal.h(rectF3, f3, rectF2, f7, 0, false, i2);
                ordinal.f(rectF3, f2, rectF2, i5, f7, 0, i2, false);
                break;
            case 3:
                i2 = 0;
                ordinal = this;
                rectF3 = rectF;
                rectF2 = rectF4;
                ordinal.a(rectF3, f3, rectF2, i6, f7, 0, i2, false);
                ordinal.c(rectF3, f2, rectF2, f7, 0, false, i2);
                break;
            case 4:
                i7 = 0;
                i2 = 0;
                i3 = 0;
                ordinal = this;
                rectF3 = rectF;
                rectF2 = rectF4;
                i4 = f7;
                ordinal.a(rectF3, f3, rectF2, i6, i4, i7, i2, i3);
                ordinal.f(rectF3, f2, rectF2, i5, i4, i7, i2, i3);
                break;
            case 5:
                this.c(rectF, f2, rectF4, f7, 0, false, false);
                break;
            case 6:
                this.h(rectF, f3, rectF4, f7, 0, false, false);
                break;
            case 7:
                this.f(rectF, f2, rectF4, i5, f7, 0, false, false);
                break;
            case 8:
                this.a(rectF, f3, rectF4, i6, f7, 0, false, false);
                break;
            default:
        }
    }

    private void q(RectF rectF, RectF rectF2, float f3) {
        float left;
        float top;
        float right;
        float obj6;
        float left2 = rectF.left;
        left = rectF2.left;
        final int i4 = 0;
        if (Float.compare(left2, i) < 0) {
            rectF.offset(left -= left2, i4);
        }
        float top2 = rectF.top;
        top = rectF2.top;
        if (Float.compare(top2, i2) < 0) {
            rectF.offset(i4, top -= top2);
        }
        float right2 = rectF.right;
        right = rectF2.right;
        if (Float.compare(right2, i3) > 0) {
            rectF.offset(right -= right2, i4);
        }
        float bottom = rectF.bottom;
        obj6 = rectF2.bottom;
        if (Float.compare(bottom, obj7) > 0) {
            rectF.offset(i4, obj6 -= bottom);
        }
    }

    public void m(RectF rectF, float f2, float f3, RectF rectF4, int i5, int i6, float f7, boolean z8, float f9) {
        Object obj;
        RectF rectF2;
        RectF rectF3;
        int i;
        int i2;
        float f;
        float f4;
        final Object obj2 = this;
        PointF pointF = obj2.f;
        final int i3 = f2 + f6;
        final int i4 = f3 + f5;
        if (obj2.e == h.b.CENTER) {
            this.n(rectF, i3, i4, rectF4, i5, i6, f7);
        } else {
            if (z8) {
                this.o(rectF, i3, i4, rectF4, i5, i6, f7, f9);
            } else {
                this.p(rectF, i3, i4, rectF4, i5, i6, f7);
            }
        }
    }
}
