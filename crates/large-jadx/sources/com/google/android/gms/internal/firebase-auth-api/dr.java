package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
abstract class dr extends com.google.android.gms.internal.firebase-auth-api.gr {

    final byte[] d;
    final int e;
    int f;
    int g;
    dr(int i) {
        super(0);
        if (i < 0) {
        } else {
            byte[] obj2 = new byte[Math.max(i, 20)];
            this.d = obj2;
            this.e = obj2.length;
        }
        obj2 = new IllegalArgumentException("bufferSize must be >= 0");
        throw obj2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    final void I(byte b) {
        final int i = this.f;
        this.f = i + 1;
        this.d[i] = b;
        this.g = obj4++;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    final void J(int i) {
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
        this.g = obj5 += 4;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    final void K(long l) {
        final byte[] bArr = this.d;
        int i = this.f;
        int i7 = i + 1;
        this.f = i7;
        int i11 = 255;
        bArr[i] = (byte)i27;
        int i2 = i7 + 1;
        this.f = i2;
        int i28 = 8;
        bArr[i7] = (byte)i31;
        int i8 = i2 + 1;
        this.f = i8;
        bArr[i2] = (byte)i35;
        int i3 = i8 + 1;
        this.f = i3;
        bArr[i8] = (byte)i13;
        int i9 = i3 + 1;
        this.f = i9;
        bArr[i3] = (byte)i17;
        int i4 = i9 + 1;
        this.f = i4;
        bArr[i9] = (byte)i21;
        int i10 = i4 + 1;
        this.f = i10;
        bArr[i4] = (byte)i25;
        this.f = i10 + 1;
        bArr[i10] = (byte)obj9;
        this.g = obj9 += i28;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    final void L(int i) {
        boolean z;
        int i3;
        byte b;
        long l;
        int i2;
        byte b2;
        int obj7;
        if (gr.l()) {
            while (obj7 & -128 == 0) {
                int i17 = this.f;
                i2 = i17 + 1;
                this.f = i2;
                j1.s(this.d, (long)i17, i2);
                obj7 >>>= 7;
            }
            int i15 = this.f;
            int i18 = i15 + 1;
            this.f = i18;
            j1.s(this.d, (long)i15, i18);
            this.g = i13 += obj7;
        }
        while (obj7 & -128 == 0) {
            i3 = this.f;
            this.f = i3 + 1;
            this.d[i3] = (byte)i10;
            this.g = i5++;
            obj7 >>>= 7;
        }
        int i7 = this.f;
        this.f = i7 + 1;
        this.d[i7] = (byte)obj7;
        this.g = obj7++;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    final void M(long l) {
        boolean z;
        int i2;
        int i3;
        byte b;
        long l2;
        int i;
        byte b2;
        int obj12;
        int i6 = 7;
        int i9 = 0;
        final int i12 = -128;
        if (gr.l()) {
            while (Long.compare(i18, i9) == 0) {
                int i19 = this.f;
                i = i19 + 1;
                this.f = i;
                j1.s(this.d, (long)i19, i);
                obj12 >>>= i6;
            }
            int i8 = this.f;
            int i11 = i8 + 1;
            this.f = i11;
            j1.s(this.d, (long)i8, i11);
            this.g = obj13 += obj12;
        }
        while (Long.compare(i13, i9) == 0) {
            i3 = this.f;
            this.f = i3 + 1;
            this.d[i3] = (byte)i17;
            this.g = i4++;
            obj12 >>>= i6;
        }
        int i7 = this.f;
        this.f = i7 + 1;
        this.d[i7] = (byte)obj12;
        this.g = obj12++;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.gr
    public final int q() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        throw unsupportedOperationException;
    }
}
