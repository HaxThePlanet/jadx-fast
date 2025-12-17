package kotlin.i0.z.e.m0.i.q;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;

/* loaded from: classes3.dex */
public final class i extends kotlin.i0.z.e.m0.i.q.g<Double> {
    public i(double d) {
        super(Double.valueOf(d));
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public b0 a(c0 c0) {
        return c(c0);
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public i0 c(c0 c0) {
        n.f(c0, "module");
        i0 obj2 = c0.m().z();
        n.e(obj2, "module.builtIns.doubleType");
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Number)b().doubleValue());
        stringBuilder.append(".toDouble()");
        return stringBuilder.toString();
    }
}
