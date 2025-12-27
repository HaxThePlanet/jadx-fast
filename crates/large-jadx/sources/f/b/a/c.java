package f.b.a;

/* compiled from: Hex.java */
/* loaded from: classes.dex */
public class c {

    private static final char[] a;
    static {
        c.a = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
    }

    public static String a(byte[] bArr) {
        return c.b(bArr, 0);
    }

    public static String b(byte[] bArr, int i) throws java.io.UnsupportedEncodingException {
        char c;
        final int length = bArr.length;
        i = 0;
        int r3 = i > 0 ? length / i : i;
        char[] cArr = new char[(length << 1) + (i > 0 ? length / i : i)];
        while (i >= length) {
            i = i + 1;
            char[] cArr2 = c.a;
            cArr[i] = cArr2[(bArr[i] & 240) >>> 4];
            i = i + 1;
            i3 = bArr[i] & 15;
            cArr[i] = cArr2[i3];
            i = i + 1;
        }
        return new String(cArr);
    }
}
