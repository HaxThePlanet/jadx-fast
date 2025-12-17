package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.net.URI;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes2.dex */
public class FirebasePerfHttpClient {
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost2, HttpRequest httpRequest3, ResponseHandler<? extends T> responseHandler4) {
        Timer timer = new Timer();
        return FirebasePerfHttpClient.execute(httpClient, httpHost2, httpRequest3, responseHandler4, timer, TransportManager.getInstance());
    }

    static <T> T execute(HttpClient httpClient, HttpHost httpHost2, HttpRequest httpRequest3, ResponseHandler<? extends T> responseHandler4, Timer timer5, TransportManager transportManager6) {
        Long apacheHttpMessageContentLength;
        final NetworkRequestMetricBuilder obj7 = NetworkRequestMetricBuilder.builder(transportManager6);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(httpHost2.toURI());
        stringBuilder.append(httpRequest3.getRequestLine().getUri());
        String method = httpRequest3.getRequestLine().getMethod();
        obj7.setUrl(stringBuilder.toString()).setHttpMethod(method);
        apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest3);
        if (apacheHttpMessageContentLength != null) {
            obj7.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
        }
        timer5.reset();
        obj7.setRequestStartTimeMicros(timer5.getMicros());
        InstrumentApacheHttpResponseHandler instrumentApacheHttpResponseHandler = new InstrumentApacheHttpResponseHandler(responseHandler4, timer5, obj7);
        return httpClient.execute(httpHost2, httpRequest3, instrumentApacheHttpResponseHandler);
    }

    public static <T> T execute(HttpClient httpClient, HttpHost httpHost2, HttpRequest httpRequest3, ResponseHandler<? extends T> responseHandler4, HttpContext httpContext5) {
        Timer timer = new Timer();
        return FirebasePerfHttpClient.execute(httpClient, httpHost2, httpRequest3, responseHandler4, httpContext5, timer, TransportManager.getInstance());
    }

    static <T> T execute(HttpClient httpClient, HttpHost httpHost2, HttpRequest httpRequest3, ResponseHandler<? extends T> responseHandler4, HttpContext httpContext5, Timer timer6, TransportManager transportManager7) {
        Long apacheHttpMessageContentLength;
        final NetworkRequestMetricBuilder obj8 = NetworkRequestMetricBuilder.builder(transportManager7);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(httpHost2.toURI());
        stringBuilder.append(httpRequest3.getRequestLine().getUri());
        String method = httpRequest3.getRequestLine().getMethod();
        obj8.setUrl(stringBuilder.toString()).setHttpMethod(method);
        apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest3);
        if (apacheHttpMessageContentLength != null) {
            obj8.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
        }
        timer6.reset();
        obj8.setRequestStartTimeMicros(timer6.getMicros());
        InstrumentApacheHttpResponseHandler instrumentApacheHttpResponseHandler = new InstrumentApacheHttpResponseHandler(responseHandler4, timer6, obj8);
        return httpClient.execute(httpHost2, httpRequest3, instrumentApacheHttpResponseHandler, httpContext5);
    }

    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest2, ResponseHandler<T> responseHandler3) {
        Timer timer = new Timer();
        return FirebasePerfHttpClient.execute(httpClient, httpUriRequest2, responseHandler3, timer, TransportManager.getInstance());
    }

    static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest2, ResponseHandler<T> responseHandler3, Timer timer4, TransportManager transportManager5) {
        Long apacheHttpMessageContentLength;
        final NetworkRequestMetricBuilder obj6 = NetworkRequestMetricBuilder.builder(transportManager5);
        final String method = httpUriRequest2.getMethod();
        obj6.setUrl(httpUriRequest2.getURI().toString()).setHttpMethod(method);
        apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest2);
        if (apacheHttpMessageContentLength != null) {
            obj6.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
        }
        timer4.reset();
        obj6.setRequestStartTimeMicros(timer4.getMicros());
        InstrumentApacheHttpResponseHandler instrumentApacheHttpResponseHandler = new InstrumentApacheHttpResponseHandler(responseHandler3, timer4, obj6);
        return httpClient.execute(httpUriRequest2, instrumentApacheHttpResponseHandler);
    }

    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest2, ResponseHandler<T> responseHandler3, HttpContext httpContext4) {
        Timer timer = new Timer();
        return FirebasePerfHttpClient.execute(httpClient, httpUriRequest2, responseHandler3, httpContext4, timer, TransportManager.getInstance());
    }

    static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest2, ResponseHandler<T> responseHandler3, HttpContext httpContext4, Timer timer5, TransportManager transportManager6) {
        Long apacheHttpMessageContentLength;
        final NetworkRequestMetricBuilder obj7 = NetworkRequestMetricBuilder.builder(transportManager6);
        final String method = httpUriRequest2.getMethod();
        obj7.setUrl(httpUriRequest2.getURI().toString()).setHttpMethod(method);
        apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest2);
        if (apacheHttpMessageContentLength != null) {
            obj7.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
        }
        timer5.reset();
        obj7.setRequestStartTimeMicros(timer5.getMicros());
        InstrumentApacheHttpResponseHandler instrumentApacheHttpResponseHandler = new InstrumentApacheHttpResponseHandler(responseHandler3, timer5, obj7);
        return httpClient.execute(httpUriRequest2, instrumentApacheHttpResponseHandler, httpContext4);
    }

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost2, HttpRequest httpRequest3) {
        Timer timer = new Timer();
        return FirebasePerfHttpClient.execute(httpClient, httpHost2, httpRequest3, timer, TransportManager.getInstance());
    }

    static HttpResponse execute(HttpClient httpClient, HttpHost httpHost2, HttpRequest httpRequest3, Timer timer4, TransportManager transportManager5) {
        Long apacheHttpMessageContentLength;
        Long obj3;
        final NetworkRequestMetricBuilder obj6 = NetworkRequestMetricBuilder.builder(transportManager5);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(httpHost2.toURI());
        stringBuilder.append(httpRequest3.getRequestLine().getUri());
        String method = httpRequest3.getRequestLine().getMethod();
        obj6.setUrl(stringBuilder.toString()).setHttpMethod(method);
        apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest3);
        if (apacheHttpMessageContentLength != null) {
            obj6.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
        }
        timer4.reset();
        obj6.setRequestStartTimeMicros(timer4.getMicros());
        final HttpResponse obj2 = httpClient.execute(httpHost2, httpRequest3);
        obj6.setTimeToResponseCompletedMicros(timer4.getDurationMicros());
        obj6.setHttpResponseCode(obj2.getStatusLine().getStatusCode());
        obj3 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(obj2);
        if (obj3 != null) {
            obj6.setResponsePayloadBytes(obj3.longValue());
        }
        try {
            obj3 = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(obj2);
            if (obj3 != null) {
            }
            obj6.setResponseContentType(obj3);
            obj6.build();
            return obj2;
            httpHost2 = timer4.getDurationMicros();
            transportManager5.setTimeToResponseCompletedMicros(httpHost2);
            NetworkRequestMetricBuilderUtil.logError(transportManager5);
            throw httpClient;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost2, HttpRequest httpRequest3, HttpContext httpContext4) {
        Timer timer = new Timer();
        return FirebasePerfHttpClient.execute(httpClient, httpHost2, httpRequest3, httpContext4, timer, TransportManager.getInstance());
    }

    static HttpResponse execute(HttpClient httpClient, HttpHost httpHost2, HttpRequest httpRequest3, HttpContext httpContext4, Timer timer5, TransportManager transportManager6) {
        Long apacheHttpMessageContentLength;
        Long obj3;
        final NetworkRequestMetricBuilder obj7 = NetworkRequestMetricBuilder.builder(transportManager6);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(httpHost2.toURI());
        stringBuilder.append(httpRequest3.getRequestLine().getUri());
        String method = httpRequest3.getRequestLine().getMethod();
        obj7.setUrl(stringBuilder.toString()).setHttpMethod(method);
        apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest3);
        if (apacheHttpMessageContentLength != null) {
            obj7.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
        }
        timer5.reset();
        obj7.setRequestStartTimeMicros(timer5.getMicros());
        final HttpResponse obj2 = httpClient.execute(httpHost2, httpRequest3, httpContext4);
        obj7.setTimeToResponseCompletedMicros(timer5.getDurationMicros());
        obj7.setHttpResponseCode(obj2.getStatusLine().getStatusCode());
        obj3 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(obj2);
        if (obj3 != null) {
            obj7.setResponsePayloadBytes(obj3.longValue());
        }
        try {
            obj3 = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(obj2);
            if (obj3 != null) {
            }
            obj7.setResponseContentType(obj3);
            obj7.build();
            return obj2;
            httpHost2 = timer5.getDurationMicros();
            transportManager6.setTimeToResponseCompletedMicros(httpHost2);
            NetworkRequestMetricBuilderUtil.logError(transportManager6);
            throw httpClient;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest2) {
        Timer timer = new Timer();
        return FirebasePerfHttpClient.execute(httpClient, httpUriRequest2, timer, TransportManager.getInstance());
    }

    static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest2, Timer timer3, TransportManager transportManager4) {
        Long apacheHttpMessageContentLength;
        long durationMicros;
        final NetworkRequestMetricBuilder obj5 = NetworkRequestMetricBuilder.builder(transportManager4);
        final String method = httpUriRequest2.getMethod();
        obj5.setUrl(httpUriRequest2.getURI().toString()).setHttpMethod(method);
        apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest2);
        if (apacheHttpMessageContentLength != null) {
            obj5.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
        }
        timer3.reset();
        obj5.setRequestStartTimeMicros(timer3.getMicros());
        final HttpResponse obj2 = httpClient.execute(httpUriRequest2);
        obj5.setTimeToResponseCompletedMicros(timer3.getDurationMicros());
        obj5.setHttpResponseCode(obj2.getStatusLine().getStatusCode());
        Long obj3 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(obj2);
        if (obj3 != null) {
            obj5.setResponsePayloadBytes(obj3.longValue());
        }
        try {
            obj3 = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(obj2);
            if (obj3 != null) {
            }
            obj5.setResponseContentType(obj3);
            obj5.build();
            return obj2;
            httpUriRequest2 = timer3.getDurationMicros();
            transportManager4.setTimeToResponseCompletedMicros(httpUriRequest2);
            NetworkRequestMetricBuilderUtil.logError(transportManager4);
            throw httpClient;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest2, HttpContext httpContext3) {
        Timer timer = new Timer();
        return FirebasePerfHttpClient.execute(httpClient, httpUriRequest2, httpContext3, timer, TransportManager.getInstance());
    }

    static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest2, HttpContext httpContext3, Timer timer4, TransportManager transportManager5) {
        Long apacheHttpMessageContentLength;
        Long obj3;
        final NetworkRequestMetricBuilder obj6 = NetworkRequestMetricBuilder.builder(transportManager5);
        final String method = httpUriRequest2.getMethod();
        obj6.setUrl(httpUriRequest2.getURI().toString()).setHttpMethod(method);
        apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest2);
        if (apacheHttpMessageContentLength != null) {
            obj6.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
        }
        timer4.reset();
        obj6.setRequestStartTimeMicros(timer4.getMicros());
        final HttpResponse obj2 = httpClient.execute(httpUriRequest2, httpContext3);
        obj6.setTimeToResponseCompletedMicros(timer4.getDurationMicros());
        obj6.setHttpResponseCode(obj2.getStatusLine().getStatusCode());
        obj3 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(obj2);
        if (obj3 != null) {
            obj6.setResponsePayloadBytes(obj3.longValue());
        }
        try {
            obj3 = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(obj2);
            if (obj3 != null) {
            }
            obj6.setResponseContentType(obj3);
            obj6.build();
            return obj2;
            httpUriRequest2 = timer4.getDurationMicros();
            transportManager5.setTimeToResponseCompletedMicros(httpUriRequest2);
            NetworkRequestMetricBuilderUtil.logError(transportManager5);
            throw httpClient;
        }
    }
}
