package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.a;
import com.google.android.gms.common.util.j;

/* loaded from: classes2.dex */
public final class fn {

    private final String a;
    private final String b;
    public fn(Context context, String string2) {
        String obj4;
        super();
        r.j(context);
        r.f(string2);
        this.a = string2;
        obj4 = a.a(context, string2);
        if (obj4 == null) {
            obj4 = String.valueOf(string2);
            String obj5 = "single cert required: ";
            if (obj4.length() != 0) {
                obj4 = obj5.concat(obj4);
            } else {
                obj4 = new String(obj5);
            }
            Log.e("FBA-PackageInfo", obj4);
            this.b = 0;
        }
        this.b = j.c(obj4, false);
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }
}
