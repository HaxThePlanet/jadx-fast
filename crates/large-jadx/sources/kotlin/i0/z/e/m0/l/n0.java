package kotlin.i0.z.e.m0.l;

import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public final class n0 extends kotlin.i0.z.e.m0.l.w0 {

    private final z0 a;
    private final h b;

    static final class a extends p implements a<kotlin.i0.z.e.m0.l.b0> {

        final kotlin.i0.z.e.m0.l.n0 this$0;
        a(kotlin.i0.z.e.m0.l.n0 n0) {
            this.this$0 = n0;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.i0.z.e.m0.l.b0 a() {
            return o0.a(n0.d(this.this$0));
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    public n0(z0 z0) {
        n.f(z0, "typeParameter");
        super();
        this.a = z0;
        n0.a aVar = new n0.a(this);
        this.b = j.a(m.PUBLICATION, aVar);
    }

    public static final z0 d(kotlin.i0.z.e.m0.l.n0 n0) {
        return n0.a;
    }

    private final kotlin.i0.z.e.m0.l.b0 e() {
        return (b0)this.b.getValue();
    }

    @Override // kotlin.i0.z.e.m0.l.w0
    public kotlin.i0.z.e.m0.l.h1 a() {
        return h1.OUT_VARIANCE;
    }

    @Override // kotlin.i0.z.e.m0.l.w0
    public kotlin.i0.z.e.m0.l.v0 b(g g) {
        n.f(g, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.i0.z.e.m0.l.w0
    public boolean c() {
        return 1;
    }

    @Override // kotlin.i0.z.e.m0.l.w0
    public kotlin.i0.z.e.m0.l.b0 getType() {
        return e();
    }
}
