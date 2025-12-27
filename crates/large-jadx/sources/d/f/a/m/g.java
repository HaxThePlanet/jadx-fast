package d.f.a.m;

import d.f.a.d;
import java.util.ArrayList;

/* compiled from: Guideline.java */
/* loaded from: classes.dex */
public class g extends e {

    protected float u0 = -1f;
    protected int v0 = -1;
    protected int w0 = -1;
    private d x0;
    private int y0 = 0;
    private boolean z0;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[d.b.values().length];
            g.a.a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                g.a.a[d.b.RIGHT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                g.a.a[d.b.TOP.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                g.a.a[d.b.BOTTOM.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                g.a.a[d.b.BASELINE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                g.a.a[d.b.CENTER.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                g.a.a[d.b.CENTER_X.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                g.a.a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                g.a.a[d.b.NONE.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    public g() {
        int i = 0;
        super();
        this.x0 = this.L;
        i = 0;
        this.T.clear();
        this.T.add(this.x0);
        while (this.L < this.S.length) {
            this.S[i] = this.x0;
            i = i + 1;
        }
    }

    @Override // d.f.a.m.e
    public void g(d dVar, boolean z) {
        d.f.a.m.d dVar2;
        d.f.a.m.d dVar3;
        int i;
        d.f.a.m.e.b wRAP_CONTENT22;
        d.f.a.m.e.b bVar;
        d.f.a.m.e eVar3;
        d.f.a.m.e eVar2 = I();
        if (eVar2 == null) {
            return;
        }
        dVar2 = eVar2.m(d.b.LEFT);
        dVar3 = eVar2.m(d.b.RIGHT);
        i = 1;
        i = 0;
        if (this.W != null) {
            int r2 = i;
        }
        if (this.y0 == 0) {
            dVar2 = eVar2.m(d.b.TOP);
            dVar3 = eVar2.m(d.b.BOTTOM);
            if (this.W != null) {
                if (eVar3.V[i] != e.b.WRAP_CONTENT) {
                }
            }
        }
        int i2 = -1;
        int i6 = 5;
        if (this.z0) {
            if (this.x0.m()) {
                d.f.a.i iVar8 = dVar.q(this.x0);
                dVar.f(iVar8, this.x0.d());
                if (this.v0 != i2) {
                    if (e.b.WRAP_CONTENT != 0) {
                        dVar.h(dVar.q(dVar3), iVar8, i, i6);
                    }
                } else {
                    if (this.w0 != i2 && e.b.WRAP_CONTENT != 0) {
                        dVar.h(iVar8, dVar.q(dVar2), i, i6);
                        dVar.h(dVar.q(dVar3), iVar8, i, i6);
                    }
                }
                this.z0 = false;
                return;
            }
        }
        int i7 = 8;
        if (this.v0 != i2) {
            d.f.a.i iVar2 = dVar.q(this.x0);
            dVar.e(iVar2, dVar.q(dVar2), this.v0, i7);
            if (e.b.WRAP_CONTENT != 0) {
                dVar.h(dVar.q(dVar3), iVar2, i, i6);
            }
        } else {
            if (this.w0 != i2) {
                iVar2 = dVar.q(this.x0);
                d.f.a.i iVar5 = dVar.q(dVar3);
                i2 = -this.w0;
                dVar.e(iVar2, iVar5, i2, i7);
                if (e.b.WRAP_CONTENT != 0) {
                    dVar.h(iVar2, dVar.q(dVar2), i, i6);
                    dVar.h(iVar5, iVar2, i, i6);
                }
            } else {
                float f = -1f;
                if (this.u0 != f) {
                    dVar.d(d.s(dVar, dVar.q(this.x0), dVar.q(dVar3), this.u0));
                }
            }
        }
    }

    @Override // d.f.a.m.e
    public void h1(d dVar, boolean z) {
        if (I() == null) {
            return;
        }
        int i4 = dVar.x(this.x0);
        final int i3 = 0;
        if (this.y0 == 1) {
            d1(i4);
            e1(i3);
            C0(I().v());
            b1(i3);
        } else {
            d1(i3);
            e1(i4);
            b1(I().R());
            C0(i3);
        }
    }

    @Override // d.f.a.m.e
    public boolean i0() {
        return this.z0;
    }

    @Override // d.f.a.m.e
    public d i1() {
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
    public d m(d.b bVar) {
        int i = 3;
        int i2 = 2;
        int i3 = g.a.a[bVar.ordinal()];
        i = 1;
        if (i3 == i || i3 == 2) {
            if (this.y0 == i) {
                return this.x0;
            }
        } else {
            i = 3;
            if (this.y0 == 3 || this.y0 == 4) {
                if (this.y0 == 0) {
                    return this.x0;
                }
            }
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
        final int i2 = -1;
        if (i > i2) {
            float f = -1f;
            this.u0 = f;
            this.v0 = i;
            this.w0 = i2;
        }
    }

    @Override // d.f.a.m.e
    public void p1(int i) {
        final int i2 = -1;
        if (i > i2) {
            float f = -1f;
            this.u0 = f;
            this.v0 = i2;
            this.w0 = i;
        }
    }

    @Override // d.f.a.m.e
    public void q1(float f) {
        if (f > -1082130432) {
            this.u0 = f;
            int i = -1;
            this.v0 = i;
            this.w0 = i;
        }
    }

    @Override // d.f.a.m.e
    public void r1(int i) {
        int i2 = 0;
        if (this.y0 == i) {
            return;
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
        while (this.y0 < this.S.length) {
            this.S[i2] = this.x0;
            i2 = i2 + 1;
        }
    }

    @Override // d.f.a.m.e
    public boolean h() {
        return true;
    }
}
