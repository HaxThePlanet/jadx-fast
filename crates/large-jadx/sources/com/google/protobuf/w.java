package com.google.protobuf;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public enum w {

    GROUP_LIST(false, field_4, field_5);

    private final com.google.protobuf.w.b collection;
    private final Class<?> elementType = null;
    private final int id;
    private final com.google.protobuf.e0 javaType;
    private final boolean primitiveScalar = false;

    static class a {

        static final int[] a;
        static final int[] b;
        static {
            int[] iArr = new int[values.length];
            w.a.b = iArr;
            int i2 = 1;
            iArr[e0.BYTE_STRING.ordinal()] = i2;
            int i = 2;
            w.a.b[e0.MESSAGE.ordinal()] = i;
            int i3 = 3;
            w.a.b[e0.STRING.ordinal()] = i3;
            int[] iArr6 = new int[values2.length];
            w.a.a = iArr6;
            iArr6[w.b.MAP.ordinal()] = i2;
            w.a.a[w.b.VECTOR.ordinal()] = i;
            w.a.a[w.b.SCALAR.ordinal()] = i3;
        }
    }

    static enum b {

        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);

        private final boolean isList;
        @Override // java.lang.Enum
        public boolean isList() {
            return this.isList;
        }
    }
    public static com.google.protobuf.w forId(int i) {
        com.google.protobuf.w[] vALUES;
        int length;
        vALUES = w.VALUES;
        if (i >= 0 && i >= vALUES.length) {
            vALUES = w.VALUES;
            if (i >= vALUES.length) {
            }
            return vALUES[i];
        }
        return null;
    }

    private static Type getGenericSuperList(Class<?> class) {
        boolean assignableFrom;
        int length;
        int i;
        Type type;
        boolean assignableFrom2;
        Class<java.util.List> obj;
        Type[] genericInterfaces = class.getGenericInterfaces();
        i = 0;
        while (i < genericInterfaces.length) {
            type = genericInterfaces[i];
            i++;
        }
        Type obj6 = class.getGenericSuperclass();
        if (obj6 instanceof ParameterizedType && List.class.isAssignableFrom((Class)(ParameterizedType)obj6.getRawType())) {
            if (List.class.isAssignableFrom((Class)(ParameterizedType)obj6.getRawType())) {
                return obj6;
            }
        }
        return null;
    }

    private static Type getListParameter(Class<?> class, Type[] type2Arr2) {
        Class[] genericSuperList;
        int i2;
        int length3;
        boolean actualTypeArguments;
        boolean assignableFrom;
        int length2;
        boolean z;
        int i;
        int length;
        Class<java.util.List> obj9;
        Type[] obj10;
        i2 = 0;
        length3 = 1;
        while (obj9 != List.class) {
            genericSuperList = w.getGenericSuperList(obj9);
            if (genericSuperList instanceof ParameterizedType) {
            } else {
            }
            obj10 = w.EMPTY_TYPES;
            genericSuperList = obj9.getInterfaces();
            while (i2 < genericSuperList.length) {
                actualTypeArguments = genericSuperList[i2];
                i2++;
            }
            obj9 = obj9.getSuperclass();
            i2 = 0;
            length3 = 1;
            actualTypeArguments = genericSuperList[i2];
            if (List.class.isAssignableFrom(actualTypeArguments)) {
            } else {
            }
            i2++;
            obj9 = actualTypeArguments;
            actualTypeArguments = (ParameterizedType)genericSuperList.getActualTypeArguments();
            assignableFrom = i2;
            for (Object length2 : obj3) {
                java.lang.reflect.TypeVariable[] typeParameters = obj9.getTypeParameters();
                i = i2;
                for (Object length : obj6) {
                }
                z = i2;
                if (length2 == typeParameters[i]) {
                } else {
                }
                i++;
                actualTypeArguments[assignableFrom] = obj10[i];
                z = length3;
            }
            obj9 = genericSuperList.getRawType();
            obj10 = actualTypeArguments;
            length2 = actualTypeArguments[assignableFrom];
            assignableFrom++;
            typeParameters = obj9.getTypeParameters();
            i = i2;
            for (Object length : obj6) {
            }
            z = i2;
            if (length2 == typeParameters[i]) {
            } else {
            }
            i++;
            actualTypeArguments[assignableFrom] = obj10[i];
            z = length3;
        }
        if (obj10.length != length3) {
        } else {
            return obj10[i2];
        }
        obj9 = new RuntimeException("Unable to identify parameter type for List<T>");
        throw obj9;
    }

    private boolean isValidForList(Field field) {
        Type[] actualTypeArguments;
        Type obj4;
        Class type = field.getType();
        if (!this.javaType.getType().isAssignableFrom(type)) {
            return 0;
        }
        actualTypeArguments = w.EMPTY_TYPES;
        if (genericType instanceof ParameterizedType) {
            actualTypeArguments = (ParameterizedType)field.getGenericType().getActualTypeArguments();
        }
        obj4 = w.getListParameter(type, actualTypeArguments);
        if (!obj4 instanceof Class) {
            return 1;
        }
        return this.elementType.isAssignableFrom((Class)obj4);
    }

    @Override // java.lang.Enum
    public com.google.protobuf.e0 getJavaType() {
        return this.javaType;
    }

    @Override // java.lang.Enum
    public int id() {
        return this.id;
    }

    @Override // java.lang.Enum
    public boolean isList() {
        return this.collection.isList();
    }

    @Override // java.lang.Enum
    public boolean isMap() {
        int i;
        i = this.collection == w.b.MAP ? 1 : 0;
        return i;
    }

    @Override // java.lang.Enum
    public boolean isPacked() {
        return w.b.PACKED_VECTOR.equals(this.collection);
    }

    @Override // java.lang.Enum
    public boolean isPrimitiveScalar() {
        return this.primitiveScalar;
    }

    @Override // java.lang.Enum
    public boolean isScalar() {
        int i;
        i = this.collection == w.b.SCALAR ? 1 : 0;
        return i;
    }

    @Override // java.lang.Enum
    public boolean isValidForField(Field field) {
        if (w.b.VECTOR.equals(this.collection)) {
            return isValidForList(field);
        }
        return this.javaType.getType().isAssignableFrom(field.getType());
    }
}
