package com.google.firebase.crashlytics.internal.network;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public class HttpRequestFactory {
    public com.google.firebase.crashlytics.internal.network.HttpGetRequest buildHttpGetRequest(String string) {
        return buildHttpGetRequest(string, Collections.emptyMap());
    }

    public com.google.firebase.crashlytics.internal.network.HttpGetRequest buildHttpGetRequest(String string, Map<String, String> map2) {
        HttpGetRequest httpGetRequest = new HttpGetRequest(string, map2);
        return httpGetRequest;
    }
}
