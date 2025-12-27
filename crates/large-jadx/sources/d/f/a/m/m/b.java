package d.f.a.m.m;

import d.f.a.m.d.b;
import d.f.a.m.e.b;
import d.f.a.m.f;
import d.f.a.m.j;
import d.f.a.m.k;
import d.f.a.m.l;
import java.util.ArrayList;

/* compiled from: BasicMeasure.java */
/* loaded from: classes.dex */
public class b {

    private final ArrayList<d.f.a.m.e> a = new ArrayList<>();
    private b.a b = new b$a();
    private f c;

    public static class a {

        public static int k = 0;
        public static int l = 1;
        public static int m = 2;
        public e.b a;
        public e.b b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public boolean i;
        public int j;
    }

    public interface b {
        void a();

        void b(d.f.a.m.e eVar, b.a aVar);
    }
    public b(f fVar) {
        super();
        ArrayList arrayList = new ArrayList();
        d.f.a.m.m.b.a aVar = new b.a();
        this.c = fVar;
    }

    private boolean a(b.b bVar, d.f.a.m.e eVar, int i) {
        int cmp;
        boolean z;
        this.b.a = eVar.y();
        this.b.b = eVar.O();
        this.b.c = eVar.R();
        this.b.d = eVar.v();
        z = false;
        this.b.i = z;
        this.b.j = i;
        e.b mATCH_CONSTRAINT2 = e.b.MATCH_CONSTRAINT;
        cmp = 1;
        i = aVar5.a == e.b.MATCH_CONSTRAINT ? cmp : z;
        int r2 = aVar5.b == e.b.MATCH_CONSTRAINT ? cmp : z;
        float f2 = 0.0f;
        if (aVar5.a != 0) {
            i = eVar.Z > 0.0f ? cmp : z;
        }
        if (e.b.MATCH_CONSTRAINT != 0) {
            r2 = eVar.Z > 0.0f ? cmp : z;
        }
        int i4 = 4;
        if (eVar.Z && eVar.u[z] == i4) {
            this.b.a = e.b.FIXED;
        }
        if (e.b.MATCH_CONSTRAINT != 0) {
            if (eVar.u[cmp] == i4) {
                this.b.b = e.b.FIXED;
            }
        }
        bVar.b(eVar, this.b);
        eVar.b1(this.b.e);
        eVar.C0(this.b.f);
        eVar.B0(this.b.h);
        eVar.r0(this.b.g);
        this.b.j = b.a.k;
        return aVar10.i;
    }

    private void b(f fVar) {
        int i;
        Object item;
        boolean z;
        e.b bVar;
        d.f.a.m.m.n nVar;
        e.b bVar2;
        e.b mATCH_CONSTRAINT2;
        boolean z2;
        final d.f.a.m.m.b.b bVar3 = fVar.z1();
        i = 0;
        while (i < fVar.u0.size()) {
            item = fVar.u0.get(i);
            z = item instanceof g;
            i = i + 1;
        }
        bVar3.a();
    }

    private void c(f fVar, String str, int i, int i2, int i3) {
        i2 = 0;
        fVar.R0(i2);
        fVar.Q0(i2);
        fVar.b1(i2);
        fVar.C0(i3);
        fVar.R0(fVar.G());
        fVar.Q0(fVar.F());
        this.c.N1(i);
        this.c.j1();
    }

