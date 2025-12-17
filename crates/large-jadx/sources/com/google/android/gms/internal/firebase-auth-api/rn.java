package com.google.android.gms.internal.firebase-auth-api;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class rn {
    public static String a(String string) {
        Class<String> assignableFrom;
        Object declaredMethod;
        assignableFrom = String.class;
        final int i = 0;
        int i2 = 1;
        final Class[] arr2 = new Class[i2];
        final int i3 = 0;
        arr2[i3] = assignableFrom;
        Object[] arr = new Object[i2];
        arr[i3] = string;
        final Object obj7 = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", arr2).invoke(i, arr);
        if (obj7 != null && assignableFrom.isAssignableFrom(obj7.getClass())) {
            if (assignableFrom.isAssignableFrom(obj7.getClass())) {
                return (String)obj7;
            }
        }
        return i;
    }
}
