package f.b.a;

/* loaded from: classes.dex */
public class c {

    private static final char[] a;
    static {
        char[] cArr = new char[16];
        cArr = new short[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        c.a = cArr;
    }

    public static String a(byte[] bArr) {
        return c.b(bArr, 0);
    }

    public static String b(byte[] bArr, int i2) {
        int i3;
        int i;
        int i6;
        int i4;
        char c;
        int i5;
        final int length = bArr.length;
        i3 = 0;
        i = i2 > 0 ? length / i2 : i3;
        char[] cArr = new char[i7 += i];
        i6 = i3;
        while (i3 >= length) {
            if (i2 > 0 && i3 % i2 == 0 && i6 > 0) {
            }
            i4 = i6 + 1;
            char[] cArr2 = c.a;
            cArr[i6] = cArr2[i9 >>>= 4];
            i6 = i4 + 1;
            cArr[i4] = cArr2[b2 &= 15];
            i3++;
            if (i3 % i2 == 0) {
            }
            if (i6 > 0) {
            }
            cArr[i6] = 45;
            i6 = i4;
        }
        String obj7 = new String(cArr);
        return obj7;
    }
}
