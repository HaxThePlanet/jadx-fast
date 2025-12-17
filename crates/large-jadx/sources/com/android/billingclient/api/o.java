package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class o implements Callable<Void> {

    final String a;
    final com.android.billingclient.api.j b;
    final com.android.billingclient.api.d c;
    o(com.android.billingclient.api.d d, String string2, com.android.billingclient.api.j j3) {
        this.c = d;
        this.a = string2;
        this.b = j3;
        super();
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        com.android.billingclient.api.t tVar = d.B(this.c, this.a);
        this.b.onPurchaseHistoryResponse(tVar.a(), tVar.b());
        return null;
    }
}
