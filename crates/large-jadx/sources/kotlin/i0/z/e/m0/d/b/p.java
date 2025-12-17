package kotlin.i0.z.e.m0.d.b;

import java.util.Map;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.g0.l.h;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;

/* loaded from: classes3.dex */
public final class p implements u0 {

    private final h b;
    public p(h h) {
        n.f(h, "packageFragment");
        super();
        this.b = h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u0
    public v0 a() {
        final v0 v0Var = v0.a;
        n.e(v0Var, "NO_SOURCE_FILE");
        return v0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        stringBuilder.append(": ");
        stringBuilder.append(this.b.L0().keySet());
        return stringBuilder.toString();
    }
}
