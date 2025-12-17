package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* loaded from: classes2.dex */
public final class o7 {
    public static Object a(Object object) {
        Throwable th;
        Object obj;
        if (object != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream obj4 = new ObjectInputStream(byteArrayInputStream);
            objectOutputStream.close();
            obj4.close();
            return obj4.readObject();
        }
        return null;
    }

    public static String b(String string, String[] string2Arr2, String[] string3Arr3) {
        int i;
        boolean equals;
        r.j(string2Arr2);
        r.j(string3Arr3);
        i = 0;
        while (i < Math.min(string2Arr2.length, string3Arr3.length)) {
            equals = string2Arr2[i];
            i++;
        }
        return null;
    }

    public static String c(Context context, String string2, String string3) {
        Object obj3;
        r.j(context);
        if (!TextUtils.isEmpty(string3)) {
        } else {
            obj3 = u4.a(context);
        }
        return u4.b("google_app_id", context.getResources(), obj3);
    }
}
