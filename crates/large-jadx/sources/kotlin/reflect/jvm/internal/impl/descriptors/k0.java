package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.i.v.h;

/* loaded from: classes3.dex */
public interface k0 extends kotlin.reflect.jvm.internal.impl.descriptors.m {

    public static final class a {
        public static boolean a(kotlin.reflect.jvm.internal.impl.descriptors.k0 k0) {
            n.f(k0, "this");
            return k0.G().isEmpty();
        }
    }
    public abstract List<kotlin.reflect.jvm.internal.impl.descriptors.f0> G();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public abstract b d();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public abstract boolean isEmpty();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public abstract h o();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.c0 u0();
}
