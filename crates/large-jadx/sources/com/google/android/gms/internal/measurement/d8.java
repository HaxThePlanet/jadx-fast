package com.google.android.gms.internal.measurement;

import java.util.Objects;

/* loaded from: classes2.dex */
final class d8 extends com.google.android.gms.internal.measurement.e8 {

    private final byte[] d;
    private final int e;
    private int f = 0;
    d8(byte[] bArr, int i2, int i3) {
        super(0);
        Objects.requireNonNull(bArr, "buffer");
        int obj4 = bArr.length;
        int i6 = 0;
        if (i |= i3 < 0) {
        } else {
            this.d = bArr;
            this.e = i3;
        }
        Object[] arr = new Object[3];
        arr[i6] = Integer.valueOf(obj4);
        arr[1] = Integer.valueOf(i6);
        arr[2] = Integer.valueOf(i3);
        IllegalArgumentException obj3 = new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", arr));
        throw obj3;
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void E(byte[] bArr, int i2, int i3) {
        System.arraycopy(bArr, 0, this.d, this.f, i3);
        this.f = obj4 += i3;
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void F(String string) {
        final int i = this.f;
        int i8 = e8.a(string.length());
        if (i8 == e8.a(length *= 3)) {
            int i4 = i + i8;
            this.f = i4;
            int i5 = mb.b(string, this.d, i4, i14 -= i4);
            this.f = i;
            u(i10 -= i8);
            this.f = i5;
        }
        try {
            u(mb.c(string));
            int i9 = this.f;
            this.f = mb.b(string, this.d, i9, i12 -= i9);
            zzjd zzjd = new zzjd(string);
            throw zzjd;
            this.f = zzjd;
            e(string, th);
        }
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final int g() {
        return i -= i3;
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void h(byte b) {
        try {
            final int i = this.f;
            this.f = i + 1;
            this.d[i] = b;
            int format = 3;
            format = new Object[format];
            int str = 0;
            int valueOf = this.f;
            valueOf = Integer.valueOf(valueOf);
            format[str] = valueOf;
            str = this.e;
            str = Integer.valueOf(str);
            valueOf = 1;
            format[valueOf] = str;
            str = 2;
            valueOf = Integer.valueOf(valueOf);
            format[str] = valueOf;
            str = "Pos: %d, limit: %d, len: %d";
            format = String.format(str, format);
            zzjd zzjd = new zzjd(format, b);
            throw zzjd;
        }
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void i(int i, boolean z2) {
        u(i <<= 3);
        h(z2);
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void j(int i, com.google.android.gms.internal.measurement.x7 x72) {
        u(obj1 |= 2);
        u(x72.g());
        x72.m(this);
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void k(int i, int i2) {
        u(obj1 |= 5);
        l(i2);
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void l(int i) {
        try {
            final byte[] bArr = this.d;
            int i2 = this.f;
            int i5 = i2 + 1;
            this.f = i5;
            bArr[i2] = (byte)i7;
            int i3 = i5 + 1;
            this.f = i3;
            bArr[i5] = (byte)i9;
            int i6 = i3 + 1;
            this.f = i6;
            bArr[i3] = (byte)i11;
            this.f = i6 + 1;
            bArr[i6] = (byte)obj5;
            int format = 3;
            format = new Object[format];
            int str = 0;
            int valueOf = this.f;
            valueOf = Integer.valueOf(valueOf);
            format[str] = valueOf;
            str = this.e;
            str = Integer.valueOf(str);
            valueOf = 1;
            format[valueOf] = str;
            str = 2;
            valueOf = Integer.valueOf(valueOf);
            format[str] = valueOf;
            str = "Pos: %d, limit: %d, len: %d";
            format = String.format(str, format);
            zzjd zzjd = new zzjd(format, i);
            throw zzjd;
        }
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void m(int i, long l2) {
        u(obj1 |= 1);
        n(l2);
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void n(long l) {
        try {
            final byte[] bArr = this.d;
            int i = this.f;
            int i7 = i + 1;
            this.f = i7;
            bArr[i] = (byte)i12;
            int i2 = i7 + 1;
            this.f = i2;
            bArr[i7] = (byte)i16;
            int i8 = i2 + 1;
            this.f = i8;
            bArr[i2] = (byte)i20;
            int i3 = i8 + 1;
            this.f = i3;
            bArr[i8] = (byte)i24;
            int i9 = i3 + 1;
            this.f = i9;
            bArr[i3] = (byte)i28;
            int i4 = i9 + 1;
            this.f = i4;
            bArr[i9] = (byte)i32;
            int i10 = i4 + 1;
            this.f = i10;
            bArr[i4] = (byte)i36;
            this.f = i10 + 1;
            bArr[i10] = (byte)obj6;
            int format = 3;
            format = new Object[format];
            int str = 0;
            int valueOf = this.f;
            valueOf = Integer.valueOf(valueOf);
            format[str] = valueOf;
            str = this.e;
            str = Integer.valueOf(str);
            valueOf = 1;
            format[valueOf] = str;
            str = 2;
            valueOf = Integer.valueOf(valueOf);
            format[str] = valueOf;
            str = "Pos: %d, limit: %d, len: %d";
            format = String.format(str, format);
            obj7 = new zzjd(format, l);
            throw obj7;
        }
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void o(int i, int i2) {
        u(i <<= 3);
        p(i2);
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void p(int i) {
        if (i >= 0) {
            u(i);
        }
        w((long)i);
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void q(byte[] bArr, int i2, int i3) {
        E(bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void r(int i, String string2) {
        u(obj1 |= 2);
        F(string2);
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void s(int i, int i2) {
        u(obj1 |= i2);
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void t(int i, int i2) {
        u(i <<= 3);
        u(i2);
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void u(int i) {
        boolean z;
        int format;
        int str;
        int obj5;
        if (e8.f()) {
            z = m7.a;
        }
        while (obj5 & -128 == 0) {
            format = this.f;
            this.f = format + 1;
            this.d[format] = (byte)i7;
            obj5 >>>= 7;
        }
        int i3 = this.f;
        this.f = i3 + 1;
        this.d[i3] = (byte)obj5;
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void v(int i, long l2) {
        u(i <<= 3);
        w(l2);
    }

    @Override // com.google.android.gms.internal.measurement.e8
    public final void w(long l) {
        boolean z;
        int i;
        byte b;
        byte b2;
        int obj10;
        int i3 = 7;
        int i6 = 0;
        final int i9 = -128;
        if (e8.f() && i2 -= i11 >= 10) {
            if (i2 -= i11 >= 10) {
            }
        }
        while (Long.compare(i10, i6) == 0) {
            i = this.f;
            this.f = i + 1;
            this.d[i] = (byte)i17;
            obj10 >>>= i3;
        }
        int i4 = this.f;
        this.f = i4 + 1;
        this.d[i4] = (byte)obj10;
    }
}
