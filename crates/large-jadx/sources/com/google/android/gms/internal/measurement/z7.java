package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class z7 extends com.google.android.gms.internal.measurement.b8 {

    private int b = 0;
    private int c;
    private int d = Integer.MAX_VALUE;
    z7(byte[] bArr, int i2, int i3, boolean z4, com.google.android.gms.internal.measurement.y7 y75) {
        super(0);
        int obj1 = Integer.MAX_VALUE;
        obj1 = 0;
    }

    @Override // com.google.android.gms.internal.measurement.b8
    public final int c(int i) {
        final int i2 = 0;
        this.d = i2;
        i3 += i5;
        this.b = i4;
        if (i4 > 0) {
            this.c = i4;
            this.b = i2;
        } else {
            this.c = i2;
        }
        return this.d;
    }
}
