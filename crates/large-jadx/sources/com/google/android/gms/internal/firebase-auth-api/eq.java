package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
final class eq extends com.google.android.gms.internal.firebase-auth-api.z0 {
    eq(com.google.android.gms.internal.firebase-auth-api.cr cr, com.google.android.gms.internal.firebase-auth-api.s1 s12, java.lang.CharSequence charSequence3) {
        super(s12, charSequence3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.z0
    final int d(int i) {
        return i++;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.z0
    final int e(int i) {
        int length;
        char charAt;
        int i2;
        Object[] arr;
        int obj8;
        java.lang.CharSequence charSequence = this.c;
        length = charSequence.length();
        if (i >= 0 && i > length) {
            if (i > length) {
            }
            return obj8;
        }
        String str = "index";
        int i4 = 0;
        final int i5 = 2;
        final int i6 = 1;
        if (i >= 0) {
            if (length < 0) {
                StringBuilder stringBuilder = new StringBuilder(26);
                stringBuilder.append("negative size: ");
                stringBuilder.append(length);
                obj8 = new IllegalArgumentException(stringBuilder.toString());
                throw obj8;
            }
            arr = new Object[3];
            arr[i4] = str;
            arr[i6] = Integer.valueOf(i);
            arr[i5] = Integer.valueOf(length);
            obj8 = t1.b("%s (%s) must not be greater than size (%s)", arr);
        } else {
            length = new Object[i5];
            length[i4] = str;
            length[i6] = Integer.valueOf(i);
            obj8 = t1.b("%s (%s) must not be negative", length);
        }
        super(obj8);
        throw indexOutOfBoundsException;
    }
}
