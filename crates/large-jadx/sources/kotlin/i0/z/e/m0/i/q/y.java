package kotlin.i0.z.e.m0.i.q;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.t;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.w;

/* loaded from: classes3.dex */
public final class y extends kotlin.i0.z.e.m0.i.q.a0<Long> {
    public y(long l) {
        super(Long.valueOf(l));
    }

    @Override // kotlin.i0.z.e.m0.i.q.a0
    public b0 a(c0 c0) {
        Object str;
        int obj2;
        n.f(c0, "module");
        obj2 = w.a(c0, k.a.h0);
        if (obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = obj2.q();
        }
        if (obj2 == null) {
            n.e(t.j("Unsigned type ULong not found"), "createErrorType(\"Unsigned type ULong not found\")");
        }
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.i.q.a0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Number)b().longValue());
        stringBuilder.append(".toULong()");
        return stringBuilder.toString();
    }
}
