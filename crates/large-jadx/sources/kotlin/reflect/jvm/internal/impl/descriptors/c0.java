package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;

/* loaded from: classes3.dex */
public interface c0 extends kotlin.reflect.jvm.internal.impl.descriptors.m {

    public static final class a {
        public static <R, D> R a(kotlin.reflect.jvm.internal.impl.descriptors.c0 c0, kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> o2, D d3) {
            n.f(c0, "this");
            n.f(o2, "visitor");
            return o2.j(c0, d3);
        }

        public static kotlin.reflect.jvm.internal.impl.descriptors.m b(kotlin.reflect.jvm.internal.impl.descriptors.c0 c0) {
            n.f(c0, "this");
            return null;
        }
    }
    public abstract <T> T F0(kotlin.reflect.jvm.internal.impl.descriptors.b0<T> b0);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.k0 M(b b);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public abstract boolean e0(kotlin.reflect.jvm.internal.impl.descriptors.c0 c0);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public abstract h m();

    public abstract Collection<b> n(b b, l<? super e, Boolean> l2);

    public abstract List<kotlin.reflect.jvm.internal.impl.descriptors.c0> s0();
}
