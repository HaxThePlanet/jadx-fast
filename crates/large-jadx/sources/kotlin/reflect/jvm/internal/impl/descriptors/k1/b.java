package kotlin.reflect.jvm.internal.impl.descriptors.k1;

import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.f1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.g1;

/* loaded from: classes3.dex */
public final class b extends g1 {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.k1.b c;
    static {
        b bVar = new b();
        b.c = bVar;
    }

    private b() {
        super("protected_and_package", 1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
    public Integer a(g1 g1) {
        int obj2;
        n.f(g1, "visibility");
        if (n.b(this, g1)) {
            return null;
        }
        if (g1 == f1.b.c) {
            return null;
        }
        obj2 = f1.a.b(g1) ? 1 : -1;
        return Integer.valueOf(obj2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
    public String b() {
        return "protected/*protected and package*/";
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
    public g1 d() {
        return f1.g.c;
    }
}
