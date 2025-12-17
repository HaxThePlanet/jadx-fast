package com.revenuecat.purchases;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\u0008\u000c\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\u0008\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\r¨\u0006\u000e", d2 = {"Lcom/revenuecat/purchases/BillingFeature;", "", "", "playBillingClientName", "Ljava/lang/String;", "getPlayBillingClientName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SUBSCRIPTIONS", "SUBSCRIPTIONS_UPDATE", "IN_APP_ITEMS_ON_VR", "SUBSCRIPTIONS_ON_VR", "PRICE_CHANGE_CONFIRMATION", "public_release"}, k = 1, mv = {1, 4, 0})
public enum BillingFeature {

    SUBSCRIPTIONS("subscriptions"),
    SUBSCRIPTIONS_UPDATE("subscriptions"),
    IN_APP_ITEMS_ON_VR("subscriptions"),
    SUBSCRIPTIONS_ON_VR("subscriptions"),
    PRICE_CHANGE_CONFIRMATION("subscriptions");

    private final String playBillingClientName;
    @Override // java.lang.Enum
    public final String getPlayBillingClientName() {
        return this.playBillingClientName;
    }
}
