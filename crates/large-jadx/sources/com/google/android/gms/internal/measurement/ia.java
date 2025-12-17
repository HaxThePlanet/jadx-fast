package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class ia implements com.google.android.gms.internal.measurement.u9 {

    private final com.google.android.gms.internal.measurement.y9 a;
    private final String b;
    private final Object[] c;
    private final int d;
    ia(com.google.android.gms.internal.measurement.y9 y9, String string2, Object[] object3Arr3) {
        int i3;
        int i2;
        int i;
        int obj4;
        super();
        this.a = y9;
        this.b = string2;
        this.c = object3Arr3;
        obj4 = string2.charAt(0);
        final int obj6 = 55296;
        if (obj4 < obj6) {
            this.d = obj4;
        }
        obj4 &= 8191;
        i3 = 13;
        i2 = 1;
        char charAt = string2.charAt(i2);
        while (charAt >= obj6) {
            obj4 |= i5;
            i3 += 13;
            i2 = i;
            charAt = string2.charAt(i2);
        }
        this.d = obj4 |= obj5;
    }

    @Override // com.google.android.gms.internal.measurement.u9
    final String a() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.measurement.u9
    final Object[] b() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.measurement.u9
    public final com.google.android.gms.internal.measurement.y9 zza() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.measurement.u9
    public final boolean zzb() {
        final int i5 = 2;
        if (i &= i5 == i5) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.u9
    public final int zzc() {
        final int i4 = 1;
        if (i &= i4 == i4) {
            return i4;
        }
        return 2;
    }
}
