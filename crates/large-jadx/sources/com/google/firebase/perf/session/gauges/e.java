package com.google.firebase.perf.session.gauges;

import com.google.firebase.perf.util.Timer;

/* loaded from: classes2.dex */
public final class e implements Runnable {

    public final com.google.firebase.perf.session.gauges.MemoryGaugeCollector a;
    public final Timer b;
    public e(com.google.firebase.perf.session.gauges.MemoryGaugeCollector memoryGaugeCollector, Timer timer2) {
        super();
        this.a = memoryGaugeCollector;
        this.b = timer2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d(this.b);
    }
}
