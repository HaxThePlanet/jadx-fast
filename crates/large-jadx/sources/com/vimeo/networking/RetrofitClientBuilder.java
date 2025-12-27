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

/* compiled from: RetrofitClientBuilder.java */
/* loaded from: classes2.dex */
public class RetrofitClientBuilder {

    private static final String KEYSTORE_PASSWORD = "vimeo123";
    private static final int NO_TIMEOUT = -1;
    private Cache cache;
    private int connectionTimeout = -1;
    private TimeUnit connectionTimeoutTimeUnit;
    private List<Interceptor> interceptorList = new ArrayList<>();
    private List<Interceptor> networkInterceptorList = new ArrayList<>();
    private int readTimeout = -1;
    private TimeUnit readTimeoutTimeUnit;
    private SSLSocketFactory sSLSocketFactory;
    public RetrofitClientBuilder() {
        super();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
    }

    public RetrofitClientBuilder addInterceptor(Interceptor interceptor) {
        this.interceptorList.add(interceptor);
        return this;
    }

    public RetrofitClientBuilder addInterceptors(List<Interceptor> list) {
        this.interceptorList.addAll(list);
        return this;
    }

    public RetrofitClientBuilder addNetworkInterceptor(Interceptor interceptor) {
        this.networkInterceptorList.add(interceptor);
        return this;
    }

    public RetrofitClientBuilder addNetworkInterceptors(List<Interceptor> list) {
        this.networkInterceptorList.addAll(list);
        return this;
    }

    public OkHttpClient build() {
        long l;
        OkHttpClient.Builder okHttpClient_Builder = new OkHttpClient_Builder();
        int i = -1;
        if (this.connectionTimeout != i) {
            l = (long)connectionTimeout2;
            okHttpClient_Builder.connectTimeout(l, this.connectionTimeoutTimeUnit);
        }
        if (this.readTimeout != i) {
            okHttpClient_Builder.readTimeout((long)readTimeout2, this.readTimeoutTimeUnit);
        }
        if (this.cache != null) {
            okHttpClient_Builder.cache(this.cache);
        }
        Iterator it = this.networkInterceptorList.iterator();
        while (it.hasNext()) {
            okHttpClient_Builder.addNetworkInterceptor((Interceptor)it.next());
        }
        Iterator it2 = this.interceptorList.iterator();
        while (it2.hasNext()) {
            okHttpClient_Builder.addInterceptor((Interceptor)it2.next());
        }
        if (this.sSLSocketFactory != null) {
            okHttpClient_Builder.sslSocketFactory(this.sSLSocketFactory);
        }
        return okHttpClient_Builder.build();
    }

    public RetrofitClientBuilder ignoreCertificates() throws java.security.KeyManagementException, java.security.NoSuchAlgorithmException {
        javax.net.ssl.TrustManager[] arr = new TrustManager[1];
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, new TrustManager[] { new RetrofitClientBuilder.AnonymousClass1(this) }, new SecureRandom());
        this.sSLSocketFactory = sSLContext.getSocketFactory();
        return this;
    }

    public RetrofitClientBuilder pinCertificates() throws java.io.IOException, java.security.NoSuchAlgorithmException, java.security.KeyManagementException, java.security.UnrecoverableKeyException, java.security.cert.CertificateException, java.security.KeyStoreException {
        KeyStore keyStore = KeyStore.getInstance("BKS");
        String str4 = "vimeo123";
        keyStore.load(getClass().getResourceAsStream("/keystore.bks"), str4.toCharArray());
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, str4.toCharArray());
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
        this.sSLSocketFactory = sSLContext.getSocketFactory();
        return this;
    }

    public RetrofitClientBuilder setCache(Cache cache) {
        this.cache = cache;
        return this;
    }

    public RetrofitClientBuilder setConnectionTimeout(int i, TimeUnit timeUnit) {
        this.connectionTimeout = i;
        this.connectionTimeoutTimeUnit = timeUnit;
        return this;
    }

    public RetrofitClientBuilder setReadTimeout(int i, TimeUnit timeUnit) {
        this.readTimeout = i;
        this.readTimeoutTimeUnit = timeUnit;
        return this;
    }
}
