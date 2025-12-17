package com.google.android.play.core.internal;

import android.os.IBinder;

/* loaded from: classes2.dex */
public abstract class h2 extends com.google.android.play.core.internal.z1 implements com.google.android.play.core.internal.i2 {
    public static com.google.android.play.core.internal.i2 m(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        android.os.IInterface localInterface = iBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
        if (localInterface instanceof i2) {
            return (i2)localInterface;
        }
        g2 g2Var = new g2(iBinder);
        return g2Var;
    }
}
