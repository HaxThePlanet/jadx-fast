package com.google.android.gms.dynamic;

import android.os.IInterface;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.r;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public final class b<T>  extends com.google.android.gms.dynamic.a.a {

    private final T a;
    private b(T t) {
        super();
        this.a = t;
    }

    public static <T> T n(com.google.android.gms.dynamic.a a) {
        int i;
        int i3;
        int i2;
        Field field;
        boolean synthetic;
        if (a instanceof b) {
            return a.a;
        }
        android.os.IBinder obj7 = (b)a.asBinder();
        Field[] declaredFields = obj7.getClass().getDeclaredFields();
        i = 0;
        i2 = i3;
        while (i3 < declaredFields.length) {
            field = declaredFields[i3];
            if (!field.isSynthetic()) {
            }
            i3++;
            i2++;
            i = field;
        }
        int i4 = 1;
        if (i2 != i4) {
        } else {
            r.j(i);
            if (i.isAccessible()) {
            } else {
                i.setAccessible(i4);
                return i.get(obj7);
            }
            obj7 = new IllegalArgumentException("IObjectWrapper declared field not private!");
            throw obj7;
        }
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("Unexpected number of IObjectWrapper declared fields: ");
        stringBuilder.append(declaredFields.length);
        obj7 = new IllegalArgumentException(stringBuilder.toString());
        throw obj7;
    }

    public static <T> com.google.android.gms.dynamic.a p2(T t) {
        b bVar = new b(t);
        return bVar;
    }
}
