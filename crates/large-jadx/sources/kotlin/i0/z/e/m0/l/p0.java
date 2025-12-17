package kotlin.i0.z.e.m0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.i.v.h.b;
import kotlin.i0.z.e.m0.l.j1.f;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.i;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class p0 {

    public static final kotlin.i0.z.e.m0.l.p0.a c;
    private final kotlin.i0.z.e.m0.l.r0 a;
    private final boolean b;

    public static final class a {
        public a(g g) {
            super();
        }

        public static final void a(kotlin.i0.z.e.m0.l.p0.a p0$a, int i2, y0 y03) {
            a.b(i2, y03);
        }

        private final void b(int i, y0 y02) {
            if (i > 100) {
            } else {
            }
            AssertionError obj2 = new AssertionError(n.o("Too deep recursion while expanding type alias ", y02.getName()));
            throw obj2;
        }

        public final void c(kotlin.i0.z.e.m0.l.r0 r0, kotlin.i0.z.e.m0.l.b0 b02, kotlin.i0.z.e.m0.l.b0 b03, z0 z04, kotlin.i0.z.e.m0.l.a1 a15) {
            kotlin.i0.z.e.m0.l.b0 b0Var;
            boolean z;
            n.f(r0, "reportStrategy");
            n.f(b02, "unsubstitutedArgument");
            n.f(b03, "typeArgument");
            n.f(z04, "typeParameterDescriptor");
            n.f(a15, "substitutor");
            Iterator iterator = z04.getUpperBounds().iterator();
            while (iterator.hasNext()) {
                b0Var = a15.n((b0)iterator.next(), h1.INVARIANT);
                n.e(b0Var, "substitutor.safeSubstitute(bound, Variance.INVARIANT)");
                if (!f.a.d(b03, b0Var)) {
                }
                r0.a(b0Var, b02, b03, z04);
            }
        }
    }
    static {
        p0.a aVar = new p0.a(0);
        p0.c = aVar;
        p0 p0Var = new p0(r0.a.a, 0);
    }

    public p0(kotlin.i0.z.e.m0.l.r0 r0, boolean z2) {
        n.f(r0, "reportStrategy");
        super();
        this.a = r0;
        this.b = z2;
    }

    private final void a(g g, g g2) {
        kotlin.i0.z.e.m0.f.b bVar;
        boolean contains;
        Object obj4;
        HashSet hashSet = new HashSet();
        Iterator obj3 = g.iterator();
        for (c next : obj3) {
            hashSet.add(next.d());
        }
        obj3 = g2.iterator();
        while (obj3.hasNext()) {
            obj4 = obj3.next();
            if (hashSet.contains((c)obj4.d())) {
            }
            this.a.b(obj4);
        }
    }

    private final void b(kotlin.i0.z.e.m0.l.b0 b0, kotlin.i0.z.e.m0.l.b0 b02) {
        int i;
        Object next;
        boolean type;
        String str;
        Object obj;
        kotlin.i0.z.e.m0.l.a1 a1Var;
        int i2;
        kotlin.i0.z.e.m0.l.b0 type2;
        final kotlin.i0.z.e.m0.l.a1 a1Var2 = a1.f(b02);
        n.e(a1Var2, "create(substitutedType)");
        Iterator obj11 = b02.K0().iterator();
        i = 0;
        for (Object next : obj11) {
            kotlin.i0.z.e.m0.l.b0 type3 = next.getType();
            str = "substitutedArgument.type";
            n.e(type3, str);
            obj = obj2;
            if (!(v0)next.c() && !a.c(type3) && this.b) {
            }
            i = i2;
            type3 = next.getType();
            str = "substitutedArgument.type";
            n.e(type3, str);
            if (!a.c(type3)) {
            }
            obj = obj2;
            if (this.b) {
            }
            type = (v0)b0.K0().get(i).getType();
            n.e(type, "unsubstitutedArgument.type");
            type2 = next.getType();
            n.e(type2, str);
            n.e((z0)(z0)obj, "typeParameter");
            p0.c.c(this.a, type, type2, obj, a1Var2);
        }
    }

    private final kotlin.i0.z.e.m0.l.q c(kotlin.i0.z.e.m0.l.q q, g g2) {
        return q.Y0(h(q, g2));
    }

    private final kotlin.i0.z.e.m0.l.i0 d(kotlin.i0.z.e.m0.l.i0 i0, g g2) {
        boolean z;
        int i;
        kotlin.i0.z.e.m0.l.b0 obj3;
        g obj4;
        if (d0.a(i0)) {
        } else {
            i = 0;
            obj3 = z0.f(i0, i, h(i0, g2), 1, i);
        }
        return obj3;
    }

    private final kotlin.i0.z.e.m0.l.i0 e(kotlin.i0.z.e.m0.l.i0 i0, kotlin.i0.z.e.m0.l.b0 b02) {
        final kotlin.i0.z.e.m0.l.i0 obj1 = c1.r(i0, b02.M0());
        n.e(obj1, "makeNullableIfNeeded(this, fromType.isMarkedNullable)");
        return obj1;
    }

    private final kotlin.i0.z.e.m0.l.i0 f(kotlin.i0.z.e.m0.l.i0 i0, kotlin.i0.z.e.m0.l.b0 b02) {
        return d(e(i0, b02), b02.getAnnotations());
    }

    private final kotlin.i0.z.e.m0.l.i0 g(kotlin.i0.z.e.m0.l.q0 q0, g g2, boolean z3) {
        kotlin.i0.z.e.m0.l.c0 c0Var = c0.a;
        kotlin.i0.z.e.m0.l.t0 t0Var = q0.b().g();
        n.e(t0Var, "descriptor.typeConstructor");
        return c0.j(g2, t0Var, q0.a(), z3, h.b.b);
    }

    private final g h(kotlin.i0.z.e.m0.l.b0 b0, g g2) {
        if (d0.a(b0)) {
            return b0.getAnnotations();
        }
        return i.a(g2, b0.getAnnotations());
    }

    private final kotlin.i0.z.e.m0.l.v0 j(kotlin.i0.z.e.m0.l.v0 v0, kotlin.i0.z.e.m0.l.q0 q02, int i3) {
        kotlin.i0.z.e.m0.l.i0 z;
        h hVar;
        boolean iterator;
        int arrayList;
        int i5;
        Object obj;
        Object next;
        int annotations;
        int i4;
        int i;
        int i2;
        kotlin.i0.z.e.m0.l.x0 obj12;
        Object obj13;
        int obj14;
        kotlin.i0.z.e.m0.l.g1 g1Var = v0.getType().O0();
        if (r.a(g1Var)) {
            return v0;
        }
        kotlin.i0.z.e.m0.l.i0 i0Var = z0.a(g1Var);
        if (!d0.a(i0Var)) {
            if (!a.n(i0Var)) {
            } else {
                z = i0Var.L0();
                hVar = z.c();
                int size = z.getParameters().size();
                arrayList = i0Var.K0().size();
                if (hVar instanceof z0) {
                } else {
                    if (hVar instanceof y0) {
                        if (q02.d((y0)hVar)) {
                            this.a.d(hVar);
                            obj12 = new x0(h1.INVARIANT, t.j(n.o("Recursive type alias: ", hVar.getName())));
                            return obj12;
                        }
                        List list = i0Var.K0();
                        arrayList = new ArrayList(p.r(list, 10));
                        i5 = 0;
                        iterator = list.iterator();
                        for (Object next : iterator) {
                            arrayList.add(l((v0)next, q02, (z0)z.getParameters().get(i5), i3 + 1));
                            i5 = annotations;
                        }
                        z = this.k(q0.e.a(q02, hVar, arrayList), i0Var.getAnnotations(), i0Var.M0(), i3 + 1, false);
                        if (r.a(z)) {
                        } else {
                            z = l0.j(z, m(i0Var, q02, i3));
                        }
                        obj13 = new x0(v0.a(), z);
                        obj12 = obj13;
                    } else {
                        obj13 = m(i0Var, q02, i3);
                        b(i0Var, obj13);
                        obj14 = new x0(v0.a(), obj13);
                        obj12 = obj14;
                    }
                }
            }
        }
        return obj12;
    }

    private final kotlin.i0.z.e.m0.l.i0 k(kotlin.i0.z.e.m0.l.q0 q0, g g2, boolean z3, int i4, boolean z5) {
        Object obj4;
        kotlin.i0.z.e.m0.l.i0 obj7;
        x0 x0Var = new x0(h1.INVARIANT, q0.b().g0());
        obj7 = l(x0Var, q0, 0, i4);
        kotlin.i0.z.e.m0.l.b0 type = obj7.getType();
        n.e(type, "expandedProjection.type");
        kotlin.i0.z.e.m0.l.i0 i0Var = z0.a(type);
        if (d0.a(i0Var)) {
            return i0Var;
        }
        obj7 = obj7.a();
        a(i0Var.getAnnotations(), g2);
        obj7 = c1.r(d(i0Var, g2), z3);
        n.e(obj7, "expandedType.combineAnnotations(annotations).let { TypeUtils.makeNullableIfNeeded(it, isNullable) }");
        if (z5) {
            obj7 = l0.j(obj7, g(q0, g2, z3));
        }
        return obj7;
    }

    private final kotlin.i0.z.e.m0.l.v0 l(kotlin.i0.z.e.m0.l.v0 v0, kotlin.i0.z.e.m0.l.q0 q02, z0 z03, int i4) {
        kotlin.i0.z.e.m0.l.h1 h1Var;
        Object iNVARIANT2;
        Object iNVARIANT;
        Object obj4;
        Object obj5;
        p0.a.a(p0.c, i4, q02.b());
        String str = "makeStarProjection(typeParameterDescriptor!!)";
        if (v0.c()) {
            n.d(z03);
            obj4 = c1.s(z03);
            n.e(obj4, str);
            return obj4;
        }
        kotlin.i0.z.e.m0.l.b0 type = v0.getType();
        n.e(type, "underlyingProjection.type");
        kotlin.i0.z.e.m0.l.v0 v0Var = q02.c(type.L0());
        if (v0Var == null) {
            return j(v0, q02, i4);
        }
        if (v0Var.c()) {
            n.d(z03);
            obj4 = c1.s(z03);
            n.e(obj4, str);
            return obj4;
        }
        kotlin.i0.z.e.m0.l.g1 obj7 = v0Var.getType().O0();
        h1Var = v0Var.a();
        n.e(h1Var, "argument.projectionKind");
        obj4 = v0.a();
        n.e(obj4, "underlyingProjection.projectionKind");
        if (obj4 == h1Var) {
        } else {
            iNVARIANT2 = h1.INVARIANT;
            if (obj4 == iNVARIANT2) {
            } else {
                if (h1Var == iNVARIANT2) {
                    h1Var = obj4;
                } else {
                    this.a.c(q02.b(), z03, obj7);
                }
            }
        }
        if (z03 == null) {
            obj4 = 0;
        } else {
            obj4 = z03.l();
        }
        if (obj4 == null) {
            obj4 = h1.INVARIANT;
        }
        n.e(obj4, "typeParameterDescriptor?.variance ?: Variance.INVARIANT");
        if (obj4 == h1Var) {
        } else {
            iNVARIANT = h1.INVARIANT;
            if (obj4 == iNVARIANT) {
            } else {
                if (h1Var == iNVARIANT) {
                    h1Var = iNVARIANT;
                } else {
                    this.a.c(q02.b(), z03, obj7);
                }
            }
        }
        a(type.getAnnotations(), obj7.getAnnotations());
        if (obj7 instanceof q) {
            obj4 = c((q)obj7, type.getAnnotations());
        } else {
            obj4 = f(z0.a(obj7), type);
        }
        obj5 = new x0(h1Var, obj4);
        return obj5;
    }

    private final kotlin.i0.z.e.m0.l.i0 m(kotlin.i0.z.e.m0.l.i0 i0, kotlin.i0.z.e.m0.l.q0 q02, int i3) {
        int i;
        kotlin.i0.z.e.m0.l.v0 v0Var;
        boolean next;
        kotlin.i0.z.e.m0.l.x0 x0Var;
        int i2;
        kotlin.i0.z.e.m0.l.h1 h1Var;
        List list = i0.K0();
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator = list.iterator();
        i = 0;
        int i6 = 0;
        for (Object next : iterator) {
            v0Var = l((v0)next, q02, (z0)i0.L0().getParameters().get(i), i3 + 1);
            if (v0Var.c()) {
            } else {
            }
            x0Var = new x0(v0Var.a(), c1.q(v0Var.getType(), next.getType().M0()));
            v0Var = x0Var;
            arrayList.add(v0Var);
            i = i2;
            i6 = 0;
        }
        return z0.f(i0, arrayList, i6, 2, i6);
    }

    public final kotlin.i0.z.e.m0.l.i0 i(kotlin.i0.z.e.m0.l.q0 q0, g g2) {
        n.f(q0, "typeAliasExpansion");
        n.f(g2, "annotations");
        return this.k(q0, g2, false, 0, true);
    }
}
