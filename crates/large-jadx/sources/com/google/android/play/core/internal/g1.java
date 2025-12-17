package com.google.android.play.core.internal;

import android.util.Base64;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public final class g1 {
    public static String a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            return Base64.encodeToString(instance.digest(), 11);
            bArr = "";
            return bArr;
        }
    }
}
