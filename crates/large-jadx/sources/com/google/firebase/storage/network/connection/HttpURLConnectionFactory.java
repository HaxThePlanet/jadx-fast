package com.google.firebase.storage.network.connection;

import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes2.dex */
public interface HttpURLConnectionFactory {
    public abstract HttpURLConnection createInstance(URL uRL);
}
