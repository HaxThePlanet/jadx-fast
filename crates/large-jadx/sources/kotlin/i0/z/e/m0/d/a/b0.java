package kotlin.i0.z.e.m0.d.a;

import java.util.List;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.j1.t;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.n;

/* loaded from: classes3.dex */
public final class b0 {

    static final class a extends p implements l<b, Boolean> {

        public static final kotlin.i0.z.e.m0.d.a.b0.a a;
        static {
            b0.a aVar = new b0.a();
            b0.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(b b) {
            n.f(b, "it");
            return i.a.b(a.o(b));
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((b)object));
        }
    }

    static final class b extends p implements l<b, Boolean> {

        public static final kotlin.i0.z.e.m0.d.a.b0.b a;
        static {
            b0.b bVar = new b0.b();
            b0.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(b b) {
            n.f(b, "it");
            return e.m.l((t0)b);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((b)object));
        }
    }

    static final class c extends p implements l<b, Boolean> {

        public static final kotlin.i0.z.e.m0.d.a.b0.c a;
        static {
            b0.c cVar = new b0.c();
            b0.c.a = cVar;
        }

        c() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(b b) {
            boolean z;
            Object obj2;
            n.f(b, "it");
            z = f.m;
            if (h.e0(b) && f.m(b) != null) {
                z = f.m;
                obj2 = f.m(b) != null ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((b)object));
        }
    }
    public static final boolean a(b b) {
        int obj1;
        n.f(b, "<this>");
        obj1 = b0.d(b) != null ? 1 : 0;
        return obj1;
    }

    public static final String b(b b) {
        int i;
        boolean eVar;
        b obj2;
        n.f(b, "callableMemberDescriptor");
        obj2 = b0.c(b);
        i = 0;
        if (obj2 == null) {
            obj2 = i;
        } else {
            obj2 = a.o(obj2);
        }
        if (obj2 == null) {
            return i;
        }
        if (obj2 instanceof o0) {
            i = i.a.a(obj2);
        } else {
            if (obj2 instanceof t0) {
                obj2 = e.m.j((t0)obj2);
                if (obj2 == null) {
                } else {
                    i = obj2.c();
                }
            }
        }
        return i;
    }

    private static final b c(b b) {
        b obj1;
        if (h.e0(b)) {
            obj1 = b0.d(b);
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    public static final <T extends b> T d(T t) {
        boolean contains;
        boolean z;
        kotlin.i0.z.e.m0.d.a.b0.a aVar;
        b i;
        e name;
        n.f(t, "<this>");
        i = 0;
        if (!c0.a.f().contains(t.getName()) && !g.a.d().contains(a.o(t).getName())) {
            if (!g.a.d().contains(a.o(t).getName())) {
                return i;
            }
        }
        int i2 = 1;
        z = t instanceof o0 ? i2 : t instanceof n0;
        final int i3 = 0;
        if (z) {
            i = a.d(t, i3, b0.a.a, i2, i);
        } else {
            if (t instanceof t0) {
                i = a.d(t, i3, b0.b.a, i2, i);
            }
        }
        return i;
    }

    public static final <T extends b> T e(T t) {
        n.f(t, "<this>");
        b bVar = b0.d(t);
        e name = t.getName();
        n.e(name, "name");
        int i2 = 0;
        if (bVar == null && !f.m.l(name)) {
            name = t.getName();
            n.e(name, "name");
            i2 = 0;
            if (!f.m.l(name)) {
                return i2;
            }
            return a.d(t, false, b0.c.a, 1, i2);
        }
        return bVar;
    }

    public static final boolean f(e e, a a2) {
        String str;
        boolean z;
        int i;
        e obj3;
        n.f(e, "<this>");
        n.f(a2, "specialCallableDescriptor");
        kotlin.i0.z.e.m0.l.i0 obj4 = (e)a2.b().q();
        n.e(obj4, "specialCallableDescriptor.containingDeclaration as ClassDescriptor).defaultType");
        obj3 = d.s(e);
        while (obj3 != null) {
            obj3 = d.s(obj3);
            i = 1;
            if (t.b(obj3.q(), obj4) != null) {
            }
            str = i;
        }
        return 0;
    }

    public static final boolean g(b b) {
        n.f(b, "<this>");
        return obj1 instanceof d;
    }

    public static final boolean h(b b) {
        int obj1;
        n.f(b, "<this>");
        if (!b0.g(b)) {
            if (h.e0(b)) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }
}
