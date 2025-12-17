package kotlin.i0.z.e.m0.d.b;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.j.b.f;
import kotlin.i0.z.e.m0.j.b.g;

/* loaded from: classes3.dex */
public final class f implements g {

    private final kotlin.i0.z.e.m0.d.b.m a;
    private final kotlin.i0.z.e.m0.d.b.e b;
    public f(kotlin.i0.z.e.m0.d.b.m m, kotlin.i0.z.e.m0.d.b.e e2) {
        n.f(m, "kotlinClassFinder");
        n.f(e2, "deserializedDescriptorResolver");
        super();
        this.a = m;
        this.b = e2;
    }

    @Override // kotlin.i0.z.e.m0.j.b.g
    public f a(a a) {
        n.f(a, "classId");
        kotlin.i0.z.e.m0.d.b.o oVar = n.b(this.a, a);
        if (oVar == null) {
            return null;
        }
        n.b(oVar.e(), a);
        return this.b.k(oVar);
    }
}
