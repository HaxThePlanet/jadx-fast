package com.google.android.gms.internal.measurement;

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
final class aa {
    static String a(com.google.android.gms.internal.measurement.y9 y9, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("# ");
        stringBuilder.append(string2);
        aa.d(y9, stringBuilder, 0);
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
                aa.b(stringBuilder, i2, string3, next2);
            }
        }
        if (object4 instanceof Map != null) {
            obj9 = (Map)object4.entrySet().iterator();
            for (Map.Entry next : obj9) {
                aa.b(stringBuilder, i2, string3, next);
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
            stringBuilder.append(va.a(x7.u((String)object4)));
            stringBuilder.append(i6);
        }
        if (object4 instanceof x7) {
            stringBuilder.append(str2);
            stringBuilder.append(va.a((x7)object4));
            stringBuilder.append(i6);
        }
        String str = "}";
        String str3 = "\n";
        String str4 = " {";
        if (object4 instanceof w8) {
            stringBuilder.append(str4);
            aa.d((w8)object4, stringBuilder, i2 + 2);
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
            aa.b(stringBuilder, obj8, "key", (Map.Entry)object4.getKey());
            aa.b(stringBuilder, obj8, "value", object4.getValue());
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

    private static void d(com.google.android.gms.internal.measurement.y9 y9, StringBuilder stringBuilder2, int i3) {
        Method[] declaredMethods;
        Object next;
        String concat;
        String string;
        int floatToRawIntBits;
        String string2;
        int equals;
        String equals2;
        String valueOf;
        String string3;
        String startsWith;
        Method doubleToRawLongBits;
        String valueOf2;
        int length2;
        boolean length;
        Class<List> obj;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        declaredMethods = y9.getClass().getDeclaredMethods();
        final int i10 = 0;
        equals = i10;
        startsWith = "get";
        while (equals < declaredMethods.length) {
            doubleToRawLongBits = declaredMethods[equals];
            hashMap2.put(doubleToRawLongBits.getName(), doubleToRawLongBits);
            hashMap.put(doubleToRawLongBits.getName(), doubleToRawLongBits);
            if (parameterTypes.length == 0 && doubleToRawLongBits.getName().startsWith(startsWith)) {
            }
            equals++;
            startsWith = "get";
            hashMap.put(doubleToRawLongBits.getName(), doubleToRawLongBits);
            if (doubleToRawLongBits.getName().startsWith(startsWith)) {
            }
            treeSet.add(doubleToRawLongBits.getName());
        }
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next.startsWith(startsWith)) {
            } else {
            }
            floatToRawIntBits = next;
            equals = "List";
            length2 = 1;
            if (floatToRawIntBits.endsWith(equals) && !floatToRawIntBits.endsWith("OrBuilderList") && !floatToRawIntBits.equals(equals)) {
            } else {
            }
            equals2 = "Map";
            if (floatToRawIntBits.endsWith(equals2) && !floatToRawIntBits.equals(equals2)) {
            } else {
            }
            String valueOf3 = String.valueOf(floatToRawIntBits);
            equals = "set";
            if (valueOf3.length() != 0) {
            } else {
            }
            concat = new String(equals);
            if ((Method)hashMap2.get(concat) != null) {
            }
            if (floatToRawIntBits.endsWith("Bytes")) {
            } else {
            }
            String valueOf5 = String.valueOf(floatToRawIntBits.substring(i10, length2).toLowerCase());
            valueOf = String.valueOf(floatToRawIntBits.substring(length2));
            if (valueOf.length() != 0) {
            } else {
            }
            valueOf = new String(valueOf5);
            declaredMethods = valueOf;
            String valueOf8 = String.valueOf(floatToRawIntBits);
            if (valueOf8.length() != 0) {
            } else {
            }
            string3 = new String(startsWith);
            equals = hashMap.get(string3);
            String valueOf6 = String.valueOf(floatToRawIntBits);
            doubleToRawLongBits = "has";
            length2 = valueOf6.length();
            if (length2 != 0) {
            } else {
            }
            string2 = new String(doubleToRawLongBits);
            floatToRawIntBits = hashMap.get(string2);
            if ((Method)equals != 0) {
            }
            equals = w8.m((Method)equals, y9, new Object[i10]);
            if ((Method)floatToRawIntBits == 0) {
            } else {
            }
            if ((Boolean)w8.m((Method)floatToRawIntBits, y9, new Object[i10]).booleanValue() != 0) {
            }
            aa.b(stringBuilder2, i3, aa.c(declaredMethods), equals);
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
            if (equals instanceof x7) {
            } else {
            }
            if (equals instanceof y9) {
            } else {
            }
            if (equals instanceof Enum) {
            } else {
            }
            if ((Enum)equals.ordinal() != 0) {
            }
            if (equals != (y9)equals.e()) {
            }
            floatToRawIntBits = equals.equals(x7.a);
            if (floatToRawIntBits == 0) {
            }
            floatToRawIntBits = equals.equals("");
            if (Long.compare(doubleToRawLongBits, length) != 0) {
            }
            if (Float.floatToRawIntBits((Float)equals.floatValue()) != 0) {
            }
            if ((Integer)equals.intValue() != 0) {
            }
            if ((Boolean)equals.booleanValue() != 0) {
            }
            string2 = doubleToRawLongBits.concat(valueOf6);
            string3 = startsWith.concat(valueOf8);
            declaredMethods = valueOf5.concat(valueOf);
            String valueOf4 = String.valueOf(floatToRawIntBits.substring(i10, length3 += -5));
            if (valueOf4.length() != 0) {
            } else {
            }
            string = new String(startsWith);
            if (hashMap.containsKey(string) == null) {
            }
            string = startsWith.concat(valueOf4);
            concat = equals.concat(valueOf3);
            if (!floatToRawIntBits.equals(equals2)) {
            } else {
            }
            String valueOf9 = String.valueOf(floatToRawIntBits.substring(i10, length2).toLowerCase());
            doubleToRawLongBits = String.valueOf(floatToRawIntBits.substring(length2, length7 += -3));
            if (doubleToRawLongBits.length() != 0) {
            } else {
            }
            doubleToRawLongBits = new String(valueOf9);
            equals2 = doubleToRawLongBits;
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
            aa.b(stringBuilder2, i3, aa.c(equals2), w8.m(next, y9, new Object[i10]));
            equals2 = valueOf9.concat(doubleToRawLongBits);
            if (!floatToRawIntBits.endsWith("OrBuilderList")) {
            } else {
            }
            if (!floatToRawIntBits.equals(equals)) {
            } else {
            }
            String valueOf7 = String.valueOf(floatToRawIntBits.substring(i10, length2).toLowerCase());
            valueOf2 = String.valueOf(floatToRawIntBits.substring(length2, length4 += -4));
            if (valueOf2.length() != 0) {
            } else {
            }
            valueOf2 = new String(valueOf7);
            equals = valueOf2;
            doubleToRawLongBits = hashMap.get(next);
            if (doubleToRawLongBits != null && (Method)doubleToRawLongBits.getReturnType().equals(List.class)) {
            } else {
            }
            if (doubleToRawLongBits.getReturnType().equals(List.class)) {
            } else {
            }
            aa.b(stringBuilder2, i3, aa.c(equals), w8.m(doubleToRawLongBits, y9, new Object[i10]));
            equals = valueOf7.concat(valueOf2);
            floatToRawIntBits = next.substring(3);
        }
        if (y9 instanceof u8) {
        } else {
            com.google.android.gms.internal.measurement.ya obj12 = y9.zzc;
            if (obj12 != null) {
                obj12.g(stringBuilder2, i3);
            }
        }
        obj12 = y9.zza;
        throw 0;
    }
}
