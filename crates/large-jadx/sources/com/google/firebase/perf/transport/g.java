package com.google.firebase.perf.transport;

import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;

/* loaded from: classes2.dex */
public final class g implements Runnable {

    public final com.google.firebase.perf.transport.TransportManager a;
    public final TraceMetric b;
    public final ApplicationProcessState c;
    public g(com.google.firebase.perf.transport.TransportManager transportManager, TraceMetric traceMetric2, ApplicationProcessState applicationProcessState3) {
        super();
        this.a = transportManager;
        this.b = traceMetric2;
        this.c = applicationProcessState3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.e(this.b, this.c);
    }
}
