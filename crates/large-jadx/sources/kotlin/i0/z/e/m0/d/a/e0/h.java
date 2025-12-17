package kotlin.i0.z.e.m0.d.a.e0;

import java.util.Map;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.d.a.g0.g;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.u;
import kotlin.y.j0;

/* loaded from: classes3.dex */
public final class h extends kotlin.i0.z.e.m0.d.a.e0.b {

    static final l<Object>[] h;
    private final i g;

    static final class a extends p implements a<Map<e, ? extends g<?>>> {

        final kotlin.i0.z.e.m0.d.a.e0.h this$0;
        a(kotlin.i0.z.e.m0.d.a.e0.h h) {
            this.this$0 = h;
            super(0);
        }

        public final Map<e, g<?>> a() {
            int i;
            Object bVar;
            g gVar = d.a.a(this.this$0.b());
            if (gVar == null) {
                i = 0;
            } else {
                i = j0.e(u.a(c.a.c(), gVar));
            }
            if (i != 0) {
            } else {
                i = j0.h();
            }
            return i;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        l[] arr = new l[1];
        x xVar = new x(c0.b(h.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;");
        h.h = arr;
    }

    public h(a a, g g2) {
        n.f(a, "annotation");
        n.f(g2, "c");
        super(g2, a, k.a.D);
        h.a obj3 = new h.a(this);
        this.g = g2.e().d(obj3);
    }

    public Map<e, g<?>> a() {
        return (Map)m.a(this.g, this, h.h[0]);
    }
}
