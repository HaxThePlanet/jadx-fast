package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.Signature;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.o.b;
import com.google.android.gms.common.o.c;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class a {
    static {
    }

    @Deprecated
    public static byte[] a(Context context, String string2) {
        int i;
        Signature[] obj2;
        android.content.pm.PackageInfo obj1 = c.a(context).e(string2, 64);
        obj2 = obj1.signatures;
        obj2 = a.b("SHA1");
        if (obj2 != null && obj2.length == 1 && obj2 == null) {
            if (obj2.length == 1) {
                obj2 = a.b("SHA1");
                if (obj2 == null) {
                }
                return obj2.digest(obj1.signatures[0].toByteArray());
            }
        }
        return null;
    }

    public static MessageDigest b(String string) {
        int i;
        MessageDigest instance;
        i = 0;
        while (i < 2) {
            instance = MessageDigest.getInstance(string);
            i++;
        }
        return null;
    }
}
