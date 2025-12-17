package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.c.a;
import com.google.android.gms.common.internal.c.b;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.n.a;

/* loaded from: classes2.dex */
public final class v8 implements ServiceConnection, c.a, c.b {

    private volatile boolean a;
    private volatile com.google.android.gms.measurement.internal.m3 b;
    final com.google.android.gms.measurement.internal.w8 c;
    protected v8(com.google.android.gms.measurement.internal.w8 w8) {
        this.c = w8;
        super();
    }

    static void a(com.google.android.gms.measurement.internal.v8 v8, boolean z2) {
        v8.a = false;
    }

    @Override // android.content.ServiceConnection
    public final void b(Intent intent) {
        this.c.h();
        synchronized (this) {
            obj5.a.b().v().a("Connection attempt already in progress");
        }
    }

    @Override // android.content.ServiceConnection
    public final void c() {
        boolean connecting;
        this.c.h();
        synchronized (this) {
            w8Var3.a.b().v().a("Connection attempt already in progress");
        }
    }

    @Override // android.content.ServiceConnection
    public final void d() {
        boolean connecting;
        if (this.b != null) {
            if (!this.b.isConnected()) {
                if (this.b.isConnecting()) {
                    this.b.disconnect();
                }
            } else {
            }
        }
        this.b = 0;
    }

    @Override // android.content.ServiceConnection
    public final void j(int i) {
        r.e("MeasurementServiceConnection.onConnectionSuspended");
        obj2.a.b().q().a("Service connection suspended");
        t8 t8Var = new t8(this);
        obj2.a.a().z(t8Var);
    }

    @Override // android.content.ServiceConnection
    public final void m(b b) {
        Object q3Var;
        String str;
        r.e("MeasurementServiceConnection.onConnectionFailed");
        q3Var = w8Var.a.E();
        if (q3Var != null) {
            q3Var.w().b("Service connection failed", b);
        }
        this.a = false;
        this.b = 0;
        u8 u8Var = new u8(this);
        obj3.a.a().z(u8Var);
        return;
        synchronized (this) {
            this.a = false;
            this.b = 0;
            u8Var = new u8(this);
            obj3.a.a().z(u8Var);
        }
    }

    @Override // android.content.ServiceConnection
    public final void n(Bundle bundle) {
        android.os.IInterface obj3;
        r.e("MeasurementServiceConnection.onConnected");
        r.j(this.b);
        s8 s8Var = new s8(this, (g3)this.b.getService());
        w8Var.a.a().z(s8Var);
        synchronized (this) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
        android.os.IInterface i;
        android.os.IInterface localInterface;
        String interfaceDescriptor;
        boolean str;
        Object obj4;
        com.google.android.gms.measurement.internal.o3 obj5;
        r.e("MeasurementServiceConnection.onServiceConnected");
        obj4 = 0;
        synchronized (this) {
            this.a = obj4;
            obj4.a.b().r().a("Service connected with null binder");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        r.e("MeasurementServiceConnection.onServiceDisconnected");
        w8Var.a.b().q().a("Service disconnected");
        r8 r8Var = new r8(this, componentName);
        w8Var2.a.a().z(r8Var);
    }
}
