package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.t.a;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.t.c.o;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.f;
import com.airbnb.lottie.v.j.l;
import com.airbnb.lottie.v.k.b;
import com.airbnb.lottie.v.k.n;
import com.airbnb.lottie.v.l.a;
import com.airbnb.lottie.y.h;
import com.airbnb.lottie.z.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class d implements com.airbnb.lottie.t.b.e, com.airbnb.lottie.t.b.m, a.b, f {

    private Paint a;
    private RectF b;
    private final Matrix c;
    private final Path d;
    private final RectF e;
    private final String f;
    private final boolean g;
    private final List<com.airbnb.lottie.t.b.c> h;
    private final f i;
    private List<com.airbnb.lottie.t.b.m> j;
    private o k;
    public d(f f, a a2, n n3) {
        super(f, a2, n3.c(), n3.d(), d.e(f, a2, n3.b()), d.h(n3.b()));
    }

    d(f f, a a2, String string3, boolean z4, List<com.airbnb.lottie.t.b.c> list5, l l6) {
        Object obj2;
        int obj3;
        String obj4;
        boolean obj5;
        super();
        a aVar = new a();
        this.a = aVar;
        RectF rectF = new RectF();
        this.b = rectF;
        Matrix matrix = new Matrix();
        this.c = matrix;
        Path path = new Path();
        this.d = path;
        RectF rectF2 = new RectF();
        this.e = rectF2;
        this.f = string3;
        this.i = f;
        this.g = z4;
        this.h = list5;
        if (l6 != null) {
            obj2 = l6.b();
            this.k = obj2;
            obj2.a(a2);
            this.k.b(this);
        }
        obj2 = new ArrayList();
        obj3--;
        while (obj3 >= 0) {
            obj4 = list5.get(obj3);
            if (obj4 instanceof j) {
            }
            obj3--;
            obj2.add((j)(c)obj4);
        }
        obj3--;
        while (obj3 >= 0) {
            (j)obj2.get(obj3).e(list5.listIterator(list5.size()));
            obj3--;
        }
    }

    private static List<com.airbnb.lottie.t.b.c> e(f f, a a2, List<b> list3) {
        int i;
        com.airbnb.lottie.t.b.c cVar;
        ArrayList arrayList = new ArrayList(list3.size());
        i = 0;
        while (i < list3.size()) {
            cVar = (b)list3.get(i).a(f, a2);
            if (cVar != null) {
            }
            i++;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    static l h(List<b> list) {
        int i;
        Object obj;
        boolean z;
        i = 0;
        while (i < list.size()) {
            obj = list.get(i);
            i++;
        }
        return null;
    }

    private boolean k() {
        int i;
        int i2;
        boolean z;
        int i3 = 0;
        i2 = i;
        while (i < this.h.size()) {
            i++;
        }
        return i3;
    }

    @Override // com.airbnb.lottie.t.b.e
    public void a() {
        this.i.invalidateSelf();
    }

    public void b(List<com.airbnb.lottie.t.b.c> list, List<com.airbnb.lottie.t.b.c> list2) {
        int i;
        int subList;
        int i2;
        int obj4;
        ArrayList obj5 = new ArrayList(size += subList);
        obj5.addAll(list);
        obj4--;
        while (obj4 >= 0) {
            i = this.h.get(obj4);
            (c)i.b(obj5, this.h.subList(0, obj4));
            obj5.add(i);
            obj4--;
        }
    }

    public void c(e e, int i2, List<e> list3, e e4) {
        boolean equals2;
        boolean equals;
        int z;
        String size;
        boolean z2;
        int obj5;
        e obj7;
        size = "__container";
        if (!e.g(getName(), i2) && !size.equals(getName())) {
            if (!size.equals(getName())) {
            }
        }
        if (!size.equals(getName()) && e.c(getName(), i2)) {
            if (e.c(getName(), i2)) {
                list3.add(e4.a(getName()).i(this));
            }
        }
        if (e.h(getName(), i2)) {
            z = 0;
            while (z < this.h.size()) {
                size = this.h.get(z);
                if (size instanceof f) {
                }
                z++;
                (f)(c)size.c(e, i2 += i, list3, obj7);
            }
        }
    }

    @Override // com.airbnb.lottie.t.b.e
    public void d(RectF rectF, Matrix matrix2, boolean z3) {
        Matrix matrix;
        int i;
        boolean z;
        Matrix matrix3;
        Object obj5;
        this.c.set(matrix2);
        obj5 = this.k;
        if (obj5 != null) {
            this.c.preConcat(obj5.f());
        }
        i = 0;
        this.e.set(i, i, i, i);
        obj5--;
        while (obj5 >= 0) {
            i = this.h.get(obj5);
            if (i instanceof e) {
            }
            obj5--;
            (e)(c)i.d(this.e, this.c, z3);
            rectF.union(this.e);
        }
    }

    @Override // com.airbnb.lottie.t.b.e
    public void f(Canvas canvas, Matrix matrix2, int i3) {
        Matrix matrix;
        int i;
        int i2;
        RectF rectF;
        Paint paint;
        int obj6;
        int obj7;
        if (this.g) {
        }
        this.c.set(matrix2);
        obj6 = this.k;
        if (obj6 != null) {
            this.c.preConcat(obj6.f());
            if (this.k.h() == null) {
                obj6 = 100;
            } else {
                obj6 = (Integer)this.k.h().h().intValue();
            }
            obj7 = 1132396544;
            obj7 = (int)obj6;
        }
        int i4 = 255;
        i2 = 1;
        if (this.i.H() && k() && obj7 != i4) {
            if (k()) {
                obj6 = obj7 != i4 ? i2 : 0;
            } else {
            }
        } else {
        }
        if (obj6 != null) {
            int i5 = 0;
            this.b.set(i5, i5, i5, i5);
            d(this.b, this.c, i2);
            this.a.setAlpha(obj7);
            h.m(canvas, this.b, this.a);
        }
        if (obj6 != null) {
            obj7 = i4;
        }
        size -= i2;
        while (i >= 0) {
            i2 = this.h.get(i);
            if (i2 instanceof e) {
            }
            i--;
            (e)i2.f(canvas, this.c, obj7);
        }
        if (obj6 != null) {
            canvas.restore();
        }
    }

    public <T> void g(T t, c<T> c2) {
        final o oVar = this.k;
        if (oVar != null) {
            oVar.c(t, c2);
        }
    }

    @Override // com.airbnb.lottie.t.b.e
    public String getName() {
        return this.f;
    }

    @Override // com.airbnb.lottie.t.b.e
    public Path getPath() {
        Object oVar;
        int i;
        Matrix path;
        boolean z;
        Matrix matrix;
        this.c.reset();
        oVar = this.k;
        if (oVar != null) {
            this.c.set(oVar.f());
        }
        this.d.reset();
        if (this.g) {
            return this.d;
        }
        size--;
        while (i >= 0) {
            path = this.h.get(i);
            if (path instanceof m) {
            }
            i--;
            this.d.addPath((m)(c)path.getPath(), this.c);
        }
        return this.d;
    }

    List<com.airbnb.lottie.t.b.m> i() {
        int list;
        Object size;
        boolean z;
        if (this.j == null) {
            ArrayList arrayList = new ArrayList();
            this.j = arrayList;
            list = 0;
            while (list < this.h.size()) {
                size = this.h.get(list);
                if (size instanceof m) {
                }
                list++;
                this.j.add((m)(c)size);
            }
        }
        return this.j;
    }

    @Override // com.airbnb.lottie.t.b.e
    Matrix j() {
        o oVar = this.k;
        if (oVar != null) {
            return oVar.f();
        }
        this.c.reset();
        return this.c;
    }
}
