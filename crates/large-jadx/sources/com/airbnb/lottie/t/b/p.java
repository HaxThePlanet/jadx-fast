package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.t.c.o;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.l;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* compiled from: RepeaterContent.java */
/* loaded from: classes.dex */
public class p implements e, m, j, a.b, k {

    private final Matrix a = new Matrix();
    private final Path b = new Path();
    private final f c;
    private final com.airbnb.lottie.v.l.a d;
    private final String e;
    private final boolean f;
    private final com.airbnb.lottie.t.c.a<Float, Float> g;
    private final com.airbnb.lottie.t.c.a<Float, Float> h;
    private final o i;
    private d j;
    public p(f fVar, com.airbnb.lottie.v.l.a aVar, com.airbnb.lottie.v.k.k kVar) {
        super();
        Matrix matrix = new Matrix();
        Path path = new Path();
        this.c = fVar;
        this.d = aVar;
        this.e = kVar.c();
        this.f = kVar.f();
        com.airbnb.lottie.t.c.a aVar2 = kVar.b().j();
        this.g = aVar2;
        aVar.i(aVar2);
        aVar2.a(this);
        com.airbnb.lottie.t.c.a aVar3 = kVar.d().j();
        this.h = aVar3;
        aVar.i(aVar3);
        aVar3.a(this);
        o oVar = kVar.e().b();
        this.i = oVar;
        oVar.a(aVar);
        oVar.b(this);
    }

    public void a() {
        this.c.invalidateSelf();
    }

    public void b(List<c> list, List<c> list2) {
        this.j.b(list, list2);
    }

    public void c(e eVar, int i, List<e> list, e eVar2) {
        g.m(eVar, i, list, eVar2, this);
    }

    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.j.d(rectF, matrix, z);
    }

    public void e(ListIterator<c> listIterator) {
        boolean previous;
        if (this.j != null) {
            return;
        }
        while (listIterator.hasPrevious()) {
        }
        final ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        d listIterator2 = new d(this.c, this.d, "Repeater", this.f, arrayList, null);
        this.j = listIterator2;
    }

    public void f(Canvas canvas, Matrix matrix, int i) {
        float value = (Float)this.g.h().floatValue();
        float f3 = 100f;
        i = (int)value - 1;
        while (i >= 0) {
            this.a.set(matrix);
            float f8 = (float)i;
            f = f8 + (Float)this.h.h().floatValue();
            this.a.preConcat(this.i.g(f));
            i2 = (int)(float)i * (g.k((Float)this.i.i().h().floatValue() / f3, (Float)this.i.e().h().floatValue() / f3, f8 / value));
            this.j.f(canvas, this.a, i2);
            i = i - 1;
        }
    }

    public <T> void g(T t, c<T> cVar) {
        if (this.i.c(t, cVar)) {
            return;
        }
        if (t == k.s) {
            this.g.n(cVar);
        } else {
            if (this.g == k.t) {
                this.h.n(cVar);
            }
        }
    }

    public String getName() {
        return this.e;
    }

    public Path getPath() {
        int i;
        this.b.reset();
        i = (int)(Float)this.g.h().floatValue() - 1;
        while (this.g >= 0) {
            f = (float)i + (Float)this.h.h().floatValue();
            this.a.set(this.i.g(f));
            this.b.addPath(this.j.getPath(), this.a);
            i = i - 1;
        }
        return this.b;
    }
}
