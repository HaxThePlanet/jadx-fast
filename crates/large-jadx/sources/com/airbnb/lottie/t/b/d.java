package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.t.c.o;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.j.l;
import com.airbnb.lottie.v.k.b;
import com.airbnb.lottie.v.k.n;
import com.airbnb.lottie.y.h;
import com.airbnb.lottie.z.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContentGroup.java */
/* loaded from: classes.dex */
public class d implements e, m, a.b, com.airbnb.lottie.v.f {

    private Paint a;
    private RectF b;
    private final Matrix c;
    private final Path d;
    private final RectF e;
    private final String f;
    private final boolean g;
    private final List<c> h;
    private final com.airbnb.lottie.f i;
    private List<m> j;
    private o k;
    public d(com.airbnb.lottie.f fVar, com.airbnb.lottie.v.l.a aVar, n nVar) {
        this(fVar, aVar, nVar.c(), nVar.d(), d.e(fVar, aVar, nVar.b()), d.h(nVar.b()));
    }

    private static List<c> e(com.airbnb.lottie.f fVar, com.airbnb.lottie.v.l.a aVar, List<b> list) {
        int i = 0;
        final ArrayList arrayList = new ArrayList(list.size());
        i = 0;
        while (i < list.size()) {
            com.airbnb.lottie.t.b.c cVar = (b)list.get(i).a(fVar, aVar);
            i = i + 1;
        }
        return arrayList;
    }

    static l h(List<b> list) {
        int i = 0;
        i = 0;
        while (i < list.size()) {
            Object item = list.get(i);
            z = item instanceof l;
            if (item instanceof l) {
                return item;
            }
        }
        return null;
    }

    private boolean k() {
        int i;
        boolean z;
        i = 0;
        while (i < this.h.size()) {
            z = this.h.get(i) instanceof e;
            if (this.h.get(i) instanceof e) {
                i = i + 1;
            }
        }
        return false;
    }

    public void a() {
        this.i.invalidateSelf();
    }

    public void b(List<c> list, List<c> list2) {
        int i3;
        i = list.size() + this.h.size();
        final ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(list);
        i3 = this.h.size() - 1;
        while (this.h >= 0) {
            Object item = this.h.get(i3);
            int i2 = 0;
            item.b(arrayList, this.h.subList(i2, i3));
            arrayList.add(item);
            i3 = i3 - 1;
        }
    }

    public void c(e eVar, int i, List<e> list, e eVar2) {
        boolean z2;
        item = "__container";
        if (!eVar.g(getName(), i) && !item.equals(this.getName())) {
            return;
        }
        if (!item.equals(getName()) && eVar.c(this.getName(), i)) {
            list.add(eVar2.a(this.getName()).i(this));
        }
        if (eVar.h(getName(), i)) {
            i3 = i + (eVar.e(getName(), i));
            i = 0;
            while (i < this.h.size()) {
                String item = this.h.get(i);
                z2 = item instanceof f;
                i = i + 1;
            }
        }
    }

    public void d(RectF rectF, Matrix matrix, boolean z) {
        float f;
        Matrix matrix3;
        int i;
        this.c.set(matrix);
        if (this.k != null) {
            this.c.preConcat(this.k.f());
        }
        f = 0.0f;
        this.e.set(f, f, f, f);
        i = this.h.size() - 1;
        while (this.e >= 0) {
            Object item = this.h.get(i);
            z = item instanceof e;
            i = i - 1;
        }
    }

    public void f(Canvas canvas, Matrix matrix, int i) {
        int i2;
        RectF rectF;
        int value = 100;
        int i4 = 0;
        if (this.g) {
            return;
        }
        this.c.set(matrix);
        if (this.k != null) {
            this.c.preConcat(this.k.f());
            if (this.k.h() == null) {
                value = 100;
            } else {
                value = (Integer)this.k.h().h().intValue();
            }
            float f9 = 255f;
            i = (int)(float)value / 100f * (float)i / f9 * f9;
        }
        i = 255;
        boolean z = true;
        matrix = this.i.H() && this.k() && i != i ? z : 0;
        if (this.k != 0) {
            float f2 = 0.0f;
            this.b.set(f2, f2, f2, f2);
            d(this.b, this.c, z);
            this.a.setAlpha(i);
            h.m(canvas, this.b, this.a);
        }
        if (this.k != 0) {
        }
        i2 = this.h.size() - z;
        while (this.h >= 0) {
            Object item = this.h.get(i2);
            i2 = i2 - 1;
        }
        if (this.k != 0) {
            canvas.restore();
        }
    }

    public <T> void g(T t, c<T> cVar) {
        if (this.k != null) {
            this.k.c(t, cVar);
        }
    }

    public String getName() {
        return this.f;
    }

    public Path getPath() {
        int i;
        Matrix matrix;
        boolean z;
        Matrix matrix2;
        this.c.reset();
        if (this.k != null) {
            this.c.set(this.k.f());
        }
        this.d.reset();
        if (this.g) {
            return this.d;
        }
        i = this.h.size() - 1;
        while (this.g >= 0) {
            Object item = this.h.get(i);
            z = item instanceof m;
            i = i - 1;
        }
        return this.d;
    }

    List<m> i() {
        int i = 0;
        boolean z;
        if (this.j == null) {
            this.j = new ArrayList();
            i = 0;
            while (this.j < this.h.size()) {
                Object item = this.h.get(i);
                z = item instanceof m;
                i = i + 1;
            }
        }
        return this.j;
    }

    Matrix j() {
        if (this.k != null) {
            return this.k.f();
        }
        this.c.reset();
        return this.c;
    }

    d(com.airbnb.lottie.f fVar, com.airbnb.lottie.v.l.a aVar, String str, boolean z, List<c> list, l lVar) {
        int i;
        int i2;
        Object item;
        super();
        this.a = new a();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Path();
        this.e = new RectF();
        this.f = str;
        this.i = fVar;
        this.g = z;
        this.h = list;
        if (lVar != null) {
            o oVar2 = lVar.b();
            this.k = oVar2;
            oVar2.a(aVar);
            this.k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        i = list.size() - 1;
        while (i >= 0) {
            item = list.get(i);
            z = item instanceof j;
            i = i - 1;
        }
        i2 = arrayList.size() - 1;
        while (i2 >= 0) {
            (j)arrayList.get(i2).e(list.listIterator(list.size()));
            i2 = i2 - 1;
        }
    }
}
