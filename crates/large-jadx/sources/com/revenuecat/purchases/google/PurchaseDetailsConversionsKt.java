package com.revenuecat.purchases.google;

import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.PurchaseDetails;
import com.revenuecat.purchases.models.PurchaseType;
import com.revenuecat.purchases.models.RevenueCatPurchaseState;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007\u001a\u0019\u0010\u0006\u001a\u00020\u0005*\u00020\u00082\u0006\u0010\t\u001a\u00020\u0001¢\u0006\u0004\u0008\u0006\u0010\n\"\u0019\u0010\r\u001a\u0004\u0018\u00010\u0000*\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u000e", d2 = {"Lcom/android/billingclient/api/Purchase;", "Lcom/revenuecat/purchases/ProductType;", "productType", "", "presentedOfferingIdentifier", "Lcom/revenuecat/purchases/models/PurchaseDetails;", "toRevenueCatPurchaseDetails", "(Lcom/android/billingclient/api/Purchase;Lcom/revenuecat/purchases/ProductType;Ljava/lang/String;)Lcom/revenuecat/purchases/models/PurchaseDetails;", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "type", "(Lcom/android/billingclient/api/PurchaseHistoryRecord;Lcom/revenuecat/purchases/ProductType;)Lcom/revenuecat/purchases/models/PurchaseDetails;", "getOriginalGooglePurchase", "(Lcom/revenuecat/purchases/models/PurchaseDetails;)Lcom/android/billingclient/api/Purchase;", "originalGooglePurchase", "google_release"}, k = 2, mv = {1, 4, 0})
public final class PurchaseDetailsConversionsKt {
    public static final Purchase getOriginalGooglePurchase(PurchaseDetails purchaseDetails) {
        String signature;
        int purchase;
        int i;
        PurchaseType gOOGLE_PURCHASE;
        Object obj4;
        n.f(purchaseDetails, "$this$originalGooglePurchase");
        if (purchaseDetails.getSignature() != null) {
            i = purchaseDetails.getPurchaseType() == PurchaseType.GOOGLE_PURCHASE ? 1 : 0;
            if (i != 0) {
            } else {
                signature = purchase;
            }
            if (signature != null) {
                purchase = new Purchase(purchaseDetails.getOriginalJson().toString(), signature);
            }
        }
        return purchase;
    }

    public static final PurchaseDetails toRevenueCatPurchaseDetails(Purchase purchase, ProductType productType2, String string3) {
        Object obj = purchase;
        n.f(purchase, "$this$toRevenueCatPurchaseDetails");
        final Object obj2 = productType2;
        n.f(obj2, "productType");
        final java.util.ArrayList list = purchase.g();
        n.e(list, "this.skus");
        final String str6 = purchase.e();
        n.e(str6, "this.purchaseToken");
        JSONObject jSONObject = new JSONObject(purchase.b());
        super(purchase.a(), list, obj2, purchase.d(), obj6, str6, PurchaseTypeConversionsKt.toRevenueCatPurchaseState(purchase.c()), Boolean.valueOf(purchase.i()), purchase.f(), jSONObject, string3, 0, PurchaseType.GOOGLE_PURCHASE);
        return purchaseDetails;
    }

    public static final PurchaseDetails toRevenueCatPurchaseDetails(PurchaseHistoryRecord purchaseHistoryRecord, ProductType productType2) {
        Object obj = purchaseHistoryRecord;
        n.f(purchaseHistoryRecord, "$this$toRevenueCatPurchaseDetails");
        final Object obj2 = productType2;
        n.f(obj2, "type");
        final java.util.ArrayList list = purchaseHistoryRecord.e();
        n.e(list, "this.skus");
        final String str6 = purchaseHistoryRecord.c();
        n.e(str6, "this.purchaseToken");
        JSONObject jSONObject = new JSONObject(purchaseHistoryRecord.a());
        super(0, list, obj2, purchaseHistoryRecord.b(), obj6, str6, RevenueCatPurchaseState.UNSPECIFIED_STATE, 0, purchaseHistoryRecord.d(), jSONObject, 0, 0, PurchaseType.GOOGLE_RESTORED_PURCHASE);
        return purchaseDetails;
    }
}
