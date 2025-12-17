package kotlin.i0.z.e.m0.b.q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.u0;
import kotlin.i0.z.e.m0.l.u0.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class j {
    public static final u0 a(e e, e e2) {
        int i;
        int i2;
        boolean next;
        n.f(e, "from");
        n.f(e2, "to");
        int size = e.t().size();
        int size2 = e2.t().size();
        List obj4 = e.t();
        n.e(obj4, "from.declaredTypeParameters");
        int i4 = 10;
        ArrayList arrayList = new ArrayList(p.r(obj4, i4));
        obj4 = obj4.iterator();
        for (z0 next4 : obj4) {
            arrayList.add(next4.g());
        }
        obj4 = e2.t();
        n.e(obj4, "to.declaredTypeParameters");
        ArrayList obj5 = new ArrayList(p.r(obj4, i4));
        obj4 = obj4.iterator();
        for (z0 next3 : obj4) {
            kotlin.i0.z.e.m0.l.i0 i0Var = next3.q();
            n.e(i0Var, "it.defaultType");
            obj5.add(a.a(i0Var));
        }
        return u0.a.e(u0.b, j0.s(p.S0(arrayList, obj5)), false, 2, 0);
    }
}
