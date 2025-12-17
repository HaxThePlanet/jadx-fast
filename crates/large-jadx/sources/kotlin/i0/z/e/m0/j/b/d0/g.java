package kotlin.i0.z.e.m0.j.b.d0;

import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.e.z.g;
import kotlin.i0.z.e.m0.e.z.h;
import kotlin.i0.z.e.m0.e.z.h.a;
import kotlin.i0.z.e.m0.e.z.i;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.protobuf.o;

/* loaded from: classes3.dex */
public interface g extends m, y {

    public static enum a {

        COMPATIBLE,
        NEEDS_WRAPPER,
        INCOMPATIBLE;
    }

    public static final class b {
        public static List<h> a(kotlin.i0.z.e.m0.j.b.d0.g g) {
            n.f(g, "this");
            return h.f.a(g.B(), g.Z(), g.Y());
        }
    }
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public abstract o B();

    public abstract List<h> H0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public abstract g S();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public abstract i Y();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public abstract c Z();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public abstract kotlin.i0.z.e.m0.j.b.d0.f c0();
}
