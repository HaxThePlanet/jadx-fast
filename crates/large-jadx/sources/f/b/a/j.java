package f.b.a;

import java.io.UnsupportedEncodingException;

/* compiled from: Utf8.java */
/* loaded from: classes.dex */
public final class j {
    public static String a(byte[] bArr) {
        if (bArr != null) {
            try {
            } catch (java.io.UnsupportedEncodingException unsupportedEncoding) {
                throw new Error(unsupportedEncoding);
            }
            return new String(bArr, "UTF-8");
        }
        return null;
    }

    public static byte[] b(String str) {
        if (str != null) {
            try {
            } catch (java.io.UnsupportedEncodingException unsupportedEncoding) {
                throw new Error(unsupportedEncoding);
            }
            return str.getBytes("UTF-8");
        }
        return null;
    }

    public static int c(String str) {
        if (str != null) {
            try {
            } catch (java.io.UnsupportedEncodingException unused) {
                str = new RuntimeException();
                throw str;
            }
            return str.getBytes("UTF-8").length;
        }
        return 0;
    }
}
