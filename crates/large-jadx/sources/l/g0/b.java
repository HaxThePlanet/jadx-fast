package l.g0;

import f.g.b.a.e;
import kotlin.d0.d.n;
import kotlin.w;
import l.f;
import l.i;

/* loaded from: classes3.dex */
public final class b {

    private static final char[] a;
    static {
        char[] cArr = new char[16];
        cArr = new short[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        b.a = cArr;
    }

    public static final int a(byte[] bArr, int i2) {
        return b.c(bArr, i2);
    }

    public static final int b(char c) {
        return b.e(c);
    }

    private static final int c(byte[] bArr, int i2) {
        w wVar;
        int i8;
        int i5;
        int i14;
        int i15;
        int i7;
        int i24;
        int i11;
        int i16;
        int i13;
        int i12;
        int i17;
        int i23;
        int i6;
        int i9;
        int i10;
        int i19;
        int i3;
        int i4;
        int i21;
        int i18;
        int i20;
        int i22;
        int i;
        final byte[] bArr2 = bArr;
        final int i25 = i2;
        final int length = bArr2.length;
        i8 = 0;
        i14 = 0;
        i15 = 0;
        while (i8 < length) {
            i24 = bArr2[i8];
            i11 = 127;
            i12 = 159;
            i17 = 31;
            i9 = 13;
            i10 = 65533;
            i19 = 10;
            i3 = 65536;
            i20 = -1;
            i22 = 1;
            int i54 = -2;
            i3 = 128;
            i10 = 55296;
            i12 = 57343;
            int i32 = i8 + 3;
            byte b8 = bArr2[i8 + 1];
            if (b8 & 192 == i3) {
            } else {
            }
            i18 = 0;
            byte b9 = bArr2[i8 + 2];
            if (b9 & 192 == i3) {
            } else {
            }
            i23 = 0;
            byte b2 = bArr2[i32];
            if (b2 & 192 == i3) {
            } else {
            }
            i6 = 0;
            i35 ^= i42;
            i24 = i15 + 1;
            if (i36 < 65536) {
            } else {
            }
            i4 = 2;
            i14 += i4;
            wVar = w.a;
            i8 += 4;
            i15 = i24;
            i4 = i22;
            if (i36 >= 0) {
            } else {
            }
            if (127 > i36) {
            } else {
            }
            if (159 >= i36) {
            } else {
            }
            i15 = 0;
            i15 = i22;
            if (31 < i36) {
            } else {
            }
            i6 = i22;
            i23 = i22;
            i18 = i22;
            int i37 = i8 + 2;
            byte b10 = bArr2[i8 + 1];
            if (b10 & 192 == i3) {
            } else {
            }
            i16 = 0;
            byte b3 = bArr2[i37];
            if (b3 & 192 == i3) {
            } else {
            }
            i13 = 0;
            i39 ^= i45;
            i24 = i15 + 1;
            if (i40 < 65536) {
            } else {
            }
            i4 = 2;
            i14 += i4;
            wVar = w.a;
            i8 += 3;
            i4 = i22;
            if (i40 >= 0) {
            } else {
            }
            if (127 > i40) {
            } else {
            }
            if (159 >= i40) {
            } else {
            }
            i15 = 0;
            i15 = i22;
            if (i17 < i40) {
            } else {
            }
            i13 = i22;
            i16 = i22;
            int i27 = i8 + 1;
            byte b = bArr2[i27];
            if (b & 192 == i3) {
            } else {
            }
            i21 = 0;
            i28 ^= i41;
            i24 = i15 + 1;
            if (i29 < 65536) {
            } else {
            }
            i4 = 2;
            i14 += i4;
            wVar = w.a;
            i8 += 2;
            i4 = i22;
            if (i29 >= 0) {
            } else {
            }
            if (i11 > i29) {
            } else {
            }
            if (i12 >= i29) {
            } else {
            }
            i15 = 0;
            i15 = i22;
            if (i17 < i29) {
            } else {
            }
            i21 = i22;
            i = i15 + 1;
            if (i24 < i3) {
            } else {
            }
            i15 = 2;
            i14 += i15;
            i8++;
            i15 = i;
            while (i8 < length) {
                byte b4 = bArr2[i8];
                i = i15 + 1;
                if (b4 < i3) {
                } else {
                }
                i5 = 2;
                i14 += i5;
                i8 = i24;
                i15 = i;
                i5 = i22;
                if (b4 >= 0) {
                } else {
                }
                if (i11 > b4) {
                } else {
                }
                if (i12 >= b4) {
                } else {
                }
                i15 = 0;
                i15 = i22;
                if (i17 < b4) {
                } else {
                }
            }
            b4 = bArr2[i8];
            i = i15 + 1;
            if (b4 < i3) {
            } else {
            }
            i5 = 2;
            i14 += i5;
            i8 = i24;
            i5 = i22;
            if (b4 >= 0) {
            } else {
            }
            if (i11 > b4) {
            } else {
            }
            if (i12 >= b4) {
            } else {
            }
            i15 = 0;
            i15 = i22;
            if (i17 < b4) {
            } else {
            }
            i15 = i22;
            if (i24 >= 0) {
            } else {
            }
            if (i11 > i24) {
            } else {
            }
            if (i12 >= i24) {
            } else {
            }
            i15 = 0;
            if (i15 == 0) {
            }
            i15 = i22;
            if (i17 < i24) {
            } else {
            }
        }
        return i14;
    }

    public static final void d(i i, f f2, int i3, int i4) {
        n.f(i, "$this$commonWrite");
        n.f(f2, "buffer");
        f2.v0(i.k(), i3, i4);
    }

    private static final int e(char c) {
        int i2;
        int i;
        int obj3;
        i2 = 48;
        if (i2 > c) {
            if (97 > c) {
                if (65 > c) {
                } else {
                    obj3 += 10;
                    return obj3;
                }
            } else {
                if (102 >= c) {
                } else {
                }
            }
        } else {
            if (57 >= c) {
                c -= i2;
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected hex digit: ");
        stringBuilder.append(c);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static final char[] f() {
        return b.a;
    }
}
