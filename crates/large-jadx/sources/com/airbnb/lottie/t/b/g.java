package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.c;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.a;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.t.c.b;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.j.a;
import com.airbnb.lottie.v.j.d;
import com.airbnb.lottie.v.k.m;
import com.airbnb.lottie.v.l.a;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class g implements com.airbnb.lottie.t.b.e, a.b, com.airbnb.lottie.t.b.k {

    private final Path a;
    private final Paint b;
    private final a c;
    private final String d;
    private final boolean e;
    private final List<com.airbnb.lottie.t.b.m> f;
    private final a<Integer, Integer> g = null;
    private final a<Integer, Integer> h = null;
    private a<ColorFilter, ColorFilter> i;
    private final f j;
    public g(f f, a a2, m m3) {
        com.airbnb.lottie.v.j.n obj4;
        super();
        Path path = new Path();
        this.a = path;
        a aVar = new a(1);
        this.b = aVar;
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        this.c = a2;
        this.d = m3.d();
        this.e = m3.f();
        this.j = f;
        if (m3.b() != null && m3.e() == null) {
            if (m3.e() == null) {
            }
            path.setFillType(m3.c());
            obj4 = m3.b().j();
            this.g = obj4;
            obj4.a(this);
            a2.i(obj4);
            obj4 = m3.e().j();
            this.h = obj4;
            obj4.a(this);
            a2.i(obj4);
        }
        obj4 = 0;
    }

    @Override // com.airbnb.lottie.t.b.e
    public void a() {
        this.j.invalidateSelf();
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
            this.f.add((m)(c)obj);
        }
    }

    public void c(e e, int i2, List<e> list3, e e4) {
        g.m(e, i2, list3, e4, this);
    }

    @Override // com.airbnb.lottie.t.b.e
    public void d(RectF rectF, Matrix matrix2, boolean z3) {
        int i;
        Path path2;
        Path path;
        this.a.reset();
        int obj6 = 0;
        i = obj6;
        while (i < this.f.size()) {
            this.a.addPath((m)this.f.get(i).getPath(), matrix2);
            i++;
        }
        this.a.computeBounds(rectF, obj6);
        obj6 = 1065353216;
        rectF.set(obj5 -= obj6, top -= obj6, right += obj6, bottom += obj6);
    }

    @Override // com.airbnb.lottie.t.b.e
    public void f(Canvas canvas, Matrix matrix2, int i3) {
        Paint path;
        int i;
        Object obj7;
        if (this.e) {
        }
        String str = "FillContent#draw";
        c.a(str);
        this.b.setColor((b)this.g.p());
        int i2 = 1132396544;
        this.b.setAlpha(g.d((int)obj7, 0, 255));
        obj7 = this.i;
        if (obj7 != null) {
            this.b.setColorFilter((ColorFilter)obj7.h());
        }
        this.a.reset();
        while (i < this.f.size()) {
            this.a.addPath((m)this.f.get(i).getPath(), matrix2);
            i++;
        }
        canvas.drawPath(this.a, this.b);
        c.b(str);
    }

    public <T> void g(T t, c<T> c2) {
        Object num;
        a obj2;
        Object obj3;
        if (t == k.a) {
            this.g.n(c2);
        } else {
            if (t == k.d) {
                this.h.n(c2);
            } else {
                obj2 = this.i;
                if (t == k.E && obj2 != null) {
                    obj2 = this.i;
                    if (obj2 != null) {
                        this.c.C(obj2);
                    }
                    if (c2 == null) {
                        this.i = 0;
                    } else {
                        obj2 = new p(c2);
                        this.i = obj2;
                        obj2.a(this);
                        this.c.i(this.i);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.t.b.e
    public String getName() {
        return this.d;
    }
}
