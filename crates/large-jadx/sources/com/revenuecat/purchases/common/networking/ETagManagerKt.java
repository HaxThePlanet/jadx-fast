package com.revenuecat.purchases.common.networking;

import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\u0008\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00018\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0005¨\u0006\u0008", d2 = {"Ljava/net/HttpURLConnection;", "", "getETagHeader", "(Ljava/net/HttpURLConnection;)Ljava/lang/String;", "SERIALIZATION_NAME_HTTPRESULT", "Ljava/lang/String;", "SERIALIZATION_NAME_ETAG", "ETAG_HEADER_NAME", "common_release"}, k = 2, mv = {1, 4, 0})
public final class ETagManagerKt {

    public static final String ETAG_HEADER_NAME = "X-RevenueCat-ETag";
    private static final String SERIALIZATION_NAME_ETAG = "eTag";
    private static final String SERIALIZATION_NAME_HTTPRESULT = "httpResult";
    public static final String getETagHeader(HttpURLConnection httpURLConnection) {
        n.f(httpURLConnection, "$this$getETagHeader");
        return httpURLConnection.getHeaderField("X-RevenueCat-ETag");
    }
}
