package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;

/* loaded from: classes2.dex */
public class InstrumentApacheHttpResponseHandler<T>  implements ResponseHandler<T> {

    private final NetworkRequestMetricBuilder networkMetricBuilder;
    private final ResponseHandler<? extends T> responseHandlerDelegate;
    private final Timer timer;
    public InstrumentApacheHttpResponseHandler(ResponseHandler<? extends T> responseHandler, Timer timer2, NetworkRequestMetricBuilder networkRequestMetricBuilder3) {
        super();
        this.responseHandlerDelegate = responseHandler;
        this.timer = timer2;
        this.networkMetricBuilder = networkRequestMetricBuilder3;
    }

    public T handleResponse(HttpResponse httpResponse) {
        int networkMetricBuilder;
        long longValue;
        this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
        this.networkMetricBuilder.setHttpResponseCode(httpResponse.getStatusLine().getStatusCode());
        Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpResponse);
        if (apacheHttpMessageContentLength != null) {
            this.networkMetricBuilder.setResponsePayloadBytes(apacheHttpMessageContentLength.longValue());
        }
        String apacheHttpResponseContentType = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(httpResponse);
        if (apacheHttpResponseContentType != null) {
            this.networkMetricBuilder.setResponseContentType(apacheHttpResponseContentType);
        }
        this.networkMetricBuilder.build();
        return this.responseHandlerDelegate.handleResponse(httpResponse);
    }
}
