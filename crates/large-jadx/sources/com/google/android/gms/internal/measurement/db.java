package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class db implements PrivilegedExceptionAction<Unsafe> {
    public static final Unsafe a() {
        int i;
        Object obj;
        boolean instance;
        int i2;
        Class<Unsafe> obj2 = Unsafe.class;
        final Field[] declaredFields = obj2.getDeclaredFields();
        i = 0;
        int i3 = 0;
        while (i < declaredFields.length) {
            Field field = declaredFields[i];
            field.setAccessible(true);
            obj = field.get(i3);
            i++;
            i3 = 0;
        }
        return i3;
    }

    @Override // java.security.PrivilegedExceptionAction
    public final Object run() {
        return db.a();
    }
}
