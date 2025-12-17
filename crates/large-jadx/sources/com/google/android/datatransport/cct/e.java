package com.google.android.datatransport.cct;

/* loaded from: classes.dex */
public final class e {
    static String a(String string, String string2) {
        int i;
        int length;
        int charAt;
        length2 -= length;
        if (i2 < 0) {
        } else {
            if (i2 > 1) {
            } else {
                StringBuilder stringBuilder = new StringBuilder(length3 += charAt);
                i = 0;
                while (i < string.length()) {
                    stringBuilder.append(string.charAt(i));
                    if (string2.length() > i) {
                    }
                    i++;
                    stringBuilder.append(string2.charAt(i));
                }
                return stringBuilder.toString();
            }
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Invalid input received");
        throw obj3;
    }
}
