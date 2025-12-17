package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.util.Base64;
import f.c.a.b.i.c0.a;
import f.c.a.b.i.p;
import f.c.a.b.i.p.a;
import f.c.a.b.i.t;

/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {
    private void a(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    @Override // android.app.job.JobService
    public void b(JobParameters jobParameters) {
        a(jobParameters);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        f.c.a.b.d decode;
        String string2 = jobParameters.getExtras().getString("extras");
        t.f(getApplicationContext());
        p.a aVar = p.a();
        aVar.b(jobParameters.getExtras().getString("backendName"));
        aVar.d(a.b(jobParameters.getExtras().getInt("priority")));
        if (string2 != null) {
            aVar.c(Base64.decode(string2, 0));
        }
        c cVar = new c(this, jobParameters);
        t.c().e().s(aVar.a(), jobParameters.getExtras().getInt("attemptNumber"), cVar);
        return 1;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return 1;
    }
}
