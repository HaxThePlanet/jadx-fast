package kotlin.i0.z.e.m0.d.a.j0;

import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.q.d;
import kotlin.i0.z.e.m0.d.a.y;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.j1.p;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.k;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class t {

    private static final kotlin.i0.z.e.m0.d.a.j0.b a;
    private static final kotlin.i0.z.e.m0.d.a.j0.b b;

    public class a {

        public static final int[] a;
        public static final int[] b;
        static {
            int[] iArr = new int[values.length];
            final int i = 1;
            iArr[f.READ_ONLY.ordinal()] = i;
            final int i2 = 2;
            iArr[f.MUTABLE.ordinal()] = i2;
            t.a.a = iArr;
            int[] iArr2 = new int[values2.length];
            iArr2[h.NULLABLE.ordinal()] = i;
            iArr2[h.NOT_NULL.ordinal()] = i2;
            t.a.b = iArr2;
        }
    }
    static {
        kotlin.i0.z.e.m0.f.b bVar3 = y.o;
        n.e(bVar3, "ENHANCED_NULLABILITY_ANNOTATION");
        b bVar = new b(bVar3);
        t.a = bVar;
        kotlin.i0.z.e.m0.f.b bVar4 = y.p;
        n.e(bVar4, "ENHANCED_MUTABILITY_ANNOTATION");
        b bVar2 = new b(bVar4);
        t.b = bVar2;
    }

    public static final g a(List list) {
        return t.d(list);
    }

    public static final kotlin.i0.z.e.m0.d.a.j0.c b(h h, kotlin.i0.z.e.m0.d.a.j0.e e2, kotlin.i0.z.e.m0.d.a.j0.p p3) {
        return t.e(h, e2, p3);
    }

    public static final kotlin.i0.z.e.m0.d.a.j0.c c(b0 b0, kotlin.i0.z.e.m0.d.a.j0.e e2, kotlin.i0.z.e.m0.d.a.j0.p p3) {
        return t.h(b0, e2, p3);
    }

    private static final g d(List<? extends g> list) {
        Object kVar;
        Object obj2;
        int size = list.size();
        if (size == 0) {
        } else {
            if (size != 1) {
                kVar = new k(p.L0(list));
            } else {
                kVar = obj2;
            }
            return kVar;
        }
        obj2 = new IllegalStateException("At least one Annotations object expected".toString());
        throw obj2;
    }

    private static final kotlin.i0.z.e.m0.d.a.j0.c<h> e(h h, kotlin.i0.z.e.m0.d.a.j0.e e2, kotlin.i0.z.e.m0.d.a.j0.p p3) {
        int[] iArr;
        int i;
        int obj3;
        kotlin.i0.z.e.m0.d.a.j0.p obj4;
        if (!q.a(p3)) {
            return t.j(h);
        }
        if (!h instanceof e) {
            return t.j(h);
        }
        d dVar = d.a;
        obj3 = e2.b();
        if (obj3 == null) {
            obj3 = -1;
        } else {
            obj3 = t.a.a[obj3.ordinal()];
        }
        if (obj3 != 1) {
            if (obj3 != 2) {
            } else {
                obj3 = h;
                if (p3 == p.FLEXIBLE_UPPER && dVar.e((e)obj3)) {
                    obj3 = h;
                    if (dVar.e((e)obj3)) {
                        return t.f(dVar.b(obj3));
                    }
                }
            }
        } else {
            obj3 = h;
            if (p3 == p.FLEXIBLE_LOWER && dVar.c((e)obj3)) {
                obj3 = h;
                if (dVar.c((e)obj3)) {
                    return t.f(dVar.a(obj3));
                }
            }
        }
        return t.j(h);
    }

    private static final <T> kotlin.i0.z.e.m0.d.a.j0.c<T> f(T t) {
        c cVar = new c(t, t.b);
        return cVar;
    }

    private static final <T> kotlin.i0.z.e.m0.d.a.j0.c<T> g(T t) {
        c cVar = new c(t, t.a);
        return cVar;
    }

    private static final kotlin.i0.z.e.m0.d.a.j0.c<Boolean> h(b0 b0, kotlin.i0.z.e.m0.d.a.j0.e e2, kotlin.i0.z.e.m0.d.a.j0.p p3) {
        kotlin.i0.z.e.m0.d.a.j0.c obj0;
        int obj1;
        boolean obj2;
        if (!q.a(p3)) {
            return t.j(Boolean.valueOf(b0.M0()));
        }
        obj1 = e2.c();
        if (obj1 == null) {
            obj1 = -1;
        } else {
            obj1 = t.a.b[obj1.ordinal()];
        }
        if (obj1 != 1) {
            if (obj1 != 2) {
                obj0 = t.j(Boolean.valueOf(b0.M0()));
            } else {
                obj0 = t.g(Boolean.FALSE);
            }
        } else {
            obj0 = t.g(Boolean.TRUE);
        }
        return obj0;
    }

    public static final boolean i(b0 b0) {
        n.f(b0, "<this>");
        return r.b(p.a, b0);
    }

    private static final <T> kotlin.i0.z.e.m0.d.a.j0.c<T> j(T t) {
        c cVar = new c(t, 0);
        return cVar;
    }
}
