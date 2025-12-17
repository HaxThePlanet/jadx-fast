package l;

import kotlin.d0.d.n;
import l.g0.b;

/* loaded from: classes3.dex */
public final class c {
    public static final boolean a(byte[] bArr, int i2, byte[] b3Arr3, int i4, int i5) {
        int i;
        byte b2;
        byte b;
        n.f(bArr, "a");
        n.f(b3Arr3, "b");
        int i3 = 0;
        i = i3;
        while (i < i5) {
            i++;
        }
        return 1;
    }

    public static final void b(long l, long l2, long l3) {
        int cmp;
        if (Long.compare(i, i3) < 0) {
        } else {
            if (Long.compare(l3, l) > 0) {
            } else {
                if (Long.compare(i2, obj8) < 0) {
                } else {
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=");
        stringBuilder.append(l);
        stringBuilder.append(" offset=");
        stringBuilder.append(l3);
        stringBuilder.append(" byteCount=");
        stringBuilder.append(obj8);
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(stringBuilder.toString());
        throw arrayIndexOutOfBoundsException;
    }

    public static final int c(int i) {
        return obj2 |= i6;
    }

    public static final short d(short s) {
        s &= i;
        return (short)obj1;
    }

    public static final String e(byte b) {
        char[] cArr = new char[2];
        String obj3 = new String(cArr);
        return obj3;
    }

    public static final String f(int i) {
        int i2;
        int i3;
        char obj6;
        if (i == 0) {
            return "0";
        }
        int i4 = 8;
        final char[] cArr = new char[i4];
        cArr[0] = b.f()[i9 &= 15];
        cArr[1] = b.f()[i11 &= 15];
        cArr[2] = b.f()[i17 &= 15];
        cArr[3] = b.f()[i19 &= 15];
        cArr[4] = b.f()[i14 &= 15];
        cArr[5] = b.f()[i21 &= 15];
        cArr[6] = b.f()[i23 &= 15];
        cArr[7] = b.f()[i &= 15];
        while (i3 < i4) {
            if (cArr[i3] != 48) {
                break;
            } else {
            }
            i3++;
        }
        String string = new String(cArr, i3, i3 - 8);
        return string;
    }
}
