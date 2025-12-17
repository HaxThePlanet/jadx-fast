package kotlin.i0.z.e;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.d;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.h.c;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.i.v.k.a;
import kotlin.k0.f;
import kotlin.k0.f.b;
import kotlin.k0.h;
import kotlin.k0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.a.e;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.a.k;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.b;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.w;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class j implements d {

    private static final Class<?> a;
    private static final h b;
    public static final kotlin.i0.z.e.j.a c;

    public static final class a {
        public a(g g) {
            super();
        }

        public final h a() {
            return j.j();
        }
    }

    public abstract class b {

        static final l[] c;
        private final kotlin.i0.z.e.c0.a a;
        final kotlin.i0.z.e.j b;
        static {
            l[] arr = new l[1];
            x xVar = new x(c0.b(j.b.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;");
            j.b.c = arr;
        }

        public b(kotlin.i0.z.e.j j) {
            this.b = j;
            super();
            j.b.a obj1 = new j.b.a(this);
            this.a = c0.d(obj1);
        }

        public final k a() {
            return (k)this.a.b(this, j.b.c[0]);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0008\u0084\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007j\u0002\u0008\nj\u0002\u0008\u000b¨\u0006\u000c", d2 = {"kotlin/i0/z/e/j$c", "", "Lkotlin/i0/z/e/j$c;", "Lkotlin/reflect/jvm/internal/impl/descriptors/b;", "member", "", "accept", "(Lkotlin/reflect/jvm/internal/impl/descriptors/b;)Z", "<init>", "(Ljava/lang/String;I)V", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    protected static enum c {

        DECLARED,
        INHERITED;
        @Override // java.lang.Enum
        public final boolean accept(b b) {
            int i2;
            int i;
            n.f(b, "member");
            b.a obj4 = b.f();
            n.e(obj4, "member.kind");
            final int i3 = 0;
            i2 = this == j.c.DECLARED ? i : i3;
            if (obj4.isReal() == i2) {
            } else {
                i = i3;
            }
            return i;
        }
    }

    static final class f implements Comparator<u> {

        public static final kotlin.i0.z.e.j.f a;
        static {
            j.f fVar = new j.f();
            j.f.a = fVar;
        }

        @Override // java.util.Comparator
        public final int a(u u, u u2) {
            int obj1;
            obj1 = t.d(u, u2);
            if (obj1 != null) {
                obj1 = obj1.intValue();
            } else {
                obj1 = 0;
            }
            return obj1;
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((u)object, (u)object2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/x;", "descriptor", "", "a", "(Lkotlin/reflect/jvm/internal/impl/descriptors/x;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 4, 1})
    static final class d extends p implements l<x, java.lang.CharSequence> {

        public static final kotlin.i0.z.e.j.d a;
        static {
            j.d dVar = new j.d();
            j.d.a = dVar;
        }

        d() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence a(x x) {
            n.f(x, "descriptor");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c.c.r(x));
            stringBuilder.append(" | ");
            stringBuilder.append(g0.b.g(x).a());
            return stringBuilder.toString();
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((x)object);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/o0;", "descriptor", "", "a", "(Lkotlin/reflect/jvm/internal/impl/descriptors/o0;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 4, 1})
    static final class e extends p implements l<o0, java.lang.CharSequence> {

        public static final kotlin.i0.z.e.j.e a;
        static {
            j.e eVar = new j.e();
            j.e.a = eVar;
        }

        e() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence a(o0 o0) {
            n.f(o0, "descriptor");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c.c.r(o0));
            stringBuilder.append(" | ");
            stringBuilder.append(g0.b.f(o0).a());
            return stringBuilder.toString();
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((o0)object);
        }
    }

    public static final class g extends kotlin.i0.z.e.a {
        g(kotlin.i0.z.e.j j, kotlin.i0.z.e.j j2) {
            super(j2);
        }

        @Override // kotlin.i0.z.e.a
        public Object h(l l, Object object2) {
            r(l, (w)object2);
            throw 0;
        }

        public kotlin.i0.z.e.f<?> r(l l, w w2) {
            n.f(l, "descriptor");
            n.f(w2, "data");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No constructors should appear here: ");
            stringBuilder.append(l);
            IllegalStateException obj4 = new IllegalStateException(stringBuilder.toString());
            throw obj4;
        }
    }
    static {
        j.a aVar = new j.a(0);
        j.c = aVar;
        j.a = Class.forName("kotlin.d0.d.g");
        h hVar = new h("<v#(\\d+)>");
        j.b = hVar;
    }

    private final List<Class<?>> E(String string) {
        int i5;
        int i;
        Class cls;
        int charAt2;
        int charAt;
        int i2;
        int i3;
        int i6;
        int str;
        int i4;
        ArrayList arrayList = new ArrayList();
        int i7 = 1;
        i4 = i7;
        while (string.charAt(i4) != 41) {
            i = i4;
            while (string.charAt(i) == 91) {
                i++;
            }
            charAt = string.charAt(i);
            i9 += i7;
            arrayList.add(H(string, i4, i5));
            i4 = i5;
            i++;
            i++;
        }
        return arrayList;
    }

    private final Class<?> F(String string) {
        return H(string, i++, string.length());
    }

    private final Method G(Class<?> class, String string2, Class<?>[] class3Arr3, Class<?> class4, boolean z5) {
        Method method;
        Object obj;
        int i;
        Class superclass;
        String string;
        Class[] str;
        Class cls2;
        boolean z;
        boolean z2;
        Class cls;
        final int i2 = 0;
        if (z5) {
            class3Arr3[i2] = class;
        }
        method = J(class, string2, class3Arr3, class4);
        if (method != null) {
            return method;
        }
        superclass = class.getSuperclass();
        method = this.G(superclass, string2, class3Arr3, class4, z5);
        if (superclass != null && method != null) {
            method = this.G(superclass, string2, class3Arr3, class4, z5);
            if (method != null) {
                return method;
            }
        }
        Class[] obj11 = class.getInterfaces();
        i = i2;
        while (i < obj11.length) {
            cls = obj11[i];
            n.e(cls, "superInterface");
            superclass = this.G(cls, string2, class3Arr3, class4, z5);
            i++;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(cls.getName());
            stringBuilder.append("$DefaultImpls");
            superclass = e.a(b.g(cls), stringBuilder.toString());
            class3Arr3[i2] = cls;
            superclass = J(superclass, string2, class3Arr3, class4);
        }
        return null;
    }

    private final Class<?> H(String string, int i2, int i3) {
        char charAt;
        int str;
        String substring;
        int i6;
        int i;
        int i4;
        int i5;
        int i7;
        Class obj9;
        int obj10;
        int obj11;
        charAt = string.charAt(i2);
        if (charAt != 70) {
            if (charAt != 76) {
                if (charAt != 83) {
                    if (charAt != 86) {
                        if (charAt != 73) {
                            if (charAt != 74) {
                                if (charAt != 90) {
                                    if (charAt != 91) {
                                        switch (charAt) {
                                            case 66:
                                                obj9 = Byte.TYPE;
                                                break;
                                            case 67:
                                                obj9 = Character.TYPE;
                                                break;
                                            case 68:
                                                obj9 = Double.TYPE;
                                                break;
                                            default:
                                                obj11 = new StringBuilder();
                                                obj11.append("Unknown type prefix in the method signature: ");
                                                obj11.append(string);
                                                obj10 = new a0(obj11.toString());
                                                throw obj10;
                                        }
                                    }
                                    obj9 = b.a(H(string, i2++, i3));
                                } else {
                                    obj9 = Boolean.TYPE;
                                }
                            } else {
                                obj9 = Long.TYPE;
                            }
                        } else {
                            obj9 = Integer.TYPE;
                        }
                    } else {
                        n.e(Void.TYPE, "Void.TYPE");
                    }
                } else {
                    obj9 = Short.TYPE;
                }
            } else {
                Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
                substring = string.substring(i2++, i3--);
                n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                n.e(b.g(d()).loadClass(l.F(substring, '/', '.', false, 4, 0)), "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
            }
        } else {
            obj9 = Float.TYPE;
        }
        return obj9;
    }

    private final Constructor<?> I(Class<?> class, List<? extends Class<?>> list2) {
        Constructor obj2;
        Object[] obj3 = list2.toArray(new Class[0]);
        if (obj3 == null) {
        } else {
            try {
                obj2 = class.getDeclaredConstructor((Class[])Arrays.copyOf((Class[])obj3, obj3.length));
                obj2 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                throw obj2;
                class = 0;
                return obj2;
            }
        }
    }

    private final Method J(Class<?> class, String string2, Class<?>[] class3Arr3, Class<?> class4) {
        int i3;
        int declaredMethod;
        int z;
        int i2;
        Method method;
        int i;
        boolean equals;
        Method[] obj7;
        i3 = 0;
        declaredMethod = class.getDeclaredMethod(string2, (Class[])Arrays.copyOf(class3Arr3, class3Arr3.length));
        n.e(declaredMethod, "result");
        if (n.b(declaredMethod.getReturnType(), class4)) {
            try {
                i3 = declaredMethod;
                obj7 = class.getDeclaredMethods();
                n.e(obj7, "declaredMethods");
                z = 0;
                i2 = z;
                while (i2 < obj7.length) {
                    method = obj7[i2];
                    n.e(method, "method");
                    Class[] parameterTypes = method.getParameterTypes();
                    n.d(parameterTypes);
                    if (n.b(method.getName(), string2) && n.b(method.getReturnType(), class4) && Arrays.equals(parameterTypes, class3Arr3)) {
                    } else {
                    }
                    i = z;
                    if (i != 0) {
                        break;
                    } else {
                    }
                    i2++;
                    if (n.b(method.getReturnType(), class4)) {
                    } else {
                    }
                    parameterTypes = method.getParameterTypes();
                    n.d(parameterTypes);
                    if (Arrays.equals(parameterTypes, class3Arr3)) {
                    } else {
                    }
                    i = 1;
                }
                method = obj7[i2];
                n.e(method, "method");
                parameterTypes = method.getParameterTypes();
                n.d(parameterTypes);
                if (n.b(method.getName(), string2) && n.b(method.getReturnType(), class4) && Arrays.equals(parameterTypes, class3Arr3)) {
                } else {
                }
                if (n.b(method.getReturnType(), class4)) {
                } else {
                }
                parameterTypes = method.getParameterTypes();
                n.d(parameterTypes);
                if (Arrays.equals(parameterTypes, class3Arr3)) {
                } else {
                }
                i = 1;
                i = z;
                if (i != 0) {
                } else {
                }
                i3 = method;
                i2++;
                return i3;
            }
        } else {
        }
    }

    public static final h j() {
        return j.b;
    }

    private final void r(List<Class<?>> list, String string2, boolean z3) {
        int i;
        Class tYPE;
        String str;
        Class<Object> obj5;
        obj5 = E(string2);
        list.addAll(obj5);
        i = 0;
        while (i < obj5 /= 32) {
            tYPE = Integer.TYPE;
            n.e(tYPE, "Integer.TYPE");
            list.add(tYPE);
            i++;
        }
        obj5 = z3 ? j.a : Object.class;
        n.e(obj5, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(obj5);
    }

    @Override // kotlin.d0.d.d
    public abstract o0 A(int i);

    protected final Collection<kotlin.i0.z.e.f<?>> B(h h, kotlin.i0.z.e.j.c j$c2) {
        Object obj;
        w accept;
        int i;
        u uVar;
        n.f(h, "scope");
        n.f(c2, "belonginess");
        j.g gVar = new j.g(this, this);
        final int i2 = 0;
        ArrayList arrayList = new ArrayList();
        Iterator obj8 = k.a.a(h, i2, i2, 3, i2).iterator();
        while (obj8.hasNext()) {
            Object next2 = obj8.next();
            accept = next2;
            if (next2 instanceof b && z ^= 1 != 0 && c2.accept(accept)) {
            } else {
            }
            obj = i2;
            if (obj != null) {
            }
            arrayList.add(obj);
            accept = next2;
            if (z ^= 1 != 0) {
            } else {
            }
            if (c2.accept(accept)) {
            } else {
            }
            obj = (m)next2.K(gVar, w.a);
        }
        return p.L0(arrayList);
    }

    protected Class<?> C() {
        Class cls;
        if (b.h(d()) != null) {
        } else {
            cls = d();
        }
        return cls;
    }

    public abstract Collection<o0> D(e e);

    public final Constructor<?> s(String string) {
        n.f(string, "desc");
        return I(d(), E(string));
    }

    public final Constructor<?> t(String string) {
        n.f(string, "desc");
        ArrayList arrayList = new ArrayList();
        r(arrayList, string, true);
        w obj4 = w.a;
        return I(d(), arrayList);
    }

    @Override // kotlin.d0.d.d
    public final Method u(String string, String string2, boolean z3) {
        Class cls;
        n.f(string, "name");
        n.f(string2, "desc");
        if (n.b(string, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z3) {
            arrayList.add(d());
        }
        int i = 0;
        r(arrayList, string2, i);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("$default");
        Object[] obj9 = arrayList.toArray(new Class[i]);
        Objects.requireNonNull(obj9, "null cannot be cast to non-null type kotlin.Array<T>");
        return this.G(C(), stringBuilder.toString(), (Class[])obj9, F(string2), z3);
    }

    @Override // kotlin.d0.d.d
    public final x v(String string, String string2) {
        Object obj;
        String str;
        Object next;
        boolean z;
        kotlin.i0.z.e.g0 g0Var;
        int i;
        String obj12;
        Object obj13;
        n.f(string, "name");
        n.f(string2, "signature");
        if (n.b(string, "<init>")) {
            obj = p.L0(y());
        } else {
            e eVar = e.j(string);
            n.e(eVar, "Name.identifier(name)");
            obj = z(eVar);
        }
        List list = obj;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (n.b(g0.b.g((x)next).a(), string2)) {
            }
            arrayList.add(next);
        }
        if (arrayList.size() != 1) {
            String str5 = p.h0(list, "\n", 0, 0, 0, 0, j.d.a, 30, 0);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Function '");
            stringBuilder.append(string);
            stringBuilder.append("' (JVM signature: ");
            stringBuilder.append(string2);
            stringBuilder.append(") not resolved in ");
            stringBuilder.append(this);
            stringBuilder.append(':');
            if (str5.length() == 0) {
            } else {
                i = 0;
            }
            if (i != 0) {
                obj12 = " no members found";
            } else {
                obj12 = new StringBuilder();
                obj12.append('\n');
                obj12.append(str5);
                obj12 = obj12.toString();
            }
            stringBuilder.append(obj12);
            a0 a0Var = new a0(stringBuilder.toString());
            throw a0Var;
        }
        return (x)p.z0(arrayList);
    }

    @Override // kotlin.d0.d.d
    public final Method w(String string, String string2) {
        Object obj2;
        Class cls;
        Object obj;
        Object[] objArr;
        Class cls2;
        int i;
        Object obj10;
        n.f(string, "name");
        n.f(string2, "desc");
        final int i2 = 0;
        if (n.b(string, "<init>")) {
            return i2;
        }
        Object[] array = E(string2).toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        final Class obj11 = F(string2);
        Method method = this.G(C(), string, (Class[])array, obj11, false);
        if (method != null) {
            return method;
        }
        obj10 = this.G(Object.class, string, array, obj11, false);
        if (C().isInterface() && obj10 != null) {
            obj10 = this.G(Object.class, string, array, obj11, false);
            if (obj10 != null) {
                return obj10;
            }
        }
        return i2;
    }

    @Override // kotlin.d0.d.d
    public final o0 x(String string, String string2) {
        String string3;
        int obj;
        int i;
        Object next2;
        boolean z;
        kotlin.i0.z.e.g0 g0Var;
        Object next;
        u visibility;
        Object arrayList;
        final Object obj2 = this;
        Object obj3 = string;
        obj = string2;
        n.f(obj3, "name");
        n.f(obj, "signature");
        f fVar2 = j.b.c(obj);
        i = 1;
        if (fVar2 != null) {
            Object obj4 = fVar2.a().a().b().get(i);
            o0 o0Var = obj2.A(Integer.parseInt((String)obj4));
            if (o0Var == null) {
            } else {
                return o0Var;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Local property #");
            stringBuilder2.append(obj4);
            stringBuilder2.append(" not found in ");
            stringBuilder2.append(d());
            a0 a0Var = new a0(stringBuilder2.toString());
            throw a0Var;
        }
        e eVar = e.j(string);
        String str7 = "Name.identifier(name)";
        n.e(eVar, str7);
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator = obj2.D(eVar).iterator();
        while (iterator.hasNext()) {
            next2 = iterator.next();
            if (n.b(g0.b.f((o0)next2).a(), obj)) {
            }
            arrayList2.add(next2);
        }
        String str9 = ") not resolved in ";
        String str11 = "' (JVM signature: ";
        String str12 = "Property '";
        if (arrayList2.isEmpty()) {
        } else {
            if (arrayList2.size() != i) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator iterator2 = arrayList2.iterator();
                while (iterator2.hasNext()) {
                    next = iterator2.next();
                    visibility = (o0)next.getVisibility();
                    if (linkedHashMap.get(visibility) == null) {
                    }
                    (List)arrayList.add(next);
                    arrayList = new ArrayList();
                    linkedHashMap.put(visibility, arrayList);
                }
                Collection values = j0.g(linkedHashMap, j.f.a).values();
                n.e(values, "properties\n             …                }).values");
                Object obj7 = p.i0(values);
                if ((List)obj7.size() == i) {
                    n.e(obj7, "mostVisibleProperties");
                    return (o0)p.X(obj7);
                }
                e eVar2 = e.j(string);
                n.e(eVar2, str7);
                String str5 = p.h0(obj2.D(eVar2), "\n", 0, 0, 0, 0, j.e.a, 30, 0);
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(str12);
                stringBuilder4.append(obj3);
                stringBuilder4.append(str11);
                stringBuilder4.append(obj);
                stringBuilder4.append(str9);
                stringBuilder4.append(obj2);
                stringBuilder4.append(':');
                if (str5.length() == 0) {
                } else {
                    i = 0;
                }
                if (i != 0) {
                    string3 = " no members found";
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append('\n');
                    stringBuilder.append(str5);
                    string3 = stringBuilder.toString();
                }
                stringBuilder4.append(string3);
                a0 a0Var3 = new a0(stringBuilder4.toString());
                throw a0Var3;
            }
            return (o0)p.z0(arrayList2);
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str12);
        stringBuilder3.append(obj3);
        stringBuilder3.append(str11);
        stringBuilder3.append(obj);
        stringBuilder3.append(str9);
        stringBuilder3.append(obj2);
        a0 a0Var2 = new a0(stringBuilder3.toString());
        throw a0Var2;
    }

    public abstract Collection<l> y();

    public abstract Collection<x> z(e e);
}
