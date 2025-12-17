package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

/* loaded from: classes2.dex */
final class s implements ServiceConnection {

    final com.google.android.play.core.internal.t a;
    s(com.google.android.play.core.internal.t t, com.google.android.play.core.internal.r r2) {
        this.a = t;
        super();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
        Object[] arr = new Object[1];
        t.f(this.a).d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        p pVar = new p(this, iBinder2);
        this.a.c().post(pVar);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Object[] arr = new Object[1];
        t.f(this.a).d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        q qVar = new q(this);
        this.a.c().post(qVar);
    }
}
