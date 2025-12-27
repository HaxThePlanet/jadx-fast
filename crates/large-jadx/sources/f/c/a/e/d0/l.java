package f.c.a.e.d0;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build.VERSION;

/* compiled from: ShapeAppearancePathProvider.java */
/* loaded from: classes2.dex */
public class l {

    private final m[] a;
    private final Matrix[] b;
    private final Matrix[] c;
    private final PointF d = new PointF();
    private final Path e = new Path();
    private final Path f = new Path();
    private final m g = new m();
    private final float[] h;
    private final float[] i;
    private final Path j = new Path();
    private final Path k = new Path();
    private boolean l = true;

    private static class a {

        static final l a = new l();
    }

    public interface b {
        void a(m mVar, Matrix matrix, int i);

        void b(m mVar, Matrix matrix, int i);
    }

    static final class c {

        public final k a;
        public final Path b;
        public final RectF c;
        public final l.b d;
        public final float e;
        c(k kVar, float f, RectF rectF, l.b bVar, Path path) {
            super();
            this.d = bVar;
            this.a = kVar;
            this.e = f;
            this.c = rectF;
            this.b = path;
        }
    }
    public l() {
        int i = 0;
        super();
        final int i2 = 4;
        this.a = new m[i2];
        this.b = new Matrix[i2];
        this.c = new Matrix[i2];
        PointF pointF = new PointF();
        Path path = new Path();
        Path path2 = new Path();
        f.c.a.e.d0.m mVar = new m();
        int i3 = 2;
        this.h = new float[i3];
        this.i = new float[i3];
        Path path3 = new Path();
        Path path4 = new Path();
        i = 0;
        while (i < i2) {
            this.a[i] = new m();
            this.b[i] = new Matrix();
            this.c[i] = new Matrix();
            i = i + 1;
        }
    }

    private void b(l.c cVar, int i) {
        i = 0;
        this.h[i] = this.a[i].k();
        final int i3 = 1;
        this.h[i3] = this.a[i].l();
        this.b[i].mapPoints(this.h);
        if (i == 0) {
            cVar.b.moveTo(fArr4[i], fArr4[i3]);
        } else {
            cVar.b.lineTo(fArr5[i], fArr5[i3]);
        }
        this.a[i].d(this.b[i], cVar.b);
        if (cVar.d != null) {
            cVar.d.a(this.a[i], this.b[i], i);
        }
    }

    private void c(l.c cVar, int i) {
        f.c.a.e.d0.m mVar;
        Matrix matrix;
        Matrix matrix2;
        i = (i + 1) % 4;
        final int i5 = 0;
        this.h[i5] = this.a[i].i();
        final int i6 = 1;
        this.h[i6] = this.a[i].j();
        this.b[i].mapPoints(this.h);
        this.i[i5] = this.a[i].k();
        this.i[i6] = this.a[i].l();
        this.b[i].mapPoints(this.i);
        float f14 = fArr12[i6];
        float f15 = 0.0f;
        this.g.n(f15, f15);
        f.c.a.e.d0.f fVar = j(i, cVar.a);
        fVar.b(Math.max((float)(Math.hypot((double)(fArr7[i5] - fArr12[i5]), (double)(fArr7[i6] - f14))) - 0.001f, f15), i(cVar.c, i), cVar.e, this.g);
        this.j.reset();
        this.g.d(this.c[i], this.j);
        if (this.l) {
            if (Build.VERSION.SDK_INT < 19 || !fVar.a()) {
                this.g.d(this.c[i], cVar.b);
            } else {
                if (!l(this.j, i)) {
                    if (l(this.j, i)) {
                        this.j.op(this.j, this.f, Path.Op.DIFFERENCE);
                        this.h[i5] = this.g.k();
                        this.h[i6] = this.g.l();
                        this.c[i].mapPoints(this.h);
                        this.e.moveTo(fArr9[i5], fArr9[i6]);
                        this.g.d(this.c[i], this.e);
                    }
                }
            }
        }
        if (cVar.d != null) {
            cVar.d.b(this.g, this.c[i], i);
        }
    }

