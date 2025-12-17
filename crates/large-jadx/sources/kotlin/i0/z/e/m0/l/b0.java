package kotlin.i0.z.e.m0.l;

import java.util.List;
import kotlin.d0.d.g;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.j1.q;
import kotlin.i0.z.e.m0.l.l1.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;

/* loaded from: classes3.dex */
public abstract class b0 implements a, h {

    private int a;
    public b0(g g) {
        super();
    }

    private final int J0() {
        if (d0.a(this)) {
            return super.hashCode();
        }
        return i5 += z2;
    }

    public abstract List<kotlin.i0.z.e.m0.l.v0> K0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.a
    public abstract kotlin.i0.z.e.m0.l.t0 L0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.a
    public abstract boolean M0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.a
    public abstract kotlin.i0.z.e.m0.l.b0 N0(g g);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.a
    public abstract kotlin.i0.z.e.m0.l.g1 O0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.a
    public final boolean equals(Object object) {
        int i;
        boolean z;
        boolean z2;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof b0) {
            return i2;
        }
        if (M0() == (b0)object.M0() && q.a.a(O0(), object.O0())) {
            if (q.a.a(O0(), object.O0())) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.a
    public final int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        int i2 = J0();
        this.a = i2;
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.a
    public abstract h o();
}
