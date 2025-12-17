package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
final class er extends com.google.android.gms.internal.firebase-auth-api.gr {

    private final byte[] d;
    private final int e;
    private int f = 0;
    er(byte[] bArr, int i2, int i3) {
        super(0);
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

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void A(int i, int i2) {
        B(i <<= 3);
        B(i2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void B(int i) {
        boolean z;
        int format;
        int str;
        int obj5;
        if (gr.l()) {
            z = lq.a;
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

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void C(int i, long l2) {
        B(i <<= 3);
        D(l2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void D(long l) {
        boolean z;
        int i;
        byte b2;
        byte b;
        int obj10;
        int i3 = 7;
        int i6 = 0;
        final int i9 = -128;
        if (gr.l() && i2 -= i11 >= 10) {
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

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void I(byte[] bArr, int i2, int i3) {
        System.arraycopy(bArr, 0, this.d, this.f, i3);
        this.f = obj4 += i3;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void J(String string) {
        final int i = this.f;
        int i8 = gr.f(string.length());
        if (i8 == gr.f(length *= 3)) {
            int i4 = i + i8;
            this.f = i4;
            int i5 = o1.b(string, this.d, i4, i14 -= i4);
            this.f = i;
            B(i10 -= i8);
            this.f = i5;
        }
        try {
            B(o1.c(string));
            int i9 = this.f;
            this.f = o1.b(string, this.d, i9, i12 -= i9);
            zzzc zzzc = new zzzc(string);
            throw zzzc;
            this.f = zzzc;
            k(string, th);
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void a(byte[] bArr, int i2, int i3) {
        I(bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void m() {
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void n(byte b) {
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
            zzzc zzzc = new zzzc(format, b);
            throw zzzc;
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void o(int i, boolean z2) {
        B(i <<= 3);
        n(z2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void p(int i, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        B(obj1 |= 2);
        B(wq2.g());
        wq2.q(this);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final int q() {
        return i -= i3;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void r(int i, int i2) {
        B(obj1 |= 5);
        s(i2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void s(int i) {
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
            zzzc zzzc = new zzzc(format, i);
            throw zzzc;
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void t(int i, long l2) {
        B(obj1 |= 1);
        u(l2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void u(long l) {
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
            obj7 = new zzzc(format, l);
            throw obj7;
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void v(int i, int i2) {
        B(i <<= 3);
        w(i2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void w(int i) {
        if (i >= 0) {
            B(i);
        }
        D((long)i);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    final void x(int i, com.google.android.gms.internal.firebase-auth-api.y y2, com.google.android.gms.internal.firebase-auth-api.l0 l03) {
        int i2;
        B(obj3 |= 2);
        Object obj3 = y2;
        if ((jq)obj3.a() == -1) {
            obj3.b(l03.d(obj3));
        }
        B(i2);
        l03.f(y2, this.a);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void y(int i, String string2) {
        B(obj1 |= 2);
        J(string2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final void z(int i, int i2) {
        B(obj1 |= i2);
    }
}
