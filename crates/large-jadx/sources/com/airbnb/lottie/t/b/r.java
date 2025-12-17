package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.b;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.v.j.a;
import com.airbnb.lottie.v.k.p;
import com.airbnb.lottie.v.k.p.b;
import com.airbnb.lottie.v.k.p.c;
import com.airbnb.lottie.v.l.a;
import com.airbnb.lottie.z.c;

/* loaded from: classes.dex */
public class r extends com.airbnb.lottie.t.b.a {

    private final a o;
    private final String p;
    private final boolean q;
    private final a<Integer, Integer> r;
    private a<ColorFilter, ColorFilter> s;
    public r(f f, a a2, p p3) {
        super(f, a2, p3.b().toPaintCap(), p3.e().toPaintJoin(), p3.g(), p3.i(), p3.j(), p3.f(), p3.d());
        this.o = a2;
        this.p = p3.h();
        this.q = p3.k();
        a obj12 = p3.c().j();
        this.r = obj12;
        obj12.a(this);
        a2.i(obj12);
    }

    @Override // com.airbnb.lottie.t.b.a
    public void f(Canvas canvas, Matrix matrix2, int i3) {
        Object aVar;
        int i;
        if (this.q) {
        }
        this.i.setColor((b)this.r.p());
        aVar = this.s;
        if (aVar != null) {
            this.i.setColorFilter((ColorFilter)aVar.h());
        }
        super.f(canvas, matrix2, i3);
    }

    public <T> void g(T t, c<T> c2) {
        Object num;
        Object obj2;
        Object obj3;
        super.g(t, c2);
        if (t == k.b) {
            this.r.n(c2);
        } else {
            obj2 = this.s;
            if (t == k.E && obj2 != null) {
                obj2 = this.s;
                if (obj2 != null) {
                    this.o.C(obj2);
                }
                if (c2 == null) {
                    this.s = 0;
                } else {
                    obj2 = new p(c2);
                    this.s = obj2;
                    obj2.a(this);
                    this.o.i(this.r);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.t.b.a
    public String getName() {
        return this.p;
    }
}
