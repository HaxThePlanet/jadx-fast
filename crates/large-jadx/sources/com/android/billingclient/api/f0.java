package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

/* loaded from: classes.dex */
final class f0 {

    private final Context a;
    private final com.android.billingclient.api.e0 b;
    f0(Context context, com.android.billingclient.api.k k2) {
        super();
        this.a = context;
        e0 obj2 = new e0(this, k2, 0);
        this.b = obj2;
    }

    static com.android.billingclient.api.e0 a(com.android.billingclient.api.f0 f0) {
        return f0.b;
    }

    final com.android.billingclient.api.k b() {
        return e0.a(this.b);
    }

    final void c() {
        this.b.c(this.a);
    }

    final void d() {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        this.b.b(this.a, intentFilter);
    }
}
