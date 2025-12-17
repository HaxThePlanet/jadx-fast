package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.d0.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.d;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.j0.h;
import kotlin.j0.i;
import kotlin.k0.l;
import kotlin.u;
import kotlin.y.i;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class b {

    private static final List<d<? extends Object>> a;
    private static final Map<Class<? extends Object>, Class<? extends Object>> b;
    private static final Map<Class<? extends Object>, Class<? extends Object>> c;
    private static final Map<Class<? extends d<?>>, Integer> d;

    static final class a extends p implements l<ParameterizedType, ParameterizedType> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.b.a a;
        static {
            b.a aVar = new b.a();
            b.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final ParameterizedType a(ParameterizedType parameterizedType) {
            Type obj2;
            n.f(parameterizedType, "it");
            if (obj2 instanceof ParameterizedType) {
            } else {
                obj2 = 0;
            }
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((ParameterizedType)object);
        }
    }

    static final class b extends p implements l<ParameterizedType, h<? extends Type>> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.b.b a;
        static {
            b.b bVar = new b.b();
            b.b.a = bVar;
        }

        b() {
            super(1);
        }

        public final h<Type> a(ParameterizedType parameterizedType) {
            n.f(parameterizedType, "it");
            Type[] obj2 = parameterizedType.getActualTypeArguments();
            n.e(obj2, "it.actualTypeArguments");
            return i.r(obj2);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((ParameterizedType)object);
        }
    }
    static {
        int i;
        int i4;
        int i2;
        int i5;
        int i3;
        Class cls;
        int i6 = 8;
        d[] arr = new d[i6];
        i4 = 0;
        arr[i4] = c0.b(Boolean.TYPE);
        i2 = 1;
        arr[i2] = c0.b(Byte.TYPE);
        final int i22 = 2;
        arr[i22] = c0.b(Character.TYPE);
        final int i23 = 3;
        arr[i23] = c0.b(Double.TYPE);
        final int i24 = 4;
        arr[i24] = c0.b(Float.TYPE);
        final int i25 = 5;
        arr[i25] = c0.b(Integer.TYPE);
        final int i26 = 6;
        arr[i26] = c0.b(Long.TYPE);
        final int i27 = 7;
        arr[i27] = c0.b(Short.TYPE);
        List list2 = p.j(arr);
        b.a = list2;
        final int i28 = 10;
        ArrayList arrayList2 = new ArrayList(p.r(list2, i28));
        Iterator iterator2 = list2.iterator();
        for (d next6 : iterator2) {
            arrayList2.add(u.a(a.c(next6), a.d(next6)));
        }
        b.b = j0.s(arrayList2);
        List list3 = b.a;
        ArrayList arrayList3 = new ArrayList(p.r(list3, i28));
        Iterator iterator3 = list3.iterator();
        for (d next5 : iterator3) {
            arrayList3.add(u.a(a.d(next5), a.c(next5)));
        }
        b.c = j0.s(arrayList3);
        Class[] arr2 = new Class[23];
        arr2[i4] = a.class;
        arr2[i2] = l.class;
        arr2[i22] = p.class;
        arr2[i23] = q.class;
        arr2[i24] = r.class;
        arr2[i25] = s.class;
        arr2[i26] = t.class;
        arr2[i27] = u.class;
        arr2[i6] = v.class;
        arr2[9] = w.class;
        arr2[i28] = b.class;
        arr2[11] = c.class;
        arr2[12] = d.class;
        arr2[13] = e.class;
        arr2[14] = f.class;
        arr2[15] = g.class;
        arr2[16] = h.class;
        arr2[17] = i.class;
        arr2[18] = j.class;
        arr2[19] = k.class;
        arr2[20] = m.class;
        arr2[21] = n.class;
        arr2[22] = o.class;
        List list = p.j(arr2);
        ArrayList arrayList = new ArrayList(p.r(list, i28));
        Iterator iterator = list.iterator();
        for (Object next2 : iterator) {
            arrayList.add(u.a((Class)next2, Integer.valueOf(i4)));
            i4 = i2;
        }
        b.d = j0.s(arrayList);
    }

    public static final Class<?> a(Class<?> class) {
        n.f(class, "<this>");
        return Array.newInstance(class, 0).getClass();
    }

    public static final a b(Class<?> class) {
        int enclosingConstructor;
        a aVar;
        e i;
        String str;
        Object obj3;
        n.f(class, "<this>");
        if (class.isPrimitive()) {
        } else {
            if (class.isArray()) {
            } else {
                i = 1;
                if (class.getEnclosingMethod() == null && class.getEnclosingConstructor() == null) {
                    if (class.getEnclosingConstructor() == null) {
                        String simpleName = class.getSimpleName();
                        n.e(simpleName, "simpleName");
                        enclosingConstructor = simpleName.length() == 0 ? i : 0;
                        if (enclosingConstructor != 0) {
                            b bVar2 = new b(class.getName());
                            obj3 = new a(bVar2.e(), b.k(bVar2.g()), i);
                            aVar = obj3;
                        } else {
                            Class declaringClass = class.getDeclaringClass();
                            if (declaringClass == null) {
                                aVar = 0;
                            } else {
                                aVar = b.b(declaringClass).d(e.j(class.getSimpleName()));
                            }
                            if (aVar == null) {
                                b bVar = new b(class.getName());
                                aVar = a.m(bVar);
                            }
                            n.e(aVar, "declaringClass?.classId?.createNestedClassId(Name.identifier(simpleName)) ?: ClassId.topLevel(FqName(name))");
                        }
                    } else {
                    }
                } else {
                }
                return aVar;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(n.o("Can't compute ClassId for array type: ", class));
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(n.o("Can't compute ClassId for primitive type: ", class));
        throw illegalArgumentException2;
    }

    public static final String c(Class<?> class) {
        n.f(class, "<this>");
        if (n.b(class, Void.TYPE)) {
            return "V";
        }
        String obj7 = b.a(class).getName();
        n.e(obj7, "createArrayType().name");
        final String substring = obj7.substring(1);
        n.e(substring, "(this as java.lang.String).substring(startIndex)");
        return l.F(substring, '.', '/', false, 4, 0);
    }

    public static final Integer d(Class<?> class) {
        n.f(class, "<this>");
        return (Integer)b.d.get(class);
    }

    public static final List<Type> e(Type type) {
        n.f(type, "<this>");
        if (!type instanceof ParameterizedType) {
            return p.g();
        }
        Object obj = type;
        if ((ParameterizedType)obj.getOwnerType() == null) {
            Type[] obj2 = obj.getActualTypeArguments();
            n.e(obj2, "actualTypeArguments");
            return i.a0(obj2);
        }
        return i.A(i.p(i.f(type, b.a.a), b.b.a));
    }

    public static final Class<?> f(Class<?> class) {
        n.f(class, "<this>");
        return (Class)b.b.get(class);
    }

    public static final java.lang.ClassLoader g(Class<?> class) {
        String str;
        java.lang.ClassLoader obj1;
        n.f(class, "<this>");
        if (class.getClassLoader() == null) {
            n.e(ClassLoader.getSystemClassLoader(), "getSystemClassLoader()");
        }
        return obj1;
    }

    public static final Class<?> h(Class<?> class) {
        n.f(class, "<this>");
        return (Class)b.c.get(class);
    }

    public static final boolean i(Class<?> class) {
        n.f(class, "<this>");
        return Enum.class.isAssignableFrom(class);
    }
}
