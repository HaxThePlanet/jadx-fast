package com.google.firebase.perf.network;

import android.os.Build.VERSION;
import com.google.firebase.perf.logging.AndroidLogger;
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
class InstrURLConnectionBase {

    private static final String USER_AGENT_PROPERTY = "User-Agent";
    private static final AndroidLogger logger;
    private final HttpURLConnection httpUrlConnection;
    private final NetworkRequestMetricBuilder networkMetricBuilder;
    private long timeRequestedInMicros = -1;
    private long timeToResponseInitiatedInMicros = -1;
    private final Timer timer;
    static {
        InstrURLConnectionBase.logger = AndroidLogger.getInstance();
    }

    public InstrURLConnectionBase(HttpURLConnection httpURLConnection, Timer timer2, NetworkRequestMetricBuilder networkRequestMetricBuilder3) {
        super();
        final int i = -1;
        this.httpUrlConnection = httpURLConnection;
        this.networkMetricBuilder = networkRequestMetricBuilder3;
        this.timer = timer2;
        networkRequestMetricBuilder3.setUrl(httpURLConnection.getURL().toString());
    }

    private void updateRequestInfo() {
        int micros;
        Object networkMetricBuilder2;
        Object networkMetricBuilder;
        int networkMetricBuilder3;
        if (Long.compare(timeRequestedInMicros, networkMetricBuilder3) == 0) {
            this.timer.reset();
            micros = this.timer.getMicros();
            this.timeRequestedInMicros = micros;
            this.networkMetricBuilder.setRequestStartTimeMicros(micros);
        }
        networkMetricBuilder2 = getRequestMethod();
        if (networkMetricBuilder2 != null) {
            this.networkMetricBuilder.setHttpMethod(networkMetricBuilder2);
        } else {
            if (getDoOutput()) {
                this.networkMetricBuilder.setHttpMethod("POST");
            } else {
                this.networkMetricBuilder.setHttpMethod("GET");
            }
        }
    }

    public void addRequestProperty(String string, String string2) {
        this.httpUrlConnection.addRequestProperty(string, string2);
    }

    public void connect() {
        int micros;
        int networkMetricBuilder;
        if (Long.compare(timeRequestedInMicros, networkMetricBuilder) == 0) {
            this.timer.reset();
            micros = this.timer.getMicros();
            this.timeRequestedInMicros = micros;
            this.networkMetricBuilder.setRequestStartTimeMicros(micros);
        }
        this.httpUrlConnection.connect();
    }

    public void disconnect() {
        this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
        this.networkMetricBuilder.build();
        this.httpUrlConnection.disconnect();
    }

    public boolean equals(Object object) {
        return this.httpUrlConnection.equals(object);
    }

    public boolean getAllowUserInteraction() {
        return this.httpUrlConnection.getAllowUserInteraction();
    }

    public int getConnectTimeout() {
        return this.httpUrlConnection.getConnectTimeout();
    }

    public Object getContent() {
        Object content;
        Object instrHttpInputStream;
        NetworkRequestMetricBuilder networkMetricBuilder;
        Timer timer;
        updateRequestInfo();
        this.networkMetricBuilder.setHttpResponseCode(this.httpUrlConnection.getResponseCode());
        content = this.httpUrlConnection.getContent();
        if (content instanceof InputStream != null) {
            this.networkMetricBuilder.setResponseContentType(this.httpUrlConnection.getContentType());
            instrHttpInputStream = new InstrHttpInputStream((InputStream)content, this.networkMetricBuilder, this.timer);
            content = instrHttpInputStream;
        } else {
            this.networkMetricBuilder.setResponseContentType(this.httpUrlConnection.getContentType());
            this.networkMetricBuilder.setResponsePayloadBytes((long)contentLength);
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            this.networkMetricBuilder.build();
        }
        return content;
    }

