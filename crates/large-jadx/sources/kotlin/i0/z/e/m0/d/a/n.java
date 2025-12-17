package kotlin.i0.z.e.m0.d.a;

import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.d.a.g0.m.e;
import kotlin.i0.z.e.m0.i.e;
import kotlin.i0.z.e.m0.i.e.a;
import kotlin.i0.z.e.m0.i.e.b;
import kotlin.i0.z.e.m0.i.j;
import kotlin.i0.z.e.m0.i.j.i;
import kotlin.i0.z.e.m0.i.j.i.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.y0;
import kotlin.j0.h;
import kotlin.j0.i;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.p;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.x.a;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class n implements e {

    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[j.i.a.OVERRIDABLE.ordinal()] = 1;
            n.a.a = iArr;
        }
    }

    static final class b extends p implements l<c1, b0> {

        public static final kotlin.i0.z.e.m0.d.a.n.b a;
        static {
            n.b bVar = new n.b();
            n.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final b0 a(c1 c1) {
            return c1.getType();
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((c1)object);
        }
    }
    @Override // kotlin.i0.z.e.m0.i.e
    public e.a a() {
        return e.a.SUCCESS_ONLY;
    }

    @Override // kotlin.i0.z.e.m0.i.e
    public e.b b(a a, a a2, e e3) {
        int i;
        j.i.a aVar;
        h next2;
        Object next;
        int i2;
        int type;
        b0 returnType;
        kotlin.reflect.jvm.internal.impl.descriptors.n obj5;
        boolean obj7;
        n.f(a, "superDescriptor");
        n.f(a2, "subDescriptor");
        if (a2 instanceof f) {
            obj7 = a2;
            java.util.List typeParameters = (f)obj7.getTypeParameters();
            n.e(typeParameters, "subDescriptor.typeParameters");
            i2 = 1;
            if (empty ^= i2 != 0) {
            } else {
                j.i iVar = j.z(a, a2);
                if (iVar == null) {
                    aVar = type;
                } else {
                    aVar = iVar.c();
                }
                if (aVar != null) {
                    return e.b.UNKNOWN;
                }
                java.util.List list = obj7.h();
                n.e(list, "subDescriptor.valueParameters");
                returnType = obj7.getReturnType();
                n.d(returnType);
                obj7 = obj7.m0();
                if (obj7 == null) {
                } else {
                    type = obj7.getType();
                }
                obj7 = i.w(i.x(i.u(p.M(list), n.b.a), returnType), p.k(type)).iterator();
                type = 0;
                while (obj7.hasNext()) {
                    next = obj7.next();
                    if (empty3 ^= i2 != null && !g1Var instanceof f) {
                    } else {
                    }
                    next2 = type;
                    type = 0;
                    if (!g1Var instanceof f) {
                    } else {
                    }
                    next2 = i2;
                }
                obj7 = type;
                if (obj7 != null) {
                    return e.b.UNKNOWN;
                }
                obj5 = a.c(e.b.c());
                if ((a)obj5 == null) {
                    return e.b.UNKNOWN;
                }
                obj7 = obj5;
                java.util.List typeParameters2 = (t0)obj7.getTypeParameters();
                n.e(typeParameters2, "erasedSuper.typeParameters");
                if (obj5 instanceof t0 && empty2 ^= i2 != 0) {
                    obj7 = obj5;
                    typeParameters2 = (t0)obj7.getTypeParameters();
                    n.e(typeParameters2, "erasedSuper.typeParameters");
                    if (empty2 ^= i2 != 0) {
                        n.d((t0)obj7.s().l(p.g()).build());
                    }
                }
                obj5 = j.d.I(obj5, a2, type).c();
                n.e(obj5, "DEFAULT.isOverridableByWithoutExternalConditions(erasedSuper, subDescriptor, false).result");
                obj5 = n.a.a[obj5.ordinal()] == i2 ? e.b.OVERRIDABLE : e.b.UNKNOWN;
            }
            return obj5;
        }
        return e.b.UNKNOWN;
    }
}
