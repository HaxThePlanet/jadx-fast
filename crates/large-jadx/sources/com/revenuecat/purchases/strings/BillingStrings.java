package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0010\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0010\u0010\u0011R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0004R\u0016\u0010\u0008\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u0004R\u0016\u0010\u000c\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000c\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0004¨\u0006\u0012", d2 = {"Lcom/revenuecat/purchases/strings/BillingStrings;", "", "", "BILLING_CLIENT_ERROR", "Ljava/lang/String;", "BILLING_WRAPPER_PURCHASES_ERROR", "BILLING_PURCHASE_HISTORY_RECORD_MORE_THAN_ONE_SKU", "BILLING_CLIENT_STARTING", "BILLING_PURCHASE_MORE_THAN_ONE_SKU", "BILLING_INTENT_FAILED", "BILLING_CLIENT_DISCONNECTED", "BILLING_SERVICE_DISCONNECTED", "BILLING_CLIENT_ENDING", "BILLING_SERVICE_SETUP_FINISHED", "BILLING_UNAVAILABLE", "BILLING_WRAPPER_PURCHASES_UPDATED", "<init>", "()V", "strings_release"}, k = 1, mv = {1, 4, 0})
public final class BillingStrings {

    public static final String BILLING_CLIENT_DISCONNECTED = "Billing is disconnected and purchase methods won't work. Stacktrace: %s";
    public static final String BILLING_CLIENT_ENDING = "Ending connection for %s";
    public static final String BILLING_CLIENT_ERROR = "Billing Service Setup finished with error code: %s";
    public static final String BILLING_CLIENT_STARTING = "Starting connection for %s";
    public static final String BILLING_INTENT_FAILED = "Failed to launch billing intent. %s";
    public static final String BILLING_PURCHASE_HISTORY_RECORD_MORE_THAN_ONE_SKU = "There's more than one sku in the PurchaseHistoryRecord, but only one will be used.";
    public static final String BILLING_PURCHASE_MORE_THAN_ONE_SKU = "There's more than one sku in the PurchaseHistoryRecord, but only one will be used.";
    public static final String BILLING_SERVICE_DISCONNECTED = "Billing Service disconnected for %s";
    public static final String BILLING_SERVICE_SETUP_FINISHED = "Billing Service Setup finished for %s";
    public static final String BILLING_UNAVAILABLE = "Billing is not available in this device. %s";
    public static final String BILLING_WRAPPER_PURCHASES_ERROR = "BillingWrapper purchases failed to update: %s";
    public static final String BILLING_WRAPPER_PURCHASES_UPDATED = "BillingWrapper purchases updated: %s";
    public static final com.revenuecat.purchases.strings.BillingStrings INSTANCE;
    static {
        BillingStrings billingStrings = new BillingStrings();
        BillingStrings.INSTANCE = billingStrings;
    }
}
