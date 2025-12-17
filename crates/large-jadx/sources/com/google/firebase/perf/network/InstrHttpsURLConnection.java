package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public final class InstrHttpsURLConnection extends HttpsURLConnection {

    private final com.google.firebase.perf.network.InstrURLConnectionBase delegate;
    private final HttpsURLConnection httpsURLConnection;
    InstrHttpsURLConnection(HttpsURLConnection httpsURLConnection, Timer timer2, NetworkRequestMetricBuilder networkRequestMetricBuilder3) {
        super(httpsURLConnection.getURL());
        this.httpsURLConnection = httpsURLConnection;
        InstrURLConnectionBase instrURLConnectionBase = new InstrURLConnectionBase(httpsURLConnection, timer2, networkRequestMetricBuilder3);
        this.delegate = instrURLConnectionBase;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void addRequestProperty(String string, String string2) {
        this.delegate.addRequestProperty(string, string2);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void connect() {
        this.delegate.connect();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void disconnect() {
        this.delegate.disconnect();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public boolean equals(Object object) {
        return this.delegate.equals(object);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public boolean getAllowUserInteraction() {
        return this.delegate.getAllowUserInteraction();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        return this.httpsURLConnection.getCipherSuite();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public int getConnectTimeout() {
        return this.delegate.getConnectTimeout();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Object getContent() {
        return this.delegate.getContent();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Object getContent(Class[] classArr) {
        return this.delegate.getContent(classArr);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getContentEncoding() {
        return this.delegate.getContentEncoding();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public int getContentLength() {
        return this.delegate.getContentLength();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public long getContentLengthLong() {
        return this.delegate.getContentLengthLong();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getContentType() {
        return this.delegate.getContentType();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public long getDate() {
        return this.delegate.getDate();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public boolean getDefaultUseCaches() {
        return this.delegate.getDefaultUseCaches();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public boolean getDoInput() {
        return this.delegate.getDoInput();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public boolean getDoOutput() {
        return this.delegate.getDoOutput();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public InputStream getErrorStream() {
        return this.delegate.getErrorStream();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public long getExpiration() {
        return this.delegate.getExpiration();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getHeaderField(int i) {
        return this.delegate.getHeaderField(i);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getHeaderField(String string) {
        return this.delegate.getHeaderField(string);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public long getHeaderFieldDate(String string, long l2) {
        return this.delegate.getHeaderFieldDate(string, l2);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public int getHeaderFieldInt(String string, int i2) {
        return this.delegate.getHeaderFieldInt(string, i2);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getHeaderFieldKey(int i) {
        return this.delegate.getHeaderFieldKey(i);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public long getHeaderFieldLong(String string, long l2) {
        return this.delegate.getHeaderFieldLong(string, l2);
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.delegate.getHeaderFields();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        return this.httpsURLConnection.getHostnameVerifier();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public long getIfModifiedSince() {
        return this.delegate.getIfModifiedSince();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public InputStream getInputStream() {
        return this.delegate.getInputStream();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.delegate.getInstanceFollowRedirects();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public long getLastModified() {
        return this.delegate.getLastModified();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        return this.httpsURLConnection.getLocalCertificates();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        return this.httpsURLConnection.getLocalPrincipal();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public OutputStream getOutputStream() {
        return this.delegate.getOutputStream();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() {
        return this.httpsURLConnection.getPeerPrincipal();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Permission getPermission() {
        return this.delegate.getPermission();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public int getReadTimeout() {
        return this.delegate.getReadTimeout();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getRequestMethod() {
        return this.delegate.getRequestMethod();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.delegate.getRequestProperties();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getRequestProperty(String string) {
        return this.delegate.getRequestProperty(string);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public int getResponseCode() {
        return this.delegate.getResponseCode();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getResponseMessage() {
        return this.delegate.getResponseMessage();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        return this.httpsURLConnection.getSSLSocketFactory();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() {
        return this.httpsURLConnection.getServerCertificates();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public URL getURL() {
        return this.delegate.getURL();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public boolean getUseCaches() {
        return this.delegate.getUseCaches();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setAllowUserInteraction(boolean z) {
        this.delegate.setAllowUserInteraction(z);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setChunkedStreamingMode(int i) {
        this.delegate.setChunkedStreamingMode(i);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setConnectTimeout(int i) {
        this.delegate.setConnectTimeout(i);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setDefaultUseCaches(boolean z) {
        this.delegate.setDefaultUseCaches(z);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setDoInput(boolean z) {
        this.delegate.setDoInput(z);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setDoOutput(boolean z) {
        this.delegate.setDoOutput(z);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setFixedLengthStreamingMode(int i) {
        this.delegate.setFixedLengthStreamingMode(i);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setFixedLengthStreamingMode(long l) {
        this.delegate.setFixedLengthStreamingMode(l);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.httpsURLConnection.setHostnameVerifier(hostnameVerifier);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setIfModifiedSince(long l) {
        this.delegate.setIfModifiedSince(l);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        this.delegate.setInstanceFollowRedirects(z);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setReadTimeout(int i) {
        this.delegate.setReadTimeout(i);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setRequestMethod(String string) {
        this.delegate.setRequestMethod(string);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setRequestProperty(String string, String string2) {
        this.delegate.setRequestProperty(string, string2);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setUseCaches(boolean z) {
        this.delegate.setUseCaches(z);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String toString() {
        return this.delegate.toString();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public boolean usingProxy() {
        return this.delegate.usingProxy();
    }
}
