package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
final class sq extends com.google.android.gms.internal.firebase-auth-api.vq {

    private final int zzc;
    sq(byte[] bArr, int i2, int i3) {
        super(bArr);
        wq.t(0, i3, bArr.length);
        this.zzc = i3;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.vq
    protected final int C() {
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.vq
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

    @Override // com.google.android.gms.internal.firebase-auth-api.vq
    final byte d(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.vq
    public final int g() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.vq
    protected final void h(byte[] bArr, int i2, int i3, int i4) {
        final int obj3 = 0;
        System.arraycopy(this.zza, obj3, bArr, obj3, i4);
    }
}
