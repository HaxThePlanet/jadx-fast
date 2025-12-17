package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
final class c implements kotlin.reflect.jvm.internal.impl.descriptors.z0 {

    private final kotlin.reflect.jvm.internal.impl.descriptors.z0 a;
    private final kotlin.reflect.jvm.internal.impl.descriptors.m b;
    private final int c;
    public c(kotlin.reflect.jvm.internal.impl.descriptors.z0 z0, kotlin.reflect.jvm.internal.impl.descriptors.m m2, int i3) {
        n.f(z0, "originalDescriptor");
        n.f(m2, "declarationDescriptor");
        super();
        this.a = z0;
        this.b = m2;
        this.c = i3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public boolean C() {
        return this.a.C();
    }

    public <R, D> R K(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> o, D d2) {
        return this.a.K(o, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public kotlin.reflect.jvm.internal.impl.descriptors.h a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public kotlin.reflect.jvm.internal.impl.descriptors.m a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public kotlin.reflect.jvm.internal.impl.descriptors.z0 a() {
        kotlin.reflect.jvm.internal.impl.descriptors.z0 z0Var2 = this.a.a();
        n.e(z0Var2, "originalDescriptor.original");
        return z0Var2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public kotlin.reflect.jvm.internal.impl.descriptors.m b() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public t0 g() {
        return this.a.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public g getAnnotations() {
        return this.a.getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public int getIndex() {
        return i += index;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public e getName() {
        return this.a.getName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public kotlin.reflect.jvm.internal.impl.descriptors.u0 getSource() {
        return this.a.getSource();
    }

    public List<b0> getUpperBounds() {
        return this.a.getUpperBounds();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public n h0() {
        return this.a.h0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public h1 l() {
        return this.a.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public boolean o0() {
        return 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public i0 q() {
        return this.a.q();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("[inner-copy]");
        return stringBuilder.toString();
    }
}
