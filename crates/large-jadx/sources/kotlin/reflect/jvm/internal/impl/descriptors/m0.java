package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.v0;

/* loaded from: classes3.dex */
public final class m0 {

    private final kotlin.reflect.jvm.internal.impl.descriptors.i a;
    private final List<v0> b;
    private final kotlin.reflect.jvm.internal.impl.descriptors.m0 c;
    public m0(kotlin.reflect.jvm.internal.impl.descriptors.i i, List<? extends v0> list2, kotlin.reflect.jvm.internal.impl.descriptors.m0 m03) {
        n.f(i, "classifierDescriptor");
        n.f(list2, "arguments");
        super();
        this.a = i;
        this.b = list2;
        this.c = m03;
    }

    public final List<v0> a() {
        return this.b;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.i b() {
        return this.a;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.m0 c() {
        return this.c;
    }
}
