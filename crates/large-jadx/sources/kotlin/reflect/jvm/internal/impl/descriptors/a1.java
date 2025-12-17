package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.t;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.j0.h;
import kotlin.j0.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class a1 {

    static final class a extends p implements l<kotlin.reflect.jvm.internal.impl.descriptors.m, Boolean> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.a1.a a;
        static {
            a1.a aVar = new a1.a();
            a1.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.m m) {
            n.f(m, "it");
            return m instanceof a;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((m)object));
        }
    }

    static final class b extends p implements l<kotlin.reflect.jvm.internal.impl.descriptors.m, Boolean> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.a1.b a;
        static {
            a1.b bVar = new a1.b();
            a1.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.m m) {
            n.f(m, "it");
            return obj2 ^= 1;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((m)object));
        }
    }

    static final class c extends p implements l<kotlin.reflect.jvm.internal.impl.descriptors.m, h<? extends kotlin.reflect.jvm.internal.impl.descriptors.z0>> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.a1.c a;
        static {
            a1.c cVar = new a1.c();
            a1.c.a = cVar;
        }

        c() {
            super(1);
        }

        public final h<kotlin.reflect.jvm.internal.impl.descriptors.z0> a(kotlin.reflect.jvm.internal.impl.descriptors.m m) {
            n.f(m, "it");
            List obj2 = (a)m.getTypeParameters();
            n.e(obj2, "it as CallableDescriptor).typeParameters");
            return p.M(obj2);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((m)object);
        }
    }
    public static final kotlin.reflect.jvm.internal.impl.descriptors.m0 a(b0 b0) {
        kotlin.reflect.jvm.internal.impl.descriptors.h hVar;
        n.f(b0, "<this>");
        if (hVar instanceof i) {
        } else {
            hVar = 0;
        }
        return a1.b(b0, hVar, 0);
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.m0 b(b0 b0, kotlin.reflect.jvm.internal.impl.descriptors.i i2, int i3) {
        int i;
        boolean z;
        int i4;
        i = 0;
        if (i2 != null) {
            if (t.r(i2)) {
            } else {
                size += i3;
                if (!i2.k() && i4 != b0.K0().size()) {
                    if (i4 != b0.K0().size()) {
                        i4 = d.E(i2);
                    }
                    m0 m0Var = new m0(i2, b0.K0().subList(i3, b0.K0().size()), i);
                    return m0Var;
                }
                final kotlin.reflect.jvm.internal.impl.descriptors.m mVar = i2.b();
                if (mVar instanceof i) {
                    i = mVar;
                }
            }
            m0 m0Var2 = new m0(i2, b0.K0().subList(i3, i4), a1.b(b0, i, i4));
            return m0Var2;
        }
        return i;
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.c c(kotlin.reflect.jvm.internal.impl.descriptors.z0 z0, kotlin.reflect.jvm.internal.impl.descriptors.m m2, int i3) {
        c cVar = new c(z0, m2, i3);
        return cVar;
    }

    public static final List<kotlin.reflect.jvm.internal.impl.descriptors.z0> d(kotlin.reflect.jvm.internal.impl.descriptors.i i) {
        boolean z2;
        Object iterator;
        boolean empty;
        int i2;
        Object next;
        int parameters;
        boolean z;
        n.f(i, "<this>");
        List list = i.t();
        String str2 = "declaredTypeParameters";
        n.e(list, str2);
        if (!i.k() && !mVar instanceof a) {
            if (!mVar instanceof a) {
                return list;
            }
        }
        List list3 = i.A(i.p(i.l(i.y(a.m(i), a1.a.a), a1.b.a), a1.c.a));
        iterator = a.m(i).iterator();
        for (Object next : iterator) {
        }
        next = parameters;
        if ((e)next == 0) {
        } else {
            iterator = (e)next.g();
            if (iterator == null) {
            } else {
                parameters = iterator.getParameters();
            }
        }
        if (parameters != 0) {
        } else {
            parameters = p.g();
        }
        if (list3.isEmpty() && parameters.isEmpty()) {
            if (parameters.isEmpty()) {
                List obj7 = i.t();
                n.e(obj7, str2);
                return obj7;
            }
        }
        List list2 = p.t0(list3, parameters);
        ArrayList arrayList = new ArrayList(p.r(list2, 10));
        Iterator iterator2 = list2.iterator();
        for (z0 next3 : iterator2) {
            n.e(next3, "it");
            arrayList.add(a1.c(next3, i, list.size()));
        }
        return p.t0(list, arrayList);
    }
}
