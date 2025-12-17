package com.google.android.exoplayer2.util;

import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class c0 {

    public byte[] a;
    private int b;
    private int c;
    private int d;
    public c0() {
        super();
        this.a = p0.f;
    }

    public c0(byte[] bArr) {
        super(bArr, bArr.length);
    }

    public c0(byte[] bArr, int i2) {
        super();
        this.a = bArr;
        this.d = i2;
    }

    private void a() {
        int i;
        int i3;
        int i2;
        i = this.b;
        if (i >= 0) {
            i2 = this.d;
            if (i >= i2) {
                if (i == i2 && this.c == 0) {
                    i3 = this.c == 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        g.f(i3);
    }

    public int b() {
        return i3 -= i6;
    }

    public void c() {
        if (this.c == 0) {
        }
        this.c = 0;
        this.b = i3++;
        a();
    }

    public int d() {
        int i;
        i = this.c == 0 ? 1 : 0;
        g.f(i);
        return this.b;
    }

    public int e() {
        return i2 += i4;
    }

    public void f(int i, int i2) {
        int i5;
        int i3;
        byte b;
        int i6;
        byte[] bArr;
        int i4;
        int obj9;
        int i7 = 1;
        if (i2 < 32) {
            i &= i5;
        }
        int i11 = Math.min(i9 - 8, i2);
        int i16 = this.c;
        i23 -= i11;
        bArr = this.a;
        int i32 = this.b;
        bArr[i32] = (byte)i19;
        bArr[i32] = (byte)i22;
        i32 += i7;
        while (i3 > 8) {
            this.a[i4] = (byte)i31;
            i3 += -8;
            i4 = i6;
        }
        int i15 = i3 - 8;
        byte[] bArr2 = this.a;
        bArr2[i4] = (byte)i24;
        bArr2[i4] = (byte)obj9;
        q(i2);
        a();
    }

    public boolean g() {
        int i;
        i = b &= i5 != 0 ? 1 : 0;
        p();
        return i;
    }

    public int h(int i) {
        int i7;
        int i2;
        int i3;
        int i5;
        int i6;
        int i4;
        final int i8 = 0;
        if (i == 0) {
            return i8;
        }
        this.c = i9 += i;
        i7 = i8;
        int i12 = this.c;
        int i14 = 8;
        while (i12 > i14) {
            i12 += -8;
            this.c = i13;
            i5 = this.b;
            this.b = i5 + 1;
            i7 |= i2;
            i12 = this.c;
            i14 = 8;
        }
        i4 = this.b;
        if (i12 == i14) {
            this.c = i8;
            this.b = i4++;
        }
        a();
        return obj8 &= i11;
    }

    public void i(byte[] bArr, int i2, int i3) {
        byte b2;
        int i6;
        byte b3;
        int i5;
        byte b;
        int i7;
        int i;
        int i4;
        byte[] obj8;
        int obj9;
        int obj10;
        i8 += i2;
        int i10 = 255;
        int i16 = 8;
        while (obj9 < i9) {
            byte[] bArr3 = this.a;
            int i21 = this.b;
            i = i21 + 1;
            this.b = i;
            i4 = this.c;
            bArr[obj9] = (byte)i22;
            bArr[obj9] = (byte)i15;
            obj9++;
            i10 = 255;
            i16 = 8;
        }
        obj9 = i3 & 7;
        if (obj9 == null) {
        }
        bArr[i9] = (byte)obj10;
        obj10 = this.c;
        if (obj10 + obj9 > i16) {
            i = this.b;
            this.b = i + 1;
            bArr[i9] = (byte)i19;
            this.c = obj10 -= i16;
        }
        obj10 += obj9;
        this.c = obj10;
        i7 = this.b;
        bArr[i9] = (byte)obj9;
        if (obj10 == i16) {
            this.c = 0;
            this.b = i7++;
        }
        a();
    }

    public void j(byte[] bArr, int i2, int i3) {
        int i;
        i = this.c == 0 ? 1 : 0;
        g.f(i);
        System.arraycopy(this.a, this.b, bArr, i2, i3);
        this.b = obj3 += i3;
        a();
    }

    public String k(int i, Charset charset2) {
        final byte[] bArr = new byte[i];
        j(bArr, 0, i);
        String obj3 = new String(bArr, charset2);
        return obj3;
    }

    public void l(com.google.android.exoplayer2.util.d0 d0) {
        n(d0.d(), d0.f());
        o(obj3 *= 8);
    }

    public void m(byte[] bArr) {
        n(bArr, bArr.length);
    }

    public void n(byte[] bArr, int i2) {
        this.a = bArr;
        final int obj1 = 0;
        this.b = obj1;
        this.c = obj1;
        this.d = i2;
    }

    public void o(int i) {
        int i2 = i / 8;
        this.b = i2;
        this.c = i -= i3;
        a();
    }

    public void p() {
        int i;
        i2++;
        this.c = i;
        if (i == 8) {
            this.c = 0;
            this.b = i4++;
        }
        a();
    }

    public void q(int i) {
        int i3;
        int i2;
        int i4 = i / 8;
        i6 += i4;
        this.b = i3;
        i7 += obj4;
        this.c = i2;
        if (i2 > 7) {
            this.b = i3++;
            this.c = i2 += -8;
        }
        a();
    }

    public void r(int i) {
        int i2;
        i2 = this.c == 0 ? 1 : 0;
        g.f(i2);
        this.b = i4 += i;
        a();
    }
}
