package f.g.e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: StringUtils.java */
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

    public static String a(String str) {
        if (g.c(str)) {
            return str;
        }
        return "";
    }

    public static List<String> b(String str) {
        int i = 0;
        i = 0;
        if (g.c(str)) {
            String[] parts = str.split(",");
            ArrayList arrayList = new ArrayList();
            for (String str2 : parts) {
            }
            return a.l(arrayList);
        }
        return a.l(new ArrayList(0));
    }

    public static boolean c(String str) {
        boolean z = false;
        if (str != null) {
            str = str.trim().length() > 0 ? 1 : 0;
        }
        return (str.trim().length() > 0 ? 1 : 0);
    }

    public static boolean d(String... strArr) {
        int i;
        i = 0;
        if (strArr != null) {
            length = strArr.length;
            if (strArr.length != 0) {
                for (Object obj : strArr) {
                    if (g.e(obj)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean e(String str) {
        return !g.c(str);
    }

    public static boolean f(String str) {
        int i;
        i = 0;
        if (g.e(str)) {
            return false;
        }
        while (i < str.length()) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String g(List<String> list) {
        int i = 0;
        boolean z;
        String str = null;
        if (list != null) {
            StringBuilder stringBuilder = new StringBuilder();
            i = 0;
            while (i < list.size()) {
                i = i + 1;
            }
            str = stringBuilder.toString();
        } else {
            int i3 = 0;
        }
        return str;
    }

    public static String h(String... strArr) {
        List list = null;
        if (strArr == null) {
            int i = 0;
        } else {
            list = Arrays.asList(strArr);
        }
        return g.g(list);
    }

    public static String i(List<? extends Number> list) {
        ArrayList arrayList = null;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
        } else {
            int i = 0;
        }
        return g.g(arrayList);
    }
}
