package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public abstract class k1 {

    public final int a;
    public k1(int i) {
        super();
        this.a = i;
    }

    static Status e(RemoteException remoteException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(remoteException.getClass().getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append(remoteException.getLocalizedMessage());
        Status obj2 = new Status(19, stringBuilder.toString());
        return obj2;
    }

    public abstract void a(Status status);

    public abstract void b(Exception exception);

    public abstract void c(com.google.android.gms.common.api.internal.x x, boolean z2);

    public abstract void d(com.google.android.gms.common.api.internal.i0<?> i0);
}
