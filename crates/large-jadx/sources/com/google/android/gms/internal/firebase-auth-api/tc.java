package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class tc {
    public static String a(byte[] bArr) {
        int i;
        char charAt2;
        String str;
        char charAt;
        final int length = bArr.length;
        StringBuilder stringBuilder = new StringBuilder(length + length);
        i = 0;
        while (i < length) {
            b &= 255;
            str = "0123456789abcdef";
            stringBuilder.append(str.charAt(i3 >> 4));
            stringBuilder.append(str.charAt(i3 &= 15));
            i++;
        }
        return stringBuilder.toString();
    }
}
