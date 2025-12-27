package io.grpc.j1;

import f.c.c.a.b;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: JsonUtil.java */
/* loaded from: classes3.dex */
public class b1 {

    private static final long a = 0L;
    static {
        b1.a = TimeUnit.SECONDS.toNanos(1L);
    }

    public static List<Map<String, ?>> a(List<?> list) {
        int i;
        i = 0;
        while (i < list.size()) {
            z = list.get(i) instanceof Map;
            if (!(list.get(i) instanceof Map)) {
                Object[] arr = new Object[3];
                arr[i] = list.get(i);
                arr[1] = Integer.valueOf(i);
                arr[2] = list;
                throw new ClassCastException(String.format("value %s for idx %d in %s is not object", arr));
            }
        }
        return list;
    }

    public static List<String> b(List<?> list) {
        int i;
        i = 0;
        while (i < list.size()) {
            z = list.get(i) instanceof String;
            if (!(list.get(i) instanceof String)) {
                Object[] arr = new Object[3];
                arr[i] = list.get(i);
                arr[1] = Integer.valueOf(i);
                arr[2] = list;
                throw new ClassCastException(String.format("value '%s' for idx %d in '%s' is not string", arr));
            }
        }
        return list;
    }

    private static boolean c(long j, int i) {
        return false;
    }

    public static Boolean d(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object value = map.get(str);
        if (!(value instanceof Boolean)) {
            Object[] arr = new Object[3];
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Boolean", new Object[] { value, str, map }));
        } else {
            return value;
        }
    }

    public static List<?> e(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object value = map.get(str);
        if (!(value instanceof List)) {
            Object[] arr = new Object[3];
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", new Object[] { value, str, map }));
        } else {
            return value;
        }
    }

    public static List<Map<String, ?>> f(Map<String, ?> map, String str) {
        List list = b1.e(map, str);
        if (list == null) {
            return null;
        }
        b1.a(list);
        return list;
    }

    public static List<String> g(Map<String, ?> map, String str) {
        List list = b1.e(map, str);
        if (list == null) {
            return null;
        }
        b1.b(list);
        return list;
    }

    public static Double h(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object value = map.get(str);
        if (!(value instanceof Double)) {
            Object[] arr = new Object[3];
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Double", new Object[] { value, str, map }));
        } else {
            return value;
        }
    }

    public static Integer i(Map<String, ?> map, String str) {
        Double d2 = b1.h(map, str);
        if (d2 == null) {
            return null;
        }
        int value2 = d2.intValue();
        double d = (double)value2;
        final double value = d2.doubleValue();
        if (d != value) {
            StringBuilder stringBuilder = new StringBuilder();
            str = "Number expected to be integer: ";
            map = str + d2;
            throw new ClassCastException(map);
        } else {
            return Integer.valueOf(value2);
        }
    }

    public static Map<String, ?> j(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object value = map.get(str);
        if (!(value instanceof Map)) {
            Object[] arr = new Object[3];
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not object", new Object[] { value, str, map }));
        } else {
            return value;
        }
    }

    public static String k(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object value = map.get(str);
        if (!(value instanceof String)) {
            Object[] arr = new Object[3];
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not String", new Object[] { value, str, map }));
        } else {
            return value;
        }
    }

    public static Long l(Map<String, ?> map, String str) {
        str = b1.k(map, str);
        if (str == null) {
            return null;
        }
        try {
        } catch (java.text.ParseException parse) {
            str = new RuntimeException(parse);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str;
        }
        return Long.valueOf(b1.n(str));
    }

    private static long m(long j, int i) {
        long l4;
        l = (long)i;
        long l9 = b1.a;
        int i5 = -l9;
        if (l > i5) {
            if (l >= b1.a) {
                l2 = l / b1.a;
                l4 = b.a(j, l2);
                l = l % b1.a;
                i = (int)l;
            }
        }
        long l5 = 0L;
        final long l10 = 1L;
        if (l4 > l5 && i < 0) {
            l3 = (long)i + b1.a;
            i = (int)l3;
            l4 = l4 - 1L;
        }
        if (l4 < l5 && i > 0) {
            i = (int)(long)i - b1.a;
            l4 = l4 + 1L;
        }
        if (!b1.c(l4, i)) {
            Object[] arr = new Object[2];
            throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", new Object[] { Long.valueOf(l4), Integer.valueOf(i) }));
        } else {
            return b1.p(TimeUnit.SECONDS.toNanos(l4), (long)i);
        }
    }

    private static long n(String str) throws ParseException {
        int i;
        String substring;
        long parsed;
        String substring2;
        String substring3;
        final String str3 = "Invalid duration string: ";
        i = 0;
        if (str.isEmpty()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            str = str3 + str;
            throw new ParseException(str, i);
        } else {
            i = 1;
            char c = 's';
            if (str.charAt(str.length() - i) == 's') {
                i = str.charAt(i) == 45 ? i : i;
                substring = substring3.substring(i, substring3.length() - i);
                int indexOf = substring.indexOf(46);
                if (indexOf != -1) {
                    substring2 = substring.substring(indexOf + 1);
                    substring = substring.substring(i, indexOf);
                } else {
                    substring2 = "";
                }
                parsed = Long.parseLong(substring);
                if (substring2.isEmpty()) {
                } else {
                    i = b1.o(substring2);
                }
                if (parsed < 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    str = str3 + substring3;
                    throw new ParseException(str, i);
                } else {
                    if (i != 0) {
                        int i3 = -parsed;
                        i = -i;
                    }
                    try {
                    } catch (java.lang.IllegalArgumentException unused) {
                        str = new ParseException("Duration value is out of range.", r2);
                        throw str;
                    }
                    return b1.m(parsed, i);
                }
            }
        }
    }

    private static int o(String str) throws ParseException {
        int i;
        int length;
        char c;
        char c2;
        i = 0;
        while (i < 9) {
            i = i * 10;
            if (i < str.length()) {
                c = '0';
            }
        }
        return i;
    }

    private static long p(long j, long j2) {
        int i;
        long l = j + j2;
        j2 ^= j;
        final long l2 = 0L;
        i = 1;
        i = 0;
        j2 = l5 < l2 ? 1 : i;
        j ^= l;
        if (l3 < l2) {
        }
        if (i | i != 0) {
            return l;
        }
        return (l >>> 63L) ^ 1L + Long.MAX_VALUE;
    }
}
