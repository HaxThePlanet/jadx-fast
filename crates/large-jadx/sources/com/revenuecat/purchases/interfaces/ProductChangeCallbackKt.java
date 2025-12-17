package com.revenuecat.purchases.interfaces;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\u0008\u0002\u0010\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0000¢\u0006\u0004\u0008\u0002\u0010\u0005¨\u0006\u0006", d2 = {"Lcom/revenuecat/purchases/interfaces/ProductChangeListener;", "Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "toProductChangeCallback", "(Lcom/revenuecat/purchases/interfaces/ProductChangeListener;)Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "Lcom/revenuecat/purchases/interfaces/MakePurchaseListener;", "(Lcom/revenuecat/purchases/interfaces/MakePurchaseListener;)Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "purchases_release"}, k = 2, mv = {1, 4, 0})
public final class ProductChangeCallbackKt {
    public static final com.revenuecat.purchases.interfaces.ProductChangeCallback toProductChangeCallback(com.revenuecat.purchases.interfaces.MakePurchaseListener makePurchaseListener) {
        n.f(makePurchaseListener, "$this$toProductChangeCallback");
        ProductChangeCallbackKt.toProductChangeCallback.2 anon = new ProductChangeCallbackKt.toProductChangeCallback.2(makePurchaseListener);
        return ProductChangeCallbackKt.toProductChangeCallback(anon);
    }

    public static final com.revenuecat.purchases.interfaces.ProductChangeCallback toProductChangeCallback(com.revenuecat.purchases.interfaces.ProductChangeListener productChangeListener) {
        n.f(productChangeListener, "$this$toProductChangeCallback");
        ProductChangeCallbackKt.toProductChangeCallback.1 anon = new ProductChangeCallbackKt.toProductChangeCallback.1(productChangeListener);
        return anon;
    }
}
