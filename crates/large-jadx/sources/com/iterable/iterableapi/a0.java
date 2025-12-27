package com.iterable.iterableapi;

import android.content.Context;
import android.graphics.Rect;
import androidx.fragment.app.d;
import androidx.fragment.app.e;

/* compiled from: IterableInAppDisplayer.java */
/* loaded from: classes2.dex */
class a0 {

    private final i a;
    a0(i iVar) {
        super();
        this.a = iVar;
    }

    static boolean b(Context context, String str, String str2, w wVar, double d, Rect rect, boolean z, g0.b bVar, boolean z2, e0 e0Var) {
        Object context2 = context;
        z2 = false;
        final String str6 = "IterableInAppManager";
        if (context2 instanceof e) {
            if (str != null && c0.M1() != null) {
                j0.i(str6, "Skipping the in-app notification: another notification is already being displayed");
                return false;
            }
        } else {
            str = "To display in-app notifications, the context must be of an instance of: FragmentActivity";
            j0.i(str6, str);
        }
        return false;
    }

    boolean a() {
        boolean z = true;
        int r0 = c0.M1() != null ? 1 : 0;
        return (c0.M1() != null ? 1 : 0);
    }

    boolean c(g0 g0Var, e0 e0Var, w wVar) {
        final android.app.Activity activity = this.a.k();
        if (activity != null) {
            return a0.b(activity, g0Var.e().a, g0Var.i(), wVar, g0Var.e().c, g0Var.e().b, g0Var.e().d.a, g0Var.e().d.b, true, e0Var);
        }
        return false;
    }
}
