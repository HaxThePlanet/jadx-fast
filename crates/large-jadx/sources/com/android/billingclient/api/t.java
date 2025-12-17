package com.android.billingclient.api;

import java.util.List;

/* loaded from: classes.dex */
final class t {

    private final List<com.android.billingclient.api.PurchaseHistoryRecord> a;
    private final com.android.billingclient.api.g b;
    t(com.android.billingclient.api.g g, List<com.android.billingclient.api.PurchaseHistoryRecord> list2) {
        super();
        this.a = list2;
        this.b = g;
    }

    final com.android.billingclient.api.g a() {
        return this.b;
    }

    final List<com.android.billingclient.api.PurchaseHistoryRecord> b() {
        return this.a;
    }
}
