package com.google.firebase.perf.metrics;

import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.perf.v1.TraceMetric.Builder;
import com.google.protobuf.z.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
class TraceMetricBuilder {

    private final com.google.firebase.perf.metrics.Trace trace;
    TraceMetricBuilder(com.google.firebase.perf.metrics.Trace trace) {
        super();
        this.trace = trace;
    }

    TraceMetric build() {
        Object subtraces;
        com.google.firebase.perf.v1.PerfSession[] andSort;
        Timer endTime;
        boolean empty;
        String traceMetricBuilder;
        long count;
        endTime = this.trace.getEndTime();
        TraceMetric.Builder durationUs = TraceMetric.newBuilder().setName(this.trace.getName()).setClientStartTimeUs(this.trace.getStartTime().getMicros()).setDurationUs(this.trace.getStartTime().getDurationMicros(endTime));
        Iterator iterator = this.trace.getCounters().values().iterator();
        for (Counter endTime : iterator) {
            durationUs.putCounters(endTime.getName(), endTime.getCount());
        }
        subtraces = this.trace.getSubtraces();
        if (!subtraces.isEmpty()) {
            subtraces = subtraces.iterator();
            for (Trace next2 : subtraces) {
                traceMetricBuilder = new TraceMetricBuilder(next2);
                durationUs.addSubtraces(traceMetricBuilder.build());
            }
        }
        durationUs.putAllCustomAttributes(this.trace.getAttributes());
        andSort = PerfSession.buildAndSort(this.trace.getSessions());
        if (andSort != null) {
            durationUs.addAllPerfSessions(Arrays.asList(andSort));
        }
        return (TraceMetric)durationUs.build();
    }
}
