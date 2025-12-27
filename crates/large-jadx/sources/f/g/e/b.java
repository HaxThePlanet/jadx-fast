package f.g.e;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* compiled from: DigestUtils.java */
/* loaded from: classes2.dex */
public class b {
    private static byte[] a(String str, String str2) throws java.security.DigestException, java.io.UnsupportedEncodingException {
        return new byte[0];
    }

    private static String b(byte[] bArr) {
        int i;
        final StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        i = 0;
        for (byte b : bArr) {
            Object[] arr = new Object[1];
            arr[i] = Integer.valueOf(b & 255);
            stringBuilder.append(String.format(Locale.US, "%02x", arr));
        }
        return stringBuilder.toString();
    }

    public static String c(String str) {
        if (g.c(str)) {
            return b.b(b.a("SHA-1", str));
        }
        return "";
    }
}
