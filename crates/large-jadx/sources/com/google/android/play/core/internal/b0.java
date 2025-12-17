package com.google.android.play.core.internal;

import android.os.Build.VERSION;

/* loaded from: classes2.dex */
public final class b0 {
    public static com.google.android.play.core.internal.z a() {
        int pREVIEW_SDK_INT;
        pREVIEW_SDK_INT = Build.VERSION.SDK_INT;
        if (pREVIEW_SDK_INT < 21) {
        } else {
            switch (pREVIEW_SDK_INT) {
                case 21:
                    g0 g0Var = new g0();
                    return g0Var;
                case 22:
                    h0 h0Var = new h0();
                    return h0Var;
                case 23:
                    l0 l0Var = new l0();
                    return l0Var;
                case 24:
                    m0 m0Var = new m0();
                    return m0Var;
                case 25:
                    n0 n0Var = new n0();
                    return n0Var;
                case 26:
                    q0 q0Var = new q0();
                    return q0Var;
                case 27:
                    r0 r0Var = new r0();
                    return r0Var;
                default:
            }
            t0 t0Var = new t0();
            return t0Var;
        }
        AssertionError assertionError = new AssertionError("Unsupported Android Version");
        throw assertionError;
    }
}
