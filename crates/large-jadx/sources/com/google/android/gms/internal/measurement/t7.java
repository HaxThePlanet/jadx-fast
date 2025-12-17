package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class t7 extends com.google.android.gms.internal.measurement.w7 {

    private final int zzc;
    t7(byte[] bArr, int i2, int i3) {
        super(bArr);
        x7.q(0, i3, bArr.length);
        this.zzc = i3;
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final byte b(int i) {
        int zzc = this.zzc;
        if (i3 |= i < 0 && i < 0) {
            if (i < 0) {
                StringBuilder stringBuilder = new StringBuilder(22);
                stringBuilder.append("Index < 0: ");
                stringBuilder.append(i);
                ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(stringBuilder.toString());
                throw arrayIndexOutOfBoundsException;
            }
            StringBuilder stringBuilder2 = new StringBuilder(40);
            stringBuilder2.append("Index > length: ");
            stringBuilder2.append(i);
            stringBuilder2.append(", ");
            stringBuilder2.append(zzc);
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
            throw arrayIndexOutOfBoundsException2;
        }
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.measurement.w7
    final byte d(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final int g() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.w7
    protected final int w() {
        return 0;
    }
}
