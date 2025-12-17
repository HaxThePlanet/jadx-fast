package com.revenuecat.purchases.google;

import com.revenuecat.purchases.models.RevenueCatPurchaseState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\u0008\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"", "Lcom/revenuecat/purchases/models/RevenueCatPurchaseState;", "toRevenueCatPurchaseState", "(I)Lcom/revenuecat/purchases/models/RevenueCatPurchaseState;", "toGooglePurchaseState", "(Lcom/revenuecat/purchases/models/RevenueCatPurchaseState;)I", "google_release"}, k = 2, mv = {1, 4, 0})
public final class PurchaseTypeConversionsKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[values.length];
            PurchaseTypeConversionsKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
            iArr[RevenueCatPurchaseState.UNSPECIFIED_STATE.ordinal()] = 1;
            iArr[RevenueCatPurchaseState.PURCHASED.ordinal()] = 2;
            iArr[RevenueCatPurchaseState.PENDING.ordinal()] = 3;
        }
    }
    public static final int toGooglePurchaseState(RevenueCatPurchaseState revenueCatPurchaseState) {
        int i;
        int i2;
        n.f(revenueCatPurchaseState, "$this$toGooglePurchaseState");
        int obj2 = PurchaseTypeConversionsKt.WhenMappings.$EnumSwitchMapping$0[revenueCatPurchaseState.ordinal()];
        i2 = 1;
        if (obj2 != i2) {
            if (obj2 != 2) {
                if (obj2 != 3) {
                } else {
                }
                obj2 = new NoWhenBranchMatchedException();
                throw obj2;
            }
            i = i2;
        } else {
            i = 0;
        }
        return i;
    }

    public static final RevenueCatPurchaseState toRevenueCatPurchaseState(int i) {
        int i2;
        RevenueCatPurchaseState obj1;
        if (i != 0) {
            if (i != 1) {
                obj1 = i != 2 ? RevenueCatPurchaseState.UNSPECIFIED_STATE : RevenueCatPurchaseState.PENDING;
            } else {
                obj1 = RevenueCatPurchaseState.PURCHASED;
            }
        } else {
            obj1 = RevenueCatPurchaseState.UNSPECIFIED_STATE;
        }
        return obj1;
    }
}
