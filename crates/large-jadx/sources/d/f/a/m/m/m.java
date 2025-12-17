package d.f.a.m.m;

import d.f.a.m.e;
import d.f.a.m.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class m {

    public static int d;
    public boolean a;
    d.f.a.m.m.p b = null;
    ArrayList<d.f.a.m.m.p> c;
    public m(d.f.a.m.m.p p, int i2) {
        super();
        int obj2 = 0;
        obj2 = new ArrayList();
        this.c = obj2;
        m.d = obj2++;
        this.b = p;
    }

    private long c(d.f.a.m.m.f f, long l2) {
        d.f.a.m.m.f fVar;
        int i2;
        long i;
        Object obj;
        boolean z;
        Object obj9;
        int obj10;
        final d.f.a.m.m.p pVar = f.d;
        if (pVar instanceof k) {
            return l2;
        }
        i2 = 0;
        i = l2;
        while (i2 < f.k.size()) {
            obj = f.k.get(i2);
            if (obj instanceof f) {
            }
            i2++;
            if (obj.d == pVar) {
            } else {
            }
            l5 += l2;
            i = Math.min(i, obj4);
        }
        if (f == pVar.i) {
            l2 -= l;
            i = Math.min(Math.min(i, obj4), i2);
        }
        return i;
    }

    private long d(d.f.a.m.m.f f, long l2) {
        d.f.a.m.m.f fVar;
        int i2;
        long i;
        Object obj;
        boolean z;
        Object obj9;
        int obj10;
        final d.f.a.m.m.p pVar = f.d;
        if (pVar instanceof k) {
            return l2;
        }
        i2 = 0;
        i = l2;
        while (i2 < f.k.size()) {
            obj = f.k.get(i2);
            if (obj instanceof f) {
            }
            i2++;
            if (obj.d == pVar) {
            } else {
            }
            l5 += l2;
            i = Math.max(i, obj4);
        }
        if (f == pVar.h) {
            l2 += l;
            i = Math.max(Math.max(i, obj4), i2);
        }
        return i;
    }

    public void a(d.f.a.m.m.p p) {
        this.c.add(p);
    }

    public long b(f f, int i2) {
        int i9;
        int i6;
        int i5;
        boolean z;
        d.f.a.m.m.p lVar;
        int pVar;
        int i;
        int i7;
        int i8;
        int i4;
        int i3;
        int cmp;
        d.f.a.m.m.p obj12;
        int obj13;
        d.f.a.m.m.p pVar2 = this.b;
        i = 0;
        if (pVar2 instanceof c) {
            if (pVar6.f != i2) {
                return i;
            }
        } else {
            if (i2 == 0) {
                if (!pVar2 instanceof l) {
                    return i;
                }
            } else {
                if (!pVar2 instanceof n) {
                    return i;
                }
            }
        }
        lVar = i2 == 0 ? f.d : f.e;
        obj12 = i2 == 0 ? f.d : f.e;
        boolean contains = fVar.l.contains(lVar.h);
        obj12 = fVar5.l.contains(obj12.i);
        pVar = this.b;
        final long l9 = pVar.j();
        if (contains && obj12 != null) {
            if (obj12 != null) {
                l -= l9;
                obj12 = this.b;
                i4 = fVar6.f;
                if (Long.compare(i6, l11) >= 0) {
                    i6 += i4;
                }
                i3 = fVar7.f;
                i19 -= l12;
                if (Long.compare(i7, l13) >= 0) {
                    i7 -= i3;
                }
                obj12 = obj12.b.o(i2);
                int i20 = 1065353216;
                if (Float.compare(obj12, obj13) > 0) {
                    i = (long)obj13;
                }
                obj13 = (float)i;
                pVar = 1056964608;
                obj12 = this.b;
                l2 += i;
                obj12 = obj12.f;
                i9 -= obj12;
            } else {
                if (contains) {
                    obj12 = obj12.h;
                    obj13 = obj12.f;
                    i5 = Math.max(d(obj12, (long)obj13), obj13);
                } else {
                    if (obj12 != null) {
                        obj12 = obj12.i;
                        obj13 = obj12.f;
                        i5 = Math.max(-obj12, obj13);
                    } else {
                        obj12 = this.b;
                        l3 += obj12;
                        obj12 = obj12.f;
                    }
                }
            }
        } else {
        }
        return i5;
    }
}
