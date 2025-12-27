package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import f.c.a.d.b.i.a;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
final class e0 extends BroadcastReceiver {

    private final k a;
    private boolean b;
    final /* synthetic */ f0 c;
    /* synthetic */ e0(f0 f0Var, k kVar, d0 d0Var) {
        this.c = f0Var;
        super();
        this.a = kVar;
    }

    static /* synthetic */ k a(e0 e0Var) {
        return e0Var.a;
    }

    @Override // android.content.BroadcastReceiver
    public final void b(Context context, IntentFilter intentFilter) {
        if (!this.b) {
            context.registerReceiver(this.c.b, intentFilter);
            boolean z2 = true;
            this.b = z2;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void c(Context context) {
        if (this.b) {
            context.unregisterReceiver(this.c.b);
            this.b = false;
            return;
        }
        a.k("BillingBroadcastManager", "Receiver is not registered.");
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.onPurchasesUpdated(a.g(intent, "BillingBroadcastManager"), a.i(intent.getExtras()));
    }
}
