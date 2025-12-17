package kotlin.i0.z.e.m0.l;

import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;

/* loaded from: classes3.dex */
public abstract class y0 {

    public static final kotlin.i0.z.e.m0.l.y0 a;

    public static final class a extends kotlin.i0.z.e.m0.l.y0 {
        @Override // kotlin.i0.z.e.m0.l.y0
        public kotlin.i0.z.e.m0.l.v0 e(kotlin.i0.z.e.m0.l.b0 b0) {
            return (v0)h(b0);
        }

        @Override // kotlin.i0.z.e.m0.l.y0
        public boolean f() {
            return 1;
        }

        @Override // kotlin.i0.z.e.m0.l.y0
        public Void h(kotlin.i0.z.e.m0.l.b0 b0) {
            n.f(b0, "key");
            return null;
        }

        @Override // kotlin.i0.z.e.m0.l.y0
        public String toString() {
            return "Empty TypeSubstitution";
        }
    }
    static {
        y0.a aVar = new y0.a();
        y0.a = aVar;
    }

    public boolean a() {
        return 0;
    }

    public boolean b() {
        return 0;
    }

    public final kotlin.i0.z.e.m0.l.a1 c() {
        final kotlin.i0.z.e.m0.l.a1 a1Var = a1.g(this);
        n.e(a1Var, "create(this)");
        return a1Var;
    }

    public g d(g g) {
        n.f(g, "annotations");
        return g;
    }

    public abstract kotlin.i0.z.e.m0.l.v0 e(kotlin.i0.z.e.m0.l.b0 b0);

    public boolean f() {
        return 0;
    }

    public kotlin.i0.z.e.m0.l.b0 g(kotlin.i0.z.e.m0.l.b0 b0, kotlin.i0.z.e.m0.l.h1 h12) {
        n.f(b0, "topLevelType");
        n.f(h12, "position");
        return b0;
    }
}
