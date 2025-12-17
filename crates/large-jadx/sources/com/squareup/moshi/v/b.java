package com.squareup.moshi.v;

import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.f;
import com.squareup.moshi.g;
import com.squareup.moshi.i;
import com.squareup.moshi.r;
import com.squareup.moshi.t;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes2.dex */
public final class b {

    public static final Set<Annotation> a;
    public static final Type[] b;
    private static final Class<? extends Annotation> c = null;
    private static final Map<Class<?>, Class<?>> d;

    public static final class a implements GenericArrayType {

        private final Type a;
        public a(Type type) {
            super();
            this.a = b.a(type);
        }

        @Override // java.lang.reflect.GenericArrayType
        public boolean equals(Object object) {
            Object obj2;
            if (object instanceof GenericArrayType && t.d(this, (GenericArrayType)object)) {
                obj2 = t.d(this, (GenericArrayType)object) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.a;
        }

        @Override // java.lang.reflect.GenericArrayType
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // java.lang.reflect.GenericArrayType
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b.s(this.a));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
    }

    public static final class b implements ParameterizedType {

        private final Type a;
        private final Type b;
        public final Type[] c;
        public b(Type type, Type type2, Type... type3Arr3) {
            boolean enclosingClass;
            String str;
            Class cls;
            Type obj4;
            Object obj5;
            Type obj6;
            super();
            enclosingClass = (Class)type2.getEnclosingClass();
            str = "unexpected owner type for ";
            if (type2 instanceof Class && type != null) {
                enclosingClass = (Class)type2.getEnclosingClass();
                str = "unexpected owner type for ";
                if (type != null) {
                    if (enclosingClass == null) {
                    } else {
                        if (t.g(type) != enclosingClass) {
                        } else {
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(type2);
                    stringBuilder.append(": ");
                    stringBuilder.append(type);
                    obj6 = new IllegalArgumentException(stringBuilder.toString());
                    throw obj6;
                }
                if (enclosingClass != null) {
                } else {
                }
                obj6 = new StringBuilder();
                obj6.append(str);
                obj6.append(type2);
                obj6.append(": null");
                obj4 = new IllegalArgumentException(obj6.toString());
                throw obj4;
            }
            if (type == null) {
                obj4 = 0;
            } else {
                obj4 = b.a(type);
            }
            this.a = obj4;
            this.b = b.a(type2);
            this.c = (Type[])type3Arr3.clone();
            obj4 = 0;
            obj5 = this.c;
            for (Object obj6 : type2) {
                Objects.requireNonNull(obj5[obj4]);
                b.b(obj5[obj4]);
                obj5 = this.c;
                obj5[obj4] = b.a(obj6);
                obj5 = this.c;
            }
        }

        @Override // java.lang.reflect.ParameterizedType
        public boolean equals(Object object) {
            Object obj2;
            if (object instanceof ParameterizedType && t.d(this, (ParameterizedType)object)) {
                obj2 = t.d(this, (ParameterizedType)object) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[])this.c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public int hashCode() {
            return i2 ^= i5;
        }

        @Override // java.lang.reflect.ParameterizedType
        public String toString() {
            String str;
            int i;
            StringBuilder stringBuilder = new StringBuilder(i2 *= 30);
            stringBuilder.append(b.s(this.b));
            if (objArr2.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append("<");
            stringBuilder.append(b.s(this.c[0]));
            for (Object type3 : obj1) {
                stringBuilder.append(", ");
                stringBuilder.append(b.s(type3));
            }
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    public static final class c implements WildcardType {

        private final Type a;
        private final Type b = null;
        public c(Type[] typeArr, Type[] type2Arr2) {
            Object length;
            Type obj5;
            int obj6;
            final Class<Object> obj = Object.class;
            super();
            final int i = 1;
            if (type2Arr2.length > i) {
            } else {
                if (typeArr.length != i) {
                } else {
                    final int i2 = 0;
                    if (type2Arr2.length == i) {
                        Objects.requireNonNull(type2Arr2[i2]);
                        b.b(type2Arr2[i2]);
                        if (typeArr[i2] != obj) {
                        } else {
                            this.b = b.a(type2Arr2[i2]);
                            this.a = obj;
                        }
                        obj5 = new IllegalArgumentException();
                        throw obj5;
                    }
                    Objects.requireNonNull(typeArr[i2]);
                    b.b(typeArr[i2]);
                    obj6 = 0;
                    this.a = b.a(typeArr[i2]);
                }
                obj5 = new IllegalArgumentException();
                throw obj5;
            }
            obj5 = new IllegalArgumentException();
            throw obj5;
        }

        @Override // java.lang.reflect.WildcardType
        public boolean equals(Object object) {
            Object obj2;
            if (object instanceof WildcardType && t.d(this, (WildcardType)object)) {
                obj2 = t.d(this, (WildcardType)object) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type[] arr;
            int i;
            final Type type = this.b;
            if (type != null) {
                new Type[1][0] = type;
            } else {
                arr = b.b;
            }
            return arr;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            Type[] arr = new Type[1];
            return arr;
        }

        @Override // java.lang.reflect.WildcardType
        public int hashCode() {
            int i;
            Type type = this.b;
            if (type != null) {
                i3 += 31;
            } else {
                i = 1;
            }
            return i ^= i5;
        }

        @Override // java.lang.reflect.WildcardType
        public String toString() {
            if (this.b != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("? super ");
                stringBuilder.append(b.s(this.b));
                return stringBuilder.toString();
            }
            if (this.a == Object.class) {
                return "?";
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("? extends ");
            stringBuilder2.append(b.s(this.a));
            return stringBuilder2.toString();
        }
    }
    static {
        b.a = Collections.emptySet();
        b.b = new Type[0];
        Class forName = Class.forName(b.getKotlinMetadataClassName());
    }

    public static Type a(Type type) {
        boolean aVar;
        Object obj3;
        if (type instanceof Class && (Class)type.isArray()) {
            if ((Class)type.isArray()) {
                aVar = new b.a(b.a(type.getComponentType()));
                obj3 = aVar;
            }
            return obj3;
        }
        if (type instanceof ParameterizedType && type instanceof b.b) {
            if (type instanceof b.b) {
                return type;
            }
            b.b bVar = new b.b((ParameterizedType)type.getOwnerType(), type.getRawType(), type.getActualTypeArguments());
            return bVar;
        }
        if (type instanceof GenericArrayType && type instanceof b.a) {
            if (type instanceof b.a) {
                return type;
            }
            b.a aVar2 = new b.a((GenericArrayType)type.getGenericComponentType());
            return aVar2;
        }
        if (type instanceof WildcardType && type instanceof b.c) {
            if (type instanceof b.c) {
                return type;
            }
            b.c cVar = new b.c((WildcardType)type.getUpperBounds(), type.getLowerBounds());
            return cVar;
        }
        return type;
    }

    static void b(Type type) {
        boolean primitive;
        if (type instanceof Class) {
            if ((Class)type.isPrimitive()) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected primitive ");
            stringBuilder.append(type);
            stringBuilder.append(". Use the boxed type.");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
    }

    static Class<?> c(TypeVariable<?> typeVariable) {
        java.lang.reflect.GenericDeclaration obj1;
        if (obj1 instanceof Class) {
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    public static f<?> d(r r, Type type2, Class<?> class3) {
        Constructor declaredConstructor;
        Class[] actualTypeArguments;
        Annotation annotation;
        RuntimeException exc;
        Object[] arr;
        Class[] arr2;
        Object obj7;
        Class<r> obj = r.class;
        annotation = class3.getAnnotation(g.class);
        if ((g)annotation != null) {
            if (!(g)annotation.generateAdapter()) {
            } else {
                final int i2 = 1;
                Class obj9 = Class.forName(t.e(class3.getName()), i2, class3.getClassLoader());
                final int i3 = 0;
                if (type2 instanceof ParameterizedType) {
                    int i4 = 2;
                    arr2 = new Class[i4];
                    arr2[i3] = obj;
                    arr2[i2] = Type[].class;
                    declaredConstructor = obj9.getDeclaredConstructor(arr2);
                    arr = new Object[i4];
                    arr[i3] = r;
                    arr[i2] = (ParameterizedType)type2.getActualTypeArguments();
                } else {
                    actualTypeArguments = new Class[i2];
                    actualTypeArguments[i3] = obj;
                    declaredConstructor = obj9.getDeclaredConstructor(actualTypeArguments);
                    new Object[i2][i3] = r;
                }
            }
            declaredConstructor.setAccessible(i2);
            return (f)declaredConstructor.newInstance(arr).f();
        }
        return 0;
    }

    public static Type e(Type type, Class<?> class2, Class<?> class3) {
        int assignableFrom2;
        int length;
        boolean assignableFrom;
        boolean obj3;
        Class<Object> obj4;
        if (class3 == class2) {
            return type;
        }
        if (class3.isInterface()) {
            obj3 = class2.getInterfaces();
            assignableFrom2 = 0;
            while (assignableFrom2 < obj3.length) {
                assignableFrom2++;
            }
        }
        if (!class2.isInterface()) {
        }
        return class3;
    }

    static int f(Object object) {
        int obj0;
        if (object != null) {
            obj0 = object.hashCode();
        } else {
            obj0 = 0;
        }
        return obj0;
    }

    static int g(Object[] objectArr, Object object2) {
        int i;
        boolean equals;
        i = 0;
        for (Object obj : objectArr) {
        }
        NoSuchElementException obj2 = new NoSuchElementException();
        throw obj2;
    }

    private static String getKotlinMetadataClassName() {
        return "kotlin.Metadata";
    }

    public static boolean h(Class<?> class) {
        boolean obj1;
        final Class cls = b.c;
        if (cls != null && class.isAnnotationPresent(cls)) {
            obj1 = class.isAnnotationPresent(cls) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean i(Class<?> class) {
        boolean startsWith;
        int obj1;
        obj1 = class.getName();
        if (!obj1.startsWith("android.") && !obj1.startsWith("androidx.") && !obj1.startsWith("java.") && !obj1.startsWith("javax.") && !obj1.startsWith("kotlin.") && !obj1.startsWith("kotlinx.")) {
            if (!obj1.startsWith("androidx.")) {
                if (!obj1.startsWith("java.")) {
                    if (!obj1.startsWith("javax.")) {
                        if (!obj1.startsWith("kotlin.")) {
                            if (!obj1.startsWith("kotlinx.")) {
                                if (obj1.startsWith("scala.")) {
                                    obj1 = 1;
                                } else {
                                    obj1 = 0;
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
        return obj1;
    }

    public static Set<? extends Annotation> j(AnnotatedElement annotatedElement) {
        return b.k(annotatedElement.getAnnotations());
    }

    public static Set<? extends Annotation> k(Annotation[] annotationArr) {
        int linkedHashSet;
        int i;
        Object obj;
        boolean annotationPresent;
        Class<com.squareup.moshi.h> obj2;
        Set obj6;
        linkedHashSet = 0;
        i = 0;
        while (i < annotationArr.length) {
            obj = annotationArr[i];
            if (obj.annotationType().isAnnotationPresent(h.class) && linkedHashSet == null) {
            }
            i++;
            if (linkedHashSet == null) {
            }
            linkedHashSet.add(obj);
            linkedHashSet = new LinkedHashSet();
        }
        if (linkedHashSet != null) {
            obj6 = Collections.unmodifiableSet(linkedHashSet);
        } else {
            obj6 = b.a;
        }
        return obj6;
    }

    public static JsonDataException l(String string, String string2, i i3) {
        boolean equals;
        String obj4;
        Object[] obj5;
        final String obj6 = i3.getPath();
        final int i2 = 2;
        final int i4 = 1;
        final int i5 = 0;
        if (string2.equals(string)) {
            obj5 = new Object[i2];
            obj5[i5] = string;
            obj5[i4] = obj6;
            obj4 = String.format("Required value '%s' missing at %s", obj5);
        } else {
            equals = new Object[3];
            equals[i5] = string;
            equals[i4] = string2;
            equals[i2] = obj6;
            obj4 = String.format("Required value '%s' (JSON name '%s') missing at %s", equals);
        }
        obj5 = new JsonDataException(obj4);
        return obj5;
    }

    public static Type m(Type type) {
        if (!type instanceof WildcardType) {
            return type;
        }
        Object obj = type;
        if (lowerBounds.length != 0) {
            return type;
        }
        Type[] obj2 = obj.getUpperBounds();
        if (obj2.length != 1) {
        } else {
            return obj2[0];
        }
        obj2 = new IllegalArgumentException();
        throw obj2;
    }

    public static Type n(Type type, Class<?> class2, Type type3) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        return b.o(type, class2, type3, linkedHashSet);
    }

    private static Type o(Type type, Class<?> class2, Type type3, Collection<TypeVariable<?>> collection4) {
        Object obj;
        boolean lowerBounds;
        int i2;
        boolean array;
        int i;
        int i3;
        Type[] upperBounds;
        int length;
        Type[] actualTypeArguments;
        Type type4;
        Type type2;
        Type obj8;
        Object obj9;
        Object obj10;
        while (type3 instanceof TypeVariable) {
            Object obj2 = type3;
            collection4.add(obj2);
            obj10 = b.p(type, class2, obj2);
        }
        obj = type3;
        if (type3 instanceof Class && (Class)obj.isArray()) {
            obj = type3;
            if ((Class)obj.isArray()) {
                obj10 = obj.getComponentType();
                obj8 = b.o(type, class2, obj10, collection4);
                if (obj10 == obj8) {
                } else {
                    obj = t.b(obj8);
                }
                return obj;
            }
        }
        if (type3 instanceof GenericArrayType) {
            Type genericComponentType = (GenericArrayType)type3.getGenericComponentType();
            obj8 = b.o(type, class2, genericComponentType, collection4);
            if (genericComponentType == obj8) {
            } else {
                obj10 = t.b(obj8);
            }
            return obj10;
        }
        i = 1;
        i3 = 0;
        if (type3 instanceof ParameterizedType) {
            Type ownerType = (ParameterizedType)type3.getOwnerType();
            Type type5 = b.o(type, class2, ownerType, collection4);
            i2 = type5 != ownerType ? i : i3;
            while (i3 < actualTypeArguments.length) {
                type4 = b.o(type, class2, actualTypeArguments[i3], collection4);
                if (type4 != actualTypeArguments[i3] && i2 == 0) {
                }
                i3++;
                if (i2 == 0) {
                }
                actualTypeArguments[i3] = type4;
                actualTypeArguments = clone;
                i2 = i;
            }
            if (i2 != 0) {
                obj8 = new b.b(type5, type3.getRawType(), actualTypeArguments);
                obj10 = obj8;
            }
            return obj10;
        }
        if (type3 instanceof WildcardType) {
            lowerBounds = (WildcardType)type3.getLowerBounds();
            upperBounds = type3.getUpperBounds();
            if (lowerBounds.length == i) {
                obj8 = b.o(type, class2, lowerBounds[i3], collection4);
                if (obj8 != lowerBounds[i3]) {
                    return t.l(obj8);
                }
            } else {
                obj8 = b.o(type, class2, upperBounds[i3], collection4);
                if (upperBounds.length == i && obj8 != upperBounds[i3]) {
                    obj8 = b.o(type, class2, upperBounds[i3], collection4);
                    if (obj8 != upperBounds[i3]) {
                        return t.k(obj8);
                    }
                }
            }
        }
        return type3;
    }

    static Type p(Type type, Class<?> class2, TypeVariable<?> typeVariable3) {
        final Class cls = b.c(typeVariable3);
        if (cls == null) {
            return typeVariable3;
        }
        Type obj1 = b.e(type, class2, cls);
        if (obj1 instanceof ParameterizedType) {
            return (ParameterizedType)obj1.getActualTypeArguments()[b.g(cls.getTypeParameters(), typeVariable3)];
        }
        return typeVariable3;
    }

    public static RuntimeException q(InvocationTargetException invocationTargetException) {
        final Throwable obj1 = invocationTargetException.getTargetException();
        if (obj1 instanceof RuntimeException != null) {
        } else {
            if (obj1 instanceof Error != null) {
                throw (Error)obj1;
            }
            RuntimeException runtimeException = new RuntimeException(obj1);
            throw runtimeException;
        }
        throw (RuntimeException)obj1;
    }

    public static String r(Type type, Set<? extends Annotation> set2) {
        String str;
        String obj2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(type);
        if (set2.isEmpty()) {
            obj2 = " (with no annotations)";
        } else {
            obj2 = new StringBuilder();
            obj2.append(" annotated ");
            obj2.append(set2);
            obj2 = obj2.toString();
        }
        stringBuilder.append(obj2);
        return stringBuilder.toString();
    }

    static String s(Type type) {
        String obj1;
        if (type instanceof Class) {
            obj1 = (Class)type.getName();
        } else {
            obj1 = type.toString();
        }
        return obj1;
    }

    public static JsonDataException t(String string, String string2, i i3) {
        boolean equals;
        String obj4;
        Object[] obj5;
        final String obj6 = i3.getPath();
        final int i2 = 2;
        final int i4 = 1;
        final int i5 = 0;
        if (string2.equals(string)) {
            obj5 = new Object[i2];
            obj5[i5] = string;
            obj5[i4] = obj6;
            obj4 = String.format("Non-null value '%s' was null at %s", obj5);
        } else {
            equals = new Object[3];
            equals[i5] = string;
            equals[i4] = string2;
            equals[i2] = obj6;
            obj4 = String.format("Non-null value '%s' (JSON name '%s') was null at %s", equals);
        }
        obj5 = new JsonDataException(obj4);
        return obj5;
    }
}
