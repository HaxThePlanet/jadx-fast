package com.google.firebase.functions;

/* loaded from: classes2.dex */
class HttpsCallableContext {

    private final String appCheckToken;
    private final String authToken;
    private final String instanceIdToken;
    HttpsCallableContext(String string, String string2, String string3) {
        super();
        this.authToken = string;
        this.instanceIdToken = string2;
        this.appCheckToken = string3;
    }

    public String getAppCheckToken() {
        return this.appCheckToken;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public String getInstanceIdToken() {
        return this.instanceIdToken;
    }
}
