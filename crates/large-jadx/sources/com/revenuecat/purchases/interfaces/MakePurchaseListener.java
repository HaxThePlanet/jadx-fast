package com.revenuecat.purchases.interfaces;

import com.android.billingclient.api.Purchase;
import com.revenuecat.purchases.PurchaserInfo;

/* loaded from: classes2.dex */
public interface MakePurchaseListener extends com.revenuecat.purchases.interfaces.PurchaseErrorListener {
    @Override // com.revenuecat.purchases.interfaces.PurchaseErrorListener
    public abstract void onCompleted(Purchase purchase, PurchaserInfo purchaserInfo2);
}
