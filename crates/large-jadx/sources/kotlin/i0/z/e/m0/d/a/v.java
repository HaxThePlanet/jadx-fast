package kotlin.i0.z.e.m0.d.a;

import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.d.b.j;
import kotlin.i0.z.e.m0.d.b.t;
import kotlin.i0.z.e.m0.i.e;
import kotlin.i0.z.e.m0.i.e.a;
import kotlin.i0.z.e.m0.i.e.b;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.p;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class v implements e {

    public static final kotlin.i0.z.e.m0.d.a.v.a a;

    public static final class a {
        public a(g g) {
            super();
        }

        private final boolean b(x x) {
            kotlin.reflect.jvm.internal.impl.descriptors.m mVar;
            int i2;
            int i;
            boolean obj6;
            final int i3 = 0;
            if (x.h().size() != 1) {
                return i3;
            }
            if (mVar instanceof e) {
            } else {
                mVar = i;
            }
            if (mVar == null) {
                return i3;
            }
            obj6 = x.h();
            n.e(obj6, "f.valueParameters");
            obj6 = (c1)p.z0(obj6).getType().L0().c();
            if (obj6 instanceof e) {
                i = obj6;
            }
            if (i == 0) {
                return i3;
            }
            if (h.x0(mVar) && n.b(a.i(mVar), a.i(i))) {
                if (n.b(a.i(mVar), a.i(i))) {
                } else {
                    i2 = i3;
                }
            } else {
            }
            return i2;
        }

        private final j c(x x, c1 c12) {
            j obj3;
            final String str = "valueParameterDescriptor.type";
            if (!t.e(x)) {
                if (b(x)) {
                    obj3 = c12.getType();
                    n.e(obj3, str);
                    obj3 = t.g(a.k(obj3));
                } else {
                    obj3 = c12.getType();
                    n.e(obj3, str);
                    obj3 = t.g(obj3);
                }
            } else {
            }
            return obj3;
        }

        public final boolean a(a a, a a2) {
            boolean iterator;
            boolean next;
            List list;
            String str3;
            String str;
            String str2;
            n.f(a, "superDescriptor");
            n.f(a2, "subDescriptor");
            if (a2 instanceof f) {
                if (!a instanceof x) {
                } else {
                    Object obj = a2;
                    int size = (f)obj.h().size();
                    int size2 = (x)a.h().size();
                    List list2 = obj.l1().h();
                    n.e(list2, "subDescriptor.original.valueParameters");
                    list = a.a().h();
                    n.e(list, "superDescriptor.original.valueParameters");
                    iterator = p.S0(list2, list).iterator();
                    for (o next2 : iterator) {
                        Object obj3 = next2.a();
                        Object obj2 = next2.b();
                        n.e((c1)obj3, "subParameter");
                        n.e((c1)obj2, "superParameter");
                    }
                }
            }
            return 0;
        }
    }
    static {
        v.a aVar = new v.a(0);
        v.a = aVar;
    }

    private final boolean c(a a, a a2, e e3) {
        boolean z2;
        Object str;
        kotlin.i0.z.e.m0.f.e name;
        int i2;
        boolean xVar;
        boolean z;
        int i3;
        int i;
        Boolean valueOf;
        int i4;
        Object obj7;
        Object obj8;
        boolean obj9;
        final int i5 = 0;
        if (a instanceof b && a2 instanceof x) {
            if (a2 instanceof x) {
                if (h.e0(a2)) {
                } else {
                    name = (x)a2.getName();
                    String str2 = "subDescriptor.name";
                    n.e(name, str2);
                    name = a2.getName();
                    n.e(name, str2);
                    if (!f.m.l(name) && !e.m.k(name)) {
                        name = a2.getName();
                        n.e(name, str2);
                        if (!e.m.k(name)) {
                            return i5;
                        }
                    }
                    str = b0.e((b)a);
                    z = a instanceof x;
                    i3 = 0;
                    if (z) {
                        i = a;
                    } else {
                        i = i3;
                    }
                    if (i == 0) {
                        valueOf = i3;
                    } else {
                        valueOf = Boolean.valueOf(i.v0());
                    }
                    i4 = 1;
                    if (z4 ^= i4 != 0 && str != null && !a2.v0()) {
                        if (str != null) {
                            if (!a2.v0()) {
                            }
                        }
                        return i4;
                    }
                    if (e3 instanceof d) {
                        if (a2.d0() != null) {
                        } else {
                            if (str != null) {
                                if (b0.f(e3, str)) {
                                } else {
                                    obj9 = 2;
                                    obj7 = (x)a.a();
                                    n.e(obj7, "superDescriptor.original");
                                    if (str instanceof x && z && f.k((x)str) != null && n.b(t.c(a2, i5, i5, obj9, i3), t.c(obj7, i5, i5, obj9, i3))) {
                                        if (z) {
                                            if (f.k((x)str) != null) {
                                                obj9 = 2;
                                                obj7 = (x)a.a();
                                                n.e(obj7, "superDescriptor.original");
                                                if (n.b(t.c(a2, i5, i5, obj9, i3), t.c(obj7, i5, i5, obj9, i3))) {
                                                    return i5;
                                                }
                                            }
                                        }
                                    }
                                }
                                return i4;
                            }
                        }
                    }
                }
            }
        }
        return i5;
    }

    @Override // kotlin.i0.z.e.m0.i.e
    public e.a a() {
        return e.a.CONFLICTS_ONLY;
    }

    @Override // kotlin.i0.z.e.m0.i.e
    public e.b b(a a, a a2, e e3) {
        n.f(a, "superDescriptor");
        n.f(a2, "subDescriptor");
        if (c(a, a2, e3)) {
            return e.b.INCOMPATIBLE;
        }
        if (v.a.a(a, a2)) {
            return e.b.INCOMPATIBLE;
        }
        return e.b.UNKNOWN;
    }
}
