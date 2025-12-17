package com.google.android.gms.internal.firebase-auth-api;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class f1 implements PrivilegedExceptionAction<Unsafe> {
    public static final Unsafe a() {
        int i2;
        Object obj;
        boolean instance;
        int i;
        Class<Unsafe> obj2 = Unsafe.class;
        final Field[] declaredFields = obj2.getDeclaredFields();
        i2 = 0;
        int i3 = 0;
        while (i2 < declaredFields.length) {
            Field field = declaredFields[i2];
            field.setAccessible(true);
            obj = field.get(i3);
            i2++;
            i3 = 0;
        }
        return i3;
    }

    @Override // java.security.PrivilegedExceptionAction
    public final Object run() {
        return f1.a();
    }
}
