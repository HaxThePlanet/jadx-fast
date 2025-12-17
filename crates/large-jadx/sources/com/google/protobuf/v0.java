package com.google.protobuf;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes2.dex */
final class v0 {
    private static final String a(String string) {
        int i;
        char lowerCase;
        boolean upperCase;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < string.length()) {
            char charAt = string.charAt(i);
            if (Character.isUpperCase(charAt)) {
            }
            stringBuilder.append(Character.toLowerCase(charAt));
            i++;
            stringBuilder.append("_");
        }
        return stringBuilder.toString();
    }

    private static boolean b(Object object) {
        int i;
        if (object instanceof Boolean) {
            return obj7 ^= i;
        }
        final int i3 = 0;
        if (object instanceof Integer) {
            if ((Integer)object.intValue() == 0) {
            } else {
                i = i3;
            }
            return i;
        }
        if (object instanceof Float) {
            if (Float.compare(obj7, i2) == 0) {
            } else {
                i = i3;
            }
            return i;
        }
        if (object instanceof Double) {
            if (Double.compare(doubleValue, i4) == 0) {
            } else {
                i = i3;
            }
            return i;
        }
        if (object instanceof String != null) {
            return object.equals("");
        }
        if (object instanceof j) {
            return object.equals(j.a);
        }
        if (object instanceof t0) {
            if (object == (t0)object.getDefaultInstanceForType()) {
            } else {
                i = i3;
            }
            return i;
        }
        if (object instanceof Enum) {
            if ((Enum)object.ordinal() == 0) {
            } else {
                i = i3;
            }
            return i;
        }
        return i3;
    }

    static final void c(StringBuilder stringBuilder, int i2, String string3, Object object4) {
        boolean next;
        int i;
        boolean next2;
        int i4;
        String str4;
        int i3;
        String str2;
        String str;
        String str3;
        String obj7;
        boolean obj8;
        Object obj9;
        if (object4 instanceof List != null) {
            obj9 = (List)object4.iterator();
            for (Object next2 : obj9) {
                v0.c(stringBuilder, i2, string3, next2);
            }
        }
        if (object4 instanceof Map != null) {
            obj9 = (Map)object4.entrySet().iterator();
            for (Map.Entry next : obj9) {
                v0.c(stringBuilder, i2, string3, next);
            }
        }
        stringBuilder.append('\n');
        i4 = i;
        i3 = 32;
        while (i4 < i2) {
            stringBuilder.append(i3);
            i4++;
            i3 = 32;
        }
        stringBuilder.append(string3);
        str4 = 34;
        str2 = ": \"";
        if (object4 instanceof String != null) {
            stringBuilder.append(str2);
            stringBuilder.append(q1.c((String)object4));
            stringBuilder.append(str4);
        } else {
            if (object4 instanceof j) {
                stringBuilder.append(str2);
                stringBuilder.append(q1.a((j)object4));
                stringBuilder.append(str4);
            } else {
                str4 = "}";
                str2 = "\n";
                str = " {";
                if (object4 instanceof z) {
                    stringBuilder.append(str);
                    v0.d((z)object4, stringBuilder, i2 + 2);
                    stringBuilder.append(str2);
                    while (i < i2) {
                        stringBuilder.append(i3);
                        i++;
                    }
                    stringBuilder.append(str4);
                } else {
                    if (object4 instanceof Map.Entry) {
                        stringBuilder.append(str);
                        obj8 = i2 + 2;
                        v0.c(stringBuilder, obj8, "key", (Map.Entry)object4.getKey());
                        v0.c(stringBuilder, obj8, "value", object4.getValue());
                        stringBuilder.append(str2);
                        while (i < i2) {
                            stringBuilder.append(i3);
                            i++;
                        }
                        stringBuilder.append(str4);
                    } else {
                        stringBuilder.append(": ");
                        stringBuilder.append(object4.toString());
                    }
                }
            }
        }
    }

    private static void d(com.google.protobuf.t0 t0, StringBuilder stringBuilder2, int i3) {
        boolean it;
        HashMap hashMap;
        Iterator iterator;
        Method[] declaredMethods;
        boolean next2;
        Object next;
        int orDie2;
        int orDie;
        String startsWith;
        Method annotationPresent;
        int endsWith;
        int booleanValue;
        boolean equals;
        Class<List> obj;
        HashMap hashMap2 = new HashMap();
        hashMap = new HashMap();
        TreeSet treeSet = new TreeSet();
        declaredMethods = t0.getClass().getDeclaredMethods();
        final int i = 0;
        orDie = i;
        startsWith = "get";
        while (orDie < declaredMethods.length) {
            annotationPresent = declaredMethods[orDie];
            hashMap.put(annotationPresent.getName(), annotationPresent);
            hashMap2.put(annotationPresent.getName(), annotationPresent);
            if (parameterTypes.length == 0 && annotationPresent.getName().startsWith(startsWith)) {
            }
            orDie++;
            startsWith = "get";
            hashMap2.put(annotationPresent.getName(), annotationPresent);
            if (annotationPresent.getName().startsWith(startsWith)) {
            }
            treeSet.add(annotationPresent.getName());
        }
        iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            orDie = 3;
            if ((String)next.startsWith(startsWith)) {
            } else {
            }
            orDie2 = next;
            annotationPresent = "List";
            booleanValue = 1;
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append(orDie2.substring(i, booleanValue).toLowerCase());
            stringBuilder7.append(orDie2.substring(booleanValue, length2 += -4));
            endsWith = hashMap2.get(next);
            if (orDie2.endsWith(annotationPresent) && !orDie2.endsWith("OrBuilderList") && !orDie2.equals(annotationPresent) && endsWith != null && (Method)endsWith.getReturnType().equals(List.class)) {
            } else {
            }
            annotationPresent = "Map";
            annotationPresent = new StringBuilder();
            annotationPresent.append(orDie2.substring(i, booleanValue).toLowerCase());
            annotationPresent.append(orDie2.substring(booleanValue, length3 -= orDie));
            next = hashMap2.get(next);
            if (orDie2.endsWith(annotationPresent) && !orDie2.equals(annotationPresent) && next != null && (Method)next.getReturnType().equals(Map.class) && !next.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(next.getModifiers())) {
            } else {
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("set");
            stringBuilder3.append(orDie2);
            if ((Method)hashMap.get(stringBuilder3.toString()) == null) {
            } else {
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(startsWith);
            stringBuilder4.append(orDie2.substring(i, length += -5));
            if (orDie2.endsWith("Bytes") && hashMap2.containsKey(stringBuilder4.toString()) != null) {
            } else {
            }
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(orDie2.substring(i, booleanValue).toLowerCase());
            stringBuilder5.append(orDie2.substring(booleanValue));
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append(startsWith);
            stringBuilder6.append(orDie2);
            orDie = hashMap2.get(stringBuilder6.toString());
            annotationPresent = new StringBuilder();
            annotationPresent.append("has");
            annotationPresent.append(orDie2);
            orDie2 = hashMap2.get(annotationPresent.toString());
            if ((Method)orDie != 0) {
            }
            orDie = z.invokeOrDie((Method)orDie, t0, new Object[i]);
            if ((Method)orDie2 == 0) {
            } else {
            }
            booleanValue = (Boolean)z.invokeOrDie((Method)orDie2, t0, new Object[i]).booleanValue();
            if (booleanValue != 0) {
            }
            v0.c(stringBuilder2, i3, v0.a(stringBuilder5.toString()), orDie);
            if (!v0.b(orDie)) {
            } else {
            }
            booleanValue = i;
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append(startsWith);
            stringBuilder4.append(orDie2.substring(i, length += -5));
            if (hashMap2.containsKey(stringBuilder4.toString()) != null) {
            } else {
            }
            if (!orDie2.equals(annotationPresent)) {
            } else {
            }
            annotationPresent = new StringBuilder();
            annotationPresent.append(orDie2.substring(i, booleanValue).toLowerCase());
            annotationPresent.append(orDie2.substring(booleanValue, length3 -= orDie));
            next = hashMap2.get(next);
            if ((Method)next != null) {
            } else {
            }
            if ((Method)next.getReturnType().equals(Map.class)) {
            } else {
            }
            if (!next.isAnnotationPresent(Deprecated.class)) {
            } else {
            }
            if (Modifier.isPublic(next.getModifiers())) {
            } else {
            }
            v0.c(stringBuilder2, i3, v0.a(annotationPresent.toString()), z.invokeOrDie(next, t0, new Object[i]));
            if (!orDie2.endsWith("OrBuilderList")) {
            } else {
            }
            if (!orDie2.equals(annotationPresent)) {
            } else {
            }
            stringBuilder7 = new StringBuilder();
            stringBuilder7.append(orDie2.substring(i, booleanValue).toLowerCase());
            stringBuilder7.append(orDie2.substring(booleanValue, length2 += -4));
            endsWith = hashMap2.get(next);
            if ((Method)endsWith != null) {
            } else {
            }
            if ((Method)endsWith.getReturnType().equals(List.class)) {
            } else {
            }
            v0.c(stringBuilder2, i3, v0.a(stringBuilder7.toString()), z.invokeOrDie(endsWith, t0, new Object[i]));
            orDie2 = next.substring(orDie);
        }
        if (t0 instanceof z.c) {
            it = obj2.extensions.s();
            for (Map.Entry next3 : it) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[");
                stringBuilder.append((z.d)next3.getKey().getNumber());
                stringBuilder.append("]");
                v0.c(stringBuilder2, i3, stringBuilder.toString(), next3.getValue());
            }
        }
        final com.google.protobuf.t1 obj13 = t0.unknownFields;
        if (obj13 != null) {
            obj13.p(stringBuilder2, i3);
        }
    }

    static String e(com.google.protobuf.t0 t0, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("# ");
        stringBuilder.append(string2);
        v0.d(t0, stringBuilder, 0);
        return stringBuilder.toString();
    }
}
