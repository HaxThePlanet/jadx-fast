package kotlin.i0.z.e.m0.i;

import android.app.ActivityManager.MemoryInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.d0;
import kotlin.i0.z.e.m0.l.j1.a;
import kotlin.i0.z.e.m0.l.j1.f;
import kotlin.i0.z.e.m0.l.j1.f.a;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.j1.g.a;
import kotlin.i0.z.e.m0.l.j1.m;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.y;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.a0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.p;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.utils.j;
import kotlin.w;
import kotlin.y.p;

/* loaded from: classes3.dex */
public class j {

    private static final List<kotlin.i0.z.e.m0.i.e> c;
    public static final kotlin.i0.z.e.m0.i.j d;
    private static final f.a e;
    private final g a;
    private final f.a b;

    static class h {

        static final int[] a;
        static final int[] b;
        static final int[] c;
        static {
            int[] iArr = new int[values.length];
            j.h.c = iArr;
            int i2 = 1;
            iArr[z.FINAL.ordinal()] = i2;
            int i = 2;
            j.h.c[z.SEALED.ordinal()] = i;
            int i3 = 3;
            j.h.c[z.OPEN.ordinal()] = i3;
            int i4 = 4;
            j.h.c[z.ABSTRACT.ordinal()] = i4;
            int[] iArr8 = new int[values2.length];
            j.h.b = iArr8;
            iArr8[j.i.a.OVERRIDABLE.ordinal()] = i2;
            j.h.b[j.i.a.CONFLICT.ordinal()] = i;
            j.h.b[j.i.a.INCOMPATIBLE.ordinal()] = i3;
            int[] iArr11 = new int[values3.length];
            j.h.a = iArr11;
            iArr11[e.b.OVERRIDABLE.ordinal()] = i2;
            j.h.a[e.b.CONFLICT.ordinal()] = i;
            j.h.a[e.b.INCOMPATIBLE.ordinal()] = i3;
            j.h.a[e.b.UNKNOWN.ordinal()] = i4;
        }
    }

    public static class i {

        private static final kotlin.i0.z.e.m0.i.j.i b;
        private final kotlin.i0.z.e.m0.i.j.i.a a;
        static {
            j.i iVar = new j.i(j.i.a.OVERRIDABLE, "SUCCESS");
            j.i.b = iVar;
        }

        public i(kotlin.i0.z.e.m0.i.j.i.a j$i$a, String string2) {
            final int i = 0;
            if (a == null) {
            } else {
                if (string2 == null) {
                } else {
                    super();
                    this.a = a;
                }
                j.i.a(4);
                throw i;
            }
            j.i.a(3);
            throw i;
        }

