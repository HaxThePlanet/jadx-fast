package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import f.c.a.b.i.p;

/* loaded from: classes.dex */
public final class e implements Runnable {

    public final com.google.android.datatransport.runtime.scheduling.jobscheduling.t a;
    public final p b;
    public final int c;
    public final Runnable v;
    public e(com.google.android.datatransport.runtime.scheduling.jobscheduling.t t, p p2, int i3, Runnable runnable4) {
        super();
        this.a = t;
        this.b = p2;
        this.c = i3;
        this.v = runnable4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.q(this.b, this.c, this.v);
    }
}
