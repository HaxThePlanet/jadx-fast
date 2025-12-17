package com.iterable.iterableapi;

import android.content.Context;
import android.graphics.Rect;
import androidx.fragment.app.d;
import androidx.fragment.app.e;

/* loaded from: classes2.dex */
class a0 {

    private final com.iterable.iterableapi.i a;
    a0(com.iterable.iterableapi.i i) {
        super();
        this.a = i;
    }

    static boolean b(Context context, String string2, String string3, com.iterable.iterableapi.w w4, double d5, Rect rect6, boolean z7, com.iterable.iterableapi.g0.b g0$b8, boolean z9, com.iterable.iterableapi.e0 e010) {
        Object str;
        str = context;
        int i2 = 0;
        final String str4 = "IterableInAppManager";
        if (str instanceof e) {
            if (string2 != null && c0.M1() != null) {
                if (c0.M1() != null) {
                    j0.i(str4, "Skipping the in-app notification: another notification is already being displayed");
                    return i2;
                }
                c0.J1(string2, e010, w4, obj23, string3, Double.valueOf(d5), z7, b8, z9).show((e)str.getSupportFragmentManager(), "iterable_in_app");
                return 1;
            }
        } else {
            j0.i(str4, "To display in-app notifications, the context must be of an instance of: FragmentActivity");
        }
        return i2;
    }

    boolean a() {
        int i;
        i = c0.M1() != null ? 1 : 0;
        return i;
    }

    boolean c(com.iterable.iterableapi.g0 g0, com.iterable.iterableapi.e0 e02, com.iterable.iterableapi.w w3) {
        final android.app.Activity activity = this.a.k();
        if (activity != null) {
            return a0.b(activity, aVar.a, g0.i(), w3, aVar2.c, obj6, aVar3.b, cVar.a, obj13.b, 1);
        }
        return 0;
    }
}
