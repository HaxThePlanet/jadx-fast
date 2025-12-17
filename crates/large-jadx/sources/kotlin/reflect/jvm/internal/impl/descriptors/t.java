package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.v.o.d;
import kotlin.i0.z.e.m0.i.v.o.e;
import kotlin.i0.z.e.m0.i.v.o.f;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.r;
import kotlin.i0.z.e.m0.m.g;
import kotlin.i0.z.e.m0.m.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.h0;
import kotlin.reflect.jvm.internal.impl.utils.a;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public class t {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.u a;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.u b;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.u c;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.u d;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.u e;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.u f;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.u g;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.u h;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.u i;
    private static final Map<kotlin.reflect.jvm.internal.impl.descriptors.u, Integer> j;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.u k;
    private static final d l;
    public static final d m;
    @Deprecated
    public static final d n;
    private static final g o;
    private static final Map<kotlin.reflect.jvm.internal.impl.descriptors.g1, kotlin.reflect.jvm.internal.impl.descriptors.u> p;

    static class a implements d {
        @Override // kotlin.i0.z.e.m0.i.v.o.d
        public b0 getType() {
            IllegalStateException illegalStateException = new IllegalStateException("This method should not be called");
            throw illegalStateException;
        }
    }

    static class b implements d {
        @Override // kotlin.i0.z.e.m0.i.v.o.d
        public b0 getType() {
            IllegalStateException illegalStateException = new IllegalStateException("This method should not be called");
            throw illegalStateException;
        }
    }

    static class c implements d {
        @Override // kotlin.i0.z.e.m0.i.v.o.d
        public b0 getType() {
            IllegalStateException illegalStateException = new IllegalStateException("This method should not be called");
            throw illegalStateException;
        }
    }

    static class d extends kotlin.reflect.jvm.internal.impl.descriptors.r {
        d(kotlin.reflect.jvm.internal.impl.descriptors.g1 g1) {
            super(g1);
        }

        private static void g(int i) {
            String str;
            String obj5;
            Object[] arr = new Object[3];
            int i3 = 0;
            final int i4 = 1;
            final int i5 = 2;
            if (i != i4) {
                if (i != i5) {
                    arr[i3] = "descriptor";
                } else {
                    arr[i3] = "from";
                }
            } else {
                arr[i3] = "what";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i != i4 && i != i5) {
                if (i != i5) {
                    arr[i5] = "hasContainingSourceFile";
                } else {
                    arr[i5] = "isVisible";
                }
            } else {
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        private boolean h(kotlin.reflect.jvm.internal.impl.descriptors.m m) {
            int i;
            if (m == null) {
            } else {
                if (d.j(m) != v0.a) {
                    i = 1;
                }
                return i;
            }
            t.d.g(0);
            throw 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.r
        public boolean e(d d, kotlin.reflect.jvm.internal.impl.descriptors.q q2, kotlin.reflect.jvm.internal.impl.descriptors.m m3) {
            int i;
            boolean z;
            boolean equals;
            b bVar;
            boolean obj4;
            kotlin.reflect.jvm.internal.impl.descriptors.m obj5;
            kotlin.reflect.jvm.internal.impl.descriptors.m obj6;
            obj4 = 0;
            i = 1;
            if (q2 == null) {
            } else {
                if (m3 == null) {
                } else {
                    if (d.J(q2) && h(m3)) {
                        if (h(m3)) {
                            return t.f(q2, m3);
                        }
                    }
                    obj4 = (l)q2.b();
                    if (q2 instanceof l && d.G(obj4) && d.J(obj4) && m3 instanceof l && d.J(m3.b()) && t.f(q2, m3)) {
                        obj4 = (l)q2.b();
                        if (d.G(obj4)) {
                            if (d.J(obj4)) {
                                if (m3 instanceof l) {
                                    if (d.J(m3.b())) {
                                        if (t.f(q2, m3)) {
                                            return i;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    while (obj5 != null) {
                        obj5 = obj5.b();
                        if (obj5 instanceof e) {
                        } else {
                        }
                        if (!obj5 instanceof f0) {
                        }
                        if (d.x(obj5)) {
                        }
                    }
                    obj4 = 0;
                    if (obj5 == null) {
                        return obj4;
                    }
                    while (obj6 != null) {
                        obj6 = obj6.b();
                    }
                    return obj4;
                }
                t.d.g(2);
                throw obj4;
            }
            t.d.g(i);
            throw obj4;
        }
    }

    static class e extends kotlin.reflect.jvm.internal.impl.descriptors.r {
        e(kotlin.reflect.jvm.internal.impl.descriptors.g1 g1) {
            super(g1);
        }

        private static void g(int i) {
            String obj3;
            Object[] arr = new Object[3];
            int i3 = 0;
            final int i4 = 1;
            if (i != i4) {
                arr[i3] = "what";
            } else {
                arr[i3] = "from";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            arr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.r
        public boolean e(d d, kotlin.reflect.jvm.internal.impl.descriptors.q q2, kotlin.reflect.jvm.internal.impl.descriptors.m m3) {
            kotlin.reflect.jvm.internal.impl.descriptors.m obj5;
            boolean obj6;
            int i = 0;
            final int i2 = 0;
            if (q2 == null) {
            } else {
                final int i3 = 1;
                if (m3 == null) {
                } else {
                    if (t.a.e(d, q2, m3) && d == t.m) {
                        if (d == t.m) {
                            return i3;
                        }
                        if (d == t.b()) {
                            return i2;
                        }
                        obj5 = d.q(q2, e.class);
                        if (obj5 != null && d instanceof f) {
                            if (d instanceof f) {
                                return (f)d.p().a().equals(obj5.a());
                            }
                        }
                    }
                    return i2;
                }
                t.e.g(i3);
                throw i;
            }
            t.e.g(i2);
            throw i;
        }
    }

    static class f extends kotlin.reflect.jvm.internal.impl.descriptors.r {
        f(kotlin.reflect.jvm.internal.impl.descriptors.g1 g1) {
            super(g1);
        }

        private static void g(int i) {
            String str;
            String obj6;
            int i2 = 3;
            final Object[] arr = new Object[i2];
            final int i3 = 1;
            int i4 = 0;
            final int i5 = 2;
            if (i != i3) {
                if (i != i5) {
                    if (i != i2) {
                        arr[i4] = "what";
                    } else {
                        arr[i4] = "fromClass";
                    }
                } else {
                    arr[i4] = "whatDeclaration";
                }
            } else {
                arr[i4] = "from";
            }
            arr[i3] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i != i5 && i != i2) {
                if (i != i2) {
                    arr[i5] = "isVisible";
                } else {
                    arr[i5] = "doesReceiverFitForProtectedVisibility";
                }
            } else {
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        private boolean h(d d, kotlin.reflect.jvm.internal.impl.descriptors.q q2, kotlin.reflect.jvm.internal.impl.descriptors.e e3) {
            int i;
            b0 obj4;
            d obj5;
            int i2 = 0;
            if (q2 == null) {
            } else {
                if (e3 == null) {
                } else {
                    if (d == t.n) {
                        return 0;
                    }
                    final int i3 = 1;
                    if (!q2 instanceof b) {
                        return i3;
                    }
                    if (q2 instanceof l) {
                        return i3;
                    }
                    if (d == t.m) {
                        return i3;
                    }
                    if (d != t.b()) {
                        if (d == null) {
                        } else {
                            if (d instanceof e) {
                                obj4 = (e)d.a();
                            } else {
                                obj4 = d.getType();
                            }
                            if (!d.I(obj4, e3)) {
                                if (r.a(obj4)) {
                                    i = i3;
                                }
                            } else {
                            }
                        }
                    }
                    return i;
                }
                t.f.g(3);
                throw i2;
            }
            t.f.g(2);
            throw i2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.r
        public boolean e(d d, kotlin.reflect.jvm.internal.impl.descriptors.q q2, kotlin.reflect.jvm.internal.impl.descriptors.m m3) {
            boolean z2;
            kotlin.reflect.jvm.internal.impl.descriptors.m mVar;
            boolean z;
            Class<kotlin.reflect.jvm.internal.impl.descriptors.e> obj = e.class;
            int i = 0;
            final int i2 = 0;
            if (q2 == null) {
            } else {
                final int i3 = 1;
                if (m3 == null) {
                } else {
                    mVar = d.q(q2, obj);
                    kotlin.reflect.jvm.internal.impl.descriptors.m obj8 = d.r(m3, obj, i2);
                    if ((e)obj8 == null) {
                        return i2;
                    }
                    mVar = d.q(mVar, obj);
                    if (mVar != null && d.x((e)mVar) && mVar != null && d.H((e)obj8, (e)mVar)) {
                        if (d.x(mVar)) {
                            mVar = d.q(mVar, obj);
                            if ((e)mVar != null) {
                                if (d.H(obj8, (e)mVar)) {
                                    return i3;
                                }
                            }
                        }
                    }
                    kotlin.reflect.jvm.internal.impl.descriptors.q qVar = d.M(q2);
                    kotlin.reflect.jvm.internal.impl.descriptors.m mVar2 = d.q(qVar, obj);
                    if ((e)mVar2 == null) {
                        return i2;
                    }
                    if (d.H(obj8, (e)mVar2) && h(d, qVar, obj8)) {
                        if (h(d, qVar, obj8)) {
                            return i3;
                        }
                    }
                    return e(d, q2, obj8.b());
                }
                t.f.g(i3);
                throw i;
            }
            t.f.g(i2);
            throw i;
        }
    }

    static class g extends kotlin.reflect.jvm.internal.impl.descriptors.r {
        g(kotlin.reflect.jvm.internal.impl.descriptors.g1 g1) {
            super(g1);
        }

        private static void g(int i) {
            String obj3;
            Object[] arr = new Object[3];
            int i3 = 0;
            final int i4 = 1;
            if (i != i4) {
                arr[i3] = "what";
            } else {
                arr[i3] = "from";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            arr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.r
        public boolean e(d d, kotlin.reflect.jvm.internal.impl.descriptors.q q2, kotlin.reflect.jvm.internal.impl.descriptors.m m3) {
            int obj3 = 0;
            final int i = 0;
            if (q2 == null) {
            } else {
                if (m3 == null) {
                } else {
                    if (!d.g(m3).e0(d.g(q2))) {
                        return i;
                    }
                    return t.c().a(q2, m3);
                }
                t.g.g(1);
                throw obj3;
            }
            t.g.g(i);
            throw obj3;
        }
    }

    static class h extends kotlin.reflect.jvm.internal.impl.descriptors.r {
        h(kotlin.reflect.jvm.internal.impl.descriptors.g1 g1) {
            super(g1);
        }

        private static void g(int i) {
            String obj3;
            Object[] arr = new Object[3];
            int i3 = 0;
            final int i4 = 1;
            if (i != i4) {
                arr[i3] = "what";
            } else {
                arr[i3] = "from";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            arr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.r
        public boolean e(d d, kotlin.reflect.jvm.internal.impl.descriptors.q q2, kotlin.reflect.jvm.internal.impl.descriptors.m m3) {
            final int obj1 = 0;
            if (q2 == null) {
            } else {
                int obj2 = 1;
                if (m3 == null) {
                } else {
                    return obj2;
                }
                t.h.g(obj2);
                throw obj1;
            }
            t.h.g(0);
            throw obj1;
        }
    }

    static class i extends kotlin.reflect.jvm.internal.impl.descriptors.r {
        i(kotlin.reflect.jvm.internal.impl.descriptors.g1 g1) {
            super(g1);
        }

        private static void g(int i) {
            String obj3;
            Object[] arr = new Object[3];
            int i3 = 0;
            final int i4 = 1;
            if (i != i4) {
                arr[i3] = "what";
            } else {
                arr[i3] = "from";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            arr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.r
        public boolean e(d d, kotlin.reflect.jvm.internal.impl.descriptors.q q2, kotlin.reflect.jvm.internal.impl.descriptors.m m3) {
            int obj1 = 0;
            if (q2 == null) {
            } else {
                if (m3 == null) {
                    t.i.g(1);
                    throw obj1;
                }
                obj1 = new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
                throw obj1;
            }
            t.i.g(0);
            throw obj1;
        }
    }

    static class j extends kotlin.reflect.jvm.internal.impl.descriptors.r {
        j(kotlin.reflect.jvm.internal.impl.descriptors.g1 g1) {
            super(g1);
        }

        private static void g(int i) {
            String obj3;
            Object[] arr = new Object[3];
            int i3 = 0;
            final int i4 = 1;
            if (i != i4) {
                arr[i3] = "what";
            } else {
                arr[i3] = "from";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            arr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.r
        public boolean e(d d, kotlin.reflect.jvm.internal.impl.descriptors.q q2, kotlin.reflect.jvm.internal.impl.descriptors.m m3) {
            int obj1 = 0;
            if (q2 == null) {
            } else {
                if (m3 == null) {
                    t.j.g(1);
                    throw obj1;
                }
                obj1 = new IllegalStateException("Visibility is unknown yet");
                throw obj1;
            }
            t.j.g(0);
            throw obj1;
        }
    }

    static class k extends kotlin.reflect.jvm.internal.impl.descriptors.r {
        k(kotlin.reflect.jvm.internal.impl.descriptors.g1 g1) {
            super(g1);
        }

        private static void g(int i) {
            String obj3;
            Object[] arr = new Object[3];
            int i3 = 0;
            final int i4 = 1;
            if (i != i4) {
                arr[i3] = "what";
            } else {
                arr[i3] = "from";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            arr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.r
        public boolean e(d d, kotlin.reflect.jvm.internal.impl.descriptors.q q2, kotlin.reflect.jvm.internal.impl.descriptors.m m3) {
            final int obj2 = 0;
            final int i = 0;
            if (q2 == null) {
            } else {
                if (m3 == null) {
                } else {
                    return i;
                }
                t.k.g(1);
                throw obj2;
            }
            t.k.g(i);
            throw obj2;
        }
    }

    static class l extends kotlin.reflect.jvm.internal.impl.descriptors.r {
        l(kotlin.reflect.jvm.internal.impl.descriptors.g1 g1) {
            super(g1);
        }

        private static void g(int i) {
            String obj3;
            Object[] arr = new Object[3];
            int i3 = 0;
            final int i4 = 1;
            if (i != i4) {
                arr[i3] = "what";
            } else {
                arr[i3] = "from";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            arr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.r
        public boolean e(d d, kotlin.reflect.jvm.internal.impl.descriptors.q q2, kotlin.reflect.jvm.internal.impl.descriptors.m m3) {
            final int obj2 = 0;
            final int i = 0;
            if (q2 == null) {
            } else {
                if (m3 == null) {
                } else {
                    return i;
                }
                t.l.g(1);
                throw obj2;
            }
            t.l.g(i);
            throw obj2;
        }
    }
    static {
        Object next;
        Class<g> obj = g.class;
        t.d dVar = new t.d(f1.e.c);
        t.a = dVar;
        t.e eVar2 = new t.e(f1.f.c);
        t.b = eVar2;
        t.f fVar2 = new t.f(f1.g.c);
        t.c = fVar2;
        t.g gVar2 = new t.g(f1.b.c);
        t.d = gVar2;
        t.h hVar = new t.h(f1.h.c);
        t.e = hVar;
        t.i iVar = new t.i(f1.d.c);
        t.f = iVar;
        t.j jVar = new t.j(f1.a.c);
        t.g = jVar;
        t.k kVar = new t.k(f1.c.c);
        t.h = kVar;
        t.l lVar = new t.l(f1.i.c);
        t.i = lVar;
        int i = 4;
        kotlin.reflect.jvm.internal.impl.descriptors.u[] arr = new u[i];
        int i2 = 0;
        final Integer valueOf2 = Integer.valueOf(i2);
        arr[i2] = dVar;
        int i3 = 1;
        final Integer valueOf3 = Integer.valueOf(i3);
        arr[i3] = eVar2;
        int i4 = 2;
        arr[i4] = gVar2;
        arr[3] = iVar;
        Collections.unmodifiableSet(q0.g(arr));
        HashMap map = a.e(i);
        map.put(eVar2, valueOf2);
        map.put(dVar, valueOf2);
        map.put(gVar2, valueOf3);
        map.put(fVar2, valueOf3);
        map.put(hVar, Integer.valueOf(i4));
        t.j = Collections.unmodifiableMap(map);
        t.k = hVar;
        t.a aVar2 = new t.a();
        t.l = aVar2;
        t.b bVar2 = new t.b();
        t.m = bVar2;
        t.c cVar2 = new t.c();
        t.n = cVar2;
        Iterator iterator = ServiceLoader.load(obj, obj.getClassLoader()).iterator();
        if (iterator.hasNext()) {
            next = iterator.next();
        } else {
            next = g.a.a;
        }
        t.o = next;
        HashMap hashMap = new HashMap();
        t.p = hashMap;
        t.i(dVar);
        t.i(eVar2);
        t.i(fVar2);
        t.i(gVar2);
        t.i(hVar);
        t.i(iVar);
        t.i(jVar);
        t.i(kVar);
        t.i(lVar);
    }

    private static void a(int i) {
        String str;
        int str2;
        String str3;
        int i2;
        Object obj8;
        final int i3 = 16;
        str = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        str2 = 3;
        final int i4 = 2;
        i2 = i != i3 ? str2 : i4;
        Object[] arr = new Object[i2];
        final String str4 = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        final int i5 = 1;
        final int i6 = 0;
        if (i != i5 && i != str2 && i != 5 && i != 7) {
            if (i != str2) {
                if (i != 5) {
                    if (i != 7) {
                        switch (i) {
                            case 9:
                                arr[i6] = "from";
                                break;
                            case 10:
                                arr[i6] = "first";
                                break;
                            case 11:
                                arr[i6] = "second";
                                break;
                            case 12:
                                arr[i6] = "visibility";
                                break;
                            case 13:
                                arr[i6] = str4;
                                break;
                            default:
                                arr[i6] = "what";
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        str3 = "toDescriptorVisibility";
        if (i != i3) {
            arr[i5] = str4;
        } else {
            arr[i5] = str3;
        }
        switch (i) {
            case 2:
                arr[i4] = "isVisibleIgnoringReceiver";
                break;
            case 3:
                arr[i4] = "isVisibleWithAnyReceiver";
                break;
            case 4:
                arr[i4] = "inSameFile";
                break;
            case 5:
                arr[i4] = "findInvisibleMember";
                break;
            case 6:
                arr[i4] = "compareLocal";
                break;
            case 7:
                arr[i4] = "compare";
                break;
            case 8:
                arr[i4] = "isPrivate";
                break;
            case 9:
                arr[i4] = str3;
                break;
            default:
                arr[i4] = "isVisible";
        }
        String format = String.format(str, arr);
        if (i != i3) {
            obj8 = new IllegalArgumentException(format);
        } else {
            obj8 = new IllegalStateException(format);
        }
        throw obj8;
    }

    static d b() {
        return t.l;
    }

    static g c() {
        return t.o;
    }

    public static Integer d(kotlin.reflect.jvm.internal.impl.descriptors.u u, kotlin.reflect.jvm.internal.impl.descriptors.u u2) {
        final int i = 0;
        if (u == null) {
        } else {
            if (u2 == null) {
            } else {
                final Integer num = u.a(u2);
                if (num != null) {
                    return num;
                }
                Integer obj2 = u2.a(u);
                if (obj2 != null) {
                    return Integer.valueOf(-obj2);
                }
                return i;
            }
            t.a(13);
            throw i;
        }
        t.a(12);
        throw i;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.q e(d d, kotlin.reflect.jvm.internal.impl.descriptors.q q2, kotlin.reflect.jvm.internal.impl.descriptors.m m3) {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVar;
        Class<kotlin.reflect.jvm.internal.impl.descriptors.q> visibility;
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar;
        Object obj4;
        Object obj5;
        final int i = 0;
        if (q2 == null) {
        } else {
            if (m3 == null) {
            } else {
                mVar = q2.a();
                while (mVar != null) {
                    mVar = d.q(mVar, q.class);
                }
                obj4 = t.e(d, (h0)q2.p0(), m3);
                if (q2 instanceof h0 && obj4 != null) {
                    obj4 = t.e(d, (h0)q2.p0(), m3);
                    if (obj4 != null) {
                        return obj4;
                    }
                }
                return i;
            }
            t.a(9);
            throw i;
        }
        t.a(8);
        throw i;
    }

    public static boolean f(kotlin.reflect.jvm.internal.impl.descriptors.m m, kotlin.reflect.jvm.internal.impl.descriptors.m m2) {
        int i = 0;
        if (m == null) {
        } else {
            if (m2 == null) {
            } else {
                final kotlin.reflect.jvm.internal.impl.descriptors.v0 obj2 = d.j(m2);
                if (obj2 != v0.a) {
                    return obj2.equals(d.j(m));
                }
                return 0;
            }
            t.a(7);
            throw i;
        }
        t.a(6);
        throw i;
    }

    public static boolean g(kotlin.reflect.jvm.internal.impl.descriptors.u u) {
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar;
        int obj1;
        if (u == null) {
        } else {
            if (u != t.a) {
                if (u == t.b) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
            return obj1;
        }
        t.a(14);
        throw 0;
    }

    public static boolean h(kotlin.reflect.jvm.internal.impl.descriptors.q q, kotlin.reflect.jvm.internal.impl.descriptors.m m2) {
        int obj1;
        int i = 0;
        if (q == null) {
        } else {
            if (m2 == null) {
            } else {
                obj1 = t.e(t.m, q, m2) == null ? 1 : 0;
                return obj1;
            }
            t.a(3);
            throw i;
        }
        t.a(2);
        throw i;
    }

    private static void i(kotlin.reflect.jvm.internal.impl.descriptors.u u) {
        t.p.put(u.b(), u);
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.u j(kotlin.reflect.jvm.internal.impl.descriptors.g1 g1) {
        int i = 0;
        if (g1 == null) {
        } else {
            Object obj = t.p.get(g1);
            if ((u)obj == null) {
            } else {
                if ((u)obj == null) {
                } else {
                    return (u)obj;
                }
                t.a(16);
                throw i;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Inapplicable visibility: ");
            stringBuilder.append(g1);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        t.a(15);
        throw i;
    }
}
