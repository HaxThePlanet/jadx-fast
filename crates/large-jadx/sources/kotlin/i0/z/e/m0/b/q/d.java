package kotlin.i0.z.e.m0.b.q;

import java.util.Collection;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.k;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class d {

    public static final kotlin.i0.z.e.m0.b.q.d a;
    static {
        d dVar = new d();
        d.a = dVar;
    }

    public static e h(kotlin.i0.z.e.m0.b.q.d d, b b2, h h3, Integer integer4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return d.g(b2, h3, obj3);
    }

    public final e a(e e) {
        String str = "mutable";
        n.f(e, str);
        b bVar = c.a.p(d.m(e));
        if (bVar == null) {
        } else {
            e obj5 = a.g(e).o(bVar);
            n.e(obj5, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return obj5;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Given class ");
        stringBuilder.append(e);
        stringBuilder.append(" is not a ");
        stringBuilder.append(str);
        stringBuilder.append(" collection");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public final e b(e e) {
        n.f(e, "readOnly");
        b bVar = c.a.q(d.m(e));
        if (bVar == null) {
        } else {
            e obj4 = a.g(e).o(bVar);
            n.e(obj4, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return obj4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Given class ");
        stringBuilder.append(e);
        stringBuilder.append(" is not a ");
        stringBuilder.append("read-only");
        stringBuilder.append(" collection");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public final boolean c(e e) {
        n.f(e, "mutable");
        return c.a.l(d.m(e));
    }

    public final boolean d(b0 b0) {
        e obj2;
        n.f(b0, "type");
        obj2 = c1.f(b0);
        if (obj2 != null && c(obj2)) {
            obj2 = c(obj2) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public final boolean e(e e) {
        n.f(e, "readOnly");
        return c.a.m(d.m(e));
    }

    public final boolean f(b0 b0) {
        e obj2;
        n.f(b0, "type");
        obj2 = c1.f(b0);
        if (obj2 != null && e(obj2)) {
            obj2 = e(obj2) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public final e g(b b, h h2, Integer integer3) {
        String str;
        a obj2;
        kotlin.i0.z.e.m0.b.q.c obj4;
        n.f(b, "fqName");
        n.f(h2, "builtIns");
        if (integer3 != null && n.b(b, c.a.i())) {
            if (n.b(b, c.a.i())) {
                obj2 = k.a;
                obj2 = k.a(integer3.intValue());
            } else {
                obj2 = c.a.n(b);
            }
        } else {
        }
        if (obj2 != null) {
            obj2 = h2.o(obj2.b());
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    public final Collection<e> i(b b, h h2) {
        n.f(b, "fqName");
        n.f(h2, "builtIns");
        e obj8 = d.h(this, b, h2, 0, 4, 0);
        if (obj8 == null) {
            return q0.b();
        }
        b bVar = c.a.q(a.j(obj8));
        if (bVar == null) {
            return q0.a(obj8);
        }
        e[] arr = new e[2];
        final e obj9 = h2.o(bVar);
        n.e(obj9, "builtIns.getBuiltInClassByFqName(kotlinMutableAnalogFqName)");
        return p.j(obj8, obj9);
    }
}
