package kotlin.i0.z.e.m0.i.q;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.x0;
import kotlin.i0.z.e.m0.l.z0;
import kotlin.j;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class n implements t0 {

    public static final kotlin.i0.z.e.m0.i.q.n.a f;
    private final long a;
    private final c0 b;
    private final Set<b0> c;
    private final i0 d;
    private final h e;

    public static final class a {
        public a(g g) {
            super();
        }

        private final i0 a(Collection<? extends i0> collection, kotlin.i0.z.e.m0.i.q.n.a.a n$a$a2) {
            Object next2;
            Object next;
            if (collection.isEmpty()) {
                return null;
            }
            Iterator obj3 = collection.iterator();
            if (!obj3.hasNext()) {
            } else {
                next2 = obj3.next();
                for (i0 next : obj3) {
                    next2 = e((i0)next2, next, a2);
                }
                return (i0)next2;
            }
            obj3 = new UnsupportedOperationException("Empty collection can't be reduced.");
            throw obj3;
        }

        private final i0 c(kotlin.i0.z.e.m0.i.q.n n, kotlin.i0.z.e.m0.i.q.n n2, kotlin.i0.z.e.m0.i.q.n.a.a n$a$a3) {
            int i;
            Set obj8;
            Set obj9;
            obj9 = n.a.b.a[a3.ordinal()];
            if (obj9 != 1) {
                if (obj9 != 2) {
                } else {
                    obj8 = p.Q0(n.k(), n2.k());
                    super(n.h(n), obj2, n.f(n), obj8, 0);
                    c0 obj7 = c0.a;
                    return c0.e(g.q.b(), obj8, false);
                }
                obj7 = new NoWhenBranchMatchedException();
                throw obj7;
            }
            obj8 = p.d0(n.k(), n2.k());
        }

        private final i0 d(kotlin.i0.z.e.m0.i.q.n n, i0 i02) {
            Object obj2;
            if (n.k().contains(i02)) {
            } else {
                obj2 = 0;
            }
            return obj2;
        }

        private final i0 e(i0 i0, i0 i02, kotlin.i0.z.e.m0.i.q.n.a.a n$a$a3) {
            int i;
            t0 t0Var;
            t0 t0Var2;
            boolean z2;
            boolean z;
            i0 obj7;
            i = 0;
            if (i0 != null) {
                if (i02 == null) {
                } else {
                    t0Var = i0.L0();
                    t0Var2 = i02.L0();
                    z2 = t0Var instanceof n;
                    if (z2 && t0Var2 instanceof n) {
                        if (t0Var2 instanceof n) {
                            i = c((n)t0Var, (n)t0Var2, a3);
                        } else {
                            if (z2) {
                                i = d((n)t0Var, i02);
                            } else {
                                if (t0Var2 instanceof n) {
                                    i = d((n)t0Var2, i0);
                                }
                            }
                        }
                    } else {
                    }
                }
            }
            return i;
        }

        public final i0 b(Collection<? extends i0> collection) {
            n.f(collection, "types");
            return a(collection, n.a.a.INTERSECTION_TYPE);
        }
    }

    static final class b extends p implements a<List<i0>> {

        final kotlin.i0.z.e.m0.i.q.n this$0;
        b(kotlin.i0.z.e.m0.i.q.n n) {
            this.this$0 = n;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<i0> invoke() {
            boolean z;
            i0[] arr = new i0[1];
            i0 i0Var = this.this$0.m().x().q();
            n.e(i0Var, "builtIns.comparable.defaultType");
            x0 x0Var = new x0(h1.IN_VARIANCE, n.g(this.this$0));
            int i3 = 0;
            List list = p.m(z0.f(i0Var, p.b(x0Var), i3, 2, i3));
            if (!n.i(this.this$0)) {
                list.add(this.this$0.m().L());
            }
            return list;
        }
    }

    static final class c extends p implements l<b0, java.lang.CharSequence> {

        public static final kotlin.i0.z.e.m0.i.q.n.c a;
        static {
            n.c cVar = new n.c();
            n.c.a = cVar;
        }

        c() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence a(b0 b0) {
            n.f(b0, "it");
            return b0.toString();
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((b0)object);
        }
    }
    static {
        n.a aVar = new n.a(0);
        n.f = aVar;
    }

    private n(long l, c0 c02, Set<? extends b0> set3) {
        super();
        c0 c0Var = c0.a;
        this.d = c0.e(g.q.b(), this, false);
        n.b bVar = new n.b(this);
        this.e = j.b(bVar);
        this.a = l;
        this.b = set3;
        this.c = obj6;
    }

    public n(long l, c0 c02, Set set3, g g4) {
        super(l, c02, set3, g4);
    }

    public static final c0 f(kotlin.i0.z.e.m0.i.q.n n) {
        return n.b;
    }

    public static final i0 g(kotlin.i0.z.e.m0.i.q.n n) {
        return n.d;
    }

    public static final long h(kotlin.i0.z.e.m0.i.q.n n) {
        return n.a;
    }

    public static final boolean i(kotlin.i0.z.e.m0.i.q.n n) {
        return n.n();
    }

    private final List<b0> l() {
        return (List)this.e.getValue();
    }

    private final boolean n() {
        Object iterator;
        boolean empty;
        int i;
        Set set;
        iterator = t.a(this.b);
        if (iterator instanceof Collection != null && iterator.isEmpty()) {
            if (iterator.isEmpty()) {
            } else {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    if (!contains ^= i) {
                        break;
                    } else {
                    }
                }
            }
        } else {
        }
        return i;
    }

    private final String o() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        stringBuilder.append(p.h0(this.c, ",", 0, 0, 0, 0, n.c.a, 30, 0));
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public Collection<b0> a() {
        return l();
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public t0 b(g g) {
        n.f(g, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public h c() {
        return null;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public boolean d() {
        return 0;
    }

    public List<z0> getParameters() {
        return p.g();
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public final boolean j(t0 t0) {
        Object iterator;
        boolean empty;
        int i;
        n.f(t0, "constructor");
        iterator = this.c;
        i = 0;
        if (iterator instanceof Collection != null && iterator.isEmpty()) {
            if (iterator.isEmpty()) {
            } else {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    if (n.b((b0)iterator.next().L0(), t0)) {
                        break;
                    } else {
                    }
                }
            }
        } else {
        }
        return i;
    }

    public final Set<b0> k() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public h m() {
        return this.b.m();
    }

    @Override // kotlin.i0.z.e.m0.l.t0
    public String toString() {
        return n.o("IntegerLiteralType", o());
    }
}
