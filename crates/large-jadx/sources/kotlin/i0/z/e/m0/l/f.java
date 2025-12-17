package kotlin.i0.z.e.m0.l;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.l1.c;
import kotlin.i0.z.e.m0.l.l1.h;
import kotlin.i0.z.e.m0.l.l1.i;
import kotlin.i0.z.e.m0.l.l1.j;
import kotlin.i0.z.e.m0.l.l1.k;
import kotlin.i0.z.e.m0.l.l1.l;
import kotlin.i0.z.e.m0.l.l1.n;
import kotlin.i0.z.e.m0.l.l1.n.a;
import kotlin.reflect.jvm.internal.impl.utils.j;
import kotlin.reflect.jvm.internal.impl.utils.j.b;

/* loaded from: classes3.dex */
public abstract class f implements n {

    private int a;
    private boolean b;
    private ArrayDeque<i> c;
    private Set<i> d;

    public static enum a {

        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER;
    }

    public static abstract class b {
        public b(g g) {
            super();
        }

        public abstract i a(kotlin.i0.z.e.m0.l.f f, h h2);
    }
    public static final int i0(kotlin.i0.z.e.m0.l.f f) {
        return f.a;
    }

    public static final void j0(kotlin.i0.z.e.m0.l.f f, int i2) {
        f.a = i2;
    }

    public static Boolean l0(kotlin.i0.z.e.m0.l.f f, h h2, h h3, boolean z4, int i5, Object object6) {
        int obj3;
        if (object6 != null) {
        } else {
            if (i5 &= 4 != 0) {
                obj3 = 0;
            }
            return f.k0(h2, h3, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        throw obj0;
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public boolean A0(i i) {
        return n.a.h(this, i);
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public boolean B0(h h) {
        return n.a.j(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public abstract boolean C0();

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public abstract h D0(h h);

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public int E(j j) {
        return n.a.l(this, j);
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public abstract h E0(h h);

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public i F(h h) {
        return n.a.n(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public abstract kotlin.i0.z.e.m0.l.f.b F0(i i);

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public i Q(h h) {
        return n.a.k(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public boolean W(h h) {
        return n.a.i(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public Boolean k0(h h, h h2, boolean z3) {
        n.f(h, "subType");
        n.f(h2, "superType");
        return null;
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public final void m0() {
        ArrayDeque queue = this.c;
        n.d(queue);
        queue.clear();
        Set set = this.d;
        n.d(set);
        set.clear();
        this.b = false;
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public boolean n0(h h, h h2) {
        n.f(h, "subType");
        n.f(h2, "superType");
        return 1;
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public k o(j j, int i2) {
        return n.a.b(this, j, i2);
    }

    public List<i> o0(i i, l l2) {
        return n.a.a(this, i, l2);
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public k p0(i i, int i2) {
        return n.a.c(this, i, i2);
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public l q(h h) {
        return n.a.m(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public kotlin.i0.z.e.m0.l.f.a q0(i i, c c2) {
        n.f(i, "subType");
        n.f(c2, "superType");
        return f.a.CHECK_SUBTYPE_AND_LOWER;
    }

    public final ArrayDeque<i> r0() {
        return this.c;
    }

    public final Set<i> s0() {
        return this.d;
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public boolean t0(h h) {
        return n.a.d(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public final void u0() {
        ArrayDeque arrayDeque;
        Object set;
        int i;
        this.b = true;
        if (this.c == null) {
            arrayDeque = new ArrayDeque(4);
            this.c = arrayDeque;
        }
        if (this.d == null) {
            this.d = j.c.a();
        }
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public abstract boolean v0(h h);

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public boolean w0(i i) {
        return n.a.e(this, i);
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public boolean x0(h h) {
        return n.a.f(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public boolean y0(h h) {
        return n.a.g(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.l1.n
    public abstract boolean z0();
}
