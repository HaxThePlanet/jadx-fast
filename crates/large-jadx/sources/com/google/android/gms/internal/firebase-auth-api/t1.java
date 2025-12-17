package com.google.android.gms.internal.firebase-auth-api;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class t1 {
    public static String a(String string) {
        String obj1;
        if (dp.c(string)) {
            obj1 = 0;
        }
        return obj1;
    }

    public static String b(String string, Object... object2Arr2) {
        int length;
        String str;
        int i;
        Object string2;
        int i2;
        Class name;
        int length2;
        String indexOf;
        String length3;
        StringBuilder stringBuilder;
        int i3;
        Throwable th;
        int i4;
        java.lang.CharSequence obj11;
        length = 0;
        i = length;
        int length4 = object2Arr2.length;
        while (i < length4) {
            Object obj = object2Arr2[i];
            if (obj == null) {
            } else {
            }
            string2 = obj.toString();
            object2Arr2[i] = string2;
            i++;
            length4 = object2Arr2.length;
            string2 = "null";
            name = string2.getClass();
            name = name.getName();
            string2 = System.identityHashCode(string2);
            string2 = Integer.toHexString(string2);
            indexOf = String.valueOf(name);
            indexOf = indexOf.length();
            length3 = String.valueOf(string2);
            length3 = length3.length();
            indexOf++;
            indexOf += length3;
            stringBuilder = new StringBuilder(indexOf);
            stringBuilder.append(name);
            name = 64;
            stringBuilder.append(name);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            name = "com.google.common.base.Strings";
            name = Logger.getLogger(name);
            indexOf = Level.WARNING;
            length3 = String.valueOf(string2);
            stringBuilder = "Exception during lenientFormat for ";
            i3 = length3.length();
            if (i3 != 0) {
            } else {
            }
            length3 = stringBuilder.concat(length3);
            length3 = new String(stringBuilder);
            i3 = length3;
            length3 = "com.google.common.base.Strings";
            stringBuilder = "lenientToString";
            name.logp(indexOf, length3, stringBuilder, i3, th2);
            name = th2.getClass();
            name = name.getName();
            indexOf = String.valueOf(string2);
            indexOf = indexOf.length();
            length3 = String.valueOf(name);
            length3 = length3.length();
            indexOf += 9;
            indexOf += length3;
            stringBuilder = new StringBuilder(indexOf);
            indexOf = "<";
            stringBuilder.append(indexOf);
            stringBuilder.append(string2);
            string2 = " threw ";
            stringBuilder.append(string2);
            stringBuilder.append(name);
            string2 = ">";
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder(length5 += i6);
        i2 = length;
        length2 = object2Arr2.length;
        while (length < length2) {
            indexOf = string.indexOf("%s", i2);
            if (indexOf == -1) {
                break;
            } else {
            }
            stringBuilder2.append(string, i2, indexOf);
            stringBuilder2.append(object2Arr2[length]);
            i2 = i5;
            length = i4;
            length2 = object2Arr2.length;
        }
        stringBuilder2.append(string, i2, string.length());
        if (length < length2) {
            stringBuilder2.append(" [");
            obj11 = length + 1;
            stringBuilder2.append(object2Arr2[length]);
            while (obj11 < object2Arr2.length) {
                stringBuilder2.append(", ");
                stringBuilder2.append(object2Arr2[obj11]);
                obj11 = str;
            }
            stringBuilder2.append(']');
        }
        return stringBuilder2.toString();
    }

    public static String c(String string) {
        return dp.b(string);
    }

    public static boolean d(String string) {
        return dp.c(string);
    }
}
