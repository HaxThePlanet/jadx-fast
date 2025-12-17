package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.net.URL;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes2.dex */
public class FirebasePerfOkHttpClient {
    public static void enqueue(Call call, Callback callback2) {
        Timer timer = new Timer();
        super(callback2, TransportManager.getInstance(), timer, timer.getMicros(), obj5);
        call.enqueue(instrumentOkHttpEnqueueCallback2);
    }

    public static Response execute(Call call) {
        Throwable th;
        HttpUrl durationMicros;
        Timer timer = new Timer();
        final Response execute = call.execute();
        FirebasePerfOkHttpClient.sendNetworkMetric(execute, NetworkRequestMetricBuilder.builder(TransportManager.getInstance()), timer.getMicros(), obj4);
        return execute;
    }

    static void sendNetworkMetric(Response response, NetworkRequestMetricBuilder networkRequestMetricBuilder2, long l3, long l4) {
        Request contentLength;
        Object contentType;
        RequestBody body;
        int contentLength2;
        contentLength = response.request();
        if (contentLength == null) {
        }
        networkRequestMetricBuilder2.setUrl(contentLength.url().url().toString());
        networkRequestMetricBuilder2.setHttpMethod(contentLength.method());
        body = contentLength.body();
        final int i = -1;
        contentLength = contentLength.body().contentLength();
        if (body != null && Long.compare(contentLength, i) != 0) {
            contentLength = contentLength.body().contentLength();
            if (Long.compare(contentLength, i) != 0) {
                networkRequestMetricBuilder2.setRequestPayloadBytes(contentLength);
            }
        }
        contentType = response.body();
        contentLength2 = contentType.contentLength();
        if (contentType != null && Long.compare(contentLength2, i) != 0) {
            contentLength2 = contentType.contentLength();
            if (Long.compare(contentLength2, i) != 0) {
                networkRequestMetricBuilder2.setResponsePayloadBytes(contentLength2);
            }
            contentType = contentType.contentType();
            if (contentType != null) {
                networkRequestMetricBuilder2.setResponseContentType(contentType.toString());
            }
        }
        networkRequestMetricBuilder2.setHttpResponseCode(response.code());
        networkRequestMetricBuilder2.setRequestStartTimeMicros(l3);
        networkRequestMetricBuilder2.setTimeToResponseCompletedMicros(obj10);
        networkRequestMetricBuilder2.build();
    }
}
