package kotlin.i0.z.e.m0.l.m1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.e1;
import kotlin.i0.z.e.m0.l.g1;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.j1.f;
import kotlin.i0.z.e.m0.l.n0;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.i0.z.e.m0.l.x0;
import kotlin.i0.z.e.m0.l.z0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class a {

    static final class a extends p implements l<g1, Boolean> {

        public static final kotlin.i0.z.e.m0.l.m1.a.a a;
        static {
            a.a aVar = new a.a();
            a.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(g1 g1) {
            int obj2;
            n.f(g1, "it");
            obj2 = g1.L0().c();
            if (obj2 == null) {
                obj2 = 0;
            } else {
                obj2 = a.h(obj2);
            }
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((g1)object));
        }
    }

    static final class b extends p implements l<g1, Boolean> {

        public static final kotlin.i0.z.e.m0.l.m1.a.b a;
        static {
            a.b bVar = new a.b();
            a.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(g1 g1) {
            int i;
            boolean z;
            h obj3;
            n.f(g1, "it");
            obj3 = g1.L0().c();
            i = 0;
            if (obj3 == null) {
            } else {
                if (!obj3 instanceof y0) {
                    if (obj3 instanceof z0) {
                        i = obj3;
                    }
                } else {
                }
            }
            return i;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((g1)object));
        }
    }
    public static final v0 a(b0 b0) {
        n.f(b0, "<this>");
        x0 x0Var = new x0(b0);
        return x0Var;
    }

    public static final boolean b(b0 b0, l<? super g1, Boolean> l2) {
        n.f(b0, "<this>");
        n.f(l2, "predicate");
        return c1.c(b0, l2);
    }

    public static final boolean c(b0 b0) {
        n.f(b0, "<this>");
        return a.b(b0, a.a.a);
    }

    public static final v0 d(b0 b0, h1 h12, z0 z03) {
        Object obj2;
        int obj3;
        n.f(b0, "type");
        n.f(h12, "projectionKind");
        if (z03 == null) {
            obj3 = 0;
        } else {
            obj3 = z03.l();
        }
        if (obj3 == h12) {
            obj2 = h1.INVARIANT;
        }
        x0 x0Var = new x0(obj2, b0);
        return x0Var;
    }

    public static final h e(b0 b0) {
        n.f(b0, "<this>");
        h obj1 = b0.L0().m();
        n.e(obj1, "constructor.builtIns");
        return obj1;
    }

    public static final b0 f(z0 z0) {
        Object iterator;
        Object next;
        int i2;
        int i;
        f aNNOTATION_CLASS;
        f iNTERFACE;
        Object obj7;
        n.f(z0, "<this>");
        List upperBounds = z0.getUpperBounds();
        final String str2 = "upperBounds";
        n.e(upperBounds, str2);
        upperBounds.isEmpty();
        List upperBounds2 = z0.getUpperBounds();
        n.e(upperBounds2, str2);
        iterator = upperBounds2.iterator();
        i2 = 0;
        while (iterator.hasNext()) {
            next = iterator.next();
            h hVar = (b0)next.L0().c();
            if (hVar instanceof e) {
            }
            i = 0;
            if (i2 == 0) {
            } else {
            }
            if (i2.f() != f.INTERFACE && i2.f() != f.ANNOTATION_CLASS) {
            }
            if (i != 0) {
                break;
            } else {
            }
            i2 = 0;
            if (i2.f() != f.ANNOTATION_CLASS) {
            }
            i = 1;
            i2 = hVar;
        }
        if ((b0)i2 == 0) {
            obj7 = z0.getUpperBounds();
            n.e(obj7, str2);
            obj7 = p.X(obj7);
            n.e(obj7, "upperBounds.first()");
            i2 = obj7;
        }
        return i2;
    }

    public static final boolean g(b0 b0, b0 b02) {
        n.f(b0, "<this>");
        n.f(b02, "superType");
        return f.a.d(b0, b02);
    }

    public static final boolean h(h h) {
        Object obj1;
        n.f(h, "<this>");
        if (h instanceof z0 && obj1 instanceof y0) {
            obj1 = obj1 instanceof y0 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static final boolean i(b0 b0) {
        n.f(b0, "<this>");
        return c1.m(b0);
    }

    public static final b0 j(b0 b0) {
        n.f(b0, "<this>");
        final b0 obj1 = c1.n(b0);
        n.e(obj1, "makeNotNullable(this)");
        return obj1;
    }

    public static final b0 k(b0 b0) {
        n.f(b0, "<this>");
        final b0 obj1 = c1.o(b0);
        n.e(obj1, "makeNullable(this)");
        return obj1;
    }

    public static final b0 l(b0 b0, g g2) {
        boolean empty;
        n.f(b0, "<this>");
        n.f(g2, "newAnnotations");
        if (b0.getAnnotations().isEmpty() && g2.isEmpty()) {
            if (g2.isEmpty()) {
                return b0;
            }
        }
        return b0.O0().R0(g2);
    }

    public static final b0 m(b0 b0) {
        kotlin.i0.z.e.m0.l.i0 i0Var;
        g1 g1Var;
        int iterator;
        Object arrayList;
        kotlin.i0.z.e.m0.l.i0 empty;
        List parameters;
        boolean iterator2;
        List parameters2;
        boolean n0Var;
        ArrayList arrayList2;
        int next2;
        boolean next;
        n0 n0Var2;
        n.f(b0, "<this>");
        g1 obj10 = b0.O0();
        final int i = 2;
        iterator = 10;
        arrayList = "constructor.parameters";
        final int i4 = 0;
        if (obj10 instanceof v) {
            c0 c0Var = c0.a;
            g1 g1Var2 = obj10;
            empty = (v)g1Var2.T0();
            if (!empty.L0().getParameters().isEmpty()) {
                if (empty.L0().c() == null) {
                } else {
                    List parameters5 = empty.L0().getParameters();
                    n.e(parameters5, arrayList);
                    arrayList2 = new ArrayList(p.r(parameters5, iterator));
                    iterator2 = parameters5.iterator();
                    for (z0 next2 : iterator2) {
                        n0Var2 = new n0(next2);
                        arrayList2.add(n0Var2);
                    }
                    empty = z0.f(empty, arrayList2, i4, i, i4);
                }
            }
            i0Var = g1Var2.U0();
            if (!i0Var.L0().getParameters().isEmpty()) {
                if (i0Var.L0().c() == null) {
                } else {
                    parameters2 = i0Var.L0().getParameters();
                    n.e(parameters2, arrayList);
                    arrayList = new ArrayList(p.r(parameters2, iterator));
                    iterator = parameters2.iterator();
                    for (z0 parameters2 : iterator) {
                        arrayList2 = new n0(parameters2);
                        arrayList.add(arrayList2);
                    }
                    i0Var = z0.f(i0Var, arrayList, i4, i, i4);
                }
            }
            g1Var = c0.d(empty, i0Var);
            return e1.b(g1Var, obj10);
        } else {
            if (!obj10 instanceof i0) {
            } else {
                g1Var = obj10;
                if (!(i0)g1Var.L0().getParameters().isEmpty()) {
                    if (g1Var.L0().c() == null) {
                    } else {
                        parameters = g1Var.L0().getParameters();
                        n.e(parameters, arrayList);
                        arrayList = new ArrayList(p.r(parameters, iterator));
                        iterator = parameters.iterator();
                        for (z0 parameters : iterator) {
                            n0Var = new n0(parameters);
                            arrayList.add(n0Var);
                        }
                        g1Var = z0.f(g1Var, arrayList, i4, i, i4);
                    }
                }
            }
        }
        obj10 = new NoWhenBranchMatchedException();
        throw obj10;
    }

    public static final boolean n(b0 b0) {
        n.f(b0, "<this>");
        return a.b(b0, a.b.a);
    }
}
