package kotlin.i0.z.e.m0.d.a;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.c.b.d;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.v.k;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.k0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.g1;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.utils.f;
import kotlin.reflect.jvm.internal.impl.utils.g;

/* loaded from: classes3.dex */
public final class d0 {
    public static final kotlin.i0.z.e.m0.d.a.t a(b0 b0, String string2) {
        int i;
        Enum fROM_BACKEND;
        boolean z;
        int jVar;
        f eNUM_CLASS;
        boolean z2;
        boolean obj4;
        Boolean obj5;
        n.f(b0, "<this>");
        n.f(string2, "value");
        kotlin.reflect.jvm.internal.impl.descriptors.h hVar = b0.L0().c();
        obj5 = e.j(string2);
        n.e(obj5, "identifier(value)");
        obj4 = hVar.x0().f(obj5, d.FROM_BACKEND);
        if (hVar instanceof e && (e)hVar.f() == f.ENUM_CLASS && obj4 instanceof e && (e)obj4.f() == f.ENUM_ENTRY) {
            if ((e)hVar.f() == f.ENUM_CLASS) {
                obj5 = e.j(string2);
                n.e(obj5, "identifier(value)");
                obj4 = hVar.x0().f(obj5, d.FROM_BACKEND);
                if (obj4 instanceof e) {
                    if ((e)obj4.f() == f.ENUM_ENTRY) {
                        jVar = new m(obj4);
                    }
                }
                return jVar;
            }
        }
        obj4 = a.j(b0);
        f fVar = g.a(string2);
        String str4 = fVar.a();
        i = fVar.b();
        if (h.d0(obj4)) {
            obj5 = Boolean.valueOf(Boolean.parseBoolean(string2));
        } else {
            if (h.g0(obj4)) {
                obj5 = l.e1(string2);
            } else {
                if (h.f0(obj4)) {
                    obj5 = l.l(str4, i);
                } else {
                    if (h.A0(obj4)) {
                        obj5 = l.q(str4, i);
                    } else {
                        if (h.p0(obj4)) {
                            obj5 = l.n(str4, i);
                        } else {
                            if (h.r0(obj4)) {
                                obj5 = l.p(str4, i);
                            } else {
                                if (h.n0(obj4)) {
                                    obj5 = l.k(string2);
                                } else {
                                    if (h.l0(obj4)) {
                                        obj5 = l.j(string2);
                                    } else {
                                        if (h.C0(obj4)) {
                                        } else {
                                            obj5 = jVar;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (obj5 != null) {
            jVar = new j(obj5);
        }
        return jVar;
    }

    public static final u b(g1 g1) {
        n.f(g1, "<this>");
        final u obj1 = u.g(g1);
        n.e(obj1, "toDescriptorVisibility(this)");
        return obj1;
    }
}
