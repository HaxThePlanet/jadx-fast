package kotlin.i0.z.e.m0.b.q;

import java.util.List;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.i.v.e;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class a extends e {

    public static final kotlin.i0.z.e.m0.b.q.a.a e;
    private static final e f;

    public static final class a {
        public a(g g) {
            super();
        }

        public final e a() {
            return a.m();
        }
    }
    static {
        a.a aVar = new a.a(0);
        a.e = aVar;
        e eVar = e.j("clone");
        n.e(eVar, "identifier(\"clone\")");
        a.f = eVar;
    }

    public a(n n, e e2) {
        n.f(n, "storageManager");
        n.f(e2, "containingClass");
        super(n, e2);
    }

    public static final e m() {
        return a.f;
    }

    protected List<x> i() {
        f0 f0Var = f0.k1(l(), g.q.b(), a.e.a(), b.a.DECLARATION, u0.a);
        f0Var.m1(0, l().I0(), p.g(), p.g(), a.g(l()).i(), z.OPEN, t.c);
        return p.b(f0Var);
    }
}
