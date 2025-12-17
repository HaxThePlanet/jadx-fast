package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.PurchaserInfo;
import com.revenuecat.purchases.models.PurchaseDetails;
import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "Lcom/revenuecat/purchases/interfaces/PurchaseErrorListener;", "Lcom/revenuecat/purchases/models/PurchaseDetails;", "purchase", "Lcom/revenuecat/purchases/PurchaserInfo;", "purchaserInfo", "Lkotlin/w;", "onCompleted", "(Lcom/revenuecat/purchases/models/PurchaseDetails;Lcom/revenuecat/purchases/PurchaserInfo;)V", "purchases_release"}, k = 1, mv = {1, 4, 0})
public interface PurchaseCallback extends com.revenuecat.purchases.interfaces.PurchaseErrorListener {
    @Override // com.revenuecat.purchases.interfaces.PurchaseErrorListener
    public abstract void onCompleted(PurchaseDetails purchaseDetails, PurchaserInfo purchaserInfo2);
}
