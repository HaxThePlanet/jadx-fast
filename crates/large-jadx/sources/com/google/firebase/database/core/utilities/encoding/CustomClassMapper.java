package com.google.firebase.database.core.utilities.encoding;

import android.util.Log;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.PropertyName;
import com.google.firebase.database.core.utilities.Utilities;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public class CustomClassMapper {

    private static final String LOG_TAG = "ClassMapper";
    private static final ConcurrentMap<Class<?>, com.google.firebase.database.core.utilities.encoding.CustomClassMapper.BeanMapper<?>> mappers;

    private static class BeanMapper {

        private final Class<T> clazz;
        private final Constructor<T> constructor = null;
        private final Map<String, Field> fields;
        private final Map<String, Method> getters;
        private final Map<String, String> properties;
        private final Map<String, Method> setters;
        private final boolean throwOnUnknownProperties;
        private final boolean warnOnUnknownProperties;
        public BeanMapper(Class<T> class) {
            int str;
            int equals;
            int length;
            Object obj;
            boolean z;
            Map propertyName;
            Map fields;
            Locale lowerCase;
            super();
            this.clazz = class;
            this.throwOnUnknownProperties = class.isAnnotationPresent(ThrowOnExtraProperties.class);
            final int i3 = 1;
            this.warnOnUnknownProperties = annotationPresent2 ^= i3;
            HashMap hashMap = new HashMap();
            this.properties = hashMap;
            HashMap hashMap2 = new HashMap();
            this.setters = hashMap2;
            HashMap hashMap3 = new HashMap();
            this.getters = hashMap3;
            HashMap hashMap4 = new HashMap();
            this.fields = hashMap4;
            class.getDeclaredConstructor(new Class[0]).setAccessible(i3);
        }

        static Class access$000(com.google.firebase.database.core.utilities.encoding.CustomClassMapper.BeanMapper customClassMapper$BeanMapper) {
            return beanMapper.clazz;
        }

        private void addProperty(String string) {
            Object equals;
            final Locale uS = Locale.US;
            equals = this.properties.put(string.toLowerCase(uS), string);
            if ((String)equals != null) {
                if (!string.equals((String)equals)) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Found two getters or fields with conflicting case sensitivity for property: ");
                stringBuilder.append(string.toLowerCase(uS));
                DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
                throw databaseException;
            }
        }

        private static String annotatedName(AccessibleObject accessibleObject) {
            if (accessibleObject.isAnnotationPresent(PropertyName.class)) {
                return (PropertyName)accessibleObject.getAnnotation(PropertyName.class).value();
            }
            return null;
        }

        private static boolean isSetterOverride(Method method, Method method2) {
            int i;
            int i2;
            int i3;
            boolean obj6;
            Object obj7;
            Utilities.hardAssert(method.getDeclaringClass().isAssignableFrom(method2.getDeclaringClass()), "Expected override from a base class");
            String str2 = "Expected void return type";
            Utilities.hardAssert(method.getReturnType().equals(Void.TYPE), str2);
            Utilities.hardAssert(method2.getReturnType().equals(Void.TYPE), str2);
            Class[] parameterTypes = method.getParameterTypes();
            Class[] parameterTypes2 = method2.getParameterTypes();
            i3 = 0;
            final int i4 = 1;
            i = parameterTypes.length == i4 ? i4 : i3;
            final String str3 = "Expected exactly one parameter";
            Utilities.hardAssert(i, str3);
            i2 = parameterTypes2.length == i4 ? i4 : i3;
            Utilities.hardAssert(i2, str3);
            if (method.getName().equals(method2.getName()) && parameterTypes[i3].equals(parameterTypes2[i3])) {
                if (parameterTypes[i3].equals(parameterTypes2[i3])) {
                    i3 = i4;
                }
            }
            return i3;
        }

        private static String propertyName(Field field) {
            String annotatedName;
            if (CustomClassMapper.BeanMapper.annotatedName(field) != null) {
            } else {
                annotatedName = field.getName();
            }
            return annotatedName;
        }

        private static String propertyName(Method method) {
            String serializedName;
            Object obj1;
            if (CustomClassMapper.BeanMapper.annotatedName(method) != null) {
            } else {
                serializedName = CustomClassMapper.BeanMapper.serializedName(method.getName());
            }
            return serializedName;
        }

        private Type resolveType(Type type, Map<TypeVariable<Class<T>>, Type> map2) {
            if (type instanceof TypeVariable) {
                Object obj4 = map2.get(type);
                if ((Type)obj4 == null) {
                } else {
                    return (Type)obj4;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not resolve type ");
                stringBuilder.append(type);
                obj4 = new IllegalStateException(stringBuilder.toString());
                throw obj4;
            }
            return type;
        }

        private static String serializedName(String string) {
            int lowerCase;
            int upperCase;
            int i;
            int i2;
            int i3;
            Object obj;
            boolean startsWith;
            i2 = 0;
            i3 = i;
            while (i3 < 3) {
                obj = /* result */[i3];
                if (string.startsWith(obj)) {
                }
                i3++;
                i2 = obj;
            }
            if (i2 == 0) {
            } else {
                char[] obj6 = string.substring(i2.length()).toCharArray();
                for (char c2 : string) {
                    if (Character.isUpperCase(obj6[i])) {
                    }
                    obj6[i] = Character.toLowerCase(c2);
                }
                String string2 = new String(obj6);
                return string2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown Bean prefix for method: ");
            stringBuilder.append(string);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        private static boolean shouldIncludeField(Field field) {
            int i = 0;
            if (field.getDeclaringClass().equals(Object.class)) {
                return i;
            }
            if (!Modifier.isPublic(field.getModifiers())) {
                return i;
            }
            if (Modifier.isStatic(field.getModifiers())) {
                return i;
            }
            if (Modifier.isTransient(field.getModifiers())) {
                return i;
            }
            if (field.isAnnotationPresent(Exclude.class)) {
                return i;
            }
            return 1;
        }

        private static boolean shouldIncludeGetter(Method method) {
            boolean startsWith;
            String str;
            int i = 0;
            if (!method.getName().startsWith("get") && !method.getName().startsWith("is")) {
                if (!method.getName().startsWith("is")) {
                    return i;
                }
            }
            if (method.getDeclaringClass().equals(Object.class)) {
                return i;
            }
            if (!Modifier.isPublic(method.getModifiers())) {
                return i;
            }
            if (Modifier.isStatic(method.getModifiers())) {
                return i;
            }
            if (method.getReturnType().equals(Void.TYPE)) {
                return i;
            }
            if (parameterTypes.length != 0) {
                return i;
            }
            if (method.isAnnotationPresent(Exclude.class)) {
                return i;
            }
            return 1;
        }

        private static boolean shouldIncludeSetter(Method method) {
            int i = 0;
            if (!method.getName().startsWith("set")) {
                return i;
            }
            if (method.getDeclaringClass().equals(Object.class)) {
                return i;
            }
            if (Modifier.isStatic(method.getModifiers())) {
                return i;
            }
            if (!method.getReturnType().equals(Void.TYPE)) {
                return i;
            }
            int i2 = 1;
            if (parameterTypes.length != i2) {
                return i;
            }
            if (method.isAnnotationPresent(Exclude.class)) {
                return i;
            }
            return i2;
        }

        public T deserialize(Map<String, Object> map) {
            return deserialize(map, Collections.emptyMap());
        }

        public T deserialize(Map<String, Object> map, Map<TypeVariable<Class<T>>, Type> map2) {
            Object[] string;
            boolean warnOnUnknownProperties;
            boolean stringBuilder;
            Object resolveType;
            Locale length;
            int i;
            Constructor constructor = this.constructor;
            if (constructor == null) {
            } else {
                final int i2 = 0;
                Object instance = constructor.newInstance(new Object[i2]);
                Iterator obj8 = map.entrySet().iterator();
                for (Map.Entry next2 : obj8) {
                    Object key = next2.getKey();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("No setter/field for ");
                    stringBuilder2.append(key);
                    stringBuilder2.append(" found on class ");
                    stringBuilder2.append(this.clazz.getName());
                    if (this.properties.containsKey(key.toLowerCase(Locale.US))) {
                    }
                    if (this.warnOnUnknownProperties) {
                    }
                    Log.w("ClassMapper", string);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuilder2.toString());
                    stringBuilder.append(" (fields/setters are case sensitive!)");
                    string = stringBuilder.toString();
                    warnOnUnknownProperties = this.fields.get(key);
                    warnOnUnknownProperties.set(instance, CustomClassMapper.access$100(next2.getValue(), resolveType((Field)warnOnUnknownProperties.getGenericType(), map2)));
                    warnOnUnknownProperties = this.setters.get(key);
                    Type[] genericParameterTypes = (Method)warnOnUnknownProperties.getGenericParameterTypes();
                    i = 1;
                    resolveType = new Object[i];
                    resolveType[i2] = CustomClassMapper.access$100(next2.getValue(), resolveType(genericParameterTypes[i2], map2));
                    warnOnUnknownProperties.invoke(instance, resolveType);
                }
                return instance;
            }
            StringBuilder obj9 = new StringBuilder();
            obj9.append("Class ");
            obj9.append(this.clazz.getName());
            obj9.append(" does not define a no-argument constructor. If you are using ProGuard, make sure these constructors are not stripped.");
            obj8 = new DatabaseException(obj9.toString());
            throw obj8;
        }

        public Map<String, Object> serialize(T t) {
            Object next;
            Object obj;
            Object invoke;
            Object[] arr;
            if (!this.clazz.isAssignableFrom(t.getClass())) {
            } else {
                HashMap hashMap = new HashMap();
                Iterator iterator = this.properties.values().iterator();
                for (String next : iterator) {
                    Object obj2 = this.fields.get(next);
                    invoke = (Field)obj2.get(t);
                    hashMap.put(next, CustomClassMapper.access$200(invoke));
                    invoke = (Method)this.getters.get(next).invoke(t, new Object[0]);
                }
                return hashMap;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Can't serialize object of class ");
            stringBuilder2.append(t.getClass());
            stringBuilder2.append(" with BeanMapper for class ");
            stringBuilder2.append(this.clazz);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
            throw illegalArgumentException;
        }
    }
    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        CustomClassMapper.mappers = concurrentHashMap;
    }

    static Object access$100(Object object, Type type2) {
        return CustomClassMapper.deserializeToType(object, type2);
    }

    static Object access$200(Object object) {
        return CustomClassMapper.serialize(object);
    }

    private static <T> T convertBean(Object object, Class<T> class2) {
        if (object instanceof Map == null) {
        } else {
            return CustomClassMapper.loadOrCreateBeanMapperForClass(class2).deserialize(CustomClassMapper.expectMap(object));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't convert object of type ");
        stringBuilder.append(object.getClass().getName());
        stringBuilder.append(" to type ");
        stringBuilder.append(class2.getName());
        DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
        throw databaseException;
    }

    private static Boolean convertBoolean(Object object) {
        if (!object instanceof Boolean) {
        } else {
            return (Boolean)object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to convert value of type ");
        stringBuilder.append(object.getClass().getName());
        stringBuilder.append(" to boolean");
        DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
        throw databaseException;
    }

    private static Double convertDouble(Object object) {
        if (object instanceof Integer) {
            return Double.valueOf((Integer)object.doubleValue());
        }
        if (object instanceof Long) {
            Object obj = object;
            Double valueOf = Double.valueOf((Long)obj.doubleValue());
            if (Long.compare(longValue, longValue2) != 0) {
            } else {
                return valueOf;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loss of precision while converting number to double: ");
            stringBuilder.append(object);
            stringBuilder.append(". Did you mean to use a 64-bit long instead?");
            DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
            throw databaseException;
        }
        if (!object instanceof Double) {
        } else {
            return (Double)object;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Failed to convert a value of type ");
        stringBuilder2.append(object.getClass().getName());
        stringBuilder2.append(" to double");
        DatabaseException databaseException2 = new DatabaseException(stringBuilder2.toString());
        throw databaseException2;
    }

    private static Integer convertInteger(Object object) {
        boolean z;
        int cmp;
        if (object instanceof Integer) {
            return (Integer)object;
        }
        if (!object instanceof Long) {
            if (!object instanceof Double) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to convert a value of type ");
            stringBuilder.append(object.getClass().getName());
            stringBuilder.append(" to int");
            DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
            throw databaseException;
        }
        double doubleValue = (Number)object.doubleValue();
        if (Double.compare(doubleValue, l) < 0) {
        } else {
            if (Double.compare(doubleValue, l2) > 0) {
            } else {
                return Integer.valueOf(object.intValue());
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Numeric value out of 32-bit integer range: ");
        stringBuilder2.append(doubleValue);
        stringBuilder2.append(". Did you mean to use a long or double instead of an int?");
        DatabaseException obj4 = new DatabaseException(stringBuilder2.toString());
        throw obj4;
    }

    private static Long convertLong(Object object) {
        int cmp;
        long l;
        if (object instanceof Integer) {
            return Long.valueOf((Integer)object.longValue());
        }
        if (object instanceof Long) {
            return (Long)object;
        }
        if (!object instanceof Double) {
        } else {
            if (Double.compare(doubleValue, l) < 0) {
            } else {
                if (Double.compare(doubleValue2, l) > 0) {
                } else {
                    return Long.valueOf(object.longValue());
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Numeric value out of 64-bit long range: ");
            stringBuilder2.append(object);
            stringBuilder2.append(". Did you mean to use a double instead of a long?");
            DatabaseException databaseException2 = new DatabaseException(stringBuilder2.toString());
            throw databaseException2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to convert a value of type ");
        stringBuilder.append(object.getClass().getName());
        stringBuilder.append(" to long");
        DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
        throw databaseException;
    }

    private static String convertString(Object object) {
        if (object instanceof String == null) {
        } else {
            return (String)object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to convert value of type ");
        stringBuilder.append(object.getClass().getName());
        stringBuilder.append(" to String");
        DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
        throw databaseException;
    }

    public static <T> T convertToCustomClass(Object object, GenericTypeIndicator<T> genericTypeIndicator2) {
        Type obj5 = genericTypeIndicator2.getClass().getGenericSuperclass();
        final String str = "Not a direct subclass of GenericTypeIndicator: ";
        if (!obj5 instanceof ParameterizedType) {
        } else {
            Type type = obj5;
            if (!(ParameterizedType)type.getRawType().equals(GenericTypeIndicator.class)) {
            } else {
                return CustomClassMapper.deserializeToType(object, type.getActualTypeArguments()[0]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(obj5);
            DatabaseException obj4 = new DatabaseException(stringBuilder.toString());
            throw obj4;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(obj5);
        obj4 = new DatabaseException(stringBuilder2.toString());
        throw obj4;
    }

    public static <T> T convertToCustomClass(Object object, Class<T> class2) {
        return CustomClassMapper.deserializeToClass(object, class2);
    }

    public static Object convertToPlainJavaTypes(Object object) {
        return CustomClassMapper.serialize(object);
    }

    public static Map<String, Object> convertToPlainJavaTypes(Map<String, Object> map) {
        final Object obj1 = CustomClassMapper.serialize(map);
        Utilities.hardAssert(obj1 instanceof Map);
        return (Map)obj1;
    }

    private static <T> T deserializeToClass(Object object, Class<T> class2) {
        boolean assignableFrom;
        if (object == null) {
            return 0;
        }
        if (!class2.isPrimitive() && !Number.class.isAssignableFrom(class2) && !Boolean.class.isAssignableFrom(class2)) {
            if (!Number.class.isAssignableFrom(class2)) {
                if (!Boolean.class.isAssignableFrom(class2)) {
                    if (Character.class.isAssignableFrom(class2)) {
                    } else {
                        if (String.class.isAssignableFrom(class2)) {
                            return CustomClassMapper.convertString(object);
                        }
                        if (class2.isArray()) {
                        } else {
                            if (typeParameters.length > 0) {
                            } else {
                                if (class2.equals(Object.class)) {
                                    return object;
                                }
                                if (class2.isEnum()) {
                                    return CustomClassMapper.deserializeToEnum(object, class2);
                                }
                                return CustomClassMapper.convertBean(object, class2);
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Class ");
                            stringBuilder.append(class2.getName());
                            stringBuilder.append(" has generic type parameters, please use GenericTypeIndicator instead");
                            DatabaseException obj2 = new DatabaseException(stringBuilder.toString());
                            throw obj2;
                        }
                    }
                    obj2 = new DatabaseException("Converting to Arrays is not supported, please use Listsinstead");
                    throw obj2;
                }
            }
        }
        return CustomClassMapper.deserializeToPrimitive(object, class2);
    }

    private static <T> T deserializeToEnum(Object object, Class<T> class2) {
        if (object instanceof String == null) {
        } else {
            return Enum.valueOf(class2, (String)object);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Expected a String while deserializing to enum ");
        stringBuilder2.append(class2);
        stringBuilder2.append(" but got a ");
        stringBuilder2.append(object.getClass());
        DatabaseException databaseException2 = new DatabaseException(stringBuilder2.toString());
        throw databaseException2;
    }

    private static <T> T deserializeToParameterizedType(Object object, ParameterizedType parameterizedType2) {
        int deserializeToType2;
        boolean deserializeToType;
        int key;
        int length;
        int length2;
        Type rawType = parameterizedType2.getRawType();
        key = 0;
        if (List.class.isAssignableFrom((Class)rawType)) {
            if (object instanceof List == null) {
            } else {
                ArrayList arrayList = new ArrayList((List)object.size());
                Iterator obj6 = object.iterator();
                for (Object next2 : obj6) {
                    arrayList.add(CustomClassMapper.deserializeToType(next2, parameterizedType2.getActualTypeArguments()[key]));
                }
                return arrayList;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected a List while deserializing, but got a ");
            stringBuilder.append(object.getClass());
            DatabaseException obj7 = new DatabaseException(stringBuilder.toString());
            throw obj7;
        }
        if (Map.class.isAssignableFrom(rawType)) {
            Type type = parameterizedType2.getActualTypeArguments()[key];
            if (!type.equals(String.class)) {
            } else {
                HashMap hashMap = new HashMap();
                obj6 = CustomClassMapper.expectMap(object).entrySet().iterator();
                for (Map.Entry next4 : obj6) {
                    hashMap.put((String)next4.getKey(), CustomClassMapper.deserializeToType(next4.getValue(), parameterizedType2.getActualTypeArguments()[1]));
                }
                return hashMap;
            }
            obj7 = new StringBuilder();
            obj7.append("Only Maps with string keys are supported, but found Map with key type ");
            obj7.append(type);
            obj6 = new DatabaseException(obj7.toString());
            throw obj6;
        }
        if (Collection.class.isAssignableFrom(rawType)) {
        } else {
            com.google.firebase.database.core.utilities.encoding.CustomClassMapper.BeanMapper orCreateBeanMapperForClass = CustomClassMapper.loadOrCreateBeanMapperForClass(rawType);
            HashMap hashMap2 = new HashMap();
            TypeVariable[] typeParameters = CustomClassMapper.BeanMapper.access$000(orCreateBeanMapperForClass).getTypeParameters();
            obj7 = parameterizedType2.getActualTypeArguments();
            if (obj7.length != typeParameters.length) {
            }
            obj6 = new IllegalStateException("Mismatched lengths for type variables and actual types");
            throw obj6;
        }
        obj6 = new DatabaseException("Collections are not supported, please use Lists instead");
        throw obj6;
    }

    private static <T> T deserializeToPrimitive(Object object, Class<T> class2) {
        boolean assignableFrom3;
        boolean assignableFrom4;
        boolean assignableFrom5;
        boolean assignableFrom2;
        boolean assignableFrom;
        if (!Integer.class.isAssignableFrom(class2)) {
            if (Integer.TYPE.isAssignableFrom(class2)) {
            } else {
                if (!Boolean.class.isAssignableFrom(class2)) {
                    if (Boolean.TYPE.isAssignableFrom(class2)) {
                    } else {
                        if (!Double.class.isAssignableFrom(class2)) {
                            if (Double.TYPE.isAssignableFrom(class2)) {
                            } else {
                                if (!Long.class.isAssignableFrom(class2)) {
                                    if (Long.TYPE.isAssignableFrom(class2)) {
                                    } else {
                                        if (!Float.class.isAssignableFrom(class2)) {
                                            if (!Float.TYPE.isAssignableFrom(class2)) {
                                            } else {
                                            }
                                            Object[] arr = new Object[1];
                                            DatabaseException obj2 = new DatabaseException(String.format("Deserializing values to %s is not supported", class2.getSimpleName()));
                                            throw obj2;
                                        }
                                    }
                                    return Float.valueOf(CustomClassMapper.convertDouble(object).floatValue());
                                }
                            }
                            return CustomClassMapper.convertLong(object);
                        }
                    }
                    return CustomClassMapper.convertDouble(object);
                }
            }
            return CustomClassMapper.convertBoolean(object);
        }
        return CustomClassMapper.convertInteger(object);
    }

    private static <T> T deserializeToType(Object object, Type type2) {
        int i;
        if (object == null) {
            return 0;
        }
        if (type2 instanceof ParameterizedType) {
            return CustomClassMapper.deserializeToParameterizedType(object, (ParameterizedType)type2);
        }
        if (type2 instanceof Class) {
            return CustomClassMapper.deserializeToClass(object, (Class)type2);
        }
        String str = " is not upper bounded.";
        final String str3 = "Wildcard type ";
        i = 1;
        final int i2 = 0;
        if (type2 instanceof WildcardType) {
            Object obj = type2;
            if (lowerBounds.length > 0) {
            } else {
                Type[] upperBounds = obj.getUpperBounds();
                if (upperBounds.length > 0) {
                } else {
                    i = i2;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str3);
                stringBuilder2.append(type2);
                stringBuilder2.append(str);
                Utilities.hardAssert(i, stringBuilder2.toString());
                return CustomClassMapper.deserializeToType(object, upperBounds[i2]);
            }
            DatabaseException obj6 = new DatabaseException("Generic lower-bounded wildcard types are not supported");
            throw obj6;
        }
        if (type2 instanceof TypeVariable) {
            Type[] bounds = (TypeVariable)type2.getBounds();
            if (bounds.length > 0) {
            } else {
                i = i2;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str3);
            stringBuilder3.append(type2);
            stringBuilder3.append(str);
            Utilities.hardAssert(i, stringBuilder3.toString());
            return CustomClassMapper.deserializeToType(object, bounds[i2]);
        }
        if (type2 instanceof GenericArrayType) {
            obj6 = new DatabaseException("Generic Arrays are not supported, please use Lists instead");
            throw obj6;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown type encountered: ");
        stringBuilder.append(type2);
        obj6 = new IllegalStateException(stringBuilder.toString());
        throw obj6;
    }

    private static Map<String, Object> expectMap(Object object) {
        if (object instanceof Map == null) {
        } else {
            return (Map)object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a Map while deserializing, but got a ");
        stringBuilder.append(object.getClass());
        DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
        throw databaseException;
    }

    private static <T> com.google.firebase.database.core.utilities.encoding.CustomClassMapper.BeanMapper<T> loadOrCreateBeanMapperForClass(Class<T> class) {
        Object beanMapper;
        final ConcurrentMap mappers = CustomClassMapper.mappers;
        if ((CustomClassMapper.BeanMapper)mappers.get(class) == null) {
            beanMapper = new CustomClassMapper.BeanMapper(class);
            mappers.put(class, beanMapper);
        }
        return beanMapper;
    }

    private static <T> Object serialize(T t) {
        boolean z;
        boolean z2;
        double serialize;
        int serialize2;
        int cmp;
        Object key;
        boolean z3;
        if (t == null) {
            return null;
        }
        if (t instanceof Number && !t instanceof Float) {
            if (!t instanceof Float) {
                if (t instanceof Double) {
                } else {
                    if (!t instanceof Long) {
                        if (!t instanceof Integer) {
                        } else {
                        }
                        Object[] arr = new Object[1];
                        DatabaseException databaseException = new DatabaseException(String.format("Numbers of type %s are not supported, please use an int, long, float or double", t.getClass().getSimpleName()));
                        throw databaseException;
                    }
                }
                return t;
            }
            double doubleValue = (Number)t.doubleValue();
            if (Double.compare(doubleValue, l) <= 0 && Double.compare(doubleValue, l2) >= 0 && Double.compare(floor, doubleValue) == 0) {
                if (Double.compare(doubleValue, l2) >= 0) {
                    if (Double.compare(floor, doubleValue) == 0) {
                        return Long.valueOf(t.longValue());
                    }
                }
            }
            return Double.valueOf(doubleValue);
        }
        if (t instanceof String != null) {
            return t;
        }
        if (t instanceof Boolean) {
            return t;
        }
        if (t instanceof Character) {
        } else {
            if (t instanceof Map != null) {
                HashMap hashMap = new HashMap();
                Iterator obj4 = (Map)t.entrySet().iterator();
                for (Map.Entry next2 : obj4) {
                    key = next2.getKey();
                    hashMap.put((String)key, CustomClassMapper.serialize(next2.getValue()));
                }
                return hashMap;
            }
            if (t instanceof Collection != null) {
                if (t instanceof List == null) {
                } else {
                    ArrayList arrayList = new ArrayList((List)t.size());
                    obj4 = t.iterator();
                    for (Object next4 : obj4) {
                        arrayList.add(CustomClassMapper.serialize(next4));
                    }
                    return arrayList;
                }
                obj4 = new DatabaseException("Serializing Collections is not supported, please use Lists instead");
                throw obj4;
            }
            if (t.getClass().isArray()) {
            } else {
                if (t instanceof Enum) {
                    return (Enum)t.name();
                }
                return CustomClassMapper.loadOrCreateBeanMapperForClass(t.getClass()).serialize(t);
            }
            obj4 = new DatabaseException("Serializing Arrays is not supported, please use Lists instead");
            throw obj4;
        }
        obj4 = new DatabaseException("Characters are not supported, please use Strings");
        throw obj4;
    }
}
