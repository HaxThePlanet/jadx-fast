package com.google.firebase.perf.session.gauges;

import com.google.firebase.perf.v1.ApplicationProcessState;

/* loaded from: classes2.dex */
public final class d implements Runnable {

    public final com.google.firebase.perf.session.gauges.GaugeManager a;
    public final String b;
    public final ApplicationProcessState c;
    public d(com.google.firebase.perf.session.gauges.GaugeManager gaugeManager, String string2, ApplicationProcessState applicationProcessState3) {
        super();
        this.a = gaugeManager;
        this.b = string2;
        this.c = applicationProcessState3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d(this.b, this.c);
    }
}
