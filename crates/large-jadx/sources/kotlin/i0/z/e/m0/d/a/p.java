package kotlin.i0.z.e.m0.d.a;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.g0.l.c;
import kotlin.i0.z.e.m0.i.e;
import kotlin.i0.z.e.m0.i.e.a;
import kotlin.i0.z.e.m0.i.e.b;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;

/* loaded from: classes3.dex */
public final class p implements e {
    @Override // kotlin.i0.z.e.m0.i.e
    public e.a a() {
        return e.a.BOTH;
    }

    @Override // kotlin.i0.z.e.m0.i.e
    public e.b b(a a, a a2, e e3) {
        Object obj2;
        boolean obj4;
        n.f(a, "superDescriptor");
        n.f(a2, "subDescriptor");
        if (a2 instanceof o0) {
            if (!a instanceof o0) {
            } else {
                if (!n.b((o0)a2.getName(), (o0)a.getName())) {
                    return e.b.UNKNOWN;
                }
                if (c.a(a2) && c.a(a)) {
                    if (c.a(a)) {
                        return e.b.OVERRIDABLE;
                    }
                }
                if (!c.a(a2) && c.a(a)) {
                    if (c.a(a)) {
                    }
                    return e.b.UNKNOWN;
                }
            }
            return e.b.INCOMPATIBLE;
        }
        return e.b.UNKNOWN;
    }
}
