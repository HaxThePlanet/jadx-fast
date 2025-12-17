package kotlin.i0.z.e.m0.i.q;

import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.d0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.t;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.i0.z.e.m0.l.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class q extends kotlin.i0.z.e.m0.i.q.g<kotlin.i0.z.e.m0.i.q.q.b> {

    public static final kotlin.i0.z.e.m0.i.q.q.a b;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.i0.z.e.m0.i.q.g<?> a(b0 b0) {
            a i;
            kotlin.i0.z.e.m0.i.q.q qVar;
            Object type;
            Object str2;
            int i2;
            String str;
            Object obj6;
            n.f(b0, "argumentType");
            if (d0.a(b0)) {
                return 0;
            }
            i = 0;
            type = b0;
            i2 = i;
            while (h.b0(type)) {
                n.e((v0)p.z0(type.K0()).getType(), "type.arguments.single().type");
                i2++;
            }
            str2 = type.L0().c();
            if (str2 instanceof e) {
                i = a.h(str2);
                if (i == null) {
                    q.b.a aVar = new q.b.a(b0);
                    q qVar2 = new q(aVar);
                    return qVar2;
                }
                qVar = new q(i, i2);
            } else {
                if (str2 instanceof z0) {
                    obj6 = a.m(k.a.b.l());
                    n.e(obj6, "topLevel(StandardNames.FqNames.any.toSafe())");
                    qVar = new q(obj6, i);
                }
            }
            return qVar;
        }
    }

    public static abstract class b {
        public b(g g) {
            super();
        }
    }
    static {
        q.a aVar = new q.a(0);
        q.b = aVar;
    }

    public q(a a, int i2) {
        n.f(a, "classId");
        f fVar = new f(a, i2);
        super(fVar);
    }

    public q(kotlin.i0.z.e.m0.i.q.f f) {
        n.f(f, "value");
        q.b.b bVar = new q.b.b(f);
        super(bVar);
    }

    public q(kotlin.i0.z.e.m0.i.q.q.b q$b) {
        n.f(b, "value");
        super(b);
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public b0 a(c0 c0) {
        n.f(c0, "module");
        c0 c0Var = c0.a;
        e eVar = c0.m().E();
        n.e(eVar, "module.builtIns.kClass");
        x0 x0Var = new x0(c(c0));
        return c0.g(g.q.b(), eVar, p.b(x0Var));
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public final b0 c(c0 c0) {
        b0 b0Var;
        int i;
        String str;
        h1 iNVARIANT;
        n.f(c0, "module");
        Object obj = b();
        if (obj instanceof q.b.a) {
            return (q.b.a)b().a();
        }
        if (!obj instanceof q.b.b) {
        } else {
            kotlin.i0.z.e.m0.i.q.f fVar = (q.b.b)b().c();
            a aVar = fVar.a();
            int i2 = fVar.b();
            e eVar = w.a(c0, aVar);
            if (eVar == null) {
                StringBuilder obj6 = new StringBuilder();
                obj6.append("Unresolved type: ");
                obj6.append(aVar);
                obj6.append(" (arrayDimensions=");
                obj6.append(i2);
                obj6.append(')');
                obj6 = t.j(obj6.toString());
                n.e(obj6, "createErrorType(\"Unresolved type: $classId (arrayDimensions=$arrayDimensions)\")");
                return obj6;
            }
            kotlin.i0.z.e.m0.l.i0 i0Var = eVar.q();
            n.e(i0Var, "descriptor.defaultType");
            b0Var = a.m(i0Var);
            i = 0;
            while (i < i2) {
                n.e(c0.m().l(h1.INVARIANT, b0Var), "module.builtIns.getArrayType(Variance.INVARIANT, type)");
                i++;
            }
            return b0Var;
        }
        obj6 = new NoWhenBranchMatchedException();
        throw obj6;
    }
}
