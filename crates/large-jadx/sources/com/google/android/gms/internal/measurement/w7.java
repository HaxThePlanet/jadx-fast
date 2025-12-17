package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: classes2.dex */
class w7 extends com.google.android.gms.internal.measurement.v7 {

    protected final byte[] zza;
    w7(byte[] bArr) {
        super();
        Objects.requireNonNull(bArr);
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.v7
    public byte b(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.measurement.v7
    byte d(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.measurement.v7
    public final boolean equals(Object object) {
        boolean equals;
        boolean zza;
        byte[] zza2;
        int i;
        byte b;
        byte b2;
        int obj9;
        equals = 1;
        if (object == this) {
            return equals;
        }
        int i7 = 0;
        if (!object instanceof x7) {
            return i7;
        }
        if (g() != (x7)object.g()) {
            return i7;
        }
        if (g() == 0) {
            return equals;
        }
        int i5 = s();
        int i9 = (w7)object.s();
        if (object instanceof w7 && i5 != 0 && i9 != 0 && i5 == i9) {
            i5 = s();
            i9 = (w7)object.s();
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
                    if (object instanceof w7) {
                        object.w();
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
                        equals = object.i(i7, i6).equals(i(i7, i6));
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

    @Override // com.google.android.gms.internal.measurement.v7
    public int g() {
        return zza.length;
    }

    @Override // com.google.android.gms.internal.measurement.v7
    protected final int h(int i, int i2, int i3) {
        return d9.d(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.measurement.v7
    public final com.google.android.gms.internal.measurement.x7 i(int i, int i2) {
        final int i3 = 0;
        int obj3 = x7.q(i3, i2, g());
        if (obj3 == null) {
            return x7.a;
        }
        t7 obj4 = new t7(this.zza, i3, obj3);
        return obj4;
    }

    @Override // com.google.android.gms.internal.measurement.v7
    protected final String l(Charset charset) {
        String string = new String(this.zza, 0, g(), charset);
        return string;
    }

    @Override // com.google.android.gms.internal.measurement.v7
    final void m(com.google.android.gms.internal.measurement.q7 q7) {
        (d8)q7.E(this.zza, 0, g());
    }

    @Override // com.google.android.gms.internal.measurement.v7
    public final boolean p() {
        return mb.f(this.zza, 0, g());
    }

    @Override // com.google.android.gms.internal.measurement.v7
    protected int w() {
        return 0;
    }
}
