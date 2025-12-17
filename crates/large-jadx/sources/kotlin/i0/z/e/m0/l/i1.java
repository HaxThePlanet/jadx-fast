package kotlin.i0.z.e.m0.l;

import java.util.List;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
public abstract class i1 extends kotlin.i0.z.e.m0.l.b0 {
    public i1() {
        super(0);
    }

    public List<kotlin.i0.z.e.m0.l.v0> K0() {
        return P0().K0();
    }

    @Override // kotlin.i0.z.e.m0.l.b0
    public kotlin.i0.z.e.m0.l.t0 L0() {
        return P0().L0();
    }

    @Override // kotlin.i0.z.e.m0.l.b0
    public boolean M0() {
        return P0().M0();
    }

    @Override // kotlin.i0.z.e.m0.l.b0
    public final kotlin.i0.z.e.m0.l.g1 O0() {
        kotlin.i0.z.e.m0.l.b0 b0Var;
        boolean z;
        b0Var = P0();
        while (b0Var instanceof i1) {
            b0Var = (i1)b0Var.P0();
        }
        return (g1)b0Var;
    }

    @Override // kotlin.i0.z.e.m0.l.b0
    protected abstract kotlin.i0.z.e.m0.l.b0 P0();

    @Override // kotlin.i0.z.e.m0.l.b0
    public boolean Q0() {
        return 1;
    }

    @Override // kotlin.i0.z.e.m0.l.b0
    public g getAnnotations() {
        return P0().getAnnotations();
    }

    @Override // kotlin.i0.z.e.m0.l.b0
    public h o() {
        return P0().o();
    }

    @Override // kotlin.i0.z.e.m0.l.b0
    public String toString() {
        String string;
        if (Q0()) {
            string = P0().toString();
        } else {
            string = "<Not computed yet>";
        }
        return string;
    }
}
