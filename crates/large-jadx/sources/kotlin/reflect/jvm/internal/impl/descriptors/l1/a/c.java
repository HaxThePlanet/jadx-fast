package kotlin.reflect.jvm.internal.impl.descriptors.l1.a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;
import kotlin.d0.a;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.i;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.b.q.c;
import kotlin.i0.z.e.m0.d.b.o.a;
import kotlin.i0.z.e.m0.d.b.o.b;
import kotlin.i0.z.e.m0.d.b.o.c;
import kotlin.i0.z.e.m0.d.b.o.d;
import kotlin.i0.z.e.m0.d.b.o.e;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.q.f;
import kotlin.i0.z.e.m0.i.t.d;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.b;
import kotlin.y.i;

/* loaded from: classes3.dex */
final class c {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.a.c a;
    static {
        c cVar = new c();
        c.a = cVar;
    }

    private final f a(Class<?> class) {
        int i;
        String str;
        Object obj5;
        i = 0;
        while (obj5.isArray()) {
            i++;
            n.e(obj5.getComponentType(), "currentClass.componentType");
        }
        if (obj5.isPrimitive() && n.b(obj5, Void.TYPE)) {
            if (n.b(obj5, Void.TYPE)) {
                a aVar2 = a.m(k.a.e.l());
                n.e(aVar2, "topLevel(StandardNames.FqNames.unit.toSafe())");
                obj5 = new f(aVar2, i);
                return obj5;
            }
            obj5 = d.get(obj5.getName()).getPrimitiveType();
            n.e(obj5, "get(currentClass.name).primitiveType");
            if (i > 0) {
                obj5 = a.m(obj5.getArrayTypeFqName());
                n.e(obj5, "topLevel(primitiveType.arrayTypeFqName)");
                f fVar2 = new f(obj5, i--);
                return fVar2;
            }
            obj5 = a.m(obj5.getTypeFqName());
            n.e(obj5, "topLevel(primitiveType.typeFqName)");
            f fVar3 = new f(obj5, i);
            return fVar3;
        }
        kotlin.i0.z.e.m0.f.b bVar2 = b.b(obj5).b();
        n.e(bVar2, "javaClassId.asSingleFqName()");
        a aVar = c.a.n(bVar2);
        if (aVar == null) {
        } else {
            obj5 = aVar;
        }
        f fVar = new f(obj5, i);
        return fVar;
    }

