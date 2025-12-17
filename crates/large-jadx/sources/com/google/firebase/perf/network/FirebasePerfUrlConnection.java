package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.URLWrapper;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes2.dex */
public class FirebasePerfUrlConnection {
    static Object getContent(URLWrapper uRLWrapper, TransportManager transportManager2, Timer timer3) {
        timer3.reset();
        final long micros = timer3.getMicros();
        final NetworkRequestMetricBuilder obj5 = NetworkRequestMetricBuilder.builder(transportManager2);
        final URLConnection connection = uRLWrapper.openConnection();
        if (connection instanceof HttpsURLConnection) {
            InstrHttpsURLConnection instrHttpsURLConnection = new InstrHttpsURLConnection((HttpsURLConnection)connection, timer3, obj5);
            return instrHttpsURLConnection.getContent();
        }
        if (connection instanceof HttpURLConnection) {
            InstrHttpURLConnection instrHttpURLConnection = new InstrHttpURLConnection((HttpURLConnection)connection, timer3, obj5);
            return instrHttpURLConnection.getContent();
        }
        return connection.getContent();
    }

    static Object getContent(URLWrapper uRLWrapper, Class[] class2Arr2, TransportManager transportManager3, Timer timer4) {
        timer4.reset();
        final long micros = timer4.getMicros();
        final NetworkRequestMetricBuilder obj6 = NetworkRequestMetricBuilder.builder(transportManager3);
        final URLConnection connection = uRLWrapper.openConnection();
        if (connection instanceof HttpsURLConnection) {
            InstrHttpsURLConnection instrHttpsURLConnection = new InstrHttpsURLConnection((HttpsURLConnection)connection, timer4, obj6);
            return instrHttpsURLConnection.getContent(class2Arr2);
        }
        if (connection instanceof HttpURLConnection) {
            InstrHttpURLConnection instrHttpURLConnection = new InstrHttpURLConnection((HttpURLConnection)connection, timer4, obj6);
            return instrHttpURLConnection.getContent(class2Arr2);
        }
        return connection.getContent(class2Arr2);
    }

    public static Object getContent(URL uRL) {
        URLWrapper uRLWrapper = new URLWrapper(uRL);
        Timer timer = new Timer();
        return FirebasePerfUrlConnection.getContent(uRLWrapper, TransportManager.getInstance(), timer);
    }

    public static Object getContent(URL uRL, Class[] class2Arr2) {
        URLWrapper uRLWrapper = new URLWrapper(uRL);
        Timer timer = new Timer();
        return FirebasePerfUrlConnection.getContent(uRLWrapper, class2Arr2, TransportManager.getInstance(), timer);
    }

    public static Object instrument(Object object) {
        if (object instanceof HttpsURLConnection) {
            Timer timer = new Timer();
            InstrHttpsURLConnection instrHttpsURLConnection = new InstrHttpsURLConnection((HttpsURLConnection)object, timer, NetworkRequestMetricBuilder.builder(TransportManager.getInstance()));
            return instrHttpsURLConnection;
        }
        if (object instanceof HttpURLConnection) {
            Timer timer2 = new Timer();
            InstrHttpURLConnection instrHttpURLConnection = new InstrHttpURLConnection((HttpURLConnection)object, timer2, NetworkRequestMetricBuilder.builder(TransportManager.getInstance()));
            return instrHttpURLConnection;
        }
        return object;
    }

    static InputStream openStream(URLWrapper uRLWrapper, TransportManager transportManager2, Timer timer3) {
        timer3.reset();
        final long micros = timer3.getMicros();
        final NetworkRequestMetricBuilder obj5 = NetworkRequestMetricBuilder.builder(transportManager2);
        final URLConnection connection = uRLWrapper.openConnection();
        if (connection instanceof HttpsURLConnection) {
            InstrHttpsURLConnection instrHttpsURLConnection = new InstrHttpsURLConnection((HttpsURLConnection)connection, timer3, obj5);
            return instrHttpsURLConnection.getInputStream();
        }
        if (connection instanceof HttpURLConnection) {
            InstrHttpURLConnection instrHttpURLConnection = new InstrHttpURLConnection((HttpURLConnection)connection, timer3, obj5);
            return instrHttpURLConnection.getInputStream();
        }
        return connection.getInputStream();
    }

    public static InputStream openStream(URL uRL) {
        URLWrapper uRLWrapper = new URLWrapper(uRL);
        Timer timer = new Timer();
        return FirebasePerfUrlConnection.openStream(uRLWrapper, TransportManager.getInstance(), timer);
    }
}
