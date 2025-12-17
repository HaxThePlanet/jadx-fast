package f.g.e;

import java.security.MessageDigest;
import java.util.Locale;

/* loaded from: classes2.dex */
public class b {
    private static byte[] a(String string, String string2) {
        boolean z;
        if (g.c(string) && !g.c(string2)) {
            if (!g.c(string2)) {
            }
            MessageDigest obj2 = MessageDigest.getInstance(string);
            obj2.update(string2.getBytes());
            return obj2.digest();
        }
        return new byte[0];
    }

    private static String b(byte[] bArr) {
        int i;
        String format;
        Locale locale;
        Object[] arr;
        StringBuilder stringBuilder = new StringBuilder(length *= 2);
        final int i3 = 0;
        i = i3;
        while (i < bArr.length) {
            arr = new Object[1];
            arr[i3] = Integer.valueOf(b &= 255);
            stringBuilder.append(String.format(Locale.US, "%02x", arr));
            i++;
        }
        return stringBuilder.toString();
    }

    public static String c(String string) {
        if (g.c(string)) {
            return b.b(b.a("SHA-1", string));
        }
        return "";
    }
}
