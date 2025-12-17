package com.google.common.base;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class r {
    public static String a(String string) {
        return m.a(string);
    }

    public static boolean b(String string) {
        return m.d(string);
    }

    public static String c(String string, Object... object2Arr2) {
        int length2;
        Object obj;
        int str;
        String length;
        int i;
        int indexOf;
        int i2;
        int i3;
        int obj6;
        Object[] obj7;
        obj6 = String.valueOf(string);
        length2 = 0;
        if (object2Arr2 == null) {
            new Object[1][length2] = "(Object[])null";
        } else {
            str = length2;
            for (Object obj3 : object2Arr2) {
                object2Arr2[str] = r.d(obj3);
            }
        }
        StringBuilder stringBuilder = new StringBuilder(length3 += indexOf);
        i = length2;
        while (length2 < obj7.length) {
            indexOf = obj6.indexOf("%s", i);
            if (indexOf == -1) {
                break;
            } else {
            }
            stringBuilder.append(obj6, i, indexOf);
            stringBuilder.append(obj7[length2]);
            i = i4;
            length2 = i3;
        }
        stringBuilder.append(obj6, i, obj6.length());
        if (length2 < obj7.length) {
            stringBuilder.append(" [");
            obj6 = length2 + 1;
            stringBuilder.append(obj7[length2]);
            while (obj6 < obj7.length) {
                stringBuilder.append(", ");
                stringBuilder.append(obj7[obj6]);
                obj6 = obj;
            }
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }

    private static String d(Object object) {
        String str;
        String string;
        if (object == null) {
            return "null";
        }
        return object.toString();
    }
}
