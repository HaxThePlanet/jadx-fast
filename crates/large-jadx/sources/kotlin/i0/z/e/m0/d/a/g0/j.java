package kotlin.i0.z.e.m0.d.a.g0;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.g;
import kotlin.i0.z.e.m0.i.t.b;
import kotlin.reflect.jvm.internal.impl.descriptors.e;

/* loaded from: classes3.dex */
public final class j implements kotlin.i0.z.e.m0.d.a.g0.i {

    public b a;
    @Override // kotlin.i0.z.e.m0.d.a.g0.i
    public e a(g g) {
        n.f(g, "javaClass");
        return b().b(g);
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.i
    public final b b() {
        b bVar = this.a;
        if (bVar == null) {
        } else {
            return bVar;
        }
        n.w("resolver");
        throw 0;
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.i
    public final void c(b b) {
        n.f(b, "<set-?>");
        this.a = b;
    }
}
