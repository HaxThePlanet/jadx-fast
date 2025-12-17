package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import f.c.a.d.b.i.a;
import f.c.a.d.b.i.c;
import f.c.a.d.b.i.d;

/* loaded from: classes.dex */
final class s implements ServiceConnection {

    private final Object a;
    private boolean b = false;
    private com.android.billingclient.api.e c;
    final com.android.billingclient.api.d v;
    s(com.android.billingclient.api.d d, com.android.billingclient.api.e e2, com.android.billingclient.api.t0 t03) {
        this.v = d;
        super();
        Object obj1 = new Object();
        this.a = obj1;
        obj1 = 0;
        this.c = e2;
    }

    private final void d(com.android.billingclient.api.g g) {
        final Object obj = this.a;
        final com.android.billingclient.api.e eVar = this.c;
        synchronized (obj) {
            eVar.onBillingSetupFinished(g);
        }
    }

    @Override // android.content.ServiceConnection
    public final Object a() {
        int str5;
        com.android.billingclient.api.d dVar2;
        com.android.billingclient.api.g gVar;
        int i2;
        Object packageName;
        int str;
        int i12;
        int i3;
        int i6;
        int i;
        int i5;
        int i8;
        int i11;
        int i9;
        int str4;
        int i13;
        int i10;
        d dVar;
        Object str6;
        String str2;
        int i4;
        int str3;
        int i7;
        Object obj2 = this.a;
        final int i15 = 0;
        synchronized (obj2) {
            return i15;
        }
        try {
            while (str4 >= str5) {
                str4--;
            }
            if (d.E(this.v).D0(str4, packageName, "subs") == 0) {
            } else {
            }
            str4--;
            Object obj = obj3;
            str4 = i2;
            i7 = 1;
            i4 = i7;
        } catch (Exception e) {
        }
        String str7 = "BillingClient";
        a.k(str7, "Exception while checking if billing is supported; try to reconnect");
        str7 = this.v;
        d.w(str7, i14);
        int i14 = this.v;
        d.F(i14, obj2);
        if (i10 == 0) {
            d(w.l);
        } else {
            d(w.a);
        }
        return i15;
    }

    @Override // android.content.ServiceConnection
    public final void b() {
        d.w(this.v, 0);
        d.F(this.v, 0);
        d(w.n);
    }

    @Override // android.content.ServiceConnection
    final void c() {
        final Object obj = this.a;
        this.c = 0;
        this.b = true;
        return;
        synchronized (obj) {
            obj = this.a;
            this.c = 0;
            this.b = true;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
        Object obj7;
        a.j("BillingClient", "Billing service connected.");
        d.F(this.v, c.j(iBinder2));
        com.android.billingclient.api.d dVar = this.v;
        r rVar = new r(this);
        q qVar = new q(this);
        if (d.K(dVar, rVar, 30000, obj3, qVar) == null) {
            d(d.C(this.v));
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        a.k("BillingClient", "Billing service disconnected.");
        d.F(this.v, 0);
        d.w(this.v, 0);
        Object obj2 = this.a;
        com.android.billingclient.api.e eVar = this.c;
        synchronized (obj2) {
            eVar.onBillingServiceDisconnected();
        }
    }
}
