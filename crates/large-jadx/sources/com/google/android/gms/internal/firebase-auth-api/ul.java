package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.l.a;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public final class ul {
    public static String a(com.google.android.gms.internal.firebase-auth-api.vl vl, String string2) {
        String valueOf;
        int i;
        boolean z;
        boolean z2;
        valueOf = new String(MessageDigest.getInstance("SHA-256").digest(string2.getBytes()));
        int obj5 = valueOf.length();
        i = obj4;
        try {
            while (i < obj5) {
                if (xb.a(valueOf.charAt(i))) {
                    break;
                } else {
                }
                i++;
            }
            if (xb.a(valueOf.charAt(i))) {
            } else {
            }
            char[] charArray = valueOf.toCharArray();
            while (i < obj5) {
                z = charArray[i];
                if (xb.a(z)) {
                }
                i++;
                charArray[i] = (char)i2;
            }
            z = charArray[i];
            if (xb.a(z)) {
            }
            charArray[i] = (char)i2;
            i++;
            valueOf = String.valueOf(charArray);
            i++;
            return valueOf;
            string2 = vl.g;
            vl = new Object[vl];
            string2.c("Failed to get SHA-256 MessageDigest", vl);
            vl = 0;
            return vl;
        }
    }
}
