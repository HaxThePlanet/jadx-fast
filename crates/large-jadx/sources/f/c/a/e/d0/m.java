package f.c.a.e.d0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import f.c.a.e.c0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    private final List<f.c.a.e.d0.m.f> g;
    private final List<f.c.a.e.d0.m.g> h;
    private boolean i;

    public static abstract class f {

        protected final Matrix a;
        public f() {
            super();
            Matrix matrix = new Matrix();
            this.a = matrix;
        }

        public abstract void a(Matrix matrix, Path path2);
    }

    static abstract class g {

        static final Matrix a;
        static {
            Matrix matrix = new Matrix();
            m.g.a = matrix;
        }

        public abstract void a(Matrix matrix, a a2, int i3, Canvas canvas4);

        public final void b(a a, int i2, Canvas canvas3) {
            a(m.g.a, a, i2, canvas3);
        }
    }

    class a extends f.c.a.e.d0.m.g {

        final List b;
        final Matrix c;
        a(f.c.a.e.d0.m m, List list2, Matrix matrix3) {
            this.b = list2;
            this.c = matrix3;
            super();
        }

        @Override // f.c.a.e.d0.m$g
        public void a(Matrix matrix, a a2, int i3, Canvas canvas4) {
            Object next;
            Matrix matrix2;
            Iterator obj3 = this.b.iterator();
            for (m.g next : obj3) {
                next.a(this.c, a2, i3, canvas4);
            }
        }
    }

    static class b extends f.c.a.e.d0.m.g {

        private final f.c.a.e.d0.m.d b;
        public b(f.c.a.e.d0.m.d m$d) {
            super();
            this.b = d;
        }

        @Override // f.c.a.e.d0.m$g
        public void a(Matrix matrix, a a2, int i3, Canvas canvas4) {
            RectF rectF = new RectF(m.d.b(this.b), m.d.c(this.b), m.d.d(this.b), m.d.e(this.b));
            a2.a(canvas4, matrix, rectF, i3, m.d.h(this.b), m.d.i(this.b));
        }
    }

    static class c extends f.c.a.e.d0.m.g {

        private final f.c.a.e.d0.m.e b;
        private final float c;
        private final float d;
        public c(f.c.a.e.d0.m.e m$e, float f2, float f3) {
            super();
            this.b = e;
            this.c = f2;
            this.d = f3;
        }

        @Override // f.c.a.e.d0.m$g
        public void a(Matrix matrix, a a2, int i3, Canvas canvas4) {
            f4 -= f6;
            int i4 = 0;
            RectF rectF = new RectF(i4, i4, (float)hypot, i4);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.c, this.d);
            matrix2.preRotate(c());
            a2.b(canvas4, matrix2, rectF, i3);
        }

        @Override // f.c.a.e.d0.m$g
        float c() {
            f4 -= f5;
            return (float)degrees;
        }
    }

    public static class d extends f.c.a.e.d0.m.f {

        private static final RectF h;
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
        static {
            RectF rectF = new RectF();
            m.d.h = rectF;
        }

        public d(float f, float f2, float f3, float f4) {
            super();
            q(f);
            u(f2);
            r(f3);
            p(f4);
        }

        static float b(f.c.a.e.d0.m.d m$d) {
            return d.k();
        }

        static float c(f.c.a.e.d0.m.d m$d) {
            return d.o();
        }

        static float d(f.c.a.e.d0.m.d m$d) {
            return d.l();
        }

        static float e(f.c.a.e.d0.m.d m$d) {
            return d.j();
        }

        static void f(f.c.a.e.d0.m.d m$d, float f2) {
            d.s(f2);
        }

        static void g(f.c.a.e.d0.m.d m$d, float f2) {
            d.t(f2);
        }

        static float h(f.c.a.e.d0.m.d m$d) {
            return d.m();
        }

        static float i(f.c.a.e.d0.m.d m$d) {
            return d.n();
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
        public void a(Matrix matrix, Path path2) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path2.transform(matrix2);
            RectF rectF = m.d.h;
            rectF.set(k(), o(), l(), j());
            path2.arcTo(rectF, m(), n(), false);
            path2.transform(matrix);
        }
    }

    public static class e extends f.c.a.e.d0.m.f {

        private float b;
        private float c;
        static float b(f.c.a.e.d0.m.e m$e) {
            return e.b;
        }

        static float c(f.c.a.e.d0.m.e m$e, float f2) {
            e.b = f2;
            return f2;
        }

        static float d(f.c.a.e.d0.m.e m$e) {
            return e.c;
        }

        static float e(f.c.a.e.d0.m.e m$e, float f2) {
            e.c = f2;
            return f2;
        }

        @Override // f.c.a.e.d0.m$f
        public void a(Matrix matrix, Path path2) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path2.transform(matrix2);
            path2.lineTo(this.b, this.c);
            path2.transform(matrix);
        }
    }
    public m() {
        super();
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.h = arrayList2;
        int i = 0;
        n(i, i);
    }

    private void b(float f) {
        if (Float.compare(f2, f) == 0) {
        }
        int i4 = 1135869952;
        i2 %= i4;
        if (Float.compare(i3, i5) > 0) {
        }
        m.d dVar = new m.d(i(), j(), i(), j());
        m.d.f(dVar, g());
        m.d.g(dVar, i3);
        m.b bVar = new m.b(dVar);
        this.h.add(bVar);
        p(f);
    }

    private void c(f.c.a.e.d0.m.g m$g, float f2, float f3) {
        b(f2);
        this.h.add(g);
        p(f3);
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
        int i;
        float obj9;
        int obj10;
        m.d dVar = new m.d(f, f2, f3, f4);
        m.d.f(dVar, f5);
        m.d.g(dVar, f6);
        this.g.add(dVar);
        m.b bVar = new m.b(dVar);
        int i2 = f5 + f6;
        obj10 = Float.compare(f6, i3) < 0 ? 1 : 0;
        int i4 = 1135869952;
        int i5 = 1127481344;
        if (obj10 != null) {
            obj9 %= i4;
        }
        i = obj10 != null ? i6 % i4 : i2;
        c(bVar, obj9, i);
        obj10 = 1056964608;
        int obj5 = 1073741824;
        double d = (double)i2;
        r(obj9 += obj7);
        s(obj7 += obj8);
    }

    public void d(Matrix matrix, Path path2) {
        int i;
        Object obj;
        i = 0;
        while (i < this.g.size()) {
            (m.f)this.g.get(i).a(matrix, path2);
            i++;
        }
    }

    boolean e() {
        return this.i;
    }

    f.c.a.e.d0.m.g f(Matrix matrix) {
        b(h());
        Matrix matrix2 = new Matrix(matrix);
        ArrayList obj3 = new ArrayList(this.h);
        m.a aVar = new m.a(this, obj3, matrix2);
        return aVar;
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
        m.e eVar = new m.e();
        m.e.c(eVar, f);
        m.e.e(eVar, f2);
        this.g.add(eVar);
        m.c cVar = new m.c(eVar, i(), j());
        int i2 = 1132920832;
        c(cVar, f3 += i2, f6 += i2);
        r(f);
        s(f2);
    }

    public void n(float f, float f2) {
        o(f, f2, 1132920832, 0);
    }

    public void o(float f, float f2, float f3, float f4) {
        t(f);
        u(f2);
        r(f);
        s(f2);
        p(f3);
        q(obj3 %= obj1);
        this.g.clear();
        this.h.clear();
        this.i = false;
    }
}