    private final void c(Class<?> class, o.d o$d2) {
        Constructor[] declaredConstructors;
        int length3;
        Annotation annotation2;
        int i8;
        int i9;
        Constructor constructor;
        o.e eVar;
        String parameterAnnotations;
        Object obj2;
        int length2;
        int i6;
        int i3;
        int i2;
        String str;
        Annotation annotation;
        int i7;
        int length;
        int i10;
        int i;
        Constructor[] objArr;
        int i4;
        int i5;
        final Object obj = this;
        declaredConstructors = class.getDeclaredConstructors();
        n.e(declaredConstructors, "klass.declaredConstructors");
        length3 = declaredConstructors.length;
        i8 = 0;
        while (i8 < length3) {
            constructor = declaredConstructors[i8];
            e eVar2 = e.n("<init>");
            n.e(eVar2, "special(\"<init>\")");
            n.e(constructor, "constructor");
            eVar = d2.b(eVar2, n.a.a(constructor));
            if (eVar == null) {
            } else {
            }
            Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
            n.e(declaredAnnotations, "constructor.declaredAnnotations");
            i2 = 0;
            str = "annotation";
            while (i2 < declaredAnnotations.length) {
                annotation = declaredAnnotations[i2];
                i2++;
                n.e(annotation, str);
                obj.f(eVar, annotation);
                str = "annotation";
            }
            parameterAnnotations = constructor.getParameterAnnotations();
            n.e(parameterAnnotations, "parameterAnnotations");
            i3 = 1;
            if (parameterAnnotations.length == 0) {
            } else {
            }
            i6 = 0;
            if (i6 ^= i3 != 0) {
            }
            objArr = declaredConstructors;
            i = length3;
            i4 = i9;
            eVar.a();
            length3 = i;
            declaredConstructors = objArr;
            i8 = i4;
            length4 -= length7;
            i3 = 0;
            while (i3 < parameterAnnotations.length) {
                annotation = parameterAnnotations[i3];
                n.e(annotation, "annotations");
                i10 = 0;
                while (i10 < annotation.length) {
                    annotation2 = annotation[i10];
                    i10++;
                    Class cls = a.b(a.a(annotation2));
                    n.e(annotation2, str);
                    b bVar = new b(annotation2);
                    o.a aVar = eVar.c(i3 + constructor, b.b(cls), bVar);
                    if (aVar == null) {
                    } else {
                    }
                    obj.h(aVar, annotation2, cls);
                    length3 = i;
                    declaredConstructors = objArr;
                    i9 = i4;
                    constructor = i5;
                }
                i3 = i7;
                annotation2 = annotation[i10];
                i10++;
                cls = a.b(a.a(annotation2));
                n.e(annotation2, str);
                bVar = new b(annotation2);
                aVar = eVar.c(i3 + constructor, b.b(cls), bVar);
                if (aVar == null) {
                } else {
                }
                obj.h(aVar, annotation2, cls);
                length3 = i;
                declaredConstructors = objArr;
                i9 = i4;
                constructor = i5;
            }
            annotation = parameterAnnotations[i3];
            n.e(annotation, "annotations");
            i10 = 0;
            while (i10 < annotation.length) {
                annotation2 = annotation[i10];
                i10++;
                cls = a.b(a.a(annotation2));
                n.e(annotation2, str);
                bVar = new b(annotation2);
                aVar = eVar.c(i3 + constructor, b.b(cls), bVar);
                if (aVar == null) {
                } else {
                }
                obj.h(aVar, annotation2, cls);
                length3 = i;
                declaredConstructors = objArr;
                i9 = i4;
                constructor = i5;
            }
            i3 = i7;
            annotation2 = annotation[i10];
            i10++;
            cls = a.b(a.a(annotation2));
            n.e(annotation2, str);
            bVar = new b(annotation2);
            aVar = eVar.c(i3 + constructor, b.b(cls), bVar);
            if (aVar == null) {
            } else {
            }
            obj.h(aVar, annotation2, cls);
            length3 = i;
            declaredConstructors = objArr;
            i9 = i4;
            constructor = i5;
            i6 = i3;
            annotation = declaredAnnotations[i2];
            i2++;
            n.e(annotation, str);
            obj.f(eVar, annotation);
            objArr = declaredConstructors;
            i = length3;
            i4 = i9;
        }
    }

    private final void d(Class<?> class, o.d o$d2) {
        int i;
        Field declaredAnnotations;
        o.c cVar;
        String length;
        int i2;
        Annotation annotation;
        String str;
        final Field[] obj10 = class.getDeclaredFields();
        n.e(obj10, "klass.declaredFields");
        final int i3 = 0;
        i = i3;
        while (i < obj10.length) {
            declaredAnnotations = obj10[i];
            i++;
            e eVar = e.j(declaredAnnotations.getName());
            n.e(eVar, "identifier(field.name)");
            n.e(declaredAnnotations, "field");
            cVar = d2.a(eVar, n.a.b(declaredAnnotations), 0);
            if (cVar == null) {
            } else {
            }
            declaredAnnotations = declaredAnnotations.getDeclaredAnnotations();
            n.e(declaredAnnotations, "field.declaredAnnotations");
            i2 = i3;
            while (i2 < declaredAnnotations.length) {
                annotation = declaredAnnotations[i2];
                i2++;
                n.e(annotation, "annotation");
                f(cVar, annotation);
            }
            cVar.a();
            annotation = declaredAnnotations[i2];
            i2++;
            n.e(annotation, "annotation");
            f(cVar, annotation);
        }
    }

