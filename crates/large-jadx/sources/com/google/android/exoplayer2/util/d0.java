package com.google.android.exoplayer2.util;

import com.google.common.base.d;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class d0 {

    private byte[] a;
    private int b;
    private int c;
    public d0() {
        super();
        this.a = p0.f;
    }

    public d0(int i) {
        super();
        this.a = new byte[i];
        this.c = i;
    }

    public d0(byte[] bArr) {
        super();
        this.a = bArr;
        this.c = bArr.length;
    }

    public d0(byte[] bArr, int i2) {
        super();
        this.a = bArr;
        this.c = i2;
    }

    public int A() {
        byte[] bArr = this.a;
        int i3 = this.b;
        int i7 = i3 + 1;
        this.b = i7;
        final int i11 = i7 + 1;
        this.b = i11;
        this.b = i11 + 1;
        return i |= i6;
    }

    public int B() {
        int i = n();
        if (i < 0) {
        } else {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder(29);
        stringBuilder.append("Top bit not zero: ");
        stringBuilder.append(i);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    public long C() {
        long l = r();
        if (Long.compare(l, i) < 0) {
        } else {
            return l;
        }
        StringBuilder stringBuilder = new StringBuilder(38);
        stringBuilder.append("Top bit not zero: ");
        stringBuilder.append(l);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    public int D() {
        byte[] bArr = this.a;
        int i3 = this.b;
        final int i6 = i3 + 1;
        this.b = i6;
        this.b = i6 + 1;
        return i |= i5;
    }

    public void E(int i) {
        byte[] bArr;
        bArr = b() < i ? new byte[i] : this.a;
        G(bArr, i);
    }

    public void F(byte[] bArr) {
        G(bArr, bArr.length);
    }

    public void G(byte[] bArr, int i2) {
        this.a = bArr;
        this.c = i2;
        this.b = 0;
    }

    public void H(int i) {
        int length;
        int i2;
        if (i >= 0 && i <= bArr.length) {
            i2 = i <= bArr.length ? 1 : 0;
        } else {
        }
        g.a(i2);
        this.c = i;
    }

    public void I(int i) {
        int i2;
        int i3;
        if (i >= 0 && i <= this.c) {
            i3 = i <= this.c ? 1 : 0;
        } else {
        }
        g.a(i3);
        this.b = i;
    }

    public void J(int i) {
        I(i2 += i);
    }

    public int a() {
        return i -= i3;
    }

    public int b() {
        return bArr.length;
    }

    public void c(int i) {
        int i2;
        int obj2;
        if (i > b()) {
            this.a = Arrays.copyOf(this.a, i);
        }
    }

    public byte[] d() {
        return this.a;
    }

    public int e() {
        return this.b;
    }

    public int f() {
        return this.c;
    }

    public char g() {
        byte[] bArr = this.a;
        int i3 = this.b;
        return (char)i2;
    }

    public int h() {
        return b &= 255;
    }

    public void i(com.google.android.exoplayer2.util.c0 c0, int i2) {
        final int i = 0;
        j(c0.a, i, i2);
        c0.o(i);
    }

    public void j(byte[] bArr, int i2, int i3) {
        System.arraycopy(this.a, this.b, bArr, i2, i3);
        this.b = obj3 += i3;
    }

    public String k(char c) {
        int i;
        byte b;
        if (a() == 0) {
            return null;
        }
        i = this.b;
        while (i < this.c) {
            if (this.a[i] != c) {
            }
            i++;
        }
        int i3 = this.b;
        this.b = i;
        if (i < this.c) {
            this.b = i++;
        }
        return p0.B(this.a, i3, i - i3);
    }

    public double l() {
        return Double.longBitsToDouble(r());
    }

    public float m() {
        return Float.intBitsToFloat(n());
    }

    public int n() {
        byte[] bArr = this.a;
        int i3 = this.b;
        int i8 = i3 + 1;
        this.b = i8;
        int i12 = i8 + 1;
        this.b = i12;
        int i11 = i12 + 1;
        this.b = i11;
        this.b = i11 + 1;
        return i |= i7;
    }

    public String o() {
        int i5;
        int i;
        boolean z;
        int i2;
        int i4;
        byte b;
        int i3;
        if (a() == 0) {
            return null;
        }
        i5 = this.b;
        while (i5 < this.c) {
            if (!p0.h0(this.a[i5])) {
            }
            i5++;
        }
        i2 = this.b;
        int i10 = 3;
        i4 = this.a;
        if (i5 - i2 >= i10 && i4[i2] == -17 && i4[i2 + 1] == -69 && i4[i2 + 2] == -65) {
            i4 = this.a;
            if (i4[i2] == -17) {
                if (i4[i2 + 1] == -69) {
                    if (i4[i2 + 2] == -65) {
                        this.b = i2 += i10;
                    }
                }
            }
        }
        int i8 = this.b;
        String str = p0.B(this.a, i8, i5 - i8);
        this.b = i5;
        int i9 = this.c;
        if (i5 == i9) {
            return str;
        }
        byte[] bArr3 = this.a;
        i5++;
        this.b = i5;
        if (bArr3[i5] == 13 && i5 == i9) {
            i5++;
            this.b = i5;
            if (i5 == i9) {
                return str;
            }
        }
        i = this.b;
        if (bArr3[i] == 10) {
            this.b = i++;
        }
        return str;
    }

    public int p() {
        byte[] bArr = this.a;
        int i4 = this.b;
        int i8 = i4 + 1;
        this.b = i8;
        int i12 = i8 + 1;
        this.b = i12;
        int i11 = i12 + 1;
        this.b = i11;
        this.b = i11 + 1;
        return i2 |= i7;
    }

    public short q() {
        byte[] bArr = this.a;
        int i4 = this.b;
        final int i6 = i4 + 1;
        this.b = i6;
        this.b = i6 + 1;
        return (short)i3;
    }

    public long r() {
        byte[] bArr = this.a;
        int i2 = this.b;
        int i11 = i2 + 1;
        this.b = i11;
        final int i27 = 255;
        int i4 = i11 + 1;
        this.b = i4;
        int i22 = i4 + 1;
        this.b = i22;
        int i16 = i22 + 1;
        this.b = i16;
        int i24 = i16 + 1;
        this.b = i24;
        int i18 = i24 + 1;
        this.b = i18;
        int i26 = i18 + 1;
        this.b = i26;
        this.b = i26 + 1;
        return i10 | i21;
    }

    public String s() {
        return k('\0');
    }

    public short t() {
        byte[] bArr = this.a;
        int i3 = this.b;
        final int i6 = i3 + 1;
        this.b = i6;
        this.b = i6 + 1;
        return (short)i2;
    }

    public String u(int i) {
        return v(i, d.c);
    }

    public String v(int i, Charset charset2) {
        String string = new String(this.a, this.b, i, charset2);
        this.b = obj5 += i;
        return string;
    }

    public int w() {
        return i4 |= i10;
    }

    public int x() {
        final int i2 = this.b;
        this.b = i2 + 1;
        return b &= 255;
    }

    public int y() {
        byte[] bArr = this.a;
        int i3 = this.b;
        final int i6 = i3 + 1;
        this.b = i6;
        int i7 = i6 + 1;
        this.b = i7;
        this.b = i7 += 2;
        return i |= i5;
    }

    public long z() {
        byte[] bArr = this.a;
        int i2 = this.b;
        int i7 = i2 + 1;
        this.b = i7;
        final int i15 = 255;
        int i4 = i7 + 1;
        this.b = i4;
        final int i14 = i4 + 1;
        this.b = i14;
        this.b = i14 + 1;
        return i6 | i13;
    }
}
