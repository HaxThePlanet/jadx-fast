package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.w;

/* loaded from: classes3.dex */
public interface x0 {

    public static final class a implements kotlin.reflect.jvm.internal.impl.descriptors.x0 {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.x0.a a;
        static {
            x0.a aVar = new x0.a();
            x0.a.a = aVar;
        }

        public Collection<b0> a(t0 t0, Collection<? extends b0> collection2, l<? super t0, ? extends Iterable<? extends b0>> l3, l<? super b0, w> l4) {
            n.f(t0, "currentTypeConstructor");
            n.f(collection2, "superTypes");
            n.f(l3, "neighbors");
            n.f(l4, "reportLoop");
            return collection2;
        }
    }
    public abstract Collection<b0> a(t0 t0, Collection<? extends b0> collection2, l<? super t0, ? extends Iterable<? extends b0>> l3, l<? super b0, w> l4);
}