    private final void e(Class<?> class, o.d o$d2) {
        Method[] declaredMethods;
        int length2;
        Class cls;
        int i5;
        Method parameterAnnotations;
        o.e eVar;
        String length3;
        Object obj3;
        int i;
        int i2;
        String str;
        Annotation annotation;
        int length;
        int i4;
        Object obj;
        Method[] objArr;
        int i3;
        final Object obj2 = this;
        declaredMethods = class.getDeclaredMethods();
        n.e(declaredMethods, "klass.declaredMethods");
        length2 = declaredMethods.length;
        i5 = 0;
        while (i5 < length2) {
            parameterAnnotations = declaredMethods[i5];
            i5++;
            e eVar2 = e.j(parameterAnnotations.getName());
            n.e(eVar2, "identifier(method.name)");
            n.e(parameterAnnotations, "method");
            eVar = d2.b(eVar2, n.a.c(parameterAnnotations));
            if (eVar == null) {
            } else {
            }
            Annotation[] declaredAnnotations = parameterAnnotations.getDeclaredAnnotations();
            n.e(declaredAnnotations, "method.declaredAnnotations");
            i2 = 0;
            str = "annotation";
            while (i2 < declaredAnnotations.length) {
                annotation = declaredAnnotations[i2];
                i2++;
                n.e(annotation, str);
                obj2.f(eVar, annotation);
                str = "annotation";
            }
            parameterAnnotations = parameterAnnotations.getParameterAnnotations();
            n.e(parameterAnnotations, "method.parameterAnnotations");
            i = 0;
            while (i < parameterAnnotations.length) {
                i2 = parameterAnnotations[i];
                n.e(i2, "annotations");
                i4 = 0;
                while (i4 < i2.length) {
                    obj = i2[i4];
                    i4++;
                    cls = a.b(a.a(obj));
                    n.e(obj, str);
                    b bVar = new b(obj);
                    o.a aVar2 = eVar.c(i, b.b(cls), bVar);
                    if (aVar2 == null) {
                    } else {
                    }
                    obj2.h(aVar2, obj, cls);
                    declaredMethods = objArr;
                    length2 = i3;
                }
                i = annotation;
                obj = i2[i4];
                i4++;
                cls = a.b(a.a(obj));
                n.e(obj, str);
                bVar = new b(obj);
                aVar2 = eVar.c(i, b.b(cls), bVar);
                if (aVar2 == null) {
                } else {
                }
                obj2.h(aVar2, obj, cls);
                declaredMethods = objArr;
                length2 = i3;
            }
            objArr = declaredMethods;
            i3 = length2;
            eVar.a();
            declaredMethods = objArr;
            length2 = i3;
            i2 = parameterAnnotations[i];
            n.e(i2, "annotations");
            i4 = 0;
            while (i4 < i2.length) {
                obj = i2[i4];
                i4++;
                cls = a.b(a.a(obj));
                n.e(obj, str);
                bVar = new b(obj);
                aVar2 = eVar.c(i, b.b(cls), bVar);
                if (aVar2 == null) {
                } else {
                }
                obj2.h(aVar2, obj, cls);
                declaredMethods = objArr;
                length2 = i3;
            }
            i = annotation;
            obj = i2[i4];
            i4++;
            cls = a.b(a.a(obj));
            n.e(obj, str);
            bVar = new b(obj);
            aVar2 = eVar.c(i, b.b(cls), bVar);
            if (aVar2 == null) {
            } else {
            }
            obj2.h(aVar2, obj, cls);
            declaredMethods = objArr;
            length2 = i3;
            annotation = declaredAnnotations[i2];
            i2++;
            n.e(annotation, str);
            obj2.f(eVar, annotation);
            objArr = declaredMethods;
            i3 = length2;
        }
    }

    private final void f(o.c o$c, Annotation annotation2) {
        Class cls = a.b(a.a(annotation2));
        b bVar = new b(annotation2);
        final o.a obj4 = c.b(b.b(cls), bVar);
        if (obj4 == null) {
        } else {
            h(obj4, annotation2, cls);
        }
    }

