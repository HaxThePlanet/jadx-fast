package kotlin.i0.z.e.m0.l;

import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.j1.g;

/* loaded from: classes3.dex */
public final class e0 extends kotlin.i0.z.e.m0.l.i1 {

    private final n b;
    private final a<kotlin.i0.z.e.m0.l.b0> c;
    private final i<kotlin.i0.z.e.m0.l.b0> v;

    static final class a extends p implements a<kotlin.i0.z.e.m0.l.b0> {

        final g $kotlinTypeRefiner;
        final kotlin.i0.z.e.m0.l.e0 this$0;
        a(g g, kotlin.i0.z.e.m0.l.e0 e02) {
            this.$kotlinTypeRefiner = g;
            this.this$0 = e02;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.i0.z.e.m0.l.b0 a() {
            return this.$kotlinTypeRefiner.g((b0)e0.R0(this.this$0).invoke());
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    public e0(n n, a<? extends kotlin.i0.z.e.m0.l.b0> a2) {
        n.f(n, "storageManager");
        n.f(a2, "computation");
        super();
        this.b = n;
        this.c = a2;
        this.v = n.d(a2);
    }

    public static final a R0(kotlin.i0.z.e.m0.l.e0 e0) {
        return e0.c;
    }

    @Override // kotlin.i0.z.e.m0.l.i1
    public kotlin.i0.z.e.m0.l.b0 N0(g g) {
        return S0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.i1
    protected kotlin.i0.z.e.m0.l.b0 P0() {
        return (b0)this.v.invoke();
    }

    @Override // kotlin.i0.z.e.m0.l.i1
    public boolean Q0() {
        return this.v.d();
    }

    @Override // kotlin.i0.z.e.m0.l.i1
    public kotlin.i0.z.e.m0.l.e0 S0(g g) {
        n.f(g, "kotlinTypeRefiner");
        e0.a aVar = new e0.a(g, this);
        e0 e0Var = new e0(this.b, aVar);
        return e0Var;
    }
}
