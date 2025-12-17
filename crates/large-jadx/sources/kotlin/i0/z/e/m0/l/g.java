package kotlin.i0.z.e.m0.l;

import java.util.Collection;
import java.util.List;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.w;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class g implements kotlin.i0.z.e.m0.l.t0 {

    private final i<kotlin.i0.z.e.m0.l.g.b> a;
    private final boolean b;

    private static final class b {

        private final Collection<kotlin.i0.z.e.m0.l.b0> a;
        private List<? extends kotlin.i0.z.e.m0.l.b0> b;
        public b(Collection<? extends kotlin.i0.z.e.m0.l.b0> collection) {
            n.f(collection, "allSupertypes");
            super();
            this.a = collection;
            this.b = p.b(t.c);
        }

        public final Collection<kotlin.i0.z.e.m0.l.b0> a() {
            return this.a;
        }

        public final List<kotlin.i0.z.e.m0.l.b0> b() {
            return this.b;
        }

        public final void c(List<? extends kotlin.i0.z.e.m0.l.b0> list) {
            n.f(list, "<set-?>");
            this.b = list;
        }
    }

    private final class a implements kotlin.i0.z.e.m0.l.t0 {

        private final g a;
        private final h b;
        final kotlin.i0.z.e.m0.l.g c;
        public a(kotlin.i0.z.e.m0.l.g g, g g2) {
            n.f(g, "this$0");
            n.f(g2, "kotlinTypeRefiner");
            this.c = g;
            super();
            this.a = g2;
            g.a.a aVar = new g.a.a(this, g);
            this.b = j.a(m.PUBLICATION, aVar);
        }

        public static final g f(kotlin.i0.z.e.m0.l.g.a g$a) {
            return a.a;
        }

        private final List<kotlin.i0.z.e.m0.l.b0> g() {
            return (List)this.b.getValue();
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public Collection a() {
            return h();
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public kotlin.i0.z.e.m0.l.t0 b(g g) {
            n.f(g, "kotlinTypeRefiner");
            return this.c.b(g);
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public h c() {
            return this.c.c();
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public boolean d() {
            return this.c.d();
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public boolean equals(Object object) {
            return this.c.equals(object);
        }

        public List<z0> getParameters() {
            List parameters = this.c.getParameters();
            n.e(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        public List<kotlin.i0.z.e.m0.l.b0> h() {
            return g();
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public int hashCode() {
            return this.c.hashCode();
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public h m() {
            h hVar = this.c.m();
            n.e(hVar, "this@AbstractTypeConstructor.builtIns");
            return hVar;
        }

        @Override // kotlin.i0.z.e.m0.l.t0
        public String toString() {
            return this.c.toString();
        }
    }

    static final class c extends p implements a<kotlin.i0.z.e.m0.l.g.b> {

        final kotlin.i0.z.e.m0.l.g this$0;
        c(kotlin.i0.z.e.m0.l.g g) {
            this.this$0 = g;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.i0.z.e.m0.l.g.b a() {
            g.b bVar = new g.b(this.this$0.h());
            return bVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    static final class d extends p implements l<Boolean, kotlin.i0.z.e.m0.l.g.b> {

        public static final kotlin.i0.z.e.m0.l.g.d a;
        static {
            g.d dVar = new g.d();
            g.d.a = dVar;
        }

        d() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.i0.z.e.m0.l.g.b a(boolean z) {
            g.b obj2 = new g.b(p.b(t.c));
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((Boolean)object.booleanValue());
        }
    }

    static final class e extends p implements l<kotlin.i0.z.e.m0.l.g.b, w> {

        final kotlin.i0.z.e.m0.l.g this$0;
        e(kotlin.i0.z.e.m0.l.g g) {
            this.this$0 = g;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(kotlin.i0.z.e.m0.l.g.b g$b) {
            Object collection;
            boolean z;
            int i;
            Object cVar;
            p dVar;
            Object bVar;
            kotlin.i0.z.e.m0.l.g this$0;
            n.f(b, "supertypes");
            cVar = new g.e.c(this.this$0);
            dVar = new g.e.d(this.this$0);
            if (this.this$0.l().a(this.this$0, b.a(), cVar, dVar).isEmpty()) {
                kotlin.i0.z.e.m0.l.b0 b0Var = this.this$0.i();
                if (b0Var == null) {
                    collection = i;
                } else {
                    collection = p.b(b0Var);
                }
                if (collection != null) {
                } else {
                    collection = p.g();
                }
            }
            if (this.this$0.k()) {
                cVar = this.this$0;
                dVar = new g.e.a(cVar);
                bVar = new g.e.b(this.this$0);
                this.this$0.l().a(cVar, collection, dVar, bVar);
            }
            if (collection instanceof List != null) {
                i = collection;
            }
            if (i == 0) {
                i = p.L0(collection);
            }
            b.c(this.this$0.o(i));
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((g.b)object);
            return w.a;
        }
    }
    public g(n n) {
        n.f(n, "storageManager");
        super();
        g.c cVar = new g.c(this);
        g.e eVar = new g.e(this);
        this.a = n.g(cVar, g.d.a, eVar);
    }

    public static final Collection f(kotlin.i0.z.e.m0.l.g g, kotlin.i0.z.e.m0.l.t0 t02, boolean z3) {
        return g.g(t02, z3);
    }

    private final Collection<kotlin.i0.z.e.m0.l.b0> g(kotlin.i0.z.e.m0.l.t0 t0, boolean z2) {
        int i2;
        List i;
        Object obj3;
        Collection obj4;
        if (t0 instanceof g) {
            i2 = t0;
        } else {
            i2 = i;
        }
        if (i2 == 0) {
        } else {
            i = p.t0((g.b)i2.a.invoke().a(), i2.j(z2));
        }
        if (i == null) {
            n.e(t0.a(), "supertypes");
        }
        return i;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public Collection a() {
        return n();
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public kotlin.i0.z.e.m0.l.t0 b(g g) {
        n.f(g, "kotlinTypeRefiner");
        g.a aVar = new g.a(this, g);
        return aVar;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public abstract h c();

    protected abstract Collection<kotlin.i0.z.e.m0.l.b0> h();

    @Override // kotlin.i0.z.e.m0.l.t0
    protected kotlin.i0.z.e.m0.l.b0 i() {
        return null;
    }

    protected Collection<kotlin.i0.z.e.m0.l.b0> j(boolean z) {
        return p.g();
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    protected boolean k() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    protected abstract x0 l();

    public List<kotlin.i0.z.e.m0.l.b0> n() {
        return (g.b)this.a.invoke().b();
    }

    protected List<kotlin.i0.z.e.m0.l.b0> o(List<kotlin.i0.z.e.m0.l.b0> list) {
        n.f(list, "supertypes");
        return list;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    protected void p(kotlin.i0.z.e.m0.l.b0 b0) {
        n.f(b0, "type");
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    protected void q(kotlin.i0.z.e.m0.l.b0 b0) {
        n.f(b0, "type");
    }
}
