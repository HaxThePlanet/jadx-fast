package kotlin.i0.z.e.m0.l.n1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.i.p.a.b;
import kotlin.i0.z.e.m0.i.p.a.d;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.e1;
import kotlin.i0.z.e.m0.l.g1;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.u0;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.i0.z.e.m0.l.x0;
import kotlin.i0.z.e.m0.l.y;
import kotlin.i0.z.e.m0.l.z0;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class b {

    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[h1.INVARIANT.ordinal()] = 1;
            iArr[h1.IN_VARIANCE.ordinal()] = 2;
            iArr[h1.OUT_VARIANCE.ordinal()] = 3;
            b.a.a = iArr;
        }
    }

    public static final class c extends u0 {
        @Override // kotlin.i0.z.e.m0.l.u0
        public v0 j(t0 t0) {
            int obj3;
            n.f(t0, "key");
            int i = 0;
            if (t0 instanceof b) {
            } else {
                obj3 = i;
            }
            if (obj3 == null) {
                return i;
            }
            if (obj3.e().c()) {
                x0 x0Var = new x0(h1.OUT_VARIANCE, obj3.e().getType());
                return x0Var;
            }
            return obj3.e();
        }
    }

    static final class b extends p implements l<g1, Boolean> {

        public static final kotlin.i0.z.e.m0.l.n1.b.b a;
        static {
            b.b bVar = new b.b();
            b.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final Boolean a(g1 g1) {
            n.e(g1, "it");
            return Boolean.valueOf(d.d(g1));
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((g1)object);
        }
    }
    public static final kotlin.i0.z.e.m0.l.n1.a<b0> a(b0 b0) {
        kotlin.i0.z.e.m0.l.n1.a aVar;
        boolean iterator;
        boolean empty;
        b0 b0Var;
        String str;
        kotlin.i0.z.e.m0.l.i0 i2;
        int size;
        int i;
        List list;
        int i3;
        String str2;
        String next;
        b0 obj7;
        n.f(b0, "type");
        if (y.b(b0)) {
            kotlin.i0.z.e.m0.l.n1.a aVar2 = b.a(y.c(b0));
            kotlin.i0.z.e.m0.l.n1.a aVar5 = b.a(y.d(b0));
            c0 c0Var = c0.a;
            a aVar6 = new a(e1.b(c0.d(y.c((b0)aVar2.c()), y.d((b0)aVar5.c())), b0), e1.b(c0.d(y.c((b0)aVar2.d()), y.d((b0)aVar5.d())), b0));
            return aVar6;
        }
        t0 t0Var = b0.L0();
        str = "type.builtIns.nothingType";
        v0 v0Var = (b)t0Var.e();
        b0 type = v0Var.getType();
        n.e(type, "typeProjection.type");
        b0 b0Var2 = b.b(type, b0);
        i2 = b.a.a[v0Var.a().ordinal()];
        if (d.d(b0) && i2 != 2) {
            v0Var = (b)t0Var.e();
            type = v0Var.getType();
            n.e(type, "typeProjection.type");
            b0Var2 = b.b(type, b0);
            i2 = b.a.a[v0Var.a().ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                } else {
                    i2 = a.e(b0).H();
                    n.e(i2, str);
                    aVar = new a(b.b(i2, b0), b0Var2);
                    return aVar;
                }
                obj7 = new AssertionError(n.o("Only nontrivial projections should have been captured, not: ", v0Var));
                throw obj7;
            }
            obj7 = a.e(b0).I();
            n.e(obj7, "type.builtIns.nullableAnyType");
            aVar = new a(b0Var2, obj7);
        }
        if (!b0.K0().isEmpty()) {
            if (b0.K0().size() != t0Var.getParameters().size()) {
            } else {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                List parameters = t0Var.getParameters();
                n.e(parameters, "typeConstructor.parameters");
                Iterator iterator2 = p.S0(b0.K0(), parameters).iterator();
                while (iterator2.hasNext()) {
                    Object next3 = iterator2.next();
                    Object obj6 = (o)next3.a();
                    Object obj5 = next3.b();
                    n.e((z0)obj5, "typeParameter");
                    list = b.g((v0)obj6, obj5);
                    if (obj6.c() != null) {
                    } else {
                    }
                    kotlin.i0.z.e.m0.l.n1.a aVar7 = b.d(list);
                    arrayList.add((c)aVar7.a());
                    arrayList2.add((c)aVar7.b());
                    arrayList.add(list);
                    arrayList2.add(list);
                }
                if (arrayList.isEmpty()) {
                    i3 = i4;
                } else {
                    iterator = arrayList.iterator();
                    while (iterator.hasNext()) {
                        if (z3 ^= i3 == 0) {
                            break;
                        }
                    }
                }
                if (i3 != 0) {
                    n.e(a.e(b0).H(), str);
                } else {
                    b0Var = b.e(b0, arrayList);
                }
            }
            a aVar4 = new a(b0Var, b.e(b0, arrayList2));
            return aVar4;
        }
        a aVar3 = new a(b0, b0);
        return aVar3;
    }

    private static final b0 b(b0 b0, b0 b02) {
        final b0 obj0 = c1.q(b0, b02.M0());
        n.e(obj0, "makeNullableIfNeeded(this, type.isMarkedNullable)");
        return obj0;
    }

    public static final v0 c(v0 v0, boolean z2) {
        if (v0 == null) {
            return null;
        }
        if (v0.c()) {
            return v0;
        }
        b0 type = v0.getType();
        n.e(type, "typeProjection.type");
        if (!c1.c(type, b.b.a)) {
            return v0;
        }
        h1 h1Var = v0.a();
        n.e(h1Var, "typeProjection.projectionKind");
        if (h1Var == h1.OUT_VARIANCE) {
            x0 obj4 = new x0(h1Var, (b0)b.a(type).d());
            return obj4;
        }
        if (z2) {
            obj4 = new x0(h1Var, (b0)b.a(type).c());
            return obj4;
        }
        return b.f(v0);
    }

    private static final kotlin.i0.z.e.m0.l.n1.a<kotlin.i0.z.e.m0.l.n1.c> d(kotlin.i0.z.e.m0.l.n1.c c) {
        kotlin.i0.z.e.m0.l.n1.a aVar = b.a(c.a());
        kotlin.i0.z.e.m0.l.n1.a aVar2 = b.a(c.b());
        c cVar2 = new c(c.c(), (b0)aVar.b(), (b0)aVar2.a());
        c cVar = new c(c.c(), (b0)aVar.a(), (b0)aVar2.b());
        a aVar3 = new a(cVar2, cVar);
        return aVar3;
    }

    private static final b0 e(b0 b0, List<kotlin.i0.z.e.m0.l.n1.c> list2) {
        int i;
        int size = b0.K0().size();
        final int size2 = list2.size();
        ArrayList arrayList = new ArrayList(p.r(list2, 10));
        final Iterator obj9 = list2.iterator();
        for (c next2 : obj9) {
            arrayList.add(b.h(next2));
        }
        return z0.e(b0, arrayList, 0, 0, 6, 0);
    }

    private static final v0 f(v0 v0) {
        b.c cVar = new b.c();
        a1 a1Var = a1.g(cVar);
        n.e(a1Var, "create(object : TypeConstructorSubstitution() {\n        override fun get(key: TypeConstructor): TypeProjection? {\n            val capturedTypeConstructor = key as? CapturedTypeConstructor ?: return null\n            if (capturedTypeConstructor.projection.isStarProjection) {\n                return TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.projection.type)\n            }\n            return capturedTypeConstructor.projection\n        }\n    })");
        return a1Var.t(v0);
    }

    private static final kotlin.i0.z.e.m0.l.n1.c g(v0 v0, z0 z02) {
        kotlin.i0.z.e.m0.l.n1.c cVar;
        b0 type;
        String str;
        String str2;
        b0 obj4;
        int i = b.a.a[a1.c(z02.l(), v0).ordinal()];
        str = "type";
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                } else {
                    type = a.g(z02).H();
                    n.e(type, "typeParameter.builtIns.nothingType");
                    obj4 = v0.getType();
                    n.e(obj4, str);
                    cVar = new c(z02, type, obj4);
                }
                obj4 = new NoWhenBranchMatchedException();
                throw obj4;
            }
            obj4 = v0.getType();
            n.e(obj4, str);
            type = a.g(z02).I();
            n.e(type, "typeParameter.builtIns.nullableAnyType");
            cVar = new c(z02, obj4, type);
        } else {
            type = v0.getType();
            n.e(type, str);
            obj4 = v0.getType();
            n.e(obj4, str);
            cVar = new c(z02, type, obj4);
        }
        return cVar;
    }

    private static final v0 h(kotlin.i0.z.e.m0.l.n1.c c) {
        x0 x0Var;
        boolean z;
        boolean z2;
        Object iN_VARIANCE;
        b0 obj2;
        c.d();
        if (!n.b(c.a(), c.b())) {
            iN_VARIANCE = h1.IN_VARIANCE;
            if (c.c().l() == iN_VARIANCE) {
                x0Var = new x0(c.a());
            } else {
                if (h.t0(c.a()) && c.c().l() != iN_VARIANCE) {
                    if (c.c().l() != iN_VARIANCE) {
                        x0Var = new x0(b.i(c, h1.OUT_VARIANCE), c.b());
                    } else {
                        if (h.v0(c.b())) {
                            x0Var = new x0(b.i(c, iN_VARIANCE), c.a());
                        } else {
                            x0Var = new x0(b.i(c, h1.OUT_VARIANCE), c.b());
                        }
                    }
                } else {
                }
            }
        } else {
        }
        return x0Var;
    }

    private static final h1 i(kotlin.i0.z.e.m0.l.n1.c c, h1 h12) {
        h1 obj1;
        if (h12 == c.c().l()) {
            obj1 = h1.INVARIANT;
        }
        return obj1;
    }
}
