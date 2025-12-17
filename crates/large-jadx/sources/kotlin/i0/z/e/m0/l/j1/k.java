package kotlin.i0.z.e.m0.l.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.g1;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.l1.b;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.u0;
import kotlin.i0.z.e.m0.l.u0.a;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.i0.z.e.m0.l.y0;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class k {
    private static final List<v0> a(g1 g1, b b2) {
        boolean iterator;
        int i4;
        int i3;
        boolean z2;
        int i2;
        boolean next;
        int i;
        boolean next2;
        h1 iNVARIANT2;
        int arrayList;
        boolean z;
        kotlin.i0.z.e.m0.l.j1.i oUT_VARIANCE;
        String str;
        h1 iNVARIANT;
        i4 = 0;
        if (g1.K0().size() != g1.L0().getParameters().size()) {
            return i4;
        }
        List list2 = g1.K0();
        i3 = 0;
        if (list2 instanceof Collection != null && list2.isEmpty()) {
            if (list2.isEmpty()) {
            } else {
                iterator = list2.iterator();
                while (iterator.hasNext()) {
                    if ((v0)iterator.next().a() == h1.INVARIANT) {
                    } else {
                    }
                    next = i3;
                    if (next == 0) {
                        break;
                    } else {
                    }
                    next = i2;
                }
            }
        } else {
        }
        if (i2 != 0) {
            return i4;
        }
        List parameters2 = g1.L0().getParameters();
        n.e(parameters2, "type.constructor.parameters");
        List list3 = p.S0(list2, parameters2);
        ArrayList arrayList2 = new ArrayList(p.r(list3, 10));
        Iterator iterator2 = list3.iterator();
        while (iterator2.hasNext()) {
            Object next3 = iterator2.next();
            iNVARIANT2 = (o)next3.a();
            i = next3.b();
            if ((v0)iNVARIANT2.a() == h1.INVARIANT) {
            } else {
            }
            if (!iNVARIANT2.c() && iNVARIANT2.a() == h1.IN_VARIANCE) {
            } else {
            }
            arrayList = i4;
            n.e((z0)i, "parameter");
            oUT_VARIANCE = new i(b2, arrayList, iNVARIANT2, i);
            iNVARIANT2 = a.a(oUT_VARIANCE);
            arrayList2.add(iNVARIANT2);
            if (iNVARIANT2.a() == h1.IN_VARIANCE) {
            } else {
            }
            arrayList = iNVARIANT2.getType().O0();
        }
        size3--;
        if (i5 >= 0) {
        }
        return arrayList2;
    }

    public static final i0 b(i0 i0, b b2) {
        int obj1;
        n.f(i0, "type");
        n.f(b2, "status");
        final List obj2 = k.a(i0, b2);
        if (obj2 == null) {
            obj1 = 0;
        } else {
            obj1 = k.c(i0, obj2);
        }
        return obj1;
    }

    private static final i0 c(g1 g1, List<? extends v0> list2) {
        final c0 c0Var = c0.a;
        return c0.i(g1.getAnnotations(), g1.L0(), list2, g1.M0(), 0, 16, 0);
    }
}
