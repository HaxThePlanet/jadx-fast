package com.google.firebase.firestore.util;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Blob;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.PropertyName;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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

    private static final int MAX_DEPTH = 500;
    private static final ConcurrentMap<Class<?>, com.google.firebase.firestore.util.CustomClassMapper.BeanMapper<?>> mappers;

    private static class BeanMapper {

        private final Class<T> clazz;
        private final Constructor<T> constructor = null;
        private final HashSet<String> documentIdPropertyNames;
        private final Map<String, Field> fields;
        private final Map<String, Method> getters;
        private final Map<String, String> properties;
        private final HashSet<String> serverTimestamps;
        private final Map<String, Method> setters;
        private final boolean throwOnUnknownProperties;
        private final boolean warnOnUnknownProperties;
        BeanMapper(Class<T> class) {
            boolean stringBuilder;
            int str2;
            int str;
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
            HashSet hashSet = new HashSet();
            this.serverTimestamps = hashSet;
            HashSet hashSet2 = new HashSet();
            this.documentIdPropertyNames = hashSet2;
            class.getDeclaredConstructor(new Class[0]).setAccessible(i3);
        }

        static String access$000(Field field) {
            return CustomClassMapper.BeanMapper.propertyName(field);
        }

        static Class access$100(com.google.firebase.firestore.util.CustomClassMapper.BeanMapper customClassMapper$BeanMapper) {
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
                RuntimeException runtimeException = new RuntimeException(stringBuilder.toString());
                throw runtimeException;
            }
        }

        private static String annotatedName(AccessibleObject accessibleObject) {
            if (accessibleObject.isAnnotationPresent(PropertyName.class)) {
                return (PropertyName)accessibleObject.getAnnotation(PropertyName.class).value();
            }
            return null;
        }

        private void applyFieldAnnotations(Field field) {
            boolean annotationPresent;
            boolean documentIdPropertyNames;
            String propertyName;
            Class<Date> obj;
            String str;
            Object obj5;
            Class type2 = field.getType();
            if (field.isAnnotationPresent(ServerTimestamp.class) && type2 != Date.class) {
                type2 = field.getType();
                if (type2 != Date.class) {
                    if (type2 != Timestamp.class) {
                    } else {
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Field ");
                    stringBuilder.append(field.getName());
                    stringBuilder.append(" is annotated with @ServerTimestamp but is ");
                    stringBuilder.append(type2);
                    stringBuilder.append(" instead of Date or Timestamp.");
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                    throw illegalArgumentException;
                }
                this.serverTimestamps.add(CustomClassMapper.BeanMapper.propertyName(field));
            }
            if (field.isAnnotationPresent(DocumentId.class)) {
                ensureValidDocumentIdType("Field", "is", field.getType());
                this.documentIdPropertyNames.add(CustomClassMapper.BeanMapper.propertyName(field));
            }
        }

        private void applyGetterAnnotations(Method method) {
            boolean annotationPresent;
            boolean documentIdPropertyNames;
            String propertyName;
            Class<Date> obj;
            String str;
            Object obj5;
            Class returnType2 = method.getReturnType();
            if (method.isAnnotationPresent(ServerTimestamp.class) && returnType2 != Date.class) {
                returnType2 = method.getReturnType();
                if (returnType2 != Date.class) {
                    if (returnType2 != Timestamp.class) {
                    } else {
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Method ");
                    stringBuilder.append(method.getName());
                    stringBuilder.append(" is annotated with @ServerTimestamp but returns ");
                    stringBuilder.append(returnType2);
                    stringBuilder.append(" instead of Date or Timestamp.");
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                    throw illegalArgumentException;
                }
                this.serverTimestamps.add(CustomClassMapper.BeanMapper.propertyName(method));
            }
            if (method.isAnnotationPresent(DocumentId.class)) {
                ensureValidDocumentIdType("Method", "returns", method.getReturnType());
                this.documentIdPropertyNames.add(CustomClassMapper.BeanMapper.propertyName(method));
            }
        }

        private void applySetterAnnotations(Method method) {
            boolean documentIdPropertyNames;
            String str;
            String str2;
            Object obj4;
            if (method.isAnnotationPresent(ServerTimestamp.class)) {
            } else {
                if (method.isAnnotationPresent(DocumentId.class)) {
                    ensureValidDocumentIdType("Method", "accepts", method.getParameterTypes()[0]);
                    this.documentIdPropertyNames.add(CustomClassMapper.BeanMapper.propertyName(method));
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Method ");
            stringBuilder.append(method.getName());
            stringBuilder.append(" is annotated with @ServerTimestamp but should not be. @ServerTimestamp can only be applied to fields and getters, not setters.");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        private void ensureValidDocumentIdType(String string, String string2, Type type3) {
            Class<String> obj;
            if (type3 != String.class) {
                if (type3 != DocumentReference.class) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" is annotated with @DocumentId but ");
                stringBuilder.append(string2);
                stringBuilder.append(" ");
                stringBuilder.append(type3);
                stringBuilder.append(" instead of String or DocumentReference.");
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            }
        }

        private static boolean isSetterOverride(Method method, Method method2) {
            int i2;
            int i3;
            int i;
            boolean obj6;
            Object obj7;
            CustomClassMapper.access$500(method.getDeclaringClass().isAssignableFrom(method2.getDeclaringClass()), "Expected override from a base class");
            String str2 = "Expected void return type";
            CustomClassMapper.access$500(method.getReturnType().equals(Void.TYPE), str2);
            CustomClassMapper.access$500(method2.getReturnType().equals(Void.TYPE), str2);
            Class[] parameterTypes = method.getParameterTypes();
            Class[] parameterTypes2 = method2.getParameterTypes();
            i = 0;
            final int i4 = 1;
            i2 = parameterTypes.length == i4 ? i4 : i;
            final String str3 = "Expected exactly one parameter";
            CustomClassMapper.access$500(i2, str3);
            i3 = parameterTypes2.length == i4 ? i4 : i;
            CustomClassMapper.access$500(i3, str3);
            if (method.getName().equals(method2.getName()) && parameterTypes[i].equals(parameterTypes2[i])) {
                if (parameterTypes[i].equals(parameterTypes2[i])) {
                    i = i4;
                }
            }
            return i;
        }

        private void populateDocumentIdProperties(Map<TypeVariable<Class<T>>, Type> map, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext2, T t3, HashSet<String> hashSet4) {
            Object obj;
            DocumentReference documentRef2;
            boolean key;
            Object documentRef;
            int i;
            final Class<String> obj2 = String.class;
            Iterator iterator = this.documentIdPropertyNames.iterator();
            for (String next2 : iterator) {
                obj = this.fields.get(next2);
                if ((Field)obj.getType() == obj2) {
                } else {
                }
                obj.set(t3, deserializeContext2.documentRef);
                obj.set(t3, deserializeContext2.documentRef.getId());
                obj = this.setters.get(next2);
                Type[] genericParameterTypes = (Method)obj.getGenericParameterTypes();
                i = 1;
                documentRef2 = 0;
                if (resolveType(genericParameterTypes[documentRef2], map) == obj2) {
                } else {
                }
                key = new Object[i];
                key[documentRef2] = deserializeContext2.documentRef;
                ApiUtil.invoke(obj, t3, key);
                key = new Object[i];
                key[documentRef2] = deserializeContext2.documentRef.getId();
                ApiUtil.invoke(obj, t3, key);
            }
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

        T deserialize(Map<String, Object> map, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext2) {
            return deserialize(map, Collections.emptyMap(), deserializeContext2);
        }

        T deserialize(Map<String, Object> map, Map<TypeVariable<Class<T>>, Type> map2, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext3) {
            Object string;
            Object warnOnUnknownProperties;
            boolean stringBuilder;
            Object instanceWithErrorPath;
            Object obj;
            int resolveType;
            int i;
            Type resolveType2;
            int length;
            Constructor constructor = this.constructor;
            if (constructor == null) {
            } else {
                Object instance = ApiUtil.newInstance(constructor);
                HashSet hashSet = new HashSet();
                Iterator obj11 = map.entrySet().iterator();
                for (Map.Entry next2 : obj11) {
                    warnOnUnknownProperties = next2.getKey();
                    com.google.firebase.firestore.util.CustomClassMapper.ErrorPath child = deserializeContext3.errorPath.child((String)warnOnUnknownProperties);
                    resolveType = 0;
                    i = 1;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("No setter/field for ");
                    stringBuilder2.append(warnOnUnknownProperties);
                    stringBuilder2.append(" found on class ");
                    stringBuilder2.append(this.clazz.getName());
                    if (this.properties.containsKey(warnOnUnknownProperties.toLowerCase(Locale.US))) {
                    }
                    if (this.warnOnUnknownProperties) {
                    }
                    instanceWithErrorPath = new Object[i];
                    instanceWithErrorPath[resolveType] = string;
                    Logger.warn(CustomClassMapper.class.getSimpleName(), "%s", instanceWithErrorPath);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuilder2.toString());
                    stringBuilder.append(" (fields/setters are case sensitive!)");
                    string = stringBuilder.toString();
                    obj = this.fields.get(warnOnUnknownProperties);
                    obj.set(instance, CustomClassMapper.access$300(next2.getValue(), resolveType((Field)obj.getGenericType(), map2), deserializeContext3.newInstanceWithErrorPath(child)));
                    hashSet.add(warnOnUnknownProperties);
                    obj = this.setters.get(warnOnUnknownProperties);
                    Type[] genericParameterTypes = (Method)obj.getGenericParameterTypes();
                    instanceWithErrorPath = new Object[i];
                    instanceWithErrorPath[resolveType] = CustomClassMapper.access$300(next2.getValue(), resolveType(genericParameterTypes[resolveType], map2), deserializeContext3.newInstanceWithErrorPath(child));
                    ApiUtil.invoke(obj, instance, instanceWithErrorPath);
                    hashSet.add(warnOnUnknownProperties);
                }
                populateDocumentIdProperties(map2, deserializeContext3, instance, hashSet);
                return instance;
            }
            StringBuilder obj12 = new StringBuilder();
            obj12.append("Class ");
            obj12.append(this.clazz.getName());
            obj12.append(" does not define a no-argument constructor. If you are using ProGuard, make sure these constructors are not stripped");
            throw CustomClassMapper.access$200(deserializeContext3.errorPath, obj12.toString());
        }

        Map<String, Object> serialize(T t, com.google.firebase.firestore.util.CustomClassMapper.ErrorPath customClassMapper$ErrorPath2) {
            Object next;
            boolean serverTimestamp;
            Object invoke;
            Object[] contains;
            if (!this.clazz.isAssignableFrom(t.getClass())) {
            } else {
                HashMap hashMap = new HashMap();
                Iterator iterator = this.properties.values().iterator();
                for (String next : iterator) {
                    Object obj2 = this.fields.get(next);
                    invoke = (Field)obj2.get(t);
                    if (this.serverTimestamps.contains(next) && invoke == null) {
                    } else {
                    }
                    serverTimestamp = CustomClassMapper.access$400(invoke, errorPath2.child(next));
                    hashMap.put(next, serverTimestamp);
                    if (invoke == null) {
                    } else {
                    }
                    serverTimestamp = FieldValue.serverTimestamp();
                    invoke = ApiUtil.invoke((Method)this.getters.get(next), t, new Object[0]);
                }
                return hashMap;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can't serialize object of class ");
            stringBuilder.append(t.getClass());
            stringBuilder.append(" with BeanMapper for class ");
            stringBuilder.append(this.clazz);
            IllegalArgumentException obj7 = new IllegalArgumentException(stringBuilder.toString());
            throw obj7;
        }
    }

    static class DeserializeContext {

        final DocumentReference documentRef;
        final com.google.firebase.firestore.util.CustomClassMapper.ErrorPath errorPath;
        DeserializeContext(com.google.firebase.firestore.util.CustomClassMapper.ErrorPath customClassMapper$ErrorPath, DocumentReference documentReference2) {
            super();
            this.errorPath = errorPath;
            this.documentRef = documentReference2;
        }

        com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext newInstanceWithErrorPath(com.google.firebase.firestore.util.CustomClassMapper.ErrorPath customClassMapper$ErrorPath) {
            CustomClassMapper.DeserializeContext deserializeContext = new CustomClassMapper.DeserializeContext(errorPath, this.documentRef);
            return deserializeContext;
        }
    }

    static class ErrorPath {

        static final com.google.firebase.firestore.util.CustomClassMapper.ErrorPath EMPTY;
        private final int length;
        private final String name;
        private final com.google.firebase.firestore.util.CustomClassMapper.ErrorPath parent;
        static {
            final int i = 0;
            CustomClassMapper.ErrorPath errorPath = new CustomClassMapper.ErrorPath(i, i, 0);
            CustomClassMapper.ErrorPath.EMPTY = errorPath;
        }

        ErrorPath(com.google.firebase.firestore.util.CustomClassMapper.ErrorPath customClassMapper$ErrorPath, String string2, int i3) {
            super();
            this.parent = errorPath;
            this.name = string2;
            this.length = i3;
        }

        com.google.firebase.firestore.util.CustomClassMapper.ErrorPath child(String string) {
            CustomClassMapper.ErrorPath errorPath = new CustomClassMapper.ErrorPath(this, string, length++);
            return errorPath;
        }

        int getLength() {
            return this.length;
        }

        public String toString() {
            int length = this.length;
            if (length == 0) {
                return "";
            }
            if (length == 1) {
                return this.name;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.parent.toString());
            stringBuilder.append(".");
            stringBuilder.append(this.name);
            return stringBuilder.toString();
        }
    }
    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        CustomClassMapper.mappers = concurrentHashMap;
    }

    static RuntimeException access$200(com.google.firebase.firestore.util.CustomClassMapper.ErrorPath customClassMapper$ErrorPath, String string2) {
        return CustomClassMapper.deserializeError(errorPath, string2);
    }

    static Object access$300(Object object, Type type2, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext3) {
        return CustomClassMapper.deserializeToType(object, type2, deserializeContext3);
    }

    static Object access$400(Object object, com.google.firebase.firestore.util.CustomClassMapper.ErrorPath customClassMapper$ErrorPath2) {
        return CustomClassMapper.serialize(object, errorPath2);
    }

    static void access$500(boolean z, String string2) {
        CustomClassMapper.hardAssert(z, string2);
    }

    private static <T> T convertBean(Object object, Class<T> class2, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext3) {
        if (object instanceof Map == null) {
        } else {
            return CustomClassMapper.loadOrCreateBeanMapperForClass(class2).deserialize(CustomClassMapper.expectMap(object, deserializeContext3), deserializeContext3);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't convert object of type ");
        stringBuilder.append(object.getClass().getName());
        stringBuilder.append(" to type ");
        stringBuilder.append(class2.getName());
        throw CustomClassMapper.deserializeError(deserializeContext3.errorPath, stringBuilder.toString());
    }

    private static Blob convertBlob(Object object, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext2) {
        if (!object instanceof Blob) {
        } else {
            return (Blob)object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to convert value of type ");
        stringBuilder.append(object.getClass().getName());
        stringBuilder.append(" to Blob");
        throw CustomClassMapper.deserializeError(deserializeContext2.errorPath, stringBuilder.toString());
    }

    private static Boolean convertBoolean(Object object, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext2) {
        if (!object instanceof Boolean) {
        } else {
            return (Boolean)object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to convert value of type ");
        stringBuilder.append(object.getClass().getName());
        stringBuilder.append(" to boolean");
        throw CustomClassMapper.deserializeError(deserializeContext2.errorPath, stringBuilder.toString());
    }

    private static Date convertDate(Object object, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext2) {
        if (object instanceof Date) {
            return (Date)object;
        }
        if (!object instanceof Timestamp) {
        } else {
            return (Timestamp)object.toDate();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to convert value of type ");
        stringBuilder.append(object.getClass().getName());
        stringBuilder.append(" to Date");
        throw CustomClassMapper.deserializeError(deserializeContext2.errorPath, stringBuilder.toString());
    }

    private static DocumentReference convertDocumentReference(Object object, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext2) {
        if (object instanceof DocumentReference == null) {
        } else {
            return (DocumentReference)object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to convert value of type ");
        stringBuilder.append(object.getClass().getName());
        stringBuilder.append(" to DocumentReference");
        throw CustomClassMapper.deserializeError(deserializeContext2.errorPath, stringBuilder.toString());
    }

    private static Double convertDouble(Object object, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext2) {
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
            throw CustomClassMapper.deserializeError(deserializeContext2.errorPath, stringBuilder.toString());
        }
        if (!object instanceof Double) {
        } else {
            return (Double)object;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Failed to convert a value of type ");
        stringBuilder2.append(object.getClass().getName());
        stringBuilder2.append(" to double");
        throw CustomClassMapper.deserializeError(deserializeContext2.errorPath, stringBuilder2.toString());
    }

    private static GeoPoint convertGeoPoint(Object object, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext2) {
        if (!object instanceof GeoPoint) {
        } else {
            return (GeoPoint)object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to convert value of type ");
        stringBuilder.append(object.getClass().getName());
        stringBuilder.append(" to GeoPoint");
        throw CustomClassMapper.deserializeError(deserializeContext2.errorPath, stringBuilder.toString());
    }

    private static Integer convertInteger(Object object, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext2) {
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
            throw CustomClassMapper.deserializeError(deserializeContext2.errorPath, stringBuilder.toString());
        }
        double doubleValue = (Number)object.doubleValue();
        if (Double.compare(doubleValue, l) < 0) {
        } else {
            if (Double.compare(doubleValue, l2) > 0) {
            } else {
                return Integer.valueOf(object.intValue());
            }
        }
        StringBuilder obj5 = new StringBuilder();
        obj5.append("Numeric value out of 32-bit integer range: ");
        obj5.append(doubleValue);
        obj5.append(". Did you mean to use a long or double instead of an int?");
        throw CustomClassMapper.deserializeError(deserializeContext2.errorPath, obj5.toString());
    }

    private static Long convertLong(Object object, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext2) {
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
            throw CustomClassMapper.deserializeError(deserializeContext2.errorPath, stringBuilder2.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to convert a value of type ");
        stringBuilder.append(object.getClass().getName());
        stringBuilder.append(" to long");
        throw CustomClassMapper.deserializeError(deserializeContext2.errorPath, stringBuilder.toString());
    }

    private static String convertString(Object object, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext2) {
        if (object instanceof String == null) {
        } else {
            return (String)object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to convert value of type ");
        stringBuilder.append(object.getClass().getName());
        stringBuilder.append(" to String");
        throw CustomClassMapper.deserializeError(deserializeContext2.errorPath, stringBuilder.toString());
    }

    private static Timestamp convertTimestamp(Object object, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext2) {
        if (object instanceof Timestamp) {
            return (Timestamp)object;
        }
        if (!object instanceof Date) {
        } else {
            Timestamp obj3 = new Timestamp((Date)object);
            return obj3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to convert value of type ");
        stringBuilder.append(object.getClass().getName());
        stringBuilder.append(" to Timestamp");
        throw CustomClassMapper.deserializeError(deserializeContext2.errorPath, stringBuilder.toString());
    }

    public static <T> T convertToCustomClass(Object object, Class<T> class2, DocumentReference documentReference3) {
        CustomClassMapper.DeserializeContext deserializeContext = new CustomClassMapper.DeserializeContext(CustomClassMapper.ErrorPath.EMPTY, documentReference3);
        return CustomClassMapper.deserializeToClass(object, class2, deserializeContext);
    }

    public static Object convertToPlainJavaTypes(Object object) {
        return CustomClassMapper.serialize(object);
    }

    public static Map<String, Object> convertToPlainJavaTypes(Map<?, Object> map) {
        final Object obj1 = CustomClassMapper.serialize(map);
        CustomClassMapper.hardAssert(obj1 instanceof Map);
        return (Map)obj1;
    }

    private static RuntimeException deserializeError(com.google.firebase.firestore.util.CustomClassMapper.ErrorPath customClassMapper$ErrorPath, String string2) {
        int stringBuilder;
        String obj2;
        String obj3;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Could not deserialize object. ");
        stringBuilder2.append(string2);
        if (errorPath.getLength() > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append(" (found in field '");
            stringBuilder.append(errorPath.toString());
            stringBuilder.append("')");
            obj3 = stringBuilder.toString();
        }
        obj2 = new RuntimeException(obj3);
        return obj2;
    }

    private static <T> T deserializeToClass(Object object, Class<T> class2, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext3) {
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
                            return CustomClassMapper.convertString(object, deserializeContext3);
                        }
                        if (Date.class.isAssignableFrom(class2)) {
                            return CustomClassMapper.convertDate(object, deserializeContext3);
                        }
                        if (Timestamp.class.isAssignableFrom(class2)) {
                            return CustomClassMapper.convertTimestamp(object, deserializeContext3);
                        }
                        if (Blob.class.isAssignableFrom(class2)) {
                            return CustomClassMapper.convertBlob(object, deserializeContext3);
                        }
                        if (GeoPoint.class.isAssignableFrom(class2)) {
                            return CustomClassMapper.convertGeoPoint(object, deserializeContext3);
                        }
                        if (DocumentReference.class.isAssignableFrom(class2)) {
                            return CustomClassMapper.convertDocumentReference(object, deserializeContext3);
                        }
                        if (class2.isArray()) {
                        } else {
                            if (typeParameters.length > 0) {
                            } else {
                                if (class2.equals(Object.class)) {
                                    return object;
                                }
                                if (class2.isEnum()) {
                                    return CustomClassMapper.deserializeToEnum(object, class2, deserializeContext3);
                                }
                                return CustomClassMapper.convertBean(object, class2, deserializeContext3);
                            }
                            StringBuilder obj3 = new StringBuilder();
                            obj3.append("Class ");
                            obj3.append(class2.getName());
                            obj3.append(" has generic type parameters, please use GenericTypeIndicator instead");
                            throw CustomClassMapper.deserializeError(deserializeContext3.errorPath, obj3.toString());
                        }
                    }
                    throw CustomClassMapper.deserializeError(deserializeContext3.errorPath, "Converting to Arrays is not supported, please use Lists instead");
                }
            }
        }
        return CustomClassMapper.deserializeToPrimitive(object, class2, deserializeContext3);
    }

    private static <T> T deserializeToEnum(Object object, Class<T> class2, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext3) {
        int i;
        Field field;
        boolean enumConstant;
        Object obj5;
        if (object instanceof String == null) {
        } else {
            Field[] fields = class2.getFields();
            i = 0;
            while (i < fields.length) {
                field = fields[i];
                if (field.isEnumConstant()) {
                    break;
                } else {
                }
                i++;
                if ((String)object.equals(CustomClassMapper.BeanMapper.access$000(field))) {
                    break;
                } else {
                }
            }
            return Enum.valueOf(class2, obj5);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Expected a String while deserializing to enum ");
        stringBuilder2.append(class2);
        stringBuilder2.append(" but got a ");
        stringBuilder2.append(object.getClass());
        throw CustomClassMapper.deserializeError(deserializeContext3.errorPath, stringBuilder2.toString());
    }

    private static <T> T deserializeToParameterizedType(Object object, ParameterizedType parameterizedType2, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext3) {
        int deserializeToType2;
        boolean deserializeToType;
        int key;
        com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext instanceWithErrorPath;
        String errorPath;
        int length;
        String str;
        int length2;
        Type rawType = parameterizedType2.getRawType();
        key = 0;
        if (List.class.isAssignableFrom((Class)rawType)) {
            if (object instanceof List == null) {
            } else {
                ArrayList arrayList = new ArrayList((List)object.size());
                while (key < object.size()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("[");
                    stringBuilder.append(key);
                    stringBuilder.append("]");
                    arrayList.add(CustomClassMapper.deserializeToType(object.get(key), parameterizedType2.getActualTypeArguments()[key], deserializeContext3.newInstanceWithErrorPath(deserializeContext3.errorPath.child(stringBuilder.toString()))));
                    key++;
                }
                return arrayList;
            }
            StringBuilder obj8 = new StringBuilder();
            obj8.append("Expected a List, but got a ");
            obj8.append(object.getClass());
            throw CustomClassMapper.deserializeError(deserializeContext3.errorPath, obj8.toString());
        }
        if (Map.class.isAssignableFrom(rawType)) {
            Type type = parameterizedType2.getActualTypeArguments()[key];
            if (!type.equals(String.class)) {
            } else {
                HashMap hashMap = new HashMap();
                Iterator obj6 = CustomClassMapper.expectMap(object, deserializeContext3).entrySet().iterator();
                for (Map.Entry next2 : obj6) {
                    hashMap.put((String)next2.getKey(), CustomClassMapper.deserializeToType(next2.getValue(), parameterizedType2.getActualTypeArguments()[1], deserializeContext3.newInstanceWithErrorPath(deserializeContext3.errorPath.child((String)next2.getKey()))));
                }
                return hashMap;
            }
            StringBuilder obj7 = new StringBuilder();
            obj7.append("Only Maps with string keys are supported, but found Map with key type ");
            obj7.append(type);
            throw CustomClassMapper.deserializeError(deserializeContext3.errorPath, obj7.toString());
        }
        if (Collection.class.isAssignableFrom(rawType)) {
        } else {
            com.google.firebase.firestore.util.CustomClassMapper.BeanMapper orCreateBeanMapperForClass = CustomClassMapper.loadOrCreateBeanMapperForClass(rawType);
            HashMap hashMap2 = new HashMap();
            TypeVariable[] typeParameters = CustomClassMapper.BeanMapper.access$100(orCreateBeanMapperForClass).getTypeParameters();
            obj7 = parameterizedType2.getActualTypeArguments();
            if (obj7.length != typeParameters.length) {
            }
            obj6 = new IllegalStateException("Mismatched lengths for type variables and actual types");
            throw obj6;
        }
        throw CustomClassMapper.deserializeError(deserializeContext3.errorPath, "Collections are not supported, please use Lists instead");
    }

    private static <T> T deserializeToPrimitive(Object object, Class<T> class2, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext3) {
        boolean assignableFrom3;
        boolean assignableFrom;
        boolean assignableFrom5;
        boolean assignableFrom2;
        boolean assignableFrom4;
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
                                            Object[] obj3 = new Object[1];
                                            throw CustomClassMapper.deserializeError(deserializeContext3.errorPath, String.format("Deserializing values to %s is not supported", class2.getSimpleName()));
                                        }
                                    }
                                    return Float.valueOf(CustomClassMapper.convertDouble(object, deserializeContext3).floatValue());
                                }
                            }
                            return CustomClassMapper.convertLong(object, deserializeContext3);
                        }
                    }
                    return CustomClassMapper.convertDouble(object, deserializeContext3);
                }
            }
            return CustomClassMapper.convertBoolean(object, deserializeContext3);
        }
        return CustomClassMapper.convertInteger(object, deserializeContext3);
    }

    private static <T> T deserializeToType(Object object, Type type2, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext3) {
        int i;
        if (object == null) {
            return 0;
        }
        if (type2 instanceof ParameterizedType) {
            return CustomClassMapper.deserializeToParameterizedType(object, (ParameterizedType)type2, deserializeContext3);
        }
        if (type2 instanceof Class) {
            return CustomClassMapper.deserializeToClass(object, (Class)type2, deserializeContext3);
        }
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
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected type bounds on wildcard ");
                stringBuilder.append(type2);
                CustomClassMapper.hardAssert(i, stringBuilder.toString());
                return CustomClassMapper.deserializeToType(object, upperBounds[i2], deserializeContext3);
            }
            throw CustomClassMapper.deserializeError(deserializeContext3.errorPath, "Generic lower-bounded wildcard types are not supported");
        }
        if (type2 instanceof TypeVariable) {
            Type[] bounds = (TypeVariable)type2.getBounds();
            if (bounds.length > 0) {
            } else {
                i = i2;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unexpected type bounds on type variable ");
            stringBuilder2.append(type2);
            CustomClassMapper.hardAssert(i, stringBuilder2.toString());
            return CustomClassMapper.deserializeToType(object, bounds[i2], deserializeContext3);
        }
        if (type2 instanceof GenericArrayType) {
            throw CustomClassMapper.deserializeError(deserializeContext3.errorPath, "Generic Arrays are not supported, please use Lists instead");
        }
        StringBuilder obj7 = new StringBuilder();
        obj7.append("Unknown type encountered: ");
        obj7.append(type2);
        throw CustomClassMapper.deserializeError(deserializeContext3.errorPath, obj7.toString());
    }

    private static Map<String, Object> expectMap(Object object, com.google.firebase.firestore.util.CustomClassMapper.DeserializeContext customClassMapper$DeserializeContext2) {
        if (object instanceof Map == null) {
        } else {
            return (Map)object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a Map while deserializing, but got a ");
        stringBuilder.append(object.getClass());
        throw CustomClassMapper.deserializeError(deserializeContext2.errorPath, stringBuilder.toString());
    }

    private static void hardAssert(boolean z) {
        CustomClassMapper.hardAssert(z, "Internal inconsistency");
    }

    private static void hardAssert(boolean z, String string2) {
        if (!z) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hard assert failed: ");
        stringBuilder.append(string2);
        RuntimeException obj2 = new RuntimeException(stringBuilder.toString());
        throw obj2;
    }

    private static <T> com.google.firebase.firestore.util.CustomClassMapper.BeanMapper<T> loadOrCreateBeanMapperForClass(Class<T> class) {
        Object beanMapper;
        final ConcurrentMap mappers = CustomClassMapper.mappers;
        if ((CustomClassMapper.BeanMapper)mappers.get(class) == null) {
            beanMapper = new CustomClassMapper.BeanMapper(class);
            mappers.put(class, beanMapper);
        }
        return beanMapper;
    }

    private static <T> Object serialize(T t) {
        return CustomClassMapper.serialize(t, CustomClassMapper.ErrorPath.EMPTY);
    }

    private static <T> Object serialize(T t, com.google.firebase.firestore.util.CustomClassMapper.ErrorPath customClassMapper$ErrorPath2) {
        boolean orCreateBeanMapperForClass;
        boolean z;
        int serialize2;
        Object key;
        int serialize;
        com.google.firebase.firestore.util.CustomClassMapper.ErrorPath child;
        String str;
        Object obj5;
        if (errorPath2.getLength() > 500) {
        } else {
            if (t == null) {
                return null;
            }
            if (t instanceof Number && !t instanceof Long && !t instanceof Integer && !t instanceof Double) {
                if (!t instanceof Long) {
                    if (!t instanceof Integer) {
                        if (!t instanceof Double) {
                            if (!t instanceof Float) {
                            } else {
                            }
                            Object[] arr = new Object[1];
                            throw CustomClassMapper.serializeError(errorPath2, String.format("Numbers of type %s are not supported, please use an int, long, float or double", t.getClass().getSimpleName()));
                        }
                    }
                }
                return t;
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
                    obj5 = (Map)t.entrySet().iterator();
                    for (Map.Entry next2 : obj5) {
                        key = next2.getKey();
                        hashMap.put(key, CustomClassMapper.serialize(next2.getValue(), errorPath2.child((String)key)));
                    }
                    return hashMap;
                }
                if (t instanceof Collection != null) {
                    if (t instanceof List == null) {
                    } else {
                        ArrayList arrayList = new ArrayList((List)t.size());
                        while (serialize2 < t.size()) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("[");
                            stringBuilder.append(serialize2);
                            stringBuilder.append("]");
                            arrayList.add(CustomClassMapper.serialize(t.get(serialize2), errorPath2.child(stringBuilder.toString())));
                            serialize2++;
                        }
                        return arrayList;
                    }
                    throw CustomClassMapper.serializeError(errorPath2, "Serializing Collections is not supported, please use Lists instead");
                }
                if (t.getClass().isArray()) {
                } else {
                    if (t instanceof Enum) {
                        return CustomClassMapper.BeanMapper.access$000(t.getClass().getField((Enum)t.name()));
                    }
                    if (!t instanceof Date && !t instanceof Timestamp && !t instanceof GeoPoint && !t instanceof Blob && t instanceof DocumentReference == null) {
                        if (!t instanceof Timestamp) {
                            if (!t instanceof GeoPoint) {
                                if (!t instanceof Blob) {
                                    if (t instanceof DocumentReference == null) {
                                        if (t instanceof FieldValue) {
                                        } else {
                                            obj5 = CustomClassMapper.loadOrCreateBeanMapperForClass(t.getClass()).serialize(t, errorPath2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return obj5;
                }
                throw CustomClassMapper.serializeError(errorPath2, "Serializing Arrays is not supported, please use Lists instead");
            }
            throw CustomClassMapper.serializeError(errorPath2, "Characters are not supported, please use Strings");
        }
        throw CustomClassMapper.serializeError(errorPath2, "Exceeded maximum depth of 500, which likely indicates there's an object cycle");
    }

    private static java.lang.IllegalArgumentException serializeError(com.google.firebase.firestore.util.CustomClassMapper.ErrorPath customClassMapper$ErrorPath, String string2) {
        int stringBuilder;
        String obj2;
        String obj3;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Could not serialize object. ");
        stringBuilder2.append(string2);
        if (errorPath.getLength() > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append(" (found in field '");
            stringBuilder.append(errorPath.toString());
            stringBuilder.append("')");
            obj3 = stringBuilder.toString();
        }
        obj2 = new IllegalArgumentException(obj3);
        return obj2;
    }
}
