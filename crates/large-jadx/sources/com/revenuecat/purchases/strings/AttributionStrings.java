package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0012\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0004R\u0016\u0010\u0008\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u0004R\u0016\u0010\u000c\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000c\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0004¨\u0006\u0014", d2 = {"Lcom/revenuecat/purchases/strings/AttributionStrings;", "", "", "ATTRIBUTES_SYNC_ERROR", "Ljava/lang/String;", "IO_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER", "SKIP_SAME_ATTRIBUTES", "GOOGLE_PLAY_SERVICES_NOT_INSTALLED_FETCHING_ADVERTISING_IDENTIFIER", "UNSYNCED_ATTRIBUTES_COUNT", "SUBSCRIBER_ATTRIBUTES_ERROR", "DELETING_ATTRIBUTES_OTHER_USERS", "MARKING_ATTRIBUTES_SYNCED", "ATTRIBUTES_SYNC_SUCCESS", "NO_SUBSCRIBER_ATTRIBUTES_TO_SYNCHRONIZE", "METHOD_CALLED", "TIMEOUT_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER", "GOOGLE_PLAY_SERVICES_REPAIRABLE_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER", "DELETING_ATTRIBUTES", "<init>", "()V", "strings_release"}, k = 1, mv = {1, 4, 0})
public final class AttributionStrings {

    public static final String ATTRIBUTES_SYNC_ERROR = "Error when syncing subscriber attributes. App User ID: %s, Error: %s";
    public static final String ATTRIBUTES_SYNC_SUCCESS = "Subscriber attributes synced successfully for App User ID: %s";
    public static final String DELETING_ATTRIBUTES = "Deleting subscriber attributes for %s from cache";
    public static final String DELETING_ATTRIBUTES_OTHER_USERS = "Deleting old synced subscriber attributes that don't belong to %s";
    public static final String GOOGLE_PLAY_SERVICES_NOT_INSTALLED_FETCHING_ADVERTISING_IDENTIFIER = "GooglePlayServices is not installed. Couldn't get and advertising identifier. Message: %s";
    public static final String GOOGLE_PLAY_SERVICES_REPAIRABLE_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER = "GooglePlayServicesRepairableException when getting advertising identifier. Message: %s";
    public static final com.revenuecat.purchases.strings.AttributionStrings INSTANCE = null;
    public static final String IO_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER = "IOException when getting advertising identifier. Message: %s";
    public static final String MARKING_ATTRIBUTES_SYNCED = "Marking the following attributes as synced for App User ID: %s";
    public static final String METHOD_CALLED = "%s called";
    public static final String NO_SUBSCRIBER_ATTRIBUTES_TO_SYNCHRONIZE = "No subscriber attributes to synchronize.";
    public static final String SKIP_SAME_ATTRIBUTES = "Attribution data is the same as latest. Skipping.";
    public static final String SUBSCRIBER_ATTRIBUTES_ERROR = "There were some subscriber attributes errors: %s";
    public static final String TIMEOUT_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER = "TimeoutException when getting advertising identifier. Message: %s";
    public static final String UNSYNCED_ATTRIBUTES_COUNT = "Found %d unsynced attributes for App User ID: %s";
    static {
        AttributionStrings attributionStrings = new AttributionStrings();
        AttributionStrings.INSTANCE = attributionStrings;
    }
}