    public Object getContent(Class[] classArr) {
        Object instrHttpInputStream;
        NetworkRequestMetricBuilder networkMetricBuilder;
        Timer timer;
        Object obj4;
        updateRequestInfo();
        this.networkMetricBuilder.setHttpResponseCode(this.httpUrlConnection.getResponseCode());
        obj4 = this.httpUrlConnection.getContent(classArr);
        if (obj4 instanceof InputStream != null) {
            this.networkMetricBuilder.setResponseContentType(this.httpUrlConnection.getContentType());
            instrHttpInputStream = new InstrHttpInputStream((InputStream)obj4, this.networkMetricBuilder, this.timer);
            obj4 = instrHttpInputStream;
        } else {
            this.networkMetricBuilder.setResponseContentType(this.httpUrlConnection.getContentType());
            this.networkMetricBuilder.setResponsePayloadBytes((long)contentLength);
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            this.networkMetricBuilder.build();
        }
        return obj4;
    }

    public String getContentEncoding() {
        updateRequestInfo();
        return this.httpUrlConnection.getContentEncoding();
    }

    public int getContentLength() {
        updateRequestInfo();
        return this.httpUrlConnection.getContentLength();
    }

    public long getContentLengthLong() {
        long contentLengthLong;
        updateRequestInfo();
        if (Build.VERSION.SDK_INT >= 24) {
            contentLengthLong = this.httpUrlConnection.getContentLengthLong();
        } else {
            contentLengthLong = 0;
        }
        return contentLengthLong;
    }

    public String getContentType() {
        updateRequestInfo();
        return this.httpUrlConnection.getContentType();
    }

    public long getDate() {
        updateRequestInfo();
        return this.httpUrlConnection.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.httpUrlConnection.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.httpUrlConnection.getDoInput();
    }

    public boolean getDoOutput() {
        return this.httpUrlConnection.getDoOutput();
    }

    public InputStream getErrorStream() {
        NetworkRequestMetricBuilder networkMetricBuilder;
        int responseCode;
        updateRequestInfo();
        this.networkMetricBuilder.setHttpResponseCode(this.httpUrlConnection.getResponseCode());
        InputStream errorStream = this.httpUrlConnection.getErrorStream();
        if (errorStream != null) {
            try {
                InstrHttpInputStream instrHttpInputStream = new InstrHttpInputStream(errorStream, this.networkMetricBuilder, this.timer);
                return instrHttpInputStream;
                return errorStream;
            }
        }
    }

    public long getExpiration() {
        updateRequestInfo();
        return this.httpUrlConnection.getExpiration();
    }

