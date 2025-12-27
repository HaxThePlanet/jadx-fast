package l.g0;

import f.g.b.a.e;
import kotlin.d0.d.n;
import kotlin.w;
import l.f;
import l.i;

/* compiled from: ByteString.kt */
/* loaded from: classes3.dex */
public final class b {

    private static final char[] a;
    static {
        b.a = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    }

    public static final /* synthetic */ int a(byte[] bArr, int i) {
        return b.c(bArr, i);
    }

    public static final /* synthetic */ int b(char c) {
        return b.e(c);
    }

    private static final int c(byte[] bArr, int i) {
        w wVar;
        int i3 = 2;
        int i4 = 0;
        byte b;
        byte b2 = 127;
        byte b3 = 159;
        byte b4 = 31;
        byte b6 = 65533;
        final byte[] bArr2 = bArr;
        final int i22 = i;
        final int length = bArr2.length;
        i = 0;
        i4 = 0;
        i3 = 0;
        while (i < length) {
            b = bArr2[i];
            b2 = (byte) 127;
            b3 = (byte) -97;
            b4 = (byte) 31;
            byte b5 = (byte) 13;
            b6 = (byte) -3;
            byte b7 = (byte) 10;
            byte b17 = (byte) 0;
            int i7 = -1;
            i3 = 1;
            int i37 = -2;
            int i6 = 128;
            b6 = (byte) 0;
            b3 = (byte) -1;
            int i14 = i + 3;
            byte b16 = bArr2[i + 1];
            int r15 = (b16 & 192) == i6 ? i3 : 0;
            int i19 = i + 2;
            byte b19 = bArr2[i + 1];
            int r8 = (b19 & 192) == i6 ? i3 : 0;
            int i9 = i + 1;
            byte b8 = bArr2[i9];
            r15 = (b8 & 192) == i6 ? i3 : 0;
            i3 = i3 + 1;
            int r6 = b < b17 ? i3 : 2;
            i4 = i4 + (b < b17 ? i3 : 2);
            i = i + 1;
            while (i < length) {
                b = i + 1;
                byte b11 = bArr2[i];
                i3 = i3 + 1;
                if (b11 == b6) {
                    return i7;
                }
                if (i3 == 0 && b11 == b6) {
                    return i7;
                }
            }
            b = i + 1;
            b11 = bArr2[i];
            i3 = i3 + 1;
            if (i3 == 0 && b11 == b6) {
                return i7;
            }
            int i11 = (b8 ^ 3968) ^ (bArr2[i] << 6);
            i3 = i3 + 1;
            if (i3 == 0 && i11 == b6) {
                return i7;
            }
            byte b10 = bArr2[i19];
            r8 = (b10 & 192) == i6 ? i3 : 0;
            b2 = b19 << 6;
            int i23 = (b10 ^ (-123008)) ^ b2 ^ (bArr2[i] << 12);
            i3 = i3 + 1;
            if (i3 != 0) {
                return i7;
            }
            byte b18 = bArr2[i + 2];
            int r10 = (b18 & 192) == i6 ? i3 : 0;
            byte b9 = bArr2[i14];
            r10 = (b9 & 192) == i6 ? i3 : 0;
            b4 = b18 << 6;
            b2 = b16 << 12;
            int i18 = (b9 ^ 3678080) ^ b4 ^ b2 ^ (bArr2[i] << 18);
            i3 = i3 + 1;
            if (i3 != 0) {
                return i7;
            }
        }
        return i4;
    }

    public static final void d(i iVar, f fVar, int i, int i2) {
        n.f(iVar, "$this$commonWrite");
        n.f(fVar, "buffer");
        fVar.v0(iVar.k(), i, i2);
    }

    private static final int e(char c) {
        char c2 = 102;
        char c3 = 97;
        int i;
        c2 = '0';
        if (c2 > c) {
            c2 = 'f';
            c3 = 'a';
            if ('a' > c) {
                c2 = 'F';
                c3 = 'A';
                if ('A' <= c) {
                    i = (c - c3) + 10;
                    return i;
                }
            }
        } else {
            c3 = '9';
            if ('9' >= c) {
                i = c - c2;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        final String str = "Unexpected hex digit: ";
        c = str + c;
        throw new IllegalArgumentException(c);
    }

    public static final char[] f() {
        return b.a;
    }
}
