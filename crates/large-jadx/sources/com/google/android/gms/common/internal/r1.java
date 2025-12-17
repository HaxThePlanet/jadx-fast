package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.n.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class r1 implements ServiceConnection, com.google.android.gms.common.internal.u1 {

    private final Map<ServiceConnection, ServiceConnection> a;
    private int b = 2;
    private boolean c;
    private IBinder v;
    private final com.google.android.gms.common.internal.p1 w;
    private ComponentName x;
    final com.google.android.gms.common.internal.t1 y;
    public r1(com.google.android.gms.common.internal.t1 t1, com.google.android.gms.common.internal.p1 p12) {
        this.y = t1;
        super();
        this.w = p12;
        HashMap obj1 = new HashMap();
        this.a = obj1;
        obj1 = 2;
    }

    @Override // android.content.ServiceConnection
    public final void a(String string) {
        this.b = 3;
        final android.content.Context context2 = t1.h(this.y);
        boolean obj8 = t1.i(this.y).d(context2, string, this.w.d(t1.h(this.y)), this, this.w.c());
        this.c = obj8;
        if (obj8 != null) {
            t1.g(this.y).sendMessageDelayed(t1.g(this.y).obtainMessage(1, this.w), t1.j(this.y));
        }
        this.b = 2;
        t1.i(this.y).c(t1.h(this.y), this);
    }

    @Override // android.content.ServiceConnection
    public final void b(String string) {
        t1.g(this.y).removeMessages(1, this.w);
        t1.i(this.y).c(t1.h(this.y), this);
        this.c = false;
        this.b = 2;
    }

    @Override // android.content.ServiceConnection
    public final void c(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String string3) {
        this.a.put(serviceConnection, serviceConnection2);
    }

    @Override // android.content.ServiceConnection
    public final void d(ServiceConnection serviceConnection, String string2) {
        this.a.remove(serviceConnection);
    }

    @Override // android.content.ServiceConnection
    public final boolean e() {
        return this.c;
    }

    @Override // android.content.ServiceConnection
    public final int f() {
        return this.b;
    }

    @Override // android.content.ServiceConnection
    public final boolean g(ServiceConnection serviceConnection) {
        return this.a.containsKey(serviceConnection);
    }

    @Override // android.content.ServiceConnection
    public final boolean h() {
        return this.a.isEmpty();
    }

    @Override // android.content.ServiceConnection
    public final IBinder i() {
        return this.v;
    }

    @Override // android.content.ServiceConnection
    public final ComponentName j() {
        return this.x;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
        com.google.android.gms.common.internal.p1 next;
        HashMap map = t1.f(this.y);
        final int i = 1;
        t1.g(this.y).removeMessages(i, this.w);
        this.v = iBinder2;
        this.x = componentName;
        Iterator iterator = this.a.values().iterator();
        synchronized (map) {
            for (ServiceConnection next : iterator) {
                next.onServiceConnected(componentName, iBinder2);
            }
            this.b = i;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        int next;
        HashMap map = t1.f(this.y);
        t1.g(this.y).removeMessages(1, this.w);
        this.v = 0;
        this.x = componentName;
        Iterator iterator = this.a.values().iterator();
        synchronized (map) {
            for (ServiceConnection next : iterator) {
                next.onServiceDisconnected(componentName);
            }
            this.b = 2;
        }
    }
}
