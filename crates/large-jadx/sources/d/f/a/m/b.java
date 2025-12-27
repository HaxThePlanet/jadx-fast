package d.f.a.m;

import d.f.a.b;
import d.f.a.d;
import java.util.ArrayList;

/* compiled from: Chain.java */
/* loaded from: classes.dex */
public class b {
    static void a(f fVar, d dVar, int i, int i2, c cVar) {
        Object cVar52;
        d.f.a.m.d dVar22;
        d.f.a.m.e fVar3;
        d.f.a.i iVar3;
        int i5 = 5;
        int i6;
        int i7;
        ArrayList list;
        int i8;
        d.f.a.m.d dVar5;
        int i9;
        d.f.a.i iVar6;
        d.f.a.m.d dVar6;
        d.f.a.m.d dVar7;
        d.f.a.m.e eVar2;
        d.f.a.i iVar9;
        d.f.a.i iVar10;
        int size;
        d.f.a.m.d dVar8;
        int i12;
        float f;
        d.f.a.m.d dVar10;
        float f2;
        int i13 = 0;
        d.f.a.i iVar12;
        int i14 = 0;
        d.f.a.i iVar14;
        int i15 = 1;
        d.f.a.i iVar15;
        float f3 = 1065353216;
        int i16;
        d.f.a.m.d[] objArr;
        d.f.a.m.d dVar11;
        d.f.a.m.d dVar12;
        d.f.a.i iVar;
        d.f.a.i iVar42;
        int i19;
        d.f.a.m.d dVar14;
        int i20 = 0;
        d.f.a.m.e.b mATCH_CONSTRAINT2;
        d.f.a.i iVar17;
        d.f.a.i iVar18;
        d.f.a.m.e eVar3;
        d.f.a.i iVar23;
        int i23 = 0;
        int i32 = 5;
        int i22;
        int i25 = 8;
        d.f.a.i iVar28;
        int cmp;
        int i27;
        int i26;
        b bVar;
        d.f.a.i iVar27;
        d.f.a.i iVar21;
        d.f.a.i iVar4;
        d.f.a.i iVar26;
        fVar2 = fVar;
        cVar52 = dVar;
        i32 = i;
        cVar52 = cVar;
        i12 = 1;
        int r4 = fVar2.V[i32] == e.b.WRAP_CONTENT ? i12 : 0;
        int i53 = 2;
        if (i32 == 0) {
            int r15 = eVar2.m0 == 0 ? i12 : 0;
            int r16 = eVar2.m0 == i12 ? i12 : 0;
            if (eVar2.m0 == i53) {
            } else {
                i12 = 0;
            }
        } else {
            r15 = eVar2.n0 == 0 ? i12 : 0;
            r16 = eVar2.n0 == i12 ? i12 : 0;
            int r5 = eVar2.n0 == i53 ? i12 : 0;
        }
        i23 = 0;
        i12 = 0;
        while (eVar2.m0 == 0) {
            dVar14 = eVar3.S[i2];
            int r20 = e.b.WRAP_CONTENT != 0 ? 1 : 4;
            d.f.a.m.e.b mATCH_CONSTRAINT22 = e.b.MATCH_CONSTRAINT;
            i10 = i2 + 1;
            cVar52 = cVar;
        }
        if (cVar52.d != null) {
            int i37 = i2 + 1;
            if (eVar9.S[i37].f != null) {
                d.f.a.m.d dVar31 = fVar3.S[i37];
                if (fVar3.V[i32] == e.b.MATCH_CONSTRAINT) {
                    int r3 = fVar3.u[i32] == 0 ? 1 : 0;
                }
                if (eVar3.V != 0 && e.b.WRAP_CONTENT == 0) {
                    if (dVar50.d == fVar2) {
                        i2 = -dVar31.e();
                        i32 = 5;
                        cVar52.e(dVar31.i, dVar50.i, i2, i32);
                    } else {
                        i32 = 5;
                        if (e.b.WRAP_CONTENT != 0) {
                            if (dVar51.d == fVar2) {
                                i2 = -dVar31.e();
                                cVar52.e(dVar31.i, dVar51.i, i2, 4);
                            }
                        }
                    }
                }
                i7 = -dVar31.e();
                i19 = 6;
                cVar52.j(dVar31.i, eVar9.S[i37].f.i, i7, i19);
            } else {
                i32 = 5;
            }
        }
        if (fVar2.V != 0) {
            int i35 = i2 + 1;
            cVar52.h(fVar2.S[i35].i, objArr33[i35].i, objArr33[i35].e(), 8);
        }
        cVar52 = cVar;
        if (cVar52.h != null && cVar52.h.size() > 1) {
            f2 = !cVar52.q || cVar52.s ? f2 : (float)i52;
            i19 = 0;
            i2 = 0;
            while (i2 < cVar52.e) {
                Object item = list.get(i2);
                f3 = item.o0[i32];
                i2 = i2 + 1;
                list = f2;
                i15 = 1;
                i19 = 0;
                i32 = 5;
            }
        }
        if (cVar52.b == null || cVar52.b != cVar52.d) {
            if (i12 == 0 || cVar52.b == null) {
                i32 = 8;
                if (i12 != 0 && cVar52.b != null) {
                    int r17 = cVar52.j > 0 && cVar52.i == cVar52.j ? 1 : 0;
                    while (dVar14.f != null) {
                        fVar3 = fVar3.q0[i32];
                        while (cVar52.i != null) {
                        }
                        d.f.a.m.e r7 = fVar3;
                        fVar3 = cVar52;
                        i32 = i;
                    }
                    dVar22 = fVar3.S[i2];
                    i16 = i2 + 1;
                    d.f.a.m.d dVar70 = fVar3.S[i16];
                    if (eVar3.S[i2].f == null) {
                        i12 = 5;
                    } else {
                        if (cVar52.b != cVar52.d) {
                            i12 = 5;
                            cVar52.e(dVar22.i, dVar5.i, dVar22.e(), i12);
                        } else {
                            i12 = 5;
                            if (eVar9.S[i16].f != null) {
                                i32 = 5;
                                dVar.c(iVar5, iVar11, i16, 1056964608, iVar16, iVar22, i21, i32);
                            }
                        }
                    }
                    if (eVar9.S[i16].f != null && cVar52.b != cVar52.d) {
                        cVar52.e(dVar70.i, dVar72.i, -dVar70.e(), i12);
                    }
                }
            } else {
                r17 = cVar52.j > 0 && cVar52.i == cVar52.j ? 1 : 0;
                while (dVar14.f != null) {
                    while (dVar72.i != null) {
                        i19 = 8;
                    }
                    i19 = 8;
                    i19 = 8;
                }
            }
        } else {
            if (e.b.WRAP_CONTENT != 0) {
                int i40 = i2 + 1;
                d.f.a.i iVar2 = eVar3.S[i2].f != null ? iVar2 : i12;
                iVar = eVar9.S[i40].f != null ? iVar : i12;
                d.f.a.m.d dVar21 = fVar3.S[i2];
                if (cVar52.d != null) {
                    dVar6 = fVar3.S[i40];
                }
                if (dVar31.i != 0 && e.b.WRAP_CONTENT != null) {
                    f = i32 == 0 ? eVar2.g0 : eVar2.h0;
                    i32 = 7;
                    dVar.c(iVar7, i12, i17, f, iVar, iVar24, dVar6.e(), i32);
                }
            }
        }
        if (i12 != 0 || i12 != 0) {
            if (cVar52.b != null && cVar52.b != cVar52.d) {
                if (cVar52.d == null) {
                }
                int i51 = i2 + 1;
                r4 = objArr13[i2].f != null ? dVar60.i : i12;
                r5 = fVar3.S[i51].f != null ? dVar63.i : i12;
                if (cVar52.c != cVar52.d) {
                    if (eVar9.S[i51].f != null) {
                    }
                }
                if (cVar52.b == cVar52.d) {
                    dVar7 = objArr13[i2];
                    dVar10 = objArr13[i51];
                }
                if (fVar2.V != 0 && e.b.WRAP_CONTENT != null) {
                    dVar.c(dVar7.i, i12, i18, 1056964608, iVar42, iVar25, i2, i32);
                }
            }
        }
    }

    public static void b(f fVar, d dVar, ArrayList<e> arrayList, int i) {
        int i2;
        d.f.a.m.c[] objArr;
        boolean contains;
        i = 0;
        if (i == 0) {
        } else {
            i = 2;
        }
        while (i < fVar.E0) {
            d.f.a.m.c cVar = objArr[i];
            cVar.a();
            i = i + 1;
        }
    }
}
