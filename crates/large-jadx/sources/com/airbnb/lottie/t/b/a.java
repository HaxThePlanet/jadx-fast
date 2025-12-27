package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.d;
import com.airbnb.lottie.v.k.q.a;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.y.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseStrokeContent.java */
/* loaded from: classes.dex */
public abstract class a implements a.b, k, e {

    private final PathMeasure a = new PathMeasure();
    private final Path b = new Path();
    private final Path c = new Path();
    private final RectF d = new RectF();
    private final f e;
    protected final com.airbnb.lottie.v.l.a f;
    private final List<a.b> g = new ArrayList<>();
    private final float[] h;
    final Paint i = new a(1);
    private final com.airbnb.lottie.t.c.a<?, Float> j;
    private final com.airbnb.lottie.t.c.a<?, Integer> k;
    private final List<com.airbnb.lottie.t.c.a<?, Float>> l = new ArrayList<>();
    private final com.airbnb.lottie.t.c.a<?, Float> m = null;
    private com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> n;

    static class a {
    }

    private static final class b {

        private final List<m> a;
        private final s b;
        /* synthetic */ b(s sVar, a.a aVar) {
            this(sVar);
        }

        static /* synthetic */ List a(a.b bVar) {
            return bVar.a;
        }

        static /* synthetic */ s b(a.b bVar) {
            return bVar.b;
        }

