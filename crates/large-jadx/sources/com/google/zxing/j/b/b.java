package com.google.zxing.j.b;

/* loaded from: classes2.dex */
final class b {

    private final byte[] a;
    private int b = 0;
    b(int i) {
        super();
        this.a = new byte[i];
        int obj1 = 0;
    }

    private void c(int i, boolean z2) {
        this.a[i] = (byte)z2;
    }

    void a(boolean z, int i2) {
        int i4;
        int i;
        int i3;
        i4 = 0;
        while (i4 < i2) {
            i = this.b;
            this.b = i + 1;
            c(i, z);
            i4++;
        }
    }

    byte[] b(int i) {
        int i3;
        byte b;
        int i2;
        length *= i;
        final byte[] bArr2 = new byte[i4];
        i3 = 0;
        while (i3 < i4) {
            bArr2[i3] = this.a[i3 / i];
            i3++;
        }
        return bArr2;
    }
}
