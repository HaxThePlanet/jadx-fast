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
import kotlin.i0.z.e.m0.i.q.v;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.u;
import kotlin.y.j0;

/* loaded from: classes3.dex */
public final class e extends kotlin.i0.z.e.m0.d.a.e0.b {

    static final l<Object>[] h;
    private final i g;

    static final class a extends p implements a<Map<e, ? extends v>> {

        public static final kotlin.i0.z.e.m0.d.a.e0.e.a a;
        static {
            e.a aVar = new e.a();
            e.a.a = aVar;
        }

        a() {
            super(0);
        }

        public final Map<e, v> a() {
            v vVar = new v("Deprecated in Java");
            return j0.e(u.a(c.a.b(), vVar));
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        l[] arr = new l[1];
        x xVar = new x(c0.b(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;");
        e.h = arr;
    }

    public e(a a, g g2) {
        n.f(g2, "c");
        super(g2, a, k.a.u);
        this.g = g2.e().d(e.a.a);
    }

    public Map<e, g<?>> a() {
        return (Map)m.a(this.g, this, e.h[0]);
    }
}