        private b(s sVar) {
            super();
            this.a = new ArrayList();
            this.b = sVar;
        }
    }
    a(f fVar, com.airbnb.lottie.v.l.a aVar, Paint.Cap cap, Paint.Join join, float f, d dVar, b bVar, List<b> list, b bVar2) {
        int fVar2 = 0;
        super();
        PathMeasure pathMeasure = new PathMeasure();
        Path path = new Path();
        Path path2 = new Path();
        RectF rectF = new RectF();
        ArrayList arrayList = new ArrayList();
        com.airbnb.lottie.t.a aVar3 = new a(1);
        this.e = fVar;
        this.f = aVar;
        aVar3.setStyle(Paint.Style.STROKE);
        aVar3.setStrokeCap(cap);
        aVar3.setStrokeJoin(join);
        aVar3.setStrokeMiter(f);
        this.k = dVar.j();
        this.j = bVar.j();
        if (bVar2 == null) {
            int i = 0;
        } else {
            this.m = bVar2.j();
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        this.h = new float[list.size()];
        fVar2 = 0;
        while (fVar2 < list.size()) {
            this.l.add((b)list.get(fVar2).j());
            fVar2 = fVar2 + 1;
        }
        aVar.i(this.k);
        aVar.i(this.j);
        while (this.j < this.l.size()) {
            aVar.i((a)this.l.get(fVar2));
            fVar2 = fVar2 + 1;
        }
        if (this.m != null) {
            aVar.i(this.m);
        }
        this.k.a(this);
        this.j.a(this);
        while (Paint.Style.STROKE < list.size()) {
            (a)this.l.get(fVar2).a(this);
            fVar2 = fVar2 + 1;
        }
        if (this.m != null) {
            this.m.a(this);
        }
    }

    private void e(Matrix matrix) {
        int i = 0;
        float f2 = 1036831949;
        int i2 = 0;
        final String str = "StrokeContent#applyDashPattern";
        c.a(str);
        if (this.l.isEmpty()) {
            c.b(str);
            return;
        }
        float f6 = h.g(matrix);
        i = 0;
        while (this.l < this.l.size()) {
            this.h[i] = (Float)(a)this.l.get(i).h().floatValue();
            f = fArr[i] * f6;
            this.h[i] = f;
            i = i + 1;
        }
        if (this.m == null) {
            i2 = 0;
        } else {
            f6 *= value;
        }
        this.i.setPathEffect(new DashPathEffect(this.h, i2));
        c.b(str);
    }

    private void h(Canvas canvas, a.b bVar, Matrix matrix) {
        int i;
        float length;
        int i2;
        int i3;
        Path path4;
        Paint paint;
        float f3 = 1065353216;
        int cmp2;
        float f;
        final String str = "StrokeContent#applyTrimPath";
        c.a(str);
        if (bVar.b == null) {
            c.b(str);
            return;
        }
        this.b.reset();
        i = bVar.a.size() - 1;
        while (bVar.a >= 0) {
            this.b.addPath((m)bVar.a.get(i).getPath(), matrix);
            i = i - 1;
        }
        boolean z = false;
        this.a.setPath(this.b, z);
        length = this.a.getLength();
        while (this.a.nextContour()) {
            length = length + this.a.getLength();
        }
        float f5 = (Float)bVar.b.g().h().floatValue() * length / 360f;
        float f9 = 100f;
        float f8 = (Float)bVar.b.h().h().floatValue() * length / f9 + f5;
        float f12 = (Float)bVar.b.e().h().floatValue() * length / f9 + f5;
        i2 = bVar.a.size() - 1;
        f = 0.0f;
        i3 = f;
        while (this.b >= 0) {
            this.c.set((m)bVar.a.get(i2).getPath());
            this.c.transform(matrix);
            this.a.setPath(this.c, z);
            float length2 = this.a.getLength();
            i3 = i3 + length2;
            i2 = i2 - 1;
        }
        c.b(str);
    }

    public void a() {
        this.e.invalidateSelf();
    }

    public void b(List<c> list, List<c> list2) {
        int i;
        Object obj;
        com.airbnb.lottie.t.b.a.b bVar;
        com.airbnb.lottie.t.b.s sVar;
        Object item;
        boolean z;
        com.airbnb.lottie.t.b.s sVar2;
        q.a iNDIVIDUALLY2;
        q.a iNDIVIDUALLY22;
        int i2;
        i = list.size() - 1;
        final com.airbnb.lottie.t.b.a.a aVar = null;
        int i4 = aVar;
        while (i >= 0) {
            item = list.get(i);
            z = item instanceof s;
            i = i - 1;
        }
        if (sVar != null) {
            sVar.c(this);
        }
        i2 = list2.size() - 1;
        int i3 = aVar;
        while (i2 >= 0) {
            item = list2.get(i2);
            z2 = item instanceof s;
            i2 = i2 - 1;
        }
        if (obj != null) {
            this.g.add(obj);
        }
    }

    public void c(com.airbnb.lottie.v.e eVar, int i, List<com.airbnb.lottie.v.e> list, com.airbnb.lottie.v.e eVar2) {
        g.m(eVar, i, list, eVar2, this);
    }

    public void d(RectF rectF, Matrix matrix, boolean z) {
        int i;
        int i2;
        int size;
        Path path;
        final String str = "StrokeContent#getBounds";
        c.a(str);
        this.b.reset();
        z = false;
        i = z;
        while (i < this.g.size()) {
            Object item = this.g.get(i);
            i2 = z;
            while (i2 < item.a.size()) {
                this.b.addPath((m)item.a.get(i2).getPath(), matrix);
                i2 = i2 + 1;
            }
            i = i + 1;
            this.b.addPath((m)item.a.get(i2).getPath(), matrix);
            i2 = i2 + 1;
        }
        this.b.computeBounds(this.d, z);
        float f10 = (c)this.j.p() / 2f;
        this.d.set(rectF2.left - f10, rectF2.top - f10, rectF2.right + f10, rectF2.bottom + f10);
        rectF.set(this.d);
        float f = 1f;
        rectF.set(rectF.left - f, rectF.top - f, rectF.right + f, rectF.bottom + f);
        c.b(str);
    }

    public void f(Canvas canvas, Matrix matrix, int i) {
        float f;
        float f2;
        int i2 = 0;
        Path path;
        Path path2;
        com.airbnb.lottie.t.c.a aVar;
        final String str = "StrokeContent#draw";
        c.a(str);
        if (h.h(matrix)) {
            c.b(str);
            return;
        }
        float f3 = 255f;
        i2 = 0;
        this.i.setAlpha(g.d((int)(float)i / f3 * (float)(e)this.k.p() / 100f * f3, i2, 255));
        this.i.setStrokeWidth((c)this.j.p() * h.g(matrix));
        float strokeWidth = this.i.getStrokeWidth();
        f = 0.0f;
        if (strokeWidth <= 0.0f) {
            c.b(str);
            return;
        }
        e(matrix);
        if (this.n != null) {
            this.i.setColorFilter((ColorFilter)this.n.h());
        }
        while (i2 < this.g.size()) {
            Object item2 = this.g.get(i2);
            i2 = i2 + 1;
        }
        c.b(str);
    }

    public <T> void g(T t, com.airbnb.lottie.z.c<T> cVar) {
        ColorFilter colorFilter;
        if (t == k.d) {
            this.k.n(cVar);
        } else {
            if (this.k == k.q) {
                this.j.n(cVar);
            } else {
                if (this.j == k.E && this.n != null) {
                    this.f.C(this.n);
                    if (cVar == null) {
                        com.airbnb.lottie.t.c.a aVar = null;
                        this.n = aVar;
                    } else {
                        p pVar = new p(cVar);
                        this.n = pVar;
                        pVar.a(this);
                        this.f.i(this.n);
                    }
                }
            }
        }
    }
}
