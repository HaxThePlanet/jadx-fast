package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
final class j0 implements com.google.android.gms.internal.firebase-auth-api.v {

    private final com.google.android.gms.internal.firebase-auth-api.y a;
    private final String b;
    private final Object[] c;
    private final int d;
    j0(com.google.android.gms.internal.firebase-auth-api.y y, String string2, Object[] object3Arr3) {
        String str;
        int i2;
        int i;
        int illegalStateException;
        int obj5;
        String obj6;
        char obj7;
        super();
        this.a = y;
        this.b = string2;
        this.c = object3Arr3;
        obj5 = 1;
        obj7 = string2.charAt(0);
        int i3 = 55296;
        if (obj7 < i3) {
            this.d = obj7;
        }
        obj7 &= 8191;
        i = 13;
        obj5 = obj6.charAt(obj5);
        while (obj5 >= i3) {
            obj7 |= obj5;
            i += 13;
            obj5 = illegalStateException;
            obj5 = obj6.charAt(obj5);
        }
        this.d = obj5 |= obj7;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.v
    final String a() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.v
    final Object[] b() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.v
    public final com.google.android.gms.internal.firebase-auth-api.y zza() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.v
    public final boolean zzb() {
        final int i5 = 2;
        if (i &= i5 == i5) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.v
    public final int zzc() {
        final int i4 = 1;
        if (i &= i4 == i4) {
            return i4;
        }
        return 2;
    }
}
