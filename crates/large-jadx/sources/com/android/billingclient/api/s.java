package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import f.c.a.d.b.i.a;
import f.c.a.d.b.i.c;
import f.c.a.d.b.i.d;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
final class s implements ServiceConnection {

    private final Object a = new Object();
    private boolean b = false;
    private e c;
    final /* synthetic */ d v;
    private final void d(g gVar) {
        synchronized (obj2) {
            try {
                if (this.c != null) {
                    this.c.onBillingSetupFinished(gVar);
                }
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public final /* synthetic */ Object a() {
        int i3;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        int i2;
        int i;
        d dVar2;
        com.android.billingclient.api.d dVar3;
        String str;
        boolean z10;
        boolean z;
        boolean z11 = true;
        synchronized (obj2) {
            try {
                final d dVar6 = null;
                if (this.b) {
                    return dVar6;
                }
            } catch (Exception unused) {
                String str3 = "BillingClient";
                a.k(str3, "Exception while checking if billing is supported; try to reconnect");
                this.v.a = i6;
                this.v.f = dVar5;
            }
        }
        i = 3;
        i2 = 0;
        try {
            String packageName = this.v.e.getPackageName();
        } catch (Exception unused) {
            str3 = "BillingClient";
            a.k(this.v, "Exception while checking if billing is supported; try to reconnect");
            this.v.a = this.v;
            this.v.f = dVar5;
        }
        i2 = 16;
        while (i2 >= this.a) {
            try {
                str = "subs";
                int i4 = 1;
                int r8 = i2 >= 5 ? i4 : i2;
                this.v.i = (i2 >= 5 ? i4 : i2);
                r8 = i2 >= this.a ? i4 : i2;
                this.v.h = (i2 >= this.a ? i4 : i2);
                if (i2 < this.a) {
                    a.j("BillingClient", "In-app billing API does not support subscription on this device.");
                }
                while (i2 >= this.a) {
                    if (this.v.f.D0(i2, packageName, "inapp") == 0) {
                        break;
                    } else {
                        i2 = i2 - 1;
                        while (i2 >= this.a) {
                            if (this.v.f.D0(i2, packageName, "inapp") == 0) {
                                break;
                            }
                        }
                        String str5 = this.v.j >= i2 ? i4 : i2;
                        this.v.r = (this.v.j >= i2 ? i4 : i2);
                        str5 = d.u(this.v) >= 15 ? i4 : i2;
                        this.v.q = (d.u(this.v) >= 15 ? i4 : i2);
                        str5 = d.u(this.v) >= 14 ? i4 : i2;
                        this.v.p = (d.u(this.v) >= 14 ? i4 : i2);
                        str5 = d.u(this.v) >= 12 ? i4 : i2;
                        this.v.o = (d.u(this.v) >= 12 ? i4 : i2);
                        str5 = d.u(this.v) >= 10 ? i4 : i2;
                        this.v.n = (d.u(this.v) >= 10 ? i4 : i2);
                        str5 = d.u(this.v) >= 9 ? i4 : i2;
                        this.v.m = (d.u(this.v) >= 9 ? i4 : i2);
                        str5 = d.u(this.v) >= 8 ? i4 : i2;
                        this.v.l = (d.u(this.v) >= 8 ? i4 : i2);
                        if (d.u(this.v) < 6) {
                        }
                        this.v.k = z11;
                        if (this.v.j < this.a) {
                            a.k("BillingClient", "In-app billing API version 3 is not supported on this device.");
                        }
                        if (i == 0) {
                            i3 = 2;
                            this.v.a = i3;
                        } else {
                            this.v.a = i2;
                            this.v.f = dVar6;
                        }
                        if (i == 0) {
                            d(w.l);
                        } else {
                            d(w.a);
                        }
                        return dVar6;
                    }
                }
                this.v.j = i2;
                str5 = this.v.j >= i2 ? i4 : i2;
                this.v.r = (this.v.j >= i2 ? i4 : i2);
                str5 = d.u(this.v) >= 15 ? i4 : i2;
                this.v.q = (d.u(this.v) >= 15 ? i4 : i2);
                str5 = d.u(this.v) >= 14 ? i4 : i2;
                this.v.p = (d.u(this.v) >= 14 ? i4 : i2);
                str5 = d.u(this.v) >= 12 ? i4 : i2;
                this.v.o = (d.u(this.v) >= 12 ? i4 : i2);
                str5 = d.u(this.v) >= 10 ? i4 : i2;
                this.v.n = (d.u(this.v) >= 10 ? i4 : i2);
                str5 = d.u(this.v) >= 9 ? i4 : i2;
                this.v.m = (d.u(this.v) >= 9 ? i4 : i2);
                str5 = d.u(this.v) >= 8 ? i4 : i2;
                this.v.l = (d.u(this.v) >= 8 ? i4 : i2);
                this.v.k = z11;
                i3 = 2;
                this.v.a = i3;
                this.v.a = i2;
                this.v.f = dVar6;
            } catch (Exception unused) {
                Object obj = obj;
            }
        }
    }

    public final /* synthetic */ void b() {
        this.v.a = 0;
        this.v.f = 0;
        d(w.n);
    }

    final void c() {
        synchronized (obj2) {
            try {
                this.c = null;
                this.b = true;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a.j("BillingClient", "Billing service connected.");
        this.v.f = c.j(iBinder);
        if (d.K(this.v, new r(this), 30000L, new q(this), this.v.p()) == null) {
            d(this.v.r());
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        a.k("BillingClient", "Billing service disconnected.");
        this.v.f = 0;
        this.v.a = 0;
        synchronized (obj) {
            try {
                if (this.c != null) {
                    this.c.onBillingServiceDisconnected();
                }
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    /* synthetic */ s(d dVar, e eVar, t0 t0Var) {
        this.v = dVar;
        super();
        Object object = new Object();
        this.c = eVar;
    }
}
