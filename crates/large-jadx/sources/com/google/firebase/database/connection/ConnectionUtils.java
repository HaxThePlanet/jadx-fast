package com.google.firebase.database.connection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ConnectionUtils {
    public static void hardAssert(boolean z) {
        ConnectionUtils.hardAssert(z, "", new Object[0]);
    }

    public static void hardAssert(boolean z, String string2, Object... object3Arr3) {
        if (!z) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hardAssert failed: ");
        stringBuilder.append(String.format(string2, object3Arr3));
        AssertionError obj2 = new AssertionError(stringBuilder.toString());
        throw obj2;
    }

    public static Long longFromObject(Object object) {
        if (object instanceof Integer) {
            return Long.valueOf((long)obj2);
        }
        if (object instanceof Long) {
            return (Long)object;
        }
        return null;
    }

    public static String pathToString(List<String> list) {
        int i;
        Object next;
        final String str = "/";
        if (list.isEmpty()) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        i = 1;
        Iterator obj4 = list.iterator();
        while (obj4.hasNext()) {
            if (i == 0) {
            }
            i = 0;
            stringBuilder.append((String)obj4.next());
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static List<String> stringToPath(String string) {
        int i;
        int empty;
        ArrayList arrayList = new ArrayList();
        final String[] obj3 = string.split("/", -1);
        i = 0;
        for (Object empty : string) {
            if (!obj3[i].isEmpty()) {
            }
            arrayList.add(empty);
        }
        return arrayList;
    }
}
