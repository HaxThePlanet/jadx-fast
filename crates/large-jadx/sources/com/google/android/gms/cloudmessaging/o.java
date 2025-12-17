package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class o implements Runnable {

    public final com.google.android.gms.cloudmessaging.r a;
    public final IBinder b;
    public o(com.google.android.gms.cloudmessaging.r r, IBinder iBinder2) {
        super();
        this.a = r;
        this.b = iBinder2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final com.google.android.gms.cloudmessaging.r rVar = this.a;
        IBinder iBinder = this.b;
        synchronized (rVar) {
            rVar.a(0, "Null service connection");
        }
    }
}
