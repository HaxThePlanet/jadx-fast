package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.net.URL;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
public class InstrumentOkHttpEnqueueCallback implements Callback {

    private final Callback callback;
    private final NetworkRequestMetricBuilder networkMetricBuilder;
    private final long startTimeMicros;
    private final Timer timer;
    public InstrumentOkHttpEnqueueCallback(Callback callback, TransportManager transportManager2, Timer timer3, long l4) {
        super();
        this.callback = callback;
        this.networkMetricBuilder = NetworkRequestMetricBuilder.builder(transportManager2);
        this.startTimeMicros = l4;
        this.timer = timer3;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException2) {
        Object request;
        Object string;
        Object networkMetricBuilder2;
        NetworkRequestMetricBuilder networkMetricBuilder;
        request = call.request();
        string = request.url();
        if (request != null && string != null) {
            string = request.url();
            if (string != null) {
                this.networkMetricBuilder.setUrl(string.url().toString());
            }
            if (request.method() != null) {
                this.networkMetricBuilder.setHttpMethod(request.method());
            }
        }
        this.networkMetricBuilder.setRequestStartTimeMicros(this.startTimeMicros);
        this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
        NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
        this.callback.onFailure(call, iOException2);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response2) {
        FirebasePerfOkHttpClient.sendNetworkMetric(response2, this.networkMetricBuilder, this.startTimeMicros, obj4);
        this.callback.onResponse(call, response2);
    }
}
