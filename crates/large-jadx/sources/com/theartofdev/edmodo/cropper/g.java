package com.theartofdev.edmodo.cropper;

import android.graphics.RectF;

/* loaded from: classes2.dex */
final class g {

    private final RectF a;
    private final RectF b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k = 1f;
    private float l = 1f;
    g() {
        super();
        RectF rectF = new RectF();
        this.a = rectF;
        RectF rectF2 = new RectF();
        this.b = rectF2;
        int i = 1065353216;
    }

    private boolean a() {
        return z ^= 1;
    }

    private com.theartofdev.edmodo.cropper.h.b g(float f, float f2) {
        com.theartofdev.edmodo.cropper.h.b obj7;
        int i5 = 1086324736;
        width /= i5;
        RectF rectF3 = this.a;
        float left = rectF3.left;
        final int i10 = 1084227584;
        height /= i5;
        float top = rectF2.top;
        int i7 = top + i3;
        top += i4;
        if (Float.compare(f, i9) < 0) {
            obj7 = Float.compare(f2, i7) < 0 ? h.b.TOP_LEFT : obj7 < 0 ? h.b.LEFT : h.b.BOTTOM_LEFT;
        } else {
            if (Float.compare(f, i8) < 0) {
                obj7 = Float.compare(f2, i7) < 0 ? h.b.TOP : obj7 < 0 ? h.b.CENTER : h.b.BOTTOM;
            } else {
                obj7 = Float.compare(f2, i7) < 0 ? h.b.TOP_RIGHT : obj7 < 0 ? h.b.RIGHT : h.b.BOTTOM_RIGHT;
            }
        }
        return obj7;
    }

    private com.theartofdev.edmodo.cropper.h.b i(float f, float f2, float f3) {
        boolean z;
        float right;
        float left;
        float right3;
        float right2;
        float bottom2;
        float bottom;
        com.theartofdev.edmodo.cropper.h.b obj8;
        float obj10;
        RectF rectF = this.a;
        if (g.m(f, f2, rectF.left, rectF.top, f3)) {
            obj8 = h.b.TOP_LEFT;
        } else {
            RectF rectF2 = this.a;
            if (g.m(f, f2, rectF2.right, rectF2.top, f3)) {
                obj8 = h.b.TOP_RIGHT;
            } else {
                RectF rectF3 = this.a;
                if (g.m(f, f2, rectF3.left, rectF3.bottom, f3)) {
                    obj8 = h.b.BOTTOM_LEFT;
                } else {
                    RectF rectF4 = this.a;
                    if (g.m(f, f2, rectF4.right, rectF4.bottom, f3)) {
                        obj8 = h.b.BOTTOM_RIGHT;
                    } else {
                        RectF rectF5 = this.a;
                        if (g.l(f, f2, rectF5.left, rectF5.top, rectF5.right, rectF5.bottom) && a()) {
                            if (a()) {
                                obj8 = h.b.CENTER;
                            } else {
                                RectF rectF6 = this.a;
                                if (g.n(f, f2, rectF6.left, rectF6.right, rectF6.top, f3)) {
                                    obj8 = h.b.TOP;
                                } else {
                                    RectF rectF7 = this.a;
                                    if (g.n(f, f2, rectF7.left, rectF7.right, rectF7.bottom, f3)) {
                                        obj8 = h.b.BOTTOM;
                                    } else {
                                        RectF rectF8 = this.a;
                                        if (g.o(f, f2, rectF8.left, rectF8.top, rectF8.bottom, f3)) {
                                            obj8 = h.b.LEFT;
                                        } else {
                                            z = this.a;
                                            if (g.o(f, f2, z.right, z.top, z.bottom, f3)) {
                                                obj8 = h.b.RIGHT;
                                            } else {
                                                obj10 = this.a;
                                                if (g.l(f, f2, obj10.left, obj10.top, obj10.right, obj10.bottom) && !a()) {
                                                    obj8 = !a() ? h.b.CENTER : 0;
                                                } else {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                        }
                    }
                }
            }
        }
        return obj8;
    }

    private static boolean l(float f, float f2, float f3, float f4, float f5, float f6) {
        float obj0;
        if (Float.compare(f, f3) > 0 && Float.compare(f, f5) < 0 && Float.compare(f2, f4) > 0 && Float.compare(f2, f6) < 0) {
            if (Float.compare(f, f5) < 0) {
                if (Float.compare(f2, f4) > 0) {
                    obj0 = Float.compare(f2, f6) < 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj0;
    }

    private static boolean m(float f, float f2, float f3, float f4, float f5) {
        int obj0;
        int obj1;
        if (Float.compare(obj0, f5) <= 0 && Float.compare(obj0, f5) <= 0) {
            obj0 = Float.compare(obj0, f5) <= 0 ? 1 : 0;
        } else {
        }
        return obj0;
    }

    private static boolean n(float f, float f2, float f3, float f4, float f5, float f6) {
        int obj0;
        int obj1;
        if (Float.compare(f, f3) > 0 && Float.compare(f, f4) < 0 && Float.compare(obj0, f6) <= 0) {
            if (Float.compare(f, f4) < 0) {
                obj0 = Float.compare(obj0, f6) <= 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj0;
    }

    private static boolean o(float f, float f2, float f3, float f4, float f5, float f6) {
        int obj0;
        if (Float.compare(obj0, f6) <= 0 && Float.compare(f2, f4) > 0 && Float.compare(f2, f5) < 0) {
            if (Float.compare(f2, f4) > 0) {
                obj0 = Float.compare(f2, f5) < 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj0;
    }

    public float b() {
        return Math.min(this.f, f3 /= f4);
    }

    public float c() {
        return Math.min(this.e, f3 /= f4);
    }

    public float d() {
        return Math.max(this.d, f3 /= f4);
    }

    public float e() {
        return Math.max(this.c, f3 /= f4);
    }

    public com.theartofdev.edmodo.cropper.h f(float f, float f2, float f3, com.theartofdev.edmodo.cropper.CropImageView.c cropImageView$c4) {
        com.theartofdev.edmodo.cropper.h.b obj4;
        int obj5;
        if (c4 == CropImageView.c.OVAL) {
            obj4 = g(f, f2);
        } else {
            obj4 = i(f, f2, f3);
        }
        if (obj4 != null) {
            obj5 = new h(obj4, this, f, f2);
        } else {
            obj5 = 0;
        }
        return obj5;
    }

    public RectF h() {
        this.b.set(this.a);
        return this.b;
    }

    public float j() {
        return this.l;
    }

    public float k() {
        return this.k;
    }

    public void p(float f, float f2, float f3, float f4) {
        this.e = f;
        this.f = f2;
        this.k = f3;
        this.l = f4;
    }

    public void q(com.theartofdev.edmodo.cropper.f f) {
        this.c = (float)i;
        this.d = (float)i2;
        this.g = (float)i3;
        this.h = (float)i4;
        this.i = (float)i5;
        this.j = (float)obj2;
    }

    public void r(RectF rectF) {
        this.a.set(rectF);
    }

    public boolean s() {
        int cmp;
        int i;
        final int i2 = 1120403456;
        if (Float.compare(width, i2) >= 0 && Float.compare(height, i2) >= 0) {
            i = Float.compare(height, i2) >= 0 ? 1 : 0;
        } else {
        }
        return i;
    }
}
