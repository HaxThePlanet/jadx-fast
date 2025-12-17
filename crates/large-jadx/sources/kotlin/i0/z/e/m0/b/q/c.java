package kotlin.i0.z.e.m0.b.q;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.c;
import kotlin.i0.z.e.m0.b.k;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.b.p.c;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.d;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.f.g;
import kotlin.i0.z.e.m0.i.t.d;
import kotlin.k0.l;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class c {

    public static final kotlin.i0.z.e.m0.b.q.c a;
    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private static final a f;
    private static final b g;
    private static final a h;
    private static final HashMap<c, a> i;
    private static final HashMap<c, a> j;
    private static final HashMap<c, b> k;
    private static final HashMap<c, b> l;
    private static final List<kotlin.i0.z.e.m0.b.q.c.a> m;

    public static final class a {

        private final a a;
        private final a b;
        private final a c;
        public a(a a, a a2, a a3) {
            n.f(a, "javaClass");
            n.f(a2, "kotlinReadOnly");
            n.f(a3, "kotlinMutable");
            super();
            this.a = a;
            this.b = a2;
            this.c = a3;
        }

        public final a a() {
            return this.a;
        }

        public final a b() {
            return this.b;
        }

        public final a c() {
            return this.c;
        }

        public final a d() {
            return this.a;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof c.a) {
                return i2;
            }
            if (!n.b(this.a, object.a)) {
                return i2;
            }
            if (!n.b(this.b, object.b)) {
                return i2;
            }
            if (!n.b(this.c, object.c)) {
                return i2;
            }
            return i;
        }

        public int hashCode() {
            return i4 += i7;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PlatformMutabilityMapping(javaClass=");
            stringBuilder.append(this.a);
            stringBuilder.append(", kotlinReadOnly=");
            stringBuilder.append(this.b);
            stringBuilder.append(", kotlinMutable=");
            stringBuilder.append(this.c);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    static {
        int i2;
        int i3;
        List next2;
        int length;
        boolean next;
        Class<java.lang.annotation.Annotation> obj;
        int i;
        b bVar;
        a valueOf;
        a str2;
        int i4;
        String str;
        c cVar = new c();
        c.a = cVar;
        StringBuilder stringBuilder = new StringBuilder();
        c function = c.Function;
        stringBuilder.append(function.getPackageFqName().toString());
        int i12 = 46;
        stringBuilder.append(i12);
        stringBuilder.append(function.getClassNamePrefix());
        c.b = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        c kFunction = c.KFunction;
        stringBuilder2.append(kFunction.getPackageFqName().toString());
        stringBuilder2.append(i12);
        stringBuilder2.append(kFunction.getClassNamePrefix());
        c.c = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        c suspendFunction = c.SuspendFunction;
        stringBuilder3.append(suspendFunction.getPackageFqName().toString());
        stringBuilder3.append(i12);
        stringBuilder3.append(suspendFunction.getClassNamePrefix());
        c.d = stringBuilder3.toString();
        StringBuilder stringBuilder4 = new StringBuilder();
        c kSuspendFunction2 = c.KSuspendFunction;
        stringBuilder4.append(kSuspendFunction2.getPackageFqName().toString());
        stringBuilder4.append(i12);
        stringBuilder4.append(kSuspendFunction2.getClassNamePrefix());
        c.e = stringBuilder4.toString();
        b bVar3 = new b("kotlin.jvm.functions.FunctionN");
        a aVar2 = a.m(bVar3);
        n.e(aVar2, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        c.f = aVar2;
        b bVar4 = aVar2.b();
        n.e(bVar4, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        c.g = bVar4;
        b bVar5 = new b("kotlin.reflect.KFunction");
        a aVar3 = a.m(bVar5);
        n.e(aVar3, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
        c.h = aVar3;
        b bVar6 = new b("kotlin.reflect.KClass");
        n.e(a.m(bVar6), "topLevel(FqName(\"kotlin.reflect.KClass\"))");
        cVar.h(Class.class);
        HashMap hashMap = new HashMap();
        c.i = hashMap;
        HashMap hashMap2 = new HashMap();
        c.j = hashMap2;
        HashMap hashMap3 = new HashMap();
        c.k = hashMap3;
        HashMap hashMap4 = new HashMap();
        c.l = hashMap4;
        kotlin.i0.z.e.m0.b.q.c.a[] arr = new c.a[8];
        a aVar7 = a.m(k.a.I);
        n.e(aVar7, "topLevel(FqNames.iterable)");
        b bVar43 = aVar7.h();
        str = "kotlinReadOnly.packageFqName";
        n.e(bVar43, str);
        i4 = 0;
        a aVar24 = new a(aVar7.h(), d.d(k.a.Q, bVar43), i4);
        c.a aVar15 = new c.a(c.a(cVar, Iterable.class), aVar7, aVar24);
        arr[i4] = aVar15;
        a aVar8 = a.m(k.a.H);
        n.e(aVar8, "topLevel(FqNames.iterator)");
        b bVar44 = aVar8.h();
        n.e(bVar44, str);
        a aVar25 = new a(aVar8.h(), d.d(k.a.P, bVar44), i4);
        c.a aVar16 = new c.a(c.a(cVar, Iterator.class), aVar8, aVar25);
        arr[1] = aVar16;
        a aVar9 = a.m(k.a.J);
        n.e(aVar9, "topLevel(FqNames.collection)");
        b bVar45 = aVar9.h();
        n.e(bVar45, str);
        a aVar26 = new a(aVar9.h(), d.d(k.a.R, bVar45), i4);
        c.a aVar17 = new c.a(c.a(cVar, Collection.class), aVar9, aVar26);
        arr[2] = aVar17;
        a aVar10 = a.m(k.a.K);
        n.e(aVar10, "topLevel(FqNames.list)");
        b bVar46 = aVar10.h();
        n.e(bVar46, str);
        a aVar27 = new a(aVar10.h(), d.d(k.a.S, bVar46), i4);
        c.a aVar18 = new c.a(c.a(cVar, List.class), aVar10, aVar27);
        arr[3] = aVar18;
        a aVar11 = a.m(k.a.M);
        n.e(aVar11, "topLevel(FqNames.set)");
        b bVar47 = aVar11.h();
        n.e(bVar47, str);
        a aVar28 = new a(aVar11.h(), d.d(k.a.U, bVar47), i4);
        c.a aVar19 = new c.a(c.a(cVar, Set.class), aVar11, aVar28);
        arr[4] = aVar19;
        a aVar12 = a.m(k.a.L);
        n.e(aVar12, "topLevel(FqNames.listIterator)");
        b bVar48 = aVar12.h();
        n.e(bVar48, str);
        a aVar29 = new a(aVar12.h(), d.d(k.a.T, bVar48), i4);
        c.a aVar20 = new c.a(c.a(cVar, ListIterator.class), aVar12, aVar29);
        arr[5] = aVar20;
        b bVar13 = k.a.N;
        a aVar21 = a.m(bVar13);
        n.e(aVar21, "topLevel(FqNames.map)");
        final b bVar51 = aVar21.h();
        n.e(bVar51, str);
        a aVar38 = new a(aVar21.h(), d.d(k.a.V, bVar51), i4);
        c.a aVar30 = new c.a(c.a(cVar, Map.class), aVar21, aVar38);
        arr[6] = aVar30;
        a aVar14 = a.m(bVar13).d(k.a.O.g());
        n.e(aVar14, "topLevel(FqNames.map).createNestedClassId(FqNames.mapEntry.shortName())");
        b bVar50 = aVar14.h();
        n.e(bVar50, str);
        valueOf = new a(aVar14.h(), d.d(k.a.W, bVar50), i4);
        c.a aVar22 = new c.a(c.a(cVar, Map.Entry.class), aVar14, valueOf);
        arr[7] = aVar22;
        next2 = p.j(arr);
        c.m = next2;
        cVar.g(Object.class, k.a.b);
        cVar.g(String.class, k.a.g);
        cVar.g(CharSequence.class, k.a.f);
        cVar.f(Throwable.class, k.a.s);
        cVar.g(Cloneable.class, k.a.d);
        cVar.g(Number.class, k.a.q);
        cVar.f(Comparable.class, k.a.t);
        cVar.g(Enum.class, k.a.r);
        cVar.f(Annotation.class, k.a.z);
        Iterator iterator = next2.iterator();
        for (c.a next2 : iterator) {
            c.a.e(next2);
        }
        d[] values = d.values();
        i = i4;
        while (i < values.length) {
            d dVar = values[i];
            i++;
            str2 = a.m(dVar.getWrapperFqName());
            n.e(str2, "topLevel(jvmType.wrapperFqName)");
            k kVar2 = k.a;
            kotlin.i0.z.e.m0.b.i primitiveType = dVar.getPrimitiveType();
            n.e(primitiveType, "jvmType.primitiveType");
            bVar = a.m(k.c(primitiveType));
            n.e(bVar, "topLevel(StandardNames.getPrimitiveFqName(jvmType.primitiveType))");
            c.a.b(str2, bVar);
        }
        Iterator iterator2 = c.a.a().iterator();
        for (a next4 : iterator2) {
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append("kotlin.jvm.internal.");
            stringBuilder6.append(next4.j().c());
            stringBuilder6.append("CompanionObject");
            b bVar32 = new b(stringBuilder6.toString());
            bVar = a.m(bVar32);
            n.e(bVar, "topLevel(FqName(\"kotlin.jvm.internal.\" + classId.shortClassName.asString() + \"CompanionObject\"))");
            length = next4.d(g.b);
            n.e(length, "classId.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)");
            c.a.b(bVar, length);
        }
        i2 = i4;
        next = i2 + 1;
        i = c.a;
        b bVar31 = new b(n.o("kotlin.jvm.functions.Function", Integer.valueOf(i2)));
        a aVar23 = a.m(bVar31);
        n.e(aVar23, "topLevel(FqName(\"kotlin.jvm.functions.Function$i\"))");
        k kVar = k.a;
        i.b(aVar23, k.a(i2));
        bVar = new b(n.o(c.c, Integer.valueOf(i2)));
        i.d(bVar, c.h);
        while (next >= 23) {
            i2 = next;
            next = i2 + 1;
            i = c.a;
            bVar31 = new b(n.o("kotlin.jvm.functions.Function", Integer.valueOf(i2)));
            aVar23 = a.m(bVar31);
            n.e(aVar23, "topLevel(FqName(\"kotlin.jvm.functions.Function$i\"))");
            kVar = k.a;
            i.b(aVar23, k.a(i2));
            bVar = new b(n.o(c.c, Integer.valueOf(i2)));
            i.d(bVar, c.h);
        }
        i3 = i4 + 1;
        c kSuspendFunction = c.KSuspendFunction;
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(kSuspendFunction.getPackageFqName().toString());
        stringBuilder5.append(i12);
        stringBuilder5.append(kSuspendFunction.getClassNamePrefix());
        i = c.a;
        bVar = new b(n.o(stringBuilder5.toString(), Integer.valueOf(i4)));
        i.d(bVar, c.h);
        while (i3 >= true) {
            i4 = i3;
            i3 = i4 + 1;
            kSuspendFunction = c.KSuspendFunction;
            stringBuilder5 = new StringBuilder();
            stringBuilder5.append(kSuspendFunction.getPackageFqName().toString());
            stringBuilder5.append(i12);
            stringBuilder5.append(kSuspendFunction.getClassNamePrefix());
            i = c.a;
            bVar = new b(n.o(stringBuilder5.toString(), Integer.valueOf(i4)));
            i.d(bVar, c.h);
        }
        b bVar2 = k.a.c.l();
        n.e(bVar2, "nothing.toSafe()");
        i.d(bVar2, i.h(Void.class));
    }

    public static final a a(kotlin.i0.z.e.m0.b.q.c c, Class class2) {
        return c.h(class2);
    }

    private final void b(a a, a a2) {
        c(a, a2);
        final b obj3 = a2.b();
        n.e(obj3, "kotlinClassId.asSingleFqName()");
        d(obj3, a);
    }

    private final void c(a a, a a2) {
        c obj3 = a.b().j();
        n.e(obj3, "javaClassId.asSingleFqName().toUnsafe()");
        c.i.put(obj3, a2);
    }

    private final void d(b b, a a2) {
        final c obj3 = b.j();
        n.e(obj3, "kotlinFqNameUnsafe.toUnsafe()");
        c.j.put(obj3, a2);
    }

    private final void e(kotlin.i0.z.e.m0.b.q.c.a c$a) {
        a aVar = a.a();
        a aVar2 = a.b();
        a obj5 = a.c();
        b(aVar, aVar2);
        b bVar3 = obj5.b();
        String str3 = "mutableClassId.asSingleFqName()";
        n.e(bVar3, str3);
        d(bVar3, aVar);
        b bVar = aVar2.b();
        n.e(bVar, "readOnlyClassId.asSingleFqName()");
        b bVar2 = obj5.b();
        n.e(bVar2, str3);
        obj5 = obj5.b().j();
        n.e(obj5, "mutableClassId.asSingleFqName().toUnsafe()");
        c.k.put(obj5, bVar);
        c cVar = bVar.j();
        n.e(cVar, "readOnlyFqName.toUnsafe()");
        c.l.put(cVar, bVar2);
    }

    private final void f(Class<?> class, b b2) {
        final a obj3 = a.m(b2);
        n.e(obj3, "topLevel(kotlinFqName)");
        b(h(class), obj3);
    }

    private final void g(Class<?> class, c c2) {
        final b obj3 = c2.l();
        n.e(obj3, "kotlinFqName.toSafe()");
        f(class, obj3);
    }

    private final a h(Class<?> class) {
        boolean primitive;
        String str;
        a obj2;
        if (!class.isPrimitive()) {
            primitive = class.isArray();
        }
        Class declaringClass = class.getDeclaringClass();
        if (declaringClass == null) {
            b bVar = new b(class.getCanonicalName());
            n.e(a.m(bVar), "topLevel(FqName(clazz.canonicalName))");
        } else {
            n.e(h(declaringClass).d(e.j(class.getSimpleName())), "classId(outer).createNestedClassId(Name.identifier(clazz.simpleName))");
        }
        return obj2;
    }

    private final boolean k(c c, String string2) {
        int i;
        int i3;
        int i2;
        int obj5;
        int obj6;
        obj5 = c.b();
        n.e(obj5, "kotlinFqName.asString()");
        obj5 = l.N0(obj5, string2, "");
        final int i4 = 0;
        obj6 = obj5.length() > 0 ? i : i4;
        if (obj6 != null && !l.J0(obj5, '0', i4, 2, 0)) {
            if (!l.J0(obj5, '0', i4, 2, 0)) {
                obj5 = l.m(obj5);
                if (obj5 != null && obj5.intValue() >= 23) {
                    if (obj5.intValue() >= 23) {
                    } else {
                        i = i4;
                    }
                } else {
                }
                return i;
            }
        }
        return i4;
    }

    public final b i() {
        return c.g;
    }

    public final List<kotlin.i0.z.e.m0.b.q.c.a> j() {
        return c.m;
    }

    public final boolean l(c c) {
        final HashMap map = c.k;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return map.containsKey(c);
    }

    public final boolean m(c c) {
        final HashMap map = c.l;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return map.containsKey(c);
    }

    public final a n(b b) {
        n.f(b, "fqName");
        return (a)c.i.get(b.j());
    }

    public final a o(c c) {
        boolean z;
        Object obj2;
        n.f(c, "kotlinFqName");
        if (k(c, c.b)) {
            obj2 = c.f;
        } else {
            if (k(c, c.d)) {
                obj2 = c.f;
            } else {
                if (k(c, c.c)) {
                    obj2 = c.h;
                } else {
                    if (k(c, c.e)) {
                        obj2 = c.h;
                    } else {
                        obj2 = c.j.get(c);
                    }
                }
            }
        }
        return obj2;
    }

    public final b p(c c) {
        return (b)c.k.get(c);
    }

    public final b q(c c) {
        return (b)c.l.get(c);
    }
}
