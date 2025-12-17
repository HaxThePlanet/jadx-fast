package kotlin.i0.z.e.m0.i;

import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.l.j1.f.a;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.j1.g.a;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class b {

    public static final kotlin.i0.z.e.m0.i.b a;

    static final class b implements f.a {

        final kotlin.i0.z.e.m0.i.b a;
        final boolean b;
        final a c;
        final a d;
        b(kotlin.i0.z.e.m0.i.b b, boolean z2, a a3, a a4) {
            this.a = b;
            this.b = z2;
            this.c = a3;
            this.d = a4;
            super();
        }

        @Override // kotlin.i0.z.e.m0.l.j1.f$a
        public final boolean a(t0 t0, t0 t02) {
            boolean z;
            n.f(t0, "c1");
            n.f(t02, "c2");
            if (n.b(t0, t02)) {
                return 1;
            }
            h obj6 = t0.c();
            final h obj7 = t02.c();
            if (obj6 instanceof z0 && !obj7 instanceof z0) {
                if (!obj7 instanceof z0) {
                }
                b.b.a aVar = new b.b.a(this.c, this.d);
                return b.a(this.a, (z0)obj6, (z0)obj7, this.b, aVar);
            }
            return 0;
        }
    }

    static final class a extends p implements p<m, m, Boolean> {

        public static final kotlin.i0.z.e.m0.i.b.a a;
        static {
            b.a aVar = new b.a();
            b.a.a = aVar;
        }

        a() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(m m, m m2) {
            return 0;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((m)object, (m)object2));
        }
    }

    static final class c extends p implements p<m, m, Boolean> {

        public static final kotlin.i0.z.e.m0.i.b.c a;
        static {
            b.c cVar = new b.c();
            b.c.a = cVar;
        }

        c() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(m m, m m2) {
            return 0;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((m)object, (m)object2));
        }
    }
    static {
        b bVar = new b();
        b.a = bVar;
    }

    public static final boolean a(kotlin.i0.z.e.m0.i.b b, z0 z02, z0 z03, boolean z4, p p5) {
        return b.g(z02, z03, z4, p5);
    }

    public static boolean c(kotlin.i0.z.e.m0.i.b b, a a2, a a3, boolean z4, boolean z5, boolean z6, g g7, int i8, Object object9) {
        int obj11;
        int obj12;
        if (i8 & 8 != 0) {
            obj11 = 1;
        }
        if (i8 & 16 != 0) {
            obj12 = 0;
        }
        return b.b(a2, a3, z4, obj11, obj12, g7);
    }

    private final boolean d(e e, e e2) {
        return n.b(e.g(), e2.g());
    }

    public static boolean f(kotlin.i0.z.e.m0.i.b b, m m2, m m3, boolean z4, boolean z5, int i6, Object object7) {
        int obj4;
        if (i6 &= 8 != 0) {
            obj4 = 1;
        }
        return b.e(m2, m3, z4, obj4);
    }

    private final boolean g(z0 z0, z0 z02, boolean z3, p<? super m, ? super m, Boolean> p4) {
        int i;
        if (n.b(z0, z02)) {
            return 1;
        }
        int i2 = 0;
        if (n.b(z0.b(), z02.b())) {
            return i2;
        }
        if (!i(z0, z02, p4, z3)) {
            return i2;
        }
        if (z0.getIndex() == z02.getIndex()) {
        } else {
            i = i2;
        }
        return i;
    }

    static boolean h(kotlin.i0.z.e.m0.i.b b, z0 z02, z0 z03, boolean z4, p p5, int i6, Object object7) {
        kotlin.i0.z.e.m0.i.b.c obj4;
        if (i6 &= 8 != 0) {
            obj4 = b.c.a;
        }
        return b.g(z02, z03, z4, obj4);
    }

    private final boolean i(m m, m m2, p<? super m, ? super m, Boolean> p3, boolean z4) {
        kotlin.i0.z.e.m0.i.b bVar;
        boolean z;
        int i;
        int i2;
        int i3;
        boolean obj8;
        final m mVar = m.b();
        final m mVar2 = m2.b();
        if (!mVar instanceof b) {
            if (mVar2 instanceof b) {
                obj8 = (Boolean)p3.invoke(mVar, mVar2).booleanValue();
            } else {
                obj8 = b.f(this, mVar, mVar2, z4, false, 8, 0);
            }
        } else {
        }
        return obj8;
    }

    private final u0 j(a a) {
        boolean obj;
        b.a aVar;
        b.a fAKE_OVERRIDE;
        while (a instanceof b) {
            obj = a;
            java.util.Collection obj4 = obj.e();
            n.e(obj4, "overriddenDescriptors");
        }
        return a.getSource();
    }

    public final boolean b(a a, a a2, boolean z3, boolean z4, boolean z5, g g6) {
        boolean z;
        Object mVar;
        int i;
        Object obj4;
        boolean obj7;
        n.f(a, "a");
        n.f(a2, "b");
        n.f(g6, "kotlinTypeRefiner");
        if (n.b(a, a2)) {
            return 1;
        }
        int i2 = 0;
        if (!n.b(a.getName(), a2.getName())) {
            return i2;
        }
        if (z4 && a instanceof y && a2 instanceof y && (y)a.L() != (y)a2.L()) {
            if (a instanceof y) {
                if (a2 instanceof y) {
                    if ((y)a.L() != (y)a2.L()) {
                        return i2;
                    }
                }
            }
        }
        if (n.b(a.b(), a2.b()) && !z3) {
            if (!z3) {
                return i2;
            }
            if (!n.b(j(a), j(a2))) {
                return i2;
            }
        }
        if (!d.E(a)) {
            if (d.E(a2)) {
            } else {
                if (!i(a, a2, b.a.a, z3)) {
                    return i2;
                }
                obj7 = new b.b(this, z3, a, a2);
                final kotlin.i0.z.e.m0.i.j obj6 = j.k(g6, obj7);
                n.e(obj6, "fun areCallableDescriptorsEquivalent(\n        a: CallableDescriptor,\n        b: CallableDescriptor,\n        allowCopiesFromTheSameDeclaration: Boolean,\n        distinguishExpectsAndNonExpects: Boolean = true,\n        ignoreReturnType: Boolean = false,\n        kotlinTypeRefiner: KotlinTypeRefiner\n    ): Boolean {\n        if (a == b) return true\n        if (a.name != b.name) return false\n        if (distinguishExpectsAndNonExpects && a is MemberDescriptor && b is MemberDescriptor && a.isExpect != b.isExpect) return false\n        if (a.containingDeclaration == b.containingDeclaration) {\n            if (!allowCopiesFromTheSameDeclaration) return false\n            if (a.singleSource() != b.singleSource()) return false\n        }\n\n        // Distinct locals are not equivalent\n        if (DescriptorUtils.isLocal(a) || DescriptorUtils.isLocal(b)) return false\n\n        if (!ownersEquivalent(a, b, { _, _ -> false }, allowCopiesFromTheSameDeclaration)) return false\n\n        val overridingUtil = OverridingUtil.create(kotlinTypeRefiner) eq@{ c1, c2 ->\n            if (c1 == c2) return@eq true\n\n            val d1 = c1.declarationDescriptor\n            val d2 = c2.declarationDescriptor\n\n            if (d1 !is TypeParameterDescriptor || d2 !is TypeParameterDescriptor) return@eq false\n\n            areTypeParametersEquivalent(d1, d2, allowCopiesFromTheSameDeclaration) { x, y -> x == a && y == b }\n        }\n\n        return overridingUtil.isOverridableBy(a, b, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n                && overridingUtil.isOverridableBy(b, a, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n\n    }");
                final int obj9 = 0;
                kotlin.i0.z.e.m0.i.j.i.a oVERRIDABLE = j.i.a.OVERRIDABLE;
                if (obj6.H(a, a2, obj9, z5 ^ 1).c() == oVERRIDABLE && obj6.H(a2, a, obj9, z5 ^ 1).c() == oVERRIDABLE) {
                    if (obj6.H(a2, a, obj9, z5 ^ 1).c() == oVERRIDABLE) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    public final boolean e(m m, m m2, boolean z3, boolean z4) {
        boolean z2;
        kotlin.i0.z.e.m0.i.b bVar;
        Object obj;
        Object obj2;
        boolean z5;
        boolean z;
        int i;
        g.a aVar;
        int i3;
        int i2;
        boolean obj11;
        Object obj12;
        boolean obj13;
        if (m instanceof e && m2 instanceof e) {
            if (m2 instanceof e) {
                obj11 = d((e)m, (e)m2);
            } else {
                if (m instanceof z0 && m2 instanceof z0) {
                    if (m2 instanceof z0) {
                        obj11 = b.h(this, (z0)m, (z0)m2, z3, 0, 8, 0);
                    } else {
                        if (m instanceof a && m2 instanceof a) {
                            if (m2 instanceof a) {
                                obj11 = b.c(this, (a)m, (a)m2, z3, z4, false, g.a.a, 16, 0);
                            } else {
                                if (m instanceof f0 && m2 instanceof f0) {
                                    if (m2 instanceof f0) {
                                        obj11 = n.b((f0)m.d(), (f0)m2.d());
                                    } else {
                                        obj11 = n.b(m, m2);
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        return obj11;
    }
}
