package f.g.e;

import java.util.Locale;

/* compiled from: FileUtils.java */
/* loaded from: classes2.dex */
public class c {
    public static String a(String str) {
        String trimmed;
        trimmed = "";
        if (g.c(str)) {
            int lastIndexOf = str.lastIndexOf(".");
            int i = -1;
            if (lastIndexOf != -1) {
                trimmed = str.substring(lastIndexOf + 1).toLowerCase(Locale.US).trim();
            }
        }
        return trimmed;
    }

    public static String b(Long long) {
        return c.c(long, true);
    }

    public static String c(Long long, boolean z) {
        String str;
        int i = 1000;
        String str2;
        str = "";
        if (long != null) {
            long value = long.longValue();
            long l = 0L;
            if (value >= l && z) {
                i = 1000;
                long value2 = long.longValue();
                long l2 = (long)i;
                if (value2 < l2) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str3 = " B";
                    str4 = long + str3;
                    return str4;
                }
                double d3 = (double)i;
                double d = Math.log((double)long.longValue()) / Math.log(d3);
                StringBuilder stringBuilder = new StringBuilder();
                String r3 = z ? "kMGTPE" : "KMGTPE";
                stringBuilder.append((z ? "kMGTPE" : "KMGTPE"));
                if (!(z)) {
                    str = "i";
                }
                stringBuilder.append(str);
                Object[] arr = new Object[2];
                return String.format(Locale.US, "%.1f %sB", new Object[] { Double.valueOf((double)long.longValue() / (Math.pow(d3, d))), stringBuilder.toString() });
            }
        }
        return "";
    }
}
