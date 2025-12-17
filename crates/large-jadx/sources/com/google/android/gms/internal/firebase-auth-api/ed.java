package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class ed {
    static {
        int i = 4;
        Object[] arr = new Object[i];
        final int i3 = 0;
        final String str2 = "([0-9a-zA-Z\\-\\.\\_~])+";
        arr[i3] = str2;
        final int i4 = 1;
        arr[i4] = str2;
        final int i5 = 2;
        arr[i5] = str2;
        final int i6 = 3;
        arr[i6] = str2;
        Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s$", arr), i5);
        Object[] arr2 = new Object[5];
        arr2[i3] = str2;
        arr2[i4] = str2;
        arr2[i5] = str2;
        arr2[i6] = str2;
        arr2[i] = str2;
        Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/%s$", arr2), i5);
    }

    public static String a(String string, String string2) {
        String str = "android-keystore://";
        if (!string2.toLowerCase(Locale.US).startsWith(str)) {
        } else {
            return string2.substring(19);
        }
        Object[] obj3 = new Object[1];
        IllegalArgumentException obj2 = new IllegalArgumentException(String.format("key URI must start with %s", str));
        throw obj2;
    }

    public static void b(int i) {
        int i2;
        if (i != 16) {
            if (i != 32) {
            } else {
            }
            Object[] arr = new Object[1];
            InvalidAlgorithmParameterException invalidAlgorithmParameterException = new InvalidAlgorithmParameterException(String.format("invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i *= 8)));
            throw invalidAlgorithmParameterException;
        }
    }

    public static void c(int i, int i2) {
        if (i < 0) {
        } else {
            if (i > 0) {
            } else {
            }
        }
        Object[] arr = new Object[2];
        int i4 = 0;
        arr[i4] = Integer.valueOf(i);
        arr[1] = Integer.valueOf(i4);
        GeneralSecurityException obj3 = new GeneralSecurityException(String.format("key has version %d; only keys with version in range [0..%d] are supported", arr));
        throw obj3;
    }
}
