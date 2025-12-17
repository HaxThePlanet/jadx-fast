package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* loaded from: classes.dex */
public final class m implements Runnable {

    public final com.google.android.datatransport.runtime.scheduling.jobscheduling.v a;
    public m(com.google.android.datatransport.runtime.scheduling.jobscheduling.v v) {
        super();
        this.a = v;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.e();
    }
}
