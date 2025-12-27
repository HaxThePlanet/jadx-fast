package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.y.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientFillContent.java */
/* loaded from: classes.dex */
public class h implements e, a.b, k {

    private final String a;
    private final boolean b;
    private final com.airbnb.lottie.v.l.a c;
    private final d.e.d<LinearGradient> d = new d<>();
    private final d.e.d<RadialGradient> e = new d<>();
    private final Path f = new Path();
    private final Paint g = new a(1);
    private final RectF h = new RectF();
    private final List<m> i = new ArrayList<>();
    private final com.airbnb.lottie.v.k.f j;
    private final com.airbnb.lottie.t.c.a<com.airbnb.lottie.v.k.c, com.airbnb.lottie.v.k.c> k;
    private final com.airbnb.lottie.t.c.a<Integer, Integer> l;
    private final com.airbnb.lottie.t.c.a<PointF, PointF> m;
    private final com.airbnb.lottie.t.c.a<PointF, PointF> n;
    private com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> o;
    private p p;
    private final com.airbnb.lottie.f q;
    private final int r;
    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.v.l.a aVar, com.airbnb.lottie.v.k.d dVar) {
        super();
        dVar = new d();
        d.e.d dVar2 = new d();
        aVar = new a(1);
        RectF rectF = new RectF();
        ArrayList arrayList = new ArrayList();
        this.c = aVar;
        this.a = dVar.f();
        this.b = dVar.i();
        this.q = fVar;
        this.j = dVar.e();
        new Path().setFillType(dVar.c());
        this.r = (int)(fVar.o().d() / 32f);
        com.airbnb.lottie.t.c.a aVar3 = dVar.d().j();
        this.k = aVar3;
        aVar3.a(this);
        aVar.i(aVar3);
        com.airbnb.lottie.t.c.a aVar4 = dVar.g().j();
        this.l = aVar4;
        aVar4.a(this);
        aVar.i(aVar4);
        com.airbnb.lottie.t.c.a aVar5 = dVar.h().j();
        this.m = aVar5;
        aVar5.a(this);
        aVar.i(aVar5);
        com.airbnb.lottie.t.c.a aVar6 = dVar.b().j();
        this.n = aVar6;
        aVar6.a(this);
        aVar.i(aVar6);
    }

    private int[] e(int[] iArr) {
        int i = 0;
        int[] iArr2;
        if (this.p != null) {
            Object obj = this.p.h();
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

    private int h() {
        int i = 17;
        int rounded = Math.round(this.m.f() * (float)this.r);
        int rounded2 = Math.round(this.n.f() * (float)this.r);
        int rounded3 = Math.round(this.k.f() * (float)this.r);
        i = rounded != 0 ? 527 * rounded : 17;
        if (rounded2 != 0) {
            i = (i * 31) * rounded2;
        }
        if (rounded3 != 0) {
            i = (i * 31) * rounded3;
        }
        return i;
    }

    private LinearGradient i() {
        final long l = (long)h();
        Object obj = this.d.f(l);
        if (obj != null) {
            return obj;
        }
        Object obj2 = this.m.h();
        Object obj3 = this.n.h();
        Object obj5 = this.k.h();
        LinearGradient linearGradient = new LinearGradient(obj2.x, obj2.y, obj3.x, obj3.y, e(obj5.a()), obj5.b(), Shader.TileMode.CLAMP);
        this.d.k(l, linearGradient);
        return linearGradient;
    }

    private RadialGradient j() {
        float f = 981668463;
        final long l = (long)h();
        Object obj = this.e.f(l);
        if (obj != null) {
            return obj;
        }
        Object obj2 = this.m.h();
        Object obj3 = this.n.h();
        Object obj5 = this.k.h();
        final int[] iArr = obj5.a();
        float f5 = obj3.y - f7;
        f = (float)(Math.hypot((double)(obj3.x - f6), (double)f5));
        if (obj3.x - f6 <= 0) {
            int i2 = 981668463;
        }
        RadialGradient radialGradient = new RadialGradient(f6, f7, f, e(iArr), obj5.b(), Shader.TileMode.CLAMP);
        this.e.k(l, radialGradient);
        return radialGradient;
    }

    public void a() {
        this.q.invalidateSelf();
    }

    public void b(List<c> list, List<c> list2) {
        boolean z;
        int i = 0;
        i = 0;
        while (i < list2.size()) {
            Object item = list2.get(i);
            z = item instanceof m;
            i = i + 1;
        }
    }

    public void c(e eVar, int i, List<e> list, e eVar2) {
        g.m(eVar, i, list, eVar2, this);
    }

    public void d(RectF rectF, Matrix matrix, boolean z) {
        int z32;
        this.f.reset();
        z = false;
        z32 = z;
        while (z32 < this.i.size()) {
            this.f.addPath((m)this.i.get(z32).getPath(), matrix);
            z32 = z32 + 1;
        }
        this.f.computeBounds(rectF, z);
        float f5 = 1f;
        rectF.set(rectF.left - f5, rectF.top - f5, rectF.right + f5, rectF.bottom + f5);
    }

    public void f(Canvas canvas, Matrix matrix, int i) {
        Object obj;
        if (this.b) {
            return;
        }
        String str = "GradientFillContent#draw";
        c.a(str);
        this.f.reset();
        boolean z2 = false;
        i = z2;
        while (i < this.i.size()) {
            this.f.addPath((m)this.i.get(i).getPath(), matrix);
            i = i + 1;
        }
        this.f.computeBounds(this.h, z2);
        if (this.j == f.LINEAR) {
            LinearGradient linearGradient = i();
        } else {
            RadialGradient radialGradient = j();
        }
        obj.setLocalMatrix(matrix);
        this.g.setShader(obj);
        if (this.o != null) {
            this.g.setColorFilter((ColorFilter)this.o.h());
        }
        float f7 = 255f;
        this.g.setAlpha(g.d((int)(float)i / f7 * (float)(Integer)this.l.h().intValue() / 100f * f7, z2, 255));
        canvas.drawPath(this.f, this.g);
        c.b(str);
    }

    public <T> void g(T t, com.airbnb.lottie.z.c<T> cVar) {
        ColorFilter colorFilter;
        Integer[] objArr;
        if (t == k.d) {
            this.l.n(cVar);
        } else {
            com.airbnb.lottie.t.c.a aVar = null;
            if (this.l == k.E) {
                if (this.o != null) {
                    this.c.C(this.o);
                }
                if (cVar == null) {
                    this.o = aVar;
                } else {
                    p pVar = new p(cVar);
                    this.o = pVar;
                    pVar.a(this);
                    this.c.i(this.o);
                }
            } else {
                if (this.l == k.F && this.p != null) {
                    this.c.C(this.p);
                    if (this.o == null) {
                        this.p = aVar;
                    } else {
                        this.d.b();
                        this.e.b();
                        p pVar3 = new p(cVar);
                        this.p = pVar3;
                        pVar3.a(this);
                        this.c.i(this.p);
                    }
                }
            }
        }
    }

    public String getName() {
        return this.a;
    }
}
