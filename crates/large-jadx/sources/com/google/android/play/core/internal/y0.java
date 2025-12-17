package com.google.android.play.core.internal;

import android.os.IBinder;

/* loaded from: classes2.dex */
public abstract class y0 extends com.google.android.play.core.internal.z1 implements com.google.android.play.core.internal.a1 {
    public static com.google.android.play.core.internal.a1 m(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        android.os.IInterface localInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        if (localInterface instanceof a1) {
            return (a1)localInterface;
        }
        x0 x0Var = new x0(iBinder);
        return x0Var;
    }
}
