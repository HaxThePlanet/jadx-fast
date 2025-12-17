package com.revenuecat.purchases.google;

import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0003\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0006¨\u0006\u0007", d2 = {"Lcom/android/billingclient/api/Purchase;", "", "getSku", "(Lcom/android/billingclient/api/Purchase;)Ljava/lang/String;", "sku", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "(Lcom/android/billingclient/api/PurchaseHistoryRecord;)Ljava/lang/String;", "google_release"}, k = 2, mv = {1, 4, 0})
public final class ExtensionsKt {
    public static final String getSku(Purchase purchase) {
        String str;
        int obj3;
        n.f(purchase, "$this$sku");
        Object obj = purchase.g().get(0);
        if (purchase.g().size() > 0) {
            LogWrapperKt.log(LogIntent.GOOGLE_WARNING, "There's more than one sku in the PurchaseHistoryRecord, but only one will be used.");
        }
        n.e(obj, "skus[0].also {\n        i…_ONE_SKU)\n        }\n    }");
        return (String)obj;
    }

    public static final String getSku(PurchaseHistoryRecord purchaseHistoryRecord) {
        String str;
        int obj3;
        n.f(purchaseHistoryRecord, "$this$sku");
        Object obj = purchaseHistoryRecord.e().get(0);
        if (purchaseHistoryRecord.e().size() > 0) {
            LogWrapperKt.log(LogIntent.GOOGLE_WARNING, "There's more than one sku in the PurchaseHistoryRecord, but only one will be used.");
        }
        n.e(obj, "skus[0].also {\n        i…_ONE_SKU)\n        }\n    }");
        return (String)obj;
    }
}
