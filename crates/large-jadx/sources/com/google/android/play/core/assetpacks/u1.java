package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.e1;

/* loaded from: classes2.dex */
public final class u1 {

    private static com.google.android.play.core.assetpacks.d a;
    static com.google.android.play.core.assetpacks.d a(Context context) {
        Object x0Var;
        com.google.android.play.core.assetpacks.u3 u3Var;
        Object obj3;
        final Class<com.google.android.play.core.assetpacks.u1> obj = u1.class;
        synchronized (obj) {
            x0Var = new x0(0);
            u3Var = new u3(e1.a(context));
            x0Var.b(u3Var);
            u1.a = x0Var.a();
            return u1.a;
        }
    }
}