    public String getHeaderField(int i) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderField(i);
    }

    public String getHeaderField(String string) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderField(string);
    }

    public long getHeaderFieldDate(String string, long l2) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderFieldDate(string, l2);
    }

    public int getHeaderFieldInt(String string, int i2) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderFieldInt(string, i2);
    }

    public String getHeaderFieldKey(int i) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderFieldKey(i);
    }

    public long getHeaderFieldLong(String string, long l2) {
        HttpURLConnection httpUrlConnection;
        long obj3;
        updateRequestInfo();
        if (Build.VERSION.SDK_INT >= 24) {
            obj3 = this.httpUrlConnection.getHeaderFieldLong(string, l2);
        } else {
            obj3 = 0;
        }
        return obj3;
    }

    public Map<String, List<String>> getHeaderFields() {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderFields();
    }

    public long getIfModifiedSince() {
        return this.httpUrlConnection.getIfModifiedSince();
    }

    public InputStream getInputStream() {
        updateRequestInfo();
        this.networkMetricBuilder.setHttpResponseCode(this.httpUrlConnection.getResponseCode());
        this.networkMetricBuilder.setResponseContentType(this.httpUrlConnection.getContentType());
        InstrHttpInputStream instrHttpInputStream = new InstrHttpInputStream(this.httpUrlConnection.getInputStream(), this.networkMetricBuilder, this.timer);
        return instrHttpInputStream;
    }

    public boolean getInstanceFollowRedirects() {
        return this.httpUrlConnection.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        updateRequestInfo();
        return this.httpUrlConnection.getLastModified();
    }

    public OutputStream getOutputStream() {
        try {
            InstrHttpOutputStream instrHttpOutputStream = new InstrHttpOutputStream(this.httpUrlConnection.getOutputStream(), this.networkMetricBuilder, this.timer);
            return instrHttpOutputStream;
            NetworkRequestMetricBuilder networkMetricBuilder = this.networkMetricBuilder;
            Timer durationMicros = this.timer;
            durationMicros = durationMicros.getDurationMicros();
            networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
            networkMetricBuilder = this.networkMetricBuilder;
            NetworkRequestMetricBuilderUtil.logError(networkMetricBuilder);
            throw th;
        }
    }

    public Permission getPermission() {
        try {
            return this.httpUrlConnection.getPermission();
            NetworkRequestMetricBuilder networkMetricBuilder = this.networkMetricBuilder;
            Timer durationMicros = this.timer;
            durationMicros = durationMicros.getDurationMicros();
            networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
            networkMetricBuilder = this.networkMetricBuilder;
            NetworkRequestMetricBuilderUtil.logError(networkMetricBuilder);
            throw th;
        }
    }

    public int getReadTimeout() {
        return this.httpUrlConnection.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.httpUrlConnection.getRequestMethod();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.httpUrlConnection.getRequestProperties();
    }

    public String getRequestProperty(String string) {
        return this.httpUrlConnection.getRequestProperty(string);
    }

    public int getResponseCode() {
        int durationMicros;
        int networkMetricBuilder;
        updateRequestInfo();
        if (Long.compare(timeToResponseInitiatedInMicros, networkMetricBuilder) == 0) {
            durationMicros = this.timer.getDurationMicros();
            this.timeToResponseInitiatedInMicros = durationMicros;
            this.networkMetricBuilder.setTimeToResponseInitiatedMicros(durationMicros);
        }
        int responseCode = this.httpUrlConnection.getResponseCode();
        this.networkMetricBuilder.setHttpResponseCode(responseCode);
        return responseCode;
    }

    public String getResponseMessage() {
        int durationMicros;
        int networkMetricBuilder;
        updateRequestInfo();
        if (Long.compare(timeToResponseInitiatedInMicros, networkMetricBuilder) == 0) {
            durationMicros = this.timer.getDurationMicros();
            this.timeToResponseInitiatedInMicros = durationMicros;
            this.networkMetricBuilder.setTimeToResponseInitiatedMicros(durationMicros);
        }
        this.networkMetricBuilder.setHttpResponseCode(this.httpUrlConnection.getResponseCode());
        return this.httpUrlConnection.getResponseMessage();
    }

    public URL getURL() {
        return this.httpUrlConnection.getURL();
    }

    public boolean getUseCaches() {
        return this.httpUrlConnection.getUseCaches();
    }

    public int hashCode() {
        return this.httpUrlConnection.hashCode();
    }

    public void setAllowUserInteraction(boolean z) {
        this.httpUrlConnection.setAllowUserInteraction(z);
    }

    public void setChunkedStreamingMode(int i) {
        this.httpUrlConnection.setChunkedStreamingMode(i);
    }

    public void setConnectTimeout(int i) {
        this.httpUrlConnection.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean z) {
        this.httpUrlConnection.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.httpUrlConnection.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.httpUrlConnection.setDoOutput(z);
    }

    public void setFixedLengthStreamingMode(int i) {
        this.httpUrlConnection.setFixedLengthStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(long l) {
        int httpUrlConnection;
        if (Build.VERSION.SDK_INT >= 19) {
            this.httpUrlConnection.setFixedLengthStreamingMode(l);
        }
    }

    public void setIfModifiedSince(long l) {
        this.httpUrlConnection.setIfModifiedSince(l);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.httpUrlConnection.setInstanceFollowRedirects(z);
    }

    public void setReadTimeout(int i) {
        this.httpUrlConnection.setReadTimeout(i);
    }

    public void setRequestMethod(String string) {
        this.httpUrlConnection.setRequestMethod(string);
    }

    public void setRequestProperty(String string, String string2) {
        boolean networkMetricBuilder;
        if ("User-Agent".equalsIgnoreCase(string)) {
            this.networkMetricBuilder.setUserAgent(string2);
        }
        this.httpUrlConnection.setRequestProperty(string, string2);
    }

    public void setUseCaches(boolean z) {
        this.httpUrlConnection.setUseCaches(z);
    }

    public String toString() {
        return this.httpUrlConnection.toString();
    }

    public boolean usingProxy() {
        return this.httpUrlConnection.usingProxy();
    }
}
