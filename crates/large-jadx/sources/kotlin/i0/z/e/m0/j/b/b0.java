package kotlin.i0.z.e.m0.j.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.j;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.f;
import kotlin.i0.z.e.m0.b.g;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.l;
import kotlin.i0.z.e.m0.e.q;
import kotlin.i0.z.e.m0.e.q.b;
import kotlin.i0.z.e.m0.e.q.b.c;
import kotlin.i0.z.e.m0.e.s;
import kotlin.i0.z.e.m0.e.z.b;
import kotlin.i0.z.e.m0.e.z.b.b;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.e.z.f;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.j.b.d0.a;
import kotlin.i0.z.e.m0.j.b.d0.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.d0;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.l0;
import kotlin.i0.z.e.m0.l.m0;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.n0;
import kotlin.i0.z.e.m0.l.t;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.i0.z.e.m0.l.x0;
import kotlin.j0.i;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.e;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class b0 {

    private final kotlin.i0.z.e.m0.j.b.l a;
    private final kotlin.i0.z.e.m0.j.b.b0 b;
    private final String c;
    private final String d;
    private boolean e;
    private final l<Integer, h> f;
    private final l<Integer, h> g;
    private final Map<Integer, z0> h;

    static final class a extends p implements l<Integer, h> {

        final kotlin.i0.z.e.m0.j.b.b0 this$0;
        a(kotlin.i0.z.e.m0.j.b.b0 b0) {
            this.this$0 = b0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final h a(int i) {
            return b0.a(this.this$0, i);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((Number)object.intValue());
        }
    }

    static final class b extends p implements a<List<? extends c>> {

        final q $proto;
        final kotlin.i0.z.e.m0.j.b.b0 this$0;
        b(kotlin.i0.z.e.m0.j.b.b0 b0, q q2) {
            this.this$0 = b0;
            this.$proto = q2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<c> invoke() {
            return b0.c(this.this$0).c().d().d(this.$proto, b0.c(this.this$0).g());
        }
    }

    static final class c extends p implements l<Integer, h> {

        final kotlin.i0.z.e.m0.j.b.b0 this$0;
        c(kotlin.i0.z.e.m0.j.b.b0 b0) {
            this.this$0 = b0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final h a(int i) {
            return b0.b(this.this$0, i);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((Number)object.intValue());
        }
    }

    static final class e extends p implements l<q, q> {

        final kotlin.i0.z.e.m0.j.b.b0 this$0;
        e(kotlin.i0.z.e.m0.j.b.b0 b0) {
            this.this$0 = b0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final q a(q q) {
            n.f(q, "it");
            return f.f(q, b0.c(this.this$0).j());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((q)object);
        }
    }

    static final class f extends p implements l<q, Integer> {

        public static final kotlin.i0.z.e.m0.j.b.b0.f a;
        static {
            b0.f fVar = new b0.f();
            b0.f.a = fVar;
        }

        f() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final int a(q q) {
            n.f(q, "it");
            return q.O();
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Integer.valueOf(a((q)object));
        }
    }

    class d extends j implements l<a, a> {

        public static final kotlin.i0.z.e.m0.j.b.b0.d a;
        static {
            b0.d dVar = new b0.d();
            b0.d.a = dVar;
        }

        d() {
            super(1);
        }

        @Override // kotlin.d0.d.j
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // kotlin.d0.d.j
        public final f getOwner() {
            return c0.b(a.class);
        }

        @Override // kotlin.d0.d.j
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // kotlin.d0.d.j
        public Object invoke(Object object) {
            return l((a)object);
        }

        @Override // kotlin.d0.d.j
        public final a l(a a) {
            n.f(a, "p0");
            return a.g();
        }
    }
    public b0(kotlin.i0.z.e.m0.j.b.l l, kotlin.i0.z.e.m0.j.b.b0 b02, List<s> list3, String string4, String string5, boolean z6) {
        String mVar;
        kotlin.i0.z.e.m0.j.b.l lVar;
        Object obj3;
        Object obj4;
        Object obj5;
        kotlin.i0.z.e.m0.j.b.b0.a obj6;
        Object obj7;
        boolean obj8;
        n.f(l, "c");
        n.f(list3, "typeParameterProtos");
        n.f(string4, "debugName");
        n.f(string5, "containerPresentableName");
        super();
        this.a = l;
        this.b = b02;
        this.c = string4;
        this.d = string5;
        this.e = z6;
        obj6 = new b0.a(this);
        this.f = l.h().i(obj6);
        obj4 = new b0.c(this);
        this.g = l.h().i(obj4);
        if (list3.isEmpty()) {
            obj3 = j0.h();
        } else {
            obj3 = new LinkedHashMap();
            obj4 = list3.iterator();
            obj5 = 0;
            for (s obj7 : obj4) {
                mVar = new m(this.a, obj7, obj5);
                obj3.put(Integer.valueOf(obj7.G()), mVar);
                obj5 = obj6;
            }
        }
        this.h = obj3;
    }

    public b0(kotlin.i0.z.e.m0.j.b.l l, kotlin.i0.z.e.m0.j.b.b0 b02, List list3, String string4, String string5, boolean z6, int i7, g g8) {
        int obj13;
        obj13 = i7 &= 32 != 0 ? 0 : obj13;
        super(l, b02, list3, string4, string5, obj13);
    }

    public static final h a(kotlin.i0.z.e.m0.j.b.b0 b0, int i2) {
        return b0.d(i2);
    }

    public static final h b(kotlin.i0.z.e.m0.j.b.b0 b0, int i2) {
        return b0.f(i2);
    }

    public static final kotlin.i0.z.e.m0.j.b.l c(kotlin.i0.z.e.m0.j.b.b0 b0) {
        return b0.a;
    }

    private final h d(int i) {
        a obj2 = v.a(this.a.g(), i);
        if (obj2.k()) {
            return this.a.c().b(obj2);
        }
        return w.b(this.a.c().p(), obj2);
    }

    private final i0 e(int i) {
        if (v.a(this.a.g(), i).k()) {
            return this.a.c().n().a();
        }
        return null;
    }

    private final h f(int i) {
        a obj2 = v.a(this.a.g(), i);
        if (obj2.k()) {
            return null;
        }
        return w.d(this.a.c().p(), obj2);
    }

    private final i0 g(b0 b0, b0 b02) {
        int type;
        List list2 = p.Q(g.j(b0), 1);
        ArrayList arrayList = new ArrayList(p.r(list2, 10));
        Iterator iterator = list2.iterator();
        for (v0 next2 : iterator) {
            arrayList.add(next2.getType());
        }
        return g.a(a.e(b0), b0.getAnnotations(), g.h(b0), arrayList, 0, b02, true).S0(b0.M0());
    }

    private final i0 h(g g, t0 t02, List<? extends v0> list3, boolean z4) {
        int str;
        i0 i3;
        int i4;
        List list;
        boolean z;
        int i;
        int i2;
        int i5;
        Object obj9;
        size -= size3;
        i3 = 0;
        if (str != null) {
            i4 = 1;
            if (str != i4) {
            } else {
                size2 -= i4;
                if (str >= 0) {
                    c0 c0Var = c0.a;
                    i4 = t02.m().W(str).g();
                    n.e(i4, "functionTypeConstructor.builtIns.getSuspendFunction(arity).typeConstructor");
                    i3 = c0.i(g, i4, list3, z4, 0, 16, 0);
                }
            }
        } else {
            i3 = i(g, t02, list3, z4);
        }
        if (i3 == null) {
            n.e(t.n(n.o("Bad suspend function in metadata with constructor: ", t02), list3), "createErrorTypeWithArguments(\n            \"Bad suspend function in metadata with constructor: $functionTypeConstructor\",\n            arguments\n        )");
        }
        return i3;
    }

    private final i0 i(g g, t0 t02, List<? extends v0> list3, boolean z4) {
        int obj9;
        final c0 c0Var = c0.a;
        obj9 = c0.i(g, t02, list3, z4, 0, 16, 0);
        if (!g.n(obj9)) {
            obj9 = 0;
        } else {
            obj9 = o(obj9);
        }
        return obj9;
    }

    private static final List<q.b> m(q q, kotlin.i0.z.e.m0.j.b.b0 b02) {
        int obj2;
        final List list = q.P();
        n.e(list, "argumentList");
        obj2 = f.f(q, b02.a.j());
        if (obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = b0.m(obj2, b02);
        }
        if (obj2 != null) {
        } else {
            obj2 = p.g();
        }
        return p.t0(list, obj2);
    }

    public static i0 n(kotlin.i0.z.e.m0.j.b.b0 b0, q q2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 1;
        }
        return b0.l(q2, obj2);
    }

    private final i0 o(b0 b0) {
        boolean z;
        int type;
        int i2;
        int i3;
        int size;
        kotlin.reflect.jvm.internal.impl.descriptors.m mVar;
        int i;
        int i4;
        z = this.a.c().g().g();
        Object obj = p.l0(g.j(b0));
        i2 = 0;
        if ((v0)obj == null) {
            type = i2;
        } else {
            type = (v0)obj.getType();
        }
        if (type == null) {
            return i2;
        }
        h hVar = type.L0().c();
        if (hVar == null) {
            i3 = i2;
        } else {
            i3 = a.i(hVar);
        }
        i = 1;
        if (type.K0().size() == i) {
            i4 = 0;
            if (!l.a(i3, i) && !l.a(i3, i4)) {
                if (!l.a(i3, i4)) {
                } else {
                    b0 type2 = (v0)p.z0(type.K0()).getType();
                    n.e(type2, "continuationArgumentType.arguments.single().type");
                    if (!mVar instanceof a) {
                        mVar = i2;
                    }
                    if ((a)mVar == null) {
                    } else {
                        i2 = a.e((a)mVar);
                    }
                    if (n.b(i2, a0.a)) {
                        return g(b0, type2);
                    }
                    if (!this.e) {
                        if (z && l.a(i3, z ^= i)) {
                            if (l.a(i3, z ^= i)) {
                            } else {
                                i = i4;
                            }
                        } else {
                        }
                    }
                }
            } else {
            }
            this.e = i;
            return g(b0, type2);
        }
        return (i0)b0;
    }

    private final v0 q(z0 z0, q.b q$b2) {
        kotlin.i0.z.e.m0.l.w0 obj3;
        Object obj4;
        if (b2.r() == q.b.c.STAR) {
            if (z0 == null) {
                obj3 = new m0(this.a.c().p().m());
            } else {
                obj4 = new n0(z0);
                obj3 = obj4;
            }
            return obj3;
        }
        q.b.c cVar2 = b2.r();
        n.e(cVar2, "typeArgumentProto.projection");
        obj4 = f.l(b2, this.a.j());
        if (obj4 == null) {
            obj3 = new x0(t.j("No type recorded"));
            return obj3;
        }
        x0 x0Var = new x0(y.a.c(cVar2), p(obj4));
        return x0Var;
    }

    private final t0 r(q q) {
        Object invoke2;
        Object invoke;
        Object str;
        Object stringBuilder;
        Object next;
        int i;
        boolean z;
        t0 obj6;
        if (q.f0()) {
            if ((h)this.f.invoke(Integer.valueOf(q.Q())) == null) {
                invoke2 = b0.s(this, q, q.Q());
            }
            n.e(invoke2.g(), "classifierDescriptors(proto.className) ?: notFoundClass(proto.className)).typeConstructor");
        } else {
            if (q.p0()) {
                str = t(q.b0());
                if (str == null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Unknown type parameter ");
                    stringBuilder2.append(q.b0());
                    stringBuilder2.append(". Please try recompiling module containing \"");
                    stringBuilder2.append(this.d);
                    stringBuilder2.append('"');
                    n.e(t.k(stringBuilder2.toString()), "createErrorTypeConstructor(\n                        \"Unknown type parameter ${proto.typeParameter}. Please try recompiling module containing \\\"$containerPresentableName\\\"\"\n                    )");
                } else {
                    obj6 = str;
                }
            } else {
                if (q.q0()) {
                    obj6 = this.a.g().getString(q.c0());
                    stringBuilder = k().iterator();
                    for (Object next : stringBuilder) {
                    }
                    next = i;
                    if ((z0)next == null) {
                    } else {
                        i = (z0)next.g();
                    }
                    if (i == 0) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Deserialized type parameter ");
                        stringBuilder.append(obj6);
                        stringBuilder.append(" in ");
                        stringBuilder.append(this.a.e());
                        obj6 = t.k(stringBuilder.toString());
                    } else {
                        obj6 = i;
                    }
                    n.e(obj6, "{\n                val container = c.containingDeclaration\n                val name = c.nameResolver.getString(proto.typeParameterName)\n                val parameter = ownTypeParameters.find { it.name.asString() == name }\n                parameter?.typeConstructor ?: ErrorUtils.createErrorTypeConstructor(\"Deserialized type parameter $name in $container\")\n            }");
                } else {
                    if (q.o0()) {
                        if ((h)this.g.invoke(Integer.valueOf(q.a0())) == null) {
                            invoke = b0.s(this, q, q.a0());
                        }
                        n.e(invoke.g(), "typeAliasDescriptors(proto.typeAliasName) ?: notFoundClass(proto.typeAliasName)).typeConstructor");
                    } else {
                        n.e(t.k("Unknown type"), "createErrorTypeConstructor(\"Unknown type\")");
                    }
                }
            }
        }
        return obj6;
    }

    private static final e s(kotlin.i0.z.e.m0.j.b.b0 b0, q q2, int i3) {
        Integer valueOf;
        final a obj4 = v.a(b0.a.g(), i3);
        b0.e eVar = new b0.e(b0);
        List obj3 = i.B(i.u(i.f(q2, eVar), b0.f.a));
        while (obj3.size() < i.j(i.f(obj4, b0.d.a))) {
            obj3.add(0);
        }
        return b0.a.c().q().d(obj4, obj3);
    }

    private final t0 t(int i) {
        t0 t0Var;
        t0 i2;
        Object obj = this.h.get(Integer.valueOf(i));
        if ((z0)obj == null) {
            t0Var = i2;
        } else {
            t0Var = (z0)obj.g();
        }
        if (t0Var == null) {
            t0Var = this.b;
            if (t0Var == null) {
            } else {
                i2 = t0Var.t(i);
            }
        } else {
            i2 = t0Var;
        }
        return i2;
    }

    public final boolean j() {
        return this.e;
    }

    public final List<z0> k() {
        return p.L0(this.h.values());
    }

    public final i0 l(q q, boolean z2) {
        i0 i0Var;
        Object str;
        Object qVar;
        int i3;
        boolean z;
        int i;
        int i4;
        Object next2;
        int next;
        int i2;
        int parameters;
        String str2;
        boolean obj13;
        n.f(q, "proto");
        i = 0;
        if (q.f0()) {
            i0Var = e(q.Q());
        } else {
            if (q.o0()) {
                i0Var = e(q.a0());
            } else {
                i0Var = i;
            }
        }
        if (i0Var != null) {
            return i0Var;
        }
        final t0 t0Var = r(q);
        if (t.r(t0Var.c())) {
            i0 obj12 = t.o(t0Var.toString(), t0Var);
            n.e(obj12, "createErrorTypeWithCustomConstructor(constructor.toString(), constructor)");
            return obj12;
        }
        b0.b bVar = new b0.b(this, q);
        a aVar = new a(this.a.h(), bVar);
        List list = b0.m(q, this);
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator = list.iterator();
        final int i10 = 0;
        i4 = i10;
        for (Object next2 : iterator) {
            parameters = t0Var.getParameters();
            n.e(parameters, "constructor.parameters");
            arrayList.add(q((z0)p.a0(parameters, i4), (q.b)next2));
            i4 = i2;
        }
        List list2 = p.L0(arrayList);
        h hVar2 = t0Var.c();
        if (z2 && hVar2 instanceof y0) {
            if (hVar2 instanceof y0) {
                obj13 = c0.a;
                obj13 = c0.b((y0)hVar2, list2);
                if (!d0.b(obj13)) {
                    if (q.X()) {
                        i3 = 1;
                    } else {
                        i3 = i10;
                    }
                } else {
                }
                obj13 = obj13.S0(i3).T0(g.q.a(p.r0(aVar, obj13.getAnnotations())));
            } else {
                obj13 = b.a.g(q.T());
                n.e(obj13, "SUSPEND_TYPE.get(proto.flags)");
                if (obj13.booleanValue()) {
                    obj13 = h(aVar, t0Var, list2, q.X());
                } else {
                    obj13 = c0.a;
                    obj13 = c0.i(aVar, t0Var, list2, q.X(), 0, 16, 0);
                }
            }
        } else {
        }
        qVar = f.a(q, this.a.j());
        if (qVar == null) {
        } else {
            qVar = l0.j(obj13, l(qVar, i10));
            if (qVar == null) {
            } else {
                obj13 = qVar;
            }
        }
        if (q.f0()) {
            return this.a.c().t().a(v.a(this.a.g(), q.Q()), obj13);
        }
        return obj13;
    }

    public final b0 p(q q) {
        n.f(q, "proto");
        if (q.h0()) {
            int i3 = 0;
            int i4 = 2;
            final int i5 = 0;
            q qVar2 = f.c(q, this.a.j());
            n.d(qVar2);
            return this.a.c().l().a(q, this.a.g().getString(q.U()), b0.n(this, q, i3, i4, i5), b0.n(this, qVar2, i3, i4, i5));
        }
        return l(q, true);
    }

    public String toString() {
        String str2;
        String str;
        kotlin.i0.z.e.m0.j.b.b0 b0Var = this.b;
        if (b0Var == null) {
            str2 = "";
        } else {
            str2 = n.o(". Child of ", b0Var.c);
        }
        return n.o(this.c, str2);
    }
}
