package com.android.billingclient.api;

import java.util.List;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
final class t {

    private final List<PurchaseHistoryRecord> a;
    private final g b;
    t(g gVar, List<PurchaseHistoryRecord> list) {
        super();
        this.a = list;
        this.b = gVar;
    }

    final g a() {
        return this.b;
    }

    final List<PurchaseHistoryRecord> b() {
        return this.a;
    }
}
