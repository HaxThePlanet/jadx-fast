package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0010\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0010\u0010\u0011R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0004R\u0016\u0010\u0008\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u0004R\u0016\u0010\u000c\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000c\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0004¨\u0006\u0012", d2 = {"Lcom/revenuecat/purchases/strings/RestoreStrings;", "", "", "RESTORING_PURCHASE_ERROR", "Ljava/lang/String;", "QUERYING_PURCHASE_HISTORY", "QUERYING_PURCHASE_WITH_HASH", "QUERYING_INAPP_ERROR", "QUERYING_SUBS_ERROR", "PURCHASE_RESTORED", "QUERYING_PURCHASE", "QUERYING_PURCHASE_WITH_TYPE", "PURCHASE_HISTORY_RETRIEVED", "SHARING_ACC_RESTORE_FALSE", "RESTORING_PURCHASE", "PURCHASE_HISTORY_EMPTY", "<init>", "()V", "strings_release"}, k = 1, mv = {1, 4, 0})
public final class RestoreStrings {

    public static final com.revenuecat.purchases.strings.RestoreStrings INSTANCE = null;
    public static final String PURCHASE_HISTORY_EMPTY = "Purchase history is empty.";
    public static final String PURCHASE_HISTORY_RETRIEVED = "Purchase history retrieved %s";
    public static final String PURCHASE_RESTORED = "Purchase %s restored";
    public static final String QUERYING_INAPP_ERROR = "Error when querying inapps. %s";
    public static final String QUERYING_PURCHASE = "Querying purchases";
    public static final String QUERYING_PURCHASE_HISTORY = "Querying purchase history for type %s";
    public static final String QUERYING_PURCHASE_WITH_HASH = "Purchase of type %s with hash %s";
    public static final String QUERYING_PURCHASE_WITH_TYPE = "Querying Purchase with %s and type %s";
    public static final String QUERYING_SUBS_ERROR = "Error when querying subscriptions. %s";
    public static final String RESTORING_PURCHASE = "Restoring purchases";
    public static final String RESTORING_PURCHASE_ERROR = "Error restoring purchase: %s. Error: %s";
    public static final String SHARING_ACC_RESTORE_FALSE = "allowSharingPlayStoreAccount is set to false and restorePurchases has been called. This will 'alias' any app user id's sharing the same receipt. Are you sure you want to do this? More info here: https://errors.rev.cat/allowsSharingPlayStoreAccount";
    static {
        RestoreStrings restoreStrings = new RestoreStrings();
        RestoreStrings.INSTANCE = restoreStrings;
    }
}
