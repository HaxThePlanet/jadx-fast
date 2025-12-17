package com.google.firebase.perf.v1;

import com.google.protobuf.j;
import com.google.protobuf.t0;
import com.google.protobuf.u0;
import java.util.List;

/* loaded from: classes2.dex */
public interface GaugeMetricOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.AndroidMemoryReading getAndroidMemoryReadings(int i);

    @Override // com.google.protobuf.u0
    public abstract int getAndroidMemoryReadingsCount();

    public abstract List<com.google.firebase.perf.v1.AndroidMemoryReading> getAndroidMemoryReadingsList();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.CpuMetricReading getCpuMetricReadings(int i);

    @Override // com.google.protobuf.u0
    public abstract int getCpuMetricReadingsCount();

    public abstract List<com.google.firebase.perf.v1.CpuMetricReading> getCpuMetricReadingsList();

    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.GaugeMetadata getGaugeMetadata();

    @Override // com.google.protobuf.u0
    public abstract String getSessionId();

    @Override // com.google.protobuf.u0
    public abstract j getSessionIdBytes();

    @Override // com.google.protobuf.u0
    public abstract boolean hasGaugeMetadata();

    @Override // com.google.protobuf.u0
    public abstract boolean hasSessionId();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
