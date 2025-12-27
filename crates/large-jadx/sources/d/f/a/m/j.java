package d.f.a.m;

import d.f.a.d;

/* compiled from: Optimizer.java */
/* loaded from: classes.dex */
public class j {

    static boolean[] a;
    static {
        j.a = new boolean[3];
    }

    static void a(f fVar, d dVar, e eVar) {
        d.f.a.i iVar;
        int i4 = 8;
        int i6 = -1;
        eVar.p = i6;
        eVar.q = i6;
        int i = 0;
        wRAP_CONTENT2 = e.b.WRAP_CONTENT;
        final int i12 = 2;
        if (fVar.V[i] != e.b.WRAP_CONTENT) {
            if (eVar.V[i] == e.b.MATCH_PARENT) {
                i = fVar.R() - eVar.M.g;
                eVar.K.i = dVar.q(eVar.K);
                eVar.M.i = dVar.q(eVar.M);
                dVar.f(eVar.K.i, eVar.K.g);
                dVar.f(eVar.M.i, i);
                eVar.p = i12;
                eVar.F0(eVar.K.g, i);
            }
        }
        int i2 = 1;
        if (fVar.V[i2] != e.b.WRAP_CONTENT) {
            if (eVar.V[i2] == e.b.MATCH_PARENT) {
                i5 = fVar.v() - eVar.N.g;
                eVar.L.i = dVar.q(eVar.L);
                eVar.N.i = dVar.q(eVar.N);
                dVar.f(eVar.L.i, eVar.L.g);
                dVar.f(eVar.N.i, i5);
                if (eVar.d0 <= 0) {
                    i4 = 8;
                    if (eVar.Q() == 8) {
                        eVar.O.i = dVar.q(eVar.O);
                        i4 = eVar.d0 + i7;
                        dVar.f(eVar.O.i, i4);
                    }
                }
                eVar.q = i12;
                eVar.W0(eVar.L.g, i5);
            }
        }
    }

    public static final boolean b(int i, int i2) {
        boolean z = true;
        i = (i & i2) == i2 ? 1 : 0;
        return ((i & i2) == i2 ? 1 : 0);
    }
}
