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
import kotlin.i0.z.e.m0.d.a.i0.e;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class i extends kotlin.i0.z.e.m0.d.a.e0.b {

    static final l<Object>[] h;
    private final i g;

    static final class a extends p implements a<Map<e, ? extends g<? extends Object>>> {

        final kotlin.i0.z.e.m0.d.a.e0.i this$0;
        a(kotlin.i0.z.e.m0.d.a.e0.i i) {
            this.this$0 = i;
            super(0);
        }

        public final Map<e, g<Object>> a() {
            g gVar;
            java.util.List list;
            Map i;
            kotlin.i0.z.e.m0.d.a.i0.b bVar = this.this$0.b();
            if (bVar instanceof e) {
                gVar = d.a.c((e)this.this$0.b().e());
            } else {
                if (bVar instanceof m) {
                    gVar = d.a.c(p.b(this.this$0.b()));
                } else {
                    gVar = i;
                }
            }
            if (gVar == null) {
            } else {
                i = j0.e(u.a(c.a.d(), gVar));
            }
            if (i != null) {
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
        x xVar = new x(c0.b(i.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;");
        i.h = arr;
    }

    public i(a a, g g2) {
        n.f(a, "annotation");
        n.f(g2, "c");
        super(g2, a, k.a.A);
        i.a obj3 = new i.a(this);
        this.g = g2.e().d(obj3);
    }

    public Map<e, g<Object>> a() {
        return (Map)m.a(this.g, this, i.h[0]);
    }
}
