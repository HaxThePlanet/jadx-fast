package f.g.e;

import java.util.Locale;

/* loaded from: classes2.dex */
public class c {
    public static String a(String string) {
        boolean lastIndexOf;
        String trim;
        int i;
        String obj3;
        trim = "";
        lastIndexOf = string.lastIndexOf(".");
        if (g.c(string) && lastIndexOf != -1) {
            lastIndexOf = string.lastIndexOf(".");
            if (lastIndexOf != -1) {
                trim = string.substring(lastIndexOf++).toLowerCase(Locale.US).trim();
            }
        }
        return trim;
    }

    public static String b(Long long) {
        return c.c(long, true);
    }

    public static String c(Long long, boolean z2) {
        String str2;
        int cmp;
        int i;
        int i2;
        String str;
        i2 = 0;
        if (long != null && Long.compare(longValue, i2) >= 0) {
            i2 = 0;
            if (Long.compare(longValue, i2) >= 0) {
                i = z2 ? 1000 : 1024;
                if (Long.compare(longValue2, l) < 0) {
                    StringBuilder obj11 = new StringBuilder();
                    obj11.append(long);
                    obj11.append(" B");
                    return obj11.toString();
                }
                double d3 = (double)i;
                int i3 = (int)i4;
                StringBuilder stringBuilder = new StringBuilder();
                str = z2 ? "kMGTPE" : "KMGTPE";
                stringBuilder.append(str.charAt(i3 + -1));
                if (z2) {
                } else {
                    str2 = "i";
                }
                stringBuilder.append(str2);
                Object[] arr = new Object[2];
                return String.format(Locale.US, "%.1f %sB", Double.valueOf(d6 /= d4), stringBuilder.toString());
            }
        }
        return "";
    }
}
