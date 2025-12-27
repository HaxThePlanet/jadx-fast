package com.airbnb.lottie.x;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.d;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.x.k0.c.b;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.a;
import d.h.l.f0.b;
import java.lang.ref.WeakReference;

/* compiled from: KeyframeParser.java */
/* loaded from: classes.dex */
class q {

    private static final Interpolator a = new LinearInterpolator();
    private static d.e.h<WeakReference<Interpolator>> b;
    static c.a c;
    static c.a d;
    static {
        q.c = c.a.a("t", "s", "e", "o", "i", "h", "to", "ti");
        q.d = c.a.a("x", "y");
    }

    q() {
        super();
    }

    private static WeakReference<Interpolator> a(int i) {
        final Class<com.airbnb.lottie.x.q> obj2 = q.class;
        synchronized (obj2) {
            try {
                return (WeakReference)q.g().e(i);
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    private static Interpolator b(PointF pointF, PointF pointF2) {
        float f;
        float f2 = 1065353216;
        int i = 0;
        Interpolator pointF3;
        Object obj2;
        float f14 = -1f;
        f2 = 1f;
        pointF.x = g.c(pointF.x, f14, f2);
        float f16 = -100f;
        float f18 = 100f;
        pointF.y = g.c(pointF.y, f16, f18);
        pointF2.x = g.c(pointF2.x, f14, f2);
        float f13 = g.c(pointF2.y, f16, f18);
        pointF2.y = f13;
        int i2 = h.i(pointF.x, pointF.y, pointF2.x, f13);
        WeakReference weakReference2 = q.a(i2);
        Object obj = weakReference2 != null ? (Interpolator)obj : 0;
        if (weakReference2 == null || pointF.y == 0) {
            try {
                pointF3 = b.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                return pointF3;
            }
            try {
                q.h(i2, new WeakReference(pointF3));
            } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                return pointF3;
            }
        }
    }

    static <T> a<T> c(c cVar, d dVar, float f, j0<T> j0Var, boolean z, boolean z2) {
        if (z && z2) {
            return q.e(dVar, cVar, f, j0Var);
        }
        if (z) {
            return q.d(dVar, cVar, f, j0Var);
        }
        return q.f(cVar, f, j0Var);
    }

    private static <T> a<T> d(d dVar, c cVar, float f, j0<T> j0Var) {
        PointF pointF = null;
        PointF pointF2;
        int i2;
        Object obj;
        int i;
        Interpolator cVar23;
        int i3;
        cVar.e();
        i = 0;
        i3 = 0;
        while (cVar.j()) {
            f = 1f;
            cVar.H();
            PointF pointF4 = p.e(cVar, f);
            PointF pointF3 = p.e(cVar, f);
            i = 1;
            int r5 = i;
            pointF2 = p.e(cVar, f);
            pointF = p.e(cVar, f);
            Object obj2 = j0Var.a(cVar, f);
            obj = j0Var.a(cVar, f);
            i3 = (float)cVar.m();
        }
        cVar.i();
        if (i != 0) {
        } else {
            if (pointF == null || pointF2 == null) {
                cVar23 = q.a;
            } else {
                cVar23 = q.b(pointF, pointF2);
            }
        }
        a cVar22 = new a(dVar, obj, obj, cVar23, i3, null);
        cVar22.o = i2;
        cVar22.p = i2;
        return cVar22;
    }

    private static <T> a<T> e(d dVar, c cVar, float f, j0<T> j0Var) {
        Interpolator interpolator;
        int i2 = 0;
        a aVar;
        boolean z2;
        Interpolator interpolator3;
        int i3 = 0;
        int i4;
        int i6 = 0;
        int i5;
        int i7 = 0;
        PointF pointF;
        int i9;
        int i10 = 0;
        c.b bEGIN_OBJECT2;
        int i8 = 0;
        PointF pointF2 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        Object obj = null;
        Interpolator interpolator2 = null;
        int i11 = 0;
        c cVar22 = cVar;
        float f32 = f;
        final Object j0Var42 = j0Var;
        cVar.e();
        i3 = 0;
        i8 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i19 = 0;
        i4 = 0;
        i9 = 0;
        i11 = 0;
        while (cVar.j()) {
            i8 = 1;
            cVar.H();
            PointF pointF5 = p.e(cVar, f);
            PointF pointF6 = p.e(cVar, f);
            int r6 = cVar.n() == i8 ? i8 : 0;
            Object obj2 = j0Var42.a(cVar22, f32);
            obj = j0Var42.a(cVar22, f32);
            float f7 = (float)cVar.m();
        }
        cVar.i();
        if (i8 != 0) {
            interpolator = q.a;
            int i18 = 0;
            int i20 = 0;
        }
        if (interpolator2 == null || interpolator3 == null) {
            Float f2 = null;
            aVar = new a(dVar, obj, obj, i2, i4, f2);
        } else {
            aVar = new a(dVar, obj, obj, interpolator2, interpolator3, i4, null);
        }
        aVar.o = i9;
        aVar.p = i3;
        return aVar;
    }

    private static <T> a<T> f(c cVar, float f, j0<T> j0Var) {
        return new a(j0Var.a(cVar, f));
    }

    private static d.e.h<WeakReference<Interpolator>> g() {
        if (q.b == null) {
            q.b = new h();
        }
        return q.b;
    }

    private static void h(int i, WeakReference<Interpolator> weakReference) {
        final Class<com.airbnb.lottie.x.q> obj2 = q.class;
        synchronized (obj2) {
            try {
                q.b.j(i, weakReference);
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }
}
