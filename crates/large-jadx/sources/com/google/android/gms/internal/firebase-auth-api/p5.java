package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.CharConversionException;
import java.io.FileNotFoundException;

/* loaded from: classes2.dex */
public final class p5 {

    private final SharedPreferences a;
    private final String b;
    public p5(Context context, String string2, String string3) {
        super();
        this.b = "GenericIdpKeyset";
        Context obj1 = context.getApplicationContext();
        if (string3 == null) {
            this.a = PreferenceManager.getDefaultSharedPreferences(obj1);
        }
        this.a = obj1.getSharedPreferences(string3, 0);
    }

    private final byte[] c() {
        int i2;
        byte b;
        int i;
        int i3;
        final int i4 = 0;
        String string = this.a.getString(this.b, 0);
        if (string == null) {
        } else {
            if (length %= 2 != 0) {
            } else {
                try {
                    length2 /= 2;
                    byte[] bArr = new byte[i7];
                    i2 = i4;
                    while (i2 < i7) {
                        int i9 = i2 + i2;
                        int i12 = 16;
                        int digit2 = Character.digit(string.charAt(i9), i12);
                        int digit = Character.digit(string.charAt(i9++), i12);
                        i3 = -1;
                        bArr[i2] = (byte)i;
                        i2++;
                    }
                    i9 = i2 + i2;
                    i12 = 16;
                    digit2 = Character.digit(string.charAt(i9), i12);
                    digit = Character.digit(string.charAt(i9++), i12);
                    i3 = -1;
                    if (digit2 == i3) {
                    } else {
                    }
                    if (digit == i3) {
                    } else {
                    }
                    bArr[i2] = (byte)i;
                    i2++;
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("input is not hexadecimal");
                    throw illegalArgumentException;
                    return bArr;
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Expected a string of even length");
                    throw illegalArgumentException2;
                    Object[] arr2 = new Object[1];
                    arr2[i4] = this.b;
                    FileNotFoundException fileNotFoundException = new FileNotFoundException(String.format("can't read keyset; the pref value %s does not exist", arr2));
                    throw fileNotFoundException;
                    int arr = new Object[arr];
                    arr[format] = this.b;
                    int format = "can't read keyset; the pref value %s is not a valid hex string";
                    format = String.format(format, arr);
                    CharConversionException charConversionException = new CharConversionException(format);
                    throw charConversionException;
                }
            }
        }
    }

    public final com.google.android.gms.internal.firebase-auth-api.j9 a() {
        return j9.B(c(), lr.a());
    }

    public final com.google.android.gms.internal.firebase-auth-api.na b() {
        return na.E(c(), lr.a());
    }
}
