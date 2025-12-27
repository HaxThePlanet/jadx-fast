package f.c.a.e.d0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import f.c.a.e.c0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ShapePath.java */
/* loaded from: classes2.dex */
public class m {

    @Deprecated
    public float a;
    @Deprecated
    public float b;
    @Deprecated
    public float c;
    @Deprecated
    public float d;
    @Deprecated
    public float e;
    @Deprecated
    public float f;
    private final List<m.f> g = new ArrayList<>();
    private final List<m.g> h = new ArrayList<>();
    private boolean i;

    public static abstract class f {

        protected final Matrix a = new Matrix();
        public f() {
            super();
            final Matrix matrix = new Matrix();
        }

        public abstract void a(Matrix matrix, Path path);
    }

    static abstract class g {

        static final Matrix a = new Matrix();

        g() {
            super();
        }

        public final void b(a aVar, int i, Canvas canvas) {
            a(m.g.a, aVar, i, canvas);
        }

        public abstract void a(Matrix matrix, a aVar, int i, Canvas canvas);
    }

    class a extends m.g {

        final /* synthetic */ List b;
        final /* synthetic */ Matrix c;
        a(List list, Matrix matrix) {
            this.b = list;
            this.c = matrix;
            super();
        }

        @Override // f.c.a.e.d0.m$g
        public void a(Matrix matrix, a aVar, int i, Canvas canvas) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                (m.g)it.next().a(this.c, aVar, i, canvas);
            }
        }
    }

    static class b extends m.g {

        private final m.d b;
        public b(m.d dVar) {
            super();
            this.b = dVar;
        }

        @Override // f.c.a.e.d0.m$g
        public void a(Matrix matrix, a aVar, int i, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.b.k(), this.b.o(), this.b.l(), this.b.j()), i, this.b.m(), this.b.n());
        }
    }

    static class c extends m.g {

        private final m.e b;
        private final float c;
        private final float d;
        public c(m.e eVar, float f, float f2) {
            super();
            this.b = eVar;
            this.c = f;
            this.d = f2;
        }

        @Override // f.c.a.e.d0.m$g
        public void a(Matrix matrix, a aVar, int i, Canvas canvas) {
            float f6 = this.b.b - this.c;
            float f7 = 0.0f;
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.c, this.d);
            matrix2.preRotate(c());
            aVar.b(canvas, matrix2, new RectF(f7, f7, (float)(Math.hypot((double)(this.b.c - this.d), (double)f6)), f7), i);
        }

        @Override // f.c.a.e.d0.m$g
        float c() {
            float f7 = this.b.b - this.c;
            return (float)(Math.toDegrees(Math.atan((double)(this.b.c - this.d) / f7)));
        }
    }

    public static class d extends m.f {

        private static final RectF h = new RectF();
        @Deprecated
        public float b;
        @Deprecated
        public float c;
        @Deprecated
        public float d;
        @Deprecated
        public float e;
        @Deprecated
        public float f;
        @Deprecated
        public float g;

        public d(float f, float f2, float f3, float f4) {
            super();
            q(f);
            u(f2);
            r(f3);
            p(f4);
        }

        static /* synthetic */ float b(m.d dVar) {
            return dVar.k();
        }

        static /* synthetic */ float c(m.d dVar) {
            return dVar.o();
        }

        static /* synthetic */ float d(m.d dVar) {
            return dVar.l();
        }

        static /* synthetic */ float e(m.d dVar) {
            return dVar.j();
        }

        static /* synthetic */ void f(m.d dVar, float f) {
            dVar.s(f);
        }

        static /* synthetic */ void g(m.d dVar, float f) {
            dVar.t(f);
        }

        static /* synthetic */ float h(m.d dVar) {
            return dVar.m();
        }

        static /* synthetic */ float i(m.d dVar) {
            return dVar.n();
        }

        private float j() {
            return this.e;
        }

        private float k() {
            return this.b;
        }

        private float l() {
            return this.d;
        }

        private float m() {
            return this.f;
        }

        private float n() {
            return this.g;
        }

        private float o() {
            return this.c;
        }

        private void p(float f) {
            this.e = f;
        }

        private void q(float f) {
            this.b = f;
        }

        private void r(float f) {
            this.d = f;
        }

        private void s(float f) {
            this.f = f;
        }

        private void t(float f) {
            this.g = f;
        }

        private void u(float f) {
            this.c = f;
        }

        @Override // f.c.a.e.d0.m$f
        public void a(Matrix matrix, Path path) {
            matrix.invert(this.a);
            path.transform(this.a);
            RectF rectF = m.d.h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    public static class e extends m.f {

        private float b;
        private float c;
        static /* synthetic */ float b(m.e eVar) {
            return eVar.b;
        }

        static /* synthetic */ float c(m.e eVar, float f) {
            eVar.b = f;
            return f;
        }

        static /* synthetic */ float d(m.e eVar) {
            return eVar.c;
        }

        static /* synthetic */ float e(m.e eVar, float f) {
            eVar.c = f;
            return f;
        }

        @Override // f.c.a.e.d0.m$f
        public void a(Matrix matrix, Path path) {
            matrix.invert(this.a);
            path.transform(this.a);
            path.lineTo(this.b, this.c);
            path.transform(matrix);
        }
    }
    public m() {
        super();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        float f = 0.0f;
        n(f, f);
    }

    private void b(float f) {
        float f2 = g();
        if (f2 == f) {
            return;
        }
        float f7 = 360f;
        float f6 = (f - g()) + f7 % f7;
        if (f6 > 1127481344) {
            return;
        }
        f.c.a.e.d0.m.d dVar = new m.d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(f6);
        this.h.add(new m.b(dVar));
        p(f);
    }

    private void c(m.g gVar, float f, float f2) {
        b(f);
        this.h.add(gVar);
        p(f2);
    }

    private float g() {
        return this.e;
    }

    private float h() {
        return this.f;
    }

    private void p(float f) {
        this.e = f;
    }

    private void q(float f) {
        this.f = f;
    }

    private void r(float f) {
        this.c = f;
    }

    private void s(float f) {
        this.d = f;
    }

    private void t(float f) {
        this.a = f;
    }

    private void u(float f) {
        this.b = f;
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8;
        int i = 0;
        f.c.a.e.d0.m.d dVar = new m.d(f, f2, f3, f4);
        dVar.s(f5);
        dVar.t(f6);
        this.g.add(dVar);
        f.c.a.e.d0.m.b bVar = new m.b(dVar);
        f7 = f5 + f6;
        f6 = f6 < 0 ? 1 : 0;
        float f9 = 360f;
        float f11 = 180f;
        if (i != 0) {
            f8 = (f5 + f11) % f9;
        }
        f7 = i != 0 ? f12 % f9 : f7;
        c(bVar, f8, f7);
        float f28 = 0.5f;
        float f13 = 2f;
        double d = (double)f7;
        r((f + f3) * f28 + (f3 - f) / f13 * (float)Math.cos(Math.toRadians(d)));
        s((f2 + f4) * f28 + (f4 - f2) / f13 * (float)Math.sin(Math.toRadians(d)));
    }

    public void d(Matrix matrix, Path path) {
        int i = 0;
        i = 0;
        while (i < this.g.size()) {
            (m.f)this.g.get(i).a(matrix, path);
            i = i + 1;
        }
    }

    boolean e() {
        return this.i;
    }

    m.g f(Matrix matrix) {
        b(h());
        return new m.a(this, new ArrayList(this.h), new Matrix(matrix));
    }

    float i() {
        return this.c;
    }

    float j() {
        return this.d;
    }

    float k() {
        return this.a;
    }

    float l() {
        return this.b;
    }

    public void m(float f, float f2) {
        f.c.a.e.d0.m.e eVar = new m.e();
        eVar.b = f;
        eVar.c = f2;
        this.g.add(eVar);
        f.c.a.e.d0.m.c cVar = new m.c(eVar, i(), j());
        float f6 = 270f;
        c(cVar, cVar.c() + f6, cVar.c() + f6);
        r(f);
        s(f2);
    }

    public void n(float f, float f2) {
        o(f, f2, 270f, 0.0f);
    }

    public void o(float f, float f2, float f3, float f4) {
        t(f);
        u(f2);
        r(f);
        s(f2);
        p(f3);
        q((f3 + f4) % 360f);
        this.g.clear();
        this.h.clear();
        this.i = false;
    }
}