    public long d(f fVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i82 = 1;
        boolean z8 = true;
        int i72;
        int i11;
        boolean z2;
        d.f.a.m.m.b.b bVar;
        int i12;
        boolean z3;
        boolean z4;
        Object item;
        d.f.a.e eVar;
        boolean z5;
        e.b mATCH_CONSTRAINT2;
        boolean z17 = true;
        long l;
        int i15 = 1;
        f fVar2;
        String str;
        final Object fVar3 = this;
        fVar2 = fVar;
        i22 = i;
        i82 = i4;
        i72 = i6;
        i82 = fVar2.u0.size();
        boolean z10 = j.b(i22, 128);
        i82 = 0;
        if (!z10) {
            i82 = 64;
            if (j.b(i22, i82)) {
                i82 = 1;
            } else {
            }
        }
        if (i82 != 0) {
            while (i82 < i82) {
                item = fVar2.u0.get(i82);
                mATCH_CONSTRAINT2 = e.b.MATCH_CONSTRAINT;
                int r14 = item.y() == e.b.MATCH_CONSTRAINT ? 1 : i82;
                int r11 = item.O() == e.b.MATCH_CONSTRAINT ? 1 : i82;
                z3 = item instanceof k;
                if (item.f0()) {
                    break;
                }
            }
        }
        if (i82 != 0 && d.x != null) {
            eVar2.c += l6;
        }
        i82 = 1073741824;
        if (i82 != i82 || i72 != i82) {
            r14 = z10 ? 1 : i82;
        }
        i82 = i82 & (z10 ? 1 : i82);
        i82 = 2;
        if (i82 & r14 != 0) {
            i82 = Math.min(fVar.E(), i5);
            int min = Math.min(fVar.D(), i7);
            if (i82 == i82 && fVar.R() != i82) {
                fVar2.b1(i82);
                fVar.C1();
            }
            if (i72 == i82 && fVar.v() != min) {
                fVar2.C0(min);
                fVar.C1();
            }
            if (i82 != i82 || i72 != i82) {
                if (i82 == i82) {
                    i82 = fVar2.x1(z10) & (fVar2.y1(z10, i82));
                    i82 = 1;
                } else {
                }
                if (i72 == i82) {
                    i82 = 1;
                    i82 = (fVar2.y1(z10, i82)) & i82;
                    i82 = i82 + 1;
                } else {
                }
            } else {
                boolean z12 = fVar2.w1(z10);
            }
            if (i82 != 0) {
                int r15 = i82 == i82 ? 1 : i82;
                int r3 = i72 == i82 ? 1 : i82;
                fVar2.g1(z17, (i72 == i82 ? 1 : i82));
            }
        } else {
        }
        if (i82 == 0 || i82 != i82) {
            if (i82 > 0) {
                b(fVar);
            }
            e(fVar);
            i72 = fVar3.a.size();
            if (i82 > 0) {
                i82 = 0;
                this.c(fVar, str, i82, i82, i12);
            }
            if (i72 > 0) {
                e.b wRAP_CONTENT2 = e.b.WRAP_CONTENT;
                r15 = fVar.y() == e.b.WRAP_CONTENT ? 1 : i82;
                int r6 = fVar.O() == e.b.WRAP_CONTENT ? 1 : i82;
                i82 = Math.max(fVar.R(), fVar3.c.G());
                i82 = Math.max(fVar.v(), fVar3.c.F());
                while (fVar3.c < i72) {
                    Object item3 = fVar3.a.get(i82);
                    i82 = i82 + 1;
                    i82 = 0;
                    i82 = 2;
                }
                i82 = 0;
                while (i82 < i82) {
                    i12 = 0;
                    while (i12 < fVar3.a) {
                        Object item2 = fVar3.a.get(i12);
                        z4 = item2 instanceof h;
                        i12 = i12 + 1;
                        i82 = 2;
                    }
                    l = 1L;
                    item2 = fVar3.a.get(i12);
                    z4 = item2 instanceof h;
                    i12 = i12 + 1;
                    i82 = 2;
                }
            } else {
            }
            fVar2.M1(i82);
        }
        return 0;
    }

    public void e(f fVar) {
        int i = 0;
        e.b bVar;
        this.a.clear();
        i = 0;
        while (i < fVar.u0.size()) {
            Object item = fVar.u0.get(i);
            mATCH_CONSTRAINT2 = e.b.MATCH_CONSTRAINT;
            i = i + 1;
        }
        fVar.C1();
    }
}
