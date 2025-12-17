package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.v.j.c;
import com.airbnb.lottie.v.j.f;
import com.airbnb.lottie.v.k.c;
import com.airbnb.lottie.v.k.e;
import com.airbnb.lottie.v.k.f;
import com.airbnb.lottie.v.k.p.b;
import com.airbnb.lottie.v.k.p.c;
import com.airbnb.lottie.v.l.a;
import com.airbnb.lottie.z.c;
import d.e.d;

/* loaded from: classes.dex */
public class i extends com.airbnb.lottie.t.b.a {

    private final String o;
    private final boolean p;
    private final d<LinearGradient> q;
    private final d<RadialGradient> r;
    private final RectF s;
    private final f t;
    private final int u;
    private final a<c, c> v;
    private final a<PointF, PointF> w;
    private final a<PointF, PointF> x;
    private p y;
    public i(f f, a a2, e e3) {
        super(f, a2, e3.b().toPaintCap(), e3.g().toPaintJoin(), e3.i(), e3.k(), e3.m(), e3.h(), e3.c());
        d dVar = new d();
        this.q = dVar;
        d dVar2 = new d();
        this.r = dVar2;
        RectF rectF = new RectF();
        this.s = rectF;
        this.o = e3.j();
        this.t = e3.f();
        this.p = e3.n();
        this.u = (int)obj12;
        a obj12 = e3.e().j();
        this.v = obj12;
        obj12.a(this);
        a2.i(obj12);
        obj12 = e3.l().j();
        this.w = obj12;
        obj12.a(this);
        a2.i(obj12);
        obj12 = e3.d().j();
        this.x = obj12;
        obj12.a(this);
        a2.i(obj12);
    }

    private int[] i(int[] iArr) {
        Object pVar;
        int length2;
        int intValue;
        int length;
        int i;
        int[] obj5;
        pVar = this.y;
        if (pVar != null) {
            pVar = pVar.h();
            i = 0;
            if (iArr.length == pVar.length) {
            } else {
                for (Object obj2 : obj0) {
                    new int[pVar.length][i] = obj2.intValue();
                }
            }
        }
        return obj5;
    }

    private int j() {
        int i;
        int round = Math.round(f *= f2);
        int round2 = Math.round(f3 *= f4);
        int round3 = Math.round(f5 *= f6);
        i = round != 0 ? i10 * round : 17;
        if (round2 != 0) {
            i9 *= round2;
        }
        if (round3 != 0) {
            i8 *= round3;
        }
        return i;
    }

    private LinearGradient k() {
        final long l = (long)i;
        Object obj = this.q.f(l);
        if ((LinearGradient)obj != null) {
            return (LinearGradient)obj;
        }
        Object obj2 = this.w.h();
        Object obj3 = this.x.h();
        Object obj4 = this.v.h();
        super(obj2.x, obj2.y, obj3.x, obj3.y, i((c)obj4.a()), obj4.b(), Shader.TileMode.CLAMP);
        this.q.k(l, obj3);
        return linearGradient;
    }

    private RadialGradient l() {
        final long l = (long)i;
        Object obj = this.r.f(l);
        if ((RadialGradient)obj != null) {
            return (RadialGradient)obj;
        }
        Object obj2 = this.w.h();
        Object obj3 = this.x.h();
        Object obj4 = this.v.h();
        final int[] iArr = (c)obj4.a();
        final float f3 = obj2.x;
        final float f4 = obj2.y;
        f2 -= f4;
        super(f3, f4, (float)hypot, i(iArr), obj4.b(), Shader.TileMode.CLAMP);
        this.r.k(l, obj3);
        return radialGradient;
    }

    @Override // com.airbnb.lottie.t.b.a
    public void f(Canvas canvas, Matrix matrix2, int i3) {
        Object linearGradient;
        if (this.p) {
        }
        d(this.s, matrix2, false);
        if (this.t == f.LINEAR) {
            linearGradient = k();
        } else {
            linearGradient = l();
        }
        linearGradient.setLocalMatrix(matrix2);
        this.i.setShader(linearGradient);
        super.f(canvas, matrix2, i3);
    }

    public <T> void g(T t, c<T> c2) {
        Integer[] objArr;
        Object obj2;
        Object obj3;
        super.g(t, c2);
        obj2 = this.y;
        if (t == k.F && obj2 != null) {
            obj2 = this.y;
            if (obj2 != null) {
                this.f.C(obj2);
            }
            if (c2 == null) {
                this.y = 0;
            } else {
                obj2 = new p(c2);
                this.y = obj2;
                obj2.a(this);
                this.f.i(this.y);
            }
        }
    }

    @Override // com.airbnb.lottie.t.b.a
    public String getName() {
        return this.o;
    }
}
