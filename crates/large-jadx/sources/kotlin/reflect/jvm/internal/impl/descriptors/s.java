package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.i.v.k;

/* loaded from: classes3.dex */
public final class s {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.e a(kotlin.reflect.jvm.internal.impl.descriptors.c0 c0, b b2, b b3) {
        kotlin.reflect.jvm.internal.impl.descriptors.h hVar;
        int i;
        int obj5;
        Object obj6;
        n.f(c0, "<this>");
        n.f(b2, "fqName");
        n.f(b3, "lookupLocation");
        i = 0;
        if (b2.d()) {
            return i;
        }
        b bVar = b2.e();
        final String str4 = "fqName.parent()";
        n.e(bVar, str4);
        kotlin.i0.z.e.m0.f.e eVar = b2.g();
        final String str5 = "fqName.shortName()";
        n.e(eVar, str5);
        if (hVar instanceof e) {
        } else {
            hVar = i;
        }
        if (hVar == null) {
            b bVar2 = b2.e();
            n.e(bVar2, str4);
            obj5 = s.a(c0, bVar2, b3);
            if (obj5 == null) {
                obj5 = i;
            } else {
            }
            if (obj5 instanceof e) {
                i = obj5;
            }
            return i;
        }
        return hVar;
    }
}
