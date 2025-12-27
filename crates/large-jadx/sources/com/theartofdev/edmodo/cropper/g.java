package com.theartofdev.edmodo.cropper;

import android.graphics.RectF;

/* compiled from: CropWindowHandler.java */
/* loaded from: classes2.dex */
final class g {

    private final RectF a = new RectF();
    private final RectF b = new RectF();
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
        RectF rectF2 = new RectF();
    }

    private boolean a() {
        return !s();
    }

    private h.b g(float f, float f2) {
        com.theartofdev.edmodo.cropper.h.b rIGHT2;
        float f7 = 6f;
        float f3 = this.a.width() / f7;
        final float f11 = left2 + f3;
        final float f12 = 5f;
        float f10 = left2 + (f3 * f12);
        float f5 = this.a.height() / f7;
        float f9 = top2 + f5;
        float f8 = top2 + (f5 * f12);
        if (f < f11) {
            if (f2 < this.a) {
                rIGHT2 = h.b.TOP_LEFT;
            } else {
                f = f2 < this.a ? h.b.LEFT : h.b.BOTTOM_LEFT;
            }
        } else {
            if (f < rectF3.left) {
                if (f2 < this.a) {
                    f = h.b.TOP;
                } else {
                    f = f2 < this.a ? h.b.CENTER : h.b.BOTTOM;
                }
            } else {
                if (f2 < this.a) {
                    f = h.b.TOP_RIGHT;
                } else {
                    f = f2 < this.a ? h.b.RIGHT : h.b.BOTTOM_RIGHT;
                }
            }
        }
        return (f2 < this.a ? h.b.LEFT : h.b.BOTTOM_LEFT);
    }

    private h.b i(float f, float f2, float f3) {
        com.theartofdev.edmodo.cropper.h.b tOP_LEFT2 = null;
        if (g.m(f, f2, rectF.left, rectF.top, f3)) {
            tOP_LEFT2 = h.b.TOP_LEFT;
        } else {
            if (g.m(f, f2, rectF2.right, rectF2.top, f3)) {
                tOP_LEFT2 = h.b.TOP_RIGHT;
            } else {
                if (g.m(f, f2, rectF3.left, rectF3.bottom, f3)) {
                    tOP_LEFT2 = h.b.BOTTOM_LEFT;
                } else {
                    if (g.m(f, f2, rectF4.right, rectF4.bottom, f3)) {
                        tOP_LEFT2 = h.b.BOTTOM_RIGHT;
                    } else {
                        if (!g.l(f, f2, rectF5.left, rectF5.top, rectF5.right, rectF5.bottom) || !this.a()) {
                            if (g.n(f, f2, rectF6.left, rectF6.right, rectF6.top, f3)) {
                                tOP_LEFT2 = h.b.TOP;
                            } else {
                                if (g.n(f, f2, rectF7.left, rectF7.right, rectF7.bottom, f3)) {
                                    tOP_LEFT2 = h.b.BOTTOM;
                                } else {
                                    if (g.o(f, f2, rectF8.left, rectF8.top, rectF8.bottom, f3)) {
                                        tOP_LEFT2 = h.b.LEFT;
                                    } else {
                                        if (g.o(f, f2, rectF9.right, rectF9.top, rectF9.bottom, f3)) {
                                            tOP_LEFT2 = h.b.RIGHT;
                                        } else {
                                            f = g.l(f, f2, rectF10.left, rectF10.top, rectF10.right, rectF10.bottom) && !this.a() ? h.b.CENTER : 0;
                                        }
                                    }
                                }
                            }
                        } else {
                            f = h.b.CENTER;
                        }
                    }
                }
            }
        }
        return (g.l(f, f2, rectF10.left, rectF10.top, rectF10.right, rectF10.bottom) && !this.a() ? h.b.CENTER : 0);
    }

    private static boolean m(float f, float f2, float f3, float f4, float f5) {
        boolean z = false;
        float f6;
        float abs = Math.abs(f - f3);
        if (abs <= f5) {
            f6 = f2 - f4;
            float abs2 = Math.abs(f6);
            f = abs2 <= f5 ? 1 : 0;
        }
        return (abs2 <= f5 ? 1 : 0);
    }

    private static boolean n(float f, float f2, float f3, float f4, float f5, float f6) {
        boolean z = true;
        float f7;
        if (f > f3) {
            if (f < f4) {
                f7 = f2 - f5;
                float abs = Math.abs(f7);
                f = abs <= f6 ? 1 : 0;
            }
        }
        return (abs <= f6 ? 1 : 0);
    }

    private static boolean o(float f, float f2, float f3, float f4, float f5, float f6) {
        boolean z = true;
        float abs = Math.abs(f - f3);
        if (abs <= f6) {
            if (f2 > f4) {
                f = f2 < f5 ? 1 : 0;
            }
        }
        return (f2 < f5 ? 1 : 0);
    }

    public float b() {
        return Math.min(this.f, this.j / this.l);
    }

    public float c() {
        return Math.min(this.e, this.i / this.k);
    }

    public float d() {
        return Math.max(this.d, this.h / this.l);
    }

    public float e() {
        return Math.max(this.c, this.g / this.k);
    }

    public h f(float f, float f2, float f3, CropImageView.c cVar) {
        com.theartofdev.edmodo.cropper.h.b bVar;
        int i = 0;
        if (cVar == CropImageView.c.OVAL) {
            bVar = g(f, f2);
        } else {
            bVar = i(f, f2, f3);
        }
        cVar = bVar != null ? new h(bVar, this, f, f2) : 0;
        return (bVar != null ? new h(bVar, this, f, f2) : 0);
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

    public void q(f fVar) {
        this.c = (float)fVar.P;
        this.d = (float)fVar.Q;
        this.g = (float)fVar.R;
        this.h = (float)fVar.S;
        this.i = (float)fVar.T;
        this.j = (float)fVar.U;
    }

    public void r(RectF rectF) {
        this.a.set(rectF);
    }

    public boolean s() {
        boolean z = false;
        float width = this.a.width();
        final float f = 100f;
        if (width >= f) {
            float height = this.a.height();
            int r0 = height >= f ? 1 : 0;
        }
        return (height >= f ? 1 : 0);
    }

    private static boolean l(float f, float f2, float f3, float f4, float f5, float f6) {
        boolean z = true;
        if (f > f3) {
            if (f < f5) {
                if (f2 > f4) {
                    f = f2 < f6 ? 1 : 0;
                }
            }
        }
        return (f2 < f6 ? 1 : 0);
    }
}
