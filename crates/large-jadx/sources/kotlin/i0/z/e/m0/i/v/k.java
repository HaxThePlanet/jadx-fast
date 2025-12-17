package kotlin.i0.z.e.m0.i.v;

import java.util.Collection;
import kotlin.d0.c.l;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;

/* loaded from: classes3.dex */
public interface k {

    public static final class a {
        public static Collection a(kotlin.i0.z.e.m0.i.v.k k, kotlin.i0.z.e.m0.i.v.d d2, l l3, int i4, Object object5) {
            kotlin.i0.z.e.m0.i.v.d obj1;
            l obj2;
            if (object5 != null) {
            } else {
                if (i4 & 1 != 0) {
                    obj1 = d.o;
                }
                if (i4 &= 2 != 0) {
                    obj2 = h.a.a();
                }
                return k.g(obj1, obj2);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
            throw obj0;
        }
    }
    public abstract h f(e e, b b2);

    public abstract Collection<m> g(kotlin.i0.z.e.m0.i.v.d d, l<? super e, Boolean> l2);
}
