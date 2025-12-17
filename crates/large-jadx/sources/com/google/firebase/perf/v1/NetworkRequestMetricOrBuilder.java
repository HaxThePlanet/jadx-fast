package com.google.firebase.perf.v1;

import com.google.protobuf.j;
import com.google.protobuf.t0;
import com.google.protobuf.u0;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface NetworkRequestMetricOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract boolean containsCustomAttributes(String string);

    @Override // com.google.protobuf.u0
    public abstract long getClientStartTimeUs();

    @Deprecated
    public abstract Map<String, String> getCustomAttributes();

    @Override // com.google.protobuf.u0
    public abstract int getCustomAttributesCount();

    public abstract Map<String, String> getCustomAttributesMap();

    @Override // com.google.protobuf.u0
    public abstract String getCustomAttributesOrDefault(String string, String string2);

    @Override // com.google.protobuf.u0
    public abstract String getCustomAttributesOrThrow(String string);

    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod getHttpMethod();

    @Override // com.google.protobuf.u0
    public abstract int getHttpResponseCode();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.NetworkRequestMetric.NetworkClientErrorReason getNetworkClientErrorReason();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.PerfSession getPerfSessions(int i);

    @Override // com.google.protobuf.u0
    public abstract int getPerfSessionsCount();

    public abstract List<com.google.firebase.perf.v1.PerfSession> getPerfSessionsList();

    @Override // com.google.protobuf.u0
    public abstract long getRequestPayloadBytes();

    @Override // com.google.protobuf.u0
    public abstract String getResponseContentType();

    @Override // com.google.protobuf.u0
    public abstract j getResponseContentTypeBytes();

    @Override // com.google.protobuf.u0
    public abstract long getResponsePayloadBytes();

    @Override // com.google.protobuf.u0
    public abstract long getTimeToRequestCompletedUs();

    @Override // com.google.protobuf.u0
    public abstract long getTimeToResponseCompletedUs();

    @Override // com.google.protobuf.u0
    public abstract long getTimeToResponseInitiatedUs();

    @Override // com.google.protobuf.u0
    public abstract String getUrl();

    @Override // com.google.protobuf.u0
    public abstract j getUrlBytes();

    @Override // com.google.protobuf.u0
    public abstract boolean hasClientStartTimeUs();

    @Override // com.google.protobuf.u0
    public abstract boolean hasHttpMethod();

    @Override // com.google.protobuf.u0
    public abstract boolean hasHttpResponseCode();

    @Override // com.google.protobuf.u0
    public abstract boolean hasNetworkClientErrorReason();

    @Override // com.google.protobuf.u0
    public abstract boolean hasRequestPayloadBytes();

    @Override // com.google.protobuf.u0
    public abstract boolean hasResponseContentType();

    @Override // com.google.protobuf.u0
    public abstract boolean hasResponsePayloadBytes();

    @Override // com.google.protobuf.u0
    public abstract boolean hasTimeToRequestCompletedUs();

    @Override // com.google.protobuf.u0
    public abstract boolean hasTimeToResponseCompletedUs();

    @Override // com.google.protobuf.u0
    public abstract boolean hasTimeToResponseInitiatedUs();

    @Override // com.google.protobuf.u0
    public abstract boolean hasUrl();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
