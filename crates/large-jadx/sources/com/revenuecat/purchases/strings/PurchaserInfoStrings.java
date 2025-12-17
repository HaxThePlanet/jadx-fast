package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000c\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0004R\u0016\u0010\u0008\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u0004¨\u0006\u000e", d2 = {"Lcom/revenuecat/purchases/strings/PurchaserInfoStrings;", "", "", "NO_CACHED_PURCHASERINFO", "Ljava/lang/String;", "PURCHASERINFO_UPDATED_NOTIFYING_LISTENER", "PURCHASERINFO_STALE_UPDATING_FOREGROUND", "PURCHASERINFO_UPDATED_FROM_NETWORK", "PURCHASERINFO_STALE_UPDATING_BACKGROUND", "SENDING_LATEST_PURCHASERINFO_TO_LISTENER", "VENDING_CACHE", "INVALIDATING_PURCHASERINFO_CACHE", "<init>", "()V", "strings_release"}, k = 1, mv = {1, 4, 0})
public final class PurchaserInfoStrings {

    public static final com.revenuecat.purchases.strings.PurchaserInfoStrings INSTANCE = null;
    public static final String INVALIDATING_PURCHASERINFO_CACHE = "Invalidating PurchaserInfo cache.";
    public static final String NO_CACHED_PURCHASERINFO = "No cached PurchaserInfo, fetching from network.";
    public static final String PURCHASERINFO_STALE_UPDATING_BACKGROUND = "PurchaserInfo cache is stale, updating from network in background.";
    public static final String PURCHASERINFO_STALE_UPDATING_FOREGROUND = "PurchaserInfo cache is stale, updating from network in foreground.";
    public static final String PURCHASERINFO_UPDATED_FROM_NETWORK = "PurchaserInfo updated from network.";
    public static final String PURCHASERINFO_UPDATED_NOTIFYING_LISTENER = "PurchaserInfo updated, sending to listener.";
    public static final String SENDING_LATEST_PURCHASERINFO_TO_LISTENER = "Sending latest PurchaserInfo to listener.";
    public static final String VENDING_CACHE = "Vending PurchaserInfo from cache.";
    static {
        PurchaserInfoStrings purchaserInfoStrings = new PurchaserInfoStrings();
        PurchaserInfoStrings.INSTANCE = purchaserInfoStrings;
    }
}
