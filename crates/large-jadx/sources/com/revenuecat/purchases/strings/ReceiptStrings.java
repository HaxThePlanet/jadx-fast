package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\n\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0004R\u0016\u0010\u0008\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\t\u0010\u0004¨\u0006\u000c", d2 = {"Lcom/revenuecat/purchases/strings/ReceiptStrings;", "", "", "CLEANING_PREV_SENT_HASHED_TOKEN", "Ljava/lang/String;", "TOKENS_ALREADY_POSTED", "CHECKING_IF_CACHE_STALE", "SAVING_TOKENS_WITH_HASH", "TOKENS_IN_CACHE", "SAVING_TOKENS", "<init>", "()V", "strings_release"}, k = 1, mv = {1, 4, 0})
public final class ReceiptStrings {

    public static final String CHECKING_IF_CACHE_STALE = "Checking if cache is stale AppInBackground %s";
    public static final String CLEANING_PREV_SENT_HASHED_TOKEN = "Cleaning previously sent tokens";
    public static final com.revenuecat.purchases.strings.ReceiptStrings INSTANCE = null;
    public static final String SAVING_TOKENS = "Saving tokens %s";
    public static final String SAVING_TOKENS_WITH_HASH = "Saving token %s with hash %s";
    public static final String TOKENS_ALREADY_POSTED = "Tokens already posted: %s";
    public static final String TOKENS_IN_CACHE = "Tokens in cache before saving %s";
    static {
        ReceiptStrings receiptStrings = new ReceiptStrings();
        ReceiptStrings.INSTANCE = receiptStrings;
    }
}
