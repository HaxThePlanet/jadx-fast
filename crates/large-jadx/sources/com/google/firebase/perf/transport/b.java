package com.google.firebase.perf.transport;

import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetric;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    public final com.google.firebase.perf.transport.TransportManager a;
    public final GaugeMetric b;
    public final ApplicationProcessState c;
    public b(com.google.firebase.perf.transport.TransportManager transportManager, GaugeMetric gaugeMetric2, ApplicationProcessState applicationProcessState3) {
        super();
        this.a = transportManager;
        this.b = gaugeMetric2;
        this.c = applicationProcessState3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.i(this.b, this.c);
    }
}