        private static void a(int i) {
            String str;
            int i2;
            String str3;
            String str2;
            Object obj10;
            final int i3 = 4;
            final int i4 = 3;
            final int i5 = 2;
            final int i6 = 1;
            if (i != i6 && i != i5 && i != i4 && i != i3) {
                if (i != i5) {
                    if (i != i4) {
                        str = i != i3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    } else {
                    }
                } else {
                }
            } else {
            }
            if (i != i6 && i != i5 && i != i4 && i != i3) {
                if (i != i5) {
                    if (i != i4) {
                        i2 = i != i3 ? i5 : i4;
                    } else {
                    }
                } else {
                }
            } else {
            }
            Object[] arr = new Object[i2];
            str3 = "success";
            final String str4 = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
            final int i7 = 0;
            if (i != i6 && i != i5) {
                if (i != i5) {
                    if (i != i4) {
                        if (i != i3) {
                            arr[i7] = str4;
                        } else {
                            arr[i7] = "debugMessage";
                        }
                    } else {
                        arr[i7] = str3;
                    }
                } else {
                }
            } else {
            }
            switch (i) {
                case 1:
                    arr[i6] = str4;
                    break;
                case 2:
                    arr[i6] = "getResult";
                    break;
                case 3:
                    arr[i6] = "getDebugMessage";
                    break;
                default:
                    arr[i6] = str3;
            }
            if (i != i6) {
                if (i != i5) {
                    if (i != i4 && i != i3) {
                        if (i != i3) {
                        } else {
                            arr[i5] = "<init>";
                        }
                    } else {
                    }
                } else {
                    arr[i5] = "conflict";
                }
            } else {
                arr[i5] = "incompatible";
            }
            String format = String.format(str, arr);
            if (i != i6 && i != i5 && i != i4 && i != i3) {
                if (i != i5) {
                    if (i != i4) {
                        if (i != i3) {
                            obj10 = new IllegalStateException(format);
                        } else {
                            obj10 = new IllegalArgumentException(format);
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            throw obj10;
        }

        public static kotlin.i0.z.e.m0.i.j.i b(String string) {
            if (string == null) {
            } else {
                j.i iVar = new j.i(j.i.a.CONFLICT, string);
                return iVar;
            }
            j.i.a(2);
            throw 0;
        }

        public static kotlin.i0.z.e.m0.i.j.i d(String string) {
            if (string == null) {
            } else {
                j.i iVar = new j.i(j.i.a.INCOMPATIBLE, string);
                return iVar;
            }
            j.i.a(1);
            throw 0;
        }

        public static kotlin.i0.z.e.m0.i.j.i e() {
            kotlin.i0.z.e.m0.i.j.i iVar = j.i.b;
            if (iVar == null) {
            } else {
                return iVar;
            }
            j.i.a(0);
            throw 0;
        }

        public kotlin.i0.z.e.m0.i.j.i.a c() {
            kotlin.i0.z.e.m0.i.j.i.a aVar = this.a;
            if (aVar == null) {
            } else {
                return aVar;
            }
            j.i.a(5);
            throw 0;
        }
    }

    static class a implements f.a {
        private static void b(int i) {
            String obj3;
            Object[] arr = new Object[3];
            int i3 = 0;
            final int i4 = 1;
            if (i != i4) {
                arr[i3] = "a";
            } else {
                arr[i3] = "b";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            arr[2] = "equals";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        @Override // kotlin.i0.z.e.m0.l.j1.f$a
        public boolean a(t0 t0, t0 t02) {
            final int i = 0;
            if (t0 == null) {
            } else {
                if (t02 == null) {
                } else {
                    return t0.equals(t02);
                }
                j.a.b(1);
                throw i;
            }
            j.a.b(0);
            throw i;
        }
    }

    static class b implements p<D, D, o<a, a>> {
        public o<a, a> a(D d, D d2) {
            o oVar = new o(d, d2);
            return oVar;
        }

        @Override // kotlin.d0.c.p
        public Object invoke(Object object, Object object2) {
            return a((a)object, (a)object2);
        }
    }

    static class c implements l<b, Boolean> {

        final m a;
        c(m m) {
            this.a = m;
            super();
        }

        @Override // kotlin.d0.c.l
        public Boolean a(b b) {
            int obj2;
            obj2 = b.b() == this.a ? 1 : 0;
            return Boolean.valueOf(obj2);
        }

        @Override // kotlin.d0.c.l
        public Object invoke(Object object) {
            return a((b)object);
        }
    }

    static class d implements l<b, a> {
        @Override // kotlin.d0.c.l
        public b a(b b) {
            return b;
        }

        @Override // kotlin.d0.c.l
        public Object invoke(Object object) {
            a((b)object);
            return object;
        }
    }

    static class e implements l<b, Boolean> {

        final e a;
        e(e e) {
            this.a = e;
            super();
        }

        @Override // kotlin.d0.c.l
        public Boolean a(b b) {
            boolean z;
            q obj2;
            if (!t.g(b.getVisibility()) && t.h(b, this.a)) {
                obj2 = t.h(b, this.a) ? 1 : 0;
            } else {
            }
            return Boolean.valueOf(obj2);
        }

        @Override // kotlin.d0.c.l
        public Object invoke(Object object) {
            return a((b)object);
        }
    }

    static class f implements l<b, a> {
        @Override // kotlin.d0.c.l
        public a a(b b) {
            return b;
        }

        @Override // kotlin.d0.c.l
        public Object invoke(Object object) {
            a((b)object);
            return object;
        }
    }

    static class g implements l<b, w> {

        final kotlin.i0.z.e.m0.i.i a;
        final b b;
        g(kotlin.i0.z.e.m0.i.i i, b b2) {
            this.a = i;
            this.b = b2;
            super();
        }

        @Override // kotlin.d0.c.l
        public w a(b b) {
            this.a.b(this.b, b);
            return w.a;
        }

        @Override // kotlin.d0.c.l
        public Object invoke(Object object) {
            return a((b)object);
        }
    }

    private class j extends a {

        private final Map<t0, t0> j;
        final kotlin.i0.z.e.m0.i.j k;
        public j(kotlin.i0.z.e.m0.i.j j, Map map2) {
            this.k = j;
            final int i = 1;
            super(i, i, i, j.b(j));
            this.j = map2;
        }

        private static void I0(int i) {
            String str;
            String obj5;
            int i2 = 3;
            final Object[] arr = new Object[i2];
            int i3 = 0;
            final int i5 = 1;
            if (i != i5 && i != i2) {
                if (i != i2) {
                    arr[i3] = "a";
                } else {
                    arr[i3] = "b";
                }
            } else {
            }
            arr[i5] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverridingUtilTypeCheckerContext";
            int i4 = 2;
            if (i != i4 && i != i2) {
                if (i != i2) {
                    arr[i4] = "areEqualTypeConstructors";
                } else {
                    arr[i4] = "areEqualTypeConstructorsByAxioms";
                }
            } else {
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        private boolean J0(t0 t0, t0 t02) {
            int i;
            t0 obj5;
            boolean obj6;
            int i2 = 0;
            if (t0 == null) {
            } else {
                if (t02 == null) {
                } else {
                    if (j.c(this.k).a(t0, t02)) {
                        return 1;
                    }
                    Map map = this.j;
                    final int i3 = 0;
                    if (map == null) {
                        return i3;
                    }
                    Object obj = map.get(t0);
                    Object obj2 = this.j.get(t02);
                    if ((t0)obj != null) {
                        if (!(t0)obj.equals(t02)) {
                            if (obj2 != null && (t0)obj2.equals(t0)) {
                                if (obj2.equals(t0)) {
                                } else {
                                    i = i3;
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                    return i;
                }
                j.j.I0(3);
                throw i2;
            }
            j.j.I0(2);
            throw i2;
        }

        @Override // kotlin.i0.z.e.m0.l.j1.a
        public boolean G0(t0 t0, t0 t02) {
            int i;
            boolean obj4;
            int i2 = 0;
            if (t0 == null) {
            } else {
                final int i3 = 1;
                if (t02 == null) {
                } else {
                    if (!super.G0(t0, t02)) {
                        if (J0(t0, t02)) {
                            i = i3;
                        }
                    } else {
                    }
                    return i;
                }
                j.j.I0(i3);
                throw i2;
            }
            j.j.I0(0);
            throw i2;
        }
    }
    static {
        Class<kotlin.i0.z.e.m0.i.e> obj = e.class;
        j.c = p.L0(ServiceLoader.load(obj, obj.getClassLoader()));
        j.a aVar = new j.a();
        j.e = aVar;
        j jVar = new j(aVar, g.a.a);
        j.d = jVar;
    }

    private j(f.a f$a, g g2) {
        final int i = 0;
        if (a == null) {
        } else {
            if (g2 == null) {
            } else {
                super();
                this.b = a;
                this.a = g2;
            }
            j.a(5);
            throw i;
        }
        j.a(4);
        throw i;
    }

    public static kotlin.i0.z.e.m0.i.j.i.a A(a a, a a2) {
        kotlin.i0.z.e.m0.i.j.i.a obj4;
        final kotlin.i0.z.e.m0.i.j jVar = j.d;
        final int i = 0;
        kotlin.i0.z.e.m0.i.j.i.a aVar = jVar.G(a2, a, i).c();
        kotlin.i0.z.e.m0.i.j.i.a obj3 = jVar.G(a, a2, i).c();
        obj4 = j.i.a.OVERRIDABLE;
        if (aVar == obj4 && obj3 == obj4) {
            if (obj3 == obj4) {
            } else {
                obj4 = j.i.a.CONFLICT;
                if (aVar != obj4) {
                    if (obj3 == obj4) {
                    } else {
                        obj4 = j.i.a.INCOMPATIBLE;
                    }
                }
            }
        } else {
        }
        return obj4;
    }

    private static z B(Collection<b> collection, boolean z2, z z3) {
        z aBSTRACT;
        z zVar;
        int compareTo;
        z aBSTRACT2;
        final int i = 0;
        if (collection == null) {
        } else {
            if (z3 == null) {
            } else {
                aBSTRACT = z.ABSTRACT;
                Iterator obj5 = collection.iterator();
                while (obj5.hasNext()) {
                    Object next2 = obj5.next();
                    if (z2 && (b)next2.i() == z.ABSTRACT) {
                    } else {
                    }
                    zVar = next2.i();
                    if (zVar.compareTo(aBSTRACT) < 0) {
                    }
                    aBSTRACT = zVar;
                    if (next2.i() == z.ABSTRACT) {
                    } else {
                    }
                    zVar = z3;
                }
                if (aBSTRACT == null) {
                } else {
                    return aBSTRACT;
                }
                j.a(93);
                throw i;
            }
            j.a(92);
            throw i;
        }
        j.a(91);
        throw i;
    }

    public static Set<b> C(b b) {
        if (b == null) {
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            j.h(b, linkedHashSet);
            return linkedHashSet;
        }
        j.a(13);
        throw 0;
    }

    private static boolean D(n0 n0, n0 n02) {
        if (n0 != null && n02 == null) {
            if (n02 == null) {
            }
            return j.K(n0, n02);
        }
        return 1;
    }

    public static boolean E(a a, a a2) {
        int i;
        boolean z;
        boolean z2;
        boolean obj8;
        int i2 = 0;
        if (a == null) {
        } else {
            if (a2 == null) {
            } else {
                b0 returnType = a.getReturnType();
                b0 returnType2 = a2.getReturnType();
                i = 0;
                if (!j.K(a, a2)) {
                    return i;
                }
                o oVar = j.d.n(a.getTypeParameters(), a2.getTypeParameters());
                if (a instanceof x) {
                    return j.J(a, returnType, a2, returnType2, oVar);
                }
                if (!a instanceof o0) {
                } else {
                    q qVar = a;
                    q qVar2 = a2;
                    if (!j.D((o0)qVar.getSetter(), (o0)qVar2.getSetter())) {
                        return i;
                    }
                    if (qVar.j0() && qVar2.j0()) {
                        if (qVar2.j0()) {
                            return (m)oVar.c().e((a)oVar.d(), returnType.O0(), returnType2.O0());
                        }
                    }
                    if (!qVar.j0()) {
                        if (!qVar2.j0() && j.J(a, returnType, a2, returnType2, oVar)) {
                            if (j.J(a, returnType, a2, returnType2, oVar)) {
                                i = 1;
                            }
                        }
                    } else {
                    }
                    return i;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected callable: ");
                stringBuilder.append(a.getClass());
                IllegalArgumentException obj9 = new IllegalArgumentException(stringBuilder.toString());
                throw obj9;
            }
            j.a(66);
            throw i2;
        }
        j.a(65);
        throw i2;
    }

    private static boolean F(a a, Collection<a> collection2) {
        int i;
        i = 0;
        if (a == null) {
        } else {
            if (collection2 == null) {
            } else {
                final Iterator obj2 = collection2.iterator();
                for (a next2 : obj2) {
                }
                return 1;
            }
            j.a(70);
            throw i;
        }
        j.a(69);
        throw i;
    }

    private static boolean J(a a, b0 b02, a a3, b0 b04, o<m, a> o5) {
        final int i = 0;
        if (a == null) {
        } else {
            if (b02 == null) {
            } else {
                if (a3 == null) {
                } else {
                    if (b04 == null) {
                    } else {
                        if (o5 == null) {
                        } else {
                            return (m)o5.c().f((a)o5.d(), b02.O0(), b04.O0());
                        }
                        j.a(75);
                        throw i;
                    }
                    j.a(74);
                    throw i;
                }
                j.a(73);
                throw i;
            }
            j.a(72);
            throw i;
        }
        j.a(71);
        throw i;
    }

    private static boolean K(q q, q q2) {
        int obj1;
        final int i = 0;
        if (q == null) {
        } else {
            if (q2 == null) {
            } else {
                obj1 = t.d(q.getVisibility(), q2.getVisibility());
                if (obj1 != null) {
                    if (obj1.intValue() >= 0) {
                        obj1 = 1;
                    } else {
                        obj1 = 0;
                    }
                } else {
                }
                return obj1;
            }
            j.a(68);
            throw i;
        }
        j.a(67);
        throw i;
    }

    public static boolean L(y y, y y2) {
        int obj1;
        int i = 0;
        if (y == null) {
        } else {
            if (y2 == null) {
            } else {
                if (!t.g(y2.getVisibility()) && t.h(y2, y)) {
                    obj1 = t.h(y2, y) ? 1 : 0;
                } else {
                }
                return obj1;
            }
            j.a(56);
            throw i;
        }
        j.a(55);
        throw i;
    }

    public static <D extends a> boolean M(D d, D d2, boolean z3, boolean z4) {
        boolean equals;
        a aVar2;
        a aVar;
        int i = 0;
        if (d == null) {
        } else {
            if (d2 == null) {
            } else {
                final int i2 = 1;
                if (!d.equals(d2) && b.a.e(d.a(), d2.a(), z3, z4)) {
                    if (b.a.e(d.a(), d2.a(), z3, z4)) {
                        return i2;
                    }
                }
                Iterator obj4 = d.d(d).iterator();
                for (a next2 : obj4) {
                }
                return 0;
            }
            j.a(12);
            throw i;
        }
        j.a(11);
        throw i;
    }

    public static void N(b b, l<b, w> l2) {
        Object next2;
        u next;
        u visibility;
        b bVar;
        u uVar;
        Object obj5;
        l obj6;
        final int i = 0;
        if (b == null) {
        } else {
            Iterator iterator = b.e().iterator();
            while (iterator.hasNext()) {
                next2 = iterator.next();
                if ((b)next2.getVisibility() == t.g) {
                }
                j.N(next2, l2);
            }
            if (b.getVisibility() != t.g) {
            }
            u uVar2 = j.j(b);
            if (uVar2 == null) {
                if (l2 != null) {
                    l2.invoke(b);
                }
                next = t.e;
            } else {
                next = uVar2;
            }
            if (b instanceof b0) {
                (b0)b.Z0(next);
                obj5 = (o0)b.u().iterator();
                while (obj5.hasNext()) {
                    if (uVar2 == null) {
                    } else {
                    }
                    bVar = l2;
                    j.N((n0)obj5.next(), bVar);
                    bVar = i;
                }
            } else {
                if (b instanceof p) {
                    (p)b.i1(next);
                } else {
                    (a0)b.N0(next);
                    if (next != b.y0().getVisibility()) {
                        b.L0(false);
                    }
                }
            }
        }
        j.a(105);
        throw i;
    }

    public static <H> H O(Collection<H> collection, l<H, a> l2) {
        int next;
        List list;
        Object obj;
        Object next2;
        Object invoke;
        boolean z;
        final int i = 0;
        if (collection == null) {
        } else {
            if (l2 == null) {
            } else {
                next = 1;
                if (collection.size() == next) {
                    Object obj9 = p.W(collection);
                    if (obj9 == null) {
                    } else {
                        return obj9;
                    }
                    j.a(78);
                    throw i;
                }
                ArrayList arrayList = new ArrayList(2);
                final Object invoke3 = l2.invoke(p.W(collection));
                obj9 = collection.iterator();
                while (obj9.hasNext()) {
                    next2 = obj9.next();
                    invoke = l2.invoke(next2);
                    if (j.F((a)invoke, p.m0(collection, l2))) {
                    }
                    if (j.E(invoke, (a)invoke3) && !j.E(invoke3, invoke)) {
                    }
                    if (!j.E(invoke3, invoke)) {
                    }
                    obj = next2;
                    arrayList.add(next2);
                }
                if (arrayList.isEmpty()) {
                    if (obj == null) {
                    } else {
                        return obj;
                    }
                    j.a(79);
                    throw i;
                }
                if (arrayList.size() == next) {
                    obj9 = p.W(arrayList);
                    if (obj9 == null) {
                    } else {
                        return obj9;
                    }
                    j.a(80);
                    throw i;
                }
                obj9 = arrayList.iterator();
                for (Object next : obj9) {
                }
                next = i;
                if (next != 0) {
                    if (next == 0) {
                    } else {
                        return next;
                    }
                    j.a(81);
                    throw i;
                }
                obj9 = p.W(arrayList);
                if (obj9 == null) {
                } else {
                    return obj9;
                }
                j.a(82);
                throw i;
            }
            j.a(77);
            throw i;
        }
        j.a(76);
        throw i;
    }

    private static void a(int i) {
        Object illegalStateException;
        String str3;
        int i2;
        String str;
        String str2;
        int i3 = i;
        final int i4 = 101;
        final int i5 = 96;
        final int i6 = 93;
        final int i7 = 19;
        final int i8 = 14;
        final int i9 = 10;
        final int i10 = 9;
        if (i3 != i10 && i3 != i9 && i3 != i8 && i3 != i7 && i3 != i6 && i3 != i5 && i3 != i4) {
            if (i3 != i9) {
                if (i3 != i8) {
                    if (i3 != i7) {
                        if (i3 != i6) {
                            if (i3 != i5) {
                                if (i3 != i4) {
                                    if (/* condition */) {
                                        str3 = "@NotNull method %s.%s must not return null";
                                    } else {
                                        if (/* condition */) {
                                        } else {
                                            if (/* condition */) {
                                            } else {
                                                if (/* condition */) {
                                                } else {
                                                    str3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                                }
                                            }
                                        }
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        final int i11 = 2;
        if (i3 != i10 && i3 != i9 && i3 != i8 && i3 != i7 && i3 != i6 && i3 != i5 && i3 != i4) {
            if (i3 != i9) {
                if (i3 != i8) {
                    if (i3 != i7) {
                        if (i3 != i6) {
                            if (i3 != i5) {
                                if (i3 != i4) {
                                    if (/* condition */) {
                                        i2 = i11;
                                    } else {
                                        if (/* condition */) {
                                        } else {
                                            if (/* condition */) {
                                            } else {
                                                if (/* condition */) {
                                                } else {
                                                    i2 = 3;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        str = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
        int i12 = 0;
        switch (i3) {
            case 1:
                arr[i12] = "kotlinTypeRefiner";
                break;
            case 2:
                arr[i12] = "equalityAxioms";
                break;
            case 3:
                arr[i12] = "axioms";
                break;
            case 4:
                arr[i12] = "candidateSet";
                break;
            case 5:
                arr[i12] = "transformFirst";
                break;
            case 6:
                arr[i12] = str;
                break;
            case 7:
                arr[i12] = "f";
                break;
            case 8:
                arr[i12] = "g";
                break;
            case 9:
                arr[i12] = "descriptor";
                break;
            case 10:
                arr[i12] = "result";
                break;
            case 11:
                arr[i12] = "superDescriptor";
                break;
            case 12:
                arr[i12] = "subDescriptor";
                break;
            case 13:
                arr[i12] = "firstParameters";
                break;
            case 14:
                arr[i12] = "secondParameters";
                break;
            case 15:
                arr[i12] = "typeInSuper";
                break;
            case 16:
                arr[i12] = "typeInSub";
                break;
            case 17:
                arr[i12] = "typeChecker";
                break;
            case 18:
                arr[i12] = "superTypeParameter";
                break;
            case 19:
                arr[i12] = "subTypeParameter";
                break;
            case 20:
                arr[i12] = "name";
                break;
            case 21:
                arr[i12] = "membersFromSupertypes";
                break;
            case 22:
                arr[i12] = "membersFromCurrent";
                break;
            case 23:
                arr[i12] = "current";
                break;
            case 24:
                arr[i12] = "strategy";
                break;
            case 25:
                arr[i12] = "overriding";
                break;
            case 26:
                arr[i12] = "fromSuper";
                break;
            case 27:
                arr[i12] = "fromCurrent";
                break;
            case 28:
                arr[i12] = "descriptorsFromSuper";
                break;
            case 29:
                arr[i12] = "notOverridden";
                break;
            case 30:
                arr[i12] = "a";
                break;
            case 31:
                arr[i12] = "b";
                break;
            case 32:
                arr[i12] = "candidate";
                break;
            case 33:
                arr[i12] = "descriptors";
                break;
            case 34:
                arr[i12] = "aReturnType";
                break;
            case 35:
                arr[i12] = "bReturnType";
                break;
            case 36:
                arr[i12] = "overridables";
                break;
            case 37:
                arr[i12] = "descriptorByHandle";
                break;
            case 38:
                arr[i12] = "classModality";
                break;
            case 39:
                arr[i12] = "toFilter";
                break;
            case 40:
                arr[i12] = "overrider";
                break;
            case 41:
                arr[i12] = "extractFrom";
                break;
            case 42:
                arr[i12] = "onConflict";
                break;
            default:
                arr[i12] = "memberDescriptor";
        }
        String str4 = "extractMembersOverridableInBothWays";
        String str5 = "filterVisibleFakeOverrides";
        final String str6 = "getMinimalModality";
        final String str7 = "determineModalityForFakeOverride";
        final String str8 = "selectMostSpecificMember";
        final String str9 = "isOverridableByWithoutExternalConditions";
        final String str10 = "isOverridableBy";
        final String str11 = "getOverriddenDeclarations";
        final String str12 = "filterOverrides";
        final int i13 = 1;
        if (i3 != i10 && i3 != i9) {
            if (i3 != i9) {
                if (i3 != i8) {
                    if (i3 != i7) {
                        if (i3 != i6) {
                            if (i3 != i5) {
                                if (i3 != i4) {
                                    if (/* condition */) {
                                        arr[i13] = str10;
                                    } else {
                                        if (/* condition */) {
                                            arr[i13] = str9;
                                        } else {
                                            if (/* condition */) {
                                                arr[i13] = str8;
                                            } else {
                                                if (/* condition */) {
                                                    arr[i13] = str7;
                                                } else {
                                                    arr[i13] = str;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    arr[i13] = str4;
                                }
                            } else {
                                arr[i13] = str5;
                            }
                        } else {
                            arr[i13] = str6;
                        }
                    } else {
                    }
                } else {
                    arr[i13] = str11;
                }
            } else {
                arr[i13] = str12;
            }
        } else {
        }
        switch (i3) {
            case 1:
                arr[i11] = "createWithTypeRefiner";
                break;
            case 2:
                arr[i11] = "create";
                break;
            case 3:
                arr[i11] = "<init>";
                break;
            case 4:
                arr[i11] = "filterOutOverridden";
                break;
            case 5:
                arr[i11] = str12;
                break;
            case 7:
                arr[i11] = "overrides";
                break;
            case 8:
                arr[i11] = str11;
                break;
            case 9:
                arr[i11] = "collectOverriddenDeclarations";
                break;
            case 10:
                arr[i11] = str10;
                break;
            case 11:
                arr[i11] = str9;
                break;
            case 12:
                arr[i11] = "getBasicOverridabilityProblem";
                break;
            case 13:
                arr[i11] = "createTypeChecker";
                break;
            case 14:
                arr[i11] = "createTypeCheckerContext";
                break;
            case 15:
                arr[i11] = "areTypesEquivalent";
                break;
            case 16:
                arr[i11] = "areTypeParametersEquivalent";
                break;
            case 17:
                arr[i11] = "generateOverridesInFunctionGroup";
                break;
            case 18:
                arr[i11] = "isVisibleForOverride";
                break;
            case 19:
                arr[i11] = "extractAndBindOverridesForMember";
                break;
            case 20:
                arr[i11] = "allHasSameContainingDeclaration";
                break;
            case 21:
                arr[i11] = "createAndBindFakeOverrides";
                break;
            case 22:
                arr[i11] = "isMoreSpecific";
                break;
            case 23:
                arr[i11] = "isVisibilityMoreSpecific";
                break;
            case 24:
                arr[i11] = "isMoreSpecificThenAllOf";
                break;
            case 25:
                arr[i11] = "isReturnTypeMoreSpecific";
                break;
            case 26:
                arr[i11] = str8;
                break;
            case 27:
                arr[i11] = "createAndBindFakeOverride";
                break;
            case 28:
                arr[i11] = str7;
                break;
            case 29:
                arr[i11] = str6;
                break;
            case 30:
                arr[i11] = str5;
                break;
            case 31:
                arr[i11] = str4;
                break;
            case 32:
                arr[i11] = "resolveUnknownVisibilityForMember";
                break;
            case 33:
                arr[i11] = "computeVisibilityToInherit";
                break;
            case 34:
                arr[i11] = "findMaxVisibility";
                break;
            default:
                arr[i11] = "createWithEqualityAxioms";
        }
        String format = String.format(str3, arr);
        if (i3 != i10 && i3 != i9 && i3 != i8 && i3 != i7 && i3 != i6 && i3 != i5 && i3 != i4) {
            if (i3 != i9) {
                if (i3 != i8) {
                    if (i3 != i7) {
                        if (i3 != i6) {
                            if (i3 != i5) {
                                if (i3 != i4) {
                                    if (/* condition */) {
                                        illegalStateException = new IllegalStateException(format);
                                    } else {
                                        if (/* condition */) {
                                        } else {
                                            if (/* condition */) {
                                            } else {
                                                if (/* condition */) {
                                                } else {
                                                    illegalStateException = new IllegalArgumentException(format);
                                                }
                                            }
                                        }
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        throw illegalStateException;
    }

    static g b(kotlin.i0.z.e.m0.i.j j) {
        return j.a;
    }

    static f.a c(kotlin.i0.z.e.m0.i.j j) {
        return j.b;
    }

    private static boolean d(Collection<b> collection) {
        if (collection == null) {
        } else {
            if (collection.size() < 2) {
                return 1;
            }
            j.c cVar = new j.c((b)collection.iterator().next().b());
            return p.L(collection, cVar);
        }
        j.a(61);
        throw 0;
    }

    private boolean e(z0 z0, z0 z02, o<m, a> o3) {
        int listIterator;
        boolean z;
        int obj6;
        int i = 0;
        if (z0 == null) {
        } else {
            if (z02 == null) {
            } else {
                if (o3 == null) {
                } else {
                    List obj5 = z0.getUpperBounds();
                    ArrayList arrayList = new ArrayList(z02.getUpperBounds());
                    final int i2 = 0;
                    if (obj5.size() != arrayList.size()) {
                        return i2;
                    }
                    obj5 = obj5.iterator();
                    for (b0 obj6 : obj5) {
                        listIterator = arrayList.listIterator();
                        for (b0 next2 : listIterator) {
                        }
                        listIterator.remove();
                    }
                    return 1;
                }
                j.a(49);
                throw i;
            }
            j.a(48);
            throw i;
        }
        j.a(47);
        throw i;
    }

    private boolean f(b0 b0, b0 b02, o<m, a> o3) {
        int i;
        boolean z;
        int i2 = 0;
        if (b0 == null) {
        } else {
            if (b02 == null) {
            } else {
                if (o3 == null) {
                } else {
                    final int i3 = 1;
                    if (d0.a(b0) && d0.a(b02)) {
                        i = d0.a(b02) ? i3 : 0;
                    } else {
                    }
                    if (i != 0) {
                        return i3;
                    }
                    return (m)o3.c().e((a)o3.d(), b0.O0(), b02.O0());
                }
                j.a(46);
                throw i2;
            }
            j.a(45);
            throw i2;
        }
        j.a(44);
        throw i2;
    }

    private static kotlin.i0.z.e.m0.i.j.i g(a a, a a2) {
        int i;
        int i2;
        final int i3 = 0;
        i = a.m0() == null ? i2 : i3;
        if (a2.m0() == null) {
        } else {
            i2 = i3;
        }
        if (i != i2) {
            return j.i.d("Receiver presence mismatch");
        }
        if (a.h().size() != a2.h().size()) {
            return j.i.d("Value parameter number mismatch");
        }
        return null;
    }

    private static void h(b b, Set<b> set2) {
        boolean real;
        boolean empty;
        Object obj2;
        int i = 0;
        if (b == null) {
        } else {
            if (set2 == null) {
            } else {
                if (b.f().isReal()) {
                    set2.add(b);
                } else {
                    if (b.e().isEmpty()) {
                    } else {
                        obj2 = b.e().iterator();
                        for (b empty : obj2) {
                            j.h(empty, set2);
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No overridden descriptors found for (fake override) ");
                stringBuilder.append(b);
                IllegalStateException obj3 = new IllegalStateException(stringBuilder.toString());
                throw obj3;
            }
            j.a(16);
            throw i;
        }
        j.a(15);
        throw i;
    }

    private static List<b0> i(a a) {
        Object type;
        type = a.m0();
        ArrayList arrayList = new ArrayList();
        if (type != null) {
            arrayList.add(type.getType());
        }
        Iterator obj2 = a.h().iterator();
        for (c1 next2 : obj2) {
            arrayList.add(next2.getType());
        }
        return arrayList;
    }

    private static u j(b b) {
        Collection equals;
        b.a fAKE_OVERRIDE;
        z aBSTRACT;
        final int i = 0;
        if (b == null) {
        } else {
            equals = b.e();
            final u uVar = j.x(equals);
            if (uVar == null) {
                return i;
            }
            if (b.f() == b.a.FAKE_OVERRIDE) {
                Iterator obj5 = equals.iterator();
                for (b equals : obj5) {
                }
                return uVar;
            }
            return uVar.f();
        }
        j.a(106);
        throw i;
    }

    public static kotlin.i0.z.e.m0.i.j k(g g, f.a f$a2) {
        int i = 0;
        if (g == null) {
        } else {
            if (a2 == null) {
            } else {
                j jVar = new j(a2, g);
                return jVar;
            }
            j.a(3);
            throw i;
        }
        j.a(2);
        throw i;
    }

    private static void l(Collection<b> collection, e e2, kotlin.i0.z.e.m0.i.i i3) {
        u uVar;
        Collection obj8;
        int i = 0;
        if (collection == null) {
        } else {
            if (e2 == null) {
            } else {
                if (i3 == null) {
                } else {
                    Collection collection2 = j.w(e2, collection);
                    final boolean empty = collection2.isEmpty();
                    if (empty) {
                    } else {
                        obj8 = collection2;
                    }
                    uVar = empty ? t.h : t.g;
                    j.d dVar = new j.d();
                    final b obj9 = (b)j.O(obj8, dVar).k0(e2, j.q(obj8, e2), uVar, b.a.FAKE_OVERRIDE, false);
                    i3.d(obj9, obj8);
                    i3.a(obj9);
                }
                j.a(85);
                throw i;
            }
            j.a(84);
            throw i;
        }
        j.a(83);
        throw i;
    }

    private static void m(e e, Collection<b> collection2, kotlin.i0.z.e.m0.i.i i3) {
        boolean singleton;
        Collection obj2;
        int i = 0;
        if (e == null) {
        } else {
            if (collection2 == null) {
            } else {
                if (i3 == null) {
                } else {
                    if (j.d(collection2)) {
                        obj2 = collection2.iterator();
                        for (b next2 : obj2) {
                            j.l(Collections.singleton(next2), e, i3);
                        }
                    }
                    LinkedList linkedList = new LinkedList(collection2);
                    while (!linkedList.isEmpty()) {
                        j.l(j.t(o.a(linkedList), linkedList, i3), e, i3);
                    }
                }
                j.a(64);
                throw i;
            }
            j.a(63);
            throw i;
        }
        j.a(62);
        throw i;
    }

    private o<m, a> n(List<z0> list, List<z0> list2) {
        int i = 0;
        if (list == null) {
        } else {
            if (list2 == null) {
            } else {
                m mVar = new m(this.a);
                o obj4 = new o(mVar, o(list, list2));
                return obj4;
            }
            j.a(41);
            throw i;
        }
        j.a(40);
        throw i;
    }

    private kotlin.i0.z.e.m0.i.j.j o(List<z0> list, List<z0> list2) {
        int i;
        t0 t0Var;
        t0 t0Var2;
        int i2 = 0;
        if (list == null) {
        } else {
            if (list2 == null) {
            } else {
                if (list.isEmpty()) {
                    j.j obj5 = new j.j(this, i2);
                    return obj5;
                }
                HashMap hashMap = new HashMap();
                i = 0;
                while (i < list.size()) {
                    hashMap.put((z0)list.get(i).g(), (z0)list2.get(i).g());
                    i++;
                }
                obj5 = new j.j(this, hashMap);
                return obj5;
            }
            j.a(43);
            throw i2;
        }
        j.a(42);
        throw i2;
    }

    public static kotlin.i0.z.e.m0.i.j p(g g) {
        if (g == null) {
        } else {
            j jVar = new j(j.e, g);
            return jVar;
        }
        j.a(1);
        throw 0;
    }

    private static z q(Collection<b> collection, e e2) {
        boolean z;
        int i3;
        int i2;
        int i7;
        int i4;
        boolean aBSTRACT;
        int i5;
        int i;
        int i6;
        z obj9;
        int i8 = 0;
        if (collection == null) {
        } else {
            if (e2 == null) {
            } else {
                Iterator iterator = collection.iterator();
                i7 = i2;
                i5 = 1;
                for (b next3 : iterator) {
                    i = j.h.c[next3.i().ordinal()];
                    if (i != 3) {
                    } else {
                    }
                    i2 = i5;
                    i5 = 1;
                    if (i != 4) {
                    } else {
                    }
                    i7 = i5;
                }
                if (e2.L() && e2.i() != z.ABSTRACT && e2.i() != z.SEALED) {
                    if (e2.i() != z.ABSTRACT) {
                        if (e2.i() != z.SEALED) {
                            i3 = i5;
                        }
                    }
                }
                if (i2 != 0 && i7 == 0) {
                    if (i7 == 0) {
                        obj9 = z.OPEN;
                        if (obj9 == null) {
                        } else {
                            return obj9;
                        }
                        j.a(89);
                        throw i8;
                    }
                }
                if (i2 == 0 && i7 != 0) {
                    if (i7 != 0) {
                        if (i3 != 0) {
                            obj9 = e2.i();
                        } else {
                            obj9 = z.ABSTRACT;
                        }
                        if (obj9 == null) {
                        } else {
                            return obj9;
                        }
                        j.a(90);
                        throw i8;
                    }
                }
                HashSet hashSet = new HashSet();
                obj9 = collection.iterator();
                for (b next2 : obj9) {
                    hashSet.addAll(j.C(next2));
                }
                return j.B(j.u(hashSet), i3, e2.i());
            }
            j.a(87);
            throw i8;
        }
        j.a(86);
        throw i8;
    }

    private Collection<b> r(b b, Collection<? extends b> collection2, e e3, kotlin.i0.z.e.m0.i.i i4) {
        Object next;
        int i2;
        boolean z;
        int i;
        int i3 = 0;
        if (b == null) {
        } else {
            if (collection2 == null) {
            } else {
                if (e3 == null) {
                } else {
                    if (i4 == null) {
                    } else {
                        ArrayList arrayList = new ArrayList(collection2.size());
                        j jVar = j.b();
                        final Iterator obj8 = collection2.iterator();
                        while (obj8.hasNext()) {
                            next = obj8.next();
                            z = j.L(b, next);
                            i2 = j.h.b[G((b)next, b, e3).c().ordinal()];
                            if (i2 != 1) {
                            } else {
                            }
                            if (z) {
                            }
                            arrayList.add(next);
                            jVar.add(next);
                            if (i2 != 2) {
                            } else {
                            }
                            if (z) {
                            }
                            arrayList.add(next);
                            i4.c(next, b);
                        }
                        i4.d(b, jVar);
                        return arrayList;
                    }
                    j.a(60);
                    throw i3;
                }
                j.a(59);
                throw i3;
            }
            j.a(58);
            throw i3;
        }
        j.a(57);
        throw i3;
    }

    public static <H> Collection<H> s(H h, Collection<H> collection2, l<H, a> l3, l<H, w> l4) {
        Object next;
        Object invoke;
        kotlin.i0.z.e.m0.i.j.i.a oVERRIDABLE;
        int i = 0;
        if (h == null) {
        } else {
            if (collection2 == null) {
            } else {
                if (l3 == null) {
                } else {
                    if (l4 == null) {
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(h);
                        final Iterator obj6 = collection2.iterator();
                        while (obj6.hasNext()) {
                            next = obj6.next();
                            if (h == next) {
                            } else {
                            }
                            invoke = j.A((a)l3.invoke(h), (a)l3.invoke(next));
                            if (invoke == j.i.a.OVERRIDABLE) {
                            } else {
                            }
                            if (invoke == j.i.a.CONFLICT) {
                            }
                            l4.invoke(next);
                            obj6.remove();
                            arrayList.add(next);
                            obj6.remove();
                            obj6.remove();
                        }
                        return arrayList;
                    }
                    j.a(100);
                    throw i;
                }
                j.a(99);
                throw i;
            }
            j.a(98);
            throw i;
        }
        j.a(97);
        throw i;
    }

    private static Collection<b> t(b b, Queue<b> queue2, kotlin.i0.z.e.m0.i.i i3) {
        int i = 0;
        if (b == null) {
        } else {
            if (queue2 == null) {
            } else {
                if (i3 == null) {
                } else {
                    j.f fVar = new j.f();
                    j.g gVar = new j.g(i3, b);
                    return j.s(b, queue2, fVar, gVar);
                }
                j.a(104);
                throw i;
            }
            j.a(103);
            throw i;
        }
        j.a(102);
        throw i;
    }

    public static <D extends a> Set<D> u(Set<D> set) {
        int i;
        boolean empty;
        final int i2 = 0;
        if (set == null) {
        } else {
            if (!set.isEmpty() && a.q(a.l((m)set.iterator().next()))) {
                i = a.q(a.l((m)set.iterator().next())) ? 1 : 0;
            } else {
            }
            j.b bVar = new j.b();
            return j.v(set, i, i2, bVar);
        }
        j.a(6);
        throw i2;
    }

    public static <D> Set<D> v(Set<D> set, boolean z2, a<?> a3, p<? super D, ? super D, o<a, a>> p4) {
        int size;
        Iterator iterator;
        boolean next;
        Object obj;
        boolean z;
        int i = 0;
        if (set == null) {
        } else {
            if (p4 == null) {
            } else {
                final int i2 = 1;
                if (set.size() <= i2) {
                    if (set == null) {
                    } else {
                        return set;
                    }
                    j.a(9);
                    throw i;
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator obj7 = set.iterator();
                while (obj7.hasNext()) {
                    size = obj7.next();
                    if (a3 != null) {
                    }
                    iterator = linkedHashSet.iterator();
                    for (Object next3 : iterator) {
                        Object invoke = p4.invoke(size, next3);
                        obj = (o)invoke.a();
                        next = invoke.b();
                        iterator.remove();
                    }
                    linkedHashSet.add(size);
                    invoke = p4.invoke(size, iterator.next());
                    obj = (o)invoke.a();
                    next = invoke.b();
                    if (j.M((a)obj, (a)next, z2, i2)) {
                    } else {
                    }
                    if (j.M(next, obj, z2, i2)) {
                    } else {
                    }
                    iterator.remove();
                    a3.invoke();
                }
                return linkedHashSet;
            }
            j.a(8);
            throw i;
        }
        j.a(7);
        throw i;
    }

    private static Collection<b> w(e e, Collection<b> collection2) {
        final int i = 0;
        if (e == null) {
        } else {
            if (collection2 == null) {
            } else {
                j.e eVar = new j.e(e);
                List obj2 = p.T(collection2, eVar);
                if (obj2 == null) {
                } else {
                    return obj2;
                }
                j.a(96);
                throw i;
            }
            j.a(95);
            throw i;
        }
        j.a(94);
        throw i;
    }

    public static u x(Collection<? extends b> collection) {
        Iterator intValue2;
        int i;
        u visibility;
        Integer intValue;
        final int i2 = 0;
        if (collection == null) {
        } else {
            if (collection.isEmpty()) {
                return t.k;
            }
            intValue2 = collection.iterator();
            while (/* condition */) {
                while (intValue2.hasNext()) {
                    visibility = (b)intValue2.next().getVisibility();
                    if (i != 0) {
                        break loop_5;
                    } else {
                    }
                    intValue = t.d(visibility, i);
                    if (intValue == null) {
                        break loop_5;
                    } else {
                    }
                    if (intValue.intValue() > 0) {
                    }
                    i = visibility;
                }
                visibility = (b)intValue2.next().getVisibility();
                if (i == 0) {
                } else {
                }
                intValue = t.d(visibility, i);
                if (intValue == null) {
                } else {
                }
                if (intValue.intValue() > 0) {
                }
                i = visibility;
                i = i2;
            }
            if (i == 0) {
                return i2;
            }
            Iterator obj5 = collection.iterator();
            for (b next2 : obj5) {
                intValue2 = t.d(i, next2.getVisibility());
            }
            return i;
        }
        j.a(107);
        throw i2;
    }

    public static kotlin.i0.z.e.m0.i.j.i z(a a, a a2) {
        boolean z2;
        boolean z;
        int i = 0;
        if (a == null) {
        } else {
            if (a2 == null) {
            } else {
                boolean z3 = a instanceof x;
                if (z3) {
                    z2 = a instanceof o0;
                    if (a2 instanceof x && z2 && !a2 instanceof o0) {
                        z2 = a instanceof o0;
                        if (z2) {
                            if (!a2 instanceof o0) {
                            }
                        }
                    }
                    return j.i.d("Member kind mismatch");
                } else {
                }
                if (!z3) {
                    if (!z2) {
                    } else {
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("This type of CallableDescriptor cannot be checked for overridability: ");
                    stringBuilder.append(a);
                    IllegalArgumentException obj5 = new IllegalArgumentException(stringBuilder.toString());
                    throw obj5;
                }
                if (!a.getName().equals(a2.getName())) {
                    return j.i.d("Name mismatch");
                }
                kotlin.i0.z.e.m0.i.j.i obj4 = j.g(a, a2);
                if (obj4 != null) {
                    return obj4;
                }
                return i;
            }
            j.a(39);
            throw i;
        }
        j.a(38);
        throw i;
    }

    public kotlin.i0.z.e.m0.i.j.i G(a a, a a2, e e3) {
        final int i = 0;
        if (a == null) {
        } else {
            if (a2 == null) {
            } else {
                kotlin.i0.z.e.m0.i.j.i obj3 = H(a, a2, e3, false);
                if (obj3 == null) {
                } else {
                    return obj3;
                }
                j.a(19);
                throw i;
            }
            j.a(18);
            throw i;
        }
        j.a(17);
        throw i;
    }

    public kotlin.i0.z.e.m0.i.j.i H(a a, a a2, e e3, boolean z4) {
        int next;
        Iterator iterator;
        int next2;
        boolean cONFLICTS_ONLY;
        String str2;
        String str;
        int i2;
        int i;
        int[] iArr;
        kotlin.i0.z.e.m0.i.e.a cONFLICTS_ONLY2;
        final int i3 = 0;
        if (a == null) {
        } else {
            if (a2 == null) {
            } else {
                kotlin.i0.z.e.m0.i.j.i obj15 = I(a, a2, z4);
                final int i4 = 1;
                next = obj15.c() == j.i.a.OVERRIDABLE ? i4 : 0;
                iterator = j.c.iterator();
                str2 = "External condition";
                str = "External condition failed";
                i2 = 3;
                i = 2;
                for (e next2 : iterator) {
                    next2 = j.h.a[next2.b(a, a2, e3).ordinal()];
                    next = i4;
                    str2 = "External condition";
                    str = "External condition failed";
                    i2 = 3;
                    i = 2;
                }
                if (next == 0) {
                    if (obj15 == null) {
                    } else {
                        return obj15;
                    }
                    j.a(24);
                    throw i3;
                }
                obj15 = j.c.iterator();
                for (e next : obj15) {
                    iterator = j.h.a[next.b(a, a2, e3).ordinal()];
                }
                kotlin.i0.z.e.m0.i.j.i obj12 = j.i.e();
                if (obj12 == null) {
                } else {
                    return obj12;
                }
                j.a(27);
                throw i3;
            }
            j.a(21);
            throw i3;
        }
        j.a(20);
        throw i3;
    }

    public kotlin.i0.z.e.m0.i.j.i I(a a, a a2, boolean z3) {
        boolean suspend2;
        List suspend;
        List typeParameters;
        int i2;
        List typeParameters2;
        int i;
        int i3;
        boolean z;
        Object obj;
        a obj11;
        a obj12;
        Object obj13;
        final int i4 = 0;
        if (a == null) {
        } else {
            if (a2 == null) {
            } else {
                kotlin.i0.z.e.m0.i.j.i iVar = j.z(a, a2);
                if (iVar != null) {
                    if (iVar == null) {
                    } else {
                        return iVar;
                    }
                    j.a(30);
                    throw i4;
                }
                List list = j.i(a);
                suspend = j.i(a2);
                typeParameters = a.getTypeParameters();
                typeParameters2 = a2.getTypeParameters();
                i3 = 0;
                if (typeParameters.size() != typeParameters2.size()) {
                }
                o oVar = n(typeParameters, typeParameters2);
                i = i3;
                while (i < typeParameters.size()) {
                    i++;
                }
                i2 = i3;
                while (i2 < list.size()) {
                    i2++;
                }
                if (a instanceof x && a2 instanceof x && (x)a.isSuspend() != (x)a2.isSuspend()) {
                    if (a2 instanceof x) {
                        if ((x)a.isSuspend() != (x)a2.isSuspend()) {
                            obj11 = j.i.b("Incompatible suspendability");
                            if (obj11 == null) {
                            } else {
                                return obj11;
                            }
                            j.a(35);
                            throw i4;
                        }
                    }
                }
                obj11 = a.getReturnType();
                obj12 = a2.getReturnType();
                if (z3 && obj11 != null && obj12 != null && d0.a(obj12) && d0.a(obj11)) {
                    obj11 = a.getReturnType();
                    obj12 = a2.getReturnType();
                    if (obj11 != null) {
                        if (obj12 != null) {
                            if (d0.a(obj12)) {
                                if (d0.a(obj11)) {
                                    i3 = 1;
                                }
                            }
                            if (i3 == 0 && !(m)oVar.c().f((a)oVar.d(), obj12.O0(), obj11.O0())) {
                                if (!(m)oVar.c().f((a)oVar.d(), obj12.O0(), obj11.O0())) {
                                    obj11 = j.i.b("Return type mismatch");
                                    if (obj11 == null) {
                                    } else {
                                        return obj11;
                                    }
                                    j.a(36);
                                    throw i4;
                                }
                            }
                        }
                    }
                }
                obj11 = j.i.e();
                if (obj11 == null) {
                } else {
                    return obj11;
                }
                j.a(37);
                throw i4;
            }
            j.a(29);
            throw i4;
        }
        j.a(28);
        throw i4;
    }

    public void y(e e, Collection<? extends b> collection2, Collection<? extends b> collection3, e e4, kotlin.i0.z.e.m0.i.i i5) {
        int i;
        i = 0;
        if (e == null) {
        } else {
            if (collection2 == null) {
            } else {
                if (collection3 == null) {
                } else {
                    if (e4 == null) {
                    } else {
                        if (i5 == null) {
                        } else {
                            LinkedHashSet obj2 = new LinkedHashSet(collection2);
                            final Iterator obj4 = collection3.iterator();
                            for (b next2 : obj4) {
                                obj2.removeAll(r(next2, collection2, e4, i5));
                            }
                            j.m(e4, obj2, i5);
                        }
                        j.a(54);
                        throw i;
                    }
                    j.a(53);
                    throw i;
                }
                j.a(52);
                throw i;
            }
            j.a(51);
            throw i;
        }
        j.a(50);
        throw i;
    }
}
