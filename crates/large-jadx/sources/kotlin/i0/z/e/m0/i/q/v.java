package kotlin.i0.z.e.m0.i.q;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;

/* loaded from: classes3.dex */
public final class v extends kotlin.i0.z.e.m0.i.q.g<String> {
    public v(String string) {
        n.f(string, "value");
        super(string);
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public b0 a(c0 c0) {
        return c(c0);
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public i0 c(c0 c0) {
        n.f(c0, "module");
        i0 obj2 = c0.m().V();
        n.e(obj2, "module.builtIns.stringType");
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        final int i = 34;
        stringBuilder.append(i);
        stringBuilder.append((String)b());
        stringBuilder.append(i);
        return stringBuilder.toString();
    }
}
