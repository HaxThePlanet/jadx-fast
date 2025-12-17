package kotlin.i0.z.e;

import f.g.b.a.e;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.p;
import kotlin.d0.d.c;
import kotlin.d0.d.n;
import kotlin.i0.o;
import kotlin.i0.t;
import kotlin.i0.z.e.l0.b;
import kotlin.i0.z.e.m0.b.q.c;
import kotlin.i0.z.e.m0.d.b.q;
import kotlin.i0.z.e.m0.e.i;
import kotlin.i0.z.e.m0.e.n;
import kotlin.i0.z.e.m0.e.z.a;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.e.z.g;
import kotlin.i0.z.e.m0.e.z.i;
import kotlin.i0.z.e.m0.e.z.i.a;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.f;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.i.q.q.b.a;
import kotlin.i0.z.e.m0.i.q.q.b.b;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.j.b.l;
import kotlin.i0.z.e.m0.j.b.u;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.k0.l;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.a.b;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.a.e;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.a.f;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.a.k;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.a.m.a;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.b;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.c;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class j0 {

    private static final b a;
    static {
        b bVar = new b("kotlin.jvm.JvmStatic");
        j0.a = bVar;
    }

    public static final kotlin.i0.z.e.f<?> a(Object object) {
        Object obj;
        obj = !object instanceof f ? 0 : object;
        if ((f)obj != null) {
        } else {
            obj = j0.b(object);
        }
        if (obj != null) {
        } else {
            obj = j0.c(object);
        }
        return obj;
    }

    public static final kotlin.i0.z.e.k b(Object object) {
        int i;
        int i2;
        Object obj2;
        i2 = 0;
        i = !object instanceof k ? i2 : object;
        if ((k)i != 0) {
        } else {
            if (!object instanceof j) {
                obj2 = i2;
            }
            if ((j)obj2 != null) {
                obj2 = (j)obj2.compute();
            } else {
                obj2 = i2;
            }
            if (!obj2 instanceof k) {
            } else {
                i2 = obj2;
            }
            i = i2;
        }
        return i;
    }

    public static final kotlin.i0.z.e.t<?> c(Object object) {
        int i2;
        int i;
        Object obj2;
        i = 0;
        i2 = !object instanceof t ? i : object;
        if ((t)i2 != 0) {
        } else {
            if (!object instanceof y) {
                obj2 = i;
            }
            if ((y)obj2 != null) {
                obj2 = (y)obj2.compute();
            } else {
                obj2 = i;
            }
            if (!obj2 instanceof t) {
            } else {
                i = obj2;
            }
            i2 = i;
        }
        return i2;
    }

    public static final List<Annotation> d(a a) {
        Object next;
        kotlin.reflect.jvm.internal.impl.descriptors.u0 source;
        boolean z;
        Annotation annotation;
        n.f(a, "$this$computeAnnotations");
        ArrayList arrayList = new ArrayList();
        Iterator obj5 = a.getAnnotations().iterator();
        while (obj5.hasNext()) {
            next = obj5.next();
            source = (c)next.getSource();
            if (source instanceof b) {
            } else {
            }
            if (source instanceof m.a) {
            } else {
            }
            annotation = j0.m(next);
            if (annotation != null) {
            }
            arrayList.add(annotation);
            if (!next instanceof c) {
            }
            if ((c)next != null) {
            }
            annotation = (c)next.Q();
            next = annotation;
            annotation = (b)source.d();
        }
        return arrayList;
    }

    public static final Object e(Type type) {
        boolean primitive;
        int i;
        Boolean obj3;
        n.f(type, "type");
        if (type instanceof Class && (Class)type.isPrimitive()) {
            if ((Class)type.isPrimitive()) {
                if (n.b(type, Boolean.TYPE)) {
                    obj3 = Boolean.FALSE;
                    return obj3;
                } else {
                    i = 0;
                    if (n.b(type, Character.TYPE)) {
                        obj3 = Character.valueOf((char)i);
                    } else {
                        if (n.b(type, Byte.TYPE)) {
                            obj3 = Byte.valueOf((byte)i);
                        } else {
                            if (n.b(type, Short.TYPE)) {
                                obj3 = Short.valueOf((short)i);
                            } else {
                                if (n.b(type, Integer.TYPE)) {
                                    obj3 = Integer.valueOf(i);
                                } else {
                                    if (n.b(type, Float.TYPE)) {
                                        obj3 = 0f;
                                    } else {
                                        if (n.b(type, Long.TYPE)) {
                                            obj3 = Long.valueOf(0);
                                        } else {
                                            if (n.b(type, Double.TYPE)) {
                                                obj3 = Double.valueOf(0);
                                            } else {
                                                if (n.b(type, Void.TYPE)) {
                                                    obj3 = new IllegalStateException("Parameter with void type is illegal");
                                                    throw obj3;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown primitive: ");
                stringBuilder.append(type);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder.toString());
                throw unsupportedOperationException;
            }
        }
        obj3 = 0;
    }

    public static final <M extends kotlin.reflect.jvm.internal.impl.protobuf.o, D extends a> D f(Class<?> class, M m2, c c3, g g4, a a5, p<? super u, ? super M, ? extends D> p6) {
        List list;
        Object obj = m2;
        Object obj2 = p6;
        Object obj3 = class;
        n.f(class, "moduleAnchor");
        n.f(m2, "proto");
        n.f(c3, "nameResolver");
        n.f(g4, "typeTable");
        n.f(a5, "metadataVersion");
        n.f(obj2, "createDescriptor");
        k kVar = b0.a(class);
        if (obj instanceof i) {
            list = (i)obj.X();
            final List list2 = list;
            n.e(list2, "typeParameters");
            super(kVar.a(), c3, kVar.b(), g4, i.b.b(), a5, 0, 0, list2);
            u uVar = new u(lVar2);
            return (a)obj2.invoke(uVar, m2);
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported message: ");
        stringBuilder.append(m2);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString().toString());
        throw illegalStateException;
    }

    public static final r0 g(a a) {
        Object str;
        r0 obj1;
        n.f(a, "$this$instanceReceiverParameter");
        if (a.f0() != null) {
            obj1 = a.b();
            Objects.requireNonNull(obj1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            obj1 = (e)obj1.I0();
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    public static final b h() {
        return j0.a;
    }

    public static final boolean i(o o) {
        int i;
        Object obj1;
        n.f(o, "$this$isInlineClassType");
        if (!o instanceof w) {
            obj1 = 0;
        }
        obj1 = (w)obj1.l();
        if (obj1 != null && obj1 != null && f.c(obj1) == 1) {
            obj1 = obj1.l();
            if (obj1 != null) {
                if (f.c(obj1) == 1) {
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static final Class<?> j(java.lang.ClassLoader classLoader, String string2, String string3, int i4) {
        boolean equals;
        Object stringBuilder;
        Object obj2;
        int i;
        String obj8;
        Object obj9;
        int obj10;
        if (n.b(string2, "kotlin")) {
            switch (string3) {
                case "BooleanArray":
                    return boolean[].class;
                case "ShortArray":
                    return short[].class;
                case "CharArray":
                    return char[].class;
                case "ByteArray":
                    return byte[].class;
                case "DoubleArray":
                    return double[].class;
                case "Array":
                    return Object[].class;
                case "IntArray":
                    return int[].class;
                case "FloatArray":
                    return float[].class;
                case "LongArray":
                    return long[].class;
                default:
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append('.');
        stringBuilder.append(l.F(string3, '.', '$', false, 4, 0));
        if (i4 > 0) {
            obj9 = new StringBuilder();
            obj9.append(l.C("[", i4));
            obj9.append('L');
            obj9.append(stringBuilder.toString());
            obj9.append(';');
            obj8 = obj9.toString();
        }
        return e.a(classLoader, obj8);
    }

    private static final Class<?> k(java.lang.ClassLoader classLoader, a a2, int i3) {
        a obj4;
        kotlin.i0.z.e.m0.f.c cVar2 = a2.b().j();
        n.e(cVar2, "kotlinClassId.asSingleFqName().toUnsafe()");
        a aVar = c.a.o(cVar2);
        if (aVar != null) {
            obj4 = aVar;
        }
        String str = obj4.h().b();
        n.e(str, "javaClassId.packageFqName.asString()");
        obj4 = obj4.i().b();
        n.e(obj4, "javaClassId.relativeClassName.asString()");
        return j0.j(classLoader, str, obj4, i3);
    }

    static Class l(java.lang.ClassLoader classLoader, a a2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 4 != 0) {
            obj2 = 0;
        }
        return j0.k(classLoader, a2, obj2);
    }

    private static final Annotation m(c c) {
        Class cls;
        o oVar;
        String key;
        java.lang.ClassLoader classLoader;
        String str;
        e eVar = a.f(c);
        final int i = 0;
        if (eVar != null) {
            cls = j0.n(eVar);
        } else {
            cls = i;
        }
        if (!cls instanceof Class) {
            cls = i;
        }
        if (cls != null) {
            ArrayList arrayList = new ArrayList();
            Iterator obj7 = c.a().entrySet().iterator();
            while (obj7.hasNext()) {
                Object next2 = obj7.next();
                classLoader = cls.getClassLoader();
                n.e(classLoader, "annotationClass.classLoader");
                Object obj = j0.p((g)next2.getValue(), classLoader);
                if (obj != null) {
                } else {
                }
                oVar = i;
                if (oVar != null) {
                }
                arrayList.add(oVar);
                oVar = u.a((e)(Map.Entry)next2.getKey().c(), obj);
            }
            return (Annotation)b.d(cls, j0.s(arrayList), i, 4, i);
        }
        return i;
    }

    public static final Class<?> n(e e) {
        Object str;
        boolean z;
        Class obj2;
        n.f(e, "$this$toJavaClass");
        kotlin.reflect.jvm.internal.impl.descriptors.u0 source = e.getSource();
        n.e(source, "source");
        if (source instanceof q) {
            obj2 = (q)source.d();
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            obj2 = (f)obj2.d();
            return obj2;
        } else {
            if (source instanceof m.a) {
                obj2 = (m.a)source.d();
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
                obj2 = (j)obj2.U();
            } else {
                str = a.h(e);
                if (str != null) {
                    obj2 = j0.k(b.g(e.getClass()), str, 0);
                }
            }
        }
        return 0;
    }

    public static final t o(u u) {
        boolean z;
        t obj1;
        n.f(u, "$this$toKVisibility");
        if (n.b(u, t.e)) {
            obj1 = t.PUBLIC;
        } else {
            if (n.b(u, t.c)) {
                obj1 = t.PROTECTED;
            } else {
                if (n.b(u, t.d)) {
                    obj1 = t.INTERNAL;
                } else {
                    if (n.b(u, t.a)) {
                        obj1 = t.PRIVATE;
                    } else {
                        if (n.b(u, t.b)) {
                        } else {
                            obj1 = 0;
                        }
                    }
                }
            }
        }
        return obj1;
    }

    private static final Object p(g<?> g, java.lang.ClassLoader classLoader2) {
        boolean arrayList;
        int i;
        Annotation array;
        int i2;
        int i3;
        kotlin.reflect.jvm.internal.impl.descriptors.h obj4;
        java.lang.ClassLoader obj5;
        array = 0;
        if (g instanceof a) {
            array = j0.m((c)(a)g.b());
        } else {
            i2 = 0;
            if (g instanceof b) {
                obj4 = (b)g.b();
                arrayList = new ArrayList(p.r((Iterable)obj4, 10));
                obj4 = obj4.iterator();
                for (g next2 : obj4) {
                    arrayList.add(j0.p(next2, classLoader2));
                }
                Objects.requireNonNull(arrayList.toArray(new Object[i2]), "null cannot be cast to non-null type kotlin.Array<T>");
            } else {
                if (g instanceof j) {
                    obj4 = (j)g.b();
                    obj5 = j0.l(classLoader2, (a)(o)obj4.a(), i2, 4, array);
                    if (obj5 != null) {
                        Objects.requireNonNull(obj5, "null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
                        array = i0.a(obj5, (e)obj4.b().c());
                    }
                } else {
                    if (g instanceof q) {
                        obj4 = (q)g.b();
                        if (obj4 instanceof q.b.b) {
                            array = j0.k(classLoader2, (q.b.b)(q.b)obj4.b(), obj4.a());
                        } else {
                            if (!obj4 instanceof q.b.a) {
                            } else {
                                if (!obj4 instanceof e) {
                                    obj4 = array;
                                }
                                if ((e)obj4 != null) {
                                    array = j0.n((e)obj4);
                                }
                            }
                        }
                        obj4 = new NoWhenBranchMatchedException();
                        throw obj4;
                    }
                    if (g instanceof k) {
                    } else {
                        if (g instanceof s) {
                        } else {
                            array = g.b();
                        }
                    }
                }
            }
        }
        return array;
    }
}
