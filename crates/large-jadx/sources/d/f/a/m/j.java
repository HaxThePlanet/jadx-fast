package d.f.a.m;

import d.f.a.d;

/* loaded from: classes.dex */
public class j {

    static boolean[] a;
    static {
        j.a = new boolean[3];
    }

    static void a(d.f.a.m.f f, d d2, d.f.a.m.e e3) {
        d.f.a.m.e.b bVar;
        d.f.a.m.e.b bVar2;
        int mATCH_PARENT2;
        int mATCH_PARENT;
        d.f.a.m.e.b wRAP_CONTENT;
        d.f.a.i iVar;
        d.f.a.i iVar2;
        Object obj6;
        int i = -1;
        e3.p = i;
        e3.q = i;
        mATCH_PARENT2 = 0;
        wRAP_CONTENT = e.b.WRAP_CONTENT;
        final int i5 = 2;
        if (f.V[mATCH_PARENT2] != wRAP_CONTENT && e3.V[mATCH_PARENT2] == e.b.MATCH_PARENT) {
            if (e3.V[mATCH_PARENT2] == e.b.MATCH_PARENT) {
                bVar = dVar2.g;
                i3 -= i6;
                d.f.a.m.d dVar11 = e3.K;
                dVar11.i = d2.q(dVar11);
                d.f.a.m.d dVar12 = e3.M;
                dVar12.i = d2.q(dVar12);
                d2.f(dVar13.i, bVar);
                d2.f(dVar14.i, mATCH_PARENT2);
                e3.p = i5;
                e3.F0(bVar, mATCH_PARENT2);
            }
        }
        mATCH_PARENT = 1;
        if (f.V[mATCH_PARENT] != wRAP_CONTENT && e3.V[mATCH_PARENT] == e.b.MATCH_PARENT) {
            if (e3.V[mATCH_PARENT] == e.b.MATCH_PARENT) {
                bVar2 = dVar.g;
                obj6 -= i2;
                d.f.a.m.d dVar4 = e3.L;
                dVar4.i = d2.q(dVar4);
                d.f.a.m.d dVar5 = e3.N;
                dVar5.i = d2.q(dVar5);
                d2.f(dVar6.i, bVar2);
                d2.f(dVar7.i, obj6);
                if (e3.d0 <= 0) {
                    if (e3.Q() == 8) {
                        d.f.a.m.d dVar8 = e3.O;
                        dVar8.i = d2.q(dVar8);
                        d2.f(dVar9.i, i4 += bVar2);
                    }
                } else {
                }
                e3.q = i5;
                e3.W0(bVar2, obj6);
            }
        }
    }

    public static final boolean b(int i, int i2) {
        int obj0;
        obj0 = i &= i2 == i2 ? 1 : 0;
        return obj0;
    }
}
