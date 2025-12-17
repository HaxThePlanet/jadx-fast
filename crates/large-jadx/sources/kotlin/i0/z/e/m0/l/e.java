package kotlin.i0.z.e.m0.l;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.l1.a;
import kotlin.i0.z.e.m0.l.l1.b;
import kotlin.i0.z.e.m0.l.l1.h;
import kotlin.i0.z.e.m0.l.l1.i;
import kotlin.i0.z.e.m0.l.l1.j;
import kotlin.i0.z.e.m0.l.l1.l;
import kotlin.i0.z.e.m0.l.l1.n;
import kotlin.i0.z.e.m0.l.l1.r;
import kotlin.reflect.jvm.internal.impl.utils.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class e {

    public static final kotlin.i0.z.e.m0.l.e a;
    public static boolean b;

    public class a {

        public static final int[] a;
        public static final int[] b;
        static {
            int[] iArr = new int[values.length];
            final int i = 1;
            iArr[r.INV.ordinal()] = i;
            final int i2 = 2;
            iArr[r.OUT.ordinal()] = i2;
            final int i3 = 3;
            iArr[r.IN.ordinal()] = i3;
            e.a.a = iArr;
            int[] iArr2 = new int[values2.length];
            iArr2[f.a.CHECK_ONLY_LOWER.ordinal()] = i;
            iArr2[f.a.CHECK_SUBTYPE_AND_LOWER.ordinal()] = i2;
            iArr2[f.a.SKIP_LOWER.ordinal()] = i3;
            e.a.b = iArr2;
        }
    }
    static {
        e eVar = new e();
        e.a = eVar;
    }

    private final Boolean a(kotlin.i0.z.e.m0.l.f f, i i2, i i3) {
        boolean z2;
        boolean z;
        int i;
        boolean obj3;
        final int i4 = 0;
        if (!f.A0(i2) && !f.A0(i3)) {
            if (!f.A0(i3)) {
                return i4;
            }
        }
        if (f.A0(i2) && f.A0(i3)) {
            if (f.A0(i3)) {
                return Boolean.TRUE;
            }
        }
        if (f.A0(i2)) {
            if (e.c(f, this, i2, i3, false)) {
                return Boolean.TRUE;
            }
        } else {
            if (f.A0(i3) && !e.b(f, i2) && e.c(f, this, i3, i2, true)) {
                if (!e.b(f, i2)) {
                    if (e.c(f, this, i3, i2, true)) {
                    }
                }
                return Boolean.TRUE;
            }
        }
        return i4;
    }

    private static final boolean b(kotlin.i0.z.e.m0.l.f f, i i2) {
        boolean empty;
        int valueOf;
        int i;
        Boolean tRUE;
        int obj4;
        Collection obj5;
        obj5 = f.b(i2);
        final int i3 = 0;
        if (obj5 instanceof g) {
            obj5 = f.n(obj5);
            if (obj5 instanceof Collection != null && obj5.isEmpty()) {
                if (obj5.isEmpty()) {
                    obj4 = i3;
                } else {
                    obj5 = obj5.iterator();
                    while (obj5.hasNext()) {
                        i iVar = f.a((h)obj5.next());
                        if (iVar == null) {
                        } else {
                        }
                        valueOf = Boolean.valueOf(f.A0(iVar));
                        valueOf = 0;
                    }
                }
            } else {
            }
            if (obj4 != null) {
            } else {
                i = i3;
            }
        } else {
        }
        return i;
    }

    private static final boolean c(kotlin.i0.z.e.m0.l.f f, kotlin.i0.z.e.m0.l.e e2, i i3, i i4, boolean z5) {
        boolean empty;
        boolean z;
        int i2;
        l lVar;
        kotlin.i0.z.e.m0.l.f fVar;
        i iVar;
        Object obj;
        int i6;
        int i5;
        int i;
        Object obj12;
        obj12 = f.p(i3);
        final int i7 = 0;
        if (obj12 instanceof Collection != null && obj12.isEmpty()) {
            if (obj12.isEmpty()) {
                i2 = i7;
            } else {
                obj12 = obj12.iterator();
                while (obj12.hasNext()) {
                    obj = next;
                    if (!n.b(f.q((h)obj), f.b(i4))) {
                    } else {
                    }
                    empty = i2;
                    if (!empty) {
                        break;
                    }
                    if (z5 && e.o(e2, f, i4, obj, false, 8, 0)) {
                    } else {
                    }
                    empty = i7;
                    if (e.o(e2, f, i4, obj, false, 8, 0)) {
                    } else {
                    }
                }
            }
        } else {
        }
        return i2;
    }

    private final Boolean d(kotlin.i0.z.e.m0.l.f f, i i2, i i3) {
        boolean z2;
        h hVar4;
        kotlin.i0.z.e.m0.l.l1.c cVar;
        boolean empty;
        boolean z3;
        boolean z;
        int i;
        h hVar3;
        kotlin.i0.z.e.m0.l.e eVar;
        kotlin.i0.z.e.m0.l.f fVar;
        h hVar;
        h hVar2;
        int i4;
        int i5;
        int i6;
        Collection obj15;
        i = 0;
        if (!f.J(i2)) {
            if (f.J(i3)) {
            } else {
                if (!f.V(i2)) {
                    if (f.V(i3)) {
                    } else {
                        kotlin.i0.z.e.m0.l.l1.d dVar = f.a0(i3);
                        if (dVar == null) {
                            hVar4 = i3;
                        } else {
                            hVar4 = f.w(dVar);
                        }
                        cVar = f.O(hVar4);
                        final int i7 = 0;
                        if (cVar == null) {
                            hVar3 = i7;
                        } else {
                            hVar3 = f.G(cVar);
                        }
                        final int i8 = 1;
                        if (cVar != null && hVar3 != null) {
                            if (hVar3 != null) {
                                if (f.I(i3)) {
                                    hVar3 = f.v(hVar3, i8);
                                } else {
                                    if (f.x0(i3)) {
                                        hVar3 = f.D(hVar3);
                                    }
                                }
                                hVar2 = hVar3;
                                cVar = e.a.b[f.q0(i2, cVar).ordinal()];
                                if (cVar != i8) {
                                    if (cVar != 2) {
                                    } else {
                                        if (e.o(this, f, i2, hVar2, false, 8, 0)) {
                                            return Boolean.TRUE;
                                        }
                                    }
                                }
                                return Boolean.valueOf(e.o(this, f, i2, hVar2, false, 8, 0));
                            }
                        }
                        l lVar = f.b(i3);
                        if (f.K(lVar)) {
                            f.I(i3);
                            obj15 = f.n(lVar);
                            if (obj15 instanceof Collection != null && obj15.isEmpty()) {
                                if (obj15.isEmpty()) {
                                    i = i8;
                                } else {
                                    obj15 = obj15.iterator();
                                    while (obj15.hasNext()) {
                                        if (e.o(this, f, i2, (h)obj15.next(), false, 8, 0)) {
                                            break;
                                        }
                                    }
                                }
                            } else {
                            }
                            return Boolean.valueOf(i);
                        }
                    }
                    return i7;
                }
            }
            return Boolean.valueOf(f.C0());
        }
        if (f.z0()) {
            return Boolean.TRUE;
        }
        if (f.I(i2) && !f.I(i3)) {
            if (!f.I(i3)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.valueOf(d.a.b(f, f.c(i2, i), f.c(i3, i)));
    }

    private final List<i> e(kotlin.i0.z.e.m0.l.f f, i i2, l l3) {
        Object iVar2;
        boolean z2;
        ArrayDeque queue;
        Set set;
        int iterator;
        kotlin.i0.z.e.m0.l.f.b.b bVar;
        Object iVar;
        int next;
        int z;
        List obj12;
        i obj13;
        b obj14;
        if (f.o0(i2, l3) == null && !f.H(l3) && f.w0(i2)) {
            if (!f.H(l3)) {
                if (f.w0(i2)) {
                    return p.g();
                }
            }
            if (f.c0(l3)) {
                if (f.f0(f.b(i2), l3)) {
                    obj12 = f.Z(i2, b.FOR_SUBTYPING);
                    if (obj12 == null) {
                    } else {
                        obj13 = obj12;
                    }
                    obj12 = p.b(obj13);
                } else {
                    obj12 = p.g();
                }
                return obj12;
            }
            iVar2 = new i();
            f.u0();
            queue = f.r0();
            n.d(queue);
            set = f.s0();
            n.d(set);
            queue.push(i2);
            while (empty ^= 1 != 0) {
                iterator = queue.pop();
                n.e((i)iterator, "current");
                if (!set.add(iterator)) {
                } else {
                }
                if (f.Z(iterator, b.FOR_SUBTYPING) == null) {
                }
                if (f.f0(f.b(iVar), l3)) {
                } else {
                }
                if (f.h(iVar) == 0) {
                } else {
                }
                bVar = f.F0(iVar);
                if (z4 ^= 1 != 0) {
                } else {
                }
                bVar = 0;
                if (bVar == null) {
                } else {
                }
                iterator = f.n(f.b(iterator)).iterator();
                for (h next2 : iterator) {
                    queue.add(bVar.a(f, next2));
                }
                queue.add(bVar.a(f, (h)iterator.next()));
                bVar = f.b.b.a;
                iVar2.add(iVar);
                bVar = f.b.c.a;
                iVar = iterator;
            }
            f.m0();
        }
        return iVar2;
    }

    private final List<i> f(kotlin.i0.z.e.m0.l.f f, i i2, l l3) {
        return q(f, e(f, i2, l3));
    }

    private final boolean g(kotlin.i0.z.e.m0.l.f f, h h2, h h3, boolean z4) {
        Boolean bool = d(f, f.Q(h2), f.F(h3));
        final Boolean obj6 = f.k0(h2, h3, z4);
        if (bool == null && obj6 == null) {
            obj6 = f.k0(h2, h3, z4);
            if (obj6 == null) {
                return p(f, f.Q(h2), f.F(h3));
            }
            return obj6.booleanValue();
        }
        f.k0(h2, h3, z4);
        return bool.booleanValue();
    }

    private final boolean k(kotlin.i0.z.e.m0.l.f f, i i2) {
        boolean z2;
        int i3;
        Set set;
        Object iterator;
        int i;
        int next;
        boolean z;
        l lVar = f.b(i2);
        if (f.H(lVar)) {
            return f.l(lVar);
        }
        i3 = 1;
        if (f.l(f.b(i2))) {
        } else {
            f.u0();
            z2 = f.r0();
            n.d(z2);
            set = f.s0();
            n.d(set);
            z2.push(i2);
            while (empty ^= i3 != 0) {
                iterator = z2.pop();
                n.e((i)iterator, "current");
                if (f.w0(iterator)) {
                } else {
                }
                i = f.b.b.a;
                if (z5 ^= i3 != 0) {
                } else {
                }
                i = 0;
                iterator = f.n(f.b(iterator)).iterator();
                for (h next2 : iterator) {
                    next = i.a(f, next2);
                    z2.add(next);
                }
                next = i.a(f, (h)iterator.next());
                z2.add(next);
                i = f.b.c.a;
            }
            f.m0();
            i3 = 0;
        }
        return i3;
    }

    private final boolean l(kotlin.i0.z.e.m0.l.f f, h h2) {
        boolean z;
        boolean obj2;
        h obj3;
        if (f.r(f.q(h2)) && !f.y0(h2) && !f.x0(h2) && n.b(f.b(f.Q(h2)), f.b(f.F(h2)))) {
            if (!f.y0(h2)) {
                if (!f.x0(h2)) {
                    obj2 = n.b(f.b(f.Q(h2)), f.b(f.F(h2))) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    public static boolean o(kotlin.i0.z.e.m0.l.e e, kotlin.i0.z.e.m0.l.f f2, h h3, h h4, boolean z5, int i6, Object object7) {
        int obj4;
        if (i6 &= 8 != 0) {
            obj4 = 0;
        }
        return e.n(f2, h3, h4, obj4);
    }

    private final boolean p(kotlin.i0.z.e.m0.l.f f, i i2, i i3) {
        i iVar;
        boolean z3;
        l lVar;
        boolean iterator;
        boolean z;
        int next;
        kotlin.i0.z.e.m0.l.l1.k kVar;
        int i7;
        boolean z2;
        int i6;
        int i5;
        int i;
        int i4;
        ArrayList arrayList;
        Iterator iterator2;
        boolean next2;
        int i8;
        l lVar2;
        final Object obj = this;
        kotlin.i0.z.e.m0.l.f fVar = f;
        iVar = i2;
        i iVar3 = i3;
        if (e.b && !f.C(i2) && !fVar.K(f.b(i2))) {
            if (!f.C(i2)) {
                if (!fVar.K(f.b(i2))) {
                    z = f.v0(i2);
                }
            }
            if (!fVar.C(iVar3)) {
                z3 = fVar.v0(iVar3);
            }
        }
        next = 0;
        if (!c.a.d(fVar, iVar, iVar3)) {
            return next;
        }
        Boolean bool = obj.a(fVar, f.Q(i2), fVar.F(iVar3));
        lVar = fVar.b(iVar3);
        i6 = 1;
        if (bool == null && fVar.f0(f.b(i2), lVar) && fVar.f(lVar) == 0) {
            lVar = fVar.b(iVar3);
            i6 = 1;
            if (fVar.f0(f.b(i2), lVar)) {
                if (fVar.f(lVar) == 0) {
                    return i6;
                }
            }
            if (fVar.T(fVar.b(iVar3))) {
                return i6;
            }
            List list = obj.j(fVar, iVar, lVar);
            int size = list.size();
            a aVar = new a(fVar.f(lVar));
            int i15 = fVar.f(lVar);
            if (size != 0 && size != i6 && i15 > 0) {
                if (size != i6) {
                    aVar = new a(fVar.f(lVar));
                    i15 = fVar.f(lVar);
                    if (i15 > 0) {
                        i = i5;
                        i4 = i5 + 1;
                        while (i == 0) {
                            if (fVar.A(fVar.s(lVar, i5)) != r.OUT) {
                            } else {
                            }
                            i = next;
                            arrayList = new ArrayList(p.r(list, 10));
                            iterator2 = list.iterator();
                            while (iterator2.hasNext()) {
                                next2 = iterator2.next();
                                kVar = fVar.p0((i)next2, i5);
                                if (kVar == null) {
                                } else {
                                }
                                lVar2 = lVar;
                                if (fVar.S(kVar) == r.INV) {
                                } else {
                                }
                                lVar = 0;
                                if (lVar == null) {
                                }
                                kVar = i8;
                                arrayList.add(fVar.d0(kVar));
                                lVar = lVar2;
                                next = 0;
                                i6 = 1;
                                lVar = 1;
                                lVar2 = lVar;
                            }
                            lVar2 = lVar;
                            aVar.add(fVar.N(fVar.B(arrayList)));
                            i5 = i4;
                            lVar = lVar2;
                            next = 0;
                            i6 = 1;
                            i4 = i5 + 1;
                            i = i6;
                            next2 = iterator2.next();
                            kVar = fVar.p0((i)next2, i5);
                            if (kVar == null) {
                            } else {
                            }
                            lVar2 = lVar;
                            if (fVar.S(kVar) == r.INV) {
                            } else {
                            }
                            lVar = 0;
                            if (lVar == null) {
                            }
                            kVar = i8;
                            arrayList.add(fVar.d0(kVar));
                            lVar = lVar2;
                            next = 0;
                            i6 = 1;
                            lVar = 1;
                            lVar2 = lVar;
                            lVar2 = lVar;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Incorrect type: ");
                        stringBuilder.append(next2);
                        stringBuilder.append(", subType: ");
                        stringBuilder.append(iVar);
                        stringBuilder.append(", superType: ");
                        stringBuilder.append(iVar3);
                        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString().toString());
                        throw illegalStateException;
                    }
                    i = 0;
                    if (i == 0 && obj.m(fVar, aVar, iVar3)) {
                        if (obj.m(fVar, aVar, iVar3)) {
                            return 1;
                        }
                    }
                    if (list instanceof Collection != null && list.isEmpty()) {
                        if (list.isEmpty()) {
                            i7 = 0;
                        } else {
                            iterator = list.iterator();
                            for (i next3 : iterator) {
                            }
                        }
                    } else {
                    }
                    return i7;
                }
                return obj.m(fVar, fVar.m((i)p.X(list)), iVar3);
            }
            return k(f, i2);
        }
        f.l0(f, i2, i3, false, 4, 0);
        return bool.booleanValue();
    }

    private final List<i> q(kotlin.i0.z.e.m0.l.f f, List<? extends i> list2) {
        Object next;
        int i3;
        j jVar;
        int i5;
        int i4;
        int i;
        int i2;
        ArrayList obj11;
        if (list2.size() < 2) {
            return list2;
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list2.iterator();
        i3 = 1;
        for (Object next : iterator) {
            jVar = f.m((i)next);
            i4 = 0;
            i = i4;
            while (i < f.E(jVar)) {
                if (f.z(f.d0(f.o(jVar, i))) == null) {
                } else {
                }
                i2 = i4;
                if (i2 == 0) {
                    break loop_5;
                } else {
                }
                i++;
                i2 = i3;
            }
            if (i3 != 0) {
            }
            i3 = 1;
            arrayList.add(next);
            if (f.z(f.d0(f.o(jVar, i))) == null) {
            } else {
            }
            i2 = i4;
            if (i2 == 0) {
            } else {
            }
            i++;
            i3 = i4;
            i2 = i3;
        }
        if (obj10 ^= i3 != 0) {
            obj11 = arrayList;
        }
        return obj11;
    }

    public final r h(r r, r r2) {
        n.f(r, "declared");
        n.f(r2, "useSite");
        r iNV = r.INV;
        if (r == iNV) {
            return r2;
        }
        if (r2 == iNV) {
            return r;
        }
        if (r == r2) {
            return r;
        }
        return null;
    }

    public final boolean i(kotlin.i0.z.e.m0.l.f f, h h2, h h3) {
        int i2;
        boolean z;
        h hVar;
        kotlin.i0.z.e.m0.l.e eVar;
        i iVar;
        Object obj;
        int i5;
        Object obj2;
        l lVar;
        Object obj3;
        int i;
        int i3;
        int i4;
        Object obj11;
        boolean obj12;
        Object obj13;
        n.f(f, "context");
        n.f(h2, "a");
        n.f(h3, "b");
        if (h2 == h3) {
            return 1;
        }
        final int i6 = 0;
        z = f.E0(h2);
        hVar = f.E0(h3);
        iVar = f.Q(z);
        if (l(f, h2) && l(f, h3) && !f.f0(f.q(z), f.q(hVar))) {
            if (l(f, h3)) {
                z = f.E0(h2);
                hVar = f.E0(h3);
                iVar = f.Q(z);
                if (!f.f0(f.q(z), f.q(hVar))) {
                    return i6;
                }
                if (f.h(iVar) == 0 && !f.t0(z)) {
                    if (!f.t0(z)) {
                        if (f.t0(hVar)) {
                        } else {
                            if (f.I(iVar) == f.I(f.Q(hVar))) {
                            } else {
                                i2 = i6;
                            }
                        }
                    }
                    return i2;
                }
            }
        }
        if (e.o(this, f, h2, h3, false, 8, 0) && e.o(this, f, h3, h2, false, 8, 0)) {
            if (e.o(this, f, h3, h2, false, 8, 0)) {
            } else {
                i2 = i6;
            }
        } else {
        }
        return i2;
    }

    public final List<i> j(kotlin.i0.z.e.m0.l.f f, i i2, l l3) {
        boolean z2;
        ArrayDeque queue;
        Set str;
        Object iterator;
        boolean z;
        int next;
        n.f(f, "<this>");
        n.f(i2, "subType");
        n.f(l3, "superConstructor");
        if (f.w0(i2)) {
            return f(f, i2, l3);
        }
        if (!f.H(l3) && !f.Y(l3)) {
            if (!f.Y(l3)) {
                return e(f, i2, l3);
            }
        }
        i iVar = new i();
        f.u0();
        queue = f.r0();
        n.d(queue);
        str = f.s0();
        n.d(str);
        queue.push(i2);
        while (empty ^= 1 != 0) {
            iterator = queue.pop();
            n.e((i)iterator, "current");
            if (!str.add(iterator)) {
            } else {
            }
            if (f.w0(iterator)) {
            } else {
            }
            z = f.b.b.a;
            if (z5 ^= 1 != 0) {
            } else {
            }
            z = 0;
            if (z == null) {
            } else {
            }
            iterator = f.n(f.b(iterator)).iterator();
            for (h next4 : iterator) {
                queue.add(z.a(f, next4));
            }
            queue.add(z.a(f, (h)iterator.next()));
            iVar.add(iterator);
            z = f.b.c.a;
        }
        f.m0();
        ArrayList obj13 = new ArrayList();
        Iterator iterator2 = iVar.iterator();
        for (i next3 : iterator2) {
            n.e(next3, "it");
            p.y(obj13, f(f, next3, l3));
        }
        return obj13;
    }

    public final boolean m(kotlin.i0.z.e.m0.l.f f, j j2, i i3) {
        String str;
        kotlin.i0.z.e.m0.l.l1.k kVar;
        int[] iArr;
        boolean z;
        h hVar;
        h hVar2;
        r iNV;
        int i4;
        int i5;
        int i;
        int i2;
        final kotlin.i0.z.e.m0.l.e eVar3 = this;
        final Object obj = f;
        final Object obj2 = j2;
        final Object obj3 = i3;
        n.f(obj, "<this>");
        n.f(obj2, "capturedSubArguments");
        n.f(obj3, "superType");
        final l lVar = obj.b(obj3);
        final int i17 = obj.f(lVar);
        final int i18 = 1;
        if (i17 > 0) {
            i5 = 0;
            str = i5;
            i = str + 1;
            kVar = obj.P(obj3, str);
            while (obj.y(kVar)) {
                str = i;
                i = str + 1;
                kVar = obj.P(obj3, str);
                hVar = obj.d0(kVar);
                kotlin.i0.z.e.m0.l.l1.k kVar2 = obj.o(obj2, str);
                r rVar4 = obj.S(kVar2);
                iNV = r.INV;
                hVar2 = obj.d0(kVar2);
                r rVar2 = eVar3.h(obj.A(obj.s(lVar, str)), obj.S(kVar));
                f.j0(obj, i8 += i18);
                int i6 = e.a.a[rVar2.ordinal()];
                str = eVar3.i(obj, hVar2, hVar);
                f.j0(obj, i10--);
                str = e.o(this, f, hVar2, hVar, false, 8, 0);
                str = e.o(this, f, hVar, hVar2, false, 8, 0);
            }
            return f.z0();
        }
        return i18;
    }

    public final boolean n(kotlin.i0.z.e.m0.l.f f, h h2, h h3, boolean z4) {
        n.f(f, "context");
        n.f(h2, "subType");
        n.f(h3, "superType");
        if (h2 == h3) {
            return 1;
        }
        if (!f.n0(h2, h3)) {
            return 0;
        }
        return g(f, f.D0(f.E0(h2)), f.D0(f.E0(h3)), z4);
    }
}
