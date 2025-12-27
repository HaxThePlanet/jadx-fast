package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
final class f0 {

    private final Context a;
    private final e0 b = new e0();
    f0(Context context, k kVar) {
        super();
        this.a = context;
        final com.android.billingclient.api.e0 e0Var = new e0(this, kVar, null);
    }

    final k b() {
        return this.b.a;
    }

    final void c() {
        this.b.c(this.a);
    }

    final void d() throws android.content.IntentFilter.MalformedMimeTypeException {
        this.b.b(this.a, new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED"));
    }

    static /* synthetic */ e0 a(f0 f0Var) {
        return f0Var.b;
    }
}
