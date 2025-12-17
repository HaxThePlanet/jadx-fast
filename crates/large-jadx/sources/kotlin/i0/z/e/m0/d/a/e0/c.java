package kotlin.i0.z.e.m0.d.a.e0;

import java.util.Map;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.d.a.g0.g;
import kotlin.i0.z.e.m0.d.a.g0.l.e;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.d;
import kotlin.i0.z.e.m0.d.a.y;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.u;
import kotlin.y.j0;

/* loaded from: classes3.dex */
public final class c {

    public static final kotlin.i0.z.e.m0.d.a.e0.c a;
    private static final e b;
    private static final e c;
    private static final e d;
    private static final Map<b, b> e;
    private static final Map<b, b> f;
    static {
        c cVar = new c();
        c.a = cVar;
        e eVar = e.j("message");
        n.e(eVar, "identifier(\"message\")");
        c.b = eVar;
        e eVar2 = e.j("allowedTargets");
        n.e(eVar2, "identifier(\"allowedTargets\")");
        c.c = eVar2;
        e eVar3 = e.j("value");
        n.e(eVar3, "identifier(\"value\")");
        c.d = eVar3;
        int i = 4;
        kotlin.o[] arr = new o[i];
        b bVar = k.a.A;
        b bVar3 = y.c;
        final int i3 = 0;
        arr[i3] = u.a(bVar, bVar3);
        b bVar5 = k.a.D;
        final b bVar6 = y.d;
        final int i4 = 1;
        arr[i4] = u.a(bVar5, bVar6);
        b bVar7 = k.a.E;
        final b bVar8 = y.g;
        final int i5 = 2;
        arr[i5] = u.a(bVar7, bVar8);
        b bVar9 = k.a.F;
        final b bVar10 = y.f;
        final int i6 = 3;
        arr[i6] = u.a(bVar9, bVar10);
        c.e = j0.k(arr);
        kotlin.o[] arr2 = new o[5];
        arr2[i3] = u.a(bVar3, bVar);
        arr2[i4] = u.a(bVar6, bVar5);
        arr2[i5] = u.a(y.e, k.a.u);
        arr2[i6] = u.a(bVar8, bVar7);
        arr2[i] = u.a(bVar10, bVar9);
        c.f = j0.k(arr2);
    }

    public static c f(kotlin.i0.z.e.m0.d.a.e0.c c, a a2, g g3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return c.e(a2, g3, obj3);
    }

    public final c a(b b, d d2, g g3) {
        boolean z;
        int i4;
        String str;
        a aVar;
        Object obj;
        int i2;
        int i3;
        int i;
        Object obj8;
        n.f(b, "kotlinName");
        n.f(d2, "annotationOwner");
        n.f(g3, "c");
        b bVar2 = y.e;
        n.e(bVar2, "DEPRECATED_ANNOTATION");
        z = d2.o(bVar2);
        if (n.b(b, k.a.u) && z == null && d2.n()) {
            bVar2 = y.e;
            n.e(bVar2, "DEPRECATED_ANNOTATION");
            z = d2.o(bVar2);
            if (z == null) {
                if (d2.n()) {
                }
            }
            obj8 = new e(z, g3);
            return obj8;
        }
        obj8 = c.e.get(b);
        i4 = 0;
        if ((b)obj8 == null) {
        } else {
            aVar = d2.o((b)obj8);
            if (aVar == null) {
            } else {
                i4 = obj8;
            }
        }
        return i4;
    }

    public final e b() {
        return c.b;
    }

    public final e c() {
        return c.d;
    }

    public final e d() {
        return c.c;
    }

    public final c e(a a, g g2, boolean z3) {
        a eVar;
        boolean z;
        kotlin.i0.z.e.m0.d.a.e0.h obj5;
        n.f(a, "annotation");
        n.f(g2, "c");
        eVar = a.e();
        if (n.b(eVar, a.m(y.c))) {
            obj5 = new i(a, g2);
        } else {
            if (n.b(eVar, a.m(y.d))) {
                obj5 = new h(a, g2);
            } else {
                if (n.b(eVar, a.m(y.g))) {
                    obj5 = new b(g2, a, k.a.E);
                } else {
                    if (n.b(eVar, a.m(y.f))) {
                        obj5 = new b(g2, a, k.a.F);
                    } else {
                        if (n.b(eVar, a.m(y.e))) {
                            obj5 = 0;
                        } else {
                            eVar = new e(g2, a, z3);
                            obj5 = eVar;
                        }
                    }
                }
            }
        }
        return obj5;
    }
}
