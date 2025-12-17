package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* loaded from: classes3.dex */
public abstract class z extends kotlin.reflect.jvm.internal.impl.descriptors.j1.k implements f0 {

    private final b w;
    public z(c0 c0, b b2) {
        n.f(c0, "module");
        n.f(b2, "fqName");
        super(c0, g.q.b(), b2.h(), u0.a);
        this.w = b2;
    }

    public <R, D> R K(o<R, D> o, D d2) {
        n.f(o, "visitor");
        return o.f(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public c0 b() {
        return (c0)super.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public m b() {
        return b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public final b d() {
        return this.w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public u0 getSource() {
        final u0 u0Var = u0.a;
        n.e(u0Var, "NO_SOURCE");
        return u0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public String toString() {
        return n.o("package ", this.w);
    }
}
