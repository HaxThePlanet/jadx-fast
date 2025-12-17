package kotlin.i0.z.e.m0.i.v;

import java.util.Collection;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public interface h extends kotlin.i0.z.e.m0.i.v.k {

    public static final kotlin.i0.z.e.m0.i.v.h.a a;

    public static final class a {

        static final kotlin.i0.z.e.m0.i.v.h.a a;
        private static final l<e, Boolean> b;
        static {
            h.a aVar = new h.a();
            h.a.a = aVar;
            h.a.b = h.a.a.a;
        }

        public final l<e, Boolean> a() {
            return h.a.b;
        }
    }

    public static final class b extends kotlin.i0.z.e.m0.i.v.i {

        public static final kotlin.i0.z.e.m0.i.v.h.b b;
        static {
            h.b bVar = new h.b();
            h.b.b = bVar;
        }

        public Set<e> b() {
            return q0.b();
        }

        public Set<e> d() {
            return q0.b();
        }

        public Set<e> e() {
            return q0.b();
        }
    }
    static {
        h.a = h.a.a;
    }

    public abstract Collection<? extends t0> a(e e, b b2);

    public abstract Set<e> b();

    public abstract Collection<? extends o0> c(e e, b b2);

    public abstract Set<e> d();

    public abstract Set<e> e();
}
