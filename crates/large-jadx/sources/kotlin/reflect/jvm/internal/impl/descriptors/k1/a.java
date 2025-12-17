package kotlin.reflect.jvm.internal.impl.descriptors.k1;

import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.g1;

/* loaded from: classes3.dex */
public final class a extends g1 {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.k1.a c;
    static {
        a aVar = new a();
        a.c = aVar;
    }

    private a() {
        super("package", 0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
    public Integer a(g1 g1) {
        n.f(g1, "visibility");
        if (this == g1) {
            return null;
        }
        if (f1.a.b(g1)) {
            return 1;
        }
        return -1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
    public String b() {
        return "public/*package*/";
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
    public g1 d() {
        return f1.g.c;
    }
}
