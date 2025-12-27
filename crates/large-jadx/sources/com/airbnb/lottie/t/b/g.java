package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.t.c.b;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.j.d;
import com.airbnb.lottie.v.k.m;
import com.airbnb.lottie.y.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FillContent.java */
/* loaded from: classes.dex */
public class g implements e, a.b, k {

    private final Path a = new Path();
    private final Paint b = new a(1);
    private final com.airbnb.lottie.v.l.a c;
    private final String d;
    private final boolean e;
    private final List<m> f = new ArrayList<>();
    private final com.airbnb.lottie.t.c.a<Integer, Integer> g = null;
    private final com.airbnb.lottie.t.c.a<Integer, Integer> h = null;
    private com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> i;
    private final f j;
    public g(f fVar, com.airbnb.lottie.v.l.a aVar, m mVar) {
        super();
        com.airbnb.lottie.t.a aVar3 = new a(1);
        ArrayList arrayList = new ArrayList();
        this.c = aVar;
        this.d = mVar.d();
        this.e = mVar.f();
        this.j = fVar;
    }

    public void a() {
        this.j.invalidateSelf();
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
        this.a.reset();
        z = false;
        z32 = z;
        while (z32 < this.f.size()) {
            this.a.addPath((m)this.f.get(z32).getPath(), matrix);
            z32 = z32 + 1;
        }
        this.a.computeBounds(rectF, z);
        float f5 = 1f;
        rectF.set(rectF.left - f5, rectF.top - f5, rectF.right + f5, rectF.bottom + f5);
    }

    public void f(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        if (this.e) {
            return;
        }
        String str = "FillContent#draw";
        c.a(str);
        this.b.setColor((b)this.g.p());
        float f = 255f;
        i = 0;
        this.b.setAlpha(g.d((int)(float)i / f * (float)(Integer)this.h.h().intValue() / 100f * f, i, 255));
        if (this.i != null) {
            this.b.setColorFilter((ColorFilter)this.i.h());
        }
        this.a.reset();
        while (i < this.f.size()) {
            this.a.addPath((m)this.f.get(i).getPath(), matrix);
            i = i + 1;
        }
        canvas.drawPath(this.a, this.b);
        c.b(str);
    }

    public <T> void g(T t, com.airbnb.lottie.z.c<T> cVar) {
        ColorFilter colorFilter;
        if (t == k.a) {
            this.g.n(cVar);
        } else {
            if (this.g == k.d) {
                this.h.n(cVar);
            } else {
                if (this.h == k.E && this.i != null) {
                    this.c.C(this.i);
                    if (cVar == null) {
                        com.airbnb.lottie.t.c.a aVar = null;
                        this.i = aVar;
                    } else {
                        p pVar = new p(cVar);
                        this.i = pVar;
                        pVar.a(this);
                        this.c.i(this.i);
                    }
                }
            }
        }
    }

    public String getName() {
        return this.d;
    }
}
