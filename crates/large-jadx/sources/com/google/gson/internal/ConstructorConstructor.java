package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: classes2.dex */
public final class ConstructorConstructor {

    private final ReflectionAccessor accessor;
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        super();
        this.accessor = ReflectionAccessor.getInstance();
        this.instanceCreators = map;
    }

    private <T> com.google.gson.internal.ObjectConstructor<T> newDefaultConstructor(Class<? super T> class) {
        boolean accessible;
        final Constructor obj2 = class.getDeclaredConstructor(new Class[0]);
        if (!obj2.isAccessible()) {
            try {
                this.accessor.makeAccessible(obj2);
                ConstructorConstructor.3 anon = new ConstructorConstructor.3(this, obj2);
                return anon;
                class = 0;
                return class;
            }
        }
    }

    private <T> com.google.gson.internal.ObjectConstructor<T> newDefaultImplementationConstructor(Type type, Class<? super T> class2) {
        Class<java.util.SortedMap> obj;
        Type obj2;
        boolean obj3;
        if (Collection.class.isAssignableFrom(class2) && SortedSet.class.isAssignableFrom(class2)) {
            if (SortedSet.class.isAssignableFrom(class2)) {
                obj2 = new ConstructorConstructor.4(this);
                return obj2;
            }
            if (EnumSet.class.isAssignableFrom(class2)) {
                obj3 = new ConstructorConstructor.5(this, type);
                return obj3;
            }
            if (Set.class.isAssignableFrom(class2)) {
                obj2 = new ConstructorConstructor.6(this);
                return obj2;
            }
            if (Queue.class.isAssignableFrom(class2)) {
                obj2 = new ConstructorConstructor.7(this);
                return obj2;
            }
            obj2 = new ConstructorConstructor.8(this);
            return obj2;
        }
        if (Map.class.isAssignableFrom(class2) && ConcurrentNavigableMap.class.isAssignableFrom(class2)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(class2)) {
                obj2 = new ConstructorConstructor.9(this);
                return obj2;
            }
            if (ConcurrentMap.class.isAssignableFrom(class2)) {
                obj2 = new ConstructorConstructor.10(this);
                return obj2;
            }
            if (SortedMap.class.isAssignableFrom(class2)) {
                obj2 = new ConstructorConstructor.11(this);
                return obj2;
            }
            if (type instanceof ParameterizedType && !String.class.isAssignableFrom(TypeToken.get((ParameterizedType)type.getActualTypeArguments()[0]).getRawType())) {
                if (!String.class.isAssignableFrom(TypeToken.get((ParameterizedType)type.getActualTypeArguments()[0]).getRawType())) {
                    obj2 = new ConstructorConstructor.12(this);
                    return obj2;
                }
            }
            obj2 = new ConstructorConstructor.13(this);
            return obj2;
        }
        return 0;
    }

    private <T> com.google.gson.internal.ObjectConstructor<T> newUnsafeAllocator(Type type, Class<? super T> class2) {
        ConstructorConstructor.14 anon = new ConstructorConstructor.14(this, class2, type);
        return anon;
    }

    public <T> com.google.gson.internal.ObjectConstructor<T> get(TypeToken<T> typeToken) {
        final Type type = typeToken.getType();
        Class obj3 = typeToken.getRawType();
        Object obj = this.instanceCreators.get(type);
        if ((InstanceCreator)obj != null) {
            obj3 = new ConstructorConstructor.1(this, (InstanceCreator)obj, type);
            return obj3;
        }
        Object obj2 = this.instanceCreators.get(obj3);
        if ((InstanceCreator)obj2 != null) {
            obj3 = new ConstructorConstructor.2(this, (InstanceCreator)obj2, type);
            return obj3;
        }
        com.google.gson.internal.ObjectConstructor defaultConstructor = newDefaultConstructor(obj3);
        if (defaultConstructor != null) {
            return defaultConstructor;
        }
        com.google.gson.internal.ObjectConstructor defaultImplementationConstructor = newDefaultImplementationConstructor(type, obj3);
        if (defaultImplementationConstructor != null) {
            return defaultImplementationConstructor;
        }
        return newUnsafeAllocator(type, obj3);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
