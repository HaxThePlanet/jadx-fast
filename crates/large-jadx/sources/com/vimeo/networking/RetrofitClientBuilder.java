package com.vimeo.networking;

import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

/* loaded from: classes2.dex */
public class RetrofitClientBuilder {

    private static final String KEYSTORE_PASSWORD = "vimeo123";
    private static final int NO_TIMEOUT = -1;
    private Cache cache;
    private int connectionTimeout = -1;
    private TimeUnit connectionTimeoutTimeUnit;
    private List<Interceptor> interceptorList;
    private List<Interceptor> networkInterceptorList;
    private int readTimeout = -1;
    private TimeUnit readTimeoutTimeUnit;
    private SSLSocketFactory sSLSocketFactory;
    public RetrofitClientBuilder() {
        super();
        int i = -1;
        ArrayList arrayList = new ArrayList();
        this.interceptorList = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.networkInterceptorList = arrayList2;
    }

    public com.vimeo.networking.RetrofitClientBuilder addInterceptor(Interceptor interceptor) {
        this.interceptorList.add(interceptor);
        return this;
    }

    public com.vimeo.networking.RetrofitClientBuilder addInterceptors(List<Interceptor> list) {
        this.interceptorList.addAll(list);
        return this;
    }

    public com.vimeo.networking.RetrofitClientBuilder addNetworkInterceptor(Interceptor interceptor) {
        this.networkInterceptorList.add(interceptor);
        return this;
    }

    public com.vimeo.networking.RetrofitClientBuilder addNetworkInterceptors(List<Interceptor> list) {
        this.networkInterceptorList.addAll(list);
        return this;
    }

    public OkHttpClient build() {
        int connectionTimeoutTimeUnit;
        int readTimeout;
        int next;
        boolean next2;
        long readTimeoutTimeUnit;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        connectionTimeoutTimeUnit = this.connectionTimeout;
        next = -1;
        if (connectionTimeoutTimeUnit != next) {
            builder.connectTimeout((long)connectionTimeoutTimeUnit, obj4);
        }
        readTimeout = this.readTimeout;
        if (readTimeout != next) {
            builder.readTimeout((long)readTimeout, next);
        }
        Cache cache = this.cache;
        if (cache != null) {
            builder.cache(cache);
        }
        Iterator iterator = this.networkInterceptorList.iterator();
        for (Interceptor next : iterator) {
            builder.addNetworkInterceptor(next);
        }
        Iterator iterator2 = this.interceptorList.iterator();
        for (Interceptor next2 : iterator2) {
            builder.addInterceptor(next2);
        }
        SSLSocketFactory sSLSocketFactory = this.sSLSocketFactory;
        if (sSLSocketFactory != null) {
            builder.sslSocketFactory(sSLSocketFactory);
        }
        return builder.build();
    }

    public com.vimeo.networking.RetrofitClientBuilder ignoreCertificates() {
        RetrofitClientBuilder.1 anon = new RetrofitClientBuilder.1(this);
        javax.net.ssl.TrustManager[] arr = new TrustManager[1];
        SSLContext instance = SSLContext.getInstance("TLS");
        SecureRandom secureRandom = new SecureRandom();
        instance.init(0, arr, secureRandom);
        this.sSLSocketFactory = instance.getSocketFactory();
        return this;
    }

    public com.vimeo.networking.RetrofitClientBuilder pinCertificates() {
        KeyStore instance2 = KeyStore.getInstance("BKS");
        String str4 = "vimeo123";
        instance2.load(getClass().getResourceAsStream("/keystore.bks"), str4.toCharArray());
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init(instance2);
        KeyManagerFactory instance4 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        instance4.init(instance2, str4.toCharArray());
        SSLContext instance3 = SSLContext.getInstance("TLS");
        instance3.init(instance4.getKeyManagers(), instance.getTrustManagers(), 0);
        this.sSLSocketFactory = instance3.getSocketFactory();
        return this;
    }

    public com.vimeo.networking.RetrofitClientBuilder setCache(Cache cache) {
        this.cache = cache;
        return this;
    }

    public com.vimeo.networking.RetrofitClientBuilder setConnectionTimeout(int i, TimeUnit timeUnit2) {
        this.connectionTimeout = i;
        this.connectionTimeoutTimeUnit = timeUnit2;
        return this;
    }

    public com.vimeo.networking.RetrofitClientBuilder setReadTimeout(int i, TimeUnit timeUnit2) {
        this.readTimeout = i;
        this.readTimeoutTimeUnit = timeUnit2;
        return this;
    }
}
