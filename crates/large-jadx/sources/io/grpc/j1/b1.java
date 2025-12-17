package io.grpc.j1;

import f.c.c.a.b;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class b1 {

    private static final long a;
    static {
        b1.a = TimeUnit.SECONDS.toNanos(1);
    }

    public static List<Map<String, ?>> a(List<?> list) {
        int i;
        boolean z;
        int i2 = 0;
        i = i2;
        while (i < list.size()) {
            i++;
        }
        return list;
    }

    public static List<String> b(List<?> list) {
        int i;
        boolean z;
        int i2 = 0;
        i = i2;
        while (i < list.size()) {
            i++;
        }
        return list;
    }

    private static boolean c(long l, int i2) {
        int cmp;
        long l2;
        int i;
        long obj6;
        if (Long.compare(l, l3) >= 0) {
            if (Long.compare(l, l2) > 0) {
            } else {
                l2 = (long)obj8;
                if (Long.compare(l2, i) >= 0) {
                    if (Long.compare(l2, i) >= 0) {
                    } else {
                        obj6 = Long.compare(l, l2);
                        if (obj6 >= 0) {
                            if (obj8 < 0 && obj6 <= 0 && obj8 > 0) {
                                if (obj6 <= 0) {
                                    if (obj8 > 0) {
                                    }
                                }
                            }
                            return 1;
                        } else {
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static Boolean d(Map<String, ?> map, String string2) {
        if (!map.containsKey(string2)) {
            return null;
        }
        Object obj = map.get(string2);
        if (!obj instanceof Boolean) {
        } else {
            return (Boolean)obj;
        }
        Object[] arr = new Object[3];
        ClassCastException classCastException = new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Boolean", obj, string2, map));
        throw classCastException;
    }

    public static List<?> e(Map<String, ?> map, String string2) {
        if (!map.containsKey(string2)) {
            return 0;
        }
        Object obj = map.get(string2);
        if (obj instanceof List == null) {
        } else {
            return (List)obj;
        }
        Object[] arr = new Object[3];
        ClassCastException classCastException = new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", obj, string2, map));
        throw classCastException;
    }

    public static List<Map<String, ?>> f(Map<String, ?> map, String string2) {
        List obj0 = b1.e(map, string2);
        if (obj0 == null) {
            return 0;
        }
        b1.a(obj0);
        return obj0;
    }

    public static List<String> g(Map<String, ?> map, String string2) {
        List obj0 = b1.e(map, string2);
        if (obj0 == null) {
            return 0;
        }
        b1.b(obj0);
        return obj0;
    }

    public static Double h(Map<String, ?> map, String string2) {
        if (!map.containsKey(string2)) {
            return null;
        }
        Object obj = map.get(string2);
        if (!obj instanceof Double) {
        } else {
            return (Double)obj;
        }
        Object[] arr = new Object[3];
        ClassCastException classCastException = new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Double", obj, string2, map));
        throw classCastException;
    }

    public static Integer i(Map<String, ?> map, String string2) {
        Double obj4 = b1.h(map, string2);
        if (obj4 == null) {
            return null;
        }
        int obj5 = obj4.intValue();
        if (Double.compare(d, doubleValue) != 0) {
        } else {
            return Integer.valueOf(obj5);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Number expected to be integer: ");
        stringBuilder.append(obj4);
        obj5 = new ClassCastException(stringBuilder.toString());
        throw obj5;
    }

    public static Map<String, ?> j(Map<String, ?> map, String string2) {
        if (!map.containsKey(string2)) {
            return 0;
        }
        Object obj = map.get(string2);
        if (obj instanceof Map == null) {
        } else {
            return (Map)obj;
        }
        Object[] arr = new Object[3];
        ClassCastException classCastException = new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not object", obj, string2, map));
        throw classCastException;
    }

    public static String k(Map<String, ?> map, String string2) {
        if (!map.containsKey(string2)) {
            return null;
        }
        Object obj = map.get(string2);
        if (obj instanceof String == null) {
        } else {
            return (String)obj;
        }
        Object[] arr = new Object[3];
        ClassCastException classCastException = new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not String", obj, string2, map));
        throw classCastException;
    }

    public static Long l(Map<String, ?> map, String string2) {
        String obj0 = b1.k(map, string2);
        if (obj0 == null) {
            return null;
        }
        return Long.valueOf(b1.n(obj0));
    }

    private static long m(long l, int i2) {
        int i;
        int cmp;
        int cmp2;
        int i3;
        long obj9;
        int obj11;
        i = (long)obj11;
        long l4 = b1.a;
        if (Long.compare(i, i7) > 0) {
            if (Long.compare(i, l4) >= 0) {
                obj9 = b.a(l, i2);
                obj11 = (int)i;
            }
        } else {
        }
        int i4 = 0;
        final int i8 = 1;
        if (Long.compare(obj9, i4) > 0 && obj11 < 0) {
            if (obj11 < 0) {
                obj11 = (int)i3;
                obj9 -= i8;
            }
        }
        if (Long.compare(obj9, i4) < 0 && obj11 > 0) {
            if (obj11 > 0) {
                obj11 = (int)cmp;
                obj9 += i8;
            }
        }
        if (!b1.c(obj9, i2)) {
        } else {
            return b1.p(TimeUnit.SECONDS.toNanos(obj9), i2);
        }
        Object[] arr = new Object[2];
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(obj9), Integer.valueOf(obj11)));
        throw illegalArgumentException;
    }

    private static long n(String string) {
        boolean charAt;
        int i;
        int i4;
        String substring;
        long long;
        int i2;
        String substring2;
        int i3;
        String obj8;
        final String str2 = "Invalid duration string: ";
        final int i6 = 0;
        if (string.isEmpty()) {
        } else {
            i4 = 1;
            if (string.charAt(length -= i4) != 115) {
            } else {
                if (string.charAt(i6) == 45) {
                    obj8 = string.substring(i4);
                    i = i4;
                } else {
                    i = i6;
                }
                substring = obj8.substring(i6, length2 -= i4);
                int indexOf = substring.indexOf(46);
                if (indexOf != -1) {
                    substring2 = substring.substring(indexOf + 1);
                    substring = substring.substring(i6, indexOf);
                } else {
                    substring2 = "";
                }
                long = Long.parseLong(substring);
                if (substring2.isEmpty()) {
                    i3 = i6;
                } else {
                    i3 = b1.o(substring2);
                }
                if (Long.compare(long, i12) < 0) {
                } else {
                    if (i != 0) {
                        long = -long;
                        i3 = -i3;
                    }
                    return b1.m(long, indexOf);
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append(obj8);
                ParseException parseException2 = new ParseException(stringBuilder2.toString(), i6);
                throw parseException2;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(string);
        ParseException parseException = new ParseException(stringBuilder.toString(), i6);
        throw parseException;
    }

    private static int o(String string) {
        int i2;
        int i4;
        int length;
        char charAt;
        int i3;
        int i;
        final int i5 = 0;
        i4 = i2;
        while (i2 < 9) {
            i2++;
            i3 = 48;
            i4 += length;
        }
        return i4;
    }

    private static long p(long l, long l2) {
        int obj7;
        int obj8;
        int i = l + obj7;
        final int i3 = 0;
        final int i4 = 0;
        obj7 = Long.compare(obj7, i3) < 0 ? obj8 : i4;
        if (Long.compare(obj5, i3) >= 0) {
        } else {
            obj8 = i4;
        }
        if (obj7 | obj8 != 0) {
            return i;
        }
        return obj7 += obj5;
    }
}
