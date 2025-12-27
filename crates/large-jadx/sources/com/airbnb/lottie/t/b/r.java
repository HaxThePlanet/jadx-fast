package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.b;
import com.airbnb.lottie.v.k.p.b;
import com.airbnb.lottie.v.k.p.c;
import com.airbnb.lottie.z.c;

/* compiled from: StrokeContent.java */
/* loaded from: classes.dex */
public class r extends a {

    private final com.airbnb.lottie.v.l.a o;
    private final String p;
    private final boolean q;
    private final com.airbnb.lottie.t.c.a<Integer, Integer> r;
    private com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> s;
    public r(f fVar, com.airbnb.lottie.v.l.a aVar, com.airbnb.lottie.v.k.p pVar) {
        super(fVar, aVar, pVar.b().toPaintCap(), pVar.e().toPaintJoin(), pVar.g(), pVar.i(), pVar.j(), pVar.f(), pVar.d());
        this.o = aVar;
        this.p = pVar.h();
        this.q = pVar.k();
        com.airbnb.lottie.t.c.a aVar3 = pVar.c().j();
        this.r = aVar3;
        aVar3.a(this);
        aVar.i(aVar3);
    }

    @Override // com.airbnb.lottie.t.b.a
    public void f(Canvas canvas, Matrix matrix, int i) {
        if (this.q) {
            return;
        }
        this.i.setColor((b)this.r.p());
        if (this.s != null) {
            this.i.setColorFilter((ColorFilter)this.s.h());
        }
        super.f(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.t.b.a
    public <T> void g(T t, c<T> cVar) {
        ColorFilter colorFilter;
        super.g(t, cVar);
        if (t == k.b) {
            this.r.n(cVar);
        } else {
            if (this.r == k.E && this.s != null) {
                this.o.C(this.s);
                if (cVar == null) {
                    this.s = null;
                } else {
                    com.airbnb.lottie.t.c.p pVar = new p(cVar);
                    this.s = pVar;
                    pVar.a(this);
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
