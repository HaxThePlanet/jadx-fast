package kotlin.i0.z.e.m0.d.b;

import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.b.q.c;
import kotlin.i0.z.e.m0.d.a.b0;
import kotlin.i0.z.e.m0.d.a.f;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.i.t.c;
import kotlin.i0.z.e.m0.i.t.d;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class t {
    private static final void a(StringBuilder stringBuilder, b0 b02) {
        stringBuilder.append(t.g(b02));
    }

    public static final String b(x x, boolean z2, boolean z3) {
        String type;
        String str;
        Object obj3;
        boolean obj4;
        String obj5;
        n.f(x, "<this>");
        StringBuilder stringBuilder = new StringBuilder();
        if (z3 != null) {
            if (x instanceof l) {
                obj5 = "<init>";
            } else {
                n.e(x.getName().c(), "name.asString()");
            }
            stringBuilder.append(obj5);
        }
        stringBuilder.append("(");
        obj5 = x.m0();
        if (obj5 == null) {
        } else {
            obj5 = obj5.getType();
            n.e(obj5, "it.type");
            t.a(stringBuilder, obj5);
        }
        obj5 = x.h().iterator();
        for (c1 next2 : obj5) {
            type = next2.getType();
            n.e(type, "parameter.type");
            t.a(stringBuilder, type);
        }
        stringBuilder.append(")");
        if (z2) {
            if (c.c(x)) {
                stringBuilder.append("V");
            } else {
                obj3 = x.getReturnType();
                n.d(obj3);
                t.a(stringBuilder, obj3);
            }
        }
        obj3 = stringBuilder.toString();
        n.e(obj3, "StringBuilder().apply(builderAction).toString()");
        return obj3;
    }

    public static String c(x x, boolean z2, boolean z3, int i4, Object object5) {
        int obj2;
        int obj3;
        final int i = 1;
        if (i4 & 1 != 0) {
            obj2 = i;
        }
        if (i4 &= 2 != 0) {
            obj3 = i;
        }
        return t.b(x, obj2, obj3);
    }

    public static final String d(a a) {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVar;
        int obj5;
        n.f(a, "<this>");
        final int i = 0;
        if (d.E(a)) {
            return i;
        }
        if (mVar instanceof e) {
        } else {
            mVar = i;
        }
        if (mVar == null) {
            return i;
        }
        if (mVar.getName().k()) {
            return i;
        }
        if (obj5 instanceof t0) {
        } else {
            obj5 = i;
        }
        if (obj5 == null) {
            return i;
        }
        final int i3 = 0;
        return s.a(v.a, mVar, t.c(obj5, i3, i3, 3, i));
    }

    public static final boolean e(a a) {
        Object str2;
        int i2;
        boolean size;
        String str;
        d i;
        kotlin.i0.z.e.m0.d.b.j obj5;
        n.f(a, "f");
        i2 = 0;
        if (!a instanceof x) {
            return i2;
        }
        str2 = a;
        str = 1;
        if (n.b((x)str2.getName().c(), "remove") && str2.h().size() == str) {
            str = 1;
            if (str2.h().size() == str) {
                if (b0.h((b)a)) {
                } else {
                    obj5 = str2.a().h();
                    n.e(obj5, "f.original.valueParameters");
                    obj5 = (c1)p.z0(obj5).getType();
                    n.e(obj5, "f.original.valueParameters.single().type");
                    if (obj5 instanceof j.d) {
                    } else {
                        obj5 = i;
                    }
                    if (obj5 == null) {
                    } else {
                        i = obj5.i();
                    }
                    if (i != d.INT) {
                        return i2;
                    }
                    obj5 = f.m;
                    obj5 = f.k(str2);
                    if (obj5 == null) {
                        return i2;
                    }
                    List list = obj5.a().h();
                    n.e(list, "overridden.original.valueParameters");
                    b0 type = (c1)p.z0(list).getType();
                    n.e(type, "overridden.original.valueParameters.single().type");
                    str2 = t.g(type);
                    obj5 = obj5.b();
                    n.e(obj5, "overridden.containingDeclaration");
                    if (n.b(a.j(obj5), k.a.R.j()) && str2 instanceof j.c && n.b((j.c)str2.i(), "java/lang/Object")) {
                        if (str2 instanceof j.c) {
                            if (n.b((j.c)str2.i(), "java/lang/Object")) {
                                i2 = str;
                            }
                        }
                    }
                }
            }
        }
        return i2;
    }

    public static final String f(e e) {
        n.f(e, "<this>");
        kotlin.i0.z.e.m0.f.c cVar2 = a.i(e).j();
        n.e(cVar2, "fqNameSafe.toUnsafe()");
        kotlin.i0.z.e.m0.f.a aVar = c.a.o(cVar2);
        if (aVar == null) {
            int i2 = 0;
            return c.b(e, i2, 2, i2);
        }
        String obj3 = c.b(aVar).f();
        n.e(obj3, "byClassId(it).internalName");
        return obj3;
    }

    public static final kotlin.i0.z.e.m0.d.b.j g(b0 b0) {
        n.f(b0, "<this>");
        return (j)c.e(b0, l.a, y.m, x.a, 0, 0, 32, 0);
    }
}
