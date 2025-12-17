package com.google.android.gms.internal.firebase-auth-api;

import android.content.res.Configuration;
import com.google.firebase.firestore.local.k1;
import com.google.firebase.inappmessaging.CommonTypesProto.1;
import com.google.firebase.inappmessaging.display.R.style;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* loaded from: classes2.dex */
public final class zc implements com.google.android.gms.internal.firebase-auth-api.c6 {

    private final java.lang.ThreadLocal<Mac> a;
    private final String b;
    private final Key c;
    private final int d;
    public zc(String string, Key key2) {
        int obj6;
        int obj7;
        super();
        yc ycVar = new yc(this);
        this.a = ycVar;
        this.b = string;
        this.c = key2;
        if (obj7.length < 16) {
        } else {
            int i2 = 4;
            final int i3 = 3;
            final int i4 = 2;
            final int i5 = 1;
            switch (string) {
                case "HMACSHA1":
                    obj7 = 0;
                    obj7 = -1;
                    break;
                case "HMACSHA224":
                    obj7 = i5;
                    obj7 = -1;
                    break;
                case "HMACSHA256":
                    obj7 = i4;
                    obj7 = -1;
                    break;
                case "HMACSHA384":
                    obj7 = i3;
                    obj7 = -1;
                    break;
                case "HMACSHA512":
                    obj7 = i2;
                    obj7 = -1;
                    break;
                default:
                    obj7 = -1;
            }
            if (obj7 != null) {
                if (obj7 != i5) {
                    if (obj7 != i4) {
                        if (obj7 != i3) {
                            if (obj7 != i2) {
                                String str = "unknown Hmac algorithm: ";
                                if (string.length() != 0) {
                                    obj6 = str.concat(string);
                                } else {
                                    obj6 = new String(str);
                                }
                                obj7 = new NoSuchAlgorithmException(obj6);
                                throw obj7;
                            }
                            this.d = 64;
                        } else {
                            obj6 = 48;
                            this.d = obj6;
                        }
                    } else {
                        obj6 = 32;
                    }
                } else {
                    obj6 = 28;
                }
            } else {
                obj6 = 20;
            }
            ycVar.get();
        }
        obj6 = new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        throw obj6;
    }

    static String b(com.google.android.gms.internal.firebase-auth-api.zc zc) {
        return zc.b;
    }

    static Key c(com.google.android.gms.internal.firebase-auth-api.zc zc) {
        return zc.c;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.c6
    public final byte[] a(byte[] bArr, int i2) {
        if (i2 > this.d) {
        } else {
            (Mac)this.a.get().update(bArr);
            return Arrays.copyOf((Mac)this.a.get().doFinal(), i2);
        }
        InvalidAlgorithmParameterException obj2 = new InvalidAlgorithmParameterException("tag size too big");
        throw obj2;
    }
}
