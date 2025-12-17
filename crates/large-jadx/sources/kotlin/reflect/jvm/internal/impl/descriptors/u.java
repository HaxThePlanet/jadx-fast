package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.i.v.o.d;

/* loaded from: classes3.dex */
public abstract class u {
    public final Integer a(kotlin.reflect.jvm.internal.impl.descriptors.u u) {
        n.f(u, "visibility");
        return b().a(u.b());
    }

    public abstract kotlin.reflect.jvm.internal.impl.descriptors.g1 b();

    public abstract String c();

    public final boolean d() {
        return b().c();
    }

    public abstract boolean e(d d, kotlin.reflect.jvm.internal.impl.descriptors.q q2, kotlin.reflect.jvm.internal.impl.descriptors.m m3);

    public abstract kotlin.reflect.jvm.internal.impl.descriptors.u f();

    public final String toString() {
        return b().toString();
    }
}
