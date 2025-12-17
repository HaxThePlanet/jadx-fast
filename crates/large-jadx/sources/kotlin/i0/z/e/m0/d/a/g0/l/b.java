package kotlin.i0.z.e.m0.d.a.g0.l;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.n;
import kotlin.i0.z.e.m0.d.a.i0.r;
import kotlin.i0.z.e.m0.d.a.i0.w;
import kotlin.i0.z.e.m0.f.e;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public interface b {

    public static final class a implements kotlin.i0.z.e.m0.d.a.g0.l.b {

        public static final kotlin.i0.z.e.m0.d.a.g0.l.b.a a;
        static {
            b.a aVar = new b.a();
            b.a.a = aVar;
        }

        public Set<e> a() {
            return q0.b();
        }

        @Override // kotlin.i0.z.e.m0.d.a.g0.l.b
        public w b(e e) {
            n.f(e, "name");
            return null;
        }

        @Override // kotlin.i0.z.e.m0.d.a.g0.l.b
        public n c(e e) {
            n.f(e, "name");
            return null;
        }

        public Set<e> d() {
            return q0.b();
        }

        public Set<e> e() {
            return q0.b();
        }

        @Override // kotlin.i0.z.e.m0.d.a.g0.l.b
        public Collection f(e e) {
            return g(e);
        }

        public List<r> g(e e) {
            n.f(e, "name");
            return p.g();
        }
    }
    public abstract Set<e> a();

    public abstract w b(e e);

    public abstract n c(e e);

    public abstract Set<e> d();

    public abstract Set<e> e();

    public abstract Collection<r> f(e e);
}
