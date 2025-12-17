package kotlin.i0.z.e.m0.d.b;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.a0.b.f;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.j.b.d0.e;
import kotlin.i0.z.e.m0.j.b.d0.f;
import kotlin.i0.z.e.m0.j.b.r;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;

/* loaded from: classes3.dex */
public final class q implements f {

    private final kotlin.i0.z.e.m0.d.b.o b;
    public q(kotlin.i0.z.e.m0.d.b.o o, r<f> r2, boolean z3, e e4) {
        n.f(o, "binaryClass");
        n.f(e4, "abiStability");
        super();
        this.b = o;
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.f
    public v0 a() {
        final v0 v0Var = v0.a;
        n.e(v0Var, "NO_SOURCE_FILE");
        return v0Var;
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.f
    public String c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Class '");
        stringBuilder.append(this.b.e().b().b());
        stringBuilder.append('\'');
        return stringBuilder.toString();
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.f
    public final kotlin.i0.z.e.m0.d.b.o d() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(q.class.getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}
