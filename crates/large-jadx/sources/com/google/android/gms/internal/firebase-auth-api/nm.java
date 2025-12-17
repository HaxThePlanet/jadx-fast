package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.n;
import java.util.List;

/* loaded from: classes2.dex */
public final class nm {

    private final int a;
    public nm(String string) {
        int i3;
        int i;
        int int;
        Object list;
        int size;
        int i2;
        java.lang.CharSequence obj9;
        super();
        final int i5 = 1;
        int = -1;
        list = s1.c("[.-]").d(string);
        if (list.size() == i5) {
            int = Integer.parseInt(string);
        } else {
            if (list.size() >= 3) {
                int = size + obj9;
            }
        }
        this.a = int;
    }

    public static com.google.android.gms.internal.firebase-auth-api.nm a() {
        nm nmVar = new nm(nm.c());
        return nmVar;
    }

    static String c() {
        boolean equals;
        String str = n.a().b("firebase-auth");
        if (!TextUtils.isEmpty(str) && str.equals("UNKNOWN")) {
            if (str.equals("UNKNOWN")) {
            }
            return str;
        }
        return "-1";
    }

    public final String b() {
        Object[] arr = new Object[1];
        return String.format("X%s", Integer.toString(this.a));
    }
}
