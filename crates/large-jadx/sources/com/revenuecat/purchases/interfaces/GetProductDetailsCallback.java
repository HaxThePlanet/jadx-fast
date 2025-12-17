package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.ProductDetails;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0008H&¢\u0006\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"Lcom/revenuecat/purchases/interfaces/GetProductDetailsCallback;", "", "", "Lcom/revenuecat/purchases/models/ProductDetails;", "productDetailsList", "Lkotlin/w;", "onReceived", "(Ljava/util/List;)V", "Lcom/revenuecat/purchases/PurchasesError;", "error", "onError", "(Lcom/revenuecat/purchases/PurchasesError;)V", "purchases_release"}, k = 1, mv = {1, 4, 0})
public interface GetProductDetailsCallback {
    public abstract void onError(PurchasesError purchasesError);

    public abstract void onReceived(List<ProductDetails> list);
}
