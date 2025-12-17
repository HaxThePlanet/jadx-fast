package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public abstract class r extends kotlin.reflect.jvm.internal.impl.descriptors.u {

    private final kotlin.reflect.jvm.internal.impl.descriptors.g1 a;
    public r(kotlin.reflect.jvm.internal.impl.descriptors.g1 g1) {
        n.f(g1, "delegate");
        super();
        this.a = g1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
    public kotlin.reflect.jvm.internal.impl.descriptors.g1 b() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
    public String c() {
        return b().b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
    public kotlin.reflect.jvm.internal.impl.descriptors.u f() {
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar = t.j(b().d());
        n.e(uVar, "toDescriptorVisibility(delegate.normalize())");
        return uVar;
    }
}
