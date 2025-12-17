package kotlin.i0.z.e.m0.i.v;

import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.k.f;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.n;

/* loaded from: classes3.dex */
public final class g extends kotlin.i0.z.e.m0.i.v.a {

    private final i<kotlin.i0.z.e.m0.i.v.h> b;

    static final class a extends p implements a<kotlin.i0.z.e.m0.i.v.h> {

        final a<kotlin.i0.z.e.m0.i.v.h> $getScope;
        a(a<? extends kotlin.i0.z.e.m0.i.v.h> a) {
            this.$getScope = a;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.i0.z.e.m0.i.v.h a() {
            Object invoke;
            invoke = this.$getScope.invoke();
            if (invoke instanceof a) {
                invoke = (a)(h)invoke.h();
            }
            return invoke;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    public g(a<? extends kotlin.i0.z.e.m0.i.v.h> a) {
        n.f(a, "getScope");
        int i = 0;
        super(i, a, 1, i);
    }

    public g(n n, a<? extends kotlin.i0.z.e.m0.i.v.h> a2) {
        n.f(n, "storageManager");
        n.f(a2, "getScope");
        super();
        g.a aVar = new g.a(a2);
        this.b = n.d(aVar);
    }

    public g(n n, a a2, int i3, g g4) {
        n obj1;
        int obj3;
        if (i3 &= 1 != 0) {
            n.e(f.e, "NO_LOCKS");
        }
        super(obj1, a2);
    }

    @Override // kotlin.i0.z.e.m0.i.v.a
    protected kotlin.i0.z.e.m0.i.v.h i() {
        return (h)this.b.invoke();
    }
}
