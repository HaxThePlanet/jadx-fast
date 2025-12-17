package com.google.firebase.perf.transport;

import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.PerfMetric.Builder;

/* loaded from: classes2.dex */
final class PendingPerfEvent {

    protected final ApplicationProcessState appState;
    protected final PerfMetric.Builder perfMetricBuilder;
    public PendingPerfEvent(PerfMetric.Builder perfMetric$Builder, ApplicationProcessState applicationProcessState2) {
        super();
        this.perfMetricBuilder = builder;
        this.appState = applicationProcessState2;
    }
}
