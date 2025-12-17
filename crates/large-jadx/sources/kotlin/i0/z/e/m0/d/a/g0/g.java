package kotlin.i0.z.e.m0.d.a.g0;

import kotlin.d0.d.n;
import kotlin.h;
import kotlin.i0.z.e.m0.d.a.g0.m.c;
import kotlin.i0.z.e.m0.d.a.w;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;

/* loaded from: classes3.dex */
public final class g {

    private final kotlin.i0.z.e.m0.d.a.g0.b a;
    private final kotlin.i0.z.e.m0.d.a.g0.k b;
    private final h<w> c;
    private final h d;
    private final c e;
    public g(kotlin.i0.z.e.m0.d.a.g0.b b, kotlin.i0.z.e.m0.d.a.g0.k k2, h<w> h3) {
        n.f(b, "components");
        n.f(k2, "typeParameterResolver");
        n.f(h3, "delegateForDefaultTypeQualifiers");
        super();
        this.a = b;
        this.b = k2;
        this.c = h3;
        this.d = h3;
        c obj2 = new c(this, k2);
        this.e = obj2;
    }

    public final kotlin.i0.z.e.m0.d.a.g0.b a() {
        return this.a;
    }

    public final w b() {
        return (w)this.d.getValue();
    }

    public final h<w> c() {
        return this.c;
    }

    public final c0 d() {
        return this.a.l();
    }

    public final n e() {
        return this.a.t();
    }

    public final kotlin.i0.z.e.m0.d.a.g0.k f() {
        return this.b;
    }

    public final c g() {
        return this.e;
    }
}
