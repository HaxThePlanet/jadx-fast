package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.j1.g;

/* loaded from: classes3.dex */
public final class s0<T extends kotlin.i0.z.e.m0.i.v.h>  {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.s0.a e;
    static final l<Object>[] f;
    private final kotlin.reflect.jvm.internal.impl.descriptors.e a;
    private final l<g, T> b;
    private final g c;
    private final i d;

    public static final class a {
        public a(g g) {
            super();
        }

        public final <T extends kotlin.i0.z.e.m0.i.v.h> kotlin.reflect.jvm.internal.impl.descriptors.s0<T> a(kotlin.reflect.jvm.internal.impl.descriptors.e e, n n2, g g3, l<? super g, ? extends T> l4) {
            n.f(e, "classDescriptor");
            n.f(n2, "storageManager");
            n.f(g3, "kotlinTypeRefinerForOwnerModule");
            n.f(l4, "scopeFactory");
            super(e, n2, l4, g3, 0);
            return s0Var;
        }
    }

    static final class b extends p implements a<T> {

        final g $kotlinTypeRefiner;
        final kotlin.reflect.jvm.internal.impl.descriptors.s0<T> this$0;
        b(kotlin.reflect.jvm.internal.impl.descriptors.s0<T> s0, g g2) {
            this.this$0 = s0;
            this.$kotlinTypeRefiner = g2;
            super(0);
        }

        public final T a() {
            return (h)s0.b(this.this$0).invoke(this.$kotlinTypeRefiner);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    static final class c extends p implements a<T> {

        final kotlin.reflect.jvm.internal.impl.descriptors.s0<T> this$0;
        c(kotlin.reflect.jvm.internal.impl.descriptors.s0<T> s0) {
            this.this$0 = s0;
            super(0);
        }

        public final T a() {
            return (h)s0.b(this.this$0).invoke(s0.a(this.this$0));
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        s0.a aVar = new s0.a(0);
        s0.e = aVar;
        l[] arr = new l[1];
        x xVar = new x(c0.b(s0.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;");
        s0.f = arr;
    }

    private s0(kotlin.reflect.jvm.internal.impl.descriptors.e e, n n2, l<? super g, ? extends T> l3, g g4) {
        super();
        this.a = e;
        this.b = l3;
        this.c = g4;
        s0.c obj1 = new s0.c(this);
        this.d = n2.d(obj1);
    }

    public s0(kotlin.reflect.jvm.internal.impl.descriptors.e e, n n2, l l3, g g4, g g5) {
        super(e, n2, l3, g4);
    }

    public static final g a(kotlin.reflect.jvm.internal.impl.descriptors.s0 s0) {
        return s0.c;
    }

    public static final l b(kotlin.reflect.jvm.internal.impl.descriptors.s0 s0) {
        return s0.b;
    }

    private final T d() {
        return (h)m.a(this.d, this, s0.f[0]);
    }

    public final T c(g g) {
        n.f(g, "kotlinTypeRefiner");
        if (!g.c(a.l(this.a))) {
            return d();
        }
        kotlin.i0.z.e.m0.l.t0 t0Var = this.a.g();
        n.e(t0Var, "classDescriptor.typeConstructor");
        if (!g.d(t0Var)) {
            return d();
        }
        s0.b bVar = new s0.b(this, g);
        return g.b(this.a, bVar);
    }
}
