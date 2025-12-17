package com.google.android.play.core.internal;

import android.os.IBinder;

/* loaded from: classes2.dex */
public abstract class c2 extends com.google.android.play.core.internal.z1 implements com.google.android.play.core.internal.d2 {
    public static com.google.android.play.core.internal.d2 m(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        android.os.IInterface localInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        if (localInterface instanceof d2) {
            return (d2)localInterface;
        }
        b2 b2Var = new b2(iBinder);
        return b2Var;
    }
}
