package kotlin.i0.z.e.m0.i.v;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.c;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.utils.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class l extends kotlin.i0.z.e.m0.i.v.i {

    static final l<Object>[] d;
    private final e b;
    private final i c;

    static final class a extends p implements a<List<? extends t0>> {

        final kotlin.i0.z.e.m0.i.v.l this$0;
        a(kotlin.i0.z.e.m0.i.v.l l) {
            this.this$0 = l;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<t0> invoke() {
            t0[] arr = new t0[2];
            return p.j(c.d(l.h(this.this$0)), c.e(l.h(this.this$0)));
        }
    }
    static {
        l[] arr = new l[1];
        x xVar = new x(c0.b(l.class), "functions", "getFunctions()Ljava/util/List;");
        l.d = arr;
    }

    public l(n n, e e2) {
        n.f(n, "storageManager");
        n.f(e2, "containingClass");
        super();
        this.b = e2;
        f obj3 = e2.f();
        f eNUM_CLASS = f.ENUM_CLASS;
        obj3 = new l.a(this);
        this.c = n.d(obj3);
    }

    public static final e h(kotlin.i0.z.e.m0.i.v.l l) {
        return l.b;
    }

    private final List<t0> l() {
        return (List)m.a(this.c, this, l.d[0]);
    }

    @Override // kotlin.i0.z.e.m0.i.v.i
    public Collection a(e e, b b2) {
        return k(e, b2);
    }

    @Override // kotlin.i0.z.e.m0.i.v.i
    public h f(e e, b b2) {
        return (h)i(e, b2);
    }

    @Override // kotlin.i0.z.e.m0.i.v.i
    public Collection g(kotlin.i0.z.e.m0.i.v.d d, l l2) {
        return j(d, l2);
    }

    @Override // kotlin.i0.z.e.m0.i.v.i
    public Void i(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return null;
    }

    public List<t0> j(kotlin.i0.z.e.m0.i.v.d d, l<? super e, Boolean> l2) {
        n.f(d, "kindFilter");
        n.f(l2, "nameFilter");
        return l();
    }

    public i<t0> k(e e, b b2) {
        Object next;
        boolean z;
        n.f(e, "name");
        n.f(b2, "location");
        i iVar = new i();
        Iterator obj5 = l().iterator();
        while (obj5.hasNext()) {
            next = obj5.next();
            if (n.b((t0)next.getName(), e)) {
            }
            iVar.add(next);
        }
        return iVar;
    }
}
