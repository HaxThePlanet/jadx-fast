package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
final class x0 {
    static String a(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        int i;
        String str;
        int i2;
        int i3;
        StringBuilder stringBuilder = new StringBuilder(wq.g());
        i = 0;
        while (i < wq.g()) {
            byte b = wq.b(i);
            if (b != 34) {
            } else {
            }
            stringBuilder.append("\\\"");
            i++;
            if (b != 39) {
            } else {
            }
            stringBuilder.append("\\'");
            i2 = 92;
            if (b != i2) {
            } else {
            }
            stringBuilder.append("\\\\");
            if (b >= 32 && b <= 126) {
            } else {
            }
            stringBuilder.append(i2);
            stringBuilder.append((char)i10);
            stringBuilder.append((char)i13);
            stringBuilder.append((char)i7);
            if (b <= 126) {
            } else {
            }
            stringBuilder.append((char)b);
            stringBuilder.append("\\r");
            stringBuilder.append("\\f");
            stringBuilder.append("\\v");
            stringBuilder.append("\\n");
            stringBuilder.append("\\t");
            stringBuilder.append("\\b");
            stringBuilder.append("\\a");
        }
        return stringBuilder.toString();
    }
}
