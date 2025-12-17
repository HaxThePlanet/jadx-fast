package com.revenuecat.purchases.interfaces;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lcom/revenuecat/purchases/interfaces/MakePurchaseListener;", "Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "toPurchaseCallback", "(Lcom/revenuecat/purchases/interfaces/MakePurchaseListener;)Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "purchases_release"}, k = 2, mv = {1, 4, 0})
public final class PurchaseCallbackKt {
    public static final com.revenuecat.purchases.interfaces.PurchaseCallback toPurchaseCallback(com.revenuecat.purchases.interfaces.MakePurchaseListener makePurchaseListener) {
        n.f(makePurchaseListener, "$this$toPurchaseCallback");
        PurchaseCallbackKt.toPurchaseCallback.1 anon = new PurchaseCallbackKt.toPurchaseCallback.1(makePurchaseListener);
        return anon;
    }
}
