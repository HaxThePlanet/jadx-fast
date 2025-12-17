package com.revenuecat.purchases.common;

import com.revenuecat.purchases.models.PurchaseDetails;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\t\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0008\u001a\u00020\u0002\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00022\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\u0008\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u000cHÖ\u0001¢\u0006\u0004\u0008\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\u0008\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0013\u0010\u0014R\u0019\u0010\u0008\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0008\u0010\u0015\u001a\u0004\u0008\u0016\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\t\u0010\u0017\u001a\u0004\u0008\u0018\u0010\u0007¨\u0006\u001b", d2 = {"Lcom/revenuecat/purchases/common/ReplaceSkuInfo;", "", "Lcom/revenuecat/purchases/models/PurchaseDetails;", "component1", "()Lcom/revenuecat/purchases/models/PurchaseDetails;", "", "component2", "()Ljava/lang/Integer;", "oldPurchase", "prorationMode", "copy", "(Lcom/revenuecat/purchases/models/PurchaseDetails;Ljava/lang/Integer;)Lcom/revenuecat/purchases/common/ReplaceSkuInfo;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/revenuecat/purchases/models/PurchaseDetails;", "getOldPurchase", "Ljava/lang/Integer;", "getProrationMode", "<init>", "(Lcom/revenuecat/purchases/models/PurchaseDetails;Ljava/lang/Integer;)V", "common_release"}, k = 1, mv = {1, 4, 0})
public final class ReplaceSkuInfo {

    private final PurchaseDetails oldPurchase;
    private final Integer prorationMode;
    public ReplaceSkuInfo(PurchaseDetails purchaseDetails, Integer integer2) {
        n.f(purchaseDetails, "oldPurchase");
        super();
        this.oldPurchase = purchaseDetails;
        this.prorationMode = integer2;
    }

    public ReplaceSkuInfo(PurchaseDetails purchaseDetails, Integer integer2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(purchaseDetails, obj2);
    }

    public static com.revenuecat.purchases.common.ReplaceSkuInfo copy$default(com.revenuecat.purchases.common.ReplaceSkuInfo replaceSkuInfo, PurchaseDetails purchaseDetails2, Integer integer3, int i4, Object object5) {
        PurchaseDetails obj1;
        Integer obj2;
        if (i4 & 1 != 0) {
            obj1 = replaceSkuInfo.oldPurchase;
        }
        if (i4 &= 2 != 0) {
            obj2 = replaceSkuInfo.prorationMode;
        }
        return replaceSkuInfo.copy(obj1, obj2);
    }

    public final PurchaseDetails component1() {
        return this.oldPurchase;
    }

    public final Integer component2() {
        return this.prorationMode;
    }

    public final com.revenuecat.purchases.common.ReplaceSkuInfo copy(PurchaseDetails purchaseDetails, Integer integer2) {
        n.f(purchaseDetails, "oldPurchase");
        ReplaceSkuInfo replaceSkuInfo = new ReplaceSkuInfo(purchaseDetails, integer2);
        return replaceSkuInfo;
    }

    public boolean equals(Object object) {
        boolean prorationMode;
        PurchaseDetails oldPurchase;
        Object obj3;
        if (this != (ReplaceSkuInfo)object && object instanceof ReplaceSkuInfo && n.b(this.oldPurchase, object.oldPurchase) && n.b(this.prorationMode, object.prorationMode)) {
            if (object instanceof ReplaceSkuInfo) {
                if (n.b(this.oldPurchase, object.oldPurchase)) {
                    if (n.b(this.prorationMode, object.prorationMode)) {
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public final PurchaseDetails getOldPurchase() {
        return this.oldPurchase;
    }

    public final Integer getProrationMode() {
        return this.prorationMode;
    }

    public int hashCode() {
        int i2;
        int i;
        PurchaseDetails oldPurchase = this.oldPurchase;
        if (oldPurchase != null) {
            i2 = oldPurchase.hashCode();
        } else {
            i2 = i;
        }
        final Integer prorationMode = this.prorationMode;
        if (prorationMode != null) {
            i = prorationMode.hashCode();
        }
        return i3 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ReplaceSkuInfo(oldPurchase=");
        stringBuilder.append(this.oldPurchase);
        stringBuilder.append(", prorationMode=");
        stringBuilder.append(this.prorationMode);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
