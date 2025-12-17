package f.g.e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class g {

    private static Map<Character, String> a;
    public static final String b;
    static {
        HashMap hashMap = new HashMap();
        g.a = hashMap;
        hashMap.put('\u0027', "\\'");
        g.a.put('"', "\\\"");
        g.a.put('\u005c', "\\\\");
        g.a.put('/', "\\/");
        g.a.put('\u0008', "\\b");
        g.a.put('\u000a', "\\n");
        g.a.put('\u0009', "\\t");
        g.a.put('\u000c', "\\f");
        g.a.put('\u000d', "\\r");
        g.b = System.getProperty("line.separator");
    }

    public static String a(String string) {
        if (g.c(string)) {
            return string;
        }
        return "";
    }

    public static List<String> b(String string) {
        int i;
        String str;
        boolean z;
        if (g.c(string)) {
            String[] obj5 = string.split(",");
            ArrayList arrayList = new ArrayList();
            while (i < obj5.length) {
                str = obj5[i];
                if (g.c(str)) {
                }
                i++;
                arrayList.add(str);
            }
            return a.l(arrayList);
        }
        obj5 = new ArrayList(0);
        return a.l(obj5);
    }

    public static boolean c(String string) {
        int obj0;
        if (string != null && string.trim().length() > 0) {
            obj0 = string.trim().length() > 0 ? 1 : 0;
        } else {
        }
        return obj0;
    }

    public static boolean d(String... stringArr) {
        int length;
        int i;
        boolean z;
        final int i2 = 0;
        if (stringArr != null) {
            if (stringArr.length == 0) {
            } else {
                i = i2;
                while (i < stringArr.length) {
                    i++;
                }
            }
            return 1;
        }
        return i2;
    }

    public static boolean e(String string) {
        return obj0 ^= 1;
    }

    public static boolean f(String string) {
        int i;
        boolean digit;
        final int i2 = 0;
        if (g.e(string)) {
            return i2;
        }
        i = i2;
        while (i < string.length()) {
            i++;
        }
        return 1;
    }

    public static String g(List<String> list) {
        StringBuilder stringBuilder;
        int i;
        int size;
        String obj3;
        if (list != null) {
            stringBuilder = new StringBuilder();
            i = 0;
            while (i < list.size()) {
                stringBuilder.append((String)list.get(i));
                if (g.c((String)list.get(i)) && i < size2--) {
                }
                i++;
                stringBuilder.append((String)list.get(i));
                if (i < size2--) {
                }
                stringBuilder.append(",");
            }
            obj3 = stringBuilder.toString();
        } else {
            obj3 = 0;
        }
        return obj3;
    }

    public static String h(String... stringArr) {
        int obj0;
        if (stringArr == null) {
            obj0 = 0;
        } else {
            obj0 = Arrays.asList(stringArr);
        }
        return g.g(obj0);
    }

    public static String i(List<? extends Number> list) {
        int arrayList;
        Object string;
        Iterator obj2;
        if (list != null) {
            arrayList = new ArrayList();
            obj2 = list.iterator();
            while (obj2.hasNext()) {
                string = obj2.next();
                if ((Number)string != null) {
                }
                arrayList.add((Number)string.toString());
            }
        } else {
            arrayList = 0;
        }
        return g.g(arrayList);
    }
}
