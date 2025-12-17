package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.PurchaserInfo;
import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\u0008\u000b\u0010\u000c¨\u0006\r", d2 = {"Lcom/revenuecat/purchases/interfaces/LogInCallback;", "", "Lcom/revenuecat/purchases/PurchaserInfo;", "purchaserInfo", "", "created", "Lkotlin/w;", "onReceived", "(Lcom/revenuecat/purchases/PurchaserInfo;Z)V", "Lcom/revenuecat/purchases/PurchasesError;", "error", "onError", "(Lcom/revenuecat/purchases/PurchasesError;)V", "purchases_release"}, k = 1, mv = {1, 4, 0})
public interface LogInCallback {
    public abstract void onError(PurchasesError purchasesError);

    public abstract void onReceived(PurchaserInfo purchaserInfo, boolean z2);
}
