package com.revenuecat.purchases;

import com.revenuecat.purchases.common.attribution.AttributionNetwork;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\u0008\u0002\u0010\u0003*.\u0010\u0008\"\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004*.\u0010\n\"\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u00042\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0004¨\u0006\u000b", d2 = {"Lcom/revenuecat/purchases/Purchases$AttributionNetwork;", "Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;", "convert", "(Lcom/revenuecat/purchases/Purchases$AttributionNetwork;)Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/models/PurchaseDetails;", "Lcom/revenuecat/purchases/PurchasesError;", "Lkotlin/w;", "ErrorPurchaseCallback", "Lcom/revenuecat/purchases/PurchaserInfo;", "SuccessfulPurchaseCallback", "purchases_release"}, k = 2, mv = {1, 4, 0})
public final class PurchasesKt {
    public static final AttributionNetwork convert(com.revenuecat.purchases.Purchases.AttributionNetwork purchases$AttributionNetwork) {
        int i2;
        AttributionNetwork attributionNetwork2;
        int i;
        int serverValue;
        n.f(attributionNetwork, "$this$convert");
        AttributionNetwork[] values = AttributionNetwork.values();
        final int i3 = 0;
        i2 = i3;
        while (i2 < values.length) {
            attributionNetwork2 = values[i2];
            if (attributionNetwork2.getServerValue() == attributionNetwork.getServerValue()) {
            } else {
            }
            i = i3;
            i2++;
            i = 1;
        }
        NoSuchElementException obj7 = new NoSuchElementException("Array contains no element matching the predicate.");
        throw obj7;
    }
}
