package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.e1;

/* loaded from: classes2.dex */
public final class u0 {

    private static com.google.android.play.core.splitinstall.p0 a;
    public static com.google.android.play.core.splitinstall.p0 a(Context context) {
        Object c0Var;
        com.google.android.play.core.splitinstall.k kVar;
        Object obj3;
        final Class<com.google.android.play.core.splitinstall.u0> obj = u0.class;
        synchronized (obj) {
            c0Var = new c0(0);
            kVar = new k(e1.a(context));
            c0Var.a(kVar);
            u0.a = c0Var.b();
            return u0.a;
        }
    }
}
