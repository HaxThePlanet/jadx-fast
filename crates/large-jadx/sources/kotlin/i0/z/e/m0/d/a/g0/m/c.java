package kotlin.i0.z.e.m0.d.a.g0.m;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.j;
import kotlin.i0.z.e.m0.b.q.d;
import kotlin.i0.z.e.m0.d.a.e0.k;
import kotlin.i0.z.e.m0.d.a.g0.b;
import kotlin.i0.z.e.m0.d.a.g0.d;
import kotlin.i0.z.e.m0.d.a.g0.g;
import kotlin.i0.z.e.m0.d.a.g0.i;
import kotlin.i0.z.e.m0.d.a.g0.k;
import kotlin.i0.z.e.m0.d.a.i0.b0;
import kotlin.i0.z.e.m0.d.a.i0.f;
import kotlin.i0.z.e.m0.d.a.i0.g;
import kotlin.i0.z.e.m0.d.a.i0.j;
import kotlin.i0.z.e.m0.d.a.i0.v;
import kotlin.i0.z.e.m0.d.a.i0.x;
import kotlin.i0.z.e.m0.d.b.e;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.j.b.j;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.e0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.t;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.i0.z.e.m0.l.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.e0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class c {

    private final g a;
    private final k b;

    static final class a extends p implements a<b0> {

        final kotlin.i0.z.e.m0.d.a.g0.m.a $attr;
        final t0 $constructor;
        final z0 $parameter;
        a(z0 z0, kotlin.i0.z.e.m0.d.a.g0.m.a a2, t0 t03) {
            this.$parameter = z0;
            this.$attr = a2;
            this.$constructor = t03;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final b0 a() {
            z0 $parameter = this.$parameter;
            n.e($parameter, "parameter");
            c.a.a aVar = new c.a.a(this.$constructor);
            return d.b($parameter, this.$attr.e(), aVar);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    public c(g g, k k2) {
        n.f(g, "c");
        n.f(k2, "typeParameterResolver");
        super();
        this.a = g;
        this.b = k2;
    }

    private final boolean a(j j, e e2) {
        int i;
        int obj2;
        i = 0;
        if (!c.b((x)p.l0(j.F()))) {
            return i;
        }
        obj2 = d.a.b(e2).g().getParameters();
        n.e(obj2, "JavaToKotlinClassMapper.convertReadOnlyToMutable(readOnlyContainer)\n            .typeConstructor.parameters");
        obj2 = p.l0(obj2);
        if ((z0)obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = (z0)obj2.l();
        }
        if (obj2 == null) {
            return i;
        }
        if (obj2 != h1.OUT_VARIANCE) {
            i = 1;
        }
        return i;
    }

    private static final boolean b(x x) {
        int i;
        x xVar;
        int obj2;
        if (x instanceof b0) {
        } else {
            obj2 = 0;
        }
        i = 0;
        if (obj2 == null) {
        } else {
            if (obj2.C() != null && !obj2.J()) {
                if (!obj2.J()) {
                    i = obj2;
                }
            }
        }
        return i;
    }

    private final List<v0> c(j j, kotlin.i0.z.e.m0.d.a.g0.m.a a2, t0 t03) {
        boolean x0Var;
        int i;
        boolean empty;
        List parameters;
        int i2;
        kotlin.i0.z.e.m0.d.a.g0.m.a aVar;
        int obj10;
        x0Var = j.x();
        int i4 = 0;
        String str = "constructor.parameters";
        if (!x0Var) {
            List parameters2 = t03.getParameters();
            n.e(parameters2, str);
            if (j.F().isEmpty() && empty2 ^= i != 0) {
                parameters2 = t03.getParameters();
                n.e(parameters2, str);
                if (empty2 ^= i != 0) {
                } else {
                    i = i4;
                }
            } else {
            }
        }
        parameters = t03.getParameters();
        n.e(parameters, str);
        String str2 = "parameter";
        i2 = 10;
        if (i != 0) {
            ArrayList obj8 = new ArrayList(p.r(parameters, i2));
            Iterator iterator = parameters.iterator();
            while (iterator.hasNext()) {
                Object next2 = iterator.next();
                c.a aVar2 = new c.a((z0)next2, a2, t03);
                parameters = new e0(this.a.e(), aVar2);
                n.e(next2, str2);
                if (x0Var) {
                } else {
                }
                aVar = a2.g(b.INFLEXIBLE);
                obj8.add(e.b.i(next2, aVar, parameters));
                aVar = a2;
            }
            return p.L0(obj8);
        }
        if (parameters.size() != j.F().size()) {
            obj8 = new ArrayList(p.r(parameters, i2));
            Iterator obj9 = parameters.iterator();
            for (z0 obj10 : obj9) {
                x0Var = new x0(t.j(obj10.getName().c()));
                obj8.add(x0Var);
            }
            return p.L0(obj8);
        }
        obj8 = p.R0(j.F());
        obj9 = new ArrayList(p.r(obj8, i2));
        obj8 = obj8.iterator();
        for (e0 obj10 : obj8) {
            int size = parameters.size();
            x0Var = parameters.get(obj10.a());
            aVar = 0;
            n.e((z0)x0Var, str2);
            obj9.add(o((x)obj10.b(), d.f(k.COMMON, i4, aVar, 3, aVar), x0Var));
        }
        return p.L0(obj9);
    }

    private final i0 d(j j, kotlin.i0.z.e.m0.d.a.g0.m.a a2, i0 i03) {
        t0 i;
        boolean z;
        int annotations;
        d dVar2;
        g gVar;
        kotlin.i0.z.e.m0.d.a.i0.d dVar;
        int i3;
        int i4;
        int i2;
        final Object obj = this;
        kotlin.i0.z.e.m0.d.a.g0.m.a aVar = a2;
        Object obj2 = i03;
        i = 0;
        if (obj2 == null) {
            annotations = i;
        } else {
            annotations = i03.getAnnotations();
        }
        if (annotations == 0) {
            super(obj.a, j, 0, 4, 0);
        }
        final t0 t0Var = e(j, a2);
        if (t0Var == null) {
            return i;
        }
        final boolean z2 = obj.h(aVar);
        if (obj2 == null) {
        } else {
            i = i03.L0();
        }
        if (n.b(i, t0Var) && !j.x() && z2) {
            if (!j.x()) {
                if (z2) {
                    return obj2.S0(true);
                }
            }
        }
        c0 c0Var = c0.a;
        return c0.i(annotations, t0Var, obj.c(j, aVar, t0Var), z2, 0, 16, 0);
    }

    private final t0 e(j j, kotlin.i0.z.e.m0.d.a.g0.m.a a2) {
        kotlin.i0.z.e.m0.d.a.i0.i iVar;
        int i;
        b bVar;
        Object obj5;
        e obj6;
        final kotlin.i0.z.e.m0.d.a.i0.i iVar2 = j.c();
        if (iVar2 == null) {
            return f(j);
        }
        i = 0;
        if (iVar2 instanceof g) {
            iVar = iVar2;
            bVar = (g)iVar.d();
            if (bVar == null) {
            } else {
                if (i(j, a2, bVar) == null) {
                    obj6 = this.a.a().m().a(iVar);
                }
                if (obj6 == null) {
                } else {
                    i = obj6;
                }
                if (i == 0) {
                    i = f(j);
                }
                return i;
            }
            obj6 = new AssertionError(n.o("Class type should have a FQ name: ", iVar2));
            throw obj6;
        }
        if (!iVar2 instanceof y) {
        } else {
            obj5 = this.b.a((y)iVar2);
            if (obj5 == null) {
            } else {
                i = obj5.g();
            }
        }
        obj5 = new IllegalStateException(n.o("Unknown classifier kind: ", iVar2));
        throw obj5;
    }

    private final t0 f(j j) {
        b bVar = new b(j.y());
        a obj3 = a.m(bVar);
        n.e(obj3, "topLevel(FqName(javaType.classifierQualifiedName))");
        obj3 = this.a.a().b().f().q().d(obj3, p.b(0)).g();
        n.e(obj3, "c.components.deserializedDescriptorResolver.components.notFoundClasses.getClass(classId, listOf(0)).typeConstructor");
        return obj3;
    }

    private final boolean g(h1 h1, z0 z02) {
        int i;
        if (z02.l() == h1.INVARIANT) {
            return 0;
        }
        if (h1 != z02.l()) {
            i = 1;
        }
        return i;
    }

    private final boolean h(kotlin.i0.z.e.m0.d.a.g0.m.a a) {
        boolean sUPERTYPE;
        int i;
        k obj4;
        if (a.c() == b.FLEXIBLE_LOWER_BOUND) {
            return 0;
        }
        if (!a.f() && a.d() != k.SUPERTYPE) {
            if (a.d() != k.SUPERTYPE) {
                i = 1;
            }
        }
        return i;
    }

    private final e i(j j, kotlin.i0.z.e.m0.d.a.g0.m.a a2, b b3) {
        boolean z;
        boolean sUPERTYPE;
        Object fLEXIBLE_LOWER_BOUND;
        j obj8;
        k obj9;
        if (a2.f() && n.b(b3, d.a())) {
            if (n.b(b3, d.a())) {
                return this.a.a().o().c();
            }
        }
        final d dVar2 = d.a;
        final e obj10 = d.h(dVar2, b3, this.a.d().m(), 0, 4, 0);
        if (obj10 == null) {
            return null;
        }
        if (dVar2.e(obj10) && a2.c() != b.FLEXIBLE_LOWER_BOUND && a2.d() != k.SUPERTYPE && a(j, obj10)) {
            if (a2.c() != b.FLEXIBLE_LOWER_BOUND) {
                if (a2.d() != k.SUPERTYPE) {
                    if (a(j, obj10)) {
                    }
                }
            }
            return dVar2.b(obj10);
        }
        return obj10;
    }

    public static b0 k(kotlin.i0.z.e.m0.d.a.g0.m.c c, f f2, kotlin.i0.z.e.m0.d.a.g0.m.a a3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return c.j(f2, a3, obj3);
    }

    private final b0 l(j j, kotlin.i0.z.e.m0.d.a.g0.m.a a2) {
        boolean z;
        int i;
        k sUPERTYPE;
        kotlin.i0.z.e.m0.l.g1 obj4;
        i0 obj5;
        if (!a2.f() && a2.d() != k.SUPERTYPE) {
            i = a2.d() != k.SUPERTYPE ? 1 : 0;
        } else {
        }
        boolean z2 = j.x();
        int i2 = 0;
        if (!z2 && i == 0 && d(j, a2, i2) == null) {
            if (i == 0) {
                if (d(j, a2, i2) == null) {
                    obj5 = c.m(j);
                }
                return obj5;
            }
        }
        i0 i0Var = d(j, a2.g(b.FLEXIBLE_LOWER_BOUND), i2);
        if (i0Var == null) {
            return c.m(j);
        }
        obj5 = d(j, a2.g(b.FLEXIBLE_UPPER_BOUND), i0Var);
        if (obj5 == null) {
            return c.m(j);
        }
        if (z2) {
            obj4 = new f(i0Var, obj5);
        } else {
            obj4 = c0.a;
            obj4 = c0.d(i0Var, obj5);
        }
        return obj4;
    }

    private static final i0 m(j j) {
        i0 obj1 = t.j(n.o("Unresolved java class ", j.q()));
        n.e(obj1, "createErrorType(\"Unresolved java class ${javaType.presentableText}\")");
        return obj1;
    }

    private final v0 o(x x, kotlin.i0.z.e.m0.d.a.g0.m.a a2, z0 z03) {
        Object iNVARIANT;
        int i3;
        int i;
        int i2;
        v0 obj5;
        Object obj6;
        Object obj7;
        if (x instanceof b0) {
            iNVARIANT = (b0)x.C();
            obj5 = x.J() ? h1.OUT_VARIANCE : h1.IN_VARIANCE;
            if (iNVARIANT != null) {
                if (g(obj5, z03)) {
                    obj5 = d.d(z03, a2);
                } else {
                    i2 = 0;
                    obj5 = a.d(n(iNVARIANT, d.f(k.COMMON, false, i2, 3, i2)), obj5, z03);
                }
            } else {
            }
        } else {
            obj7 = new x0(h1.INVARIANT, n(x, a2));
            obj5 = obj7;
        }
        return obj5;
    }

    public final b0 j(f f, kotlin.i0.z.e.m0.d.a.g0.m.a a2, boolean z3) {
        x xVar;
        int type;
        kotlin.i0.z.e.m0.l.g1 obj7;
        h1 obj8;
        n.f(f, "arrayType");
        n.f(a2, "attr");
        x xVar2 = f.p();
        final int i = 0;
        if (xVar2 instanceof v) {
            xVar = xVar2;
        } else {
            xVar = i;
        }
        if (xVar == null) {
            type = i;
        } else {
            type = xVar.getType();
        }
        final int i3 = 1;
        d dVar = new d(this.a, f, i3);
        if (type != null) {
            obj7 = this.a.d().m().N(type);
            n.e(obj7, "c.module.builtIns.getPrimitiveArrayKotlinType(primitiveType)");
            obj7.T0(g.q.a(p.r0(dVar, obj7.getAnnotations())));
            if (a2.f()) {
            } else {
                obj8 = c0.a;
                obj7 = c0.d(obj7, obj7.S0(i3));
            }
            return obj7;
        }
        obj7 = n(xVar2, d.f(k.COMMON, a2.f(), i, 2, i));
        if (a2.f()) {
            obj8 = z3 ? h1.OUT_VARIANCE : h1.INVARIANT;
            obj7 = this.a.d().m().m(obj8, obj7, dVar);
            n.e(obj7, "c.module.builtIns.getArrayType(projectionKind, componentType, annotations)");
            return obj7;
        }
        obj8 = c0.a;
        obj8 = this.a.d().m().m(h1.INVARIANT, obj7, dVar);
        n.e(obj8, "c.module.builtIns.getArrayType(INVARIANT, componentType, annotations)");
        return c0.d(obj8, this.a.d().m().m(h1.OUT_VARIANCE, obj7, dVar).S0(i3));
    }

    public final b0 n(x x, kotlin.i0.z.e.m0.d.a.g0.m.a a2) {
        boolean z;
        Object str;
        Object obj;
        Object obj2;
        int i;
        int i3;
        int i2;
        i0 obj8;
        Object obj9;
        n.f(a2, "attr");
        if (x instanceof v) {
            obj8 = (v)x.getType();
            if (obj8 != null) {
                obj8 = this.a.d().m().Q(obj8);
            } else {
                obj8 = this.a.d().m().Y();
            }
            n.e(obj8, "{\n                val primitiveType = javaType.type\n                if (primitiveType != null) c.module.builtIns.getPrimitiveKotlinType(primitiveType)\n                else c.module.builtIns.unitType\n            }");
            return obj8;
        } else {
            if (x instanceof j) {
                obj8 = l((j)x, a2);
            } else {
                if (x instanceof f) {
                    obj8 = c.k(this, (f)x, a2, false, 4, 0);
                } else {
                    str = "c.module.builtIns.defaultBound";
                    if (x instanceof b0) {
                        obj8 = (b0)x.C();
                        if (obj8 == null) {
                            obj8 = 0;
                        } else {
                            obj8 = n(obj8, a2);
                        }
                        if (obj8 == null) {
                            n.e(this.a.d().m().y(), str);
                        }
                    } else {
                        if (x != null) {
                        } else {
                            n.e(this.a.d().m().y(), str);
                        }
                    }
                }
            }
        }
        obj9 = new UnsupportedOperationException(n.o("Unsupported type: ", x));
        throw obj9;
    }
}
