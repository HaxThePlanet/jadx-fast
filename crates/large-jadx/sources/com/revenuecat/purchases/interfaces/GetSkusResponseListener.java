package com.revenuecat.purchases.interfaces;

import com.android.billingclient.api.SkuDetails;
import com.revenuecat.purchases.PurchasesError;
import java.util.List;

/* loaded from: classes2.dex */
public interface GetSkusResponseListener {
    public abstract void onError(PurchasesError purchasesError);

    public abstract void onReceived(List<SkuDetails> list);
}
