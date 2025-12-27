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

/* compiled from: Util.java */
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

        @Override // java.lang.Object
        public boolean equals(Object object) {
            boolean z3 = false;
            if (object instanceof GenericArrayType) {
                object = t.d(this, object) ? 1 : 0;
            }
            return (t.d(this, object) ? 1 : 0);
        }

        public Type getGenericComponentType() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = b.s(this.a);
            String str3 = "[]";
            str = str2 + str3;
            return str;
        }
    }

    public static final class b implements ParameterizedType {

        private final Type a;
        private final Type b;
        public final Type[] c;
        public b(Type type, Type type2, Type... typeArr) {
            Type type3 = null;
            int i = 0;
            super();
            z = type2 instanceof Class;
            if (type2 instanceof Class) {
                Class enclosingClass = (Class)type2.getEnclosingClass();
                str = "unexpected owner type for ";
                if (type != null) {
                    if (enclosingClass == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str3 = ": ";
                        type = str + type2 + str3 + type;
                        throw new IllegalArgumentException(type);
                    }
                }
                if (enclosingClass != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str2 = ": null";
                    type2 = str + type2 + str2;
                    throw new IllegalArgumentException(type2);
                }
            }
            if (type == null) {
                int i2 = 0;
            } else {
                type3 = b.a(type);
            }
            this.a = type3;
            this.b = b.a(type2);
            this.c = (Type[])typeArr.clone();
            i = 0;
            while (i < objArr2.length) {
                Objects.requireNonNull(objArr2[i]);
                b.b(objArr2[i]);
                this.c[i] = b.a(objArr[i]);
                i = i + 1;
            }
        }

        @Override // java.lang.Object
        public boolean equals(Object object) {
            boolean z3 = false;
            if (object instanceof ParameterizedType) {
                object = t.d(this, object) ? 1 : 0;
            }
            return (t.d(this, object) ? 1 : 0);
        }

        public Type[] getActualTypeArguments() {
            return (Type[])this.c.clone();
        }

        public Type getOwnerType() {
            return this.a;
        }

        public Type getRawType() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (Arrays.hashCode(this.c) ^ this.b.hashCode()) ^ b.f(this.a);
        }

        @Override // java.lang.Object
        public String toString() {
            int i = 1;
            i = 1;
            StringBuilder stringBuilder = new StringBuilder((this.c.length + i) * 30);
            stringBuilder.append(b.s(this.b));
            if (this.c.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append("<");
            stringBuilder.append(b.s(this.c[0]));
            for (Type type3 : objArr4) {
                stringBuilder.append(", ");
                stringBuilder.append(b.s(type3));
            }
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    public static final class c implements WildcardType {

        private final Type a = Object.class;
        private final Type b = null;
        public c(Type[] typeArr, Type[] typeArr2) {
            super();
            final int i2 = 1;
            if (typeArr2.length > i2) {
                throw new IllegalArgumentException();
            } else {
                if (typeArr.length != i2) {
                    throw new IllegalArgumentException();
                } else {
                    final int i3 = 0;
                    if (typeArr2.length == i2) {
                        Objects.requireNonNull(typeArr2[i3]);
                        b.b(typeArr2[i3]);
                        if (typeArr[i3] != Object.class) {
                            throw new IllegalArgumentException();
                        } else {
                            this.b = b.a(typeArr2[i3]);
                            return;
                        }
                    }
                    Objects.requireNonNull(typeArr[i3]);
                    b.b(typeArr[i3]);
                    int i = 0;
                    this.a = b.a(typeArr[i3]);
                }
            }
        }

        @Override // java.lang.Object
        public boolean equals(Object object) {
            boolean z3 = false;
            if (object instanceof WildcardType) {
                object = t.d(this, object) ? 1 : 0;
            }
            return (t.d(this, object) ? 1 : 0);
        }

        public Type[] getLowerBounds() {
            Type[] arr;
            if (this.b != null) {
                int i = 0;
                new Type[1][i] = this.b;
            } else {
                arr = b.b;
            }
            return arr;
        }

        public Type[] getUpperBounds() {
            Type[] arr = new Type[1];
            return new Type[] { this.a };
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i = 1;
            i = this.b != null ? i3 + 31 : 1;
            return i ^ (this.a.hashCode() + 31);
        }

        @Override // java.lang.Object
        public String toString() {
            if (this.b != null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "? super ";
                String str5 = b.s(this.b);
                str = str4 + str5;
                return str;
            }
            if (this.a == Object.class) {
                return "?";
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            String str6 = "? extends ";
            String str7 = b.s(this.a);
            str3 = str6 + str7;
            return str3;
        }
    }
    static {
        b.a = Collections.emptySet();
        b.b = new Type[0];
        try {
        } catch (java.lang.ClassNotFoundException unused) {
            int tYPE2 = 16;
            String unmodifiable = new LinkedHashMap(tYPE2);
            tYPE2 = Boolean.TYPE;
            Class<Boolean> obj = Boolean.class;
            unmodifiable.put(tYPE2, obj);
            tYPE2 = Byte.TYPE;
            obj = Byte.class;
            unmodifiable.put(tYPE2, obj);
            tYPE2 = Character.TYPE;
            obj = Character.class;
            unmodifiable.put(tYPE2, obj);
            tYPE2 = Double.TYPE;
            obj = Double.class;
            unmodifiable.put(tYPE2, obj);
            tYPE2 = Float.TYPE;
            obj = Float.class;
            unmodifiable.put(tYPE2, obj);
            tYPE2 = Integer.TYPE;
            obj = Integer.class;
            unmodifiable.put(tYPE2, obj);
            tYPE2 = Long.TYPE;
            obj = Long.class;
            unmodifiable.put(tYPE2, obj);
            tYPE2 = Short.TYPE;
            obj = Short.class;
            unmodifiable.put(tYPE2, obj);
            tYPE2 = Void.TYPE;
            obj = Void.class;
            unmodifiable.put(tYPE2, obj);
            unmodifiable = Collections.unmodifiableMap(unmodifiable);
            b.d = unmodifiable;
            return;
        }
    }

    public static Type a(Type type) {
        com.squareup.moshi.v.b.a aVar;
        if (type instanceof Class) {
            if (type.isArray()) {
            }
            return aVar;
        }
        if (type instanceof ParameterizedType) {
            if (type instanceof b.b) {
                return type;
            }
            return new b.b(type.getOwnerType(), type.getRawType(), type.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type instanceof b.a) {
                return type;
            }
            return new b.a(type.getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            if (type instanceof b.c) {
                return type;
            }
            return new b.c(type.getUpperBounds(), type.getLowerBounds());
        }
        return type;
    }

    static void b(Type type) {
        primitive = type instanceof Class;
        if (type instanceof Class) {
            if ((Class)type.isPrimitive()) {
                final StringBuilder stringBuilder = new StringBuilder();
                final String str = "Unexpected primitive ";
                String str2 = ". Use the boxed type.";
                type = str + type + str2;
                throw new IllegalArgumentException(type);
            }
        }
    }

    static Class<?> c(TypeVariable<?> typeVariable) {
        java.lang.reflect.GenericDeclaration genericDeclaration = null;
        typeVariable = typeVariable.getGenericDeclaration() instanceof Class ? (Class)typeVariable.getGenericDeclaration() : 0;
        return (typeVariable.getGenericDeclaration() instanceof Class ? (Class)typeVariable.getGenericDeclaration() : 0);
    }

    public static f<?> d(r rVar, Type type, Class<?> cls) {
        Constructor declaredConstructor;
        RuntimeException cls32;
        Object[] arr;
        Class<r> obj = r.class;
        Annotation annotation = cls.getAnnotation(g.class);
        return null;
    }

    public static Type e(Type type, Class<?> cls, Class<?> cls2) {
        int i = 0;
        boolean assignableFrom;
        Class<Object> type2;
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class[] interfaces = cls.getInterfaces();
            i = 0;
            length = interfaces.length;
            while (i < length) {
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return b.e(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (type2 != Object.class) {
                type2 = type2.getSuperclass();
                if (cls2.isAssignableFrom(type2)) {
                    return b.e(type2.getGenericSuperclass(), type2, cls2);
                }
            }
        }
        return cls2;
    }

    static int f(Object object) {
        int i = 0;
        if (object != null) {
            i = object.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    static int g(Object[] objectArr, Object object) {
        int i = 0;
        i = 0;
        while (i < objectArr.length) {
            if (object.equals(objectArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public static boolean h(Class<?> cls) {
        boolean z = false;
        final Class cls2 = b.c;
        cls = b.c != null && cls.isAnnotationPresent(b.c) ? 1 : 0;
        return (b.c != null && cls.isAnnotationPresent(b.c) ? 1 : 0);
    }

    public static boolean i(Class<?> cls) {
        boolean startsWith;
        boolean z = true;
        String name = cls.getName();
        if (!name.startsWith("android.")) {
            if (!name.startsWith("androidx.")) {
                if (!name.startsWith("java.")) {
                    if (!name.startsWith("javax.")) {
                        if (!name.startsWith("kotlin.")) {
                            if (!name.startsWith("kotlinx.")) {
                                if (name.startsWith("scala.")) {
                                    int i = 1;
                                } else {
                                    int i2 = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public static Set<? extends Annotation> j(AnnotatedElement annotatedElement) {
        return b.k(annotatedElement.getAnnotations());
    }

    public static Set<? extends Annotation> k(Annotation[] annotationArr) {
        Set set = null;
        int i = 0;
        Set unmodifiable;
        int i2 = 0;
        i = 0;
        for (Object obj : annotationArr) {
            cls = h.class;
        }
        if (set != null) {
            unmodifiable = Collections.unmodifiableSet(set);
        } else {
            unmodifiable = b.a;
        }
        return unmodifiable;
    }

    public static JsonDataException l(String str, String str2, i iVar) {
        String formatted;
        final String path = iVar.getPath();
        final int i2 = 2;
        final int i3 = 1;
        final int i4 = 0;
        if (str2.equals(str)) {
            Object[] arr = new Object[i2];
            formatted = String.format("Required value '%s' missing at %s", new Object[] { str, path });
        } else {
            Object[] arr2 = new Object[3];
            formatted = String.format("Required value '%s' (JSON name '%s') missing at %s", new Object[] { str, str2, path });
        }
        return new JsonDataException(formatted);
    }

    public static Type m(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        Object type2 = type;
        if (type2.getLowerBounds().length != 0) {
            return type;
        }
        Type[] upperBounds = type2.getUpperBounds();
        if (upperBounds.length != 1) {
            throw new IllegalArgumentException();
        } else {
            return upperBounds[0];
        }
    }

    public static Type n(Type type, Class<?> cls, Type type2) {
        return b.o(type, cls, type2, new LinkedHashSet());
    }

    private static Type o(Type type, Class<?> cls, Type type2, Collection<TypeVariable<?>> collection) {
        GenericArrayType genericArrayType;
        int i;
        Type[] actualTypeArguments;
        GenericArrayType genericArrayType2;
        com.squareup.moshi.v.b.b type6;
        while (type2 instanceof TypeVariable) {
            Object type32 = type2;
            collection.add(type32);
            Type type14 = b.p(type, cls, type32);
            if (type14 == type32) {
                return type14;
            }
        }
        z = type2 instanceof Class;
        if (type2 instanceof Class && type32.isArray()) {
            cls = type32.getComponentType();
            Type type12 = b.o(type, cls, cls, collection);
            if (cls != type12) {
                genericArrayType = t.b(type12);
            }
            return genericArrayType;
        }
        if (type2 instanceof GenericArrayType) {
            Type genericComponentType = type2.getGenericComponentType();
            Type type13 = b.o(type, cls, genericComponentType, collection);
            if (genericComponentType != type13) {
                genericArrayType2 = t.b(type13);
            }
            return genericArrayType2;
        }
        i = 1;
        i = 0;
        if (type2 instanceof ParameterizedType) {
            Type ownerType = type2.getOwnerType();
            Type type10 = b.o(type, cls, ownerType, collection);
            int r0 = i;
            while (i < type2.getActualTypeArguments().length) {
                type2 = b.o(type, cls, actualTypeArguments[i], collection);
                i = i + 1;
            }
            if (i != 0) {
            }
            return type6;
        }
        z2 = type2 instanceof WildcardType;
        if (type2 instanceof WildcardType) {
            Type[] lowerBounds = type2.getLowerBounds();
            Type[] upperBounds = type2.getUpperBounds();
            length = lowerBounds.length;
            if (lowerBounds.length == i) {
                Type type5 = b.o(type, cls, lowerBounds[i], collection);
                if (type5 != lowerBounds[i]) {
                    return t.l(type5);
                }
            } else {
                if (upperBounds.length == i) {
                    type5 = b.o(type, cls, upperBounds[i], collection);
                    if (type5 != upperBounds[i]) {
                        return t.k(type5);
                    }
                }
            }
        }
        return type2;
    }

    static Type p(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        cls = b.c(typeVariable);
        if (cls == null) {
            return typeVariable;
        }
        Type type2 = b.e(type, cls, cls);
        if (type2 instanceof ParameterizedType) {
            return type2.getActualTypeArguments()[b.g(cls.getTypeParameters(), typeVariable)];
        }
        return typeVariable;
    }

    public static RuntimeException q(InvocationTargetException exc) {
        final Throwable targetException = exc.getTargetException();
        if (targetException instanceof RuntimeException) {
            throw targetException;
        } else {
            if (targetException instanceof Error) {
                throw targetException;
            }
            throw new RuntimeException(targetException);
        }
    }

    public static String r(Type type, Set<? extends Annotation> set) {
        String str2;
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(type);
        if (set.isEmpty()) {
            str2 = " (with no annotations)";
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            str = " annotated ";
            str2 = str + set;
        }
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    static String s(Type type) {
        String object;
        if (type instanceof Class) {
            object = type.getName();
        } else {
            object = type.toString();
        }
        return object;
    }

    public static JsonDataException t(String str, String str2, i iVar) {
        String formatted;
        final String path = iVar.getPath();
        final int i2 = 2;
        final int i3 = 1;
        final int i4 = 0;
        if (str2.equals(str)) {
            Object[] arr = new Object[i2];
            formatted = String.format("Non-null value '%s' was null at %s", new Object[] { str, path });
        } else {
            Object[] arr2 = new Object[3];
            formatted = String.format("Non-null value '%s' (JSON name '%s') was null at %s", new Object[] { str, str2, path });
        }
        return new JsonDataException(formatted);
    }

    private static String getKotlinMetadataClassName() {
        return "kotlin.Metadata";
    }
}
