package com.google.android.play.core.internal;

import android.os.IBinder;

/* loaded from: classes2.dex */
public abstract class c extends com.google.android.play.core.internal.z1 implements com.google.android.play.core.internal.d {
    public static com.google.android.play.core.internal.d m(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        android.os.IInterface localInterface = iBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
        if (localInterface instanceof d) {
            return (d)localInterface;
        }
        b bVar = new b(iBinder);
        return bVar;
    }
}
