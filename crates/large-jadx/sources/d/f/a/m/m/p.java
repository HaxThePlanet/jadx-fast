package d.f.a.m.m;

import d.f.a.m.d;
import d.f.a.m.d.b;
import d.f.a.m.e;
import d.f.a.m.e.b;
import java.util.List;

/* loaded from: classes.dex */
public abstract class p implements d.f.a.m.m.d {

    public int a;
    e b;
    d.f.a.m.m.m c;
    protected e.b d;
    d.f.a.m.m.g e;
    public int f = 0;
    boolean g = false;
    public d.f.a.m.m.f h;
    public d.f.a.m.m.f i;
    protected d.f.a.m.m.p.b j;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            p.a.a = iArr;
            iArr[d.b.LEFT.ordinal()] = 1;
            p.a.a[d.b.RIGHT.ordinal()] = 2;
            p.a.a[d.b.TOP.ordinal()] = 3;
            p.a.a[d.b.BASELINE.ordinal()] = 4;
            p.a.a[d.b.BOTTOM.ordinal()] = 5;
        }
    }

    static enum b {

        NONE,
        START,
        END,
        CENTER;
    }
    public p(e e) {
        super();
        g gVar = new g(this);
        this.e = gVar;
        int i = 0;
        f fVar = new f(this);
        this.h = fVar;
        f fVar2 = new f(this);
        this.i = fVar2;
        this.j = p.b.NONE;
        this.b = e;
    }

    private void l(int i, int i2) {
        d.f.a.m.m.g i4;
        float f;
        int i3;
        int i5;
        d.f.a.m.m.p pVar;
        int i6;
        e.b mATCH_CONSTRAINT;
        e.b bVar;
        int obj8;
        int obj9;
        i4 = this.a;
        if (i4 != 0) {
            i3 = 1;
            if (i4 != i3) {
                i5 = 1056964608;
                if (i4 != 2) {
                    obj9 = 3;
                    if (i4 != obj9) {
                    } else {
                        i4 = this.b;
                        pVar = i4.d;
                        mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
                        i6 = i4.e;
                        if (pVar.d == mATCH_CONSTRAINT && pVar.a == obj9 && i6.d == mATCH_CONSTRAINT && i6.a == obj9) {
                            if (pVar.a == obj9) {
                                i6 = i4.e;
                                if (i6.d == mATCH_CONSTRAINT) {
                                    if (i6.a == obj9) {
                                    } else {
                                        if (i == 0) {
                                            pVar = i4.e;
                                        }
                                        if (obj9.j) {
                                            obj9 = i4.t();
                                            if (i == i3) {
                                                obj8 = (int)obj8;
                                            } else {
                                                obj8 = (int)obj9;
                                            }
                                            this.e.d(obj8);
                                        }
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                } else {
                    obj9 = this.b.I();
                    if (obj9 != null) {
                        obj9 = i == 0 ? obj9.d : obj9.e;
                        obj9 = obj9.e;
                        if (obj9.j) {
                            e eVar = this.b;
                            f = i == 0 ? eVar.x : eVar.A;
                            this.e.d(g((int)obj9, i));
                        }
                    }
                }
            } else {
                this.e.d(Math.min(g(gVar.m, i), i2));
            }
        } else {
            this.e.d(g(i2, i));
        }
    }

    @Override // d.f.a.m.m.d
    public void a(d.f.a.m.m.d d) {
    }

    @Override // d.f.a.m.m.d
    protected final void b(d.f.a.m.m.f f, d.f.a.m.m.f f2, int i3) {
        f.l.add(f2);
        f.f = i3;
        f2.k.add(f);
    }

    @Override // d.f.a.m.m.d
    protected final void c(d.f.a.m.m.f f, d.f.a.m.m.f f2, int i3, d.f.a.m.m.g g4) {
        f.l.add(f2);
        f.l.add(this.e);
        f.h = i3;
        f.i = g4;
        f2.k.add(f);
        g4.k.add(f);
    }

    @Override // d.f.a.m.m.d
    abstract void d();

    @Override // d.f.a.m.m.d
    abstract void e();

    @Override // d.f.a.m.m.d
    abstract void f();

    @Override // d.f.a.m.m.d
    protected final int g(int i, int i2) {
        int i3;
        int obj2;
        int obj3;
        if (i2 == 0) {
            obj3 = this.b;
            i3 = obj3.w;
            obj3 = Math.max(obj3.v, i);
            if (i3 > 0) {
                obj3 = Math.min(i3, i);
            }
            if (obj3 != i) {
                obj2 = obj3;
            }
        } else {
            obj3 = this.b;
            i3 = obj3.z;
            obj3 = Math.max(obj3.y, i);
            if (i3 > 0) {
                obj3 = Math.min(i3, i);
            }
            if (obj3 != i) {
            }
        }
        return obj2;
    }

    @Override // d.f.a.m.m.d
    protected final d.f.a.m.m.f h(d d) {
        d.f.a.m.m.f i2;
        int i;
        d.f.a.m.m.l obj4;
        obj4 = d.f;
        if (obj4 == null) {
            return null;
        }
        final e eVar = obj4.d;
        obj4 = p.a.a[obj4.e.ordinal()];
        if (obj4 != 1) {
            if (obj4 != 2) {
                if (obj4 != 3) {
                    if (obj4 != 4) {
                        if (obj4 != 5) {
                        } else {
                            i2 = obj4.i;
                        }
                    } else {
                        i2 = obj4.k;
                    }
                } else {
                    i2 = obj4.h;
                }
            } else {
                i2 = obj4.i;
            }
        } else {
            i2 = obj4.h;
        }
        return i2;
    }

    @Override // d.f.a.m.m.d
    protected final d.f.a.m.m.f i(d d, int i2) {
        d.f.a.m.m.f i;
        int i3;
        d.f.a.m.m.p obj4;
        d obj3 = d.f;
        if (obj3 == null) {
            return null;
        }
        e eVar = obj3.d;
        obj4 = i2 == 0 ? eVar.d : eVar.e;
        obj3 = p.a.a[obj3.e.ordinal()];
        if (obj3 != 1) {
            if (obj3 != 2) {
                if (obj3 != 3) {
                    if (obj3 != 5) {
                    } else {
                        i = obj4.i;
                    }
                } else {
                    i = obj4.h;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // d.f.a.m.m.d
    public long j() {
        d.f.a.m.m.g gVar = this.e;
        if (gVar.j) {
            return (long)i;
        }
        return 0;
    }

    @Override // d.f.a.m.m.d
    public boolean k() {
        return this.g;
    }

    @Override // d.f.a.m.m.d
    abstract boolean m();

    @Override // d.f.a.m.m.d
    protected void n(d.f.a.m.m.d d, d d2, d d3, int i4) {
        d.f.a.m.m.f fVar;
        int z2;
        boolean z;
        int i;
        e.b mATCH_CONSTRAINT;
        d.f.a.m.m.f obj5;
        int obj6;
        float obj7;
        int obj8;
        obj5 = h(d2);
        fVar = h(d3);
        if (obj5.j) {
            if (!fVar.j) {
            } else {
                i3 += obj6;
                obj6 -= obj7;
                obj7 = obj6 - z2;
                if (!gVar.j && this.d == e.b.MATCH_CONSTRAINT) {
                    if (this.d == e.b.MATCH_CONSTRAINT) {
                        l(i4, obj7);
                    }
                }
                d.f.a.m.m.g gVar2 = this.e;
                if (!gVar2.j) {
                }
                if (gVar2.g == obj7) {
                    this.h.d(z2);
                    this.i.d(obj6);
                }
                obj7 = this.b;
                if (i4 == 0) {
                    obj7 = obj7.w();
                } else {
                    obj7 = obj7.M();
                }
                obj8 = 1056964608;
                if (obj5 == fVar) {
                    z2 = obj5.g;
                    obj6 = fVar.g;
                    obj7 = obj8;
                }
                this.h.d((int)fVar);
                this.i.d(obj6 += obj7);
            }
        }
    }

    @Override // d.f.a.m.m.d
    protected void o(d.f.a.m.m.d d) {
    }

    @Override // d.f.a.m.m.d
    protected void p(d.f.a.m.m.d d) {
    }
}