    private void f(int i, RectF rectF, PointF pointF) {
        int i2 = 1;
        if (i == 1) {
            pointF.set(rectF.right, rectF.bottom);
        } else {
            i2 = 2;
            if (rectF.right == 2) {
                pointF.set(rectF.left, rectF.bottom);
            } else {
                i2 = 3;
                if (rectF.right != 3) {
                    pointF.set(rectF.right, rectF.top);
                } else {
                    pointF.set(rectF.left, rectF.top);
                }
            }
        }
    }

    private c g(int i, k kVar) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return kVar.t();
            }
            return kVar.r();
        }
        return kVar.l();
    }

    private d h(int i, k kVar) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return kVar.s();
            }
            return kVar.q();
        }
        return kVar.k();
    }

    private float i(RectF rectF, int i) {
        final int i4 = 0;
        this.h[i4] = objArr[i].c;
        int i3 = 1;
        this.h[i3] = objArr[i].d;
        this.b[i].mapPoints(this.h);
        if (i != i3 && i != 3) {
            return Math.abs(rectF.centerY() - this.h[i3]);
        }
        return Math.abs(rectF.centerX() - this.h[i4]);
    }

    private f j(int i, k kVar) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return kVar.o();
            }
            return kVar.p();
        }
        return kVar.h();
    }

    public static l k() {
        return l.a.a;
    }

    private boolean l(Path path, int i) {
        boolean z = true;
        int cmp;
        this.k.reset();
        this.a[i].d(this.b[i], this.k);
        RectF rectF = new RectF();
        z = true;
        path.computeBounds(rectF, z);
        this.k.computeBounds(rectF, z);
        path.op(this.k, Path.Op.INTERSECT);
        path.computeBounds(rectF, z);
        if (rectF.isEmpty()) {
            float width = rectF.width();
            float f = 1f;
            if (width > f) {
                float height = rectF.height();
                if (height <= f) {
                    i = 0;
                }
            }
        }
        return z;
    }

    private void m(l.c cVar, int i) {
        h(i, cVar.a).b(this.a[i], 90f, cVar.e, cVar.c, g(i, cVar.a));
        this.b[i].reset();
        f(i, cVar.c, this.d);
        this.b[i].setTranslate(pointF2.x, pointF2.y);
        this.b[i].preRotate(a(i));
    }

    private void n(int i) {
        int i2 = 0;
        this.h[i2] = this.a[i].i();
        int i3 = 1;
        this.h[i3] = this.a[i].j();
        this.b[i].mapPoints(this.h);
        this.c[i].reset();
        this.c[i].setTranslate(fArr4[i2], fArr4[i3]);
        this.c[i].preRotate(a(i));
    }

    public void d(k kVar, float f, RectF rectF, Path path) {
        this.e(kVar, f, rectF, null, path);
    }

    public void e(k kVar, float f, RectF rectF, l.b bVar, Path path) {
        int kVar3 = 0;
        path.rewind();
        this.e.rewind();
        this.f.rewind();
        this.f.addRect(rectF, Path.Direction.CW);
        l.c cVar = new l.c(kVar, f, rectF, bVar, path);
        kVar3 = 0;
        int i2 = 4;
        while (kVar3 < i2) {
            m(cVar, kVar3);
            n(kVar3);
            kVar3 = kVar3 + 1;
            i2 = 4;
        }
        while (kVar3 < i2) {
            b(cVar, kVar3);
            c(cVar, kVar3);
            kVar3 = kVar3 + 1;
        }
        path.close();
        this.e.close();
        int i = 19;
        if (Build.VERSION.SDK_INT >= 19) {
            if (!this.e.isEmpty()) {
                path.op(this.e, Path.Op.UNION);
            }
        }
    }

    private float a(int i) {
        return (float)(i + 1) * 90;
    }
}
