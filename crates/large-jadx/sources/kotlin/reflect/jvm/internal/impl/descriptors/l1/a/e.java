package kotlin.reflect.jvm.internal.impl.descriptors.l1.a;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class e {
    public static final Class<?> a(java.lang.ClassLoader classLoader, String string2) {
        Class obj1;
        n.f(classLoader, "<this>");
        n.f(string2, "fqName");
        obj1 = Class.forName(string2, false, classLoader);
        return obj1;
    }
}
