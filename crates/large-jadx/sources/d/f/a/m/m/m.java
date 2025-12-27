package d.f.a.m.m;

import d.f.a.m.e;
import d.f.a.m.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RunGroup.java */
/* loaded from: classes.dex */
class m {

    public static int d;
    public boolean a;
    p b = null;
    ArrayList<p> c = new ArrayList<>();
    public m(p pVar, int i) {
        super();
        ArrayList arrayList = new ArrayList();
        m.d++;
        this.b = pVar;
    }

    private long c(f fVar, long j) {
        int i = 0;
        long j22;
        Object item;
        boolean z;
        if (pVar instanceof k) {
            return j;
        }
        i = 0;
        j22 = j;
        while (i < fVar.k.size()) {
            item = fVar.k.get(i);
            z = item instanceof f;
            i = i + 1;
        }
        if (fVar == pVar.i) {
            j -= l2;
            l = l9 - (long)pVar.h.f;
            j22 = Math.min(Math.min(j22, c(pVar.h, l9)), l);
        }
        return j22;
    }

    private long d(f fVar, long j) {
        int i = 0;
        long j22;
        Object item;
        boolean z;
        if (pVar instanceof k) {
            return j;
        }
        i = 0;
        j22 = j;
        while (i < fVar.k.size()) {
            item = fVar.k.get(i);
            z = item instanceof f;
            i = i + 1;
        }
        if (fVar == pVar.h) {
            j += l2;
            l = l9 - (long)pVar.i.f;
            j22 = Math.max(Math.max(j22, d(pVar.i, l9)), l);
        }
        return j22;
    }

    public void a(p pVar) {
        this.c.add(pVar);
    }

    public long b(f fVar, int i) {
        long l;
        long l2;
        long max;
        d.f.a.m.m.l lVar;
        float f = 1056964608;
        long l3 = 0;
        long l4;
        float f2;
        int cmp;
        d.f.a.m.m.l lVar2;
        int i4;
        int i5;
        l3 = 0L;
        if (pVar instanceof c) {
            if ((c)pVar.f != i) {
                return l3;
            }
        } else {
            if (i == 0) {
                z = pVar instanceof l;
                if (!(pVar instanceof l)) {
                    return l3;
                }
            } else {
                z = pVar instanceof n;
                if (!(pVar instanceof n)) {
                    return l3;
                }
            }
        }
        d.f.a.m.m.l r1 = i == 0 ? fVar.d : fVar.e;
        fVar = i == 0 ? fVar.d : fVar.e;
        boolean contains = pVar.h.l.contains((i == 0 ? fVar.d : fVar.e).h);
        boolean contains2 = this.b.i.l.contains((i == 0 ? fVar.d : fVar.e));
        final long l17 = this.b.j();
        if (!contains || !contains2) {
            if (contains) {
                max = Math.max(d(this.b.h, (long)i5), (long)this.b.h.f + l17);
            } else {
                if (contains2) {
                    max = Math.max(-(c(this.b.i, (long)i5)), (long)-this.b.i.f + l17);
                } else {
                    l = (long)pVar10.h.f + this.b.j();
                }
            }
        } else {
            l2 = (d(this.b.h, l3)) - l17;
            long l22 = (long)-i;
            if (pVar.h >= l22) {
                l2 = l2 + (long)i;
            }
            l4 = (-(c(this.b.i, l3))) - l17 - (long)i3;
            long l24 = (long)i3;
            if (l4 >= l24) {
                l4 = l4 - (long)i3;
            }
            float f9 = pVar8.b.o(i);
            float f8 = 1f;
            if (f9 > 0) {
                l3 = (long)(float)l4 / f9 + (float)l2 / (f8 - f9);
            }
            float f10 = (float)l3;
            f = 0.5f;
            f2 = f8 - f9;
            l3 = (long)(f10 * f9) + f + l17 + (long)(f10 * f2) + f;
            l = (long)pVar9.h.f + l3;
            l5 = (long)i4;
            max = l - l5;
        }
        return max;
    }
}
