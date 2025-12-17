package kotlin.i0.z.e.m0.i.q;

import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;

/* loaded from: classes3.dex */
public final class b extends kotlin.i0.z.e.m0.i.q.g<List<? extends kotlin.i0.z.e.m0.i.q.g<?>>> {

    private final l<c0, b0> b;
    public b(List<? extends kotlin.i0.z.e.m0.i.q.g<?>> list, l<? super c0, ? extends b0> l2) {
        n.f(list, "value");
        n.f(l2, "computeType");
        super(list);
        this.b = l2;
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public b0 a(c0 c0) {
        boolean z;
        n.f(c0, "module");
        final Object obj2 = this.b.invoke(c0);
        if (!h.b0((b0)obj2) && !h.w0(obj2)) {
            if (!h.w0(obj2)) {
                z = h.K0(obj2);
            }
        }
        return obj2;
    }
}
