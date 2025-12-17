package kotlin.i0.z.e.m0.l.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.i.j;
import kotlin.i0.z.e.m0.i.p.a.c;
import kotlin.i0.z.e.m0.i.q.p;
import kotlin.i0.z.e.m0.l.a0;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.e;
import kotlin.i0.z.e.m0.l.e1;
import kotlin.i0.z.e.m0.l.g1;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.l1.b;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.v;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class m implements kotlin.i0.z.e.m0.l.j1.l {

    private final kotlin.i0.z.e.m0.l.j1.g c;
    private final j d;
    public m(kotlin.i0.z.e.m0.l.j1.g g) {
        n.f(g, "kotlinTypeRefiner");
        super();
        this.c = g;
        j obj2 = j.p(c());
        n.e(obj2, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.d = obj2;
    }

    @Override // kotlin.i0.z.e.m0.l.j1.l
    public j a() {
        return this.d;
    }

    @Override // kotlin.i0.z.e.m0.l.j1.l
    public boolean b(b0 b0, b0 b02) {
        n.f(b0, "a");
        n.f(b02, "b");
        super(0, 0, 0, c(), 6, 0);
        return e(aVar, b0.O0(), b02.O0());
    }

    @Override // kotlin.i0.z.e.m0.l.j1.l
    public kotlin.i0.z.e.m0.l.j1.g c() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.m0.l.j1.l
    public boolean d(b0 b0, b0 b02) {
        n.f(b0, "subtype");
        n.f(b02, "supertype");
        super(1, 0, 0, c(), 6, 0);
        return f(aVar, b0.O0(), b02.O0());
    }

    @Override // kotlin.i0.z.e.m0.l.j1.l
    public final boolean e(kotlin.i0.z.e.m0.l.j1.a a, g1 g12, g1 g13) {
        n.f(a, "<this>");
        n.f(g12, "a");
        n.f(g13, "b");
        return e.a.i(a, g12, g13);
    }

    @Override // kotlin.i0.z.e.m0.l.j1.l
    public final boolean f(kotlin.i0.z.e.m0.l.j1.a a, g1 g12, g1 g13) {
        n.f(a, "<this>");
        n.f(g12, "subType");
        n.f(g13, "superType");
        return e.o(e.a, a, g12, g13, false, 8, 0);
    }

    @Override // kotlin.i0.z.e.m0.l.j1.l
    public final i0 g(i0 i0) {
        Object a0Var;
        Object obj;
        kotlin.i0.z.e.m0.l.t0 t0Var;
        boolean arrayList2;
        int type;
        kotlin.i0.z.e.m0.l.j1.j jVar;
        int i7;
        int next;
        int i2;
        int i;
        int next2;
        a0 i3;
        kotlin.i0.z.e.m0.l.j1.j jVar2;
        v0 v0Var;
        ArrayList arrayList;
        int i4;
        int i6;
        int i5;
        n.f(i0, "type");
        t0Var = i0.L0();
        i = 0;
        next2 = 10;
        if (t0Var instanceof c) {
            if ((c)t0Var.e().a() == h1.IN_VARIANCE) {
            } else {
                next = i;
            }
            if (next != 0) {
            } else {
                type = i3;
            }
            if (type != null) {
                type = type.getType();
                if (type == null) {
                } else {
                    i3 = type.O0();
                }
            }
            if (t0Var.g() == null) {
                Collection collection3 = t0Var.a();
                arrayList = new ArrayList(p.r(collection3, next2));
                Iterator iterator2 = collection3.iterator();
                for (b0 next5 : iterator2) {
                    arrayList.add(next5.O0());
                }
                super(t0Var.e(), arrayList, 0, 4, 0);
                t0Var.i(jVar);
            }
            final kotlin.i0.z.e.m0.l.j1.j jVar3 = t0Var.g();
            n.d(jVar3);
            super(b.FOR_SUBTYPING, jVar3, i3, i0.getAnnotations(), i0.M0(), 0, 32, 0);
            return iVar;
        }
        if (t0Var instanceof p) {
            Collection collection2 = (p)t0Var.a();
            ArrayList arrayList3 = new ArrayList(p.r(collection2, next2));
            Iterator iterator = collection2.iterator();
            for (b0 next4 : iterator) {
                i7 = c1.p(next4, i0.M0());
                n.e(i7, "makeNullableAsSpecified(it, type.isMarkedNullable)");
                arrayList3.add(i7);
            }
            a0 a0Var2 = new a0(arrayList3);
            c0 c0Var = c0.a;
            return c0.j(i0.getAnnotations(), a0Var2, p.g(), i, i0.o());
        }
        if (t0Var instanceof a0 && i0.M0()) {
            if (i0.M0()) {
                Collection collection = (a0)t0Var.a();
                arrayList2 = new ArrayList(p.r(collection, next2));
                a0Var = collection.iterator();
                for (b0 next6 : a0Var) {
                    arrayList2.add(a.k(next6));
                    i = next;
                }
                if (i == 0) {
                } else {
                    b0 b0Var = t0Var.h();
                    if (b0Var == null) {
                    } else {
                        i3 = a.k(b0Var);
                    }
                    a0Var = new a0(arrayList2);
                    i3 = a0Var.k(i3);
                }
                if (i3 == null) {
                } else {
                    t0Var = i3;
                }
                obj = t0Var.g();
            }
        }
        return obj;
    }

    @Override // kotlin.i0.z.e.m0.l.j1.l
    public g1 h(g1 g1) {
        Object obj;
        Object g1Var;
        i0 i0Var3;
        i0 i0Var;
        i0 i0Var2;
        n.f(g1, "type");
        if (g1 instanceof i0) {
            g1Var = g((i0)g1);
            return e1.b(g1Var, g1);
        } else {
            if (!g1 instanceof v) {
            } else {
                obj = g1;
                i0Var3 = g((v)obj.T0());
                i0Var = g(obj.U0());
                if (i0Var3 == obj.T0()) {
                    if (i0Var != obj.U0()) {
                        c0 c0Var = c0.a;
                        g1Var = c0.d(i0Var3, i0Var);
                    } else {
                        g1Var = g1;
                    }
                } else {
                }
            }
        }
        NoWhenBranchMatchedException obj5 = new NoWhenBranchMatchedException();
        throw obj5;
    }
}
