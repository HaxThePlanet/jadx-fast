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
import com.airbnb.lottie.c;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.a;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.j.c;
import com.airbnb.lottie.v.j.d;
import com.airbnb.lottie.v.j.f;
import com.airbnb.lottie.v.k.c;
import com.airbnb.lottie.v.k.d;
import com.airbnb.lottie.v.k.f;
import com.airbnb.lottie.v.l.a;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.c;
import d.e.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class h implements com.airbnb.lottie.t.b.e, a.b, com.airbnb.lottie.t.b.k {

    private final String a;
    private final boolean b;
    private final a c;
    private final d<LinearGradient> d;
    private final d<RadialGradient> e;
    private final Path f;
    private final Paint g;
    private final RectF h;
    private final List<com.airbnb.lottie.t.b.m> i;
    private final f j;
    private final a<c, c> k;
    private final a<Integer, Integer> l;
    private final a<PointF, PointF> m;
    private final a<PointF, PointF> n;
    private a<ColorFilter, ColorFilter> o;
    private p p;
    private final f q;
    private final int r;
    public h(f f, a a2, d d3) {
        super();
        d dVar = new d();
        this.d = dVar;
        d dVar2 = new d();
        this.e = dVar2;
        Path path = new Path();
        this.f = path;
        a aVar = new a(1);
        this.g = aVar;
        RectF rectF = new RectF();
        this.h = rectF;
        ArrayList arrayList = new ArrayList();
        this.i = arrayList;
        this.c = a2;
        this.a = d3.f();
        this.b = d3.i();
        this.q = f;
        this.j = d3.e();
        path.setFillType(d3.c());
        this.r = (int)obj4;
        a obj4 = d3.d().j();
        this.k = obj4;
        obj4.a(this);
        a2.i(obj4);
        obj4 = d3.g().j();
        this.l = obj4;
        obj4.a(this);
        a2.i(obj4);
        obj4 = d3.h().j();
        this.m = obj4;
        obj4.a(this);
        a2.i(obj4);
        obj4 = d3.b().j();
        this.n = obj4;
        obj4.a(this);
        a2.i(obj4);
    }

    private int[] e(int[] iArr) {
        Object pVar;
        int length;
        int intValue;
        int length2;
        int i;
        int[] obj5;
        pVar = this.p;
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

    private int h() {
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

    private LinearGradient i() {
        final long l = (long)i;
        Object obj = this.d.f(l);
        if ((LinearGradient)obj != null) {
            return (LinearGradient)obj;
        }
        Object obj2 = this.m.h();
        Object obj3 = this.n.h();
        Object obj4 = this.k.h();
        super(obj2.x, obj2.y, obj3.x, obj3.y, e((c)obj4.a()), obj4.b(), Shader.TileMode.CLAMP);
        this.d.k(l, obj3);
        return linearGradient;
    }

    private RadialGradient j() {
        float i;
        final long l = (long)i2;
        Object obj = this.e.f(l);
        if ((RadialGradient)obj != null) {
            return (RadialGradient)obj;
        }
        Object obj2 = this.m.h();
        Object obj3 = this.n.h();
        Object obj4 = this.k.h();
        final int[] iArr = (c)obj4.a();
        final float f3 = obj2.x;
        final float f4 = obj2.y;
        f2 -= f4;
        if (Float.compare(i, i5) <= 0) {
            i = 981668463;
        }
        super(f3, f4, i, e(iArr), obj4.b(), Shader.TileMode.CLAMP);
        this.e.k(l, obj3);
        return radialGradient;
    }

    @Override // com.airbnb.lottie.t.b.e
    public void a() {
        this.q.invalidateSelf();
    }

    public void b(List<com.airbnb.lottie.t.b.c> list, List<com.airbnb.lottie.t.b.c> list2) {
        Object obj;
        boolean z;
        int obj3;
        obj3 = 0;
        while (obj3 < list2.size()) {
            obj = list2.get(obj3);
            if (obj instanceof m) {
            }
            obj3++;
            this.i.add((m)(c)obj);
        }
    }

    public void c(e e, int i2, List<e> list3, e e4) {
        g.m(e, i2, list3, e4, this);
    }

    @Override // com.airbnb.lottie.t.b.e
    public void d(RectF rectF, Matrix matrix2, boolean z3) {
        int i;
        Path path;
        Path path2;
        this.f.reset();
        int obj6 = 0;
        i = obj6;
        while (i < this.i.size()) {
            this.f.addPath((m)this.i.get(i).getPath(), matrix2);
            i++;
        }
        this.f.computeBounds(rectF, obj6);
        obj6 = 1065353216;
        rectF.set(obj5 -= obj6, top -= obj6, right += obj6, bottom += obj6);
    }

    @Override // com.airbnb.lottie.t.b.e
    public void f(Canvas canvas, Matrix matrix2, int i3) {
        int i;
        Object radialGradient;
        Path path2;
        Path path;
        Object obj7;
        if (this.b) {
        }
        String str = "GradientFillContent#draw";
        c.a(str);
        this.f.reset();
        int i2 = 0;
        i = i2;
        while (i < this.i.size()) {
            this.f.addPath((m)this.i.get(i).getPath(), matrix2);
            i++;
        }
        this.f.computeBounds(this.h, i2);
        if (this.j == f.LINEAR) {
            radialGradient = i();
        } else {
            radialGradient = j();
        }
        radialGradient.setLocalMatrix(matrix2);
        this.g.setShader(radialGradient);
        obj7 = this.o;
        if (obj7 != null) {
            this.g.setColorFilter((ColorFilter)obj7.h());
        }
        int obj8 = 1132396544;
        this.g.setAlpha(g.d((int)obj7, i2, 255));
        canvas.drawPath(this.f, this.g);
        c.b(str);
    }

    public <T> void g(T t, c<T> c2) {
        Object num;
        int i;
        Object obj3;
        Object obj4;
        if (t == k.d) {
            this.l.n(c2);
        } else {
            i = 0;
            if (t == k.E) {
                obj3 = this.o;
                if (obj3 != null) {
                    this.c.C(obj3);
                }
                if (c2 == null) {
                    this.o = i;
                } else {
                    obj3 = new p(c2);
                    this.o = obj3;
                    obj3.a(this);
                    this.c.i(this.o);
                }
            } else {
                obj3 = this.p;
                if (t == k.F && obj3 != null) {
                    obj3 = this.p;
                    if (obj3 != null) {
                        this.c.C(obj3);
                    }
                    if (c2 == null) {
                        this.p = i;
                    } else {
                        this.d.b();
                        this.e.b();
                        obj3 = new p(c2);
                        this.p = obj3;
                        obj3.a(this);
                        this.c.i(this.p);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.t.b.e
    public String getName() {
        return this.a;
    }
}
