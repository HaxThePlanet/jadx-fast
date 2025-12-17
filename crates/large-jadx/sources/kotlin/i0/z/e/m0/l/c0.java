package kotlin.i0.z.e.m0.l;

import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.i.q.n;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.u;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class c0 {

    public static final kotlin.i0.z.e.m0.l.c0 a;

    private static final class b {

        private final kotlin.i0.z.e.m0.l.i0 a;
        private final kotlin.i0.z.e.m0.l.t0 b;
        public b(kotlin.i0.z.e.m0.l.i0 i0, kotlin.i0.z.e.m0.l.t0 t02) {
            super();
            this.a = i0;
            this.b = t02;
        }

        public final kotlin.i0.z.e.m0.l.i0 a() {
            return this.a;
        }

        public final kotlin.i0.z.e.m0.l.t0 b() {
            return this.b;
        }
    }

    static final class a extends p implements l {

        public static final kotlin.i0.z.e.m0.l.c0.a a;
        static {
            c0.a aVar = new c0.a();
            c0.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final Void a(g g) {
            n.f(g, "$noName_0");
            return null;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((g)object);
        }
    }

    static final class c extends p implements l<g, kotlin.i0.z.e.m0.l.i0> {

        final g $annotations;
        final List<kotlin.i0.z.e.m0.l.v0> $arguments;
        final kotlin.i0.z.e.m0.l.t0 $constructor;
        final boolean $nullable;
        final kotlin.i0.z.e.m0.l.c0 this$0;
        c(kotlin.i0.z.e.m0.l.c0 c0, kotlin.i0.z.e.m0.l.t0 t02, List<? extends kotlin.i0.z.e.m0.l.v0> list3, g g4, boolean z5) {
            this.this$0 = c0;
            this.$constructor = t02;
            this.$arguments = list3;
            this.$annotations = g4;
            this.$nullable = z5;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.i0.z.e.m0.l.i0 a(g g) {
            n.f(g, "refiner");
            kotlin.i0.z.e.m0.l.c0.b bVar = c0.a(this.this$0, this.$constructor, g, this.$arguments);
            if (bVar == null) {
                return null;
            }
            kotlin.i0.z.e.m0.l.i0 i0Var = bVar.a();
            if (i0Var == null) {
                kotlin.i0.z.e.m0.l.t0 t0Var = bVar.b();
                n.d(t0Var);
                return c0.h(this.$annotations, t0Var, this.$arguments, this.$nullable, g);
            }
            return i0Var;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((g)object);
        }
    }

    static final class d extends p implements l<g, kotlin.i0.z.e.m0.l.i0> {

        final g $annotations;
        final List<kotlin.i0.z.e.m0.l.v0> $arguments;
        final kotlin.i0.z.e.m0.l.t0 $constructor;
        final h $memberScope;
        final boolean $nullable;
        final kotlin.i0.z.e.m0.l.c0 this$0;
        d(kotlin.i0.z.e.m0.l.c0 c0, kotlin.i0.z.e.m0.l.t0 t02, List<? extends kotlin.i0.z.e.m0.l.v0> list3, g g4, boolean z5, h h6) {
            this.this$0 = c0;
            this.$constructor = t02;
            this.$arguments = list3;
            this.$annotations = g4;
            this.$nullable = z5;
            this.$memberScope = h6;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.i0.z.e.m0.l.i0 a(g g) {
            n.f(g, "kotlinTypeRefiner");
            kotlin.i0.z.e.m0.l.c0.b obj5 = c0.a(this.this$0, this.$constructor, g, this.$arguments);
            if (obj5 == null) {
                return null;
            }
            kotlin.i0.z.e.m0.l.i0 i0Var = obj5.a();
            if (i0Var == null) {
                obj5 = obj5.b();
                n.d(obj5);
                return c0.j(this.$annotations, obj5, this.$arguments, this.$nullable, this.$memberScope);
            }
            return i0Var;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((g)object);
        }
    }
    static {
        c0 c0Var = new c0();
        c0.a = c0Var;
        kotlin.i0.z.e.m0.l.c0.a aVar = c0.a.a;
    }

    public static final kotlin.i0.z.e.m0.l.c0.b a(kotlin.i0.z.e.m0.l.c0 c0, kotlin.i0.z.e.m0.l.t0 t02, g g3, List list4) {
        return c0.f(t02, g3, list4);
    }

    public static final kotlin.i0.z.e.m0.l.i0 b(y0 y0, List<? extends kotlin.i0.z.e.m0.l.v0> list2) {
        n.f(y0, "<this>");
        n.f(list2, "arguments");
        p0 p0Var = new p0(r0.a.a, 0);
        return p0Var.i(q0.e.a(0, y0, list2), g.q.b());
    }

    private final h c(kotlin.i0.z.e.m0.l.t0 t0, List<? extends kotlin.i0.z.e.m0.l.v0> list2, g g3) {
        kotlin.i0.z.e.m0.l.u0.a empty;
        h obj3;
        Object obj4;
        g obj5;
        h hVar = t0.c();
        if (hVar instanceof z0) {
            obj3 = hVar.q().o();
            return obj3;
        } else {
            if (hVar instanceof e) {
                if (g3 == null) {
                    obj5 = a.k(a.l(hVar));
                }
                if (list2.isEmpty()) {
                    obj3 = u.b((e)hVar, obj5);
                } else {
                    obj3 = u.a((e)hVar, u0.b.b(t0, list2), obj5);
                }
            } else {
                if (hVar instanceof y0) {
                    n.e(t.i(n.o("Scope for abbreviation: ", (y0)hVar.getName()), true), "createErrorScope(\"Scope for abbreviation: ${descriptor.name}\", true)");
                }
            }
        }
        if (!t0 instanceof a0) {
        } else {
            return (a0)t0.f();
        }
        obj5 = new StringBuilder();
        obj5.append("Unsupported classifier: ");
        obj5.append(hVar);
        obj5.append(" for constructor: ");
        obj5.append(t0);
        obj4 = new IllegalStateException(obj5.toString());
        throw obj4;
    }

    public static final kotlin.i0.z.e.m0.l.g1 d(kotlin.i0.z.e.m0.l.i0 i0, kotlin.i0.z.e.m0.l.i0 i02) {
        n.f(i0, "lowerBound");
        n.f(i02, "upperBound");
        if (n.b(i0, i02)) {
            return i0;
        }
        w wVar = new w(i0, i02);
        return wVar;
    }

    public static final kotlin.i0.z.e.m0.l.i0 e(g g, n n2, boolean z3) {
        n.f(g, "annotations");
        n.f(n2, "constructor");
        h hVar = t.i("Scope for integer literal type", true);
        n.e(hVar, "createErrorScope(\"Scope for integer literal type\", true)");
        return c0.j(g, n2, p.g(), z3, hVar);
    }

    private final kotlin.i0.z.e.m0.l.c0.b f(kotlin.i0.z.e.m0.l.t0 t0, g g2, List<? extends kotlin.i0.z.e.m0.l.v0> list3) {
        h obj3;
        obj3 = t0.c();
        final int i = 0;
        if (obj3 == null) {
            obj3 = i;
        } else {
            obj3 = g2.e(obj3);
        }
        if (obj3 == null) {
            return i;
        }
        if (obj3 instanceof y0) {
            c0.b obj4 = new c0.b(c0.b((y0)obj3, list3), i);
            return obj4;
        }
        obj3 = obj3.g().b(g2);
        n.e(obj3, "descriptor.typeConstructor.refine(kotlinTypeRefiner)");
        obj4 = new c0.b(i, obj3);
        return obj4;
    }

    public static final kotlin.i0.z.e.m0.l.i0 g(g g, e e2, List<? extends kotlin.i0.z.e.m0.l.v0> list3) {
        n.f(g, "annotations");
        n.f(e2, "descriptor");
        n.f(list3, "arguments");
        final kotlin.i0.z.e.m0.l.t0 t0Var = e2.g();
        n.e(t0Var, "descriptor.typeConstructor");
        return c0.i(g, t0Var, list3, false, 0, 16, 0);
    }

    public static final kotlin.i0.z.e.m0.l.i0 h(g g, kotlin.i0.z.e.m0.l.t0 t02, List<? extends kotlin.i0.z.e.m0.l.v0> list3, boolean z4, g g5) {
        boolean empty;
        n.f(g, "annotations");
        n.f(t02, "constructor");
        n.f(list3, "arguments");
        if (g.isEmpty() && list3.isEmpty() && !z4 && t02.c() != null) {
            if (list3.isEmpty()) {
                if (!z4) {
                    if (t02.c() != null) {
                        h obj8 = t02.c();
                        n.d(obj8);
                        obj8 = obj8.q();
                        n.e(obj8, "constructor.declarationDescriptor!!.defaultType");
                        return obj8;
                    }
                }
            }
        }
        final kotlin.i0.z.e.m0.l.c0 c0Var = c0.a;
        final boolean z = z4;
        super(c0Var, t02, list3, g, z);
        return c0.k(g, t02, list3, z, c0Var.c(t02, list3, g5), cVar2);
    }

    public static kotlin.i0.z.e.m0.l.i0 i(g g, kotlin.i0.z.e.m0.l.t0 t02, List list3, boolean z4, g g5, int i6, Object object7) {
        int obj4;
        if (i6 &= 16 != 0) {
            obj4 = 0;
        }
        return c0.h(g, t02, list3, z4, obj4);
    }

    public static final kotlin.i0.z.e.m0.l.i0 j(g g, kotlin.i0.z.e.m0.l.t0 t02, List<? extends kotlin.i0.z.e.m0.l.v0> list3, boolean z4, h h5) {
        kotlin.i0.z.e.m0.l.i0 j0Var;
        boolean obj10;
        n.f(g, "annotations");
        n.f(t02, "constructor");
        n.f(list3, "arguments");
        n.f(h5, "memberScope");
        super(c0.a, t02, list3, g, z4, h5);
        super(t02, list3, z4, h5, dVar3);
        if (g.isEmpty()) {
        } else {
            obj10 = new h(j0Var, g);
            j0Var = obj10;
        }
        return j0Var;
    }

    public static final kotlin.i0.z.e.m0.l.i0 k(g g, kotlin.i0.z.e.m0.l.t0 t02, List<? extends kotlin.i0.z.e.m0.l.v0> list3, boolean z4, h h5, l<? super g, ? extends kotlin.i0.z.e.m0.l.i0> l6) {
        kotlin.i0.z.e.m0.l.i0 j0Var;
        boolean obj8;
        n.f(g, "annotations");
        n.f(t02, "constructor");
        n.f(list3, "arguments");
        n.f(h5, "memberScope");
        n.f(l6, "refinedTypeFactory");
        super(t02, list3, z4, h5, l6);
        if (g.isEmpty()) {
        } else {
            obj8 = new h(j0Var, g);
            j0Var = obj8;
        }
        return j0Var;
    }
}
