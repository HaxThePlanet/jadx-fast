package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.c;
import java.util.List;

/* loaded from: classes2.dex */
public final class vo {
    public static long a(String string) {
        String obj4;
        r.f(string);
        List list = s1.b('.').d(string);
        if (list.size() < 2) {
            obj4 = String.valueOf(string);
            String str3 = "Invalid idToken ";
            if (obj4.length() != 0) {
                obj4 = str3.concat(obj4);
            } else {
                obj4 = new String(str3);
            }
            RuntimeException runtimeException2 = new RuntimeException(obj4);
            throw runtimeException2;
        }
        String string2 = new String(c.b((String)list.get(1)), "UTF-8");
        obj4 = wo.a(string2);
        return longValue -= longValue2;
    }
}
