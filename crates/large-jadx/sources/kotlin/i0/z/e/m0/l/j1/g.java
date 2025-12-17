package kotlin.i0.z.e.m0.l.j1;

import java.util.Collection;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;

/* loaded from: classes3.dex */
public abstract class g {

    public static final class a extends kotlin.i0.z.e.m0.l.j1.g {

        public static final kotlin.i0.z.e.m0.l.j1.g.a a;
        static {
            g.a aVar = new g.a();
            g.a.a = aVar;
        }

        @Override // kotlin.i0.z.e.m0.l.j1.g
        public e a(a a) {
            n.f(a, "classId");
            return null;
        }

        public <S extends kotlin.i0.z.e.m0.i.v.h> S b(e e, a<? extends S> a2) {
            n.f(e, "classDescriptor");
            n.f(a2, "compute");
            return (h)a2.invoke();
        }

        @Override // kotlin.i0.z.e.m0.l.j1.g
        public boolean c(c0 c0) {
            n.f(c0, "moduleDescriptor");
            return 0;
        }

        @Override // kotlin.i0.z.e.m0.l.j1.g
        public boolean d(t0 t0) {
            n.f(t0, "typeConstructor");
            return 0;
        }

        @Override // kotlin.i0.z.e.m0.l.j1.g
        public h e(m m) {
            return h(m);
        }

        public Collection<b0> f(e e) {
            n.f(e, "classDescriptor");
            Collection obj2 = e.g().a();
            n.e(obj2, "classDescriptor.typeConstructor.supertypes");
            return obj2;
        }

        @Override // kotlin.i0.z.e.m0.l.j1.g
        public b0 g(b0 b0) {
            n.f(b0, "type");
            return b0;
        }

        @Override // kotlin.i0.z.e.m0.l.j1.g
        public e h(m m) {
            n.f(m, "descriptor");
            return null;
        }
    }
    public abstract e a(a a);

    public abstract <S extends kotlin.i0.z.e.m0.i.v.h> S b(e e, a<? extends S> a2);

    public abstract boolean c(c0 c0);

    public abstract boolean d(t0 t0);

    public abstract h e(m m);

    public abstract Collection<b0> f(e e);

    public abstract b0 g(b0 b0);
}
