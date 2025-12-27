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
import com.airbnb.lottie.n;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.t.c.o;
import com.airbnb.lottie.v.k.g.a;
import com.airbnb.lottie.y.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: BaseLayer.java */
/* loaded from: classes.dex */
public abstract class a implements com.airbnb.lottie.t.b.e, a.b, com.airbnb.lottie.v.f {

    private final Path a = new Path();
    private final Matrix b = new Matrix();
    private final Paint c = new a(1);
    private final Paint d = new a();
    private final Paint e = new a();
    private final Paint f = new a(1);
    private final Paint g = new a();
    private final RectF h = new RectF();
    private final RectF i = new RectF();
    private final RectF j = new RectF();
    private final RectF k = new RectF();
    private final String l;
    final Matrix m = new Matrix();
    final com.airbnb.lottie.f n;
    final d o;
    private com.airbnb.lottie.t.c.g p = new g();
    private com.airbnb.lottie.t.c.c q;
    private a r;
    private a s;
    private List<a> t;
    private final List<com.airbnb.lottie.t.c.a<?, ?>> u = new ArrayList<>();
    final o v;
    private boolean w = true;
    private boolean x;
    private Paint y;

    static class b {

        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static {
            int[] iArr = new int[g.a.values().length];
            a.b.b = iArr;
            int i2 = 1;
            try {
                iArr[g.a.MASK_MODE_NONE.ordinal()] = i2;
            } catch (java.lang.NoSuchFieldError unused) {
                int i3 = 3;
                int i7 = 4;
                int[] iArr11 = new int[d.a.values().length];
                a.b.a = iArr11;
                return;
            }
            int i = 2;
            try {
                a.b.b[g.a.MASK_MODE_SUBTRACT.ordinal()] = i;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    class a implements a.b {

        final /* synthetic */ a a;
        a() {
            this.a = aVar;
            super();
        }

        public void a() {
            boolean z = true;
            float f = this.a.q.p();
            int r1 = f == 1065353216 ? 1 : 0;
            this.a.I((f == 1065353216 ? 1 : 0));
        }
    }
    a(com.airbnb.lottie.f fVar, d dVar) {
        super();
        Path path = new Path();
        Matrix matrix = new Matrix();
        int i = 1;
        com.airbnb.lottie.t.a aVar = new a(i);
        com.airbnb.lottie.t.a aVar2 = new a(i, PorterDuff.Mode.DST_IN);
        com.airbnb.lottie.t.a aVar3 = new a(i, PorterDuff.Mode.DST_OUT);
        com.airbnb.lottie.t.a aVar4 = new a(i);
        com.airbnb.lottie.t.a aVar5 = new a(PorterDuff.Mode.CLEAR);
        RectF rectF = new RectF();
        RectF rectF2 = new RectF();
        RectF rectF3 = new RectF();
        RectF rectF4 = new RectF();
        Matrix matrix2 = new Matrix();
        ArrayList arrayList = new ArrayList();
        this.n = fVar;
        this.o = dVar;
        StringBuilder stringBuilder = new StringBuilder();
        String str = dVar.g();
        String str2 = "#draw";
        str3 = str + str2;
        this.l = str3;
        if (dVar.f() == d.b.INVERT) {
            aVar4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            aVar4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        o oVar = dVar.u().b();
        this.v = oVar;
        oVar.b(this);
        if (dVar.e() != null) {
            if (!dVar.e().isEmpty()) {
                Iterator it = new g(dVar.e()).a().iterator();
                while (it.hasNext()) {
                    (a)it.next().a(this);
                }
                Iterator it2 = this.p.c().iterator();
                while (it2.hasNext()) {
                    Object item2 = it2.next();
                    i(item2);
                    item2.a(this);
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
        boolean z = false;
        z = true;
        if (!this.o.c().isEmpty()) {
            com.airbnb.lottie.t.c.c cVar = new c(this.o.c());
            this.q = cVar;
            cVar.l();
            this.q.a(new a.a(this));
            float value = (Float)this.q.h().floatValue();
            float f = 1f;
            if (value != f) {
                int i = 0;
            }
            I(z);
            i(this.q);
        } else {
            I(true);
        }
    }

    static /* synthetic */ com.airbnb.lottie.t.c.c e(a aVar) {
        return aVar.q;
    }

    static /* synthetic */ void h(a aVar, boolean z) {
        aVar.I(z);
    }

    private void j(Canvas canvas, Matrix matrix, com.airbnb.lottie.v.k.g gVar, com.airbnb.lottie.t.c.a<com.airbnb.lottie.v.k.l, Path> aVar, com.airbnb.lottie.t.c.a<Integer, Integer> aVar2) {
        this.a.set((Path)aVar.h());
        this.a.transform(matrix);
        this.c.setAlpha((int)(float)(Integer)aVar2.h().intValue() * 2.55f);
        canvas.drawPath(this.a, this.c);
    }

    private void k(Canvas canvas, Matrix matrix, com.airbnb.lottie.v.k.g gVar, com.airbnb.lottie.t.c.a<com.airbnb.lottie.v.k.l, Path> aVar, com.airbnb.lottie.t.c.a<Integer, Integer> aVar2) {
        h.m(canvas, this.h, this.d);
        this.a.set((Path)aVar.h());
        this.a.transform(matrix);
        this.c.setAlpha((int)(float)(Integer)aVar2.h().intValue() * 2.55f);
        canvas.drawPath(this.a, this.c);
        canvas.restore();
    }

    private void l(Canvas canvas, Matrix matrix, com.airbnb.lottie.v.k.g gVar, com.airbnb.lottie.t.c.a<com.airbnb.lottie.v.k.l, Path> aVar, com.airbnb.lottie.t.c.a<Integer, Integer> aVar2) {
        h.m(canvas, this.h, this.c);
        canvas.drawRect(this.h, this.c);
        this.a.set((Path)aVar.h());
        this.a.transform(matrix);
        this.c.setAlpha((int)(float)(Integer)aVar2.h().intValue() * 2.55f);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, com.airbnb.lottie.v.k.g gVar, com.airbnb.lottie.t.c.a<com.airbnb.lottie.v.k.l, Path> aVar, com.airbnb.lottie.t.c.a<Integer, Integer> aVar2) {
        h.m(canvas, this.h, this.d);
        canvas.drawRect(this.h, this.c);
        this.e.setAlpha((int)(float)(Integer)aVar2.h().intValue() * 2.55f);
        this.a.set((Path)aVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, com.airbnb.lottie.v.k.g gVar, com.airbnb.lottie.t.c.a<com.airbnb.lottie.v.k.l, Path> aVar, com.airbnb.lottie.t.c.a<Integer, Integer> aVar2) {
        h.m(canvas, this.h, this.e);
        canvas.drawRect(this.h, this.c);
        this.e.setAlpha((int)(float)(Integer)aVar2.h().intValue() * 2.55f);
        this.a.set((Path)aVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix) {
        int i = 0;
        int sDK_INT2;
        int i2 = 255;
        int i3 = 1;
        Matrix matrix22;
        String str = "Layer#saveLayer";
        c.a(str);
        i3 = 19;
        h.n(canvas, this.h, this.d, i3);
        i2 = 28;
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        c.b(str);
        i = 0;
        while (i < this.p.b().size()) {
            gVar = this.p.b().get(i);
            aVar = this.p.a().get(i);
            aVar2 = this.p.c().get(i);
            sDK_INT2 = a.b.b[gVar.a().ordinal()];
            i2 = 255;
            i3 = 1;
            i = i + 1;
        }
        final String str2 = "Layer#restoreLayer";
        c.a(str2);
        canvas.restore();
        c.b(str2);
    }

    private void p(Canvas canvas, Matrix matrix, com.airbnb.lottie.v.k.g gVar, com.airbnb.lottie.t.c.a<com.airbnb.lottie.v.k.l, Path> aVar, com.airbnb.lottie.t.c.a<Integer, Integer> aVar2) {
        this.a.set((Path)aVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
    }

    private boolean q() {
        int i;
        i = 0;
        if (this.p.a().isEmpty()) {
            return false;
        }
        while (this.p < this.p.b().size()) {
            if ((g)this.p.b().get(i).a() != g.a.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void r() {
        com.airbnb.lottie.v.l.a aVar;
        if (this.t != null) {
            return;
        }
        if (this.s == null) {
            this.t = Collections.emptyList();
            return;
        }
        this.t = new ArrayList();
        while (this.s != null) {
            this.t.add(aVar);
        }
    }

    private void s(Canvas canvas) {
        final String str = "Layer#clearLayer";
        c.a(str);
        final float f = 1f;
        canvas.drawRect(rectF.left - f, rectF.top - f, rectF.right + f, rectF.bottom + f, this.g);
        c.b(str);
    }

    static a u(d dVar, com.airbnb.lottie.f fVar, com.airbnb.lottie.d dVar2) {
        switch (a.b.a[dVar.d().ordinal()]) {
            case 1: /* ordinal */
                return new f(fVar, dVar);
            case 2: /* ordinal */
                return new b(fVar, dVar, dVar2.n(dVar.k()), dVar2);
            case 3: /* ordinal */
                return new g(fVar, dVar);
            case 4: /* ordinal */
                return new c(fVar, dVar);
            case 5: /* ordinal */
                return new e(fVar, dVar);
            case 6: /* ordinal */
                return new h(fVar, dVar);
            default:
                final StringBuilder stringBuilder = new StringBuilder();
                String str3 = "Unknown layer type ";
                com.airbnb.lottie.v.l.d.a aVar2 = dVar.d();
                str2 = str3 + aVar2;
                d.c(str3 + aVar2);
                return null;
        }
    }

    private void y(RectF rectF, Matrix matrix) {
        int i;
        RectF rectF2;
        RectF rectF3;
        int i2 = 4;
        float max;
        float max2;
        float bottom2;
        final float f = 0.0f;
        this.i.set(f, f, f, f);
        if (!w()) {
            return;
        }
        final boolean z3 = false;
        i = z3;
        while (i < this.p.b().size()) {
            Object item = this.p.b().get(i);
            this.a.set((Path)(a)this.p.a().get(i).h());
            this.a.transform(matrix);
            int i4 = a.b.b[item.a().ordinal()];
            int i3 = 1;
            i3 = 2;
            i2 = 3;
            if (this.a == 3) {
            }
        }
        if (!rectF.intersect(this.i)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void z(RectF rectF, Matrix matrix) {
        if (!x()) {
            return;
        }
        if (this.o.f() == d.b.INVERT) {
            return;
        }
        float f = 0.0f;
        this.j.set(f, f, f, f);
        this.r.d(this.j, matrix, true);
        if (!rectF.intersect(this.j)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void C(com.airbnb.lottie.t.c.a<?, ?> aVar) {
        this.u.remove(aVar);
    }

    void E(a aVar) {
        this.r = aVar;
    }

    void F(boolean z) {
        if (z && this.y == null) {
            this.y = new a();
        }
        this.x = z;
    }

    void G(a aVar) {
        this.s = aVar;
    }

    void H(float f) {
        int i;
        float f2 = 0;
        float f3;
        this.v.j(f);
        i = 0;
        if (this.p != null) {
            while (this.v < this.p.a().size()) {
                (a)this.p.a().get(i).m(f);
                i = i + 1;
            }
        }
        float f4 = this.o.t();
        f2 = 0.0f;
        if (f4 != 0.0f) {
            f3 = f / this.o.t();
        }
        if (this.q != null) {
            f2 = f3 / this.o.t();
            this.q.m(f2);
        }
        if (this.r != null) {
            this.r.H(item.o.t() * f3);
        }
        while (i < this.u.size()) {
            (a)this.u.get(i).m(f3);
            i = i + 1;
        }
    }

    public void a() {
        A();
    }

    public void c(com.airbnb.lottie.v.e eVar, int i, List<com.airbnb.lottie.v.e> list, com.airbnb.lottie.v.e eVar2) {
        if (this.r != null) {
            com.airbnb.lottie.v.e eVar5 = eVar2.a(this.r.getName());
            if (eVar.c(this.r.getName(), i)) {
                list.add(eVar5.i(this.r));
            }
            if (eVar.h(getName(), i)) {
                this.r.D(eVar, (eVar.e(this.r.getName(), i)) + i, list, eVar5);
            }
        }
        if (!eVar.g(getName(), i)) {
            return;
        }
        if (!"__container".equals(getName()) && eVar.c(this.getName(), i)) {
            list.add(eVar2.a(this.getName()).i(this));
        }
        if (eVar.h(getName(), i)) {
            i = i + (eVar.e(getName(), i));
            D(eVar, i, list, eVar2);
        }
    }

    public void d(RectF rectF, Matrix matrix, boolean z) {
        int i;
        Matrix matrix3;
        Matrix matrix4;
        final float f = 0.0f;
        this.h.set(f, f, f, f);
        r();
        this.m.set(matrix);
        if (z && this.t != null) {
            i = this.t.size() - 1;
            while (this.h >= 0) {
                this.m.preConcat((a)this.t.get(i).v.f());
                i = i - 1;
            }
        }
        this.m.preConcat(this.v.f());
    }

    public void f(Canvas canvas, Matrix matrix, int i) {
        int value = 100;
        String str;
        boolean z4;
        Paint paint;
        float f3;
        float f4 = 0;
        c.a(this.l);
        if (this.w) {
            if (!this.o.v()) {
                r();
                String str4 = "Layer#parentMatrix";
                c.a(str4);
                this.b.reset();
                this.b.set(matrix);
                i = this.t.size() - 1;
                while (this.t >= 0) {
                    this.b.preConcat((a)this.t.get(i).v.f());
                    i = i - 1;
                }
                c.b(str4);
                if (this.v.h() == null) {
                    value = 100;
                } else {
                    value = (Integer)this.v.h().h().intValue();
                }
                float f6 = 255f;
                i2 = (int)(float)i / f6 * (float)value / 100f * f6;
                str2 = "Layer#drawLayer";
                if (!x() && !this.w()) {
                    this.b.preConcat(this.v.f());
                    c.a(str2);
                    t(canvas, this.b, i2);
                    c.b(str2);
                    B(c.b(this.l));
                    return;
                }
                String str5 = "Layer#computeBounds";
                c.a(str5);
                d(this.h, this.b, false);
                z(this.h, matrix);
                this.b.preConcat(this.v.f());
                y(this.h, this.b);
                f2 = (float)canvas.getWidth();
                f3 = (float)canvas.getHeight();
                f4 = 0.0f;
                if (!this.h.intersect(f4, f4, f2, f3)) {
                    this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
                }
                c.b(str5);
                float width = this.h.width();
                float f = 1f;
                if (width >= f && height >= f) {
                    str = "Layer#saveLayer";
                    c.a(str);
                    this.c.setAlpha(255);
                    h.m(canvas, this.h, this.c);
                    c.b(str);
                    s(canvas);
                    c.a(str2);
                    t(canvas, this.b, i2);
                    c.b(str2);
                    if (w()) {
                        o(canvas, this.b);
                    }
                    String str7 = "Layer#restoreLayer";
                    if (x()) {
                        String str6 = "Layer#drawMatte";
                        c.a(str6);
                        c.a(str);
                        h.n(canvas, this.h, this.f, 19);
                        c.b(str);
                        s(canvas);
                        this.r.f(canvas, matrix, i2);
                        c.a(str7);
                        canvas.restore();
                        c.b(str7);
                        c.b(str6);
                    }
                    c.a(str7);
                    canvas.restore();
                    c.b(str7);
                }
                if (this.x && this.y != null) {
                    this.y.setStyle(Paint.Style.STROKE);
                    this.y.setColor(-251901);
                    this.y.setStrokeWidth(4f);
                    canvas.drawRect(this.h, this.y);
                    this.y.setStyle(Paint.Style.FILL);
                    this.y.setColor(1357638635);
                    canvas.drawRect(this.h, this.y);
                }
            }
            B(c.b(this.l));
            return;
        }
        c.b(this.l);
    }

    public <T> void g(T t, com.airbnb.lottie.z.c<T> cVar) {
        this.v.c(t, cVar);
    }

    public String getName() {
        return this.o.g();
    }

    public void i(com.airbnb.lottie.t.c.a<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.u.add(aVar);
    }

    d v() {
        return this.o;
    }

    boolean w() {
        boolean z = false;
        if (this.p != null) {
            int r0 = !this.p.a().isEmpty() ? 1 : 0;
        }
        return (!this.p.a().isEmpty() ? 1 : 0);
    }

    boolean x() {
        boolean z = true;
        int r0 = this.r != null ? 1 : 0;
        return (this.r != null ? 1 : 0);
    }

    void D(com.airbnb.lottie.v.e eVar, int i, List<com.airbnb.lottie.v.e> list, com.airbnb.lottie.v.e eVar2) {
    }

    public void b(List<com.airbnb.lottie.t.b.c> list, List<com.airbnb.lottie.t.b.c> list2) {
    }

    abstract void t(Canvas canvas, Matrix matrix, int i);
}
