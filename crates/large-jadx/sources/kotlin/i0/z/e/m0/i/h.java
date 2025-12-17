package kotlin.i0.z.e.m0.i;

import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.b;

/* loaded from: classes3.dex */
public abstract class h extends kotlin.i0.z.e.m0.i.i {
    @Override // kotlin.i0.z.e.m0.i.i
    public void b(b b, b b2) {
        n.f(b, "first");
        n.f(b2, "second");
        e(b, b2);
    }

    @Override // kotlin.i0.z.e.m0.i.i
    public void c(b b, b b2) {
        n.f(b, "fromSuper");
        n.f(b2, "fromCurrent");
        e(b, b2);
    }

    @Override // kotlin.i0.z.e.m0.i.i
    protected abstract void e(b b, b b2);
}
