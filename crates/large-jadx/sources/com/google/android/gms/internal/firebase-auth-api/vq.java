package com.google.android.gms.internal.firebase-auth-api;

import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: classes2.dex */
class vq extends com.google.android.gms.internal.firebase-auth-api.uq {

    protected final byte[] zza;
    vq(byte[] bArr) {
        super();
        Objects.requireNonNull(bArr);
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uq
    protected int C() {
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uq
    public byte b(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uq
    byte d(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uq
    public final boolean equals(Object object) {
        boolean equals;
        boolean zza2;
        byte[] zza;
        int i;
        byte b;
        byte b2;
        int obj9;
        equals = 1;
        if (object == this) {
            return equals;
        }
        int i7 = 0;
        if (!object instanceof wq) {
            return i7;
        }
        if (g() != (wq)object.g()) {
            return i7;
        }
        if (g() == 0) {
            return equals;
        }
        int i5 = u();
        int i9 = (vq)object.u();
        if (object instanceof vq && i5 != 0 && i9 != 0 && i5 == i9) {
            i5 = u();
            i9 = (vq)object.u();
            if (i5 != 0) {
                if (i9 != 0) {
                    if (i5 == i9) {
                    }
                    return i7;
                }
            }
            int i6 = g();
            if (i6 > object.g()) {
            } else {
                if (i6 > object.g()) {
                } else {
                    if (object instanceof vq) {
                        object.C();
                        i = obj9;
                        while (obj9 < i6) {
                            if (this.zza[obj9] != object.zza[i]) {
                                break;
                            } else {
                            }
                            obj9++;
                            i++;
                        }
                    } else {
                        equals = object.l(i7, i6).equals(l(i7, i6));
                    }
                    return equals;
                }
                StringBuilder stringBuilder2 = new StringBuilder(59);
                stringBuilder2.append("Ran off end of other: 0, ");
                stringBuilder2.append(i6);
                stringBuilder2.append(", ");
                stringBuilder2.append(object.g());
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
                throw illegalArgumentException;
            }
            StringBuilder stringBuilder = new StringBuilder(40);
            stringBuilder.append("Length too large: ");
            stringBuilder.append(i6);
            stringBuilder.append(g());
            obj9 = new IllegalArgumentException(stringBuilder.toString());
            throw obj9;
        }
        return object.equals(this);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uq
    public int g() {
        return zza.length;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uq
    protected void h(byte[] bArr, int i2, int i3, int i4) {
        final int obj3 = 0;
        System.arraycopy(this.zza, obj3, bArr, obj3, i4);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uq
    protected final int i(int i, int i2, int i3) {
        return e.d(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uq
    public final com.google.android.gms.internal.firebase-auth-api.wq l(int i, int i2) {
        final int i3 = 0;
        int obj3 = wq.t(i3, i2, g());
        if (obj3 == null) {
            return wq.a;
        }
        sq obj4 = new sq(this.zza, i3, obj3);
        return obj4;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uq
    public final com.google.android.gms.internal.firebase-auth-api.zq m() {
        return zq.n(this.zza, 0, g(), true);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uq
    protected final String p(Charset charset) {
        String string = new String(this.zza, 0, g(), charset);
        return string;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uq
    final void q(com.google.android.gms.internal.firebase-auth-api.pq pq) {
        pq.a(this.zza, 0, g());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uq
    public final boolean s() {
        return o1.f(this.zza, 0, g());
    }
}
