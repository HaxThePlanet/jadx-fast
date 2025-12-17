package kotlin.i0.z.e.m0.i.q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class p implements t0 {

    private final long a;
    private final c0 b;
    private final ArrayList<b0> c;
    public Collection<b0> a() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public t0 b(g g) {
        n.f(g, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public h c() {
        return (h)f();
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public boolean d() {
        return 0;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public Void f() {
        return null;
    }

    public List<z0> getParameters() {
        return p.g();
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public h m() {
        return this.b.m();
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IntegerValueType(");
        stringBuilder.append(this.a);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
