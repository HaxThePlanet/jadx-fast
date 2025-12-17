package kotlin.i0.z.e.m0.d.a.g0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.q.d;
import kotlin.i0.z.e.m0.d.a.e0.a;
import kotlin.i0.z.e.m0.d.a.e0.k;
import kotlin.i0.z.e.m0.d.a.f0.i;
import kotlin.i0.z.e.m0.d.a.g0.b;
import kotlin.i0.z.e.m0.d.a.g0.g;
import kotlin.i0.z.e.m0.d.a.g0.i;
import kotlin.i0.z.e.m0.d.a.g0.m.c;
import kotlin.i0.z.e.m0.d.a.g0.m.d;
import kotlin.i0.z.e.m0.d.a.h0.a;
import kotlin.i0.z.e.m0.d.a.h0.b;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.b;
import kotlin.i0.z.e.m0.d.a.i0.c;
import kotlin.i0.z.e.m0.d.a.i0.e;
import kotlin.i0.z.e.m0.d.a.i0.h;
import kotlin.i0.z.e.m0.d.a.i0.m;
import kotlin.i0.z.e.m0.d.a.i0.o;
import kotlin.i0.z.e.m0.d.a.i0.x;
import kotlin.i0.z.e.m0.d.a.y;
import kotlin.i0.z.e.m0.d.b.e;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.h.c;
import kotlin.i0.z.e.m0.i.q.a;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.i.q.h;
import kotlin.i0.z.e.m0.i.q.j;
import kotlin.i0.z.e.m0.i.q.q;
import kotlin.i0.z.e.m0.i.q.q.a;
import kotlin.i0.z.e.m0.i.q.s;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.j.b.j;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.j;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.d0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.t;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class e implements c, i {

    static final l<Object>[] i;
    private final g a;
    private final a b;
    private final j c;
    private final i d;
    private final a e;
    private final i f;
    private final boolean g;
    private final boolean h;

    static final class a extends p implements a<Map<e, ? extends g<?>>> {

        final kotlin.i0.z.e.m0.d.a.g0.l.e this$0;
        a(kotlin.i0.z.e.m0.d.a.g0.l.e e) {
            this.this$0 = e;
            super(0);
        }

        public final Map<e, g<?>> a() {
            kotlin.o oVar;
            e name;
            ArrayList arrayList = new ArrayList();
            Iterator iterator = e.e(this.this$0).b().iterator();
            while (iterator.hasNext()) {
                Object next2 = iterator.next();
                if ((b)next2.getName() == null) {
                }
                g gVar = e.g(this.this$0, next2);
                if (gVar == null) {
                } else {
                }
                oVar = u.a(name, gVar);
                if (oVar != null) {
                }
                arrayList.add(oVar);
                oVar = 0;
                name = y.b;
            }
            return j0.s(arrayList);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    static final class b extends p implements a<b> {

        final kotlin.i0.z.e.m0.d.a.g0.l.e this$0;
        b(kotlin.i0.z.e.m0.d.a.g0.l.e e) {
            this.this$0 = e;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final b a() {
            int i;
            a aVar2 = e.e(this.this$0).e();
            if (aVar2 == null) {
                i = 0;
            } else {
                i = aVar2.b();
            }
            return i;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    static final class c extends p implements a<i0> {

        final kotlin.i0.z.e.m0.d.a.g0.l.e this$0;
        c(kotlin.i0.z.e.m0.d.a.g0.l.e e) {
            this.this$0 = e;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final i0 a() {
            e eVar;
            Object bVar;
            b bVar2 = this.this$0.d();
            if (bVar2 == null) {
                return t.j(n.o("No fqName: ", e.e(this.this$0)));
            }
            if (d.h(d.a, bVar2, e.c(this.this$0).d().m(), 0, 4, 0) == null) {
                kotlin.i0.z.e.m0.d.a.i0.g gVar = e.e(this.this$0).z();
                if (gVar == null) {
                    eVar = 0;
                } else {
                    eVar = e.c(this.this$0).a().m().a(gVar);
                }
                if (eVar == null) {
                    eVar = e.b(this.this$0, bVar2);
                }
            }
            return eVar.q();
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        Class<kotlin.i0.z.e.m0.d.a.g0.l.e> obj = e.class;
        l[] arr = new l[3];
        x xVar = new x(c0.b(obj), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;");
        x xVar2 = new x(c0.b(obj), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;");
        x xVar3 = new x(c0.b(obj), "allValueArguments", "getAllValueArguments()Ljava/util/Map;");
        e.i = arr;
    }

    public e(g g, a a2, boolean z3) {
        int obj3;
        n.f(g, "c");
        n.f(a2, "javaAnnotation");
        super();
        this.a = g;
        this.b = a2;
        e.b bVar3 = new e.b(this);
        this.c = g.e().f(bVar3);
        e.c cVar = new e.c(this);
        this.d = g.e().d(cVar);
        this.e = g.a().s().a(a2);
        e.a aVar2 = new e.a(this);
        this.f = g.e().d(aVar2);
        this.g = a2.f();
        if (!a2.w()) {
            if (z3) {
                obj3 = 1;
            } else {
                obj3 = 0;
            }
        } else {
        }
        this.h = obj3;
    }

    public e(g g, a a2, boolean z3, int i4, g g5) {
        int obj3;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(g, a2, obj3);
    }

    public static final e b(kotlin.i0.z.e.m0.d.a.g0.l.e e, b b2) {
        return e.h(b2);
    }

    public static final g c(kotlin.i0.z.e.m0.d.a.g0.l.e e) {
        return e.a;
    }

    public static final a e(kotlin.i0.z.e.m0.d.a.g0.l.e e) {
        return e.b;
    }

    public static final g g(kotlin.i0.z.e.m0.d.a.g0.l.e e, b b2) {
        return e.l(b2);
    }

    private final e h(b b) {
        a obj3 = a.m(b);
        n.e(obj3, "topLevel(fqName)");
        return w.c(this.a.d(), obj3, this.a.a().b().f().q());
    }

    private final g<?> l(b b) {
        e name;
        String str;
        g obj3;
        if (b instanceof o) {
            obj3 = h.a.c((o)b.getValue());
        } else {
            if (b instanceof m) {
                obj3 = o((m)b.b(), b.d());
            } else {
                if (b instanceof e) {
                    if (b.getName() == null) {
                        name = y.b;
                    }
                    n.e(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
                    obj3 = n(name, (e)b.e());
                } else {
                    if (b instanceof c) {
                        obj3 = m((c)b.a());
                    } else {
                        if (b instanceof h) {
                            obj3 = p((h)b.c());
                        } else {
                            obj3 = 0;
                        }
                    }
                }
            }
        }
        return obj3;
    }

    private final g<?> m(a a) {
        super(this.a, a, 0, 4, 0);
        a aVar = new a(eVar2);
        return aVar;
    }

    private final g<?> n(e e, List<? extends b> list2) {
        Object iNVARIANT;
        int sVar;
        int type;
        Object obj3;
        i0 i0Var = j();
        n.e(i0Var, "type");
        if (d0.a(i0Var)) {
            return 0;
        }
        iNVARIANT = a.f(this);
        n.d(iNVARIANT);
        obj3 = a.b(e, iNVARIANT);
        if (obj3 == null) {
        } else {
            type = obj3.getType();
        }
        if (type == null) {
            type = this.a.a().l().m().l(h1.INVARIANT, t.j("Unknown array element type"));
        }
        n.e(type, "DescriptorResolverUtils.getAnnotationParameterByName(argumentName, annotationClass!!)?.type\n            // Try to load annotation arguments even if the annotation class is not found\n                ?: c.components.module.builtIns.getArrayType(\n                    Variance.INVARIANT,\n                    ErrorUtils.createErrorType(\"Unknown array element type\")\n                )");
        obj3 = new ArrayList(p.r(list2, 10));
        Iterator obj4 = list2.iterator();
        while (obj4.hasNext()) {
            if (l((b)obj4.next()) == null) {
            }
            obj3.add(sVar);
            sVar = new s();
        }
        return h.a.b(obj3, type);
    }

    private final g<?> o(a a, e e2) {
        if (a != null && e2 == null) {
            if (e2 == null) {
            }
            j jVar = new j(a, e2);
            return jVar;
        }
        return 0;
    }

    private final g<?> p(x x) {
        final int i2 = 0;
        return q.b.a(this.a.g().n(x, d.f(k.COMMON, false, i2, 3, i2)));
    }

    public Map<e, g<?>> a() {
        return (Map)m.a(this.f, this, e.i[2]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public b d() {
        return (b)m.b(this.c, this, e.i[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public boolean f() {
        return this.g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public u0 getSource() {
        return i();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public b0 getType() {
        return j();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public a i() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public i0 j() {
        return (i0)m.a(this.d, this, e.i[1]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public final boolean k() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public String toString() {
        final int i = 0;
        return c.t(c.b, this, i, 2, i);
    }
}
