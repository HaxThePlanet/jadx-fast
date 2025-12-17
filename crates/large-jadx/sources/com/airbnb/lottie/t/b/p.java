package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.t.c.o;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.l;
import com.airbnb.lottie.v.k.k;
import com.airbnb.lottie.v.l.a;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class p implements com.airbnb.lottie.t.b.e, com.airbnb.lottie.t.b.m, com.airbnb.lottie.t.b.j, a.b, com.airbnb.lottie.t.b.k {

    private final Matrix a;
    private final Path b;
    private final f c;
    private final a d;
    private final String e;
    private final boolean f;
    private final a<Float, Float> g;
    private final a<Float, Float> h;
    private final o i;
    private com.airbnb.lottie.t.b.d j;
    public p(f f, a a2, k k3) {
        super();
        Matrix matrix = new Matrix();
        this.a = matrix;
        Path path = new Path();
        this.b = path;
        this.c = f;
        this.d = a2;
        this.e = k3.c();
        this.f = k3.f();
        a obj2 = k3.b().j();
        this.g = obj2;
        a2.i(obj2);
        obj2.a(this);
        obj2 = k3.d().j();
        this.h = obj2;
        a2.i(obj2);
        obj2.a(this);
        obj2 = k3.e().b();
        this.i = obj2;
        obj2.a(a2);
        obj2.b(this);
    }

    @Override // com.airbnb.lottie.t.b.e
    public void a() {
        this.c.invalidateSelf();
    }

    public void b(List<com.airbnb.lottie.t.b.c> list, List<com.airbnb.lottie.t.b.c> list2) {
        this.j.b(list, list2);
    }

    public void c(e e, int i2, List<e> list3, e e4) {
        g.m(e, i2, list3, e4, this);
    }

    @Override // com.airbnb.lottie.t.b.e
    public void d(RectF rectF, Matrix matrix2, boolean z3) {
        this.j.d(rectF, matrix2, z3);
    }

    public void e(ListIterator<com.airbnb.lottie.t.b.c> listIterator) {
        com.airbnb.lottie.t.b.d previous;
        if (this.j != null) {
        }
        while (listIterator.hasPrevious()) {
            if (listIterator.previous() != this) {
            }
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        super(this.c, this.d, "Repeater", this.f, arrayList, 0);
        this.j = obj9;
    }

    @Override // com.airbnb.lottie.t.b.e
    public void f(Canvas canvas, Matrix matrix2, int i3) {
        int i2;
        int i;
        com.airbnb.lottie.t.b.d dVar;
        Matrix matrix;
        int i4;
        float floatValue = (Float)this.g.h().floatValue();
        int i6 = 1120403456;
        i7--;
        while (i2 >= 0) {
            this.a.set(matrix2);
            float f3 = (float)i2;
            this.a.preConcat(this.i.g(f3 + floatValue2));
            this.j.f(canvas, this.a, (int)i9);
            i2--;
        }
    }

    public <T> void g(T t, c<T> c2) {
        Float num;
        Object obj2;
        if (this.i.c(t, c2)) {
        }
        if (t == k.s) {
            this.g.n(c2);
        } else {
            if (t == k.t) {
                this.h.n(c2);
            }
        }
    }

    @Override // com.airbnb.lottie.t.b.e
    public String getName() {
        return this.e;
    }

    @Override // com.airbnb.lottie.t.b.e
    public Path getPath() {
        int i2;
        Path path;
        Matrix matrix;
        int i;
        this.b.reset();
        i3--;
        while (i2 >= 0) {
            this.a.set(this.i.g(f += floatValue2));
            this.b.addPath(this.j.getPath(), this.a);
            i2--;
        }
        return this.b;
    }
}
