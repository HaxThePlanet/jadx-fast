package kotlin.i0.z.e.m0.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class o {

    public static final kotlin.i0.z.e.m0.b.o a;
    private static final Set<e> b;
    private static final HashMap<a, a> c;
    private static final HashMap<a, a> d;
    private static final Set<e> e;
    static {
        int arrayClassId;
        int i3;
        int i4;
        int i;
        int i2;
        e typeName;
        a classId;
        o oVar = new o();
        o.a = oVar;
        kotlin.i0.z.e.m0.b.n[] values = n.values();
        ArrayList arrayList = new ArrayList(values.length);
        i3 = 0;
        i4 = i3;
        while (i4 < values.length) {
            arrayList.add(values[i4].getTypeName());
            i4++;
        }
        o.b = p.P0(arrayList);
        kotlin.i0.z.e.m0.b.m[] values2 = m.values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        i = i3;
        while (i < values2.length) {
            arrayList2.add(values2[i].getTypeName());
            i++;
        }
        p.P0(arrayList2);
        HashMap hashMap = new HashMap();
        o.c = hashMap;
        HashMap hashMap2 = new HashMap();
        o.d = hashMap2;
        kotlin.o[] arr = new o[4];
        arr[i3] = u.a(m.UBYTEARRAY, e.j("ubyteArrayOf"));
        arr[1] = u.a(m.USHORTARRAY, e.j("ushortArrayOf"));
        arr[2] = u.a(m.UINTARRAY, e.j("uintArrayOf"));
        arr[3] = u.a(m.ULONGARRAY, e.j("ulongArrayOf"));
        j0.j(arr);
        kotlin.i0.z.e.m0.b.n[] values3 = n.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        i2 = i3;
        while (i2 < values3.length) {
            linkedHashSet.add(values3[i2].getArrayClassId().j());
            i2++;
        }
        o.e = linkedHashSet;
        kotlin.i0.z.e.m0.b.n[] values4 = n.values();
        while (i3 < values4.length) {
            kotlin.i0.z.e.m0.b.n nVar = values4[i3];
            i3++;
            o.c.put(nVar.getArrayClassId(), nVar.getClassId());
            o.d.put(nVar.getClassId(), nVar.getArrayClassId());
        }
    }

    public static final boolean d(b0 b0) {
        n.f(b0, "type");
        final int i = 0;
        if (c1.v(b0)) {
            return i;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h obj2 = b0.L0().c();
        if (obj2 == null) {
            return i;
        }
        return o.a.c(obj2);
    }

    public final a a(a a) {
        n.f(a, "arrayClassId");
        return (a)o.c.get(a);
    }

    public final boolean b(e e) {
        n.f(e, "name");
        return o.e.contains(e);
    }

    public final boolean c(m m) {
        Object mVar;
        kotlin.i0.z.e.m0.f.b bVar;
        int obj3;
        n.f(m, "descriptor");
        mVar = m.b();
        if (mVar instanceof f0 && n.b((f0)mVar.d(), k.l) && o.b.contains(m.getName())) {
            if (n.b((f0)mVar.d(), k.l)) {
                obj3 = o.b.contains(m.getName()) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj3;
    }
}
