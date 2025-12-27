package l;

import kotlin.d0.d.n;
import l.g0.b;

/* compiled from: -Util.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final boolean a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        n.f(bArr, "a");
        n.f(bArr2, "b");
        i = 0;
        while (i < i3) {
            if (bArr[i + i] != bArr2[i + i2]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j, long j2, long j3) {
        long l = j2 | j3;
        if (l < 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            String str = "size=";
            String str2 = " offset=";
            String str3 = " byteCount=";
            j = str + j + str2 + j2 + str3 + j3;
            throw new ArrayIndexOutOfBoundsException(j);
        } else {
            if (j2 <= j) {
                long l2 = j - j2;
                if (l2 >= j3) {
                    return;
                }
            }
        }
    }

    public static final String e(byte b) throws java.io.UnsupportedEncodingException {
        char[] cArr = new char[2];
        return new String(cArr);
    }

    public static final String f(int i) throws java.io.UnsupportedEncodingException {
        int i2 = 7;
        int i3 = 0;
        char c;
        if (i == 0) {
            return "0";
        }
        int i4 = 8;
        final char[] cArr = new char[i4];
        i3 = 0;
        cArr[i3] = b.f()[(i >> 28) & 15];
        cArr[1] = b.f()[(i >> 24) & 15];
        cArr[2] = b.f()[(i >> 20) & 15];
        cArr[3] = b.f()[(i >> 16) & 15];
        cArr[4] = b.f()[(i >> 12) & 15];
        cArr[5] = b.f()[(i >> 8) & 15];
        cArr[6] = b.f()[(i >> 4) & 15];
        i2 = 7;
        cArr[i2] = b.f()[i & 15];
        while (i3 < i4) {
            i2 = 48;
            if (cArr[i3] != 48) {
                break;
            }
        }
        return new String(cArr, i3, i3 - 8);
    }

    public static final int c(int i) {
        return (i & 255) << 24 | (-16777216 & i) >>> 24 | (16711680 & i) >>> 8 | (65280 & i) << 8;
    }

    public static final short d(short s) {
        s &= 65535;
        return (short)(i5 & 255) << 8 | (65280 & i5) >>> 8;
    }
}
