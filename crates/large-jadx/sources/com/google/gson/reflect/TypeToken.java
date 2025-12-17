package com.google.gson.reflect;

import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.internal..Gson.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class TypeToken<T>  {

    final int hashCode;
    final Class<? super T> rawType;
    final Type type;
    protected TypeToken() {
        super();
        Type superclassTypeParameter = TypeToken.getSuperclassTypeParameter(getClass());
        this.type = superclassTypeParameter;
        this.rawType = .Gson.Types.getRawType(superclassTypeParameter);
        this.hashCode = superclassTypeParameter.hashCode();
    }

    TypeToken(Type type) {
        super();
        Type obj2 = .Gson.Types.canonicalize((Type).Gson.Preconditions.checkNotNull(type));
        this.type = obj2;
        this.rawType = .Gson.Types.getRawType(obj2);
        this.hashCode = obj2.hashCode();
    }

    private static java.lang.AssertionError buildUnexpectedTypeError(Type type, Class<?>... class2Arr2) {
        int i;
        String str;
        StringBuilder stringBuilder = new StringBuilder("Unexpected type. Expected one of: ");
        i = 0;
        while (i < class2Arr2.length) {
            stringBuilder.append(class2Arr2[i].getName());
            stringBuilder.append(", ");
            i++;
        }
        stringBuilder.append("but got: ");
        stringBuilder.append(type.getClass().getName());
        stringBuilder.append(", for type token: ");
        stringBuilder.append(type.toString());
        stringBuilder.append('.');
        AssertionError obj4 = new AssertionError(stringBuilder.toString());
        return obj4;
    }

    public static <T> com.google.gson.reflect.TypeToken<T> get(Class<T> class) {
        TypeToken typeToken = new TypeToken(class);
        return typeToken;
    }

    public static com.google.gson.reflect.TypeToken<?> get(Type type) {
        TypeToken typeToken = new TypeToken(type);
        return typeToken;
    }

    public static com.google.gson.reflect.TypeToken<?> getArray(Type type) {
        TypeToken typeToken = new TypeToken(.Gson.Types.arrayOf(type));
        return typeToken;
    }

    public static com.google.gson.reflect.TypeToken<?> getParameterized(Type type, Type... type2Arr2) {
        TypeToken typeToken = new TypeToken(.Gson.Types.newParameterizedTypeWithOwner(0, type, type2Arr2));
        return typeToken;
    }

    static Type getSuperclassTypeParameter(Class<?> class) {
        Type obj1 = class.getGenericSuperclass();
        if (obj1 instanceof Class) {
        } else {
            return .Gson.Types.canonicalize((ParameterizedType)obj1.getActualTypeArguments()[0]);
        }
        obj1 = new RuntimeException("Missing type parameter.");
        throw obj1;
    }

    private static boolean isAssignableFrom(Type type, GenericArrayType genericArrayType2) {
        boolean array;
        Object obj1;
        final Type obj2 = genericArrayType2.getGenericComponentType();
        if (obj2 instanceof ParameterizedType) {
            if (type instanceof GenericArrayType) {
                obj1 = (GenericArrayType)type.getGenericComponentType();
            } else {
                if (type instanceof Class) {
                    while (obj1.isArray()) {
                        obj1 = obj1.getComponentType();
                    }
                }
            }
            HashMap hashMap = new HashMap();
            return TypeToken.isAssignableFrom(obj1, (ParameterizedType)obj2, hashMap);
        }
        return 1;
    }

    private static boolean isAssignableFrom(Type type, ParameterizedType parameterizedType2, Map<String, Type> map3) {
        int i;
        int i2;
        boolean assignableFrom;
        int hashMap;
        int length;
        String name;
        boolean z;
        Object obj9;
        i = 0;
        if (type == null) {
            return i;
        }
        final int i3 = 1;
        if (parameterizedType2.equals(type)) {
            return i3;
        }
        Class rawType = .Gson.Types.getRawType(type);
        i2 = 0;
        if (type instanceof ParameterizedType) {
            i2 = type;
        }
        if (i2 != 0) {
            obj9 = i2.getActualTypeArguments();
            hashMap = i;
            for (Object length : type) {
                while (length instanceof TypeVariable) {
                    length = map3.get((TypeVariable)length.getName());
                }
                map3.put(rawType.getTypeParameters()[hashMap].getName(), length);
                length = map3.get((TypeVariable)length.getName());
            }
            if (TypeToken.typeEquals(i2, parameterizedType2, map3)) {
                return i3;
            }
        }
        obj9 = rawType.getGenericInterfaces();
        while (i < obj9.length) {
            hashMap = new HashMap(map3);
            i++;
        }
        HashMap hashMap2 = new HashMap(map3);
        return TypeToken.isAssignableFrom(rawType.getGenericSuperclass(), parameterizedType2, hashMap2);
    }

    private static boolean matches(Type type, Type type2, Map<String, Type> map3) {
        boolean equals;
        Object obj1;
        if (!type2.equals(type)) {
            if (type instanceof TypeVariable && type2.equals(map3.get((TypeVariable)type.getName()))) {
                if (type2.equals(map3.get((TypeVariable)type.getName()))) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private static boolean typeEquals(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map3) {
        int i;
        boolean matches;
        Type type;
        int i2 = 0;
        if (parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            Type[] obj4 = parameterizedType.getActualTypeArguments();
            i = i2;
            for (Object type2 : parameterizedType) {
            }
            return 1;
        }
        return i2;
    }

    public final boolean equals(Object object) {
        boolean type;
        Object obj2;
        if (object instanceof TypeToken && .Gson.Types.equals(this.type, object.type)) {
            obj2 = .Gson.Types.equals(this.type, object.type) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    @Deprecated
    public boolean isAssignableFrom(com.google.gson.reflect.TypeToken<?> typeToken) {
        return isAssignableFrom(typeToken.getType());
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> class) {
        return isAssignableFrom(class);
    }

    @Deprecated
    public boolean isAssignableFrom(Type type) {
        int i;
        boolean assignableFrom;
        Object obj5;
        i = 0;
        if (type == null) {
            return i;
        }
        int i3 = 1;
        if (this.type.equals(type)) {
            return i3;
        }
        Type type3 = this.type;
        if (type3 instanceof Class) {
            return this.rawType.isAssignableFrom(.Gson.Types.getRawType(type));
        }
        if (type3 instanceof ParameterizedType) {
            HashMap hashMap = new HashMap();
            return TypeToken.isAssignableFrom(type, (ParameterizedType)type3, hashMap);
        }
        if (!type3 instanceof GenericArrayType) {
        } else {
            if (this.rawType.isAssignableFrom(.Gson.Types.getRawType(type)) && TypeToken.isAssignableFrom(type, (GenericArrayType)this.type)) {
                if (TypeToken.isAssignableFrom(type, (GenericArrayType)this.type)) {
                    i = i3;
                }
            }
            return i;
        }
        obj5 = new Class[3];
        obj5[i] = Class.class;
        obj5[i3] = ParameterizedType.class;
        obj5[2] = GenericArrayType.class;
        throw TypeToken.buildUnexpectedTypeError(type3, obj5);
    }

    public final String toString() {
        return .Gson.Types.typeToString(this.type);
    }
}
