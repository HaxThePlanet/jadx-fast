package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class va {
    static String a(com.google.android.gms.internal.measurement.x7 x7) {
        int i;
        String str;
        int i2;
        int i3;
        StringBuilder stringBuilder = new StringBuilder(x7.g());
        i = 0;
        while (i < x7.g()) {
            byte b = x7.b(i);
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
