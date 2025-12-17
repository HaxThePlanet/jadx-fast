package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

/* loaded from: classes2.dex */
public final class i1 implements ServiceConnection {

    private final int a;
    final com.google.android.gms.common.internal.c b;
    public i1(com.google.android.gms.common.internal.c c, int i2) {
        this.b = c;
        super();
        this.a = i2;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
        android.os.IInterface localInterface;
        boolean z;
        if (iBinder2 == null) {
            c.zzc(this.b, 16);
        }
        Object obj4 = c.zzd(this.b);
        localInterface = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        synchronized (obj4) {
            if (localInterface instanceof m) {
            } else {
                localInterface = new w0(iBinder2);
            }
            c.zze(this.b, localInterface);
            this.b.zzb(0, 0, this.a);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Object obj4 = c.zzd(this.b);
        c.zze(this.b, 0);
        obj4 = obj4.zzb;
        obj4.sendMessage(obj4.obtainMessage(6, this.a, 1));
        return;
        synchronized (obj4) {
            obj4 = c.zzd(this.b);
            c.zze(this.b, 0);
            obj4 = obj4.zzb;
            obj4.sendMessage(obj4.obtainMessage(6, this.a, 1));
        }
    }
}
