package com.google.android.gms.common.util;

import android.util.Base64;
import androidx.annotation.RecentlyNonNull;

/* loaded from: classes2.dex */
public final class c {
    public static byte[] a(String string) {
        if (string == null) {
            return null;
        }
        return Base64.decode(string, 10);
    }

    public static byte[] b(String string) {
        if (string == null) {
            return null;
        }
        return Base64.decode(string, 11);
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    public static String d(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 10);
    }

    public static String e(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 11);
    }
}
