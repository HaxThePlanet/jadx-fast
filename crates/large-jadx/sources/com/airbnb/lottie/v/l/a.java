package com.airbnb.lottie.v.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import com.airbnb.lottie.c;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.n;
import com.airbnb.lottie.t.a;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.e;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.t.c.c;
import com.airbnb.lottie.t.c.g;
import com.airbnb.lottie.t.c.o;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.f;
import com.airbnb.lottie.v.j.l;
import com.airbnb.lottie.v.k.g;
import com.airbnb.lottie.v.k.g.a;
import com.airbnb.lottie.v.k.l;
import com.airbnb.lottie.y.d;
import com.airbnb.lottie.y.h;
import com.airbnb.lottie.z.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a implements e, a.b, f {

    private final Path a;
    private final Matrix b;
    private final Paint c;
    private final Paint d;
    private final Paint e;
    private final Paint f;
    private final Paint g;
    private final RectF h;
    private final RectF i;
    private final RectF j;
    private final RectF k;
    private final String l;
    final Matrix m;
    final f n;
    final com.airbnb.lottie.v.l.d o;
    private g p;
    private c q;
    private com.airbnb.lottie.v.l.a r;
    private com.airbnb.lottie.v.l.a s;
    private List<com.airbnb.lottie.v.l.a> t;
    private final List<a<?, ?>> u;
    final o v;
    private boolean w = true;
    private boolean x;
    private Paint y;

    static class b {

        static final int[] a;
        static final int[] b;
        static {
            int[] iArr = new int[values.length];
            a.b.b = iArr;
            int i2 = 1;
            iArr[g.a.MASK_MODE_NONE.ordinal()] = i2;
            int i = 2;
            a.b.b[g.a.MASK_MODE_SUBTRACT.ordinal()] = i;
            int i3 = 3;
            a.b.b[g.a.MASK_MODE_INTERSECT.ordinal()] = i3;
            int i7 = 4;
            a.b.b[g.a.MASK_MODE_ADD.ordinal()] = i7;
            int[] iArr11 = new int[values2.length];
            a.b.a = iArr11;
            iArr11[d.a.SHAPE.ordinal()] = i2;
            a.b.a[d.a.PRE_COMP.ordinal()] = i;
            a.b.a[d.a.SOLID.ordinal()] = i3;
            a.b.a[d.a.IMAGE.ordinal()] = i7;
            a.b.a[d.a.NULL.ordinal()] = 5;
            a.b.a[d.a.TEXT.ordinal()] = 6;
            a.b.a[d.a.UNKNOWN.ordinal()] = 7;
        }
    }

    class a implements a.b {

        final com.airbnb.lottie.v.l.a a;
        a(com.airbnb.lottie.v.l.a a) {
            this.a = a;
            super();
        }

        @Override // com.airbnb.lottie.t.c.a$b
        public void a() {
            int i;
            final com.airbnb.lottie.v.l.a aVar = this.a;
            i = Float.compare(f, i2) == 0 ? 1 : 0;
            a.h(aVar, i);
        }
    }
    a(f f, com.airbnb.lottie.v.l.d d2) {
        PorterDuff.Mode dST_OUT;
        PorterDuffXfermode obj5;
        com.airbnb.lottie.v.l.d obj6;
        super();
        Path path = new Path();
        this.a = path;
        Matrix matrix = new Matrix();
        this.b = matrix;
        int i = 1;
        a aVar = new a(i);
        this.c = aVar;
        a aVar2 = new a(i, PorterDuff.Mode.DST_IN);
        this.d = aVar2;
        a aVar3 = new a(i, PorterDuff.Mode.DST_OUT);
        this.e = aVar3;
        a aVar4 = new a(i);
        this.f = aVar4;
        a aVar5 = new a(PorterDuff.Mode.CLEAR);
        this.g = aVar5;
        RectF rectF = new RectF();
        this.h = rectF;
        RectF rectF2 = new RectF();
        this.i = rectF2;
        RectF rectF3 = new RectF();
        this.j = rectF3;
        RectF rectF4 = new RectF();
        this.k = rectF4;
        Matrix matrix2 = new Matrix();
        this.m = matrix2;
        ArrayList arrayList = new ArrayList();
        this.u = arrayList;
        this.n = f;
        this.o = d2;
        obj5 = new StringBuilder();
        obj5.append(d2.g());
        obj5.append("#draw");
        this.l = obj5.toString();
        if (d2.f() == d.b.INVERT) {
            obj5 = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            aVar4.setXfermode(obj5);
        } else {
            obj5 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
            aVar4.setXfermode(obj5);
        }
        obj5 = d2.u().b();
        this.v = obj5;
        obj5.b(this);
        if (d2.e() != null && !d2.e().isEmpty()) {
            if (!d2.e().isEmpty()) {
                obj5 = new g(d2.e());
                this.p = obj5;
                obj5 = obj5.a().iterator();
                for (a obj6 : obj5) {
                    obj6.a(this);
                }
                obj5 = this.p.c().iterator();
                for (a obj6 : obj5) {
                    i(obj6);
                    obj6.a(this);
                }
            }
        }
        J();
    }

    private void A() {
        this.n.invalidateSelf();
    }

    private void B(float f) {
        this.n.o().m().a(this.o.g(), f);
    }

    private void I(boolean z) {
        if (z != this.w) {
            this.w = z;
            A();
        }
    }

    private void J() {
        boolean empty;
        int i2;
        int i;
        if (!this.o.c().isEmpty()) {
            c cVar = new c(this.o.c());
            this.q = cVar;
            cVar.l();
            a.a aVar = new a.a(this);
            this.q.a(aVar);
            if (Float.compare(floatValue, i) == 0) {
            } else {
                i2 = 0;
            }
            I(i2);
            i(this.q);
        } else {
            I(true);
        }
    }

    static c e(com.airbnb.lottie.v.l.a a) {
        return a.q;
    }

    static void h(com.airbnb.lottie.v.l.a a, boolean z2) {
        a.I(z2);
    }

    private void j(Canvas canvas, Matrix matrix2, g g3, a<l, Path> a4, a<Integer, Integer> a5) {
        this.a.set((Path)a4.h());
        this.a.transform(matrix2);
        this.c.setAlpha((int)obj3);
        canvas.drawPath(this.a, this.c);
    }

    private void k(Canvas canvas, Matrix matrix2, g g3, a<l, Path> a4, a<Integer, Integer> a5) {
        h.m(canvas, this.h, this.d);
        this.a.set((Path)a4.h());
        this.a.transform(matrix2);
        this.c.setAlpha((int)obj4);
        canvas.drawPath(this.a, this.c);
        canvas.restore();
    }

    private void l(Canvas canvas, Matrix matrix2, g g3, a<l, Path> a4, a<Integer, Integer> a5) {
        h.m(canvas, this.h, this.c);
        canvas.drawRect(this.h, this.c);
        this.a.set((Path)a4.h());
        this.a.transform(matrix2);
        this.c.setAlpha((int)obj4);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix2, g g3, a<l, Path> a4, a<Integer, Integer> a5) {
        h.m(canvas, this.h, this.d);
        canvas.drawRect(this.h, this.c);
        this.e.setAlpha((int)obj6);
        this.a.set((Path)a4.h());
        this.a.transform(matrix2);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix2, g g3, a<l, Path> a4, a<Integer, Integer> a5) {
        h.m(canvas, this.h, this.e);
        canvas.drawRect(this.h, this.c);
        this.e.setAlpha((int)obj6);
        this.a.set((Path)a4.h());
        this.a.transform(matrix2);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix2) {
        int i3;
        int sDK_INT;
        int i2;
        int i;
        Matrix matrix;
        Object obj;
        Object obj3;
        Object obj2;
        String str = "Layer#saveLayer";
        c.a(str);
        h.n(canvas, this.h, this.d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        c.b(str);
        i3 = 0;
        while (i3 < this.p.b().size()) {
            obj = obj4;
            obj3 = obj5;
            obj2 = obj6;
            sDK_INT = a.b.b[(g)obj.a().ordinal()];
            i2 = 255;
            if (sDK_INT != 1) {
            } else {
            }
            if (q()) {
            }
            i3++;
            this.c.setAlpha(i2);
            canvas.drawRect(this.h, this.c);
            if (sDK_INT != 2) {
            } else {
            }
            if (i3 == 0) {
            }
            if (obj.d()) {
            } else {
            }
            this.p(canvas, matrix2, obj, (a)obj3, (a)obj2);
            this.n(canvas, matrix2, obj, obj3, obj2);
            this.c.setColor(-16777216);
            this.c.setAlpha(i2);
            canvas.drawRect(this.h, this.c);
            if (sDK_INT != 3) {
            } else {
            }
            if (obj.d()) {
            } else {
            }
            this.k(canvas, matrix2, obj, obj3, obj2);
            this.m(canvas, matrix2, obj, obj3, obj2);
            if (sDK_INT != 4) {
            } else {
            }
            if (obj.d()) {
            } else {
            }
            this.j(canvas, matrix2, obj, obj3, obj2);
            this.l(canvas, matrix2, obj, obj3, obj2);
        }
        final String obj10 = "Layer#restoreLayer";
        c.a(obj10);
        canvas.restore();
        c.b(obj10);
    }

    private void p(Canvas canvas, Matrix matrix2, g g3, a<l, Path> a4, a<Integer, Integer> a5) {
        this.a.set((Path)a4.h());
        this.a.transform(matrix2);
        canvas.drawPath(this.a, this.e);
    }

    private boolean q() {
        int i;
        g.a aVar;
        g.a mASK_MODE_NONE;
        final int i3 = 0;
        if (this.p.a().isEmpty()) {
            return i3;
        }
        i = i3;
        while (i < this.p.b().size()) {
            i++;
        }
        return 1;
    }

    private void r() {
        com.airbnb.lottie.v.l.a aVar;
        List list;
        if (this.t != null) {
        }
        if (this.s == null) {
            this.t = Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.t = arrayList;
        aVar = this.s;
        while (aVar != null) {
            this.t.add(aVar);
            aVar = aVar.s;
        }
    }

    private void s(Canvas canvas) {
        final String str = "Layer#clearLayer";
        c.a(str);
        RectF rectF = this.h;
        final int i = 1065353216;
        canvas.drawRect(left - i, top - i, right + i, bottom + i, this.g);
        c.b(str);
    }

    static com.airbnb.lottie.v.l.a u(com.airbnb.lottie.v.l.d d, f f2, d d3) {
        int i;
        switch (i2) {
            case 1:
                f obj4 = new f(f2, d);
                return obj4;
            case 2:
                b bVar = new b(f2, d, d3.n(d.k()), d3);
                return bVar;
            case 3:
                obj4 = new g(f2, d);
                return obj4;
            case 4:
                obj4 = new c(f2, d);
                return obj4;
            case 5:
                obj4 = new e(f2, d);
                return obj4;
            case 6:
                obj4 = new h(f2, d);
                return obj4;
            default:
                StringBuilder obj3 = new StringBuilder();
                obj3.append("Unknown layer type ");
                obj3.append(d.d());
                d.c(obj3.toString());
                return null;
        }
    }

    private void y(RectF rectF, Matrix matrix2) {
        int i3;
        RectF rectF3;
        boolean obj;
        RectF rectF2;
        int i;
        int i2;
        float f2;
        float f;
        float bottom;
        final int i4 = 0;
        this.i.set(i4, i4, i4, i4);
        if (!w()) {
        }
        final int i5 = 0;
        i3 = i5;
        while (i3 < this.p.b().size()) {
            obj = this.p.b().get(i3);
            this.a.set((Path)(a)this.p.a().get(i3).h());
            this.a.transform(matrix2);
            int i6 = a.b.b[(g)obj.a().ordinal()];
            this.a.computeBounds(this.k, i5);
            if (i3 == 0) {
            } else {
            }
            rectF3 = this.i;
            rectF3.set(Math.min(rectF3.left, rectF6.left), Math.min(rectF7.top, rectF8.top), Math.max(rectF9.right, rectF10.right), Math.max(rectF11.bottom, rectF12.bottom));
            i3++;
            this.i.set(this.k);
        }
        if (!rectF.intersect(this.i)) {
            rectF.set(i4, i4, i4, i4);
        }
    }

    private void z(RectF rectF, Matrix matrix2) {
        if (!x()) {
        }
        if (this.o.f() == d.b.INVERT) {
        }
        int i = 0;
        this.j.set(i, i, i, i);
        this.r.d(this.j, matrix2, true);
        if (!rectF.intersect(this.j)) {
            rectF.set(i, i, i, i);
        }
    }

    public void C(a<?, ?> a) {
        this.u.remove(a);
    }

    void D(e e, int i2, List<e> list3, e e4) {
    }

    @Override // com.airbnb.lottie.t.b.e
    void E(com.airbnb.lottie.v.l.a a) {
        this.r = a;
    }

    @Override // com.airbnb.lottie.t.b.e
    void F(boolean z) {
        Paint aVar;
        if (z && this.y == null) {
            if (this.y == null) {
                aVar = new a();
                this.y = aVar;
            }
        }
        this.x = z;
    }

    @Override // com.airbnb.lottie.t.b.e
    void G(com.airbnb.lottie.v.l.a a) {
        this.s = a;
    }

    @Override // com.airbnb.lottie.t.b.e
    void H(float f) {
        int gVar;
        int cmp;
        com.airbnb.lottie.v.l.a aVar;
        int i2;
        Object size;
        int i;
        float obj4;
        this.v.j(f);
        if (this.p != null) {
            gVar = i2;
            while (gVar < this.p.a().size()) {
                (a)this.p.a().get(gVar).m(f);
                gVar++;
            }
        }
        if (Float.compare(f2, i) != 0) {
            f /= cmp;
        }
        c cVar = this.q;
        if (cVar != null) {
            cVar.m(obj4 / f4);
        }
        aVar = this.r;
        if (aVar != null) {
            this.r.H(f3 *= obj4);
        }
        while (i2 < this.u.size()) {
            (a)this.u.get(i2).m(obj4);
            i2++;
        }
    }

    @Override // com.airbnb.lottie.t.b.e
    public void a() {
        A();
    }

    public void b(List<c> list, List<c> list2) {
    }

    public void c(e e, int i2, List<e> list3, e e4) {
        Object aVar2;
        boolean equals;
        boolean z2;
        boolean z;
        boolean z3;
        com.airbnb.lottie.v.l.a aVar;
        int obj5;
        e obj7;
        aVar2 = this.r;
        aVar2 = e4.a(aVar2.getName());
        if (aVar2 != null && e.c(this.r.getName(), i2)) {
            aVar2 = e4.a(aVar2.getName());
            if (e.c(this.r.getName(), i2)) {
                list3.add(aVar2.i(this.r));
            }
            if (e.h(getName(), i2)) {
                this.r.D(e, i += i2, list3, aVar2);
            }
        }
        if (!e.g(getName(), i2)) {
        }
        if (!"__container".equals(getName()) && e.c(getName(), i2)) {
            if (e.c(getName(), i2)) {
                list3.add(e4.a(getName()).i(this));
            }
        }
        if (e.h(getName(), i2)) {
            D(e, i2 += z2, list3, obj7);
        }
    }

    @Override // com.airbnb.lottie.t.b.e
    public void d(RectF rectF, Matrix matrix2, boolean z3) {
        Matrix obj2;
        Matrix obj3;
        Matrix obj4;
        final int i = 0;
        this.h.set(i, i, i, i);
        r();
        this.m.set(matrix2);
        if (z3 != null) {
            obj2 = this.t;
            if (obj2 != null) {
                obj2--;
                while (obj2 >= 0) {
                    this.m.preConcat(obj4.v.f());
                    obj2--;
                }
            } else {
                obj2 = this.s;
                if (obj2 != null) {
                    this.m.preConcat(obj2.v.f());
                }
            }
        }
        this.m.preConcat(this.v.f());
    }

    @Override // com.airbnb.lottie.t.b.e
    public void f(Canvas canvas, Matrix matrix2, int i3) {
        boolean z;
        int intValue;
        boolean z2;
        Object cmp;
        int i2;
        boolean z3;
        boolean str2;
        Matrix matrix3;
        boolean intersect;
        int str;
        Matrix matrix;
        Object paint;
        float f;
        int i;
        boolean obj8;
        int obj9;
        c.a(this.l);
        if (this.w) {
            if (this.o.v()) {
            } else {
                r();
                String str4 = "Layer#parentMatrix";
                c.a(str4);
                this.b.reset();
                this.b.set(matrix2);
                size--;
                while (i2 >= 0) {
                    this.b.preConcat(obj2.v.f());
                    i2--;
                }
                c.b(str4);
                if (this.v.h() == null) {
                    intValue = 100;
                } else {
                    intValue = (Integer)this.v.h().h().intValue();
                }
                int i5 = 1132396544;
                obj9 = (int)obj9;
                str2 = "Layer#drawLayer";
                if (!x() && !w()) {
                    if (!w()) {
                        this.b.preConcat(this.v.f());
                        c.a(str2);
                        t(canvas, this.b, obj9);
                        c.b(str2);
                        B(c.b(this.l));
                    }
                }
                String str5 = "Layer#computeBounds";
                c.a(str5);
                d(this.h, this.b, false);
                z(this.h, matrix2);
                this.b.preConcat(this.v.f());
                y(this.h, this.b);
                i = 0;
                if (!this.h.intersect(i, i, (float)width2, (float)height2)) {
                    this.h.set(i, i, i, i);
                }
                c.b(str5);
                str = 1065353216;
                cmp = "Layer#saveLayer";
                c.a(cmp);
                this.c.setAlpha(255);
                h.m(canvas, this.h, this.c);
                c.b(cmp);
                s(canvas);
                c.a(str2);
                t(canvas, this.b, obj9);
                c.b(str2);
                if (Float.compare(width, str) >= 0 && Float.compare(height, str) >= 0 && w()) {
                    if (Float.compare(height, str) >= 0) {
                        cmp = "Layer#saveLayer";
                        c.a(cmp);
                        this.c.setAlpha(255);
                        h.m(canvas, this.h, this.c);
                        c.b(cmp);
                        s(canvas);
                        c.a(str2);
                        t(canvas, this.b, obj9);
                        c.b(str2);
                        if (w()) {
                            o(canvas, this.b);
                        }
                        str = "Layer#restoreLayer";
                        if (x()) {
                            str2 = "Layer#drawMatte";
                            c.a(str2);
                            c.a(cmp);
                            h.n(canvas, this.h, this.f, 19);
                            c.b(cmp);
                            s(canvas);
                            this.r.f(canvas, matrix2, obj9);
                            c.a(str);
                            canvas.restore();
                            c.b(str);
                            c.b(str2);
                        }
                        c.a(str);
                        canvas.restore();
                        c.b(str);
                    }
                }
                obj8 = this.y;
                if (this.x && obj8 != null) {
                    obj8 = this.y;
                    if (obj8 != null) {
                        obj8.setStyle(Paint.Style.STROKE);
                        this.y.setColor(-251901);
                        this.y.setStrokeWidth(1082130432);
                        canvas.drawRect(this.h, this.y);
                        this.y.setStyle(Paint.Style.FILL);
                        this.y.setColor(1357638635);
                        canvas.drawRect(this.h, this.y);
                    }
                }
            }
            B(c.b(this.l));
        }
        c.b(this.l);
    }

    public <T> void g(T t, c<T> c2) {
        this.v.c(t, c2);
    }

    @Override // com.airbnb.lottie.t.b.e
    public String getName() {
        return this.o.g();
    }

    public void i(a<?, ?> a) {
        if (a == null) {
        }
        this.u.add(a);
    }

    @Override // com.airbnb.lottie.t.b.e
    abstract void t(Canvas canvas, Matrix matrix2, int i3);

    @Override // com.airbnb.lottie.t.b.e
    com.airbnb.lottie.v.l.d v() {
        return this.o;
    }

    @Override // com.airbnb.lottie.t.b.e
    boolean w() {
        g empty;
        int i;
        empty = this.p;
        if (empty != null && !empty.a().isEmpty()) {
            i = !empty.a().isEmpty() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // com.airbnb.lottie.t.b.e
    boolean x() {
        int i;
        i = this.r != null ? 1 : 0;
        return i;
    }
}
