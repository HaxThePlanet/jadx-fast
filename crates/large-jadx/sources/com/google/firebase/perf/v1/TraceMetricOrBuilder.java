package com.google.firebase.perf.v1;

import com.google.protobuf.j;
import com.google.protobuf.t0;
import com.google.protobuf.u0;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface TraceMetricOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract boolean containsCounters(String string);

    @Override // com.google.protobuf.u0
    public abstract boolean containsCustomAttributes(String string);

    @Override // com.google.protobuf.u0
    public abstract long getClientStartTimeUs();

    @Deprecated
    public abstract Map<String, Long> getCounters();

    @Override // com.google.protobuf.u0
    public abstract int getCountersCount();

    public abstract Map<String, Long> getCountersMap();

    @Override // com.google.protobuf.u0
    public abstract long getCountersOrDefault(String string, long l2);

    @Override // com.google.protobuf.u0
    public abstract long getCountersOrThrow(String string);

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
    public abstract long getDurationUs();

    @Override // com.google.protobuf.u0
    public abstract boolean getIsAuto();

    @Override // com.google.protobuf.u0
    public abstract String getName();

    @Override // com.google.protobuf.u0
    public abstract j getNameBytes();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.PerfSession getPerfSessions(int i);

    @Override // com.google.protobuf.u0
    public abstract int getPerfSessionsCount();

    public abstract List<com.google.firebase.perf.v1.PerfSession> getPerfSessionsList();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.TraceMetric getSubtraces(int i);

    @Override // com.google.protobuf.u0
    public abstract int getSubtracesCount();

    public abstract List<com.google.firebase.perf.v1.TraceMetric> getSubtracesList();

    @Override // com.google.protobuf.u0
    public abstract boolean hasClientStartTimeUs();

    @Override // com.google.protobuf.u0
    public abstract boolean hasDurationUs();

    @Override // com.google.protobuf.u0
    public abstract boolean hasIsAuto();

    @Override // com.google.protobuf.u0
    public abstract boolean hasName();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
