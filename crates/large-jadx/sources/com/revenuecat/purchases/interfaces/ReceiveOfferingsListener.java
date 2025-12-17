package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchasesError;

/* loaded from: classes2.dex */
public interface ReceiveOfferingsListener {
    public abstract void onError(PurchasesError purchasesError);

    public abstract void onReceived(Offerings offerings);
}
