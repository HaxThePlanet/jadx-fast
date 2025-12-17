package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0004R\u0016\u0010\u0008\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0004¨\u0006\u000b", d2 = {"Lcom/revenuecat/purchases/strings/NetworkStrings;", "", "", "ETAG_RETRYING_CALL", "Ljava/lang/String;", "API_REQUEST_STARTED", "HTTP_RESPONSE_PAYLOAD_NULL", "API_REQUEST_COMPLETED", "ETAG_CALL_ALREADY_RETRIED", "<init>", "()V", "strings_release"}, k = 1, mv = {1, 4, 0})
public final class NetworkStrings {

    public static final String API_REQUEST_COMPLETED = "API request completed with status: %s %s %s";
    public static final String API_REQUEST_STARTED = "API request started: %s %s";
    public static final String ETAG_CALL_ALREADY_RETRIED = "We can't find the cached response, but call has already been retried. Returning result from backend: %s";
    public static final String ETAG_RETRYING_CALL = "We were expecting to be able to return a cached response, but we can't find it. Retrying call with a new ETag";
    public static final String HTTP_RESPONSE_PAYLOAD_NULL = "HTTP Response payload is null";
    public static final com.revenuecat.purchases.strings.NetworkStrings INSTANCE;
    static {
        NetworkStrings networkStrings = new NetworkStrings();
        NetworkStrings.INSTANCE = networkStrings;
    }
}
