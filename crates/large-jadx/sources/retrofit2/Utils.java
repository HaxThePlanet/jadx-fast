package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import l.f;
import l.h;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
final class Utils {

    static final Type[] EMPTY_TYPE_ARRAY;

    private static final class GenericArrayTypeImpl implements GenericArrayType {

        private final Type componentType;
        GenericArrayTypeImpl(Type type) {
            super();
            this.componentType = type;
        }

        @Override // java.lang.reflect.GenericArrayType
        public boolean equals(Object object) {
            Object obj2;
            if (object instanceof GenericArrayType && Utils.equals(this, (GenericArrayType)object)) {
                obj2 = Utils.equals(this, (GenericArrayType)object) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        @Override // java.lang.reflect.GenericArrayType
        public int hashCode() {
            return this.componentType.hashCode();
        }

        @Override // java.lang.reflect.GenericArrayType
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Utils.typeToString(this.componentType));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
    }

    static final class ParameterizedTypeImpl implements ParameterizedType {

        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;
        ParameterizedTypeImpl(Type type, Type type2, Type... type3Arr3) {
            boolean z;
            int i;
            int i2;
            Class enclosingClass;
            super();
            i = 0;
            if (type2 instanceof Class) {
                i2 = type == null ? z : i;
                if ((Class)type2.getEnclosingClass() == null) {
                } else {
                    z = i;
                }
                if (i2 != z) {
                } else {
                }
                IllegalArgumentException obj5 = new IllegalArgumentException();
                throw obj5;
            }
            while (i < type3Arr3.length) {
                i2 = type3Arr3[i];
                Objects.requireNonNull(i2, "typeArgument == null");
                Utils.checkNotPrimitive(i2);
                i++;
            }
            this.ownerType = type;
            this.rawType = type2;
            this.typeArguments = (Type[])type3Arr3.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public boolean equals(Object object) {
            Object obj2;
            if (object instanceof ParameterizedType && Utils.equals(this, (ParameterizedType)object)) {
                obj2 = Utils.equals(this, (ParameterizedType)object) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[])this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public int hashCode() {
            int i;
            Type ownerType = this.ownerType;
            if (ownerType != null) {
                i = ownerType.hashCode();
            } else {
                i = 0;
            }
            return i3 ^= i;
        }

        @Override // java.lang.reflect.ParameterizedType
        public String toString() {
            String typeToString;
            int i;
            Type[] typeArguments = this.typeArguments;
            if (typeArguments.length == 0) {
                return Utils.typeToString(this.rawType);
            }
            StringBuilder stringBuilder = new StringBuilder(i2 *= 30);
            stringBuilder.append(Utils.typeToString(this.rawType));
            stringBuilder.append("<");
            stringBuilder.append(Utils.typeToString(this.typeArguments[0]));
            for (Object type2 : obj0) {
                stringBuilder.append(", ");
                stringBuilder.append(Utils.typeToString(type2));
            }
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    private static final class WildcardTypeImpl implements WildcardType {

        private final Type lowerBound = null;
        private final Type upperBound;
        WildcardTypeImpl(Type[] typeArr, Type[] type2Arr2) {
            Object length;
            Object obj5;
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
                        Utils.checkNotPrimitive(type2Arr2[i2]);
                        if (typeArr[i2] != obj) {
                        } else {
                            this.lowerBound = type2Arr2[i2];
                            this.upperBound = obj;
                        }
                        obj5 = new IllegalArgumentException();
                        throw obj5;
                    }
                    Objects.requireNonNull(typeArr[i2]);
                    Utils.checkNotPrimitive(typeArr[i2]);
                    obj6 = 0;
                    this.upperBound = typeArr[i2];
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
            if (object instanceof WildcardType && Utils.equals(this, (WildcardType)object)) {
                obj2 = Utils.equals(this, (WildcardType)object) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type[] eMPTY_TYPE_ARRAY;
            int i;
            final Type lowerBound = this.lowerBound;
            if (lowerBound != null) {
                new Type[1][0] = lowerBound;
            } else {
                eMPTY_TYPE_ARRAY = Utils.EMPTY_TYPE_ARRAY;
            }
            return eMPTY_TYPE_ARRAY;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            Type[] arr = new Type[1];
            return arr;
        }

        @Override // java.lang.reflect.WildcardType
        public int hashCode() {
            int i;
            Type lowerBound = this.lowerBound;
            if (lowerBound != null) {
                i3 += 31;
            } else {
                i = 1;
            }
            return i ^= i5;
        }

        @Override // java.lang.reflect.WildcardType
        public String toString() {
            if (this.lowerBound != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("? super ");
                stringBuilder.append(Utils.typeToString(this.lowerBound));
                return stringBuilder.toString();
            }
            if (this.upperBound == Object.class) {
                return "?";
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("? extends ");
            stringBuilder2.append(Utils.typeToString(this.upperBound));
            return stringBuilder2.toString();
        }
    }
    static {
        Utils.EMPTY_TYPE_ARRAY = new Type[0];
    }

    static ResponseBody buffer(ResponseBody responseBody) {
        f fVar = new f();
        responseBody.source().J1(fVar);
        return ResponseBody.create(responseBody.contentType(), responseBody.contentLength(), obj3);
    }

    static void checkNotPrimitive(Type type) {
        Object obj1;
        if (type instanceof Class) {
            if ((Class)type.isPrimitive()) {
            } else {
            }
            obj1 = new IllegalArgumentException();
            throw obj1;
        }
    }

    private static Class<?> declaringClassOf(TypeVariable<?> typeVariable) {
        java.lang.reflect.GenericDeclaration obj1;
        if (obj1 instanceof Class) {
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    static boolean equals(Type type, Type type2) {
        int i;
        boolean ownerType;
        Type ownerType2;
        boolean obj4;
        Object obj5;
        if (type == type2) {
            return 1;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        final int i2 = 0;
        if (type instanceof ParameterizedType && !type2 instanceof ParameterizedType) {
            if (!type2 instanceof ParameterizedType) {
                return i2;
            }
            ownerType = (ParameterizedType)type.getOwnerType();
            ownerType2 = (ParameterizedType)type2.getOwnerType();
            if (ownerType != ownerType2) {
                if (ownerType != null && ownerType.equals(ownerType2) && type.getRawType().equals(type2.getRawType()) && Arrays.equals(type.getActualTypeArguments(), type2.getActualTypeArguments())) {
                    if (ownerType.equals(ownerType2)) {
                        if (type.getRawType().equals(type2.getRawType())) {
                            if (Arrays.equals(type.getActualTypeArguments(), type2.getActualTypeArguments())) {
                            } else {
                                i = i2;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        if (type instanceof GenericArrayType && !type2 instanceof GenericArrayType) {
            if (!type2 instanceof GenericArrayType) {
                return i2;
            }
            return Utils.equals((GenericArrayType)type.getGenericComponentType(), (GenericArrayType)type2.getGenericComponentType());
        }
        if (type instanceof WildcardType && !type2 instanceof WildcardType) {
            if (!type2 instanceof WildcardType) {
                return i2;
            }
            if (Arrays.equals((WildcardType)type.getUpperBounds(), (WildcardType)type2.getUpperBounds()) && Arrays.equals(type.getLowerBounds(), type2.getLowerBounds())) {
                if (Arrays.equals(type.getLowerBounds(), type2.getLowerBounds())) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        if (type instanceof TypeVariable && !type2 instanceof TypeVariable) {
            if (!type2 instanceof TypeVariable) {
                return i2;
            }
            if ((TypeVariable)type.getGenericDeclaration() == (TypeVariable)type2.getGenericDeclaration() && type.getName().equals(type2.getName())) {
                if (type.getName().equals(type2.getName())) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    static Type getGenericSupertype(Type type, Class<?> class2, Class<?> class3) {
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

    static Type getParameterLowerBound(int i, ParameterizedType parameterizedType2) {
        Type obj0;
        boolean obj1;
        obj0 = parameterizedType2.getActualTypeArguments()[i];
        if (obj0 instanceof WildcardType) {
            obj0 = (WildcardType)obj0.getLowerBounds()[0];
        }
        return obj0;
    }

    static Type getParameterUpperBound(int i, ParameterizedType parameterizedType2) {
        int length;
        Type obj4;
        boolean obj5;
        final Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
        if (i < 0) {
        } else {
            if (i >= actualTypeArguments.length) {
            } else {
                obj4 = actualTypeArguments[i];
                if (obj4 instanceof WildcardType) {
                    obj4 = (WildcardType)obj4.getUpperBounds()[0];
                }
                return obj4;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index ");
        stringBuilder.append(i);
        stringBuilder.append(" not in range [0,");
        stringBuilder.append(actualTypeArguments.length);
        stringBuilder.append(") for ");
        stringBuilder.append(parameterizedType2);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    static Class<?> getRawType(Type type) {
        Objects.requireNonNull(type, "type == null");
        if (type instanceof Class) {
            return (Class)type;
        }
        if (type instanceof ParameterizedType) {
            Type obj3 = (ParameterizedType)type.getRawType();
            if (!obj3 instanceof Class) {
            } else {
                return (Class)obj3;
            }
            obj3 = new IllegalArgumentException();
            throw obj3;
        }
        int i = 0;
        if (type instanceof GenericArrayType) {
            return Array.newInstance(Utils.getRawType((GenericArrayType)type.getGenericComponentType()), i).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (!type instanceof WildcardType) {
        } else {
            return Utils.getRawType((WildcardType)type.getUpperBounds()[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        stringBuilder.append(type);
        stringBuilder.append("> is of type ");
        stringBuilder.append(type.getClass().getName());
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    static Type getSupertype(Type type, Class<?> class2, Class<?> class3) {
        if (!class3.isAssignableFrom(class2)) {
        } else {
            return Utils.resolve(type, class2, Utils.getGenericSupertype(type, class2, class3));
        }
        IllegalArgumentException obj1 = new IllegalArgumentException();
        throw obj1;
    }

    static boolean hasUnresolvableType(Type type) {
        String name;
        int i;
        boolean unresolvableType;
        int i2 = 0;
        if (type instanceof Class) {
            return i2;
        }
        int i3 = 1;
        if (type instanceof ParameterizedType) {
            Type[] obj5 = (ParameterizedType)type.getActualTypeArguments();
            i = i2;
            while (i < obj5.length) {
                i++;
            }
            return i2;
        }
        if (type instanceof GenericArrayType) {
            return Utils.hasUnresolvableType((GenericArrayType)type.getGenericComponentType());
        }
        if (type instanceof TypeVariable) {
            return i3;
        }
        if (type instanceof WildcardType) {
            return i3;
        }
        if (type == null) {
            name = "null";
        } else {
            name = type.getClass().getName();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        stringBuilder.append(type);
        stringBuilder.append("> is of type ");
        stringBuilder.append(name);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private static int indexOf(Object[] objectArr, Object object2) {
        int i;
        boolean equals;
        i = 0;
        for (Object obj : objectArr) {
        }
        NoSuchElementException obj2 = new NoSuchElementException();
        throw obj2;
    }

    static boolean isAnnotationPresent(Annotation[] annotationArr, Class<? extends Annotation> class2) {
        int i;
        boolean instance;
        final int i2 = 0;
        i = i2;
        while (i < annotationArr.length) {
            i++;
        }
        return i2;
    }

    static RuntimeException methodError(Method method, String string2, Object... object3Arr3) {
        return Utils.methodError(method, 0, string2, object3Arr3);
    }

    static RuntimeException methodError(Method method, Throwable throwable2, String string3, Object... object4Arr4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(string3, object4Arr4));
        stringBuilder.append("\n    for method ");
        stringBuilder.append(method.getDeclaringClass().getSimpleName());
        stringBuilder.append(".");
        stringBuilder.append(method.getName());
        IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString(), throwable2);
        return obj4;
    }

    static RuntimeException parameterError(Method method, int i2, String string3, Object... object4Arr4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(" (parameter #");
        stringBuilder.append(i2++);
        stringBuilder.append(")");
        return Utils.methodError(method, stringBuilder.toString(), object4Arr4);
    }

    static RuntimeException parameterError(Method method, Throwable throwable2, int i3, String string4, Object... object5Arr5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string4);
        stringBuilder.append(" (parameter #");
        stringBuilder.append(i3++);
        stringBuilder.append(")");
        return Utils.methodError(method, throwable2, stringBuilder.toString(), object5Arr5);
    }

    static Type resolve(Type type, Class<?> class2, Type type3) {
        Object genericArrayTypeImpl;
        boolean lowerBounds;
        int i;
        boolean array;
        int i2;
        Type upperBounds;
        int length;
        Type[] actualTypeArguments;
        Type resolve;
        Type type2;
        Type obj8;
        Object obj9;
        Object obj10;
        while (type3 instanceof TypeVariable) {
            Type resolveTypeVariable = Utils.resolveTypeVariable(type, class2, (TypeVariable)type3);
            obj10 = resolveTypeVariable;
        }
        genericArrayTypeImpl = type3;
        if (type3 instanceof Class && (Class)genericArrayTypeImpl.isArray()) {
            genericArrayTypeImpl = type3;
            if ((Class)genericArrayTypeImpl.isArray()) {
                obj10 = genericArrayTypeImpl.getComponentType();
                obj8 = Utils.resolve(type, class2, obj10);
                if (obj10 == obj8) {
                } else {
                    genericArrayTypeImpl = new Utils.GenericArrayTypeImpl(obj8);
                }
                return genericArrayTypeImpl;
            }
        }
        if (type3 instanceof GenericArrayType) {
            Type genericComponentType = (GenericArrayType)type3.getGenericComponentType();
            obj8 = Utils.resolve(type, class2, genericComponentType);
            if (genericComponentType == obj8) {
            } else {
                obj10 = new Utils.GenericArrayTypeImpl(obj8);
            }
            return obj10;
        }
        int i3 = 1;
        i2 = 0;
        if (type3 instanceof ParameterizedType) {
            Type ownerType = (ParameterizedType)type3.getOwnerType();
            Type resolve2 = Utils.resolve(type, class2, ownerType);
            i = resolve2 != ownerType ? i3 : i2;
            while (i2 < actualTypeArguments.length) {
                resolve = Utils.resolve(type, class2, actualTypeArguments[i2]);
                if (resolve != actualTypeArguments[i2] && i == 0) {
                }
                i2++;
                if (i == 0) {
                }
                actualTypeArguments[i2] = resolve;
                actualTypeArguments = clone;
                i = i3;
            }
            if (i != 0) {
                obj8 = new Utils.ParameterizedTypeImpl(resolve2, type3.getRawType(), actualTypeArguments);
                obj10 = obj8;
            }
            return obj10;
        }
        if (type3 instanceof WildcardType) {
            lowerBounds = (WildcardType)type3.getLowerBounds();
            upperBounds = type3.getUpperBounds();
            if (lowerBounds.length == i3) {
                obj8 = Utils.resolve(type, class2, lowerBounds[i2]);
                if (obj8 != lowerBounds[i2]) {
                    obj10 = new Type[i3];
                    obj10[i2] = Object.class;
                    Type[] arr = new Type[i3];
                    arr[i2] = obj8;
                    obj9 = new Utils.WildcardTypeImpl(obj10, arr);
                    return obj9;
                }
            } else {
                obj8 = Utils.resolve(type, class2, upperBounds[i2]);
                if (upperBounds.length == i3 && obj8 != upperBounds[i2]) {
                    obj8 = Utils.resolve(type, class2, upperBounds[i2]);
                    if (obj8 != upperBounds[i2]) {
                        obj10 = new Type[i3];
                        obj10[i2] = obj8;
                        obj9 = new Utils.WildcardTypeImpl(obj10, Utils.EMPTY_TYPE_ARRAY);
                        return obj9;
                    }
                }
            }
        }
        return type3;
    }

    private static Type resolveTypeVariable(Type type, Class<?> class2, TypeVariable<?> typeVariable3) {
        final Class declaringClassOf = Utils.declaringClassOf(typeVariable3);
        if (declaringClassOf == null) {
            return typeVariable3;
        }
        Type obj1 = Utils.getGenericSupertype(type, class2, declaringClassOf);
        if (obj1 instanceof ParameterizedType) {
            return (ParameterizedType)obj1.getActualTypeArguments()[Utils.indexOf(declaringClassOf.getTypeParameters(), typeVariable3)];
        }
        return typeVariable3;
    }

    static void throwIfFatal(Throwable throwable) {
        if (throwable instanceof VirtualMachineError != null) {
        } else {
            if (throwable instanceof ThreadDeath) {
            } else {
                if (throwable instanceof LinkageError != null) {
                } else {
                }
                throw (LinkageError)throwable;
            }
            throw (ThreadDeath)throwable;
        }
        throw (VirtualMachineError)throwable;
    }

    static String typeToString(Type type) {
        String obj1;
        if (type instanceof Class) {
            obj1 = (Class)type.getName();
        } else {
            obj1 = type.toString();
        }
        return obj1;
    }
}
