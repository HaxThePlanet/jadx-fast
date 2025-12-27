package com.squareup.moshi;

import com.squareup.moshi.v.b;
import com.squareup.moshi.v.b.a;
import com.squareup.moshi.v.b.b;
import com.squareup.moshi.v.b.c;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

/* compiled from: Types.java */
/* loaded from: classes2.dex */
public final class t {
    static Type a(Type type) {
        if (type instanceof GenericArrayType) {
            return type.getGenericComponentType();
        }
        if (type instanceof Class) {
            return type.getComponentType();
        }
        return null;
    }

    public static GenericArrayType b(Type type) {
        return new b.a(type);
    }

    public static Type c(Type type, Class<?> cls) {
        Type type2;
        type2 = t.h(type, cls, Collection.class);
        int i = 0;
        if (type2 instanceof WildcardType) {
            type2 = type2.getUpperBounds()[i];
        }
        if (type2 instanceof ParameterizedType) {
            return type2.getActualTypeArguments()[i];
        }
        return Object.class;
    }

    public static boolean d(Type type, Type type2) {
        boolean z = true;
        Type[] actualTypeArguments;
        Type[] actualTypeArguments2;
        boolean equals;
        boolean equals2;
        boolean equals3;
        Type[] lowerBounds;
        String name;
        Type rawType;
        z = true;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            if (type2 instanceof GenericArrayType) {
                return t.d(type.getComponentType(), type2.getGenericComponentType());
            }
            return type.equals(type2);
        }
        final int i = 0;
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            if (type instanceof b.b) {
            } else {
                actualTypeArguments = type.getActualTypeArguments();
            }
            if (type2 instanceof b.b) {
            } else {
                actualTypeArguments2 = type2.getActualTypeArguments();
            }
            if (t.d(type.getOwnerType(), type2.getOwnerType())) {
                if (!type.getRawType().equals(type2.getRawType()) || !(Arrays.equals(type instanceof b.b, type2 instanceof b.b))) {
                }
            }
            return z;
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof Class) {
                return t.d(type2.getComponentType(), type.getGenericComponentType());
            }
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return t.d(type.getGenericComponentType(), type2.getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            if (Arrays.equals(type.getUpperBounds(), type2.getUpperBounds())) {
                if (!(Arrays.equals(type.getLowerBounds(), type2.getLowerBounds()))) {
                }
            }
            return z;
        }
        if (type instanceof TypeVariable) {
            if (!(type2 instanceof TypeVariable)) {
                return false;
            }
            if (type.getGenericDeclaration() == type2.getGenericDeclaration()) {
                if (!(type.getName().equals(type2.getName()))) {
                }
            }
            return z;
        }
        return false;
    }

    public static String e(String str) {
        final StringBuilder stringBuilder = new StringBuilder();
        String replaced = str.replace("$", "_");
        String str4 = "JsonAdapter";
        str5 = replaced + str4;
        return str5;
    }

    static Type f(Type type) {
        final Class cls = t.g(type);
        return b.n(type, cls, cls.getGenericSuperclass());
    }

    public static Class<?> g(Type type) {
        String name;
        if (type instanceof Class) {
            return type;
        }
        if (type instanceof ParameterizedType) {
            return (Class)type.getRawType();
        }
        int i = 0;
        if (type instanceof GenericArrayType) {
            return Array.newInstance(t.g(type.getGenericComponentType()), i).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return t.g(type.getUpperBounds()[i]);
        }
        if (type == null) {
            name = "null";
        } else {
            name = type.getClass().getName();
        }
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "Expected a Class, ParameterizedType, or GenericArrayType, but <";
        String str2 = "> is of type ";
        type = str + type + str2 + name;
        throw new IllegalArgumentException(type);
    }

    static Type h(Type type, Class<?> cls, Class<?> cls2) {
        if (!cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException();
        } else {
            return b.n(type, cls, b.e(type, cls, cls2));
        }
    }

    static Type[] i(Type type, Class<?> cls) {
        final Class<Object> obj = Object.class;
        Class<String> obj2 = String.class;
        final int i = 1;
        final int i2 = 0;
        final int i3 = 2;
        if (type == Properties.class) {
            Type[] arr = new Type[i3];
            return new Type[] { obj2, obj2 };
        }
        Type type2 = t.h(type, cls, Map.class);
        if (type2 instanceof ParameterizedType) {
            return type2.getActualTypeArguments();
        }
        Type[] arr2 = new Type[i3];
        return new Type[] { obj, obj };
    }

    public static ParameterizedType j(Type type, Type... typeArr) {
        if (typeArr.length == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Missing type arguments for ";
            type = str + type;
            throw new IllegalArgumentException(type);
        } else {
            return new b.b(null, type, typeArr);
        }
    }

    public static WildcardType k(Type type) {
        Type[] upperBounds;
        z = type instanceof WildcardType;
        if (type instanceof WildcardType) {
            upperBounds = type.getUpperBounds();
        } else {
            upperBounds = new Type[1];
            int i = 0;
            upperBounds[i] = type;
        }
        return new b.c(upperBounds, b.b);
    }

    public static WildcardType l(Type type) {
        Type[] lowerBounds;
        z = type instanceof WildcardType;
        final int i = 0;
        int i2 = 1;
        if (type instanceof WildcardType) {
            lowerBounds = type.getLowerBounds();
        } else {
            lowerBounds = new Type[i2];
        }
        Type[] arr = new Type[i2];
        return new b.c(arr, lowerBounds);
    }
}
