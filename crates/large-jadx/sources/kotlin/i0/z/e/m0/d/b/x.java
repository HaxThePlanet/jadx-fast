package kotlin.i0.z.e.m0.d.b;

import java.util.Collection;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class x implements kotlin.i0.z.e.m0.d.b.w<kotlin.i0.z.e.m0.d.b.j> {

    public static final kotlin.i0.z.e.m0.d.b.x a;
    static {
        x xVar = new x();
        x.a = xVar;
    }

    @Override // kotlin.i0.z.e.m0.d.b.w
    public Object a(e e) {
        return h(e);
    }

    @Override // kotlin.i0.z.e.m0.d.b.w
    public String b(e e) {
        return w.a.a(this, e);
    }

    public b0 c(Collection<? extends b0> collection) {
        n.f(collection, "types");
        AssertionError assertionError = new AssertionError(n.o("There should be no intersection type in existing descriptors, but found: ", p.h0(collection, 0, 0, 0, 0, 0, 0, 63, 0)));
        throw assertionError;
    }

    @Override // kotlin.i0.z.e.m0.d.b.w
    public String d(e e) {
        n.f(e, "classDescriptor");
        return null;
    }

    @Override // kotlin.i0.z.e.m0.d.b.w
    public b0 e(b0 b0) {
        return w.a.b(this, b0);
    }

    @Override // kotlin.i0.z.e.m0.d.b.w
    public boolean f() {
        return w.a.c(this);
    }

    @Override // kotlin.i0.z.e.m0.d.b.w
    public void g(b0 b0, e e2) {
        n.f(b0, "kotlinType");
        n.f(e2, "descriptor");
    }

    @Override // kotlin.i0.z.e.m0.d.b.w
    public kotlin.i0.z.e.m0.d.b.j h(e e) {
        n.f(e, "classDescriptor");
        return null;
    }
}
