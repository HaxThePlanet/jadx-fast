package com.google.firebase.perf.v1;

import com.google.protobuf.j;
import com.google.protobuf.t0;
import com.google.protobuf.u0;

/* loaded from: classes2.dex */
public interface GaugeMetadataOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract int getCpuClockRateKhz();

    @Override // com.google.protobuf.u0
    public abstract int getCpuProcessorCount();

    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract int getDeviceRamSizeKb();

    @Override // com.google.protobuf.u0
    public abstract int getMaxAppJavaHeapMemoryKb();

    @Override // com.google.protobuf.u0
    public abstract int getMaxEncouragedAppJavaHeapMemoryKb();

    @Override // com.google.protobuf.u0
    public abstract String getProcessName();

    @Override // com.google.protobuf.u0
    public abstract j getProcessNameBytes();

    @Override // com.google.protobuf.u0
    public abstract boolean hasCpuClockRateKhz();

    @Override // com.google.protobuf.u0
    public abstract boolean hasCpuProcessorCount();

    @Override // com.google.protobuf.u0
    public abstract boolean hasDeviceRamSizeKb();

    @Override // com.google.protobuf.u0
    public abstract boolean hasMaxAppJavaHeapMemoryKb();

    @Override // com.google.protobuf.u0
    public abstract boolean hasMaxEncouragedAppJavaHeapMemoryKb();

    @Override // com.google.protobuf.u0
    public abstract boolean hasProcessName();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
