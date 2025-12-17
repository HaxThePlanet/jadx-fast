package kotlin.i0.z.e.m0.i.s;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.d0.c.l;
import kotlin.d0.d.b0;
import kotlin.d0.d.c0;
import kotlin.d0.d.j;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.f;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.i.v.k;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.j1.g.a;
import kotlin.i0.z.e.m0.l.j1.h;
import kotlin.i0.z.e.m0.l.j1.o;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.j0.h;
import kotlin.j0.i;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.n0;
import kotlin.reflect.jvm.internal.impl.utils.b;
import kotlin.reflect.jvm.internal.impl.utils.b.b;
import kotlin.reflect.jvm.internal.impl.utils.b.c;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class a {

    static final class a implements b.c<c1> {

        public static final kotlin.i0.z.e.m0.i.s.a.a a;
        static {
            a.a aVar = new a.a();
            a.a.a = aVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$c
        public Iterable a(Object object) {
            return b((c1)object);
        }

        public final Iterable<c1> b(c1 c1) {
            int i;
            Collection obj3 = c1.e();
            ArrayList arrayList = new ArrayList(p.r(obj3, 10));
            obj3 = obj3.iterator();
            for (c1 next2 : obj3) {
                arrayList.add(next2.a());
            }
            return arrayList;
        }
    }

    static final class c implements b.c<b> {

        final boolean a;
        c(boolean z) {
            this.a = z;
            super();
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$c
        public Iterable a(Object object) {
            return b((b)object);
        }

        public final Iterable<b> b(b b) {
            Collection i;
            b obj3;
            if (this.a) {
                if (b == null) {
                    obj3 = i;
                } else {
                    obj3 = b.a();
                }
            }
            if (obj3 == null) {
            } else {
                i = obj3.e();
            }
            if (i == null) {
                i = p.g();
            }
            return i;
        }
    }

    public static final class d extends b.b<b, b> {

        final b0<b> a;
        final l<b, Boolean> b;
        d(b0<b> b0, l<? super b, Boolean> l2) {
            this.a = b0;
            this.b = l2;
            super();
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public Object a() {
            return f();
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public void b(Object object) {
            d((b)object);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public boolean c(Object object) {
            return e((b)object);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public void d(b b) {
            Object booleanValue;
            n.f(b, "current");
            if (b0Var.element == null && (Boolean)this.b.invoke(b).booleanValue()) {
                if ((Boolean)this.b.invoke(b).booleanValue()) {
                    booleanValue.element = b;
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public boolean e(b b) {
            int obj2;
            n.f(b, "current");
            obj2 = obj2.element == null ? 1 : 0;
            return obj2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public b f() {
            return (b)b0Var.element;
        }
    }

    static final class e extends p implements l<m, m> {

        public static final kotlin.i0.z.e.m0.i.s.a.e a;
        static {
            a.e eVar = new a.e();
            a.e.a = eVar;
        }

        e() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final m a(m m) {
            n.f(m, "it");
            return m.b();
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((m)object);
        }
    }

    class b extends j implements l<c1, Boolean> {

        public static final kotlin.i0.z.e.m0.i.s.a.b a;
        static {
            a.b bVar = new a.b();
            a.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.j
        public final String getName() {
            return "declaresDefaultValue";
        }

        @Override // kotlin.d0.d.j
        public final f getOwner() {
            return c0.b(c1.class);
        }

        @Override // kotlin.d0.d.j
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }

        @Override // kotlin.d0.d.j
        public Object invoke(Object object) {
            return Boolean.valueOf(l((c1)object));
        }

        @Override // kotlin.d0.d.j
        public final boolean l(c1 c1) {
            n.f(c1, "p0");
            return c1.t0();
        }
    }
    static {
        n.e(e.j("value"), "identifier(\"value\")");
    }

    public static final boolean a(c1 c1) {
        n.f(c1, "<this>");
        Boolean obj2 = b.e(p.b(c1), a.a.a, a.b.a);
        n.e(obj2, "ifAny(\n        listOf(this),\n        { current -> current.overriddenDescriptors.map(ValueParameterDescriptor::getOriginal) },\n        ValueParameterDescriptor::declaresDefaultValue\n    )");
        return obj2.booleanValue();
    }

    public static final g<?> b(c c) {
        n.f(c, "<this>");
        return (g)p.Y(c.a().values());
    }

    public static final b c(b b, boolean z2, l<? super b, Boolean> l3) {
        n.f(b, "<this>");
        n.f(l3, "predicate");
        b0 b0Var = new b0();
        a.c cVar = new a.c(z2);
        a.d obj3 = new a.d(b0Var, l3);
        return (b)b.b(p.b(b), cVar, obj3);
    }

    public static b d(b b, boolean z2, l l3, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        return a.c(b, obj1, l3);
    }

    public static final b e(m m) {
        b i;
        c obj2;
        n.f(m, "<this>");
        if (a.j(m).f()) {
        } else {
            obj2 = i;
        }
        if (obj2 == null) {
        } else {
            i = obj2.l();
        }
        return i;
    }

    public static final e f(c c) {
        h obj1;
        n.f(c, "<this>");
        if (obj1 instanceof e) {
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    public static final h g(m m) {
        n.f(m, "<this>");
        return a.l(m).m();
    }

    public static final a h(h h) {
        int aVar;
        Object obj;
        boolean z;
        Object obj3;
        aVar = 0;
        if (h == null) {
        } else {
            obj = h.b();
            if (obj == null) {
            } else {
                if (obj instanceof f0) {
                    aVar = new a((f0)obj.d(), h.getName());
                } else {
                    if (obj instanceof i) {
                        obj = a.h((h)obj);
                        if (obj == null) {
                        } else {
                            aVar = obj3;
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static final b i(m m) {
        n.f(m, "<this>");
        final b obj1 = d.n(m);
        n.e(obj1, "getFqNameSafe(this)");
        return obj1;
    }

    public static final c j(m m) {
        n.f(m, "<this>");
        final c obj1 = d.m(m);
        n.e(obj1, "getFqName(this)");
        return obj1;
    }

    public static final g k(c0 c0) {
        int obj1;
        n.f(c0, "<this>");
        obj1 = c0.F0(h.a());
        if ((o)obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = (o)obj1.a();
        }
        if (obj1 == null) {
            obj1 = g.a.a;
        }
        return obj1;
    }

    public static final c0 l(m m) {
        n.f(m, "<this>");
        final c0 obj1 = d.g(m);
        n.e(obj1, "getContainingModule(this)");
        return obj1;
    }

    public static final h<m> m(m m) {
        n.f(m, "<this>");
        return i.k(a.n(m), 1);
    }

    public static final h<m> n(m m) {
        n.f(m, "<this>");
        return i.f(m, a.e.a);
    }

    public static final b o(b b) {
        boolean str;
        Object obj1;
        n.f(b, "<this>");
        if (b instanceof n0) {
            n.e((n0)b.y0(), "correspondingProperty");
        }
        return obj1;
    }

    public static final e p(e e) {
        String next;
        boolean z;
        n.f(e, "<this>");
        Iterator obj2 = e.q().L0().a().iterator();
        for (b0 next : obj2) {
            next = next.L0().c();
        }
        return null;
    }

    public static final boolean q(c0 c0) {
        int obj1;
        n.f(c0, "<this>");
        obj1 = c0.F0(h.a());
        if ((o)obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = (o)obj1.a();
        }
        obj1 = obj1 != null ? 1 : 0;
        return obj1;
    }

    public static final e r(c0 c0, b b2, b b3) {
        h obj2;
        n.f(c0, "<this>");
        n.f(b2, "topLevelClassFqName");
        n.f(b3, "location");
        b2.d();
        b bVar = b2.e();
        n.e(bVar, "topLevelClassFqName.parent()");
        e obj3 = b2.g();
        n.e(obj3, "topLevelClassFqName.shortName()");
        if (obj2 instanceof e) {
        } else {
            obj2 = 0;
        }
        return obj2;
    }
}
