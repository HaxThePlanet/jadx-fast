package kotlin.reflect.jvm.internal.impl.descriptors.i1;

import java.util.Collection;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public interface a {

    public static final class a implements kotlin.reflect.jvm.internal.impl.descriptors.i1.a {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.i1.a.a a;
        static {
            a.a aVar = new a.a();
            a.a.a = aVar;
        }

        public Collection<d> a(e e) {
            n.f(e, "classDescriptor");
            return p.g();
        }

        public Collection<t0> b(e e, e e2) {
            n.f(e, "name");
            n.f(e2, "classDescriptor");
            return p.g();
        }

        public Collection<b0> d(e e) {
            n.f(e, "classDescriptor");
            return p.g();
        }

        public Collection<e> e(e e) {
            n.f(e, "classDescriptor");
            return p.g();
        }
    }
    public abstract Collection<d> a(e e);

    public abstract Collection<t0> b(e e, e e2);

    public abstract Collection<b0> d(e e);

    public abstract Collection<e> e(e e);
}
