package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class InstrHttpURLConnection extends HttpURLConnection {

    private final com.google.firebase.perf.network.InstrURLConnectionBase delegate;
    InstrHttpURLConnection(HttpURLConnection httpURLConnection, Timer timer2, NetworkRequestMetricBuilder networkRequestMetricBuilder3) {
        super(httpURLConnection.getURL());
        InstrURLConnectionBase instrURLConnectionBase = new InstrURLConnectionBase(httpURLConnection, timer2, networkRequestMetricBuilder3);
        this.delegate = instrURLConnectionBase;
    }

    @Override // java.net.HttpURLConnection
    public void addRequestProperty(String string, String string2) {
        this.delegate.addRequestProperty(string, string2);
    }

    @Override // java.net.HttpURLConnection
    public void connect() {
        this.delegate.connect();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        this.delegate.disconnect();
    }

    @Override // java.net.HttpURLConnection
    public boolean equals(Object object) {
        return this.delegate.equals(object);
    }

    @Override // java.net.HttpURLConnection
    public boolean getAllowUserInteraction() {
        return this.delegate.getAllowUserInteraction();
    }

    @Override // java.net.HttpURLConnection
    public int getConnectTimeout() {
        return this.delegate.getConnectTimeout();
    }

    @Override // java.net.HttpURLConnection
    public Object getContent() {
        return this.delegate.getContent();
    }

    @Override // java.net.HttpURLConnection
    public Object getContent(Class[] classArr) {
        return this.delegate.getContent(classArr);
    }

    @Override // java.net.HttpURLConnection
    public String getContentEncoding() {
        return this.delegate.getContentEncoding();
    }

    @Override // java.net.HttpURLConnection
    public int getContentLength() {
        return this.delegate.getContentLength();
    }

    @Override // java.net.HttpURLConnection
    public long getContentLengthLong() {
        return this.delegate.getContentLengthLong();
    }

    @Override // java.net.HttpURLConnection
    public String getContentType() {
        return this.delegate.getContentType();
    }

    @Override // java.net.HttpURLConnection
    public long getDate() {
        return this.delegate.getDate();
    }

    @Override // java.net.HttpURLConnection
    public boolean getDefaultUseCaches() {
        return this.delegate.getDefaultUseCaches();
    }

    @Override // java.net.HttpURLConnection
    public boolean getDoInput() {
        return this.delegate.getDoInput();
    }

    @Override // java.net.HttpURLConnection
    public boolean getDoOutput() {
        return this.delegate.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return this.delegate.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public long getExpiration() {
        return this.delegate.getExpiration();
    }

    @Override // java.net.HttpURLConnection
    public String getHeaderField(int i) {
        return this.delegate.getHeaderField(i);
    }

    @Override // java.net.HttpURLConnection
    public String getHeaderField(String string) {
        return this.delegate.getHeaderField(string);
    }

    @Override // java.net.HttpURLConnection
    public long getHeaderFieldDate(String string, long l2) {
        return this.delegate.getHeaderFieldDate(string, l2);
    }

    @Override // java.net.HttpURLConnection
    public int getHeaderFieldInt(String string, int i2) {
        return this.delegate.getHeaderFieldInt(string, i2);
    }

    @Override // java.net.HttpURLConnection
    public String getHeaderFieldKey(int i) {
        return this.delegate.getHeaderFieldKey(i);
    }

    @Override // java.net.HttpURLConnection
    public long getHeaderFieldLong(String string, long l2) {
        return this.delegate.getHeaderFieldLong(string, l2);
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.delegate.getHeaderFields();
    }

    @Override // java.net.HttpURLConnection
    public long getIfModifiedSince() {
        return this.delegate.getIfModifiedSince();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getInputStream() {
        return this.delegate.getInputStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.delegate.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public long getLastModified() {
        return this.delegate.getLastModified();
    }

    @Override // java.net.HttpURLConnection
    public OutputStream getOutputStream() {
        return this.delegate.getOutputStream();
    }

    @Override // java.net.HttpURLConnection
    public Permission getPermission() {
        return this.delegate.getPermission();
    }

    @Override // java.net.HttpURLConnection
    public int getReadTimeout() {
        return this.delegate.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.delegate.getRequestMethod();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.delegate.getRequestProperties();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestProperty(String string) {
        return this.delegate.getRequestProperty(string);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() {
        return this.delegate.getResponseCode();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() {
        return this.delegate.getResponseMessage();
    }

    @Override // java.net.HttpURLConnection
    public URL getURL() {
        return this.delegate.getURL();
    }

    @Override // java.net.HttpURLConnection
    public boolean getUseCaches() {
        return this.delegate.getUseCaches();
    }

    @Override // java.net.HttpURLConnection
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.net.HttpURLConnection
    public void setAllowUserInteraction(boolean z) {
        this.delegate.setAllowUserInteraction(z);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        this.delegate.setChunkedStreamingMode(i);
    }

    @Override // java.net.HttpURLConnection
    public void setConnectTimeout(int i) {
        this.delegate.setConnectTimeout(i);
    }

    @Override // java.net.HttpURLConnection
    public void setDefaultUseCaches(boolean z) {
        this.delegate.setDefaultUseCaches(z);
    }

    @Override // java.net.HttpURLConnection
    public void setDoInput(boolean z) {
        this.delegate.setDoInput(z);
    }

    @Override // java.net.HttpURLConnection
    public void setDoOutput(boolean z) {
        this.delegate.setDoOutput(z);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        this.delegate.setFixedLengthStreamingMode(i);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long l) {
        this.delegate.setFixedLengthStreamingMode(l);
    }

    @Override // java.net.HttpURLConnection
    public void setIfModifiedSince(long l) {
        this.delegate.setIfModifiedSince(l);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        this.delegate.setInstanceFollowRedirects(z);
    }

    @Override // java.net.HttpURLConnection
    public void setReadTimeout(int i) {
        this.delegate.setReadTimeout(i);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String string) {
        this.delegate.setRequestMethod(string);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestProperty(String string, String string2) {
        this.delegate.setRequestProperty(string, string2);
    }

    @Override // java.net.HttpURLConnection
    public void setUseCaches(boolean z) {
        this.delegate.setUseCaches(z);
    }

    @Override // java.net.HttpURLConnection
    public String toString() {
        return this.delegate.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.delegate.usingProxy();
    }
}
