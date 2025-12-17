package f.c.a.e.d0;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build.VERSION;

/* loaded from: classes2.dex */
public class l {

    private final f.c.a.e.d0.m[] a;
    private final Matrix[] b;
    private final Matrix[] c;
    private final PointF d;
    private final Path e;
    private final Path f;
    private final f.c.a.e.d0.m g;
    private final float[] h;
    private final float[] i;
    private final Path j;
    private final Path k;
    private boolean l = true;

    private static class a {

        static final f.c.a.e.d0.l a;
        static {
            l lVar = new l();
            l.a.a = lVar;
        }
    }

    public interface b {
        public abstract void a(f.c.a.e.d0.m m, Matrix matrix2, int i3);

        public abstract void b(f.c.a.e.d0.m m, Matrix matrix2, int i3);
    }

    static final class c {

        public final f.c.a.e.d0.k a;
        public final Path b;
        public final RectF c;
        public final f.c.a.e.d0.l.b d;
        public final float e;
        c(f.c.a.e.d0.k k, float f2, RectF rectF3, f.c.a.e.d0.l.b l$b4, Path path5) {
            super();
            this.d = b4;
            this.a = k;
            this.e = f2;
            this.c = rectF3;
            this.b = path5;
        }
    }
    public l() {
        int i;
        float[] fArr;
        Matrix matrix;
        super();
        final int i2 = 4;
        this.a = new m[i2];
        this.b = new Matrix[i2];
        this.c = new Matrix[i2];
        PointF pointF = new PointF();
        this.d = pointF;
        Path path = new Path();
        this.e = path;
        Path path2 = new Path();
        this.f = path2;
        m mVar = new m();
        this.g = mVar;
        int i3 = 2;
        this.h = new float[i3];
        this.i = new float[i3];
        Path path3 = new Path();
        this.j = path3;
        Path path4 = new Path();
        this.k = path4;
        int i4 = 1;
        i = 0;
        while (i < i2) {
            m mVar2 = new m();
            this.a[i] = mVar2;
            Matrix matrix2 = new Matrix();
            this.b[i] = matrix2;
            matrix = new Matrix();
            this.c[i] = matrix;
            i++;
        }
    }

    private float a(int i) {
        return (float)obj1;
    }

    private void b(f.c.a.e.d0.l.c l$c, int i2) {
        Path path;
        f.c.a.e.d0.m mVar;
        float f2;
        Matrix matrix;
        float f;
        int i = 0;
        this.h[i] = this.a[i2].k();
        final int i3 = 1;
        this.h[i3] = this.a[i2].l();
        this.b[i2].mapPoints(this.h);
        if (i2 == 0) {
            float[] fArr4 = this.h;
            c.b.moveTo(fArr4[i], fArr4[i3]);
        } else {
            float[] fArr5 = this.h;
            c.b.lineTo(fArr5[i], fArr5[i3]);
        }
        this.a[i2].d(this.b[i2], c.b);
        final f.c.a.e.d0.l.b obj5 = c.d;
        if (obj5 != null) {
            obj5.a(this.a[i2], this.b[i2], i2);
        }
    }

