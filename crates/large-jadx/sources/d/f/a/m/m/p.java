package d.f.a.m.m;

import d.f.a.m.d;
import d.f.a.m.d.b;
import d.f.a.m.e;
import d.f.a.m.e.b;
import java.util.List;

/* compiled from: WidgetRun.java */
/* loaded from: classes.dex */
public abstract class p implements d {

    public int a;
    e b;
    m c;
    protected e.b d;
    g e = new g();
    public int f = 0;
    boolean g = false;
    public f h = new f();
    public f i = new f();
    protected p.b j;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[d.b.values().length];
            p.a.a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                p.a.a[d.b.RIGHT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                p.a.a[d.b.TOP.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                p.a.a[d.b.BASELINE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                p.a.a[d.b.BOTTOM.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    enum b {

        CENTER,
        END,
        NONE,
        START;
    }
    public p(e eVar) {
        super();
        d.f.a.m.m.g gVar = new g(this);
        d.f.a.m.m.f fVar = new f(this);
        d.f.a.m.m.f fVar2 = new f(this);
        this.j = p.b.NONE;
        this.b = eVar;
    }

    private void l(int i, int i2) {
        float f;
        d.f.a.m.m.l lVar;
        e.b bVar;
        e.b bVar2;
        int min;
        d.f.a.m.m.n nVar;
        if (this.a == 0) {
            this.e.d(g(i2, i));
        } else {
            int i3 = 1;
            if (this.a == i3) {
                this.e.d(Math.min(g(this.e.m, i), i2));
            } else {
                float f2 = 0.5f;
                if (this.a != 2) {
                    int i5 = 3;
                    if (this.a == i5) {
                        mATCH_CONSTRAINT2 = e.b.MATCH_CONSTRAINT;
                        if (lVar.d == e.b.MATCH_CONSTRAINT && lVar.a == i5) {
                            if (nVar3.d != e.b.MATCH_CONSTRAINT || nVar3.a != i5) {
                                if (i == 0) {
                                }
                                if (lVar.e.j && i == i3) {
                                    min = (int)(float)lVar.e.g / f3 + f2;
                                    this.e.d(min);
                                }
                            }
                        }
                    }
                } else {
                    e eVar4 = this.b.I();
                    if (eVar4 != null && i == 0) {
                        if (gVar7.j && i == 0) {
                            i5 = (int)(float)gVar7.g * f + f2;
                            this.e.d(g(i5, i));
                        }
                    }
                }
            }
        }
    }

    protected final void b(f fVar, f fVar2, int i) {
        fVar.l.add(fVar2);
        fVar.f = i;
        fVar2.k.add(fVar);
    }

    protected final void c(f fVar, f fVar2, int i, g gVar) {
        fVar.l.add(fVar2);
        fVar.l.add(this.e);
        fVar.h = i;
        fVar.i = gVar;
        fVar2.k.add(fVar);
        gVar.k.add(fVar);
    }

    protected final int g(int i, int i2) {
        int i3;
        int i22;
        if (i2 == 0) {
            i22 = Math.max(eVar2.v, i);
            if (eVar2.w > 0) {
                i22 = Math.min(eVar2.w, i);
            }
            if (this.b != i) {
            }
        } else {
            i22 = Math.max(eVar.y, i);
            if (eVar.z > 0) {
                i22 = Math.min(eVar.z, i);
            }
        }
        return i22;
    }

    protected final f h(d dVar) {
        d.f.a.m.m.f fVar = null;
        if (dVar.f == null) {
            return null;
        }
        int i3 = p.a.a[dVar2.e.ordinal()];
        int i = 1;
        if (dVar2.e == 1) {
        } else {
            i = 2;
            if (dVar2.e == 2) {
            } else {
                i = 3;
                if (dVar2.e == 3) {
                } else {
                    i = 4;
                    if (dVar2.e == 4) {
                    } else {
                        i = 5;
                        if (dVar2.e == 5) {
                        }
                    }
                }
            }
        }
        return fVar;
    }

    protected final f i(d dVar, int i) {
        d.f.a.m.m.f fVar = null;
        d.f.a.m.m.l lVar;
        if (dVar.f == null) {
            return null;
        }
        i = i == 0 ? eVar.d : eVar.e;
        int i4 = p.a.a[dVar2.e.ordinal()];
        i = 1;
        if (dVar2.e == 1 || dVar2.e != 2) {
        } else {
            i = 3;
            if (dVar2.e != 3) {
                i = 5;
                if (dVar2.e == 5) {
                }
            }
        }
        return fVar;
    }

    public long j() {
        if (gVar.j) {
            return (long)gVar.g;
        }
        return 0;
    }

    public boolean k() {
        return this.g;
    }

    protected void n(d dVar, d dVar2, d dVar3, int i) {
        int i3;
        float f;
        d.f.a.m.m.f fVar2 = h(dVar2);
        d.f.a.m.m.f fVar = h(dVar3);
    }

    public void a(d dVar) {
    }

    abstract void d();

    abstract void e();

    abstract void f();

    abstract boolean m();

    protected void o(d dVar) {
    }

    protected void p(d dVar) {
    }
}
