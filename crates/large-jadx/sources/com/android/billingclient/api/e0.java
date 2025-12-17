package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import f.c.a.d.b.i.a;

/* loaded from: classes.dex */
final class e0 extends BroadcastReceiver {

    private final com.android.billingclient.api.k a;
    private boolean b;
    final com.android.billingclient.api.f0 c;
    e0(com.android.billingclient.api.f0 f0, com.android.billingclient.api.k k2, com.android.billingclient.api.d0 d03) {
        this.c = f0;
        super();
        this.a = k2;
    }

    static com.android.billingclient.api.k a(com.android.billingclient.api.e0 e0) {
        return e0.a;
    }

    @Override // android.content.BroadcastReceiver
    public final void b(Context context, IntentFilter intentFilter2) {
        boolean z;
        int obj2;
        if (!this.b) {
            context.registerReceiver(f0.a(this.c), intentFilter2);
            this.b = true;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void c(Context context) {
        if (this.b) {
            context.unregisterReceiver(f0.a(this.c));
            this.b = false;
        }
        a.k("BillingBroadcastManager", "Receiver is not registered.");
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent2) {
        this.a.onPurchasesUpdated(a.g(intent2, "BillingBroadcastManager"), a.i(intent2.getExtras()));
    }
}