    private void c(f.c.a.e.d0.l.c l$c, int i2) {
        f.c.a.e.d0.m mVar;
        int i;
        Matrix matrix;
        boolean sDK_INT;
        Path path;
        Matrix matrix2;
        i3 %= 4;
        final int i9 = 0;
        this.h[i9] = this.a[i2].i();
        final int i10 = 1;
        this.h[i10] = this.a[i2].j();
        this.b[i2].mapPoints(this.h);
        this.i[i9] = this.a[i].k();
        this.i[i10] = this.a[i].l();
        this.b[i].mapPoints(this.i);
        float[] fArr7 = this.h;
        float[] fArr12 = this.i;
        float f12 = fArr12[i10];
        int i8 = 0;
        this.g.n(i8, i8);
        f.c.a.e.d0.f fVar = j(i2, c.a);
        fVar.b(Math.max(f2 -= i7, i8), i(c.c, i2), c.e, this.g);
        this.j.reset();
        this.g.d(this.c[i2], this.j);
        if (this.l && Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= 19) {
                if (!fVar.a() && !l(this.j, i2)) {
                    if (!l(this.j, i2)) {
                        if (l(this.j, i)) {
                            Path path2 = this.j;
                            path2.op(path2, this.f, Path.Op.DIFFERENCE);
                            this.h[i9] = this.g.k();
                            this.h[i10] = this.g.l();
                            this.c[i2].mapPoints(this.h);
                            float[] fArr9 = this.h;
                            this.e.moveTo(fArr9[i9], fArr9[i10]);
                            this.g.d(this.c[i2], this.e);
                        } else {
                            this.g.d(this.c[i2], c.b);
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        final f.c.a.e.d0.l.b obj9 = c.d;
        if (obj9 != null) {
            obj9.b(this.g, this.c[i2], i2);
        }
    }

    private void f(int i, RectF rectF2, PointF pointF3) {
        int i2;
        float obj2;
        float obj3;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    pointF3.set(rectF2.right, rectF2.top);
                } else {
                    pointF3.set(rectF2.left, rectF2.top);
                }
            } else {
                pointF3.set(rectF2.left, rectF2.bottom);
            }
        } else {
            pointF3.set(rectF2.right, rectF2.bottom);
        }
    }

    private f.c.a.e.d0.c g(int i, f.c.a.e.d0.k k2) {
        if (i != 1 && i != 2 && i != 3) {
            if (i != 2) {
                if (i != 3) {
                    return k2.t();
                }
                return k2.r();
            }
            return k2.j();
        }
        return k2.l();
    }

    private f.c.a.e.d0.d h(int i, f.c.a.e.d0.k k2) {
        if (i != 1 && i != 2 && i != 3) {
            if (i != 2) {
                if (i != 3) {
                    return k2.s();
                }
                return k2.q();
            }
            return k2.i();
        }
        return k2.k();
    }

    private float i(RectF rectF, int i2) {
        float[] fArr;
        fArr = this.h;
        f.c.a.e.d0.m[] objArr = this.a;
        final int i3 = 0;
        fArr[i3] = mVar2.c;
        int i = 1;
        fArr[i] = mVar.d;
        this.b[i2].mapPoints(fArr);
        if (i2 != i && i2 != 3) {
            if (i2 != 3) {
                return Math.abs(obj5 -= obj6);
            }
        }
        return Math.abs(obj5 -= obj6);
    }

    private f.c.a.e.d0.f j(int i, f.c.a.e.d0.k k2) {
        if (i != 1 && i != 2 && i != 3) {
            if (i != 2) {
                if (i != 3) {
                    return k2.o();
                }
                return k2.p();
            }
            return k2.n();
        }
        return k2.h();
    }

    public static f.c.a.e.d0.l k() {
        return l.a.a;
    }

    private boolean l(Path path, int i2) {
        int i;
        Path path2;
        int obj4;
        this.k.reset();
        this.a[i2].d(this.b[i2], this.k);
        RectF obj5 = new RectF();
        i = 1;
        path.computeBounds(obj5, i);
        this.k.computeBounds(obj5, i);
        path.op(this.k, Path.Op.INTERSECT);
        path.computeBounds(obj5, i);
        if (obj5.isEmpty()) {
            path2 = 1065353216;
            if (Float.compare(obj4, path2) > 0 && Float.compare(obj4, path2) > 0) {
                if (Float.compare(obj4, path2) > 0) {
                } else {
                    i = 0;
                }
            } else {
            }
        }
        return i;
    }

    private void m(f.c.a.e.d0.l.c l$c, int i2) {
        h(i2, c.a).b(this.a[i2], 1119092736, c.e, c.c, g(i2, c.a));
        this.b[i2].reset();
        f(i2, c.c, this.d);
        PointF pointF2 = this.d;
        this.b[i2].setTranslate(pointF2.x, pointF2.y);
        this.b[i2].preRotate(a(i2));
    }

    private void n(int i) {
        int i2 = 0;
        this.h[i2] = this.a[i].i();
        int i3 = 1;
        this.h[i3] = this.a[i].j();
        this.b[i].mapPoints(this.h);
        this.c[i].reset();
        final float[] fArr4 = this.h;
        this.c[i].setTranslate(fArr4[i2], fArr4[i3]);
        this.c[i].preRotate(a(i));
    }

    public void d(f.c.a.e.d0.k k, float f2, RectF rectF3, Path path4) {
        this.e(k, f2, rectF3, 0, path4);
    }

    public void e(f.c.a.e.d0.k k, float f2, RectF rectF3, f.c.a.e.d0.l.b l$b4, Path path5) {
        int obj9;
        int obj10;
        RectF obj11;
        path5.rewind();
        this.e.rewind();
        this.f.rewind();
        this.f.addRect(rectF3, Path.Direction.CW);
        super(k, f2, rectF3, b4, path5);
        obj10 = obj9;
        obj11 = 4;
        while (obj10 < obj11) {
            m(cVar, obj10);
            n(obj10);
            obj10++;
            obj11 = 4;
        }
        while (obj9 < obj11) {
            b(cVar, obj9);
            c(cVar, obj9);
            obj9++;
        }
        path5.close();
        this.e.close();
        if (Build.VERSION.SDK_INT >= 19 && !this.e.isEmpty()) {
            if (!this.e.isEmpty()) {
                path5.op(this.e, Path.Op.UNION);
            }
        }
    }
}
