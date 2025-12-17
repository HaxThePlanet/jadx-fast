package com.google.firebase.perf.transport;

import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.NetworkRequestMetric;

/* loaded from: classes2.dex */
public final class f implements Runnable {

    public final com.google.firebase.perf.transport.TransportManager a;
    public final NetworkRequestMetric b;
    public final ApplicationProcessState c;
    public f(com.google.firebase.perf.transport.TransportManager transportManager, NetworkRequestMetric networkRequestMetric2, ApplicationProcessState applicationProcessState3) {
        super();
        this.a = transportManager;
        this.b = networkRequestMetric2;
        this.c = applicationProcessState3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.g(this.b, this.c);
    }
}
