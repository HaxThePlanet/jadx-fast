package com.google.android.gms.internal.firebase-auth-api;

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
final class b0 {
    static String a(com.google.android.gms.internal.firebase-auth-api.y y, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("# ");
        stringBuilder.append(string2);
        b0.d(y, stringBuilder, 0);
        return stringBuilder.toString();
    }

    static final void b(StringBuilder stringBuilder, int i2, String string3, Object object4) {
        boolean next2;
        boolean next;
        int i3;
        int i4;
        int i;
        if (object4 instanceof List != null) {
            Iterator obj9 = (List)object4.iterator();
            for (Object next2 : obj9) {
                b0.b(stringBuilder, i2, string3, next2);
            }
        }
        if (object4 instanceof Map != null) {
            obj9 = (Map)object4.entrySet().iterator();
            for (Map.Entry next : obj9) {
                b0.b(stringBuilder, i2, string3, next);
            }
        }
        stringBuilder.append('\n');
        i4 = i3;
        i = 32;
        while (i4 < i2) {
            stringBuilder.append(i);
            i4++;
            i = 32;
        }
        stringBuilder.append(string3);
        int i6 = 34;
        String str2 = ": \"";
        if (object4 instanceof String != null) {
            stringBuilder.append(str2);
            stringBuilder.append(x0.a(wq.y((String)object4)));
            stringBuilder.append(i6);
        }
        if (object4 instanceof wq) {
            stringBuilder.append(str2);
            stringBuilder.append(x0.a((wq)object4));
            stringBuilder.append(i6);
        }
        String str = "}";
        String str3 = "\n";
        String str4 = " {";
        if (object4 instanceof xr) {
            stringBuilder.append(str4);
            b0.d((xr)object4, stringBuilder, i2 + 2);
            stringBuilder.append(str3);
            while (i3 < i2) {
                stringBuilder.append(i);
                i3++;
            }
            stringBuilder.append(str);
        }
        if (object4 instanceof Map.Entry) {
            stringBuilder.append(str4);
            int obj8 = i2 + 2;
            b0.b(stringBuilder, obj8, "key", (Map.Entry)object4.getKey());
            b0.b(stringBuilder, obj8, "value", object4.getValue());
            stringBuilder.append(str3);
            while (i3 < i2) {
                stringBuilder.append(i);
                i3++;
            }
            stringBuilder.append(str);
        }
        stringBuilder.append(": ");
        stringBuilder.append(object4.toString());
    }

