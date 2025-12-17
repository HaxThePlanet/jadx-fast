package kotlin.i0.z.e.m0.l;

import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
public final class p extends kotlin.i0.z.e.m0.l.y0 {

    public static final kotlin.i0.z.e.m0.l.p.a d;
    private final kotlin.i0.z.e.m0.l.y0 b;
    private final kotlin.i0.z.e.m0.l.y0 c;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.i0.z.e.m0.l.y0 a(kotlin.i0.z.e.m0.l.y0 y0, kotlin.i0.z.e.m0.l.y0 y02) {
            n.f(y0, "first");
            n.f(y02, "second");
            if (y0.f()) {
                return y02;
            }
            if (y02.f()) {
                return y0;
            }
            p pVar = new p(y0, y02, 0);
            return pVar;
        }
    }
    static {
        p.a aVar = new p.a(0);
        p.d = aVar;
    }

    private p(kotlin.i0.z.e.m0.l.y0 y0, kotlin.i0.z.e.m0.l.y0 y02) {
        super();
        this.b = y0;
        this.c = y02;
    }

    public p(kotlin.i0.z.e.m0.l.y0 y0, kotlin.i0.z.e.m0.l.y0 y02, g g3) {
        super(y0, y02);
    }

    public static final kotlin.i0.z.e.m0.l.y0 h(kotlin.i0.z.e.m0.l.y0 y0, kotlin.i0.z.e.m0.l.y0 y02) {
        return p.d.a(y0, y02);
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public boolean a() {
        int i;
        boolean z;
        if (!this.b.a()) {
            if (this.c.a()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public boolean b() {
        int i;
        boolean z;
        if (!this.b.b()) {
            if (this.c.b()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public g d(g g) {
        n.f(g, "annotations");
        return this.c.d(this.b.d(g));
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public kotlin.i0.z.e.m0.l.v0 e(kotlin.i0.z.e.m0.l.b0 b0) {
        kotlin.i0.z.e.m0.l.v0 v0Var;
        n.f(b0, "key");
        if (this.b.e(b0) == null) {
            v0Var = this.c.e(b0);
        }
        return v0Var;
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public boolean f() {
        return 0;
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public kotlin.i0.z.e.m0.l.b0 g(kotlin.i0.z.e.m0.l.b0 b0, kotlin.i0.z.e.m0.l.h1 h12) {
        n.f(b0, "topLevelType");
        n.f(h12, "position");
        return this.c.g(this.b.g(b0, h12), h12);
    }
}
