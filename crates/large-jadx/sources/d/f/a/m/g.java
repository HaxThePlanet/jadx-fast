package d.f.a.m;

import d.f.a.d;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class g extends d.f.a.m.e {

    protected float u0 = -1f;
    protected int v0 = -1;
    protected int w0 = -1;
    private d.f.a.m.d x0 = -1;
    private int y0 = 0;
    private boolean z0;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            g.a.a = iArr;
            iArr[d.b.LEFT.ordinal()] = 1;
            g.a.a[d.b.RIGHT.ordinal()] = 2;
            g.a.a[d.b.TOP.ordinal()] = 3;
            g.a.a[d.b.BOTTOM.ordinal()] = 4;
            g.a.a[d.b.BASELINE.ordinal()] = 5;
            g.a.a[d.b.CENTER.ordinal()] = 6;
            g.a.a[d.b.CENTER_X.ordinal()] = 7;
            g.a.a[d.b.CENTER_Y.ordinal()] = 8;
            g.a.a[d.b.NONE.ordinal()] = 9;
        }
    }
    public g() {
        int i;
        d.f.a.m.d dVar2;
        d.f.a.m.d dVar;
        super();
        int i2 = -1082130432;
        int i3 = -1;
        d.f.a.m.d dVar3 = this.L;
        i = 0;
        this.T.clear();
        this.T.add(this.x0);
        while (i < objArr.length) {
            this.S[i] = this.x0;
            i++;
        }
    }

    @Override // d.f.a.m.e
    public void g(d d, boolean z2) {
        d.f.a.m.d dVar;
        d.f.a.m.d dVar2;
        int wRAP_CONTENT;
        Object eVar;
        int i3;
        int i2;
        d.f.a.m.e.b wRAP_CONTENT2;
        int i;
        Object obj9;
        obj9 = I();
        if ((f)obj9 == null) {
        }
        dVar = (f)obj9.m(d.b.LEFT);
        dVar2 = obj9.m(d.b.RIGHT);
        eVar = this.W;
        i3 = 1;
        final int i5 = 0;
        if (eVar != null && eVar.V[i5] == e.b.WRAP_CONTENT) {
            wRAP_CONTENT = eVar.V[i5] == e.b.WRAP_CONTENT ? i3 : i5;
        } else {
        }
        if (this.y0 == 0) {
            dVar = obj9.m(d.b.TOP);
            dVar2 = obj9.m(d.b.BOTTOM);
            obj9 = this.W;
            if (obj9 != null && obj9.V[i3] == e.b.WRAP_CONTENT) {
                if (obj9.V[i3] == e.b.WRAP_CONTENT) {
                } else {
                    i3 = i5;
                }
            } else {
            }
            wRAP_CONTENT = i3;
        }
        i2 = -1;
        int i7 = 5;
        if (this.z0 && this.x0.m()) {
            if (this.x0.m()) {
                obj9 = d.q(this.x0);
                d.f(obj9, this.x0.d());
                if (this.v0 != i2) {
                    if (wRAP_CONTENT != 0) {
                        d.h(d.q(dVar2), obj9, i5, i7);
                    }
                } else {
                    if (this.w0 != i2 && wRAP_CONTENT != 0) {
                        if (wRAP_CONTENT != 0) {
                            d.h(obj9, d.q(dVar), i5, i7);
                            d.h(d.q(dVar2), obj9, i5, i7);
                        }
                    }
                }
                this.z0 = i5;
            }
        }
        int i8 = 8;
        if (this.v0 != i2) {
            obj9 = d.q(this.x0);
            d.e(obj9, d.q(dVar), this.v0, i8);
            if (wRAP_CONTENT != 0) {
                d.h(d.q(dVar2), obj9, i5, i7);
            }
        } else {
            if (this.w0 != i2) {
                obj9 = d.q(this.x0);
                dVar2 = d.q(dVar2);
                d.e(obj9, dVar2, -i4, i8);
                if (wRAP_CONTENT != 0) {
                    d.h(obj9, d.q(dVar), i5, i7);
                    d.h(dVar2, obj9, i5, i7);
                }
            } else {
                if (Float.compare(obj9, dVar) != 0) {
                    d.d(d.s(d, d.q(this.x0), d.q(dVar2), this.u0));
                }
            }
        }
    }

    @Override // d.f.a.m.e
    public boolean h() {
        return 1;
    }

    @Override // d.f.a.m.e
    public void h1(d d, boolean z2) {
        int obj3;
        if (I() == null) {
        }
        obj3 = d.x(this.x0);
        final int i2 = 0;
        if (this.y0 == 1) {
            d1(obj3);
            e1(i2);
            C0(I().v());
            b1(i2);
        } else {
            d1(i2);
            e1(obj3);
            b1(I().R());
            C0(i2);
        }
    }

    @Override // d.f.a.m.e
    public boolean i0() {
        return this.z0;
    }

    @Override // d.f.a.m.e
    public d.f.a.m.d i1() {
        return this.x0;
    }

    @Override // d.f.a.m.e
    public boolean j0() {
        return this.z0;
    }

    @Override // d.f.a.m.e
    public int j1() {
        return this.y0;
    }

    @Override // d.f.a.m.e
    public int k1() {
        return this.v0;
    }

    @Override // d.f.a.m.e
    public int l1() {
        return this.w0;
    }

    @Override // d.f.a.m.e
    public d.f.a.m.d m(d.f.a.m.d.b d$b) {
        int i;
        int i2;
        int obj3;
        obj3 = g.a.a[b.ordinal()];
        i = 1;
        if (obj3 != i && obj3 != 2) {
            if (obj3 != 2) {
                if (obj3 != 3 && obj3 != 4) {
                    if (obj3 != 4) {
                    } else {
                        if (this.y0 == 0) {
                            return this.x0;
                        }
                    }
                } else {
                }
            } else {
                if (this.y0 == i) {
                    return this.x0;
                }
            }
        } else {
        }
        return null;
    }

    @Override // d.f.a.m.e
    public float m1() {
        return this.u0;
    }

    @Override // d.f.a.m.e
    public void n1(int i) {
        this.x0.s(i);
        this.z0 = true;
    }

    @Override // d.f.a.m.e
    public void o1(int i) {
        int i2;
        final int i3 = -1;
        if (i > i3) {
            this.u0 = -1082130432;
            this.v0 = i;
            this.w0 = i3;
        }
    }

    @Override // d.f.a.m.e
    public void p1(int i) {
        int i2;
        final int i3 = -1;
        if (i > i3) {
            this.u0 = -1082130432;
            this.v0 = i3;
            this.w0 = i;
        }
    }

    @Override // d.f.a.m.e
    public void q1(float f) {
        int obj2;
        if (Float.compare(f, i) > 0) {
            this.u0 = f;
            obj2 = -1;
            this.v0 = obj2;
            this.w0 = obj2;
        }
    }

    @Override // d.f.a.m.e
    public void r1(int i) {
        int i2;
        d.f.a.m.d[] objArr;
        d.f.a.m.d dVar;
        d.f.a.m.d obj4;
        if (this.y0 == i) {
        }
        this.y0 = i;
        this.T.clear();
        if (this.y0 == 1) {
            this.x0 = this.K;
        } else {
            this.x0 = this.L;
        }
        this.T.add(this.x0);
        i2 = 0;
        while (i2 < obj4.length) {
            this.S[i2] = this.x0;
            i2++;
        }
    }
}
