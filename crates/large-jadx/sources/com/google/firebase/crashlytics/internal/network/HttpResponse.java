package com.google.firebase.crashlytics.internal.network;

/* loaded from: classes2.dex */
public class HttpResponse {

    private final String body;
    private final int code;
    public HttpResponse(int i, String string2) {
        super();
        this.code = i;
        this.body = string2;
    }

    public String body() {
        return this.body;
    }

    public int code() {
        return this.code;
    }
}