    private static final String c(String string) {
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

    private static void d(com.google.android.gms.internal.firebase-auth-api.y y, StringBuilder stringBuilder2, int i3) {
        Method[] declaredMethods;
        Object next;
        String concat;
        String string;
        int booleanValue;
        String string3;
        int equals;
        String equals2;
        String valueOf;
        String string2;
        String startsWith;
        Method annotationPresent;
        String valueOf2;
        int length;
        boolean length2;
        Class<List> obj;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        declaredMethods = y.getClass().getDeclaredMethods();
        final int i10 = 0;
        equals = i10;
        startsWith = "get";
        while (equals < declaredMethods.length) {
            annotationPresent = declaredMethods[equals];
            hashMap2.put(annotationPresent.getName(), annotationPresent);
            hashMap.put(annotationPresent.getName(), annotationPresent);
            if (parameterTypes.length == 0 && annotationPresent.getName().startsWith(startsWith)) {
            }
            equals++;
            startsWith = "get";
            hashMap.put(annotationPresent.getName(), annotationPresent);
            if (annotationPresent.getName().startsWith(startsWith)) {
            }
            treeSet.add(annotationPresent.getName());
        }
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next.startsWith(startsWith)) {
            } else {
            }
            booleanValue = next;
            equals = "List";
            length = 1;
            if (booleanValue.endsWith(equals) && !booleanValue.endsWith("OrBuilderList") && !booleanValue.equals(equals)) {
            } else {
            }
            equals2 = "Map";
            if (booleanValue.endsWith(equals2) && !booleanValue.equals(equals2)) {
            } else {
            }
            String valueOf3 = String.valueOf(booleanValue);
            equals = "set";
            if (valueOf3.length() != 0) {
            } else {
            }
            concat = new String(equals);
            if ((Method)hashMap2.get(concat) != null) {
            }
            if (booleanValue.endsWith("Bytes")) {
            } else {
            }
            String valueOf5 = String.valueOf(booleanValue.substring(i10, length).toLowerCase());
            valueOf = String.valueOf(booleanValue.substring(length));
            if (valueOf.length() != 0) {
            } else {
            }
            valueOf = new String(valueOf5);
            declaredMethods = valueOf;
            String valueOf8 = String.valueOf(booleanValue);
            if (valueOf8.length() != 0) {
            } else {
            }
            string2 = new String(startsWith);
            equals = hashMap.get(string2);
            String valueOf6 = String.valueOf(booleanValue);
            annotationPresent = "has";
            if (valueOf6.length() != 0) {
            } else {
            }
            string3 = new String(annotationPresent);
            booleanValue = hashMap.get(string3);
            if ((Method)equals != 0) {
            }
            equals = xr.e((Method)equals, y, new Object[i10]);
            if ((Method)booleanValue == 0) {
            } else {
            }
            if ((Boolean)xr.e((Method)booleanValue, y, new Object[i10]).booleanValue() != 0) {
            }
            b0.b(stringBuilder2, i3, b0.c(declaredMethods), equals);
            if (equals instanceof Boolean) {
            } else {
            }
            if (equals instanceof Integer) {
            } else {
            }
            if (equals instanceof Float) {
            } else {
            }
            if (equals instanceof Double) {
            } else {
            }
            if (equals instanceof String != null) {
            } else {
            }
            if (equals instanceof wq) {
            } else {
            }
            if (equals instanceof y) {
            } else {
            }
            if (equals instanceof Enum) {
            } else {
            }
            if ((Enum)equals.ordinal() != 0) {
            }
            if (equals != (y)equals.p()) {
            }
            booleanValue = equals.equals(wq.a);
            if (booleanValue == 0) {
            }
            booleanValue = equals.equals("");
            if (Double.compare(annotationPresent, length2) != 0) {
            }
            if (Float.compare(floatValue, annotationPresent) != 0) {
            }
            if ((Integer)equals.intValue() != 0) {
            }
            if ((Boolean)equals.booleanValue() != 0) {
            }
            string3 = annotationPresent.concat(valueOf6);
            string2 = startsWith.concat(valueOf8);
            declaredMethods = valueOf5.concat(valueOf);
            String valueOf4 = String.valueOf(booleanValue.substring(i10, length3 += -5));
            if (valueOf4.length() != 0) {
            } else {
            }
            string = new String(startsWith);
            if (hashMap.containsKey(string) == null) {
            }
            string = startsWith.concat(valueOf4);
            concat = equals.concat(valueOf3);
            if (!booleanValue.equals(equals2)) {
            } else {
            }
            String valueOf9 = String.valueOf(booleanValue.substring(i10, length).toLowerCase());
            annotationPresent = String.valueOf(booleanValue.substring(length, length7 += -3));
            if (annotationPresent.length() != 0) {
            } else {
            }
            annotationPresent = new String(valueOf9);
            equals2 = annotationPresent;
            next = hashMap.get(next);
            if (next != null && (Method)next.getReturnType().equals(Map.class) && !next.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(next.getModifiers())) {
            } else {
            }
            if (next.getReturnType().equals(Map.class)) {
            } else {
            }
            if (!next.isAnnotationPresent(Deprecated.class)) {
            } else {
            }
            if (Modifier.isPublic(next.getModifiers())) {
            } else {
            }
            b0.b(stringBuilder2, i3, b0.c(equals2), xr.e(next, y, new Object[i10]));
            equals2 = valueOf9.concat(annotationPresent);
            if (!booleanValue.endsWith("OrBuilderList")) {
            } else {
            }
            if (!booleanValue.equals(equals)) {
            } else {
            }
            String valueOf7 = String.valueOf(booleanValue.substring(i10, length).toLowerCase());
            valueOf2 = String.valueOf(booleanValue.substring(length, length4 += -4));
            if (valueOf2.length() != 0) {
            } else {
            }
            valueOf2 = new String(valueOf7);
            equals = valueOf2;
            annotationPresent = hashMap.get(next);
            if (annotationPresent != null && (Method)annotationPresent.getReturnType().equals(List.class)) {
            } else {
            }
            if (annotationPresent.getReturnType().equals(List.class)) {
            } else {
            }
            b0.b(stringBuilder2, i3, b0.c(equals), xr.e(annotationPresent, y, new Object[i10]));
            equals = valueOf7.concat(valueOf2);
            booleanValue = next.substring(3);
        }
        if (y instanceof vr) {
        } else {
            com.google.android.gms.internal.firebase-auth-api.a1 obj12 = y.zzc;
            if (obj12 != null) {
                obj12.g(stringBuilder2, i3);
            }
        }
        obj12 = y.zzb;
        throw 0;
    }
}
