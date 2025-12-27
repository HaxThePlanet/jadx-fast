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
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.v.k.e;
import com.airbnb.lottie.v.k.p.b;
import com.airbnb.lottie.v.k.p.c;

/* compiled from: GradientStrokeContent.java */
/* loaded from: classes.dex */
public class i extends a {

    private final String o;
    private final boolean p;
    private final d.e.d<LinearGradient> q = new d<>();
    private final d.e.d<RadialGradient> r = new d<>();
    private final RectF s = new RectF();
    private final com.airbnb.lottie.v.k.f t;
    private final int u;
    private final com.airbnb.lottie.t.c.a<com.airbnb.lottie.v.k.c, com.airbnb.lottie.v.k.c> v;
    private final com.airbnb.lottie.t.c.a<PointF, PointF> w;
    private final com.airbnb.lottie.t.c.a<PointF, PointF> x;
    private p y;
    public i(com.airbnb.lottie.f fVar, com.airbnb.lottie.v.l.a aVar, e eVar) {
        super(fVar, aVar, eVar.b().toPaintCap(), eVar.g().toPaintJoin(), eVar.i(), eVar.k(), eVar.m(), eVar.h(), eVar.c());
        d.e.d dVar = new d();
        d.e.d dVar2 = new d();
        RectF rectF = new RectF();
        this.o = eVar.j();
        this.t = eVar.f();
        this.p = eVar.n();
        this.u = (int)(fVar.o().d() / 32f);
        com.airbnb.lottie.t.c.a aVar2 = eVar.e().j();
        this.v = aVar2;
        aVar2.a(this);
        aVar.i(aVar2);
        com.airbnb.lottie.t.c.a aVar3 = eVar.l().j();
        this.w = aVar3;
        aVar3.a(this);
        aVar.i(aVar3);
        com.airbnb.lottie.t.c.a aVar4 = eVar.d().j();
        this.x = aVar4;
        aVar4.a(this);
        aVar.i(aVar4);
    }

    private int[] i(int[] iArr) {
        int i = 0;
        int[] iArr2;
        if (this.y != null) {
            Object obj = this.y.h();
            length2 = iArr.length;
            length3 = obj.length;
            i = 0;
            if (iArr.length == obj.length) {
                length = iArr.length;
                while (i < iArr.length) {
                    iArr[i] = obj[i].intValue();
                    i = i + 1;
                    length = iArr.length;
                }
            } else {
                length = obj.length;
                while (i < obj.length) {
                    new int[obj.length][i] = obj[i].intValue();
                    i = i + 1;
                    length = obj.length;
                }
            }
        }
        return iArr2;
    }

    private int j() {
        int i = 17;
        int rounded = Math.round(this.w.f() * (float)this.u);
        int rounded2 = Math.round(this.x.f() * (float)this.u);
        int rounded3 = Math.round(this.v.f() * (float)this.u);
        i = rounded != 0 ? 527 * rounded : 17;
        if (rounded2 != 0) {
            i = (i * 31) * rounded2;
        }
        if (rounded3 != 0) {
            i = (i * 31) * rounded3;
        }
        return i;
    }

    private LinearGradient k() {
        final long l = (long)j();
        Object obj = this.q.f(l);
        if (obj != null) {
            return obj;
        }
        Object obj2 = this.w.h();
        Object obj3 = this.x.h();
        Object obj5 = this.v.h();
        LinearGradient linearGradient = new LinearGradient(obj2.x, obj2.y, obj3.x, obj3.y, i(obj5.a()), obj5.b(), Shader.TileMode.CLAMP);
        this.q.k(l, linearGradient);
        return linearGradient;
    }

    private RadialGradient l() {
        final long l = (long)j();
        Object obj = this.r.f(l);
        if (obj != null) {
            return obj;
        }
        Object obj2 = this.w.h();
        Object obj3 = this.x.h();
        Object obj5 = this.v.h();
        final int[] iArr = obj5.a();
        float f4 = obj3.y - f6;
        RadialGradient radialGradient = new RadialGradient(f5, f6, (float)(Math.hypot((double)(obj3.x - f5), (double)f4)), i(iArr), obj5.b(), Shader.TileMode.CLAMP);
        this.r.k(l, radialGradient);
        return radialGradient;
    }

    @Override // com.airbnb.lottie.t.b.a
    public void f(Canvas canvas, Matrix matrix, int i) {
        Object obj;
        if (this.p) {
            return;
        }
        d(this.s, matrix, false);
        if (this.t == f.LINEAR) {
            LinearGradient linearGradient = k();
        } else {
            RadialGradient radialGradient = l();
        }
        obj.setLocalMatrix(matrix);
        this.i.setShader(obj);
        super.f(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.t.b.a
    public <T> void g(T t, com.airbnb.lottie.z.c<T> cVar) {
        Integer[] objArr;
        super.g(t, cVar);
        if (this.y == k.F && this.y != null) {
            this.f.C(this.y);
            if (cVar == null) {
                this.y = null;
            } else {
                p pVar3 = new p(cVar);
                this.y = pVar3;
                pVar3.a(this);
                this.f.i(this.y);
            }
        }
    }

    @Override // com.airbnb.lottie.t.b.a
    public String getName() {
        return this.o;
    }
}
