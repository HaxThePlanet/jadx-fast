package com.revenuecat.purchases.models;

import com.android.billingclient.api.SkuDetails;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0005", d2 = {"Lcom/revenuecat/purchases/models/ProductDetails;", "Lcom/android/billingclient/api/SkuDetails;", "getSkuDetails", "(Lcom/revenuecat/purchases/models/ProductDetails;)Lcom/android/billingclient/api/SkuDetails;", "skuDetails", "public_release"}, k = 2, mv = {1, 4, 0})
public final class ProductDetailsHelpers {
    public static final SkuDetails getSkuDetails(com.revenuecat.purchases.models.ProductDetails productDetails) {
        n.f(productDetails, "$this$skuDetails");
        SkuDetails skuDetails = new SkuDetails(productDetails.getOriginalJson().toString());
        return skuDetails;
    }
}
