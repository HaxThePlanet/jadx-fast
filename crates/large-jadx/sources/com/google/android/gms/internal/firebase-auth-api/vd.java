package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
final class vd extends com.google.android.gms.internal.firebase-auth-api.vc {
    vd(char c) {
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.vc
    public final String toString() {
        int i3;
        int i4;
        int i;
        int i2;
        char charAt;
        Object str;
        char[] cArr = new char[6];
        cArr = new short[]{'\', 'u', 0, 0, 0, 0};
        i3 = 46;
        i4 = 0;
        i = 4;
        while (i4 < i) {
            cArr[i4 - 5] = "0123456789ABCDEF".charAt(i3 & 15);
            i3 >>= i;
            i4++;
            i = 4;
        }
        String copyValueOf = String.copyValueOf(cArr);
        StringBuilder stringBuilder = new StringBuilder(length += 18);
        stringBuilder.append("CharMatcher.is('");
        stringBuilder.append(copyValueOf);
        stringBuilder.append("')");
        return stringBuilder.toString();
    }
}
