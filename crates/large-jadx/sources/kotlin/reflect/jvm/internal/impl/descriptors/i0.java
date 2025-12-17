package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;

/* loaded from: classes3.dex */
public final class i0 {
    public static final void a(kotlin.reflect.jvm.internal.impl.descriptors.g0 g0, b b2, Collection<kotlin.reflect.jvm.internal.impl.descriptors.f0> collection3) {
        Object obj1;
        n.f(g0, "<this>");
        n.f(b2, "fqName");
        n.f(collection3, "packageFragments");
        if (g0 instanceof j0) {
            (j0)g0.b(b2, collection3);
        } else {
            collection3.addAll(g0.a(b2));
        }
    }

    public static final List<kotlin.reflect.jvm.internal.impl.descriptors.f0> b(kotlin.reflect.jvm.internal.impl.descriptors.g0 g0, b b2) {
        n.f(g0, "<this>");
        n.f(b2, "fqName");
        ArrayList arrayList = new ArrayList();
        i0.a(g0, b2, arrayList);
        return arrayList;
    }
}
