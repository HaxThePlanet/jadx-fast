package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

/* loaded from: classes.dex */
public final class c implements Runnable {

    public final com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService a;
    public final JobParameters b;
    public c(com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters2) {
        super();
        this.a = jobInfoSchedulerService;
        this.b = jobParameters2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
