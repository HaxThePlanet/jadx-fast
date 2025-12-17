package kotlin.i0.z.e.m0.i.q;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;

/* loaded from: classes3.dex */
public final class l extends kotlin.i0.z.e.m0.i.q.g<Float> {
    public l(float f) {
        super(Float.valueOf(f));
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public b0 a(c0 c0) {
        return c(c0);
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public i0 c(c0 c0) {
        n.f(c0, "module");
        i0 obj2 = c0.m().B();
        n.e(obj2, "module.builtIns.floatType");
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Number)b().floatValue());
        stringBuilder.append(".toFloat()");
        return stringBuilder.toString();
    }
}
