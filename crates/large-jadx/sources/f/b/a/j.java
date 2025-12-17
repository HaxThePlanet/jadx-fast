package f.b.a;

/* loaded from: classes.dex */
public final class j {
    public static String a(byte[] bArr) {
        if (bArr != null) {
            String string = new String(bArr, "UTF-8");
            return string;
        }
        return null;
    }

    public static byte[] b(String string) {
        if (string != null) {
            return string.getBytes("UTF-8");
        }
        return null;
    }

    public static int c(String string) {
        if (string != null) {
            return obj1.length;
        }
        return 0;
    }
}
