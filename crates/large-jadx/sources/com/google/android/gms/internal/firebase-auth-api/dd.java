package com.google.android.gms.internal.firebase-auth-api;

import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public final class dd {
    public static int a() {
        try {
            return Class.forName("android.os.Build$VERSION").getDeclaredField("SDK_INT").getInt(0);
            return -1;
        }
    }

    public static boolean b() {
        Class.forName("android.app.Application", false, 0);
        return 1;
    }
}
