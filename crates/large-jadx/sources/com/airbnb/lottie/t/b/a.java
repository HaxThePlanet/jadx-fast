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
import com.airbnb.lottie.c;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.a;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.t.c.c;
import com.airbnb.lottie.t.c.e;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.d;
import com.airbnb.lottie.v.k.q.a;
import com.airbnb.lottie.v.l.a;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.y.h;
import com.airbnb.lottie.z.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a implements a.b, com.airbnb.lottie.t.b.k, com.airbnb.lottie.t.b.e {

    private final PathMeasure a;
    private final Path b;
    private final Path c;
    private final RectF d;
    private final f e;
    protected final a f;
    private final List<com.airbnb.lottie.t.b.a.b> g;
    private final float[] h;
    final Paint i;
    private final a<?, Float> j;
    private final a<?, Integer> k;
    private final List<a<?, Float>> l;
    private final a<?, Float> m = null;
    private a<ColorFilter, ColorFilter> n;

    static class a {
    }

    private static final class b {

        private final List<com.airbnb.lottie.t.b.m> a;
        private final com.airbnb.lottie.t.b.s b;
        private b(com.airbnb.lottie.t.b.s s) {
            super();
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            this.b = s;
        }

        b(com.airbnb.lottie.t.b.s s, com.airbnb.lottie.t.b.a.a a$a2) {
            super(s);
        }

        static List a(com.airbnb.lottie.t.b.a.b a$b) {
            return b.a;
        }

        static com.airbnb.lottie.t.b.s b(com.airbnb.lottie.t.b.a.b a$b) {
            return b.b;
        }
    }
    a(f f, a a2, Paint.Cap paint$Cap3, Paint.Join paint$Join4, float f5, d d6, b b7, List<b> list8, b b9) {
        int obj3;
        a obj4;
        int obj5;
        Paint.Join obj6;
        float obj7;
        super();
        PathMeasure pathMeasure = new PathMeasure();
        this.a = pathMeasure;
        Path path = new Path();
        this.b = path;
        Path path2 = new Path();
        this.c = path2;
        RectF rectF = new RectF();
        this.d = rectF;
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        a aVar = new a(1);
        this.i = aVar;
        this.e = f;
        this.f = a2;
        aVar.setStyle(Paint.Style.STROKE);
        aVar.setStrokeCap(cap3);
        aVar.setStrokeJoin(join4);
        aVar.setStrokeMiter(f5);
        this.k = d6.j();
        this.j = b7.j();
        if (b9 == null) {
            obj3 = 0;
        } else {
            this.m = b9.j();
        }
        obj3 = new ArrayList(list8.size());
        this.l = obj3;
        this.h = new float[list8.size()];
        obj3 = 0;
        obj5 = obj3;
        while (obj5 < list8.size()) {
            this.l.add((b)list8.get(obj5).j());
            obj5++;
        }
        a2.i(this.k);
        a2.i(this.j);
        obj5 = obj3;
        while (obj5 < this.l.size()) {
            a2.i((a)this.l.get(obj5));
            obj5++;
        }
        obj5 = this.m;
        if (obj5 != null) {
            a2.i(obj5);
        }
        this.k.a(this);
        this.j.a(this);
        while (obj3 < list8.size()) {
            (a)this.l.get(obj3).a(this);
            obj3++;
        }
        obj3 = this.m;
        if (obj3 != null) {
            obj3.a(this);
        }
    }

    private void e(Matrix matrix) {
        int i3;
        a floatValue;
        float[] fArr;
        float[] fArr2;
        int i2;
        int cmp;
        int i;
        int obj6;
        final String str = "StrokeContent#applyDashPattern";
        c.a(str);
        if (this.l.isEmpty()) {
            c.b(str);
        }
        obj6 = h.g(matrix);
        i3 = 0;
        while (i3 < this.l.size()) {
            this.h[i3] = (Float)(a)this.l.get(i3).h().floatValue();
            if (i3 % 2 == 0) {
            } else {
            }
            fArr2 = this.h;
            i = 1036831949;
            if (Float.compare(f, i) < 0) {
            }
            fArr = this.h;
            fArr[i3] = f2 *= obj6;
            i3++;
            fArr2[i3] = i;
            fArr2 = this.h;
            i = 1065353216;
            if (Float.compare(f3, i) < 0) {
            }
            fArr2[i3] = i;
        }
        floatValue = this.m;
        if (floatValue == null) {
            obj6 = 0;
        } else {
            obj6 *= floatValue;
        }
        DashPathEffect dashPathEffect = new DashPathEffect(this.h, obj6);
        this.i.setPathEffect(dashPathEffect);
        c.b(str);
    }

    private void h(Canvas canvas, com.airbnb.lottie.t.b.a.b a$b2, Matrix matrix3) {
        int i3;
        float length2;
        Path path;
        Path length3;
        int i2;
        Path path3;
        int i;
        float length;
        Path path2;
        int cmp3;
        int cmp;
        Paint paint;
        int cmp2;
        final String str = "StrokeContent#applyTrimPath";
        c.a(str);
        if (a.b.b(b2) == null) {
            c.b(str);
        }
        this.b.reset();
        size--;
        while (i3 >= 0) {
            this.b.addPath((m)a.b.a(b2).get(i3).getPath(), matrix3);
            i3--;
        }
        int i6 = 0;
        this.a.setPath(this.b, i6);
        length2 = this.a.getLength();
        while (this.a.nextContour()) {
            length2 += length3;
        }
        i4 /= i7;
        int i11 = 1120403456;
        i9 += i5;
        i14 += i5;
        size2--;
        int i12 = 0;
        i = i12;
        while (i2 >= 0) {
            this.c.set((m)a.b.a(b2).get(i2).getPath());
            this.c.transform(matrix3);
            this.a.setPath(this.c, i6);
            length = this.a.getLength();
            cmp3 = i15 - length2;
            if (Float.compare(i15, length2) > 0 && Float.compare(cmp3, i17) < 0 && Float.compare(i, cmp3) < 0) {
            } else {
            }
            path2 = i + length;
            if (Float.compare(path2, i10) >= 0) {
            }
            i += length;
            i2--;
            if (Float.compare(i, i15) > 0) {
            } else {
            }
            if (Float.compare(path2, i15) <= 0 && Float.compare(i10, i) < 0) {
            } else {
            }
            if (Float.compare(i10, i) < 0) {
            } else {
            }
            i19 /= length;
            if (Float.compare(i15, path2) > 0) {
            } else {
            }
            paint = cmp / length;
            h.a(this.c, cmp2, paint, i12);
            canvas.drawPath(this.c, this.i);
            cmp2 = i12;
            if (Float.compare(i10, i) < 0) {
            } else {
            }
            canvas.drawPath(this.c, this.i);
            cmp3 = i15 - length2;
            if (Float.compare(cmp3, i17) < 0) {
            } else {
            }
            if (Float.compare(i, cmp3) < 0) {
            } else {
            }
            if (Float.compare(i10, length2) > 0) {
            } else {
            }
            cmp2 = i12;
            h.a(this.c, cmp2, Math.min(cmp3 /= length, 1065353216), i12);
            canvas.drawPath(this.c, this.i);
            i18 /= length;
        }
        c.b(str);
    }

    @Override // com.airbnb.lottie.t.c.a$b
    public void a() {
        this.e.invalidateSelf();
    }

    public void b(List<com.airbnb.lottie.t.b.c> list, List<com.airbnb.lottie.t.b.c> list2) {
        int i;
        int bVar;
        int i2;
        Object obj;
        boolean z;
        q.a iNDIVIDUALLY2;
        q.a iNDIVIDUALLY;
        int obj8;
        size--;
        final int i3 = 0;
        i2 = i3;
        while (i >= 0) {
            obj = list.get(i);
            if (obj instanceof s && (s)(c)obj.i() == q.a.INDIVIDUALLY) {
            }
            i--;
            if ((s)obj.i() == q.a.INDIVIDUALLY) {
            }
            i2 = obj;
        }
        if (i2 != 0) {
            i2.c(this);
        }
        obj8--;
        bVar = i3;
        while (obj8 >= 0) {
            obj = list2.get(obj8);
            z = obj;
            if (obj instanceof s && (s)z.i() == q.a.INDIVIDUALLY) {
            } else {
            }
            if (obj instanceof m && bVar == 0) {
            }
            obj8--;
            if (bVar == 0) {
            }
            a.b.a(bVar).add((m)(c)obj);
            bVar = new a.b(i2, i3);
            z = obj;
            if ((s)z.i() == q.a.INDIVIDUALLY) {
            } else {
            }
            if (bVar != 0) {
            }
            bVar = new a.b(z, i3);
            z.c(this);
            this.g.add(bVar);
        }
        if (bVar != 0) {
            this.g.add(bVar);
        }
    }

    public void c(e e, int i2, List<e> list3, e e4) {
        g.m(e, i2, list3, e4, this);
    }

    @Override // com.airbnb.lottie.t.c.a$b
    public void d(RectF rectF, Matrix matrix2, boolean z3) {
        int i;
        Object obj;
        int i2;
        int size;
        Path path;
        final String obj9 = "StrokeContent#getBounds";
        c.a(obj9);
        this.b.reset();
        int i3 = 0;
        i = i3;
        while (i < this.g.size()) {
            obj = this.g.get(i);
            i2 = i3;
            while (i2 < a.b.a((a.b)obj).size()) {
                this.b.addPath((m)a.b.a(obj).get(i2).getPath(), matrix2);
                i2++;
            }
            i++;
            this.b.addPath((m)a.b.a(obj).get(i2).getPath(), matrix2);
            i2++;
        }
        this.b.computeBounds(this.d, i3);
        RectF rectF2 = this.d;
        obj8 /= i7;
        rectF2.set(left -= obj8, top2 -= obj8, right2 += obj8, bottom2 += obj8);
        rectF.set(this.d);
        int i4 = 1065353216;
        rectF.set(obj8 -= i4, top -= i4, right += i4, bottom += i4);
        c.b(obj9);
    }

    @Override // com.airbnb.lottie.t.c.a$b
    public void f(Canvas canvas, Matrix matrix2, int i3) {
        int i4;
        float f;
        int i;
        int i2;
        Path path2;
        Path path;
        Object obj9;
        final String str = "StrokeContent#draw";
        c.a(str);
        if (h.h(matrix2)) {
            c.b(str);
        }
        int i5 = 1132396544;
        this.i.setAlpha(g.d((int)obj9, 0, 255));
        this.i.setStrokeWidth(f2 *= f);
        if (Float.compare(obj9, i4) <= 0) {
            c.b(str);
        }
        e(matrix2);
        obj9 = this.n;
        if (obj9 != null) {
            this.i.setColorFilter((ColorFilter)obj9.h());
        }
        while (i2 < this.g.size()) {
            obj9 = this.g.get(i2);
            if (a.b.b((a.b)obj9) != null) {
            } else {
            }
            String str2 = "StrokeContent#buildPath";
            c.a(str2);
            this.b.reset();
            size--;
            while (i >= 0) {
                this.b.addPath((m)a.b.a(obj9).get(i).getPath(), matrix2);
                i--;
            }
            c.b(str2);
            obj9 = "StrokeContent#drawPath";
            c.a(obj9);
            canvas.drawPath(this.b, this.i);
            c.b(obj9);
            i2++;
            this.b.addPath((m)a.b.a(obj9).get(i).getPath(), matrix2);
            i--;
            h(canvas, obj9, matrix2);
        }
        c.b(str);
    }

    public <T> void g(T t, c<T> c2) {
        Object num;
        a obj2;
        Object obj3;
        if (t == k.d) {
            this.k.n(c2);
        } else {
            if (t == k.q) {
                this.j.n(c2);
            } else {
                obj2 = this.n;
                if (t == k.E && obj2 != null) {
                    obj2 = this.n;
                    if (obj2 != null) {
                        this.f.C(obj2);
                    }
                    if (c2 == null) {
                        this.n = 0;
                    } else {
                        obj2 = new p(c2);
                        this.n = obj2;
                        obj2.a(this);
                        this.f.i(this.n);
                    }
                }
            }
        }
    }
}
