package kotlin.reflect.jvm.internal.impl.descriptors.h1;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class i {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.h1.g a(kotlin.reflect.jvm.internal.impl.descriptors.h1.g g, kotlin.reflect.jvm.internal.impl.descriptors.h1.g g2) {
        boolean kVar;
        kotlin.reflect.jvm.internal.impl.descriptors.h1.g[] arr;
        int i;
        Object obj3;
        n.f(g, "first");
        n.f(g2, "second");
        if (g.isEmpty()) {
            obj3 = g2;
        } else {
            if (g2.isEmpty()) {
            } else {
                arr = new g[2];
                kVar = new k(arr);
                obj3 = kVar;
            }
        }
        return obj3;
    }
}
