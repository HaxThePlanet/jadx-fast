package com.airbnb.lottie.x;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.d;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.x.k0.c.b;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.y.h;
import com.airbnb.lottie.z.a;
import d.e.h;
import d.h.l.f0.b;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class q {

    private static final Interpolator a;
    private static h<WeakReference<Interpolator>> b;
    static c.a c;
    static c.a d;
    static {
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        q.a = linearInterpolator;
        q.c = c.a.a(/* result */);
        q.d = c.a.a(/* result */);
    }

    private static WeakReference<Interpolator> a(int i) {
        final Class<com.airbnb.lottie.x.q> obj = q.class;
        return (WeakReference)q.g().e(i);
        synchronized (obj) {
            obj = q.class;
            return (WeakReference)q.g().e(i);
        }
    }

    private static Interpolator b(PointF pointF, PointF pointF2) {
        float weakReference;
        int i;
        int i2;
        float f2;
        float f3;
        float f;
        Object obj6;
        Object obj7;
        int i4 = -1082130432;
        i = 1065353216;
        pointF.x = g.c(pointF.x, i4, i);
        int i5 = -1027080192;
        int i6 = 1120403456;
        pointF.y = g.c(pointF.y, i5, i6);
        pointF2.x = g.c(pointF2.x, i4, i);
        float f11 = g.c(pointF2.y, i5, i6);
        pointF2.y = f11;
        int i3 = h.i(pointF.x, pointF.y, pointF2.x, f11);
        weakReference = q.a(i3);
        if (weakReference != null) {
            i2 = weakReference.get();
        } else {
            i2 = 0;
        }
        if (weakReference != null) {
            if (i2 == 0) {
                obj6 = b.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
                obj6 = new WeakReference(obj6);
                q.h(i3, obj6);
            }
        } else {
        }
        return i2;
    }

    static <T> a<T> c(c c, d d2, float f3, com.airbnb.lottie.x.j0<T> j04, boolean z5, boolean z6) {
        if (z5 && z6) {
            if (z6) {
                return q.e(d2, c, f3, j04);
            }
        }
        if (z5) {
            return q.d(d2, c, f3, j04);
        }
        return q.f(c, f3, j04);
    }

    private static <T> a<T> d(d d, c c2, float f3, com.airbnb.lottie.x.j0<T> j04) {
        int i4;
        int i5;
        int i8;
        int i;
        int i9;
        int i2;
        int i3;
        Interpolator interpolator;
        int i10;
        int i6;
        int i11;
        int i7;
        Interpolator obj12;
        c2.e();
        final int i13 = 0;
        i9 = i13;
        i10 = i14;
        i5 = i7;
        while (c2.j()) {
            i6 = 1065353216;
            c2.H();
            i7 = p.e(c2, f3);
            i11 = p.e(c2, f3);
            i3 = 1;
            if (c2.n() == i3) {
            } else {
            }
            i9 = i13;
            i9 = i3;
            i5 = p.e(c2, i6);
            i4 = p.e(c2, i6);
            i8 = j04.a(c2, f3);
            i = j04.a(c2, f3);
            i10 = (float)i3;
        }
        c2.i();
        if (i9 != 0) {
            interpolator = obj12;
            i2 = i;
        } else {
            if (i4 != 0 && i5 != 0) {
                if (i5 != 0) {
                    obj12 = q.b(i4, i5);
                } else {
                    obj12 = q.a;
                }
            } else {
            }
            interpolator = obj12;
            i2 = i8;
        }
        super(d, i, i2, interpolator, i10, 0);
        obj12.o = i11;
        obj12.p = i7;
        return obj12;
    }

    private static <T> a<T> e(d d, c c2, float f3, com.airbnb.lottie.x.j0<T> j04) {
        Interpolator interpolator3;
        a aVar;
        boolean z;
        Interpolator aVar3;
        int i8;
        int i;
        int i12;
        int pointF2;
        int i7;
        int i21;
        int bEGIN_OBJECT;
        int i13;
        int i11;
        int i10;
        int i26;
        a aVar2;
        int i18;
        d dVar;
        int i9;
        int i16;
        int i3;
        int i4;
        int i19;
        int i25;
        Interpolator interpolator2;
        int i14;
        int i2;
        Interpolator interpolator;
        int i5;
        int i24;
        int i15;
        PointF pointF;
        int i20;
        int i6;
        boolean z2;
        int i23;
        int i22;
        c cVar = c2;
        aVar3 = f3;
        final Object obj = j04;
        c2.e();
        i8 = 0;
        i11 = 0;
        i10 = 0;
        i26 = 0;
        i18 = 0;
        i16 = 0;
        i3 = 0;
        i25 = 0;
        i2 = 0;
        i24 = 0;
        i20 = 0;
        i6 = 0;
        while (c2.j()) {
            bEGIN_OBJECT = 1;
            i22 = i8;
            i = i24;
            i23 = i20;
            c2.H();
            i8 = i22;
            i8 = p.e(c2, f3);
            i20 = p.e(c2, f3);
            if (c2.n() == bEGIN_OBJECT) {
            } else {
            }
            i11 = 0;
            i11 = bEGIN_OBJECT;
            if (c2.w() == c.b.BEGIN_OBJECT) {
            } else {
            }
            i22 = i8;
            i = i24;
            i23 = i20;
            i26 = p.e(c2, f3);
            c2.e();
            i21 = 0;
            bEGIN_OBJECT = 0;
            i14 = 0;
            i5 = 0;
            while (c2.j()) {
                int i29 = cVar.E(q.d);
                if (i29 != 0) {
                } else {
                }
                i22 = i8;
                if (c2.w() == c.b.NUMBER) {
                } else {
                }
                c2.c();
                i21 = (float)d7;
                i14 = (float)i24;
                c2.f();
                i24 = i12;
                i20 = i23;
                i8 = i22;
                i24 = i12;
                i21 = i14;
                i22 = i8;
                if (i29 != 1) {
                } else {
                }
                if (c2.w() == c.b.NUMBER) {
                } else {
                }
                i12 = i24;
                c2.c();
                bEGIN_OBJECT = (float)d2;
                i5 = (float)d3;
                c2.f();
                i24 = i12;
                bEGIN_OBJECT = i5;
                c2.H();
            }
            i22 = i8;
            i = i24;
            i23 = i20;
            pointF = new PointF(i21, bEGIN_OBJECT);
            pointF2 = new PointF(i14, i5);
            c2.i();
            i2 = pointF2;
            i25 = pointF;
            i24 = i;
            i29 = cVar.E(q.d);
            if (i29 != 0) {
            } else {
            }
            i22 = i8;
            if (c2.w() == c.b.NUMBER) {
            } else {
            }
            c2.c();
            i21 = (float)d7;
            i14 = (float)i24;
            c2.f();
            i24 = i12;
            i20 = i23;
            i8 = i22;
            i24 = i12;
            i21 = i14;
            i22 = i8;
            if (i29 != 1) {
            } else {
            }
            if (c2.w() == c.b.NUMBER) {
            } else {
            }
            i12 = i24;
            c2.c();
            bEGIN_OBJECT = (float)d2;
            i5 = (float)d3;
            c2.f();
            i24 = i12;
            bEGIN_OBJECT = i5;
            c2.H();
            i22 = i8;
            i23 = i20;
            if (c2.w() == c.b.BEGIN_OBJECT) {
            } else {
            }
            i10 = p.e(c2, f3);
            i24 = i;
            i20 = i23;
            c2.e();
            i7 = 0;
            bEGIN_OBJECT = 0;
            i9 = 0;
            i19 = 0;
            while (c2.j()) {
                i24 = cVar.E(q.d);
                if (i24 != 0) {
                } else {
                }
                if (c2.w() == c.b.NUMBER) {
                } else {
                }
                c2.c();
                i7 = (float)d6;
                i9 = (float)i24;
                c2.f();
                i7 = i9;
                if (i24 != 1) {
                } else {
                }
                if (c2.w() == c.b.NUMBER) {
                } else {
                }
                c2.c();
                bEGIN_OBJECT = (float)d5;
                i19 = (float)i24;
                c2.f();
                bEGIN_OBJECT = i19;
                c2.H();
            }
            pointF = new PointF(i7, bEGIN_OBJECT);
            pointF2 = new PointF(i9, i19);
            c2.i();
            i3 = pointF2;
            i18 = pointF;
            i20 = i23;
            i24 = cVar.E(q.d);
            if (i24 != 0) {
            } else {
            }
            if (c2.w() == c.b.NUMBER) {
            } else {
            }
            c2.c();
            i7 = (float)d6;
            i9 = (float)i24;
            c2.f();
            i7 = i9;
            if (i24 != 1) {
            } else {
            }
            if (c2.w() == c.b.NUMBER) {
            } else {
            }
            c2.c();
            bEGIN_OBJECT = (float)d5;
            i19 = (float)i24;
            c2.f();
            bEGIN_OBJECT = i19;
            c2.H();
            i22 = i8;
            i = i24;
            i23 = i20;
            i6 = obj.a(cVar, aVar3);
            i22 = i8;
            i = i24;
            i23 = i20;
            i16 = obj.a(cVar, aVar3);
            i22 = i8;
            i23 = i20;
            i24 = (float)i;
        }
        int i27 = i24;
        int i30 = i20;
        c2.i();
        if (i11 != 0) {
            interpolator3 = q.a;
            i4 = i16;
            interpolator2 = 0;
            interpolator = 0;
        } else {
        }
        if (interpolator2 != null && interpolator != null) {
            if (interpolator != null) {
                i13 = i30;
                super(d, i16, i4, interpolator2, interpolator, i27, 0);
            } else {
                i13 = i30;
                super(d, i16, i4, interpolator3, i27, 0);
                aVar = aVar3;
            }
        } else {
        }
        aVar.o = i13;
        aVar.p = i8;
        return aVar;
    }

    private static <T> a<T> f(c c, float f2, com.airbnb.lottie.x.j0<T> j03) {
        a obj1 = new a(j03.a(c, f2));
        return obj1;
    }

    private static h<WeakReference<Interpolator>> g() {
        h hVar;
        if (q.b == null) {
            hVar = new h();
            q.b = hVar;
        }
        return q.b;
    }

    private static void h(int i, WeakReference<Interpolator> weakReference2) {
        final Class<com.airbnb.lottie.x.q> obj = q.class;
        q.b.j(i, weakReference2);
        return;
        synchronized (obj) {
            obj = q.class;
            q.b.j(i, weakReference2);
        }
    }
}
