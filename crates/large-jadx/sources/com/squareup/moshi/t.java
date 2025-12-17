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

/* loaded from: classes2.dex */
public final class t {
    static Type a(Type type) {
        if (type instanceof GenericArrayType) {
            return (GenericArrayType)type.getGenericComponentType();
        }
        if (type instanceof Class) {
            return (Class)type.getComponentType();
        }
        return null;
    }

    public static GenericArrayType b(Type type) {
        b.a aVar = new b.a(type);
        return aVar;
    }

    public static Type c(Type type, Class<?> class2) {
        Type obj1;
        obj1 = t.h(type, class2, Collection.class);
        int i = 0;
        if (obj1 instanceof WildcardType) {
            obj1 = (WildcardType)obj1.getUpperBounds()[i];
        }
        if (obj1 instanceof ParameterizedType) {
            return (ParameterizedType)obj1.getActualTypeArguments()[i];
        }
        return Object.class;
    }

    public static boolean d(Type type, Type type2) {
        int i;
        Type[] actualTypeArguments;
        Type[] actualTypeArguments2;
        boolean obj6;
        Type[] obj7;
        if (type == type2) {
            return 1;
        }
        if (type instanceof Class && type2 instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return t.d((Class)type.getComponentType(), (GenericArrayType)type2.getGenericComponentType());
            }
            return type.equals(type2);
        }
        final int i2 = 0;
        if (type instanceof ParameterizedType && !type2 instanceof ParameterizedType) {
            if (!type2 instanceof ParameterizedType) {
                return i2;
            }
            if (type instanceof b.b) {
                actualTypeArguments = obj.c;
            } else {
                actualTypeArguments = type.getActualTypeArguments();
            }
            if (type2 instanceof b.b) {
                actualTypeArguments2 = obj2.c;
            } else {
                actualTypeArguments2 = type2.getActualTypeArguments();
            }
            if (t.d(type.getOwnerType(), type2.getOwnerType()) && type.getRawType().equals(type2.getRawType()) && Arrays.equals(actualTypeArguments, actualTypeArguments2)) {
                if (type.getRawType().equals(type2.getRawType())) {
                    if (Arrays.equals(actualTypeArguments, actualTypeArguments2)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        if (type instanceof GenericArrayType && type2 instanceof Class) {
            if (type2 instanceof Class) {
                return t.d((Class)type2.getComponentType(), (GenericArrayType)type.getGenericComponentType());
            }
            if (!type2 instanceof GenericArrayType) {
                return i2;
            }
            return t.d((GenericArrayType)type.getGenericComponentType(), (GenericArrayType)type2.getGenericComponentType());
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

    public static String e(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.replace("$", "_"));
        stringBuilder.append("JsonAdapter");
        return stringBuilder.toString();
    }

    static Type f(Type type) {
        final Class cls = t.g(type);
        return b.n(type, cls, cls.getGenericSuperclass());
    }

    public static Class<?> g(Type type) {
        String name;
        if (type instanceof Class) {
            return (Class)type;
        }
        if (type instanceof ParameterizedType) {
            return (Class)(ParameterizedType)type.getRawType();
        }
        int i = 0;
        if (type instanceof GenericArrayType) {
            return Array.newInstance(t.g((GenericArrayType)type.getGenericComponentType()), i).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return t.g((WildcardType)type.getUpperBounds()[i]);
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

    static Type h(Type type, Class<?> class2, Class<?> class3) {
        if (!class3.isAssignableFrom(class2)) {
        } else {
            return b.n(type, class2, b.e(type, class2, class3));
        }
        IllegalArgumentException obj1 = new IllegalArgumentException();
        throw obj1;
    }

    static Type[] i(Type type, Class<?> class2) {
        final Class<Object> obj = Object.class;
        Class<String> obj2 = String.class;
        final int i = 1;
        final int i2 = 0;
        final int i3 = 2;
        if (type == Properties.class) {
            Type[] obj6 = new Type[i3];
            obj6[i2] = obj2;
            obj6[i] = obj2;
            return obj6;
        }
        obj6 = t.h(type, class2, Map.class);
        if (obj6 instanceof ParameterizedType) {
            return (ParameterizedType)obj6.getActualTypeArguments();
        }
        obj6 = new Type[i3];
        obj6[i2] = obj;
        obj6[i] = obj;
        return obj6;
    }

    public static ParameterizedType j(Type type, Type... type2Arr2) {
        if (type2Arr2.length == 0) {
        } else {
            b.b bVar = new b.b(0, type, type2Arr2);
            return bVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing type arguments for ");
        stringBuilder.append(type);
        IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder.toString());
        throw obj3;
    }

    public static WildcardType k(Type type) {
        boolean arr;
        int i;
        Type[] obj2;
        if (type instanceof WildcardType) {
            obj2 = (WildcardType)type.getUpperBounds();
        } else {
            arr = new Type[1];
            obj2 = arr;
        }
        b.c cVar = new b.c(obj2, b.b);
        return cVar;
    }

    public static WildcardType l(Type type) {
        boolean arr;
        Type[] obj4;
        final int i = 0;
        int i2 = 1;
        if (type instanceof WildcardType) {
            obj4 = (WildcardType)type.getLowerBounds();
        } else {
            arr = new Type[i2];
            arr[i] = type;
            obj4 = arr;
        }
        Type[] arr2 = new Type[i2];
        arr2[i] = Object.class;
        b.c cVar = new b.c(arr2, obj4);
        return cVar;
    }
}
