package com.google.firebase.storage.network.connection;

import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes2.dex */
public class HttpURLConnectionFactoryImpl implements com.google.firebase.storage.network.connection.HttpURLConnectionFactory {
    @Override // com.google.firebase.storage.network.connection.HttpURLConnectionFactory
    public HttpURLConnection createInstance(URL uRL) {
        return (HttpURLConnection)uRL.openConnection();
    }
}
