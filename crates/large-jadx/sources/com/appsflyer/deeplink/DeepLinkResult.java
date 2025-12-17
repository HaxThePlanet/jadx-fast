package com.appsflyer.deeplink;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class DeepLinkResult {

    private final com.appsflyer.deeplink.DeepLink deepLink;
    private final com.appsflyer.deeplink.DeepLinkResult.Error error;
    private final com.appsflyer.deeplink.DeepLinkResult.Status status;

    public static enum Error {

        TIMEOUT,
        NETWORK,
        HTTP_STATUS_CODE,
        UNEXPECTED,
        DEVELOPER_ERROR;
    }

    public static enum Status {

        FOUND,
        NOT_FOUND,
        ERROR;
    }
    public DeepLinkResult(com.appsflyer.deeplink.DeepLink deepLink, com.appsflyer.deeplink.DeepLinkResult.Error deepLinkResult$Error2) {
        com.appsflyer.deeplink.DeepLinkResult.Status obj1;
        super();
        this.deepLink = deepLink;
        this.error = error2;
        if (error2 != null) {
            this.status = DeepLinkResult.Status.ERROR;
        } else {
            if (deepLink != null) {
                this.status = DeepLinkResult.Status.FOUND;
            } else {
                this.status = DeepLinkResult.Status.NOT_FOUND;
            }
        }
    }

    public com.appsflyer.deeplink.DeepLink getDeepLink() {
        return this.deepLink;
    }

    public com.appsflyer.deeplink.DeepLinkResult.Error getError() {
        return this.error;
    }

    public com.appsflyer.deeplink.DeepLinkResult.Status getStatus() {
        return this.status;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deepLink", this.deepLink);
        jSONObject.put("error", this.error);
        jSONObject.put("status", this.status);
        return jSONObject.toString();
    }
}