    private final void g(o.a o$a, e e2, Object object3) {
        Class enclosingClass;
        boolean contains;
        Object str;
        String str2;
        Object obj5;
        Object obj6;
        Object obj7;
        enclosingClass = object3.getClass();
        if (n.b(enclosingClass, Class.class)) {
            a.b(e2, a((Class)object3));
        } else {
            if (i.a().contains(enclosingClass)) {
                a.c(e2, object3);
            } else {
                if (b.i(enclosingClass)) {
                    if (enclosingClass.isEnum()) {
                    } else {
                        enclosingClass = enclosingClass.getEnclosingClass();
                    }
                    n.e(enclosingClass, "if (clazz.isEnum) clazz else clazz.enclosingClass");
                    obj7 = e.j((Enum)object3.name());
                    n.e(obj7, "identifier((value as Enum<*>).name)");
                    a.d(e2, b.b(enclosingClass), obj7);
                } else {
                    if (Annotation.class.isAssignableFrom(enclosingClass)) {
                        Class[] interfaces = enclosingClass.getInterfaces();
                        n.e(interfaces, "clazz.interfaces");
                        enclosingClass = i.N(interfaces);
                        n.e((Class)enclosingClass, "annotationClass");
                        obj5 = a.e(e2, b.b(enclosingClass));
                        if (obj5 == null) {
                        }
                        h(obj5, (Annotation)object3, enclosingClass);
                    } else {
                        if (!enclosingClass.isArray()) {
                        } else {
                            obj5 = a.f(e2);
                            if (obj5 == null) {
                            }
                            obj6 = enclosingClass.getComponentType();
                            contains = 0;
                            if (obj6.isEnum()) {
                                n.e(obj6, "componentType");
                                while (contains < object3.length) {
                                    Object obj4 = (Object[])object3[contains];
                                    contains++;
                                    Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.Enum<*>");
                                    str = e.j((Enum)obj4.name());
                                    n.e(str, "identifier((element as Enum<*>).name)");
                                    obj5.c(b.b(obj6), str);
                                }
                            } else {
                                if (n.b(obj6, Class.class)) {
                                    while (contains < object3.length) {
                                        Object obj = (Object[])object3[contains];
                                        contains++;
                                        Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.Class<*>");
                                        obj5.d(a((Class)obj));
                                    }
                                } else {
                                    while (contains < object3.length) {
                                        contains++;
                                        obj5.b((Object[])object3[contains]);
                                    }
                                }
                            }
                            obj5.a();
                        }
                    }
                }
            }
        }
        obj6 = new StringBuilder();
        obj6.append("Unsupported annotation argument value (");
        obj6.append(enclosingClass);
        obj6.append("): ");
        obj6.append(object3);
        obj5 = new UnsupportedOperationException(obj6.toString());
        throw obj5;
    }

    private final void h(o.a o$a, Annotation annotation2, Class<?> class3) {
        int i;
        e eVar;
        Object invoke;
        String str;
        final Method[] obj9 = class3.getDeclaredMethods();
        n.e(obj9, "annotationType.declaredMethods");
        final int i2 = 0;
        i = i2;
        while (i < obj9.length) {
            Method method = obj9[i];
            i++;
            invoke = method.invoke(annotation2, new Object[i2]);
            n.d(invoke);
            eVar = e.j(method.getName());
            n.e(eVar, "identifier(method.name)");
            g(a, eVar, invoke);
        }
        a.a();
    }

    public final void b(Class<?> class, o.c o$c2) {
        int i;
        Annotation annotation;
        String str;
        n.f(class, "klass");
        n.f(c2, "visitor");
        final Annotation[] obj5 = class.getDeclaredAnnotations();
        n.e(obj5, "klass.declaredAnnotations");
        i = 0;
        while (i < obj5.length) {
            annotation = obj5[i];
            i++;
            n.e(annotation, "annotation");
            f(c2, annotation);
        }
        c2.a();
    }

    public final void i(Class<?> class, o.d o$d2) {
        n.f(class, "klass");
        n.f(d2, "memberVisitor");
        e(class, d2);
        c(class, d2);
        d(class, d2);
    }
}
