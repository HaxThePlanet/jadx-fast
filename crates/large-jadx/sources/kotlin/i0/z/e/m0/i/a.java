package kotlin.i0.z.e.m0.i;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.i.v.d;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.i.v.k.a;
import kotlin.j0.h;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class a extends kotlin.i0.z.e.m0.i.n {

    public static final kotlin.i0.z.e.m0.i.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    private static final void b(e e, LinkedHashSet<e> linkedHashSet2, h h3, boolean z4) {
        d next;
        int str;
        int i;
        str = 0;
        Iterator obj5 = k.a.a(h3, d.q, str, 2, str).iterator();
        while (obj5.hasNext()) {
            next = obj5.next();
            if (next instanceof e == 0) {
            } else {
            }
            str = next;
            if (d.z((e)str, e) != 0) {
            }
            if (z4) {
            }
            next = str.x0();
            n.e(next, "descriptor.unsubstitutedInnerClassesScope");
            a.b(e, linkedHashSet2, next, z4);
            linkedHashSet2.add((m)next);
        }
    }

    public Collection<e> a(e e, boolean z2) {
        Object mVar;
        Object next;
        boolean z;
        n.f(e, "sealedClass");
        if (e.i() != z.SEALED) {
            return p.g();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (!z2) {
            mVar = e.b();
        } else {
            Iterator iterator = a.m(e).iterator();
            for (Object next : iterator) {
            }
            next = 0;
            mVar = next;
        }
        if (mVar instanceof f0) {
            a.b(e, linkedHashSet, (f0)mVar.o(), z2);
        }
        final h obj6 = e.x0();
        n.e(obj6, "sealedClass.unsubstitutedInnerClassesScope");
        a.b(e, linkedHashSet, obj6, true);
        return linkedHashSet;
    }
}
