package com.google.firebase.perf.session.gauges;

import com.google.firebase.perf.util.Timer;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    public final com.google.firebase.perf.session.gauges.CpuGaugeCollector a;
    public final Timer b;
    public b(com.google.firebase.perf.session.gauges.CpuGaugeCollector cpuGaugeCollector, Timer timer2) {
        super();
        this.a = cpuGaugeCollector;
        this.b = timer2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d(this.b);
    }
}
