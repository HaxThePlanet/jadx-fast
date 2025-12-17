package com.google.gson.internal;

import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public final class Primitives {
    public static boolean isPrimitive(Type type) {
        Object obj1;
        if (type instanceof Class && (Class)type.isPrimitive()) {
            obj1 = (Class)type.isPrimitive() ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean isWrapperType(Type type) {
        Class<Integer> obj;
        int obj1;
        if (type != Integer.class && type != Float.class && type != Byte.class && type != Double.class && type != Long.class && type != Character.class && type != Boolean.class && type != Short.class) {
            if (type != Float.class) {
                if (type != Byte.class) {
                    if (type != Double.class) {
                        if (type != Long.class) {
                            if (type != Character.class) {
                                if (type != Boolean.class) {
                                    if (type != Short.class) {
                                        if (type == Void.class) {
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
            } else {
            }
        } else {
        }
        return obj1;
    }

    public static <T> Class<T> unwrap(Class<T> class) {
        Class<Integer> obj1;
        if (class == Integer.class) {
            return Integer.TYPE;
        }
        if (class == Float.class) {
            return Float.TYPE;
        }
        if (class == Byte.class) {
            return Byte.TYPE;
        }
        if (class == Double.class) {
            return Double.TYPE;
        }
        if (class == Long.class) {
            return Long.TYPE;
        }
        if (class == Character.class) {
            return Character.TYPE;
        }
        if (class == Boolean.class) {
            return Boolean.TYPE;
        }
        if (class == Short.class) {
            return Short.TYPE;
        }
        if (class == Void.class) {
            obj1 = Void.TYPE;
        }
        return obj1;
    }

    public static <T> Class<T> wrap(Class<T> class) {
        Class obj1;
        if (class == Integer.TYPE) {
            return Integer.class;
        }
        if (class == Float.TYPE) {
            return Float.class;
        }
        if (class == Byte.TYPE) {
            return Byte.class;
        }
        if (class == Double.TYPE) {
            return Double.class;
        }
        if (class == Long.TYPE) {
            return Long.class;
        }
        if (class == Character.TYPE) {
            return Character.class;
        }
        if (class == Boolean.TYPE) {
            return Boolean.class;
        }
        if (class == Short.TYPE) {
            return Short.class;
        }
        if (class == Void.TYPE) {
            obj1 = Void.class;
        }
        return obj1;
    }
}
