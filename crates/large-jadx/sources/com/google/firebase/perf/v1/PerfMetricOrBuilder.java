package com.google.firebase.perf.v1;

import com.google.protobuf.t0;
import com.google.protobuf.u0;

/* loaded from: classes2.dex */
public interface PerfMetricOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.ApplicationInfo getApplicationInfo();

    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.GaugeMetric getGaugeMetric();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.NetworkRequestMetric getNetworkRequestMetric();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.TraceMetric getTraceMetric();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.TransportInfo getTransportInfo();

    @Override // com.google.protobuf.u0
    public abstract boolean hasApplicationInfo();

    @Override // com.google.protobuf.u0
    public abstract boolean hasGaugeMetric();

    @Override // com.google.protobuf.u0
    public abstract boolean hasNetworkRequestMetric();

    @Override // com.google.protobuf.u0
    public abstract boolean hasTraceMetric();

    @Override // com.google.protobuf.u0
    public abstract boolean hasTransportInfo();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
